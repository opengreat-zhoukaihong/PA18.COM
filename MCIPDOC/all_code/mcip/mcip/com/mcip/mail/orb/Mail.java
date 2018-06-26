package com.mcip.mail.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.mail.orb.Mail
<li> <b>Source File</b> com/mcip/mail/orb/Mail.java
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
final public class Mail {
  public java.lang.String sender;
  public java.lang.String receiver;
  public java.lang.String subject;
  public java.lang.String content;
  public Mail() {
  }
  public Mail(
    java.lang.String sender,
    java.lang.String receiver,
    java.lang.String subject,
    java.lang.String content
  ) {
    this.sender = sender;
    this.receiver = receiver;
    this.subject = subject;
    this.content = content;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.mail.orb.MailHelper.insert(any, this);
    return any.toString();
  }
}
