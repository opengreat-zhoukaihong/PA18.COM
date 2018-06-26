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
public class _EmailManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.mail.orb.EmailManager {
  final public static java.lang.Class _opsClass = com.mcip.mail.orb.EmailManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/mail/orb/EmailManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss GetMailList (in string mailcde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] GetMailList (java.lang.String mailcde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("GetMailList", true);
          _output.write_string((java.lang.String)mailcde);
          _input = this._invoke(_output);
          _result = com.mcip.orb.StringssHelper.read(_input);
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw             com.mcip.orb.CoExceptionHelper.read(_exception.getInputStream());
          }
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.portable.RemarshalException _exception) {
          continue;
        }
        finally {
          this._releaseReply(_input);
        }
      } else {
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("GetMailList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.mail.orb.EmailManagerOperations _self = (com.mcip.mail.orb.EmailManagerOperations)_so.servant;
        try {
          return _self.GetMailList(mailcde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean SetMailFlag (in string mailcde, in com.mcip.orb.Strings key)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean SetMailFlag (java.lang.String mailcde, 
                              java.lang.String[] key) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("SetMailFlag", true);
          _output.write_string((java.lang.String)mailcde);
          com.mcip.orb.StringsHelper.write(_output, key);
          _input = this._invoke(_output);
          _result = _input.read_boolean();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw             com.mcip.orb.CoExceptionHelper.read(_exception.getInputStream());
          }
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.portable.RemarshalException _exception) {
          continue;
        }
        finally {
          this._releaseReply(_input);
        }
      } else {
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("SetMailFlag", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.mail.orb.EmailManagerOperations _self = (com.mcip.mail.orb.EmailManagerOperations)_so.servant;
        try {
          return _self.SetMailFlag(mailcde, key);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean OnlineMail (in com.mcip.mail.orb.Mail inmail)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean OnlineMail (com.mcip.mail.orb.Mail inmail) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("OnlineMail", true);
          com.mcip.mail.orb.MailHelper.write(_output, inmail);
          _input = this._invoke(_output);
          _result = _input.read_boolean();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
          java.lang.String _exception_id = _exception.getId();
          if (_exception_id.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw             com.mcip.orb.CoExceptionHelper.read(_exception.getInputStream());
          }
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.portable.RemarshalException _exception) {
          continue;
        }
        finally {
          this._releaseReply(_input);
        }
      } else {
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("OnlineMail", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.mail.orb.EmailManagerOperations _self = (com.mcip.mail.orb.EmailManagerOperations)_so.servant;
        try {
          return _self.OnlineMail(inmail);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
