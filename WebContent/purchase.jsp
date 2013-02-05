<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="com.mobile.db.DBConnection"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Material Inward</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<SCRIPT type="text/javascript" src="./scripts/library.js"></SCRIPT>
<SCRIPT type="text/javascript" src="./scripts/clientValidate.js"></SCRIPT>
<SCRIPT type="text/javascript" src="./scripts/CalendarPopup.js"></SCRIPT>
<SCRIPT type="text/javascript" src="./scripts/ebmLibrary.js"></SCRIPT>
<SCRIPT type="text/javascript" src="./scripts/datetimepicker.js"></SCRIPT>
<script type="text/javascript">

 function funcGenerate()
 {
	 alert ("inside");
	 var form = document.getElementById("frmpurcahse");
	 var rows = form["rows"].value;
	 
	 if(rows == "" || rows == 0 || rows == 0)
	 {
		 alert("Enter Valid Rows");
	 }
	 else if(!isNaN(rows))
	 {
		 //form.action='purchase.jsp'
		 //form.method='POST';
		 //form.submit(); 
	 	document.location.href("/Mobile/purchase?rows="+rows);
		//document.location.href("/Mobile/purchase");
	 }
	 else
	 {
	 	alert("Enter a valid number of rows");
	 }
 }
 function calcValue(line)
 {
	 var form = document.getElementById("frmpurcahse");
	 eval('form.total'+line).value=Number(eval('form.qty'+line).value) * Number(eval('form.rate'+line).value);
 }
 function validation()
 {
	var form = document.getElementById("frmpurcahse");
	var supplier = form["supplier"].value;
	var billno = form["billno"].value;
	var date = form["billdate"].value;
	var count = form["itemCount"].value;
	  
	if(supplier == "0")
	{
		alert("Please select the supplier Name");
		return false;
	}
	if(billno == "")
	{
		alert("please enter bill no");
		return false; 	
	}
	if(date == "")
	{
		alert("Please enter valid date");
		return false;
	}
	
	for(i=1; i<=count; i++)
	{
		var brandname = form["brand"+i].value;
		var modelname = form["model"+i].value;
		var qty = form["qty"+i].value;
		var rate = form["rate"+i].value;
		var tax = form["tax"+i].value;
		var totalamount;
		if(brandname == "0")
		{
			alert("Please Select Mobile Brand Name");
			return false;
		}
		if(modelname == "0")
		{
			alert("Please Select Mobile Model Name");
			return false;
		}
		if(qty == "0")
		{
			alert("Please Enter Valid Quantity");
			return false;
		}
		if(rate == "0")
		{
			alert("Please Enter Valid Price");
			return false;
		}
		if(tax == "0")
		{
			alert("Please Enter Valid Tax Percentage");
			return false;
		}
		}
		return true;
 }
 
</script>
</head>
<body>
<form name="frmpurcahse" method="post" action="purchase" onSubmit="javascript:return validation();" style="margin:0px">
<%!
    public String strQueryString;
    int rowscnt,lno,slno,itemCount=0;
    
    Connection con = DBConnection.getConnection();
    ResultSet rs;
    
%>

<table align="center" border="0" cellspacing="0" cellpadding="0" width="60%">
<TR CLASS='TRData1'>
				<TD ALIGN='center'>Purchase Details</TD>
			</TR>
			
			 <TR ALIGN="left">
		 		  <TD CLASS="TRData1">No of Products:</TD>
		 		  <% if(request.getParameter("rows")==null)
		 		  {%>
		 		  	<TD CLASS="TDData1"><input type='text' name='rows' id='rows' value='0' class='textboxNum' onChange='funcGenerate()'></input></TD>		  
		 		  <%}
		 		  else
		 		  {
		 		  %>
		 		    <TD CLASS="TDData1"><input type='text' name='rows' id='rows' value='<%=request.getParameter("rows")%>' class='textboxNum' onChange='funcGenerate()'></input></TD>		  
		 		  <%}%>
		 </TR>
		 </table>
		  <script>
		 	document.getElementById("rows").focus();
		 </script>
		 
		 <%
		 if(request.getParameter("rows")==null)
		 {}
		 else
		 {
		 %>
		 
		 <table align="center" border="0" cellspacing="1" cellpadding="3" width="60%">
		 <TR ALIGN="left">
		 		  <TD CLASS="TRData1">Supplier Name:</TD>
		 	  <TD nowrap=true>
				 <SELECT NAME='supplier' ID='supplier' CLASS='clsDropDown' STYLE='WIDTH:270px;'>
				 <option value='0'>[Select supplier Name]</option>
		    <%! Iterator itr;%>
<% List supplier= (List)request.getAttribute("supplier");
  
for (itr=supplier.iterator(); itr.hasNext(); )
{
%>
		     
		    	
		         <Option value=" <%= itr.next() %> "><%= itr.next() %></Option> <br>
		         <%} %>
		     </SELECT>
			 </TD>
		 	 </TR>
		 	 <TR align="left" class="TRData1">
		  	<td>Bill No:</td>
		  	<td class="TDData1">
		  	<input type="textbox" name="billno" id="billno" value='' class="textbox" size="20"></input>
		  	</td>
		  	</TR>
		  	<TR align="left" class="TRData1">
		  	<td>Bill Date:</td>
		  	<td class="TDData1">
		  	<input type="textbox" name="billdate" id="billdate" value='' class="textbox" size="10"></input>
		  	<!-- <input id="billdate" type="text" size="25"><a href="javascript:NewCal('billdate','ddmmyyyy')"><img src="images/cal.gif" width="16" height="16" border="0" alt="Pick a date"></a> -->
		  	<span class="TDData1">(dd-mm-yyyy)</span>
		  	</td>
		  	</TR>
		 </table>
		 
		 <table align="center" border="0" cellspacing="1" cellpadding="3" width="60%">
		 <tr align="center" class="TRHead">
		 <TH width='8%'nowrap=true>Brand Name</TH>
		 <TH width='8%'nowrap=true>Model Name</TH>
		 <TH width='8%'nowrap=true>Quantity</TH>
		 <TH width='8%'nowrap=true>Price</TH>
		 <TH width='8%'nowrap=true>Tax Percentage</TH>
		 <TH width='8%'nowrap=true>Value</TH>
		 </tr>
		 
		 <%
		 
		     rowscnt=Integer.parseInt(request.getParameter("rows"));
		    int j;
		 	slno=1;
		 	lno=0;
		     for(int i=0;i<rowscnt;i++)
		     {
		    	 lno++;
		        if (slno > 0)
				{  
					 out.println("\t<TR CLASS='clsDataRow0' ID='rowNo"+i+"'>");
				}
				else
				{
					out.println("\t<TR CLASS='clsDataRow1'  ID='rowNo"+i+"'>");
				}
				j =i+1;
				
		     %>
		      <TD nowrap=true>
				 <SELECT NAME='brand<%=lno%>' ID='brand<%=lno%>' CLASS='clsDropDown' STYLE='WIDTH:270px;'>
				 <option value='0'>[Select Brand Name]</option>
		  
<% List data= (List)request.getAttribute("data");
  
for (itr=data.iterator(); itr.hasNext(); )
{
%>
		     
		    	
		         <Option value=" <%= itr.next() %> "><%= itr.next() %></Option> <br>
		         <%} %>
		     </SELECT>
			 </TD>
			<TD nowrap=true>
				 <SELECT NAME='model<%=lno%>' ID='model<%=lno%>' CLASS='clsDropDown' STYLE='WIDTH:270px;'>
				 <option value='0'>[Select Model Name]</option>
				  
<% List data1= (List)request.getAttribute("data1");
  
for (itr=data1.iterator(); itr.hasNext(); )
{
%>
		     
		    	
		         <Option value=" <%= itr.next() %> "><%= itr.next() %></Option> <br>
		         <%} %>
		     </SELECT>
			 </TD>
			 <% 
			 out.println("\n\t<TD nowrap=true><INPUT TYPE='text' NAME='qty"+lno+"' VALUE='0' size='20' class='textbox' onblur=calcValue('"+lno+"');></INPUT></TD>");				           	
	         out.println("\n\t<TD nowrap=true><INPUT TYPE='text'  NAME='rate"+lno+"' VALUE='0' size='10' class='textbox' onblur=calcValue('"+lno+"');></INPUT>");
	         out.println("\n\t<TD nowrap=true><INPUT TYPE='text'  NAME='tax"+lno+"' VALUE='0' size='10' class='textbox' onblur=calcValue('"+lno+"');></INPUT>");
	         out.println("<TD><INPUT TYPE='text' NAME='total"+lno+"' SIZE='5' VALUE=''  class='textboxNum' READONLY></INPUT></TD>"); 
	         slno=slno * -1;
	         }
		 %>
		
		 
		   </TABLE>
				 		
		 <table align="center" width="50%">
        	<tr align="center">
        		<td>
                    <input type="submit" class="button" value="Add"/> 
        			<input type="button" name="btncancel" value="Cancel" accesskey="c" onclick=funcFormSubmit(document.frmpaytermadd,'ebmPaymentTerms_list.jsp') class="button">
        		</td>
        	</tr>
       </table>
       <%}
		     %>
		 <INPUT TYPE="hidden" NAME="itemCount" ID="itemCount" VALUE="<%=rowscnt%>"></INPUT>
		 
</table>
</form>
</body>
</html>