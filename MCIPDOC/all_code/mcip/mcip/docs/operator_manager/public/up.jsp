<%@ page language="java" import="java.beans.Beans,java.math.*,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="ub"  scope="session" class="beans.UserManagerBean"/>
<jsp:setProperty name="ub" property="*"/>

<%
int index_page_no = 0;
int index_page_title =0;
int index_file_enm  = 0;
int index_func_cde = 0;
int index_edit_tm = 0;
int Locate;
//String sessionId=(String)request.getAttribute("sessionId");//Code for Test & Debug
String sessionId=Code.Decrypt(request.getParameter("sessionId"));
if (sessionId != null && sessionId.length() > 0){
	request.getSession(true).putValue("sessionId",Code.Encrypt(sessionId));
}else{
	sessionId = Code.Decrypt((String)request.getSession(false).getValue("sessionId"));
}

if ((sessionId == null) || (sessionId.equals("")))
{
          throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
}
String[] FormPara=new String[2];
String[] returnArray=null;
int RetLen=0;
//User Session Initialization

SessionUser sessionuser = SessionUser.getSessionUser();
	try
	{
		Locate = sessionuser.ProcessSession(Const.SESSAUTH,sessionId);
	}
	catch (Exception e)
	{
		Locate = -1;
	}

if (Locate<0)
{
       throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
}

//End of User Initialization
String opr_cde=sessionuser.getuserId(Locate); 

returnArray=sessionuser.getfuncCode(Locate);//Retrieve Function list Array form user session
int lenUp=sessionuser.getlength(returnArray); //Number of the element in the return array
%>
<html>
<head>
<title>平安货运险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%
 if(request.getParameter("meeting")!= null &&request.getParameter("meeting")!=""){%>
<meta http-equiv="Refresh" Content="10" URL="../ServerMeeting.jsp?meeting=1">
<%}%>
<link rel="stylesheet" href="style/backStyle.css">
</head>

<body bgcolor="FBFAF3" topmargin="0" leftmargin="0">

<table width="776" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#007B78"> 
    <td height="43" width="10%" bgcolor="019490">&nbsp;</td>
    <td height="43" width="90%" bgcolor="019490"><img src="images/di_r01_c2.jpg" width="247" height="41"></td>
  </tr>
</table>
<table width="776" border="0" cellspacing="0" cellpadding="0" height="3" bgcolor="#EEEEEE">
  <tr> 
    <td height="2"></td>
  </tr>
</table>

<table width="776" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="15%" height="25"><img src="images/di_r03_c1.jpg" width="137" height="31"></td>
    <td width="85%" background="images/di_r03_c3.jpg" height="25"> 
      <table border="0" cellspacing="0" cellpadding="0" class="unnamed2">
        <tr> 
	  <%
		String initLogin = request.getParameter("initLogin");
		String[] func_cde=new String[lenUp];	////////////////////
			for ( int i=0;i<lenUp;i++){			//Save function code
				func_cde[i]=returnArray[i];	//
			}///////////////////
			String[] func_cmn=sessionuser.getfuncName(Locate);
			lenUp=sessionuser.getlength(func_cmn);
			out.println("<tr> ");
			String Result[][] = null;
			for ( int i=0;i<lenUp;i++){
				if (initLogin != null && initLogin.equals("true")){
					try
					{
					FormPara[0]=func_cde[i];
						ub.setFormPara(ZConst.QUERY_PAGESLIST,FormPara);
						Result = ub.getRetValueArra();
					}
					catch(NormalException e)
					{
					//     throw NormalExceptionHandler.Handle(e);
					Result = null;
					}
					if (Result != null)
						request.getSession().putValue(func_cde[i],Result);
				}else{
					Result = (String[][])request.getSession().getValue(func_cde[i]);
				}

				String url = "";
				if (Result!=null && Result.length>1)
				{
					RetLen=Result.length;
					//获得所需字段的所在列的索引
					index_page_no = Objects.getColNum("C_PAGE_NO",Result);   //页面编码
					index_page_title = Objects.getColNum("C_PAGE_TITLE",Result);   //页面中文名称
					index_file_enm   = Objects.getColNum("C_FILE_ENM",Result);  //页面文件名
					index_func_cde = Objects.getColNum("C_FUNC_CDE",Result);//功能编码
					index_edit_tm = Objects.getColNum("C_EDIT_TM",Result);//最后修改时间
					url = Result[1][index_file_enm];
				}
				else
				{
					RetLen = 0;
				}
	  %>
          <td width="90"> 
            <div align="center"><a href="<%=url%>?fCode=<%=func_cde[i]%>"><font color="#000000"><%=func_cmn[i]%></font></a></div>
          </td>
		<%}%>
        </tr>
      </table>
    </td>
  </tr>
</table>

