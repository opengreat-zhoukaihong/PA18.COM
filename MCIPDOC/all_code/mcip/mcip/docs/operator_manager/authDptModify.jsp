<%@ include file="PublicUser.jsp" %>
<jsp:useBean id="ub"  scope="session" class="beans.UserManagerBean"/>

<jsp:setProperty name="ub" property="*"/>
<%

    java.lang.String dptIDs[] = request.getParameterValues("c_dpt_cde");
    java.lang.String delDptIds[] =  request.getParameterValues("del_dpt_cde");
    Hashtable suptable= ub.getLoggerDptList();
    Hashtable dptTable = ub.getOprDptList();
    
    if(delDptIds!=null && dptTable!=null){
      for(int i= 0 ;i< delDptIds.length; i++){
       dptTable.remove(delDptIds[i]);
      }
    }
    
    if(dptIDs!=null){
      int Len = dptIDs.length;
      int i;
      if(dptTable==null)dptTable = new Hashtable();
      for(i=0 ; i< Len ;i++){
       dptTable.put(dptIDs[i], suptable.get(dptIDs[i]));
     }
     ub.setOprDptList(dptTable);
     if(i==Len){%>
       <a href="javascript:window.close()">¹Ø±Õ</a>
     <% }
     }else{%>
       <a href="javascript:window.close()">¹Ø±Õ</a>
     <%}%>

