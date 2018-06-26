package com.mcip.mail.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.mail.orb.EmailManagerHelper
<li> <b>Source File</b> com/mcip/mail/orb/EmailManagerHelper.java
<li> <b>IDL Source File</b> MailDaemon.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::mail::orb::EmailManager
<li> <b>Repository Identifier</b> IDL:com/mcip/mail/orb/EmailManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/mail/orb"
    interface EmailManager {
      ::com::mcip::orb::Stringss GetMailList(
        in string mailcde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean SetMailFlag(
        in string mailcde,
        in ::com::mcip::orb::Strings key
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean OnlineMail(
        in ::com::mcip::mail::orb::Mail inmail
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
abstract public class EmailManagerHelper {
  public static com.mcip.mail.orb.EmailManager narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static com.mcip.mail.orb.EmailManager narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof com.mcip.mail.orb.EmailManager) {
      return (com.mcip.mail.orb.EmailManager) object;
    }
    if(is_a || object._is_a(id())) {
      com.mcip.mail.orb._st_EmailManager result = (com.mcip.mail.orb._st_EmailManager)new com.mcip.mail.orb._st_EmailManager();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (com.mcip.mail.orb.EmailManager) result._this();
    }
    return null;
  }
  public static com.mcip.mail.orb.EmailManager bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static com.mcip.mail.orb.EmailManager bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static com.mcip.mail.orb.EmailManager bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
    if (orb instanceof com.visigenic.vbroker.orb.ORB) {
      return narrow(((com.visigenic.vbroker.orb.ORB)orb).bind(id(), name, host, options), true);
    }
    else {
      throw new org.omg.CORBA.BAD_PARAM();
    }
  }
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.mail.orb.EmailManager read(org.omg.CORBA.portable.InputStream _input) {
    return com.mcip.mail.orb.EmailManagerHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.mail.orb.EmailManager value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.mail.orb.EmailManager value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.mail.orb.EmailManager extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "EmailManager");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/mail/orb/EmailManager:1.0";
  }
}
