<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_In_plyapp_guide.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_In_plyapp_guide.jsp
*Previous Page : B_guide_list.jsp
*Next Page : B_Message_Guide.jsp
*Author : Lawrence Kang
*Created Date : 2000-10-20
*Last Updated : 
*Status : submit for test
*Function : I.Accept user's update/input
*					II.forward to the next page for update/create
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
	oprCde = null,
	infoNo = request.getParameter("infoNo"),
	wrnStr = "",
	action = "",
	formPara[] = new String [2],
	result [][] = null,
	titleNo = "",
	titleCnm = "",
	titleEnm = "",
	contentEnm = "",
	contentCnm = "";


int
	indexInfoNo,
	indexTitleNo,
	indexTitleCnm,
	indexTitleEnm,
	indexContentEnm ,
	indexContentCnm ;

	oprCde=sessionuser.getuserId(Locate); 

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//BRANCH HANDLE
if (infoNo != null && infoNo.length() >0)
{
	action = "update";
	try
	{
		formPara = new String[2];
		formPara[0] = infoNo;
		formPara[1] = oprCde;
		bb.setFormPara(BConst.QUERY_GUIDE_LIST,formPara);
		result = bb.getRetValueArra();
	}
	catch (NormalException e)
	{
		result = null;
	}
	
	if (result != null && result.length >1)
	{
		indexInfoNo = Objects.getColNum("C_INFO_NO",result);
		indexTitleNo = Objects.getColNum("C_TITLE_NO",result);
		indexTitleCnm = Objects.getColNum("C_TITLE_CNM",result);
		indexTitleEnm = Objects.getColNum("C_TITLE_ENM",result);
		indexContentEnm = Objects.getColNum("C_CONTENT_ENM",result);
		indexContentCnm = Objects.getColNum("C_CONTENT_CNM",result);
		infoNo = StringTool.htmlEncode(result[1][indexInfoNo]);
		titleNo = StringTool.htmlEncode(result[1][indexTitleNo]);
		titleCnm = StringTool.htmlEncode(result[1][indexTitleCnm]);
		titleEnm = StringTool.htmlEncode(result[1][indexTitleEnm]);
		contentEnm = StringTool.htmlEncode(result[1][indexContentEnm]);
		contentCnm = StringTool.htmlEncode(result[1][indexContentCnm]);
	}
	else
	{
		wrnStr = "警告：没有找到要修改的记录!";
	}
}
else
{
	action ="create";
}
%>
<script language="JavaScript" src="check.js">
</script>

<%@ include file="public/left.jsp"%>
 <form name="EntAnswerForm" method="POST" action="B_Message_Guide.jsp" onsubmit="return (ValidNull(titleNo,false) && ValidNull(titleCnm,false))">
 <input type="hidden" name="action" value = "<%=action%>">
 <input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
 <input type="hidden" name="infoNo" value="<%=infoNo%>">
 <p align="center"><font color="#0000CC">投保指南输入</font></p>
  <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" bgcolor="#DFF9F3">
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE"> 
          显示序号: 
		  </td>
		  <td>
          <input type="text" name="titleNo" maxlength="5" size="5" value="<%=titleNo%>">
			<font color ="red"><%=wrnStr%></font>
        </td>
      </tr>
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE"> 
          中文标题: 
 		  </td>
		  <td>
            <input type="text" name="titleCnm" maxlength="100" size="50" value="<%=titleCnm%>">
			   <font color ="red"><%=wrnStr%></font>
        </td>
      </tr>
      <tr> 
        <td width="18%" height="24"  bgcolor="#9DEEDE"> 
		  英文标题: 
 		  </td>
		  <td>
           <input type="text" name="titleEnm" maxlength="100" size="50" value="<%=titleEnm%>">
        </td>
      </tr>
          <tr> 
            <td width="18%" height="24"  bgcolor="#9DEEDE"> 
				  中文内容: 
			   </td>
			   <td>
              <textarea name="contentCnm" cols="70" rows="4"><%=contentCnm%></textarea>
            </td>
          </tr>
          <tr> 
            <td width="18%" height="24"  bgcolor="#9DEEDE">
				   英文内容: 
			   </td>
			   <td>
              <textarea name="contentEnm" cols="70" rows="4"><%=contentEnm%></textarea>
            </td>
          </tr>
        </table>
        <p align="center"> 
          <input type="submit" value="提交" name="B1">
          <input type="button" value="返回" name="B12" onclick="history.back()">
        </p>
</form>
     
<%@ include file="public/bottom.jsp"%>
