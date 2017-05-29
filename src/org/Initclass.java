package org;

public class Initclass
{
	java.util.Properties dbproperties = null ;

	public  String initurl(String p_path,org.Global_Data Global_Data)
	{
		String l_ers="";
		try
		{
			dbproperties = new java.util.Properties () ;
			dbproperties.load ( new java.io.FileInputStream (p_path )  ) ;
			Global_Data.setServicename_orcl(dbproperties.getProperty("servicename").trim());			//service name Ereturns
			Global_Data.setIpaddress_orcl(dbproperties.getProperty("ipaddress").trim());               		//Ip address Ereturns
			Global_Data.setUsername_orcl(dbproperties.getProperty("username").trim());          		//setting user name Ereturns
			Global_Data.setPassword_orcl(dbproperties.getProperty("password").trim());          		//Password Ereturns

		
			Global_Data.setURL_orcl("jdbc:oracle:thin:@"+Global_Data.getIpaddress_orcl().trim()+":1521:"+	Global_Data.getServicename_orcl().trim());
			Global_Data.setImageDirectory(dbproperties.getProperty("ImageDirectory").trim());

		}
		catch ( java.lang.Exception e )
		{
			l_ers="Check the Properties file : " +e.getMessage();
		}
		return l_ers;
	}
	public  java.sql.Connection oraConnection(org.Global_Data Global_Data,ActionErrors errors  ) //throws java.lang.Exception
	{
		java.sql.Connection con=null;
		try
		{
			java.sql.DriverManager.registerDriver ( new oracle.jdbc.driver.OracleDriver () ) ;
			
			con= java.sql.DriverManager.getConnection(Global_Data.getURL_orcl(),Global_Data.getUsername_orcl(),Global_Data.getPassword_orcl());
			
			
		}
		catch ( java.lang.Exception e )
		{
			errors.addError(new ActionError
					("","APP Level 0","Oracle Connection Error "+e.getMessage() ));
		}
		return con;
	}

	

}
