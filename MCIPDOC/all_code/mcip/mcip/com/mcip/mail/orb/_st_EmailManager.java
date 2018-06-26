package com.mcip.mail.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.mail.orb._st_EmailManager
<li> <b>Source File</b> com/mcip/mail/orb/_st_EmailManager.java
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
public class _st_EmailManager extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.mail.orb.EmailManager {
  protected com.mcip.mail.orb.EmailManager _wrapper = null;
  public com.mcip.mail.orb.EmailManager _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/mail/orb/EmailManager:1.0"
  };
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
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("GetMailList", true);
      _output.write_string(mailcde);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = com.mcip.orb.StringssHelper.read(_input);
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
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
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("SetMailFlag", true);
      _output.write_string(mailcde);
      com.mcip.orb.StringsHelper.write(_output, key);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = _input.read_boolean();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
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
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("OnlineMail", true);
      com.mcip.mail.orb.MailHelper.write(_output, inmail);
      org.omg.CORBA.StringHolder _exception_id = new org.omg.CORBA.StringHolder();
      try {
        _input = this._invoke(_output, _exception_id);
        if(_exception_id.value != null) {
          if(_exception_id.value.equals(com.mcip.orb.CoExceptionHelper.id())) {
            throw com.mcip.orb.CoExceptionHelper.read(_input);
          }
          throw new org.omg.CORBA.MARSHAL
            ("Unexpected User Exception: " + _exception_id.value);
        }
        _result = _input.read_boolean();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
    return _result;
  }
}
