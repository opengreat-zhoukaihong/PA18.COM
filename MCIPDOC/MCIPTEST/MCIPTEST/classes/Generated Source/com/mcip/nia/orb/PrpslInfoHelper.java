package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PrpslInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PrpslInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PrpslInfo {
  ...
};
 * </pre>
 */
public final class PrpslInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PrpslInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PrpslInfo _result = new com.mcip.nia.orb.PrpslInfo();
    _result.c_doc_no = _input.read_string();
    _result.n_rate = _input.read_double();
    _result.c_no_repay = _input.read_wstring();
    _result.c_undr_cndtn = _input.read_wstring();
    _result.t_send_tm = _input.read_string();
    _result.c_send_desc = _input.read_wstring();
    _result.c_undr_prsn = _input.read_wstring();
    _result.t_sign_tm = _input.read_string();
    _result.c_user_id = _input.read_string();
    _result.c_remark = _input.read_wstring();
    _result.c_user_remark = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PrpslInfo _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_doc_no);
    _output.write_double((double)_vis_value.n_rate);
    _output.write_wstring((java.lang.String)_vis_value.c_no_repay);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_cndtn);
    _output.write_string((java.lang.String)_vis_value.t_send_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_send_desc);
    _output.write_wstring((java.lang.String)_vis_value.c_undr_prsn);
    _output.write_string((java.lang.String)_vis_value.t_sign_tm);
    _output.write_string((java.lang.String)_vis_value.c_user_id);
    _output.write_wstring((java.lang.String)_vis_value.c_remark);
    _output.write_wstring((java.lang.String)_vis_value.c_user_remark);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PrpslInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PrpslInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PrpslInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PrpslInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PrpslInfoHolder _vis_holder = new com.mcip.nia.orb.PrpslInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PrpslInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[11];
          members[0] = new org.omg.CORBA.StructMember("c_doc_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("n_rate", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_double), null);
          members[2] = new org.omg.CORBA.StructMember("c_no_repay", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[3] = new org.omg.CORBA.StructMember("c_undr_cndtn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("t_send_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[5] = new org.omg.CORBA.StructMember("c_send_desc", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[6] = new org.omg.CORBA.StructMember("c_undr_prsn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[7] = new org.omg.CORBA.StructMember("t_sign_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[8] = new org.omg.CORBA.StructMember("c_user_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[9] = new org.omg.CORBA.StructMember("c_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[10] = new org.omg.CORBA.StructMember("c_user_remark", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "PrpslInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PrpslInfo:1.0";
  }
}
