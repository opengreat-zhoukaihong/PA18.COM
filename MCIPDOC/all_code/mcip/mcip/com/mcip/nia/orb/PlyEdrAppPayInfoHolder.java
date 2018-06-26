package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppPayInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppPayInfoHolder.java
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
final public class PlyEdrAppPayInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyEdrAppPayInfo value;
  public PlyEdrAppPayInfoHolder() {
  }
  public PlyEdrAppPayInfoHolder(com.mcip.nia.orb.PlyEdrAppPayInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyEdrAppPayInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyEdrAppPayInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlyEdrAppPayInfoHelper.type();
  }
}
