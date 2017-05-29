import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;


public class ImgUpload extends HttpServlet {

	//abhfbabsf
	//dsjbgkjdbsjkbgskjdbgkjs
	//dskgnjdsngns
	org.krrvalidation krrvalidation=new org.krrvalidation();
	org.Initclass Initclass=new org.Initclass();
	org.Global_Data Global_Data=new org.Global_Data();
//ngnsdngsd
	//nsdfnnsdfn s
	//sngfns
	public ImgUpload() {
		
		super();
	}
//sdnfjbsdbfs
	//sdjfjdbsbfdsj
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}


	public void init() throws ServletException {
		String l_ers1=Initclass.initurl(getServletContext().getRealPath("/properties/database.properties"), Global_Data);
	}
	public void service (javax.servlet.http.HttpServletRequest req ,
			javax.servlet.http.HttpServletResponse res )
	{
		String 	filename = null ;
		String l_ers="";
		java.sql.Connection con = null ;
		try
		{
			int Option = (int) krrvalidation.ConvertNum(req.getParameter("Option"));
			System.out.println("Option......... "+Option);

			switch(Option)
			{
			case 1:
			{
				l_ers  = getExcelSheet1(req, res, filename,Global_Data);
				getServletContext().getRequestDispatcher("/Upload.jsp").forward(req, res);	
			}
			}

		}

		catch ( java.lang.Exception e )
		{
			e.printStackTrace () ;
		}
		finally
		{
			try
			{
				if (!(con==null )) con.close();
			}
			catch(java.lang.Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public String getExcelSheet1 ( javax.servlet.http.HttpServletRequest req ,
			javax.servlet.http.HttpServletResponse res ,
			String filename , 
			org.Global_Data Global_Data)
	{
		String upload_filename="";
		String l_district="";

		try
		{

			FileUpload fup=new FileUpload();
			boolean isMultipart = FileUpload.isMultipartContent(req);
			DiskFileUpload upload = new DiskFileUpload();
			List items = upload.parseRequest(req);
			Iterator iter = items.iterator();
			while (iter.hasNext())
			{
				System.out.println("ewhtuheruhti");
				FileItem item = (FileItem) iter.next();
				System.out.println("Names----------"+item.getFieldName ());
				String names = item.getFieldName () ;
				String l_item=new String(item.getString());
				if(names.equalsIgnoreCase("DHQ_UP"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="DHQ_UP"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}

				if(names.equalsIgnoreCase("DHQ_DOWN"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="DHQ_DOWN"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}
				if(names.equalsIgnoreCase("ZONAL_UP"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="ZONAL_UP"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}

				if(names.equalsIgnoreCase("ZONAL_DOWN"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="ZONAL_DOWN"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}

				if(names.equalsIgnoreCase("MANDAL_UP"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="MANDAL_UP"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}

				if(names.equalsIgnoreCase("MANDAL_DOWN"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="MANDAL_DOWN"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}
				if(names.equalsIgnoreCase("SS_UP"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="SS_UP"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}
				if(names.equalsIgnoreCase("SS_DOWN"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="SS_DOWN"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}
				if(names.equalsIgnoreCase("OLA_UP"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="OLA_UP"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}
				if(names.equalsIgnoreCase("OLA_DOWN"))
				{
					upload_filename = item.getName() ;
					String Image_filename=getUserFileName(upload_filename);	
					if (krrvalidation.isValue(upload_filename))
					{
						String ImageDirectory = Global_Data.getImageDirectory();
						System.out.println("image directory "+ImageDirectory);
						HttpSession ss=req.getSession(false);
						java.io.File saveDir = new java.io.File (ImageDirectory);
						saveDir.mkdirs();
						int dot = Image_filename.lastIndexOf('.');
						String extension = (dot == -1) ? "" : Image_filename.substring(dot+1);
						String new_filename="OLA_DOWN"+"."+extension;
						File tosave=new File(ImageDirectory+"/"+new_filename);						
						item.write(tosave);
						System.out.println("to save "+tosave);
					}
				}

			}
		}

		catch ( java.lang.Exception e )
		{
			e.printStackTrace();
		}
		return upload_filename ;
	}	

	public String getUserFileName(String filepath)
	{
		String  File_name="";
		try
		{
			String arr[] = filepath.split("/");
			File_name=arr[arr.length-1];
			if(arr.length == 1)
			{
				String arr1[] = filepath.split("\\\\");
				File_name=arr1[arr1.length-1];
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return File_name;
	}
	public String getUserFileName1(String filepath)
	{
		String  File_name="";
		try
		{
			filepath.substring(0, filepath.lastIndexOf('.'));
			int dot = filepath.lastIndexOf('.');
			String base = (dot == -1) ? filepath : filepath.substring(0, dot);
			String replaceString=base.replaceFirst(base, "asdkm");
			String extension = (dot == -1) ? "" : filepath.substring(dot+1);
			System.out.println("adshfah"+base);
			System.out.println("adshfah"+extension);
			System.out.println("adshfah"+replaceString);
			System.out.println("smdkask"+filepath.substring(0, filepath.lastIndexOf('.')));
			System.out.println("smdkask"+filepath.startsWith("."));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return File_name;
	}
}

//gfjghjghjkghkghkghkg
//asdfghjkl;
