<%@ page language="java" import="java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<%  //for get login para and to bean

        if (!Init.isInit())
        {
            Init.initAll();//throw NormalExceptionHandler.Handle("0001",Const.SYS_NOT_INIT);
        }
   String WarnMsg = "";        
  
%>    