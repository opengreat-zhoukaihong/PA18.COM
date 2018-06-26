<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : User_Claim_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/User_Claim_List.jsp
*URL : http://10.16.102.1:8800/operator_manager/User_Claim_List.jsp
*Previous Page : Zclaim_List.jsp
*Next Page : N/A(this is the final page of this module)
*Author : Lawrence Kang
*Created Date : 2000/09/16
*Last Updated : 2000/10/10
*Status : submited for test
*Function : I.Display the detail information of selected policy claim
*============================MODIFIED HISTORY==================================================
*Date : 
*Time : 
*Modify id : 
*Modifier : 
*Reason : 
***********************************************************************************************
*/
%>
<jsp:useBean id="sb"  scope="page" class="beans.ZPolicyInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ include file="public/Public.jsp" %>
<%
String FormPara[]=new String[2];
String RetList[][]=null;
int RetLen=0;
int i=0,IndEnd=-1,IndStart=-1,StrLen=0;
int index_rpt_no=0;
int index_digest=0;
int index_content=0;
int index_input_tm=0;

String ParaStr,C_RPT_NO=null,C_CLM_NO=null,PLY_NO=null;
String selStr="";
boolean IsRight=true;

//将以"_"分隔的参数串解开，并放置出错标志
ParaStr=StringTool.null2Blank(request.getParameter("selectno"));
StrLen=ParaStr.length();

IndStart=ParaStr.indexOf("-");
if (IndStart!=-1 && IndStart<(StrLen-1))
{
	IndEnd=ParaStr.indexOf("-",IndStart+1);
}
else
{
	IsRight=false;
}
if (IsRight && IndEnd<(StrLen-1) && IndEnd!=-1)
{
	C_RPT_NO=ParaStr.substring(0,IndStart);
	PLY_NO=ParaStr.substring(IndStart+1,IndEnd);
	C_CLM_NO=ParaStr.substring(IndEnd+1,StrLen);
}
else
{
	IsRight=false;
}

if (IsRight)
{
	//set Form Paremeters

	FormPara[0]=C_RPT_NO;
	FormPara[1]=PLY_NO;
	//get values to the table
	//Summary is 
	//C_RPT_NO		报案号
	//C_DIGEST		信息摘要
	//T_INPUT_TM	信息记录时间
	//C_CONTENT		详细内容
	try
	{		 
		sb.setFormPara(ZConst.GET_CLMDGSTLIST,FormPara);
		RetList=sb.getRetValueArra();
	}
	catch(NormalException e)
	{
 		if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
	}

	if (RetList!=null && RetList.length>1)
	{
		RetLen=RetList.length;
		//获得所需字段的所在列的索引
		 index_rpt_no = Objects.getColNum("C_RPT_NO",RetList);   // 报案号
		 index_digest = Objects.getColNum("C_DIGEST",RetList);   //信息摘要
		 index_input_tm   = Objects.getColNum("T_INPUT_TM",RetList);  //信息记录时间
		 index_content = Objects.getColNum("C_CONTENT",RetList);//详细内容
	}

}
%>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicInquireLeft.jsp" %>      
    <td width="613" height="288" valign="top"> <br>
      <img src="images/m_inq4.gif" width="150" height="31" alt="赔案查询">

    <form name="f" method="POST" action="Claim_Content.jsp">
        <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
          <tr bgcolor="#99FFFF" align="center">
			<td bgcolor="#C0C0C0" height=20>&nbsp;</td> 
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
	  	  <%
	  if (RetList!=null && RetList.length >1 && IsRight)
	  {
		for (i=1;i<RetLen;i++)
		{
			if (i==1)
				selStr=" checked ";
			else
				selStr=" ";
	  %>
	  <tr bgcolor="#FFFFFF">
		<td>
			<input <%=selStr%>type="radio" name="index" value="<%=i%>">
			<input type="hidden" name="<%="reportNo"+i%>" value="<%=RetList[i][index_rpt_no]%>">
			<input type="hidden" name="<%="claimDgst"+i%>" value="<%=RetList[i][index_digest]%>">
			<input type="hidden" name="<%="inputTime"+i%>" value="<%=RetList[i][index_input_tm]%>">
			<input type="hidden" name="<%="content"+i%>" value="<%=RetList[i][index_content]%>">
		</td>
		<td><%=RetList[i][index_rpt_no]%>&nbsp;</td>
		<td><%=RetList[i][index_digest]%>&nbsp;</td>
		<td><%=RetList[i][index_input_tm]%>&nbsp;</td>
	  </tr>
	  <%
		}
	  }
	  else{
	  %>
          <tr bgcolor="#FFFFFF"> 
            <td valign="top" colspan="4" align="center"><font color=red>没有赔案进度信息！<font></td>
          </tr>
	  <%
	  }
	  %>
        </table>
		<br>
              <div align="center"><font face="宋体" size="4"> 
				<input type="submit" name="seeContent" value="查看内容">
                <input type=button name="back" value="返回" onclick=history.back()>
                </font></div>
        </form>
	</td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %>   
</body>
</html>
