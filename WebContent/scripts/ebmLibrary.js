/***************************************************************************************************************
*       File Name   : ebmLibrary.js                                                                *        
*       Created On  : 19/04/2004                                                                               *    
*       Description : This file Contains the functions that are common to this Application                        *    
***************************************************************************************************************/

//(formName,Length of ChBox,CtrlName where unselected val is to be placed,ChkBoxName)

 	
 function funcRemoveModel(docref,chkLength,listVal,chkCtrlName)
 {   
   
   var val='';
   var count; 
   count= eval(docref+'.'+chkLength).value;
   
   chkBox=eval(docref+'.'+chkCtrlName);
   
   for (var i = 0; i < count; i++)
   {
     if (count==1) 
     {
          if (!chkBox.checked)   
          {
           val=val+chkBox.value ;
          } 
     } 
     else if (!(chkBox[i].checked))
     { 
          val=val+chkBox[i].value ;
     }   
     if (i<count-1)
     { 
          if (val !='')
          { 
                if (!(chkBox[i+1].checked))
                {
                  val=val+',';
                }
           }
      }
    }//for
  
   eval(docref+'.'+listVal).value=val;
   funcFinal();
 }
 
//(formName,Length of ChBox,CtrlName where unselected val is to be placed,ChkBoxName)
 function funcRemoveProcess(docref,chkLength,listVal,chkCtrlName)
 { 
     var val='';
     var count; 
     count= eval(docref+'.'+chkLength).value;
     chkBox=eval(docref+'.'+chkCtrlName);
     for (var i = 0; i < count; i++)
     {
       if (count==1) 
       {
            if (chkBox.checked)   
            {
             val=val+chkBox.value ;
            } 
       } 
       else if ((chkBox[i].checked))
       { 
            val=val+chkBox[i].value ;
       }
       if (i<count-1)
       { 
            if (val !='')
            { 
                  if ((chkBox[i+1].checked))
                  {
                    val=val+',';
                  }
             }
        }
      }//for
     eval(docref+'.'+listVal).value=val;
     funcFinal();
 }

 function windowClose()
 {
   opener.parent.location.reload();
   self.close();
 }

function removeList(frmName,count,listVal,chkCtrlName)
{
  var val='';
  checkBox=eval(frmName+'.'+chkCtrlName);
  for (var i=0;i<count;i++)
  {
    if (count==1) 
    {
      if (!checkBox.checked)   
      {
        val=val+checkBox.value ;
      } 
    } 
    else if (!(checkBox[i].checked))
    { 
      val=val+checkBox[i].value ;
    }
    if (i<count-1)
    { 
      if (val !='')
      { 
        if (!(checkBox[i+1].checked))
        {
          val=val+',';
        }
      }
    }
  } // eof forloop
  eval(frmName+'.'+listVal).value=val;
  alert(eval(frmName+'.'+listVal).value);
  funcFinal();
}


// popup form name,Parent Form Name,Ctrl Name containing Chk Box Length,Ctrl in Parent where val is to be placed,ChBox Name
function  funcSelectListPopUp(docFrmName,parentFrmName,chkLength,listVal,chkCtrlName)
{   
   
   var val='';
   var count;
   var fanseq=""; 
   
   /*alert(docFrmName);
   alert(parentFrmName);
   alert(chkLength);
   alert(listVal);
   alert(chkCtrlName);
   */  
   
   
   count= eval(docFrmName+'.'+chkLength).value;
   chkBox=eval(docFrmName+'.'+chkCtrlName);
   winopen = eval('window.opener.document.'+parentFrmName);
   
  //alert(count);
    if (count==1)
    {
      if (chkBox.checked)
       { 
        val=val+chkBox.value ;
       }
    }
    else
    {
      for (var i = 0; i < count; i++)
      {
      	 // alert(val);	
          if (chkBox[i].checked)
          { 
                if(parentFrmName=="frmAddQuote" || parentFrmName=="frmEditQuote")
                {
                   fanseq+=Number(i+1)+" ";
                }
                val=val+chkBox[i].value ;
          }
          //alert(val);
          if (i<count-1)
          {
             if (val !='')
             { 
               if (chkBox[i+1].checked)
               {
                 val=val+',';
                 fanseq=fanseq+",";
               }
              }
          }
       }//end of for
     }//end of else
    if(val=="")
     {
          alert("Please select atleast one and then proceed");
          return false;
     }
    //alert(parentFrmName+"  frm");
    if(parentFrmName=="frmAddQuote") 
    {
        if(listVal=="fanModelList")
            if(winopen.document.getElementById("fanSequenceNos"))
                winopen.document.getElementById("fanSequenceNos").value=fanseq;
    }
    //alert(listVal); 
    //alert(val);
    //alert(winopen.document.getElementById(listVal).value);
     winopen.document.getElementById(listVal).value=val;
    // alert(winopen.document.getElementById(listVal).value);
     
     funcFinal();
      
  }
function showTab(tabClicked,greyArray,blueArray,tableName)
 { 
 	//alert("here");
      tabGreyArray = new Array();
      tabGreyArray=  greyArray.split(',');  
      
      tabBlueArray = new Array();
      tabBlueArray=  blueArray.split(',');  
      
      tableArray = new Array();
      tableArray=  tableName.split(',');  
      
      for (i=0;i< tabGreyArray.length;i++)
      {  
         //alert(tabGreyArray.length);
         //alert(document.getElementById(tabGreyArray[i]).name);
         //alert(tabClicked);
         if(document.getElementById(tabGreyArray[i]).name == tabClicked)
         {  
             document.getElementById(tabGreyArray[i]).style.display="none";
             document.getElementById(tabBlueArray[i]).style.display="block";
             document.getElementById(tableArray[i]).style.display="block";
             
         } 
         else
         {
              
              document.getElementById(tabBlueArray[i]).style.display="none";
              document.getElementById(tabGreyArray[i]).style.display="block";
              document.getElementById(tableArray[i]).style.display="none";
             
         }
      } 
      
   }

//funcRemoveItemFromList('frmEditOrder','deliveryListLen','deliveryList','checkDeliveryNo',4)
 function funcRemoveItemFromList(docref,chkLength,listVal,chkCtrlName,issubmit)
 {
  
  
   //alert("here");
   var val='';
   var count; 
   // alert(chkLength);
   count= eval(docref+'.'+chkLength).value;
   chkBox=eval(docref+'.'+chkCtrlName);
  // alert(count);
  for (var i = 0; i < count; i++)
   {     
    if (count==1) 
     {
          if (!chkBox.checked)   
          {
           val=val+chkBox.value ;
          } 
     } 
     else if (!(chkBox[i].checked))
     { 
          val=val+chkBox[i].value ;
     }
     if (i<count-1)
     { 
            //alert(i+"i");
            //alert(count+"count");
          if (val !='')
          { 
                if (!(chkBox[i+1].checked))
                {
                  val=val+',';
                }
           }
      }
    }//for
    
   eval(docref+'.'+listVal).value=val; 
   //alert(val);
   funcFinal(issubmit);
   
 }
 
 
 //select the list and concat it the values already in the parent window
function  funcSelectListPopUpConcat(docFrmName,parentFrmName,chkLength,listVal,chkCtrlName)
 {   
    
    var val='';
    var count;
    var existList;
  /* alert(docFrmName);
    alert(parentFrmName);
    alert(chkLength);
    alert(listVal);
    alert(chkCtrlName);*/
   
    count= eval(docFrmName+'.'+chkLength).value;
    
    chkBox=eval(docFrmName+'.'+chkCtrlName);
    
    winopen = eval('window.opener.document.'+parentFrmName);    
    existList=winopen.document.getElementById(listVal).value;    
    if (count==1)
     {
       if (chkBox.checked)
        { 
         val=val+chkBox.value ;
        }
     }
     else
     {
       for (var i = 0; i < count; i++)
       {
           if (chkBox[i].checked)
            { 
                val=val+chkBox[i].value ;
            }
           if (i<count-1)
            {
              if (val !='')
              { 
                if (chkBox[i+1].checked)
                {
                  val=val+',';
                }
               }
             }
        }//end of for
      }//end of else
     if(val=="")
      {
           alert("Please select one and then proceed");
           return false;
      } 
     
     if (existList!="")
       {val= existList+","+val;}
     winopen.document.getElementById(listVal).value=val;
     
     funcFinal();
  }
  
  
  function  funcSelectList(docFrmName,chkLength,listVal,chkCtrlName)
  {   
     var val='';
     var count;
    
     count= eval(docFrmName+'.'+chkLength).value;
     chkBox=eval(docFrmName+'.'+chkCtrlName);
     
     if (count==1)
      {
        if (chkBox.checked)
         { 
          val=val+chkBox.value ;
         }
      }
      else
      {
        for (var i = 0; i < count; i++)
        {
            if (chkBox[i].checked)
             { 
                 val=val+chkBox[i].value ;
             }
            if (i<count-1)
             {
               if (val !='')
               { 
                 if (chkBox[i+1].checked)
                 {
                   val=val+',';
                 }
                }
              }
         }//end of for
       }//end of else
      if(val=="")
       {
            alert("Please select one and then proceed");
            return false;
       } 
     
      
       objListVal=eval(docFrmName+'.'+listVal);
       objListVal.value=val;
       //alert(val);
       funcFinal();
  }
  

    /* code which makes the ctrls (input / div) readonly based on the radio(/checkbox)
       which is checked.
       Document name,ctrlName,input ctrl list,div list.
       If any of the ctrls are not present 0 is passed
     */  
  
 function funcReadOnly(docref,ctrlNam,indexId,ctrlInputList,ctrlDivList,ctrlComboList,imgList,ctrlRadioList)
 {
	
    if(eval(docref+'.'+ctrlNam+'['+indexId+']').checked)
      {
         if(ctrlInputList != 0)
          {
              ctrlInputArray=new Array();
              ctrlInputArray=ctrlInputList.split(',');
              ctrlInputLen=ctrlInputArray.length;
              
              for(var i=0;i<ctrlInputLen;i++)
              {
                document.getElementById(ctrlInputArray[i]).readOnly=false;
              }
          }
          if(ctrlDivList != 0)
          {
             ctrlDivArray=new Array();
             ctrlDivArray=ctrlDivList.split(',');
             ctrlDivLen=ctrlDivArray.length;
             for(var i=0;i<ctrlDivLen;i++)
             {
              
               document.getElementById(ctrlDivArray[i]).contentEditable=true;
               
               
             }
          }
          if(ctrlComboList != 0)
          {
             ctrlComboArray=new Array();
             ctrlComboArray=ctrlComboList.split(',');
             ctrlComboLen=ctrlComboArray.length;
             for(var i=0;i<ctrlComboLen;i++)
             {
               document.getElementById(ctrlComboArray[i]).disabled=false;
             }
          }
          if(imgList != 0)
          {  
             imgArray=new Array();
             imgArray=imgList.split(',');
             imgLen=imgArray.length;
             for(var i=0;i<imgLen;i++)
             {
               document.getElementById(imgArray[i]).style.display="block";
             }
          }
          
           if(ctrlRadioList != 0)
            {
               ctrlRadioArray=new Array();
               ctrlRadioArray=ctrlRadioList.split(',');
               ctrlRadioLen=ctrlRadioArray.length;
               var ctrlName;
               for(var i=0;i<ctrlRadioLen;i++)
               {
                
                 ctrlName="";
                 ctrlLen=eval(docref+'.'+ctrlRadioArray[i]).length;
                 ctrlName=eval(docref+'.'+ctrlRadioArray[i]);
                 for(var j=0;j<ctrlLen;j++)
                 {   
                     ctrlName[j].disabled=false;
                 }
               }
            }
         
     
      }
     else
     {
        
     	
        if(ctrlInputList != 0)
         {
             ctrlInputArray=new Array();
             ctrlInputArray=ctrlInputList.split(',');
             ctrlInputLen=ctrlInputArray.length;
            
             for(var i=0;i<ctrlInputLen;i++)
             {
              
              eval(docref+'.'+ctrlInputArray[i]).readOnly=true;
             }
         }
         if(ctrlDivList != 0)
         {
            ctrlDivArray=new Array();
            ctrlDivArray=ctrlDivList.split(',');
            ctrlDivLen=ctrlDivArray.length;
            
            for(var i=0;i<ctrlDivLen;i++)
            {
             document.getElementById(ctrlDivArray[i]).contentEditable=false;
            
             
            }
         }
         if(ctrlComboList != 0)
         {
            ctrlComboArray=new Array();
            ctrlComboArray=ctrlComboList.split(',');
            ctrlComboLen=ctrlComboArray.length;
            for(var i=0;i<ctrlComboLen;i++)
            {
              document.getElementById(ctrlComboArray[i]).disabled=true;
             
            }
          }
          if(imgList != 0)
          {
             imgArray=new Array();
             imgArray=imgList.split(',');
             imgLen=imgArray.length;
             for(var i=0;i<imgLen;i++)
             {
               document.getElementById(imgArray[i]).style.display="none";
             }
          }
        if(ctrlRadioList != 0)
        {
           ctrlRadioArray=new Array();
           ctrlRadioArray=ctrlRadioList.split(',');
           ctrlRadioLen=ctrlRadioArray.length;
           var ctrlName;
           for(var i=0;i<ctrlRadioLen;i++)
           {

             ctrlName="";
             ctrlLen=eval(docref+'.'+ctrlRadioArray[i]).length;
             ctrlName=eval(docref+'.'+ctrlRadioArray[i]);
             for(var j=0;j<ctrlLen;j++)
             { 
                 ctrlName[j].disabled=true;
             }
           }
        }
          
     }
  
 }
  
//Rounds the value with 2 decimal point  
function funcRound(val)
{
  val = Math.round(Number(val) * 100 );
  var strVal = val.toString();
  var strlen = strVal.length;
  var finalVal = "";
  
  if (strlen <= 2)//then it is a decimal part(because val * 100)
  {
    finalVal = finalVal + ".";
  } 
  //Position of dot
  var dot = strlen - 3;
  var counter = 0;
  while (counter < strlen )
  {
      finalVal = finalVal + strVal.charAt(counter);
      if (counter == dot)
      { 
        finalVal = finalVal + ".";
      }  
      counter = counter + 1;
  }
  return finalVal;
}  


function funcRoundThreeDigits(val)
{
  val = Math.round(Number(val) * 1000 );
  finalVal=Number(val)/1000;
  
  return finalVal;
} 

function fnMoveCursor(index,txtCtrlName,countCtrlName)
{		
	// Included By Anitha on, Thursday, February 02, 2006 -To move cursor in forward and reverse direction while pressing up,down arrow keys. 
	
	if(event.keyCode==40)//Down-arrow -To move cursor to next text ctrl.
	{
		if(index<document.getElementById(countCtrlName).value)
		{				
			document.getElementById(txtCtrlName+(index+1)).focus();	
		}
	}
	else if(event.keyCode==38)// Up-arrow-To move cursor to previous text ctrl.  
	{
		if(index>1)
		{
			document.getElementById(txtCtrlName+(index-1)).focus();	
		}	
	}
}


