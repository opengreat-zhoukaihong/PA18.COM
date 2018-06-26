package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.SysFuncInfoHelper
<li> <b>Source File</b> com/mcip/bus/orb/SysFuncInfoHelper.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::SysFuncInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/SysFuncInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct SysFuncInfo {
      string c_func_cde;
      wstring c_func_cnm;
      wstring c_func_enm;
    };
</pre>
</p>
*/
abstract public class SysFuncInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.SysFuncInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.bus.orb.SysFuncInfo result = new com.mcip.bus.orb.SysFuncInfo();
    result.c_func_cde = _input.read_string();
    result.c_func_cnm = _input.read_wstring();
    result.c_func_enm = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.SysFuncInfo value) {
    _output.write_string(value.c_func_cde);
    _output.write_wstring(value.c_func_cnm);
    _output.write_wstring(value.c_func_enm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.SysFuncInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.SysFuncInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[3];
      members[0] = new org.omg.CORBA.StructMember("c_func_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_func_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_func_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "SysFuncInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/SysFuncInfo:1.0";
  }
}
