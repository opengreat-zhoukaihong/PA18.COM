package com.mcip.mail.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.mail.orb.MailHelper
<li> <b>Source File</b> com/mcip/mail/orb/MailHelper.java
<li> <b>IDL Source File</b> MailDaemon.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::mail::orb::Mail
<li> <b>Repository Identifier</b> IDL:com/mcip/mail/orb/Mail:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/mail/orb"
    struct Mail {
      wstring sender;
      wstring receiver;
      wstring subject;
      wstring content;
    };
</pre>
</p>
*/
abstract public class MailHelper {
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.mail.orb.Mail read(org.omg.CORBA.portable.InputStream _input) {
    com.mcip.mail.orb.Mail result = new com.mcip.mail.orb.Mail();
    result.sender = _input.read_wstring();
    result.receiver = _input.read_wstring();
    result.subject = _input.read_wstring();
    result.content = _input.read_wstring();
    return result;
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.mail.orb.Mail value) {
    _output.write_wstring(value.sender);
    _output.write_wstring(value.receiver);
    _output.write_wstring(value.subject);
    _output.write_wstring(value.content);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.mail.orb.Mail value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.mail.orb.Mail extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      org.omg.CORBA.StructMember[] members = new org.omg.CORBA.StructMember[4];
      members[0] = new org.omg.CORBA.StructMember("sender", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[1] = new org.omg.CORBA.StructMember("receiver", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[2] = new org.omg.CORBA.StructMember("subject", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      members[3] = new org.omg.CORBA.StructMember("content", _orb().get_primitive_tc(org.omg.CORBA.TCKind.tk_wstring), null);
      _type = (_orb()).create_struct_tc(id(), "Mail", members);
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/mail/orb/Mail:1.0";
  }
}
