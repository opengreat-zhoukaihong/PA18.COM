package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::OpenCoverList
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/OpenCoverList:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct OpenCoverList {
  ...
};
 * </pre>
 */
public final class OpenCoverListHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.OpenCoverList read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.OpenCoverList _result = new com.mcip.nia.orb.OpenCoverList();
    _result.c_open_cover_no = _input.read_string();
    _result.c_crgo_name = _input.read_wstring();
    _result.c_insrnc_cde = _input.read_string();
    _result.c_insrnc_cnm = _input.read_wstring();
    _result.c_frm_prt_ara = _input.read_string();
    _result.c_frm_prt_ara_cnm = _input.read_wstring();
    _result.c_to_prt_ara = _input.read_string();
    _result.c_to_prt_ara_cnm = _input.read_wstring();
    _result.c_from_prt = _input.read_wstring();
    _result.c_to_prt = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.OpenCoverList _vis_value) {
    _output.write_string((java.lang.String)_vis_value.c_open_cover_no);
    _output.write_wstring((java.lang.String)_vis_value.c_crgo_name);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_wstring((java.lang.String)_vis_value.c_insrnc_cnm);
    _output.write_string((java.lang.String)_vis_value.c_frm_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_frm_prt_ara_cnm);
    _output.write_string((java.lang.String)_vis_value.c_to_prt_ara);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt_ara_cnm);
    _output.write_wstring((java.lang.String)_vis_value.c_from_prt);
    _output.write_wstring((java.lang.String)_vis_value.c_to_prt);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.OpenCoverList _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.OpenCoverListHolder(_vis_value));
  }

  public static com.mcip.nia.orb.OpenCoverList extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.OpenCoverList _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.OpenCoverListHolder _vis_holder = new com.mcip.nia.orb.OpenCoverListHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.OpenCoverListHelper.read(any.create_input_stream());
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
          members[0] = new org.omg.CORBA.StructMember("c_open_cover_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[1] = new org.omg.CORBA.StructMember("c_crgo_name", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("c_insrnc_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("c_frm_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[5] = new org.omg.CORBA.StructMember("c_frm_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[6] = new org.omg.CORBA.StructMember("c_to_prt_ara", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[7] = new org.omg.CORBA.StructMember("c_to_prt_ara_cnm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("c_from_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[9] = new org.omg.CORBA.StructMember("c_to_prt", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "OpenCoverList", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/OpenCoverList:1.0";
  }
}
