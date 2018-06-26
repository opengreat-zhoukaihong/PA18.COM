package com.mcip.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.orb.StringssHelper
<li> <b>Source File</b> com/mcip/orb/StringssHelper.java
<li> <b>IDL Source File</b> CorbaDataType.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::orb::Stringss
<li> <b>Repository Identifier</b> IDL:com/mcip/orb/Stringss:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/orb"
    typedef sequence&lt::com::mcip::orb::Strings&gt Stringss;
</pre>
</p>
*/
abstract public class StringssHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static java.lang.String[][] read(org.omg.CORBA.portable.InputStream _input) {
    java.lang.String[][] result;
    {
      int _length3 = _input.read_long();
      result = new java.lang.String[_length3][];
      for(int _i3 = 0; _i3 < _length3; _i3++) {
        result[_i3] = com.mcip.orb.StringsHelper.read(_input);
      }
    }
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, java.lang.String[][] value) {
    _output.write_long(value.length);
    for(int _i2 = 0; _i2 < value.length; _i2++) {
      com.mcip.orb.StringsHelper.write(_output, value[_i2]);
    }
  }
  public static void insert(org.omg.CORBA.Any any, java.lang.String[][] value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static java.lang.String[][] extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.TypeCode original_type = _orb().create_sequence_tc(0, _orb().create_sequence_tc(0, _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring)));
      _type = _orb().create_alias_tc(id(), "Stringss", original_type);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/orb/Stringss:1.0";
  }
}
