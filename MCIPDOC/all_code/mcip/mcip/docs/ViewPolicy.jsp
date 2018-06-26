<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>


<%
      Hashtable hashData = new Hashtable();
      hashData = ob.getHashData();
	  Enumeration ep =hashData.keys();
      /*while(ep.hasMoreElements())
      {   String key =(String)(ep.nextElement());
	      out.println(key+":"+(String)hashData.get(key));
		  out.println("<p>");
	  }*/
	//to be get insrnce info :main and addtion
      String InsrncName = "";
      String PlyAppRdrInfo[][] = null;
      String PlyNoDisp = Objects.getHt(hashData,"C_PLY_APP_NO");
      if(PlyNoDisp.equals(""))
         PlyNoDisp = Objects.getHt(hashData,"C_PLY_NO");
      String ClientType = sessionbuffer.getClientType(Locate);
%>      
<%@ include file="PublicPly_ViewXmlsend.jsp" %>
<%

    try
    {
        pb.setFieldValue(Const.GET_PLYAPPRDRINFO,PlyNoDisp);
        PlyAppRdrInfo = pb.getRetValueArra();

    }
    catch(NormalException e)
    {
/* 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
*/ 	    
    }
	int c_rdr_nme =  Objects.getColNum("c_rdr_nme",PlyAppRdrInfo);
	int RdrLen = Servlets.getLen(PlyAppRdrInfo);
	if(RdrLen > 1)
	{
		for(int i = 1; i < RdrLen; i++)
		{
		    InsrncName = InsrncName + ":" + PlyAppRdrInfo[i][c_rdr_nme];
		}
	}	
%>
<%
      String TranType = Objects.getHt(hashData,"C_INSRNC_CDE");
      String Transit[] = new String[1];
      String TransitName = "";
System.out.println("in viewpolicy TranType:"+TranType);      
      if(TranType.equals(Const.C_EXPORT_CDE))//outport
      {
          TranType = Const.C_EXPORT_CNM;           
      }
      else if(TranType.equals(Const.C_IMPORT_CDE))//import
      {
          TranType = Const.C_IMPORT_CNM;           
      }
      else
      {
          TransitName = Objects.getValue(1,TranType,Const.HOME_TRANSIT);
System.out.println("home TransitName:"+TransitName);          
          FrmPrtName = "";
          ToPrtName = "";
          TranType = Const.C_HOME_CDE;           
      }
      
      if(!TranType.equals(Const.C_HOME_CDE))
      {
System.out.println("is port transit");                
        Transit = new String[Const.PORT_TRANSIT_LEN];
        Transit = Servlets.GetInsrncAddtion(PlyAppRdrInfo,Transit);     
        for(int k=0;k<Const.PORT_TRANSIT_LEN;k++)   
        {
           if(!(Transit[k] == null || Transit[k].equals("")))
           {
               TransitName = TransitName + Objects.getValue(1,String.valueOf(k),Const.PORT_TRANSIT);
           }
        }
        
      }
      
      if(!AmtCurName.equals(""))
         AmtCurName = "("+AmtCurName+")";

       String[][]TempArra = {{"AMT_CUR_NAME"},{AmtCurName}};
       ob.setFormDataAdd(TempArra);

%>      

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
<%
if(MenuRef.equals("FindPly"))
{
%>
<%@ include file="public/PublicInquireLeft.jsp" %> 
<%
}
else
{
%>
<%@ include file="public/PublicPlyLeft.html" %>

<%
}
%>
    <td width="613"  valign="top">
      <div align=right> 
<br>
      </div>
      <p align=center><font face=宋体 size=5><strong>中国平安保险股份有限公司 </strong></font><br>
        <font size=2>PING AN INSURANCE COMPANY OF CHINA. LTD.</font></p>
<p align="center"><font size="4"><u><font size="4"><%=TransitName%></font>货物运输保险单</u></font></p>
<p align="center">&nbsp;</p>
<form>
  <div align="center"> 
    <center>
      <p align="left">被保险人(Insured)：  <%=Objects.getHt(hashData,"C_INSRNT_NME")%></p>
      <p align="left"><font size="2">中国平安保险股份有限公司根据被保险人的要求及其所交付约定的保险费，按照本保险单的相关条款，承保下述货物运输保险，特立本保险单。</font><i> 
        <br>
        </i></p>
    </center>
  </div>
</form>

<%
	String insrncCde = Objects.getHt(hashData,"C_INSRNC_CDE");
	String printPage = "";
	//进出口
	if (insrncCde.equals(Const.C_IMPORT_CDE) || insrncCde.equals(Const.C_EXPORT_CDE)){
		printPage = "PolicyPrint.jsp";
	}
	//国内航空、水路、陆路
	if(insrncCde.equals(Const.C_ROAD_CDE) || insrncCde.equals(Const.C_WATER_CDE) || insrncCde.equals(Const.C_H_AVIATION_CDE)){
		printPage = "printPolicySLH.jsp";
	}
	//国内铁路
	if(insrncCde.equals(Const.C_RAILAGE_CDE)){
		printPage = "printPolicyT.jsp";
	}
%>
<form name="printaim" action="<%=printPage%>" method="post" target="_blank">
    <input type="hidden" name="C_DOC_NO" value="<%=PlyNoDisp%>">
        <table bordercolor=#999999 cellspacing=0 cellpadding=0 width="96%" border=1 height="198" align="center">

    <tr> 
      <td  colspan="2">保单号<br>Policy NO：<%=PlyNoDisp%></td>
    </tr>
    <tr> 
      <td  colspan="2">发票或提单号<br>Invoice NO.or B/L No.：<%=Objects.getHt(hashData,"C_INVC_NO")%></td>
    </tr>

    <tr>
       <td>
        品名<br>Goods： <%=Objects.getHt(hashData,"C_CRGO_NAME")%>
	</td>
	<td>        
	包装<br>Packing： <%=Objects.getHt(hashData,"C_PACK_CNM")%><br>
        </td>
    </tr>

    <tr> <td>
        数量<br>Quantity：  <%=Objects.getHt(hashData,"C_AMOUNT")%><br>
  	</td>
	<td>        
        唛头<br>Marks： <%=Objects.getHt(hashData,"C_MARK")%>
        </td>
    </tr>
    <tr> 
      <td  colspan="2">货物描述:<br>Crgo Description：<%=Objects.getHt(hashData,"C_CRGO_DESC")%></td>
    </tr>

    <tr> 
      <td width="47%" height="28">运输工具<br>PerConveyance S.S：<%=Objects.getHt(hashData,"C_SAIL_NO")%></td>
      <td width="47%" height="28">起运日期<br>Slg.on or abt.：<%=Objects.getHt(hashData,"T_INSRNC_BGN_TM")%></td>

    </tr>
    <tr> 
      <td>   自<br>From： <%=Objects.getHt(hashData,"C_FROM_PRT")%></td>
      <td>   至<br>To： <%=Objects.getHt(hashData,"C_TO_PRT")%></td>
    </tr>
    <tr> 
      <td  colspan="2">保险金额<br>Amount Insured： <%=AmtCurName%><%=Objects.getHt(hashData,"N_AMT")%></td>
    </tr>

    <tr>        
       <td colspan="2">承保条件(Conditions)：<br> <%=Objects.getHt(hashData,"C_UNDR_CNDTN")%><br>
       <%=Objects.getHt(hashData,"C_NO_REPAY")%>
       </td>
    </tr>
<%if(!TranType.equals(Const.C_HOME_CDE))
      {%>
    <tr> 
      <td colspan="2">赔款偿付地点(Claim Payable at)：<br> <%=Objects.getHt(hashData,"C_PAY_ADDR")%></td>
    </tr>
<%}%>
    <tr>        
      <td colspan="2" valign="top">查勘代理人(Survey By)：<br> <%=Objects.getHt(hashData,"C_SRVY_CNM")%></td>
    </tr>



  </table>
  <br>签单时间(Date)：<%=Objects.getHt(hashData,"T_SIGN_TM")%>

  <p align="center">
    <input type="button" value="在线咨询" name="button1" onclick="OpenChat(this.form)">
<%           if(ClientType.equals(Const.CUST_AG) || ClientType.equals(Const.CUST_OC)){
%>
   <input type="submit" value="打 印" name="B88">    
<%}%>
   <input type="button" value="前一页" name="B44" onclick='javascript:history.back();'>                  
</p>
  </form>
    </td>
  </tr>
</table>
<% String clientName = sessionbuffer.getuserId(Locate); %> 
<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
<script language=JavaScript>
function OpenChat(theForm){

  subject = theForm.C_DOC_NO.value ;
  href = "meeting/ClientLogin.jsp?user=<%=clientName%>&sub="+subject;
  js_openClientSmallPage(href);
}
</script>
