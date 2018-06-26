package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::OpenCoverInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/OpenCoverInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct OpenCoverInfo {
  ...
};
 * </pre>
 */
public final class OpenCoverInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.OpenCoverInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.OpenCoverInfo _result = new com.mcip.nia.orb.OpenCoverInfo();
    _result.c_open_cover_no = _input.read_string();
    _result.c_auth_mrk = _input.read_string();
    _result.c_udr_mrk = _input.read_string();
    _result.c_dpt_cde = _input.read_string();
    _result.t_effc_tm = _input.read_string();
    _result.t_co_strt_tm = _input.read_string();
    _result.t_co_end_tm = _input.read_string();
    _result.c_undr_prsn = _input.read_wstring();
    _result.c_insrnc_cde = _input.read_string();
    _result.c_sls_cde = _input.read_string();
    _result.n_rate = _input.read_double();
    _result.c_insrnt_cde = _input.read_string();
    _result.c_insrnt_nme = _input.read_wstring();
    _result.c_app_cde = _input.read_string();
    _result.c_app_nme = _input.read_wstring();
    _result.c_crt_prsn = _input.read_wstring();
    _result.t_undr_tm = _input.read_string();
    _result.c_ara_cde = _input.read_string();
    _result.c_province = _input.read_wstring();
    _result.c_city = _input.read_wstring();
    _result.c_place = _input.read_wstring();
    _result.c_contact_name = _input.read_wstring();
    _result.c_contact_phone = _input.read_string();
    _result.c_contact_fax = _input.read_string();
    _result.c_contact_email = _input.read_wstring();
    _result.c_need_ply_no = _input.read_string();
    _result.c_need_change = _input.read_string();
    _result.c_undr_cndtn = _input.read_wstring();
    _result.c_no_repay_desc = _input.read_wstring();
    _result.n_busi_amt = _input.read_string();
    _result.c_busi_cur = _input.read_string();
    _result.c_bus_feather = _input.read_wstring();
    _result.c_srvy_cde = _input.read_string();
    _result.c_srvy_cnm = _input.read_wstring();
    _result.c_pay_addr = _input.read_wstring();
    _result.c_carriage_cde = _input.read_string();
    _result.c_from_prt = _input.read_wstring();
    _result.c_to_prt = _input.read_wstring();
    _result.c_frm_prt_ara = _input.read_string();
    _result.c_to_prt_ara = _input.read_string();
    _result.c_pass_prt = _input.read_wstring();
    _result.c_crgo_cls = _input.read_string();
    _result.c_crgo_cde = _input.read_string();
    _result.c_crgo_name = _input.read_wstring();
    _result.c_amount = _input.read_string();
    _result.c_pack_cde = _input.read_string();
    _result.c_pack_cnm = _input.read_wstring();
    _result.c_mark = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.OpenCoverInfo _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_open_cover_no);
    _output.write_string((java.lang.String)_vis_value.c_auth_mrk);
    _output.write_string((java.lang.String)_vis_value.c_udr_mrk);
    _output.write_string((java.lang.String)_vis_value.c_dpt_cde);
    _output.write_string((java.lang.String)_vis_value.t_effc_tm);
    _output.write_string((java.lang.String)_vis_value.t_co_strt_tm);
    _output.write_string((java.lang.String)_vis_value.t_co_end_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_prsn);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_string((java.lang.String)_vis_value.c_sls_cde);
    _output.write_double((double)_vis_value.n_rate);
    _output.write_string((java.lang.String)_vis_value.c_insrnt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnt_nme);
    _output.write_string((java.lang.String)_vis_value.c_app_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_app_nme);
    _output.write_wstring((java.lang.String)_vis_value.c_crt_prsn);
    _output.write_string((java.lang.String)_vis_value.t_undr_tm);
    _output.write_string((java.lang.String)_vis_value.c_ara_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_province);
    _output.write_wstring((java.lang.String)_vis_value.c_city);
    _output.write_wstring((java.lang.String)_vis_value.c_place);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_name);
    _output.write_string((java.lang.String)_vis_value.c_contact_phone);
    _output.write_string((java.lang.String)_vis_value.c_contact_fax);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_email);
    _output.write_string((java.lang.String)_vis_value.c_need_ply_no);
    _output.write_string((java.lang.String)_vis_value.c_need_change);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_cndtn);
    _output.write_wstring((java.lang.String)_vis_value.c_no_repay_desc);
    _output.write_string((java.lang.String)_vis_value.n_busi_amt);
    _output.write_string((java.lang.String)_vis_value.c_busi_cur);
    _output.write_wstring((java.lang.String)_vis_value.c_bus_feather);
    _output.write_string((java.lang.String)_vis_value.c_srvy_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_srvy_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_addr);
    _output.write_string((java.lang.String)_vis_value.c_carriage_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_from_prt);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt);
    _output.write_string((java.lang.String)_vis_value.c_frm_prt_ara);
    _output.write_string((java.lang.String)_vis_value.c_to_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_pass_prt);
    _output.write_string((java.lang.String)_vis_value.c_crgo_cls);
    _output.write_string((java.lang.String)_vis_value.c_crgo_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_name);
    _output.write_string((java.lang.String)_vis_value.c_amount);
    _output.write_string((java.lang.String)_vis_value.c_pack_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_pack_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_mark);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.OpenCoverInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.OpenCoverInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.OpenCoverInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.OpenCoverInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.OpenCoverInfoHolder _vis_holder = new com.mcip.nia.orb.OpenCoverInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.OpenCoverInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[48];
          members[0] = new org.omg.CORBA.StructMember("c_open_cover_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("c_auth_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[2] = new org.omg.CORBA.StructMember("c_udr_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[4] = new org.omg.CORBA.StructMember("t_effc_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[5] = new org.omg.CORBA.StructMember("t_co_strt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[6] = new org.omg.CORBA.StructMember("t_co_end_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[7] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[9] = new org.omg.CORBA.StructMember("c_sls_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[10] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[11] = new org.omg.CORBA.StructMember("c_insrnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[12] = new org.omg.CORBA.StructMember("c_insrnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[13] = new org.omg.CORBA.StructMember("c_app_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[14] = new org.omg.CORBA.StructMember("c_app_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[15] = new org.omg.CORBA.StructMember("c_crt_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[16] = new org.omg.CORBA.StructMember("t_undr_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[17] = new org.omg.CORBA.StructMember("c_ara_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[18] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[19] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[20] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[21] = new org.omg.CORBA.StructMember("c_contact_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[22] = new org.omg.CORBA.StructMember("c_contact_phone", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[23] = new org.omg.CORBA.StructMember("c_contact_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[24] = new org.omg.CORBA.StructMember("c_contact_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[25] = new org.omg.CORBA.StructMember("c_need_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[26] = new org.omg.CORBA.StructMember("c_need_change", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[27] = new org.omg.CORBA.StructMember("c_undr_cndtn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[28] = new org.omg.CORBA.StructMember("c_no_repay_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[29] = new org.omg.CORBA.StructMember("n_busi_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[30] = new org.omg.CORBA.StructMember("c_busi_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[31] = new org.omg.CORBA.StructMember("c_bus_feather", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[32] = new org.omg.CORBA.StructMember("c_srvy_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[33] = new org.omg.CORBA.StructMember("c_srvy_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[34] = new org.omg.CORBA.StructMember("c_pay_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[35] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[36] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[37] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[38] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[39] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[40] = new org.omg.CORBA.StructMember("c_pass_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[41] = new org.omg.CORBA.StructMember("c_crgo_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[42] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[43] = new org.omg.CORBA.StructMember("c_crgo_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[44] = new org.omg.CORBA.StructMember("c_amount", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[45] = new org.omg.CORBA.StructMember("c_pack_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[46] = new org.omg.CORBA.StructMember("c_pack_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[47] = new org.omg.CORBA.StructMember("c_mark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "OpenCoverInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/OpenCoverInfo:1.0";
  }
}
