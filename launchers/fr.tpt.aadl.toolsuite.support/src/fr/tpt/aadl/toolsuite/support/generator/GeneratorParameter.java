package fr.tpt.aadl.toolsuite.support.generator ;

public enum GeneratorParameter
{
  GENERATION_PATH("generated files path") ;

  public String literal ;

  private GeneratorParameter(
                             String literal)
  {
    this.literal = literal ;
  }
}
