<%@ page contentType="text/html; charset=GBK" %>
<html>
<head>
<title>
Jsp1
</title>
</head>
<jsp:useBean id="Jsp1BeanId" scope="session" class="mciptest.Jsp1Bean" />
<jsp:setProperty name="Jsp1BeanId" property="*" />
<body>
<h1>
JBuilder Generated JSP
</h1>
<form method="post">
<br>Enter new value   :  <input name="sample"><br>
<br><br>
<input type="submit" name="Submit" value="Submit">
<input type="reset" value="Reset">
<br>
Value of Bean property is :<jsp:getProperty name="Jsp1BeanId" property="sample" />
</form>
</body>
</html>
