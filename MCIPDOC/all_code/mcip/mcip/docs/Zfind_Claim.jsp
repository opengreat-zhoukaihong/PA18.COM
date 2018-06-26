<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>      

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 

<%@ include file="public/PublicInquireLeft.jsp" %>      
    <td width="613" height="288" valign="top"> <br>
      <img src="images/m_inq3.gif" width="150" height="31" alt="报案查询">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
form1.check[2].focus();
</SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
  function checkIsnull(fieldOption,fieldply)
  {

     var valuestr = fieldply.value;
     if(fieldOption[0].checked && valuestr=="")
     {
        alert("根据报案号查询，请输入报案号");
        return false;
     }

     return true;
  }
</SCRIPT>

<%

    String userid[] = new String[1];
    userid[0] = sessionbuffer.getuserId(Locate);   
	GregorianCalendar gc = new GregorianCalendar();
	int year = gc.get(gc.YEAR);
	int month = gc.get(gc.MONTH);
	int minday = gc.getActualMinimum(gc.DAY_OF_MONTH);
	int maxday = gc.getActualMaximum(gc.DAY_OF_MONTH);
	month++;//month in GregorianCalendar is zero based
	
%>

     <form name="form1" method="POST" action="Zclm_rpt_list.jsp" onsubmit="return(
   IsChecked2(check[1]) ||
   ( ValidDateNew(tempdatefr,from_year)&&
   ValidDateNew(tempdateto,to_year) )
);">

		<input TYPE="hidden" NAME="userid" VALUE="<%=userid[0]%>">
		<input TYPE="hidden" NAME="sessionid" VALUE="<%=request.getParameter("sessionid")%>">
 	<input TYPE="hidden" NAME="claim" VALUE="claim">

        <table border="0" width="70%" bgcolor="#F6F6F6" align="left">
          <tr>
            <td bgcolor="#F6F6F6" valign="top"> 
              <p>1、请选择您的查询方式</p>
              <blockquote> 
                <p><input type="radio" name="check" value="1" onclick="PlyDisableNew(check,C_RPT_NO,from_year,from_month,from_day,to_year,to_month,to_day);">
                报案号 
                  <input type="radio" name="check" value="2" onclick="PlyDisableNew(check,C_RPT_NO,from_year,from_month,from_day,to_year,to_month,to_day);">
                  报案时间
                  <input type="radio" name="check" value="0" checked onclick="PlyDisableNew(check,C_RPT_NO,from_year,from_month,from_day,to_year,to_month,to_day);"
							onfocus="PlyDisableNew(check,C_RPT_NO,from_year,from_month,from_day,to_year,to_month,to_day);">
                  所有报案号</p>
              </blockquote>
              <p>2、请输入您的查询条件</p>
              <blockquote> 

				  <p>报案号：
                <input type="text" name="C_RPT_NO" maxlength="20">
                 </p><p> 报案时间范围: &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                  &nbsp;&nbsp;&nbsp;&nbsp; </p>
               <p>&nbsp;&nbsp;&nbsp;&nbsp;从: 
                  <input type="text" name="from_year" size="4" maxlength="4" value="<%=year%>">
                  年 
                  <input type="text" name="from_month" size="2" maxlength="2" value="<%if (month<10) out.println("0"); %><%=month %>">
                  月 
                  <input type="text" name="from_day" size="2" maxlength="2" value="0<%=minday %>">
                  日 
					<br>
                 &nbsp;&nbsp;&nbsp;&nbsp;到: 
                  <input type="text" name="to_year" size="4" maxlength="4" value="<%=year%>"">
                  年 
                  <input type="text" name="to_month" size="2" maxlength="2" value="<%if (month<10) out.println("0"); %><%=month %>">
                  月 
                  <input type="text" name="to_day" size="2" maxlength="2" value="<%=maxday %>">
                  日
		</p>
           <input type="hidden" name="tempdatefr" value="2000-08-28">
           <input type="hidden" name="tempdateto" value="2000-08-28">           
                <div align="center"><br>&nbsp;&nbsp;
                  <input type="submit" value="查询" name="B1"  onclick="change(from_year,from_month,from_day,tempdatefr);change(to_year,to_month,to_day,tempdateto);return(checkIsnull(check,C_RPT_NO));">
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="reset" value="清除" name="B22">
                </div>
            </td>
          </tr>
        </table>
        </form>

	</td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
