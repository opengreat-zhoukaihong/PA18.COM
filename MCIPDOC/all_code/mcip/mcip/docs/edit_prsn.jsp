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
      <img src="images/m_changeinfo.gif" width="150" height="31" alt="修改个人资料">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>

<jsp:useBean id="obj_cust"  scope="session" class="beans.CustManagerBean"/> 
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>


<%  //The folloing is to getData from database and display on page
    int i = 0;
    int j = 0;

    String National[][] = null; 
//    String Area[][] = null;
    String Province[][] = null;
    String Edu[][] = null;
    String Duty[][] = null;
    String Title[][] = null;
    String Major[][] = null;
    String city[][] = null;

    int cityLen=0;  
    int NationalLen = 0;
    int AreaLen = 0;   
    int ProvinceLen = 0;   
    int EduLen = 0;   
    int DutyLen = 0;   
    int TitleLen = 0;   
    int MajorLen = 0;   
    
    int birthlen = 0;   
    String birth=null;
    String birthyear="";
    String birthmonth="";
    String birthday="";

    String custorg[][] = null; 
    String userid[] = new String[1];
	userid[0]=(String)request.getAttribute("userid");
	if(userid[0]==null)
    userid[0]=request.getParameter("userid");
   if(userid[0]==null)
		userid[0] = sessionbuffer.getClientId(Locate);   
    
    try
    {

        sb.setFieldValue(Const.GET_MAJOR,"");
        Major = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_NATIONAL,"");
        National = sb.getRetValueArra();

//        sb.setFieldValue(Const.GET_AREA,"");
//        Area = sb.getRetValueArra();
        
        sb.setFieldValue(Const.GET_PROVINCE,"");
        Province = sb.getRetValueArra();
        
        sb.setFieldValue(Const.GET_EDU,"");
        Edu = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_DUTY,"");
        Duty = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_TITILE,"");
        Title = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_CITY,"");
        city = sb.getRetValueArra();
        
    }
    catch(NormalException e)
    {
 		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
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

    if(!(National == null))
        NationalLen = National.length;
    if(!(Area == null))
        AreaLen = Area.length;
    if(!(Province == null))
        ProvinceLen = Province.length;
    if(!(Edu == null))
        EduLen = Edu.length;
    if(!(Duty == null))
        DutyLen = Duty.length;
    if(!(Title == null))
        TitleLen = Title.length;
    if(!(Major == null))
        MajorLen = Major.length;
   
     obj_cust.setFormPara(Const.QUERY_CUSTPRSN,userid);
     custorg=obj_cust.getRetValueArra();
     if( !(custorg[1][13] == null) ) 
     	birthlen = custorg[1][13].length();
     if( birthlen < 10) birth="";
     if( birthlen >= 10) 
     {
			birth=custorg[1][13].substring(0,10);
			birthyear=birth.substring(0,4);
			birthmonth=birth.substring(5,7);
			birthday=birth.substring(8,10);
	  }
     // out.println("birlen="+birthlen);	
     // out.println("bir="+custorg[1][13]);	


String JS = ServTool.JSMake(city,Province,"0");
%>
<script LANGUAGE="JavaScript">
<%out.println(JS);%>
</script>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>

<form method="POST" action="subm_editprsn.jsp" onsubmit="return(
ValidYear(birth_year) &&
ValidMonth(birth_month) &&
ValidDay(birth_day) &&

ValidNull(C_CLNT_NME,false) &&
ValidNull(C_RGST_NO,false) &&
ValidNull(C_TEL,false) &&
ValidNull(C_EMAIL,false) &&
ValidNull(C_PROVINCE,false) &&
ValidNull(C_CITY,false) &&
ValidNull(C_PLACE,false) &&
ValidTel(C_TEL) &&
ValidTel(C_FAX) &&
ValidEmail(C_EMAIL) &&
ValidInt(C_RGST_NO) &&
ValidInt(C_ZIP_CDE) 
);">

 <input TYPE="hidden" NAME="userid" VALUE="<%=userid[0]%>">

  <p align="right"><em><font color="#ED7CC9"><small>带</small> * <small>的选项必须填写</small></font></em></p>
  <table width="100%" cellspacing="0" border="1" bordercolordark="#F6F6F6" bordercolorlight="#F6F6F6">
    <tr> 
        <td width="10%" bgcolor="#CCCCCC">真实姓名: </td>
	<TD width="30%">  
            <input type="text" name="C_CLNT_NME" value="<%=custorg[1][4]%>" size="20" maxlength="100">
        *</td>
        <td width="10%" bgcolor="#CCCCCC">身份证号:</td>
	<TD width="50%">  
            <input type="text" name="C_RGST_NO" value="<%=custorg[1][9]%>" size="25" maxlength="20">
      * </td>
    </tr>
    <tr>
      <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;&nbsp;&nbsp;性别:</td>
	<TD width="30%">  
	  <% if ( custorg[1][10].equals("M") )
	     { 
	  %>
          <input type="radio" name="C_SEX" value="M" checked>
           男
          <input type="radio" name="C_SEX" value="F">
           女
	</td>
          <%  }
	   else  {
	   %>
           <input type="radio" name="C_SEX" value="M">
            男
           <input type="radio" name="C_SEX" value="F" checked>
            女
	 </td>
             <%    }    
             %>
              
            <td width="10%" bgcolor="#CCCCCC">出生年月:</td>
	    <TD width="50%">  
              <input type="text" name="birth_year" value="<%=birthyear%>" size="4" maxlength="4">
              年
              <input type="text" name="birth_month" value="<%=birthmonth%>" size="2" maxlength="2">
              月
              <input type="text" name="birth_day" value="<%=birthday%>" size="2" maxlength="2">
              日
	     </td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;&nbsp;&nbsp;民族:</td>
	    <TD width="30%">  
              <select name="C_NTN_CDE" size="1">
                <%
                   if(NationalLen > 1)
                   {
                      for(i = 1; i < NationalLen; i++)
                      {
                        if( National[i][0].equals(custorg[1][12]) )
                        {
                %>
                          <option selected value= "<%=National[i][0]%>"> <%=National[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= "<%=National[i][0]%>"> <%=National[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
            </td>
            <td width="10%" bgcolor="#CCCCCC">电话号码:</td>
	    <TD width="50%">  
              <input type="text" name="C_TEL" value="<%=custorg[1][21]%>" size="25" maxlength="20">
              *</td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;&nbsp;&nbsp;传真:</td>
	    <TD width="30%">  
              <input type="text" name="C_FAX" value="<%=custorg[1][22]%>" size="20" maxlength="20">
            </td>
            <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;E-Mail:</td>
	    <TD width="30%">  
              <input type="text" name="C_EMAIL" value="<%=custorg[1][23]%>" size="25" maxlength="30">
              *</td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC">所在国家:</td>
	    <TD width="30%">  
              <select name="C_ARA_CDE" size="1">
                <%
                   if(AreaLen > 1)
                   {
                      for(i = 1; i < AreaLen; i++)
                      {
                        if( Area[i][0].equals(Objects.getValue(1,"C_ARA_CDE",custorg)) )
                        {
                %>
                          <option selected value= "<%=Area[i][0]%>"> <%=Area[i][2]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= "<%=Area[i][0]%>"> <%=Area[i][2]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
              *</td>
            <td width="10%" bgcolor="#CCCCCC">省/直辖市:</td>
	    <TD width="50%">  
              <select name="C_PROVINCE" size="1" onChange="editCity(C_PROVINCE,C_CITY);return true;">
                <%
                   if(ProvinceLen > 1)
                   {
                      for(i = 1; i < ProvinceLen; i++)
                      {
                        if( Province[i][0].equals(Objects.getValue(1,"C_PROVINCE",custorg)) )
                        {
                %>
                          <option selected value= "<%=Province[i][0]%>"> <%=Province[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= "<%=Province[i][0]%>"> <%=Province[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
              *</td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC"> 市/县/区:</td>
	    <TD width="30%">  
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
              </select>
              *
			</td>
            <td rowspan="2" width="10%" bgcolor="#CCCCCC">详细地址:</td>
	    <TD width="50%" rowspan="2">  
              <textarea name="C_PLACE" value="<%=custorg[1][28]%>" cols="35" rows="4"><%=Objects.getValue(1,"C_PLACE",custorg)%></textarea>
              *</td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;&nbsp;&nbsp;邮编:</td>
	    <TD width="30%">  
              <input type="text" name="C_ZIP_CDE" value="<%=custorg[1][29]%>" size="20" maxlength="6">
            </td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC">最高学历:</td>
	    <TD width="30%">  
              <select name="C_EDU_CDE" size="1">
                <%
                   if(EduLen > 1)
                   {
                      for(i = 1; i < EduLen; i++)
                      {
                        if( Edu[i][0].equals(custorg[1][17]) )
                        {
                %>
                          <option selected value= "<%=Edu[i][0]%>"> <%=Edu[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= "<%=Edu[i][0]%>"> <%=Edu[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
            </td>
            <td width="10%" bgcolor="#CCCCCC">毕业学校:</td>
	    <TD width="50%">  
              <input type="text" name="C_GRDT" value="<%=custorg[1][15]%>" size="30" maxlength="30">
            </td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;&nbsp;&nbsp;专业:</td>
	    <TD width="30%">  
              <select name="C_MAJOR_CDE" size="1">
                <%
                   if(MajorLen > 1)
                   {
                      for(i = 1; i < MajorLen; i++)
                      {
                        if( Major[i][0].equals(custorg[1][16]) )
                        {
                %>
                          <option selected value= "<%=Major[i][0]%>"> <%=Major[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= "<%=Major[i][0]%>"> <%=Major[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
            </td>
            <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;&nbsp;&nbsp;职称:</td>
	    <TD width="50%">  
              <select name="C_TITLE_CDE" size="1">
                <%
                   if(TitleLen > 1)
                   {
                      for(i = 1; i < TitleLen; i++)
                      {
                        if( Title[i][0].equals(custorg[1][19]) )
                        {
                %>
                          <option selected value= <%=Title[i][0]%>> <%=Title[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= <%=Title[i][0]%>> <%=Title[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
            </td>
          </tr>
          <tr>
            <td width="10%" bgcolor="#CCCCCC">&nbsp;&nbsp;&nbsp;&nbsp;职业:</td>
	    <td  colspan="3">
              <select name="C_DUTY" size="1">
                <%
                   if(DutyLen > 1)
                   {
                      for(i = 1; i < DutyLen; i++)
                      {
                        if( Duty[i][0].equals(custorg[1][20]) )
                        {
                %>
                          <option selected value= <%=Duty[i][0]%>> <%=Duty[i][1]%> </option>
                <%      }
                        else   {
                %> 
                          <option value= <%=Duty[i][0]%>> <%=Duty[i][1]%> </option>
                <%
                                }       
                      }
                    }   
                %>          
              </select>
              </td>
          </tr>
        </table>
	<br>
        <div align="center">
	   <input type="submit" value="提  交" name="Btn_Sub">
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
           <input type="reset" value="重  填" name="Btn_Reset">
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <input type="button" value="返  回" onclick="history.back()">
	</div>
</form>

	</td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   

</body>
</html>

