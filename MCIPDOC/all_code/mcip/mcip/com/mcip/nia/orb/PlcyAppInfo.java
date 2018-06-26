package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlcyAppInfo
<li> <b>Source File</b> com/mcip/nia/orb/PlcyAppInfo.java
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
final public class PlcyAppInfo {
  public java.lang.String c_ply_app_no;
  public java.lang.String c_ply_no;
  public java.lang.String c_orig_ply_no;
  public java.lang.String c_dpt_cde;
  public java.lang.String c_bsns_typ;
  public java.lang.String c_cmpny_agt_cde;
  public java.lang.String c_cmpny_agt_nme;
  public java.lang.String c_agt_agr_no;
  public int n_sub_co_no;
  public java.lang.String c_brkr_cde;
  public java.lang.String c_brkr_nme;
  public java.lang.String c_sls_cde;
  public java.lang.String c_sls_nme;
  public java.lang.String c_insrnc_cmpny_cde;
  public java.lang.String c_insrnc_cmpny_nme;
  public java.lang.String c_insrnt_cde;
  public java.lang.String c_insrnt_nme;
  public java.lang.String c_insrnt_addr;
  public java.lang.String c_bnfc_cde;
  public java.lang.String c_bnfc_nme;
  public java.lang.String c_app_cde;
  public java.lang.String c_app_nme;
  public java.lang.String c_app_addr;
  public java.lang.String c_app_tel;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_claus_cde;
  public java.lang.String t_app_tm;
  public java.lang.String t_insrnc_bgn_tm;
  public java.lang.String t_insrnc_end_tm;
  public java.lang.String t_sign_tm;
  public java.lang.String c_amt_cur;
  public double n_insrnc_vlu;
  public double n_amt;
  public double n_rate;
  public double n_prm;
  public double n_rdr_prm;
  public double n_sum_prm;
  public java.lang.String c_prm_cur;
  public double n_nclm_prop;
  public double n_appnt_prop;
  public double n_cmm_prop;
  public double n_brk_prop;
  public int n_pay_tms;
  public java.lang.String c_appnt;
  public java.lang.String c_remark;
  public java.lang.String c_crt_prsn;
  public java.lang.String c_undr_prsn;
  public java.lang.String t_undr_tm;
  public java.lang.String c_rinsrnc_mrk;
  public java.lang.String c_coinsrnc_mrk;
  public java.lang.String t_input_tm;
  public java.lang.String c_undr_dpt;
  public java.lang.String c_opr_typ;
  public java.lang.String c_edr_prj_no;
  public java.lang.String t_next_edr_undr_tm;
  public java.lang.String c_udr_mrk;
  public java.lang.String c_agelong_mrk;
  public java.lang.String c_ceprn_mrk;
  public java.lang.String c_salegrp_cde;
  public java.lang.String c_open_cover_no;
  public java.lang.String c_internet_typ;
  public java.lang.String c_crgo_cde;
  public java.lang.String c_crgo_desc;
  public java.lang.String c_invc_no;
  public java.lang.String c_sail_no;
  public java.lang.String c_prn_frm;
  public java.lang.String c_carriage_cde;
  public java.lang.String c_vsl_lvl_cde;
  public java.lang.String c_from_prt;
  public java.lang.String c_to_prt;
  public java.lang.String c_frm_prt_ara;
  public java.lang.String c_to_prt_ara;
  public java.lang.String c_pass_prt;
  public java.lang.String c_srvy_cde;
  public java.lang.String c_srvy_cnm;
  public java.lang.String c_undr_cndtn;
  public java.lang.String c_pay_addr;
  public java.lang.String c_receipt_no;
  public java.lang.String c_crgo_cls;
  public java.lang.String c_crgo_name;
  public java.lang.String c_amount;
  public java.lang.String c_pack_cde;
  public java.lang.String c_pack_cnm;
  public java.lang.String c_mark;
  public double n_invc_amt;
  public java.lang.String c_invc_amt_cur;
  public java.lang.String c_no_repay;
  public java.lang.String c_credit_id;
  public java.lang.String c_lost_desc;
  public java.lang.String c_container;
  public java.lang.String c_add_risk;
  public java.lang.String c_main_insurance;
  public java.lang.String c_add_insurance;
  public java.lang.String c_rdr_cde;
  public java.lang.String c_rdr_nme;
  public java.lang.String c_rmk_desc;
  public java.lang.String c_province;
  public java.lang.String c_city;
  public java.lang.String c_place;
  public java.lang.String c_contact_name;
  public java.lang.String c_contact_phone;
  public java.lang.String c_contact_fax;
  public java.lang.String c_contact_email;
  public java.lang.String c_pay_mde_cde;
  public java.lang.String c_site_cde;
  public java.lang.String c_zip_cde;
  public java.lang.String c_srvy_addr;
  public java.lang.String c_edr_info;
  public java.lang.String c_mdfy_tm;
  public PlcyAppInfo() {
  }
  public PlcyAppInfo(
    java.lang.String c_ply_app_no,
    java.lang.String c_ply_no,
    java.lang.String c_orig_ply_no,
    java.lang.String c_dpt_cde,
    java.lang.String c_bsns_typ,
    java.lang.String c_cmpny_agt_cde,
    java.lang.String c_cmpny_agt_nme,
    java.lang.String c_agt_agr_no,
    int n_sub_co_no,
    java.lang.String c_brkr_cde,
    java.lang.String c_brkr_nme,
    java.lang.String c_sls_cde,
    java.lang.String c_sls_nme,
    java.lang.String c_insrnc_cmpny_cde,
    java.lang.String c_insrnc_cmpny_nme,
    java.lang.String c_insrnt_cde,
    java.lang.String c_insrnt_nme,
    java.lang.String c_insrnt_addr,
    java.lang.String c_bnfc_cde,
    java.lang.String c_bnfc_nme,
    java.lang.String c_app_cde,
    java.lang.String c_app_nme,
    java.lang.String c_app_addr,
    java.lang.String c_app_tel,
    java.lang.String c_insrnc_cde,
    java.lang.String c_claus_cde,
    java.lang.String t_app_tm,
    java.lang.String t_insrnc_bgn_tm,
    java.lang.String t_insrnc_end_tm,
    java.lang.String t_sign_tm,
    java.lang.String c_amt_cur,
    double n_insrnc_vlu,
    double n_amt,
    double n_rate,
    double n_prm,
    double n_rdr_prm,
    double n_sum_prm,
    java.lang.String c_prm_cur,
    double n_nclm_prop,
    double n_appnt_prop,
    double n_cmm_prop,
    double n_brk_prop,
    int n_pay_tms,
    java.lang.String c_appnt,
    java.lang.String c_remark,
    java.lang.String c_crt_prsn,
    java.lang.String c_undr_prsn,
    java.lang.String t_undr_tm,
    java.lang.String c_rinsrnc_mrk,
    java.lang.String c_coinsrnc_mrk,
    java.lang.String t_input_tm,
    java.lang.String c_undr_dpt,
    java.lang.String c_opr_typ,
    java.lang.String c_edr_prj_no,
    java.lang.String t_next_edr_undr_tm,
    java.lang.String c_udr_mrk,
    java.lang.String c_agelong_mrk,
    java.lang.String c_ceprn_mrk,
    java.lang.String c_salegrp_cde,
    java.lang.String c_open_cover_no,
    java.lang.String c_internet_typ,
    java.lang.String c_crgo_cde,
    java.lang.String c_crgo_desc,
    java.lang.String c_invc_no,
    java.lang.String c_sail_no,
    java.lang.String c_prn_frm,
    java.lang.String c_carriage_cde,
    java.lang.String c_vsl_lvl_cde,
    java.lang.String c_from_prt,
    java.lang.String c_to_prt,
    java.lang.String c_frm_prt_ara,
    java.lang.String c_to_prt_ara,
    java.lang.String c_pass_prt,
    java.lang.String c_srvy_cde,
    java.lang.String c_srvy_cnm,
    java.lang.String c_undr_cndtn,
    java.lang.String c_pay_addr,
    java.lang.String c_receipt_no,
    java.lang.String c_crgo_cls,
    java.lang.String c_crgo_name,
    java.lang.String c_amount,
    java.lang.String c_pack_cde,
    java.lang.String c_pack_cnm,
    java.lang.String c_mark,
    double n_invc_amt,
    java.lang.String c_invc_amt_cur,
    java.lang.String c_no_repay,
    java.lang.String c_credit_id,
    java.lang.String c_lost_desc,
    java.lang.String c_container,
    java.lang.String c_add_risk,
    java.lang.String c_main_insurance,
    java.lang.String c_add_insurance,
    java.lang.String c_rdr_cde,
    java.lang.String c_rdr_nme,
    java.lang.String c_rmk_desc,
    java.lang.String c_province,
    java.lang.String c_city,
    java.lang.String c_place,
    java.lang.String c_contact_name,
    java.lang.String c_contact_phone,
    java.lang.String c_contact_fax,
    java.lang.String c_contact_email,
    java.lang.String c_pay_mde_cde,
    java.lang.String c_site_cde,
    java.lang.String c_zip_cde,
    java.lang.String c_srvy_addr,
    java.lang.String c_edr_info,
    java.lang.String c_mdfy_tm
  ) {
    this.c_ply_app_no = c_ply_app_no;
    this.c_ply_no = c_ply_no;
    this.c_orig_ply_no = c_orig_ply_no;
    this.c_dpt_cde = c_dpt_cde;
    this.c_bsns_typ = c_bsns_typ;
    this.c_cmpny_agt_cde = c_cmpny_agt_cde;
    this.c_cmpny_agt_nme = c_cmpny_agt_nme;
    this.c_agt_agr_no = c_agt_agr_no;
    this.n_sub_co_no = n_sub_co_no;
    this.c_brkr_cde = c_brkr_cde;
    this.c_brkr_nme = c_brkr_nme;
    this.c_sls_cde = c_sls_cde;
    this.c_sls_nme = c_sls_nme;
    this.c_insrnc_cmpny_cde = c_insrnc_cmpny_cde;
    this.c_insrnc_cmpny_nme = c_insrnc_cmpny_nme;
    this.c_insrnt_cde = c_insrnt_cde;
    this.c_insrnt_nme = c_insrnt_nme;
    this.c_insrnt_addr = c_insrnt_addr;
    this.c_bnfc_cde = c_bnfc_cde;
    this.c_bnfc_nme = c_bnfc_nme;
    this.c_app_cde = c_app_cde;
    this.c_app_nme = c_app_nme;
    this.c_app_addr = c_app_addr;
    this.c_app_tel = c_app_tel;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_claus_cde = c_claus_cde;
    this.t_app_tm = t_app_tm;
    this.t_insrnc_bgn_tm = t_insrnc_bgn_tm;
    this.t_insrnc_end_tm = t_insrnc_end_tm;
    this.t_sign_tm = t_sign_tm;
    this.c_amt_cur = c_amt_cur;
    this.n_insrnc_vlu = n_insrnc_vlu;
    this.n_amt = n_amt;
    this.n_rate = n_rate;
    this.n_prm = n_prm;
    this.n_rdr_prm = n_rdr_prm;
    this.n_sum_prm = n_sum_prm;
    this.c_prm_cur = c_prm_cur;
    this.n_nclm_prop = n_nclm_prop;
    this.n_appnt_prop = n_appnt_prop;
    this.n_cmm_prop = n_cmm_prop;
    this.n_brk_prop = n_brk_prop;
    this.n_pay_tms = n_pay_tms;
    this.c_appnt = c_appnt;
    this.c_remark = c_remark;
    this.c_crt_prsn = c_crt_prsn;
    this.c_undr_prsn = c_undr_prsn;
    this.t_undr_tm = t_undr_tm;
    this.c_rinsrnc_mrk = c_rinsrnc_mrk;
    this.c_coinsrnc_mrk = c_coinsrnc_mrk;
    this.t_input_tm = t_input_tm;
    this.c_undr_dpt = c_undr_dpt;
    this.c_opr_typ = c_opr_typ;
    this.c_edr_prj_no = c_edr_prj_no;
    this.t_next_edr_undr_tm = t_next_edr_undr_tm;
    this.c_udr_mrk = c_udr_mrk;
    this.c_agelong_mrk = c_agelong_mrk;
    this.c_ceprn_mrk = c_ceprn_mrk;
    this.c_salegrp_cde = c_salegrp_cde;
    this.c_open_cover_no = c_open_cover_no;
    this.c_internet_typ = c_internet_typ;
    this.c_crgo_cde = c_crgo_cde;
    this.c_crgo_desc = c_crgo_desc;
    this.c_invc_no = c_invc_no;
    this.c_sail_no = c_sail_no;
    this.c_prn_frm = c_prn_frm;
    this.c_carriage_cde = c_carriage_cde;
    this.c_vsl_lvl_cde = c_vsl_lvl_cde;
    this.c_from_prt = c_from_prt;
    this.c_to_prt = c_to_prt;
    this.c_frm_prt_ara = c_frm_prt_ara;
    this.c_to_prt_ara = c_to_prt_ara;
    this.c_pass_prt = c_pass_prt;
    this.c_srvy_cde = c_srvy_cde;
    this.c_srvy_cnm = c_srvy_cnm;
    this.c_undr_cndtn = c_undr_cndtn;
    this.c_pay_addr = c_pay_addr;
    this.c_receipt_no = c_receipt_no;
    this.c_crgo_cls = c_crgo_cls;
    this.c_crgo_name = c_crgo_name;
    this.c_amount = c_amount;
    this.c_pack_cde = c_pack_cde;
    this.c_pack_cnm = c_pack_cnm;
    this.c_mark = c_mark;
    this.n_invc_amt = n_invc_amt;
    this.c_invc_amt_cur = c_invc_amt_cur;
    this.c_no_repay = c_no_repay;
    this.c_credit_id = c_credit_id;
    this.c_lost_desc = c_lost_desc;
    this.c_container = c_container;
    this.c_add_risk = c_add_risk;
    this.c_main_insurance = c_main_insurance;
    this.c_add_insurance = c_add_insurance;
    this.c_rdr_cde = c_rdr_cde;
    this.c_rdr_nme = c_rdr_nme;
    this.c_rmk_desc = c_rmk_desc;
    this.c_province = c_province;
    this.c_city = c_city;
    this.c_place = c_place;
    this.c_contact_name = c_contact_name;
    this.c_contact_phone = c_contact_phone;
    this.c_contact_fax = c_contact_fax;
    this.c_contact_email = c_contact_email;
    this.c_pay_mde_cde = c_pay_mde_cde;
    this.c_site_cde = c_site_cde;
    this.c_zip_cde = c_zip_cde;
    this.c_srvy_addr = c_srvy_addr;
    this.c_edr_info = c_edr_info;
    this.c_mdfy_tm = c_mdfy_tm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.PlcyAppInfoHelper.insert(any, this);
    return any.toString();
  }
}
