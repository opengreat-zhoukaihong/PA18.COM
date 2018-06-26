
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<jsp:useBean id="bb"  scope="request" class="beans.BusinessManagerBean"/>
<jsp:setProperty name="bb" property="*"/>


<% SessionUser mySession = sessionuser ;//SessionUser.getSessionUser();


    String argss[] = new String[5];
    String loginUserId =mySession.getuserId(Locate);
    String fromdate = request.getParameter("fromdate");
    String todate =  request.getParameter("todate");
    String eventtype= request.getParameter("event");
    String c_event_cde = request.getParameter("c_event_cde");
    if(eventtype.equalsIgnoreCase("1")){
         c_event_cde = request.getParameter("c_event_cde");
    }else{
         c_event_cde = "";
    }
	if (todate != null){
		try{
			
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			Date toDayDate = sdf.parse(todate);
			toDayDate = new Date(toDayDate.getTime()+3600*24*1000);
			todate =	 sdf.format(toDayDate);
		}catch(Exception e){
		}
	}

    int rowCount = 0;
    String retValueArra[][] = null;
    argss[0]= fromdate;
    argss[1]= todate;
    argss[2]= eventtype;
    argss[3]= c_event_cde;
    argss[4]= loginUserId;

  /*for debug liuyn
    out.println(argss[0]);
	out.println(argss[1]);*/

    try
    {
        bb.setFormPara(BConst.QUERY_EVENT_COUNTLIST,argss);
        retValueArra = bb.getRetValueArra();
        rowCount = retValueArra.length;
    }
    catch(NormalException e)
    {
      if(!(e.getErrCode().equalsIgnoreCase("100000002")))
 	    throw NormalExceptionHandler.Handle(e);
      rowCount =0;
    }

%>
<div>
<div align=center>
   <font color="#0066CC"><span class="unnamed3">
    网站事务统计报表  </span></font>
</div>

<div align=center>
<table width="90%" border="1" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
  <tr  bgcolor="#9DEEDE">
    <td height="33" width="10%">事件类型</td>
    <td height="33" width="15%">总发生次数</td>
    <td height="33" width="16%">成功次数</td>
    <td height="33" width="15%">失败次数</td>
  </tr>
  <% if(rowCount > 1){
     for(int i= 1 ; i< rowCount ;i++){ %>
     <tr bgcolor="#DFF9F3">
    <td width="10%"><%=retValueArra[i][1]%></td>
    <td width="15%"><%=retValueArra[i][2]%></td>
    <td width="16%"><%=retValueArra[i][3]%></td>
    <td width="15%"><%=retValueArra[i][4]%></td>
  </tr>
  <%   }
  }%>

</table>
 <p laign=center><input type=button value="返回" onClick="javascript:history.back()">
</div>
<%@ include file="public/bottom.jsp" %>

