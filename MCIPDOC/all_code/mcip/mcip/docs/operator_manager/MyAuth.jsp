<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>   
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<style type="text/css">
<!--
.unnamed1 {  background-color: #DFF9F3; background-attachment: scroll;}-->
</style>
<%

    SessionUser mySession = sessionuser;
    String funcNames[] = mySession.getfuncName(Locate);

	//out.println(mySession.getuserId(Locate));

    %>


<p align="center"><font color="#0066CC"><span class="unnamed3"> 我的权限一览</span></font></p>

<form name="form1" action="permission.jsp" method="get">

    <div align="center">
               
                <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
                  <tr>
                    <td bgcolor="#9DEEDE"  valign="top" width="22%">
                        操作权限：
                    </td>
                    <td bgcolor="#DFF9F3"  width="78%">

                    <% if(funcNames!=null && funcNames.length >0){ %>
                       <div><table width=100% border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
                      <% for(int i= 0 ; i< funcNames.length && funcNames[i]!=null ; i++){%>
                        <tr width=100%>
                        <td width=100% bgcolor="#DFF9F3" height="2"  valign="top">
                         <%=funcNames[i]%></font> </td>
                        </tr>
                      <%}
                        out.println("</table>");
                      }else{%>
                       &nbsp;&nbsp;
                     <%}%>

                  </tr>
                  
                  
                  <tr> 
                    <td bgcolor="#9DEEDE" valign="top" width=22%>
                       授权管辖机构：
                    </td>
                    <td width="78%">
              <table width=100% border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
             
	 <%
	  String oprCde=sessionuser.getuserId(Locate); 
	  String departList[][] = null ;
	
	  //GET DEPARTMENT LIST FOR CURRENT USER
	  try
	 {
		String formPara[] = {oprCde};
		ub.setFormPara(ZConst.QUERY_OPTRDPTLIST,formPara);
		departList = ub.getRetValueArra();
	 }
     catch(NormalException e)
	 {
		if(NormalExceptionHandler.IsSevere(e))
			throw NormalExceptionHandler.Handle(e);
	  }
	  if (departList!=null && departList.length>1)
	  {

		int index_opr_cde=Objects.getColNum("C_OPR_CDE",departList);
		int index_dpt_cde=Objects.getColNum("C_DPT_CDE",departList);
		int index_dpt_cnm=Objects.getColNum("C_DPT_CNM",departList);
		int index_dpt_enm=Objects.getColNum("C_DPT_ENM",departList);
		int i,j ;
		for (i=1,j=0;i<departList.length;i++,j++)
		{
	     %>
        <tr> 
          
          
          <td width="100%" bgcolor="#DFF9F3"><%=departList[i][index_dpt_cnm]%></td>
        </tr>
	  <%}
	}else
	  {
	  %>
	  <tr><td><font color="#FF0066">没有找到相应的机构！</font></td></tr>
	  <%
	  }
	  %>
           
       </table></div>
                </td>
    </tr></table>  
 </div>

  <p align="center">
    <input type="button" value="返回" name="SubmitLog" onClick="Javascript: history.back()">
    <br>
  </p>
</form>

<%@ include file="public/bottom.jsp"%>

