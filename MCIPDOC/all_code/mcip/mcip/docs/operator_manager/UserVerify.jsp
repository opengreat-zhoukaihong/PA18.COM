<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>

<jsp:useBean id="obj_user"  scope="session" class="beans.Zuserbean"/>
<jsp:useBean id="obj_cust"  scope="page" class="beans.CustManagerBean"/>
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>

<%
	String userid[] = new String[1];
	String info[][]=null;
	String info2[][]=null;
	String area="";
	String province="";
	String city="";

	boolean nodaili=true;
	
	int i=0;
	
	i=Integer.parseInt(request.getParameter("radio"));
	info=obj_user.getRetValueArra();

//	out.println("for debug:infolen1738 = "+info.length);
	if(info==null)
		throw new NormalException(" debug:info==null");
	String c_userid=Objects.getValue(i,"C_USER_ID",info);
	String usermark= Objects.getValue(i,"c_clnt_mrk",info);
//	String agtcde= "";
//	String agtcde= Objects.getValue(i,"C_CMPNY_AGT_CDE",info);
	 
	userid[0] = Objects.getValue(i,"c_clnt_cde",info); 
 	  
/* if( agtcde.length()>0) 
 {
   nodaili=false;
   obj_cust.setFormPara(Const.QUERY_CUSTAGNT,agtcde);
	info=obj_cust.getRetValueArra();
 }else
 {
*/
	usermark=usermark.trim();
   if(usermark.equals("0"))
   	obj_cust.setFormPara(Const.QUERY_CUSTORGN,userid);
   if(usermark.equals("1"))
   	obj_cust.setFormPara(Const.QUERY_CUSTPRSN,userid);
	info=obj_cust.getRetValueArra();

// get city,area.. 
/*
	String city2="";
if(usermark.equals("0") ||usermark.equals("1"))
{
	 city2=Objects.getValue(1,"C_CITY",info);
  try
  {
  	if( (Objects.getValue(1,"C_ARA_CDE",info)).equals(""))
  		area="";
  	else
  	{
   	sb.setFieldValue(Const.GET_AREA,Objects.getValue(1,"C_ARA_CDE",info));
   	info2 = sb.getRetValueArra();
  		if(info2!=null)area=Objects.getValue(1,"C_ARA_CNM",info2);
  	}
        
   sb.setFieldValue(Const.GET_PROVINCE,Objects.getValue(1,"C_PROVINCE",info));
   info2 = sb.getRetValueArra();
  	if(info2!=null)province=Objects.getValue(1,"C_CITY_CNM",info2);

   sb.setFieldValue(Const.GET_CITY,Objects.getValue(1,"C_PROVINCE",info));
   info2 = sb.getRetValueArra();
  	if(info2!=null)
  	{
  		for(i=1;i<info2.length;i++)
  			if( (Objects.getValue(1,"C_CITY",info)).equals(Objects.getValue(i,"C_CITY",info2)) )
  			city=Objects.getValue(i,"C_CITY_CNM",info2);
  	}
  }
  catch(NormalException e)
  {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
  }
}
*/
	String[][] info3=null;
	String[] formpara=new String[1];
	if((request.getParameter("accept"))==null)
	{
		try
		{
		formpara[0]=c_userid;
  		obj_cust.setFormPara(Const.QUERY_CUSTENTT,formpara);
			info3=obj_cust.getRetValueArra();
		}
		catch(NormalException e)
		{
 			if(NormalExceptionHandler.IsSevere(e))
 				throw NormalExceptionHandler.Handle(e);
		}
		catch(Exception e)
		{
			out.println("debug:err excption occur when call :e");
		}	// end try
  }


%>
<SCRIPT LANGUAGE="JavaScript" SRC="Ztool.js"></SCRIPT>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
   	form2.radio1[0].focus();
   	form2.radio1[1].focus();
   	form2.radio1[2].focus();   	   	
</SCRIPT>

       <div align="center"><font color="#0066CC" class="unnamed3"> 会 员 审 批<br>
        </font> 
       <table width="98%" border="0" cellspacing="0" cellpadding="0" class="td">
          <tr>
            <td>客户基本资料：</td>
          </tr>
        </table>
        <table width="98%" border="1" cellspacing="0" cellpadding="0" bordercolor="#009966" bgcolor="#F4FFF4" bordercolorlight="#FFFFFF" class="td" height="100">
          <tr>
            <td> 客户编号：<%=Objects.getValue(1,"C_CLNT_CDE",info)%></td>
          </tr>
          <tr>
            <td>客户名称：<%=Objects.getValue(1,"C_CLNT_NME",info)%></td>
          </tr>
          <tr>
            <td>身份证号/工商登记号：<%=Objects.getValue(1,"C_RGST_NO",info)%></td>
          </tr>
          <tr>
            <td>电话号码：<%=Objects.getValue(1,"C_TEL",info)%></td>
          </tr>
          <tr>
            <td>客户地址：<%=Objects.getValue(1,"C_PLACE",info)%></td>
          </tr>
        </table>
<form name="form2" action="Zsubm_userverify.jsp">
  <input type="hidden" name="C_USER_ID" value="<%=c_userid%>">
  <input type="hidden" name="C_CLNT_CDE" value="<%=userid[0]%>">
  <input type="hidden" name="c_clnt_nme" value="<%=Objects.getValue(1,"C_CLNT_NME",info)%>">
        <table width="98%" border="1" cellspacing="0" cellpadding="0" bordercolor="#009966" bgcolor="#F4FFF4" bordercolorlight="#FFFFFF" class="td" height="100">
          <tr> 
            <td width="14%"> 
              <div align="center">会员类型：</div>
            </td>
            <td width="86%"> 
	<%	  if( (Objects.getValue(1,"c_verify",info3).equals("3"))||(Objects.getValue(1,"c_verify",info3).equals("2"))  )
		  {	%>
        <input type="radio" name="radio1" value="1"  onclick="radioDisable('t',C_CMPNY_AGT_CDE);"
				onfocus="radioDisable('t',C_CMPNY_AGT_CDE);">
	<%	  } else
		  {	%>
        <input type="radio" name="radio1" value="1" checked onclick="radioDisable('t',C_CMPNY_AGT_CDE);"
				onfocus="radioDisable('t',C_CMPNY_AGT_CDE);">
	<%	   }	%>
        普通会员<br>
	<%	  if(Objects.getValue(1,"c_verify",info3).equals("3"))
		  {	%>
			<input type="radio" name="radio1" value="3" checked onclick="radioDisable('t',C_CMPNY_AGT_CDE);"
				onfocus="radioDisable('t',C_CMPNY_AGT_CDE);"> 
	<%	  } else
		  {	%>
			<input type="radio" name="radio1" value="3" onclick="radioDisable('t',C_CMPNY_AGT_CDE);"
				onfocus="radioDisable('t',C_CMPNY_AGT_CDE);">
	<%	   }	%>
			Open Cover客户<br>
	<%	  if(Objects.getValue(1,"c_verify",info3).equals("2"))
		  {	%>
			<input type="radio" name="radio1" value="2" checked onclick="radioDisable('f',C_CMPNY_AGT_CDE);"
				onfocus="radioDisable('f',C_CMPNY_AGT_CDE);">
	<%	  } else
		  {	%>
			<input type="radio" name="radio1" value="2" onclick="radioDisable('f',C_CMPNY_AGT_CDE);"
				onfocus="radioDisable('t',C_CMPNY_AGT_CDE);">
	<%	   }	%>
        代理人(代理编号<input type="text" name="C_CMPNY_AGT_CDE" size="8" maxlength="12" value="<%=Objects.getValue(1,"C_CMPNY_AGT_CDE",info3)%>">)
				 </td>
          </tr>
          <tr> 
            <td width="14%"> 
              <div align="center">审批意见：</div>
            </td>
            <td width="86%"> 
        <input type="radio" name="radio2" value="y" checked>
        同意为会员 <br>
        <input type="radio" name="radio2" value="0">
        不同意 <br>
        <input type="radio" name="radio2" value="9">
        注销	 
		      </td>
          </tr>
          <tr> 
            <td width="14%"> 
              <div align="center">审批意见描述：</div>
            </td>
            <td width="86%"> 
              <textarea name="C_VERIFY_DESC" cols="50" value="<%=Objects.getValue(1,"c_verify_desc",info3)%>"></textarea>
            </td>
          </tr>
        </table>
        <br>
      </div>
              
      <input type="submit" name="Submit" value="提交">
      <input type="submit" name="Submit4" value="查询同名客户" onclick="ChgAction(form2,'SameNameUser.jsp');return true;">
      <input type="submit" name="Submit2" value="客户匹配"  onclick="ChgAction(form2,'Zrelationship.jsp');return true;">
      <a href="edit_orgn_rear.jsp?userid=<%=userid[0]%>">修改客户资料</a>
      <a href="Zprint_orgn.jsp?userid=<%=userid[0]%>">打印客户资料</a> 
</form>

<%@ include file="public/bottom.jsp" %>
