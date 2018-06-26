package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.OpenCoverInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/OpenCoverInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::OpenCoverInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/OpenCoverInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct OpenCoverInfo {
      string c_open_cover_no;
      string c_auth_mrk;
      string c_udr_mrk;
      string c_dpt_cde;
      string t_effc_tm;
      string t_co_strt_tm;
      string t_co_end_tm;
      wstring c_undr_prsn;
      string c_insrnc_cde;
      string c_sls_cde;
      double n_rate;
      string c_insrnt_cde;
      wstring c_insrnt_nme;
      string c_app_cde;
      wstring c_app_nme;
      wstring c_crt_prsn;
      string t_undr_tm;
      string c_ara_cde;
      wstring c_province;
      wstring c_city;
      wstring c_place;
      wstring c_contact_name;
      string c_contact_phone;
      string c_contact_fax;
      wstring c_contact_email;
      string c_need_ply_no;
      string c_need_change;
      wstring c_undr_cndtn;
      wstring c_no_repay_desc;
      string n_busi_amt;
      string c_busi_cur;
      wstring c_bus_feather;
      string c_srvy_cde;
      wstring c_srvy_cnm;
      wstring c_pay_addr;
      string c_carriage_cde;
      wstring c_from_prt;
      wstring c_to_prt;
      string c_frm_prt_ara;
      string c_to_prt_ara;
      wstring c_pass_prt;
      string c_crgo_cls;
      string c_crgo_cde;
      wstring c_crgo_name;
      string c_amount;
      string c_pack_cde;
      wstring c_pack_cnm;
      wstring c_mark;
    };
</pre>
</p>
*/
final public class OpenCoverInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.OpenCoverInfo value;
  public OpenCoverInfoHolder() {
  }
  public OpenCoverInfoHolder(com.mcip.nia.orb.OpenCoverInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.OpenCoverInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.OpenCoverInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.OpenCoverInfoHelper.type();
  }
}
