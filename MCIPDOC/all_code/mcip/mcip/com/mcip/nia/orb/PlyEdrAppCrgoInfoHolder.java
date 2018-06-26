package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppCrgoInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppCrgoInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrAppCrgoInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrAppCrgoInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrAppCrgoInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_edr_app_no;
      wstring c_crgo_cde;
      wstring c_crgo_cnm;
      wstring c_crgo_desc;
      wstring c_invc_no;
      wstring c_sail_no;
      wstring c_prn_frm;
      wstring c_carriage_cde;
      wstring c_vsl_lvl_cde;
      wstring c_from_prt;
      wstring c_to_prt;
      wstring c_frm_prt_ara;
      wstring c_to_prt_ara;
      wstring c_pass_prt;
      wstring c_srvy_cde;
      wstring c_srvy_cnm;
      wstring c_undr_cndtn;
      wstring n_amt;
      wstring n_rate;
      wstring n_prm;
      wstring c_pay_addr;
      wstring c_rec_no;
      wstring c_receipt_no;
      wstring c_crgo_cls;
      wstring c_crgo_name;
      wstring c_amount;
      wstring c_pack_cde;
      wstring c_mark;
      wstring n_invc_amt;
      wstring c_invc_amt_cur;
      wstring c_no_repay;
      wstring c_credit_id;
      wstring c_lost_desc;
      wstring c_container;
      wstring c_add_risk;
      wstring c_pack_cnm;
      wstring c_srvy_addr;
      wstring c_edr_info;
    };
</pre>
</p>
*/
final public class PlyEdrAppCrgoInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyEdrAppCrgoInfo value;
  public PlyEdrAppCrgoInfoHolder() {
  }
  public PlyEdrAppCrgoInfoHolder(com.mcip.nia.orb.PlyEdrAppCrgoInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper.type();
  }
}
