package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrGridInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrGridInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrGridInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrGridInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrGridInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_edr_app_no;
      wstring c_send_tm;
      wstring c_dpt_cde;
      wstring c_source;
      wstring c_send_dpt_cde;
      wstring c_send_cde;
      wstring c_des_dpt_cde;
      wstring c_emergency;
      wstring c_authprn_cde;
      wstring c_udr_mrk;
      wstring c_send_mrk;
      wstring c_udr_opn_mrk;
      wstring c_vrfy_mrk;
      wstring c_mdfy_tm;
      wstring c_insrnc_cde;
      wstring c_undr_prsn;
      wstring c_undr_dpt;
      wstring c_prn_typ;
      wstring c_rinsrnc_mrk;
      wstring c_coinsrnc_mrk;
      wstring c_ply_no;
      wstring c_edr_no;
      wstring c_read_tm;
      wstring c_rec_no;
      wstring c_flag;
      wstring c_insrnc_dfn_typ;
      wstring c_insrnc_cnm;
      wstring c_edr_typ;
      wstring c_app_nme;
      wstring n_amt;
      wstring t_sign_tm;
      wstring c_rpt_desc;
      wstring c_risk_lvl_cde;
      wstring c_lcn_no;
      wstring c_eng_no;
      wstring c_insrnc_cls;
      wstring c_use_atr;
      wstring c_undr_opn;
      wstring c_internet_typ;
    };
</pre>
</p>
*/
abstract public class PlyEdrGridInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PlyEdrGridInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PlyEdrGridInfo result = new com.mcip.nia.orb.PlyEdrGridInfo();
    result.c_crt_cde = _input.read_wstring();
    result.c_crt_tm = _input.read_wstring();
    result.c_upd_cde = _input.read_wstring();
    result.c_upd_tm = _input.read_wstring();
    result.c_edr_app_no = _input.read_wstring();
    result.c_send_tm = _input.read_wstring();
    result.c_dpt_cde = _input.read_wstring();
    result.c_source = _input.read_wstring();
    result.c_send_dpt_cde = _input.read_wstring();
    result.c_send_cde = _input.read_wstring();
    result.c_des_dpt_cde = _input.read_wstring();
    result.c_emergency = _input.read_wstring();
    result.c_authprn_cde = _input.read_wstring();
    result.c_udr_mrk = _input.read_wstring();
    result.c_send_mrk = _input.read_wstring();
    result.c_udr_opn_mrk = _input.read_wstring();
    result.c_vrfy_mrk = _input.read_wstring();
    result.c_mdfy_tm = _input.read_wstring();
    result.c_insrnc_cde = _input.read_wstring();
    result.c_undr_prsn = _input.read_wstring();
    result.c_undr_dpt = _input.read_wstring();
    result.c_prn_typ = _input.read_wstring();
    result.c_rinsrnc_mrk = _input.read_wstring();
    result.c_coinsrnc_mrk = _input.read_wstring();
    result.c_ply_no = _input.read_wstring();
    result.c_edr_no = _input.read_wstring();
    result.c_read_tm = _input.read_wstring();
    result.c_rec_no = _input.read_wstring();
    result.c_flag = _input.read_wstring();
    result.c_insrnc_dfn_typ = _input.read_wstring();
    result.c_insrnc_cnm = _input.read_wstring();
    result.c_edr_typ = _input.read_wstring();
    result.c_app_nme = _input.read_wstring();
    result.n_amt = _input.read_wstring();
    result.t_sign_tm = _input.read_wstring();
    result.c_rpt_desc = _input.read_wstring();
    result.c_risk_lvl_cde = _input.read_wstring();
    result.c_lcn_no = _input.read_wstring();
    result.c_eng_no = _input.read_wstring();
    result.c_insrnc_cls = _input.read_wstring();
    result.c_use_atr = _input.read_wstring();
    result.c_undr_opn = _input.read_wstring();
    result.c_internet_typ = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PlyEdrGridInfo value) {
    _output.write_wstring(value.c_crt_cde);
    _output.write_wstring(value.c_crt_tm);
    _output.write_wstring(value.c_upd_cde);
    _output.write_wstring(value.c_upd_tm);
    _output.write_wstring(value.c_edr_app_no);
    _output.write_wstring(value.c_send_tm);
    _output.write_wstring(value.c_dpt_cde);
    _output.write_wstring(value.c_source);
    _output.write_wstring(value.c_send_dpt_cde);
    _output.write_wstring(value.c_send_cde);
    _output.write_wstring(value.c_des_dpt_cde);
    _output.write_wstring(value.c_emergency);
    _output.write_wstring(value.c_authprn_cde);
    _output.write_wstring(value.c_udr_mrk);
    _output.write_wstring(value.c_send_mrk);
    _output.write_wstring(value.c_udr_opn_mrk);
    _output.write_wstring(value.c_vrfy_mrk);
    _output.write_wstring(value.c_mdfy_tm);
    _output.write_wstring(value.c_insrnc_cde);
    _output.write_wstring(value.c_undr_prsn);
    _output.write_wstring(value.c_undr_dpt);
    _output.write_wstring(value.c_prn_typ);
    _output.write_wstring(value.c_rinsrnc_mrk);
    _output.write_wstring(value.c_coinsrnc_mrk);
    _output.write_wstring(value.c_ply_no);
    _output.write_wstring(value.c_edr_no);
    _output.write_wstring(value.c_read_tm);
    _output.write_wstring(value.c_rec_no);
    _output.write_wstring(value.c_flag);
    _output.write_wstring(value.c_insrnc_dfn_typ);
    _output.write_wstring(value.c_insrnc_cnm);
    _output.write_wstring(value.c_edr_typ);
    _output.write_wstring(value.c_app_nme);
    _output.write_wstring(value.n_amt);
    _output.write_wstring(value.t_sign_tm);
    _output.write_wstring(value.c_rpt_desc);
    _output.write_wstring(value.c_risk_lvl_cde);
    _output.write_wstring(value.c_lcn_no);
    _output.write_wstring(value.c_eng_no);
    _output.write_wstring(value.c_insrnc_cls);
    _output.write_wstring(value.c_use_atr);
    _output.write_wstring(value.c_undr_opn);
    _output.write_wstring(value.c_internet_typ);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PlyEdrGridInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PlyEdrGridInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[43];
      members[0] = new org.omg.CORBA.StructMember("c_crt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_upd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_edr_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("c_send_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[7] = new org.omg.CORBA.StructMember("c_source", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_send_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[9] = new org.omg.CORBA.StructMember("c_send_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[10] = new org.omg.CORBA.StructMember("c_des_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[11] = new org.omg.CORBA.StructMember("c_emergency", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[12] = new org.omg.CORBA.StructMember("c_authprn_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[13] = new org.omg.CORBA.StructMember("c_udr_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[14] = new org.omg.CORBA.StructMember("c_send_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[15] = new org.omg.CORBA.StructMember("c_udr_opn_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[16] = new org.omg.CORBA.StructMember("c_vrfy_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[17] = new org.omg.CORBA.StructMember("c_mdfy_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[18] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[19] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[20] = new org.omg.CORBA.StructMember("c_undr_dpt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[21] = new org.omg.CORBA.StructMember("c_prn_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[22] = new org.omg.CORBA.StructMember("c_rinsrnc_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[23] = new org.omg.CORBA.StructMember("c_coinsrnc_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[24] = new org.omg.CORBA.StructMember("c_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_edr_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[26] = new org.omg.CORBA.StructMember("c_read_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[27] = new org.omg.CORBA.StructMember("c_rec_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[28] = new org.omg.CORBA.StructMember("c_flag", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[29] = new org.omg.CORBA.StructMember("c_insrnc_dfn_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[30] = new org.omg.CORBA.StructMember("c_insrnc_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[31] = new org.omg.CORBA.StructMember("c_edr_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[32] = new org.omg.CORBA.StructMember("c_app_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[33] = new org.omg.CORBA.StructMember("n_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[34] = new org.omg.CORBA.StructMember("t_sign_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[35] = new org.omg.CORBA.StructMember("c_rpt_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[36] = new org.omg.CORBA.StructMember("c_risk_lvl_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[37] = new org.omg.CORBA.StructMember("c_lcn_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[38] = new org.omg.CORBA.StructMember("c_eng_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[39] = new org.omg.CORBA.StructMember("c_insrnc_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[40] = new org.omg.CORBA.StructMember("c_use_atr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[41] = new org.omg.CORBA.StructMember("c_undr_opn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[42] = new org.omg.CORBA.StructMember("c_internet_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "PlyEdrGridInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PlyEdrGridInfo:1.0";
  }
}
