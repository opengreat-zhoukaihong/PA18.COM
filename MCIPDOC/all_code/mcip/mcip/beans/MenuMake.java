////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For get dynamic menu
// Create date：2000/11/01
// Update date：2000/11/01
////////////////////////////////////////////////////////


package beans;

import java.util.*;
import java.lang.*;
import java.io.*;
import utility.*;
import constant.*;

public class MenuMake
{
    //for topmenu
 //  private static String topMenu = "document.write(\"<img src='images/topmenu.gif' width='540' height='19' usemap='#Map' border='0'><map name='Map'><area shape='rect' coords='32,3,74,15' href='*'><area shape='rect' coords='106,3,162,15' href='*'><area shape='rect' coords='180,3,237,15' href='*'><area shape='rect' coords='254,3,312,15' href='*'><area shape='rect' coords='330,2,387,16' href='*'><area shape='rect' coords='403,1,460,17' href='*'><area shape='rect' coords='478,3,539,14' href='Aboutus.jsp'></map>\")";

 private static String topMenu = "document.write(\"<img src='images/topmenu.gif' width='540' height='19' usemap='#Map' border='0'><map name='Map'><area shape='rect' coords='5,1,46,15' href='index.jsp?Logout=0'><area shape='rect' coords='62,1,126,15' href='*'><area shape='rect' coords='140,1,208,15' href='*'><area shape='rect' coords='220,1,290,15' href='*'><area shape='rect' coords='304,1,372,16' href='*'><area shape='rect' coords='386,1,452,15' href='*'><area shape='rect' coords='472,1,533,15' href='Aboutus.jsp'></map>\")";

    public static String[] MenuRef = {"MENU_MEMBER","MENU_CONSULTANT","MENU_INSURANCE","MENU_REPORT","MENU_INQUIRE","MENU_EVALUATE","FindPlyApp","FindPrp","OpenCover"};
    public static String UrlSucc[] = {"MemberSucc.jsp","Consultant.jsp","OperationSelect.jsp","Find_PlyApp.jsp","InquireSucc.jsp","OperationSelect1.jsp","Find_PlyApp.jsp","Find_PlyApp.jsp","OpenCoverList.jsp"};

    //for left menu
	//wuyan add 业务统计 Menu Link 2001.01.09
    private static String LeftMenuMember ="document.write(\"<img src='images/m-member.gif' width='190' height='54' alt='会员专区'><br><a href='Edit_UserInfo.jsp'><img src='images/m-change1.gif' width='101' height='17' alt='会员资料' border='0'></a><br><a href='Edit_Request.jsp'><img src='images/m-change2.gif' width='101' height='17' alt='修改密码' border='0'></a><br><a href='findUserPlyTotal.jsp'><img src='images/PlyTotal.gif' width='101' height='17' alt='业务统计' border='0'></a><br>";

    private static String LeftMenuMember2 ="<a href='OpenCoverList.jsp'><img src='images/m_open.gif' width='101' height='17' alt='预约保险' border='0'></a><br>";
    //modify in 2000-11-08

    private static String LeftMenuMember3 =
    "<a href='Find_PlyApp.jsp?MENU_REF=FindPly'><img src='images/baodpg-s.gif' width='101' height='17' alt='保单批改' border='0'></a><br>"
    +"<a href=javascript:js_openClientSmallPage('meeting/ClientLogin.jsp');><img src='images/zaixgt-s.gif' width='101' height='17' alt='在线沟通' border='0'></a><br>"

    +"<a href='payfor.jsp'><img src='images/m_pay.gif' width='101' height='17' alt='支付保费' border='0'></a><br><br><a href='index.jsp?Logout=0'><img src='images/hback.gif' width='80' height='50' alt='返回首页' border='0'></a>\")";

	private static String LeftMenuMember4 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Find_PlyApp.jsp?MENU_REF=FindPly'>保单批改</a><br>";

	private static String LeftMenuMember5= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Find_PlyApp.jsp?MENU_REF=FindEdrSmtApp'>批改申请单查询</a><br>";

	private static String LeftMenuMember6 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Find_PlyApp.jsp?MENU_REF=FindEdrSmt'>批单查询</a><br>";

    private static String LeftMenuInquire =
    "document.write(\"<img src='images/m-inquire.gif' width='190' height='54' alt='综合查询'><br><a href='Find_PlyApp.jsp?MENU_REF=FindPlyApp'><img src='images/m-tou.gif' width='101' height='17' alt='投保查询' border='0'></a><br><a href='Find_PlyApp.jsp?MENU_REF=FindPrp'><img src='images/m-jys.gif' width='101' height='17' alt='建议书查询' border='0'></a><br><a href='Find_PlyApp.jsp?MENU_REF=FindPly'><img src='images/m-bao.gif' width='101' height='17' alt='保单查询' border='0'></a><br><a href='Find_PlyApp.jsp?MENU_REF=FindEdrSmt'><img src='images/pidancx-s.gif' width='101' height='17' alt='批单查询' border='0'></a><br><a href='Find_PlyApp.jsp?MENU_REF=FindEdrSmtApp'><img src='images/pigaicx-s.gif' width='134' height='17' alt='批改申请单查询' border='0'></a><br><a href='Zfind_rpt.jsp'><img src='images/m-baoan.gif' width='134' height='17' alt='报案查询' border='0'></a><br><a href='Zfind_Claim.jsp'><img src='images/m-lipei.gif' width='134' height='17' alt='理赔查询' border='0'></a><br>&nbsp;&nbsp;&nbsp;&nbsp;<br><a href='index.jsp?Logout=0'><img src='images/hback.gif' width='80' height='50' alt='返回首页' border='0'></a>\")";

     private  static int LeftMenuMemCount = 8;

     public static String MainPage = "index.jsp";
     public static String MENU_REF = "MENU_REF";

    public MenuMake()
    {
    }

    public static String TopMenu(String sessionId)
    {
    	//sessionId is the decrypt
//	    String sessionId = Code.Decrypt(sessionid);
	    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
	    int Locate = -1;
	    String ParaSessionId = "";
	    String ParaRef = "";
	    String TopMenu = topMenu;
	    int index = 0;

/*       	    if(sessionId == null)
    	        sessionId = "";

    	    if(!(sessionId.equals("")))
    	    {
	   	    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
		    ParaSessionId =   "sessionid=" + Code.Encrypt(sessionId)+"&";
    	    }
  */
    	    for(int j=0;j< MenuRef.length - 4;j++)// MENU_EVALUATE IS NOT IN
    	    {
    	    	 ParaRef = "MenuMid.jsp?"+  ParaSessionId + "MENU_REF="+ MenuRef[j];
    	    	 String Temp[] = Servlets.DivideStr(TopMenu,"*");
    	         TopMenu = Temp[0] + ParaRef + Temp[1];
    	    }

    	    return TopMenu;
    }

    public static String LeftMenuMember(String sessionId)
    {
    	//sessionId is the decrypt
//	    String sessionId = Code.Decrypt(sessionid);
//is to be dispose opencover user
	    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
	    int Locate = -1;
	    String ClientType = "";
	    String ParaSessionId = "";
	    String LeftMenu = LeftMenuMember;
	    String LeftMenu2 = LeftMenuMember2;
	    String LeftMenu3 = LeftMenuMember3;
		String LeftMenu4 = LeftMenuMember4;
		String LeftMenu5 = LeftMenuMember5;
		String LeftMenu6 = LeftMenuMember6;
	    int index = 0;

       	    if(sessionId == null)
    	        sessionId = "";

    	    if(!(sessionId.equals("")))
    	    {
	   	    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
		    ClientType = sessionbuffer.getClientType(Locate);
//		    ParaSessionId =   "?sessionid=" + Code.Encrypt(sessionId);
    	    }
/*    	    if(!(ClientType.equals(Const.CUST_OC)))
    	    {
    	    	LeftMenu2 = "";
    	    }
*/
/*    	    for(int j=0;j < LeftMenuMemCount;j++)
    	    {
    	    	 String Temp[] = Servlets.DivideStr(LeftMenu,"*");
    	         LeftMenu = Temp[0] + ParaSessionId + Temp[1];
    	    }
*/
//    	    return (LeftMenu+LeftMenu2+LeftMenu4+LeftMenu5+LeftMenu6+LeftMenu3);
    	    return (LeftMenu+LeftMenu2+LeftMenu3);
    }

    public static String LeftMenuInquire(String sessionId)
    {
    	//sessionId is the decrypt
//	    String sessionId = Code.Decrypt(sessionid);
//is to be dispose opencover user
	    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
	    int Locate = -1;
	    String ClientType = "";
	    String ParaSessionId = "";
	    String LeftMenu = LeftMenuInquire;
	    int index = 0;

       	    if(sessionId == null)
    	        sessionId = "";

    	    if(!(sessionId.equals("")))
    	    {
	   	    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
		    ClientType = sessionbuffer.getClientType(Locate);
    	    }

/*    	    for(int j=0;j < LeftMenuMemCount;j++)
    	    {
    	    	 String Temp[] = Servlets.DivideStr(LeftMenu,"*");
    	         LeftMenu = Temp[0] + ParaSessionId + Temp[1];
    	    }
*/
    	    return (LeftMenu);
    }
}
