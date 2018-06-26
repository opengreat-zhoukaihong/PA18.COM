<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="session" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/> 
<jsp:setProperty name="pm" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Assigned_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Assigned_List.jsp
*Previous Page : Find_Ply_Net.jsp
*Next Page : Assign_All.jsp|Assign_Send.jsp|Assign_Back.jsp
*Author : Lawrence Kang
*Created Date : 2000/10/09
*Last Updated : 2000/10/10
*Status : submited for test
*Function : I.Retrieve the all the Policy-Net list meet the condidtion
*			II.Submit to various page according to the various button pressed
*============================MODIFIED HISTORY==================================================
*Date : 00-10-11
*Time : 11:12
*Modify id :0001 
*Modifier : Lawrence Kang
*Reason : add validation check of date inputed
*==============================================================================================
*Date : 00-10-12
*Time : 10:09
*Modify id :0002
*Modifier : Lawrence Kang
*Reason : fix the page bug(hidden field shoud include in the <td></td> tag)
***********************************************************************************************
*Date : 2000-10-18
*Time : 10:07:53
*Modify id :0003
*Modifier : Lawrence Kang
*Reason : 分页处理
***********************************************************************************************

*/
%>

<%
//predefine
String selStr="";
String formTable[][] = new String[9][1];
String result[][] = null;
int indexUndrTm = 0;
int indexCrtTm = 0;
int indexPlyNo = 0;
int indexSendEmpCde = 0;
int indexSendEmpCnm = 0;
int indexSendTm = 0;
int indexSendedTm = 0;
int indexFeedBackTm = 0;
int indexProvince = 0;
int indexCity = 0;
int indexPlace = 0;
int indexProvinceCnm = 0;
int indexCityCnm = 0;
int indexDptCde = 0;
int indexPayFlag = 0;


int i=0,j=0;
/*B0003+*/
Integer pNo;
/*E0003+*/
Integer totalDpt;
/*B0003+*/
String numStr = request.getParameter("numStr");
String numBack = request.getParameter("numBack");
if (numBack == null)
	numBack = "0";
/*E0003+*/

String isInit = StringTool.null2Blank(request.getParameter("isInit"));//isInit = "true" means the previous page is the Find_Ply_Net.jsp

///////////////////////////////////////////////////////////////////////
//GET PARAMEETERS FROM THE LAST PAGE
String dealType = request.getParameter("dealType");
String isHandle = request.getParameter("isHandle");
String notHandle = request.getParameter("notHandle");
String isSent = request.getParameter("isSent");
String notSent = request.getParameter("notSent");
String isBack = request.getParameter("isBack");
String notBack = request.getParameter("notBack");
String isPolicy = request.getParameter("isPolicy");
String policyNo =  request.getParameter("policyNo");
String isTimeTrack = request.getParameter("isTimeTrack");
String fromYear = request.getParameter("fromYear");
String fromMonth = request.getParameter("fromMonth");
String fromDay = request.getParameter("fromDay");
String fromHour = request.getParameter("fromHour");
String fromMinute = request.getParameter("fromMinute");
String fromSecond = request.getParameter("fromSecond");
String toYear = request.getParameter("toYear");
String toMonth = request.getParameter("toMonth");
String toDay = request.getParameter("toDay");
String toHour = request.getParameter("toHour");
String toMinute = request.getParameter("toMinute");
String toSecond = request.getParameter("toSecond");
String isInsuranceCode = request.getParameter("isInsuranceCode");
String fromInsuranceCode = request.getParameter("fromInsuranceCode");
String toInsuranceCode = request.getParameter("toInsuranceCode");
String dptCde = request.getParameter("dptCde");
String oprCde = request.getParameter("oprCde");
String dptCount = request.getParameter("dptCount");

////////////////////////////////////////////////////////////////////////////////
//INITIALIZE THE FORMPARA LIST
/*B0003+*/
if (numStr == null) //first enter the page
{
/*E0003+*/
		if (isInit.equals("true")){ //parameters are from the last page's post fields
			//prepare the parameters for query the policy deal list
			for (i=0;i<formTable.length;i++)
				formTable[i][0] = "";
			formTable[0][0] = dealType;//dealtype

			if (dealType.equals("0")) //act_type
				formTable[1][0]="2";
			if (dealType.equals("1"))//act_type
			{
				if ((isHandle == null && notHandle == null) || (isHandle!=null && notHandle!=null))
					formTable[1][0] = "2";//all the action selected
				if (isHandle != null && notHandle == null)
					formTable[1][0] = "1"; // only isHandle selected
				if (isHandle == null && notHandle != null)
					formTable[1][0] = "0"; // only notHandle selected
			}
			if (dealType.equals("2"))//act_type
			{
				if ((isSent == null && notSent == null) || (isSent != null && notSent != null))
					formTable[1][0] = "2";//all the action selected
				if (isSent != null && notSent == null)
					formTable[1][0] = "1"; // only isSent selected
				if (isSent == null && notSent != null)
					formTable[1][0] = "0"; // only notSent selected
			}

			if (dealType.equals("3"))//act_type
			{
				if ((isBack == null && notBack == null) || (isBack != null && notBack != null))
					formTable[1][0] = "2";//all the action selected
				if (isBack != null && notBack == null)
					formTable[1][0] = "1"; // only isBack selected
				if (isBack == null && notBack != null)
					formTable[1][0] = "0"; // only notBack selected
			}

			if (isPolicy != null && policyNo != null) //policy no
				formTable[2][0] = policyNo.trim();

			if (isTimeTrack!=null && //fromtime & totime
				fromYear!=null && fromMonth!=null && fromDay!=null && fromHour!=null && fromMinute!=null && fromSecond!=null &&
				toYear!=null && toMonth!=null && toDay!=null && toHour!=null && toMinute!=null && toSecond!=null)
			{
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.text.ParsePosition pos = new java.text.ParsePosition(0);
				Date toDate = sdf.parse(toYear+"-"+toMonth+"-"+toDay+" "+toHour+":"+toMinute+":"+toSecond,pos);
				toDate.setTime(toDate.getTime()+86400000);
				formTable[3][0] = fromYear+"-"+fromMonth+"-"+fromDay+" "+fromHour+":"+fromMinute+":"+fromSecond;
				formTable[4][0] = sdf.format(toDate);
			}

			if (isInsuranceCode!=null && fromInsuranceCode != null && toInsuranceCode != null)//from & to insurance code
			{
				formTable[5][0] = fromInsuranceCode.trim();
				formTable[6][0] = toInsuranceCode.trim();
			}

			//获得选择的部门列表
			try{
				totalDpt = new Integer(dptCount);
			}
			catch (Exception e){
				totalDpt = new Integer(0);
			}
			Vector dptList = new Vector();
			for (i=0;i<totalDpt.intValue();i++){
				if (request.getParameter("is"+i) != null && request.getParameter("is"+i).equals("true"))
					dptList.add(request.getParameter("dptCde"+i));		
			}
			//当没有一个部门被选择时，默认为所有部门
			if (dptList.size()<1){
				for (i=0;i<totalDpt.intValue();i++){
						dptList.add(request.getParameter("dptCde"+i));		
				}
			}
			formTable[7] = new String[dptList.size()];
			for (i=0;i<dptList.size();i++)
				formTable[7][i] = (String)dptList.get(i);
			formTable[8][0] = oprCde; //operator code
		}else{//if isInit
			formTable = (String[][])request.getSession(false).getValue("formTable");
		}// end of if isInit
		try
		{
			bb.setFormTable(BConst.QUERY_PLYDEALLIST,formTable);
			result = bb.getRetValueArra();
		}
		catch(NormalException e)
		{
			result = null;
		}
		/*B0003+*/
		pm.setPageLength(6);
		pm.dumpIn(result);
		pNo = new Integer(numBack);
		result = pm.getPage(pNo.intValue());
}
else
{
		pNo = new Integer(numStr);
		result = pm.getPage(pNo.intValue());
}
/*E0003+*/
if (isInit.equals("true")){
	request.getSession(true).putValue("formTable",formTable);
}
%>
<script language="JavaScript">
function ChgAction(Str)
{
	f.action=Str;
	return;
}
</script>
<form name="f" method="POST" action="Assign_All.jsp">
<div align="center"><font color="#0066CC" class="unnamed3">送单信息列表</font></div>
  <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
    <tr bgcolor="#9DEEDE"> 
      <td width="5%">&nbsp;</td>
      <td align="center" width="15%"> 
        保单号
      </td>
      <td align="center" width="12%"> 
        送单人
      </td>
      <td align="center" width="12%"> 
        保单时间
      </td>
      <td align="center" width="12%"> 
        送单时间
      </td>
      <td  align="center" width="12%"> 
        送到时间
      </td>
      <td  align="center" width="12%">
		返回时间
		</td>
      <td  align="center" width="15%"> 
        送单地址
      </td>
	  <td align="center" width="5%">
	  付费
	  </td>
    </tr>
    <%if (result != null && result.length>1)
	{
		indexUndrTm = Objects.getColNum("T_UNDR_TM",result);
		//indexCrtTm = Objects.getColNum("C_CRT",result);
		indexPlyNo = Objects.getColNum("C_PLY_NO",result);
		indexSendEmpCde=Objects.getColNum("C_SEND_EMP_CDE",result);
		indexSendEmpCnm=Objects.getColNum("C_SEND_EMP_CNM",result);
		indexSendTm=Objects.getColNum("T_SEND_TM",result);
		indexSendedTm=Objects.getColNum("T_SENDED_TM",result);
		indexFeedBackTm=Objects.getColNum("T_FEEDBACK_TM",result);
		indexProvince = Objects.getColNum("C_PROVINCE",result);
		indexCity =  Objects.getColNum("C_CITY",result);
		indexPlace = Objects.getColNum("C_PLACE",result);
		indexProvinceCnm = Objects.getColNum("C_PROVINCE_CNM",result);
		indexCityCnm = Objects.getColNum("C_CITY_CNM",result);
		indexDptCde = Objects.getColNum("C_DPT_CDE",result);
		indexPayFlag = Objects.getColNum("C_PAY_FLAG",result);
	%>
	<input type="hidden" name="lines" value="<%=result.length%>">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<%	for (i=1;i<result.length;i++)
		{
			if (i == 1)
				selStr="checked";
			else
				selStr="";
			j=i-1;%>
			<tr bgcolor="#DFF9F3"> 
				<td width="5%"> 
					<input <%=selStr%> type="radio" name="index" value="<%=j%>">
					<!--B0002+-->
					<input type="hidden" name="plyNoList<%=j%>" value="<%=result[i][indexPlyNo]%>">
					<input type="hidden" name="sendEmpList<%=j%>" value="<%=result[i][indexSendEmpCde]%>">
					<input type="hidden" name="sendTmList<%=j%>" value="<%=result[i][indexSendTm]%>">
					<input type="hidden" name="sendedTmList<%=j%>" value="<%=result[i][indexSendedTm]%>">
					<input type="hidden" name="backTmList<%=j%>" value="<%=result[i][indexFeedBackTm]%>">
					<input type="hidden" name="dptCdeList<%=j%>" value="<%=result[i][indexDptCde]%>">
					<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
					<input type="hidden" name="numBack" value="<%=pNo%>">
					<!--E0002+-->
				</td>
				<td width="15%">
					<%=result[i][indexPlyNo]%>
				</td>
				<td width="12%">
					<%=result[i][indexSendEmpCnm]%>&nbsp;
				</td>
				<td width="12%">
					<%=result[i][indexUndrTm]%>&nbsp;
				</td>
				<td width="12%">
					<%=result[i][indexSendTm]%>&nbsp;
				</td>
				<td width="12%">
					<%=result[i][indexSendedTm]%>&nbsp;
				</td>
				<td width="12%">
					<%=result[i][indexFeedBackTm]%>&nbsp;
				</td>
				<td width="15%">
					<%=result[i][indexProvinceCnm]+result[i][indexCityCnm]+"<br>"+result[i][indexPlace]%>
				</td>
				<td width="5%">
					<%if(result[i][indexPayFlag].equals("1")){%>
					<font color="red">已付</font>
					<%}else{%>
					未付
					<%}%>
				</td>
			</tr>
    <%		}%>
    <tr> 
      <td colspan="9" align="center" width="100%"> 
          <input type="submit" name="in" value="送单调度" onclick="f.action='Assign_All.jsp';" style="background-color: #009999">
          <input type="submit" name="modify" value="添加送到时间" onclick="f.action='Assign_Send.jsp';" style="background-color: #009999">
          <input type="submit" name="add" value="添加返回时间" onclick="f.action='Assign_Back.jsp';" style="background-color: #009999">
      </td>
    </tr>
    <%}
    else
    {%>
	<tr><td colspan="7" width="100%" align="center"><font color="red">没有查到送单信息！<br>请检查查询条件或扩大查询范围</font></td></tr>
    <%}%>
	
  </table>
</form>
	<!--
	B0003+
	-->
	<table width="96%" border="0" class="td">
	<tr>
		<td align="left" width="30%">
		<%if (pNo.intValue()>0){%>
		<a href="Assigned_List.jsp?numStr=<%=pNo.toString(0)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[首    页]</a>
		<a href="Assigned_List.jsp?numStr=<%=pNo.toString(pNo.intValue()-1)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[上一页]</a>
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
		<a href="Assigned_List.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[下一页]</a>
		<a href="Assigned_List.jsp?numStr=<%=pm.getTotalPage()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[末    页]</a>
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
<%@ include file="public/bottom.jsp"%>