package com.mcip.mail.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/MailDaemon.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::mail::orb::EmailManager
 * <li> <b>Repository Id</b> IDL:com/mcip/mail/orb/EmailManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface EmailManager {
  ...
};
 * </pre>
 */
public interface EmailManagerOperations {
  /**
   * <pre>
   *   com.mcip.orb.Stringss GetMailList (in string mailcde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] GetMailList (java.lang.String mailcde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   boolean SetMailFlag (in string mailcde, in com.mcip.orb.Strings key)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean SetMailFlag (java.lang.String mailcde, 
                              java.lang.String[] key) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   boolean OnlineMail (in com.mcip.mail.orb.Mail inmail)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean OnlineMail (com.mcip.mail.orb.Mail inmail) throws com.mcip.orb.CoException;

}
