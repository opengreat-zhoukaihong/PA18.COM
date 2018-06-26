package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyEdrAppPayInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyEdrAppPayInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyEdrAppPayInfo {
  ...
};
 * </pre>
 */
public final class PlyEdrAppPayInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlyEdrAppPayInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlyEdrAppPayInfo _result = new com.mcip.nia.orb.PlyEdrAppPayInfo();
    _result.c_crt_cde = _input.read_wstring();
    _result.c_crt_tm = _input.read_wstring();
    _result.c_upd_cde = _input.read_wstring();
    _result.c_upd_tm = _input.read_wstring();
    _result.c_edr_app_no = _input.read_wstring();
    _result.n_tms = _input.read_wstring();
    _result.c_rcpt_no = _input.read_wstring();
    _result.c_pay_prsn_cde = _input.read_wstring();
    _result.c_pay_prsn_nme = _input.read_wstring();
    _result.n_get_prm = _input.read_wstring();
    _result.c_pay_mde_cde = _input.read_wstring();
    _result.c_accnt_no = _input.read_wstring();
    _result.t_pay_lmt_tm = _input.read_wstring();
    _result.n_got_prm = _input.read_wstring();
    _result.t_pay_strt_tm = _input.read_wstring();
    _result.t_pay_tm = _input.read_wstring();
    _result.c_insrnc_cde = _input.read_wstring();
    _result.c_cur_typ = _input.read_wstring();
    _result.c_rec_no = _input.read_wstring();
    _result.c_prn_typ = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlyEdrAppPayInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_crt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_crt_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_edr_app_no);
    _output.write_wstring((java.lang.String)_vis_value.n_tms);
    _output.write_wstring((java.lang.String)_vis_value.c_rcpt_no);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_prsn_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_prsn_nme);
    _output.write_wstring((java.lang.String)_vis_value.n_get_prm);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_mde_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_accnt_no);
    _output.write_wstring((java.lang.String)_vis_value.t_pay_lmt_tm);
    _output.write_wstring((java.lang.String)_vis_value.n_got_prm);
    _output.write_wstring((java.lang.String)_vis_value.t_pay_strt_tm);
    _output.write_wstring((java.lang.String)_vis_value.t_pay_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_cur_typ);
    _output.write_wstring((java.lang.String)_vis_value.c_rec_no);
    _output.write_wstring((java.lang.String)_vis_value.c_prn_typ);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlyEdrAppPayInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlyEdrAppPayInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlyEdrAppPayInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlyEdrAppPayInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlyEdrAppPayInfoHolder _vis_holder = new com.mcip.nia.orb.PlyEdrAppPayInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlyEdrAppPayInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[20];
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
          _type = _orb().create_struct_tc(id(), "PlyEdrAppPayInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlyEdrAppPayInfo:1.0";
  }
}
