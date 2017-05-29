<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'Upload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<script language="JAVASCRIPT" type="TEXT/JAVASCRIPT">
 	function Uploads()
	{
		alert('jdsjdsn');
		document.forms[0].action='ImgUpload?Option=1';	//Close Complaint
		document.forms[0].submit();
	}
		
	</script>
  </head>
  
  <body>
	<form name="complaintsave" method ="POST" enctype="multipart/form-data" > 
		<table align="center" class="mainTable" border="1" cellpadding="2" cellspacing="2" width="92%" height="50%" style="background-color:silver;">
			<tr><td>
				<table align="center" width="95%" cellpadding="2" cellspacing="2" style="background-color:transparent;">
					<tr>
						<td  colspan="3"></td>
						<td  colspan="1"><b><font color="blue">DHQ Up</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="DHQ_UP" id="DHQ_UP" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errDHQ_UP"></span></td>
						<td  colspan="1"><b><font color="blue">DHQ Down</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="DHQ_DOWN" id="DHQ_DOWN" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errDHQ_DOWN"></span></td>
					</tr> 
					<tr>
						<td  colspan="3"></td>
						<td  colspan="1"><b><font color="blue">Zonal Up</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="ZONAL_UP" id="ZONAL_UP" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errZONAL_UP"></span></td>
						<td  colspan="1"><b><font color="blue">Zonal Down</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="ZONAL_DOWN" id="ZONAL_DOWN" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errZONAL_DOWN"></span></td>
					</tr>
					<tr>
						<td  colspan="3"></td>
						<td  colspan="1"><b><font color="blue">Mandal Up</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="MANDAL_UP" id="MANDAL_UP" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errMANDAL_UP"></span></td>
						<td  colspan="1" ><b><font color="blue">Mandal Down</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="MANDAL_DOWN" id="MANDAL_DOWN" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errMANDAL_DOWN"></span></td>
					</tr>
					<tr>
						<td  colspan="3"></td>
						<td  colspan="1"><b><font color="blue">SS Up</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="SS_UP" id="SS_UP" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errSS_UP"></span></td>
						<td  colspan="1"><b><font color="blue">SS Down</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="SS_DOWN" id="SS_DOWN" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errSS_DOWN"></span></td>
					</tr>
					<tr>
						<td  colspan="3"></td>
						<td  colspan="1"><b><font color="blue">OLA Up</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="OLA_UP" id="OLA_UP" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errOLA_UP"></span></td>
						<td  colspan="1"><b><font color="blue">OLA Down</font></b></td>
						<td  colspan="2"><input style="width: 98%;" name="OLA_DOWN" id="OLA_DOWN" type="file" accept="application/pdf, image/jpeg, image/jpg, image/JPEG, image/JPG" class="sitemap-link-1" value="browse..">
						<br><span style="color:red;" id="errOLA_DOWN"></span></td>
					</tr>
				</table>
			</td></tr>
					<tr>
						<td  align="center" colspan="10"><button class="button" onclick="Uploads();"/><b><font color="blue">Save Image</font></b></button></td>
					</tr>
			
		</table>
	</form>
	</body>
</html>
