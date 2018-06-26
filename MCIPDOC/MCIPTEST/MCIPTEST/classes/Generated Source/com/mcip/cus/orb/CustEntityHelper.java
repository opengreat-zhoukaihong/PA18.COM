package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustEntity
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustEntity:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustEntity {
  ...
};
 * </pre>
 */
public final class CustEntityHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.cus.orb.CustEntity read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.cus.orb.CustEntity _result = new com.mcip.cus.orb.CustEntity();
    _result.c_user_id = _input.read_wstring();
    _result.c_user_name = _input.read_wstring();
    _result.c_user_pw = _input.read_string();
    _result.c_pw_question = _input.read_wstring();
    _result.c_pw_result = _input.read_wstring();
    _result.c_clnt_cde = _input.read_string();
    _result.n_user_seq_no = _input.read_long();
    _result.c_verify = _input.read_char();
    _result.c_cmpny_agt_cde = _input.read_string();
    _result.c_net_id = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.cus.orb.CustEntity _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_user_id);
    _output.write_wstring((java.lang.String)_vis_value.c_user_name);
    _output.write_string((java.lang.String)_vis_value.c_user_pw);
    _output.write_wstring((java.lang.String)_vis_value.c_pw_question);
    _output.write_wstring((java.lang.String)_vis_value.c_pw_result);
    _output.write_string((java.lang.String)_vis_value.c_clnt_cde);
    _output.write_long((int)_vis_value.n_user_seq_no);
    _output.write_char((char)_vis_value.c_verify);
    _output.write_string((java.lang.String)_vis_value.c_cmpny_agt_cde);
    _output.write_string((java.lang.String)_vis_value.c_net_id);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.cus.orb.CustEntity _vis_value) {
    any.insert_Streamable(new com.mcip.cus.orb.CustEntityHolder(_vis_value));
  }

  public static com.mcip.cus.orb.CustEntity extract (final org.omg.CORBA.Any any) {
    com.mcip.cus.orb.CustEntity _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.cus.orb.CustEntityHolder _vis_holder = new com.mcip.cus.orb.CustEntityHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.cus.orb.CustEntityHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[10];
          members[0] = new org.omg.CORBA.StructMember("c_user_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("c_user_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("c_user_pw", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("c_pw_question", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("c_pw_result", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[5] = new org.omg.CORBA.StructMember("c_clnt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[6] = new org.omg.CORBA.StructMember("n_user_seq_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_long), null);
          members[7] = new org.omg.CORBA.StructMember("c_verify", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_char), null);
          members[8] = new org.omg.CORBA.StructMember("c_cmpny_agt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[9] = new org.omg.CORBA.StructMember("c_net_id", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "CustEntity", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/cus/orb/CustEntity:1.0";
  }
}
