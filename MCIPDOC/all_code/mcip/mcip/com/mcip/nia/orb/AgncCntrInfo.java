package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.AgncCntrInfo
<li> <b>Source File</b> com/mcip/nia/orb/AgncCntrInfo.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::AgncCntrInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/AgncCntrInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct AgncCntrInfo {
      string c_agt_agr_no;
      long n_sub_co_no;
      string c_auth_mrk;
      string c_co_mrk;
      string c_per_org_mrk;
      string c_udr_mrk;
      string c_clnt_cde;
      wstring c_clnt_nme;
      string c_dpt_cde;
      string t_effc_tm;
      string t_co_strt_tm;
      string t_co_end_tm;
      string c_sls_cde;
      wstring c_co_cnt;
      wstring c_undr_prsn;
      string c_insrnc_cde;
      string c_crgo_cde;
      double n_rate;
      double n_nclm_prop;
      double n_appnt_prop;
      double n_cmm_prop;
      double n_min_prm_prop;
      double n_max_amt_prop;
    };
</pre>
</p>
*/
final public class AgncCntrInfo {
  public java.lang.String c_agt_agr_no;
  public int n_sub_co_no;
  public java.lang.String c_auth_mrk;
  public java.lang.String c_co_mrk;
  public java.lang.String c_per_org_mrk;
  public java.lang.String c_udr_mrk;
  public java.lang.String c_clnt_cde;
  public java.lang.String c_clnt_nme;
  public java.lang.String c_dpt_cde;
  public java.lang.String t_effc_tm;
  public java.lang.String t_co_strt_tm;
  public java.lang.String t_co_end_tm;
  public java.lang.String c_sls_cde;
  public java.lang.String c_co_cnt;
  public java.lang.String c_undr_prsn;
  public java.lang.String c_insrnc_cde;
  public java.lang.String c_crgo_cde;
  public double n_rate;
  public double n_nclm_prop;
  public double n_appnt_prop;
  public double n_cmm_prop;
  public double n_min_prm_prop;
  public double n_max_amt_prop;
  public AgncCntrInfo() {
  }
  public AgncCntrInfo(
    java.lang.String c_agt_agr_no,
    int n_sub_co_no,
    java.lang.String c_auth_mrk,
    java.lang.String c_co_mrk,
    java.lang.String c_per_org_mrk,
    java.lang.String c_udr_mrk,
    java.lang.String c_clnt_cde,
    java.lang.String c_clnt_nme,
    java.lang.String c_dpt_cde,
    java.lang.String t_effc_tm,
    java.lang.String t_co_strt_tm,
    java.lang.String t_co_end_tm,
    java.lang.String c_sls_cde,
    java.lang.String c_co_cnt,
    java.lang.String c_undr_prsn,
    java.lang.String c_insrnc_cde,
    java.lang.String c_crgo_cde,
    double n_rate,
    double n_nclm_prop,
    double n_appnt_prop,
    double n_cmm_prop,
    double n_min_prm_prop,
    double n_max_amt_prop
  ) {
    this.c_agt_agr_no = c_agt_agr_no;
    this.n_sub_co_no = n_sub_co_no;
    this.c_auth_mrk = c_auth_mrk;
    this.c_co_mrk = c_co_mrk;
    this.c_per_org_mrk = c_per_org_mrk;
    this.c_udr_mrk = c_udr_mrk;
    this.c_clnt_cde = c_clnt_cde;
    this.c_clnt_nme = c_clnt_nme;
    this.c_dpt_cde = c_dpt_cde;
    this.t_effc_tm = t_effc_tm;
    this.t_co_strt_tm = t_co_strt_tm;
    this.t_co_end_tm = t_co_end_tm;
    this.c_sls_cde = c_sls_cde;
    this.c_co_cnt = c_co_cnt;
    this.c_undr_prsn = c_undr_prsn;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_crgo_cde = c_crgo_cde;
    this.n_rate = n_rate;
    this.n_nclm_prop = n_nclm_prop;
    this.n_appnt_prop = n_appnt_prop;
    this.n_cmm_prop = n_cmm_prop;
    this.n_min_prm_prop = n_min_prm_prop;
    this.n_max_amt_prop = n_max_amt_prop;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.AgncCntrInfoHelper.insert(any, this);
    return any.toString();
  }
}
