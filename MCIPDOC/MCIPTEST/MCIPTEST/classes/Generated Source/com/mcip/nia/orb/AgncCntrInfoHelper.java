package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::AgncCntrInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/AgncCntrInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct AgncCntrInfo {
  ...
};
 * </pre>
 */
public final class AgncCntrInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.AgncCntrInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.AgncCntrInfo _result = new com.mcip.nia.orb.AgncCntrInfo();
    _result.c_agt_agr_no = _input.read_string();
    _result.n_sub_co_no = _input.read_long();
    _result.c_auth_mrk = _input.read_string();
    _result.c_co_mrk = _input.read_string();
    _result.c_per_org_mrk = _input.read_string();
    _result.c_udr_mrk = _input.read_string();
    _result.c_clnt_cde = _input.read_string();
    _result.c_clnt_nme = _input.read_wstring();
    _result.c_dpt_cde = _input.read_string();
    _result.t_effc_tm = _input.read_string();
    _result.t_co_strt_tm = _input.read_string();
    _result.t_co_end_tm = _input.read_string();
    _result.c_sls_cde = _input.read_string();
    _result.c_co_cnt = _input.read_wstring();
    _result.c_undr_prsn = _input.read_wstring();
    _result.c_insrnc_cde = _input.read_string();
    _result.c_crgo_cde = _input.read_string();
    _result.n_rate = _input.read_double();
    _result.n_nclm_prop = _input.read_double();
    _result.n_appnt_prop = _input.read_double();
    _result.n_cmm_prop = _input.read_double();
    _result.n_min_prm_prop = _input.read_double();
    _result.n_max_amt_prop = _input.read_double();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.AgncCntrInfo _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_agt_agr_no);
    _output.write_long((int)_vis_value.n_sub_co_no);
    _output.write_string((java.lang.String)_vis_value.c_auth_mrk);
    _output.write_string((java.lang.String)_vis_value.c_co_mrk);
    _output.write_string((java.lang.String)_vis_value.c_per_org_mrk);
    _output.write_string((java.lang.String)_vis_value.c_udr_mrk);
    _output.write_string((java.lang.String)_vis_value.c_clnt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_clnt_nme);
    _output.write_string((java.lang.String)_vis_value.c_dpt_cde);
    _output.write_string((java.lang.String)_vis_value.t_effc_tm);
    _output.write_string((java.lang.String)_vis_value.t_co_strt_tm);
    _output.write_string((java.lang.String)_vis_value.t_co_end_tm);
    _output.write_string((java.lang.String)_vis_value.c_sls_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_co_cnt);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_prsn);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_string((java.lang.String)_vis_value.c_crgo_cde);
    _output.write_double((double)_vis_value.n_rate);
    _output.write_double((double)_vis_value.n_nclm_prop);
    _output.write_double((double)_vis_value.n_appnt_prop);
    _output.write_double((double)_vis_value.n_cmm_prop);
    _output.write_double((double)_vis_value.n_min_prm_prop);
    _output.write_double((double)_vis_value.n_max_amt_prop);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.AgncCntrInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.AgncCntrInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.AgncCntrInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.AgncCntrInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.AgncCntrInfoHolder _vis_holder = new com.mcip.nia.orb.AgncCntrInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.AgncCntrInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[23];
          members[0] = new org.omg.CORBA.StructMember("c_agt_agr_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("n_sub_co_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
          members[2] = new org.omg.CORBA.StructMember("c_auth_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("c_co_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[4] = new org.omg.CORBA.StructMember("c_per_org_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[5] = new org.omg.CORBA.StructMember("c_udr_mrk", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[6] = new org.omg.CORBA.StructMember("c_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[7] = new org.omg.CORBA.StructMember("c_clnt_nme", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[9] = new org.omg.CORBA.StructMember("t_effc_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[10] = new org.omg.CORBA.StructMember("t_co_strt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[11] = new org.omg.CORBA.StructMember("t_co_end_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[12] = new org.omg.CORBA.StructMember("c_sls_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[13] = new org.omg.CORBA.StructMember("c_co_cnt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[14] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[15] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[16] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[17] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[18] = new org.omg.CORBA.StructMember("n_nclm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[19] = new org.omg.CORBA.StructMember("n_appnt_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[20] = new org.omg.CORBA.StructMember("n_cmm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[21] = new org.omg.CORBA.StructMember("n_min_prm_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[22] = new org.omg.CORBA.StructMember("n_max_amt_prop", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          _type = _orb().create_struct_tc(id(), "AgncCntrInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/AgncCntrInfo:1.0";
  }
}
