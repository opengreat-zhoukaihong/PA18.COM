<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ include file="public/Public.jsp" %>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicMemLeft.jsp" %> 
    <td width="613" height="288" valign="top"> <br>
      <img src="images/m_changeinfo.gif" width="150" height="31" alt="修改机构资料">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>

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
    String userid[] = new String[1];
	userid[0]=(String)request.getAttribute("userid");
	if(userid[0]==null)
    userid[0]=request.getParameter("userid");
   if(userid[0]==null)
		userid[0] = sessionbuffer.getClientId(Locate);   
	//add by zlx 2000/11/14
	String Result[] = sessionbuffer.getClientAddInfo(Locate);
	userid[0]=Result[5];

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
        
   
     obj_cust.setFormPara(Const.QUERY_CUSTORGN,userid);
     custorg=obj_cust.getRetValueArra();


String JS = ServTool.JSMake(city,Province,"0");
%>
<script LANGUAGE="JavaScript">
<%out.println(JS);%>
</script>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>

<form method="POST" action="subm_editorgn.jsp" onsubmit="return(
ValidNull(C_CNLT_NME,false) &&
ValidNull(C_OWNERSHIP_CDE,false) &&
ValidNull(C_CHIEF,false) &&
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

 <input TYPE="hidden" NAME="userid" VALUE="<%=userid[0]%>">
 <input TYPE="hidden" NAME="custorg_name" VALUE="<%=custorg%>">
 <input TYPE="hidden" NAME="sessionid" VALUE="<%=request.getParameter("sessionid")%>">
  <p align="right">
     <em>
       <font color="#ED7CC9">
         <small>带</small> * <small>的选项必须填写</small>
       </font>
     </em>
  </p>
  <table width="100%" cellspacing="1" cellpadding="0">
      <tr bordercolor="#FFFFFF">
	  <td bgcolor="#F6F6F6" align="right">用户名</td>
	  <td colspan=3><input name="C_USER_NME" disabled value=<%=sessionbuffer.getuserId(Locate)%>>
	  </tr>
      <tr bordercolor="#FFFFFF"> 
        <td bgcolor="#F6F6F6"  align="right">企业名称</td>
	<TD >  
          <input type="text" name="C_CNLT_NME" value="<%=custorg[1][4]%>" size="20" maxlength="100">*
	</td>
        <td  bgcolor="#F6F6F6" align="right">英文名称</td>
	<TD >  
           <input type="text" name="C_BRD_ENM" value="<%=custorg[1][10]%>" size="20" maxlength="100">
        </td>
      </tr>      
      <tr bordercolor="#FFFFFF"> 
        <td  bgcolor="#F6F6F6" align="right">工商登记号</td> 
	<TD >              
          <input type="text" name="C_RGST_NO" value="<%=custorg[1][13]%>" size="20" maxlength="20">
        </td>
        <td  bgcolor="#F6F6F6" align="right">行业</td> 
	<TD >
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
      <tr bordercolor="#FFFFFF"> 
        <td bgcolor="#F6F6F6" align="right">所有制</td> 
	<TD colspan=3 align=left>
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
              </select>* 
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>

          </tr>
     <tr bordercolor="#FFFFFF"> 
            
        <td bgcolor="#F6F6F6"   align="right">法人代表</td> 
	<TD >
          <input type="text" name="C_CHIEF" value="<%=custorg[1][16]%>" size="20" maxlength="12">* 
	</td>
        <td bgcolor="#F6F6F6"    align="right">联系人</td> 
	<TD>
          <input type="text" name="C_CNTCT_PRSN_NME" value="<%=custorg[1][21]%>" size="20" maxlength="20">*
        </td>
      </tr>
     
   
      <tr bordercolor="#FFFFFF"> 
        <td bgcolor="#F6F6F6"  align="right">省/市</td> 
	<TD >
	<%if(ProvinceLen > 1){
			for(i = 1; i < ProvinceLen; i++){
				if( Province[i][0].equals(custorg[1][27]) ){
                %>
                    &nbsp;<font color="blue"><%=Province[i][1]%></font>
					<input type="hidden" name="C_PROVINCE" value="<%=Province[i][0]%>">
                <%break;
					}
                 }
            }%>          

	<!-- r20010924-10
              <select name="C_PROVINCE" size="1" onChange="editCity(C_PROVINCE,C_CITY);return true;">
                <%
                   if(ProvinceLen > 1)
                   {
                      for(i = 1; i < ProvinceLen; i++)
                      {
                        if( Province[i][0].equals(custorg[1][27]) )
                        {
                %>
                          <option selected value="<%=Province[i][0]%>"> <%=Province[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value="<%=Province[i][0]%>"> <%=Province[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>*-->
	</td>
        <td  bgcolor="#F6F6F6" align="right">市县</td> 
	<TD >
	<%
		if(cityLen > 1){
			String tempsss=Objects.getValue(1,"C_CITY",custorg)+"&"+Objects.getValue(1,"c_dpt_cde",custorg);
			for(i = 1; i < cityLen; i++){
					if( city[i][0].equals(tempsss) ){
                %>
						&nbsp;<font color="blue" ><%=city[i][1]%></font>
						<input type="hidden" name="C_CITY" value="<%=city[i][0]%>">
				<%break;
                      }
                 }
            }%>
	<!--r20010924-10
              <select name="C_CITY" size="1">
                <%
                   if(cityLen > 1)
                   {
			String tempsss=Objects.getValue(1,"C_CITY",custorg)+"&"+Objects.getValue(1,"c_dpt_cde",custorg);
				 for(i = 1; i < cityLen; i++)
                      {
					if( city[i][0].equals(tempsss) )
                        {
                %>	
                          <option selected value= "<%=city[i][0]%>"> <%=city[i][1]%> </option>
                <%      }
                        else   {
                %> 	
                          <option value= "<%=city[i][0]%>"> <%=city[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>*-->
	</td></tr>
      <tr bordercolor="#FFFFFF" > 
        <td bgcolor="#F6F6F6"  align="right">详细地址</td> 
	<TD colspan=3><input type="text" name="C_PLACE" size="60" maxlength="100" value=<%=custorg[1][29]%>>*
      </td>          
      </tr>
      <tr bordercolor="#FFFFFF"> 
        <td  bgcolor="#F6F6F6" align="right">E-Mail</td> 
	<TD >
              <input type="text" name="C_EMAIL" value="<%=custorg[1][24]%>" size="20" maxlength="30">*
        </td>

		 <td bgcolor="#F6F6F6"  align="right">邮编</td> 
	     <TD >
              <input type="text" name="C_ZIP_CDE" value="<%=custorg[1][30]%>" size="20" maxlength="6">
        </td>
      </tr>
      <tr bordercolor="#FFFFFF"> 
        <td bgcolor="#F6F6F6"  align="right">电话</td> 
	<TD >
          <input type="text" name="C_TEL" value="<%=custorg[1][22]%>" size="20" maxlength="20">*
	</td>
        <td bgcolor="#F6F6F6"  align="right">传真</td> 
	<TD >
           <input type="text" name="C_FAX" value="<%=custorg[1][23]%>" size="20" maxlength="20">
	</td>
      </tr>
     

  </table>
 <p align=left>与您联系的业务员:<input type="text" name="C_REMARK" value="<%=Objects.getValue(1,"c_remark",custorg)%>">
      <p>&nbsp;</p><br>
 <div align="center">
    <input type="submit" value="提  交" name="Btn_Sub">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    <input type="reset" value="重  填" name="Btn_Reset">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" value="返  回" onclick="history.back()">
 </div>
 
</form>

    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   

</body>
</html>
