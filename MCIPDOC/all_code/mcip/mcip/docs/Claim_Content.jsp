<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Claim_Content.jsp
*Directory : /data1/pa18/nul/mcip/public_html/
*URL : http://10.16.102.1:8800/Claim_Content.jsp
*Previous Page : User_Claim_List.jsp
*Next Page : none (can only back to the previous page)
*Author : Lawrence Kang
*Created Date : 2000/10/11
*Last Updated : 2000/10/11
*Status : submited for test
*Function : I.Display the selected the claim's content
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
String index="",reportNo="",claimDgst="",inputTime="",content="";

index = request.getParameter("index");
if (index != null)
{
	reportNo = request.getParameter("reportNo"+index);
	claimDgst = request.getParameter("claimDgst"+index);
	inputTime = request.getParameter("inputTime"+index);
	content = request.getParameter("content"+index);
}
%>
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ include file="public/Public.jsp" %>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicInquireLeft.jsp" %>      
    <td width="613" height="288" valign="top"> <br>

      <img src="images/m_inq4.gif" width="150" height="31" alt="赔案查询">

      <form name="f" method="POST" action="Claim_Content.jsp">
      <input type="hidden" name="C_DOC_NO" value="<%=reportNo%>">
        <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
          <tr bgcolor="#99FFFF" align="center">
            <td bgcolor="#C0C0C0" height=20 width="166"> 
              <div align="left">报案号</div>
            </td>
            <td bgcolor="#C0C0C0" height=20 width="212"> 
              <div align="left">信息摘要</div>
            </td>
            <td bgcolor="#C0C0C0" height=20 width="138"> 
              <p align="left">信息记录时间</p>
            </td>
          </tr>
		  <%if (index==null || index.length()==0){%>
          <tr bgcolor="#FFFFFF">
                <td align="left" colspan ="3"><font color="red">没有摘要信息！</font></td>
          </tr>
		  <%}else{%>
          <tr bgcolor="#FFFFFF">
                <td><%=reportNo%>&nbsp;</td>
                <td><%=claimDgst%>&nbsp;</td>
                <td><%=inputTime%>&nbsp;</td>
          </tr>
		  <%}%>
		  <tr bgcolor="#99FFFF" align="center">
			<td colspan="3" bgcolor="#C0C0C0" align="center">
				赔案处理情况
			</td>
		  </tr>
          <tr bgcolor="#FFFFFF">
			<td colspan ="3" align="left">
				<%if (content == null || content.length()==0)
					out.println("<font color=\"red\">没有赔案内容！</font>");
				else
					out.println("<pre>"+content+"</pre>");
				%>

			</td>
		  </tr>
        </table>
              <div align="center"><font face="宋体" size="4">
               <input type="button" value="在线咨询" name="button1" onclick="OpenChat(this.form)">
                &nbsp;&nbsp;
                <input type=button name="back" value="返回" onclick=history.back()>
                </font></div>
        </form>
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
  //href = "meeting/ClientLogin.jsp?user=<%=clientName%>&sub="+subject;
href = "meeting/ClientLogin.jsp?user=<%=clientName%>"
  js_openClientSmallPage(href);
}
</script>
