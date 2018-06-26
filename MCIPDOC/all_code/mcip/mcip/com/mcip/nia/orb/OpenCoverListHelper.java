package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.OpenCoverListHelper
<li> <b>Source File</b> com/mcip/nia/orb/OpenCoverListHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::OpenCoverList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/OpenCoverList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct OpenCoverList {
      string c_open_cover_no;
      wstring c_crgo_name;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      string c_frm_prt_ara;
      wstring c_frm_prt_ara_cnm;
      string c_to_prt_ara;
      wstring c_to_prt_ara_cnm;
      wstring c_from_prt;
      wstring c_to_prt;
    };
</pre>
</p>
*/
abstract public class OpenCoverListHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.OpenCoverList read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.OpenCoverList result = new com.mcip.nia.orb.OpenCoverList();
    result.c_open_cover_no = _input.read_string();
    result.c_crgo_name = _input.read_wstring();
    result.c_insrnc_cde = _input.read_string();
    result.c_insrnc_cnm = _input.read_wstring();
    result.c_frm_prt_ara = _input.read_string();
    result.c_frm_prt_ara_cnm = _input.read_wstring();
    result.c_to_prt_ara = _input.read_string();
    result.c_to_prt_ara_cnm = _input.read_wstring();
    result.c_from_prt = _input.read_wstring();
    result.c_to_prt = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.OpenCoverList value) {
    _output.write_string(value.c_open_cover_no);
    _output.write_wstring(value.c_crgo_name);
    _output.write_string(value.c_insrnc_cde);
    _output.write_wstring(value.c_insrnc_cnm);
    _output.write_string(value.c_frm_prt_ara);
    _output.write_wstring(value.c_frm_prt_ara_cnm);
    _output.write_string(value.c_to_prt_ara);
    _output.write_wstring(value.c_to_prt_ara_cnm);
    _output.write_wstring(value.c_from_prt);
    _output.write_wstring(value.c_to_prt);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.OpenCoverList value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.OpenCoverList extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[10];
      members[0] = new org.omg.CORBA.StructMember("c_open_cover_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_crgo_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_insrnc_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("c_frm_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[7] = new org.omg.CORBA.StructMember("c_to_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[9] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "OpenCoverList", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/OpenCoverList:1.0";
  }
}
