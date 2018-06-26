package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrGridInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrGridInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrGridInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrGridInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrGridInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_edr_app_no;
      wstring c_send_tm;
      wstring c_dpt_cde;
      wstring c_source;
      wstring c_send_dpt_cde;
      wstring c_send_cde;
      wstring c_des_dpt_cde;
      wstring c_emergency;
      wstring c_authprn_cde;
      wstring c_udr_mrk;
      wstring c_send_mrk;
      wstring c_udr_opn_mrk;
      wstring c_vrfy_mrk;
      wstring c_mdfy_tm;
      wstring c_insrnc_cde;
      wstring c_undr_prsn;
      wstring c_undr_dpt;
      wstring c_prn_typ;
      wstring c_rinsrnc_mrk;
      wstring c_coinsrnc_mrk;
      wstring c_ply_no;
      wstring c_edr_no;
      wstring c_read_tm;
      wstring c_rec_no;
      wstring c_flag;
      wstring c_insrnc_dfn_typ;
      wstring c_insrnc_cnm;
      wstring c_edr_typ;
      wstring c_app_nme;
      wstring n_amt;
      wstring t_sign_tm;
      wstring c_rpt_desc;
      wstring c_risk_lvl_cde;
      wstring c_lcn_no;
      wstring c_eng_no;
      wstring c_insrnc_cls;
      wstring c_use_atr;
      wstring c_undr_opn;
      wstring c_internet_typ;
    };
</pre>
</p>
*/
final public class PlyEdrGridInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyEdrGridInfo value;
  public PlyEdrGridInfoHolder() {
  }
  public PlyEdrGridInfoHolder(com.mcip.nia.orb.PlyEdrGridInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyEdrGridInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyEdrGridInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlyEdrGridInfoHelper.type();
  }
}
