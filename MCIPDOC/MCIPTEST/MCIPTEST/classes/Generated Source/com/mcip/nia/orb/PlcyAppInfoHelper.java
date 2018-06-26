package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlcyAppInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlcyAppInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlcyAppInfo {
  ...
};
 * </pre>
 */
public final class PlcyAppInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlcyAppInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlcyAppInfo _result = new com.mcip.nia.orb.PlcyAppInfo();
    _result.c_ply_app_no = _input.read_string();
    _result.c_ply_no = _input.read_string();
    _result.c_orig_ply_no = _input.read_string();
    _result.c_dpt_cde = _input.read_string();
    _result.c_bsns_typ = _input.read_string();
    _result.c_cmpny_agt_cde = _input.read_string();
    _result.c_cmpny_agt_nme = _input.read_wstring();
    _result.c_agt_agr_no = _input.read_string();
    _result.n_sub_co_no = _input.read_long();
    _result.c_brkr_cde = _input.read_string();
    _result.c_brkr_nme = _input.read_wstring();
    _result.c_sls_cde = _input.read_string();
    _result.c_sls_nme = _input.read_wstring();
    _result.c_insrnc_cmpny_cde = _input.read_string();
    _result.c_insrnc_cmpny_nme = _input.read_wstring();
    _result.c_insrnt_cde = _input.read_string();
    _result.c_insrnt_nme = _input.read_wstring();
    _result.c_insrnt_addr = _input.read_wstring();
    _result.c_bnfc_cde = _input.read_string();
    _result.c_bnfc_nme = _input.read_wstring();
    _result.c_app_cde = _input.read_string();
    _result.c_app_nme = _input.read_wstring();
    _result.c_app_addr = _input.read_wstring();
    _result.c_app_tel = _input.read_string();
    _result.c_insrnc_cde = _input.read_string();
    _result.c_claus_cde = _input.read_string();
    _result.t_app_tm = _input.read_string();
    _result.t_insrnc_bgn_tm = _input.read_string();
    _result.t_insrnc_end_tm = _input.read_string();
    _result.t_sign_tm = _input.read_string();
    _result.c_amt_cur = _input.read_string();
    _result.n_insrnc_vlu = _input.read_double();
    _result.n_amt = _input.read_double();
    _result.n_rate = _input.read_double();
    _result.n_prm = _input.read_double();
    _result.n_rdr_prm = _input.read_double();
    _result.n_sum_prm = _input.read_double();
    _result.c_prm_cur = _input.read_string();
    _result.n_nclm_prop = _input.read_double();
    _result.n_appnt_prop = _input.read_double();
    _result.n_cmm_prop = _input.read_double();
    _result.n_brk_prop = _input.read_double();
    _result.n_pay_tms = _input.read_long();
    _result.c_appnt = _input.read_wstring();
    _result.c_remark = _input.read_wstring();
    _result.c_crt_prsn = _input.read_wstring();
    _result.c_undr_prsn = _input.read_wstring();
    _result.t_undr_tm = _input.read_string();
    _result.c_rinsrnc_mrk = _input.read_string();
    _result.c_coinsrnc_mrk = _input.read_string();
    _result.t_input_tm = _input.read_string();
    _result.c_undr_dpt = _input.read_wstring();
    _result.c_opr_typ = _input.read_string();
    _result.c_edr_prj_no = _input.read_string();
    _result.t_next_edr_undr_tm = _input.read_string();
    _result.c_udr_mrk = _input.read_string();
    _result.c_agelong_mrk = _input.read_string();
    _result.c_ceprn_mrk = _input.read_string();
    _result.c_salegrp_cde = _input.read_string();
    _result.c_open_cover_no = _input.read_string();
    _result.c_internet_typ = _input.read_string();
    _result.c_crgo_cde = _input.read_string();
    _result.c_crgo_desc = _input.read_wstring();
    _result.c_invc_no = _input.read_wstring();
    _result.c_sail_no = _input.read_wstring();
    _result.c_prn_frm = _input.read_wstring();
    _result.c_carriage_cde = _input.read_wstring();
    _result.c_vsl_lvl_cde = _input.read_wstring();
    _result.c_from_prt = _input.read_wstring();
    _result.c_to_prt = _input.read_wstring();
    _result.c_frm_prt_ara = _input.read_string();
    _result.c_to_prt_ara = _input.read_string();
    _result.c_pass_prt = _input.read_wstring();
    _result.c_srvy_cde = _input.read_string();
    _result.c_srvy_cnm = _input.read_wstring();
    _result.c_undr_cndtn = _input.read_wstring();
    _result.c_pay_addr = _input.read_wstring();
    _result.c_receipt_no = _input.read_wstring();
    _result.c_crgo_cls = _input.read_string();
    _result.c_crgo_name = _input.read_wstring();
    _result.c_amount = _input.read_wstring();
    _result.c_pack_cde = _input.read_wstring();
    _result.c_pack_cnm = _input.read_wstring();
    _result.c_mark = _input.read_wstring();
    _result.n_invc_amt = _input.read_double();
    _result.c_invc_amt_cur = _input.read_wstring();
    _result.c_no_repay = _input.read_wstring();
    _result.c_credit_id = _input.read_string();
    _result.c_lost_desc = _input.read_wstring();
    _result.c_container = _input.read_wstring();
    _result.c_add_risk = _input.read_wstring();
    _result.c_main_insurance = _input.read_string();
    _result.c_add_insurance = _input.read_string();
    _result.c_rdr_cde = _input.read_string();
    _result.c_rdr_nme = _input.read_wstring();
    _result.c_rmk_desc = _input.read_wstring();
    _result.c_province = _input.read_string();
    _result.c_city = _input.read_string();
    _result.c_place = _input.read_wstring();
    _result.c_contact_name = _input.read_wstring();
    _result.c_contact_phone = _input.read_string();
    _result.c_contact_fax = _input.read_string();
    _result.c_contact_email = _input.read_wstring();
    _result.c_pay_mde_cde = _input.read_string();
    _result.c_site_cde = _input.read_wstring();
    _result.c_zip_cde = _input.read_wstring();
    _result.c_srvy_addr = _input.read_wstring();
    _result.c_edr_info = _input.read_wstring();
    _result.c_mdfy_tm = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlcyAppInfo _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_ply_app_no);
    _output.write_string((java.lang.String)_vis_value.c_ply_no);
    _output.write_string((java.lang.String)_vis_value.c_orig_ply_no);
    _output.write_string((java.lang.String)_vis_value.c_dpt_cde);
    _output.write_string((java.lang.String)_vis_value.c_bsns_typ);
    _output.write_string((java.lang.String)_vis_value.c_cmpny_agt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_cmpny_agt_nme);
    _output.write_string((java.lang.String)_vis_value.c_agt_agr_no);
    _output.write_long((int)_vis_value.n_sub_co_no);
    _output.write_string((java.lang.String)_vis_value.c_brkr_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_brkr_nme);
    _output.write_string((java.lang.String)_vis_value.c_sls_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_sls_nme);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cmpny_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_cmpny_nme);
    _output.write_string((java.lang.String)_vis_value.c_insrnt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnt_nme);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnt_addr);
    _output.write_string((java.lang.String)_vis_value.c_bnfc_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_bnfc_nme);
    _output.write_string((java.lang.String)_vis_value.c_app_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_app_nme);
    _output.write_wstring((java.lang.String)_vis_value.c_app_addr);
    _output.write_string((java.lang.String)_vis_value.c_app_tel);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_string((java.lang.String)_vis_value.c_claus_cde);
    _output.write_string((java.lang.String)_vis_value.t_app_tm);
    _output.write_string((java.lang.String)_vis_value.t_insrnc_bgn_tm);
    _output.write_string((java.lang.String)_vis_value.t_insrnc_end_tm);
    _output.write_string((java.lang.String)_vis_value.t_sign_tm);
    _output.write_string((java.lang.String)_vis_value.c_amt_cur);
    _output.write_double((double)_vis_value.n_insrnc_vlu);
    _output.write_double((double)_vis_value.n_amt);
    _output.write_double((double)_vis_value.n_rate);
    _output.write_double((double)_vis_value.n_prm);
    _output.write_double((double)_vis_value.n_rdr_prm);
    _output.write_double((double)_vis_value.n_sum_prm);
    _output.write_string((java.lang.String)_vis_value.c_prm_cur);
    _output.write_double((double)_vis_value.n_nclm_prop);
    _output.write_double((double)_vis_value.n_appnt_prop);
    _output.write_double((double)_vis_value.n_cmm_prop);
    _output.write_double((double)_vis_value.n_brk_prop);
    _output.write_long((int)_vis_value.n_pay_tms);
    _output.write_wstring((java.lang.String)_vis_value.c_appnt);
    _output.write_wstring((java.lang.String)_vis_value.c_remark);
    _output.write_wstring((java.lang.String)_vis_value.c_crt_prsn);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_prsn);
    _output.write_string((java.lang.String)_vis_value.t_undr_tm);
    _output.write_string((java.lang.String)_vis_value.c_rinsrnc_mrk);
    _output.write_string((java.lang.String)_vis_value.c_coinsrnc_mrk);
    _output.write_string((java.lang.String)_vis_value.t_input_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_dpt);
    _output.write_string((java.lang.String)_vis_value.c_opr_typ);
    _output.write_string((java.lang.String)_vis_value.c_edr_prj_no);
    _output.write_string((java.lang.String)_vis_value.t_next_edr_undr_tm);
    _output.write_string((java.lang.String)_vis_value.c_udr_mrk);
    _output.write_string((java.lang.String)_vis_value.c_agelong_mrk);
    _output.write_string((java.lang.String)_vis_value.c_ceprn_mrk);
    _output.write_string((java.lang.String)_vis_value.c_salegrp_cde);
    _output.write_string((java.lang.String)_vis_value.c_open_cover_no);
    _output.write_string((java.lang.String)_vis_value.c_internet_typ);
    _output.write_string((java.lang.String)_vis_value.c_crgo_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_desc);
    _output.write_wstring((java.lang.String)_vis_value.c_invc_no);
    _output.write_wstring((java.lang.String)_vis_value.c_sail_no);
    _output.write_wstring((java.lang.String)_vis_value.c_prn_frm);
    _output.write_wstring((java.lang.String)_vis_value.c_carriage_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_vsl_lvl_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_from_prt);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt);
    _output.write_string((java.lang.String)_vis_value.c_frm_prt_ara);
    _output.write_string((java.lang.String)_vis_value.c_to_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_pass_prt);
    _output.write_string((java.lang.String)_vis_value.c_srvy_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_srvy_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_cndtn);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_addr);
    _output.write_wstring((java.lang.String)_vis_value.c_receipt_no);
    _output.write_string((java.lang.String)_vis_value.c_crgo_cls);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_name);
    _output.write_wstring((java.lang.String)_vis_value.c_amount);
    _output.write_wstring((java.lang.String)_vis_value.c_pack_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_pack_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_mark);
    _output.write_double((double)_vis_value.n_invc_amt);
    _output.write_wstring((java.lang.String)_vis_value.c_invc_amt_cur);
    _output.write_wstring((java.lang.String)_vis_value.c_no_repay);
    _output.write_string((java.lang.String)_vis_value.c_credit_id);
    _output.write_wstring((java.lang.String)_vis_value.c_lost_desc);
    _output.write_wstring((java.lang.String)_vis_value.c_container);
    _output.write_wstring((java.lang.String)_vis_value.c_add_risk);
    _output.write_string((java.lang.String)_vis_value.c_main_insurance);
    _output.write_string((java.lang.String)_vis_value.c_add_insurance);
    _output.write_string((java.lang.String)_vis_value.c_rdr_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_rdr_nme);
    _output.write_wstring((java.lang.String)_vis_value.c_rmk_desc);
    _output.write_string((java.lang.String)_vis_value.c_province);
    _output.write_string((java.lang.String)_vis_value.c_city);
    _output.write_wstring((java.lang.String)_vis_value.c_place);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_name);
    _output.write_string((java.lang.String)_vis_value.c_contact_phone);
    _output.write_string((java.lang.String)_vis_value.c_contact_fax);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_email);
    _output.write_string((java.lang.String)_vis_value.c_pay_mde_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_site_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_zip_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_srvy_addr);
    _output.write_wstring((java.lang.String)_vis_value.c_edr_info);
    _output.write_string((java.lang.String)_vis_value.c_mdfy_tm);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlcyAppInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlcyAppInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlcyAppInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlcyAppInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlcyAppInfoHolder _vis_holder = new com.mcip.nia.orb.PlcyAppInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlcyAppInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[109];
          members[0] = new org.omg.CORBA.StructMember("c_ply_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("c_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[2] = new org.omg.CORBA.StructMember("c_orig_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[4] = new org.omg.CORBA.StructMember("c_bsns_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[5] = new org.omg.CORBA.StructMember("c_cmpny_agt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[6] = new org.omg.CORBA.StructMember("c_cmpny_agt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[7] = new org.omg.CORBA.StructMember("c_agt_agr_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[8] = new org.omg.CORBA.StructMember("n_sub_co_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
          members[9] = new org.omg.CORBA.StructMember("c_brkr_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[10] = new org.omg.CORBA.StructMember("c_brkr_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[11] = new org.omg.CORBA.StructMember("c_sls_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[12] = new org.omg.CORBA.StructMember("c_sls_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[13] = new org.omg.CORBA.StructMember("c_insrnc_cmpny_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[14] = new org.omg.CORBA.StructMember("c_insrnc_cmpny_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[15] = new org.omg.CORBA.StructMember("c_insrnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[16] = new org.omg.CORBA.StructMember("c_insrnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[17] = new org.omg.CORBA.StructMember("c_insrnt_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[18] = new org.omg.CORBA.StructMember("c_bnfc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[19] = new org.omg.CORBA.StructMember("c_bnfc_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[20] = new org.omg.CORBA.StructMember("c_app_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[21] = new org.omg.CORBA.StructMember("c_app_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[22] = new org.omg.CORBA.StructMember("c_app_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[23] = new org.omg.CORBA.StructMember("c_app_tel", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[24] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[25] = new org.omg.CORBA.StructMember("c_claus_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[26] = new org.omg.CORBA.StructMember("t_app_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[27] = new org.omg.CORBA.StructMember("t_insrnc_bgn_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[28] = new org.omg.CORBA.StructMember("t_insrnc_end_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[29] = new org.omg.CORBA.StructMember("t_sign_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[30] = new org.omg.CORBA.StructMember("c_amt_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[31] = new org.omg.CORBA.StructMember("n_insrnc_vlu", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[32] = new org.omg.CORBA.StructMember("n_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[33] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[34] = new org.omg.CORBA.StructMember("n_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[35] = new org.omg.CORBA.StructMember("n_rdr_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[36] = new org.omg.CORBA.StructMember("n_sum_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[37] = new org.omg.CORBA.StructMember("c_prm_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[38] = new org.omg.CORBA.StructMember("n_nclm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[39] = new org.omg.CORBA.StructMember("n_appnt_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[40] = new org.omg.CORBA.StructMember("n_cmm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[41] = new org.omg.CORBA.StructMember("n_brk_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[42] = new org.omg.CORBA.StructMember("n_pay_tms", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
          members[43] = new org.omg.CORBA.StructMember("c_appnt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[44] = new org.omg.CORBA.StructMember("c_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[45] = new org.omg.CORBA.StructMember("c_crt_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[46] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[47] = new org.omg.CORBA.StructMember("t_undr_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[48] = new org.omg.CORBA.StructMember("c_rinsrnc_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[49] = new org.omg.CORBA.StructMember("c_coinsrnc_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[50] = new org.omg.CORBA.StructMember("t_input_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[51] = new org.omg.CORBA.StructMember("c_undr_dpt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[52] = new org.omg.CORBA.StructMember("c_opr_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[53] = new org.omg.CORBA.StructMember("c_edr_prj_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[54] = new org.omg.CORBA.StructMember("t_next_edr_undr_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[55] = new org.omg.CORBA.StructMember("c_udr_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[56] = new org.omg.CORBA.StructMember("c_agelong_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[57] = new org.omg.CORBA.StructMember("c_ceprn_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[58] = new org.omg.CORBA.StructMember("c_salegrp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[59] = new org.omg.CORBA.StructMember("c_open_cover_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[60] = new org.omg.CORBA.StructMember("c_internet_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[61] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[62] = new org.omg.CORBA.StructMember("c_crgo_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[63] = new org.omg.CORBA.StructMember("c_invc_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[64] = new org.omg.CORBA.StructMember("c_sail_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[65] = new org.omg.CORBA.StructMember("c_prn_frm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[66] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[67] = new org.omg.CORBA.StructMember("c_vsl_lvl_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[68] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[69] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[70] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[71] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[72] = new org.omg.CORBA.StructMember("c_pass_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[73] = new org.omg.CORBA.StructMember("c_srvy_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[74] = new org.omg.CORBA.StructMember("c_srvy_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[75] = new org.omg.CORBA.StructMember("c_undr_cndtn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[76] = new org.omg.CORBA.StructMember("c_pay_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[77] = new org.omg.CORBA.StructMember("c_receipt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[78] = new org.omg.CORBA.StructMember("c_crgo_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[79] = new org.omg.CORBA.StructMember("c_crgo_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[80] = new org.omg.CORBA.StructMember("c_amount", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[81] = new org.omg.CORBA.StructMember("c_pack_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[82] = new org.omg.CORBA.StructMember("c_pack_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[83] = new org.omg.CORBA.StructMember("c_mark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[84] = new org.omg.CORBA.StructMember("n_invc_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[85] = new org.omg.CORBA.StructMember("c_invc_amt_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[86] = new org.omg.CORBA.StructMember("c_no_repay", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[87] = new org.omg.CORBA.StructMember("c_credit_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[88] = new org.omg.CORBA.StructMember("c_lost_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[89] = new org.omg.CORBA.StructMember("c_container", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[90] = new org.omg.CORBA.StructMember("c_add_risk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[91] = new org.omg.CORBA.StructMember("c_main_insurance", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[92] = new org.omg.CORBA.StructMember("c_add_insurance", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[93] = new org.omg.CORBA.StructMember("c_rdr_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[94] = new org.omg.CORBA.StructMember("c_rdr_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[95] = new org.omg.CORBA.StructMember("c_rmk_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[96] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[97] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[98] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[99] = new org.omg.CORBA.StructMember("c_contact_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[100] = new org.omg.CORBA.StructMember("c_contact_phone", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[101] = new org.omg.CORBA.StructMember("c_contact_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[102] = new org.omg.CORBA.StructMember("c_contact_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[103] = new org.omg.CORBA.StructMember("c_pay_mde_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[104] = new org.omg.CORBA.StructMember("c_site_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[105] = new org.omg.CORBA.StructMember("c_zip_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[106] = new org.omg.CORBA.StructMember("c_srvy_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[107] = new org.omg.CORBA.StructMember("c_edr_info", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[108] = new org.omg.CORBA.StructMember("c_mdfy_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "PlcyAppInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlcyAppInfo:1.0";
  }
}
