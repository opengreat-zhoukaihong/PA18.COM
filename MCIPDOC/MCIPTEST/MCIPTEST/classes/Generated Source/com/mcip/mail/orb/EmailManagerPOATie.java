
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
public class EmailManagerPOATie extends EmailManagerPOA {
  private com.mcip.mail.orb.EmailManagerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public EmailManagerPOATie (final com.mcip.mail.orb.EmailManagerOperations _delegate) {
    this._delegate = _delegate;
  }

  public EmailManagerPOATie (final com.mcip.mail.orb.EmailManagerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public com.mcip.mail.orb.EmailManagerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final com.mcip.mail.orb.EmailManagerOperations delegate) {
    this._delegate = delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss GetMailList (in string mailcde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] GetMailList (java.lang.String mailcde) throws  com.mcip.orb.CoException {
    return this._delegate.GetMailList(mailcde);
  }

  /**
   * <pre>
   *   boolean SetMailFlag (in string mailcde, in com.mcip.orb.Strings key)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean SetMailFlag (java.lang.String mailcde, 
                              java.lang.String[] key) throws  com.mcip.orb.CoException {
    return this._delegate.SetMailFlag(mailcde, key);
  }

  /**
   * <pre>
   *   boolean OnlineMail (in com.mcip.mail.orb.Mail inmail)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean OnlineMail (com.mcip.mail.orb.Mail inmail) throws  com.mcip.orb.CoException {
    return this._delegate.OnlineMail(inmail);
  }

}
