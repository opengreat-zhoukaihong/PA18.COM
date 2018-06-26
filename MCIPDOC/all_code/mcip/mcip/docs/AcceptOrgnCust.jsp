<html>
<head>
<title>机构用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<style type="text/css">
<!--
.no {  border-top-width: auto; border-right-width: auto; border-bottom-width: auto; border-left-width: auto}
-->
</style>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" >

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>

<%@ include file="public/PublicCust.jsp" %>      

<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>


<%  //The folloing is to getData from database and display on page
    int i = 0;
    int j = 0;
//           out.println("pppppppppyyyyyypppppppp");   
    String TradeType[][] = null; 
    String OrgType[][] = null;
    String Province[][] = null;
    String Ownership[][] = null;
    String Area[][] = null;
    String Scale[][] = null;
    String PremiumScale[][] = null;
    String City[][] = null;        

    try
    {
        sb.setFieldValue(Const.GET_TRADETYPE,"");
       TradeType = sb.getRetValueArra();

          sb.setFieldValue(Const.GET_ORGTYPE,"");
          OrgType = sb.getRetValueArra();
        
        sb.setFieldValue(Const.GET_PROVINCE,"");
      Province = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CITY,"");
        City = sb.getRetValueArra();
        
          sb.setFieldValue(Const.GET_OWNERSHIP,"");
          Ownership = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_AREA,"");
        Area = sb.getRetValueArra();

          sb.setFieldValue(Const.GET_SCALE,"");
          Scale = sb.getRetValueArra();

          sb.setFieldValue(Const.GET_PREMIUMSCALE,"");
          PremiumScale = sb.getRetValueArra();
        
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }
    
    int TradeTypeLen = Servlets.getLen(TradeType);
    int OrgTypeLen = Servlets.getLen(OrgType);   
    int ProvinceLen = Servlets.getLen(Province);   
    int OwnershipLen = Servlets.getLen(Ownership);   
    int AreaLen = Servlets.getLen(Area);   
    int ScaleLen = Servlets.getLen(Scale);   
    int PremiumScaleLen = Servlets.getLen(PremiumScale);   
    int CityLen = Servlets.getLen(City);               
    
String JS = ServTool.JSMake(City,Province,"1");
%>
<script LANGUAGE="JavaScript">
<% out.println(JS);%>
</script>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
 orgnCust.C_PROVINCE.focus();
// orgnCust.C_USER_ID.focus();
window.scrollTo(0,0);
</SCRIPT>


<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
  function setAddress(flag,fieldProv,fieldCity,fieldPlace)
  {
      var index1 = fieldProv.options.selectedIndex;
      var index2 = fieldCity.options.selectedIndex; 
      var valueofplace = fieldPlace.value;
      if(flag=="0" && index1 > 0)
      { 
         valueofplace = fieldProv.text;
      }
      else if(flag=="1" && index2 > 0)
      {
        valueofplace = fieldCity.options[index2].text;         
      }  
      fieldPlace.value = valueofplace;
     
      return;
  } 
</SCRIPT>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
   	orgnCust.C_USER_ID.focus();
</SCRIPT>

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
                <td width="78%" class="title"><font color="#ff0000">机构客户资料录入：</font></td>
                <td width="22%">　<font color="#FF0000">打*的项目必须填写</font></td>
              </tr>
            </table>
            <table width="100%" border="0" cellspacing="1" cellpadding="0" height="68">
            
<form name="orgnCust" method="POST" action="AcceptOrgnCustOut.jsp" onsubmit="return(
ValidNull(C_USER_ID,false) &&
ValidNull(C_User_pw,false) &&
ValidNull(ConfirmPassword,false) &&
ValidNull(C_CLNT_CDE,false) &&
ValidNull(C_OWNERSHIP_CDE,false) &&
ValidNull(C_CHIEF,false) &&
ValidNull(C_PROVINCE,false) &&
ValidNull(C_CITY,false) &&
ValidNull(C_PLACE,false) &&
ValidNull(C_CNTCT_PRSN_NME,false) &&
ValidNull(C_TEL,false) &&
ValidNull(C_EMAIL,false) &&
ValidNull(C_FAX,false) &&
ValidNull(C_ZIP_CDE)&&
ValidUserPwd(C_USER_ID,'0') &&
ValidUserPwd(C_User_pw,'1') &&
ValidSame(C_User_pw,ConfirmPassword)&&
ValidEmail(C_EMAIL)&&
ValidTel(C_TEL)&&
ValidInt(C_ZIP_CDE)&&
ValidZip(C_ZIP_CDE)&&
ValidTel(C_FAX)) ;">

          <tr>
          <td colspan="5">
	          <font color="#3300FF">如果您已经是www.pa18.com 用户，你想继续使用www.pa18.com的用户名吗?
					 <br><input type="radio" name="RegisterType" value="1"> 是
                    <input type="radio" name="RegisterType" value="0" checked>否
												请在下面输入您原用户名和密码，以便检查。
				</font>
				<br>
          </td>
          </tr>
          <tr>
            <td width="18%" bgcolor="#F6F6F6"><p align="right">用户名： </td>
              <td colspan="4"><input type="text" name="C_USER_ID" size="18" maxlength="16" onfocus="changeCity(C_PROVINCE,C_CITY);setSelectedIndex(C_CITY,selectedCity)">*
              (长度为3至16位,由小写字母,数字组成<font color="#FF0000">且首位为小写字母</font>)</td>
          </tr>
          <tr>
            <td width="18%" bgcolor="#F6F6F6"><p align="right">请输入密码： </td>
              <td colspan="4"><input type="password" maxlength="15" name="C_User_pw" size="18">*
		(长度只能为6至15位,由小写字母,数字组成)</td>
          </tr>
          <tr>
            <td width="18%" bgcolor="#F6F6F6"><p align="right">确认密码： </td>
              <td width="31%"><input type="password" maxlength="15" name="ConfirmPassword" size="18">*</td>
              <td colspan="4"></td>

          </tr>

<!--          <tr>
            <td width="18%"><p align="right">密码提示问题： </td>
              <td width="31%"><input maxlength="100" name="C_Pw_Question" size="22"></td>
            <td width="18%"><p align="right">密码提示答案： </td>
              <td width="31%"><input maxlength="50" name="C_Pw_Result" size="16"></td>
          </tr>
-->          
        </table>
        <p>&nbsp;</p>
		  <span class="title">企业信息：</span><br>
        <table width="100%" border="1" cellspacing="1" cellpadding="0" height="332">
          <tr bordercolor="#FFFFFF">
            <td bgcolor="#F6F6F6" align="right">企业名称：</td>
            <td nowrap><input type="text" name="C_CLNT_CDE" size="26" maxlength="150">*</td>
			<!--
            <td align="right" bgcolor="#F6F6F6" >中文简称：</td>
            <td><input type="text" name="C_CHN_ABR" size="18" maxlength="12"></td>
          </tr>
          <tr bordercolor="#FFFFFF">
		  -->
            <td bgcolor="#F6F6F6" align="right">英文名称：</td>
            <td><input type="text" name="C_BRD_ENM" size="26" maxlength="100">
            </td>
			<!--
            <td align="right" bgcolor="#F6F6F6">英文简称：</td>
            <td><input type="text" name="C_ENG_ABR" size="18" maxlength="12">
            </td>
			-->
          </tr>
          <tr bordercolor="#FFFFFF">
            <td bgcolor="#F6F6F6" nowrap align="right">工商登记号：</td>
            <td> <input type="text" name="C_RGST_NO" size="26" maxlength="20">
            </td>
            <td nowrap align="right" bgcolor="#F6F6F6">行业：</td>
            <td>
            <select name="C_TRD_CDE" size="1">
                <option selected value="">请选择</option>
                <%
                   if(TradeTypeLen > 1)
                   {
        	      int c_trd_cde = Objects.getColNum("c_trd_cde",TradeType);        	                                            
        	      int c_trd_cnm = Objects.getColNum("c_trd_cnm",TradeType);        	                                            
                      for(i = 1; i < TradeTypeLen; i++)
                      {
                %>
                          <option value="<%=TradeType[i][c_trd_cde]%>"><%=TradeType[i][c_trd_cnm]%></option>
                <%
                       }
                    }   
                %>          
              </select>
            </td>
          </tr>
          <tr bordercolor="#FFFFFF">
		  <!--by Lawrence 2001-3-28
            <td bgcolor="#F6F6F6" align="right">组织形式：</td>
            <td> <select name="C_ORGZ_TYP_CDE" size="1">
                <option selected value="">请选择</option>
                <%
                   if(OrgTypeLen > 1)
                   {
        	      int c_orgz_typ_cde = Objects.getColNum("c_orgz_typ_cde",OrgType);        	                                            
        	      int c_organization_cnm = Objects.getColNum("c_organization_cnm",OrgType);        	                                            
                      for(i = 1; i < OrgTypeLen; i++)
                      {
                %>
                          <option value= <%=OrgType[i][c_orgz_typ_cde]%>> <%=OrgType[i][c_organization_cnm]%> </option>
                <%
                       }
                    }   
                %>          
              </select>
             </td>
			 -->
            <td align="right" bgcolor="#F6F6F6">所有制：</td>   
               <td>        <select name="C_OWNERSHIP_CDE" size="1">
                <option selected value="">请选择</option>
                <%
                   if(OwnershipLen > 1)
                   {
        	      int c_ownership_cde = Objects.getColNum("c_ownership_cde",Ownership);        	                                            
        	      int c_ownership_cnm = Objects.getColNum("c_ownership_cnm",Ownership);        	                                            
                      for(i = 1; i < OwnershipLen; i++)
                      {
                %>
                          <option value= <%=Ownership[i][c_ownership_cde]%>> <%=Ownership[i][c_ownership_cnm]%> </option>
                <%
                       }
                    }   
                %>          
              </select>*</td>
          </tr>
          <tr bordercolor="#FFFFFF">
            <td bgcolor="#F6F6F6" align="right">法人代表：</td>
            <td><input type="text" name="C_CHIEF" size="26" maxlength="12">*</td>
            <td bgcolor="#F6F6F6" align="right">联系人：</td>
            <td> <input type="text" name="C_CNTCT_PRSN_NME" size="26" maxlength="20">*</td>

<!--            <td align="right" bgcolor="#F6F6F6">总资产：</td>
            <td> <input type="text" name="N_RGST_MNY" size="18" maxlength="14">
            </td>
-->            
          </tr>
        
          <tr bordercolor="#FFFFFF">
		  
  <input type="hidden" name="C_ARA_CDE" value="<%=Const.CHINA_CDE%>">          
<td bgcolor="#F6F6F6" align="right">省市：</td>
            <td><select name="C_PROVINCE" size="1" onChange="changeCity(C_PROVINCE,C_CITY);return true;"
            onfocus="changeCity(C_PROVINCE,C_CITY);return true;">
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
//				value = Province[i][c_city]+"&"+Province[i][c_dpt_cde];                      
                %>
                          <option value= <%=Province[i][c_city]%>> <%=Province[i][c_city_cnm]%> </option>
                <%
                       }
                    }   
                %>          
              </select>*</td>
			  <!-- removed by lawrence 2001-3-28
            <td bgcolor="#F6F6F6" align="right">员工人数：</td>
            <td><input type="text" name="N_EMLY_NUM" size="26" maxlength="6">
            </td>
              -->

            <td nowrap align="right" bgcolor="#F6F6F6">市县：</td>
			<Script lanaguage=JavaScript>
			 /* {
			      for address onChange="setAddress('1',C_PROVINCE,C_CITY,C_PLACE);
				   return true;"
             } */
			</script>
            <td><select name="C_CITY" size="1" onChange= "SetSelectedCity(C_CITY,selectedCity)">
                <option selected value="">请选择</option>
                <script language=JavaScript>
                 /* index = document.orgnCust.C_PROVINCE.options.selectedIndex-1;
                  for(var i = 0;i<city[index].length;i++)
                   {
                    var text = city[index][i].split("-");
                    document.write("<options value='"+text[1]+"'>"+text[0]);
                   }*/
                </script>
          
          </select>*</td>
		  <!-- removed by Lawrence 
            <td nowrap align="right" bgcolor="#F6F6F6">企业规模：</td>
            <td><select name="C_SCALE_CDE" size="1">
                <option selected value="">请选择</option>
                <%
                   if(ScaleLen > 1)
                   {
        	      int c_scale_cde = Objects.getColNum("c_scale_cde",Scale);        	                                            
        	      int c_scale_cnm = Objects.getColNum("c_scale_cnm",Scale);        	                                            
                      for(i = 1; i < ScaleLen; i++)
                      {
                %>
                          <option value= <%=Scale[i][c_scale_cde]%>> <%=Scale[i][c_scale_cnm]%> </option>
                <%
                       }
                    }   
                %>          

              </select>
            </td>
		-->
          </tr>

          <tr bordercolor="#FFFFFF">
            <td align="right" bgcolor="#F6F6F6">详细地址：</td>
            <td nowrap colspan="3">
            <input type="text" name="C_PLACE" size="60" maxlength="100">*</td>
          </tr>

          <tr bordercolor="#FFFFFF">
            <td bgcolor="#F6F6F6" align="right">EMail：</td>
            <td>   <input type="text" name="C_EMAIL" size="20" maxlength="60">*</td>
            <td align="right" bgcolor="#F6F6F6">邮编：</td>
            <td><input type="text" name="C_ZIP_CDE" size="20" maxlength="6">*
            </td>
              
          </tr>
          <tr bordercolor="#FFFFFF">
            <td bgcolor="#F6F6F6" align="right">电话：</td>
            <td>   <input type="text" name="C_TEL" size="20" maxlength="20">*</td>
            <td align="right" bgcolor="#F6F6F6">传真：</td>
            <td> <input type="text" name="C_FAX" size="20" maxlength="20">*</td>
          </tr>
        </table>
		  
      <p align=left>向您推荐网站的业务员:<input type="text" name="C_REMARK">
      <p>&nbsp;</p>
        <div align="center">
		    <input type="hidden"  name="selectedCity" value="请选择">
        	<input type="submit" value="提  交" name="Btn_Sub">
              	<input type="reset" value="重  填" name="Btn_Reset">
      	        <input type="button" value="退 出" onclick='javascript:window.close();' >
        	</div>

        </td>
        <td width="113" height="416"></td>
      </tr>
    </table>
 </form>

    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>