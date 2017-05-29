package org;
import org.apache.commons.validator.GenericValidator;
import java.text.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
//import java.text.DecimalFormat;

public  class krrvalidation {
	Date_fun Date_fun=new  Date_fun();
	public  String Checknullreturn(String p_string)
	{

		if (isValue(p_string))
			return "'"+RemoveChar(p_string.trim(),'\'')+"'";
		else
			return "null";
	}
	public  String Checkandreturnnull(String p_string)
	{
		if ( ( p_string == null || p_string.trim().equals("") ) ) return "";
		return p_string;
	}

	public org.ActionError isValidNumber ( java.lang.String value , java.lang.String linNo , java.lang.String boxNo  , java.lang.String errorDesc )
	{
		if( !org.apache.commons.validator.GenericValidator.isBlankOrNull(value) )
		{
			if (!org.apache.commons.validator.GenericValidator.isDouble(value))
			{
				return new org.ActionError ( linNo , boxNo , errorDesc )  ;
			}
			else
				return null ;
		}
		return null ;
	}
	
	public String AppendPercentileBothEndsUpper(String p_string){
		p_string = p_string.toUpperCase();
		if(p_string ==""){
	 		p_string = "'%'";
	 	}
		else{
			p_string = "'%"+p_string+"%'";
		}
		return p_string;
	}
	public String AppendPercentileBothEnds(String p_string){
		if(p_string ==""){
	 		p_string = "'%";
	 	}
		else{
			p_string = "'%"+p_string+"%'";
		}
		return p_string;
	}

	public  double DConvertNum(String p_string)
	{
		double l_dnum;
		if (org.apache.commons.validator.GenericValidator.isDouble(p_string))
		{
			l_dnum=(Double.parseDouble(p_string));
		}
		else
			l_dnum=0.0;
		return l_dnum;
	}
	public  String DConvertNum_big(String p_string)
	{
		String l_dnum="0";
		if (isValue(p_string))l_dnum=p_string;
		return l_dnum;
	}
	public    int GetSuboptioncode(String P_string)
	{
		if (P_string.equalsIgnoreCase("Add")) return 1;
		if (P_string.equalsIgnoreCase("Edit")) return 2;
		if (P_string.equalsIgnoreCase("None")) return 3;
		if (P_string.equalsIgnoreCase("Save")) return 4;
		if (P_string.equalsIgnoreCase("Delete")) return 5;
		if (P_string.equalsIgnoreCase("Exit")) return 6;
		if (P_string.equalsIgnoreCase("Subexit")) return 7;

		return 0;
	}

	public  long ConvertNum(String p_string)
	{
		long l_dnum;
		double ld_dnum;
		l_dnum=0;

		if (org.apache.commons.validator.GenericValidator.isLong(p_string))
		{
			l_dnum=(Long.parseLong(p_string));
		}
		else
			if (org.apache.commons.validator.GenericValidator.isDouble(p_string))
			{
				ld_dnum=(Double.parseDouble(p_string));
				l_dnum=(long)ld_dnum;
			}
		return l_dnum;
	}
	public  boolean Check_email(String p_email)
	{
		if( org.apache.commons.validator.GenericValidator.isEmail(p_email ))
			return true ;
		else
			return false;

	}
	public  boolean Check_email1(String p_email)
	{
		if ( isValue ( p_email ) )
			if ( p_email.indexOf ( "@" ) == -1 )
				return false;
		return true ;
	}
	public  double GettaxRate(String p_string)
	{
		String l_string;
		l_string=p_string.substring(0,p_string.trim().length()-1);
		double l_dnum;
		if (org.apache.commons.validator.GenericValidator.isDouble(l_string))
		{
			l_dnum=(Double.parseDouble(l_string));
		}
		else
			l_dnum=0.0;
		return l_dnum;
	}
	//date wind 0-29  2000+year
	//30-99 1900+year
	public  String  DateYYMMDD_YYYYMMDD(String p_string)
	{
		if (isValuenull(p_string))  					  return "";
		if(!(p_string.length()==6))                       return "";
		if (ConvertNum(p_string.substring(0, 2))<30)	  return "20"+p_string;
		return "19"+p_string;
	}
	public  String  DateDDMMYYYY_YYYYMMDD(String p_string)
	{
		String l_ers="";
		if (p_string.length()==8) 
		{
			l_ers=p_string.substring(5, 8)+p_string.substring(2, 4)+p_string.substring(0, 2);
			Date tempdate=ConvertYYYYMMDDTODate(l_ers);
			if (tempdate==null)l_ers="";
		}
		return l_ers;
	}
	public  double ABSValue(double p_pvalue)
	{
		if (p_pvalue> 0)
			return p_pvalue;
		return (-p_pvalue);
	}

	public  String  DateToYYYYMMDD_fromddslash(String p_string)
	{
		String ldt=null;
		if (isValuenull(p_string))
			return null;
//		System.out.println("print Sldate "+p_string  );
		if (DConvertNum(p_string.substring(6, 8))<30)
			ldt="20"+p_string.substring(6, 8)+p_string.substring(3, 5)+p_string.substring(0, 2);
		else
			ldt="19"+p_string.substring(6, 8)+p_string.substring(3, 5)+p_string.substring(0, 2);

		return ldt;
	}
	public  String  DateToYYMMDD_fromddslash(String p_string)
	{
		String ldt=null;
		if (isValuenull(p_string))
			return null;
//		System.out.println("print Sldate "+p_string  );
		ldt=p_string.substring(6, 8)+p_string.substring(3, 5)+p_string.substring(0, 2);

		return ldt;
	}
//	public  boolean isLastDayOfMonth ( java.util.Date date )
//	{
//	java.util.Calendar  calender = java.util.Calendar . getInstance () ;
//	calender . set ( date.getYear () , date.getMonth() , date.getDate() ) ;
//	if ( date.getDate() == calender.getActualMaximum( java.util.Calendar.DAY_OF_MONTH ) )
//	return true ;
//	else
//	return false ;
//	}

	public  java.util.Date ConvertYYMMDDTODate(String p_string)
	{
		java.util.Date dt = new java.util.Date () ;
		DateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		try
		{
			dt=dateFormat.parse(p_string);
		}
		catch(Exception e)
		{
			dt=null;
		}
		finally
		{
			return dt;
		}
	}
	

	public  String Datecheck(String p_dtstring,String p_dtpattern)
	{
		String error;
		error=null;
		String pdate=null ;
		String lcurdt=curdateyymmdd();
		if (org.apache.commons.validator.GenericValidator.isDate(p_dtstring, p_dtpattern, true))
		{
			if (p_dtpattern.equalsIgnoreCase("YYMMDD"))
			{ pdate=p_dtstring; }
			else
				if (p_dtpattern.equalsIgnoreCase("DD/MM/YY"))
				{
					pdate= p_dtstring.substring(6,8) +p_dtstring.substring(3,5)+p_dtstring.substring(0,2);
				}
				else
					error="UnSupported date Format"  ;
//			System.out.println("Date :"+pdate);
			if (error==null)
			{
				if (ConvertNum(pdate)>ConvertNum(lcurdt))
					error=" Future Date Not Allowed";
				else
					if (ConvertNum(pdate)<ConvertNum("050331"))
						error="Be Greater Than 31st March 2005";
			}

		}

		else
			error="Invalid Date --> "+ p_dtstring;		// wrong date date
		return error;
	}
	public  String Datechecknew(String p_dtstring)
	{
		String error;
		error="";
		String pdate=p_dtstring ;
		String lcurdt=curdateyyyymmdd();
		if (org.apache.commons.validator.GenericValidator.isDate(p_dtstring, "yyyyMMdd", true))
		{
//			if (ConvertNum(pdate)>ConvertNum(lcurdt))
//			error=" Future Date Not Allowed";
//			else
//			{
//			if (ConvertNum(pdate)<ConvertNum("20050331"))
//			error="Be Greater Than 31st March 2005";
//			}
			error="";
		}
		else
			error="Invalid Date --> "+ p_dtstring;		// wrong date date
		return error;
	}

	public  String Datecheck_B1(String p_dtstring,String p_dtpattern)
	{
		String error;
		error=null;
		String pdate=null ;
		String lcurdt=curdateyyyymmdd();
		if (org.apache.commons.validator.GenericValidator.isDate(p_dtstring, p_dtpattern, true))
		{
			if (p_dtpattern.equalsIgnoreCase("YYMMDD"))
			{ pdate=DateYYMMDD_YYYYMMDD(p_dtstring); }
			else
				if (p_dtpattern.equalsIgnoreCase("DD/MM/YY"))
				{
//					pdate= p_dtstring.substring(6,8) +p_dtstring.substring(3,5)+p_dtstring.substring(0,2);
					pdate=DateToYYYYMMDD_fromddslash(p_dtstring);
				}
				else
					error="UnSupported date Format"  ;
//			System.out.println("Date :"+pdate);
//			if (error==null)
//			{
//			if (ConvertNum(pdate)>ConvertNum(lcurdt))
//			error=" Future Date Not Allowed";
//			}

		}

		else
			error="Invalid Date --> "+ p_dtstring;		// wrong date date
		return error;
	}
	public  String DiplayDate(String p_dtstring)
	{
		String l_ers="";
		String  lret_string="" ;
		try
		{
			//display date of format yymmdd to dd-mmm-yyyy
			java.util.Date ldate=new java.util.Date() ;
//			System.out.println("Date -- "+p_dtstring);
//			if (isValuenull(p_dtstring))

//			return "--Nil--";
			ldate= ConvertYYMMDDTODate(p_dtstring);
			lret_string=java.text.DateFormat.getDateInstance (java.text.DateFormat.MEDIUM).format(ldate);
			System.out.println("Display date"+lret_string);
		}
		catch(Exception e)
		{
			l_ers="Error on Display date "+e.getMessage();
			System.out.println("l_ers1>>> "+l_ers);
		}
		return lret_string;
	}


	public   String curdateyymmdd()
	{
		int i;
		String curdt=null;
		java.util.Date dt = new java.util.Date () ;
		i=dt.getYear()-100;
		if (i>9) curdt=""+i; else curdt="0"+i;
		i=dt.getMonth()+1;
		if (i>9) curdt=curdt+""+i; else curdt=curdt+"0"+i;
		i=dt.getDate();
		if (i>9) curdt=curdt+""+i; else curdt=curdt+"0"+i;
		return curdt;
	}
	public   String curdateyyyymmdd()
	{
		int i;
		String curdt="";
		java.util.Date dt = new java.util.Date () ;
		i=dt.getYear()+1900;
		if (i>9) curdt=""+i; else curdt="0"+i;
		i=dt.getMonth()+1;
		if (i>9) curdt=curdt+""+i; else curdt=curdt+"0"+i;
		i=dt.getDate();
		if (i>9) curdt=curdt+""+i; else curdt=curdt+"0"+i;
		return curdt;
	}

	public  String CheckTinno(String MVATRCNO)
	{   Double dtinno;
	long SubMVATRCNO;
	String error;
	error=null;
	if(MVATRCNO.length()==11)
	{
		if(MVATRCNO.startsWith("27"))
		{
			dtinno=DConvertNum(MVATRCNO.substring(0,11));
			if (dtinno !=0 )
			{
				SubMVATRCNO=Long.parseLong(MVATRCNO.substring(4,11)+MVATRCNO.substring(0,4));
				if(!(SubMVATRCNO%97==1))
					error="M V A T RC No is Invalid  Number";
			}
			else
			{
				error="M V A T RC No Should be Number";
			}
		}
		else
			error=" M V A T RC No Should Begin With 27 ";
	}
	else
		error="M V A T R C No Should be 11 Digits, Begin With 27";
	return error;
	}




	public  String CheckPan(String panno)
	{  
		String error;
		error="";
		if(panno.length()==10)
		{
			if(isAlphastring(panno.substring(0, 5)))
			{
				if(isAlphanumeric(panno.substring(5, 9)))
				{
					if(!(isAlphabet(panno.charAt(9))))
					{
						error="PAN 10th  Character should be alpha";
					}

				}
				else
					error="PAN 6-9 Characters should be digits";
			}
			else
				error=" PAN First 5 Characters should be alpha chars ";
		}
		else
			error="PAN Should be 10 Characters";
		return error;
	}

	public  int DatediffMonths ( java.util.Date Fdate ,java.util.Date Tdate )
	{
		int lmonths=0;
		lmonths=((Tdate.getYear()*12)+Tdate.getMonth ())-((Fdate.getYear()*12)+Fdate.getMonth ());

		return lmonths ;
	}


	public  String Checkemptyreturn(String p_string)
	{
		if ( !( p_string == null  || p_string.equals("") ) )
			return p_string.trim();
		else
			return "";
	}
	public  String ReturnEmptyvalue(String p_string)
	{
		if ( !( p_string == null) )
			return p_string;
		else
			return "";
	}

	public  boolean isValue ( java.lang.String value )
	{
		if ( !( value == null || value.trim().equals("") ) )
			return true ;
		else
			return false ;
	}
	public  boolean isValuenull ( java.lang.String value )
	{
		if ( ( value == null || value.trim().equals("") ) )
			return true ;
		else
			return false ;
	}

	public  boolean isAlphastring(String pstring)
	{
		char c=0;
		boolean flag=true;
		for (int j=0;j<pstring.length();j++)
		{
			c=pstring.charAt(j);
			int i=(int)c;
			if(!((i>=65&&i<=90)||(i>=97&&i<=122)))
			{
				flag= false;
				break;
			}
		}
		return flag;
	}
	public  boolean isAlphanumeric(String pstring)
	{
		char c=0;
		boolean flag=true;
		for (int j=0;j<pstring.length();j++)
		{
			c=pstring.charAt(j);
			int i=(int)c;
			if(!((i>=48&&i<=57)||(i==43)))
			{
				flag= false;
				break;
			}
		}
		return flag;
	}
	public  boolean isLegalname(String pstring)
	{
		char c=0;
		boolean flag=true;
		for (int j=0;j<pstring.length();j++)
		{
			c=pstring.charAt(j);
			int i=(int)c;
			if(!((i>=65&&i<=90)||  // A To Z
					(i>=97&&i<=122)||// a To z
					(i>=44 && i<=57 )||// , - . \ 0 to 9
					(i==92 )||  //  /
					(i==32)||   // space
					(i==40)||   // (
					(i==41)||  //)
					(i==91)|| //[
					(i==93)))  // ]

			{
//				System.out.println("false   "+i);
				flag= false;
				break;
			}
		}
		return flag;
	}

	public  boolean isAlphabet(char c)
	{
		int i=(int)c;
		if((i>=65&&i<=90)||(i>=97&&i<=122))
			return true;
		else
			return false;
	}
	public  boolean isDigit(char c)
	{
		int i=(int)c;
		if(i>=48&&i<=57)
			return true;
		else
			return false;
	}

	public boolean isNegNumbers ( java.lang.String [] values  )
	{
		for ( int i = 0 ; i < values.length ; i++ )
		{
			if ( isValue ( values [ i ] ) && isNegNumber ( values [ i ] ) )
			{
				return true ;
			}
		}
		return false ;
	}
	public boolean isNegNumber ( java.lang.String value )
	{
		try
		{

			if ( Double.parseDouble ( value ) < 0 )
				return true ;
			else
				return false ;
		}
		catch ( java.lang.Exception e )
		{
			return false ;
		}
	}
	public  boolean Check_seprtcode1(String Rtcode)
	{
		boolean rts;
		rts=true;
		if (isValue(Rtcode ))
		{  char c=Rtcode.charAt(0);
		if ((isAlphabet(c )))
			rts=true;
		else
			rts=false;
		}
		return rts;
	}
	public  boolean Check_seprtcode2(String Rtcode)
	{
		boolean rts;
		rts=true;
		if (isValue(Rtcode ))
		{  char c=Rtcode.charAt(0);
		if ((isDigit(c )))
			rts=true;
		else
			rts=false;
		}
		return rts;
	}

	public  boolean isValidName ( String name  )
	{
		char [] chars = name.trim().toCharArray() ;
		boolean flag=true;
		for ( int i = 0; i < chars.length ; i++ )
		{
			if ( (((int)chars[i]) >= 65 && ((int)chars[i]) <= 90) ||			// A To Z
					(((int)chars[i]) >= 97 && ((int)chars[i]) <= 122) || 		// a to z
					(((int)chars[i])== 32)||									// space
					(((int)chars[i])== 45)||									//dash
					(((int)chars[i])== 46)										// dot
			)

			{}
			else
				flag=false;
		}
		return flag ;

	}

	public  String  RenameFile(String sr,String dt)
	{
		String l_ers=null;
		try{
			File source=new File(sr);
			System.out.println("fasf"+source);
			File dest = new File(dt);
			System.out.println("webhfuew"+dest);
			File destdir = new File(dt);
			source.createNewFile();
//			source.deleteOnExit();
			System.out.println("sr>>> "+sr);
			System.out.println("dt>>> "+dt);
			if(destdir.exists()){
				l_ers=(" Unable to move file " + " File exists in dest directory ");
				System.out.println("l_ers>>> "+l_ers);
			}

			source.renameTo(dest);

		}
		catch(IOException e)
		{
			l_ers="Error to Rename file "+e.getMessage();
			System.out.println("l_ers1>>> "+l_ers);
		}
		return l_ers;
	}

	public  boolean isValidARE ( java.lang.String regixExpression , java.lang.String p_string)
	{
		if ( isValue(p_string) )
		{
			java.util.regex.Pattern mobilePattern =  java.util.regex.Pattern.compile( regixExpression ) ;
			java.util.regex.Matcher matcher = mobilePattern.matcher( p_string ) ;

			if ( matcher.matches() )
				return true ;
			else
				return false ;
		}
		else
			return false ;
	}
	public   String RemoveChar(String P_string,char c)
	{
		String lstring="";
		if (isValuenull(P_string))
			return "";
		for (int i=0; i<P_string.length();i++)
		{
			if 	(P_string.charAt(i)!=c)
				lstring=lstring+P_string.charAt(i);
		}
		return lstring;
	}
	public  String ConvertYYYYMMDDTOMedium(String p_string)
	{
		String dt_str="";
		java.util.Date dt = new java.util.Date () ;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat dateddmmmyy = new  SimpleDateFormat("dd-MMM-yyyy");
		try
		{
			dt=dateFormat.parse(p_string);
			//  	  	dt_str=java.text.DateFormat.getDateInstance (java.text.DateFormat.MEDIUM,Locale.FRANCE).format (dt);
			dt_str=dateddmmmyy.format(dt);
			System.out.println(p_string);
		}

		catch(Exception e)
		{
			dt_str=null;
		}
		finally
		{
		}
		return dt_str;

	}
	// P_date is of format yyyymmdd
	public  String getlastdayofmonth(String p_date)
	{
		String lastday="";
		long year=ConvertNum(p_date.substring(0,4));
		String l_month=p_date.substring(4,6);
		if ((l_month.equalsIgnoreCase("01"))||
				(l_month.equalsIgnoreCase("03"))||
				(l_month.equalsIgnoreCase("05"))||
				(l_month.equalsIgnoreCase("07"))||
				(l_month.equalsIgnoreCase("08"))||
				(l_month.equalsIgnoreCase("10"))||
				(l_month.equalsIgnoreCase("12")))
		{
			lastday="31";
		}
		else
		{
			if ((l_month.equalsIgnoreCase("04"))||
					(l_month.equalsIgnoreCase("06"))||
					(l_month.equalsIgnoreCase("09"))||
					(l_month.equalsIgnoreCase("11")))
			{
				lastday="30";
			}
			else
			{
				if(year%4==0)
				{
					lastday="29";
				}
				else
				{
					lastday="28";
				}

			}

		}
		return lastday;
	}
	//start of quarter
	// P_date is of format yyyymmdd


	public String get_finyear(String pdate_yyyymmdd)
	{
		String rfin_year="NONE" ;
		if (isValue(pdate_yyyymmdd))
		{
			if (ConvertNum(pdate_yyyymmdd.substring(4,8)) <= 331)
			{
				rfin_year =""+( ConvertNum(pdate_yyyymmdd.substring(0,4)) - 1);
				rfin_year = rfin_year +" - "+ pdate_yyyymmdd.substring(0,4);
			}
			else
			{
				rfin_year =  pdate_yyyymmdd.substring(0,4);
				rfin_year = rfin_year + " - "+( ConvertNum(pdate_yyyymmdd.substring(0,4)) + 1);
			}
		}
		return rfin_year;
	}




	public long getMomthid(String todate)
	{

		long month=ConvertNum(todate.substring(4,6));
		//System.out.println("month"+todate+","+month);
		if(month>2)
		{
			return month-2;
		}
		else
			return month+10;
	}

	public  String returnblank_aszero(String p_string)
	{

		if (isValue(p_string))
			return p_string;
		else
			return "0";
	}



	public  String Nxt_workdate ( java.sql.Connection conora,String P_date)
	{
		int i=0 ;
		boolean rpt=true;
		String in_date=P_date;
		while (rpt==true)
		{
			i=Date_fun.Day_ofweek(in_date);
			boolean public_hday=Check_public_Holiday(conora,in_date);
			if ((i==1)||(public_hday==true))
			{
				Date temp_date=Date_fun.Date_FromYYYYMMDD(in_date);
				temp_date=Date_fun.Date_addDays(temp_date, 1);
				in_date=Date_fun.Date_toYYYYMMDD(temp_date);
			}
			else
				rpt=false;
		}
		System.out.println("Date : "+P_date+ "  >> "+ in_date);

		return in_date;
	}
	public boolean 	Check_public_Holiday(java.sql.Connection conora,String in_date)
	{
		boolean trn_val=false;
		String sql="";
		Statement st ;
		ResultSet rs;
		try
		{
			st= conora.createStatement();
			sql="select *  from PUBLIC_HOLIDAYS  where HOLIDAY_DATE = '"+in_date+"'";
			rs = st.executeQuery(sql);
			if(rs.next())
			{
				trn_val=true;
			}
			rs.close();
			st.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return trn_val;

	}
//	public String duedate_f704no(String p_todate)
//	{
//	DecimalFormat df= new DecimalFormat("0000");
//	long to_month=ConvertNum(p_todate.substring(4,6));
//	long to_year=ConvertNum(p_todate.substring(0,4));
//	if (to_month>3)to_year=to_year+1;
//	String allowed_date=df.format(to_year)+"0710";
//	allowed_date=sat2or4_sunday(allowed_date);
//	return allowed_date;

//	}

	public  String calculateMonthEndDate(String p_Activedt) 
	{
		int year =(int)ConvertNum(p_Activedt.substring(0,4));
		int month =(int)ConvertNum(p_Activedt.substring(4,6));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		int[] daysInAMonth = { 29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int day = daysInAMonth[month];
		boolean isLeapYear = new GregorianCalendar().isLeapYear(year);

		if (isLeapYear && month == 2) {
			day++;
		}
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
		java.util.Date monthEndDate = new java.util.Date(gc.getTime().getTime());
		return  dateFormat.format(monthEndDate);
	}
	public  String skip_sunday ( String P_date)
	{
		int i=0 ;
		String in_date=P_date;
		i=Date_fun.Day_ofweek(in_date);
		if (i==7)
		{
			Date temp_date=Date_fun.Date_FromYYYYMMDD(in_date);
			temp_date=Date_fun.Date_addDays(temp_date, 1);
			in_date=Date_fun.Date_toYYYYMMDD(temp_date);

		}

		return in_date;
	}
	public  String second_saturdayday ( String P_date,int scnt)
	{
		String todate="";
		int cnt=0;
		int month=(int)ConvertNum(P_date.substring(4, 6));
		int year=(int)ConvertNum(P_date.substring(0, 4));
		DecimalFormat myFormatter = new DecimalFormat("00");
		String Monthend=calculateMonthEndDate(P_date);
		int lday =(int)ConvertNum(Monthend.substring(6,8));
		for (int i=1;i<=lday;i++)
		{
			todate=""+year+myFormatter.format(month)+myFormatter.format(i);	
			int week=Date_fun.Day_ofweek(todate);
			if (week==7) cnt=cnt+1;
			if (cnt==scnt) break;
		}
		return todate;
	}
	public  String sat2or4_sunday ( String P_date)
	{
		int i=0 ;
		String in_date=P_date;
//		int month=(int)ConvertNum(P_date.substring(4, 6));
//		int year=(int)ConvertNum(P_date.substring(0, 4));
		String s2=second_saturdayday ( P_date,2);
		String s4=second_saturdayday ( P_date,4);
		if (s2.equalsIgnoreCase(P_date)||s4.equalsIgnoreCase(P_date))
		{
			Date temp_date=Date_fun.Date_FromYYYYMMDD(P_date);
			temp_date=Date_fun.Date_addDays(temp_date, 2);
			in_date=Date_fun.Date_toYYYYMMDD(temp_date);

		}
		i=Date_fun.Day_ofweek(in_date);
		if (i==1)
		{
			Date temp_date=Date_fun.Date_FromYYYYMMDD(in_date);
			temp_date=Date_fun.Date_addDays(temp_date, 1);
			in_date=Date_fun.Date_toYYYYMMDD(temp_date);
		}
//		System.out.println("To date >>> Day "+in_date+" >>> "+i);
		return in_date;
	}
	public  String get_Nxtworkdate ( java.sql.Connection conora,String P_date)
	{
		int i=0 ;
		boolean rpt=true;
		String in_date=P_date;
		while (rpt==true)
		{
			boolean public_hday=Check_public_Holiday(conora,in_date);
			if ((public_hday==true))
			{
				Date temp_date=Date_fun.Date_FromYYYYMMDD(in_date);
				temp_date=Date_fun.Date_addDays(temp_date, 1);
				in_date=Date_fun.Date_toYYYYMMDD(temp_date);
			}
			else
				rpt=false;
		}
//		System.out.println("Date : "+P_date+ "  >> "+ in_date);

		return in_date;
	}


	// Late Fee Validation On Dated 21 July 2012
	public String Skip_Holidays(java.sql.Connection conora,	String Due_date)	
	{
		String d1_date=Due_date;
		String d2_date="";
		int i=0;
		while (i==0)
		{
			d2_date=sat2or4_sunday(d1_date);
			d2_date=get_Nxtworkdate(conora, d2_date);
//			System.out.println("d1_date  "+d1_date+" d2_date  "+d2_date);
			if (d1_date.equalsIgnoreCase(d2_date))
				i=1;
			else
				d1_date=d2_date;
		}
		return d2_date;
	}	

	public  boolean isValidStatusApplicant ( java.lang.String Status )
	{
		if ( isValue ( Status ) )
		{
			if (Status.equalsIgnoreCase("Proprietor")) return true;
			if (Status.equalsIgnoreCase("Partner")) return true;
			if (Status.equalsIgnoreCase("Director")) return true;
			if (Status.equalsIgnoreCase("Authorized Manager")) return true;
			if (Status.equalsIgnoreCase("Power of Attorney holder")) return true;
			if (Status.equalsIgnoreCase("Others")) return true;

			return false ;
		}
		else
			return false ;
	}

	public  boolean isValidStatutoryOrder ( java.lang.String Order )
	{
		if ( isValue ( Order ) )
		{
			if (Order.equalsIgnoreCase("Assessment order")) return true;
			if (Order.equalsIgnoreCase("Re-assessment order")) return true;
			if (Order.equalsIgnoreCase("Revision order")) return true;
			if (Order.equalsIgnoreCase("Review order")) return true;
			if (Order.equalsIgnoreCase("1st Appeal order")) return true;
			if (Order.equalsIgnoreCase("Any  other order")) return true;

			return false ;
		}
		else
			return false ;
	}

	public  boolean isValidStatutoryAct ( java.lang.String Order )
	{
		if ( isValue ( Order ) )
		{
			if (Order.equalsIgnoreCase("Maharashtra Value Added Tax  Act, 2002")) return true;
			if (Order.equalsIgnoreCase("Central Sales Tax Act, 1956")) return true;
			if (Order.equalsIgnoreCase("Maharashtra  Tax on Entry of Motor Vehicles into Local Areas Act, 1987")) return true;
			if (Order.equalsIgnoreCase("Maharashtra Tax on Entry of Goods into Local Areas Act, 2002")) return true;
			if (Order.equalsIgnoreCase("Maharashra Tax on Professions Trades and Callings Act, 1975")) return true;
			if (Order.equalsIgnoreCase("Maharashtra Purchase Tax on Sugar Cane Act, 1962")) return true;
			if (Order.equalsIgnoreCase("Bombay Sales Tax Act, 1959")) return true;
			if (Order.equalsIgnoreCase("Bombay Sales of Motor Spirit axation  Act, 1958")) return true;
			if (Order.equalsIgnoreCase("Maharashtra Tax on Luxuries Act, 1987")) return true;
			if (Order.equalsIgnoreCase("Maharashtra Sales Tax on the Transfer of Property in  goods involved in the execution of Works Contract(Re-enacted) Act, 1989")) return true;
			if (Order.equalsIgnoreCase("Maharashtra Sales Tax on the Transfer of Right to use any goods for any Purpose Act, 1985")) return true;

			return false ;
		}
		else
			return false ;
	}

	public  boolean isValidDistrict ( java.lang.String District )
	{
		if ( isValue ( District ) )
		{
			if (District.equalsIgnoreCase("1.Ahmadnagar")) return true;
			if (District.equalsIgnoreCase("2.Akola")) return true;
			if (District.equalsIgnoreCase("3.Amravati")) return true;
			if (District.equalsIgnoreCase("4.Aurangabad")) return true;
			if (District.equalsIgnoreCase("5.Bhandara")) return true;
			if (District.equalsIgnoreCase("6.Beed")) return true;
			if (District.equalsIgnoreCase("7.Buldana")) return true;
			if (District.equalsIgnoreCase("8.Chandrapur")) return true;
			if (District.equalsIgnoreCase("9.Dhule")) return true;
			if (District.equalsIgnoreCase("10.Gadchiroli")) return true;
			if (District.equalsIgnoreCase("11.Gondiya")) return true;
			if (District.equalsIgnoreCase("12.Hingoli")) return true;
			if (District.equalsIgnoreCase("13.Jalgaon")) return true;
			if (District.equalsIgnoreCase("14.Jalna")) return true;
			if (District.equalsIgnoreCase("15.Kolhapur")) return true;
			if (District.equalsIgnoreCase("16.Latur")) return true;
			if (District.equalsIgnoreCase("17.Mumbai")) return true;
			if (District.equalsIgnoreCase("18.Mumbai (Suburban)")) return true;
			if (District.equalsIgnoreCase("19.Nagpur")) return true;
			if (District.equalsIgnoreCase("20.Nanded")) return true;
			if (District.equalsIgnoreCase("21.Nandurbar")) return true;
			if (District.equalsIgnoreCase("22.Nashik")) return true;
			if (District.equalsIgnoreCase("23.Osmanabad")) return true;
			if (District.equalsIgnoreCase("24.Parbhani")) return true;
			if (District.equalsIgnoreCase("25.Pune")) return true;
			if (District.equalsIgnoreCase("26.Raigarh")) return true;
			if (District.equalsIgnoreCase("27.Ratnagiri")) return true;
			if (District.equalsIgnoreCase("28.Sangli")) return true;
			if (District.equalsIgnoreCase("29.Satara")) return true;
			if (District.equalsIgnoreCase("30.Sindhudurg")) return true;
			if (District.equalsIgnoreCase("31.Solapur")) return true;
			if (District.equalsIgnoreCase("32.Thane")) return true;
			if (District.equalsIgnoreCase("33.Wardha")) return true;
			if (District.equalsIgnoreCase("34.Washim1")) return true;
			if (District.equalsIgnoreCase("35.Yavatmal")) return true;
			if (District.equalsIgnoreCase("36.Palgar")) return true;
			return false ;
		}
		else
			return false ;
	}
	public boolean isNumeric(String s) {  
		return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
	public  boolean isValidDesignationVI ( java.lang.String DesignationVI )
	{
		if ( isValue ( DesignationVI ) )
		{
			if (DesignationVI.equalsIgnoreCase("S.T.O.CL-1")) return true;
			if (DesignationVI.equalsIgnoreCase("D.C.APPEAL")) return true;
			if (DesignationVI.equalsIgnoreCase("J.C. APPEAL")) return true;
			if (DesignationVI.equalsIgnoreCase("M.S.T.T.")) return true;
			if (DesignationVI.equalsIgnoreCase("HON.BOMBAY HIGH COURT")) return true;
			if (DesignationVI.equalsIgnoreCase("HON.SUPREME COURT OF INDIA")) return true;
			if (DesignationVI.equalsIgnoreCase("OTHER")) return true;

			return false ;
		}
		else
			return false ;
	}
	public  boolean isValidDesignationIV ( java.lang.String DesignationIV )
	{
		if ( isValue ( DesignationIV ) )
		{
			if (DesignationIV.equalsIgnoreCase("S.T.O.CL-1")) return true;
			if (DesignationIV.equalsIgnoreCase("S.T.O. CL- 2")) return true;
			if (DesignationIV.equalsIgnoreCase("A.C.S.T.")) return true;
			if (DesignationIV.equalsIgnoreCase("DY.COMMR.OF Sales tax.")) return true;
			if (DesignationIV.equalsIgnoreCase("SR.DY.COMMR.")) return true;
			if (DesignationIV.equalsIgnoreCase("JT.COMMR.")) return true;
			if (DesignationIV.equalsIgnoreCase("ADDL.COMMR.")) return true;
			if (DesignationIV.equalsIgnoreCase("COMMR.OF SALES TAX")) return true;
			if (DesignationIV.equalsIgnoreCase("OTHER")) return true;


			return false ;
		}
		else
			return false ;
	}

	public  boolean isValidAddrs ( String name  )
	{
		char [] chars = name.trim().toCharArray() ;
		boolean flag=true;
		for ( int i = 0; i < chars.length ; i++ )
		{
			if ( (((int)chars[i]) >= 65 && ((int)chars[i]) <= 90) ||			// A To Z
					(((int)chars[i]) >= 97 && ((int)chars[i]) <= 122) || 		// a to z
					(((int)chars[i]) >= 48 && ((int)chars[i]) <= 57) || 		// 0 to 9
					(((int)chars[i])== 32)||									// space
					(((int)chars[i])== 44)||									//comma
					(((int)chars[i])== 45)||									// dash
					(((int)chars[i])== 46)||									// dot
					(((int)chars[i])== 47)  									// slash

			)

			{}
			else
				flag=false;
		}
		return flag ;

	}
	public String current_Time()
	{
		String l_ers = "";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		l_ers = sdf.format(cal.getTime());
		return l_ers;
	}
	public  long datedifference(String from_date,String to_date)
	{
		String l_ers="";
		long  lret_string = 0 ;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm");

		Date d1 = null;
		Date d2 = null;

		try {
			d1 = format.parse(from_date);
			d2 = format.parse(to_date);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			if(diffDays>0)
			{
				diffHours=diffHours+(diffDays*24);
				lret_string=diffMinutes+(diffHours*60);
			}
			else
			{
				lret_string=diffMinutes+(diffHours*60);

			}
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		return lret_string;
	}
	public  String Checkemptyreturn1(String p_string)
	{
		if ( !( p_string == null  || p_string.equals("") ) )
			return p_string.trim();
		else
			return "&nbsp";
	}
	public  java.lang.String getDb2Date ( java.lang.String pdate )
	{

//		input date format yyyymmdd
		java.util.Date dt = new java.util.Date () ;
		String rtdate;
		if (isValuenull(pdate))
			return "";
		java.text.SimpleDateFormat smp = new java.text.SimpleDateFormat("dd-MM-yyyy") ;
		rtdate=  smp.format( ConvertYYYYMMDDTODate(pdate)  ,
				new  StringBuffer (),
				new java.text.FieldPosition  (0) ).toString() ;
		return rtdate;
	}
	public  java.util.Date ConvertYYYYMMDDTODate(String p_string)
	{
		java.util.Date dt = new java.util.Date () ;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		try
		{
			dt=dateFormat.parse(p_string);
		}
		catch(Exception e)
		{
			dt=null;
		}
		finally
		{
			return dt;
		}
	}
}