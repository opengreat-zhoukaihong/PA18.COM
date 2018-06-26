package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustPrsnHolder
<li> <b>Source File</b> com/mcip/cus/orb/CustPrsnHolder.java
<li> <b>IDL Source File</b> custInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cus::orb::CustPrsn
<li> <b>Repository Identifier</b> IDL:com/mcip/cus/orb/CustPrsn:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cus/orb"
    struct CustPrsn {
      string c_clnt_cde;
      string c_dpt_cde;
      long n_clnt_grp_cde;
      string c_clnt_mrk;
      wstring c_clnt_nme;
      wstring c_chn_abr;
      string c_auth_mrk;
      wstring c_brd_enm;
      wstring c_eng_abr;
      string c_rgst_no;
      string c_sex;
      wstring c_hmtwn;
      string c_ntn_cde;
      string t_birthday;
      string c_mrg_cde;
      wstring c_grdt;
      string c_major_cde;
      string c_edu_cde;
      wstring c_work_dpt;
      string c_title_cde;
      string c_duty;
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
      string c_impt_clnt_cde;
      string t_upd_tm;
    };
</pre>
</p>
*/
final public class CustPrsnHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cus.orb.CustPrsn value;
  public CustPrsnHolder() {
  }
  public CustPrsnHolder(com.mcip.cus.orb.CustPrsn value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cus.orb.CustPrsnHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cus.orb.CustPrsnHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.cus.orb.CustPrsnHelper.type();
  }
}
