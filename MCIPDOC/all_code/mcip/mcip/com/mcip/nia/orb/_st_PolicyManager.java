package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._st_PolicyManager
<li> <b>Source File</b> com/mcip/nia/orb/_st_PolicyManager.java
<li> <b>IDL Source File</b> policyManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PolicyManager
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PolicyManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    interface PolicyManager {
      ::com::mcip::orb::Stringss acceptCaseRpt(
        in ::com::mcip::nia::orb::CaseRptInfo caserptinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss acceptPolicyEdr(
        in ::com::mcip::nia::orb::PlyEdrAppInfo plyedrappinfoobj,
        in ::com::mcip::nia::orb::PlyEdrAppCrgoInfo plyedrappcrgoinfoobj,
        in ::com::mcip::orb::Stringss rdrinfo,
        in ::com::mcip::nia::orb::PlyEdrAppPayInfo plyedrapppayinfoobj,
        in ::com::mcip::nia::orb::PlyPlyAppNetInfo plyplyappnetinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      void getPolicyEdr(
        in ::com::mcip::nia::orb::PlyGetDocInfo plygetdocinfoobj,
        out any plyedrapp,
        out any plyedrappcrgo,
        out any plyedrapprdr,
        out any plyedrapppay,
        out any plyplyappnet
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean withdrawalEdrApp(
        in string edr_app_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      void getEdrAppInfo(
        in ::com::mcip::nia::orb::PlyEdrGridInfo plyedrgridinfoobj,
        out any plyedrapp,
        out any plyedrappcrgo,
        out any plyedrapprdr,
        out any plyedrapppay,
        out any plyplyappnet
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss confirmEdrAppProposal(
        in string edrapp_no,
        in string dpt_cde,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteEdrApp(
        in string edr_app_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _st_PolicyManager extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.nia.orb.PolicyManager {
  protected com.mcip.nia.orb.PolicyManager _wrapper = null;
  public com.mcip.nia.orb.PolicyManager _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyManager:1.0"
  };
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::acceptCaseRpt</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    ::com::mcip::orb::Stringss acceptCaseRpt(
      in ::com::mcip::nia::orb::CaseRptInfo caserptinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] acceptCaseRpt(
    com.mcip.nia.orb.CaseRptInfo caserptinfoobj
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("acceptCaseRpt", true);
      com.mcip.nia.orb.CaseRptInfoHelper.write(_output, caserptinfoobj);
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
  Operation: <b>::com::mcip::nia::orb::PolicyManager::acceptPolicyEdr</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    ::com::mcip::orb::Stringss acceptPolicyEdr(
      in ::com::mcip::nia::orb::PlyEdrAppInfo plyedrappinfoobj,
      in ::com::mcip::nia::orb::PlyEdrAppCrgoInfo plyedrappcrgoinfoobj,
      in ::com::mcip::orb::Stringss rdrinfo,
      in ::com::mcip::nia::orb::PlyEdrAppPayInfo plyedrapppayinfoobj,
      in ::com::mcip::nia::orb::PlyPlyAppNetInfo plyplyappnetinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] acceptPolicyEdr(
    com.mcip.nia.orb.PlyEdrAppInfo plyedrappinfoobj,
    com.mcip.nia.orb.PlyEdrAppCrgoInfo plyedrappcrgoinfoobj,
    java.lang.String[][] rdrinfo,
    com.mcip.nia.orb.PlyEdrAppPayInfo plyedrapppayinfoobj,
    com.mcip.nia.orb.PlyPlyAppNetInfo plyplyappnetinfoobj
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("acceptPolicyEdr", true);
      com.mcip.nia.orb.PlyEdrAppInfoHelper.write(_output, plyedrappinfoobj);
      com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper.write(_output, plyedrappcrgoinfoobj);
      com.mcip.orb.StringssHelper.write(_output, rdrinfo);
      com.mcip.nia.orb.PlyEdrAppPayInfoHelper.write(_output, plyedrapppayinfoobj);
      com.mcip.nia.orb.PlyPlyAppNetInfoHelper.write(_output, plyplyappnetinfoobj);
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
  Operation: <b>::com::mcip::nia::orb::PolicyManager::getPolicyEdr</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    void getPolicyEdr(
      in ::com::mcip::nia::orb::PlyGetDocInfo plygetdocinfoobj,
      out any plyedrapp,
      out any plyedrappcrgo,
      out any plyedrapprdr,
      out any plyedrapppay,
      out any plyplyappnet
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public void getPolicyEdr(
    com.mcip.nia.orb.PlyGetDocInfo plygetdocinfoobj,
    org.omg.CORBA.AnyHolder plyedrapp,
    org.omg.CORBA.AnyHolder plyedrappcrgo,
    org.omg.CORBA.AnyHolder plyedrapprdr,
    org.omg.CORBA.AnyHolder plyedrapppay,
    org.omg.CORBA.AnyHolder plyplyappnet
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("getPolicyEdr", true);
      com.mcip.nia.orb.PlyGetDocInfoHelper.write(_output, plygetdocinfoobj);
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
        plyedrapp.value = _input.read_any();
        plyedrappcrgo.value = _input.read_any();
        plyedrapprdr.value = _input.read_any();
        plyedrapppay.value = _input.read_any();
        plyplyappnet.value = _input.read_any();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::withdrawalEdrApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    boolean withdrawalEdrApp(
      in string edr_app_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean withdrawalEdrApp(
    java.lang.String edr_app_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("withdrawalEdrApp", true);
      _output.write_string(edr_app_no);
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
  Operation: <b>::com::mcip::nia::orb::PolicyManager::getEdrAppInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    void getEdrAppInfo(
      in ::com::mcip::nia::orb::PlyEdrGridInfo plyedrgridinfoobj,
      out any plyedrapp,
      out any plyedrappcrgo,
      out any plyedrapprdr,
      out any plyedrapppay,
      out any plyplyappnet
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public void getEdrAppInfo(
    com.mcip.nia.orb.PlyEdrGridInfo plyedrgridinfoobj,
    org.omg.CORBA.AnyHolder plyedrapp,
    org.omg.CORBA.AnyHolder plyedrappcrgo,
    org.omg.CORBA.AnyHolder plyedrapprdr,
    org.omg.CORBA.AnyHolder plyedrapppay,
    org.omg.CORBA.AnyHolder plyplyappnet
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    while(true) {
      _output = this._request("getEdrAppInfo", true);
      com.mcip.nia.orb.PlyEdrGridInfoHelper.write(_output, plyedrgridinfoobj);
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
        plyedrapp.value = _input.read_any();
        plyedrappcrgo.value = _input.read_any();
        plyedrapprdr.value = _input.read_any();
        plyedrapppay.value = _input.read_any();
        plyplyappnet.value = _input.read_any();
      }
      catch(org.omg.CORBA.TRANSIENT _exception) {
        continue;
      }
      break;
    }
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::confirmEdrAppProposal</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    ::com::mcip::orb::Stringss confirmEdrAppProposal(
      in string edrapp_no,
      in string dpt_cde,
      in string insrnc_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] confirmEdrAppProposal(
    java.lang.String edrapp_no,
    java.lang.String dpt_cde,
    java.lang.String insrnc_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("confirmEdrAppProposal", true);
      _output.write_string(edrapp_no);
      _output.write_string(dpt_cde);
      _output.write_string(insrnc_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyManager::deleteEdrApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    boolean deleteEdrApp(
      in string edr_app_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteEdrApp(
    java.lang.String edr_app_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("deleteEdrApp", true);
      _output.write_string(edr_app_no);
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
