package fr.tpt.aadl.sched.wcetanalysis.extractors;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.sched.wcetanalysis.WcetAnalysisDebug;
import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.extractors.ba.SubprogramBehaviorAnnexExtractor;
import fr.tpt.aadl.sched.wcetanalysis.extractors.seq.SubprogramCallSequenceExtractor;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTExtractor;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.util.BehaviorAnnexUtil;

public class SubprogramExtractor extends ASTExtractor
{

	private final SubprogramBehaviorAnnexExtractor spgAA;
	private final SubprogramCallSequenceExtractor spgSA;

	public SubprogramExtractor(ExtractionContext ctxt)
	{
		super(ctxt, ctxt.errManager);
		spgAA = new SubprogramBehaviorAnnexExtractor(ctxt);
		spgSA = new SubprogramCallSequenceExtractor(ctxt);
	}

	public ASTNode caseThreadInstance(ComponentInstance spg, ASTNode lastAction)
	{
		BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg);
		ASTNode ast = null;
		
		WcetAnalysisDebug.println("Extracting AST of " + spg.getName() 
				+ " thread instance from its "
				+ (ba==null ? "CALL SEQUENCE/NONE" : "BEHAVIOR ANNEX"));

		ctxt.pushVisitingElement(spg);

		if (ba != null)
		{
			ast = spgAA.extractFrom(spg.getComponentClassifier(), lastAction);
		}
		else
		{
			ast = spgSA.extractFrom(spg, lastAction);
		}

		ctxt.popVisitedElement();

		return ast;
	}
	
	public ASTNode caseSubprogramClassifier(Classifier spg, ASTNode lastAction)
	{
		BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg);
		ASTNode ast = null;
		
		WcetAnalysisDebug.println("[SubprogramCall]Extracting AST of " 
				+ spg.getName() + " subprogram classifier from its "
				+ (ba==null ? "CALL SEQUENCE/NONE" : "BEHAVIOR ANNEX"));

		ctxt.pushVisitingElement(spg);
		
		if (ba != null)
		{
			ast = spgAA.extractFrom(spg, lastAction);
		}
		else
		{
			ast = spgSA.extractFrom(spg, lastAction);
		}
		
		ctxt.popVisitedElement();
		
		return ast;
	}

	public ASTNode caseSubprogramCall(SubprogramCall call, ASTNode lastAction)
	{
		Classifier spg = (SubprogramClassifier) call.getCalledSubprogram();
		BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg);
		ASTNode ast = null;
		
		WcetAnalysisDebug.println("[SubprogramCall]Extracting AST of " 
				+ spg.getName() + " subprogram call from its "
				+ (ba==null ? "CALL SEQUENCE/NONE" : "BEHAVIOR ANNEX"));

		ctxt.pushVisitingElement(call);
		
		if (ba != null)
		{
			ast = spgAA.extractFrom(spg, lastAction);
		}
		else
		{
			ast = spgSA.extractFrom(spg, lastAction);
		}
		
		ctxt.popVisitedElement();
		
		return ast;
	}
}
