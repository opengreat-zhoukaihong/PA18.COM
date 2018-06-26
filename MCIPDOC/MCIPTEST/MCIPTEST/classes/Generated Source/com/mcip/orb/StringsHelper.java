package com.mcip.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/CorbaDataType.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::orb::Strings
 * <li> <b>Repository Id</b> IDL:com/mcip/orb/Strings:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * typedef sequence&ltwstring&gt Strings;
 * </pre>
 */
public final class StringsHelper {
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static java.lang.String[] read (final org.omg.CORBA.portable.InputStream _input) {
    java.lang.String[] result;
    final int $length0 = _input.read_long();
    result = new java.lang.String[$length0];
    for (int $counter1 = 0; $counter1 < $length0; $counter1++) {
      result[$counter1] = _input.read_wstring();
    }
    return result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final java.lang.String[] _vis_value) {
    _output.write_long(_vis_value.length);
    for (int $counter2 = 0;  $counter2 < _vis_value.length; $counter2++) {
      _output.write_wstring((java.lang.String)_vis_value[$counter2]);
    }
  }

  public static void insert (final org.omg.CORBA.Any any, final java.lang.String[] _vis_value) {
    any.type(com.mcip.orb.StringsHelper.type());
    any.insert_Streamable(new com.mcip.orb.StringsHolder(_vis_value));
  }

  public static java.lang.String[] extract (final org.omg.CORBA.Any any) {
    java.lang.String[] _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.orb.StringsHolder _vis_holder = new com.mcip.orb.StringsHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    } else {
      _vis_value = com.mcip.orb.StringsHelper.read(any.create_input_stream());
    }
    return _vis_value;
  }

  public static org.omg.CORBA.TypeCode type () {
    if (_type == null) {
      synchronized (org.omg.CORBA.TypeCode.class) {
        if (_type == null) {
          org.omg.CORBA.TypeCode originalType = _orb().create_sequence_tc(0, _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring));
          _type = _orb().create_alias_tc(id(), "Strings", originalType);
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/orb/Strings:1.0";
  }
}
