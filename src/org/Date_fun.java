package org;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Date_fun 
{
	//Conversion of YYYYMMDD to Date
	public Date Date_FromYYYYMMDD(String p_date)
	{
		Date retun_date;
		int year;
		int month;
		int date;
		year=Integer.parseInt(p_date.substring(0,4));
		month=Integer.parseInt(p_date.substring(4,6))-1;
		date=Integer.parseInt(p_date.substring(6,8));
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE,date);  
		retun_date =cal.getTime();
		return retun_date;
	}
	//Conversion of date to YYYYMMDD
	public String Date_toYYYYMMDD(Date p_date)
	{
		Format formatter;
		formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(p_date);
	}
	//adding years to the date
	public Date Date_addYear(Date p_date, int noyears)
	{
		Date retun_date;
		Calendar cal = Calendar.getInstance();
		String date_YYYY=Date_toYYYYMMDD(p_date);
		int year;
		int month;
		int date;
		year=Integer.parseInt(date_YYYY.substring(0,4));
		month=Integer.parseInt(date_YYYY.substring(4,6))-1;
		date=Integer.parseInt(date_YYYY.substring(6,8));
		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE,date); 
		cal.add(Calendar.YEAR, noyears);
		retun_date=cal.getTime();
		return retun_date;
	}
	public Date Date_addMonth(Date p_date, int nomonths)
	{
		Date retun_date;
		Calendar cal = Calendar.getInstance();
		String date_YYYY=Date_toYYYYMMDD(p_date);
		int year;
		int month;
		int date;
		year=Integer.parseInt(date_YYYY.substring(0,4));
		month=Integer.parseInt(date_YYYY.substring(4,6))-1;
		date=Integer.parseInt(date_YYYY.substring(6,8));
		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE,date); 
		cal.add(Calendar.MONTH, nomonths);
		retun_date=cal.getTime();
		return retun_date;
	}
	public Date Date_addDays(Date p_date, int nodays)
	{
		Date retun_date;
		Calendar cal = Calendar.getInstance();
		String date_YYYY=Date_toYYYYMMDD(p_date);
		int year;
		int month;
		int date;
		year=Integer.parseInt(date_YYYY.substring(0,4));
		month=Integer.parseInt(date_YYYY.substring(4,6))-1;
		date=Integer.parseInt(date_YYYY.substring(6,8));
		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE,date); 
		cal.add(Calendar.DATE, nodays);
		retun_date=cal.getTime();
		return retun_date;
	}
	
//	public int datediff(String p_fdate, String p_tdate)
//	{
//			  int ret_days;;
//			  System.out.println("datef : "+p_fdate);
//			  System.out.println("datet : "+p_tdate);
//			  Calendar calendar1 = Calendar.getInstance();
//			  Calendar calendar2 = Calendar.getInstance();
//			  calendar1.set(Integer.parseInt(p_fdate.substring(0,4)), Integer.parseInt(p_fdate.substring(4,6)), Integer.parseInt(p_fdate.substring(6,8)));
//			  calendar2.set(Integer.parseInt(p_tdate.substring(0,4)), Integer.parseInt(p_tdate.substring(4,6)), Integer.parseInt(p_tdate.substring(6,8)));
//			  long milliseconds1 = calendar1.getTimeInMillis();
//			  long milliseconds2 = calendar2.getTimeInMillis();
//			  long diff = milliseconds2 - milliseconds1;
//			  System.out.println("diff : "+diff);
//			  long diffDays = diff / (24 * 60 * 60 * 1000);
//			  System.out.println("diff1: "+diffDays);
//			  
//			  ret_days=(int)diffDays - 1;
//			  System.out.println("diff2: "+ret_days);
//			  return ret_days;
//	}
	public int datediff(String p_fdate, String p_tdate)
	{
		int ret_days=0;
		try
		{
			int tempDifference = 0;
			//int difference = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date a=(Date)sdf.parse(p_fdate);
			Date b=(Date)sdf.parse(p_tdate);
			Calendar earlier = Calendar.getInstance();
			Calendar later = Calendar.getInstance();

			if (a.compareTo(b) < 0)
			{
				earlier.setTime(a);
				later.setTime(b);
			}
			else
			{
				earlier.setTime(b);
				later.setTime(a);
			}

			while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR))
			{
				tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
				ret_days += tempDifference;
//				System.out.println("ret_days--->:"+ret_days);

				earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
				
			}

			if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR))
			{
				tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
				ret_days += tempDifference;
//				System.out.println("tempDifference--->:"+ret_days);
//				System.out.println("earlier--->:"+earlier.get(Calendar.DAY_OF_YEAR));
//				System.out.println("later--->:"+later.get(Calendar.DAY_OF_YEAR));

				earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
			}

			//return difference;
			//System.out.println("Difference--->:"+ret_days);
		}
		catch(Exception e)
		{
			//e.printStackTrace();
		}
		return ret_days;
	}
	public    int  Day_ofweek(String p_date)
	{
		Calendar cal = Calendar.getInstance();
		int year;
		int month;
		int date;
		year=Integer.parseInt(p_date.substring(0,4));
		month=Integer.parseInt(p_date.substring(4,6))-1;
		date=Integer.parseInt(p_date.substring(6,8));
		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DATE,date); 
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek;
	}
	
}
