package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.CaseRptInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/CaseRptInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::CaseRptInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/CaseRptInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct CaseRptInfo {
      string c_ply_no;
      string c_rpt_no;
      string c_clm_no;
      wstring c_insrnt_nme;
      string c_insrnt_cde;
      wstring c_insrnc_tgt;
      wstring c_rpt_nme;
      string c_srs_case_mrk;
      wstring c_rpt_addr_tel;
      string t_rtp_tm;
      string t_accdnt_tm;
      wstring c_accdnt_spot;
      wstring c_accdnt_caus;
      wstring c_los_dtl;
      string c_cur_typ;
      double n_rpt_amt;
      string c_insrnc_cde;
      string c_rcvr_cde;
      wstring c_opinion;
      wstring c_remark;
      wstring c_tgt_los_dtl;
      wstring c_hlp_exp;
      wstring c_thd_los;
      wstring c_clm_prcs_dtl;
      wstring c_srs_case_opinion;
      string c_dpt_cde;
      string t_rpt_mdfy_tm;
      string c_prcs_dpt_cde;
      string c_rpt_rgst_cde;
      string t_insrnc_bgn_tm;
      string t_insrnc_end_tm;
      double n_amt;
      string c_amt_cur;
      string c_car_no;
      string c_lcn_no;
      string c_brnd_cde;
      string c_eng_no;
      wstring c_accdnt_dtl;
      string c_rpt_prcs_mrk;
      wstring c_brnd_cnm;
      string c_internet_typ;
      string c_prt_dcn_no;
      string c_srvy_mrk;
      string c_agencysrvy_mrk;
      string c_insrnc_cls;
      string t_rpt_rgst_tm;
      string c_clm_rgst_mrk;
    };
</pre>
</p>
*/
final public class CaseRptInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.CaseRptInfo value;
  public CaseRptInfoHolder() {
  }
  public CaseRptInfoHolder(com.mcip.nia.orb.CaseRptInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.CaseRptInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.CaseRptInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.CaseRptInfoHelper.type();
  }
}
