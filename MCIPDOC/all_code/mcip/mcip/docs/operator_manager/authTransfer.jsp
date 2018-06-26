<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="cb"  scope="session" class="beans.UserManagerBean"/>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<jsp:setProperty name="cb" property="*"/>

<%
    SessionUser mySession = sessionuser ;
    
    String operInfos[] = new String[4];
    operInfos[0] = "";
    operInfos[1] = "";
    operInfos[2] = mySession.getuserId(Locate);
    operInfos[3] = mySession.getdepartId(Locate);
    boolean IsAccept = false;
    String [][] retValueArra = null ;
    int rowCount =0 ;

    
    String pageNoStr = request.getParameter("pageNo");
    int pageNo = 0 ;
    int begIndex = 1 ;    
    int endIndex = 0 ;
    int nextPage = 0 ;
    int pageSize = 2 ;
    int i =0 ;
    int totalPages = 0;
    boolean NotFound = false ;
    if(pageNoStr==null){
     
      try
     {

        cb.setFormPara(ZConst.QUERY_OPTRLIST,operInfos);
     }
     catch(NormalException e)
     {
      //out.println("Wrong error");
 	    //if(NormalExceptionHandler.IsSevere(e))
 	    //throw NormalExceptionHandler.Handle(e);
       NotFound = true;
     }
    }else{
          try{
              pageNo = (new Integer(pageNoStr)).intValue();
              if(pageNo==0){
                 begIndex = 1; 
              }else{
                 begIndex = pageNo* pageSize+1;
              }


          }catch(NumberFormatException e){
             NotFound = true ;
             e.printStackTrace();
          }
    }
    if(!NotFound){
     retValueArra = cb.getRetValueArra();
     rowCount = retValueArra.length;
   }
    if(rowCount<=pageSize){
         endIndex = rowCount;
         nextPage = 0 ;
    }else{
         if(rowCount > begIndex+pageSize){            
             endIndex = begIndex+pageSize;
             nextPage = pageNo+ 1; 
         }else{
             endIndex = rowCount ;
         }
        
    }
   
    String errText= new String("you failure");

    

     totalPages = (rowCount-1)/pageSize ;
     if((rowCount-1)%pageSize >0) { totalPages++; }

%>


<% if(rowCount < 2){
      out.println("<font color ='red'>没有下属操作员</font>");
    }
  %>
<div align=center>
<font color="#0066CC"><span class="unnamed3">
操作人员授权转移</span></font>
</font>

  <table width="90%" border="1" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" align="center">
    <tr bgcolor="#9DEEDE">
      <td>
        <div align="center">操作员帐号</div>
      </td>
      <td>
        <div align="center">员工编号</div>
      </td>
      <td>
        <div align="center">员工姓名</div>
      </td>
    </tr>

    <%
     if(rowCount >0)
      for( i=0; begIndex< endIndex; begIndex++,i++){ %>
      <tr bgcolor="#DFF9F3">
      <td><%= retValueArra[begIndex][0]%> </td>
      <td><%= retValueArra[begIndex][1]%> </td>
      <td><%= retValueArra[begIndex][5]%> </td>
    <% }%>

  </table>
<% if(rowCount> 0){ %>
<p align=right class="td">
  共 <font color=red><%=(rowCount-1)%></font> 个操作员
  <% if(pageNo > 0 ){%>
     <a href="authTransfer.jsp?&pageNo=0">[首  页]</a>
  <% } %>
  <% if(pageNo > 0){%>
     <a href="authTransfer.jsp?pageNo=<%=(pageNo-1)%>"> [上一页]</a>
  <%}%>
       <% if(rowCount%pageSize > 0 ){ %>
          &nbsp;&nbsp;显示<%=(pageNo+1)%>/<%=totalPages%>&nbsp;&nbsp;
       <%}else{%>
          &nbsp;&nbsp;显示<%=(pageNo+1)%>/<%=totalPages%>&nbsp;&nbsp;
       <%}%>
   <% if(nextPage>0){%>
       <a href="authTransfer.jsp?pageNo=<%=nextPage%>"> [下一页]</a>
   <%}%>
   <% if(rowCount> 0  && rowCount> endIndex ){ %>
     <a href="authTransfer.jsp?pageNo=<%=(totalPages-1)%>">[尾  页]</a>
   <%}%>


<div align="center">
   <form name="form1">
<p align=left>
   <input type="hidden" name="auth_opr_cde" value="<%=mySession.getuserId(Locate)%>">
   <input type="hidden" name="auth_dpt_cde" value="<%=mySession.getdepartId(Locate)%>">
<table border=0 width="90%" class= "td" align="center">
<tr bgcolor="#9DEEDE" width="100%"><td align=left>
    操作员帐号： <input type=text  name="FromOprCde">*
  <td align=centern bgcolor="#9DEEDE">&nbsp;<input type=button name="transfer" value=" 授权转移>>"
                    onClick="transferAuth(this.form)">
  <td align=right bgcolor="#9DEEDE"><input type=text name="ToOprCde">*
  </table>
  </form>

<%}%>
<%@ include file="public/bottom.jsp"%>

<script language=JavaScript>

function transferAuth(theForm){
    if(theForm.FromOprCde.value==""){
      alert("带*不能为空");
      theForm.FromOprCde.focus();
      return false;
    }
     if(theForm.ToOprCde.value==""){
      alert("带*不能为空");
      theForm.ToOprCde.focus();
      return false;
    }
    theForm.action ="authTransferAction.jsp";
    theForm.submit();
}

</script>
