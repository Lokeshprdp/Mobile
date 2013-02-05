<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<script type="text/javascript" src="./scripts/clientValidtate.js"></script>
</head>
<body>
<form name="frmpayment" action="payment">
<table align="center" BORDER=0 CELLSPACING=1 CELLPADDING=1 WIDTH="90%">
<TR ALIGN="center" CLASS="TRData1">
	<TD CLASS="TDData1">Payment Entry
	</TD>
</TR>
</table>

<table align="center" border="0" cellspacing="1" cellpadding="1" width="60%">
<TR ALIGN="left">
		 		  <TD CLASS="TRData1">Supplier Name:</TD>
		 	  <TD nowrap=true>
				 <SELECT NAME='supplier' ID='supplier' CLASS='clsDropDown' STYLE='WIDTH:270px;'>
				 <option value='0'>[Select supplier Name]</option>
		    <%! Iterator itr;%>
<% List supplier= (List)request.getAttribute("data");
  
for (itr=supplier.iterator(); itr.hasNext(); )
{
%>
		     
		    	
		         <Option value=" <%= itr.next() %> "><%= itr.next() %></Option> <br>
		         <%} %>
		     </SELECT>
			 </TD>
		 	 </TR>
</table>
</form>
</body>
</html>