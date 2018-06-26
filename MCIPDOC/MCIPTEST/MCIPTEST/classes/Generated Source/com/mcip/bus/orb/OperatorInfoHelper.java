package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::OperatorInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/OperatorInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct OperatorInfo {
  ...
};
 * </pre>
 */
public final class OperatorInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.bus.orb.OperatorInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.bus.orb.OperatorInfo _result = new com.mcip.bus.orb.OperatorInfo();
    _result.c_opr_cde = _input.read_wstring();
    _result.c_opr_pw = _input.read_string();
    _result.c_emp_cde = _input.read_string();
    _result.c_dpt_cde = _input.read_string();
    _result.c_acredt_cde = _input.read_wstring();
    _result.c_sys_admin = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.bus.orb.OperatorInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_opr_cde);
    _output.write_string((java.lang.String)_vis_value.c_opr_pw);
    _output.write_string((java.lang.String)_vis_value.c_emp_cde);
    _output.write_string((java.lang.String)_vis_value.c_dpt_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_acredt_cde);
    _output.write_string((java.lang.String)_vis_value.c_sys_admin);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.bus.orb.OperatorInfo _vis_value) {
    any.insert_Streamable(new com.mcip.bus.orb.OperatorInfoHolder(_vis_value));
  }

  public static com.mcip.bus.orb.OperatorInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.bus.orb.OperatorInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.bus.orb.OperatorInfoHolder _vis_holder = new com.mcip.bus.orb.OperatorInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.bus.orb.OperatorInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[6];
          members[0] = new org.omg.CORBA.StructMember("c_opr_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("c_opr_pw", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[2] = new org.omg.CORBA.StructMember("c_emp_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("c_dpt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[4] = new org.omg.CORBA.StructMember("c_acredt_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[5] = new org.omg.CORBA.StructMember("c_sys_admin", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "OperatorInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/bus/orb/OperatorInfo:1.0";
  }
}
