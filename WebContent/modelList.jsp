<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Model's List</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
</head>
<body>
<TABLE ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">					
			<TR CLASS='TRData1'>
				<TD ALIGN='center'>Mobile Model's List</TD>
				
			</TR> 
			
		<TR>
	     <TD ALIGN="right"> | 
       	  <A accesskey="a" href="modelAdd.jsp"><u>A</u>dd Mobile Model</A> | 
	      </TD>
	    </TR>
			
			
		</TABLE>	

<TABLE ALIGN='center' BORDER=1 CELLSPACING=1 CELLPADDING=3 WIDTH="50%">
<tr>
<td nowrap=true CLASS="TRData1"><b>SI No.</b></td>
<td nowrap=true CLASS="TRData1"><b>Model Name</b></td>
<td nowrap=true CLASS="TRData1"><b>Brand Name</b></td>
</tr>
<%! Iterator itr;%>
<% List data= (List)request.getAttribute("data");
for (itr=data.iterator(); itr.hasNext(); )
{

%>
<tr>
<td nowrap=true CLASS="TDData1"><%=itr.next()%></td>
<td nowrap=true CLASS="TDData1"><a href='/Mobile/mobileEdit?modelid=<%= itr.next() %>'><%= itr.next()%></a></td>
<td nowrap=true CLASS="TDData1"><%=itr.next()%></td>
</tr>
<%
}
%>
</table>
</body>
</html>