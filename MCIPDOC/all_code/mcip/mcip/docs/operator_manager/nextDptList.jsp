<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>操作员授权</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
<%@ include file="PublicUser.jsp" %>
<jsp:useBean id="ub"  scope="session" class="beans.UserManagerBean"/>

<jsp:setProperty name="ub" property="*"/>
<div align="right">
<%
    String c_snr_dpt = request.getParameter("c_snr_cde");
    String sessionIdStr =  request.getParameter("sessionId");
    
%>
<address style="border-bottom: 1px dotted">
  平安保险
</address>
</div>
<font face="宋体" size="4">
<p align="center"> 操作员授权修改</p>

</font>
<form name="form1"  action="authDptModify.jsp">
  <input type="hidden" name="sessionId" value="<%=sessionIdStr%>">
  
  <font face="宋体" size="4"> </font>
  <table width="100%" border="0" height="289">
    <tr>

      <td colspan="2" rowspan="7" width="64%">
        <div align="center">
          <table width="100%" border="1" height="100%" bordercolorlight="#000000" bordercolordark="#FFFFFF" cellpadding="1" cellspacing="1">
            <tr bgcolor="#CCCCFF">
              <td colspan="2" width="50%">
                <div align="center">
                  <%
                Hashtable suptable= ub.getLoggerDptList();
                if(suptable==null)out.println("null in super ");
                Enumeration supkeys = suptable.keys();
                Hashtable table = ub.getOprDptList();
                //if(table==null) out.println("null in table");
                if(supkeys.hasMoreElements()){
                  DepartmentInfo info =(DepartmentInfo)(suptable.get(c_snr_dpt));
                  if(table!=null && table.containsKey(c_snr_dpt)){%>
                    <input type = hidden name="del_dpt_cde" value="<%=c_snr_dpt%>">
                    <p align=left><input type=checkbox checked name="c_dpt_cde" value="<%=c_snr_dpt%>"><%=info.c_dpt_cnm%>
                  <%}else{%>
                    <input type = hidden name="del_dpt_cde" value="<%=c_snr_dpt%>">
                    <p align=left><input type=checkbox name="c_dpt_cde" value="<%=c_snr_dpt%>"><%=info.c_dpt_cnm%>
                  <%}
                }
                while(supkeys.hasMoreElements()){
                   String dptID= (String)(supkeys. nextElement());
                   if(dptID.indexOf(c_snr_dpt)>=0){
                      DepartmentInfo info =(DepartmentInfo)(suptable.get(dptID));
                      if(table!=null && !dptID.equals(c_snr_dpt)){
                          if(table.containsKey(dptID)){%>
                          <input type = hidden name="del_dpt_cde" value="<%=dptID%>">
                          <p align=left>&nbsp;&nbsp;<input type=checkbox checked name="c_dpt_cde" value="<%=dptID%>"><%=info.c_dpt_cnm%>
                          <%}else{%>
                          <input type = hidden name="del_dpt_cde" value="<%=dptID%>">
                          <p align=left>&nbsp;&nbsp;<input type=checkbox name="c_dpt_cde" value="<%=dptID%>"><%=info.c_dpt_cnm%>
                          <%}}
                      else if(!dptID.equals(c_snr_dpt)){%>
                      <input type = hidden name="del_dpt_cde" value="<%=dptID%>">
                      <p align=left>&nbsp;&nbsp;<input type=checkbox name="c_dpt_cde" value="<%=dptID%>"><%=info.c_dpt_cnm%>
                      <%}

                   }//end if dptId

                }
                  %>
                  <p align="left">
                    <a href="javascript:SetChecked('c_dpt_cde',1)"><font face="宋体" size="4">全选<font></a>&nbsp;&nbsp;
                     <a href="javascript:SetChecked('c_dpt_cde',0)"><font face="宋体" size="4">清空</font></a>
                  <p>&nbsp;</p>
                </div>
              </td>
            </tr>


          </table>
        </div>
      </td>
    </tr>
    <tr> </tr>
    <tr> </tr>
    
  </table>
  <p align="center">
    <input type="submit" value="确定" name="SubmitLog">
    <a href="javascript:window.close()">取消</a><br>
  </p>
  <br>
</form>
<form name="form2">
</form>
</body>
</html>
<script language=javascript>
function SetChecked(name ,val) {
    dml=document.form1;
    len = dml.elements.length;
    var i=0;
    for( i=0 ; i<len ; i++) {
    if (dml.elements[i].name==name) {
    dml.elements[i].checked=val;
    }
   }
}
</script>
