package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PrpslInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/PrpslInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PrpslInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PrpslInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PrpslInfo {
      string c_doc_no;
      double n_rate;
      wstring c_no_repay;
      wstring c_undr_cndtn;
      string t_send_tm;
      wstring c_send_desc;
      wstring c_undr_prsn;
      string t_sign_tm;
      string c_user_id;
      wstring c_remark;
      wstring c_user_remark;
    };
</pre>
</p>
*/
abstract public class PrpslInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PrpslInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PrpslInfo result = new com.mcip.nia.orb.PrpslInfo();
    result.c_doc_no = _input.read_string();
    result.n_rate = _input.read_double();
    result.c_no_repay = _input.read_wstring();
    result.c_undr_cndtn = _input.read_wstring();
    result.t_send_tm = _input.read_string();
    result.c_send_desc = _input.read_wstring();
    result.c_undr_prsn = _input.read_wstring();
    result.t_sign_tm = _input.read_string();
    result.c_user_id = _input.read_string();
    result.c_remark = _input.read_wstring();
    result.c_user_remark = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PrpslInfo value) {
    _output.write_string(value.c_doc_no);
    _output.write_double(value.n_rate);
    _output.write_wstring(value.c_no_repay);
    _output.write_wstring(value.c_undr_cndtn);
    _output.write_string(value.t_send_tm);
    _output.write_wstring(value.c_send_desc);
    _output.write_wstring(value.c_undr_prsn);
    _output.write_string(value.t_sign_tm);
    _output.write_string(value.c_user_id);
    _output.write_wstring(value.c_remark);
    _output.write_wstring(value.c_user_remark);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PrpslInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PrpslInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[11];
      members[0] = new org.omg.CORBA.StructMember("c_doc_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[2] = new org.omg.CORBA.StructMember("c_no_repay", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_undr_cndtn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("t_send_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("c_send_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[7] = new org.omg.CORBA.StructMember("t_sign_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[8] = new org.omg.CORBA.StructMember("c_user_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("c_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[10] = new org.omg.CORBA.StructMember("c_user_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "PrpslInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PrpslInfo:1.0";
  }
}
