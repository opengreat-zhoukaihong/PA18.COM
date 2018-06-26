package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.OperatorInfoHelper
<li> <b>Source File</b> com/mcip/bus/orb/OperatorInfoHelper.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::OperatorInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/OperatorInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct OperatorInfo {
      wstring c_opr_cde;
      string c_opr_pw;
      string c_emp_cde;
      string c_dpt_cde;
      wstring c_acredt_cde;
      string c_sys_admin;
    };
</pre>
</p>
*/
abstract public class OperatorInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.OperatorInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.bus.orb.OperatorInfo result = new com.mcip.bus.orb.OperatorInfo();
    result.c_opr_cde = _input.read_wstring();
    result.c_opr_pw = _input.read_string();
    result.c_emp_cde = _input.read_string();
    result.c_dpt_cde = _input.read_string();
    result.c_acredt_cde = _input.read_wstring();
    result.c_sys_admin = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.OperatorInfo value) {
    _output.write_wstring(value.c_opr_cde);
    _output.write_string(value.c_opr_pw);
    _output.write_string(value.c_emp_cde);
    _output.write_string(value.c_dpt_cde);
    _output.write_wstring(value.c_acredt_cde);
    _output.write_string(value.c_sys_admin);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.OperatorInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.OperatorInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[6];
      members[0] = new org.omg.CORBA.StructMember("c_opr_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_opr_pw", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("c_emp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[4] = new org.omg.CORBA.StructMember("c_acredt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("c_sys_admin", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "OperatorInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/OperatorInfo:1.0";
  }
}
