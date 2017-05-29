package org;
public class ActionError
{
	private String errorDesc  ;
	private String errorLine  ;
	private String errorBox   ;
	public ActionError ( java.lang.String errorLine  , java.lang.String errorBox , java.lang.String errorDesc )
	{
		this.errorLine = errorLine ;
		this.errorBox  = errorBox  ;
		this.errorDesc = errorDesc ;
	}
	public java.lang.String getErrorDesc () 
	{
		return this.errorDesc ;
	}
	public void setErrorDesc ( java.lang.String errorDesc )
	{
       this.errorDesc = errorDesc  ;
	}
	public java.lang.String getErrorLine ()
	{
		return this.errorLine ;
	}
	public void setErrorLine ( java.lang.String errorLine )
	{
		this.errorLine = errorLine ;
	}
	public void setErrorBox ( java.lang.String errorBox )
	{
       this.errorBox = errorBox ;
	}
	public java.lang.String getErrorBox ()
	{
		return this.errorBox ;
	}
}
