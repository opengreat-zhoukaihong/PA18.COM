package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.PagesInfoHelper
<li> <b>Source File</b> com/mcip/bus/orb/PagesInfoHelper.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::PagesInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/PagesInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct PagesInfo {
      string c_page_no;
      wstring c_page_title;
      wstring c_file_enm;
      string c_func_cde;
      string t_edit_tm;
    };
</pre>
</p>
*/
abstract public class PagesInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.PagesInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.bus.orb.PagesInfo result = new com.mcip.bus.orb.PagesInfo();
    result.c_page_no = _input.read_string();
    result.c_page_title = _input.read_wstring();
    result.c_file_enm = _input.read_wstring();
    result.c_func_cde = _input.read_string();
    result.t_edit_tm = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.PagesInfo value) {
    _output.write_string(value.c_page_no);
    _output.write_wstring(value.c_page_title);
    _output.write_wstring(value.c_file_enm);
    _output.write_string(value.c_func_cde);
    _output.write_string(value.t_edit_tm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.PagesInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.PagesInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[5];
      members[0] = new org.omg.CORBA.StructMember("c_page_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_page_title", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_file_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_func_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[4] = new org.omg.CORBA.StructMember("t_edit_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "PagesInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/PagesInfo:1.0";
  }
}
