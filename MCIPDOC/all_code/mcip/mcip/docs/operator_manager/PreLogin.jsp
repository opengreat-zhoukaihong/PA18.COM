<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : PreLogin.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/PreLogin.jsp
*Previous Page : Staff_login.jsp(by posted form)
*Next Page : BackManage.jsp(by directly forward)
*Author : Lawrence Kang
*Created Date : 2000/09/20
*Last Updated : 2000/10/08
*Status : submit for test
*Function : I.Operator authorization
*			II.Save authorized operator's information into SessionUser bean
*			III.Forward to the nextpage
*============================MODIFIED HISTORY==================================================
*Date : 
*Time : 
*Modify id : 
*Modifier : 
*Reason : 
***********************************************************************************************
*/
%>

<%@ page language="java" import="java.lang.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp"%>
<%
   response.setHeader("Pragma","No-Cache");
   response.setDateHeader("Expires",0);
   response.setHeader("Cache-Control","no-Cache");
%>
<jsp:useBean id="ub"  scope="session" class="beans.UserManagerBean"/> 
<jsp:setProperty name="ub" property="*"/>



<%  //for get login para and to bean



    String[] FormPara = new String[2];//Parameter Form
    String Result[][] = null; //Result table
	String UrlStr = "";//the url of the redirected page
	String temp = StringTool.null2Blank(request.getParameter("temp"));
    int ResultLen = 0,i=0;
    FormPara[0] = request.getParameter("C_OPR_CDE");
    FormPara[1] = request.getParameter("C_OPR_PW");



    try
    {
        ub.setFormPara(ZConst.OPERATOR_LOGIN,FormPara);
        Result = ub.getRetValueArra();
    }
    catch(NormalException e)
    {

		Result = null;
    out.println(e);
    // throw NormalExceptionHandler.Handle(e);
    }

	//Save the Operator detail to the sessions
	//Account				C_OPR_CDE
	//Department				C_DPT_CDE
	//List of the available functions	functionList

//    ResultLen = Servlets.getLen(Result);
//    if(ResultLen < 2)
//    {
//    System.out.println("4444444444444aaaaaaaaaaResultLen:"+ExceptionCode.NO_CLIENT_INFO);
//            throw NormalExceptionHandler.Handle(ExceptionCode.NO_CLIENT_INFO);
//    }
//        System.out.println("4444444444444aaaaaaaaaaResultLen:"+ResultLen);

	//Get all the requested field

	if (Result != null && Result.length>1)
	{
		//获得所需字段的所在列的索引

		int index_opr_cde = Objects.getColNum("C_OPR_CDE",Result);   //操作者帐号
		int index_dpt_cde = Objects.getColNum("C_DPT_CDE",Result);   //操作者部门
		int index_func_cde   = Objects.getColNum("C_FUNC_CDE",Result);  //功能编码
		int index_func_cnm = Objects.getColNum("C_FUNC_CNM",Result);//中文名称
		int index_emp_cde = Objects.getColNum("C_EMP_CDE",Result);//操作员公司员工编号
		int index_acredt_cde = Objects.getColNum("C_ACREDT_CDE",Result);//授权者帐号
		int index_sys_admin = Objects.getColNum("C_SYS_ADMIN",Result);//超级用户标志

		String c_opr_cde=Result[1][index_opr_cde];
		
		HttpSession https = request.getSession(true);
		
		String c_dpt_cde=Result[1][index_dpt_cde];
		String c_emp_cde=Result[1][index_emp_cde];
		String c_acredt_cde=Result[1][index_acredt_cde];
		String c_sys_admin=Result[1][index_sys_admin];

		String c_func_cde[]=new String[Result.length-1];
		String c_func_cnm[]=new String[Result.length-1];

		for (i=1;i<Result.length;i++)
		{
			if (Result[i][index_func_cde]!=null)
				c_func_cde[i-1]=Result[i][index_func_cde];
			if (Result[i][index_func_cnm]!=null)
				c_func_cnm[i-1]=Result[i][index_func_cnm];
		}
		//Fill the necessary field to the sessions

		SessionUser sessionuser = SessionUser.getSessionUser();
		String sessionId = new String(sessionuser.getNewSessionId());
		int  Locate = sessionuser.ProcessSession(Const.SESSNEW,sessionId);


    //----------------add by raohanmin 2000.11.27-----------
    String[][] dptList = null;
    int rowCount = 0;
    try
    {

        ub.setFormPara(ZConst.QUERY_OPTRDPTLIST,FormPara);
        dptList = ub.getRetValueArra();
        rowCount = dptList.length;
    }
    catch(NormalException e)
    {
    out.println(e);
      rowCount =0;

    }
    if(rowCount>1){
        Hashtable table = new Hashtable() ;
        Vector Dpt_Cde_List  = new Vector(40);
        DepartmentInfo  dptInfo;
        for(int rowId=1 ; rowId< rowCount; rowId++){
         //out.println("<p>"+dptList[rowId][1] + ","+ dptList[rowId][2]);
             dptInfo = new DepartmentInfo(dptList[rowId][1],dptList[rowId][2],
             dptList[rowId][3],dptList[rowId][4],dptList[rowId][5],dptList[rowId][6]);
             table.put(dptList[rowId][1],dptInfo);
             Dpt_Cde_List.add(dptList[rowId][1]);
        }
        ub.setLoggerDptList(table);
        ub.setLoggerDpt_CDE_List(Dpt_Cde_List);
        out.println("<p>dpt:"+table.size());
        Hashtable mytable = ub.getLoggerDptList();
        out.println(mytable.size());


    }

/* Commented By Liuxy
     MessageBean mb = MessageBean.instance;
     String myName= c_opr_cde ;//sessionuser.getuserId(Locate);
     String[] authOrgs = null;
     String[] authInsurances= c_func_cde ;//sessionuser.getfuncCode(Locate) ;
     Vector Logger_DPT_Cde_List = ub.getLoggerDpt_CDE_List();
     if(Logger_DPT_Cde_List.size()>0){
          authOrgs = new String[Logger_DPT_Cde_List.size()];
          for(i =0 ;i < Logger_DPT_Cde_List.size() ;i++)
              authOrgs[i] = (String)Logger_DPT_Cde_List.get(i);
     }
     //server= new Server(myName,authInsurances,authOrgs);
     mb.ServerLogin(myName,authInsurances,authOrgs);
      
*/   

    //-----------------------end added by rao--------------------
		if (Locate >= 0)
		{
			sessionuser.setUserId(Locate,c_opr_cde);
			sessionuser.setdepartId(Locate,c_dpt_cde);
			sessionuser.setfuncName(Locate,c_func_cnm);
			sessionuser.setemployeCode(Locate,c_emp_cde);
			sessionuser.setauthorCode(Locate,c_acredt_cde);
			sessionuser.setadminFlag(Locate,c_sys_admin);
			sessionuser.setfuncCode(Locate,c_func_cde);

			request.setAttribute("sessionId",Code.Encrypt(sessionId));
			sessionId =  Code.Encrypt(sessionId);
			if (!temp.equals("yes")){
				UrlStr = "backHome.jsp?initLogin=true&sessionId="+sessionId;
		 		response.sendRedirect(UrlStr);
			}
			else{
				UrlStr = "B_FAQ_List.jsp?initLogin=true&sessionId="+sessionId;
		 		response.sendRedirect(UrlStr);
			}
		}
		else
		{
			UrlStr = "index.jsp?errCde=0001";
			response.sendRedirect(UrlStr);
		}
	}
	else
	{
	 	UrlStr = "index.jsp?errCde=0002";
	 	response.sendRedirect(UrlStr);
	}
%>

