package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyEdrAppCrgoInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyEdrAppCrgoInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyEdrAppCrgoInfo {
  ...
};
 * </pre>
 */
public final class PlyEdrAppCrgoInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlyEdrAppCrgoInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlyEdrAppCrgoInfo _result = new com.mcip.nia.orb.PlyEdrAppCrgoInfo();
    _result.c_crt_cde = _input.read_wstring();
    _result.c_crt_tm = _input.read_wstring();
    _result.c_upd_cde = _input.read_wstring();
    _result.c_upd_tm = _input.read_wstring();
    _result.c_edr_app_no = _input.read_wstring();
    _result.c_crgo_cde = _input.read_wstring();
    _result.c_crgo_cnm = _input.read_wstring();
    _result.c_crgo_desc = _input.read_wstring();
    _result.c_invc_no = _input.read_wstring();
    _result.c_sail_no = _input.read_wstring();
    _result.c_prn_frm = _input.read_wstring();
    _result.c_carriage_cde = _input.read_wstring();
    _result.c_vsl_lvl_cde = _input.read_wstring();
    _result.c_from_prt = _input.read_wstring();
    _result.c_to_prt = _input.read_wstring();
    _result.c_frm_prt_ara = _input.read_wstring();
    _result.c_to_prt_ara = _input.read_wstring();
    _result.c_pass_prt = _input.read_wstring();
    _result.c_srvy_cde = _input.read_wstring();
    _result.c_srvy_cnm = _input.read_wstring();
    _result.c_undr_cndtn = _input.read_wstring();
    _result.n_amt = _input.read_wstring();
    _result.n_rate = _input.read_wstring();
    _result.n_prm = _input.read_wstring();
    _result.c_pay_addr = _input.read_wstring();
    _result.c_rec_no = _input.read_wstring();
    _result.c_receipt_no = _input.read_wstring();
    _result.c_crgo_cls = _input.read_wstring();
    _result.c_crgo_name = _input.read_wstring();
    _result.c_amount = _input.read_wstring();
    _result.c_pack_cde = _input.read_wstring();
    _result.c_mark = _input.read_wstring();
    _result.n_invc_amt = _input.read_wstring();
    _result.c_invc_amt_cur = _input.read_wstring();
    _result.c_no_repay = _input.read_wstring();
    _result.c_credit_id = _input.read_wstring();
    _result.c_lost_desc = _input.read_wstring();
    _result.c_container = _input.read_wstring();
    _result.c_add_risk = _input.read_wstring();
    _result.c_pack_cnm = _input.read_wstring();
    _result.c_srvy_addr = _input.read_wstring();
    _result.c_edr_info = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlyEdrAppCrgoInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_crt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_crt_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_edr_app_no);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_desc);
    _output.write_wstring((java.lang.String)_vis_value.c_invc_no);
    _output.write_wstring((java.lang.String)_vis_value.c_sail_no);
    _output.write_wstring((java.lang.String)_vis_value.c_prn_frm);
    _output.write_wstring((java.lang.String)_vis_value.c_carriage_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_vsl_lvl_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_from_prt);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt);
    _output.write_wstring((java.lang.String)_vis_value.c_frm_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_pass_prt);
    _output.write_wstring((java.lang.String)_vis_value.c_srvy_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_srvy_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_cndtn);
    _output.write_wstring((java.lang.String)_vis_value.n_amt);
    _output.write_wstring((java.lang.String)_vis_value.n_rate);
    _output.write_wstring((java.lang.String)_vis_value.n_prm);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_addr);
    _output.write_wstring((java.lang.String)_vis_value.c_rec_no);
    _output.write_wstring((java.lang.String)_vis_value.c_receipt_no);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_cls);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_name);
    _output.write_wstring((java.lang.String)_vis_value.c_amount);
    _output.write_wstring((java.lang.String)_vis_value.c_pack_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_mark);
    _output.write_wstring((java.lang.String)_vis_value.n_invc_amt);
    _output.write_wstring((java.lang.String)_vis_value.c_invc_amt_cur);
    _output.write_wstring((java.lang.String)_vis_value.c_no_repay);
    _output.write_wstring((java.lang.String)_vis_value.c_credit_id);
    _output.write_wstring((java.lang.String)_vis_value.c_lost_desc);
    _output.write_wstring((java.lang.String)_vis_value.c_container);
    _output.write_wstring((java.lang.String)_vis_value.c_add_risk);
    _output.write_wstring((java.lang.String)_vis_value.c_pack_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_srvy_addr);
    _output.write_wstring((java.lang.String)_vis_value.c_edr_info);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlyEdrAppCrgoInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlyEdrAppCrgoInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlyEdrAppCrgoInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlyEdrAppCrgoInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlyEdrAppCrgoInfoHolder _vis_holder = new com.mcip.nia.orb.PlyEdrAppCrgoInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[42];
          members[0] = new org.omg.CORBA.StructMember("c_crt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("c_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("c_upd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[3] = new org.omg.CORBA.StructMember("c_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("c_edr_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[5] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[6] = new org.omg.CORBA.StructMember("c_crgo_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[7] = new org.omg.CORBA.StructMember("c_crgo_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("c_invc_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[9] = new org.omg.CORBA.StructMember("c_sail_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[10] = new org.omg.CORBA.StructMember("c_prn_frm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[11] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[12] = new org.omg.CORBA.StructMember("c_vsl_lvl_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[13] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[14] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[15] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[16] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[17] = new org.omg.CORBA.StructMember("c_pass_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[18] = new org.omg.CORBA.StructMember("c_srvy_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[19] = new org.omg.CORBA.StructMember("c_srvy_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[20] = new org.omg.CORBA.StructMember("c_undr_cndtn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[21] = new org.omg.CORBA.StructMember("n_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[22] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[23] = new org.omg.CORBA.StructMember("n_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[24] = new org.omg.CORBA.StructMember("c_pay_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[25] = new org.omg.CORBA.StructMember("c_rec_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[26] = new org.omg.CORBA.StructMember("c_receipt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[27] = new org.omg.CORBA.StructMember("c_crgo_cls", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[28] = new org.omg.CORBA.StructMember("c_crgo_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[29] = new org.omg.CORBA.StructMember("c_amount", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[30] = new org.omg.CORBA.StructMember("c_pack_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[31] = new org.omg.CORBA.StructMember("c_mark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[32] = new org.omg.CORBA.StructMember("n_invc_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[33] = new org.omg.CORBA.StructMember("c_invc_amt_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[34] = new org.omg.CORBA.StructMember("c_no_repay", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[35] = new org.omg.CORBA.StructMember("c_credit_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[36] = new org.omg.CORBA.StructMember("c_lost_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[37] = new org.omg.CORBA.StructMember("c_container", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[38] = new org.omg.CORBA.StructMember("c_add_risk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[39] = new org.omg.CORBA.StructMember("c_pack_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[40] = new org.omg.CORBA.StructMember("c_srvy_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[41] = new org.omg.CORBA.StructMember("c_edr_info", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "PlyEdrAppCrgoInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlyEdrAppCrgoInfo:1.0";
  }
}
