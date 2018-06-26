<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/> 
<jsp:setProperty name="pm" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_FAQ_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_FAQ_List.jsp
*Previous Page : BackManage.jsp
*Next Page : B_FAQ_Show.jsp/B_Reply_FAQ.jsp/B_del_FAQ.jsp
*Author : Lawrence Kang
*Created Date : 2000-10-24
*Last Updated : 
*Status : open
*Function : I.Display the  FAQ List
*			II.Redirect the page the delete FAQ/Reply FAQ/ShowFAQ list
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
	formPara[],
	oprCde,
	status,
	result[][],
	/*B0003+*/
numStr = request.getParameter("numStr");
/*E0003+*/


int 
	indexFaqNo,
	indexFaqPsn,
	indexFaqEmail,
	indexFaqTitle,
	indexFaqTm,
	indexReplyTm,
	indexReplyEmp;

/*B0003+*/
Integer pNo;
/*E0003+*/

	oprCde=sessionuser.getuserId(Locate); 
/*B0003+*/
if (numStr == null) //first enter the page
{
/*E0003+*/
	try
	{
		formPara = new String[2];
		formPara[0] = ""; // faq number ,empty for all 
		formPara[1] = oprCde; //operator code
		bb.setFormPara(BConst.QUERY_FAQ_LIST,formPara);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
/*B0003+*/
	pm.setPageLength(8);
	pm.dumpIn(result);
	pNo = new Integer(0);
	result = pm.getPage(pNo.intValue());
}
else
{
	pNo = new Integer(numStr);
	result = pm.getPage(pNo.intValue());
}
/*E0003+*/
%>
<div align="center"><br>
	<font color="#0066CC" class="unnamed3">客 户 咨 询</font>
</div>
  <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
    <tr bgcolor="#9DEEDE"> 
      <td align="center" height="26" width="40%">主题</td>
      <td align="center" nowrap height="26" width="18%">咨询时间</td>
      <td align="center" nowrap height="26" width="7%">状态</td>
       <td align="center" nowrap height="26" width="19%">回复人</td>
      <td align="center" nowrap height="26" width="16%" colspan="2">操作</td>
    </tr>
	<% if (result != null && result.length>1){
				indexFaqNo = Objects.getColNum("C_FAQ_NO",result);
				indexFaqPsn = Objects.getColNum("C_FAQ_PSN",result);
				indexFaqEmail = Objects.getColNum("C_FAQ_EMAIL",result);
				indexFaqTitle = Objects.getColNum("C_FAQ_TITLE",result);
				indexFaqTm = Objects.getColNum("T_FAQ_TM",result);
				indexReplyTm = Objects.getColNum("T_REPLY_TM",result);
				indexReplyEmp = Objects.getColNum("C_REPLY_EMP",result);
				for (int i = 1; i < result.length; i++){
					if (result[i][indexReplyTm].length() == 0)
						status = "未回复";
					else
						status = "已回复";
	%>
    <tr> 
      <td bgcolor="#DFF9F3" align="left" height="25" width="59%"><a href="B_FAQ_Show.jsp?sessionId=<%=Code.Encrypt(sessionId)%>&faqNo=<%=result[i][indexFaqNo]%>"> 
        ◆<%=StringTool.htmlEncode(result[i][indexFaqTitle])%></a> </td>
      <td bgcolor="#DFF9F3" align="left" nowrap height="25" width="18%"> <%=result[i][indexFaqTm]%></td>
      <td bgcolor="#DFF9F3" align="left" nowrap height="25" width="7%"> 
        <font color="#990099"><%=status%></font>
      </td>
      <td bgcolor="#DFF9F3" align="center" nowrap height="25" width="19%"> 
        <%=result[i][indexReplyEmp]%>&nbsp;
      </td>
	  <form action="B_Reply_FAQ.jsp" method="post">
      <td bgcolor="#DFF9F3" align="right" nowrap height="25" width="8%"> 
		<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
		<input type="hidden" name="faqNo" value="<%=result[i][indexFaqNo]%>">
        <input type="submit" value="回复" style="background-color:#009999" >
      </td>
	  </form>
	  <form action="B_del_FAQ.jsp" method="post">
      <td bgcolor="#DFF9F3" align="left" nowrap height="25" width="8%"> 
	  <input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	  <input type="hidden" name="faqNo" value="<%=result[i][indexFaqNo]%>">
        <input type="submit" value="删除" style="background-color:#009999" >
      </td>
	  </form>
    </tr>
	<%		}
			}%>
  </table>
	<!--
	B0003+
	-->
	<table width="96%" border="0" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr>
		<td align="left" width="30%">
		<%if (pNo.intValue()>0){%>
		<a href="B_FAQ_List.jsp?numStr=<%=pNo.toString(0)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[首    页]</a>
		<a href="B_FAQ_List.jsp?numStr=<%=pNo.intValue()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[上一页]</a>
		<%}
		else{
			out.println("[首    页]");
			out.println("[上一页]");
		}
		%>
		</td>
		<td align="center" width="40%" valign="top">
			<p align=center>共<%=pm.getTotalPage()%>页；第<%=pNo.toString(pNo.intValue()+1)%>页</p>
		</td>
		<td align="right" width="30%">
		<%if (pNo.intValue() < pm.getTotalPage()-1){%>
		<a href="B_FAQ_List.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[下一页]</a>
		<a href="B_FAQ_List.jsp?numStr=<%=pm.getTotalPage()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[末    页]</a>
		<%}
		else{
			out.println("[下一页]");
			out.println("[末    页]");
		}
		%>
		</td>
	</tr>
  </table>
  <!--
  E0003+
  -->
<%@ include file="public/bottom.jsp" %>