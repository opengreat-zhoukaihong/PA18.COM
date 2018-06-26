<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<jsp:useBean id="cb"  scope="page" class="beans.CustManagerBean"/> 
<jsp:setProperty name="cb" property="*"/>
<%@ include file="public/Public.jsp" %>
<%
  String Result[] = sessionbuffer.getClientAddInfo(Locate);
	String clientVerifyFlag = sessionbuffer.getClientVerifyFlag(Locate);
	/* add by Lawrence 2001-3-28*/
	String clientType = sessionbuffer.getClientType(Locate);
	/*end of add by Lawrence2001-3-28*/
	String flag = "0";
	String flag1 = "9";
	String LinkPlyApp = "href=\"Find_PlyApp.jsp?MENU_REF=FindPlyApp\"";
	String LinkPrp = "href=\"Find_PlyApp.jsp?MENU_REF=FindPrp\"";
	String LinkPly = "href=\"MenuMid.jsp?MENU_REF=MENU_INSURANCE\"";
	if(clientVerifyFlag.equals(flag) || clientVerifyFlag.equals(flag1))
	{
	   LinkPlyApp = "";
	   LinkPrp = "";
	   LinkPly = "";
	}        
%>


<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<td width="165" height="288" valign="top">

<p><img src="images/ins_ins.gif" width="190" height="54" alt="网上投保"></p>
<p>&nbsp;</p> <p>&nbsp;</p> <p>&nbsp;</p><br>
<p align="center">
<a href="index.jsp?Logout=0"><img src="images/hback.gif" width="80" height="50" border="0"></a> 
</p>
</td>


    <td width="613" height="288" valign="top"> 
      <br>  
<%//wuyan modify 
	if(clientVerifyFlag.equals(flag) || clientVerifyFlag.equals(flag1))
	{
%>
		<p>
			<FONT COLOR="#3300CC">
				您的用户还没有开通，暂时不能做保险业务，我们将尽快审核您的用户资料并与您联系。
				你可以做<a href="MenuMid.jsp?MENU_REF=MENU_EVALUATE">保费测算</a>。
			</FONT>
		</p>
<%	
		}
	  else
	  {
%>
	 <p><%if (!clientType.equals(Const.CUST_CM)){%>预约保险业务申报请点击：<%}%>
		<a href="OpenCoverList.jsp">
		  <img src="images/openCoverLeft.gif" width="80" height="17" alt="预约保险" border="0">
		</a>
	</p>
<%
		}
%>

      <p>  
      <br>
	  <%if(clientType.equals(Const.CUST_CM)){%>
         投保直接业务请点击下列流程框：
		<%}else{%>
		 投保非预约保险业务请点击下列流程框：
		<%}%>
      <br>
	<img src="images/liuc1.gif" width="399" height="84" usemap="#Map2" border="0">
	<map name="Map2"> 
		<!--area shape="rect" coords="31,36,90,64"--> 
	   <area shape="rect" coords="112,37,193,64" <%=LinkPly%>> 
	   <area shape="rect" coords="213,36,315,65" <%=LinkPlyApp%>> 
	</map>
	<img src="images/liuc2.gif" width="298" height="17" usemap="#Map3" border="0"> 
	<map name="Map3">
		<area shape="rect" coords="231,1,295,14" <%=LinkPrp%>> 
	</map> 
	<!--img src="images/liuc.gif" width="399" height="100" usemap="#Map2" border="0">
	<map name="Map2">
	  <area shape="rect" coords="28,35,90,67">
	  <area shape="rect" coords="112,35,190,67"  <%=LinkPly%>>
	  <area shape="rect" coords="215,36,314,67"  <%=LinkPlyApp%>>
	  <area shape="rect" coords="234,85,295,99"  <%=LinkPrp%>>
	</map--> 
     
   <% if(!(clientVerifyFlag.equals(flag) || clientVerifyFlag.equals(flag1))){
         System.out.println("Yes");
         try{
             String formPara[]  = new String[2];
             formPara[0] =  sessionbuffer.getuserId(Locate);
             formPara[1] =  sessionbuffer.getClientType(Locate);
             for(int p=0 ;p<2 ;p++)
             System.out.println(formPara[p]);
             cb.setFormPara(Const.CHECK_PROPOSAL, formPara);
         }catch(NormalException e)
          {
             throw NormalExceptionHandler.Handle(e);
          }catch(Throwable eb){
           eb.printStackTrace();
          }
          if(cb.getRetValueBool()){
            //out.println("<p>你有新的建议书");http://10.16.102.1:8800/Find_PlyApp.jsp?MENU_REF=FindPrp
	%>			
				<a href="Find_PlyApp.jsp?MENU_REF=FindPrp">
				   <img src='images/new.gif' alt='新建议书' border="0" height="12">
				</a>
	<%
          }
      }
   %>
      </p><br>
	联系地址：<%=Result[0]%><br>联 系 人：<%=Result[1]%><br>电&nbsp;&nbsp;&nbsp;&nbsp;话：<%=Result[2]%><br>传&nbsp;&nbsp;&nbsp;&nbsp;真：<%=Result[3]%><br>
      <br>
    </td>
  </tr>  
</table>


<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
