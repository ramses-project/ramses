/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.control.support.reporters ;

import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.modelsupport.errorreporting.AbstractAnalysisErrorReporter ;

public class StandAloneAnalysisErrorReporter extends
                                            AbstractAnalysisErrorReporter
{
  private MessageReporter _reporter ;
  private final static String STAGE = "Analysis" ;

  public StandAloneAnalysisErrorReporter(Resource rsrc, MessageReporter reporter)
  {
    super(rsrc) ;
    _reporter = reporter ;
  }

  @Override
  protected void errorImpl(Element where,
                           String message,
                           String[] attrs,
                           Object[] values)
  {
    MessageStatus ms = MessageStatus.AADL_ERROR ;
    ms._stage = STAGE ;
    message = ms.toString() + " " + message ;
    _reporter.reportMessage(ms, where, message) ;
  }

  @Override
  protected void warningImpl(Element where,
                             String message,
                             String[] attrs,
                             Object[] values)
  {
    MessageStatus ms = MessageStatus.AADL_WARNING ;
    ms._stage = STAGE ;
    message = ms.toString() + " " + message ;
    _reporter.reportMessage(ms, where, message) ;
  }

  @Override
  protected void infoImpl(Element where,
                          String message,
                          String[] attrs,
                          Object[] values)
  {
    MessageStatus ms = MessageStatus.AADL_INFO ;
    ms._stage = STAGE ;
    message = ms.toString() + " " + message ;
    _reporter.reportMessage(ms, where, message) ;
  }

  @Override
  protected void deleteMessagesImpl()
  {
    // Nothing to do.
  }
}