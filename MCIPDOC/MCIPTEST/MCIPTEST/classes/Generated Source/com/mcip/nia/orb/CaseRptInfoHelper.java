package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::CaseRptInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/CaseRptInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CaseRptInfo {
  ...
};
 * </pre>
 */
public final class CaseRptInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.CaseRptInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.CaseRptInfo _result = new com.mcip.nia.orb.CaseRptInfo();
    _result.c_ply_no = _input.read_string();
    _result.c_rpt_no = _input.read_string();
    _result.c_clm_no = _input.read_string();
    _result.c_insrnt_nme = _input.read_wstring();
    _result.c_insrnt_cde = _input.read_string();
    _result.c_insrnc_tgt = _input.read_wstring();
    _result.c_rpt_nme = _input.read_wstring();
    _result.c_srs_case_mrk = _input.read_string();
    _result.c_rpt_addr_tel = _input.read_wstring();
    _result.t_rtp_tm = _input.read_string();
    _result.t_accdnt_tm = _input.read_string();
    _result.c_accdnt_spot = _input.read_wstring();
    _result.c_accdnt_caus = _input.read_wstring();
    _result.c_los_dtl = _input.read_wstring();
    _result.c_cur_typ = _input.read_string();
    _result.n_rpt_amt = _input.read_double();
    _result.c_insrnc_cde = _input.read_string();
    _result.c_rcvr_cde = _input.read_string();
    _result.c_opinion = _input.read_wstring();
    _result.c_remark = _input.read_wstring();
    _result.c_tgt_los_dtl = _input.read_wstring();
    _result.c_hlp_exp = _input.read_wstring();
    _result.c_thd_los = _input.read_wstring();
    _result.c_clm_prcs_dtl = _input.read_wstring();
    _result.c_srs_case_opinion = _input.read_wstring();
    _result.c_dpt_cde = _input.read_string();
    _result.t_rpt_mdfy_tm = _input.read_string();
    _result.c_prcs_dpt_cde = _input.read_string();
    _result.c_rpt_rgst_cde = _input.read_string();
    _result.t_insrnc_bgn_tm = _input.read_string();
    _result.t_insrnc_end_tm = _input.read_string();
    _result.n_amt = _input.read_double();
    _result.c_amt_cur = _input.read_string();
    _result.c_car_no = _input.read_string();
    _result.c_lcn_no = _input.read_string();
    _result.c_brnd_cde = _input.read_string();
    _result.c_eng_no = _input.read_string();
    _result.c_accdnt_dtl = _input.read_wstring();
    _result.c_rpt_prcs_mrk = _input.read_string();
    _result.c_brnd_cnm = _input.read_wstring();
    _result.c_internet_typ = _input.read_string();
    _result.c_prt_dcn_no = _input.read_string();
    _result.c_srvy_mrk = _input.read_string();
    _result.c_agencysrvy_mrk = _input.read_string();
    _result.c_insrnc_cls = _input.read_string();
    _result.t_rpt_rgst_tm = _input.read_string();
    _result.c_clm_rgst_mrk = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.CaseRptInfo _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_ply_no);
    _output.write_string((java.lang.String)_vis_value.c_rpt_no);
    _output.write_string((java.lang.String)_vis_value.c_clm_no);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnt_nme);
    _output.write_string((java.lang.String)_vis_value.c_insrnt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_tgt);
    _output.write_wstring((java.lang.String)_vis_value.c_rpt_nme);
    _output.write_string((java.lang.String)_vis_value.c_srs_case_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_rpt_addr_tel);
    _output.write_string((java.lang.String)_vis_value.t_rtp_tm);
    _output.write_string((java.lang.String)_vis_value.t_accdnt_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_accdnt_spot);
    _output.write_wstring((java.lang.String)_vis_value.c_accdnt_caus);
    _output.write_wstring((java.lang.String)_vis_value.c_los_dtl);
    _output.write_string((java.lang.String)_vis_value.c_cur_typ);
    _output.write_double((double)_vis_value.n_rpt_amt);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_string((java.lang.String)_vis_value.c_rcvr_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_opinion);
    _output.write_wstring((java.lang.String)_vis_value.c_remark);
    _output.write_wstring((java.lang.String)_vis_value.c_tgt_los_dtl);
    _output.write_wstring((java.lang.String)_vis_value.c_hlp_exp);
    _output.write_wstring((java.lang.String)_vis_value.c_thd_los);
    _output.write_wstring((java.lang.String)_vis_value.c_clm_prcs_dtl);
    _output.write_wstring((java.lang.String)_vis_value.c_srs_case_opinion);
    _output.write_string((java.lang.String)_vis_value.c_dpt_cde);
    _output.write_string((java.lang.String)_vis_value.t_rpt_mdfy_tm);
    _output.write_string((java.lang.String)_vis_value.c_prcs_dpt_cde);
    _output.write_string((java.lang.String)_vis_value.c_rpt_rgst_cde);
    _output.write_string((java.lang.String)_vis_value.t_insrnc_bgn_tm);
    _output.write_string((java.lang.String)_vis_value.t_insrnc_end_tm);
    _output.write_double((double)_vis_value.n_amt);
    _output.write_string((java.lang.String)_vis_value.c_amt_cur);
    _output.write_string((java.lang.String)_vis_value.c_car_no);
    _output.write_string((java.lang.String)_vis_value.c_lcn_no);
    _output.write_string((java.lang.String)_vis_value.c_brnd_cde);
    _output.write_string((java.lang.String)_vis_value.c_eng_no);
    _output.write_wstring((java.lang.String)_vis_value.c_accdnt_dtl);
    _output.write_string((java.lang.String)_vis_value.c_rpt_prcs_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_brnd_cnm);
    _output.write_string((java.lang.String)_vis_value.c_internet_typ);
    _output.write_string((java.lang.String)_vis_value.c_prt_dcn_no);
    _output.write_string((java.lang.String)_vis_value.c_srvy_mrk);
    _output.write_string((java.lang.String)_vis_value.c_agencysrvy_mrk);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cls);
    _output.write_string((java.lang.String)_vis_value.t_rpt_rgst_tm);
    _output.write_string((java.lang.String)_vis_value.c_clm_rgst_mrk);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.CaseRptInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.CaseRptInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.CaseRptInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.CaseRptInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.CaseRptInfoHolder _vis_holder = new com.mcip.nia.orb.CaseRptInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.CaseRptInfoHelper.read(any.create_input_stream());
    }
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          if (_initializing) {
            return _orb().create_recursive_tc(id());
          }
          _initializing = true;
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[47];
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
          _type = _orb().create_struct_tc(id(), "CaseRptInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/CaseRptInfo:1.0";
  }
}
