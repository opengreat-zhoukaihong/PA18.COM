<html>
<head>
<title>statistics classfy selection</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="description" content="统计报表业务分类选择">
<link rel="stylesheet" href="style.css">
<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<%@ page language="java" import="utility.*,exceptions.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
   response.setHeader("Pragma","No-Cache");
   response.setDateHeader("Expires",0);
   response.setHeader("Cache-Control","no-Cache");

%>
<%
   if(!Init.isInit())
   {
       boolean isOk = false;
       isOk = Init.initAll();
       if(!isOk)
          throw NormalExceptionHandler.Handle(ExceptionCode.SYS_INIT_FAILURE);
       
   }    
%>
</head>

<body bgcolor="#FFFFFF">

<div align="right">

<address style="border-bottom: 1px dotted">
  平安保险
</address>
</div>

<h2><center>统计报表业务分类选择</center></h2>
<br>
<form method="post" action="Bus_Statistics_form.htm" name="busness statistics  classfy select"
  onSubmit= "return checkForm(this)">
<input type=hidden name=fromdate>
<input type=hidden name=todate>
  <table width="100%" border="1">
    <tr> 
      <td height="42" width="46%"> 
        <center>
          统计时间段 
        </center>
      </td>
      <td height="42" width="54%"> 
        <center>
          分类业务 
        </center>
      </td>
    </tr>
    <tr> 
      <td align="left" width="46%">起始时间： 
        <input type="text" name="From_Year" 		size="5" maxlength="4" value="2000">
        年 
        <input type="text" name="From_Month"size="3" maxlength="2" value="01">
        月 
        <input type="text" name="From_Day" size="3" maxlength="2" value="01">
        日</td>
      <td width="54%"> 
        <input type="checkbox" name="total" value="ON" checked>
        总业务量</td>
    </tr>
    <tr> 
      <td width="46%">终止时间： 
        <input type="text" name="To_Year" size="5" maxlength="4" value="2000">
        年 
        <input type="text" name="To_Month" size="3" maxlength="2" value="12">
        月 
        <input type="text" name="To_Day" size="3" maxlength="2" value="31">
        日</td>
      <td width="54%" height="27"> 
        <input type="checkbox" name="insrnc" value="ON"> 分险种业务 
        <select name="c_insrnc_cde">
          <option selected value="">请选择</option>
        </select>
      </td>
    </tr>
    <tr> 
      <td width="46%" height="26" noborder>&nbsp;</td>
      <td width="54%" height="26"> 
        <input type="checkbox" name="dpt" value="ON">
        分机构业务 
        <select name="c_dpt_cde">
          <option selected value="">请选择</option>
        </select>
      </td>
    </tr>
    <tr> 
      <td width="46%">&nbsp;</td>
      <td width="54%"> 
        <input type="checkbox" name="bsns" value="ON">
        分来源业务 
        <select name="c_bsns_typ">
          <option selected value="">请选择</option>
        </select>
      </td>
    </tr>
    <tr> 
      <td width="46%">&nbsp;</td>
      <td width="54%"> 
        <input type="checkbox" name="open_cover" value="ON">
        开口保单 </td>
    </tr>
    <tr>
      <td width="46%">&nbsp;</td>
      <td width="54%">
        <input type="checkbox" name="agent" value="ON">
        代理业务 </td>
    </tr>
  </table>
  <p><center> <a href="BackManage.htm">返回 </a>
    <input type="submit" name="Submit" value="提交">
    <input type="reset" name="Reset" value="重设"></center>
  </p>
</form>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p>
</body>
</html>
<script language=JavaScript>
  function checkForm(theForm){
    if(!ValidYear(theForm.From_Year)){
             return false;
    }
    if(!ValidMonth(theForm.From_Month)){
             return false;
    }
    if(!ValidDay(theForm.From_Day)){
             return false;
    }

    if(!ValidYear(theForm.To_Year)){
             return false;
    }
    if(!ValidMonth(theForm.To_Month)){
             return false;
    }
    if(!ValidDay(theForm.To_Day)){
             return false;
    }
    fromdate = theForm.From_Year.value + "-" + theForm.From_Month.value  + "-" + theForm.From_Day.value ;
    theForm.fromdate.value = fromdate;
    if(!ValidDate(theForm.fromdate)){
       return false;
      }
    todate = theForm.To_Year.value + "-" + theForm.To_Month.value + "-" + theForm.To_Day.value;
    theForm.todate.value = todate;
    if(!ValidDate(theForm.todate)){
       return false;
      }

   return false;
  }
  </script>
