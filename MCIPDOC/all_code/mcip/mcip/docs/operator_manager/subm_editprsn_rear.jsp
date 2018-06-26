<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../style.css">

<title>个人</title>
<base target="main">

</head>

<body>


<%@ page language="java" import="java.lang.*,java.util.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

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
/*
    for(i = 0; i < oldcust[1].length; i++)
         if(CustPrsn[i] ==null) CustPrsn[i]="";
*/
    // oldcustorg = request.getParameter("custorg_name");        
/*    for(i = 4; i < 29; i++)
    {
      if(i==5 || i ==6 || i==7 ||i==8 ) continue;
      if( !(CustPrsn[i].equals(oldcustorg[1][i])) )
      {
         Isright = true;  
         break;
      } 
    }
*/
    if(  (CustPrsn[21].trim()).length()==0 ) 
    %>
       <p> 操作失败,电话号码empty！ </p>
    <%
/*    
	i=CustPrsn.length;
    for(i = 0; i < oldcust[1].length; i++)
         CustPrsn[i] = oldcust[1][i];
*/
    try
    {
        //Is to be check custorgn fields
        obj_cust.setFormParaPre(Const.UPDATE_PRSNCUST,parapre);
        obj_cust.setFormPara(Const.UPDATE_PRSNCUST,CustPrsn);
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
    //ttt=oldcust[1].length;
    IsAccept = obj_cust.getRetValueBool();
    if(IsAccept)  
    { %>
       <p><H2> 操作成功   </p>
 <% }
    else {  %>
       <p><H2> 操作失败    </p>
    <%   }    %>


  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.go(-2);'>  
</body>
</html>
