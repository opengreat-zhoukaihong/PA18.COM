package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustOrgn
<li> <b>Source File</b> com/mcip/cus/orb/CustOrgn.java
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
final public class CustOrgn {
  public java.lang.String c_clnt_cde;
  public java.lang.String c_dpt_cde;
  public int n_clnt_grp_cde;
  public java.lang.String c_clnt_mrk;
  public java.lang.String c_clnt_nme;
  public java.lang.String c_chn_abr;
  public java.lang.String c_auth_mrk;
  public java.lang.String c_scale_cde;
  public java.lang.String c_clnt_scle_cde;
  public java.lang.String c_orgz_typ_cde;
  public java.lang.String c_brd_enm;
  public java.lang.String c_eng_abr;
  public java.lang.String c_ownership_cde;
  public java.lang.String c_rgst_no;
  public java.lang.String c_tax_no;
  public double n_rgst_mny;
  public java.lang.String c_chief;
  public int n_emly_num;
  public java.lang.String c_trd_cde;
  public java.lang.String c_upr_dpt_cde;
  public java.lang.String c_impt_clnt_cde;
  public java.lang.String c_cntct_prsn_nme;
  public java.lang.String c_tel;
  public java.lang.String c_fax;
  public java.lang.String c_email;
  public java.lang.String c_clnt_addr;
  public java.lang.String c_ara_cde;
  public java.lang.String c_province;
  public java.lang.String c_city;
  public java.lang.String c_place;
  public java.lang.String c_zip_cde;
  public java.lang.String c_bank;
  public java.lang.String c_accnt_no;
  public java.lang.String c_remark;
  public java.lang.String t_upd_tm;
  public CustOrgn() {
  }
  public CustOrgn(
    java.lang.String c_clnt_cde,
    java.lang.String c_dpt_cde,
    int n_clnt_grp_cde,
    java.lang.String c_clnt_mrk,
    java.lang.String c_clnt_nme,
    java.lang.String c_chn_abr,
    java.lang.String c_auth_mrk,
    java.lang.String c_scale_cde,
    java.lang.String c_clnt_scle_cde,
    java.lang.String c_orgz_typ_cde,
    java.lang.String c_brd_enm,
    java.lang.String c_eng_abr,
    java.lang.String c_ownership_cde,
    java.lang.String c_rgst_no,
    java.lang.String c_tax_no,
    double n_rgst_mny,
    java.lang.String c_chief,
    int n_emly_num,
    java.lang.String c_trd_cde,
    java.lang.String c_upr_dpt_cde,
    java.lang.String c_impt_clnt_cde,
    java.lang.String c_cntct_prsn_nme,
    java.lang.String c_tel,
    java.lang.String c_fax,
    java.lang.String c_email,
    java.lang.String c_clnt_addr,
    java.lang.String c_ara_cde,
    java.lang.String c_province,
    java.lang.String c_city,
    java.lang.String c_place,
    java.lang.String c_zip_cde,
    java.lang.String c_bank,
    java.lang.String c_accnt_no,
    java.lang.String c_remark,
    java.lang.String t_upd_tm
  ) {
    this.c_clnt_cde = c_clnt_cde;
    this.c_dpt_cde = c_dpt_cde;
    this.n_clnt_grp_cde = n_clnt_grp_cde;
    this.c_clnt_mrk = c_clnt_mrk;
    this.c_clnt_nme = c_clnt_nme;
    this.c_chn_abr = c_chn_abr;
    this.c_auth_mrk = c_auth_mrk;
    this.c_scale_cde = c_scale_cde;
    this.c_clnt_scle_cde = c_clnt_scle_cde;
    this.c_orgz_typ_cde = c_orgz_typ_cde;
    this.c_brd_enm = c_brd_enm;
    this.c_eng_abr = c_eng_abr;
    this.c_ownership_cde = c_ownership_cde;
    this.c_rgst_no = c_rgst_no;
    this.c_tax_no = c_tax_no;
    this.n_rgst_mny = n_rgst_mny;
    this.c_chief = c_chief;
    this.n_emly_num = n_emly_num;
    this.c_trd_cde = c_trd_cde;
    this.c_upr_dpt_cde = c_upr_dpt_cde;
    this.c_impt_clnt_cde = c_impt_clnt_cde;
    this.c_cntct_prsn_nme = c_cntct_prsn_nme;
    this.c_tel = c_tel;
    this.c_fax = c_fax;
    this.c_email = c_email;
    this.c_clnt_addr = c_clnt_addr;
    this.c_ara_cde = c_ara_cde;
    this.c_province = c_province;
    this.c_city = c_city;
    this.c_place = c_place;
    this.c_zip_cde = c_zip_cde;
    this.c_bank = c_bank;
    this.c_accnt_no = c_accnt_no;
    this.c_remark = c_remark;
    this.t_upd_tm = t_upd_tm;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.cus.orb.CustOrgnHelper.insert(any, this);
    return any.toString();
  }
}
