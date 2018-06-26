<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<jsp:useBean id="cb"  scope="request" class="beans.UserManagerBean"/>
<jsp:setProperty name="cb" property="*"/>
<%
    SessionUser mySession = sessionuser ;
    int sessionIdNum = 0;
    sessionIdNum = Locate ; //mySession.ProcessSession(Const.SESSAUTH,sessionId);

    String c_opr_cde="";
    String info=  (request.getParameter("C_OPR_CDE")).trim();

    int i= info.indexOf(",");
    if(i==-1){
        c_opr_cde = info;
    }else{
         c_opr_cde  = info.substring(0,i);
    }
    //query sub operator


      String operInfos[] = new String[4];
      operInfos[0] = "";
      operInfos[1] = "";
      operInfos[2] = c_opr_cde;
      operInfos[3] = mySession.getdepartId(sessionIdNum);
    // for(i=0; i< 4 ;i++) out.println(operInfos[i]+",");
      String [][] retValueArra;
      int rowCount =0 ;
      boolean hasSubOpr = false;
      boolean IsAccept = false;
     try
     {

        cb.setFormPara(ZConst.QUERY_OPTRLIST,operInfos);
        retValueArra = cb.getRetValueArra();
        rowCount =  retValueArra.length;
     }
     catch(NormalException e)
     {
       rowCount = 0;
      //out.println("Wrong error");
 	    //throw NormalExceptionHandler.Handle(e);
    }

     if(rowCount>0){
          out.println("因为该操作员有下属操作员，不得删除");
          hasSubOpr = true;
     }

    //prepare delete operator
    if(!hasSubOpr){
        operInfos[0] = mySession.getdepartId( sessionIdNum );
        operInfos[1] = mySession.getuserId( sessionIdNum );
        operInfos[2] =   c_opr_cde ;
        operInfos[3] = "0";
      
       try
      {

        cb.setFormPara(ZConst.DELETE_OPERATOR,operInfos);
      }
      catch(NormalException e)
     {
 	    if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
     }

     IsAccept = cb.getRetValueBool();
     String errText= new String("you failure");
   }
   if(IsAccept)
    {

%>
<form>
<font color="#0066CC"><span class="unnamed3">删除后台操作人员成功
&nbsp;&nbsp; <input type="button" name="button1" value="返回" onClick="javascript:history.back()">
</span></font>
</form>
<%
    }
    else
    {
%>
<form>
<font color="#0066CC"><span class="unnamed3">修改后台操作人员失败
&nbsp;&nbsp;<input type="button" name="button1" value="返回" onClick="javascript:history.back()">
</span></font>
</form>
<%
     }

%>
<%@ include file="public/bottom.jsp" %>
