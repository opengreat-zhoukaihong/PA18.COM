package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.ClmDgstInfoHelper
<li> <b>Source File</b> com/mcip/bus/orb/ClmDgstInfoHelper.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::ClmDgstInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/ClmDgstInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct ClmDgstInfo {
      wstring c_ply_no;
      wstring c_rpt_no;
      wstring c_info_no;
      wstring c_digest;
      wstring c_content;
      string t_input_tm;
    };
</pre>
</p>
*/
abstract public class ClmDgstInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.ClmDgstInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.bus.orb.ClmDgstInfo result = new com.mcip.bus.orb.ClmDgstInfo();
    result.c_ply_no = _input.read_wstring();
    result.c_rpt_no = _input.read_wstring();
    result.c_info_no = _input.read_wstring();
    result.c_digest = _input.read_wstring();
    result.c_content = _input.read_wstring();
    result.t_input_tm = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.ClmDgstInfo value) {
    _output.write_wstring(value.c_ply_no);
    _output.write_wstring(value.c_rpt_no);
    _output.write_wstring(value.c_info_no);
    _output.write_wstring(value.c_digest);
    _output.write_wstring(value.c_content);
    _output.write_string(value.t_input_tm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.ClmDgstInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.ClmDgstInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[6];
      members[0] = new org.omg.CORBA.StructMember("c_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_rpt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_info_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_digest", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_content", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("t_input_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "ClmDgstInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/ClmDgstInfo:1.0";
  }
}
