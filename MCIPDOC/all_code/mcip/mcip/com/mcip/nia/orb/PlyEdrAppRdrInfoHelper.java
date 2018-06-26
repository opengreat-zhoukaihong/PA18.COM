package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppRdrInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppRdrInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrAppRdrInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrAppRdrInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrAppRdrInfo {
      ::com::mcip::orb::Stringss edrapprdr;
    };
</pre>
</p>
*/
abstract public class PlyEdrAppRdrInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PlyEdrAppRdrInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PlyEdrAppRdrInfo result = new com.mcip.nia.orb.PlyEdrAppRdrInfo();
    result.edrapprdr = com.mcip.orb.StringssHelper.read(_input);
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PlyEdrAppRdrInfo value) {
    com.mcip.orb.StringssHelper.write(_output, value.edrapprdr);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PlyEdrAppRdrInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PlyEdrAppRdrInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[1];
      members[0] = new org.omg.CORBA.StructMember("edrapprdr", _orb().create_sequence_tc(0, _orb().create_sequence_tc(0, _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring))), null);
      _type = (_orb()).create_struct_tc(id(), "PlyEdrAppRdrInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PlyEdrAppRdrInfo:1.0";
  }
}
