<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_delmessage_guide.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_delmessage_guide.jsp
*Previous Page : B_del_guide.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-10-21
*Last Updated : 
*Status : submit for test
*Function : I.execute the delete operation and return the result message
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
formPara[] ,
oprCde = null,
infoNo = StringTool.null2Blank(request.getParameter("infoNo"));

boolean
bingo = false;

	oprCde=sessionuser.getuserId(Locate); 

	try
	{
		formPara = new String[2];
		formPara[0] = infoNo;
		formPara[1] = oprCde;
		bb.setFormPara(BConst.DELETE_GUIDE_INFO,formPara);
		bingo = bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
	}

%>
<%@ include file="public/left.jsp"%>
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="198" align="center">
  <tr align="center"> 
    <td height="200"> 
			<%if (bingo){%>
				        <font color="#0000CC"><B>该投保指南删除成功</B>!</font>
			<%}else{%>
						<font color="red"><h1>该投保指南未能删除!</h1></font>
			<%}%>
		<form action="B_guide_list.jsp" method="post">
			<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
          <input type="submit" value="返回" name="B12">
		  </form>
    </td>
  </tr>
</table>
<%@ include file="public/bottom.jsp"%>
