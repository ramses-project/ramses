package fr.tpt.aadl.toolsuite.support.reporters ;

public enum MessageStatus
{
  ERROR("error"), INTERNAL_ERROR("internal error"), WARNING("warning"), INFO(
        "info") ;

  public final String _literal ;
  public String _stage ;

  private MessageStatus(
                        String literal)
  {
    this._literal = literal ;
  }

  public String toString()
  {
    if(this._stage != null && (!this._stage.isEmpty()))
    {
      return this._stage + " " + this._literal ;
    }
    else
    {
      return this._literal ;
    }
  }
}
