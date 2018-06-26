package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.AgncCntrListHelper
<li> <b>Source File</b> com/mcip/nia/orb/AgncCntrListHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::AgncCntrList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/AgncCntrList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct AgncCntrList {
      string c_agt_agr_no;
      long n_sub_co_no;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      string c_crgo_cde;
      wstring c_crgo_cnm;
    };
</pre>
</p>
*/
abstract public class AgncCntrListHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.AgncCntrList read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.AgncCntrList result = new com.mcip.nia.orb.AgncCntrList();
    result.c_agt_agr_no = _input.read_string();
    result.n_sub_co_no = _input.read_long();
    result.c_insrnc_cde = _input.read_string();
    result.c_insrnc_cnm = _input.read_wstring();
    result.c_crgo_cde = _input.read_string();
    result.c_crgo_cnm = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.AgncCntrList value) {
    _output.write_string(value.c_agt_agr_no);
    _output.write_long(value.n_sub_co_no);
    _output.write_string(value.c_insrnc_cde);
    _output.write_wstring(value.c_insrnc_cnm);
    _output.write_string(value.c_crgo_cde);
    _output.write_wstring(value.c_crgo_cnm);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.AgncCntrList value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.AgncCntrList extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[6];
      members[0] = new org.omg.CORBA.StructMember("c_agt_agr_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("n_sub_co_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
      members[2] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_insrnc_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("c_crgo_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "AgncCntrList", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/AgncCntrList:1.0";
  }
}
