package com.mcip.mail.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.mail.orb.EmailManager
<li> <b>Source File</b> com/mcip/mail/orb/EmailManager.java
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
public interface EmailManager extends com.inprise.vbroker.CORBA.Object {
  /**
  <p>
  Operation: <b>::com::mcip::mail::orb::EmailManager::GetMailList</b>.
  <pre>
    #pragma prefix "com/mcip/mail/orb/EmailManager"
    ::com::mcip::orb::Stringss GetMailList(
      in string mailcde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] GetMailList(
    java.lang.String mailcde
  ) throws
    com.mcip.orb.CoException;
  /**
  <p>
  Operation: <b>::com::mcip::mail::orb::EmailManager::SetMailFlag</b>.
  <pre>
    #pragma prefix "com/mcip/mail/orb/EmailManager"
    boolean SetMailFlag(
      in string mailcde,
      in ::com::mcip::orb::Strings key
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean SetMailFlag(
    java.lang.String mailcde,
    java.lang.String[] key
  ) throws
    com.mcip.orb.CoException;
  /**
  <p>
  Operation: <b>::com::mcip::mail::orb::EmailManager::OnlineMail</b>.
  <pre>
    #pragma prefix "com/mcip/mail/orb/EmailManager"
    boolean OnlineMail(
      in ::com::mcip::mail::orb::Mail inmail
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean OnlineMail(
    com.mcip.mail.orb.Mail inmail
  ) throws
    com.mcip.orb.CoException;
}
