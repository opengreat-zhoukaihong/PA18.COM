package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyGetDocInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/PlyGetDocInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyGetDocInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyGetDocInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyGetDocInfo {
      wstring c_doc_no;
      string c_insrnc_cde;
      string c_prn_typ;
      wstring t_undr_tm;
    };
</pre>
</p>
*/
abstract public class PlyGetDocInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PlyGetDocInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PlyGetDocInfo result = new com.mcip.nia.orb.PlyGetDocInfo();
    result.c_doc_no = _input.read_wstring();
    result.c_insrnc_cde = _input.read_string();
    result.c_prn_typ = _input.read_string();
    result.t_undr_tm = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PlyGetDocInfo value) {
    _output.write_wstring(value.c_doc_no);
    _output.write_string(value.c_insrnc_cde);
    _output.write_string(value.c_prn_typ);
    _output.write_wstring(value.t_undr_tm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PlyGetDocInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PlyGetDocInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[4];
      members[0] = new org.omg.CORBA.StructMember("c_doc_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("c_prn_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("t_undr_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "PlyGetDocInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PlyGetDocInfo:1.0";
  }
}
