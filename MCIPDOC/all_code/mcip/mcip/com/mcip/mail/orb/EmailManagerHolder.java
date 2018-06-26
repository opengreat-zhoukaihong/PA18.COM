package com.mcip.mail.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.mail.orb.EmailManagerHolder
<li> <b>Source File</b> com/mcip/mail/orb/EmailManagerHolder.java
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
final public class EmailManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.mail.orb.EmailManager value;
  public EmailManagerHolder() {
  }
  public EmailManagerHolder(com.mcip.mail.orb.EmailManager value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.mail.orb.EmailManagerHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.mail.orb.EmailManagerHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.mail.orb.EmailManagerHelper.type();
  }
}
