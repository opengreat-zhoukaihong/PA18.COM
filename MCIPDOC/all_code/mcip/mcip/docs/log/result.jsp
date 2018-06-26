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
  boolean flag1;
  boolean flag2;
  boolean flag3;
  Hashtable tH = new Hashtable();
  if(request.getParameter("checkbox1")==null){
    //System.out.println("0");
	flag1 = false;
  }else{
    //System.out.println("1");
	flag1 = true;
	tH = LogOperator.getNewLog(1);
    out.println("对象1");
	out.println("更新日期:"+tH.get("LogDate"));
	out.println("<br>");
    out.println("更新内容:"+tH.get("LogContent"));
		out.println("<br>");
  }
  if(request.getParameter("checkbox2")==null){
    //System.out.println("0");
	flag2 = false;
  }else{
    //System.out.println("2");
	flag2 = true;
	tH = LogOperator.getNewLog(2);
    out.println("对象2");
	out.println("更新日期:"+tH.get("LogDate"));
	out.println("<br>");
    out.println("更新内容:"+tH.get("LogContent"));
	out.println("<br>");
  }
  if(request.getParameter("checkbox3")==null){
    //System.out.println("0");
	flag3 = false;
  }else{
    //System.out.println("3");
	flag3 = true;
	tH = LogOperator.getNewLog(3);
    out.println("对象3");
	out.println("更新日期:"+tH.get("LogDate"));
	out.println("<br>");
    out.println("更新内容:"+tH.get("LogContent"));
	out.println("<br>");
  }
%>

</BODY>
</HTML>
