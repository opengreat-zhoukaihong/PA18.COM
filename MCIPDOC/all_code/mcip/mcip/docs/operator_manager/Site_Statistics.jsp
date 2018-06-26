
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<jsp:useBean id="bb"  scope="request" class="beans.BusinessManagerBean"/>
<jsp:setProperty name="bb" property="*"/>
<%

    String [][] retValueArra = null;
    int rowCount =0 ;
    String[] argss={""};
    try
    {
        bb.setFormPara(BConst.QUERY_EVENT_TYPELIST,argss);
        retValueArra = bb.getRetValueArra();
        rowCount = retValueArra.length;
    }
    catch(NormalException e)
    {
      if(!(e.getErrCode().equalsIgnoreCase("100000002")))
 	    throw NormalExceptionHandler.Handle(e);
      rowCount =0;
    }
     

%>

<div>
    <div align="center">
          <div align="center"><font color="#0066CC"><span class="unnamed3">网站状态统计报表分类选择</span></font><br>
            <br>
          </div>
<form method="post" action="Site_Statistics_List.jsp" name="busness statistics  classfy select"
    onSubmit="return checkForm(this)" >
  <input type=hidden name="fromdate">
  <input type=hidden name="todate">
  <table width="90%" border="1" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
    <tr bgcolor="#9DEEDE"> 
      <td height="42" width="46%"> 
        <center>
          统计时间段 
        </center>
      </td>
      <td height="42" width="54%"> 
        <center>
          统计类型选择 
        </center>
      </td>
    </tr>
    <tr bgcolor="#DFF9F3"> 
      <td align="left" width="46%">起始时间： 
        <input type="text" name="From_Year"   size="5" maxlength="4" value="2001">
        年 
        <input type="text" name="From_Month"  size="3" maxlength="2" value="01">
        月 
        <input type="text" name="From_Day"  size="3" maxlength="2" value="01">
        日</td>
      <td width="54%"> 
        <input type="radio" name="event"  value="1" checked>
        单一事件 
        <select name="c_event_cde">
          <option selected value="">请选择</option>
          <% if(rowCount>0){
             for(int i=1; i< rowCount ;i++){%>
            <option value="<%=retValueArra[i][0]%>"> <%=retValueArra[i][1]%>
          <%}}
          %>

        </select>
        </select>
      </td>
    </tr>
    <tr bgcolor="#DFF9F3"> 
      <td width="46%">终止时间： 
        <input type="text" name="To_Year"  size="5" maxlength="4" value="2001">
        年 
        <input type="text" name="To_Month" size="3" maxlength="2" value="12">
        月 
        <input type="text" name="To_Day" size="3" maxlength="2" value="31">
        日</td>
      <td width="54%" height="27">
        <input type="radio" name="event" value="0">
        全选（所有事件） </td>
    </tr>
  </table>

  <p><center>

    <input type="submit" name="Submit" value="提交">

    <input type="reset" name="Reset" value="重设"></center>

  </p>

</form>
</div>
<%@ include file="public/bottom.jsp" %>

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
    todate = theForm.To_Year.value + "-" + theForm.To_Month.value + "-" + theForm.To_Day.value  ;
    theForm.todate.value = todate;
	 
	/*window.alert(fromdate);
	window.alert(todate);*/
   if(!ValidDate(theForm.todate)){
       return false;
      }

      if(!checkIsnull(theForm.event, theForm.c_event_cde)){
       return false;
      }
   return true;
  }

  function checkIsnull(fieldOption,fieldply)
  {

     //var valuestr = fieldply.selectevalue;
     var index =0;
     for(i=0 ; i< fieldply.options.length; i++)
     {
         if(fieldply.options[i].selected){
             index =i;
             break;
         }
     }
     if(fieldOption[0].checked && index ==0)
     {
        alert("请选择事件");
        return false;
     }

     return true;
  }
  </script>
