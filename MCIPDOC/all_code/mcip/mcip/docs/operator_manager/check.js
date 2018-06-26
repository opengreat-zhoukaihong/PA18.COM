
var MsgBufSize=50;
var Message = new Array(MsgBufSize);

Message[0]="输入只能包含字母或数字。";
Message[1]="输入只能包含数字0-9。";
Message[2]="输入日期格式错误。";
Message[3]="请输入介于 01 到 12 的月份值。";
Message[4]="请输入介于 01 到 31 的日期值。";
Message[5]="该月没有 31 天。";
Message[6]="该年并非闰年,二月只有 28 天。";
Message[7]="输入时间格式错误。";
Message[8]="请输入介于 01 到 12 的小时值。";
Message[9]="请选择时间输入格式 确定 = Standard Time, 取消 = Military Time。";
Message[10]="必须输入 AM 或 PM。 ";
Message[11]="不需要对于 military time 时间格式输入 AM 或 PM。";
Message[12]="请输入介于 00 到 59 的分钟值。";
Message[13]="请输入介于 00 到 59 的秒钟值。";
Message[14]="带*号的为必须输入,不能为空。";
Message[15]="时间输入值不能为空。";
Message[16]="时间长度为6位。";
Message[17]="输入不能包含如-:=,&;`'\".*&^%$#@!~|\?<>{}[]() 等字符。";
Message[18]="输入不能为0。";
Message[19]="首字必须为字母;其他字符为字母或数字。";
Message[20]="不能同时为空。";
Message[21]="不能同时输入。";
Message[22]="删除,是否确定?";
Message[23]="此参数需大于零。";
Message[24]="两次输入的密码不相同。";
Message[25]="请重新检查输入域--";

Message[26]="发票号和提单号不能同时输入。";
Message[27]="发票号和提单号不能同时为空。";
Message[28]="请输入介于 00 到 23 的小时值。";
Message[29]="Email地址输入错误";
Message[30]="电话或传真号码只能包含数字或-()";
Message[31]="请至少选择一种与货运类型对应的运输方式";

////////////////////////////////////////////////////////
Message[32]="金额/费率必须为数字";
Message[33]="费率是0~1的两位小数";
Message[34]="只能为实数";
Message[35]="修改投保单需要选择投保单号";
Message[36]="填写起运通知书需要选择OpenCover协议号";

Message[37]="年份是四位数字";
Message[38]="开航日期不能早于录入日起两天";

Message[39]="查询建议书需要选择投保单号";
Message[40]="根据代理协议投保需要选择投代理协议协议号";
Message[41]="请至少选择一种查询条件";
Message[42]="请输入介于 00 到 24 的值。";
Message[43]="请输入介于 00 到 60 的值。";
///////////////////////////////
//开航日期不能早于录入日起两天
//////////////////////////////
function ValidDateBegin(field,Str,field1)
{
	var beg = field.value;
	if(beg < Str)
	{
	    alert(Message[38]);
            field1.focus();
            return false;	
		
	}
	return true;
}

////////////////////////////////////////////////////////
// 验证日期,and foucus field
////////////////////////////////////////////////////////
function ValidDateNew(field,field1) 
{
	if(!ValidDate(field))
	{
		field1.focus();
		return false;
	}
     return true;
}	

/////////////////////////
//验证年
////////////////////////
function ValidYear(field)
{
  if ((!ValidInt(field)) ||  (field.value.length!=4) || (field.value=="0000"))
  {
    alert(Message[37]);
        field.focus();
        return false;	
  }	
  return true;
	}
///////////////////////
//验证月
////////////////////////
function ValidMonth(field)
{
   if (!ValidInt(field) || field.value.length != 2 || field.value > 12 || field.value=="00")
  {
    alert(Message[3]);
        field.focus();
        return false;	
  }	
  return true;
	}

////////////////////////
//验证日
////////////////////////
function ValidDay(field)
{
 if (!ValidInt(field) || field.value.length != 2 || field.value > 31 || field.value=="00")
  {
    alert(Message[4]);
        field.focus();
        return false;	
  }	
  return true;	
	}
////////////////////////////

////////////////////////
//验证时
////////////////////////
function ValidHour(field)
{
 if (!ValidInt(field) || field.value.length != 2 || field.value > 24)
  {
    alert(Message[42]);
        field.focus();
        return false;	
  }	
  return true;	
	}
////////////////////////////
////////////////////////
//验证分,秒
////////////////////////
function ValidMinute(field)
{
 if (!ValidInt(field) || field.value.length != 2 || field.value > 60)
  {
    alert(Message[43]);
        field.focus();
        return false;	
  }	
  return true;	
	}
////////////////////////////

function ValidAmt(field)
{
    var amt = field.value;

    var valid = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    var ok = "yes";
    var temp;
    for (var i=0; i<amt.length; i++) {
        temp = "" + amt.substring(i, i+1);
        if (valid.indexOf(temp) != "-1")
        {
         ok = "no";
         break;
        } 
    }
    if (ok == "no") {
        alert(Message[32]);
        field.focus();
        return false;
    }

    
    if (amt != null && amt != "")
    {
      amt = parseFloat(amt);
      if(isNaN(amt))
      {
        alert(Message[32]);
        field.focus();
        return false;
       } 
    }
    
    return true;
}   
function ValidRate(field) 
{
    if(!ValidAmt(field))
	return false;
    var amt = field.value;	   
    if (amt != null && amt != "")
    {
      amt = parseFloat(amt);
      if(amt <0 || amt > 1)    	
      {
        alert(Message[33]);
        field.focus();
        return false;
       } 
         
    }
    return true;    
}

////////////////////////////////////////////////////////
// 显示报警消息正文
////////////////////////////////////////////////////////
function Refocus(field){
    field.focus();
    if (field.type=="text")
    {
        field.select();
    }
}

function DspAlert(field,msg){
    Refocus(field);
    alert('\n'+Message[25]+'\n'+msg);
}

function DspAlertHidden(field,msg){
    alert('\n'+Message[25]+'\n'+msg);
}

function DAlert(field,msg){
//    var temp;	
    Refocus(field);
//    temp=Schelmttl(field.name);        
    alert('\n'+msg);
}

////////////////////////////////////////////////////////
// 验证是否为空   
////////////////////////////////////////////////////////
function ValidNull(field,AllowNull) 
{
	var str = field.value;

    if(str == null)    //for netscape optionselect
    {
    	str = field.options[field.selectedIndex].value;
    }

    if(str == "")
    {
        DspAlert(field,Message[14]);
        return false;
    }

    return true;
}
////////////////////////////////////////
//For email address check
////////////////////////////////////////
function ValidEmail(field)
{

   	if ((field.value.indexOf("@") < 1) || (field.value.indexOf(".") < 1))
   	{
	        DspAlert(field,Message[29]);
	        return false;
   		
   	}
   	return true;
 
}

////////////////////////////////////////////////////////
// 验证电话或传真：仅包含数字或-()
////////////////////////////////////////////////////////
function ValidTel(field) {
    var valid = "0123456789-()";
    var ok = "yes";
    var temp;
    for (var i=0; i<field.value.length; i++) {
        temp = "" + field.value.substring(i, i+1);
        if (valid.indexOf(temp) == "-1") ok = "no";
    }
    if (ok == "no") {
        DspAlert(field,Message[30]);
        return false;
    }
    return true;
}

////////////////////////////////////////////////////////
// 验证仅包含字母与数字
////////////////////////////////////////////////////////
function ValidKey(field) {
    var valid = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    var ok = "yes";
    var temp;
    for (var i=0; i<field.value.length; i++) {
        temp = "" + field.value.substring(i, i+1);
        if (valid.indexOf(temp) == "-1") ok = "no";
    }
    if (ok == "no") {
        DspAlert(field,Message[0]);
        return false;
    }
    return true;
}

////////////////////////////////////////////////////////
// 验证第一个为字母,其他为字母与数字
////////////////////////////////////////////////////////
function ValidId(field) {
    var firstvalid = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    var valid = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";    
    var ok = "yes";
    var temp;
    
    if (firstvalid.indexOf(field.value.substring(0, 1))=="-1") 
       {ok = "no"}
    else 
       {
          for (var i=0; i<field.value.length; i++) {
              temp = "" + field.value.substring(i, i+1);
              if (valid.indexOf(temp) == "-1") ok = "no";
          }
       }   
    if (ok == "no") {
        DspAlert(field,Message[19]);
        return false;
    }
    return true;
}


////////////////////////////////////////////////////////
// 验证不包含特殊保留字的字符串,可以输入中文
////////////////////////////////////////////////////////
function ValidInvaKey(field) {
    var invalid = ":-=,&;`.*&^%$#@!~|\?<>{}[]'\"()"
    var find = "no";
    var temp;
    for (var i=0; i<field.value.length; i++) {
        temp = "" + field.value.substring(i, i+1);
        if (invalid.indexOf(temp) != -1) find = "yes";
    }
    if (find == "yes") {
        DspAlert(field,Message[17]);
        return false;
    }
    return true;
}

////////////////////////////////////////////////////////
// 验证零
////////////////////////////////////////////////////////
function ValidZero(field) {
    if (field.value == 0) {
        DspAlert(field,Message[18]);
        return false;
    }
    return true;
}


////////////////////////////////////////////////////////
// 验证仅包含数字
////////////////////////////////////////////////////////
function ValidInt(field) {
    var valid = "0123456789";
    var ok = "yes";
    var temp;
    for (var i=0; i<field.value.length; i++) {
        temp = "" + field.value.substring(i, i+1);
        if (valid.indexOf(temp) == "-1") ok = "no";
    }
    if (ok == "no") {
       DspAlert(field,Message[1]);
       return false;       
    }
    return true;
}

//////////////////////
//////////////////////
function  change(field1,field2,field3,field)
{
	var month = field2.value;
	var day = field3.value;	
	if(month.length < 2)
	   month="0"+month;
	if(day.length < 2)
	   day="0"+day;
  
  field.value=field1.value+"-"+month+"-"+day;
  
//  field.value=field1.value+"-"+field2.value+"-"+field3.value;
  return true;  
}


////////////////////////////////////////////////////////
// 验证日期
////////////////////////////////////////////////////////
function ValidDate(field) {
// Checks for the following valid date formats:
// YY/MM/DD   YYYY/MM/DD   YY-MM-DD   YYYY-MM-DD
// Also separates date into month, day, and year variables

    var datePat = /^(\d{2}|\d{4})(\-)(\d{1,2})(\-)(\d{1,2})$/;
// To require a 4 digit year entry, use this line instead:
    var dateStr=field.value;
    var matchArray = dateStr.match(datePat); // is the format ok?
    if (matchArray == null) {
        DspAlertHidden(field,Message[2]);
        return false;
    }
    year = matchArray[1]; // parse date into variables
    month = matchArray[3];
    day = matchArray[5];

    if (year.length!=4 || month.length!=2 || day.length!=2) {
        DspAlertHidden(field,Message[2]);
        return false;
    }

    if (month < 1 || month > 12) { // check month range
        DspAlertHidden(field,Message[3]);
        return false;           
    }
    if (day < 1 || day > 31) {
        DspAlertHidden(field,Message[4]);
        return false;           
    }

    if ((month==4 || month==6 || month==9 || month==11) && day==31) {
        DspAlertHidden(field,Message[5]);
        return false;           
    }
    if (month == 2) { // check for february 29th
        var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        if (day>29 || (day==29 && !isleap)) {
            DspAlertHidden(field,Message[6]);
            return false;                       
        }
    }
    return true;  // date is valid
}

	
////////////////////////////////////////////////////////
// 验证时间(12)
////////////////////////////////////////////////////////
function ValidTimeFmt(field) {
// Checks if time is in HH:MM:SS AM/PM format.
// The seconds and AM/PM are optional.

    var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
    var timeStr=field.value;
    var matchArray = timeStr.match(timePat);
    if (matchArray == null) {
        DspAlert(field,Message[7]);
        return false;           
    }
    hour = matchArray[1];
    minute = matchArray[2];
    second = matchArray[4];
    ampm = matchArray[6];

    if (second=="") { second = null; }
    if (ampm=="") { ampm = null }


    if (hour.length!=2 || minute.length!=2 || (second!=null && second.length!=2)) {
        DspAlert(field,Message[7]);
        return false;
    }
    
    if (hour < 0  || hour > 23) {
        DspAlert(field,Message[8]);
        return false;           
    }
    if (hour <= 12 && ampm == null) {
        if (confirm(Message[9])) {
            DspAlert(field,Message[10]);
            return false;                       
        }
    }
    if (hour > 12 && ampm != null) {
        DspAlert(field,Message[11]);
        return false;           
    }
    if (minute<0 || minute > 59) {
        DspAlert(field,Message[12]);
        return false;           
    }
    if (second != null && (second < 0 || second > 59)) {
        DspAlert(field,Message[13]);
        return false;           
    }
    return true;
}

////////////////////////////////////////////////////////
// 验证报表日期格式  
////////////////////////////////////////////////////////
function ValidYearMonth(field) {
// Checks for the following valid date formats:
//   YYYYMM
// Also separates date into month, day, and year variables

// To require a 4 digit year entry, use this line instead:
    var dateStr=field.value;
    
    if (dateStr == null||dateStr==""){
       DspAlert(field,Message[15]);
           return false;
    }
        if(isNaN(dateStr)){
          DspAlert(field,Message[1]);
          return false;
        }
        if (dateStr.length!=6){
       DspAlert(field,Message[16]);
           return false;
    }
     year=dateStr.substring(0,4);
         month=dateStr.substring(4,6);

    if (month < 1 ||  month > 12){  
        DspAlert(field,Message[3]);
            return false;               
    }
    return true;  // date is valid
}

////////////////////////////////////////////////////////
// 验证时间(24)
////////////////////////////////////////////////////////
function ValidTime(field) {
// Checks if time is in HH:MM:SS format.

    var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))$/;
    var timeStr=field.value;
    var matchArray = timeStr.match(timePat);
    if (matchArray == null) {
        DspAlert(field,Message[7]);
        return false;           
    }
    hour = matchArray[1];
    minute = matchArray[2];
    second = matchArray[4];


    if (second=="") { second = null; }


    if (hour.length!=2 || minute.length!=2 || (second!=null && second.length!=2)) {
        DspAlert(field,Message[7]);
        return false;
    }
    
    if (hour < 0  || hour > 23) {
        DspAlert(field,Message[28]);
        return false;           
    }

    if (minute<0 || minute > 59) {
        DspAlert(field,Message[12]);
        return false;           
    }
    if (second != null && (second < 0 || second > 59)) {
        DspAlert(field,Message[13]);
        return false;           
    }
    return true;
}


////////////////////////////////////////////////////////
// 验证大小比较
////////////////////////////////////////////////////////
function ValidRange(field,Lower,Higher) {

    if (field.value>=Lower && field.value<=Higher){
        return true;
    }
    else {
        DspAlert(field,"输入值大小必须介于 ["+Lower+"] 与 ["+Higher+"] 之间。");
        return false;
    }
}

////////////////////////////////////////////////////////
// 验证范围
////////////////////////////////////////////////////////
function ValidLength(field,Lower,Higher) {

    var len=field.value.length;
    if (len>=Lower && len<=Higher){
        return true;
    }
    else {
        DspAlert(field,"输入值长度必须介于 ["+Lower+"] 与 ["+Higher+"] 间。");
        return false;        
    }
}



////////////////////////////////////////////////////////
// 验证定长数字字符串
////////////////////////////////////////////////////////
function ValidNumLen(field,Lower,Higher,AllowNull) {
    if (!ValidNull(field,AllowNull)){
        return false;
    }

    if (!ValidInt(field)){
        return false;
    }

    if (!ValidLength(field,Lower,Higher)){
        return false;
    }
    return true;
}


////////////////////////////////////////////////////////
// 验证定大小范围数字字符串
////////////////////////////////////////////////////////
function ValidNumRng(field,Lower,Higher,AllowNull) {
    if (!ValidNull(field,AllowNull)){
        return false;
    }

    if (!ValidInt(field)){
        return false;
    }

    if (!ValidRange(field,Lower,Higher)){
        return false;
    }
    return true;
}

////////////////////////////////////////////////////////
// 验证定长字符串
////////////////////////////////////////////////////////
function ValidKeyLen(field,Lower,Higher,AllowNull) {
    if (!ValidNull(field,AllowNull)){
        return false;
    }

    if (!ValidKey(field)){
        return false;
    }

    if (!ValidLength(field,Lower,Higher)){
        return false;
    }
    return true;
}


//The special:
////////////////////////////////////////////////////////
// 验证口令
////////////////////////////////////////////////////////
function ValidOprPsw(field,AllowNull) {
    if (field.value.length==0 && AllowNull){
        return true;
    }

    if (!ValidNull(field,AllowNull)){
                return false;
    }

    if (!ValidKey(field)){
        return false;
    } 
    
    if (!ValidLength(field,1,8)){
        return false;
    }
    return true;
}




////////////////////////////////////////////////////////
// 验证密码相同
////////////////////////////////////////////////////////
function ValidSame(field1,field2) {
    if (field1.value!=field2.value){
        DspAlert(field2,Message[24]);                
        return false;
    }
    return true;
}



function ValidNoOrReal(field1,field2)
{
	if(field1.value.length==0 && field2.value.length==0)
	{
		DAlert(field1,Message[27]);
		return false;
	}
	if(field1.value.length!=0 && field2.value.length!=0)
	{
		DAlert(field1,Message[26]);
		return false;
	}
}




////////////////////////////////////////////////////////
// 确认是否删除
////////////////////////////////////////////////////////
function ConfirmDelGrp()
{

    if (!confirm(Message[22])) {
        return false;
    }

    return true;    
}
 
 
 
//------------------------------------------------------------------
/******************************************************/
/******************************************************/
////////////////////////////////////////////////////////
// 验证不能输入
////////////////////////////////////////////////////////
function BeNull(field) 
{
	// field 有值时出错
  if ((field.value != null)&&(field.value != ""))
  {
    DspAlert(field,"此参数不能输入");
    return false;
  }
	// field 无值时对
  return true;
}

//special for operationselect
function check(field,field1,field2,field3,field4,field6,field7,field8)
{
   var f = new Array(4);	
   var f1 = new Array(3);	

	f[0]=field1;
	f[1]=field2;
	f[2]=field3;
	f[3]=field4;

	f1[0]=field6;
	f1[1]=field7;
	f1[2]=field8;
	
   var flag = 0;
   if(field[0].checked)//home transt
   {
     for(var i =0;i<4;i++)
     {
         if(f[i].checked)	
         {
         	flag = flag + 1;
         }   
     }
   }    
   else//portTransit
   {
     for(var i =0;i<3;i++)
     {
         if(f1[i].checked)	
         {
         	flag = flag + 1;
         }   
     }

   }

   if(flag < 1)
   {
          alert(Message[31]);
          return false;

    }
    return true;
}
//for plyfind
function IsChecked(field)
{
  if (field.checked)
  {return false;}
  else
  {return true;}
}
function IsCheckedBox(field)
{
	if(IsChecked(field))
	   DspAlert(field,Message[41]);
	
}
//for policylist
function setField(field,Str)
{
	field.value = Str;
	return;
}
//for agentList select & openCoverList select
function checkFieldNull(field,Strflag)
{ 
   var str = field.value;

   if(str == null)//for netscape
   {
       str = field.options[field.selectedIndex].value;
   }
   
   if(str == "")
   {
      //alert("修改投保单需要选择投保单号");
      //field.focus();
      if(Strflag == "0")
      {
         DAlert(field,Message[35]);
      }
      else if(Strflag == "1")
      {
         DAlert(field,Message[36]);      	
      }   
      else if(Strflag == "2")
      {
         DAlert(field,Message[39]);      	
      }   
      else if(Strflag == "3")
      {
         DAlert(field,Message[40]);      	
      }   

      return false;
   }    
   return true;
}
