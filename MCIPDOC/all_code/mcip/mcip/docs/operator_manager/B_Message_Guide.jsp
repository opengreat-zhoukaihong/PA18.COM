<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_Message_Guide.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_Message_Guide.jsp
*Previous Page : B_In_plyapp_guide.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-10-21
*Last Updated : 
*Status : submit for test
*Function : I.take the action choice by the last page(update or add)
*			II.update the t_insrnc_guide and feedback the message(if update)
*			III.insert the t_insrnc_guide and feedback the message(if add0
*============================MODIFIED HISTORY==================================================
*Date : 
*Time : 
*Modify id : 
*Modifier : 
*Reason : 
***********************************************************************************************
*/
%>
<%
	String
	formPara[] =null,
	msgStr = "",
	oprCde,
	action = StringTool.null2Blank(request.getParameter("action")),
	infoNo = StringTool.null2Blank(request.getParameter("infoNo")),
	titleNo = StringTool.null2Blank(request.getParameter("titleNo")),
	titleCnm = StringTool.null2Blank(request.getParameter("titleCnm")),
	titleEnm = StringTool.null2Blank(request.getParameter("titleEnm")),
	contentCnm = StringTool.null2Blank(request.getParameter("contentCnm")),
	contentEnm = StringTool.null2Blank(request.getParameter("contentEnm")),
	crtTm = StringTool.null2Blank(request.getParameter("crtTm"));



	boolean
	bingo =false;
	oprCde=sessionuser.getuserId(Locate);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//BRANCH
if ( action != null && action.equals("create") )
{
	try
	{
		formPara = new String[8];
		formPara[0] = infoNo;
		formPara[1] = titleNo;
		formPara[2] = titleCnm;
		formPara[3] = titleEnm;
		formPara[4] = contentCnm;
		formPara[5] = contentEnm;
		formPara[6] = crtTm;
		formPara[7] = oprCde;
		bb.setFormPara(BConst.ACCEPT_GUIDE_INFO,formPara);
		bingo = bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
	}
}

if ( action != null && action.equals("update") )
{
	try
	{
		formPara = new String[8];
		formPara[0] = infoNo;
		formPara[1] = titleNo;
		formPara[2] = titleCnm;
		formPara[3] = titleEnm;
		formPara[4] = contentCnm;
		formPara[5] = contentEnm;
		formPara[6] = crtTm;
		formPara[7] = oprCde;
		bb.setFormPara(BConst.UPDATE_GUIDE_INFO,formPara);
		bingo = bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
	}
}

%>
<%@ include file="public/left.jsp"%>
 <form name="EntAnswerForm" method="POST" action="B_Message_Guide.jsp">
  <p align="center">
		<font color="#0000CC">
		<% if (action != null && action.equals("create")) {%>
			投保指南增加结果
		<%}%>
		<% if (action != null && action.equals("update")) {%>
			投保指南修改结果
		<%}%>
		</font>
</p>
<% if (bingo)
{
%>
  <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" bgcolor="#DFF9F3">
      <tr> 
        <td colspan="2" align="center"> 
          <B>操作成功!</B>
        </td>
      </tr>
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE">显示序号: </td>
		  <td><%=StringTool.htmlEncode(titleNo)%></td>
      </tr>
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE"> 中文标题: </td>
		  <td><%=StringTool.htmlEncode(titleCnm)%></td>
      </tr>
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE">英文标题: </td>
		  <td><%=StringTool.htmlEncode(titleEnm)%>&nbsp;</td>
      </tr>
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE">中文内容:</td>
		  <td><%=StringTool.htmlEncode(contentCnm)%>&nbsp;</td>
      </tr>
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE">英文内容: </td>
		  <td><%=StringTool.htmlEncode(contentEnm)%>&nbsp;</td>
      </tr>
    </table>

		<%}
		else
		{
		%>
			<font color="red"><h1>操作失败!请重试或联系系统管理员.</h1></font>
		<%}%>
		</form>
        <p align="center"> 
		<form action="B_guide_list.jsp" method="post">
			<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
          <input type="submit" value="返回" name="B12">
		  </form>
        </p>
<%@ include file="public/bottom.jsp"%>
