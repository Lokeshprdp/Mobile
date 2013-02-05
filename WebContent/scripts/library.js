
function checkqty(field,fieldname)
  {
    var fldConv;     
    fldConv = eval(fieldname);
    if (isNaN(field))
     {
      fldConv.value='';
      alert('Not a number');
      fldConv.focus();
     }
    else
     if (field <= 0)
      {
       alert("Make valid entry! Value cannot be less than 1");
       fldConv.value='';
       fldConv.focus();
       
      } 
   }
function checkqty1(field,fieldname)
  {
    var fldConv;     
    fldConv = eval(fieldname);
    if (isNaN(field))
     {
      alert('Not a number');
      fldConv.value='';
      fldConv.focus()
     }
    else
     if (field < 0)
      {
       alert("Make valid entry! Value cannot be less than 0");
       fldConv.value='';
       fldConv.focus();
       
      } 
   }


function MM_reloadPage(init)
{  //reloads the window if Nav4 resized
  if (init==true) 
    with (navigator) 
    {
        if ((appName=="Netscape")&&(parseInt(appVersion)==4)) 
        {
            document.MM_pgW=innerWidth ;
            document.MM_pgH=innerHeight ;
            onresize=MM_reloadPage; 
        }
    }
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) 
    location.reload();
}
function tabOver(othis, item)
{
  switch (item)
  {
    case "hover" : 
      othis.style.backgroundimage = "./images/tab_hover.png";    
      break;
  }
  othis.style.cursor="hand";
}
  
function tabOut(othis, item)
{
  switch (item)
  {
    case "active" :
      othis.style.backgroundimage = "./images/tab_active.png";
      break;
    case "inactive" :
      othis.style.backgroundimage = "./images/tab.png";
      break;
   }
}

function activatePage(sURL)
{
   window.location.href=sURL;
}

function MM_openBrWindow(theURL,winName,features)
{ 
    features = "scrollbars=1,resizable=1,width=600,height=200"
    if (typeof(popupwin) == "object" && !popupwin.closed)
    {
      popupwin.close();
    }      
    popupwin = window.open(theURL,winName,features);

    if (!popupwin.opener) {
        popupwin.opener = window;
    }   
    popupwin.focus();
}

function isMaxLength (textarea, evt, maxLength) {
  if (textarea.selected && evt.shiftKey) 
    // ignore shift click for select
    return true;
  var allowKey = false;
  if (textarea.selected && textarea.selectedLength > 0)
    allowKey = true;
  else {
    var keyCode = 
      document.layers ? evt.which : evt.keyCode;
    if (keyCode < 32 && keyCode != 13)
      allowKey = true;
    else           
      allowKey = textarea.value.length < maxLength;
  }
  textarea.selected = false;
  return allowKey;
}
function storeSelection (field) {
  if (document.all) {
    field.selected = true;
    field.selectedLength = 
      field.createTextRange ?
        document.selection.createRange().text.length : 1;
  }
}

function getFieldValue(fieldName)
{
    frm = "document.forms[0].";
    fld = fieldName + ".value";
    val = eval(frm + fld);
    return(val);
}

function MM_openNewWindow(theURL)
{ 
    
    if (typeof(popupwin) == "object" && !popupwin.closed)
    {
      popupwin.close();
    }      
    popupwin = window.open(theURL);

    if (!popupwin.opener) {
        popupwin.opener = window;
    }   
    popupwin.focus();
}

//v3.0
function MM_goToURL() 
{ 
  var i, args=MM_goToURL.arguments; 
  document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}

//v4.0
function MM_findObj(n, d) { 
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && document.getElementById) x=document.getElementById(n); return x;
}

//v3.0
function MM_showHideLayers() 
{ 
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v='hide')?'hidden':v; }
    obj.visibility=v; }
}

function getCookie(name) 
{
    var dc = document.cookie;
    var prefix = name + "=";
    var begin = dc.indexOf("; " + prefix);
    if (begin == -1) {
      begin = dc.indexOf(prefix);
      if (begin != 0) return null;
    } else {
      begin += 2;
    }
    var end = document.cookie.indexOf(";", begin);
    if (end == -1) end = dc.length;
    return unescape(dc.substring(begin + prefix.length, end));
}

function trim(inputString) 
{
   // Removes leading and trailing spaces from the passed string. Also removes
   // consecutive spaces and replaces it with one space. If something besides
   // a string is passed in (null, custom object, etc.) then return the input.
   
   if (typeof inputString != "string") { return inputString; }
   var retValue = inputString;
   var ch = retValue.substring(0, 1);
   while (ch == " ") { // Check for spaces at the beginning of the string
      retValue = retValue.substring(1, retValue.length);
      ch = retValue.substring(0, 1);
   }
   ch = retValue.substring(retValue.length-1, retValue.length);
   while (ch == " ") { // Check for spaces at the end of the string
      retValue = retValue.substring(0, retValue.length-1);
      ch = retValue.substring(retValue.length-1, retValue.length);
   }
   // Note that there are two spaces in the string - look for multiple spaces within the string
   while (retValue.indexOf("  ") != -1) { 
      retValue = retValue.substring(0, retValue.indexOf("  ")) + retValue.substring(retValue.indexOf("  ")+1, retValue.length); // Again, there are two spaces in each of the strings
   }
   return retValue; // Return the trimmed string back to the user
} // Ends the "trim" function

function emailCheck(oEmailID)
{
    var emailStr=oEmailID.value
    var emailPat=/^(.+)@(.+)$/
    var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]"
    var validChars="\[^\\s" + specialChars + "\]"
    var quotedUser="(\"[^\"]*\")"
    var ipDomainPat=/^\[(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\]$/
    var atom=validChars + '+'
    var word="(" + atom + "|" + quotedUser + ")"
    var userPat=new RegExp("^" + word + "(\\." + word + ")*$")
    var domainPat=new RegExp("^" + atom + "(\\." + atom +")*$")

    var matchArray=emailStr.match(emailPat)
    if (matchArray==null)
    {
        alert("Email address seems incorrect (check @ and .'s)")
        oEmailID.select();
        oEmailID.focus();
        return false
    }
    var user=matchArray[1]
    var domain=matchArray[2]

    if (user.match(userPat)==null)
    {
        // user is not valid
        alert("The username doesn't seem to be valid.")
        oEmailID.select();
        oEmailID.focus();
        return false
    }

    var IPArray=domain.match(ipDomainPat)
    if (IPArray!=null)
    {
        // this is an IP address
        for (var i=1;i<=4;i++)
        {
            if (IPArray[i]>255)
            {
                alert("Destination IP address is invalid!")
                oEmailID.select();
                oEmailID.focus();
                return false
            }
        }

        return true
    }

    var domainArray=domain.match(domainPat)
    if (domainArray==null) {
        alert("The domain name doesn't seem to be valid.")
        oEmailID.select();
        oEmailID.focus();
        return false
    }

    var atomPat=new RegExp(atom,"g")
    var domArr=domain.match(atomPat)
    var len=domArr.length
    if (domArr[domArr.length-1].length<2 || domArr[domArr.length-1].length>3) 
    {
       alert("The address must end in a three-letter domain, or two letter country.")
       oEmailID.select();
       oEmailID.focus();
       return false
    }

    if (len<2) 
    {
       var errStr="This address is missing a hostname!"
       alert(errStr)
       oEmailID.select();
       oEmailID.focus();
       return false
    }
    return true;
}

function Start(page) 
{
  OpenWin = this.open(page, "CtrlWindow", "toolbar=no,menubar=no,location=no,scrollbars=yes,resizable=yes,height=300,width=500,top=200,left=200,fullscreen=no");
}

var calPopup;
function initpage()
{
  calPopup = new CalendarPopup();
  calPopup.showYearNavigation();
}

var timePopup;
function initpage1()
{
  timePopup = new localizedate();
  //timePopup.showYearNavigation();
}


function frmsubmit(pageName)
{
  docref = document.frmmenu;
  docref.method="POST";
  docref.action=pageName;
  docref.submit();
}
function funcDivHeight(divName)
{
  divArray = new Array();
  divArray=divName.split(",");
 
  for(i=0;i<divArray.length;i++)
  { 
   
    if(document.getElementById(divArray[i]).scrollHeight>75)
    {     
     
      document.getElementById(divArray[i]).style.height='75px';
      document.getElementById(divArray[i]).style.overflow='auto';
    } 
    else 
    { 
      document.getElementById(divArray[i]).style.overflow='visible';
    }
  }
}

function openWindow(pageName)
{
  //handle=window.open(pageName,"CtrlWindow","top=75,left=100,height=400px,width=603px,toolbar=no,menubar=yes,status=yes,location=no,resizable=no,scrollbars=1");
  //handle.focus();
  window.open(pageName,"CtrlWindow","top=75,left=100,height=400px,width=603px,toolbar=no,menubar=no,status=yes,location=no,resizable=no,scrollbars=1");
 }
 
 function openReportWindow(pageName)
 {
   window.open(pageName,"CtrlWindow","top=85,left=100,height=400px,width=630px,toolbar=no,menubar=yes,status=no,location=no,resizable=yes,scrollbars=1");
 }
 

function funcFormSubmit(docref,pageName)
 {  
    docref.method="post";
    docref.action=pageName;
    docref.submit();
} 
function printlink()
{
  window.print();
}

function frmFocus(formName)
{   
  formName.focus();
}
function funcLocationReplace(url)
{
   location.replace(url);
}
function RetChar()
{
	return('<');
}
