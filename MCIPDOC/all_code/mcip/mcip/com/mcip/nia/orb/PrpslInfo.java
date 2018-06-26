package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PrpslInfo
<li> <b>Source File</b> com/mcip/nia/orb/PrpslInfo.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PrpslInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PrpslInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PrpslInfo {
      string c_doc_no;
      double n_rate;
      wstring c_no_repay;
      wstring c_undr_cndtn;
      string t_send_tm;
      wstring c_send_desc;
      wstring c_undr_prsn;
      string t_sign_tm;
      string c_user_id;
      wstring c_remark;
      wstring c_user_remark;
    };
</pre>
</p>
*/
final public class PrpslInfo {
  public java.lang.String c_doc_no;
  public double n_rate;
  public java.lang.String c_no_repay;
  public java.lang.String c_undr_cndtn;
  public java.lang.String t_send_tm;
  public java.lang.String c_send_desc;
  public java.lang.String c_undr_prsn;
  public java.lang.String t_sign_tm;
  public java.lang.String c_user_id;
  public java.lang.String c_remark;
  public java.lang.String c_user_remark;
  public PrpslInfo() {
  }
  public PrpslInfo(
    java.lang.String c_doc_no,
    double n_rate,
    java.lang.String c_no_repay,
    java.lang.String c_undr_cndtn,
    java.lang.String t_send_tm,
    java.lang.String c_send_desc,
    java.lang.String c_undr_prsn,
    java.lang.String t_sign_tm,
    java.lang.String c_user_id,
    java.lang.String c_remark,
    java.lang.String c_user_remark
  ) {
    this.c_doc_no = c_doc_no;
    this.n_rate = n_rate;
    this.c_no_repay = c_no_repay;
    this.c_undr_cndtn = c_undr_cndtn;
    this.t_send_tm = t_send_tm;
    this.c_send_desc = c_send_desc;
    this.c_undr_prsn = c_undr_prsn;
    this.t_sign_tm = t_sign_tm;
    this.c_user_id = c_user_id;
    this.c_remark = c_remark;
    this.c_user_remark = c_user_remark;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.PrpslInfoHelper.insert(any, this);
    return any.toString();
  }
}
