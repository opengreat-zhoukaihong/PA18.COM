package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.OpenCoverInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/OpenCoverInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::OpenCoverInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/OpenCoverInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct OpenCoverInfo {
      string c_open_cover_no;
      string c_auth_mrk;
      string c_udr_mrk;
      string c_dpt_cde;
      string t_effc_tm;
      string t_co_strt_tm;
      string t_co_end_tm;
      wstring c_undr_prsn;
      string c_insrnc_cde;
      string c_sls_cde;
      double n_rate;
      string c_insrnt_cde;
      wstring c_insrnt_nme;
      string c_app_cde;
      wstring c_app_nme;
      wstring c_crt_prsn;
      string t_undr_tm;
      string c_ara_cde;
      wstring c_province;
      wstring c_city;
      wstring c_place;
      wstring c_contact_name;
      string c_contact_phone;
      string c_contact_fax;
      wstring c_contact_email;
      string c_need_ply_no;
      string c_need_change;
      wstring c_undr_cndtn;
      wstring c_no_repay_desc;
      string n_busi_amt;
      string c_busi_cur;
      wstring c_bus_feather;
      string c_srvy_cde;
      wstring c_srvy_cnm;
      wstring c_pay_addr;
      string c_carriage_cde;
      wstring c_from_prt;
      wstring c_to_prt;
      string c_frm_prt_ara;
      string c_to_prt_ara;
      wstring c_pass_prt;
      string c_crgo_cls;
      string c_crgo_cde;
      wstring c_crgo_name;
      string c_amount;
      string c_pack_cde;
      wstring c_pack_cnm;
      wstring c_mark;
    };
</pre>
</p>
*/
abstract public class OpenCoverInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.OpenCoverInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.OpenCoverInfo result = new com.mcip.nia.orb.OpenCoverInfo();
    result.c_open_cover_no = _input.read_string();
    result.c_auth_mrk = _input.read_string();
    result.c_udr_mrk = _input.read_string();
    result.c_dpt_cde = _input.read_string();
    result.t_effc_tm = _input.read_string();
    result.t_co_strt_tm = _input.read_string();
    result.t_co_end_tm = _input.read_string();
    result.c_undr_prsn = _input.read_wstring();
    result.c_insrnc_cde = _input.read_string();
    result.c_sls_cde = _input.read_string();
    result.n_rate = _input.read_double();
    result.c_insrnt_cde = _input.read_string();
    result.c_insrnt_nme = _input.read_wstring();
    result.c_app_cde = _input.read_string();
    result.c_app_nme = _input.read_wstring();
    result.c_crt_prsn = _input.read_wstring();
    result.t_undr_tm = _input.read_string();
    result.c_ara_cde = _input.read_string();
    result.c_province = _input.read_wstring();
    result.c_city = _input.read_wstring();
    result.c_place = _input.read_wstring();
    result.c_contact_name = _input.read_wstring();
    result.c_contact_phone = _input.read_string();
    result.c_contact_fax = _input.read_string();
    result.c_contact_email = _input.read_wstring();
    result.c_need_ply_no = _input.read_string();
    result.c_need_change = _input.read_string();
    result.c_undr_cndtn = _input.read_wstring();
    result.c_no_repay_desc = _input.read_wstring();
    result.n_busi_amt = _input.read_string();
    result.c_busi_cur = _input.read_string();
    result.c_bus_feather = _input.read_wstring();
    result.c_srvy_cde = _input.read_string();
    result.c_srvy_cnm = _input.read_wstring();
    result.c_pay_addr = _input.read_wstring();
    result.c_carriage_cde = _input.read_string();
    result.c_from_prt = _input.read_wstring();
    result.c_to_prt = _input.read_wstring();
    result.c_frm_prt_ara = _input.read_string();
    result.c_to_prt_ara = _input.read_string();
    result.c_pass_prt = _input.read_wstring();
    result.c_crgo_cls = _input.read_string();
    result.c_crgo_cde = _input.read_string();
    result.c_crgo_name = _input.read_wstring();
    result.c_amount = _input.read_string();
    result.c_pack_cde = _input.read_string();
    result.c_pack_cnm = _input.read_wstring();
    result.c_mark = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.OpenCoverInfo value) {
    _output.write_string(value.c_open_cover_no);
    _output.write_string(value.c_auth_mrk);
    _output.write_string(value.c_udr_mrk);
    _output.write_string(value.c_dpt_cde);
    _output.write_string(value.t_effc_tm);
    _output.write_string(value.t_co_strt_tm);
    _output.write_string(value.t_co_end_tm);
    _output.write_wstring(value.c_undr_prsn);
    _output.write_string(value.c_insrnc_cde);
    _output.write_string(value.c_sls_cde);
    _output.write_double(value.n_rate);
    _output.write_string(value.c_insrnt_cde);
    _output.write_wstring(value.c_insrnt_nme);
    _output.write_string(value.c_app_cde);
    _output.write_wstring(value.c_app_nme);
    _output.write_wstring(value.c_crt_prsn);
    _output.write_string(value.t_undr_tm);
    _output.write_string(value.c_ara_cde);
    _output.write_wstring(value.c_province);
    _output.write_wstring(value.c_city);
    _output.write_wstring(value.c_place);
    _output.write_wstring(value.c_contact_name);
    _output.write_string(value.c_contact_phone);
    _output.write_string(value.c_contact_fax);
    _output.write_wstring(value.c_contact_email);
    _output.write_string(value.c_need_ply_no);
    _output.write_string(value.c_need_change);
    _output.write_wstring(value.c_undr_cndtn);
    _output.write_wstring(value.c_no_repay_desc);
    _output.write_string(value.n_busi_amt);
    _output.write_string(value.c_busi_cur);
    _output.write_wstring(value.c_bus_feather);
    _output.write_string(value.c_srvy_cde);
    _output.write_wstring(value.c_srvy_cnm);
    _output.write_wstring(value.c_pay_addr);
    _output.write_string(value.c_carriage_cde);
    _output.write_wstring(value.c_from_prt);
    _output.write_wstring(value.c_to_prt);
    _output.write_string(value.c_frm_prt_ara);
    _output.write_string(value.c_to_prt_ara);
    _output.write_wstring(value.c_pass_prt);
    _output.write_string(value.c_crgo_cls);
    _output.write_string(value.c_crgo_cde);
    _output.write_wstring(value.c_crgo_name);
    _output.write_string(value.c_amount);
    _output.write_string(value.c_pack_cde);
    _output.write_wstring(value.c_pack_cnm);
    _output.write_wstring(value.c_mark);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.OpenCoverInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.OpenCoverInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[48];
      members[0] = new org.omg.CORBA.StructMember("c_open_cover_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_auth_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("c_udr_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[4] = new org.omg.CORBA.StructMember("t_effc_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("t_co_strt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[6] = new org.omg.CORBA.StructMember("t_co_end_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[7] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("c_sls_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[10] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[11] = new org.omg.CORBA.StructMember("c_insrnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[12] = new org.omg.CORBA.StructMember("c_insrnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[13] = new org.omg.CORBA.StructMember("c_app_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[14] = new org.omg.CORBA.StructMember("c_app_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[15] = new org.omg.CORBA.StructMember("c_crt_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[16] = new org.omg.CORBA.StructMember("t_undr_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[17] = new org.omg.CORBA.StructMember("c_ara_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[18] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[19] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[20] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[21] = new org.omg.CORBA.StructMember("c_contact_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[22] = new org.omg.CORBA.StructMember("c_contact_phone", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[23] = new org.omg.CORBA.StructMember("c_contact_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[24] = new org.omg.CORBA.StructMember("c_contact_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_need_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[26] = new org.omg.CORBA.StructMember("c_need_change", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[27] = new org.omg.CORBA.StructMember("c_undr_cndtn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[28] = new org.omg.CORBA.StructMember("c_no_repay_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[29] = new org.omg.CORBA.StructMember("n_busi_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[30] = new org.omg.CORBA.StructMember("c_busi_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[31] = new org.omg.CORBA.StructMember("c_bus_feather", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[32] = new org.omg.CORBA.StructMember("c_srvy_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[33] = new org.omg.CORBA.StructMember("c_srvy_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[34] = new org.omg.CORBA.StructMember("c_pay_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[35] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[36] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[37] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[38] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[39] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[40] = new org.omg.CORBA.StructMember("c_pass_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[41] = new org.omg.CORBA.StructMember("c_crgo_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[42] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[43] = new org.omg.CORBA.StructMember("c_crgo_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[44] = new org.omg.CORBA.StructMember("c_amount", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[45] = new org.omg.CORBA.StructMember("c_pack_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[46] = new org.omg.CORBA.StructMember("c_pack_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[47] = new org.omg.CORBA.StructMember("c_mark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "OpenCoverInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/OpenCoverInfo:1.0";
  }
}
