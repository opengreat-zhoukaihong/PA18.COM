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
public abstract class EmailManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.mail.orb.EmailManagerOperations {

  public com.mcip.mail.orb.EmailManager _this () {
   return com.mcip.mail.orb.EmailManagerHelper.narrow(super._this_object());
  }

  public com.mcip.mail.orb.EmailManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.mail.orb.EmailManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/mail/orb/EmailManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("GetMailList", new int[] { 0, 0 });
    _methods.put("SetMailFlag", new int[] { 0, 1 });
    _methods.put("OnlineMail", new int[] { 0, 2 });
  }

  public org.omg.CORBA.portable.OutputStream _invoke (java.lang.String opName,
                                                      org.omg.CORBA.portable.InputStream _input,
                                                      org.omg.CORBA.portable.ResponseHandler handler) {
    int[] method = (int[]) _methods.get(opName);
    if (method == null) {
      throw new org.omg.CORBA.BAD_OPERATION();
    }
    switch (method[0]) {
      case 0: {
        return com.mcip.mail.orb.EmailManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.mail.orb.EmailManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
      try {
        java.lang.String mailcde;
        mailcde = _input.read_string();
        java.lang.String[][] _result = _self.GetMailList(mailcde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 1: {
      try {
        java.lang.String mailcde;
        mailcde = _input.read_string();
        java.lang.String[] key;
        key = com.mcip.orb.StringsHelper.read(_input);
        boolean _result = _self.SetMailFlag(mailcde, key);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 2: {
      try {
        com.mcip.mail.orb.Mail inmail;
        inmail = com.mcip.mail.orb.MailHelper.read(_input);
        boolean _result = _self.OnlineMail(inmail);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      }
      throw new org.omg.CORBA.BAD_OPERATION();
    }
  }
}
