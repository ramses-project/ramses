/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.sched.cheddar ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.jdom.Document ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.flow.model.ExecutionGraphRegistry ;
import fr.tpt.aadl.sched.cheddar.model.CheddarElement ;
import fr.tpt.aadl.sched.cheddar.model.CheddarModel ;
import fr.tpt.aadl.sched.cheddar.strategies.CheddarModelConversionPart ;

public class AADL2Cheddar
{

  /** Strategy to extract Cheddar model from an AADL model. */
  private CheddarContext strategy ;

  private final SystemInstance root ;

  private final ExecutionGraphRegistry registry ;

  private File outputDir = null ;

  private Document cheddarXML = null ;

  /** Tool which export Cheddar model in XML file. */
  private Cheddar2XML modelToXML = new Cheddar2XML() ;

  private CheddarModel cheddarModel = null ;
  private List<CheddarElement> cheddarElements = null ;

  private final String prefix ;

  private final float scaling ;

  //FIXME: remove registry, execution graph analysis must be isolated from Cheddar

  public AADL2Cheddar(String prefix, SystemInstance root, File outputDir,
                      AnalysisErrorReporterManager errManager, float scaling)
  {
    this.outputDir = outputDir ;
    this.root = root ;
    this.prefix = prefix ;
    this.scaling = scaling ;
    this.strategy = CheddarContext.getContextFor(root) ;
    this.registry = new ExecutionGraphRegistry(root, errManager) ;
    this.strategy.setExecutionRegistry(this.registry) ;
  }

  /*
  public void addSupport()
  {
    registry.addGraphVisitor(new ExecutionGraphPrinter());
    registry.addGraphVisitor(new Automaton2DOT("/home/fabien/tmp/cheddar/"));
  }*/

  public void createCheddarModel()
  {
    CheddarModelConversionPart.init() ;

    /** Step 1 : Extract Cheddar Model from AADL Model. */
    cheddarElements = new ArrayList<CheddarElement>() ;
    strategy.getExtractionSection(ComponentCategory.PROCESSOR)
          .export(root, cheddarElements) ;
    strategy.getExtractionSection(ComponentCategory.PROCESS)
          .export(root, cheddarElements) ;
    cheddarModel = new CheddarModel(cheddarElements, strategy, root) ;
    cheddarModel.setScaling(scaling) ;
  }

  public void exportCheddarModel()
  {
    if(cheddarElements == null)
    {
      createCheddarModel() ;
    }

    /** Step 2 : Export Cheddar Model in XML File. */
    cheddarXML = modelToXML.generateXML(cheddarModel, outputDir) ;
    //XMLUtil.printXML(cheddarXML);
    /** Step 3 : Notify observers. */
    //strategy.getExecutionRegistry().notifyVisitors();
  }

  public File getCheddarXMLPath()
  {
    return outputDir ;
  }

  public Document getCheddarXML()
  {
    if(cheddarXML == null)
    {
      exportCheddarModel() ;
    }

    return cheddarXML ;
  }

  public CheddarModel getCheddarModel()
  {
    if(cheddarModel == null)
    {
      exportCheddarModel() ;
    }

    return cheddarModel ;
  }
}