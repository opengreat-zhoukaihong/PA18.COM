package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlcyAppListHelper
<li> <b>Source File</b> com/mcip/nia/orb/PlcyAppListHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlcyAppList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlcyAppList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlcyAppList {
      string c_ply_app_no;
      string c_ply_no;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      double n_amt;
      string c_amt_cur;
      string c_crgo_cde;
      wstring c_cdgo_desc;
      string c_frm_prt_ara;
      wstring c_frm_prt_ara_cnm;
      wstring c_from_prt;
      string c_to_prt_ara;
      wstring c_to_prt_ara_cnm;
      wstring c_to_prt;
      string c_carriage_cde;
      wstring c_carriage_cnm;
    };
</pre>
</p>
*/
abstract public class PlcyAppListHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PlcyAppList read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PlcyAppList result = new com.mcip.nia.orb.PlcyAppList();
    result.c_ply_app_no = _input.read_string();
    result.c_ply_no = _input.read_string();
    result.c_insrnc_cde = _input.read_string();
    result.c_insrnc_cnm = _input.read_wstring();
    result.n_amt = _input.read_double();
    result.c_amt_cur = _input.read_string();
    result.c_crgo_cde = _input.read_string();
    result.c_cdgo_desc = _input.read_wstring();
    result.c_frm_prt_ara = _input.read_string();
    result.c_frm_prt_ara_cnm = _input.read_wstring();
    result.c_from_prt = _input.read_wstring();
    result.c_to_prt_ara = _input.read_string();
    result.c_to_prt_ara_cnm = _input.read_wstring();
    result.c_to_prt = _input.read_wstring();
    result.c_carriage_cde = _input.read_string();
    result.c_carriage_cnm = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PlcyAppList value) {
    _output.write_string(value.c_ply_app_no);
    _output.write_string(value.c_ply_no);
    _output.write_string(value.c_insrnc_cde);
    _output.write_wstring(value.c_insrnc_cnm);
    _output.write_double(value.n_amt);
    _output.write_string(value.c_amt_cur);
    _output.write_string(value.c_crgo_cde);
    _output.write_wstring(value.c_cdgo_desc);
    _output.write_string(value.c_frm_prt_ara);
    _output.write_wstring(value.c_frm_prt_ara_cnm);
    _output.write_wstring(value.c_from_prt);
    _output.write_string(value.c_to_prt_ara);
    _output.write_wstring(value.c_to_prt_ara_cnm);
    _output.write_wstring(value.c_to_prt);
    _output.write_string(value.c_carriage_cde);
    _output.write_wstring(value.c_carriage_cnm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PlcyAppList value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PlcyAppList extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[16];
      members[0] = new org.omg.CORBA.StructMember("c_ply_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_insrnc_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("n_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[5] = new org.omg.CORBA.StructMember("c_amt_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[6] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[7] = new org.omg.CORBA.StructMember("c_cdgo_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("c_frm_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[10] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[11] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[12] = new org.omg.CORBA.StructMember("c_to_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[13] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[14] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[15] = new org.omg.CORBA.StructMember("c_carriage_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "PlcyAppList", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PlcyAppList:1.0";
  }
}
