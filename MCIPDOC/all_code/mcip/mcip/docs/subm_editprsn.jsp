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
<%  //for get login para and to bean
    String oldcust[][] = null;
    String CustPrsn[] = new String[Const.CUSTPRSN_LEN];
    String parapre[] = new String[1];
    boolean IsAccept = false;
    boolean Isright = false;
    String Syear = "";
    String Smonth = "";
    String Sday = "";
    String Birthday = "";
    int i = 0;
    int ttt = 0;

    parapre[0]=request.getParameter("userid");
    //obj_cust.setFormPara(Const.QUERY_CUSTPRSN,parapre);
    oldcust=obj_cust.getRetValueArra();

	
/*
	ttt=CustPrsn.length;

	out.println("i="+i);
	out.println("tt="+ttt);
*/
//=================================================================
// the following set custprsn=oldcust,notice cust.len=35 and oldcust.len=34
//================================================
    for(i = 0; i < Const.CUSTPRSN_LEN-2; i++)
         CustPrsn[i] = oldcust[1][i];
             
    CustPrsn[Const.CUSTPRSN_LEN-2]="";
    CustPrsn[Const.CUSTPRSN_LEN-1]=oldcust[1][oldcust[1].length-1];

//==================================================================
	String city=request.getParameter("C_CITY");
	int loc=city.indexOf("&");
	
	CustPrsn[TabPrsn.C_CITY] = city.substring(0,loc);                                
	CustPrsn[TabPrsn.C_DPT_CDE] = city.substring(loc+1);

	 CustPrsn[TabPrsn.C_CLNT_NME] = request.getParameter("C_CLNT_NME");        

    CustPrsn[9] = request.getParameter("C_RGST_NO");                    
    CustPrsn[10] = request.getParameter("C_SEX");                    
//    CustPrsn[11] = oldcust[1][11];

    CustPrsn[12] = request.getParameter("C_NTN_CDE");                                

    
    Syear = request.getParameter("birth_year");
    Smonth = request.getParameter("birth_month");
    Sday = request.getParameter("birth_day"); 
    //is to check valid of birthday    
    Birthday = Syear+"-"+Smonth+"-"+Sday;   
    CustPrsn[13] = Birthday; 

    CustPrsn[14] = oldcust[1][14];
    CustPrsn[15] = request.getParameter("C_GRDT");                                
    CustPrsn[16] = request.getParameter("C_MAJOR_CDE");                                
    CustPrsn[17] = request.getParameter("C_EDU_CDE");                                
//    CustPrsn[18] = request.getParameter("C_WORK_DPT");                                
    CustPrsn[19] = request.getParameter("C_TITLE_CDE");                                
    CustPrsn[20] = request.getParameter("C_DUTY");                                
    CustPrsn[21] = request.getParameter("C_TEL");                                
    CustPrsn[22] = request.getParameter("C_FAX");                                
    CustPrsn[23] = request.getParameter("C_EMAIL");                                

    CustPrsn[24] = oldcust[1][24];
    
    CustPrsn[25] = request.getParameter("C_ARA_CDE");                                
    CustPrsn[26] = request.getParameter("C_PROVINCE");                                
    CustPrsn[TabPrsn.C_PLACE] = request.getParameter("C_PLACE");                                
    CustPrsn[29] = request.getParameter("C_ZIP_CDE");                                

/*
    CustPrsn[30] = oldcust[1][30];
    CustPrsn[31] = oldcust[1][31];
    CustPrsn[32] = oldcust[1][32];
*/
    try
    {
        //Is to be check custorgn fields
        obj_cust.setFormParaPre(Const.UPDATE_PRSNCUST,parapre);
        obj_cust.setFormPara(Const.UPDATE_PRSNCUST,CustPrsn);
			IsAccept = obj_cust.getRetValueBool();
    }
    catch(NormalException e)
    {
 		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }

    if(IsAccept) 
    {  %>
		<font color="#FF0000">修改个人资料已成功!</font>
    <% }
    else {   %>
      <font color="#FF0000">修改个人资料提交没有成功!</font>
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
