<%@ page  import="ken.*" contentType="text/html;charset=gb2312"%>
<jsp:useBean id="LogOperator" scope="session" class="ken.LogOperator" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> 更新内容 </TITLE>
</HEAD>

<BODY>

<form name="form1" method="post" action="receive.jsp">
  <table width="94%" border="1">
    <tr> 
      <td width="13%">更新内容</td>
      <td colspan="2" width="87%"> 
        <textarea name="content" cols="85"></textarea>
      </td>
    </tr>
    <tr> 
      <td width="13%" height="21">告诉对象</td>
      <td colspan="2" width="87%" height="21">
        <input type="checkbox" name="checkbox1" value="0">
        1类用户
        <input type="checkbox" name="checkbox2" value="0">
        2类用户 
        <input type="checkbox" name="checkbox3" value="0">
        3类用户</td>
    </tr>
    <tr> 
      <td colspan="3"> 
        <div align="center">
          <input type="submit" name="Submit" value="确定">
          <input type="reset" name="Submit2" value="重设">
        </div>
      </td>
    </tr>
  </table>
</form>
</BODY>
</HTML>
