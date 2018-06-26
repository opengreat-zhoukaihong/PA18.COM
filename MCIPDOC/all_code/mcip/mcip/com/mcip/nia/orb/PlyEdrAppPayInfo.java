package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppPayInfo
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppPayInfo.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrAppPayInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrAppPayInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrAppPayInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_edr_app_no;
      wstring n_tms;
      wstring c_rcpt_no;
      wstring c_pay_prsn_cde;
      wstring c_pay_prsn_nme;
      wstring n_get_prm;
      wstring c_pay_mde_cde;
      wstring c_accnt_no;
      wstring t_pay_lmt_tm;
      wstring n_got_prm;
      wstring t_pay_strt_tm;
      wstring t_pay_tm;
      wstring c_insrnc_cde;
      wstring c_cur_typ;
      wstring c_rec_no;
      wstring c_prn_typ;
    };
</pre>
</p>
*/
final public class PlyEdrAppPayInfo {
  public java.lang.String c_crt_cde;
  public java.lang.String c_crt_tm;
  public java.lang.String c_upd_cde;
  public java.lang.String c_upd_tm;
  public java.lang.String c_edr_app_no;
  public java.lang.String n_tms;
  public java.lang.String c_rcpt_no;
  public java.lang.String c_pay_prsn_cde;
  public java.lang.String c_pay_prsn_nme;
  public java.lang.String n_get_prm;
  public java.lang.String c_pay_mde_cde;
  public java.lang.String c_accnt_no;
  public java.lang.String t_pay_lmt_tm;
  public java.lang.String n_got_prm;
  public java.lang.String t_pay_strt_tm;
  public java.lang.String t_pay_tm;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_cur_typ;
  public java.lang.String c_rec_no;
  public java.lang.String c_prn_typ;
  public PlyEdrAppPayInfo() {
  }
  public PlyEdrAppPayInfo(
    java.lang.String c_crt_cde,
    java.lang.String c_crt_tm,
    java.lang.String c_upd_cde,
    java.lang.String c_upd_tm,
    java.lang.String c_edr_app_no,
    java.lang.String n_tms,
    java.lang.String c_rcpt_no,
    java.lang.String c_pay_prsn_cde,
    java.lang.String c_pay_prsn_nme,
    java.lang.String n_get_prm,
    java.lang.String c_pay_mde_cde,
    java.lang.String c_accnt_no,
    java.lang.String t_pay_lmt_tm,
    java.lang.String n_got_prm,
    java.lang.String t_pay_strt_tm,
    java.lang.String t_pay_tm,
    java.lang.String c_insrnc_cde,
    java.lang.String c_cur_typ,
    java.lang.String c_rec_no,
    java.lang.String c_prn_typ
  ) {
    this.c_crt_cde = c_crt_cde;
    this.c_crt_tm = c_crt_tm;
    this.c_upd_cde = c_upd_cde;
    this.c_upd_tm = c_upd_tm;
    this.c_edr_app_no = c_edr_app_no;
    this.n_tms = n_tms;
    this.c_rcpt_no = c_rcpt_no;
    this.c_pay_prsn_cde = c_pay_prsn_cde;
    this.c_pay_prsn_nme = c_pay_prsn_nme;
    this.n_get_prm = n_get_prm;
    this.c_pay_mde_cde = c_pay_mde_cde;
    this.c_accnt_no = c_accnt_no;
    this.t_pay_lmt_tm = t_pay_lmt_tm;
    this.n_got_prm = n_got_prm;
    this.t_pay_strt_tm = t_pay_strt_tm;
    this.t_pay_tm = t_pay_tm;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_cur_typ = c_cur_typ;
    this.c_rec_no = c_rec_no;
    this.c_prn_typ = c_prn_typ;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.PlyEdrAppPayInfoHelper.insert(any, this);
    return any.toString();
  }
}
