package com.mcip.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/exceptions.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::orb::CoException
 * <li> <b>Repository Id</b> IDL:com/mcip/orb/CoException:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception CoException {
  ...
};
 * </pre>
 */
public final class CoExceptionHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.orb.CoException read (final org.omg.CORBA.portable.InputStream _input) {
    if (!_input.read_string().equals(id())) {
      throw new org.omg.CORBA.MARSHAL("Mismatched repository id");
    }
    final com.mcip.orb.CoException _result = new com.mcip.orb.CoException();
    _result.errCode = _input.read_string();
    _result.errDescription = _input.read_wstring();
    _result.errFieldName = _input.read_string();
    _result.severity = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.orb.CoException _vis_value) {
    _output.write_string(id());
    _output.write_string((java.lang.String)_vis_value.errCode);
    _output.write_wstring((java.lang.String)_vis_value.errDescription);
    _output.write_string((java.lang.String)_vis_value.errFieldName);
    _output.write_string((java.lang.String)_vis_value.severity);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.orb.CoException _vis_value) {
    any.insert_Streamable(new com.mcip.orb.CoExceptionHolder(_vis_value));
  }

  public static com.mcip.orb.CoException extract (final org.omg.CORBA.Any any) {
    com.mcip.orb.CoException _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.orb.CoExceptionHolder _vis_holder = new com.mcip.orb.CoExceptionHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.orb.CoExceptionHelper.read(any.create_input_stream());
    }
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[4];
          members[0] = new org.omg.CORBA.StructMember("errCode", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("errDescription", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("errFieldName", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("severity", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_exception_tc(id(), "CoException", members);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/orb/CoException:1.0";
  }
}
