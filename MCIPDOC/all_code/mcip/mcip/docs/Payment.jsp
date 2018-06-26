<%@ include file="public/Public.jsp" %>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PaymentManagerBean"/>
<jsp:setProperty name="pb" property="*"/>

<%
	//get the payment information from the previous page
			Hashtable hashData = new Hashtable();
			hashData = ob.getHashData();
		String OrderNo = (String)request.getAttribute("PlyNoDisp");
			if(OrderNo.equals(""))
				 OrderNo = Objects.getHt(hashData,"C_PLY_NO");
		String nSumPrmValue = (String)request.getAttribute("nSumPrmValue");
		Date payTime = new Date();
		request.getSession().putValue("payTime",payTime);
		String UserName = sessionbuffer.getuserId(Locate);
		//Add a record to local log DB with the false flag
		boolean logStatus = false;
		Object formParaObj[] = new Object[1];
		com.mcip.pay.orb.PaymentLog log = new com.mcip.pay.orb.PaymentLog();
		log.c_trans_id = "";//transaction id,preset all zero
		log.c_bank_cde = "";//bank code blank
		log.c_bank_cnm = "";//bank name in Chinese
		log.c_bank_accnt = "";//account in bank
		log.n_got_prm = Double.parseDouble(nSumPrmValue);//amount paid
		log.c_cur_typ = "01";//currency type code
		log.c_cur_sbl = "";//currency symbol
		log.c_cur_cnm = "";//currency name in Chinese
		log.t_pay_tm = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(payTime);
		log.c_pay_typ = "1";//pay type allocated by pa18
		log.c_pay_cde = "";//
		log.c_order_no = OrderNo;//order no (policy no)
		log.t_order_tm = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(payTime);//time when order created
		log.c_type_id = "1";//
		log.c_payment_id = "";//payment id preset all zero
		log.c_pay_seq_no = "";//sequence no preset all zero
		log.c_status_id = "103";//preset status as unknow
		log.c_user_id = UserName;//user id
		formParaObj[0] = log;
		try{
			pb.setFormParaObj(PConst.ACCEPT_PAYMENT_LOG,formParaObj);
			logStatus = pb.getRetValueBool();
		}catch(Exception e){
		}

//format the source payment string
		String spaceString = "                                        ";//40 space characters
		String zeroString = "000000000000";
		String Time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(payTime);

		if (OrderNo.length()<40)
			OrderNo += spaceString.substring(0,40-OrderNo.length());
		String Amount = new Integer((int) (new Double(nSumPrmValue).doubleValue()*100)).toString();

		if (Amount.length()<12)
			Amount = zeroString.substring(0,12-Amount.length()) + Amount;

		String TypeID = "1";
		if (TypeID.length()<4)
			TypeID = zeroString.substring(0,4-TypeID.length()) + TypeID;

		UserName = "";
		if (UserName.length() < 20)
			UserName+= spaceString.substring(0, 20- UserName.length() );
	//encrypt the data will be transfered by url
	String cipherText = payutil.buildCiphertext(OrderNo+Amount+TypeID+UserName+Time);
%>

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

	<table border="0">
	<% if (logStatus){%>
		<tr>
			<td>
			您选择了网上支付的付款方式，请根据系统提示完成支付过程
			</td>
		</tr>
		<tr>
			<td>
				<br><br><br><br>
			</td>
		</tr>
		<tr>
			<td>
		<form name="pay" action="https://www4.pa18.com/payment/ssl/docc/payment.jsp" method="post">
			<input type="hidden" name="msg" value="<%=cipherText%>">
			<input type="hidden" name="returnnrul" value="http://cargot.pa18.com/payBack.jsp">
			&nbsp;&nbsp&nbsp<input type="submit" value="开始支付">
		</form>
			</td>
		</tr>
		<%}else{%>
				<tr>
			<td>
			无法产生支付记录，请使用网下支付！
			</td>
		</tr>
		<%}%>
	</table>
</td>
			</tr>
		</table>
</td>
	</tr>
</table>
<%@ include file="public/PublicBottom.html" %>

</body>
</html>
