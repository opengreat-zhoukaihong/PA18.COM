package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlcyAppList
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlcyAppList:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlcyAppList {
  ...
};
 * </pre>
 */
public final class PlcyAppListHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlcyAppList read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlcyAppList _result = new com.mcip.nia.orb.PlcyAppList();
    _result.c_ply_app_no = _input.read_string();
    _result.c_ply_no = _input.read_string();
    _result.c_insrnc_cde = _input.read_string();
    _result.c_insrnc_cnm = _input.read_wstring();
    _result.n_amt = _input.read_double();
    _result.c_amt_cur = _input.read_string();
    _result.c_crgo_cde = _input.read_string();
    _result.c_cdgo_desc = _input.read_wstring();
    _result.c_frm_prt_ara = _input.read_string();
    _result.c_frm_prt_ara_cnm = _input.read_wstring();
    _result.c_from_prt = _input.read_wstring();
    _result.c_to_prt_ara = _input.read_string();
    _result.c_to_prt_ara_cnm = _input.read_wstring();
    _result.c_to_prt = _input.read_wstring();
    _result.c_carriage_cde = _input.read_string();
    _result.c_carriage_cnm = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlcyAppList _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_ply_app_no);
    _output.write_string((java.lang.String)_vis_value.c_ply_no);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_cnm);
    _output.write_double((double)_vis_value.n_amt);
    _output.write_string((java.lang.String)_vis_value.c_amt_cur);
    _output.write_string((java.lang.String)_vis_value.c_crgo_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_cdgo_desc);
    _output.write_string((java.lang.String)_vis_value.c_frm_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_frm_prt_ara_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_from_prt);
    _output.write_string((java.lang.String)_vis_value.c_to_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt_ara_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt);
    _output.write_string((java.lang.String)_vis_value.c_carriage_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_carriage_cnm);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlcyAppList _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlcyAppListHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlcyAppList extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlcyAppList _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlcyAppListHolder _vis_holder = new com.mcip.nia.orb.PlcyAppListHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlcyAppListHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[16];
          members[0] = new org.omg.CORBA.StructMember("c_ply_app_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("c_ply_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[2] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("c_insrnc_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("n_amt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[5] = new org.omg.CORBA.StructMember("c_amt_cur", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[6] = new org.omg.CORBA.StructMember("c_crgo_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[7] = new org.omg.CORBA.StructMember("c_cdgo_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[9] = new org.omg.CORBA.StructMember("c_frm_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[10] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[11] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[12] = new org.omg.CORBA.StructMember("c_to_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[13] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[14] = new org.omg.CORBA.StructMember("c_carriage_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[15] = new org.omg.CORBA.StructMember("c_carriage_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "PlcyAppList", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlcyAppList:1.0";
  }
}
