package com.mcip.pay.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.pay.orb.PaymentLog
<li> <b>Source File</b> com/mcip/pay/orb/PaymentLog.java
<li> <b>IDL Source File</b> paymentInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::pay::orb::PaymentLog
<li> <b>Repository Identifier</b> IDL:com/mcip/pay/orb/PaymentLog:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/pay/orb"
    struct PaymentLog {
      string c_trans_id;
      string c_bank_cde;
      wstring c_bank_cnm;
      wstring c_bank_accnt;
      double n_got_prm;
      wstring c_cur_typ;
      wstring c_cur_sbl;
      wstring c_cur_cnm;
      string t_pay_tm;
      wstring c_pay_typ;
      wstring c_pay_cde;
      wstring c_order_no;
      string t_order_tm;
      wstring c_type_id;
      wstring c_payment_id;
      wstring c_pay_seq_no;
      wstring c_status_id;
      wstring c_user_id;
    };
</pre>
</p>
*/
final public class PaymentLog {
  public java.lang.String c_trans_id;
  public java.lang.String c_bank_cde;
  public java.lang.String c_bank_cnm;
  public java.lang.String c_bank_accnt;
  public double n_got_prm;
  public java.lang.String c_cur_typ;
  public java.lang.String c_cur_sbl;
  public java.lang.String c_cur_cnm;
  public java.lang.String t_pay_tm;
  public java.lang.String c_pay_typ;
  public java.lang.String c_pay_cde;
  public java.lang.String c_order_no;
  public java.lang.String t_order_tm;
  public java.lang.String c_type_id;
  public java.lang.String c_payment_id;
  public java.lang.String c_pay_seq_no;
  public java.lang.String c_status_id;
  public java.lang.String c_user_id;
  public PaymentLog() {
  }
  public PaymentLog(
    java.lang.String c_trans_id,
    java.lang.String c_bank_cde,
    java.lang.String c_bank_cnm,
    java.lang.String c_bank_accnt,
    double n_got_prm,
    java.lang.String c_cur_typ,
    java.lang.String c_cur_sbl,
    java.lang.String c_cur_cnm,
    java.lang.String t_pay_tm,
    java.lang.String c_pay_typ,
    java.lang.String c_pay_cde,
    java.lang.String c_order_no,
    java.lang.String t_order_tm,
    java.lang.String c_type_id,
    java.lang.String c_payment_id,
    java.lang.String c_pay_seq_no,
    java.lang.String c_status_id,
    java.lang.String c_user_id
  ) {
    this.c_trans_id = c_trans_id;
    this.c_bank_cde = c_bank_cde;
    this.c_bank_cnm = c_bank_cnm;
    this.c_bank_accnt = c_bank_accnt;
    this.n_got_prm = n_got_prm;
    this.c_cur_typ = c_cur_typ;
    this.c_cur_sbl = c_cur_sbl;
    this.c_cur_cnm = c_cur_cnm;
    this.t_pay_tm = t_pay_tm;
    this.c_pay_typ = c_pay_typ;
    this.c_pay_cde = c_pay_cde;
    this.c_order_no = c_order_no;
    this.t_order_tm = t_order_tm;
    this.c_type_id = c_type_id;
    this.c_payment_id = c_payment_id;
    this.c_pay_seq_no = c_pay_seq_no;
    this.c_status_id = c_status_id;
    this.c_user_id = c_user_id;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.pay.orb.PaymentLogHelper.insert(any, this);
    return any.toString();
  }
}
