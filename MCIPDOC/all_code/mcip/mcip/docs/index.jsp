<HTML>
<HEAD>
<TITLE>平安货运保险</TITLE>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
<script language="JavaScript"
src="http://www.pa18.com/advert/docc/cargobanner.js" ></script>


<META content="MSHTML 5.00.3103.1000" name=GENERATOR>
<style type="text/css">
<!--
.t9 {  font-size: 9pt; line-height: 16pt}
.form {BORDER-BOTTOM: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; FONT-SIZE: 9pt
}
.ts {  font-size: 6px}
.border {  border-color: black #336699 black black; border-style: solid; border-top-width: 0px; border-right-width: 1px; border-bottom-width: 0px; border-left-width: 0px}
.border01 {  border: 1px #336699 solid}
-->
</style>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0>
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<% 
        if (!Init.isInit())
        {
            Init.initAll();
        }
    //del old user info
	String kyType = " ";
	String  BtnStr = "登录";
	String  FormStr = " <FORM METHOD=\"POST\" ACTION=\"ProcessLogin.jsp\"  onSubMit=\"return (ValidNull(USER,false) && ValidNull(PSWD,false));\" >";

	String OperType = request.getParameter("Logout");
    System.out.println("you are in index.jsp:"+OperType);
    HttpSession https = request.getSession(true);
    String sessionId = https.getId();
    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
    int Locate = 0;
    
    if (OperType == null)
    {
	OperType="1";
    }
    if(OperType.equals("0"))
    {

	    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
	    if (Locate < 0)
	    {
	    //        throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);            
	       OperType="1";
	    }
	    
    }	    

    if(OperType.equals("0"))
    {

	   String ClientType = sessionbuffer.getClientType(Locate);
	   if(ClientType.equals(Const.CUST_AG))
           {
		     kyType =  "ag"; 
           }
		   else
			{
				if (ClientType.equals(Const.CUST_CM))
				{
					 kyType = "cm";
					 // 直接用户
				}
				else
				{
					 kyType ="oc"; //"预约用户";
				}
			}
		BtnStr = "退出";
		FormStr = " <FORM METHOD=\"POST\" ACTION=\"index.jsp?Logout=1\">";
    }
    else
	{
	    sessionbuffer.ProcessSession(Const.SESSDEL,sessionId);
	    BtnStr = "登录";
		FormStr = " <FORM METHOD=\"POST\" ACTION=\"ProcessLogin.jsp\"  onSubMit=\"return (ValidNull(USER,false) && ValidNull(PSWD,false));\" >";
		//		FormStr = " <FORM METHOD=\"POST\" ACTION=\"https://cargo.pa18.com/ProcessLogin.jsp\"  onSubMit=\"return (ValidNull(USER,false) && ValidNull(PSWD,false));\" >";
	}
%>    
<TABLE border=0 cellPadding=0 cellSpacing=0 height=64 width=778>
  <TBODY>
  <TR>
    <TD width=167 valign="top"><IMG height=69 src="../images/topl.gif" width=240></TD>
    <TD width=611>
      <TABLE border=0 cellPadding=0 cellSpacing=0 height=64 width=540>
        <TBODY>
        <TR>
          <TD height=46 valign="top"><img src="../images/topright1.gif" width="538" height="50"></TD>
        </TR>
        <TR>
		 <td>
			<script language="JavaScript">
				<%out.println(MenuMake.TopMenu(""));%>
			</script>
		</td>
          <!--TD>
            <!SCRIPT language=JavaScript>document.write("<img src='../images/topmenu.gif' width='540' height='19' usemap='#Map' border='0'><map name='Map'><area shape='rect' coords='5,1,46,15' href='index.jsp'><area shape='rect' coords='62,1,126,15' href='MenuMid.jsp?MENU_REF=MENU_MEMBER'><area shape='rect' coords='140,1,208,15' href='MenuMid.jsp?MENU_REF=MENU_CONSULTANT'><area shape='rect' coords='220,1,290,15' href='MenuMid.jsp?MENU_REF=MENU_INSURANCE'><area shape='rect' coords='304,1,372,16' href='MenuMid.jsp?MENU_REF=MENU_REPORT'><area shape='rect' coords='386,1,452,15' href='MenuMid.jsp?MENU_REF=MENU_INQUIRE'><area shape='rect' coords='472,1,533,15' href='help.jsp'></map>")
</SCRIPT>
          </TD-->
		  </TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
<TABLE border=0 cellPadding=0 cellSpacing=0 width=778>
  <TBODY> 
  <TR> 
		  <TD rowspan="2" valign="top" class="border" width="160"> 
<!--FORM METHOD="POST" ACTION="index.jsp?Logout=1"-->
<%=FormStr%>
	  <table width="160" border="0" cellpadding="0" cellspacing="0" align="center" class="t9">
          <tr> 
            <td height="30" width="160"><img src="../images/yonghdl.gif" width="67" height="16"></td>
          </tr>
          <tr> 
            <td bgcolor="#e4e4e4" height="20" width="160">用户名： 
              <input  maxLength="16" name="USER"  size="8" class="form" style="height:15">
            </td>
          </tr>
          <tr> 
            <td bgcolor="#e4e4e4" height="20" width="160">密　码： 
              <input maxLength=16 name=PSWD size=8 type=password class="form" style="height:15">
              	<input type="submit" name="Submit" value="<%=BtnStr%>" class="form">
				 </td>
          </tr>
          <tr> 
            <td class="t9" height="35" valign="middle" width="156"><font color="#FFCC00" class="ts">●</font> 
              <a href="register.jsp"  target=_blank>新用户注册</a> 
			<font color="#FFCC00" class="ts">●</font> 
			<a href="password.jsp"  target=_blank>忘记密码</a>
			</td>
          </tr>
        </table>
		</form>
        <br>
        <table width="138" border="0" cellpadding="0" cellspacing="0" align="center" class="border01">
        <tr>
            <td height="15" valign="middle" bgcolor="#FFCC00"> 
              <div align="center" class="t9"><a href="guide_list.jsp">投 保 指 南</a></div>
          </td>
        </tr>
      </table>
      <br>
	  <script language="javascript1.2" src="art_open.js"></script>
      <table width="138" border="0" cellpadding="0" cellspacing="0" align="center" class="border01">
        <tr> 
          <td> 
            <div align="center"><img src="../images/baoxtk.gif" width="134" height="16"><br>
              <table width="95%" border="0" cellpadding="0" cellspacing="0" class="t9">
                <tr> 
                  <td width="10%" valign="top"><font color="#FFCC00" class="ts">●</font></td>
                    <td width="90%" valign="top">
					<a href="ZView_Clause.jsp?path=sea_cargo.txt" onclick="return js_openpage(this.href);">
						海洋运输
					</a>
					</td>
                </tr>
                <tr> 
                  <td width="10%" valign="top"><font color="#FFCC00" class="ts">●</font></td>
                    <td width="90%" valign="top">
					 <a href="ZView_Clause.jsp?path=air_cargo.txt" onclick="return js_openpage(this.href);">
						航空运输
					</a>
					</td>
                </tr>
                <tr> 
                  <td width="10%" valign="top"><font color="#FFCC00" class="ts">●</font></td>
                    <td width="90%" valign="top">
					 <a href="ZView_Clause.jsp?path=dom_water_land_cargo.txt" onclick="return js_openpage(this.href);">
						国内水路、陆路运输
					</a>
					</td>
                </tr>
                <tr> 
                  <td width="10%" valign="top">&nbsp;</td>
                  <td width="90%" valign="top" align="right"> 
						<a href="Clause_List.jsp">更多...</a>
				</td>
                </tr>
              </table>
            </div>
          </td>
        </tr>
        
      </table>



        <br>
        <table border="0" cellpadding="0" cellspacing="0" align="center">
          <tr> 
            <td><iframe name="01" marginheight=0 marginwidth=0 border=0 topmargin=0 leftmargin=0 frameborder=0 scrolling="no" width=120 height=60 src="http://www.pa18.com/advert/docc/but_cargo_01.htm"> 
              </iframe></td>
          </tr>
          <tr> 
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><iframe name="01" marginheight=0 marginwidth=0 border=0 topmargin=0 leftmargin=0 frameborder=0 scrolling="no" width=120 height=60 src="http://www.pa18.com/advert/docc/but_cargo_02.htm"> 
              </iframe></td>
          </tr>
        </table>
        
      </TD>
    </form>
    <TD vAlign=middle  align="center" height="80" width="525" >
    <script language="JavaScript">
		  <!--
           requestbanner(l_banner);
         // -->
		 </script></TD>
    <TD vAlign=middle align="center" height="80" width="67" >
     <a href="http://www.paic.com.cn/default2.asp"><img src="../images/palogo-01.gif" width="60" height="60"></a></TD>
  </TR>





  <TR> 
    <TD vAlign=top colspan="2" height="341"> 
      <table width="95%" border="0" cellpadding="0" cellspacing="0" align="center">
        <tr> 
          <td height="45" colspan="3"><img src="../images/wangltb.gif" width="315" height="30"></td>
        </tr>
        <tr valign="top"> 
          <td width="34%" bgcolor="#F0F7FB" height="97">
		  <%
			if (kyType.equals("cm") || kyType.equals("oc"))
			{
		  %>
			  <a href="MenuMid.jsp?MENU_REF=MENU_INSURANCE"><img src="../images/zhijyh.gif" width="87" height="18"  border="0"></a>
		  <%
			  }
				else
				{
			%>
			  <img src="../images/zhijyh.gif" width="87" height="18"  border="0">
			<%}%>
			<br>
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><span class="t9">如果您打算为您公司的业务投保货运险,我们将在这里为您提供最便捷的服务</span>。</td>
              </tr>
            </table>
          
            
          </td>
          <td width="33%" bgcolor="#F0F7FB" height="97">
		  <%
			if (kyType.equals("ag"))
			{
		  %>
			  <a href="MenuMid.jsp?MENU_REF=MENU_INSURANCE"><img src="../images/wosdlr.gif" width="87" height="18" border="0"></a>
		  <%
			  }
				else
				{
			%>
			  <img src="../images/wosdlr.gif" width="87" height="18" border="0">
			<%}%>
			 <br>
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td><span class="t9">如果您是我公司的代理人，并已经与我们签署了代理协议，那么您可以在网上以最快的速度，为客户签发保单。</span></td>
              </tr>
            </table></td>
          <td width="33%" bgcolor="#F0F7FB" height="97">
		  <%
			if (kyType.equals("oc"))
			{
		  %>
			  <a href="OpenCoverList.jsp"><img src="../images/yuykh.gif" width="113" height="18" border="0"></a>
		  <%
			  }
				else
				{
			%>
			 <img src="../images/yuykh.gif" width="113" height="18" border="0">
			<%}%>
			  <br>
            <table width="80%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td><span class="t9">如果您已经与我公司签署了预约保险协议，那么只要在此填写货物起运通知单，您的货物将自动进入我们的承保范围。</span></td>
              </tr>
            </table><br>
          </td>
        </tr>
        <tr> 
          <td colspan="3" height="40"><img src="../images/toublc.gif" width="330" height="28"></td>
        </tr>
        <tr> 
          <td colspan="3"><img src="../images/liucheng.gif" width="592" height="43"></td>
        </tr>
        <tr> 
          <td colspan="3" height="50"><img src="../images/huiyzq.gif" width="313" height="27"></td>
        </tr>
        <tr> 
          <td colspan="3"> 
            <table width="564" border="0" cellpadding="0" cellspacing="0" class="t9" align="center">
              <tr> 
                <td height="67" background="../images/fuwuzq.gif" width="563" valign="bottom"><br>
                  <br>
                  　 <a href="MenuMid.jsp?MENU_REF=FindPrp">查询投保结果</a><img src="../images/new.gif" width="28" height="11">　　 
                   <a href='MenuMid.jsp?MENU_REF=MENU_INQUIRE'>综合查询</a>　　　　　<a href="MenuMid.jsp?MENU_REF=FindPlyApp">修改投保单</a>　　　　  &nbsp;<a href="MenuMid.jsp?MENU_REF=MENU_EVALUATE">保费测算</a>　　　　　<a href='MenuMid.jsp?MENU_REF=MENU_REPORT'>网上报案</a></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <br>
    </TD>
  </TR>
  <TR> 
  </TR>
  <TR> 
    <TD colspan="3" valign="top" class="border"><img src="../images/bline.gif" width="770" height="1"></TD>
  </TR>
  <TR> 
  </TR>
  <TR> 
  </TR>
  </TBODY> 
</TABLE>
<%@ include file="public/PublicBottom.html" %>
</BODY></HTML>
