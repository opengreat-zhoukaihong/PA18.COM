package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrAppInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrAppInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrAppInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_edr_app_no;
      wstring c_edr_no;
      wstring c_ply_no;
      wstring c_edr_typ;
      wstring c_app_prsn_no;
      wstring c_app_prsn_nme;
      wstring c_app_prsn_addr;
      wstring c_app_prsn_tel;
      wstring t_edr_app_tm;
      wstring c_edr_rsn;
      wstring c_edr_ctnt;
      wstring n_amt_var;
      wstring n_prm_var;
      wstring n_nclm_amt;
      wstring n_appnt_amt;
      wstring n_ndis_amt;
      wstring n_nnclm_amt;
      wstring c_orig_ply_no;
      wstring c_dpt_cde;
      wstring c_bsns_typ;
      wstring c_cmpny_agt_cde;
      wstring n_sub_co_no;
      wstring c_agt_agr_no;
      wstring c_brkr_cde;
      wstring c_sls_cde;
      wstring c_insrnc_cmpny_cde;
      wstring c_insrnt_cde;
      wstring c_insrnt_nme;
      wstring c_insrnt_addr;
      wstring c_bnfc_cde;
      wstring c_bnfc_nme;
      wstring c_app_cde;
      wstring c_app_nme;
      wstring c_app_addr;
      wstring c_app_tel;
      wstring c_insrnc_cde;
      wstring c_claus_cde;
      wstring t_app_tm;
      wstring t_insrnc_bgn_tm;
      wstring t_insrnc_end_tm;
      wstring t_sign_tm;
      wstring c_amt_cur;
      wstring n_insrnc_vlu;
      wstring n_amt;
      wstring n_rate;
      wstring n_prm;
      wstring n_rdr_prm;
      wstring n_sum_prm;
      wstring c_prm_cur;
      wstring n_nclm_prop;
      wstring n_appnt_prop;
      wstring n_cmm_prop;
      wstring n_brk_prop;
      wstring n_pay_tms;
      wstring c_appnt;
      wstring c_remark;
      wstring c_crt_prsn;
      wstring c_undr_prsn;
      wstring t_undr_tm;
      wstring c_rinsrnc_mrk;
      wstring c_coinsrnc_mrk;
      wstring t_input_tm;
      wstring c_undr_dpt;
      wstring c_opr_typ;
      wstring c_edr_prj_no;
      wstring t_next_edr_undr_tm;
      wstring c_dpt_cnm;
      wstring c_insrnc_cnm;
      wstring c_undr_prsn_cnm;
      wstring c_undr_dpt_cnm;
      wstring c_crt_prsn_cnm;
      wstring c_sls_nme;
      wstring c_cmpny_agt_nme;
      wstring c_amt_cur_cnm;
      wstring c_agelong_mrk;
      wstring c_ceprn_mrk;
      wstring c_udr_mrk;
      wstring c_salegrp_cde;
      wstring n_got_prm;
      wstring c_sum_nclm;
      wstring c_zip_cde;
      wstring c_sttl;
      wstring c_ratio;
      wstring c_cntct_prsn_nme;
      wstring c_app_typ;
      wstring c_query_mrk;
      wstring c_fst_undr_prsn;
      wstring c_fst_opn;
      wstring c_chk_prsn;
      wstring c_chk_rec;
      wstring c_chk_tm;
      wstring c_fst_undr_tm;
      wstring n_save_amt_var;
      wstring c_open_cover_no;
      wstring c_internet_typ;
    };
</pre>
</p>
*/
final public class PlyEdrAppInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyEdrAppInfo value;
  public PlyEdrAppInfoHolder() {
  }
  public PlyEdrAppInfoHolder(com.mcip.nia.orb.PlyEdrAppInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyEdrAppInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyEdrAppInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlyEdrAppInfoHelper.type();
  }
}
