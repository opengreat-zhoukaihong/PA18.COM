<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicMemLeft.jsp" %> 
    <td width="613" height="288" valign="top"> <br>
      <img src="images/xgmm.gif" width="150" height="31" alt="报案查询">

		<table border="0" width="489"  align="center" height="117">
		 <tr> 
			<td  height=20>

<jsp:useBean id="obj_cust"  scope="session" class="beans.CustManagerBean"/> 
<jsp:useBean id="obj_session"  scope="session" class="beans.StaticInfoBean"/>

<%  //for get login para and to bean
    String CustOrgn[] = new String[Const.CUSTORGN_LEN];
    String oldcust[][] = null;
    String CheckOrgn[] = null;
    String parapre[] = new String[1];
    boolean IsAccept = false;
    
    int i = 0;
    int t=0;
    
     parapre[0]=request.getParameter("userid");
     //obj_cust.setFormPara(Const.QUERY_CUSTORGN,parapre);
     oldcust=obj_cust.getRetValueArra();
    //oldcust=request.getParameter("custorg_name");
    //if (!oldcust==null) t=oldcust.length;
    
//=================================================================
// the following set custprsn=oldcust
//==================================================================

    for(i = 0; i < Const.CUSTORGN_LEN; i++)
         CustOrgn[i] = oldcust[1][i];
//=================================================================

//Objects.getValue(1,"C_CRGO_DESC",info)    
	String city=request.getParameter("C_CITY");
	int loc=city.indexOf("&");
	
	//debug
//	out.println("city="+city+" loc="+loc);
   CustOrgn[TabOrgn.C_CITY] = city.substring(0,loc);                                
	CustOrgn[TabOrgn.C_DPT_CDE] = city.substring(loc+1);
//debug 
//	out.println("city="+TabOrgn.C_CITY+" value="+CustOrgn[TabOrgn.C_CITY]);
//	out.println("dptcde="+TabOrgn.C_DPT_CDE+" value="+CustOrgn[TabOrgn.C_DPT_CDE]);

//
	 CustOrgn[0] = oldcust[1][0];
    CustOrgn[2] = oldcust[1][2];
    CustOrgn[3] = oldcust[1][3];
    CustOrgn[4] = request.getParameter("C_CNLT_NME");        
    CustOrgn[5] = request.getParameter("C_CNLT_ABR");            
    CustOrgn[6] = oldcust[1][6];

    CustOrgn[7] = request.getParameter("C_SCALE_CDE");            
    CustOrgn[8] = request.getParameter("C_CLNT_SCLE_CDE");                    
    CustOrgn[9] = request.getParameter("C_ORGZ_TYP_CDE");                    
    CustOrgn[10] = request.getParameter("C_BRD_ENM");                    
    CustOrgn[TabOrgn.C_ENG_ABR] = request.getParameter("C_ENG_ABR");                    
    CustOrgn[12] = request.getParameter("C_OWNERSHIP_CDE");                                
    CustOrgn[13] = request.getParameter("C_RGST_NO");                                
    CustOrgn[14] = oldcust[1][14];

    CustOrgn[15] = request.getParameter("N_RGST_MNY");                                
    CustOrgn[16] = request.getParameter("C_CHIEF");                                
    CustOrgn[17] = request.getParameter("N_EMLY_NUM");                                
    CustOrgn[18] = request.getParameter("C_TRD_CDE");                                
    CustOrgn[19] = oldcust[1][19];
    CustOrgn[20] = oldcust[1][20];

    CustOrgn[21] = request.getParameter("C_CNTCT_PRSN_NME");                                
    CustOrgn[22] = request.getParameter("C_TEL");                                
    CustOrgn[23] = request.getParameter("C_FAX");                                
    CustOrgn[24] = request.getParameter("C_EMAIL");                                

    CustOrgn[26] = request.getParameter("C_ARA_CDE");                                
    CustOrgn[TabOrgn.C_PROVINCE] = request.getParameter("C_PROVINCE");                                
    CustOrgn[29] = request.getParameter("C_PLACE");                                
//    CustOrgn[29] = CustOrgn[25];

    CustOrgn[30] = request.getParameter("C_ZIP_CDE");    
    CustOrgn[31] = oldcust[1][31];
    CustOrgn[32] = oldcust[1][32];
    CustOrgn[TabOrgn.C_REMARK] =request.getParameter("C_REMARK") ;//change by zlx 20001.1.5
                                
//    System.out.println("CheckEntitylentg:"+CheckEntity.length);
    for(i = 0; i < Const.CUSTORGN_LEN; i++)
         if(CustOrgn[i] ==null) CustOrgn[i]="";
    i = 0;
    
    i=CustOrgn.length;
    
    try
    {
        //Is to be check custorgn fields
        obj_cust.setFormParaPre(Const.UPDATE_ORGACUST,parapre);
        obj_cust.setFormPara(Const.UPDATE_ORGACUST,CustOrgn);
		 IsAccept = obj_cust.getRetValueBool();
    }
    catch(NormalException e)
    {
 		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
    if(IsAccept) 
    {  %>
		<font color="#FF0000">修改机构资料已成功!</font>
    <% }
    else {   %>
      <font color="#FF0000">修改机构资料提交没有成功!</font>
    <% } %>
			</td>
		</tr> 
		</table>

	</td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   
</body>
</html>