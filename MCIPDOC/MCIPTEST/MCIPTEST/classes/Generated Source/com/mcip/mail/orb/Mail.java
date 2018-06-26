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
public final class Mail implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String sender;
  
  public java.lang.String receiver;
  
  public java.lang.String subject;
  
  public java.lang.String content;

  public Mail () {
  }

  public Mail (final java.lang.String sender, 
               final java.lang.String receiver, 
               final java.lang.String subject, 
               final java.lang.String content) {
    this.sender = sender;
    this.receiver = receiver;
    this.subject = subject;
    this.content = content;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.mail.orb.Mail {");
    _ret.append("\n");
    _ret.append("java.lang.String sender=");
    _ret.append(sender != null?'\"' + sender + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String receiver=");
    _ret.append(receiver != null?'\"' + receiver + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String subject=");
    _ret.append(subject != null?'\"' + subject + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String content=");
    _ret.append(content != null?'\"' + content + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.mail.orb.Mail) {
      final com.mcip.mail.orb.Mail obj = (com.mcip.mail.orb.Mail)o;
      boolean res = true;
      do {
        res = this.sender == obj.sender ||
         (this.sender != null && obj.sender != null && this.sender.equals(obj.sender));
        if (!res) break;
        res = this.receiver == obj.receiver ||
         (this.receiver != null && obj.receiver != null && this.receiver.equals(obj.receiver));
        if (!res) break;
        res = this.subject == obj.subject ||
         (this.subject != null && obj.subject != null && this.subject.equals(obj.subject));
        if (!res) break;
        res = this.content == obj.content ||
         (this.content != null && obj.content != null && this.content.equals(obj.content));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
