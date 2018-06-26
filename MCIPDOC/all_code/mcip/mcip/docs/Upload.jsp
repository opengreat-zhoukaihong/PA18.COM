<html>
<head>
<title>平安货运保险-保单上传</title>
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>
<!--end of pulbic-->
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>
<%@ include file="public/PublicPlyLeft.html" %>
<!--end of left-->
    <td width="613" height="288" valign="top">
    <table>
      <tr>
        <td>
          保单上传:
    <FORM METHOD="POST" ACTION="XMLReceiver.jsp" ENCTYPE="multipart/form-data" name="UForm">
      <INPUT TYPE="FILE" NAME="FILE1" SIZE="50" value="d:\mcip\simple.xml"><BR>
      <INPUT TYPE="SUBMIT" VALUE="上传">
    </FORM>
        </td>
      </tr>
    </table>
    </td>
  </tr>
</table>
<script language="JavaScript">
function changeValue(field,newValue){
	field.value= newValue;
	return true;
}
</script>

<%@ include file="public/PublicBottom.html" %>
