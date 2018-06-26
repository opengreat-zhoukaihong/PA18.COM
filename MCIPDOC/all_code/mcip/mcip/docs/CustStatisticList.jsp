
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL="STYLESHEET" TITLE="text" TYPE="text/css" href="table.css">
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
function IsNoticeModify(field,Form)
{
     var str = field.value;
     if(str == null)//for netscape
     {
         str = field.options[field.selectedIndex].value;
     }
     if(str=="")
       return;
     if(str.indexOf("&") > 0) {

	   if(Form.AGENCYNO.value=="<%=Const.CASE%>" || Form.AGENCYNO.value=="<%=Const.EDRSMTAPP%>" ){

         Form.action="Policy_OC.jsp";

	   }else{

	      Form.action = "Notice.jsp";

	   }

	    return;

      }

	 else{

	    if(Form.AGENCYNO.value=="<%=Const.CASE%>" || Form.AGENCYNO.value=="<%=Const.EDRSMTAPP%>"){

		  Form.action="Policy.jsp";

		}

		return;

	 }
}
</SCRIPT>
<%@ include file="public/Public.jsp" %>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pb"  scope="session" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>

<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/>

<jsp:setProperty name="pmb" property="*"/>

<% String Policy[][] = null;
   int PolicyLen = 0;
   int i = 0;
   String ClientId = sessionbuffer.getuserId(Locate);//getClientId(Locate);
   String ClientType = sessionbuffer.getClientType(Locate);
   String TranType = ob.getTranType();
   String[] Transit = ob.getHomeTransit();
  // String FormPara[] = new String[3];

   String FormPara[] = {"","","0"};
   //if comefrom agencylist:agencyNo is "" foward to InputPolicy else is null contnue else getpolydata
   String AgencyNo = null;
   String AddAgencyNo = null;
   String SrcnNo = null;
   int OperType = 0;
   String PlyCnm = Const.PLY_CNM;
   //for pagelist display hold data
   String HoldAgencyNo="";
// String Holdcheckply="";
// String Holdcheckdate="";
   String HoldRadio="";
   String HoldC_PLY_APP_NO="";
   String Holdtempdatefr="";
   String Holdtempdateto="";
   String PolicyPic = "images/list.gif";

   ob.setStep(Const.STEP_BEG);
   AgencyNo = request.getParameter(Const.C_AGENCY_NO);
   HoldAgencyNo = AgencyNo;



   request.setAttribute("AGENCYNO",AgencyNo);






   if(AgencyNo.equals(""))
   {


 %>
     <jsp:forward page="InputPolicy.jsp"/>
 <%
   }
   else if(AgencyNo.equals(Const.CLAUSE))
   {


        FormPara[0] = ClientId;
	try
	{
	 	TranType = Servlets.GetInsrnc(TranType,Transit);
	}
	catch(NormalException e)
	{
	     if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
	     else if(NormalExceptionHandler.IsWarning(e))
	 	    WarnMsg = e.getErrDesc();

	}
	catch(Exception e)
	{
	   throw NormalExceptionHandler.Handle(e);
	}
        FormPara[1] = TranType;

		if(TranType.equals(Const.C_EXPORT_CDE))//outport

        {

          FormPara[2] = ob.getCredit();

        }else{

		  FormPara[2] = "0";

		}
        OperType = Const.GET_CUSTPLCYLIST;
   }
   else if(AgencyNo.equals(Const.FIND) || AgencyNo.equals(Const.CASE)  || AgencyNo.equals(Const.MODIFY) || AgencyNo.equals(Const.PRP) || AgencyNo.equals(Const.EDRSMTAPP) || AgencyNo.equals(Const.EDRSMT))
   {
       String CheckedField = request.getParameter("checkOption");
       String Plyno = "";
       String datefr ="";
       String dateto = "";

       HoldRadio = CheckedField;//checkOption value

       if(CheckedField.equals("0"))//ply
       {
           Plyno = (request.getParameter("C_PLY_APP_NO")).trim();
           HoldC_PLY_APP_NO=Plyno;

       }
       if(CheckedField.equals("1"))//date
       {
          datefr =  request.getParameter("tempdatefr");
          dateto =  request.getParameter("tempdateto");
          Holdtempdatefr=datefr;
          Holdtempdateto=dateto;

       }
       FormPara = new String[5];
       FormPara[0] = ClientId;
       FormPara[1] = Plyno;
       FormPara[2] = datefr;
       FormPara[3] = dateto;
       FormPara[4] = ClientType;

       if(AgencyNo.equals(Const.FIND))
       {
          OperType = Const.GET_POLICYAPPLIST;
	      PlyCnm = Const.PLYAPP_CNM;
	      PolicyPic = "images/tbdlb.gif";
       }
       else if(AgencyNo.equals(Const.CASE) || AgencyNo.equals(Const.MODIFY))
       {
              OperType = Const.GET_POLICYLIST;
       	      PlyCnm = Const.PLY_CNM;
       }
       else if(AgencyNo.equals(Const.PRP))
       {
              OperType = Const.GET_PROPOSALLIST;
       	      //PlyCnm = Const.PRP_CNM;

			  PlyCnm =  Const.PLYAPP_CNM;
	          PolicyPic = "images/jyslb.gif";
       }else if(AgencyNo.equals(Const.EDRSMTAPP)){


	          OperType =  Const.GET_EDRAPPLIST;

	          PlyCnm = "批改申请单";

			  PolicyPic = "images/pigailb-b.gif";

	   }else if(AgencyNo.equals(Const.EDRSMT)){


	          OperType = Const.GET_EDRSMTLIST;

	          PlyCnm = "批单";

			  PolicyPic = "images/pidanlb-b.gif";

	   }

   }
   else
   {
        String TempData[] = new String[3];
        TempData = Servlets.DivideMultiStr(AgencyNo,"&");
        FormPara[0] = TempData[0];
        FormPara[1] = TempData[1];

		if(FormPara[1].equals(Const.C_EXPORT_CDE))//outport

        {

          FormPara[2] = ob.getCredit();

        }else{

		  FormPara[2] = "0";

		}
        OperType = Const.GET_AGENCYPLCYLIST;
        AgencyNo = TempData[0];
        AddAgencyNo = TempData[2];
   }

    String IsPageNow = request.getParameter("PAGE");
    try
    {
	    if(IsPageNow == null)
	    {



			if(AgencyNo.equals(Const.EDRSMTAPP) || AgencyNo.equals(Const.EDRSMT)){

			    String findEdrAppParas[] = new String[6];

				findEdrAppParas[0] = ClientId;

                findEdrAppParas[1] = FormPara[1];

				findEdrAppParas[2] = "";

                findEdrAppParas[3] = FormPara[2];

                findEdrAppParas[4] = FormPara[3];

                findEdrAppParas[5] = FormPara[4];


				pb.setFormPara(OperType,findEdrAppParas);



			}else{


			   pb.setFormPara(OperType,FormPara);

			}
        }
        Policy = pb.getRetValueArra();

    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

    }
    catch(Exception e)
    {
 	    throw NormalExceptionHandler.Handle(e);
    }
    ////for testing :
   /*    Policy = new String[2][1];
    Policy[0][0] = "c_ply_no";
    Policy[1][0] = "5158800020200000004";
   */
    ////end testing




    PolicyLen = Servlets.getLen(Policy);

    int c_ply_no   = 0;
    //for page list loop pages
    int ArrayRowLen =  PolicyLen;
    String PageListUrl = "PolicyList.jsp";
    String FormName = "New_baodan";




    String newAgencyNo = "";

	StringTokenizer st = new StringTokenizer(HoldAgencyNo , "&");

    while (st.hasMoreTokens()) {


		 if(!newAgencyNo.equals("")){

		   newAgencyNo =  newAgencyNo +"%26";

		 }



		 newAgencyNo =  newAgencyNo +(String)(st.nextToken());


    }

	HoldAgencyNo = newAgencyNo;




    String ListParas="?"+Const.C_AGENCY_NO+"="+HoldAgencyNo+"&checkOption="+HoldRadio
                 +"&C_PLY_APP_NO="+HoldC_PLY_APP_NO
                 +"&tempdatefr="+Holdtempdatefr+"&tempdateto="+Holdtempdateto
                 +"&"+MenuMake.MENU_REF+"="+MenuRef;
	ob.setSavedResult(Policy);
%>



<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>
<%
if(MenuRef.equals("MENU_REPORT"))
{
%>
<td width="165" height="288" valign="top">
<img src="images/rep_rep.gif" width="190" height="54"><br>
<br>　<a href="index.jsp?Logout=0"><img src="images/hback.gif" width="80" height="50" alt="返回首页" border="0"></a>
</td>
<%
}
else if(MenuRef.equals("FindPly") || MenuRef.equals("FindPrp") )
{
%>
<%@ include file="public/PublicInquireLeft.jsp" %>
<%
}else
{
%>
<%@ include file="public/PublicPlyLeft.html" %>
<%
}
%>


    <td width="613" height="288" valign="top">
<form name="New_baodan" METHOD="POST" action="InputPolicy.jsp">
        <table width="95%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2" height="10" align="center">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2" height="15" ><img src="<%=PolicyPic%>" width="150" height="31" alt="<%=PlyCnm%>列表"></td>
          </tr>
          <tr>
            <td colspan="2" height="10" align="center">&nbsp;</td>
          </tr>
          <tr>
            <td colspan="2" height="15" align="center">
              <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
     <tr bgcolor="#99FFFF" align="center">
      <td width="13%" bgcolor="#C0C0C0" align="center"><%=PlyCnm%>号</td>

	  <% if(AgencyNo.equals(Const.EDRSMTAPP) || AgencyNo.equals(Const.EDRSMT)) {%>

	  <td width="13%" bgcolor="#C0C0C0" align="center">保单号</td>

	  <%}%>
      <td width="9%" bgcolor="#C0C0C0" align="center">发票/提单号</td>
      <td width="10%" bgcolor="#C0C0C0" align="center">起始港</td>
      <td width="10%" bgcolor="#C0C0C0" align="center">目的港</td>
      <td width="9%" bgcolor="#C0C0C0" align="center">保险金额</td>
<%if(AgencyNo.equals(Const.FIND) || AgencyNo.equals(Const.EDRSMTAPP)){%>
      <td width="4%" bgcolor="#C0C0C0" align="center">有否建议书</td>
<%}%>
<%if(!AgencyNo.equals(Const.FIND) && !AgencyNo.equals(Const.PRP) && !AgencyNo.equals(Const.EDRSMTAPP) && !AgencyNo.equals(Const.EDRSMT)){%>
	<td width="8%" bgcolor="#C0C0C0" align="center">付费标志</td>
	<%}%>
    </tr>

<%
   if(PolicyLen > 1)
   {
      String ColName = "";
      if(AgencyNo.equals(Const.FIND) || AgencyNo.equals(Const.PRP))
      {
      	ColName = "c_ply_app_no";
      }else if(AgencyNo.equals(Const.EDRSMTAPP)){

	     ColName = "c_edr_app_no";

	  }else if(AgencyNo.equals(Const.EDRSMT)){

	     ColName ="c_edr_no";

	  }
      else
      {
        ColName = "c_ply_no";
      }

     //for(int p=0; p < Policy[0].length;p++)

	 // out.println(Policy[0][p]+"<p>");
     c_ply_no = Objects.getColNum(ColName,Policy);
     int c_sail_no = Objects.getColNum("c_sail_no",Policy);

	 int c_invc_no = Objects.getColNum("c_invc_no",Policy);

	 int c_receipt_no = Objects.getColNum("c_receipt_no",Policy);
     int c_from_prt = Objects.getColNum("c_from_prt",Policy);
     int c_to_prt = Objects.getColNum("c_to_prt",Policy);
     int n_amt = Objects.getColNum("n_amt",Policy);
     int prpsl_exist = Objects.getColNum("prpsl_exist",Policy);

	 int BAODAN_NO = Objects.getColNum("c_ply_no",Policy);

	 int C_READ_FLAG = Objects.getColNum("C_READ_FLAG",Policy);

	 int indexPayFlag = Objects.getColNum("C_PAY_FLAG",Policy);
	 //for(i = begini ;i< endi;i++ )
	 for (i = 0;i<Policy.length;i++);
    {
%>
    <tr>
      <td width="13%" height="16"><%=Policy[i][c_ply_no]%></a></td>

	  <% if(AgencyNo.equals(Const.EDRSMTAPP) || AgencyNo.equals(Const.EDRSMT)){%>

	     <td width="13%" height="16"><%=Policy[i][BAODAN_NO]%>&nbsp;</td>

	  <%}%>
      <td width="9%" height="16"><% if(Policy[i][c_invc_no].length()>0){%><%=Policy[i][c_invc_no]%><%}else{%><%=Policy[i][c_receipt_no]%><%}%>&nbsp;</td>
      <td width="10%" height="16"><%=Policy[i][c_from_prt]%>&nbsp; </td>
      <td width="10%" height="16"><%=Policy[i][c_to_prt]%>&nbsp; </td>
      <td width="9%" height="16" align="right"><%=Policy[i][n_amt]%>&nbsp; </td>
	<%if(AgencyNo.equals(Const.FIND) || AgencyNo.equals(Const.EDRSMTAPP)){%>
      <td width="4%" height="16">
	      <%if(Policy[i][prpsl_exist].equals("0")){%>
	         否
	      <%}else if(prpsl_exist == 0){%>
	          不定
	      <%}else{

		       if(Policy[i][C_READ_FLAG].equals("1")){%>

			   <image src="images/new.gif">

		     <%}else{%>
	       <font color="#ED7CC9">  有</font>
	      <%}}%>
      </td>
   <%}%>
		  <%if(!AgencyNo.equals(Const.FIND) && !AgencyNo.equals(Const.PRP) && !AgencyNo.equals(Const.EDRSMTAPP) && !AgencyNo.equals(Const.EDRSMT)){%>
		  <td width="8%" height="16"><%if (Policy[i][indexPayFlag].equals("1")){%>保费已付<%}else{%>保费未付<%}%></td>
		  <%}%>
    </tr>
<%
   }
  }
  else
  {
%>
没有取得<%=PlyCnm%>数据
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

            </td>
          </tr>

          <tr>
            <td colspan="2" height="10" align="center">&nbsp;<br><br>
            </td>
          </tr>

        </table>
      <%String sessionid = Code.Encrypt(sessionId);%>
    <input type="hidden" name="sessionid" value="<%=sessionid%>">
    <input type="hidden" name="OPER" value="PLYAPPNEW">
    <input type="hidden" name="AGENCYNO" value="<%=AgencyNo%>">
    <input type="hidden" name="ADDAGENCYNO" value="<%=AddAgencyNo%>">

    <input type="hidden" name="<%=Const.C_AGENCY_NO%>" value="<%=HoldAgencyNo%>">
    <input type="hidden" name="checkOption" value="<%=HoldRadio%>">
    <input type="hidden" name="C_PLY_APP_NO" value="<%=HoldC_PLY_APP_NO%>">
    <input type="hidden" name="tempdatefr" value="<%=Holdtempdatefr%>">
    <input type="hidden" name="tempdateto" value="<%=Holdtempdateto%>">
    <input type="hidden" name="<%=MenuMake.MENU_REF%>" value="<%=MenuRef%>">

      </form>
    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>

</body>
</html>
