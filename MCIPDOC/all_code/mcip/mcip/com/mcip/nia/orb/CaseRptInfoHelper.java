package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.CaseRptInfoHelper
<li> <b>Source File</b> com/mcip/nia/orb/CaseRptInfoHelper.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::CaseRptInfo
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/CaseRptInfo:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct CaseRptInfo {
      string c_ply_no;
      string c_rpt_no;
      string c_clm_no;
      wstring c_insrnt_nme;
      string c_insrnt_cde;
      wstring c_insrnc_tgt;
      wstring c_rpt_nme;
      string c_srs_case_mrk;
      wstring c_rpt_addr_tel;
      string t_rtp_tm;
      string t_accdnt_tm;
      wstring c_accdnt_spot;
      wstring c_accdnt_caus;
      wstring c_los_dtl;
      string c_cur_typ;
      double n_rpt_amt;
      string c_insrnc_cde;
      string c_rcvr_cde;
      wstring c_opinion;
      wstring c_remark;
      wstring c_tgt_los_dtl;
      wstring c_hlp_exp;
      wstring c_thd_los;
      wstring c_clm_prcs_dtl;
      wstring c_srs_case_opinion;
      string c_dpt_cde;
      string t_rpt_mdfy_tm;
      string c_prcs_dpt_cde;
      string c_rpt_rgst_cde;
      string t_insrnc_bgn_tm;
      string t_insrnc_end_tm;
      double n_amt;
      string c_amt_cur;
      string c_car_no;
      string c_lcn_no;
      string c_brnd_cde;
      string c_eng_no;
      wstring c_accdnt_dtl;
      string c_rpt_prcs_mrk;
      wstring c_brnd_cnm;
      string c_internet_typ;
      string c_prt_dcn_no;
      string c_srvy_mrk;
      string c_agencysrvy_mrk;
      string c_insrnc_cls;
      string t_rpt_rgst_tm;
      string c_clm_rgst_mrk;
    };
</pre>
</p>
*/
abstract public class CaseRptInfoHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.nia.orb.CaseRptInfo read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.nia.orb.CaseRptInfo result = new com.mcip.nia.orb.CaseRptInfo();
    result.c_ply_no = _input.read_string();
    result.c_rpt_no = _input.read_string();
    result.c_clm_no = _input.read_string();
    result.c_insrnt_nme = _input.read_wstring();
    result.c_insrnt_cde = _input.read_string();
    result.c_insrnc_tgt = _input.read_wstring();
    result.c_rpt_nme = _input.read_wstring();
    result.c_srs_case_mrk = _input.read_string();
    result.c_rpt_addr_tel = _input.read_wstring();
    result.t_rtp_tm = _input.read_string();
    result.t_accdnt_tm = _input.read_string();
    result.c_accdnt_spot = _input.read_wstring();
    result.c_accdnt_caus = _input.read_wstring();
    result.c_los_dtl = _input.read_wstring();
    result.c_cur_typ = _input.read_string();
    result.n_rpt_amt = _input.read_double();
    result.c_insrnc_cde = _input.read_string();
    result.c_rcvr_cde = _input.read_string();
    result.c_opinion = _input.read_wstring();
    result.c_remark = _input.read_wstring();
    result.c_tgt_los_dtl = _input.read_wstring();
    result.c_hlp_exp = _input.read_wstring();
    result.c_thd_los = _input.read_wstring();
    result.c_clm_prcs_dtl = _input.read_wstring();
    result.c_srs_case_opinion = _input.read_wstring();
    result.c_dpt_cde = _input.read_string();
    result.t_rpt_mdfy_tm = _input.read_string();
    result.c_prcs_dpt_cde = _input.read_string();
    result.c_rpt_rgst_cde = _input.read_string();
    result.t_insrnc_bgn_tm = _input.read_string();
    result.t_insrnc_end_tm = _input.read_string();
    result.n_amt = _input.read_double();
    result.c_amt_cur = _input.read_string();
    result.c_car_no = _input.read_string();
    result.c_lcn_no = _input.read_string();
    result.c_brnd_cde = _input.read_string();
    result.c_eng_no = _input.read_string();
    result.c_accdnt_dtl = _input.read_wstring();
    result.c_rpt_prcs_mrk = _input.read_string();
    result.c_brnd_cnm = _input.read_wstring();
    result.c_internet_typ = _input.read_string();
    result.c_prt_dcn_no = _input.read_string();
    result.c_srvy_mrk = _input.read_string();
    result.c_agencysrvy_mrk = _input.read_string();
    result.c_insrnc_cls = _input.read_string();
    result.t_rpt_rgst_tm = _input.read_string();
    result.c_clm_rgst_mrk = _input.read_string();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.CaseRptInfo value) {
    _output.write_string(value.c_ply_no);
    _output.write_string(value.c_rpt_no);
    _output.write_string(value.c_clm_no);
    _output.write_wstring(value.c_insrnt_nme);
    _output.write_string(value.c_insrnt_cde);
    _output.write_wstring(value.c_insrnc_tgt);
    _output.write_wstring(value.c_rpt_nme);
    _output.write_string(value.c_srs_case_mrk);
    _output.write_wstring(value.c_rpt_addr_tel);
    _output.write_string(value.t_rtp_tm);
    _output.write_string(value.t_accdnt_tm);
    _output.write_wstring(value.c_accdnt_spot);
    _output.write_wstring(value.c_accdnt_caus);
    _output.write_wstring(value.c_los_dtl);
    _output.write_string(value.c_cur_typ);
    _output.write_double(value.n_rpt_amt);
    _output.write_string(value.c_insrnc_cde);
    _output.write_string(value.c_rcvr_cde);
    _output.write_wstring(value.c_opinion);
    _output.write_wstring(value.c_remark);
    _output.write_wstring(value.c_tgt_los_dtl);
    _output.write_wstring(value.c_hlp_exp);
    _output.write_wstring(value.c_thd_los);
    _output.write_wstring(value.c_clm_prcs_dtl);
    _output.write_wstring(value.c_srs_case_opinion);
    _output.write_string(value.c_dpt_cde);
    _output.write_string(value.t_rpt_mdfy_tm);
    _output.write_string(value.c_prcs_dpt_cde);
    _output.write_string(value.c_rpt_rgst_cde);
    _output.write_string(value.t_insrnc_bgn_tm);
    _output.write_string(value.t_insrnc_end_tm);
    _output.write_double(value.n_amt);
    _output.write_string(value.c_amt_cur);
    _output.write_string(value.c_car_no);
    _output.write_string(value.c_lcn_no);
    _output.write_string(value.c_brnd_cde);
    _output.write_string(value.c_eng_no);
    _output.write_wstring(value.c_accdnt_dtl);
    _output.write_string(value.c_rpt_prcs_mrk);
    _output.write_wstring(value.c_brnd_cnm);
    _output.write_string(value.c_internet_typ);
    _output.write_string(value.c_prt_dcn_no);
    _output.write_string(value.c_srvy_mrk);
    _output.write_string(value.c_agencysrvy_mrk);
    _output.write_string(value.c_insrnc_cls);
    _output.write_string(value.t_rpt_rgst_tm);
    _output.write_string(value.c_clm_rgst_mrk);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.CaseRptInfo value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.CaseRptInfo extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[47];
      members[0] = new org.omg.CORBA.StructMember("c_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[1] = new org.omg.CORBA.StructMember("c_rpt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[2] = new org.omg.CORBA.StructMember("c_clm_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[3] = new org.omg.CORBA.StructMember("c_insrnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[4] = new org.omg.CORBA.StructMember("c_insrnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[5] = new org.omg.CORBA.StructMember("c_insrnc_tgt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[6] = new org.omg.CORBA.StructMember("c_rpt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[7] = new org.omg.CORBA.StructMember("c_srs_case_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[8] = new org.omg.CORBA.StructMember("c_rpt_addr_tel", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[9] = new org.omg.CORBA.StructMember("t_rtp_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[10] = new org.omg.CORBA.StructMember("t_accdnt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[11] = new org.omg.CORBA.StructMember("c_accdnt_spot", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[12] = new org.omg.CORBA.StructMember("c_accdnt_caus", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[13] = new org.omg.CORBA.StructMember("c_los_dtl", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[14] = new org.omg.CORBA.StructMember("c_cur_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[15] = new org.omg.CORBA.StructMember("n_rpt_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[16] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[17] = new org.omg.CORBA.StructMember("c_rcvr_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[18] = new org.omg.CORBA.StructMember("c_opinion", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[19] = new org.omg.CORBA.StructMember("c_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[20] = new org.omg.CORBA.StructMember("c_tgt_los_dtl", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[21] = new org.omg.CORBA.StructMember("c_hlp_exp", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[22] = new org.omg.CORBA.StructMember("c_thd_los", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[23] = new org.omg.CORBA.StructMember("c_clm_prcs_dtl", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[24] = new org.omg.CORBA.StructMember("c_srs_case_opinion", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[25] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[26] = new org.omg.CORBA.StructMember("t_rpt_mdfy_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[27] = new org.omg.CORBA.StructMember("c_prcs_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[28] = new org.omg.CORBA.StructMember("c_rpt_rgst_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[29] = new org.omg.CORBA.StructMember("t_insrnc_bgn_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[30] = new org.omg.CORBA.StructMember("t_insrnc_end_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[31] = new org.omg.CORBA.StructMember("n_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
      members[32] = new org.omg.CORBA.StructMember("c_amt_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[33] = new org.omg.CORBA.StructMember("c_car_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[34] = new org.omg.CORBA.StructMember("c_lcn_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[35] = new org.omg.CORBA.StructMember("c_brnd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[36] = new org.omg.CORBA.StructMember("c_eng_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[37] = new org.omg.CORBA.StructMember("c_accdnt_dtl", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[38] = new org.omg.CORBA.StructMember("c_rpt_prcs_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[39] = new org.omg.CORBA.StructMember("c_brnd_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[40] = new org.omg.CORBA.StructMember("c_internet_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[41] = new org.omg.CORBA.StructMember("c_prt_dcn_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[42] = new org.omg.CORBA.StructMember("c_srvy_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[43] = new org.omg.CORBA.StructMember("c_agencysrvy_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[44] = new org.omg.CORBA.StructMember("c_insrnc_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[45] = new org.omg.CORBA.StructMember("t_rpt_rgst_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      members[46] = new org.omg.CORBA.StructMember("c_clm_rgst_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
      _type = (_orb()).create_struct_tc(id(), "CaseRptInfo", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/CaseRptInfo:1.0";
  }
}
