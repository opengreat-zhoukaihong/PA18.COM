<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/> 
<jsp:setProperty name="pm" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_guide_list.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_guide_list.jsp
*Previous Page : BackManage.jsp
*Next Page : B_In_plyapp_guide.jsp/B_del_guide.jsp
*Author : Lawrence Kang
*Created Date : 2000-10-20
*Last Updated : 
*Status : submit for test
*Function : I.list all the insurance guide (8 records per page)
*					II.forward to the next page according to client's choice
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
result[][] = null,
formPara[] = null,
oprCde = null,
numStr = null;


int
indexInfoNo,
indexTitleNo,
indexTitleCnm,
indexTitleEnm;

Integer pNo;

oprCde = sessionuser.getuserId(Locate); 

numStr = request.getParameter("numStr");
if (numStr == null) //first enter the page
{
	try
	{
		formPara = new String[2];
		formPara[0] = "";
		formPara[1] = oprCde;
		bb.setFormPara(BConst.QUERY_GUIDE_LIST,formPara);
		result = bb.getRetValueArra();
	}
	catch (NormalException e)
	{
		result = null;
	}

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
%>
<%@ include file="public/left.jsp"%>
<table border="0" cellpadding="0" cellspacing="0" width="100%" height="248">
  <tr><td>
       <div>
    
     <% //out.println("Session:"+sessionuser.getTotalSes()+",Locate:"+Locate);%>
</div>
  </td> </tr>
  <tr> 
    <td valign="top" height="239"> 
      <p align="center"><br>
      </p>
        <p align="center"><font size="3" color="#0000CC">投保指南列表</font></p>
        <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
          <tr bgcolor="#9DEEDE"> 
            <td width="10%" height="27"> 
              <div align="center" class="unnamed2">序号 </div>
            </td>
            <td width="45%" height="27"> 
              <div align="center" class="unnamed2">中文标题</div>
            </td>
            <td width="37%" height="27"> 
              <div align="center" class="unnamed2">英文标题</div>
            </td>
            <td width="8%" height="27" colspan="2"> 
              <div align="center" class="unnamed2">选择</div>
            </td>
          </tr>
		  <% if (result != null && result.length>1)
		  {
					indexInfoNo = Objects.getColNum("C_INFO_NO",result);
					indexTitleNo = Objects.getColNum("C_TITLE_NO",result);
					indexTitleCnm = Objects.getColNum("C_TITLE_CNM",result);
					indexTitleEnm = Objects.getColNum("C_TITLE_ENM",result);

					for(int i=1;i<result.length;i++)
					{%>
          <tr> 
			    <td bgcolor="#DFF9F3" width="10%" height="11">
					<%=StringTool.htmlEncode(result[i][indexTitleNo])%>&nbsp;
				</td>
            <td bgcolor="#DFF9F3" width="45%" height="11">
				<%=StringTool.htmlEncode(result[i][indexTitleCnm])%>&nbsp;
			</td>
            <td bgcolor="#DFF9F3" width="37%" height="11">
				<%=StringTool.htmlEncode(result[i][indexTitleEnm])%>&nbsp;
			</td>
			<form action="B_del_guide.jsp" method="post">
				<td bgcolor="#DFF9F3" width="4%" height="11">
					<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
					<input type="hidden" name="infoNo" value="<%=StringTool.htmlEncode(result[i][indexInfoNo])%>">
					<input type="hidden" name="titleNo" value="<%=StringTool.htmlEncode(result[i][indexTitleNo])%>">
					<input type="hidden" name="titleCnm" value="<%=StringTool.htmlEncode(result[i][indexTitleCnm])%>">
					<input type="hidden" name="titleEnm" value="<%=StringTool.htmlEncode(result[i][indexTitleEnm])%>">
					<input type="submit"  value="删除" style="background-color: #009999">
				</td>
			</form>
			<form action="B_In_plyapp_guide.jsp" method="post">
				<td bgcolor="#DFF9F3" width="4%" height="30">
					<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
					<input type="hidden" name="infoNo" value="<%=StringTool.htmlEncode(result[i][indexInfoNo])%>">
					<input type="submit"  value="修改" style="background-color: #009999">
				</td>
			</form>
          </tr>
		  <%		}
		  }%>
		<tr>
			<form name="EntAnswerForm" method="POST" action="B_In_plyapp_guide.jsp">
			<td bgcolor="#DFF9F3" width="100%" colspan="5" align="right">
					<input type="submit" value="新增/add" name="add" style="background-color: #009999">
					<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
					<input type="hidden" name="infoNo" value ="">
			</td>
				</form>
		  </tr>
        </table>

  <table width="96%" border="0" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr>
		<td align="left" width="40%">
		<%if (pNo.intValue()>0){%>
		<a href="B_guide_list.jsp?numStr=<%=pNo.toString(0)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[首    页]</a>
		<a href="B_guide_list.jsp?numStr=<%=pNo.intValue()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[上一页]</a>
		<%}
		else{
			out.println("[首    页]");
			out.println("[上一页]");
		}
		%>
		<td align="center" width="20%">
<p align=center>共<%=pm.getTotalPage()%>页；第<%=pNo.toString(pNo.intValue()+1)%>页</p>
		</td>
		</td>
		<td align="right" width="40%">
		<%if (pNo.intValue() < pm.getTotalPage()-1){%>
		<a href="B_guide_list.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[下一页]</a>
		<a href="B_guide_list.jsp?numStr=<%=pm.getTotalPage()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[末    页]</a>
		<%}
		else{
			out.println("[下一页]");
			out.println("[末    页]");
		}
		%>
		</td>
	</tr>
  </table>
    </td>
  </tr>
</table>
<%@ include file="public/bottom.jsp"%>