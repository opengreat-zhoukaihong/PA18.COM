package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyGetDocInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyGetDocInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyGetDocInfo {
  ...
};
 * </pre>
 */
public final class PlyGetDocInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.nia.orb.PlyGetDocInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.nia.orb.PlyGetDocInfo _result = new com.mcip.nia.orb.PlyGetDocInfo();
    _result.c_doc_no = _input.read_wstring();
    _result.c_insrnc_cde = _input.read_string();
    _result.c_prn_typ = _input.read_string();
    _result.t_undr_tm = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.nia.orb.PlyGetDocInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_doc_no);
    _output.write_string((java.lang.String)_vis_value.c_insrnc_cde);
    _output.write_string((java.lang.String)_vis_value.c_prn_typ);
    _output.write_wstring((java.lang.String)_vis_value.t_undr_tm);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.nia.orb.PlyGetDocInfo _vis_value) {
    any.insert_Streamable(new com.mcip.nia.orb.PlyGetDocInfoHolder(_vis_value));
  }

  public static com.mcip.nia.orb.PlyGetDocInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.nia.orb.PlyGetDocInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.nia.orb.PlyGetDocInfoHolder _vis_holder = new com.mcip.nia.orb.PlyGetDocInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.nia.orb.PlyGetDocInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[4];
          members[0] = new org.omg.CORBA.StructMember("c_doc_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("c_insrnc_cde", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[2] = new org.omg.CORBA.StructMember("c_prn_typ", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[3] = new org.omg.CORBA.StructMember("t_undr_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "PlyGetDocInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/nia/orb/PlyGetDocInfo:1.0";
  }
}
