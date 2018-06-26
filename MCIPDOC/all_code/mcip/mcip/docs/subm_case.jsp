<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>
<body>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>


<jsp:useBean id="obj"  scope="page" class="beans.ZPolicybean"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<%

	int i=0;

	String info[] = new String[ZConst.CASERPTINFO_LEN];
	String caseno[][]=null;
	String Para[]={"C_PLY_NO","C_INSRNT_NME","C_INSRNT_CDE","C_RPT_NME"
  		,"C_ACCDNT_SPOT","C_ACCDNT_CAUS","C_LOS_DTL","C_CUR_TYP"

		,"N_RPT_AMT","C_INSRNC_CDE","C_DPT_CDE","T_INSRNC_BGN_TM","T_INSRNC_END_TM","N_AMT"

		,"C_AMT_CUR"};





	for(i=0;i<ZConst.CASERPTINFO_LEN;i++)
		info[i]="";
// debug

	for(i=0;i<Para.length;i++)

	{

		if(ZObjects.getcase(Para[i])==-1)

			out.println(" have -1 in "+i+"  --  "+Para[i]+" --end --");

		else

//			out.println(" -- in "+ZObjects.getcase(Para[i])+"  --  "+Para[i]+" -end-");

			info[ZObjects.getcase(Para[i])]=request.getParameter(Para[i]);

	}



	info[ZObjects.getcase("t_accdnt_tm")]=request.getParameter("T_ACCDNT_YEAR")+"-"

			+request.getParameter("T_ACCDNT_MONTH")+"-"+request.getParameter("T_ACCDNT_DAY");

	info[ZObjects.getcase("C_RPT_ADDR_TEL")]=request.getParameter("C_PROVINCE")+request.getParameter("C_CITY")

		+request.getParameter("C_ADDR")+" "+request.getParameter("C_RPT_TEL");

//	out.println("tmp="+info[ZObjects.getcase("C_RPT_ADDR_TEL")]);
		 obj.setFormPara(ZConst.ACCEPT_CASERPT,info);
	    caseno = obj.getRetValueArra();

    i=222;

    if(caseno!=null)i=888;

    String  retArr[][] = null;
	String  c_dpt_cde=request.getParameter("C_DPT_CDE");
	try
	  {
	    
   	    sb.setFieldValue(Const.GET_RPTTELNUM,c_dpt_cde);
	    retArr = sb.getRetValueArra();
	    
	  }catch(NormalException e)
	  {
	 	   if(NormalExceptionHandler.IsSevere(e))
	 	       throw NormalExceptionHandler.Handle(e);
	 	    else if(NormalExceptionHandler.IsWarning(e))
	 	       WarnMsg = e.getErrDesc();
        }
     int c_rpt_tel = Objects.getColNum("C_RPT_TEL", retArr);

%>

 

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">

  <tr>
   <%@ include file="public/PublicRepLeft.jsp" %>

   <td width="613" height="288" valign="top"><br> <p></p>
   <table width="80%"><tr><td>   报案正在接受审理,你的报案号是：<%=Objects.getValue(1,"C_RPT_NO",caseno)%>

   我们将尽快与您取得联系，您可以通过理赔电话：<%=retArr[1][c_rpt_tel]%>查询。我们将以最快的速度把审核结果通过E-MAIL告知您，您也可以随时上网查询。

</td></tr></table>
</td></tr></table>

<%@ include file="public/PublicBottom.html" %>

</body>
</html>