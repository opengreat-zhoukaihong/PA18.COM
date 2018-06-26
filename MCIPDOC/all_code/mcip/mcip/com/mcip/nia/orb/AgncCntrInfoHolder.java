package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.AgncCntrInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/AgncCntrInfoHolder.java
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
final public class AgncCntrInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.AgncCntrInfo value;
  public AgncCntrInfoHolder() {
  }
  public AgncCntrInfoHolder(com.mcip.nia.orb.AgncCntrInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.AgncCntrInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.AgncCntrInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.AgncCntrInfoHelper.type();
  }
}
