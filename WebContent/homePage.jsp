<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>homePage</title>
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<link REL="STYLESHEET" TYPE="text/css" HREF="./style.css">
<SCRIPT type="text/javascript" src="./scripts/jquery.js"></SCRIPT>
<script type="text/javascript">
$(document).ready(function () { 
	$('#nav li').hover(
	function () {
	//show its submenu
	$('ul', this).slideDown(350);
	}, 
	function () {
	//hide its submenu
	$('ul', this).slideUp(350); 
	}
	);
	});
</script>
</head>
<body>

<input type=hidden name=arav value="1*#*#*2"><ul id='nav'>
<li> <a href='#'>Transaction</a>
<ul>
<li style='background-color:#b0c4de;'><a href=/Mobile/purchaseList>Purchase</a></li>
<li style='background-color:#bebebe;'><a href=/Mobile/salesList>Sales</a></li>
</ul>
</li>
<li> <a href='#'>Master</a>
<ul>
<li style='background-color:#b0c4de;'><a href=/Mobile/brandList>Brand</a></li>
<li style='background-color:#bebebe;'><a href=/Mobile/ModelList>Model</a></li>
<li style='background-color:#b0c4de;'><a href=/Mobile/customerList>Customer</a></li>
<li style='background-color:#b0c4de;'><a href=/Mobile/supplierList>Supplier</a></li>
</ul>
</li>
</ul>
</body>
</html>