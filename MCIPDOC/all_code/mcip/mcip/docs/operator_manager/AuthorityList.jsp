<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>   
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<style type="text/css">
<!--
.unnamed1 {  background-color: #DFF9F3; background-attachment: scroll;}-->
</style>
<%

    SessionUser mySession = sessionuser;
    String operInfos[] = new String[4];
    String info = request.getParameter("C_OPR_CDE");
    int p1= info.indexOf(",");
    operInfos[0] = info.substring(0,p1);
    int p2 = info.indexOf(",", p1+1);
    operInfos[1] = info.substring(p1+1,p2);
    operInfos[2] = request.getParameter("auth_opr_cde");
    operInfos[3] = request.getParameter("auth_dpt_cde");
    boolean IsAccept = false;
    String [][] retValueArra = null;
    int rowCount =0 ;
    //for(int i=0; i<4;i++)
    //out.println(operInfos[i]+",");
    try
    {

        ub.setFormPara(ZConst.QUERY_AUTHLIST,operInfos);
        retValueArra = ub.getRetValueArra();
        rowCount = retValueArra.length;
    }
    catch(NormalException e)
    {
     // if no record is here
      if(!(e.getErrCode().equalsIgnoreCase("100000002")))
 	    throw NormalExceptionHandler.Handle(e);
      rowCount =0;
    }


    String errText= new String("you failure");

    %>


<p align="center"><font color="#0066CC"><span class="unnamed3"> 操作员<%=operInfos[0]%>权限一览</span></font></p>

<form name="form1" action="permission.jsp" method="post">

  <input type=hidden name=opr_cde value="<%=operInfos[0]%>">
   <% if(rowCount>0){
            for(int i= 1 ; i< retValueArra.length; i++){%>
                  <input type=hidden name=hasAuthCodes value="<%=retValueArra[i][3]%>">
  <%}}%>

  
    <div align="center">
               
                <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
                  <tr>
                    <td bgcolor="#9DEEDE"  valign="top" width="22%">
                        操作权限：
                    </td>
                    <td bgcolor="#DFF9F3"  width="78%">

                    <% if(rowCount>0){ %>
                       <div><table width=100% border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
                      <% for(int i= 1 ; i< retValueArra.length; i++){%>
                        <tr width=100%>
                        <td width=100% bgcolor="#DFF9F3" height="2"  valign="top">
                         <%=retValueArra[i][4]%></font> </td>
                        </tr>
                      <%}
                        out.println("</table>");
                      }else{%>
                       &nbsp;&nbsp;
                     <%}%>

                  </tr>
                  
                  
                  <tr> 
                    <td bgcolor="#9DEEDE" valign="top" width=22%> 
                        可授权管辖机构：
                    </td>
                    <td width="78%">
					  <table width=100% border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
                     <%  
				       String departList[][] = null;
                      try
                      {
                          String formParam[] = {operInfos[0]};
                          ub.setFormPara(ZConst.QUERY_OPTRDPTLIST,operInfos);
                          departList = ub.getRetValueArra();                         
                      }
                     catch(NormalException e)
                   {
                      // if no record is here
                      // if(!(e.getErrCode().equalsIgnoreCase("100000002")))
 	                    // throw NormalExceptionHandler.Handle(e);
                      rowCount =0;
                   }

                     
                  //if(departList.length>0)
                  //  for(int kk=0 ;kk< departList[0].length; kk++)
				  //   out.println(departList[0][kk]+",");

				 if (departList!=null && departList.length>1)
	             {

		          
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
                </table>                  
                </td>
               </tr>
                </table>
 </div>

  <p align="center">
    <input type="submit" value="修改权限" name="SubmitLog">
    <a href="authList.jsp">返回</a> <br>
    <br>
  </p>
</form>
<%@ include file="public/bottom.jsp"%>
