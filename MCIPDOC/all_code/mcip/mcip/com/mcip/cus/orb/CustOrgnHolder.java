package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustOrgnHolder
<li> <b>Source File</b> com/mcip/cus/orb/CustOrgnHolder.java
<li> <b>IDL Source File</b> custInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cus::orb::CustOrgn
<li> <b>Repository Identifier</b> IDL:com/mcip/cus/orb/CustOrgn:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cus/orb"
    struct CustOrgn {
      string c_clnt_cde;
      string c_dpt_cde;
      long n_clnt_grp_cde;
      string c_clnt_mrk;
      wstring c_clnt_nme;
      wstring c_chn_abr;
      string c_auth_mrk;
      string c_scale_cde;
      string c_clnt_scle_cde;
      string c_orgz_typ_cde;
      wstring c_brd_enm;
      wstring c_eng_abr;
      string c_ownership_cde;
      string c_rgst_no;
      string c_tax_no;
      double n_rgst_mny;
      wstring c_chief;
      long n_emly_num;
      string c_trd_cde;
      string c_upr_dpt_cde;
      string c_impt_clnt_cde;
      wstring c_cntct_prsn_nme;
      string c_tel;
      string c_fax;
      wstring c_email;
      wstring c_clnt_addr;
      string c_ara_cde;
      wstring c_province;
      wstring c_city;
      wstring c_place;
      string c_zip_cde;
      wstring c_bank;
      string c_accnt_no;
      wstring c_remark;
      string t_upd_tm;
    };
</pre>
</p>
*/
final public class CustOrgnHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cus.orb.CustOrgn value;
  public CustOrgnHolder() {
  }
  public CustOrgnHolder(com.mcip.cus.orb.CustOrgn value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cus.orb.CustOrgnHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cus.orb.CustOrgnHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.cus.orb.CustOrgnHelper.type();
  }
}
