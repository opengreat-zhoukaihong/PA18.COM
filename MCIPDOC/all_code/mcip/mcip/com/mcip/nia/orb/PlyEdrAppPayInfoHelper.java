package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlyEdrAppPayInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/PlyEdrAppPayInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlyEdrAppPayInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlyEdrAppPayInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlyEdrAppPayInfo {
      wstring c_crt_cde;
      wstring c_crt_tm;
      wstring c_upd_cde;
      wstring c_upd_tm;
      wstring c_edr_app_no;
      wstring n_tms;
      wstring c_rcpt_no;
      wstring c_pay_prsn_cde;
      wstring c_pay_prsn_nme;
      wstring n_get_prm;
      wstring c_pay_mde_cde;
      wstring c_accnt_no;
      wstring t_pay_lmt_tm;
      wstring n_got_prm;
      wstring t_pay_strt_tm;
      wstring t_pay_tm;
      wstring c_insrnc_cde;
      wstring c_cur_typ;
      wstring c_rec_no;
      wstring c_prn_typ;
    };
</pre>
</p>
*/
abstract public class PlyEdrAppPayInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.PlyEdrAppPayInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.PlyEdrAppPayInfo result = new com.mcip.nia.orb.PlyEdrAppPayInfo();
    result.c_crt_cde = _input.read_wstring();
    result.c_crt_tm = _input.read_wstring();
    result.c_upd_cde = _input.read_wstring();
    result.c_upd_tm = _input.read_wstring();
    result.c_edr_app_no = _input.read_wstring();
    result.n_tms = _input.read_wstring();
    result.c_rcpt_no = _input.read_wstring();
    result.c_pay_prsn_cde = _input.read_wstring();
    result.c_pay_prsn_nme = _input.read_wstring();
    result.n_get_prm = _input.read_wstring();
    result.c_pay_mde_cde = _input.read_wstring();
    result.c_accnt_no = _input.read_wstring();
    result.t_pay_lmt_tm = _input.read_wstring();
    result.n_got_prm = _input.read_wstring();
    result.t_pay_strt_tm = _input.read_wstring();
    result.t_pay_tm = _input.read_wstring();
    result.c_insrnc_cde = _input.read_wstring();
    result.c_cur_typ = _input.read_wstring();
    result.c_rec_no = _input.read_wstring();
    result.c_prn_typ = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PlyEdrAppPayInfo value) {
    _output.write_wstring(value.c_crt_cde);
    _output.write_wstring(value.c_crt_tm);
    _output.write_wstring(value.c_upd_cde);
    _output.write_wstring(value.c_upd_tm);
    _output.write_wstring(value.c_edr_app_no);
    _output.write_wstring(value.n_tms);
    _output.write_wstring(value.c_rcpt_no);
    _output.write_wstring(value.c_pay_prsn_cde);
    _output.write_wstring(value.c_pay_prsn_nme);
    _output.write_wstring(value.n_get_prm);
    _output.write_wstring(value.c_pay_mde_cde);
    _output.write_wstring(value.c_accnt_no);
    _output.write_wstring(value.t_pay_lmt_tm);
    _output.write_wstring(value.n_got_prm);
    _output.write_wstring(value.t_pay_strt_tm);
    _output.write_wstring(value.t_pay_tm);
    _output.write_wstring(value.c_insrnc_cde);
    _output.write_wstring(value.c_cur_typ);
    _output.write_wstring(value.c_rec_no);
    _output.write_wstring(value.c_prn_typ);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PlyEdrAppPayInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PlyEdrAppPayInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[20];
      members[0] = new org.omg.CORBA.StructMember("c_crt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("c_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("c_upd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("c_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_edr_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[5] = new org.omg.CORBA.StructMember("n_tms", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("c_rcpt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[7] = new org.omg.CORBA.StructMember("c_pay_prsn_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[8] = new org.omg.CORBA.StructMember("c_pay_prsn_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[9] = new org.omg.CORBA.StructMember("n_get_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[10] = new org.omg.CORBA.StructMember("c_pay_mde_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[11] = new org.omg.CORBA.StructMember("c_accnt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[12] = new org.omg.CORBA.StructMember("t_pay_lmt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[13] = new org.omg.CORBA.StructMember("n_got_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[14] = new org.omg.CORBA.StructMember("t_pay_strt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[15] = new org.omg.CORBA.StructMember("t_pay_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[16] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[17] = new org.omg.CORBA.StructMember("c_cur_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[18] = new org.omg.CORBA.StructMember("c_rec_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[19] = new org.omg.CORBA.StructMember("c_prn_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "PlyEdrAppPayInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PlyEdrAppPayInfo:1.0";
  }
}
