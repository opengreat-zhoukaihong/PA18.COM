<%
	//GET PARAMETERS FROM THE LAST PAGE
	int Locate = -1;
	if ((sessionId == null) || (sessionId.equals("")))
	{
          throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
	}
	SessionUser sessionuser = SessionUser.getSessionUser();
	try
	{
		Locate = sessionuser.ProcessSession(Const.SESSAUTH,sessionId);
	}
	catch (Exception e)
	{
		Locate = -1;
	}

	if (Locate<0)
	{
       throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
	}
%>
