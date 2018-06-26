<%@ include file="public/Public.jsp" %>
<jsp:useBean id="pb"  scope="request" class="beans.PaymentManagerBean"/> 
<jsp:setProperty name="pb" property="*"/>
<%
String transactid = request.getParameter("transactid");
String orderno = request.getParameter("orderno");
String amount = request.getParameter("amount");
String paymentid = request.getParameter("paymentid");
String statusid = request.getParameter("statusid");
String signare = request.getParameter("signare");
boolean isSafe = payutil.verify(transactid+orderno+amount+paymentid+statusid,signare);

%>
<!--
transactid:<%=transactid%><br>
orderno:<%=orderno%><br>
amount:<%=amount%><br>
paymentid:<%=paymentid%><br>
statusid:<%=statusid%><br>
signare:<%=signare%><br>
isSafe:<%=isSafe%>
-->
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 

<%@ include file="public/PublicPlyLeft.html" %>

  <td width="613" height="288" valign="top"> <br>
	<table border="0"  width="80%" cellpadding="4">
	      <tr>
	<td width="5%">　　</td>
	<td>
<%
if (isSafe){
	if (statusid.equals("101")){
		out.println("网上支付成功,请等待送单");
		//update the pay flag in the log db
	}else {
		if (statusid.equals("102")){
			out.println("网上支付失败,我们的业务人员将在送单的同时收取保费");
			//update the pay flag in the log db
		}else{
			if (statusid.equals("103")){
				out.println("等待支付结果，请稍后查询");
			}else{
				out.println("支付出现未知错误，请稍后查询");
			}
		}
	}
	//update pay log and policy net
		//save the pay result information
	//Date paytime = (Date)request.getSession().getValue("payTime");
Date paytime = new Date();
	String UserName = sessionbuffer.getuserId(Locate);
	String formPara[] = new String[12];
	boolean updateOK = false;
	formPara[0] = orderno;//order no 
	formPara[1] = statusid.substring(2,3);//status id 
	formPara[2] = paymentid;//payment id 
	formPara[3] = "";//bank code
	formPara[4] = "";//bank name
	formPara[5] ="";//bank account
	formPara[6] =amount;//amount
	formPara[7] ="01";//currency type (RMB for now)
	formPara[8] =new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(paytime);//payment time
	formPara[9] ="1";//pay type
	formPara[10] ="";//pay code
	formPara[11] = "0";//app type
	try{
		pb.setFormPara(PConst.UPDATE_PAY_FLAG,formPara);
		updateOK = pb.getRetValueBool();
	}catch (Exception e){
		updateOK = false;
		out.println("日志出错!,请稍后查询详细结果");
	}

	if (updateOK){
		//save to pay log 
		Object formParaObj[] = new Object[1];
		com.mcip.pay.orb.PaymentLog log = new com.mcip.pay.orb.PaymentLog();
		log.c_trans_id = transactid;//transaction id,preset all zero
		log.c_bank_cde = "";//bank code blank
		log.c_bank_cnm = "";//bank name in Chinese
		log.c_bank_accnt = "";//account in bank
		log.n_got_prm = Double.parseDouble(amount);//amount paid
		log.c_cur_typ = "01";//currency type code
		log.c_cur_sbl = "";//currency symbol
		log.c_cur_cnm = "";//currency name in Chinese
		log.t_pay_tm = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paytime);
		log.c_pay_typ = "1";//pay type allocated by pa18
		log.c_pay_cde = "";//
		log.c_order_no = orderno;//order no (policy no)
		log.t_order_tm = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(paytime);//time when order created
		log.c_type_id = "";//
		log.c_payment_id = paymentid;//payment id preset all zero
		log.c_pay_seq_no = "";//sequence no preset all zero
		log.c_status_id = statusid;//preset status as unknow
		log.c_user_id = UserName;//user id 
		formParaObj[0] = log;
		try{
			pb.setFormParaObj(PConst.UPDATE_PAY_LOG,formParaObj);
			updateOK = pb.getRetValueBool();
		}catch(Exception e){
			out.println("日志出错!,请稍后查询详细结果"+e);
			updateOK = false;
		}
	}
}else{
		out.println("支付数据已经被篡改，请稍后查询详细结果");
}
%>
</td>
      </tr>
    </table>
</td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %>      
</body>
</html>
