<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title> 客户资料打印 </title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="TableStyle.css">
</head>

<body>
<div align="right">

<address style="border-bottom: 1px dotted">
  平安保险
</address>
</div>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*,com.mcip.orb.CoException" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="obj_cust"  scope="page" class="beans.CustManagerBean"/> 
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>


<%  //The folloing is to getData from database and display on page
    int i = 0;
    int j = 0;

    String National[][] = null; 
    String Area[][] = null;
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
//    userid[0]="11a";
	userid[0]=(String)request.getAttribute("userid");
	if(userid[0]==null)
    userid[0]=request.getParameter("userid");
//   userid[0] = sessionbuffer.getClientId(Locate);   
    
    
    try
    {

        sb.setFieldValue(Const.GET_MAJOR,"");
        Major = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_NATIONAL,"");
        National = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_AREA,"");
        Area = sb.getRetValueArra();
        
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
    
    if(!(city== null))
        cityLen = city.length;

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

%>
<p align="center"><font face="宋体" size="4">客户资料打印</font></p>



 <input TYPE="hidden" NAME="userid" VALUE="<%=userid[0]%>">

  <p>个人信息：</p>
  <table width="648" border="5" bordercolordark="#3300CC" bordercolorlight="#3300CC">
    <tr> 
            <td width="45%">真实姓名： 
              
        <%=custorg[1][4]%>
              </td>
            <td width="55%">身份证号码：
              
        <%=custorg[1][9]%> 
               </td>
          </tr>
          <tr>
            <td width="45%">&nbsp;&nbsp;&nbsp;&nbsp;性别：
	     <% if ( custorg[1][10].equals("M") )
	        { 
	     %>
              男
             <%  }
	         else  {
	     %>
              女</td>
             <%    }    
             %>
              
            <td width="55%">&nbsp;&nbsp;出生年月：
              <%=birthyear%>
              年
              <%=birthmonth%>
              月
              <%=birthday%>
              日</td>
          </tr>
          <tr>
            <td width="45%">&nbsp;&nbsp;&nbsp;&nbsp;民族：
                <%
                   if(NationalLen > 1)
                   {
                      for(i = 1; i < NationalLen; i++)
                      {
                        if( National[i][0].equals(custorg[1][12]) )
                        {
                %>
                          <%=National[i][1]%> 
                <%      }
                      }
                    }   
                %>          
            </td>
            <td width="55%">&nbsp;&nbsp;电话号码：
              <%=custorg[1][21]%> </td>
          </tr>
          <tr>
            <td width="45%">&nbsp;&nbsp;&nbsp;&nbsp;传真：
              <%=custorg[1][22]%>
            </td>
            <td width="55%">&nbsp;&nbsp;&nbsp;&nbsp;E-Mail：
              <%=custorg[1][23]%></td>
          </tr>
          <tr bordercolor="#CC33CC">
            <td width="45%">所在国家：中国
              </td>
            <td width="55%">所在省/直辖市：
                <%
                   if(ProvinceLen > 1)
                   {
                      for(i = 1; i < ProvinceLen; i++)
                      {
                        if( Province[i][0].equals(Objects.getValue(1,"C_PROVINCE",custorg)) )
                        {
                %>
                          <%=Province[i][1]%>
                <%      }
                      }
                    }   
                %>          
              </td>
          </tr>
          <tr bordercolor="#CC33CC">
            <td width="45%" height="48"> 所在市/县/区:
                <%
                   if(cityLen > 1)
                   {
                      for(i = 1; i < cityLen; i++)
                      {
                        if( city[i][0].equals(Objects.getValue(1,"C_CITY",custorg)) )
                        {
                %>
                          <%=city[i][1]%>
                <%      }
                      }
                    }   
                %>          
  			</td>
            <td rowspan="2" width="55%">详细地址：
              <%=Objects.getValue(1,"C_PLACE",custorg)%> </td>
          </tr>
          <tr bordercolor="#CC33CC">
            <td width="45%">邮编：
              <%=custorg[1][29]%>
            </td>
          </tr>
          <tr>
            <td width="45%">最高学历：
                <%
                   if(EduLen > 1)
                   {
                      for(i = 1; i < EduLen; i++)
                      {
                        if( Edu[i][0].equals(custorg[1][17]) )
                        {
                %>
                           <%=Edu[i][1]%> 
                <%      }
                      }
                    }   
                %>          
            </td>
            <td width="55%">毕业学校：
              <%=custorg[1][15]%>
            </td>
          </tr>
          <tr>
            <td width="45%">专业：
                <%
                   if(MajorLen > 1)
                   {
                      for(i = 1; i < MajorLen; i++)
                      {
                        if( Major[i][0].equals(custorg[1][16]) )
                        {
                %>
                          <%=Major[i][1]%> 
                <%      }
                      }
                    }   
                %>          
            </td>
            <td width="55%">职称：
                <%
                   if(TitleLen > 1)
                   {
                      for(i = 1; i < TitleLen; i++)
                      {
                        if( Title[i][0].equals(custorg[1][19]) )
                        {
                %>
                          <%=Title[i][1]%> 
                <%      }
                      }
                    }   
                %>          
            </td>
          </tr>
          <tr>
            <td width="45%">职业：
                <%
                   if(DutyLen > 1)
                   {
                      for(i = 1; i < DutyLen; i++)
                      {
                        if( Duty[i][0].equals(custorg[1][20]) )
                        {
                %>
                          <%=Duty[i][1]%>
                <%      }
                      }
                    }   
                %>          
              </td>
          </tr>
        </table>
 <p>&nbsp;</p>
        <div align="center"><center><p>
    <input type="submit" name="Submit" value="打印" onClick="javascript:window.print()">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  </center></div>

<p></p>
<p></p>

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>  

</body>
</html>

