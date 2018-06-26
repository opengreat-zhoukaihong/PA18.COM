package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::CustFaqInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/CustFaqInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustFaqInfo {
  ...
};
 * </pre>
 */
public final class CustFaqInfoHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.bus.orb.CustFaqInfo read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.bus.orb.CustFaqInfo _result = new com.mcip.bus.orb.CustFaqInfo();
    _result.c_faq_no = _input.read_wstring();
    _result.c_faq_psn = _input.read_wstring();
    _result.c_faq_email = _input.read_wstring();
    _result.c_faq_title = _input.read_wstring();
    _result.c_faq_content = _input.read_wstring();
    _result.t_faq_tm = _input.read_string();
    _result.c_reply_cont = _input.read_wstring();
    _result.c_reply_emp = _input.read_wstring();
    _result.t_reply_tm = _input.read_string();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.bus.orb.CustFaqInfo _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.c_faq_no);
    _output.write_wstring((java.lang.String)_vis_value.c_faq_psn);
    _output.write_wstring((java.lang.String)_vis_value.c_faq_email);
    _output.write_wstring((java.lang.String)_vis_value.c_faq_title);
    _output.write_wstring((java.lang.String)_vis_value.c_faq_content);
    _output.write_string((java.lang.String)_vis_value.t_faq_tm);
    _output.write_wstring((java.lang.String)_vis_value.c_reply_cont);
    _output.write_wstring((java.lang.String)_vis_value.c_reply_emp);
    _output.write_string((java.lang.String)_vis_value.t_reply_tm);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.bus.orb.CustFaqInfo _vis_value) {
    any.insert_Streamable(new com.mcip.bus.orb.CustFaqInfoHolder(_vis_value));
  }

  public static com.mcip.bus.orb.CustFaqInfo extract (final org.omg.CORBA.Any any) {
    com.mcip.bus.orb.CustFaqInfo _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.bus.orb.CustFaqInfoHolder _vis_holder = new com.mcip.bus.orb.CustFaqInfoHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.bus.orb.CustFaqInfoHelper.read(any.create_input_stream());
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
          final org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[9];
          members[0] = new org.omg.CORBA.StructMember("c_faq_no", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("c_faq_psn", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("c_faq_email", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[3] = new org.omg.CORBA.StructMember("c_faq_title", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[4] = new org.omg.CORBA.StructMember("c_faq_content", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[5] = new org.omg.CORBA.StructMember("t_faq_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          members[6] = new org.omg.CORBA.StructMember("c_reply_cont", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[7] = new org.omg.CORBA.StructMember("c_reply_emp", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[8] = new org.omg.CORBA.StructMember("t_reply_tm", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_string), null);
          _type = _orb().create_struct_tc(id(), "CustFaqInfo", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/bus/orb/CustFaqInfo:1.0";
  }
}
