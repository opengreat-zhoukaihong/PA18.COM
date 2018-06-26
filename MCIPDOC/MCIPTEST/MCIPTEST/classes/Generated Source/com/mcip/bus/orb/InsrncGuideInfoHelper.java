package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::InsrncGuideInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct InsrncGuideInfo {
  ...
};
 * </pre>
 */
public final class InsrncGuideInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.bus.orb.InsrncGuideInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.bus.orb.InsrncGuideInfo _result = new com.mcip.bus.orb.InsrncGuideInfo();
    _result.c_info_no = _input.read_wstring();
    _result.c_title_no = _input.read_wstring();
    _result.c_title_cnm = _input.read_wstring();
    _result.c_title_enm = _input.read_wstring();
    _result.c_content_cnm = _input.read_wstring();
    _result.c_content_enm = _input.read_wstring();
    _result.t_crt_tm = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.bus.orb.InsrncGuideInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_info_no);
    _output.write_wstring((java.lang.String)_vis_value.c_title_no);
    _output.write_wstring((java.lang.String)_vis_value.c_title_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_title_enm);
    _output.write_wstring((java.lang.String)_vis_value.c_content_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_content_enm);
    _output.write_string((java.lang.String)_vis_value.t_crt_tm);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.bus.orb.InsrncGuideInfo _vis_value) {
    any.insert_Streamable(new com.mcip.bus.orb.InsrncGuideInfoHolder(_vis_value));
  }

  public static com.mcip.bus.orb.InsrncGuideInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.bus.orb.InsrncGuideInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.bus.orb.InsrncGuideInfoHolder _vis_holder = new com.mcip.bus.orb.InsrncGuideInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.bus.orb.InsrncGuideInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[7];
          members[0] = new org.omg.CORBA.StructMember("c_info_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("c_title_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("c_title_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[3] = new org.omg.CORBA.StructMember("c_title_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("c_content_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[5] = new org.omg.CORBA.StructMember("c_content_enm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[6] = new org.omg.CORBA.StructMember("t_crt_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "InsrncGuideInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0";
  }
}
