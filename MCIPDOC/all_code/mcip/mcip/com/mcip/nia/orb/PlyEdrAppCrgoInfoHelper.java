package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppCrgoInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrAppCrgoInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrAppCrgoInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrAppCrgoInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_edr_app_no;
      wstring c_crgo_cde;
      wstring c_crgo_cnm;
      wstring c_crgo_desc;
      wstring c_invc_no;
      wstring c_sail_no;
      wstring c_prn_frm;
      wstring c_carriage_cde;
      wstring c_vsl_lvl_cde;
      wstring c_from_prt;
      wstring c_to_prt;
      wstring c_frm_prt_ara;
      wstring c_to_prt_ara;
      wstring c_pass_prt;
      wstring c_srvy_cde;
      wstring c_srvy_cnm;
      wstring c_undr_cndtn;
      wstring n_amt;
      wstring n_rate;
      wstring n_prm;
      wstring c_pay_addr;
      wstring c_rec_no;
      wstring c_receipt_no;
      wstring c_crgo_cls;
      wstring c_crgo_name;
      wstring c_amount;
      wstring c_pack_cde;
      wstring c_mark;
      wstring n_invc_amt;
      wstring c_invc_amt_cur;
      wstring c_no_repay;
      wstring c_credit_id;
      wstring c_lost_desc;
      wstring c_container;
      wstring c_add_risk;
      wstring c_pack_cnm;
      wstring c_srvy_addr;
      wstring c_edr_info;
    };
</pre>
</p>
*/
abstract public class PlyEdrAppCrgoInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PlyEdrAppCrgoInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PlyEdrAppCrgoInfo result = new com.mcip.nia.orb.PlyEdrAppCrgoInfo();
    result.c_crt_cde = _input.read_wstring();
    result.c_crt_tm = _input.read_wstring();
    result.c_upd_cde = _input.read_wstring();
    result.c_upd_tm = _input.read_wstring();
    result.c_edr_app_no = _input.read_wstring();
    result.c_crgo_cde = _input.read_wstring();
    result.c_crgo_cnm = _input.read_wstring();
    result.c_crgo_desc = _input.read_wstring();
    result.c_invc_no = _input.read_wstring();
    result.c_sail_no = _input.read_wstring();
    result.c_prn_frm = _input.read_wstring();
    result.c_carriage_cde = _input.read_wstring();
    result.c_vsl_lvl_cde = _input.read_wstring();
    result.c_from_prt = _input.read_wstring();
    result.c_to_prt = _input.read_wstring();
    result.c_frm_prt_ara = _input.read_wstring();
    result.c_to_prt_ara = _input.read_wstring();
    result.c_pass_prt = _input.read_wstring();
    result.c_srvy_cde = _input.read_wstring();
    result.c_srvy_cnm = _input.read_wstring();
    result.c_undr_cndtn = _input.read_wstring();
    result.n_amt = _input.read_wstring();
    result.n_rate = _input.read_wstring();
    result.n_prm = _input.read_wstring();
    result.c_pay_addr = _input.read_wstring();
    result.c_rec_no = _input.read_wstring();
    result.c_receipt_no = _input.read_wstring();
    result.c_crgo_cls = _input.read_wstring();
    result.c_crgo_name = _input.read_wstring();
    result.c_amount = _input.read_wstring();
    result.c_pack_cde = _input.read_wstring();
    result.c_mark = _input.read_wstring();
    result.n_invc_amt = _input.read_wstring();
    result.c_invc_amt_cur = _input.read_wstring();
    result.c_no_repay = _input.read_wstring();
    result.c_credit_id = _input.read_wstring();
    result.c_lost_desc = _input.read_wstring();
    result.c_container = _input.read_wstring();
    result.c_add_risk = _input.read_wstring();
    result.c_pack_cnm = _input.read_wstring();
    result.c_srvy_addr = _input.read_wstring();
    result.c_edr_info = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PlyEdrAppCrgoInfo value) {
    _output.write_wstring(value.c_crt_cde);
    _output.write_wstring(value.c_crt_tm);
    _output.write_wstring(value.c_upd_cde);
    _output.write_wstring(value.c_upd_tm);
    _output.write_wstring(value.c_edr_app_no);
    _output.write_wstring(value.c_crgo_cde);
    _output.write_wstring(value.c_crgo_cnm);
    _output.write_wstring(value.c_crgo_desc);
    _output.write_wstring(value.c_invc_no);
    _output.write_wstring(value.c_sail_no);
    _output.write_wstring(value.c_prn_frm);
    _output.write_wstring(value.c_carriage_cde);
    _output.write_wstring(value.c_vsl_lvl_cde);
    _output.write_wstring(value.c_from_prt);
    _output.write_wstring(value.c_to_prt);
    _output.write_wstring(value.c_frm_prt_ara);
    _output.write_wstring(value.c_to_prt_ara);
    _output.write_wstring(value.c_pass_prt);
    _output.write_wstring(value.c_srvy_cde);
    _output.write_wstring(value.c_srvy_cnm);
    _output.write_wstring(value.c_undr_cndtn);
    _output.write_wstring(value.n_amt);
    _output.write_wstring(value.n_rate);
    _output.write_wstring(value.n_prm);
    _output.write_wstring(value.c_pay_addr);
    _output.write_wstring(value.c_rec_no);
    _output.write_wstring(value.c_receipt_no);
    _output.write_wstring(value.c_crgo_cls);
    _output.write_wstring(value.c_crgo_name);
    _output.write_wstring(value.c_amount);
    _output.write_wstring(value.c_pack_cde);
    _output.write_wstring(value.c_mark);
    _output.write_wstring(value.n_invc_amt);
    _output.write_wstring(value.c_invc_amt_cur);
    _output.write_wstring(value.c_no_repay);
    _output.write_wstring(value.c_credit_id);
    _output.write_wstring(value.c_lost_desc);
    _output.write_wstring(value.c_container);
    _output.write_wstring(value.c_add_risk);
    _output.write_wstring(value.c_pack_cnm);
    _output.write_wstring(value.c_srvy_addr);
    _output.write_wstring(value.c_edr_info);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PlyEdrAppCrgoInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PlyEdrAppCrgoInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[42];
      members[0] = new org.omg.CORBA.StructMember("c_crt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_upd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_edr_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("c_crgo_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[7] = new org.omg.CORBA.StructMember("c_crgo_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_invc_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[9] = new org.omg.CORBA.StructMember("c_sail_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[10] = new org.omg.CORBA.StructMember("c_prn_frm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[11] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[12] = new org.omg.CORBA.StructMember("c_vsl_lvl_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[13] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[14] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[15] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[16] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[17] = new org.omg.CORBA.StructMember("c_pass_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[18] = new org.omg.CORBA.StructMember("c_srvy_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[19] = new org.omg.CORBA.StructMember("c_srvy_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[20] = new org.omg.CORBA.StructMember("c_undr_cndtn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[21] = new org.omg.CORBA.StructMember("n_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[22] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[23] = new org.omg.CORBA.StructMember("n_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[24] = new org.omg.CORBA.StructMember("c_pay_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_rec_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[26] = new org.omg.CORBA.StructMember("c_receipt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[27] = new org.omg.CORBA.StructMember("c_crgo_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[28] = new org.omg.CORBA.StructMember("c_crgo_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[29] = new org.omg.CORBA.StructMember("c_amount", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[30] = new org.omg.CORBA.StructMember("c_pack_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[31] = new org.omg.CORBA.StructMember("c_mark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[32] = new org.omg.CORBA.StructMember("n_invc_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[33] = new org.omg.CORBA.StructMember("c_invc_amt_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[34] = new org.omg.CORBA.StructMember("c_no_repay", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[35] = new org.omg.CORBA.StructMember("c_credit_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[36] = new org.omg.CORBA.StructMember("c_lost_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[37] = new org.omg.CORBA.StructMember("c_container", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[38] = new org.omg.CORBA.StructMember("c_add_risk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[39] = new org.omg.CORBA.StructMember("c_pack_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[40] = new org.omg.CORBA.StructMember("c_srvy_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[41] = new org.omg.CORBA.StructMember("c_edr_info", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "PlyEdrAppCrgoInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PlyEdrAppCrgoInfo:1.0";
  }
}
