<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_cust"  scope="session" class="beans.CustManagerBean"/> 
<%
	String userid = request.getParameter("userid");
	String [] formPara = new String[1];
	formPara[0] = userid;
	boolean result = false;
  try{
     obj_cust.setFormPara(Const.DELETE_ILLEGAL_USER,formPara);
     result=obj_cust.getRetValueBool();
	 }catch(Exception e){
	 	out.println(e);
	 }
	 if (result)
	 	out.println("成功删除用户："+userid);
	else
		out.println("删除用户\""+userid+"\"失败");
	 %>
	 <br>
	 <input type="button" value="返回" onclick="history.go(-2)">
</body>
</html>
