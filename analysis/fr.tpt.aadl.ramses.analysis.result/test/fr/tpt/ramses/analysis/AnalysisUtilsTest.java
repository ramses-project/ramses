package fr.tpt.ramses.analysis;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import fr.tpt.aadl.ramses.analysis.util.AnalysisUtils;

public class AnalysisUtilsTest {

	@Test
	public void testCreateAnalysisArtifact(){
		
		String analysisPath = "test.artifacts/analysis_v1.0.xml";
		
		AnalysisUtils.createNewAnalysisArtifact(analysisPath);
		
		assertTrue(new File(analysisPath).exists());
		
	}
	
}
