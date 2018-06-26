package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._st_PolicyAppManager
<li> <b>Source File</b> com/mcip/nia/orb/_st_PolicyAppManager.java
<li> <b>IDL Source File</b> policyAppManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PolicyAppManager
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PolicyAppManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    interface PolicyAppManager {
      ::com::mcip::orb::Stringss acceptPolicyApp(
        in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
        in ::com::mcip::orb::Stringss rdrinfo
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean withdrawalPolicyApp(
        in string plcyapp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss updatePolicyApp(
        in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
        in ::com::mcip::orb::Stringss rdrinfo
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss confirmPolicyAppProposal(
        in string plcyapp_no,
        in string dpt_cde,
        in string insrnc_cde,
        in string undr_prsn
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptUserRemark(
        in string plcyapp_no,
        in string app_cde,
        in wstring user_remark,
        in string app_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deletePolicyApp(
        in string plcyapp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePayFlag(
        in string plcy_no,
        in string pay_flag,
        in string app_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _st_PolicyAppManager extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.nia.orb.PolicyAppManager {
  protected com.mcip.nia.orb.PolicyAppManager _wrapper = null;
  public com.mcip.nia.orb.PolicyAppManager _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyAppManager:1.0"
  };
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::acceptPolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    ::com::mcip::orb::Stringss acceptPolicyApp(
      in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
      in ::com::mcip::orb::Stringss rdrinfo
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] acceptPolicyApp(
    com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj,
    java.lang.String[][] rdrinfo
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("acceptPolicyApp", true);
      com.mcip.nia.orb.PlcyAppInfoHelper.write(_output, plcyappinfoobj);
      com.mcip.orb.StringssHelper.write(_output, rdrinfo);
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
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::withdrawalPolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean withdrawalPolicyApp(
      in string plcyapp_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean withdrawalPolicyApp(
    java.lang.String plcyapp_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("withdrawalPolicyApp", true);
      _output.write_string(plcyapp_no);
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
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::updatePolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    ::com::mcip::orb::Stringss updatePolicyApp(
      in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
      in ::com::mcip::orb::Stringss rdrinfo
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] updatePolicyApp(
    com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj,
    java.lang.String[][] rdrinfo
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("updatePolicyApp", true);
      com.mcip.nia.orb.PlcyAppInfoHelper.write(_output, plcyappinfoobj);
      com.mcip.orb.StringssHelper.write(_output, rdrinfo);
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
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::confirmPolicyAppProposal</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    ::com::mcip::orb::Stringss confirmPolicyAppProposal(
      in string plcyapp_no,
      in string dpt_cde,
      in string insrnc_cde,
      in string undr_prsn
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] confirmPolicyAppProposal(
    java.lang.String plcyapp_no,
    java.lang.String dpt_cde,
    java.lang.String insrnc_cde,
    java.lang.String undr_prsn
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("confirmPolicyAppProposal", true);
      _output.write_string(plcyapp_no);
      _output.write_string(dpt_cde);
      _output.write_string(insrnc_cde);
      _output.write_string(undr_prsn);
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
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::acceptUserRemark</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean acceptUserRemark(
      in string plcyapp_no,
      in string app_cde,
      in wstring user_remark,
      in string app_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptUserRemark(
    java.lang.String plcyapp_no,
    java.lang.String app_cde,
    java.lang.String user_remark,
    java.lang.String app_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("acceptUserRemark", true);
      _output.write_string(plcyapp_no);
      _output.write_string(app_cde);
      _output.write_wstring(user_remark);
      _output.write_string(app_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::deletePolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean deletePolicyApp(
      in string plcyapp_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deletePolicyApp(
    java.lang.String plcyapp_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("deletePolicyApp", true);
      _output.write_string(plcyapp_no);
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
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::updatePayFlag</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean updatePayFlag(
      in string plcy_no,
      in string pay_flag,
      in string app_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updatePayFlag(
    java.lang.String plcy_no,
    java.lang.String pay_flag,
    java.lang.String app_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("updatePayFlag", true);
      _output.write_string(plcy_no);
      _output.write_string(pay_flag);
      _output.write_string(app_typ);
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
