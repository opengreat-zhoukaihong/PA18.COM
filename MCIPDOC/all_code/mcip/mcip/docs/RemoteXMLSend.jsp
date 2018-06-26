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
  <td>
  &nbsp;  &nbsp;
  </td>
  <td>



<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:useBean id="pb"  scope="page" class="beans.PolicyInfoBean"/> 
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>

     
<%
    String PlyNo = (String)request.getAttribute("C_PLY_NO");
    String PlyAppNo = "";
    String XmlData[][] = null;
    String XmlDoc = "";
    boolean IsPly = true;
    String RemoteData[][] = ob.getRemoteData();    
    String XmlDataBase[][] = new String[2][4];
    String XmlDataAdd[][] = null;
    String XmlContent = "";
    String XmlMethod = "";
    String XmlKey = "";
    String XmlUrl = Const.XMLURL_HR;
    int result = 0;
System.out.println("Enter remotexmlsned.jsp:");	                                            
    if(RemoteData == null || RemoteData.length < 2 || RemoteData[0].length < 4)
    {
        throw new NormalException("Parameter and value from remote request is error");
    }

    for(int i = 0; i < 2;i++)
       for(int j = 0 ; j < 4 ; j++)
       {
          XmlDataBase[i][j] = RemoteData[i][j];
//          out.println("XmlDataBase:"+XmlDataBase[i][j]+"\n");
       }   

    if(PlyNo == null || PlyNo.equals(""))//is plyapp
    {
            IsPly = false;
            PlyAppNo = (String)request.getAttribute("C_PLY_APP_NO"); 
            String Sdate = ServTool.getSysDateTime(); 
            String XmlDataStatus[][] = {{"T_SEND_TM","TRAN_STATUS","C_PLY_APP_NO"},{Sdate,"APPLICATION_SUBMITTED",PlyAppNo}};   
            XmlData = XmlDataStatus;
            XmlContent = Const.XMLCONTENT_STATUS_HR;
            XmlMethod = Const.XMLMETHOD_STATUS_HR;
            XmlKey = Const.XMLKEY_STATUS_HR;
            XmlDataBase[1][3] = Const.REMOTE_PLY_SEND;
    }    
    else//is ply
    {
            try
	    {
	        pb.setFieldValue(Const.GET_POLICYINFO,PlyNo);
	        XmlData = pb.getRetValueArra();
	        ob.setFormData(XmlData);        
	    }
	    catch(NormalException e)
	    {
	 	if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
	 	else if(NormalExceptionHandler.IsWarning(e))    
	 	    WarnMsg = e.getErrDesc(); 
	    }
            XmlContent = Const.XMLCONTENT_POLICY_HR;
            XmlDataBase[1][3] = Const.REMOTE_PRP_SEND;            
            XmlMethod = Const.XMLMETHOD_POLICY_HR;
            XmlKey = Const.XMLKEY_POLICY_HR;
            
            //Begin:is to get chinese name 
            
            Hashtable hashData = new Hashtable();
            hashData = ob.getHashData();      
%>
<%@ include file="PublicPly_ViewXmlsend.jsp" %>
<%
    String CarriageName = Objects.getValue(1,Objects.getHt(hashData,"C_CARRIAGE_CDE"),Const.CARRIAGE);
    String Chinese[][] = {{"C_CRGO_CLS_CNM","C_CRGO_CDE_CNM","C_PACK_CDE_CNM","C_INVC_AMT_CUR_CNM",
     "C_AMT_CUR_CNM","C_PRM_CUR_CNM","C_FRM_PRT_ARA_CNM","C_TO_PRT_ARA_CNM","C_PROVINCE_CNM","C_CITY_CNM",
     "C_INSRNC_CDE_CNM","C_CARRIAGE_CDE"},
     {CargoClsName,CargoTypeName,PackName,InvcCurName,AmtCurName,PrmCurName,FrmPrtName,ToPrtName,
     ProvinceName,CityName,InsrncMainName,CarriageName}}; 
     
    XmlDataAdd = Chinese; 
           //End get chinese name
}           
%>
<%          
//xml parse and send
//for temp2000-11-02
XmlDataAdd = null;
XmlData = new String[2][2];
String SdateTemp = ServTool.getSysDateTime(); 
XmlData[0][0] = "C_PLY_NO";
XmlData[0][1] = "T_UNDR_TM";
XmlData[1][0] = PlyNo;
XmlData[1][1] = SdateTemp;

//end for temp

     try
     {
        XmlDoc = XMLMake.Xml(XmlContent,XmlDataBase,XmlData,XmlDataAdd);
System.out.println("Begin write file:");	                        
/*                File file = new File("/data1/pa18/mcip/beans/xmlfile_ply");
                FileOutputStream fos = new FileOutputStream(file);
                byte[] xmlbyte = XmlDoc.getBytes("GB2312");
                fos.write(xmlbyte);
*/                
System.out.println("End write file:");	                                        
        
        RPCClient XmlClient= new RPCClient(XmlMethod,XmlDoc,XmlKey,XmlUrl);
        result = XmlClient.SendData();
     }    
     catch(Exception e)
     {
//         throw NormalExceptionHandler.Handle(e);
         result = - 1;
     }
System.out.println("result:"+result);	      
     if(result == 0)
     {
%>
<br>XML数据发送成功(XML Data send successful)。
    <% if(PlyNo!=null){
         out.println("保单号："+PlyNo);
      }
      if(PlyAppNo!=null){
         out.println("申请单号:"+PlyAppNo);
      }
      %>
<br>
<p>建议书确认成功。
<br>我们已就承保条件达成共识，我们将在最快的时间内将保险单送到您的手中。我们将在交付保险单的同时收取保险费，同时，保险单生效。

<%
     }
     else
     {
%>
<br>XML数据发送失败(XML Data send failure)。
<%
     }
%>

</td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
