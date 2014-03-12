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

import org.osate.aadl2.modelsupport.errorreporting.AbstractParseErrorReporter ;

public class StandAloneParseErrorReporter extends AbstractParseErrorReporter
{
  private MessageReporter _reporter ;
  private final static String STAGE = "parser" ;

  public StandAloneParseErrorReporter(
                                      MessageReporter reporter)
  {
    _reporter = reporter ;
  }

  @Override
  protected void deleteMessagesImpl()
  {
    // Nothing to do.
  }

  @Override
  protected void errorImpl(String filename,
                           int line,
                           String message)
  {
    MessageStatus ms = MessageStatus.ERROR ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, filename, line, message) ;
  }

  @Override
  protected void warningImpl(String filename,
                             int line,
                             String message)
  {
    MessageStatus ms = MessageStatus.WARNING ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, filename, line, message) ;
  }

  @Override
  protected void infoImpl(String filename,
                          int line,
                          String message)
  {
    MessageStatus ms = MessageStatus.INFO ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, filename, line, message) ;
  }
}