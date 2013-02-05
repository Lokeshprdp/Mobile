<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Price View</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
</head>
<body>
<table ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">
<TR CLASS='TRData'>
				<TD ALIGN='center'>Supplier Price Details</TD>
			</TR>
</table>
<table align='center'>

	  	
		<%! Iterator itr; 
		Set set=null; %>
	<% Map data= (Map)request.getAttribute("data");

	set=data.entrySet();
	itr=set.iterator();
	while(itr.hasNext()) { 
	Map.Entry me = (Map.Entry)itr.next(); 
	System.out.print(me.getKey() + ": "); 
	System.out.println(me.getValue()); 
}
%>
		
				
              <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="35%" align="left">Supplier Name :</TD>
             <TD CLASS="TDData1">
             <%= data.get("supplier") %>
             </TD>
             </TR>
          <BR>
</table>
 <TABLE ALIGN="center" BORDER=0 CELLSPACING=1 CELLPADDING=2 WIDTH="85%">
            <TR class='TRData1'>
            	<TD colspan='9' ALIGN='CENTER'>Supplier Price Details</TD>
            </TR>
             <TR CLASS='TRHead'>
              <TD WIDTH='5%'>Sl No.</TD>
              <TD width="15%">Brand Name</TD>
              <TD>Model Name</TD>
              <TD>Model Description</TD>
              <TD>Price</TD>
            </TR>
</TABLE>            
</body>
</html>