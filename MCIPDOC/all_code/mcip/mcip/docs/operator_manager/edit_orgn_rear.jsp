<%
/*
Modified Date:2001-11-1
By : L.K
Purpose :forbid operators to change the provice & city of the memeber
Ref:LK0001
*/
%>
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>

<jsp:useBean id="obj_cust"  scope="session" class="beans.CustManagerBean"/> 
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>

<%  //The folloing is to getData from database and display on page
    int i = 0;
    int j = 0;
    int tttt=0;
    String TradeType[][] = null; 
    String OrgType[][] = null;
    String Province[][] = null;
    String Ownership[][] = null;
//    String Area[][] = null;
    String Scale[][] = null;
    String PremiumScale[][] = null;
    String city[][] = null;

    int cityLen=0;  
    int TradeTypeLen = 0;
    int OrgTypeLen = 0;   
    int ProvinceLen = 0;   
    int OwnershipLen = 0;   
    int AreaLen = 0;   
    int ScaleLen = 0;   
    int PremiumScaleLen = 0;   

    String custorg[][] = null; 
    String userid[] = new String[2];
	userid[0]=(String)request.getAttribute("userid");
	/*add r20010924-10{*/
	userid[1] = (String)request.getAttribute("loginid");
	/*}add r20010924-10*/
	if(userid[0]==null)
    userid[0]=request.getParameter("userid");
//    userid[0] = sessionbuffer.getClientId(Locate);   


    try
    {
        sb.setFieldValue(Const.GET_TRADETYPE,"");
       TradeType = sb.getRetValueArra();

          sb.setFieldValue(Const.GET_ORGTYPE,"");
          OrgType = sb.getRetValueArra();
        
        sb.setFieldValue(Const.GET_PROVINCE,"");
      Province = sb.getRetValueArra();
        
          sb.setFieldValue(Const.GET_OWNERSHIP,"");
          Ownership = sb.getRetValueArra();

//        sb.setFieldValue(Const.GET_AREA,"");
//        Area = sb.getRetValueArra();


          sb.setFieldValue(Const.GET_SCALE,"");
          Scale = sb.getRetValueArra();

          sb.setFieldValue(Const.GET_PREMIUMSCALE,"");
          PremiumScale = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CITY,"");
        city = sb.getRetValueArra();
        
    }
    catch(NormalException e)
    {
        throw new ServletException("NormalExceptionThrows:"+e.getMessage());
    }
    catch(Exception e)
    {
        throw new ServletException("Not sureException:"+e.getMessage());
    }
    
    String Area[][] = new String[2][3];
	 Area[1][0]=Const.CHINA_CDE;
	 Area[1][2]="中国";

	 if(!(city== null))
	 {
        cityLen = city.length;
		for(i=1;i<cityLen;i++)
			city[i][0]=city[i][0]+"&"+city[i][4];
	 }
	 
    if(!(TradeType == null))
        TradeTypeLen = TradeType.length;
    if(!(Area == null))
        AreaLen = Area.length;
    if(!(Province == null))
        ProvinceLen = Province.length;
    if(!(OrgType == null))
        OrgTypeLen = OrgType.length;
    if(!(Ownership == null))
        OwnershipLen = Ownership.length;
    if(!(Scale == null))
        ScaleLen = Scale.length;
    if(!(PremiumScale == null))
        PremiumScaleLen = PremiumScale.length;
        
   try{
     obj_cust.setFormPara(Const.QUERY_CUSTORGN,userid);
     custorg=obj_cust.getRetValueArra();
	 }catch(Exception e){
	 	out.println("<h2><font color=red>没有查到该用户的详细资料！</font><br> 是否清除该用户?");
		out.println("<form action=DeleteUser.jsp method=post>");
		out.println("<input type=hidden name=userid value="+(String)request.getAttribute("loginid")+">");
		out.println("<input type=submit value=清除>&nbsp;&nbsp;<input type=button onclick=\"history.back()\" value=放弃>");
		out.println("</form>");
		return;
	 }
	 if (obj_cust == null){
	 	out.println("<h2><font color=red>没有查到该用户的详细资料！</font><br> 是否清除该用户?");
		out.println("<form action=DeleteUser.jsp method=post>");
		out.println("<input type=hidden name=userid value="+(String)request.getAttribute("loginid")+">");
		out.println("<input type=submit value=清除>&nbsp;&nbsp;<input type=button onclick=\"history.back()\" value=放弃>");
		out.println("</form>");
		return;
	}

String JS = ServTool.JSMake(city,Province,"0");
%>
<script LANGUAGE="JavaScript">
<%out.println(JS);%>
</script>
<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>

<form method="POST" action="subm_editorgn_rear.jsp" onsubmit="return(
ValidNull(C_CNLT_NME,false) &&
ValidNull(C_OWNERSHIP_CDE,false) &&
ValidNull(C_CHIEF,false) &&
ValidNull(C_ARA_CDE,false) &&
ValidNull(C_PROVINCE,false) &&
ValidNull(C_CITY,false) &&
ValidNull(C_PLACE,false) &&
ValidNull(C_CNTCT_PRSN_NME,false) &&
ValidNull(C_TEL,false) &&
ValidNull(C_EMAIL,false) &&
ValidTel(C_TEL) &&
ValidTel(C_FAX) &&
ValidEmail(C_EMAIL)
);">

 <input TYPE="hidden" NAME="userid" VALUE="<%=userid[1]%>">
 <input TYPE="hidden" NAME="custorg_name" VALUE="<%=custorg%>">
 <input TYPE="hidden" NAME="sessionid" VALUE="<%=request.getParameter("sessionid")%>">
 <div align="center"><font color="#0066CC" class="unnamed3"> 客 户 资 料 修 改<br></font></div>
  <font color="#009999">企业信息：</font><font color="#FF9900"><small>带</small> * <small>的选项必须填写</small></font>
        <table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#009966" bgcolor="#F4FFF4" bordercolorlight="#FFFFFF" class="td">
          <tr> 
            <td width="54%">&nbsp;&nbsp;企业名称： 
              
        <input type="text" name="C_CNLT_NME" value="<%=custorg[1][4]%>"  size="29" maxlength="100">
        <font color="#FF9900">* </font>
			</td>
            <td width="46%">中文简称： 
              
        <input type="text" name="C_CNLT_ABR" value="<%=custorg[1][5]%>" size="18" maxlength="12">
            </td>
          </tr>
          <tr> 
            <td width="54%">&nbsp;&nbsp;英文名称： 
              
        <input type="text" name="C_BRD_ENM" value="<%=custorg[1][10]%>" size="30" maxlength="100">
            </td>
            <td width="46%">英文简称： 
              
        <input type="text" name="C_ENG_ABR" value="<%=Objects.getValue(1,"c_eng_abr",custorg)%>" size="18" maxlength="12">
            </td>
          </tr>
          <tr> 
            <td width="54%">工商登记号： 
              
        <input type="text" name="C_RGST_NO" value="<%=custorg[1][13]%>" size="30" maxlength="20">
            </td>

            <td width="46%">&nbsp;&nbsp;&nbsp;&nbsp;行业： 
              <select name="C_TRD_CDE" size="1">
                <%
                   if(TradeTypeLen > 1)
                   {
                      for(i = 1; i < TradeTypeLen; i++)
                      {
                        if( TradeType[i][0].equals(custorg[1][18]) )
                        {
                %>
                          <option selected value= "<%=TradeType[i][0]%>"> <%=TradeType[i][2]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= "<%=TradeType[i][0]%>"> <%=TradeType[i][2]%> </option>
                <%
                                }       
                      }
                    }   

                %>          
              </select>
            </td>
          </tr>
          <tr> 
            <td width="54%">企业组织形式： 
              <select name="C_ORGZ_TYP_CDE" size="1">
                <%
                   if(OrgTypeLen > 1)
                   {
                      for(i = 1; i < OrgTypeLen; i++)
                      {
                        if( OrgType[i][0].equals(custorg[1][9]) )
                        {
                %>
                          <option selected value= "<%=OrgType[i][0]%>"> <%=OrgType[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= "<%=OrgType[i][0]%>"> <%=OrgType[i][1]%> </option>
                <%
                                }       
                      }
                    }   

                %>          
              </select>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
 
            <td width="46%">&nbsp;&nbsp;所有制： 
              <select name="C_OWNERSHIP_CDE" size="1">
                <%
                   if(OwnershipLen > 1)
                   {
                      for(i = 1; i < OwnershipLen; i++)
                      {
                        if( Ownership[i][0].equals(custorg[1][12]) )
                        {
                %>
                          <option selected value= <%=Ownership[i][0]%>> <%=Ownership[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= <%=Ownership[i][0]%>> <%=Ownership[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select><font color="#FF9900">* </font> 
		   </td>
          </tr>
          <tr> 
            
      <td width="54%">&nbsp;&nbsp;&nbsp;&nbsp;法人代表： 
        <input type="text" name="C_CHIEF" value="<%=custorg[1][16]%>" size="20" maxlength="12">
        <font color="#FF9900">* </font> </td>
            <td width="46%">&nbsp;&nbsp;总资产： 
              
        <input type="text" name="N_RGST_MNY" value="<%=custorg[1][15]%>" size="18" maxlength="19">
            </td>
          </tr>
          <tr> 
            <td width="54%">&nbsp;&nbsp;&nbsp;&nbsp;员工人数： 
              
        <input type="text" name="N_EMLY_NUM" value="<%=custorg[1][17]%>" size="10" maxlength="6">
            </td>
            <td width="46%">企业规模： 
              <select name="C_SCALE_CDE" size="1">
                <%
                   if(ScaleLen > 1)
                   {
                      for(i = 1; i < ScaleLen; i++)
                      {
                        if( Scale[i][0].equals(custorg[1][7]) )
                        {
                %>
                          <option selected value= <%=Scale[i][0]%>> <%=Scale[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= <%=Scale[i][0]%>> <%=Scale[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
            </td>
          </tr>
          <tr> 
            <td width="54%">&nbsp;&nbsp;&nbsp;&nbsp;保费规模： 
              <select name="C_CLNT_SCLE_CDE" size="1">
                <%
                   if(PremiumScaleLen > 1)
                   {
                      for(i = 1; i < PremiumScaleLen; i++)
                      {
                        if( PremiumScale[i][0].equals(custorg[1][8]) )
                        {
                %>
                          <option selected value= <%=PremiumScale[i][0]%>> <%=PremiumScale[i][3]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= <%=PremiumScale[i][0]%>> <%=PremiumScale[i][3]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
            </td>
            <td width="46%">&nbsp;</td>
          </tr>
          <tr bordercolor="#009999"> 
            <td width="54%">企业所在国家： 
              <select name="C_ARA_CDE" size="1">
                <%
                   if(AreaLen > 1)
                   {
                      for(i = 1; i < AreaLen; i++)
                      {
								int leng=Area[i][0].length();
								String ss="11";
								if(leng>2)ss=Area[i][0].substring(leng-2,leng);
								if(!(ss.equals("00")))
								{
                        	if( Area[i][0].equals(custorg[1][26]) )
                        	{
                %>
                          <option selected value= "<%=Area[i][0]%>"> <%=Area[i][2]%> </option>
                <%      	}
                       		else   {
                %> 
                          <option value= "<%=Area[i][0]%>"> <%=Area[i][2]%> </option>
                <%
                           }       
                       }
                      }
                    }   
                %>          
              </select>
              <font color="#FF9900">* </font></td>
            <td width="46%">企业所在省/直辖市：
			<%/*LK0001+B*/
                   if(ProvinceLen > 1){
                      for(i = 1; i < ProvinceLen; i++){
                        if( Province[i][0].equals(custorg[1][27]) ){
							out.println(Province[i][1]);
							out.println("<input type=\"hidden\" name=\"C_PROVINCE\" value=\""+Province[i][0]+"\">");
						}
					  }
				   }
				   /*LK0001+E*/
                %>          
              </td>
          </tr>
          <tr bordercolor="#009999"> 
            <td width="54%" height="49"> 所在市/县/区： 
			<%/*LK0001+B*/
                   if(cityLen > 1){
					   String tempsss=Objects.getValue(1,"C_CITY",custorg)+"&"+Objects.getValue(1,"c_dpt_cde",custorg);
                      for(i = 1; i < cityLen; i++){
                        if( city[i][0].equals(tempsss) ){
							out.println(city[i][1]);
							out.println("<input type=\"hidden\" name=\"C_CITY\" value=\""+city[i][0]+"\">");
						}
					  }
				   }
				   /*LK0001+E*/
			%>
              </td>
            <td rowspan="2" width="46%">企业详细地址： 
              <textarea name="C_PLACE" value="<%=custorg[1][29]%>" cols="35" rows="4"><%=custorg[1][29]%></textarea>
              <font color="#FF9900">* </font> </td>
          </tr>
          <tr bordercolor="#009999"> 
            <td width="54%" height="45">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮编： 
              <input type="text" name="C_ZIP_CDE" value="<%=custorg[1][30]%>" size="20" maxlength="6">
            </td>
          </tr>
          <tr bordercolor="#FF66FF"> 
            <td width="54%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系人： 
              
        <input type="text" name="C_CNTCT_PRSN_NME" value="<%=custorg[1][21]%>" size="20" maxlength="20">
              <font color="#FF9900">* </font> </td>
            <td width="46%">电话号码： 
              
        <input type="text" name="C_TEL" value="<%=custorg[1][22]%>" size="20" maxlength="20">
              <font color="#FF9900">* </font> </td>
          </tr>
          <tr bordercolor="#FF66FF"> 
            <td width="54%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传真： 
              
        <input type="text" name="C_FAX" value="<%=custorg[1][23]%>" size="20" maxlength="20">
            </td>
            <td width="46%">&nbsp;&nbsp;E-Mail： 
              
        <input type="text" name="C_EMAIL" value="<%=custorg[1][24]%>" size="20" maxlength="30">
              <font color="#FF9900">* </font> </td>
          </tr>


        </table>
 <p align=left>与您联系的业务员:<input type="text" name="C_REMARK" value="<%=Objects.getValue(1,"c_remark",custorg)%>">
      <p>&nbsp;</p><br>
        <div align="center"><center><input type="submit" value="提  交" name="Btn_Sub">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
              <input type="reset" value="重  填" name="Btn_Reset">
  </center></div>
       
</form>

<%@ include file="public/bottom.jsp" %>
