package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.InsrncGuideInfoHelper
<li> <b>Source File</b> com/mcip/bus/orb/InsrncGuideInfoHelper.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::InsrncGuideInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct InsrncGuideInfo {
      wstring c_info_no;
      wstring c_title_no;
      wstring c_title_cnm;
      wstring c_title_enm;
      wstring c_content_cnm;
      wstring c_content_enm;
      string t_crt_tm;
    };
</pre>
</p>
*/
abstract public class InsrncGuideInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.InsrncGuideInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.bus.orb.InsrncGuideInfo result = new com.mcip.bus.orb.InsrncGuideInfo();
    result.c_info_no = _input.read_wstring();
    result.c_title_no = _input.read_wstring();
    result.c_title_cnm = _input.read_wstring();
    result.c_title_enm = _input.read_wstring();
    result.c_content_cnm = _input.read_wstring();
    result.c_content_enm = _input.read_wstring();
    result.t_crt_tm = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.InsrncGuideInfo value) {
    _output.write_wstring(value.c_info_no);
    _output.write_wstring(value.c_title_no);
    _output.write_wstring(value.c_title_cnm);
    _output.write_wstring(value.c_title_enm);
    _output.write_wstring(value.c_content_cnm);
    _output.write_wstring(value.c_content_enm);
    _output.write_string(value.t_crt_tm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.InsrncGuideInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.InsrncGuideInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[7];
      members[0] = new org.omg.CORBA.StructMember("c_info_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_title_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_title_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_title_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_content_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("c_content_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("t_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "InsrncGuideInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0";
  }
}
