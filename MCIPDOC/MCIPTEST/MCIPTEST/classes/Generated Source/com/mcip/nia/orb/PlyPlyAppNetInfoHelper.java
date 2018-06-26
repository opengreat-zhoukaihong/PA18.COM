package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyPlyAppNetInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyPlyAppNetInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyPlyAppNetInfo {
  ...
};
 * </pre>
 */
public final class PlyPlyAppNetInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlyPlyAppNetInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlyPlyAppNetInfo _result = new com.mcip.nia.orb.PlyPlyAppNetInfo();
    _result.c_crt_cde = _input.read_wstring();
    _result.c_crt_tm = _input.read_wstring();
    _result.c_upd_cde = _input.read_wstring();
    _result.c_upd_tm = _input.read_wstring();
    _result.c_ply_app_no = _input.read_wstring();
    _result.n_user_seq_no = _input.read_wstring();
    _result.t_freeback_tm = _input.read_wstring();
    _result.t_print_tm = _input.read_wstring();
    _result.c_province = _input.read_wstring();
    _result.c_city = _input.read_wstring();
    _result.c_place = _input.read_wstring();
    _result.c_contact_name = _input.read_wstring();
    _result.c_contact_phone = _input.read_wstring();
    _result.c_contact_fax = _input.read_wstring();
    _result.c_contact_email = _input.read_wstring();
    _result.c_site_cde = _input.read_wstring();
    _result.c_rec_no = _input.read_wstring();
    _result.c_send_flag = _input.read_wstring();
    _result.c_send_emp_cde = _input.read_wstring();
    _result.c_prt_emp_cde = _input.read_wstring();
    _result.t_send_tm = _input.read_wstring();
    _result.t_sended_tm = _input.read_wstring();
    _result.c_zip_cde = _input.read_wstring();
    _result.c_pay_flag = _input.read_wstring();
    _result.c_session_id = _input.read_wstring();
    _result.c_bank_cde = _input.read_wstring();
    _result.c_bank_cnm = _input.read_wstring();
    _result.c_bank_accnt = _input.read_wstring();
    _result.n_got_prm = _input.read_wstring();
    _result.c_cur_typ = _input.read_wstring();
    _result.t_pay_tm = _input.read_wstring();
    _result.c_pay_typ = _input.read_wstring();
    _result.c_pay_cde = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlyPlyAppNetInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_crt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_crt_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_upd_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_ply_app_no);
    _output.write_wstring((java.lang.String)_vis_value.n_user_seq_no);
    _output.write_wstring((java.lang.String)_vis_value.t_freeback_tm);
    _output.write_wstring((java.lang.String)_vis_value.t_print_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_province);
    _output.write_wstring((java.lang.String)_vis_value.c_city);
    _output.write_wstring((java.lang.String)_vis_value.c_place);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_name);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_phone);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_fax);
    _output.write_wstring((java.lang.String)_vis_value.c_contact_email);
    _output.write_wstring((java.lang.String)_vis_value.c_site_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_rec_no);
    _output.write_wstring((java.lang.String)_vis_value.c_send_flag);
    _output.write_wstring((java.lang.String)_vis_value.c_send_emp_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_prt_emp_cde);
    _output.write_wstring((java.lang.String)_vis_value.t_send_tm);
    _output.write_wstring((java.lang.String)_vis_value.t_sended_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_zip_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_flag);
    _output.write_wstring((java.lang.String)_vis_value.c_session_id);
    _output.write_wstring((java.lang.String)_vis_value.c_bank_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_bank_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_bank_accnt);
    _output.write_wstring((java.lang.String)_vis_value.n_got_prm);
    _output.write_wstring((java.lang.String)_vis_value.c_cur_typ);
    _output.write_wstring((java.lang.String)_vis_value.t_pay_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_typ);
    _output.write_wstring((java.lang.String)_vis_value.c_pay_cde);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlyPlyAppNetInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlyPlyAppNetInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlyPlyAppNetInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlyPlyAppNetInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlyPlyAppNetInfoHolder _vis_holder = new com.mcip.nia.orb.PlyPlyAppNetInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlyPlyAppNetInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[33];
          members[0] = new org.omg.CORBA.StructMember("c_crt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("c_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("c_upd_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[3] = new org.omg.CORBA.StructMember("c_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("c_ply_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[5] = new org.omg.CORBA.StructMember("n_user_seq_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[6] = new org.omg.CORBA.StructMember("t_freeback_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[7] = new org.omg.CORBA.StructMember("t_print_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[9] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[10] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[11] = new org.omg.CORBA.StructMember("c_contact_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[12] = new org.omg.CORBA.StructMember("c_contact_phone", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[13] = new org.omg.CORBA.StructMember("c_contact_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[14] = new org.omg.CORBA.StructMember("c_contact_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[15] = new org.omg.CORBA.StructMember("c_site_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[16] = new org.omg.CORBA.StructMember("c_rec_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[17] = new org.omg.CORBA.StructMember("c_send_flag", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[18] = new org.omg.CORBA.StructMember("c_send_emp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[19] = new org.omg.CORBA.StructMember("c_prt_emp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[20] = new org.omg.CORBA.StructMember("t_send_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[21] = new org.omg.CORBA.StructMember("t_sended_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[22] = new org.omg.CORBA.StructMember("c_zip_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[23] = new org.omg.CORBA.StructMember("c_pay_flag", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[24] = new org.omg.CORBA.StructMember("c_session_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[25] = new org.omg.CORBA.StructMember("c_bank_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[26] = new org.omg.CORBA.StructMember("c_bank_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[27] = new org.omg.CORBA.StructMember("c_bank_accnt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[28] = new org.omg.CORBA.StructMember("n_got_prm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[29] = new org.omg.CORBA.StructMember("c_cur_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[30] = new org.omg.CORBA.StructMember("t_pay_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[31] = new org.omg.CORBA.StructMember("c_pay_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[32] = new org.omg.CORBA.StructMember("c_pay_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "PlyPlyAppNetInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlyPlyAppNetInfo:1.0";
  }
}
