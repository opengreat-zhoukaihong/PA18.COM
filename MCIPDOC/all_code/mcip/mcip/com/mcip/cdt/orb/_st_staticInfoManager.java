package com.mcip.cdt.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cdt.orb._st_staticInfoManager
<li> <b>Source File</b> com/mcip/cdt/orb/_st_staticInfoManager.java
<li> <b>IDL Source File</b> getStaticInfo.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cdt::orb::staticInfoManager
<li> <b>Repository Identifier</b> IDL:com/mcip/cdt/orb/staticInfoManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cdt/orb"
    interface staticInfoManager {
      ::com::mcip::orb::Stringss getNationalList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAreaList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProvinceList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCityList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEduList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getTitleList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getDutyList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getTradeTypeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getOrgTypeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getOwnershipList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getScaleList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPremiumScaleList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCurrencyList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCargoClsList(
        in string cde,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCargoTypeList(
        in string Cargocls
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPackList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getExchangeRateList(
        in string cur1,
        in string cur2
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPayModeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getInsuranceClassList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getInsuranceDefineList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getInsuranceTypeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClauseList(
        in string insrnc_cde,
        in string claus_cde,
        in string add_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEndorseReasonList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getDepartmentList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgentCharacterList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getSurveyAgentList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCarriageList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getVslLevelList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCertificateList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getMajorList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getMarriageList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getSexList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEmployeeCodeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPACrgoClsTypList(
        in wstring in_crgo_cde,
        in wstring in_site_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getNetCodeList(
        in wstring in_net_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCurrencyInfo(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getRptTelNum(
        in string in_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _st_staticInfoManager extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.cdt.orb.staticInfoManager {
  protected com.mcip.cdt.orb.staticInfoManager _wrapper = null;
  public com.mcip.cdt.orb.staticInfoManager _this() {
    return this;
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/cdt/orb/staticInfoManager:1.0"
  };
  /**
  <p>
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getNationalList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getNationalList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getNationalList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getNationalList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getAreaList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getAreaList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAreaList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getAreaList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getProvinceList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getProvinceList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getProvinceList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getProvinceList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getCityList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getCityList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCityList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCityList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getEduList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getEduList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEduList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getEduList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getTitleList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getTitleList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getTitleList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getTitleList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getDutyList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getDutyList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getDutyList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getDutyList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getTradeTypeList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getTradeTypeList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getTradeTypeList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getTradeTypeList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getOrgTypeList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getOrgTypeList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getOrgTypeList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getOrgTypeList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getOwnershipList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getOwnershipList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getOwnershipList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getOwnershipList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getScaleList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getScaleList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getScaleList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getScaleList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getPremiumScaleList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getPremiumScaleList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPremiumScaleList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPremiumScaleList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getCurrencyList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getCurrencyList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCurrencyList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCurrencyList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getCargoClsList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getCargoClsList(
      in string cde,
      in string insrnc_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCargoClsList(
    java.lang.String cde,
    java.lang.String insrnc_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCargoClsList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getCargoTypeList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getCargoTypeList(
      in string Cargocls
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCargoTypeList(
    java.lang.String Cargocls
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCargoTypeList", true);
      _output.write_string(Cargocls);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getPackList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getPackList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPackList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPackList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getExchangeRateList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getExchangeRateList(
      in string cur1,
      in string cur2
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getExchangeRateList(
    java.lang.String cur1,
    java.lang.String cur2
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getExchangeRateList", true);
      _output.write_string(cur1);
      _output.write_string(cur2);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getPayModeList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getPayModeList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPayModeList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPayModeList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getInsuranceClassList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getInsuranceClassList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getInsuranceClassList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getInsuranceClassList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getInsuranceDefineList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getInsuranceDefineList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getInsuranceDefineList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getInsuranceDefineList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getInsuranceTypeList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getInsuranceTypeList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getInsuranceTypeList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getInsuranceTypeList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getClauseList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getClauseList(
      in string insrnc_cde,
      in string claus_cde,
      in string add_mrk
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getClauseList(
    java.lang.String insrnc_cde,
    java.lang.String claus_cde,
    java.lang.String add_mrk
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getClauseList", true);
      _output.write_string(insrnc_cde);
      _output.write_string(claus_cde);
      _output.write_string(add_mrk);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getEndorseReasonList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getEndorseReasonList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEndorseReasonList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getEndorseReasonList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getDepartmentList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getDepartmentList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getDepartmentList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getDepartmentList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getAgentCharacterList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getAgentCharacterList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAgentCharacterList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getAgentCharacterList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getSurveyAgentList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getSurveyAgentList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getSurveyAgentList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getSurveyAgentList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getCarriageList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getCarriageList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCarriageList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCarriageList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getVslLevelList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getVslLevelList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getVslLevelList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getVslLevelList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getCertificateList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getCertificateList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCertificateList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCertificateList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getMajorList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getMajorList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getMajorList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getMajorList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getMarriageList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getMarriageList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getMarriageList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getMarriageList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getSexList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getSexList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getSexList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getSexList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getEmployeeCodeList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getEmployeeCodeList(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEmployeeCodeList(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getEmployeeCodeList", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getPACrgoClsTypList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getPACrgoClsTypList(
      in wstring in_crgo_cde,
      in wstring in_site_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPACrgoClsTypList(
    java.lang.String in_crgo_cde,
    java.lang.String in_site_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getPACrgoClsTypList", true);
      _output.write_wstring(in_crgo_cde);
      _output.write_wstring(in_site_cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getNetCodeList</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getNetCodeList(
      in wstring in_net_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getNetCodeList(
    java.lang.String in_net_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getNetCodeList", true);
      _output.write_wstring(in_net_cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getCurrencyInfo</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getCurrencyInfo(
      in string cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCurrencyInfo(
    java.lang.String cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getCurrencyInfo", true);
      _output.write_string(cde);
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
  Operation: <b>::com::mcip::cdt::orb::staticInfoManager::getRptTelNum</b>.
  <pre>
    #pragma prefix "com/mcip/cdt/orb/staticInfoManager"
    ::com::mcip::orb::Stringss getRptTelNum(
      in string in_dpt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getRptTelNum(
    java.lang.String in_dpt_cde
  ) throws
    com.mcip.orb.CoException {
    org.omg.CORBA.portable.OutputStream _output;
    org.omg.CORBA.portable.InputStream _input;
    java.lang.String[][] _result;
    while(true) {
      _output = this._request("getRptTelNum", true);
      _output.write_string(in_dpt_cde);
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
}
