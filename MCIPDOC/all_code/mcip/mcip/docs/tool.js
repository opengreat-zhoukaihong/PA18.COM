
////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Function£ºFor js tool
// Create date£º2000/10/18
// Update date£º2000/10/18
////////////////////////////////////////////////////////

function forward(Form,field,field1,flag) 
{ 
 
  if(flag =="0")	
  {
  if(field1.value=="")	
    return;
  }  
  field.value="rep";
  Form.submit();
  return;
}
function sub(field) 
{ 
  field.value="sub";
  return;
}
function ChgAction(Form,Str)
{
	Form.action=Str;
	return;
}
function setField(field,Str)
{
	field.value = Str;
	return;
}
//for List selection:policyList,agencylist,opencoverList
function selectNo(field,Index)
{
//	alert("oh,you successful");
	field.options[Index].selected = true;
	return;
}
//for operation select

//function selectDisable(Index,field1,field2,field3,field4,field6,field7,field8)
function selectDisable(Index,fieldtran,field1,field2)
{
   var f = new Array(4);	
   var f1 = new Array(3);	
   var HomeDisabled;
   var PortDisabled;   
/*	f[0]=field1;
	f[1]=field2;
	f[2]=field3;
	f[3]=field4;

	f1[0]=field6;
	f1[1]=field7;
	f1[2]=field8;
*/
//   if(Index == "1")//home
    if(fieldtran[0].checked)
   {
      	HomeDisabled = false;
      	PortDisabled = true;
   }
   else //if(Index == "2")//port
   {
      	HomeDisabled = true;
      	PortDisabled = false;
   }
   for(var i =0;i<4;i++)
   {
        field1[i].disabled =  HomeDisabled;
   }      
   for(var i =0;i<3;i++)
   {
        field2[i].disabled =  PortDisabled;
   }      
   
  return;
}

function creditDisable(Index,field1,field)
{
  if(field1[2].checked)
   {
      	CreditDisabled = false;
   }
   else
   {
         CreditDisabled = true;
   }

   field[0].disabled = CreditDisabled;
   field[1].disabled = CreditDisabled; 

   return;
}

//for province and city sellect
function changeCity(fieldProv,fieldCity)
{
   if(fieldProv.value == "")	
      return;
 index = fieldProv.options.selectedIndex-1;
// index = fieldProv.options.selectedIndex;
 fieldCity.length = city[index].length;
 for(var i = 0;i<city[index].length;i++)
  {
   var text = city[index][i].split("-");
   fieldCity.options[i].text = text[0];
   fieldCity.options[i].value =text[1];
  }
  
  return;
}

function editCity(fieldProv,fieldCity)
{
   if(fieldProv.value == "")	
      return;
 index = fieldProv.options.selectedIndex;
 fieldCity.length = city[index].length;
 for(var i = 0;i<city[index].length;i++)
  {
   var text = city[index][i].split("-");
   fieldCity.options[i].text = text[0];
   fieldCity.options[i].value =text[1];
  }
  
  return;
}

//for find(ply and plyapp) interface control
function PlyDisable(fieldPlyCh,field2Ply)
{
   var PlyDisabled;

   PlyDisabled = !(fieldPlyCh.checked);
   field2Ply.disabled = PlyDisabled;
   
   return;
}

function DateDisable(fieldDtCh,field1,field2,field3,field4,field5,field6)
{
   var f = new Array(6);	
   var DtDisabled;   

   f[0]=field1;
   f[1]=field2;
   f[2]=field3;
   f[3]=field4;
   f[4]=field5;
   f[5]=field6;

   DtDisabled = !(fieldDtCh.checked);
   for(var i =0;i<6;i++)
   {
        f[i].disabled =  DtDisabled;
   }      
   
  return;
}

function PlyDisableNew(fieldOption,fieldply,field1,field2,field3,field4,field5,field6)
{
   var f = new Array(6);	
   var PlyDisabled = false;
   var DtDisabled = false;   

   f[0]=field1;
   f[1]=field2;
   f[2]=field3;
   f[3]=field4;
   f[4]=field5;
   f[5]=field6;

   if(fieldOption[0].checked)
   {
	PlyDisabled = false
	DtDisabled = true;   
   }
   else if(fieldOption[1].checked)
   {
	PlyDisabled = true;
	DtDisabled = false;   
   }
   else
   {
	PlyDisabled = true;
	DtDisabled = true;   
   }

   fieldply.disabled = PlyDisabled;
   for(var i =0;i<6;i++)
   {
        f[i].disabled =  DtDisabled;
   }      
   
  return;
}
//add by zlx 2000/10/27

function DisableTwo(fieldDtCh,field1,field2)
{
   var f = new Array(2);	
   var DtDisabled;   

   f[0]=field1;
   f[1]=field2;

   DtDisabled = !(fieldDtCh.checked);
   for(var i =0;i<2;i++)
   {
        f[i].disabled =  DtDisabled;
   }      
   
  return;
}

function DisableTwelve(fieldDtCh,field1,field2,field3,field4,field5,field6,field7,field8,field9,field10,field11,field12)
{
	DateDisable(fieldDtCh,field1,field2,field3,field4,field5,field6);
	DateDisable(fieldDtCh,field7,field8,field9,field10,field11,field12);
	return;
}


//end add by zlx 2000/10/27

//FOR agentList.jsp while select inputpolicy directly
function setAgency(field,field1,field2)
{
        var agencyOrg = field.value;
        
    if(agencyOrg == null)    //for netscape optionselect
    {
    	agencyOrg = field.options[field.selectedIndex].value;
    }
        
        var agencyMain;
        var agencyAdd;
        if(agencyOrg == "")
           return;
           
        var i = agencyOrg.indexOf("&");
	agencyMain = agencyOrg.substring(0,i);
	agencyAdd = agencyOrg.substring(i+1);
	i = agencyAdd.indexOf("&");
	agencyAdd = agencyAdd.substring(i+1);

        field1.value = agencyMain;
        field2.value = agencyAdd;

        return;
}
function SetSelectedCity(C_CITY,selectedCity){
   //alert(C_CITY);
   index = C_CITY.options.selectedIndex;
   //alert("setselectedcity:"+index);   
   selectedCity.value = C_CITY.options[index].value;   
   //alert("selectedCity.value:"+selectedCity.value);
}
function setSelectedIndex(C_CITY,selectedCity){
   value = selectedCity.value;
   len =  C_CITY.options.length;   
   if(selectedCity.length==0 || len==1){
     C_CITY.options.selectedIndex = 0;
	 //alert("case 1 set index");
	 return;
   }
   for(i=1 ;i <len ;i++){
      if(selectedCity.value== C_CITY.options[i].value){
	    // alert("selected index:"+i);
	     C_CITY.options.selectedIndex = i;
		 return;
	  }
   }   
   
}

