          



function forward(Form,field) 
{ 
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

function selectDisable(Index,field1,field2,field3,field4,field6,field7,field8)
{
   var f = new Array(4);	
   var f1 = new Array(3);	
   var HomeDisabled;
   var PortDisabled;   
	f[0]=field1;
	f[1]=field2;
	f[2]=field3;
	f[3]=field4;

	f1[0]=field6;
	f1[1]=field7;
	f1[2]=field8;

   if(Index == "1")//home
   {
      	HomeDisabled = false;
      	PortDisabled = true;
   }	
   else if(Index == "2")//port
   {
      	HomeDisabled = true;
      	PortDisabled = false;
   }
 
   for(var i =0;i<4;i++)
   {
        f[i].disabled =  HomeDisabled;
   }      
   for(var i =0;i<3;i++)
   {
        f1[i].disabled =  PortDisabled;
   }      
   
  return;
}

function creditDisable(Index,field)
{
   if(Index == "1")//home or inport
   {
      	CreditDisabled = true;
   }	
   else if(Index == "2")//outport
   {
      	CreditDisabled = false;
   }
   field[0].disabled = CreditDisabled;
   field[1].disabled = CreditDisabled;   
   return;
}
