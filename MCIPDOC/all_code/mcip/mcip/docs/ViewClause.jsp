<html>
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL="STYLESHEET" TITLE="text" TYPE="text/css" href="table.css">
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<script language="javascript1.2" src="art_open.js"></script>
<%@ include file="public/Public.jsp" %>

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>

<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>


<%  //The folloing is to getData from database and display on page
    int i = 0;
    int j = 0;
    String Clause[][] = null; 
    String ClauseAdd[][] = null;     
    String FileContent = "";
    int ClauseLen = 0;
    int ClauseAddLen = 0;
    String TranType = ob.getTranType();
    String Transit[] = null;
    String[] FormPara = new String[3];
    String ClauseCode = "";
    String RemoteOperType = ob.getRemoteOperType();
    boolean IsRemote = false;
    String Other_Type = (String)request.getAttribute("OTHER_TYPE");
          
    if(RemoteOperType.equals(Const.REMOTE_PRP) || RemoteOperType.equals(Const.REMOTE_PLY))
    {
       IsRemote = true;
    }
    
    if(TranType.equals(Const.C_HOME_CDE))//home
    {
       Transit = ob.getHomeTransit();
       if(!(Transit[Const.N_RAILAGE_CDE].equals("") & Transit[Const.N_ROAD_CDE].equals("")
          & Transit[Const.N_WATER_CDE].equals("")))
       {
          ClauseCode = Const.CLAUSE01;
       }   
       
       if(!Transit[Const.N_H_AVIATION_CDE].equals(""))
       { 
          ClauseCode = ClauseCode + Const.CLAUSE02; 
       }
    }
    else//port
    {
       Transit = ob.getPortTransit(); 
       if(!Transit[Const.N_LANDWAY_CDE].equals(""))
       { 
          ClauseCode = ClauseCode + Const.CLAUSE01; 
       }
       if(!Transit[Const.N_SEA_CDE].equals(""))
       { 
          ClauseCode = ClauseCode + Const.CLAUSE02; 
       }
       if(!Transit[Const.N_AVIATION_CDE].equals(""))
       { 
          ClauseCode = ClauseCode + Const.CLAUSE03; 
       }

    }
    	FormPara[0] = TranType;
    	FormPara[1] = ClauseCode;    
    try
    {
    	FormPara[2] = "0";
        sb.setFormPara(Const.GET_CLAUSE,FormPara);
        Clause = sb.getRetValueArra();
	FormPara[2] = "1";
 //       sb.setFieldValue(Const.GET_CLAUSE,FormPara);
//        ClauseAdd = sb.getRetValueArra();

    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }
    
    ClauseLen = Servlets.getLen(Clause);   
    String ClauseName[]  = new String[1];
    String ClauseContent[]  = new String[1] ;
    String ClauseMainName = "";
    String ClauseMainContent = "";

    ClauseAddLen = Servlets.getLen(ClauseAdd);   
    String ClauseAddName[]  = new String[1] ;
    String ClauseAddContent[]  = new String[1] ;

    int c_claus_cnm = Objects.getColNum("c_claus_cnm",Clause);
    int c_claus_ccnt = Objects.getColNum("c_claus_path",Clause);
  if(ClauseLen > 1)   
  {
      ClauseName  = new String[ClauseLen - 1] ;
      ClauseContent  = new String[ClauseLen - 1] ;

      for(i = 1; i < ClauseLen; i++)
      {
          ClauseName[j] = Clause[i][c_claus_cnm];
          String FilePath = Clause[i][c_claus_ccnt];

	  try
	  {
	     FileContent = Servlets.GetFileContent(FilePath);
	  }
          catch(NormalException e)
	  {
	 	if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
	 	else if(NormalExceptionHandler.IsWarning(e))    
	 	    WarnMsg = e.getErrDesc(); 
	 	    
	  }
	  
	  ClauseContent[j] = FileContent;
	  if(!ClauseMainName.equals(""))
	      ClauseMainName = ClauseMainName + ",";
	  ClauseMainName = ClauseMainName + ClauseName[j];
	  ClauseMainContent = ClauseMainContent + ClauseContent[j] + "\n\n";
	  j++;
     }	  
  }
  if(ClauseAddLen > 1)   
  {
      ClauseAddName  = new String[ClauseAddLen - 1] ;
      ClauseAddContent  = new String[ClauseAddLen - 1] ;
      c_claus_cnm = Objects.getColNum("c_claus_cnm",ClauseAdd);
      c_claus_ccnt = Objects.getColNum("c_claus_path",ClauseAdd);

      j = 0;
      for(i = 1; i < ClauseAddLen; i++)
      {
          ClauseAddName[j] = ClauseAdd[i][c_claus_cnm];
          ClauseAddContent[j] = ClauseAdd[i][c_claus_ccnt];
	  j++;
     }	  
  }  
  
  ClauseMainName = "";//change in 10.19 according to dingwenyu
%>
   
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
<%@ include file="public/PublicPlyLeft.html" %>

    <td width="613" height="288" valign="top">
<FORM name="viewClause" METHOD="POST" ACTION="PolicyList.jsp">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td colspan="2" align="center" class="title" height="10">&nbsp;</td>
        </tr>
        <tr> 
          <td colspan="2" > <img src="images/con_art.gif" width="150" height="31" alt="保险条款"> </td>
        </tr>
        <!--tr> 
          <td width="79%" height="10">&nbsp;</td>
          <td width="21%">&nbsp;</td>
        </tr-->
        <tr> 
            <td width="79%" align="left"> 
        <textarea name="T9" cols="75" rows="13" onkeydown="return false;">
        <%=ClauseMainContent%>
        </textarea>
            </td>
          <td width="21%" valign="top"> 

<%
  if(ClauseAddLen > 1)   
  {

%>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr align="center"> 
                <td>附加险条款列表 </td>
              </tr>

<% 
     for(i = 0; i < ClauseAddName.length;i++)
     {
       String ClauseLink = "ViewClauseAdd.jsp?ClausePath=" + Code.Encrypt(ClauseAddContent[i]);
 %>
              <tr align="center"><td>&nbsp;
 <a href="<%=ClauseLink%>" target="blank" ><%=ClauseAddName[i]%></a>   
 		</td>  </tr>
 <%
     }
%>
            </table>

<%     
  }   
 %>

<%
//for test clause
String ClauseLinkTest = "";//"ViewClauseAdd.jsp?ClausePath=" + Code.Encrypt("/data1/pa18/nul/mcip/public_html/jj.txt");
if(!(ClauseLinkTest.equals("")))
{
%>
<br> <a href="<%=ClauseLinkTest%>" target="blank" >条款测试</a>  
<%
}
%>
          </td>
        </tr>
        <tr>
          <td width="79%" height="8">&nbsp;</td>
          <td width="21%">&nbsp;</td>
        </tr>
        <tr> 
          <td colspan="2">
			 		请点击选择你要查看<B>附加险</B>条款的项目：<br>
					 <table width="95%" border="0" cellpadding="2">
						<tr> 
						  <td bgcolor="#6633CC" colspan="5"></td>
						</tr>
						<tr> 
						  <td width="17%"> <font color="#EFB281">■</font> <a href="clause/rdr18.html" onClick="return js_openpage(this.href);"> 
							 罢工险条款 </a> </td>
						  <td width="18%"> <font color="#EFB281">■</font> <a href="clause/rdr20.html" onClick="return js_openpage(this.href);"> 
							 战争险条款 </a> </td>
						  <td width="23%"> <font color="#EFB281">■</font> <a href="clause/rdr24.html" onClick="return js_openclause(this.href);"> 
							 碰损、破碎险条款 </a> </td>
						  <td width="19%"><font color="#EFB281">■</font> <a href="clause/rdr31.html" onClick="return js_openclause(this.href);"> 
							 串味险条款</a></td>
						  <td width="23%"><font color="#EFB281">■</font> <a href="clause/rdr32.html" onClick="return js_openclause(this.href);"> 
							 受潮、受热险条款</a></td>
						</tr>
						<tr> 
						  <td width="17%"> <font color="#EFB281">■</font> <a href="clause/rdr25.html" onClick="return js_openclause(this.href);"> 
							 渗漏险条款 </a> </td>
						  <td width="18%"> <font color="#EFB281">■</font> <a href="clause/rdr33.html" onClick="return js_openclause(this.href);"> 
							 钩损险条款 </a> </td>
						  <td width="23%"> <font color="#EFB281">■</font> <a href="clause/rdr29.html" onClick="return js_openclause(this.href);"> 
							 淡水、雨淋险条款 </a> </td>
						  <td width="19%"><font color="#EFB281">■</font> <a href="clause/rdr34.html" onClick="return js_openclause(this.href);"> 
							 锈损险条款 </a> </td>
						  <td width="23%"><font color="#EFB281">■</font> <a href="clause/rdr28.html" onClick="return js_openclause(this.href);"> 
							 包装破裂险条款 </a> </td>
						</tr>
						<tr> 
						  <td> <a href="clause/rdr31.html" onClick="return js_openclause(this.href);"> 
							 </a> <font color="#EFB281">■</font> <a href="clause/rdr27.html" onClick="return js_openclause(this.href);"> 
							 短量险条款</a></td>
						  <td colspan="2"> <a href="clause/rdr32.html" onClick="return js_openclause(this.href);"> 
							 </a><font color="#EFB281">■</font> <a href="clause/rdr30.html" onClick="return js_openclause(this.href);"> 
							 混杂、沾污险条款</a> </td>
						  <td colspan="2"><font color="#EFB281">■</font> <a href="clause/rdr23.html" onClick="return js_openclause(this.href);"> 
							 偷窃、提货不着险条款 </a></td>
						</tr>
					 </table><br>
		请点击选择你要查看<B>英文协会货物运输</B>条款的项目：<br>
		<table width="95%" border="0" cellpadding="0">
			  <tr><td bgcolor="#6633CC" colspan="3"></td></tr>
			  <tr>
				<td height="30" align="left">
					<font color="#EFB281">■</font>
				   <a href="ZView_Clause.jsp?path=ICC-A.txt" onclick="return js_openpage(this.href);">INSTITUTE CARGO CLAUSES (A)</a>
				</td>
				<td height="30" align="left">
					<font color="#EFB281">■</font>
				   <a href="ZView_Clause.jsp?path=ICC-B.txt" onclick="return js_openpage(this.href);">INSTITUTE CARGO CLAUSES (B)</a>
				</td>
				<td height="30" align="left">
					<font color="#EFB281">■</font>
				   <a href="ZView_Clause.jsp?path=ICC-C.txt" onclick="return js_openpage(this.href);">INSTITUTE CARGO CLAUSES (C)</a>
				</td>
			  </tr>
		 </table>   
			 </td>
        </tr>
        <tr> 
          <td colspan="2"><font color="#3366FF">注:本人已仔细阅读该条款，对条款内容特别是责任免除部分的内容已经了解，同意按本条款投保。</font><font color="#6666FF"> 
            </font></td>
        </tr>
        <tr>
          <td width="79%" height="8">&nbsp;</td>
          <td width="21%">&nbsp;</td>
        </tr>
        <tr> 
          <td width="79%" height="8" align="center">
  
<%
  if(IsRemote || Other_Type.equals("PLYNEW"))
  {
       ob.setStep(Const.STEP_BEG);          
%>
  <input type="submit" value="同  意" name="B2" onclick="ChgAction(viewClause,'InputPolicy.jsp');return true;"> 
<%  

  }
  else /** add by kangjin for xml policy input 2001-09-17*/
  	if (Other_Type.equals("PLYUPLD")){%>
  <input type="submit" value="同  意" name="B2" onclick="ChgAction(viewClause,'Upload.jsp');return true;"> 
	<%}
	else{
%>
  <input type="submit" value="同  意" name="B1"> 
<%  
  }
%>
  <input type="button" value="前一页" name="B44" onclick='javascript:history.back();'>    
          <td width="21%">&nbsp;</td>
        </tr>
        <tr> 
          <td width="79%" height="8">&nbsp;</td>
          <td width="21%">&nbsp;</td>
        </tr>
      </table>

    <%String sessionid = Code.Encrypt(sessionId);%>
    <input type="hidden" name="sessionid" value="<%=sessionid%>">
    <input type="hidden" name="<%=Const.C_AGENCY_NO%>" value="<%=Const.CLAUSE%>">    
    <input type="hidden" name="C_PLY_NO" value="">
</form>
    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
