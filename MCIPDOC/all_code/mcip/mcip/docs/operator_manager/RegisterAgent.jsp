<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>

<div align="center"><font color="#0066CC" class="unnamed3">后 台 用 户 注 册</font><br><br></div>
<form action="RegisterNext.jsp" method="post" onsubmit="return(
ValidNull(UserID,false) &&
ValidNull(UserPassword,false) &&
ValidNull(ConfirmPassword,false)&&
ValidNull(Code)&&
ValidUserPwd(UserID,'0') &&
ValidUserPwd(UserPassword,'1') &&
ValidSame(UserPassword,ConfirmPassword)) ;">
 <table width="100%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr>
		<td width="14%"><font color="#ff0000">机构客户资料录入：</font></td>
		<td width="52%" align="right">
		<font color="#FF0000">打*的项目必须填写</font>
		</td>
	</tr>
	<tr>
		<td width="66%" colspan="2"><font color="#3300FF">如果您已经是www.pa18.com 用户，你想继续使用www.pa18.com的用户名吗?
					 <br><input type="radio" name="RegisterType" value="1"> 是
										<input type="radio" name="RegisterType" value="0" checked>否
												请在下面输入您原用户名和密码，以便检查。
				</font>
		</td>
	</tr>
	<tr>
		<td width="14%">用户名：</td>
		<td width="52%"><input type="text" name="UserID" size="18" maxlength="16">* (长度为3至16位,由小写字母,数字组成(<font color="#FF0000">且首位为小写字母或2</font>)</td>
	</tr>
	<tr>
		<td width="14%">请输入密码：</td>
		<td width="52%"><input type="password" maxlength="15" name="UserPassword" size="18">* (长度只能为6至15位,由小写字母,数字组成)</td>
	</tr>
	<tr>
		<td width="14%">验证密码：</td>
		<td width="52%"><input type="password" maxlength="15" name="ConfirmPassword" size="18">*</td>
	</tr>
	<tr>
		<td width="14%">
				编码：
		</td>
		<td width="52%"><input type="text" name="Code" size="18" maxlenth="12">*<input type="radio" value="AGENT" name="codeType" checked>代理人编码<input type="radio" value="OPEN_COVER"  name="codeType">预约客户编码</td>
	</tr>
	<tr>
		<td width="66%" colspan="2" align="center">
				<input type="submit" value="下一步>>">
		</td>
	</tr>
</table>
</form>
<%@ include file="public/bottom.jsp" %>
