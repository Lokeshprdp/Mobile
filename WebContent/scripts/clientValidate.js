/***************************************************************************************************************
*       File Name   : ClientValidate.js                                                                        *        
*       Created On  : 06/04/2004                                                                               *    
*       Description : This file Contains the functions to perform client side validation                       *    
***************************************************************************************************************/
var renamemustpat=/^[A-Za-z]+$/;
var renamepat=/^[A-Za-z]+$/;
var renamespacepat=/^[A-Za-z ]+$/;
var realphanumericpat=/^[A-Za-z0-9 ]+$/;
var alphanumericpatnozero=/^[A-Za-z1-9]+[A-Za-z0-9 ]+$/;
var renamecommapat=/^[A-Za-z]+[A-Za-z\, ]+$/;
var ressnopat =/^\d{4}$/;
var rephonepat =/^\d[\d- ]+\d$/;
var faxpat =/^\d{8,}$/;
var faxpat1=/^[\d- ]+[\d ]$/;
var numhyphen=/^([0-9]+)([-])([0-9]+)$/;
var rephonecodepat =/^\d{3,}$/;
var reemailpat = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,4}))$/;
var usernamepat=/^\S{6,}$/;
var userpwdpat=/^\S{8,}$/;
var optSelectedPat=/^[^0][0-9a-zA-Z]*$/;
var nospacepat=/^\S+$/;
var notnullpat=/\w/; 
var intpat=/^[1-9]+\d*$/;
var phonepat1=/^[1-9]+[0-9\,]+\d*$/;
var integerpat=/^[0-9]+\d*$/;
var timepat=/^(([0]?[0-5][0-9]|[0-9]):([0-5][0-9]))$/;
var timesecpat=/^(([0]?[0-5][0-9]|[0-9]):([0-5][0-9]):([0-5][0-9]))$/;
var floatpat=/(^\d*\.?\d*[1-9]+\d*$)|(^[1-9]+\d*\.\d*$)/;
var floatzeropat=/(^\d*\.?\d*[0-9]+\d*$)|(^[0-9]+\d*\.\d*$)/;
var rephonenullpat=/^(\d[\d- ]+\d){0,1}$/;
var reemailnullpat = /^((([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,4}))){0,1}$/;

// This is for getting Current Date

var month1,date1,fulldate; 
var curDate=new Date();
date2="";
month1=curDate.getMonth()+1;
date1=curDate.getDate();
if(month1<10)
{	
	fulldate=curDate.getYear()+"-"+"0"+month1;
}	
else
	fulldate=curDate.getYear()+"-"+month1;

if(date1<10)
	fulldate=fulldate+"-"+"0"+date1;
else
	fulldate=fulldate+"-"+date1;
	
curDate=fulldate;

function check_text_date(InpDateObj)
{
var InpDate=InpDateObj.value;
if(InpDate == "")
{
	alert("Enter the Date field. \n Please enter date in this format (dd-mm-yyyy).");
	InpDateObj.focus();
	return false;
}
else
{
      if(InpDate.length < 10) 
      {
         alert("Enter Correct Date.\n Please enter date in this format (dd-mm-yyyy).")
         InpDateObj.focus();
     	 return false;
      }
      else if(InpDate.length > 10)
      {
         alert("Enter Correct Date.\n Please enter date in this format (dd-mm-yyyy).")
         InpDateObj.focus();
     	 return false;
      }
      else
      {
      	// 
		mon_var=InpDate.substring(0,2);
		delimit1=InpDate.substring(2,3);
		date_var=InpDate.substring(3,5);
		year_var=InpDate.substring(5,10);
		InpDate=date_var+delimit1+mon_var+year_var;
		
		
        InpVal = InpDate;
        SendNext = "False";
        PrevSlash = "";
        LastSlash = "";
        for(i = 0;i <= InpDate.length-1;i++)
        {
          PrevSlash = LastSlash;
          LastSlash = InpDate.substring(i,i+1);
            if((LastSlash == '-' && i == 0 ))
            {
                alert("Your Date Format is incorrect. \n Please enter date in this format (dd-mm-yyyy).");
                 InpDateObj.focus();
                return false;
                 break;    
            }
          	if ( LastSlash == '-' && PrevSlash == '-' )
            {
                alert("Your Date Format is incorrect. \n Please enter date in this format (dd-mm-yyyy).");
                 InpDateObj.focus();
                return false;
                 break;
            }
          	else 
            {
                if (LastSlash == '-') 
                SendNext = "True";
            } 
       } 
    if (SendNext == "True") 
        {
            lBool="False";
            LMonth="False";
            LDate="False";
            var OutVal;
            var InVal;
            var RoundYear;
            var Mon;
            var LastSlashNumber;
            var j;
            var k;
            var x;
            x = InpDate;
            OutVal="";
            TotVal="";
            LastSlashNumber=0;
            for(i = 0;i <= x.length-1;i++) 
               {
                  LastSlash = x.substring(i,i+1);
                  if (LastSlash != 0 && LastSlash != 1 && LastSlash != 2 && LastSlash != 3 && LastSlash != 4 && LastSlash != 5 && LastSlash != 6 && LastSlash != 7 && LastSlash != 8 && LastSlash != 9 && LastSlash != '-') //fifth if
                    {
                        lBool="True";
                        break;
                    }
                  else 
                    {
                      if (LastSlash == '-' || LastSlashNumber == 2 ) //sixth if
                          {
                            InVal = OutVal;
                            if (InVal == '0' || InVal == '00' || InVal == '0000') //seventh if
                                {
                                    alert("You entered Some Zero's in the field(Month/Date/Year). \n Please enter date in this format (dd-mm-yyyy).")
                                     InpDateObj.focus();
                                    return false;
                                    break;
                                }
                                TotVal = TotVal+InVal
                                OutVal="";
                                   if (LastSlashNumber == 0)
                                    {
                                        LastSlashNumber  = LastSlashNumber + 1;
                                        Mon = InVal;
                                        if (InVal > 12)
                                            {
                                                LMonth ="True";
                                                InVal="";
                                                break;
                                            }
                                    }
                               else
                                    {
                                           if(LastSlashNumber == 1)
                                            {
                                                Dat = InVal;
                                                LastSlashNumber  = LastSlashNumber + 1;
                                                if(Mon == '01' || Mon == '1' || Mon == '03' || Mon == '3' || Mon == '05' || Mon == '5' || Mon == '07' || Mon == '7' || Mon == '08' || Mon == '8' || Mon == '10' || Mon == '12')
                                                    {
                                                          if (InVal > 31)
                                                            {
                                                                  LDate ="True";
                                                                   InVal="";
                                                                  break;
                                                            }
                                                    }
                                                else
                                                       {
                                                        if(Mon == '04' || Mon == '4' || Mon == '06' || Mon == '6' || Mon == '09' || Mon == '9' || Mon == '11')
                                                           {
                                                                if (InVal > 30)
                                                                    {
                                                                          LDate ="True";
                                                                           InVal="";
                                                                          break;
                                                                    }
                                                            }        
                                                          }
                                            }
                                    else
                                        {
                                            if(LastSlashNumber == 2 )
                                                   {
                                                    LastSlashNumber = LastSlashNumber + 1;
                                                    lYear = x.substring(TotVal.length+2,x.length);
                                                    if(lYear == '0000')
                                                        {
                                                            alert("You entered Some Zero's in the field(Month/Date/Year).\n Please enter date in this format (dd-mm-yyyy).")
	                                                         InpDateObj.focus();
                                                            return false;                        
                                                        }
                                                    else
                                                        {
                                                            if(lYear.length <= 3 )
                                                                {
                                                                    alert("Enter Four digits for Year. \n Please enter date in this format (dd-mm-yyyy).");
                                                                     InpDateObj.focus();
                                                                    return false;
                                                                    break;
                                                                }
                                                            else
                                                                {
                                                                       if(lYear.length > 4 )
                                                                        {
                                                                            alert("Enter Four digits for Year.\n Please enter date in this format (dd-mm-yyyy).");
                                                                             InpDateObj.focus();
                                                                            return false;
                                                                            break;
                                                                        }
                                                                       else
                                                                        {
                                                                             RoundYear = Math.round(lYear/4); 
                                                                             if (lYear/4 != RoundYear) 
                                                                                {
                                                                                    if(Mon == 2 && Dat > 28 )
                                                                                        {
                                                                                            alert("You entered More than 28 in the date field (it's not a leap year)");
                                                                                             InpDateObj.focus();
                                                                                            return false;
                                                                                            break;
                                                                                        }
                                                                                    else
                                                                                    {
                                                                                    //alert("Entered Date is Correct");
                                                                                    return true;
                                                                                    }
                                                                                   }
                                                                            else
                                                                                   {
                                                                                    if(Mon == 2 && Dat > 29)
                                                                                        {
                                                                                            alert("You entered More than 28 in the date field/month is febraury");
                                                                                             InpDateObj.focus();
                                                                                            return false;
                                                                                            break;
                                                                                        }
                                                                                    else
                                                                                        {
                                                                                        //alert("Entered Date is Correct");
                                                                                        return true;
                                                                                        }
                                                                                   }
                                                                        }
                                                                }
                                                           }
                                                }    
                                                else
                                                {
                                                //alert("Entered Date is Correct");
                                                return true;
                                                }
                                            }
                                       }
                                }
                                       else
                                        OutVal=OutVal + LastSlash;
                            }
                        }
                    }
            else
                {
                    alert("Your Date format is incorrect. \n Please enter date in this format (dd-mm-yyyy).");
                     InpDateObj.focus();
                    return false;
                }
             }
    }
    
    if (lBool == "True")
        {
            alert("You entered some alpha value in the Date field. \n Please enter date in this format (dd-mm-yyyy).");
             InpDateObj.focus();
            return false;
        }
    else
        {
            if (LMonth == "True")
                {
                    alert("Your Month is invalid. \n Please enter date in this format (dd-mm-yyyy).");
                     InpDateObj.focus();
                    return false;
                }
            else
                {
                    if (LDate == "True")
                        {
                            alert("Your Date is invalid. \n Please enter date in this format (dd-mm-yyyy).");
                             InpDateObj.focus();
                            return false;
                        }
                    else
                        {
                        //alert("Entered Date is Correct");
                        return true;
                        }
                }
        }
        

}

// date may be null or if it is entered it should be date
function check_text_datenull(InpDateObj)
{
	var InpDate=InpDateObj.value;
	if(InpDate != "")
	{
		return check_text_date(InpDateObj);	  	
	}
}	


//Function to check the field is empty.If there is no data true is returned else false is returned.     
function checkFieldEmpty(FieldData,cntErrField)
{
    if(FieldData.length) 
    {
        return false;
    }   
    else
    {
        cntErrField.value="";
        return true;
    }
}


function checkFieldDataClient(cntField,errorMsg,patname)
{
	//alert(inside);
	
   if(!(patname.test(trim(cntField.value))))
    {
        if(tagName!='0')
        {  
            tableArray = new Array();
            tableArray=tagArray.split(",");
            for(i=0;i<tableArray.length;i++)
            { 
                
                if(tableArray[i] == tagName)
                {     
                   document.getElementById(tableArray[i]).style.display="block";
                  
                } 
                else 
                { 
                  
                   document.getElementById(tableArray[i]).style.display="none";
                  
                }
             }//for           
         }
         //alert(errorMsg);
         
         //cntField.value="";
         cntField.focus();
         return false;
    }   
    else
    {   
        return true;
    }
}
function checkTabDivContent(divName,textAreaName,errorMsg,patname,tagName,tagArray)
{   
  divHTML=trim(document.getElementById(divName).innerHTML);
  divTEXT=trim(document.getElementById(divName).innerText);
  
  if(!(patname.test(divHTML)) || (!trim(divTEXT).length))
  {
        if(tagName!='0')
        {   
            tableArray = new Array();
            tableArray=tagArray.split(",");
            for(i=0;i<tableArray.length;i++)
            { 
               if(tableArray[i] == tagName)
                {     
                  document.getElementById(tableArray[i]).style.display="block";
                } 
                else 
                { 
                   document.getElementById(tableArray[i]).style.display="none";
                }
             }//for           
        }
        alert(errorMsg);
        document.getElementById(divName).focus();
        document.getElementById(divName).innerHTML="";
        return false;
  }
  else
  {
    textAreaName.innerText=divHTML;
    return true;
  }
}
function checkClientData(cntField,fieldName,patname)
{  
    if(!(patname.test(trim(cntField.value))))
    {
        strmessage= "Please enter valid " + fieldName ; 
        alert(strmessage);
       // cntField.value="";
        cntField.focus();
        return false;
    }   
    else
    {
        return true;
    }   
}
function checkCurdate(dateField,errorMsg1,patname,errorMsg2)
{ 
	//alert(curDate);	
  	//alert("From Date"+dateField.value);  
  	  if(!(patname.test(trim(dateField.value))))
	  {
	    alert(errorMsg2);
	    dateField.focus();
	    return false;
	  }
  
  
  currentDate = Date.UTC(curDate.substr(0,4),curDate.substr(5,2)-1,curDate.substr(8,2));  
  frmDate=dateField.value;
  frmDate=Date.UTC(frmDate.substr(6,4),frmDate.substr(3,2)-1,frmDate.substr(0,2)); 
  if(frmDate > currentDate)
  {
    alert(errorMsg1);
    dateField.focus();
    return false;
  }
  else
  {
    return true;    
  }
}

function checkFinYearDate(dateField,errorMsg,finYearDate)
{ 
    var VoucherDate=dateField.value;
    var vcyrsubstring=VoucherDate.substr(8,2);	
    var vcmonthsubstring=VoucherDate.substr(3,2); 
    var financialyr = finYearDate.value;
    fiyr1=financialyr.substr(0,2);	
    fiyr2=financialyr.substr(3,2);	
    var flag=0;

    if( vcyrsubstring ==  fiyr1)
    {
        if(Number(vcmonthsubstring) < 4) // SHOULD NOT BE LESS THAN APRIL
        {
            alert(errorMsg);
            dateField.focus();
            flag = 1;
            return false;
        }
    }
    else if( vcyrsubstring ==  fiyr2)
    {
        if(Number(vcmonthsubstring) > 3) // SHOULD NOT BE GREATER THAN MARCH
        {
            alert(errorMsg);
            dateField.focus();
            flag = 1;
            return false;
        }
    }
    else
    {
        alert(errorMsg);
        dateField.focus();
        flag = 1;
        return false;
    }
   
    if(flag==0)
    {
        return true;
    }
}

function checkDivContent(divName,textAreaName,errorMsg,patname)
{   
  divHTML=trim(document.getElementById(divName).innerHTML);
  divTEXT=trim(document.getElementById(divName).innerText);
  
  if(!(patname.test(divHTML)) || (!trim(divTEXT).length))
  {
    alert(errorMsg);
    document.getElementById(divName).focus();
    document.getElementById(divName).innerHTML="";
    return false;
  }
  else
  {
    textAreaName.innerText=divHTML;
    return true;
  }
}

function checkDivContentFields(divName,textAreaName)
{   
  divHTML=trim(document.getElementById(divName).innerHTML);
  divTEXT=trim(document.getElementById(divName).innerText);
  
    textAreaName.innerText=divHTML;
    return true;
}

function checkCurdateLess(dateField,errorMsg1,patname,errorMsg2)
{
  if(!(patname.test(trim(dateField.value))))
  {
    alert(errorMsg2);
    dateField.focus();
    return false;
  }
  //var curDate=new Date();
  currentDate = Date.UTC(curDate.substr(0,4),curDate.substr(5,2)-1,curDate.substr(8,2));  
  
  frmDate=dateField.value;
  frmDate=Date.UTC(frmDate.substr(6,4),frmDate.substr(3,2)-1,frmDate.substr(0,2)); 
  if(frmDate < currentDate)
  {
    alert(errorMsg1);
    dateField.focus();
    return false;
  }
  else
  { 
    return true;    
  }
}
function comparCurdate(dateField,errorMsg1,patname,errorMsg2)
{
  if(!(patname.test(trim(dateField.value))))
  {
    alert(errorMsg2);
    dateField.focus();
    return false;
  }
  //var curDate=new Date();
  currentDate = Date.UTC(curDate.substr(0,4),curDate.substr(5,2)-1,curDate.substr(8,2));  
  frmDate=dateField.value;
  frmDate=Date.UTC(frmDate.substr(6,4),frmDate.substr(3,2)-1,frmDate.substr(0,2)); 
  if(frmDate > currentDate)
  {
    alert(errorMsg1);
    dateField.focus();
    return false;
  }
  else
  {
    return true;    
  }
}

function checkTabCurdateLess(dateField,errorMsg1,patname,errorMsg2,tagName,tagArray)
{
  tableArray = new Array();
  tableArray=tagArray.split(",");
  if(!(patname.test(trim(dateField.value))))
  {
    if(tagName!='0')
    {   
         
          for(i=0;i<tableArray.length;i++)
          { 
             if(tableArray[i] == tagName)
              {     
                document.getElementById(tableArray[i]).style.display="block";
              } 
              else 
              { 
                 document.getElementById(tableArray[i]).style.display="none";
              }
           }//for           
    }
    alert(errorMsg2);
    dateField.focus();
    return false;
  }
  //var curDate=new Date();
  currentDate = Date.UTC(curDate.substr(0,4),curDate.substr(5,2)-1,curDate.substr(8,2));  
  frmDate=dateField.value;
  frmDate=Date.UTC(frmDate.substr(6,4),frmDate.substr(3,2)-1,frmDate.substr(0,2)); 
 
  if(frmDate < currentDate)
  {
      if(tagName!='0')
      {   

        for(i=0;i<tableArray.length;i++)
        { 
           if(tableArray[i] == tagName)
            {     
              document.getElementById(tableArray[i]).style.display="block";
            } 
            else 
            { 
               document.getElementById(tableArray[i]).style.display="none";
            }
         }//for           
      }
      alert(errorMsg1);
      dateField.focus();
      return false;
  }
  else
  {
    return true;    
  }
}


// Function for comparing two dates
function checkDates(dateField1,dateField2,errorMsg)
{
  frmDate=dateField1.value;
  frmDate=Date.UTC(frmDate.substr(6,4),frmDate.substr(3,2)-1,frmDate.substr(0,2)); 
  toDate=dateField2.value;
  toDate=Date.UTC(toDate.substr(6,4),toDate.substr(3,2)-1,toDate.substr(0,2)); 
  if(frmDate > toDate)
  {
    alert(errorMsg);
    dateField2.focus();
    return false;
  }
  else
  {
    return true;    
  }
}

// Function to compare two dates- from date and to date
function checkTodateLess(dateField1,dateField2,patname,errorMsg1)
{
  frmDate=dateField1.value;
  frmDate=Date.UTC(frmDate.substr(6,4),frmDate.substr(3,2)-1,frmDate.substr(0,2)); 
  toDate=dateField2.value;
  toDate=Date.UTC(toDate.substr(6,4),toDate.substr(3,2)-1,toDate.substr(0,2)); 
  if(frmDate > toDate)
  {
    alert(errorMsg1);
    dateField2.focus();
    return false;
  }
  else
  {
    return true;    
  }
}

function dateDiff(D1,D2,interval,errorMsg) 
{
 D1Arr=D1.value.split('-');
 D2Arr=D2.value.split('-')
 d1=new Date(D1Arr[2],D1Arr[1]-1,D1Arr[0])
 d2=new Date(D2Arr[2],D2Arr[1]-1,D2Arr[0])

 if((Math.floor(d2.getTime()-d1.getTime())/(1000*3600*24)+1) != interval.value) 
 {
  alert(errorMsg);
  return false;
 }  
 else
 {
  return true;
 }
}

function dateDiffLess(D1,D2,interval,errorMsg) 
{
  D1Arr=D1.value.split('-')
  D2Arr=D2.value.split('-')
  d1=new Date(D1Arr[2],D1Arr[1]-1,D1Arr[0])
  d2=new Date(D2Arr[2],D2Arr[1]-1,D2Arr[0])
  
  if((Math.floor(d2.getTime()-d1.getTime())/(1000*3600*24)+1) < interval.value) 
  {
    alert(errorMsg);
    return false;
  }  
  else
  {
    return true;
  }
}

//Function for comparing dates with time
function dateTimeDiff(D1,D2,errorMsg,patname)
{
  if(!(patname.test(trim(D1.value))))
  {
    alert(errorMsg);
    D1.focus();
    return false;
  }
  if(!(patname.test(trim(D2.value))))
  {
    alert(errorMsg);
    D2.focus();
    return false;
  }
  
  D1Arr=D1.value.split(" ");
  D2Arr=D2.value.split(" ");
  
  D1Date=D1Arr[0];
  D1Time=D1Arr[1];
  
  D2Date=D2Arr[0];
  D2Time=D2Arr[1];
  
  D1DateArr=D1Date.split('-');
  D1TimeArr=D1Time.split(':');
  
  D2DateArr=D2Date.split('-');
  D2TimeArr=D2Time.split(':');
  
  d1=Date.UTC(D1DateArr[2],D1DateArr[1]-1,D1DateArr[0],D1TimeArr[0],D1TimeArr[1],D1TimeArr[2]);
  d2=Date.UTC(D2DateArr[2],D2DateArr[1]-1,D2DateArr[0],D2TimeArr[0],D2TimeArr[1],D2TimeArr[2]);

  if(d2<=d1)
  {
    alert(errorMsg);
    return false;
  }
  else
  {
    return true;
  }
}

