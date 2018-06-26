<% String clientName = request.getParameter("clientName");%>
<html>
<head>
<title><%=clientName%></title>
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%

   String serverName = request.getParameter("serverName");
   MessageBean mb = MessageBean.instance;
   if(!mb.IsClientLogged(clientName)){%>  
     <script language=JavaScript>
      alert("<%=clientName%>"+"¸Õ¸ÕÍË³ö!");
      window.close();
     </script>
   <%}else{
   boolean succ =false;
   String transfter ="no";
   if(request.getParameter("accept")!=null){
        try{
          succ= mb.SetConnection(clientName, serverName);
        }catch(Exception e){
         e.printStackTrace();
        }
    }else{
        transfter ="yes" ;
    }
    String sessionId = clientName +"_"+ serverName;
    String subject =  request.getParameter("subject");
	

    if(subject==null){
		//session.setAttribute("noSub","yes");
		subject="Have no subject";
	}else{
		//session.setAttribute("noSub","no");
	}

%>
<frameset frameborder="1" border="0" rows="400,0,*" >
  <frame target="up" name="up" src="ServerContent.jsp?transfter=<%=transfter%>&sessionId=<%=sessionId%>&subject=<%=subject%>">
  <frame target="cl" name="cl" src="GetServerContent.jsp?sessionId=<%=sessionId%>">
  <frame target="down" name="down" src="AddServerMsg.jsp?sessionId=<%=sessionId%>&subject=<%=subject%>" name="down" marginwidth="4">
  <noframes>
  </noframes>
</frameset>
<%}%>

</html>
<script language=JavaScript>
function window_close(){
 url ="ServerClose.jsp?clientName="+"<%=clientName%>";
 newwin =  "&";
 //window.open(url,newwin,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizeable=no,width=0,height=0");
 window.location = url;
}

</script>
