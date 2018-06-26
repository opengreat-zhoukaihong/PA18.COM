package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlcyAppInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlcyAppInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlcyAppInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlcyAppInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlcyAppInfo {
      string c_ply_app_no;
      string c_ply_no;
      string c_orig_ply_no;
      string c_dpt_cde;
      string c_bsns_typ;
      string c_cmpny_agt_cde;
      wstring c_cmpny_agt_nme;
      string c_agt_agr_no;
      long n_sub_co_no;
      string c_brkr_cde;
      wstring c_brkr_nme;
      string c_sls_cde;
      wstring c_sls_nme;
      string c_insrnc_cmpny_cde;
      wstring c_insrnc_cmpny_nme;
      string c_insrnt_cde;
      wstring c_insrnt_nme;
      wstring c_insrnt_addr;
      string c_bnfc_cde;
      wstring c_bnfc_nme;
      string c_app_cde;
      wstring c_app_nme;
      wstring c_app_addr;
      string c_app_tel;
      string c_insrnc_cde;
      string c_claus_cde;
      string t_app_tm;
      string t_insrnc_bgn_tm;
      string t_insrnc_end_tm;
      string t_sign_tm;
      string c_amt_cur;
      double n_insrnc_vlu;
      double n_amt;
      double n_rate;
      double n_prm;
      double n_rdr_prm;
      double n_sum_prm;
      string c_prm_cur;
      double n_nclm_prop;
      double n_appnt_prop;
      double n_cmm_prop;
      double n_brk_prop;
      long n_pay_tms;
      wstring c_appnt;
      wstring c_remark;
      wstring c_crt_prsn;
      wstring c_undr_prsn;
      string t_undr_tm;
      string c_rinsrnc_mrk;
      string c_coinsrnc_mrk;
      string t_input_tm;
      wstring c_undr_dpt;
      string c_opr_typ;
      string c_edr_prj_no;
      string t_next_edr_undr_tm;
      string c_udr_mrk;
      string c_agelong_mrk;
      string c_ceprn_mrk;
      string c_salegrp_cde;
      string c_open_cover_no;
      string c_internet_typ;
      string c_crgo_cde;
      wstring c_crgo_desc;
      wstring c_invc_no;
      wstring c_sail_no;
      wstring c_prn_frm;
      wstring c_carriage_cde;
      wstring c_vsl_lvl_cde;
      wstring c_from_prt;
      wstring c_to_prt;
      string c_frm_prt_ara;
      string c_to_prt_ara;
      wstring c_pass_prt;
      string c_srvy_cde;
      wstring c_srvy_cnm;
      wstring c_undr_cndtn;
      wstring c_pay_addr;
      wstring c_receipt_no;
      string c_crgo_cls;
      wstring c_crgo_name;
      wstring c_amount;
      wstring c_pack_cde;
      wstring c_pack_cnm;
      wstring c_mark;
      double n_invc_amt;
      wstring c_invc_amt_cur;
      wstring c_no_repay;
      string c_credit_id;
      wstring c_lost_desc;
      wstring c_container;
      wstring c_add_risk;
      string c_main_insurance;
      string c_add_insurance;
      string c_rdr_cde;
      wstring c_rdr_nme;
      wstring c_rmk_desc;
      string c_province;
      string c_city;
      wstring c_place;
      wstring c_contact_name;
      string c_contact_phone;
      string c_contact_fax;
      wstring c_contact_email;
      string c_pay_mde_cde;
      wstring c_site_cde;
      wstring c_zip_cde;
      wstring c_srvy_addr;
      wstring c_edr_info;
      string c_mdfy_tm;
    };
</pre>
</p>
*/
final public class PlcyAppInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlcyAppInfo value;
  public PlcyAppInfoHolder() {
  }
  public PlcyAppInfoHolder(com.mcip.nia.orb.PlcyAppInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlcyAppInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlcyAppInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlcyAppInfoHelper.type();
  }
}
