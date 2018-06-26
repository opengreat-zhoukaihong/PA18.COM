package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyPlyAppNetInfoHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlyPlyAppNetInfoHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyPlyAppNetInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyPlyAppNetInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyPlyAppNetInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_ply_app_no;
      wstring n_user_seq_no;
      wstring t_freeback_tm;
      wstring t_print_tm;
      wstring c_province;
      wstring c_city;
      wstring c_place;
      wstring c_contact_name;
      wstring c_contact_phone;
      wstring c_contact_fax;
      wstring c_contact_email;
      wstring c_site_cde;
      wstring c_rec_no;
      wstring c_send_flag;
      wstring c_send_emp_cde;
      wstring c_prt_emp_cde;
      wstring t_send_tm;
      wstring t_sended_tm;
      wstring c_zip_cde;
      wstring c_pay_flag;
      wstring c_session_id;
      wstring c_bank_cde;
      wstring c_bank_cnm;
      wstring c_bank_accnt;
      wstring n_got_prm;
      wstring c_cur_typ;
      wstring t_pay_tm;
      wstring c_pay_typ;
      wstring c_pay_cde;
    };
</pre>
</p>
*/
final public class PlyPlyAppNetInfoHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlyPlyAppNetInfo value;
  public PlyPlyAppNetInfoHolder() {
  }
  public PlyPlyAppNetInfoHolder(com.mcip.nia.orb.PlyPlyAppNetInfo value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlyPlyAppNetInfoHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlyPlyAppNetInfoHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlyPlyAppNetInfoHelper.type();
  }
}
