package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.CustFaqInfoHelper
<li> <b>Source File</b> com/mcip/bus/orb/CustFaqInfoHelper.java
<li> <b>IDL Source File</b> businessInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::CustFaqInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/CustFaqInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    struct CustFaqInfo {
      wstring c_faq_no;
      wstring c_faq_psn;
      wstring c_faq_email;
      wstring c_faq_title;
      wstring c_faq_content;
      string t_faq_tm;
      wstring c_reply_cont;
      wstring c_reply_emp;
      string t_reply_tm;
    };
</pre>
</p>
*/
abstract public class CustFaqInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.CustFaqInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.bus.orb.CustFaqInfo result = new com.mcip.bus.orb.CustFaqInfo();
    result.c_faq_no = _input.read_wstring();
    result.c_faq_psn = _input.read_wstring();
    result.c_faq_email = _input.read_wstring();
    result.c_faq_title = _input.read_wstring();
    result.c_faq_content = _input.read_wstring();
    result.t_faq_tm = _input.read_string();
    result.c_reply_cont = _input.read_wstring();
    result.c_reply_emp = _input.read_wstring();
    result.t_reply_tm = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.CustFaqInfo value) {
    _output.write_wstring(value.c_faq_no);
    _output.write_wstring(value.c_faq_psn);
    _output.write_wstring(value.c_faq_email);
    _output.write_wstring(value.c_faq_title);
    _output.write_wstring(value.c_faq_content);
    _output.write_string(value.t_faq_tm);
    _output.write_wstring(value.c_reply_cont);
    _output.write_wstring(value.c_reply_emp);
    _output.write_string(value.t_reply_tm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.CustFaqInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.CustFaqInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[9];
      members[0] = new org.omg.CORBA.StructMember("c_faq_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_faq_psn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_faq_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_faq_title", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_faq_content", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("t_faq_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[6] = new org.omg.CORBA.StructMember("c_reply_cont", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[7] = new org.omg.CORBA.StructMember("c_reply_emp", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("t_reply_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "CustFaqInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/CustFaqInfo:1.0";
  }
}
