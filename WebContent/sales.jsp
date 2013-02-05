<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<SCRIPT type="text/javascript" src="./scripts/library.js"></SCRIPT>
<SCRIPT type="text/javascript" src="./scripts/clientValidate.js"></SCRIPT>
<SCRIPT type="text/javascript" src="./scripts/ebmLibrary.js"></SCRIPT>
<SCRIPT type="text/javascript">

function funcAgentBranchEnable()
{
	
  var form = document.getElementById("frmsales");
  if(form.customretail[0].checked)
  {
			document.getElementById("TRWholesale").style.display="block";
			document.getElementById("TRRetail").style.display="none";
  }
  else
  {
    document.getElementById("TRWholesale").style.display="none";
    document.getElementById("TRRetail").style.display="block";
  }
}

function funcGenerate()
{
	 
	 var form = document.getElementById("frmsales");
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
	 	document.location.href("/Mobile/sales?rows="+rows);
		//document.location.href("/Mobile/purchase");
	 }
	 else
	 {
	 	alert("Enter a valid number of rows");
	 }
}
function calcValue(line)
{
	 var form = document.getElementById("frmsales");
	 var discvalue = "";
	 var totalvalue = "";

	 totalvalue = Number(eval('form.qty'+line).value) * Number(eval('form.rate'+line).value);
	 discvalue = (( totalvalue * Number(eval('form.disper'+line).value)) / 100);

	 eval('form.total'+line).value = totalvalue - discvalue;
	 eval('form.disvalue'+line).value = discvalue;
	 	 
}
function selectAgentBranch(obj)
{
	if(obj.value=="customer")
	{
		document.frmsales.retail.disabled=true;
		document.frmsales.retail.value="";
		document.frmsales.customer.disabled=false;
	}
  else
  {
  	alert(retail)
  	document.frmsales.retail.disabled=false;
		document.frmsales.customer.disabled=true;
		document.frmsales.customer.value="";
  }
}
function validation()
{
	var form = document.getElementById("frmsales");
	var customer = form["customer"].value;
	var retail = form["retail"].value;
	var count = form["itemCount"].value;

	if(form.customretail[0].checked)
	{
		if(customer == "0")
		{
			alert("Please select the Customer Name");
		}
	}
	if(form.customretail[1].checked)
	{
		if(retail == "")
		{
			alert("Please Enter the Customer Name");
		}
	}
	
	for(i=1; i<=count; i++)
	{
		var brandname = form["brand"+i].value;
		var modelname = form["model"+i].value;
		var qty = form["qty"+i].value;
		var rate = form["rate"+i].value;
		var imei = form["imei"+i].value;
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
		if(imei == "")
		{
			alert("Please Enter Valid IMEI No");
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
		}
		return true;
}

</SCRIPT>
</head>
<body>
<form name="frmsales" method="post" action="sales" onSubmit="javascript: return validation()" style="margin:0px">
<%! 
	int rowscnt,lno,slno,itemCount=0;
%>
<table align="center" border="0" CELLSPACING="0" CELLPADDING="0" WIDTH="60%">
<TR CLASS='TRData1'>
				<TD ALIGN='center'>Sales Details</TD>
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
		 	<TR ALIGN="left" class='TRData1'>
			 <TD>WholeSale/Retail :</TD>
			 <TD class='TDData1'>
			 	<INPUT TYPE='radio' NAME='customretail' ID='customretail' VALUE='WholeSale' class='radio' onClick='funcAgentBranchEnable()' checked>&nbsp; WholeSales                  
			 	<INPUT TYPE='radio' NAME='customretail' ID='customretail' VALUE='Retailer' class='radio' onClick='funcAgentBranchEnable()'>&nbsp; Retail                  
			 </TD>
			 </TR>
		  	
		  	<TR align="left" class="TRData1" NAME="TRWholesale" ID="TRWholesale">
		  	<td>Customer:</td>
		  	<td class="TDData1">
		  	<SELECT NAME='customer' ID='customer' CLASS='clsDropDown' STYLE='WIDTH:270px;'>
				 <option value='0'>[Select Customer Name]</option>
				  <%! Iterator itr;%>
<% List customer= (List)request.getAttribute("customer");
  
for (itr=customer.iterator(); itr.hasNext(); )
{
%>
		     
		    	
		         <Option value=" <%= itr.next() %> "><%= itr.next() %></Option> <br>
		         <%} %>
		    </SELECT>
			</td>
		  	</TR>
		  	<TR align="left" class="TRData1" style="display:none" NAME="TRRetail" ID="TRRetail">
		  	<td>Customer:</td>
		  	<td class="TDData1">
		  	<input type="textbox" name="retail" id="retail" value='' class="textbox" size="20"></input>
		  	</td>
		  	</TR>
		  	<TR align="left" class="TRData1">
		  	<td>DC No:</td>
		  	<td class="TDData1">
		  	<input type="textbox" name="billno" id="billno" value='' class="textbox" size="20"></input>
		  	</td>
		  	</TR>
		  	<TR align="left" class="TRData1">
		  	<td>DC Date:</td>
		  	<td class="TDData1">
		  	<input type="textbox" name="billdate" id="billdate" value='' class="textbox" size="10"></input>
		  	</td>
		  	</TR>
		  	</table>
		  	
		 <table align="center" border="0" cellspacing="1" cellpadding="3" width="60%">
		 <tr align="center" class="TRHead">
		 <TH width='8%'nowrap=true>Brand Name</TH>
		 <TH width='8%'nowrap=true>Model Name</TH>
		 <TH width='8%'nowrap=true>IMEI No</TH>
		 <TH width='8%'nowrap=true>Quantity</TH>
		 <TH width='8%'nowrap=true>Price</TH>
		 <TH width='8%'nowrap=true>Discount %</TH>
		 <TH width='8%'nowrap=true>Discount Value</TH>
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
		     out.println("\n\t<TD nowrap=true><INPUT TYPE='text' NAME='imei"+lno+"' VALUE='' size='10' class='textbox'></INPUT></TD>");
		     out.println("\n\t<TD nowrap=true><INPUT TYPE='text' NAME='qty"+lno+"' VALUE='0' size='10' class='textbox' onblur=calcValue('"+lno+"');></INPUT></TD>");				           	
	         out.println("\n\t<TD nowrap=true><INPUT TYPE='text'  NAME='rate"+lno+"' VALUE='0' size='10' class='textbox' onblur=calcValue('"+lno+"');></INPUT>");
	         out.println("\n\t<TD nowrap=true><INPUT TYPE='text'  NAME='disper"+lno+"' VALUE='0' size='10' class='textbox' onblur=calcValue('"+lno+"');></INPUT>");
	         out.println("\n\t<TD nowrap=true><INPUT TYPE='text'  NAME='disvalue"+lno+"' VALUE='0' size='10' class='textbox' onblur=calcValue('"+lno+"');></INPUT>");
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