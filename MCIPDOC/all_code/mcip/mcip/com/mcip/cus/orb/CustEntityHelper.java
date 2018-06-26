package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustEntityHelper
<li> <b>Source File</b> com/mcip/cus/orb/CustEntityHelper.java
<li> <b>IDL Source File</b> custInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cus::orb::CustEntity
<li> <b>Repository Identifier</b> IDL:com/mcip/cus/orb/CustEntity:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cus/orb"
    struct CustEntity {
      wstring c_user_id;
      wstring c_user_name;
      string c_user_pw;
      wstring c_pw_question;
      wstring c_pw_result;
      string c_clnt_cde;
      long n_user_seq_no;
      char c_verify;
      string c_cmpny_agt_cde;
      string c_net_id;
    };
</pre>
</p>
*/
abstract public class CustEntityHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.cus.orb.CustEntity read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.cus.orb.CustEntity result = new com.mcip.cus.orb.CustEntity();
    result.c_user_id = _input.read_wstring();
    result.c_user_name = _input.read_wstring();
    result.c_user_pw = _input.read_string();
    result.c_pw_question = _input.read_wstring();
    result.c_pw_result = _input.read_wstring();
    result.c_clnt_cde = _input.read_string();
    result.n_user_seq_no = _input.read_long();
    result.c_verify = _input.read_char();
    result.c_cmpny_agt_cde = _input.read_string();
    result.c_net_id = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.cus.orb.CustEntity value) {
    _output.write_wstring(value.c_user_id);
    _output.write_wstring(value.c_user_name);
    _output.write_string(value.c_user_pw);
    _output.write_wstring(value.c_pw_question);
    _output.write_wstring(value.c_pw_result);
    _output.write_string(value.c_clnt_cde);
    _output.write_long(value.n_user_seq_no);
    _output.write_char(value.c_verify);
    _output.write_string(value.c_cmpny_agt_cde);
    _output.write_string(value.c_net_id);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.cus.orb.CustEntity value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.cus.orb.CustEntity extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[10];
      members[0] = new org.omg.CORBA.StructMember("c_user_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_user_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_user_pw", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_pw_question", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_pw_result", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("c_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[6] = new org.omg.CORBA.StructMember("n_user_seq_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
      members[7] = new org.omg.CORBA.StructMember("c_verify", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_char), null);
      members[8] = new org.omg.CORBA.StructMember("c_cmpny_agt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("c_net_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "CustEntity", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/cus/orb/CustEntity:1.0";
  }
}
