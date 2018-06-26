package com.mcip.mail.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.mail.orb.MailHolder
<li> <b>Source File</b> com/mcip/mail/orb/MailHolder.java
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
final public class MailHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.mail.orb.Mail value;
  public MailHolder() {
  }
  public MailHolder(com.mcip.mail.orb.Mail value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.mail.orb.MailHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.mail.orb.MailHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.mail.orb.MailHelper.type();
  }
}
