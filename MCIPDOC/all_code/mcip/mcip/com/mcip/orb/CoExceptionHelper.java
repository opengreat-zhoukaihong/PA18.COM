package com.mcip.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.orb.CoExceptionHelper
<li> <b>Source File</b> com/mcip/orb/CoExceptionHelper.java
<li> <b>IDL Source File</b> exceptions.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::orb::CoException
<li> <b>Repository Identifier</b> IDL:com/mcip/orb/CoException:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/orb"
    exception CoException {
      string errCode;
      wstring errDescription;
      string errFieldName;
      string severity;
    };
</pre>
</p>
*/
abstract public class CoExceptionHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.orb.CoException read(org.omg.CORBA.portable.InputStream _input) {
    if(!_input.read_string().equals(id())) {
      throw new org.omg.CORBA.MARSHAL("Mismached repository id");
    }
    com.mcip.orb.CoException result = new com.mcip.orb.CoException();
    result.errCode = _input.read_string();
    result.errDescription = _input.read_wstring();
    result.errFieldName = _input.read_string();
    result.severity = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.orb.CoException value) {
    _output.write_string(id());
    _output.write_string(value.errCode);
    _output.write_wstring(value.errDescription);
    _output.write_string(value.errFieldName);
    _output.write_string(value.severity);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.orb.CoException value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.orb.CoException extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[4];
      members[0] = new org.omg.CORBA.StructMember("errCode", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("errDescription", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("errFieldName", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("severity", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_exception_tc(id(), "CoException", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/orb/CoException:1.0";
  }
}
