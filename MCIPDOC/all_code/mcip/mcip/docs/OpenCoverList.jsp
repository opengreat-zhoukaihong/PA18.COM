<!--
Modified:2001-09-27
By : L.K
Description:增加目的港字段
ID:R20010924-1
-->
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<%@ include file="public/Public.jsp" %>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pb"  scope="session" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>
<% 
   String OpenCover[][] = null;
   int OpenCoverLen = 0;
   int i = 0;
   String ClientId = sessionbuffer.getuserId(Locate);//getClientId(Locate);
   String TranType = ob.getTranType();
   String[] Transit = ob.getHomeTransit();
   String FormPara[] = new String[2];
   FormPara[0] = ClientId;
   TranType = "";//Servlets.GetInsrnc(TranType,Transit);   
   FormPara[1] = TranType;
   String ClientType = sessionbuffer.getClientType(Locate);    
   
   if(!(ClientType.equals(Const.CUST_OC)))
   {
        throw NormalExceptionHandler.Handle(Const.SYS_USER_ERR_OC_CDE,Const.SYS_USER_OC_ERR);	               
   }

    String IsPageNow = request.getParameter("PAGE");     
    try
    {
    	if(IsPageNow == null)
	{
        	pb.setFormPara(Const.GET_OCLIST,FormPara);
        }
        OpenCover = pb.getRetValueArra();
        ob.setStep(Const.STEP_BEG);        
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }
  
    OpenCoverLen = Servlets.getLen(OpenCover); 
    int c_open_cover_no = 0;       
    
    int ArrayRowLen =  OpenCoverLen;
    String PageListUrl = "OpenCoverList.jsp";  
    String FormName = "find_Info";
    String ListParas="?a=a";       
%>

<%@ include file="PageListPre.jsp" %>      
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
<%@ include file="public/PublicMemLeft.jsp" %>
    <td width="613" height="288" valign="top"> <br>
      <img src="images/opencover.gif" width="150" height="31" alt="OPEN COVER 协议">

 <table border="0" width="95%" cellpadding="4" >
 
  <tr> 
<td width="5%">　</td>
    <td >
<form name="find_Info" METHOD="POST" ACTION="Notice.jsp">
        <table width="95%" border="0" cellspacing="0" cellpadding="0">
         
          <tr> 
            <td colspan="2" height="15" align="center"> 
              <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
                <tr bgcolor="#99FFFF" align="center"> 
      <td  bgcolor="#C0C0C0" align="center">Open Cover 协议号</td>
      <td  bgcolor="#C0C0C0" align="center">险种中文名称</td>
      <td  bgcolor="#C0C0C0" align="center">货物描述</td>
      <td bgcolor="#C0C0C0" align="center">运输方式名称</td>
	  <!--ADD BEGIN R20010924-1-->
	  <td bgcolor="#COCOCO" align="center">启始港</td>      
	  <td bgcolor="#COCOCO" align="center">目的港</td>      
	  <!--ADD END R20010924-1-->
	    </tr>
<%
   if(OpenCoverLen > 1)
   {
     c_open_cover_no = Objects.getColNum("c_open_cover_no",OpenCover);
     int c_insrnc_cnm = Objects.getColNum("c_insrnc_cnm",OpenCover);
     int c_crgo_desc = Objects.getColNum("c_crgo_name",OpenCover);
     int c_carriage_cnm = Objects.getColNum("c_carriage_cnm",OpenCover);      
	 /*ADD BEGIN R20010924-1*/
	 int c_from_port = Objects.getColNum("C_FROM_PRT",OpenCover);
	 int c_to_port = Objects.getColNum("C_TO_PRT",OpenCover);
	 /*ADD END R20010924*/

    for(i = begini ;i< endi;i++ ) 
    {
%>
    <tr>
      <td><a href="#" title="点击选择" onclick="selectNo(C_OC_NO,<%=i-begini+1%>);return true"><%=OpenCover[i][c_open_cover_no]%></a></td>
      <td><%=OpenCover[i][c_insrnc_cnm]%>&nbsp;</td>
      <td><%=OpenCover[i][c_crgo_desc]%>&nbsp;</td>
      <td><%=OpenCover[i][c_carriage_cnm]%>&nbsp;</td>
	  <!--ADD BEGIN R20010924-1-->
	  <td><%=OpenCover[i][c_from_port]%>&nbsp;</td>      
	  <td><%=OpenCover[i][c_to_port] %>&nbsp;</td>
	  <!--ADD END R20010924-1-->
    </tr>
<%
   }
  }
  else
  {
%>
没有取得OpenCover协议数据
<%  
  }
%>     
              </table>
            </td>
          </tr>
          <tr> 
            <td colspan="2" height="5" align="center">&nbsp;</td>
          </tr>
          <tr> 
            <td colspan="2" height="15" align="right"> 
	     <%@ include file="PageListNext.jsp" %>      
            </td>
          </tr>
          <tr> 
            <td colspan="2"><br>请根据OpenCover协议来生成起运通知书，请先选择协议号。<br><br></td>
          </tr>
          <tr> 
            <td colspan="2" height="20">Open Cover 协议号： 
              <select name="C_OC_NO" size="1">
                <option value="" selected>空协议号</option>
                <%
                   if(OpenCoverLen > 1)
                   {
		     int c_insrnc_cde = Objects.getColNum("c_insrnc_cde",OpenCover);
		     int c_crgo_cde = Objects.getColNum("c_crgo_cde",OpenCover);
                     String ValueStr = "";
    		     for(i = begini ;i< endi;i++ ) 
                      {
                        ValueStr = OpenCover[i][c_open_cover_no]+"&"+OpenCover[i][c_insrnc_cde]+"&"+OpenCover[i][c_crgo_cde];
                %>
                          <option value="<%=ValueStr%>"> <%=OpenCover[i][c_open_cover_no]%> </option>
                <%
                       }
                       
                    }   
                %>          
              </select>
  <input type="submit" value="填写起运通知书" name="B2" onclick="return(checkFieldNull(C_OC_NO,'1'));">
  <input type="button" value="前一页" name="B44" onclick='javascript:history.back();'>  
            </td>
          </tr>                 
          
        </table>
        
      </form>
         </td>
    </tr>
  </table>
    
       
        </div>
   
      
    </td>
  </tr>
</table>


 </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      
</body>
</html>
