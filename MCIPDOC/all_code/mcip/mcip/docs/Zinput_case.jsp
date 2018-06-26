
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<%@ include file="public/Public.jsp" %>
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>
<jsp:useBean id="get"  scope="page" class="beans.PolicyInfoBean"/>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>
     <%@ include file="public/PublicRepLeft.jsp" %> 
    <td width="613" height="288" valign="top"> <br>
      <img src="images/rep_sheet.gif" width="150" height="31" alt="填写报案表">


 <%
 //declear v
    String info[][]=null;
    String insr[][]=null;
    String insrnm[][]=null;
    String plyno=null;

	  String area[][]=null;
    String province[][] = null;
    String city[][] = null;
    String currency[][] = null;

    int arealen=0;
    int provlen=0;
    int citylen=0;
    int currlen=0;

    int i=0;


        sb.setFieldValue(Const.GET_AREA,"");
        area = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_PROVINCE,"");
        province = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CITY,"");
        city = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CURRENCY,"");
        currency = sb.getRetValueArra();
    if(!(area == null))
        arealen = area.length;
    if(!(province == null))
        provlen = province.length;
    if(!(city== null))
        citylen = city.length;
    if(!(currency == null))
        currlen = currency.length;
		plyno=request.getParameter("C_PLY_NO");
		//add by kangjin for no record found bug 2001-4-6
		int index = plyno.indexOf('&');
		if (index != -1)
			plyno = plyno.substring(0,index);
   		get.setFieldValue(Const.GET_POLICYINFO,plyno);
    	info=get.getRetValueArra();

	   sb.setFieldValue(Const.GET_INSURANCEDEFINE,Objects.getValue(1,"c_insrnc_cde",info));
   	insrnm= sb.getRetValueArra();		//main insurance
	  try
	  {
   	get.setFieldValue(Const.GET_PLYAPPRDRINFO,plyno);
    	insr=get.getRetValueArra();	//additional insurance
     }
    catch (Exception e)
    {  }   

String JS = ServTool.JSMake(city,province,"0");
%>
 <script LANGUAGE="JavaScript">
<%out.println(JS);%>
</script>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="Ztool.js"></SCRIPT>

 <form name="EntAnswerForm" method="POST" action="subm_case.jsp" onsubmit="return(
ValidNull(C_ACCDNT_SPOT,false) &&
ValidNull(C_RPT_NME,false) &&
ValidNull(C_ADDR,false) &&
ValidNull(C_RPT_TEL,false) &&
ValidInt(N_RPT_AMT) &&
ValidTel(C_RPT_TEL) &&
ValidYear(T_ACCDNT_YEAR) &&
ValidMonth(T_ACCDNT_MONTH) &&
ValidDay(T_ACCDNT_DAY)
);">

 	<input TYPE="hidden" NAME="sessionid" VALUE="<%=request.getParameter("sessionid")%>">
    	<input TYPE="hidden" NAME="C_INSRNT_CDE" VALUE="<%=Objects.getValue(1,"C_INSRNT_CDE",info)%>">
    	<input TYPE="hidden" NAME="C_INSRNC_CDE" VALUE="<%=Objects.getValue(1,"c_insrnc_cde",info)%>">
    	<input TYPE="hidden" NAME="C_DPT_CDE" VALUE="<%=Objects.getValue(1,"c_dpt_cde",info)%>">
    	<input TYPE="hidden" NAME="T_INSRNC_BGN_TM" VALUE="<%=Objects.getValue(1,"t_insrnc_bgn_tm",info)%>">
    	<input TYPE="hidden" NAME="T_INSRNC_END_TM" VALUE="<%=Objects.getValue(1,"t_insrnc_end_tm",info)%>">

      <font color="#ff0000">■</font> <font color="#0000CC">保单信息</font><br>
       <table width="90%" border="1" bordercolorlight="#FFFFFF">
          <tr> 
            <td bgcolor="#CCCCCC"> 
              保 单 号:</td><td> <%=plyno%> </td>
              <input TYPE="hidden" NAME="C_PLY_NO" VALUE="<%=plyno%>">
            </td>
            <td width="15%" bgcolor="#CCCCCC"> 
              被保险人:</td><td><%=Objects.getValue(1,"C_INSRNT_NME",info)%> 
		<input TYPE="hidden" NAME="C_INSRNT_NME" VALUE="<%=Objects.getValue(1,"C_INSRNT_NME",info)%>">
            </td>
			</tr>
         <tr> 
            <td width="15%" bgcolor="#CCCCCC">货物描述:</td><td> <%=Objects.getValue(1,"C_CRGO_DESC",info)%> </td>
            <td width="15%" bgcolor="#CCCCCC">运输工具:</td><td> <%=Objects.getValue(1,"C_SAIL_NO",info)%> </td>
			</tr>
         <tr> 
             <td width="15%" bgcolor="#CCCCCC">起 运 港:</td><td>
            <% if ( arealen > 0 )
              	 {
              	     for (i=1;i<arealen;i++)
              	     {    
              	        if(area[i][0].equals(Objects.getValue(1,"C_FRM_PRT_ARA",info))) 
              	        {    %>
                         <%=area[i][2]%>
                       
              <%     	  break;
              				}
              			}
                  }   %>
            <%=Objects.getValue(1,"C_FROM_PRT",info)%>
            </td>
           <td width="15%" bgcolor="#CCCCCC">目 的 港:</td><td>
                        <% if ( arealen > 0 )
              	 {
              	     for (i=1;i<arealen;i++)
              	     {    
              	        if(area[i][0].equals(Objects.getValue(1,"C_TO_PRT_ARA",info))) 
              	        {    %>
                         <%=area[i][2]%>
                       
              <%     	  break;
              				}
              			}
                  }   %>
            <%=Objects.getValue(1,"C_TO_PRT",info)%>  </td>
          </tr>
          <tr> 
            <td width="15%" bgcolor="#CCCCCC">起运日期:</td><td> <%=Objects.getValue(1,"T_INSRNC_BGN_TM",info)%>  </td>
            <td width="15%" bgcolor="#CCCCCC">保险金额:</td><td> <%=Objects.getValue(1,"N_AMT",info)%> 
           <input TYPE="hidden" NAME="N_AMT" VALUE="<%=Objects.getValue(1,"n_amt",info)%>">
           <input TYPE="hidden" NAME="C_AMT_CUR" VALUE="<%=Objects.getValue(1,"c_amt_cur",info)%>">
              <% if ( currlen > 0 )
              	 {
              	     for (i=1;i<currlen;i++)
              	     {    
              	        if(currency[i][0].equals(Objects.getValue(1,"C_AMT_CUR",info))) 
              	        {    %>
                         <%=currency[i][1]%>
                       
              <%     	  break;
              				}
              			}
                  }   %>
              
             </td>
          </tr>
          <tr> 
            <td  bgcolor="#CCCCCC"> 保险条件:</td><td colspan="3"> 
               <br>
               <%
               if(insrnm!=null)
               {
               	if(insrnm[0].length>1)   
               	%>	<%=Objects.getValue(1,"c_insrnc_cnm",insrnm)%> <%
               }
               
               if(insr!=null)
               {
               	for(i=1;i<insr[1].length;i++)
               	{	%>
               		<%=Objects.getValue(i,"c_rdr_nme",insr)%>
               <%	}
               }
               %>
            </td>
          </tr>
        </table>
	<br><br>
       <% 	Date mytoday=new Date(); %> 		  
        <font color="#ff0000">■</font> 请填写报案信息<br>
        <table  width="90%" border="0" bgcolor="#F6F6F6">
          <tr> 
            <td colspan="2">货物抵港时间: 
              <input type="text" name="T_ACCDNT_YEAR" size="4" maxlength="4" value="<%=mytoday.getYear()+1900%>">
              年 
              <input type="text" name="T_ACCDNT_MONTH" size="2" maxlength="2" value="<%=mytoday.getMonth()+1%>">
              月 
              <input type="text" name="T_ACCDNT_DAY" size="2" maxlength="2" value="<%=mytoday.getDate()%>">
              日*</font>
	     </td>
          </tr>
          <tr> 
            <td colspan="2">出险地点: 
               <input type="text" name="C_ACCDNT_SPOT" size="60" value="" maxlength="100">*
	    </td>
          </tr>
          <tr> 
            <td colspan="2">出险原因: 
              <input type="text" name="C_ACCDNT_CAUS" size="60" value="" maxlength="100">
            </td>
          </tr>
          <tr> 
            <td colspan="2">损失情况: 
              <input type="text" name="C_LOS_DTL" size="60" value="" maxlength="200">
            </td>
          </tr>
          <tr> 
            <td colspan="2">报损金额:
             <input type="text" name="N_RPT_AMT" size="14" value="" maxlength="17">
              <select name="C_CUR_TYP" size="1">
              <% if ( currlen > 0 )
              	 {
              	     for (i=1;i<currlen;i++)
              	     {     %>
                <option  value="<%=currency[i][0]%>"><%=currency[i][1]%> </option>
              <%     }
                  }   %>
             </select> 
           </td>
	 </tr>
	 <tr>
	   <td colspan="2">&nbsp;
             </td>
	</tr>
	 <tr>
	   <td bgcolor="#7CA3E9" colspan="2">
             </td>
	</tr>
	<tr>
            <td width="50%">报案人:
              <input type="text" name="C_RPT_NME" size="20" value="" maxlength="12">*
	    </td>
	</tr>
	<tr >
          <td colspan="2">所在省/直辖市: 
             <select name="C_PROVINCE" size="1" onChange="editCityName(C_PROVINCE,C_CITY);return true;">
              <% if (provlen>0)
              	 {
              	     for (i=1;i<provlen;i++)
              	     {     %>
                <option  value="<%=province[i][1]%>"><%=province[i][1]%> </option>
              <%     }
                  }   %>
              </select>市/县/区 
              <select name="C_CITY" size="1">
              <% if (citylen>0)
              	 {
              	     for (i=1;i<citylen;i++)
              	     {     %>
                <option  value="<%=city[i][1]%>"><%=city[i][1]%> </option>
              <%     }
                  }   %>
              </select>* 
	   </td>
	</tr>
	<tr>
            <td colspan="2">详细地址: 
              <input type="text" name="C_ADDR" size="40" value="" maxlength="100">
              * </td>
          </tr>
          <tr> 
            <td > 电话: 
             <input type="text" name="C_RPT_TEL" size="20" value="" maxlength="20">
              * </td>
          </tr>
        </table>

          <p align="center"> 
           <input type="submit" value="提交" name="B1"></p>
  </form>
   
      
    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>
</body>
</html>
