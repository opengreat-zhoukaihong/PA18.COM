<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="cb"  scope="session" class="beans.UserManagerBean"/>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<jsp:setProperty name="cb" property="*"/>
<%
    SessionUser mySession = sessionuser;

    String operInfos[] = new String[4];
    operInfos[0] = "";
    operInfos[1] = ""; 
    operInfos[2] = mySession.getuserId(Locate);
    operInfos[3] = mySession.getdepartId(Locate);
    boolean IsAccept = false;
    String [][] retValueArra = null ;
    int rowCount =0 ;
    boolean NotFound = false;
   
    String pageNoStr = request.getParameter("pageNo");
    int pageNo   = 0 ;
    int begIndex = 1 ;    
    int endIndex = 0 ;
    int nextPage = 0 ;
    int pageSize = 10 ;
    int i =0 ;
    int totalPages = 0;
    if(pageNoStr==null){
     
      try
     {

        cb.setFormPara(ZConst.QUERY_OPTRLIST,operInfos);
     }
     catch(NormalException e)
     {

       NotFound = true;
        //out.println("Wrong error");
 	    //if(NormalExceptionHandler.IsSevere(e))
 	    //throw NormalExceptionHandler.Handle(e);
     }
    }else{
          try{
              pageNo = (new Integer(pageNoStr)).intValue();
              if(pageNo==0){
                 begIndex = 1; 
              }else{
                 begIndex = pageNo*pageSize+1;
              }
          }catch(NumberFormatException e){
             NotFound = true;
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
    //out.println(begIndex +","+ endIndex);
    String errText= new String("you failure");

    if(rowCount < 1)
    {

        out.println("<font color='red'>没有下属操作员</font>");
     }

     totalPages = (rowCount-1)/pageSize ;
     if((rowCount-1)%pageSize >0){ totalPages++; }

%>


<div align="center"><font color="#0066CC"><span class="unnamed3">
操作权限信息维护</span></font></div>
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
 <% if(rowCount >0)
    for( i= 0  ;begIndex < endIndex  ; begIndex++ ,i++){ %>
      <tr bgcolor="#DFF9F3">
      <td><a href="JavaScript:selectNo('C_OPR_CDE',<%=i%>)"><%= retValueArra[begIndex][0]%></a></td>
      <td><%= retValueArra[begIndex][1]%> </td>
      <td><%= retValueArra[begIndex][5]%> </td>
    <%}%>
    

  </table>
  <% if(rowCount >0) { %>
  <p align=right class="td">
  共 <font color=red><%=(rowCount-1)%></font> 个操作员
  <% if(pageNo > 0 ){%>
     <a href="authList.jsp?&pageNo=0">[首  页]</a>
  <% } %>
  <% if(pageNo > 0){%>
     <a href="authList.jsp?pageNo=<%=(pageNo-1)%>"> [上一页]</a>
  <%}%>
       <% if(rowCount%pageSize > 0 ){ %>
          &nbsp;&nbsp;显示<%=(pageNo+1)%>/<%=totalPages%>&nbsp;&nbsp;
       <%}else{%>
          &nbsp;&nbsp;显示<%=(pageNo+1)%>/<%=totalPages%>&nbsp;&nbsp;
       <%}%>
   <% if(nextPage>0){%>
       <a href="authList.jsp?pageNo=<%=nextPage%>"> [下一页]</a>
   <%}%>
   <% if(rowCount> 0  && rowCount> endIndex ){ %>
     <a href="authList.jsp?pageNo=<%=(totalPages-1)%>">[尾  页]</a>
   <%}%>
<div align="center">
 <form name="form1">
<p align="center"  class="td">
   <input type="hidden" name="auth_opr_cde" value="<%=mySession.getuserId(Locate)%>">
   <input type="hidden" name="auth_dpt_cde" value="<%=mySession.getdepartId(Locate)%>">
    操作员帐号： <select name="C_OPR_CDE">
    <% begIndex = endIndex - i; %>
    <% for( i=0; begIndex< endIndex; begIndex++,i++){
         String value = retValueArra[begIndex][0] +"," +  retValueArra[begIndex][1] + "," + retValueArra[begIndex][2];
    %>
      <% if(i==0){%>
        <option value="<%=value%>" selected><%=retValueArra[begIndex][0]%>
       <%} else{ %>
         <option value="<%=value%>"><%=retValueArra[begIndex][0]%>
    <%} }%>
	</select>
  <input type=button name=authButton value="查看权限" onClick = "authClick(this.form)">
  </form>

 </div>

<%}%>
<%@ include file="public/bottom.jsp"%>
<script language=JavaScript>
function queryClick(theForm){
  theForm.action = "QueryOprListUnderMe.jsp";
  theForm.submit();
}
function editClick(theForm){
  theForm.action= "Edit_Operator.jsp";
  theForm.submit();
}
function delClick(theForm){
  theForm.action ="delOperatorAction.jsp";
  theForm.submit();
}
function authClick(theForm){
   theForm.action= "AuthorityList.jsp";
   theForm.submit();
}

function selectNo(fieldName,Index)
{
        
         document.form1.elements[fieldName].options[Index].selected  =true;	
	 return;
}
</script>





