package com.mcip.pay.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.pay.orb.PaymentLogHolder
<li> <b>Source File</b> com/mcip/pay/orb/PaymentLogHolder.java
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
final public class PaymentLogHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.pay.orb.PaymentLog value;
  public PaymentLogHolder() {
  }
  public PaymentLogHolder(com.mcip.pay.orb.PaymentLog value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.pay.orb.PaymentLogHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.pay.orb.PaymentLogHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.pay.orb.PaymentLogHelper.type();
  }
}
