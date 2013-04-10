package fr.tpt.aadl.sched.wcetanalysis.extractors.seq;

import java.util.List;

import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.Subprogram;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.ramses.util.properties.AadlUtil;
import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.util.Aadl2ASTUtil;
import fr.tpt.aadl.sched.wcetanalysis.util.IDGenerator;

public class SubprogramCallSequenceExtractor extends CallSequenceExtractor
{
	public SubprogramCallSequenceExtractor(ExtractionContext ctxt)
	{
		super(ctxt, ctxt.errManager);
	}

	public ASTNode extractFrom(ComponentInstance spg, ASTNode lastAction)
	{
		Subcomponent sub = spg.getSubcomponent();
		ComponentClassifier cl = sub.getClassifier();
		if (cl instanceof BehavioredImplementation)
		{
			return extractFrom((BehavioredImplementation) cl, lastAction);
		}
		else
		{
			throw new RuntimeException(
					"SubprogramCallSequenceExtractor: not supported classifier ("
							+cl.getClass().getSimpleName()+")");
		}
	}
	
	public ASTNode extractFrom(SubprogramCall call, ASTNode lastAction)
	{
		SubprogramClassifier spg = (SubprogramClassifier) call.getCalledSubprogram();
		return extractFrom(spg, lastAction);
	}

	public ASTNode extractFrom(Classifier spg, ASTNode lastAction)
	{
		ASTNode ret = null;

		if (spg != null)
		{
			if (spg.getOwnedElements() != null
					&& spg.getOwnedElements().size() > 0)
			{
				ret = extractSequence(spg, lastAction);
			}

			if ((ret == lastAction) || (ret == null))
			{
				ASTNode compute = createComputeAction(spg, lastAction);
				lastAction.addNext(compute);
				lastAction = compute;
				ret = lastAction;
			}
		}

		return ret;
	}

	private ASTNode createComputeAction(Classifier spg, ASTNode lastAction)
	{
		StatementKind type = getSubprogramActionType(spg);
		ASTNode compute = new ASTNode(
				IDGenerator.getNewIdForName(spg.getName()), type,
				lastAction.getElement());
		compute.setMinExecutionTime(AadlUtil.getInfoMinDuration(spg));
		compute.setMaxExecutionTime(AadlUtil.getInfoMaxDuration(spg));
		return compute;
	}

	private ASTNode extractSequence(Classifier spg, ASTNode lastAction)
	{
		if (!(spg instanceof BehavioredImplementation))
		{
			return lastAction;
		}
		
		final BehavioredImplementation bi = (BehavioredImplementation) spg;
		final List<SubprogramCallSequence> seqs = bi.getOwnedSubprogramCallSequences();
		
		if (seqs==null || seqs.isEmpty())
		{
			return lastAction;
		}
		
		final SubprogramCallSequence seq = seqs.get(0);
		final List<Connection> conns = bi.getAllConnections();
		
		for (CallSpecification eCall : seq.getOwnedCallSpecifications())
		{
			if (eCall instanceof SubprogramCall)
			{
				SubprogramCall call = (SubprogramCall) eCall;
				Subprogram called = (Subprogram) call.getCalledSubprogram();
				SubprogramClassifier cl = null;

				if (called instanceof SubprogramClassifier)
				{
					cl = (SubprogramClassifier) called;
				}
				else
				{
					cl = (SubprogramClassifier) ((SubprogramSubcomponent) called)
							.getClassifier();
				}

				lastAction = ctxt.subprogramExtractor.caseSubprogramCall(
						call, lastAction);
				final float assignTime = computeParametersAssignmentTime(
						call, conns);
				
				lastAction.addExecutionTime(assignTime);
				
			}
		}

		return lastAction;
	}
	
	private static boolean needsCopy(Connection c)
	{
		return ! (c instanceof AccessConnection);
	}
	
	/*
	private static boolean isInFeature(ConnectionEnd ce)
	{
		if (ce instanceof DirectedFeature)
		{
			return ((DirectedFeature) ce).getDirection()
					== DirectionType.IN;
		}
		else
		{
			return false;
		}
	}*/
	
	private DataClassifier getConnectionEndClassifier(ConnectionEnd ce)
	{
		if (ce instanceof Parameter)
		{
			Parameter p = (Parameter) ce;
			//return Aadl2ASTUtil.getDataClassifier(p.getDataFeatureClassifier());
			return null;
		}
		else
		{
			return null;
		}
	}
	
	private static float computeParametersAssignmentTime(
			SubprogramCall call, List<Connection> allConnections)
	{
		final SubprogramClassifier spgC = (SubprogramClassifier)
				call.getCalledSubprogram();
		
		float assignTime = 0f;
		
		for(Connection c : allConnections)
		{
			/** Filter only connections from the current subprogram call */
			final ConnectedElement cSrc = (ConnectedElement) c.getSource();
			if (cSrc.getContext() != spgC)
			{
				continue;
			}
		
			/** The connection cost represents the time needed
			 *  to copy features from the source subprogram
			 *  to the destination subprogram.
			 * 
			 *  - All kinds of connections need copy excepts access connections.
			 *  
			 *  - Copy time is ignored if the source subprogram has behavior
			 *    (in that case, copy time is computed from its behavior annex/sequence)  
			 */
			if (!needsCopy(c) || Aadl2ASTUtil.hasBehavior(spgC))
			{
				continue;
			}
			
			final ConnectionEnd ce = cSrc.getConnectionEnd();
			
		}
		
		return assignTime;
	}

	private static StatementKind getSubprogramActionType(NamedElement e)
	{
		if (e.getName().equals("Get_Resource"))
		{
			return StatementKind.GetResource;
		}
		else if (e.getName().equals("Release_Resource"))
		{
			return StatementKind.ReleaseResource;
		}
		else
		{
			return StatementKind.Compute;
		}
	}
}
