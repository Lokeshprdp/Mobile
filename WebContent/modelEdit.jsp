<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Model Details</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<script type="text/javascript">

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

function validation()
{
	var form = document.getElementById("frmmodeledit");
	
	var modelname = form["modelname"].value;
	var modelspec = form["modelspec"].value;
	var price = form["price"].value;
	
		
	if(modelname == "")
	{
		alert("Please Enter Mobile Model Name");
		return false;
	}
	
	if(modelspec == "")
	{
		alert("Please Enter Mobile Model Spec details");
		return false;
	}
	
	if(price == "0")
	{
		alert("Please Enter Valid Price");
		return false;
	}
	else
	{
		return true;
	}
}

</script>
</head>
<body>

<FORM NAME="frmmodeledit" method="POST" action="mobileEdit"  onsubmit="javascript:return validation();" style="margin:0px">
    
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

<table ALIGN='center' BORDER=0 CELLSPACING=0 CELLPADDING=0 WIDTH="100%">
<TR CLASS='TRData'>
				<TD ALIGN='center'>Edit Model</TD>
			</TR>
			
			 <table align="Center" border="0" cellspacing="0" cellpadding="0" width="60%">
			
			
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">Brand Name :</TD>
             <TD CLASS="TDData1">
             <%= data.get("Brand") %>
             
             </TD></TR>
             
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">Model Name :</TD>
             <TD CLASS="TDData1">
             <input type='text' name='modelname' value='<%= data.get("Model Name") %>' class='textbox'></input>
             <input type='hidden' name='modelid' value='<%= data.get("Id") %>' >
             </TD></TR>
             
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">Model Spec :</TD>
             <TD CLASS="TDData1">
             <input type='text' name='modelspec' value='<%= data.get("Model Spec") %>' class='textbox' size='30'></input>
             </TD></TR>
             
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">Quantity :</TD>
             <TD CLASS="TDData1">
             <input type='text' name='qty' onkeypress="return isNumber(event)" value='<%= data.get("Quantity") %>' class='textbox' size='10'></input>
             </TD></TR>
             
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">Rate :</TD>
             <TD CLASS="TDData1">
             <input type='text' name='price' onkeypress="return isNumber(event)" value='<%= data.get("Rate") %>' class='textbox' size='10'></input>
             </TD></TR>
             
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">WholeSale Price1 :</TD>
             <TD CLASS="TDData1">
             <input type='text' name='wholesale1' onkeypress="return isNumber(event)" value='<%= data.get("wholesale1") %>' class='textbox' size='10'></input>
             </TD></TR>
             
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">WholeSale Price2 :</TD>
             <TD CLASS="TDData1">
             <input type='text' name='wholesale2' onkeypress="return isNumber(event)" value='<%= data.get("wholesale2") %>' class='textbox' size='10'></input>
             </TD></TR>
             
             <TR ALIGN="left" class="TRData1">
             <TD CLASS="TRData1" width="25%" align="center">customer Price :</TD>
             <TD CLASS="TDData1">
             <input type='text' name='customerrate' onkeypress="return isNumber(event)" value='<%= data.get("customerrate") %>' class='textbox' size='10'></input>
</TD>
</TR>
</table>
<br><br>
                <table align="center" width="50%">
        	<tr align="center">
        		<td>
                            <input type="submit" class="button" value="Add"/> 
        			<!--  <input type="button" name="btnupdate" value="Add" accesskey="a" onclick='validation()' class="button"> --> 
        			<input type="button" name="btncancel" value="Cancel" accesskey="c" onclick=funcFormSubmit(document.frmpaytermadd,'ebmPaymentTerms_list.jsp') class="button">
        		</td>
        	</tr>
       </table>
   <input type="hidden" name="modelid" value="<%=data.get("Id") %>"></input>    
  </FORM>
  </body>
</html>