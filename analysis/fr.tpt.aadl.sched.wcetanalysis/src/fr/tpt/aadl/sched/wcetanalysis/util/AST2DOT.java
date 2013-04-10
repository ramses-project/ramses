package fr.tpt.aadl.sched.wcetanalysis.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.osate.aadl2.NamedElement;

import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBodyVisitor;

public class AST2DOT implements TaskBodyVisitor
{
	public enum DOTLayout {dot,neato,twopi,fdp,sfdp};
	
	
	public static final boolean DELETE_DOT_FILES = true;

	private String outputDir;

	private boolean exportInit = false;

	private HashMap<String, String> actionToResource = new HashMap<String, String>();
	private final DOTLayout layout;
	
	public AST2DOT(String outputDir, DOTLayout layout)
	{
		this.outputDir = outputDir;
		this.layout = layout;

		if (!outputDir.endsWith("/"))
		{
			outputDir += "/";
		}
		initDirectory(new File(outputDir));
	}
	
	public AST2DOT(String outputDir)
	{
		this(outputDir, DOTLayout.dot);
	}
	
	public AST2DOT(File outputDir, DOTLayout layout)
	{
		this.layout = layout;
		initDirectory(outputDir);
	}
	
	public AST2DOT(File outputDir)
	{
		this(outputDir, DOTLayout.dot);
	}
	
	private void initDirectory(File f)
	{
		if (!f.exists())
		{
			f.mkdir();
		}
	}

	public void visit(TaskBody a)
	{
		int priority = a.getPriority();
		final ASTNode INIT_AST = a.getInitAST();
		final ASTNode MAIN_AST = a.getMainLoopAST();
		final ASTNode MAIN_REDUCED_AST = a.getReducedMainLoopAST();

		final String PROCESS_NAME = ((NamedElement) (a.getTask().eContainer())).getName();
		final String TASK_NAME = PROCESS_NAME + "." + a.getTask().getName();
		
		
		final String INIT_AST_PATH = outputDir + TASK_NAME
				+ "_init.dot";
		final String MAIN_AST_PATH = outputDir + TASK_NAME + "_ast.dot";
		final String MAIN_REDUCED_AST_PATH = outputDir + TASK_NAME + "_ast_reduced.dot";

		try
		{
			if (exportInit)
			{
				saveFlowModelAsPng(INIT_AST, INIT_AST_PATH, priority);
			}

			saveFlowModelAsPng(MAIN_AST, MAIN_AST_PATH, priority);
			saveFlowModelAsPng(MAIN_REDUCED_AST, MAIN_REDUCED_AST_PATH, priority);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void saveFlowModelAsPng(ASTNode flow, String outputPath, int priority)
			throws Exception
	{
		File f;
		BufferedWriter writer;
		String title;
		String content;
		List<String> actionNames;
		List<String> transitionNames;
		f = new File(outputPath);

		if (!f.exists())
		{
			f.createNewFile();
		}

		writer = new BufferedWriter(new FileWriter(outputPath));
		actionNames = new ArrayList<String>();
		transitionNames = new ArrayList<String>();
		title = flow.getElement().getName() + " [Priority : " + priority + "]";
		collectActionNames(flow, actionNames);
		collectTransitionNames(flow, transitionNames, new ArrayList<ASTNode>());
		content = getGlobalContent(title, actionNames, transitionNames);
		writer.write(content);
		writer.close();
		String outputImage = outputPath.replace(".dot", ".png");
		String cmd = layout.name() + " " + outputPath + " -Tpng -o " + outputImage;
		// System.out.println(cmd);
		Process cmdP = Runtime.getRuntime().exec(cmd);
		cmdP.waitFor();

		if (DELETE_DOT_FILES)
		{
			f.delete();
		}
	}

	private String getGlobalContent(String title, List<String> actionNames,
			List<String> transitionNames)
	{
		String s = "digraph TaskFlow {\n\tlabel = \"" + title + "\";\n\n";

		for (int index = 0; index < actionNames.size(); index++)
		{
			String actionName = actionNames.get(index);
			String actionLabel = actionName;

			if (smoothLabel(actionName).equals("Get_Resource")
					|| smoothLabel(actionName).equals("Release_Resource"))
			{
				actionName += " [color=red]";
			}
			else if (index == 0)
			{
				actionName += " [shape=Mdiamond]";
			}

			s += "\n\t" + smoothName(actionName) + " [label=\""
					+ smoothLabel(actionLabel) + "\"];";
		}

		s += "\n\n";

		for (String transitionName : transitionNames)
		{
			s += "\n\t" + transitionName + ";";
		}

		return s + "\n}";
	}

	private static String smoothName(String name)
	{
		String newname = name;

		while (newname.contains("-"))
		{
			newname = newname.replace("-", "_");
		}

		return newname;
	}

	private String smoothLabel(String name)
	{
		String newname = name;

		while (newname.contains("-"))
		{
			newname = newname.replace("-", "_");
		}

		int index = newname.lastIndexOf("__");

		if (index != -1)
		{
			newname = newname.substring(0, index);
		}

		String resourceID = actionToResource.get(name);

		if (resourceID != null)
		{
			newname += " (" + resourceID + ")";
		}

		return newname;
	}

	private void collectActionNames(ASTNode flow, List<String> names)
	{
		names.add(flow.getName());

		if (flow.getResourceID() != null)
		{
			if (flow.getType() == StatementKind.GetResource)
			{
				actionToResource.put("GetResource", flow.getResourceID());
			}
			else if (flow.getType() == StatementKind.ReleaseResource)
			{
				actionToResource.put("ReleaseResource", flow.getResourceID());
			}
			else
			{
				actionToResource.put(flow.getName(), flow.getResourceID());
			}
		}

		for (ASTNode next : flow.getNext())
		{
			if (!names.contains(next.getName()))
			{
				collectActionNames(next, names);
			}
		}
	}

	private static void collectTransitionNames(ASTNode flow,
			List<String> transitions, List<ASTNode> visited)
	{
		if (!visited.contains(flow))
		{
			visited.add(flow);

			for (ASTNode next : flow.getNext())
			{
				float min = flow.getMinExecutionTime();
				float max = flow.getMaxExecutionTime();
				String name = smoothName(flow.getName())
						+ " -> "
						+ smoothName(next.getName() + "[label=\"[" + min + ","
								+ max + "]\"]");
				transitions.add(name);
				collectTransitionNames(next, transitions, visited);
			}
		}
	}

}
