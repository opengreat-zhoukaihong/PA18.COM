package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.QuotaCndtnHelper
<li> <b>Source File</b> com/mcip/nia/orb/QuotaCndtnHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::QuotaCndtn
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/QuotaCndtn:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct QuotaCndtn {
      string c_dpt_cde;
      string c_insrnc_cde;
      string c_rdr_cde;
      string c_crgo_cls;
      string c_crgo_cde;
      string c_pack_cde;
      string c_carriage_cde;
      string c_frm_prt_ara;
      string c_to_prt_ara;
      string n_rate;
      wstring c_nclm_desc;
    };
</pre>
</p>
*/
abstract public class QuotaCndtnHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.QuotaCndtn read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.QuotaCndtn result = new com.mcip.nia.orb.QuotaCndtn();
    result.c_dpt_cde = _input.read_string();
    result.c_insrnc_cde = _input.read_string();
    result.c_rdr_cde = _input.read_string();
    result.c_crgo_cls = _input.read_string();
    result.c_crgo_cde = _input.read_string();
    result.c_pack_cde = _input.read_string();
    result.c_carriage_cde = _input.read_string();
    result.c_frm_prt_ara = _input.read_string();
    result.c_to_prt_ara = _input.read_string();
    result.n_rate = _input.read_string();
    result.c_nclm_desc = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.QuotaCndtn value) {
    _output.write_string(value.c_dpt_cde);
    _output.write_string(value.c_insrnc_cde);
    _output.write_string(value.c_rdr_cde);
    _output.write_string(value.c_crgo_cls);
    _output.write_string(value.c_crgo_cde);
    _output.write_string(value.c_pack_cde);
    _output.write_string(value.c_carriage_cde);
    _output.write_string(value.c_frm_prt_ara);
    _output.write_string(value.c_to_prt_ara);
    _output.write_string(value.n_rate);
    _output.write_wstring(value.c_nclm_desc);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.QuotaCndtn value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.QuotaCndtn extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[11];
      members[0] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("c_rdr_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_crgo_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[4] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("c_pack_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[6] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[7] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[8] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[10] = new org.omg.CORBA.StructMember("c_nclm_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "QuotaCndtn", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/QuotaCndtn:1.0";
  }
}
