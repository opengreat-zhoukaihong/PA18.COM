<%@ page  import="ken.*" contentType="text/html;charset=gb2312"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="LogOperator" scope="session" class="ken.LogOperator" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> 更新内容操作结果 </TITLE>
</HEAD>

<BODY>
<%
  String absolutePath = request.getRealPath("/");
  String url = absolutePath+"log/";
  LogOperator.setLogName(url+"log1.log",url+"log2.log",url+"log3.log");
  String content = request.getParameter("content").toString();
  out.println("content is :"+content);
  Hashtable tH = new Hashtable();
  boolean flag1;
  boolean flag2;
  boolean flag3;
  if(request.getParameter("checkbox1")==null){
    //System.out.println("0");
	flag1 = false;
  }else{
    //System.out.println("1");
	flag1 = true;
  }
  if(request.getParameter("checkbox2")==null){
    //System.out.println("0");
	flag2 = false;
  }else{
    //System.out.println("2");
	flag2 = true;
  }
  if(request.getParameter("checkbox3")==null){
    //System.out.println("0");
	flag3 = false;
  }else{
    //System.out.println("3");
	flag3 = true;
  }
  tH.put("1",content);
  tH.put("2",content);
  tH.put("3",content);
  boolean flag = LogOperator.addNewLog(tH,flag1,flag2,flag3);
%>
<script language="javascript">
<%
  if(flag){
%>
  alert("更新日志操作成功！");
  document.location.href="input.jsp";
<%
  }	else{
%>
  alert("更新日志操作失败！");
  document.location.href="input.jsp";
<%
  }	
%>
</script>
</BODY>
</HTML>
