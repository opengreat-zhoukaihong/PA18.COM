<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>送单信息打印</title>
</head>

<body>
<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="obj_buss"  scope="session" class="beans.Zbussbean"/>
<jsp:useBean id="obj_buss2"  scope="session" class="beans.Zbussbean"/>
<jsp:useBean id="obj"  scope="page" class="beans.Zbussbean"/>
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>


<%
	String info[][]=null;
	String info2[][]=null;
	String[] check=null;
	String province="";
	String city="";
	int i=0;

//======= begin process  =========
//	String check2=null;
	check=request.getParameterValues("checkno");
	if(check==null)
	{
//		check2=request.getParameter("checkbox");
//		if(check2==null)
			throw new NormalException("<h3>没有选择打印项！</h3>");
	}
	String plyno[] = new String[check.length];
	info=obj_buss.getRetValueArra();
	if(info==null)
		throw new NormalException("系统访问错误(WebServer因故重新启动或登录超时),请重新登录,多谢合作!!!");
	for(i=0;i<check.length;i++)
	{
		int t=Integer.parseInt(check[i]);
		plyno[i]=Objects.getValue(t,"C_PLY_NO",info);
	}
	//obj_buss2 for next page
	obj_buss2.setFormParaPre(ZConst.UPDATE_PRINTINFO,plyno);

	obj.setFormPara(ZConst.QUERY_PLYNETINFO,plyno);
	info=obj.getRetValueArra();
%>


<form name="EntAnswerForm" method="POST" action="Zsubm_plynet.jsp">
	<input type="hidden" name="c_opr_cde" value="<%=request.getParameter("c_opr_cde")%>">
<%
	if(info!=null)
	{
	//debug:
//	for(i=0;i<info[0].length;i++)
//		out.println("debug1120:"+info[0][i]);
		for(i=1;i<info.length;i++)
		{
// get city,area..
			try
			{
			sb.setFieldValue(Const.GET_PROVINCE,Objects.getValue(i,"C_PROVINCE",info));
			info2 = sb.getRetValueArra();
				province=Objects.getValue(1,"C_CITY_CNM",info2);

			city=Objects.getValue(i,"C_CITY",info);
			sb.setFieldValue(Const.GET_CITY,Objects.getValue(i,"C_PROVINCE",info));
			info2 = sb.getRetValueArra();
				if(info2!=null)
				{
					for(int j=1;j<info2.length;j++)
				{
						if( city.equals(Objects.getValue(j,"C_CITY",info2)) )
							city=Objects.getValue(j,"C_CITY_CNM",info2);
				}
				}
			}
			catch(NormalException e)
		{
			if(NormalExceptionHandler.IsSevere(e))
					throw NormalExceptionHandler.Handle(e);
			}

//   		sb.setFieldValue(Const.GET_CITY,Objects.getValue(i,"C_CITY",info));

%>
<div align="center"><font color="#0066CC" class="unnamed3">送单地址</font><br></div>
<br>
<br>
<table align="center" width="100%">
	<tr>
		<td align="right" width="25%">客户签名:</td>
		<td width="25%">&nbsp;</td>
		<td align="left" width="25%">签收时间:
		</td>
		<td width="25%">&nbsp;</td>
	<tr>
</table>
<table align="center" width="70%">
			 <tr><td>
			 保单号：<%=Objects.getValue(i,"C_PLY_NO",info)%>
			 </td></tr>
</table>
<table  align="center" width="70%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td" height="140">
	<tr>
			<td height="20" width="17%" bgcolor="#9DEEDE">送&nbsp;单&nbsp;人：</td>
		<td height="20" colspan="3"><%=Objects.getValue(i,"C_EMP_CNM",info)%>&nbsp; </td>
		</tr>
		<tr>
			<td height="20" width="17%" bgcolor="#9DEEDE">送单时间：</td>
		<td height="20" colspan="3"> <%=Objects.getValue(i,"T_SEND_TM",info)%>&nbsp;</td>
		</tr>
		<tr>
			<td height="20" width="17%" bgcolor="#9DEEDE">送到时间： </td>
		<td height="20" colspan="3"><%=Objects.getValue(i,"T_SENDED_TM",info)%>&nbsp;</td>
		</tr>
		<tr>
			<td height="20" width="17%" bgcolor="#9DEEDE">送单地址：</td>
		<td height="20" colspan="3"> <%=city+" "+Objects.getValue(i,"C_PLACE",info)%>&nbsp;</td>
		</tr>
		<tr>
			<td height="20" width="17%" bgcolor="#9DEEDE">联&nbsp;系&nbsp;人： </td>
		<td height="20" colspan="3"><%=Objects.getValue(i,"C_CONTACT_NAME",info)%>&nbsp;</td>
		</tr>
		<tr>
		<td height="20" width="17%" bgcolor="#9DEEDE">联系电话： </td>
		<td height="20" colspan="3"> <%=Objects.getValue(i,"C_CONTACT_PHONE",info)%>&nbsp;</td>
		</tr>
		<tr>
			<td height="20" width="17%" bgcolor="#9DEEDE">&nbsp;传&nbsp;&nbsp;真&nbsp;： </td>
		<td height="20" colspan="3">
				<%=Objects.getValue(i,"C_CONTACT_FAX",info)%>&nbsp;</td>
		</tr>
		<tr>
		<td height="20" width="17%" bgcolor="#9DEEDE">&nbsp;E-mail： </td>
		<td height="20" colspan="3"><%=Objects.getValue(i,"C_CONTACT_EMAIL",info)%>&nbsp;</td>
		</tr>
		<tr>
		<td height="20" width="17%" bgcolor="#9DEEDE">&nbsp;备注： </td>
		<td height="20" colspan="3"><%if(Objects.getValue(i,"C_PAY_FLAG",info).equals("1")){%>保费已付<%}else{%>保费未付<%}%>&nbsp;</td>
		</tr>

	</table>
	<p>&nbsp;</p>
<% 	}
	}
%>
	<p align="center">
		<input type="submit" name="Submit" value="打印" onClick="javascript:window.print()">
	</p>
</form>

 </body>
</html>
