package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustPrsn
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustPrsn:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustPrsn {
  ...
};
 * </pre>
 */
public final class CustPrsnHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.cus.orb.CustPrsn read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.cus.orb.CustPrsn _result = new com.mcip.cus.orb.CustPrsn();
    _result.c_clnt_cde = _input.read_string();
    _result.c_dpt_cde = _input.read_string();
    _result.n_clnt_grp_cde = _input.read_long();
    _result.c_clnt_mrk = _input.read_string();
    _result.c_clnt_nme = _input.read_wstring();
    _result.c_chn_abr = _input.read_wstring();
    _result.c_auth_mrk = _input.read_string();
    _result.c_brd_enm = _input.read_wstring();
    _result.c_eng_abr = _input.read_wstring();
    _result.c_rgst_no = _input.read_string();
    _result.c_sex = _input.read_string();
    _result.c_hmtwn = _input.read_wstring();
    _result.c_ntn_cde = _input.read_string();
    _result.t_birthday = _input.read_string();
    _result.c_mrg_cde = _input.read_string();
    _result.c_grdt = _input.read_wstring();
    _result.c_major_cde = _input.read_string();
    _result.c_edu_cde = _input.read_string();
    _result.c_work_dpt = _input.read_wstring();
    _result.c_title_cde = _input.read_string();
    _result.c_duty = _input.read_string();
    _result.c_tel = _input.read_string();
    _result.c_fax = _input.read_string();
    _result.c_email = _input.read_wstring();
    _result.c_clnt_addr = _input.read_wstring();
    _result.c_ara_cde = _input.read_string();
    _result.c_province = _input.read_wstring();
    _result.c_city = _input.read_wstring();
    _result.c_place = _input.read_wstring();
    _result.c_zip_cde = _input.read_string();
    _result.c_bank = _input.read_wstring();
    _result.c_accnt_no = _input.read_string();
    _result.c_remark = _input.read_wstring();
    _result.c_impt_clnt_cde = _input.read_string();
    _result.t_upd_tm = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.cus.orb.CustPrsn _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_clnt_cde);
    _output.write_string((java.lang.String)_vis_value.c_dpt_cde);
    _output.write_long((int)_vis_value.n_clnt_grp_cde);
    _output.write_string((java.lang.String)_vis_value.c_clnt_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_clnt_nme);
    _output.write_wstring((java.lang.String)_vis_value.c_chn_abr);
    _output.write_string((java.lang.String)_vis_value.c_auth_mrk);
    _output.write_wstring((java.lang.String)_vis_value.c_brd_enm);
    _output.write_wstring((java.lang.String)_vis_value.c_eng_abr);
    _output.write_string((java.lang.String)_vis_value.c_rgst_no);
    _output.write_string((java.lang.String)_vis_value.c_sex);
    _output.write_wstring((java.lang.String)_vis_value.c_hmtwn);
    _output.write_string((java.lang.String)_vis_value.c_ntn_cde);
    _output.write_string((java.lang.String)_vis_value.t_birthday);
    _output.write_string((java.lang.String)_vis_value.c_mrg_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_grdt);
    _output.write_string((java.lang.String)_vis_value.c_major_cde);
    _output.write_string((java.lang.String)_vis_value.c_edu_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_work_dpt);
    _output.write_string((java.lang.String)_vis_value.c_title_cde);
    _output.write_string((java.lang.String)_vis_value.c_duty);
    _output.write_string((java.lang.String)_vis_value.c_tel);
    _output.write_string((java.lang.String)_vis_value.c_fax);
    _output.write_wstring((java.lang.String)_vis_value.c_email);
    _output.write_wstring((java.lang.String)_vis_value.c_clnt_addr);
    _output.write_string((java.lang.String)_vis_value.c_ara_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_province);
    _output.write_wstring((java.lang.String)_vis_value.c_city);
    _output.write_wstring((java.lang.String)_vis_value.c_place);
    _output.write_string((java.lang.String)_vis_value.c_zip_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_bank);
    _output.write_string((java.lang.String)_vis_value.c_accnt_no);
    _output.write_wstring((java.lang.String)_vis_value.c_remark);
    _output.write_string((java.lang.String)_vis_value.c_impt_clnt_cde);
    _output.write_string((java.lang.String)_vis_value.t_upd_tm);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.cus.orb.CustPrsn _vis_value) {
    any.insert_Streamable(new com.mcip.cus.orb.CustPrsnHolder(_vis_value));
  }

  public static com.mcip.cus.orb.CustPrsn extract (final org.omg.CORBA.Any any) {
    com.mcip.cus.orb.CustPrsn _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.cus.orb.CustPrsnHolder _vis_holder = new com.mcip.cus.orb.CustPrsnHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.cus.orb.CustPrsnHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[35];
          members[0] = new org.omg.CORBA.StructMember("c_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[2] = new org.omg.CORBA.StructMember("n_clnt_grp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
          members[3] = new org.omg.CORBA.StructMember("c_clnt_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[4] = new org.omg.CORBA.StructMember("c_clnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[5] = new org.omg.CORBA.StructMember("c_chn_abr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[6] = new org.omg.CORBA.StructMember("c_auth_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[7] = new org.omg.CORBA.StructMember("c_brd_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("c_eng_abr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[9] = new org.omg.CORBA.StructMember("c_rgst_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[10] = new org.omg.CORBA.StructMember("c_sex", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[11] = new org.omg.CORBA.StructMember("c_hmtwn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[12] = new org.omg.CORBA.StructMember("c_ntn_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[13] = new org.omg.CORBA.StructMember("t_birthday", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[14] = new org.omg.CORBA.StructMember("c_mrg_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[15] = new org.omg.CORBA.StructMember("c_grdt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[16] = new org.omg.CORBA.StructMember("c_major_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[17] = new org.omg.CORBA.StructMember("c_edu_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[18] = new org.omg.CORBA.StructMember("c_work_dpt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[19] = new org.omg.CORBA.StructMember("c_title_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[20] = new org.omg.CORBA.StructMember("c_duty", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[21] = new org.omg.CORBA.StructMember("c_tel", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[22] = new org.omg.CORBA.StructMember("c_fax", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[23] = new org.omg.CORBA.StructMember("c_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[24] = new org.omg.CORBA.StructMember("c_clnt_addr", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[25] = new org.omg.CORBA.StructMember("c_ara_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[26] = new org.omg.CORBA.StructMember("c_province", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[27] = new org.omg.CORBA.StructMember("c_city", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[28] = new org.omg.CORBA.StructMember("c_place", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[29] = new org.omg.CORBA.StructMember("c_zip_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[30] = new org.omg.CORBA.StructMember("c_bank", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[31] = new org.omg.CORBA.StructMember("c_accnt_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[32] = new org.omg.CORBA.StructMember("c_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[33] = new org.omg.CORBA.StructMember("c_impt_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[34] = new org.omg.CORBA.StructMember("t_upd_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "CustPrsn", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/cus/orb/CustPrsn:1.0";
  }
}
