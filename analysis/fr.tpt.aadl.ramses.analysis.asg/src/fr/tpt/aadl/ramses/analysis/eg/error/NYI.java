package fr.tpt.aadl.ramses.analysis.eg.error;

public class NYI extends Exception
{
  private static final long serialVersionUID = -4820520313868549709L;
  private final Object o;
  
  public NYI(Object o)
  {
    this.o = o;
  }
  
  public String getMessage()
  {
    return "Not yet supported: " + o.getClass().getSimpleName();
  }
}