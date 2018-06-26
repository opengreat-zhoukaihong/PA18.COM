<html>
<head>
<title>个人用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<style type="text/css">
<!--
.no {  border-top-width: auto; border-right-width: auto; border-bottom-width: auto; border-left-width: auto}
-->
</style>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<%@ include file="public/PublicCust.jsp" %>      

<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>


<%  //The folloing is to getData from database and display on page
    int i = 0;
    int j = 0;
//           out.println("pppppppppyyyyyypppppppp");   
    String National[][] = null; 
    String Area[][] = null;
    String Province[][] = null;
    String Edu[][] = null;
    String Duty[][] = null;
    String Title[][] = null;
    String Major[][] = null;
    String City[][] = null;    
        
    try
    {
        sb.setFieldValue(Const.GET_NATIONAL,"");
        National = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_AREA,"");
        Area = sb.getRetValueArra();
        
        sb.setFieldValue(Const.GET_PROVINCE,"");
        Province = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CITY,"");
        City = sb.getRetValueArra();
        
        sb.setFieldValue(Const.GET_EDU,"");
        Edu = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_DUTY,"");
        Duty = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_TITILE,"");
        Title = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_MAJOR,"");
        Major = sb.getRetValueArra();
        
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }

    int NationalLen =  Servlets.getLen(National);
    int AreaLen = Servlets.getLen(Area);   
    int ProvinceLen = Servlets.getLen(Province);   
    int EduLen = Servlets.getLen(Edu);   
    int DutyLen = Servlets.getLen(Duty);   
    int TitleLen = Servlets.getLen(Title);   
    int MajorLen = Servlets.getLen(Major);       
    int CityLen = Servlets.getLen(City);           
String JS = ServTool.JSMake(City,Province,"1");
%>
<script LANGUAGE="JavaScript">
<%out.println(JS);%>
</script>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>


 <table width="778" border="0" cellspacing="0" cellpadding="0" height="509">
	<%@ include file="public/PublicRegTop.html" %>	
  <tr>
    <td height="405"> 
      <table width="778" border="0" cellspacing="0" cellpadding="0" height="509">
        <tr>
          <td width="102">&nbsp;</td>
          <td width="563" valign="top"> 
            <p><img src="images/zcxyh.gif" width="153" height="52"></p>
            <table width="96%" border="0" cellspacing="0" cellpadding="0" height="34">
              <tr>
                <td width="78%" class="title"><font color="#ff0000">个人用户注册：</font></td>
                <td width="22%">　<font color="#FF0000">打*的项目必须填写</font></td>
              </tr>
            </table>
            <table width="99%" border="0" cellspacing="0" cellpadding="0" height="68">

      <form method="POST" action="AcceptPrsnCustOut.jsp" onSubMit="return(
ValidDateNew(tempdate,birth_year) &&
ValidNull(C_USER_ID,false) &&
ValidNull(C_User_pw,false) &&
ValidNull(ConfirmPassword,false) && 
ValidNull(C_CLNT_NME,false) &&
ValidNull(C_RGST_NO,false) && 
ValidNull(C_TEL,false) &&
ValidNull(C_EMAIL,false) && 
ValidNull(C_PROVINCE,false) && 
ValidNull(C_CITY,false) &&
ValidNull(C_PLACE,false) && 
ValidSame(C_User_pw,ConfirmPassword) &&
ValidInt(C_RGST_NO) &&
ValidTel(C_TEL) &&
ValidTel(C_FAX)&&
ValidEmail(C_EMAIL));">
              <tr> 
                <td width="18%"> 
                  <div align="right">用户名：</div>
                </td>
                <td width="33%"> 
              <input type="text" name="C_USER_ID" size="20" maxlength="12">*</td>
                <td width="17%"> 
                  <div align="right"></div>
                </td>
                <td width="33%">&nbsp;</td>
              </tr>
              <tr> 
                <td width="18%"> 
                  <div align="right">请输入密码：</div>
                </td>
                <td width="33%"> 
              <input type="password" maxlength="8" name="C_User_pw" size="20">*</td>
                <td width="17%"> 
                  <div align="right">确认密码：</div>
                </td>
                <td width="33%">
              <input type="password" maxlength="8" name="ConfirmPassword" size="20">*</td>
              </tr>
              <tr> 
                <td width="18%"> 
                  <div align="right">密码提示问题：</div>
                </td>
                <td width="33%"> 
              <input maxlength="64" name="C_Pw_Question" size="20">
                </td>
                <td width="17%"> 
                  <div align="right">密码提示答案：</div>
                </td>
                <td width="33%">
              <input maxlength="64" name="C_Pw_Result" size="20">
                </td>
              </tr>
            </table>
            <p class="title">个人信息：</p>
            <table width="99%" border="1" cellspacing="1" cellpadding="0" height="284">
              <tr bordercolor="#FFFFFF"> 
                <td width="18%" bordercolor="#FFFFFF" bgcolor="#F6F6F6"> 
                  <div align="right">真实姓名：</div>
                </td>
                <td width="33%"><input type="text" name="C_CLNT_NME" size="25" maxlength="100">*</td>
                <td width="17%" bgcolor="#F6F6F6"> 
                  <div align="right">身份证号码：</div>
                </td>
                <td width="33%"><input type="text" name="C_RGST_NO" size="25" maxlength="20">*</td>
              </tr>
              <tr bordercolor="#FFFFFF"> 
                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">性别：</div>
                </td>
                <td width="33%"> 
              <input type="radio" name="C_SEX" value="M" checked>
              男
              <input type="radio" name="C_SEX" value="F">
              女</td>
                <td width="17%" bgcolor="#F6F6F6"> 
                  <div align="right">出生年月：</div>
                </td>
                <td width="33%"> 
              <input type="text" name="birth_year" size="6" maxlength="4">
              年
              <input type="text" name="birth_month" size="3" maxlength="2">
              月
              <input type="text" name="birth_day" size="3" maxlength="2">
              日*</td>
                      <input type="hidden" name="tempdate" value="2000-08-23">
          </tr>
              <tr bordercolor="#FFFFFF"> 
                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">最高学历：</div>
                </td>
                <td width="33%"> 
              <select name="C_EDU_CDE" size="1">
                <option selected value="">请选择</option>
                <%
                   if(EduLen > 1)
                   {
        	      int c_education_cde = Objects.getColNum("c_education_cde",Edu);
        	      int c_education_cnm = Objects.getColNum("c_education_cnm",Edu);        	      
                      for(i = 1; i < EduLen; i++)
                      {
                %>
                          <option value= <%=Edu[i][c_education_cde]%>> <%=Edu[i][c_education_cnm]%> </option>
                <%
                       }
                    }   
                %>          
              </select>
            </td>

                <td width="17%" bgcolor="#F6F6F6"> 
                  <div align="right">职业：</div>
                </td>
                <td width="33%"> 
              <select name="C_DUTY" size="1">
                <option value="">请选择</option>
                <%
                   if(DutyLen > 1)
                   {
        	      int c_profession_cde = Objects.getColNum("c_profession_cde",Duty);        	                         
        	      int c_profession_cnm = Objects.getColNum("c_profession_cnm",Duty);        	                         
                      for(i = 1; i < DutyLen; i++)
                      {
                %>
                          <option value= <%=Duty[i][c_profession_cde]%>> <%=Duty[i][c_profession_cnm]%> </option>
                <%
                       }
                    }   
                %>          
              </select>
              </td>
              
          </tr>
              <tr bordercolor="#FFFFFF"> 
                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">省/直辖市：</div>
                </td>
                <td width="33%"> 

		  <input type="hidden" name="C_ARA_CDE" value="<%=Const.CHINA_CDE%>"> 
              <select name="C_PROVINCE" size="1" onChange="changeCity(C_PROVINCE,C_CITY);return true;">
                <option selected value="">请选择</option>
                <%
                   if(ProvinceLen > 1)
                   {
        	      int c_city = Objects.getColNum("c_city",Province);
  	              int c_city_cnm = Objects.getColNum("c_city_cnm",Province);
//                      int c_dpt_cde =  Objects.getColNum("c_dpt_cde",Province);
                      String value = "";
                      for(i = 1; i < ProvinceLen; i++)
                      {
//			value = Province[i][c_city]+"&"+Province[i][c_dpt_cde];                      
                %>
                          <option value= <%=Province[i][c_city]%>> <%=Province[i][c_city_cnm]%> </option>
                <%
                       }
                    }   
                %>          
              </select>*</td>
                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">市/县/区：</div>
                </td>
                <td width="33%"> 
	<select name="C_CITY" size="1">
                <option selected value="">请选择</option>	
          <%
               if(CityLen > 1)
                   {
        	       int c_city = Objects.getColNum("c_city",City);
  	               int c_city_cnm = Objects.getColNum("c_city_cnm",City);
                      int c_dpt_cde =  Objects.getColNum("c_dpt_cde",City);
                      String value = "";
                      for(i = 1; i < CityLen; i++)
                      {
                          value = City[i][c_city]+"&"+City[i][c_dpt_cde]; 
//System.out.println(City[i][0]+"***"+City[i][1]+"***"+City[i][2]+"***"+City[i][3]+"***"+City[i][4]+"***");                      
          %>
                          <option value= <%=value%>> <%=City[i][c_city_cnm]%> </option>
         <%       
                       }
                    }   
          %>          
          </select>*</td>

          </tr>
              <tr bordercolor="#FFFFFF"> 
        
                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">详细地址：</div>
                </td>
                <td width="33%"> 
              <input type="text"  name="C_PLACE"  size="25" maxlength="100">*</td>

                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">邮编：</div>
                </td>
                <td width="33%"> 
              <input type="text" name="C_ZIP_CDE" size="20" maxlength="6">
               </td>

             </tr>

              <tr bordercolor="#FFFFFF"> 
                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">电话号码：</div>
                </td>
                <td width="31%"> 
              <input type="text" name="C_TEL" size="25" maxlength="20">*</td>
                <td width="17%" bgcolor="#F6F6F6"> 
                  <div align="right">E-mail：</div>
                </td>
                <td width="33%"> 
              <input type="text" name="C_EMAIL" size="25" maxlength="60">*</td>
          <tr>

              <tr bordercolor="#FFFFFF"> 
                <td width="18%" bgcolor="#F6F6F6"> 
                  <div align="right">传真：</div>
                </td>
                <td width="33%"> 
              <input type="text" name="C_FAX" size="25" maxlength="20">
                </td>

                <td width="18%" bgcolor="#F6F6F6"> 
                </td>
                <td width="33%"> 
                </td>
          </tr>
 
        </table>
        <p>&nbsp;&nbsp;</p>
            <div align="center">
              <input type="submit" value="提  交" name="B1" onclick="change(birth_year,birth_month,birth_day,tempdate);">
              <input type="reset" value="重  填" name="B2">
              <input type="button" value="返  回" onclick="history.back()"> 
            </div>
            </td>
          <td width="113">&nbsp;</td>
        </tr>
      </table>
      </form>
    </td>
  </tr>
</table><br><br>

<%@ include file="public/PublicBottom.html" %>      
      
</body>
</html>
