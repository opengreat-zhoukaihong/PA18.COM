package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyEdrGridInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyEdrGridInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyEdrGridInfo {
  ...
};
 * </pre>
 */
public final class PlyEdrGridInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlyEdrGridInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlyEdrGridInfo _result = new com.mcip.nia.orb.PlyEdrGridInfo();
    _result.c_crt_cde = _input.read_wstring();
    _result.c_crt_tm = _input.read_wstring();
    _result.c_upd_cde = _input.read_wstring();
    _result.c_upd_tm = _input.read_wstring();
    _result.c_edr_app_no = _input.read_wstring();
    _result.c_send_tm = _input.read_wstring();
    _result.c_dpt_cde = _input.read_wstring();
    _result.c_source = _input.read_wstring();
    _result.c_send_dpt_cde = _input.read_wstring();
    _result.c_send_cde = _input.read_wstring();
    _result.c_des_dpt_cde = _input.read_wstring();
    _result.c_emergency = _input.read_wstring();
    _result.c_authprn_cde = _input.read_wstring();
    _result.c_udr_mrk = _input.read_wstring();
    _result.c_send_mrk = _input.read_wstring();
    _result.c_udr_opn_mrk = _input.read_wstring();
    _result.c_vrfy_mrk = _input.read_wstring();
    _result.c_mdfy_tm = _input.read_wstring();
    _result.c_insrnc_cde = _input.read_wstring();
    _result.c_undr_prsn = _input.read_wstring();
    _result.c_undr_dpt = _input.read_wstring();
    _result.c_prn_typ = _input.read_wstring();
    _result.c_rinsrnc_mrk = _input.read_wstring();
    _result.c_coinsrnc_mrk = _input.read_wstring();
    _result.c_ply_no = _input.read_wstring();
    _result.c_edr_no = _input.read_wstring();
    _result.c_read_tm = _input.read_wstring();
    _result.c_rec_no = _input.read_wstring();
    _result.c_flag = _input.read_wstring();
    _result.c_insrnc_dfn_typ = _input.read_wstring();
    _result.c_insrnc_cnm = _input.read_wstring();
    _result.c_edr_typ = _input.read_wstring();
    _result.c_app_nme = _input.read_wstring();
    _result.n_amt = _input.read_wstring();
    _result.t_sign_tm = _input.read_wstring();
    _result.c_rpt_desc = _input.read_wstring();
    _result.c_risk_lvl_cde = _input.read_wstring();
    _result.c_lcn_no = _input.read_wstring();
    _result.c_eng_no = _input.read_wstring();
    _result.c_insrnc_cls = _input.read_wstring();
    _result.c_use_atr = _input.read_wstring();
    _result.c_undr_opn = _input.read_wstring();
    _result.c_internet_typ = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlyEdrGridInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_crt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_crt_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_edr_app_no);
    _output.write_wstring((java.lang.String)_vis_value.c_send_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_dpt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_source);
    _output.write_wstring((java.lang.String)_vis_value.c_send_dpt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_send_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_des_dpt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_emergency);
    _output.write_wstring((java.lang.String)_vis_value.c_authprn_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_udr_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_send_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_udr_opn_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_vrfy_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_mdfy_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_prsn);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_dpt);
    _output.write_wstring((java.lang.String)_vis_value.c_prn_typ);
    _output.write_wstring((java.lang.String)_vis_value.c_rinsrnc_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_coinsrnc_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_ply_no);
    _output.write_wstring((java.lang.String)_vis_value.c_edr_no);
    _output.write_wstring((java.lang.String)_vis_value.c_read_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_rec_no);
    _output.write_wstring((java.lang.String)_vis_value.c_flag);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_dfn_typ);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_edr_typ);
    _output.write_wstring((java.lang.String)_vis_value.c_app_nme);
    _output.write_wstring((java.lang.String)_vis_value.n_amt);
    _output.write_wstring((java.lang.String)_vis_value.t_sign_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_rpt_desc);
    _output.write_wstring((java.lang.String)_vis_value.c_risk_lvl_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_lcn_no);
    _output.write_wstring((java.lang.String)_vis_value.c_eng_no);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_cls);
    _output.write_wstring((java.lang.String)_vis_value.c_use_atr);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_opn);
    _output.write_wstring((java.lang.String)_vis_value.c_internet_typ);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlyEdrGridInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlyEdrGridInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlyEdrGridInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlyEdrGridInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlyEdrGridInfoHolder _vis_holder = new com.mcip.nia.orb.PlyEdrGridInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlyEdrGridInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[43];
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
          _type = _orb().create_struct_tc(id(), "PlyEdrGridInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlyEdrGridInfo:1.0";
  }
}
