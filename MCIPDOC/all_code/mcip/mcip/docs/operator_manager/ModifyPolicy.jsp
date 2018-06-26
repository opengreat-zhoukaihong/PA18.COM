<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>保单修改</title>
<link rel="stylesheet" href="TableStyle.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
<div align="right">
<address style="border-bottom: 1px dotted">
  平安保险...
</address>
</div>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="set.js"></SCRIPT>
<%@ include file="Public.jsp" %>

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>
<%@ include file="PublicPly.jsp" %>   
<%  //for get  para and to bean

    String PlyNo =  request.getParameter("C_PLY_NO");
    String para[]={PlyNo};
    try
    {
        pb.setFormPara(0,para);
    }
    catch(NormalException e)
    {
 	    if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
      // following is new
      String ClientName = sessionbuffer.getClientName(Locate); //投保人
      String ClientType = sessionbuffer.getClientType(Locate); //登录客户类型
      String ClientId =   sessionbuffer.getClientId(Locate);
      String C_INSRNT_CDE = ""; //被保人遍码
      String C_INSRNT_CDE ="" ; //被保人名
      String C_PROVINCE_CNM=""; //送达省名
      String C_CITY = ""; //送达市
      String C_PLACE = "" ; //送达祥细地址
      String C_CONTACT_NAME= "" ; //联系人
      String C_CONTACT_PHONE="" ;//联系电话
      String C_CONTACT_FAX=""; //联系传真
      String C_CONTACT_EMAIL="";//E_MAIL
      String C_CRGO_DESC="" ; //品名描述
      String C_PACK_CNM=""; //包装描述
      String C_AMOUNT=""; //数量
      String C_MARK="";//唛头
      String N_INVC_AMT="";//发票金额
      String C_INVC_NO=""; //发票号码
      String C_RECEIPT_NO="";//提单号
      String C_FRM_PRT_ARA="";//起运国
      String C_FROM_PRT="";//起运港
      String C_PASS_PRT="";//途经港
      String C_TO_PRT_ARA="";//到达国
      String C_TO_PRT="";//到达港
      String C_SAIL_NO="";//航次
      String C_CONTAINER="" ;// 集装箱方氏
      String birth_year="";  //开航年
      String birth_month=""; //开航月
      String birth_day=""; //开航年日

     //for get
      PlyNo = request.getParameter("C_PLY_NO");
      String HOME = Const.C_HOME_CDE;//B03
      String EXPORT = Const.C_EXPORT_CDE;//B02
      String IMPORT = Const.C_IMPORT_CDE; //B01
      String TranType = "B02";

      int i=0 ;
  %>



<p align="center">　<font face="宋体" size="4">保单批改</font></p>
<form name="nf" method="POST" action="ModifyBaoDan.jsp" onsubmit="return(
ValidDateNew(tempdate,birth_year) &&
ValidDateBegin(tempdate,"2000-10-21",birth_year,C_REMARK) &&
ValidNull(C_INSRNT_NME,false) &&
ValidNull(C_PLACE,false) &&
ValidNull(C_CONTACT_NAME,false) &&
ValidNull(C_CONTACT_PHONE,false) &&
ValidNull(C_CONTACT_EMAIL,false) &&
ValidNull(C_PROVINCE,false) &&
ValidNull(C_CITY,false) &&
ValidNull(C_CRGO_DESC,false) &&
ValidNull(C_PACK_CNM,false) &&
ValidNull(C_AMOUNT,false) &&
ValidAmt(C_AMOUNT) &&
ValidNull(C_INVC_AMT) &&
ValidAmt(C_INVC_AMT)&&
ValidNull(C_SAIL_NO,false) &&
ValidNull(C_FRM_PRT_ARA,false) &&
ValidNull(C_TO_PRT_ARA,false) &&
ValidNull(C_FROM_PRT,false) &&
ValidNull(C_TO_PRT,false) &&
ValidNull(birth_year,false) &&
ValidNull(birth_month,false) &&
ValidNull(birth_day,false) &&
ValidTel(C_CONTACT_PHONE) &&
ValidTel(C_CONTACT_FAX) &&
ValidEmail(C_CONTACT_EMAIL) &&
ValidNoOrReal(C_INVC_NO,C_RECEIPT_NO)
);">
  <div align="left">
    <p align="right"><font
  color="#ED7CC9"><small>打</small> * <small>的项目必须填写</small></font> </p>

      投保人： 中国人民银行出口科<%=ClientName%> &nbsp;&nbsp;&nbsp;保单号：<%=C_PLY_NO%> ,00001799901<br>
  </div>
  <div>
  <center>
      <table width="95%" border="2">
        <tr  align="center" width=100%>
          <td  align="center" width=50%>原保单</td>
          <td width=50%>批改保单</td>
        </tr>
        <tr>
          <td align="left" width=50%>被保险人：中国人民</td>
          <td width=50%>被保险人：
            <input type="text"  name="C_INSRNT_NME" maxlength="100" size="20" value="企业名称">
            <input type=hidden name="C_INSRNT_CDE" value="<%=C_INSRNT_CDE%>">
            * </td>
        </tr>
        <tr>
          <td> <font face="宋体" size="2" color="#F19CD1"><em>送单时间：从发出承保通知开始一个工作日内。</em></font>
            <br>
            送单地点: <br>
            <%=C_PROVINCE_CNM%>海南 市/县/区:<%=C_CITY%> 海口 <br>
            详细地址:<%=C_PLACE%>海南省海口市中山一路28号 <br>
            联系人: <%=C_CONTACT_NAME%>刘欢 <br>
            联系电话:<%=C_CONTACT_PHONE%> 086-0768-5501918 <br>
            传真: <%=C_CONTACT_FAX%>  86-0768-5501919 <br>
            E-mail:<%=C_CONTACT_EMAIL%> pa18@pa18.com </td>
          <td> <font face="宋体" size="2" color="#F19CD1"><em>送单时间：从发出承保通知开始一个工作日内。</em></font>
            <br>
            送单地点:  <%=C_PROVINCE_CNM%>海南  <%=C_CITY%> 海口

            <br>
            详细地址:
            <input type="text" name="C_PLACE" size="50" maxlength="100" value="<%=C_PLACE%>">
            * <br>
            联系人:
            <input type="text"  name="C_CONTACT_NAME" size="14"  maxlength="20" value="rewy213" value="<%=C_CONTACT_NAME%>">
            * <br>
            联系电话:
            <input type="text"  name="C_CONTACT_PHONE" size="15"  maxlength="20"  value="<%=C_CONTACT_PHONE%>">
            * <br>
            传真:
            <input type="text"   name="C_CONTACT_FAX" size="14" maxlength="20" value="<%=C_CONTACT_FAX%>">
            &nbsp;&nbsp;&nbsp;&nbsp; <br>
            E-mail:
            <input type="text"  name="C_CONTACT_EMAIL" size="15" maxlength="50" value="<%=C_CONTACT_FAX%>">
            * </td>
        </tr>
        <tr>
          <td  align="center">
            <div align="left"> 品名描述:<%=C_CRGO_DESC%>该小麦为生产面包专用</div>
          </td>
          <td > 品名描述:<br>
            <textarea rows="2"  name="C_CRGO_DESC" cols="45"><%=C_CRGO_DESC%> 312312</textarea>
            * </td>
        </tr>
        <tr>
          <td  align="center">
            <div align="left"> 包装描述: <%=C_PACK_CNM%>必须密封，防潮 </div>
          </td>
          <td > 包装描述:
            <input type="text"  name="C_PACK_CNM" size="50" maxlength="60" value="<%=C_PACK_CNM%>">
            * </td>
        </tr>
        <tr>
          <td  align="center">
            <div align="left">
              <p>数量：<%=C_AMOUNT%>200</p>
              <p>唛头:<%=C_MARK%>HKG_01_MSG</p>
            </div>
          </td>
          <td >
            <p>数量：
              <input type="text"  name="C_AMOUNT" size="25" maxlength="200" value="<=C_AMOUNT%>">
              * </p>
            <p>唛头 :
              <input type="text" name="C_MARK" size="30" maxlength="200" vale="<=C_MARK%>">
              * </p>
          </td>
        </tr>

        <tr>
          <td  align="center">
            <p align="left">发票金额:<%=N_INVC_AMT%>6000 (人民币）</p>
            <p align="left">发票号码:<%=C_INVC_NO%> 185001</p>
            <p align="left">提单/运单号码:<%=C_RECEIPT_NO%>09999</p>
          </td>
          <td >
            <p align="left">发票金额:
              <input type="text" name="N_INVC_AMT" maxlength="20" size="12" onBlur="setPrm(N_INVC_AMT,N_AMT,TRAN_TYPE_TEMP);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM);return true;" value="<%=C_INVC_AMT%>">
              (人民币）</p>
            <p align="left">发票号码:
              <input type="text" name="C_INVC_NO" maxlength="60" size="14" value="<%=C_INVC_NO%>">
            </p>
            <p align="left">提单/运单号码:
              <input type="text" name="C_RECEIPT_NO" maxlength="50" size="12" value="<%=C_RECEIPT_NO%>">
            </p>
          </td>
        </tr>
        <tr>
          <td  align="center">
            <p align="left">起运港国家：<%=C_FRM_PRT_ARA%>中国</p>
            <p align="left">起运港名称：<%=C_FRM_PRT%>深圳</p>
          </td>
          <td >
            <p>起运港国家：
              <select name="C_FRM_PRT_ARA" size="1" >
                <option value=1001>China(中国) </option>
                <% if(TranType.equals(EXPORT) || TranType.equals(HOME))
                {
                 %>
                 <option value=<%=Const.CHINA_CDE%>>(China)<%=Const.CHINA_CNM%> </option>
                <%}
               else
              {
		             if(AreaLen > 1)
		            {
		              for(i = 1 ;i< AreaLen;i++ )
		              {
		                 String AraCdeTemp = Area[i][c_ara_cde];
		                 int PointTemp = AraCdeTemp.length() - 2;
		                 String CdeLastTwo = AraCdeTemp.substring(PointTemp);
		                 if(!(CdeLastTwo.equals("00")))
		                {//warning it's well
                    %>
	                   <option  <%if(C_FRM_PRT_ARA.equals(Area[i][c_ara_cde])){%>selected<%}%>  value=<%=Area[i][c_ara_cde]%>>(<%=Area[i][c_ara_enm]%>)<%=Area[i][c_ara_cnm]%></option>
		              <%
		                }
		               }
		              }
                 }
		   %>

              </select>
            </p>
            <p>起运港名称：
              <input type="text" name="C_FROM_PRT" maxlength="60" size="25" value="harbin" value="<%=C_FRM_PRT%>">
            </p>
          </td>
        </tr>
        <tr>
          <td  align="center">
            <div align="left">途径港名称：<%=C_PASS_PRT%>上海</div>
          </td>
          <td >途径港名称： <input type="text" name="C_PASS_PRT"  maxlength="40" size="22" value="<%=C_PASS_PRT%>"></td>
        </tr>
        <tr>
          <td  align="center">
            <div align="left">
              <p>目的港国家：<%=C_TO_PRT_ARA%>中国</p>
              <p>目的港名称：<%=C_TO_PRT%>大连 </p>
            </div>
          </td>
          <td>
            <div align="left">
              <p>目的港国家：
                <select name="C_TO_PRT_ARA" size="1" >
                  <option value= 1001>(China)中国 </option>
                   <%
	                    if(TranType.equals(IMPORT) || TranType.equals(HOME))
                      {
                      %>
                      <option value= <%=Const.CHINA_CDE%>>(China)<%=Const.CHINA_CNM%> </option>
                      <%
                       }else{
		                     if(AreaLen > 1)
		                     {

		                       for(i = 1 ;i< AreaLen;i++ )
		                      {
		                          String AraCdeTemp1 = Area[i][c_ara_cde];
		                          int PointTemp = AraCdeTemp1.length() - 2;
		                          String CdeLastTwo = AraCdeTemp1.substring(PointTemp);
		                          if(!(CdeLastTwo.equals("00")))
		                         {//waring
                             		   %>
	                            <option  <%if(C_TO_PRT_ARA.equals(Area[i][c_ara_cde])){%>selected<%}%>  value=<%=Area[i][c_ara_cde]%>>(<%=Area[i][c_ara_enm]%>)<%=Area[i][c_ara_cnm]%></option>
		                         <%
		                         }
		                        }
		                       }
                          }
		                   %>
                </select>
              </p>
              <p>目的港名称： 
                <input type="text"  name="C_TO_PRT" maxlength="60" size="25" value="<%=C_TO_PRT%>">
              </p>
            </div>
          </td>
        </tr>
        <tr> 
          <td  align="center"> 
            <div align="left">船名/车号/航班号：<%=C_SAIL_NO%>88-09-01 </div>
          </td>
          <td >船名/车号/航班号： 
            <input type="text" name="C_SAIL_NO" maxlength="60" size="14" value="<%=C_SAIL_NO%>">
            * </td>
        </tr>
        <tr> 
          <td  align="center"> 
            <div align="left">集装箱整箱</div>
          </td>
          <td > 
            <input type="radio" name="C_CONTAINER" <%if(C_CONTAINER.equals("集装箱整箱")) out.print("checked")%> value="集装箱整箱">
            集装箱整箱
            <input type="radio" name="C_CONTAINER" <%if(C_CONTAINER.equals("集装箱拼箱")) out.print("checked")%> value="集装箱拼箱">
            集装箱拼箱
            <input type="radio" name="C_CONTAINER" <%if(C_CONTAINER.equals("非集装箱运输")) out.print("checked")%> value="非集装箱运输">
            非集装箱运输</td>
        </tr>
        <tr> 
          <td  align="center"> 
            <p align="left">开航日期：<%=birth_year%>-<%=birth_month%>-<%=birth_day%>2000-05-16</p>
            <p>&nbsp;</p>
          </td>
          <td >开航日期：
            <input type="text" name="birth_year" size="4"  maxlength="4" value="<%=birth_year%>">
            年
            <input type="text" name="birth_month" size="2" maxlength="2" value="<%=birth_month%>">
            月
            <input type="text" name="birth_day" size="2" maxlength="2" value="<%=birth_day%>">
            日*
            <input type="hidden" name="tempdate" value="2000-08-23">
            </td>
        </tr>
      </table>
</center>
</div>
  <dl>
              <dd align="left"> 
                <div align="center"> 
                  <input type="submit" value="提  交" name="B1" onclick="sub(temp);change(birth_year,birth_month,birth_day,tempdate);">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                  <input type="reset" value="重  填" name="B2">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                  <input type="button" value="返  回" name="B44" onclick='javascript:history.back();'>
                </div>
              </dd>
           
   
  </dl>
      
    <input type="hidden" name="sessionid" value="z8-Pz8-Pz8-PzgAA">
    <input type="hidden" name="temp" value="sub">
    <input type="hidden" name="C_PLY_APP_NO" value="">    
    <input type="hidden" name="AGENCYNO" value="CASE">
    <input type="hidden" name="ADDAGENCYNO" value="">
        <input type="hidden" name="TEMPAMT" value="">
        <input type="hidden" name="TEMPAMT1" value="">        

</form>
</body>
</html>
