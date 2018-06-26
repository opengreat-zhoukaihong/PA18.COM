package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OprAuthInfoHelper
<li> <b>Source File</b> com/mcip/bus/orb/OprAuthInfoHelper.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OprAuthInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OprAuthInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OprAuthInfo {
      string c_opr_cde;
      string c_func_cde;
    };
</pre>
</p>
*/
abstract public class OprAuthInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.OprAuthInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.bus.orb.OprAuthInfo result = new com.mcip.bus.orb.OprAuthInfo();
    result.c_opr_cde = _input.read_string();
    result.c_func_cde = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.OprAuthInfo value) {
    _output.write_string(value.c_opr_cde);
    _output.write_string(value.c_func_cde);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.OprAuthInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.OprAuthInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[2];
      members[0] = new org.omg.CORBA.StructMember("c_opr_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_func_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "OprAuthInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/OprAuthInfo:1.0";
  }
}
