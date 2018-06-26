
////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For js set inputpolicy
// Create date：2000/9/15
// Update date：2000/9/18
////////////////////////////////////////////////////////

function setCur(field,fieldAmt,fieldPrm,fieldInv,fieldAmtCnm,fieldPrmCnm)
{
	var invc = field.value;
	var code = "";
	var name = "";
	
       if(invc == null)//for netscape
       {
	    invc = field.options[field.selectedIndex].value;
       }

	if(invc == "")
	 return;
	
	var i = invc.indexOf("&");
	code = invc.substring(0,i);
	name = invc.substring(i+1);
	i = name.indexOf("&");
	name = name.substring(i+1);	
	
	if(code != "01" && code != "02" && code != "03")   
	{
	  
	   fieldPrm.value = "03";
	   fieldPrmCnm.value = "美元";
	}
	else
	{
	   fieldPrm.value = code;     
	   fieldPrmCnm.value = name;        
	   
	}
	fieldAmt.value = code;                     
   	fieldInv.value = code;                     
	fieldAmtCnm.value = name;   	
  return;

}
function setPrm(fieldInv,fieldPrm,fieldtype)
{

   var invAmt = fieldInv.value; //发票
   var tranType = fieldtype.value;
   
   if(invAmt == "" || invAmt == null)
   {
      return;
   }   
   if(tranType == "B01" || tranType == "B02" )
   { 
      
	  
      invAmt = parseFloat(invAmt)*1.1;
      if(!isNaNcheck(fieldInv,invAmt))
      {
        return;
      }  

   }
   else
   {
      invAmt = parseFloat(invAmt);
      if(!isNaNcheck(fieldInv,invAmt))
      {
        return;
      }  
   }   
    nf.TEMPAMT1.value = invAmt;
	
	var amtstr =  nf.TEMPAMT1.value;
	var temp1="";
	if(amtstr == null)
	{
		amtstr = "0";
	}
	amtstr = TrimStr2(amtstr);
    xx = amtstr.valueOf();
	var i= amtstr.indexOf(".");
	if(i<=0){
	   fieldPrm.value= ""+xx;
	   return;
    }
	
	if(tranType=="B02"){	  
	  amstr =  ""+xx;  
	  if(i>0){	     
	     //xx = xx*1.0+0.005;		 
		 xx = xx*1.0+1;		 
		 temp1 =temp1+xx;		
		 fieldPrm.value= TrimLastZero(temp1.substring(0,i));
       }else{
	     fieldPrm.value= TrimLastZero(amtstr);
	   }
	   return; 
    }else{
	   xx = xx*1.0+ 0.005;	   
       amtstr = ""+xx;
	   if(amtstr.length>(i+3))
	   amtstr = amtstr.substring(0,i+3); 
	}    
	if(amtstr == "0")
	   amtstr = "";

	fieldPrm.value= TrimLastZero(amtstr);
     nf.TEMPAMT1.value = TrimLastZero(amtstr);
     //AmtDiv(fieldPrm,invAmt,nf.TEMPAMT1);
}
function setAmt(fieldPrm,fieldRate,fieldInv,fieldAmt)
{
    var Prm = fieldPrm.value;   //保额
    var Rate = fieldRate.value;  //费率
    var Exchange = fieldInv.value;//to devide 汇率
    var amt = 0;
    var code = "";
	//alert("set Amt:Prm"+ Prm +",Rate:"+ Rate +",Exchange:"+Exchange);
	    
    if (Prm != null && Prm != "")
    {
      Prm = parseFloat(Prm);
      if(!isNaNcheck(fieldPrm,Prm))
      {
        return;
      }  
    }
    else
    {return;}  
    
    if(Rate == null || Rate == "")
    {
       Rate = 0;  
    }
    else
    {
      Rate = parseFloat(Rate);
      if(!isNaNcheck(fieldRate,Rate))
      {
        return;
      }  
    }
    //dispose exchangerate is to be
    if(Exchange == null)//for netscape
    {
        Exchange = fieldInv.options[fieldInv.selectedIndex].value;
    }

   if(Exchange == "")
   {
    	Exchange = 1;
   }
   else
   {
	var i = Exchange.indexOf("&");
	code = Exchange.substring(0,i);	
	Exchange = Exchange.substring(i+1);
	i = Exchange.indexOf("&");
	Exchange = Exchange.substring(0,i);
   }

   if(code == "01" || code == "02" || code == "03")
   {
   	Exchange = 1;
   }
    amt = Prm*Rate*Exchange*0.01;//nate is 20%
  
//  fieldAmt.value = amt;
    
    nf.TEMPAMT.value = TrimLastZero(amt);
	
    AmtDiv(fieldAmt,amt,nf.TEMPAMT);
}
function SetRate(fieldPrm,fieldRate,fieldInv,fieldAmt){
   var Prm = fieldPrm.value;//保额
   //var Rate = fieldRate.value; //费率
    var Exchange = fieldInv.value;//to devide //币种
    //fieldAmt :保费
    var Amt = fieldAmt.value;

    var code = "";

    if (Prm != null && Prm != "")
    {
      Prm = parseFloat(Prm);
      if(!isNaNcheck(fieldPrm,Prm))
      {
        return;
      }
    }
    else
    {return;}

    if(Amt == null || Amt == "")
    {
       Amt = 0;
    }
    else
    {
      
      Amt = parseFloat(Amt);  
      
      if(!isNaNcheck(fieldAmt,Amt))
      {
        return;
      }
    }
    //dispose exchangerate is to be
    if(Exchange == null)//for netscape
    {
        Exchange = fieldInv.options[fieldInv.selectedIndex].value;
    }

   if(Exchange == ""|| Exchange == null)
   {
    	Exchange = 1;
   }
   else
   {
	var i = Exchange.indexOf("&");
	code = Exchange.substring(0,i);
	Exchange = Exchange.substring(i+1);
	i = Exchange.indexOf("&");
	Exchange = Exchange.substring(0,i);
   }

   if(code == "01" || code == "02" || code == "03")
   {
   	Exchange = 1;
   }
    //amt = Prm*Rate*Exchange*0.01;//nate is 20%
    if(Amt == 0){
      rate =0;
    }else{
     rate = Amt*100/(Prm*Exchange);
     
    }
    //alert("rate:"+rate);
    //fieldRate.value = rate;

    nf.TEMPAMT.value = rate;
    RateDiv(fieldRate,rate,nf.TEMPAMT);
}
function isNaNcheck(field,invAmt)
{
    var amt = field.value;
//    var valid = "-ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz%,<>/';:[]()&*!@#$&_+?";
    var valid = "0123456789.";
    var ok = "yes";
    var temp;
    for (var i=0; i<amt.length; i++) 
    {
        temp = "" + amt.substring(i, i+1);
        if (valid.indexOf(temp) == "-1")
        {
         ok = "no";
         break;
        } 
    }

      if(isNaN(invAmt) || ok == "no")
      {
        alert("金额/费率必须为数字");
        field.focus();
        return false;
       } 
   return true;
}
function setOldN_PRM(fieldPrm,N_PRM1_TEMP,fieldInv, OLD_PRM_CUR)
{
    var Prm = fieldPrm.value;   //旧保费
	var Exchange = fieldInv.value;//to devide 汇率(新的发票币种)
	var old_prm_cur = OLD_PRM_CUR.value; //(旧的保费币种) 
	 
    var amt = 0 ;
    var code = "";

    var oldcode = "";
	var oldexchange ="";

    Prm = parseFloat(Prm);
    
    if(Exchange == null)//for netscape
    {
        Exchange = fieldInv.options[fieldInv.selectedIndex].value;
    }

	if(old_prm_cur == Exchange)return; 

	var i = old_prm_cur.indexOf("&");
	oldexchange = old_prm_cur.substring(i+1);
	i = oldexchange.indexOf("&");
	oldexchange = oldexchange.substring(0,i);

	i = Exchange.indexOf("&");
	code = Exchange.substring(0,i);	
	Exchange = Exchange.substring(i+1);
	i = Exchange.indexOf("&");
	Exchange = Exchange.substring(0,i);
	if(code =="01" || code == "02"){
	   amt = (Prm*oldexchange)/(Exchange);
	   fieldPrm.value = amt;
	   N_PRM1_TEMP.value = amt;	   
	   OLD_PRM_CUR.value = fieldInv.value;
	}else{
	   amt = Prm*oldexchange;
	   fieldPrm.value = amt;
	   N_PRM1_TEMP.value = amt; 
       OLD_PRM_CUR.value = "03&1&美元";
	}
	return;
   
 
}
function setPrmChange(N_PRM,N_PRM1_TEMP,N_PRM1,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP)
{
   var n_prm = N_PRM.value;
   var n_prm1 = N_PRM1.value;
   N_PRM2.value = n_prm; 
   n_prm = n_prm.valueOf();
   n_prm1 = n_prm1.valueOf();
   //alert("new n_prm:"+n_prm);
   //alert("old n_prm:"+n_prm1);
   N_PRM_VAR.value = TrimStr2(n_prm-n_prm1);
   //alert("N_PRM_VAR.value:"+N_PRM_VAR.value);
   N_PRM_VAR_TEMP.value = TrimStr2(n_prm-n_prm1);
   var change = 0 ;
   if(n_prm == n_prm1){
     change = 0;
	 N_PRM_CHANGE.value = 0;//TrimLastZero(change);
	 N_PRM_CHANGE_TEMP.value = 0;//TrimLastZero(change) ;   
   }else{
	   change = n_prm-n_prm1;
	   if(change<0) change = 0 - change ;
	   //alert("change:"+change);
       change = change/n_prm1 *100;
       change = change*1.0 +0.00005;    
	   str = change+"";
       i = str.indexOf(".");
       str = str.substring(0,i+5);	   
	   N_PRM_CHANGE.value = TrimLastZero(str);	   
	   N_PRM_CHANGE_TEMP.value = TrimLastZero(str);
   }
   
}
function AmtDiv(field,amtPara,field1)
{
    
	var amtstr =  field1.value;
	if(amtstr == null)
	{
		amtstr = "0";
	}
	
    xx = amtstr.valueOf();
    xx = xx*1.0+ 0.005;
    amtstr = ""+xx ;
    var i = amtstr.indexOf(".");
    if(amtstr.length>(i+3))
    amtstr = amtstr.substring(0,i+3);

	if(amtstr == "0")
	   amtstr = "";

	  field.value=TrimLastZero(amtstr);
}
function RateDiv(field,amtPara,field1){
   var amtstr =  field1.value;
	if(amtstr == null)
	{
		amtstr = "0";
	}  
   xx = amtstr.valueOf();   
   
   if(xx!=0){
    xx = xx*1.0+ 0.000000005;
    amtstr = ""+xx ;
    var i = amtstr.indexOf(".");
    if(i>0)
    amtstr = amtstr.substring(0,i+9);
   }else{
     amtstr=0;
   }

	//if(amtstr == "0")
	//   amtstr = "";
	   field.value= TrimLastZero(amtstr);

}
function TrimLastZero(xx){
      str = ''+xx;
	  if(str.indexOf('.')<0)return str;
      while(''+str.charAt(str.length-1)=='0'){
	    str= str.substring(0,str.length-1);
	  }	 
	  if(str.charAt(str.length-1)=='.'){
	    str= str.substring(0,str.length-1);
	  } 
	  return str;
}
function TrimStr2(str)
{
    
	var amtstr =  str;
	if(amtstr == null)
	{ amtstr = "0";	 return amtstr;}	
    xx = amtstr.valueOf();	    
    amtstr = ""+xx ;		
    var i = amtstr.indexOf(".");
	if(i<0)return amtstr;
	if(amtstr.indexOf("-")>=0){	  
	  xx = xx*1.0 -0.005;
	}else{
	 xx = xx*1.0+ 0.005;
    }

	amtstr = ""+xx ;	
    if(amtstr.length>(i+3))
    amtstr = amtstr.substring(0,i+3);

	if(amtstr == "0"){
	   return amtstr;
	}
	amtstr = TrimLastZero(amtstr);
	return amtstr;
}




