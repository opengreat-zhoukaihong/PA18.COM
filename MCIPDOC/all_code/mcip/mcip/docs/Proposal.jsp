<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>


<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>

<%
    String Result[][] = ob.getTempTwo();
    String OperType = (String)request.getAttribute("OPER_TYPE");
	/**add by kangjin for sending c_undr_prsn purpose 2001-09-13*/	
	String c_undr_prsn = (String)request.getAttribute("c_undr_prsn");
	/** end of add*/
    String RemoteOperType = ob.getRemoteOperType();
    String RemoteData[][] = ob.getRemoteData();        
    boolean IsRemote = false;
    int XmlResult= 0;    
    String[] RMB = Const.RMB;
    String ClientType = sessionbuffer.getClientType(Locate);

	boolean previewDisabled = false;
	int i= 0;

	String AgencyNo = request.getParameter("AGENCYNO");
	if(AgencyNo == null)AgencyNo = "";
	String PlyNo = request.getParameter("C_PLY_NO");
	String edrAppInfo[] =null;
	if(AgencyNo.equals(Const.EDRSMTAPP)){
	     edrAppInfo = ob.getTempOne();
		 String tempOne[] = new String[3];
		 for(int p=0 ; p< edrAppInfo.length; p++)
		   	 tempOne[p]= edrAppInfo[p];
         ob.setTempOne(tempOne);
		 String[] tempparas = Servlets.DivideMultiStr(edrAppInfo[0],"&");
		 edrAppInfo[0] = tempparas[0];
	}
    if(RemoteOperType.equals(Const.REMOTE_PRP) || RemoteOperType.equals(Const.REMOTE_PLY))
    {
       IsRemote = true;
    }

     int c_rtrn_cde = Objects.getColNum("c_rtrn_cde",Result);    //flag
     int c_doc_no = Objects.getColNum("c_doc_no",Result);
     int c_ply_app_no = Objects.getColNum("c_ply_app_no",Result);
     int c_ply_no = Objects.getColNum("c_ply_no",Result);
     int n_rate = Objects.getColNum("n_rate",Result);
     int c_no_repay = Objects.getColNum("c_no_repay",Result);
     int c_undr_cndtn = Objects.getColNum("c_undr_cndtn",Result);
     int c_remark = Objects.getColNum("c_remark",Result);
     int n_sum_prm= Objects.getColNum("n_sum_prm",Result);
     int c_prm_cur= Objects.getColNum("c_prm_cur",Result);

      String RateValue = Result[1][n_rate];

     if(!(RateValue.equals("")))
     {
       double Irate = Double.parseDouble(RateValue);
       Irate = Irate*100 ;
       RateValue = String.valueOf(Irate);
     //by kangjin//RateValue = RateValue.substring(0,RateValue.indexOf(".")+3);
	   RateValue = new java.math.BigDecimal(new Double(RateValue).doubleValue()).setScale(4,java.math.BigDecimal.ROUND_HALF_UP).toString();
     }
String policyInfo[][] =null;      
//add by rao 4/15/2001
if(AgencyNo.equals(Const.EDRSMTAPP)){
 
  try{
    pmb.setFormPara(4,edrAppInfo);
  }catch(NormalException e){   
      if(NormalExceptionHandler.IsSevere(e)){				  
	 	             throw NormalExceptionHandler.Handle(e);
         }else if(NormalExceptionHandler.IsWarning(e)){				  
					 WarnMsg = e.getErrDesc();
         } 
  }
      Hashtable valuesTable = new Hashtable(100);
	  Object obj = (Object)pmb.plyEdrAppInfo;
      Class c = obj.getClass();
      Field[] fields =c.getFields();
      String fieldName ="";
	  String fieldValue="";
      for ( i = 0; i < fields.length; i++) {
        try{
            fieldName = fields[i].getName();
            fieldValue=(c.getField(fieldName).get(obj)).toString();
            //System.out.print(i+":"+fieldName+":\t"+fieldValue+"\n");
			if(fieldName!=null && fieldValue!=null)valuesTable.put(fieldName, fieldValue);
          }catch(Exception e){
              throw NormalExceptionHandler.Handle(e);      
         }
      }

      obj = (Object)pmb.plyEdrAppCrgoInfo;
      c = obj.getClass();
	  fields =c.getFields();

	  for ( i = 0; i < fields.length; i++) {
        try{
            fieldName = fields[i].getName();
            fieldValue=(c.getField(fieldName).get(obj)).toString();
            //System.out.print(i+":"+fieldName+":\t"+fieldValue+"\n");
			if(fieldName!=null && fieldValue!=null)valuesTable.put(fieldName, fieldValue);
          }catch(Exception e){
              throw NormalExceptionHandler.Handle(e);      
         }
      }
	  String paras[][]= new String[2][valuesTable.size()];
	  Enumeration ee = valuesTable.keys();
	  i =0 ;
	  while(ee.hasMoreElements()){
		  String key = (String)ee.nextElement();
		  paras[0][i] = key;
		  paras[1][i] = (String)(valuesTable.get(key));
		  i++;
		}
		if(paras!=null)previewDisabled = true;
		try
        {
	       ob.setFormData(paras);
        }
        catch(NormalException e)
        {
		  previewDisabled = false;
        }


}else{		
//end by rao
//kangjin 2001-4-10

      try
      {
        pb.setFieldValue(Const.GET_POLICYAPPINFO,Result[1][c_doc_no]);
        policyInfo = pb.getRetValueArra();
		ob.setFormData(policyInfo); 
      }
      catch(NormalException e)
      {
		policyInfo = null;	    
      }
	  
}	 

    //Add by rao 2001/04/15
	if(AgencyNo.equals(Const.EDRSMTAPP)){
		String edrAppInfos[] = ob.getTempOne();
		String tranType = edrAppInfos[2];
		String forwardPage="LocalPolicyView.jsp";
		if(!(tranType.equalsIgnoreCase(Const.C_IMPORT_CDE) || tranType.equalsIgnoreCase(Const.C_EXPORT_CDE)))
		  {              		   tranType = Const.C_HOME_CDE;		  }
         if (tranType.equals(Const.C_IMPORT_CDE))//进口货运
		 forwardPage= "ImportPolicyView.jsp";
	     if (tranType.equals(Const.C_EXPORT_CDE))//出口货运
		      forwardPage= "ExportPolicyView.jsp";	      
	    out.println("<script language=JavaScript>");
	    out.println("function Preview(theForm){  theForm.action = \""+forwardPage+"\";  theForm.submit();}");
	    out.println("</script>");
	 }
     
	//add by rao 2001/04/15
		String insuranceID = "";
	  String clientAddInfo[] = sessionbuffer.getClientAddInfo(Locate);
  	  String orgID = clientAddInfo[4];
	  if (policyInfo != null){
	  String tranType = policyInfo[1][Objects.getColNum("C_INSRNC_CDE ",policyInfo)];
	  insuranceID = tranType;
	  String forwardPage="LocalPolicyView.jsp";//default for local
	  if (tranType.equals(Const.C_IMPORT_CDE))//进口货运
		forwardPage= "ImportPolicyView.jsp";
	  if (tranType.equals(Const.C_EXPORT_CDE))//出口货运
		forwardPage= "ExportPolicyView.jsp";
	 // if (tranType.equals(Const.C_HOME_CDE))//国内货运
		//forwardPage= "LocalPolicyView.jsp";
	  out.println("<script language=JavaScript>");
	  out.println("function Preview(theForm){  theForm.action = \""+forwardPage+"\";  theForm.submit();}");
	  out.println("</script>");
	  }else{
		  previewDisabled = true;
	  }
//kangjin 2001-4-10


       //get currency
     String Currency[][] = null;
        try
    {
        sb.setFieldValue(Const.GET_CURRENCY,"");
        Currency = sb.getRetValueArra();
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

    }
String PrmCurName = Objects.getValueCnm(Currency,"c_cur_no","c_cur_cnm",Result[1][c_prm_cur]);
//despose result is null or row<2
if(Result == null || Result.length < 2)
    Result = new String[2][2];
//test begin
  // for(int kk=0;kk<Result.length;kk++)
  //   {
  // 	out.println("  &&&&&  ");
  // 	for(int gg=0;gg<Result[0].length;gg++)
  //         out.println(Result[kk][gg]+"             " +",");
  //   }

//test end
%>


<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicPlyLeft.html" %>

    <td width="613"  valign="top">
<br><br>

<%
      String ret = Result[1][c_rtrn_cde];
   //for temmp test:
//    ret = "6";

   if(ret.equals("0"))
   {
      if(IsRemote)
      {
		try
		{
       			XMLSend  xmlsend = new XMLSend(RemoteData);
			XmlResult = xmlsend.SendStatus("0",Result[1][c_ply_app_no]);
			
		}
		catch(NormalException e)
		{
// 	    		throw NormalExceptionHandler.Handle(e);
			XmlResult = - 1;
		}
         if(XmlResult == 0)      
         {
%>
<p>XML数据发送成功(XML Data send successful)。
<%         
         }
         else
         {
%>
<p>XML数据发送失败(XML Data send failure)。
<%         
         
         }
      }
%>
<%

	int c_undr_opn =  Objects.getColNum("c_undr_opn",Result);
    String desc = Result[1][c_undr_opn];
    if(desc==null || desc.trim().length() == 0)desc="   ";
   int p = desc.indexOf(" ");
/*     p= desc.indexOf(" ",p+1);    
    desc =desc.substring(p);
*/
      StringTokenizer st = new StringTokenizer(desc," ");
        p=0;
      	while (st.hasMoreTokens()) {
      	          try	{
         		desc = st.nextToken();
                         p = p +1;
         		}
       			catch(NoSuchElementException e){}
       			if(p==2)break;
      	}
    
 %>  
<table width="100%">
<tr><td><%if(ClientType.equals(Const.CUST_AG)){%>&nbsp;&nbsp;&nbsp;&nbsp;您的投保业务<%if(desc.trim().length()>0){%>由于<font color="red"><%=(desc.trim())%> </font><%}%>保单未能自动生成，需要等待我公司的后台处理，我们将在一个工作日给您答复。
<%}%>
</td></tr>
<tr><td>   &nbsp;&nbsp;&nbsp;&nbsp;您的投保单号是：<%=Result[1][c_ply_app_no]%>。
           您可以在主页上点击查询投保结果，也可以打电话查询有关事项。（点击进入<input type=button name="address" value="平安保险查询电话" onClick="js_openAdressPage('AddressInfo.html')"> ）
</td></tr></table>

<%   
//       return;
   }    
   else if(ret.equals("1"))       
   {
      if(IsRemote)
      {
          request.setAttribute("C_PLY_NO",Result[1][c_ply_no]);
%>
      <jsp:forward page="RemoteXMLSend.jsp"/>
<%          
      }
      else
      {
%>
<table width="80%"><tr><td>  
   <form action="Find_PlyView.jsp"> &nbsp;&nbsp;&nbsp;&nbsp;您的投保业务已经通过系统核保，保单号是：<%=Result[1][c_ply_no]%>.
     <% String FromApp= request.getParameter("FromApp");
	    String Preview = "";
	    if(FromApp==null){FromApp=""; Preview="";}
		else if (FromApp.equals("PlyApp")||FromApp.equals("PlyEdrApp")){
		  Preview = "0";
		} 
		
	 %>
      <input type="hidden" name="C_PLY_NO" value="<%=Result[1][c_ply_no]%>">
	  <input type="hidden" name="Preview" value="<%=Preview%>">
    <br>请点击进入<input type="submit" name="submit1" value="保单打印">
		  		  <select name="language" size="1">
        <option value="CHN" selected>中</option>
		<option value="ENG">英</option>
</select>

     <br>
   </form>
</td></tr></table>
<%       
      }       
   }
   else if(ret.equals("6"))       
   {
      if(IsRemote & OperType.equals("0"))//and is inputpolicy
      {
		try
		{
       			XMLSend  xmlsend = new XMLSend(RemoteData);			
			XmlResult = xmlsend.SendStatus("0",Result[1][c_doc_no]);
			XmlResult = xmlsend.SendStatus("1",Result[1][c_doc_no]);
		}
		catch(NormalException e)
		{
			XmlResult = - 1;		
// 	    		throw NormalExceptionHandler.Handle(e);
		}
      
         if(XmlResult == 0)      
         {
%>
<p>XML数据发送成功(XML Data send successful)。
<%         
         }
         else
         {
%>
<p>XML数据发送失败(XML Data send failure)。
<%         
         
         }
    }     
%>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
      <table width="613" border="0" cellspacing="0" cellpadding="0" height="357" align="center">
        <tr> 
          <td height="29"><img src="images/jys.gif" width="150" height="31"></td>
        </tr>
        <tr> 
          <td>
<% 
  if(OperType.equals("0"))
  {
%>
你已经成功的提交了投保单!
<%
  }
%>
<form method="POST" action="ProposalMid.jsp">
  <p> 建议书号：&nbsp;<input type="text" disabled name="C_DOC_NO_TEMP" size="20" value=<%=Result[1][c_doc_no]%>>
  <input type="hidden" name="C_DOC_NO" size="20" value="<%=Result[1][c_doc_no]%>">
  <% if(AgencyNo.equals(Const.EDRSMTAPP)){
     int n_prm_var = Objects.getColNum("n_prm_var",Result);
	 int n_prm_old = Objects.getColNum("n_prm_old",Result);
	 int n_rate_old = Objects.getColNum("n_rate_old",Result);
	 String old_rate = Result[1][n_rate_old];

	 if(!(old_rate.equals("")))
     {
       double Irate = Double.parseDouble(old_rate);
       Irate = Irate*100 ;
       old_rate = String.valueOf(Irate);
     //by kangjin//RateValue = RateValue.substring(0,RateValue.indexOf(".")+3);
	   old_rate = new java.math.BigDecimal(new Double(RateValue).doubleValue()).setScale(4,java.math.BigDecimal.ROUND_HALF_UP).toString();
     }
  %>
  <br>原保费   <input type="text" disabled  name="n_prm_old" size="12" value="<%=Result[1][n_prm_old]%>">
	           <input type="hidden"   name="n_prm_old_value" size="12" value="<%=Result[1][n_prm_old]%>"> 

      最新保费 <input type="text" disabled  name="n_sum_prm" size="12" value="<%=Result[1][n_sum_prm]%>">
	           <input type="hidden"   name="n_sum_prm_value" size="12" value="<%=Result[1][n_sum_prm]%>"> 
	  保费变化 <input type="text" disabled  name="n_prm_var" size="12" value="<%=Result[1][n_prm_var]%>">
	           <input type="hidden"   name="n_prm_var_value" size="12" value="<%=Result[1][n_prm_var]%>"><%=PrmCurName%> 
			   <input type="hidden"   name="PrmCurName" size="20" value="<%=PrmCurName%>">  
    <input type="hidden" name="PRM_CUR" value="<%=Result[1][c_prm_cur]%>">
  <br>原费率   <input type="text" disabled  name="n_rate_old" size="12" value="<%=old_rate%>">%
	           <input type="hidden"   name="n_rate_old_value" size="12" value="<%=old_rate%>"> 
	  新费率   <input type="text" disabled  name="N_RATE" size="12" value="<%=RateValue%>">%
	           <input type="hidden"   name="N_RATE_VALUE" size="12" value="<%=RateValue%>"> 
  <%}else{%>
    <br>保　费　：
    <input type="text" disabled  name="n_sum_prm" size="12" value="<%=Result[1][n_sum_prm]%>"><%=PrmCurName%>
    <input type="hidden"   name="n_sum_prm_value" size="12" value="<%=Result[1][n_sum_prm]%>"> 
    <input type="hidden"   name="PrmCurName" size="20" value="<%=PrmCurName%>">  
    <input type="hidden" name="PRM_CUR" value="<%=Result[1][c_prm_cur]%>">
  <br>费　率　：
    <input type="text" disabled  name="N_RATE" size="12" value="<%=RateValue%>">%
    <input type="hidden" name="N_RATE_VALUE" size="12" value="<%=RateValue%>">
  <%}%>
  <br>免赔描述：<br>
    <textarea  name="C_NO_REPAY" cols="70" rows="2" onkeydown="return false;" ><%=Result[1][c_no_repay]%></textarea>
    <!---input type="text" disabled  name="C_NO_REPAY" size="40" value="<%=Result[1][c_no_repay]%>"--->
  <br>
  承保条件：<br>
    <textarea name="C_UNDR_CNDTN" cols="70" rows="5" onkeydown="return false;" ><%=Result[1][c_undr_cndtn]%></textarea>
  <br>核保意见：<br>
    <textarea name="C_REMARK" cols="70" rows="2"  onkeydown="return false;"><%=Result[1][c_remark]%></textarea>

  <%if(!AgencyNo.equals(Const.EDRSMTAPP)  && Result[1][c_prm_cur]!= null & Result[1][c_prm_cur].equals(RMB[0]))
    {//PAYMENT
  %> 
  
  <input type="hidden" name="PAY_METHOD" value="1">
  <br>
  选择付款方式：<input type="radio" name="PAY_TYPE" value="0">网上付款&nbsp;&nbsp;&nbsp;
                <input type="radio" checked name="PAY_TYPE" value="1">网下付款
  <%}%>
  <br>
  <div align="left">
    送单时间：从发出承保通知开始一个工作日内。<br>
  </div>
  <%
     boolean disabled = false;	
	 int C_PROPOSAL_TYPE  = Objects.getColNum("C_PROPOSAL_TYPE",Result);
     int C_PROPOSAL_FLAG  = Objects.getColNum("C_PROPOSAL_FLAG",Result);
	 if(Result[1][C_PROPOSAL_TYPE].equals("0")){
	    disabled = true;
	 }
	 %>
	  <input type="hidden" name="c_undr_prsn" value="<%=c_undr_prsn %>">
      <input type="submit" <%if(disabled){%>disabled <%}%> value="同意" size=10  name="B1" onclick="setField(temp,'agr');return agree();">
	  <% if(AgencyNo.equals(Const.EDRSMTAPP)) {%>
	  <input type="submit"  value="修改申请单" name="Submit"   onclick="setField(temp,'mod');return true;">
	  <input type="submit" <%if(disabled){%> disabled <%}%> value="预览保单" name="B2" onclick="Preview(this.form);return true;">
		  <select name="language" size="1">
        <option value="CHN" selected>中</option>
		<option value="ENG">英</option>
</select>
	  <%}else{%>
      <input type="submit"  value="修改投保单" name="Submit" onclick="setField(temp,'mod');return true;">
	  <input type="submit" <%if(disabled || previewDisabled){%> disabled <%}%> value="预览保单" name="B2" onclick="Preview(this.form);return true;">
		 <select name="language" size="1">			   
		       <option value="ENG" selected>英</option>
			   <option value="CHN" >中</option>
               </select>
	  <%}%>	  
      <input type="button" <%if(disabled){%>disabled <%}%> value="在线咨询" name="B0" onclick="OpenChat(this.form)">
      <input type="submit" <%if(Result[1][C_PROPOSAL_FLAG].equals("0")){%>disabled <%}%> value="我有意见" name="BB" onclick="AddNote(this.form);return true;">
      <input type="submit" value="撤单" name="B3" onclick="setField(temp,'undraw');return confirmDelete();">	
      <input type="hidden" name="temp" value="agr">
	  <input type="hidden" name="AGENCYNO" value="<%=AgencyNo%>">  
  </p>
  <P><input type="hidden" name="insuranceID" value="<%=insuranceID%>">
     <input type="hidden" name="orgID" value="<%=sessionbuffer.getClientAddInfo(Locate)[4]%>">
</form>
<%
   }
%>
    </td>
        </tr>
      </table>

</td>
  </tr>
</table>
 <% String clientName = sessionbuffer.getuserId(Locate); %> 
<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
<script language=JavaScript>
function OpenChat(theForm){

  subject = theForm.C_DOC_NO.value ;
  href = "meeting/ClientLogin.jsp?user=<%=clientName%>&sub="+subject+"&orgID=<%=orgID%>&insuranceID=<%=insuranceID%>";
  //theForm.B0.disabled=true;
  js_openClientSmallPage(href);
  
}
function AddNote(theForm){
  theForm.action = "AddProposalNote.jsp";
  theForm.submit();
}

function js_openAdressPage(url) {
  var newwin=window.open(url,"NewWin","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=680,height=600");
  newwin.focus();
  return false;
}
function agree(){
  if(confirm("是否确定同意?")){
    return true;
  }else{
    return false;
  }
}
function confirmDelete(){
  if(confirm("是否确定撤单?")){
    return true;
  }else{
    return false;
  }
}
</script>

