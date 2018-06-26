
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>

<%  //for get login para and to bean


    SessionUser mySession = sessionuser;
    

    java.lang.String in_opr_cde= request.getParameter("opr_cde");
    java.lang.String auth_opr_cde = mySession.getuserId(Locate);
    java.lang.String funcCodes[] = request.getParameterValues("funcCodes");
    java.lang.String dptList[] = request.getParameterValues("AuthDptList");

    java.lang.String optrdptinfo[][] = null;
    boolean IsAccept = false;
	
    if(dptList!=null && dptList.length>0 ){
         int Len = dptList.length;
         Hashtable v= new Hashtable();
         for(int j=0 ; j< Len ; j++){
           String  str = dptList[j];
             int p = str.indexOf(",");
			 String key = str.substring(0,p);
			 String value = str.substring(p+1); 
			 
             v.put(str.substring(0,p), str.substring(p+1));
			 
            
         }
		 
         Len =  v.size();
        
        if(Len>0){
            optrdptinfo = new String[Len][3];
            String c_dpt_cde, c_snr_dpt;
            int j=0 ;
            for( Enumeration keys= v.keys(); keys.hasMoreElements(); j++ ){
                   c_dpt_cde = (String)keys.nextElement();
                   c_snr_dpt = (String)v.get(c_dpt_cde);
                   optrdptinfo[j][0] = in_opr_cde;
                   optrdptinfo[j][1] = c_dpt_cde;
                   optrdptinfo[j][2] = c_snr_dpt;
            }
        }

    }

    java.lang.String optrauthinfo[][]= null;

    if(funcCodes!=null && funcCodes.length>0){
         optrauthinfo = new String[funcCodes.length][2];
         for(int i=0; i< funcCodes.length ;i++){
         optrauthinfo[i][0]= in_opr_cde ;
         optrauthinfo[i][1]= funcCodes[i];
     }
   }


    String act_typ ="3";
     /*for(int p=0 ; p< optrauthinfo.length ;p++)
      out.println( optrauthinfo[p][0] +"," +  optrauthinfo[p][1]);
      out.println("CVM</p>");
      for(int p=0 ; p< optrdptinfo.length ; p++)
        out.println( optrdptinfo[p][0] +"," +  optrdptinfo[p][1]+ "," + optrdptinfo[p][2]);
       */

   try
    {
       if(optrauthinfo==null ||  optrdptinfo==null){
          String as[][]  = {{"",""}};
          String bs[][]  = {{"",""}};
         ub.ExecuteAuth(ZConst.EXECUTE_OPTRAUTH, "2" ,auth_opr_cde,
                             in_opr_cde, as, bs)  ;
       }else{
          ub.ExecuteAuth(ZConst.EXECUTE_OPTRAUTH, act_typ ,auth_opr_cde,
                             in_opr_cde, optrauthinfo, optrdptinfo)  ;
       }
    }
    catch(NormalException e)
    {
 	    //if(NormalExceptionHandler.IsSevere(e)){
 	     throw NormalExceptionHandler.Handle(e);
     // }
    }
    
    IsAccept = ub.getRetValueBool();
    String errText= new String("you failure");
    if(IsAccept)
    {
%>
 <font color="#0066CC"><span class="unnamed3">修改后台操作人员权限成功</span></font>
 <a href="authList.jsp">返回</a>
<%
    }
    else
    {
%>
<font color="#0066CC"><span class="unnamed3">修改后台操作人员权限失败</span></font>
<%

     }

%>
<%@ include file="public/bottom.jsp"%>



