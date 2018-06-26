<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<jsp:useBean id="cb"  scope="page" class="beans.CustManagerBean"/>
<jsp:setProperty name="cb" property="*"/>
<%
//retrieve the parameter from the posted form
String RegisterType = request.getParameter("RegisterType");
String UserID = request.getParameter("UserID");
String UserPassword = request.getParameter("UserPassword");
String ConfirmPassword = request.getParameter("ConfirmPassword");
String Code = request.getParameter("Code");
String codeType = request.getParameter("codeType");
String EnterpriseName = request.getParameter("EnterpriseName");
String EnglishName = request.getParameter("EnglishName");
String CorporationDelegrate = request.getParameter("CorporationDelegrate");
String Province = request.getParameter("Province");
String City = request.getParameter("City");
String Place = request.getParameter("Place");
String Email = request.getParameter("Email");
String ZipCode = request.getParameter("ZipCode");
String Tel = request.getParameter("Tel");
String Fax = request.getParameter("Fax");
String C_RGST_NO = request.getParameter("C_RGST_NO");
String C_TRD_CDE = request.getParameter("C_TRD_CDE");
String OwenerShip = request.getParameter("OwenerShip");
String ContactorName = request.getParameter("ContactorName");
String C_REMARK = request.getParameter("C_REMARK");
String updateTime = request.getParameter("updateTime");
String Orgn = City.substring(City.indexOf("&")+1,City.length());
			City = City.substring(0,City.indexOf("&"));
//retrieve the object from the session
	HttpSession sess = request.getSession();
	String clientInfo[][] = (String[][])sess.getValue("clientInfo");
/*
	for (int i=0 ;i<clientInfo[0].length;i++){
		for(int j=0;j<clientInfo.length;j++)
			out.println(clientInfo[j][i]+" ");
		out.println("<br>");
	}*/

//prepare the parameter for register
Object objectFormPara[] = new Object[3];
com.mcip.cus.orb.CustOrgn custOrgn = new com.mcip.cus.orb.CustOrgn();
com.mcip.cus.orb.CustEntity custEntity = new com.mcip.cus.orb.CustEntity();
//prepare the CustEntity object
	custEntity.c_user_id = UserID;
	custEntity.c_user_name = EnterpriseName;
	custEntity.c_user_pw = UserPassword;
	custEntity.c_pw_question = "";
	custEntity.c_pw_result = "";
	custEntity.c_clnt_cde = "";
	custEntity.n_user_seq_no = 0;
	custEntity.c_verify = '0';
	custEntity.c_cmpny_agt_cde = "";
	custEntity.c_net_id = "001";
	if (codeType.equals("AGENT")){
		custEntity.c_cmpny_agt_cde = Code;
	}else{
		custEntity.c_clnt_cde = Code;
	}
if (codeType.equals("AGENT")){
		custOrgn.c_clnt_cde = Code;
		custOrgn.c_dpt_cde = Orgn;
		custOrgn.n_clnt_grp_cde=1;
		custOrgn.c_clnt_mrk = "0";
		custOrgn.c_clnt_nme = EnterpriseName;//
		custOrgn.c_chn_abr =  clientInfo[1][Objects.getColNum("C_AGT_ABR",clientInfo)];
		custOrgn.c_auth_mrk = clientInfo[1][Objects.getColNum("C_AUTH_MRK",clientInfo)];
		custOrgn.c_scale_cde="3";
		custOrgn.c_clnt_scle_cde="";
		custOrgn.c_orgz_typ_cde = "1";
		custOrgn.c_brd_enm = EnglishName;
		custOrgn.c_eng_abr = "";
		custOrgn.c_ownership_cde = OwenerShip;
		custOrgn.c_rgst_no = C_RGST_NO;
		custOrgn.c_tax_no = "";
		custOrgn.n_rgst_mny = 0;
		custOrgn.c_chief = CorporationDelegrate;
		custOrgn.n_emly_num = 0;
		custOrgn.c_trd_cde = C_TRD_CDE;
		custOrgn.c_upr_dpt_cde =clientInfo[1][Objects.getColNum("C_UPR_DPT_CDE ",clientInfo)];
		custOrgn.c_impt_clnt_cde = "";
		custOrgn.c_cntct_prsn_nme = ContactorName;
		custOrgn.c_tel = Tel;
		custOrgn.c_fax = Fax;
		custOrgn.c_email = Email;
		custOrgn.c_clnt_addr = clientInfo[1][Objects.getColNum("C_CLNT_ADDR",clientInfo)];
		custOrgn.c_ara_cde = "1001";
		custOrgn.c_province = Province;
		custOrgn.c_city = City;
		custOrgn.c_place = Place;
		custOrgn.c_zip_cde = ZipCode;
		custOrgn.c_bank = clientInfo[1][Objects.getColNum("C_BANK",clientInfo)];
		custOrgn.c_accnt_no = clientInfo[1][Objects.getColNum("C_ACCNT_NO",clientInfo)];
		custOrgn.c_remark = clientInfo[1][Objects.getColNum("C_REMARK",clientInfo)];
		custOrgn.t_upd_tm = updateTime;
}else{//open cover register
		try{
		custOrgn.n_clnt_grp_cde=Integer.parseInt(clientInfo[1][Objects.getColNum("C_ORGZ_TYP_CDE",clientInfo)]);
		custOrgn.n_rgst_mny = Double.parseDouble(clientInfo[1][Objects.getColNum("C_ORGZ_TYP_CDE",clientInfo)]);
		custOrgn.n_emly_num = Integer.parseInt(clientInfo[1][Objects.getColNum("N_EMLY_NUM",clientInfo)]);
		}catch(Exception e){
		custOrgn.n_clnt_grp_cde = 1;
		custOrgn.n_rgst_mny = 0;
		custOrgn.n_emly_num = 0;
		}
		custOrgn.c_clnt_cde = Code;
		custOrgn.c_dpt_cde = Orgn;
		custOrgn.c_clnt_mrk = clientInfo[1][Objects.getColNum("C_CLNT_MRK",clientInfo)];
		custOrgn.c_clnt_nme = EnterpriseName;//
		custOrgn.c_chn_abr =  clientInfo[1][Objects.getColNum("C_CHN_ABR",clientInfo)];
		custOrgn.c_auth_mrk = clientInfo[1][Objects.getColNum("C_AUTH_MRK",clientInfo)];
		custOrgn.c_scale_cde=clientInfo[1][Objects.getColNum("C_SCALE_CDE",clientInfo)];
		custOrgn.c_clnt_scle_cde=clientInfo[1][Objects.getColNum("C_CLNT_SCLE_CDE",clientInfo)];
		custOrgn.c_orgz_typ_cde = clientInfo[1][Objects.getColNum("C_ORGZ_TYP_CDE",clientInfo)];
		custOrgn.c_brd_enm = EnglishName;
		custOrgn.c_eng_abr = clientInfo[1][Objects.getColNum("C_ENG_ABR",clientInfo)];
		custOrgn.c_ownership_cde = OwenerShip;
		custOrgn.c_rgst_no = C_RGST_NO;
		custOrgn.c_tax_no = clientInfo[1][Objects.getColNum("C_TAX_NO",clientInfo)];
		custOrgn.c_chief = CorporationDelegrate;
		custOrgn.c_trd_cde = C_TRD_CDE;
		custOrgn.c_upr_dpt_cde =clientInfo[1][Objects.getColNum("C_UPR_DPT_CDE",clientInfo)];
		custOrgn.c_impt_clnt_cde = clientInfo[1][Objects.getColNum("C_IMPT_CLNT_CDE",clientInfo)];
		custOrgn.c_cntct_prsn_nme = ContactorName;
		custOrgn.c_tel = Tel;
		custOrgn.c_fax = Fax;
		custOrgn.c_email = Email;
		custOrgn.c_clnt_addr = clientInfo[1][Objects.getColNum("C_CLNT_ADDR",clientInfo)];
		custOrgn.c_ara_cde = "1001";
		custOrgn.c_province = Province;
		custOrgn.c_city = City;
		custOrgn.c_place = Place;
		custOrgn.c_zip_cde = ZipCode;
		custOrgn.c_bank = clientInfo[1][Objects.getColNum("C_BANK",clientInfo)];
		custOrgn.c_accnt_no = clientInfo[1][Objects.getColNum("C_ACCNT_NO",clientInfo)];
		custOrgn.c_remark = clientInfo[1][Objects.getColNum("C_REMARK",clientInfo)];
		custOrgn.t_upd_tm = updateTime;
}
//branch to the sucess or fail page
objectFormPara[0] = RegisterType;
objectFormPara[1] = custOrgn;
objectFormPara[2] = custEntity;
boolean registerSuccess = false;
String WarnMsg = "";
try{
	if (codeType.equals("AGENT"))
		cb.setObjectFormPara(Const.ACCEPT_AG_CUST,objectFormPara);
	else
		cb.setObjectFormPara(Const.ACCEPT_OC_CUST,objectFormPara);
	registerSuccess = cb.getRetValueBool();
}catch(NormalException e)
		{
	if(NormalExceptionHandler.IsSevere(e))
			throw NormalExceptionHandler.Handle(e);
	else if(NormalExceptionHandler.IsWarning(e))
			WarnMsg = e.getErrDesc();
		}
	if (registerSuccess)
		out.println("<font color=\"blue\">用户 "+UserID+" 注册成功!</font>");
	else
		out.println("<font color=\"red\">用户 "+UserID+" 注册失败!请稍后再试。</font>");
%>
<%@ include file="public/bottom.jsp" %>