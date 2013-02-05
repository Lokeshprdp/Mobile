<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Edit</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<SCRIPT type="text/javascript" src="./scripts/clientValidate.js"></SCRIPT>
<script type="text/javascript">
function validation()
{
	var form = document.getElementById("frmsupplieredit");
	var count = form["itemCount"].value;
	var chkCount=0;

	for(i=1; i<=count; i++)
	{
		var payment = form["payment"+i].value;
		var payamount = form["payamount"+i].value;
		var balamount = form["balamount"+i].value;
		
		if(form["payment"+i].checked)
		{
			//if(!(flgTitle=checkFieldDataClient(eval(form["payamount"+i]),'Please enter valid amount received.',floatpat,'0','0')))
				//return false;
				
			if(payamount == "0")
			{
			   alert("please Enter Valid amount");	
			   return false
			}
			if(balamount < payamount)
			{
				alert("Pay Amount Should not exceed Balance Amount");
				return false;
			}  	
			
			chkCount="1";
		}
		
		
	}
	if(chkCount=="0")
	{
		alert("Please select a purchase bill and then proceed.");
		return false;
	}
		return true;
}

</script>
</head>
<body>
<FORM NAME="frmsupplieredit" method="post" action="supplierEdit" onSubmit="javascript:return validation();" style="margin:0px">
<table ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">
<TR CLASS='TRData'>
				<TD ALIGN='center'>Supplier Details</TD>
			</TR>
</table>

<table align='center'>

	  	
		<%! Iterator itr1; 
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
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">Contact Person :</TD>
             <TD CLASS="TDData1">
             <%= data.get("CP Name") %>
             </TD>
             </TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">Contact No :</TD>
             <TD CLASS="TDData1">
             <%= data.get("CP No") %>
             </TD>
             </TR>
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="left">OutStanding Amount :</TD>
             <TD CLASS="TDData1">
             <%= data.get("OutStanding") %>
             </TD>
             </TR>
             
          <BR>
             
</table>
<table align='center'>
 <TR ALIGN="center" class="TRData1">
             <TD CLASS="TRData1" colspan="8" align="center">Payment Details</TD>
             </TR></table>
<TABLE ALIGN="center"  BORDER=0 CELLSPACING=1 CELLPADDING=2 WIDTH="95%">
		<TR ALIGN="left" CLASS='TRHead'>
			<td nowrap=true CLASS="TRData1"><b>SI No.</b></td>
          	<td nowrap=true CLASS="TRData1"><b>Select</b></td>
			<td nowrap=true CLASS="TRData1"><b>Bill No</b></td>
			<td nowrap=true CLASS="TRData1"><b>Bill Date</b></td>
			<td nowrap=true CLASS="TRData1"><b>Bill Amount</b></td>
			<td nowrap=true CLASS="TRData1"><b>Due Amount</b></td>
			<td nowrap=true CLASS="TRData1"><b>Pay Amount</b></td>
		</TR>
		
<%! Iterator itr;%>
<% List payment= (List)request.getAttribute("payment");
int lno=0;
for (itr=payment.iterator(); itr.hasNext(); )
{
	lno++;

out.println("<tr>");
out.println("<td nowrap=true CLASS='TDData1'>"+ itr.next() +"</td>");
out.println("<td class='TDData1' align='center'><INPUT type='checkbox' Name='payment'"+lno+"' id='payment"+lno+"' value='"+ itr.next() +"'></INPUT></TD>");
out.println("<td nowrap=true CLASS='TDData1'>"+ itr.next() +"</td>");
out.println("<td nowrap=true CLASS='TDData1'>"+ itr.next() +"</td>");
out.println("<td nowrap=true CLASS='TDData1'>"+ itr.next() +"</td>");
out.println("<td nowrap=true CLASS='TDData1'><INPUT type='textbox' Name='balamount'"+lno+"' id='balamount"+lno+"' value='"+ itr.next() +"' READONLY></INPUT></td>");
out.println("<td class='TDData1' align='center'><INPUT type='textbox' Name='payamount'"+lno+"' id='payamount"+lno+"' value='0'></INPUT></TD>");
out.println("</tr>");
} %>
	 <table align="center" width="50%">
        	<tr align="center">
        		<td>
                    <input type="submit" class="button" value="Add"/> 
        			<input type="button" name="btncancel" value="Cancel" accesskey="c" onclick=funcFormSubmit(document.frmpaytermadd,'ebmPaymentTerms_list.jsp') class="button">
        		</td>
        	</tr>
       </table>
       <INPUT TYPE="hidden" NAME="itemCount" ID="itemCount" VALUE="<%=lno%>"></INPUT>
</TABLE>
</FORM>
 </body>
</html>