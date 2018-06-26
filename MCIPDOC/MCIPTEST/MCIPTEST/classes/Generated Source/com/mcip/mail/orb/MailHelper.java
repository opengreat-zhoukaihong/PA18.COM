package com.mcip.mail.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/MailDaemon.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::mail::orb::Mail
 * <li> <b>Repository Id</b> IDL:com/mcip/mail/orb/Mail:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct Mail {
  ...
};
 * </pre>
 */
public final class MailHelper {
  private static boolean _inited = false;
  private static boolean _initing = false;
  private static org.omg.CORBA.TypeCode _type;
  private static boolean _initializing;

  private static org.omg.CORBA.ORB _orb () {
    return org.omg.CORBA.ORB.init();
  }

  public static com.mcip.mail.orb.Mail read (final org.omg.CORBA.portable.InputStream _input) {
    final com.mcip.mail.orb.Mail _result = new com.mcip.mail.orb.Mail();
    _result.sender = _input.read_wstring();
    _result.receiver = _input.read_wstring();
    _result.subject = _input.read_wstring();
    _result.content = _input.read_wstring();
    return _result;
  }

  public static void write (final org.omg.CORBA.portable.OutputStream _output, final com.mcip.mail.orb.Mail _vis_value) {
    _output.write_wstring((java.lang.String)_vis_value.sender);
    _output.write_wstring((java.lang.String)_vis_value.receiver);
    _output.write_wstring((java.lang.String)_vis_value.subject);
    _output.write_wstring((java.lang.String)_vis_value.content);
  }

  public static void insert (final org.omg.CORBA.Any any, final com.mcip.mail.orb.Mail _vis_value) {
    any.insert_Streamable(new com.mcip.mail.orb.MailHolder(_vis_value));
  }

  public static com.mcip.mail.orb.Mail extract (final org.omg.CORBA.Any any) {
    com.mcip.mail.orb.Mail _vis_value;
    if (any instanceof com.inprise.vbroker.CORBA.Any) {
      com.mcip.mail.orb.MailHolder _vis_holder = new com.mcip.mail.orb.MailHolder();
      ((com.inprise.vbroker.CORBA.Any)any).extract_Streamable(_vis_holder);
      _vis_value = _vis_holder.value;
    }
    else {
      _vis_value = com.mcip.mail.orb.MailHelper.read(any.create_input_stream());
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
          members[0] = new org.omg.CORBA.StructMember("sender", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[1] = new org.omg.CORBA.StructMember("receiver", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[2] = new org.omg.CORBA.StructMember("subject", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          members[3] = new org.omg.CORBA.StructMember("content", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
          _type = _orb().create_struct_tc(id(), "Mail", members);
          _initializing = false;
        }
      }
    }
    return _type;
  }

  public static java.lang.String id () {
    return "IDL:com/mcip/mail/orb/Mail:1.0";
  }
}
