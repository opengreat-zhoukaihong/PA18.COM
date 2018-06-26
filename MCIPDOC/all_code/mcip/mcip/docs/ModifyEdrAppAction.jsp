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
 <%@ include file="public/Public.jsp" %>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/>
<jsp:setProperty name="pmb" property="*"/>

<%  //for get  para and to bean



     // String ClientName = sessionbuffer.getClientName(Locate); //投保人
     // String ClientType = sessionbuffer.getClientType(Locate); //登录客户类型
     // String ClientId =   sessionbuffer.getClientId(Locate);

       if(pmb.plyEdrAppInfo==null){
         out.println("NULLLLLLLL");
       }

      String C_INSRNT_CDE = request.getParameter("C_INSRNT_CDE"); //被保人遍码
      out.println("<p>1 被保人遍码"+ C_INSRNT_CDE);
      pmb.plyEdrAppInfo.c_insrnt_cde=C_INSRNT_CDE ;

      String C_INSRNT_NME = request.getParameter("C_INSRNT_NME"); //plyEdrAppInfo.c_insrnt_nme ;被保人姓名
      out.println("<p>2:"+ C_INSRNT_NME);
      pmb.plyEdrAppInfo.c_insrnt_nme= C_INSRNT_NME;

      String C_PLACE = request.getParameter("C_PLACE") ; //plyPlyAppNetInfo.c_place送达祥细地址
      out.println("<p>3:"+ C_PLACE);
      pmb.plyPlyAppNetInfo.c_place = C_PLACE;

      String C_CONTACT_NAME= request.getParameter("C_CONTACT_NAME") ; //plyPlyAppNetInfo.c_contact_name联系人
      out.println("<p>4:"+ C_CONTACT_NAME);
      pmb.plyPlyAppNetInfo.c_contact_name  = C_CONTACT_NAME;

      String C_CONTACT_PHONE = request.getParameter("C_CONTACT_PHONE") ;//plyPlyAppNetInfo.c_contact_phone联系电话
      out.println("<p>5:"+ C_CONTACT_PHONE);
      pmb.plyPlyAppNetInfo.c_contact_phone = C_CONTACT_PHONE;

      String C_CONTACT_FAX = request.getParameter("C_CONTACT_FAX"); //plyPlyAppNetInfo.c_contact_fax联系传真
      out.println("<p>6:"+ C_CONTACT_FAX);
      pmb.plyPlyAppNetInfo.c_contact_fax = C_CONTACT_FAX ;

      String C_CONTACT_EMAIL=request.getParameter("C_CONTACT_EMAIL");//plyPlyAppNetInfo.c_contact_email
      out.println("<p>7:"+ C_CONTACT_EMAIL);
      pmb.plyPlyAppNetInfo.c_contact_email  = C_CONTACT_EMAIL;

      String C_CRGO_DESC = request.getParameter("C_CRGO_DESC") ; //plyEdrAppCrgoInfo.c_crgo_desc品名描述
      out.println("<p>8:"+ C_CRGO_DESC);
      pmb.plyEdrAppCrgoInfo.c_crgo_desc =  C_CRGO_DESC ;

      String C_PACK_CNM=request.getParameter("C_PACK_CNM"); //plyEdrAppCrgoInfo.c_pack_cnm包装描述
      out.println("<p>9:"+C_PACK_CNM);
      pmb.plyEdrAppCrgoInfo.c_pack_cnm = C_PACK_CNM;

      String C_AMOUNT = request.getParameter("C_AMOUNT"); //plyEdrAppCrgoInfo.c_amount数量
      out.println("<p>10:"+ C_AMOUNT);
      pmb.plyEdrAppCrgoInfo.c_amount  =  C_AMOUNT ;

      String C_MARK = request.getParameter("C_MARK");//plyEdrAppCrgoInfo.c_mark唛头
      out.println("<p>11:"+ C_MARK);
      if(C_MARK == null){
        pmb.plyEdrAppCrgoInfo.c_mark = "";
      }else{
         pmb.plyEdrAppCrgoInfo.c_mark =   C_MARK ;
      }


      String N_INVC_AMT = request.getParameter("N_INVC_AMT");//plyEdrAppCrgoInfo.n_invc_amt发票金额
      out.println("<p>12:"+ N_INVC_AMT);
      pmb.plyEdrAppCrgoInfo.n_invc_amt =  N_INVC_AMT ;

      String C_INVC_NO = request.getParameter("C_INVC_NO"); //plyEdrAppCrgoInfo.c_invc_no发票号码
      out.println("<p>13:"+ C_INVC_NO);
      pmb.plyEdrAppCrgoInfo.c_invc_no  = C_INVC_NO ;

      String C_RECEIPT_NO = request.getParameter("C_RECEIPT_NO");//plyEdrAppCrgoInfo.c_receipt_no提单号
      out.println("<p>14:"+ C_RECEIPT_NO);
      if(C_RECEIPT_NO == null) {
        pmb.plyEdrAppCrgoInfo.c_receipt_no = "";
      }else{
        pmb.plyEdrAppCrgoInfo.c_receipt_no =   C_RECEIPT_NO ;
      }  

      String C_FRM_PRT_ARA = request.getParameter("C_FRM_PRT_ARA");//plyEdrAppCrgoInfo.c_frm_prt_ara起运国
      out.println("<p>15:"+  C_FRM_PRT_ARA);
      pmb.plyEdrAppCrgoInfo.c_frm_prt_ara = C_FRM_PRT_ARA ;

      String C_FRM_PRT= request.getParameter("C_FRM_PRT");//plyEdrAppCrgoInfo.c_from_prt起运港
      out.println("<p>16:"+ C_FRM_PRT);
      pmb.plyEdrAppCrgoInfo.c_from_prt =  C_FRM_PRT ;

      String C_PASS_PRT= request.getParameter("C_PASS_PRT");//plyEdrAppCrgoInfo.c_pass_prt途经港
      out.println("<p>17:"+ C_PASS_PRT);
      if( C_PASS_PRT == null ){
        pmb.plyEdrAppCrgoInfo.c_pass_prt = "";
      }else{
        pmb.plyEdrAppCrgoInfo.c_pass_prt =  C_PASS_PRT;
      }

      String C_TO_PRT_ARA= request.getParameter("C_TO_PRT_ARA");//plyEdrAppCrgoInfo.c_to_prt_ara到达国
      out.println("<p>18:"+ C_TO_PRT_ARA);
      pmb.plyEdrAppCrgoInfo.c_to_prt_ara = C_TO_PRT_ARA;

      String C_TO_PRT = request.getParameter("C_TO_PRT");//plyEdrAppCrgoInfo.c_to_prt到达港
      out.println("<p>19:"+ C_TO_PRT);
      pmb.plyEdrAppCrgoInfo.c_to_prt =  C_TO_PRT ;

      String C_SAIL_NO = request.getParameter("C_SAIL_NO");//plyEdrAppCrgoInfo.c_sail_no航次
      out.println("<p>20:"+C_SAIL_NO);
      pmb.plyEdrAppCrgoInfo.c_sail_no  = C_SAIL_NO ;

      String C_CONTAINER= request.getParameter("C_CONTAINER") ;// plyEdrAppCrgoInfo.c_container集装箱方氏
      out.println("<p>21:"+ C_CONTAINER);
      pmb.plyEdrAppCrgoInfo.c_container = C_CONTAINER ;

      String birth_year= request.getParameter("birth_year");  //plyEdrAppCrgoInfo.c_prn_frm开航年
      out.println("<p>22:"+birth_year);

      String birth_month= request.getParameter("birth_month"); //开航月
      out.println("<p>23:"+ birth_month);

      String birth_day= request.getParameter("birth_day"); //开航年日
      out.println("<p>24:"+ birth_day);

      String PlyNo = request.getParameter("C_PLY_NO");
      out.println("<p>25:"+ PlyNo);
      String datestr =  birth_year + "-"+ birth_month +"-" +birth_day +" 00:00:00";
      out.println("<p>26:"+ datestr);
      pmb.plyEdrAppInfo.t_insrnc_bgn_tm = birth_year + "-"+ birth_month +"-" +birth_day +" 00:00:00";


    String para[]={PlyNo};
    out.println("PlyNo:"+PlyNo);
    String[][] retValueArra;
    try
    {
         pmb.setFormPara(1,para);
         retValueArra = pmb.getRetValueArra();
    }
    catch(NormalException e)
    {
 	    //if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
    /*for(int i=0; i<  retValueArra.length; i++)
      for(int  j=0; j < retValueArra[i].length; j++)
        out.println("<p> i:"+ i+ ",j:"+j +":"+ retValueArra[i][j]);*/
     if(retValueArra[1][0].equals("0")){
        out.println("您已经成功批改保单，申请号："+retValueArra[1][1]);
        out.println("请等待我们审批！");         
     }else{
       out.println("批改不成功!");
     }

   %>
</body>
</html>

