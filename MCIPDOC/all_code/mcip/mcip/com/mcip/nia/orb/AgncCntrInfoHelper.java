package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.AgncCntrInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/AgncCntrInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::AgncCntrInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/AgncCntrInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct AgncCntrInfo {
      string c_agt_agr_no;
      long n_sub_co_no;
      string c_auth_mrk;
      string c_co_mrk;
      string c_per_org_mrk;
      string c_udr_mrk;
      string c_clnt_cde;
      wstring c_clnt_nme;
      string c_dpt_cde;
      string t_effc_tm;
      string t_co_strt_tm;
      string t_co_end_tm;
      string c_sls_cde;
      wstring c_co_cnt;
      wstring c_undr_prsn;
      string c_insrnc_cde;
      string c_crgo_cde;
      double n_rate;
      double n_nclm_prop;
      double n_appnt_prop;
      double n_cmm_prop;
      double n_min_prm_prop;
      double n_max_amt_prop;
    };
</pre>
</p>
*/
abstract public class AgncCntrInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.AgncCntrInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.AgncCntrInfo result = new com.mcip.nia.orb.AgncCntrInfo();
    result.c_agt_agr_no = _input.read_string();
    result.n_sub_co_no = _input.read_long();
    result.c_auth_mrk = _input.read_string();
    result.c_co_mrk = _input.read_string();
    result.c_per_org_mrk = _input.read_string();
    result.c_udr_mrk = _input.read_string();
    result.c_clnt_cde = _input.read_string();
    result.c_clnt_nme = _input.read_wstring();
    result.c_dpt_cde = _input.read_string();
    result.t_effc_tm = _input.read_string();
    result.t_co_strt_tm = _input.read_string();
    result.t_co_end_tm = _input.read_string();
    result.c_sls_cde = _input.read_string();
    result.c_co_cnt = _input.read_wstring();
    result.c_undr_prsn = _input.read_wstring();
    result.c_insrnc_cde = _input.read_string();
    result.c_crgo_cde = _input.read_string();
    result.n_rate = _input.read_double();
    result.n_nclm_prop = _input.read_double();
    result.n_appnt_prop = _input.read_double();
    result.n_cmm_prop = _input.read_double();
    result.n_min_prm_prop = _input.read_double();
    result.n_max_amt_prop = _input.read_double();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.AgncCntrInfo value) {
    _output.write_string(value.c_agt_agr_no);
    _output.write_long(value.n_sub_co_no);
    _output.write_string(value.c_auth_mrk);
    _output.write_string(value.c_co_mrk);
    _output.write_string(value.c_per_org_mrk);
    _output.write_string(value.c_udr_mrk);
    _output.write_string(value.c_clnt_cde);
    _output.write_wstring(value.c_clnt_nme);
    _output.write_string(value.c_dpt_cde);
    _output.write_string(value.t_effc_tm);
    _output.write_string(value.t_co_strt_tm);
    _output.write_string(value.t_co_end_tm);
    _output.write_string(value.c_sls_cde);
    _output.write_wstring(value.c_co_cnt);
    _output.write_wstring(value.c_undr_prsn);
    _output.write_string(value.c_insrnc_cde);
    _output.write_string(value.c_crgo_cde);
    _output.write_double(value.n_rate);
    _output.write_double(value.n_nclm_prop);
    _output.write_double(value.n_appnt_prop);
    _output.write_double(value.n_cmm_prop);
    _output.write_double(value.n_min_prm_prop);
    _output.write_double(value.n_max_amt_prop);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.AgncCntrInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.AgncCntrInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[23];
      members[0] = new org.omg.CORBA.StructMember("c_agt_agr_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("n_sub_co_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
      members[2] = new org.omg.CORBA.StructMember("c_auth_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_co_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[4] = new org.omg.CORBA.StructMember("c_per_org_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("c_udr_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[6] = new org.omg.CORBA.StructMember("c_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[7] = new org.omg.CORBA.StructMember("c_clnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[9] = new org.omg.CORBA.StructMember("t_effc_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[10] = new org.omg.CORBA.StructMember("t_co_strt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[11] = new org.omg.CORBA.StructMember("t_co_end_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[12] = new org.omg.CORBA.StructMember("c_sls_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[13] = new org.omg.CORBA.StructMember("c_co_cnt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[14] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[15] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[16] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[17] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[18] = new org.omg.CORBA.StructMember("n_nclm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[19] = new org.omg.CORBA.StructMember("n_appnt_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[20] = new org.omg.CORBA.StructMember("n_cmm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[21] = new org.omg.CORBA.StructMember("n_min_prm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[22] = new org.omg.CORBA.StructMember("n_max_amt_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      _type = (_orb()).create_struct_tc(id(), "AgncCntrInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/AgncCntrInfo:1.0";
  }
}
