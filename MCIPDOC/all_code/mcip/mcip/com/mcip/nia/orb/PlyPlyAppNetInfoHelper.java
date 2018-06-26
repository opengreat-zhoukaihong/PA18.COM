package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyPlyAppNetInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/PlyPlyAppNetInfoHelper.java
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
abstract public class PlyPlyAppNetInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PlyPlyAppNetInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PlyPlyAppNetInfo result = new com.mcip.nia.orb.PlyPlyAppNetInfo();
    result.c_crt_cde = _input.read_wstring();
    result.c_crt_tm = _input.read_wstring();
    result.c_upd_cde = _input.read_wstring();
    result.c_upd_tm = _input.read_wstring();
    result.c_ply_app_no = _input.read_wstring();
    result.n_user_seq_no = _input.read_wstring();
    result.t_freeback_tm = _input.read_wstring();
    result.t_print_tm = _input.read_wstring();
    result.c_province = _input.read_wstring();
    result.c_city = _input.read_wstring();
    result.c_place = _input.read_wstring();
    result.c_contact_name = _input.read_wstring();
    result.c_contact_phone = _input.read_wstring();
    result.c_contact_fax = _input.read_wstring();
    result.c_contact_email = _input.read_wstring();
    result.c_site_cde = _input.read_wstring();
    result.c_rec_no = _input.read_wstring();
    result.c_send_flag = _input.read_wstring();
    result.c_send_emp_cde = _input.read_wstring();
    result.c_prt_emp_cde = _input.read_wstring();
    result.t_send_tm = _input.read_wstring();
    result.t_sended_tm = _input.read_wstring();
    result.c_zip_cde = _input.read_wstring();
    result.c_pay_flag = _input.read_wstring();
    result.c_session_id = _input.read_wstring();
    result.c_bank_cde = _input.read_wstring();
    result.c_bank_cnm = _input.read_wstring();
    result.c_bank_accnt = _input.read_wstring();
    result.n_got_prm = _input.read_wstring();
    result.c_cur_typ = _input.read_wstring();
    result.t_pay_tm = _input.read_wstring();
    result.c_pay_typ = _input.read_wstring();
    result.c_pay_cde = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PlyPlyAppNetInfo value) {
    _output.write_wstring(value.c_crt_cde);
    _output.write_wstring(value.c_crt_tm);
    _output.write_wstring(value.c_upd_cde);
    _output.write_wstring(value.c_upd_tm);
    _output.write_wstring(value.c_ply_app_no);
    _output.write_wstring(value.n_user_seq_no);
    _output.write_wstring(value.t_freeback_tm);
    _output.write_wstring(value.t_print_tm);
    _output.write_wstring(value.c_province);
    _output.write_wstring(value.c_city);
    _output.write_wstring(value.c_place);
    _output.write_wstring(value.c_contact_name);
    _output.write_wstring(value.c_contact_phone);
    _output.write_wstring(value.c_contact_fax);
    _output.write_wstring(value.c_contact_email);
    _output.write_wstring(value.c_site_cde);
    _output.write_wstring(value.c_rec_no);
    _output.write_wstring(value.c_send_flag);
    _output.write_wstring(value.c_send_emp_cde);
    _output.write_wstring(value.c_prt_emp_cde);
    _output.write_wstring(value.t_send_tm);
    _output.write_wstring(value.t_sended_tm);
    _output.write_wstring(value.c_zip_cde);
    _output.write_wstring(value.c_pay_flag);
    _output.write_wstring(value.c_session_id);
    _output.write_wstring(value.c_bank_cde);
    _output.write_wstring(value.c_bank_cnm);
    _output.write_wstring(value.c_bank_accnt);
    _output.write_wstring(value.n_got_prm);
    _output.write_wstring(value.c_cur_typ);
    _output.write_wstring(value.t_pay_tm);
    _output.write_wstring(value.c_pay_typ);
    _output.write_wstring(value.c_pay_cde);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PlyPlyAppNetInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PlyPlyAppNetInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[33];
      members[0] = new org.omg.CORBA.StructMember("c_crt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_upd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_ply_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("n_user_seq_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("t_freeback_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[7] = new org.omg.CORBA.StructMember("t_print_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[9] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[10] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[11] = new org.omg.CORBA.StructMember("c_contact_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[12] = new org.omg.CORBA.StructMember("c_contact_phone", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[13] = new org.omg.CORBA.StructMember("c_contact_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[14] = new org.omg.CORBA.StructMember("c_contact_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[15] = new org.omg.CORBA.StructMember("c_site_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[16] = new org.omg.CORBA.StructMember("c_rec_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[17] = new org.omg.CORBA.StructMember("c_send_flag", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[18] = new org.omg.CORBA.StructMember("c_send_emp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[19] = new org.omg.CORBA.StructMember("c_prt_emp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[20] = new org.omg.CORBA.StructMember("t_send_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[21] = new org.omg.CORBA.StructMember("t_sended_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[22] = new org.omg.CORBA.StructMember("c_zip_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[23] = new org.omg.CORBA.StructMember("c_pay_flag", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[24] = new org.omg.CORBA.StructMember("c_session_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_bank_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[26] = new org.omg.CORBA.StructMember("c_bank_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[27] = new org.omg.CORBA.StructMember("c_bank_accnt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[28] = new org.omg.CORBA.StructMember("n_got_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[29] = new org.omg.CORBA.StructMember("c_cur_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[30] = new org.omg.CORBA.StructMember("t_pay_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[31] = new org.omg.CORBA.StructMember("c_pay_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[32] = new org.omg.CORBA.StructMember("c_pay_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "PlyPlyAppNetInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PlyPlyAppNetInfo:1.0";
  }
}
