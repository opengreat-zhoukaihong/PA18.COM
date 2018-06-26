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
public final class MailHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.mail.orb.Mail value;

  public MailHolder () {
  }

  public MailHolder (final com.mcip.mail.orb.Mail _vis_value) {
    this.value = _vis_value;
  }

  public void _read (final org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.mail.orb.MailHelper.read(input);
  }

  public void _write (final org.omg.CORBA.portable.OutputStream output) {
    com.mcip.mail.orb.MailHelper.write(output, value);
  }

  public org.omg.CORBA.TypeCode _type () {
    return com.mcip.mail.orb.MailHelper.type();
  }
}
