package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._st_PolicyInfoManager
<li> <b>Source File</b> com/mcip/nia/orb/_st_PolicyInfoManager.java
<li> <b>IDL Source File</b> policyInfoManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PolicyInfoManager
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PolicyInfoManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    interface PolicyInfoManager {
      ::com::mcip::orb::Stringss getOCList(
        in wstring user_id,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getOCInfo(
        in string OC_cde,
        in string insrnc_cde,
        in string crgo_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      wstring getPrintFormat(
        in wstring incondStr
      )
      raises(
        ::com::mcip::orb::CoException
      );
      wstring getPrintPolicy(
        in wstring incondStr
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyList(
        in wstring clnt_cde,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyInfo(
        in string agt_agr_cde,
        in string insrnc_cde,
        in string crgo_cde,
        in string crgo_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyPlcyList(
        in string agt_agr_cde,
        in string insrnc_cde,
        in string credit_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustPlcyList(
        in wstring user_id,
        in string insrnc_cde,
        in string credit_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyAppList(
        in wstring user_id,
        in string plyapp_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyAppInfo(
        in string plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyList(
        in wstring user_id,
        in string policy_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyInfo(
        in string policy_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyInfoLatest(
        in string policy_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalInfo(
        in string plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEndorseProposalInfo(
        in string edrapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppRdrInfo(
        in string in_plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyRdrInfo(
        in string in_ply_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptList(
        in wstring in_user_id,
        in string in_rpt_no,
        in string in_from_tm,
        in string in_to_tm,
        in string in_cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptInfo(
        in string in_rpt_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseClmList(
        in string in_rpt_no,
        in string in_status_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClaimList(
        in string in_clnt_cde,
        in string in_rpt_no,
        in string in_clm_no,
        in string in_from_tm,
        in string in_to_tm,
        in string in_status_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClmDgstList(
        in string in_rpt_no,
        in string in_ply_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getQuotation(
        in ::com::mcip::nia::orb::QuotaCndtn quotacndtnobj,
        in wstring rdr_type
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppNetAddress(
        in string cust_typ,
        in string in_clnt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClauseList(
        in wstring in_insrnc_cde,
        in wstring in_clause_cde,
        in wstring in_clnt_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalList(
        in wstring user_id,
        in string plyapp_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrAppList(
        in wstring user_id,
        in string edrapp_cde,
        in string ply_no,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrsmtList(
        in wstring user_id,
        in string edr_no,
        in string ply_no,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrsmtInfo(
        in string edr_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPreEdrInfo(
        in string edr_app_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean checkEdrApp(
        in string ply_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _st_PolicyInfoManager extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.nia.orb.PolicyInfoManager {
  protected com.mcip.nia.orb.PolicyInfoManager _wrapper = null;
  public com.mcip.nia.orb.PolicyInfoManager _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyInfoManager:1.0"
  };
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getOCList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getOCList(
      in wstring user_id,
      in string insrnc_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getOCList(
    java.lang.String user_id,
    java.lang.String insrnc_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getOCList", true);
      _output.write_wstring(user_id);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getOCInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getOCInfo(
      in string OC_cde,
      in string insrnc_cde,
      in string crgo_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getOCInfo(
    java.lang.String OC_cde,
    java.lang.String insrnc_cde,
    java.lang.String crgo_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getOCInfo", true);
      _output.write_string(OC_cde);
      _output.write_string(insrnc_cde);
      _output.write_string(crgo_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPrintFormat</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    wstring getPrintFormat(
      in wstring incondStr
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String getPrintFormat(
    java.lang.String incondStr
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String _result;
    while(true) {
      _output = this._request("getPrintFormat", true);
      _output.write_wstring(incondStr);
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
        _result = _input.read_wstring();
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPrintPolicy</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    wstring getPrintPolicy(
      in wstring incondStr
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String getPrintPolicy(
    java.lang.String incondStr
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String _result;
    while(true) {
      _output = this._request("getPrintPolicy", true);
      _output.write_wstring(incondStr);
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
        _result = _input.read_wstring();
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getAgencyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getAgencyList(
      in wstring clnt_cde,
      in string insrnc_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAgencyList(
    java.lang.String clnt_cde,
    java.lang.String insrnc_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getAgencyList", true);
      _output.write_wstring(clnt_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getAgencyInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getAgencyInfo(
      in string agt_agr_cde,
      in string insrnc_cde,
      in string crgo_cde,
      in string crgo_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAgencyInfo(
    java.lang.String agt_agr_cde,
    java.lang.String insrnc_cde,
    java.lang.String crgo_cde,
    java.lang.String crgo_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getAgencyInfo", true);
      _output.write_string(agt_agr_cde);
      _output.write_string(insrnc_cde);
      _output.write_string(crgo_cde);
      _output.write_string(crgo_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getAgencyPlcyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getAgencyPlcyList(
      in string agt_agr_cde,
      in string insrnc_cde,
      in string credit_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAgencyPlcyList(
    java.lang.String agt_agr_cde,
    java.lang.String insrnc_cde,
    java.lang.String credit_id
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getAgencyPlcyList", true);
      _output.write_string(agt_agr_cde);
      _output.write_string(insrnc_cde);
      _output.write_string(credit_id);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCustPlcyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCustPlcyList(
      in wstring user_id,
      in string insrnc_cde,
      in string credit_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCustPlcyList(
    java.lang.String user_id,
    java.lang.String insrnc_cde,
    java.lang.String credit_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCustPlcyList", true);
      _output.write_wstring(user_id);
      _output.write_string(insrnc_cde);
      _output.write_string(credit_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyAppList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyAppList(
      in wstring user_id,
      in string plyapp_cde,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyAppList(
    java.lang.String user_id,
    java.lang.String plyapp_cde,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPolicyAppList", true);
      _output.write_wstring(user_id);
      _output.write_string(plyapp_cde);
      _output.write_string(app_from_tm);
      _output.write_string(app_to_tm);
      _output.write_string(cust_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyAppInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyAppInfo(
      in string plyapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyAppInfo(
    java.lang.String plyapp_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPolicyAppInfo", true);
      _output.write_string(plyapp_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyList(
      in wstring user_id,
      in string policy_cde,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyList(
    java.lang.String user_id,
    java.lang.String policy_cde,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPolicyList", true);
      _output.write_wstring(user_id);
      _output.write_string(policy_cde);
      _output.write_string(app_from_tm);
      _output.write_string(app_to_tm);
      _output.write_string(cust_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyInfo(
      in string policy_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyInfo(
    java.lang.String policy_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPolicyInfo", true);
      _output.write_string(policy_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyInfoLatest</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyInfoLatest(
      in string policy_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyInfoLatest(
    java.lang.String policy_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPolicyInfoLatest", true);
      _output.write_string(policy_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getProposalInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getProposalInfo(
      in string plyapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getProposalInfo(
    java.lang.String plyapp_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getProposalInfo", true);
      _output.write_string(plyapp_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEndorseProposalInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEndorseProposalInfo(
      in string edrapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEndorseProposalInfo(
    java.lang.String edrapp_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getEndorseProposalInfo", true);
      _output.write_string(edrapp_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPlyAppRdrInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPlyAppRdrInfo(
      in string in_plyapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPlyAppRdrInfo(
    java.lang.String in_plyapp_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPlyAppRdrInfo", true);
      _output.write_string(in_plyapp_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPlyRdrInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPlyRdrInfo(
      in string in_ply_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPlyRdrInfo(
    java.lang.String in_ply_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPlyRdrInfo", true);
      _output.write_string(in_ply_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCaseRptList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCaseRptList(
      in wstring in_user_id,
      in string in_rpt_no,
      in string in_from_tm,
      in string in_to_tm,
      in string in_cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCaseRptList(
    java.lang.String in_user_id,
    java.lang.String in_rpt_no,
    java.lang.String in_from_tm,
    java.lang.String in_to_tm,
    java.lang.String in_cust_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCaseRptList", true);
      _output.write_wstring(in_user_id);
      _output.write_string(in_rpt_no);
      _output.write_string(in_from_tm);
      _output.write_string(in_to_tm);
      _output.write_string(in_cust_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCaseRptInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCaseRptInfo(
      in string in_rpt_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCaseRptInfo(
    java.lang.String in_rpt_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCaseRptInfo", true);
      _output.write_string(in_rpt_no);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCaseClmList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCaseClmList(
      in string in_rpt_no,
      in string in_status_mrk
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCaseClmList(
    java.lang.String in_rpt_no,
    java.lang.String in_status_mrk
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCaseClmList", true);
      _output.write_string(in_rpt_no);
      _output.write_string(in_status_mrk);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getClaimList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getClaimList(
      in string in_clnt_cde,
      in string in_rpt_no,
      in string in_clm_no,
      in string in_from_tm,
      in string in_to_tm,
      in string in_status_mrk
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getClaimList(
    java.lang.String in_clnt_cde,
    java.lang.String in_rpt_no,
    java.lang.String in_clm_no,
    java.lang.String in_from_tm,
    java.lang.String in_to_tm,
    java.lang.String in_status_mrk
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getClaimList", true);
      _output.write_string(in_clnt_cde);
      _output.write_string(in_rpt_no);
      _output.write_string(in_clm_no);
      _output.write_string(in_from_tm);
      _output.write_string(in_to_tm);
      _output.write_string(in_status_mrk);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getClmDgstList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getClmDgstList(
      in string in_rpt_no,
      in string in_ply_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getClmDgstList(
    java.lang.String in_rpt_no,
    java.lang.String in_ply_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getClmDgstList", true);
      _output.write_string(in_rpt_no);
      _output.write_string(in_ply_no);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getQuotation</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getQuotation(
      in ::com::mcip::nia::orb::QuotaCndtn quotacndtnobj,
      in wstring rdr_type
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getQuotation(
    com.mcip.nia.orb.QuotaCndtn quotacndtnobj,
    java.lang.String rdr_type
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getQuotation", true);
      com.mcip.nia.orb.QuotaCndtnHelper.write(_output, quotacndtnobj);
      _output.write_wstring(rdr_type);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPlyAppNetAddress</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPlyAppNetAddress(
      in string cust_typ,
      in string in_clnt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPlyAppNetAddress(
    java.lang.String cust_typ,
    java.lang.String in_clnt_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPlyAppNetAddress", true);
      _output.write_string(cust_typ);
      _output.write_string(in_clnt_cde);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getClauseList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getClauseList(
      in wstring in_insrnc_cde,
      in wstring in_clause_cde,
      in wstring in_clnt_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getClauseList(
    java.lang.String in_insrnc_cde,
    java.lang.String in_clause_cde,
    java.lang.String in_clnt_cnm
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getClauseList", true);
      _output.write_wstring(in_insrnc_cde);
      _output.write_wstring(in_clause_cde);
      _output.write_wstring(in_clnt_cnm);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getProposalList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getProposalList(
      in wstring user_id,
      in string plyapp_cde,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getProposalList(
    java.lang.String user_id,
    java.lang.String plyapp_cde,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getProposalList", true);
      _output.write_wstring(user_id);
      _output.write_string(plyapp_cde);
      _output.write_string(app_from_tm);
      _output.write_string(app_to_tm);
      _output.write_string(cust_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEdrAppList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEdrAppList(
      in wstring user_id,
      in string edrapp_cde,
      in string ply_no,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEdrAppList(
    java.lang.String user_id,
    java.lang.String edrapp_cde,
    java.lang.String ply_no,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getEdrAppList", true);
      _output.write_wstring(user_id);
      _output.write_string(edrapp_cde);
      _output.write_string(ply_no);
      _output.write_string(app_from_tm);
      _output.write_string(app_to_tm);
      _output.write_string(cust_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEdrsmtList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEdrsmtList(
      in wstring user_id,
      in string edr_no,
      in string ply_no,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEdrsmtList(
    java.lang.String user_id,
    java.lang.String edr_no,
    java.lang.String ply_no,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getEdrsmtList", true);
      _output.write_wstring(user_id);
      _output.write_string(edr_no);
      _output.write_string(ply_no);
      _output.write_string(app_from_tm);
      _output.write_string(app_to_tm);
      _output.write_string(cust_typ);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEdrsmtInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEdrsmtInfo(
      in string edr_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEdrsmtInfo(
    java.lang.String edr_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getEdrsmtInfo", true);
      _output.write_string(edr_no);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPreEdrInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPreEdrInfo(
      in string edr_app_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPreEdrInfo(
    java.lang.String edr_app_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPreEdrInfo", true);
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
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::checkEdrApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    boolean checkEdrApp(
      in string ply_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean checkEdrApp(
    java.lang.String ply_no
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    boolean _result;
    while(true) {
      _output = this._request("checkEdrApp", true);
      _output.write_string(ply_no);
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
