<%@ page language="java" import="java.lang.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp"  contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="ub"  scope="application" class="beans.UserManagerBean"/> 
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
if ((sessionId == null) || (sessionId.equals("")))
{
          throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);        
}



String[] FormPara=new String[2];
String[] returnArray=null;
int i=0,j=0,RetLen=0;

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

%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>操作员权限一览</title>
<style type="text/css">
<!--
body {  background-image: url(images/nabkgnd.jpg); background-color: #009900; color: #000099; font-family: "Arial Narrow", "Times New Roman", "宋体"; font-size: 9pt}
a:link {  color: #6600FF; font-size: 10pt}
.bigChange{color:blue;font-weight:bolder;font-size=10;letter-spacing:4px;background:yellow;}
.start{color: #6600FF;}
a:hover {  color: #00CC00}
a:active {  color: #8695A8}
.linkbig {  font-size: 10pt}
.linkreset {  font-size: 10pt}

-->
</style>

<!--link rel="stylesheet" href="../TableStyle_font_Small.css"-->

</head>

<body>
<%
returnArray=sessionuser.getfuncCode(Locate);//Retrieve Function list Array form user session
int len=sessionuser.getlength(returnArray); //Number of the element in the return array

String Result[][]=null; //Query result receiver

/*//data simulate
String Result[][]={{"c_page_no","c_page_title","c_file_enm","c_func_cde","t_edit_tm"},
		   {"0000100001","增加操作员","Add_Operator.html","00001",null},
		   {"0000100002","删除操作员","Add_Operator.html","00001",null},
		   {"0000100003","修改操作员资料","Add_Operator.html","00001",null},
		   {"0000100004","查询操作员资料","Add_Operator.html","00001",null}
		   };
//end of data simulate*/

String[] func_cde=new String[len];	////////////////////
for (i=0;i<len;i++){			//Save function code
	func_cde[i]=returnArray[i];	//
 }					///////////////////

String[] func_cmn=sessionuser.getfuncName(Locate);
len=sessionuser.getlength(func_cmn);
 %>
 <!--
<p><b>-Start debugging display-</b></p>
<font color=#FFFF66>
sessionid:<%=sessionId%><br>
len:<%=len%><br>
Locate:<%=Locate%>
cmn:<%=func_cmn[0]%>
cde:<%=func_cde[0]%>
</font>
<p><b>-End of debugging display-</b></p>
-->
<!--Generate the Function List-->
<table width="100%" border="0" bordercolorlight="#000000" bordercolordark="#FFFFFF" cellpadding="0" cellspacing="0" height="32%" bgcolor="#DDDDFF">

<%
for (i=0;i<len;i++){	//Retrieve all the pages for each function code

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

if (Result!=null && Result.length>1)
{
    RetLen=Result.length;

	//获得所需字段的所在列的索引
	index_page_no = Objects.getColNum("C_PAGE_NO",Result);   //页面编码
	index_page_title = Objects.getColNum("C_PAGE_TITLE",Result);   //页面中文名称
	index_file_enm   = Objects.getColNum("C_FILE_ENM",Result);  //页面文件名
	index_func_cde = Objects.getColNum("C_FUNC_CDE",Result);//功能编码
	index_edit_tm = Objects.getColNum("C_EDIT_TM",Result);//最后修改时间
}
else
{
	RetLen = 0;
}
 %>
<tr>
	<td><%=func_cmn[i]%><!--Function Code:(<%=func_cde[i]%>)--><br>
		<table width="100%" border="0">
			<% if (Result!=null && Result.length>1)
			{
			for (j=1;j<RetLen;j++){
			%>
			    <tr>
				  <td width="3%">&nbsp;</td>
			          <td width="97%" onmouseover="this.className='linkbig'" onmouseout="this.className='linkReset'">
					<a href="<%=Result[j][index_file_enm]%>?sessionId=<%=Code.Encrypt(sessionId)%>&C_FUNC_CDE=<%=Result[j][index_func_cde]%>" target="main"><%=Result[j][index_page_title]%></a>
					</td>
			    </tr>
			   <%		}
			   }%>

		</table>
	</td>
</tr>
<%}%>
</table>
</body>
</html>
