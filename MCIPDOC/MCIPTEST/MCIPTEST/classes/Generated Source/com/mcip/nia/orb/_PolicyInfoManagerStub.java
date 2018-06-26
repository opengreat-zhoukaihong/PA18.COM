package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyInfoManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyInfoManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyInfoManager {
  ...
};
 * </pre>
 */
public class _PolicyInfoManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.nia.orb.PolicyInfoManager {
  final public static java.lang.Class _opsClass = com.mcip.nia.orb.PolicyInfoManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyInfoManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOCList (in wstring user_id, in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOCList (java.lang.String user_id, 
                                         java.lang.String insrnc_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getOCList", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)insrnc_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getOCList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getOCList(user_id, insrnc_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOCInfo (in string OC_cde, in string insrnc_cde,
                                   in string crgo_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOCInfo (java.lang.String OC_cde, 
                                         java.lang.String insrnc_cde, 
                                         java.lang.String crgo_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getOCInfo", true);
          _output.write_string((java.lang.String)OC_cde);
          _output.write_string((java.lang.String)insrnc_cde);
          _output.write_string((java.lang.String)crgo_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getOCInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getOCInfo(OC_cde, insrnc_cde, crgo_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   wstring getPrintFormat (in wstring incondStr)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String getPrintFormat (java.lang.String incondStr) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String _result;
        try {
          _output = this._request("getPrintFormat", true);
          _output.write_wstring((java.lang.String)incondStr);
          _input = this._invoke(_output);
          _result = _input.read_wstring();
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPrintFormat", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPrintFormat(incondStr);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   wstring getPrintPolicy (in wstring incondStr)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String getPrintPolicy (java.lang.String incondStr) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String _result;
        try {
          _output = this._request("getPrintPolicy", true);
          _output.write_wstring((java.lang.String)incondStr);
          _input = this._invoke(_output);
          _result = _input.read_wstring();
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPrintPolicy", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPrintPolicy(incondStr);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgencyList (in wstring clnt_cde,
                                       in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgencyList (java.lang.String clnt_cde, 
                                             java.lang.String insrnc_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getAgencyList", true);
          _output.write_wstring((java.lang.String)clnt_cde);
          _output.write_string((java.lang.String)insrnc_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAgencyList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getAgencyList(clnt_cde, insrnc_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgencyInfo (in string agt_agr_cde,
                                       in string insrnc_cde,
                                       in string crgo_cde, in string crgo_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgencyInfo (java.lang.String agt_agr_cde, 
                                             java.lang.String insrnc_cde, 
                                             java.lang.String crgo_cde, 
                                             java.lang.String crgo_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getAgencyInfo", true);
          _output.write_string((java.lang.String)agt_agr_cde);
          _output.write_string((java.lang.String)insrnc_cde);
          _output.write_string((java.lang.String)crgo_cde);
          _output.write_string((java.lang.String)crgo_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAgencyInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getAgencyInfo(agt_agr_cde, insrnc_cde, crgo_cde, crgo_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgencyPlcyList (in string agt_agr_cde,
                                           in string insrnc_cde,
                                           in string credit_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgencyPlcyList (java.lang.String agt_agr_cde, 
                                                 java.lang.String insrnc_cde, 
                                                 java.lang.String credit_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getAgencyPlcyList", true);
          _output.write_string((java.lang.String)agt_agr_cde);
          _output.write_string((java.lang.String)insrnc_cde);
          _output.write_string((java.lang.String)credit_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAgencyPlcyList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getAgencyPlcyList(agt_agr_cde, insrnc_cde, credit_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCustPlcyList (in wstring user_id,
                                         in string insrnc_cde,
                                         in string credit_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCustPlcyList (java.lang.String user_id, 
                                               java.lang.String insrnc_cde, 
                                               java.lang.String credit_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCustPlcyList", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)insrnc_cde);
          _output.write_string((java.lang.String)credit_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCustPlcyList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getCustPlcyList(user_id, insrnc_cde, credit_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyAppList (in wstring user_id,
                                          in string plyapp_cde,
                                          in string app_from_tm,
                                          in string app_to_tm,
                                          in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyAppList (java.lang.String user_id, 
                                                java.lang.String plyapp_cde, 
                                                java.lang.String app_from_tm, 
                                                java.lang.String app_to_tm, 
                                                java.lang.String cust_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPolicyAppList", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)plyapp_cde);
          _output.write_string((java.lang.String)app_from_tm);
          _output.write_string((java.lang.String)app_to_tm);
          _output.write_string((java.lang.String)cust_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPolicyAppList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPolicyAppList(user_id, plyapp_cde, app_from_tm, app_to_tm, 
                                        cust_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyAppInfo (in string plyapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyAppInfo (java.lang.String plyapp_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPolicyAppInfo", true);
          _output.write_string((java.lang.String)plyapp_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPolicyAppInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPolicyAppInfo(plyapp_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyList (in wstring user_id,
                                       in string policy_cde,
                                       in string app_from_tm,
                                       in string app_to_tm, in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyList (java.lang.String user_id, 
                                             java.lang.String policy_cde, 
                                             java.lang.String app_from_tm, 
                                             java.lang.String app_to_tm, 
                                             java.lang.String cust_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPolicyList", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)policy_cde);
          _output.write_string((java.lang.String)app_from_tm);
          _output.write_string((java.lang.String)app_to_tm);
          _output.write_string((java.lang.String)cust_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPolicyList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPolicyList(user_id, policy_cde, app_from_tm, app_to_tm, 
                                     cust_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyInfo (in string policy_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyInfo (java.lang.String policy_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPolicyInfo", true);
          _output.write_string((java.lang.String)policy_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPolicyInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPolicyInfo(policy_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyInfoLatest (in string policy_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyInfoLatest (java.lang.String policy_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPolicyInfoLatest", true);
          _output.write_string((java.lang.String)policy_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPolicyInfoLatest", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPolicyInfoLatest(policy_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProposalInfo (in string plyapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProposalInfo (java.lang.String plyapp_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getProposalInfo", true);
          _output.write_string((java.lang.String)plyapp_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getProposalInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getProposalInfo(plyapp_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEndorseProposalInfo (in string edrapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEndorseProposalInfo (java.lang.String edrapp_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEndorseProposalInfo", true);
          _output.write_string((java.lang.String)edrapp_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEndorseProposalInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getEndorseProposalInfo(edrapp_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPlyAppRdrInfo (in string in_plyapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPlyAppRdrInfo (java.lang.String in_plyapp_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPlyAppRdrInfo", true);
          _output.write_string((java.lang.String)in_plyapp_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPlyAppRdrInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPlyAppRdrInfo(in_plyapp_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPlyRdrInfo (in string in_ply_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPlyRdrInfo (java.lang.String in_ply_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPlyRdrInfo", true);
          _output.write_string((java.lang.String)in_ply_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPlyRdrInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPlyRdrInfo(in_ply_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCaseRptList (in wstring in_user_id,
                                        in string in_rpt_no,
                                        in string in_from_tm,
                                        in string in_to_tm,
                                        in string in_cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCaseRptList (java.lang.String in_user_id, 
                                              java.lang.String in_rpt_no, 
                                              java.lang.String in_from_tm, 
                                              java.lang.String in_to_tm, 
                                              java.lang.String in_cust_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCaseRptList", true);
          _output.write_wstring((java.lang.String)in_user_id);
          _output.write_string((java.lang.String)in_rpt_no);
          _output.write_string((java.lang.String)in_from_tm);
          _output.write_string((java.lang.String)in_to_tm);
          _output.write_string((java.lang.String)in_cust_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCaseRptList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getCaseRptList(in_user_id, in_rpt_no, in_from_tm, in_to_tm, 
                                      in_cust_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCaseRptInfo (in string in_rpt_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCaseRptInfo (java.lang.String in_rpt_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCaseRptInfo", true);
          _output.write_string((java.lang.String)in_rpt_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCaseRptInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getCaseRptInfo(in_rpt_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCaseClmList (in string in_rpt_no,
                                        in string in_status_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCaseClmList (java.lang.String in_rpt_no, 
                                              java.lang.String in_status_mrk) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCaseClmList", true);
          _output.write_string((java.lang.String)in_rpt_no);
          _output.write_string((java.lang.String)in_status_mrk);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCaseClmList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getCaseClmList(in_rpt_no, in_status_mrk);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClaimList (in string in_clnt_cde,
                                      in string in_rpt_no,
                                      in string in_clm_no,
                                      in string in_from_tm,
                                      in string in_to_tm,
                                      in string in_status_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClaimList (java.lang.String in_clnt_cde, 
                                            java.lang.String in_rpt_no, 
                                            java.lang.String in_clm_no, 
                                            java.lang.String in_from_tm, 
                                            java.lang.String in_to_tm, 
                                            java.lang.String in_status_mrk) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getClaimList", true);
          _output.write_string((java.lang.String)in_clnt_cde);
          _output.write_string((java.lang.String)in_rpt_no);
          _output.write_string((java.lang.String)in_clm_no);
          _output.write_string((java.lang.String)in_from_tm);
          _output.write_string((java.lang.String)in_to_tm);
          _output.write_string((java.lang.String)in_status_mrk);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getClaimList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getClaimList(in_clnt_cde, in_rpt_no, in_clm_no, in_from_tm, 
                                    in_to_tm, in_status_mrk);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClmDgstList (in string in_rpt_no,
                                        in string in_ply_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClmDgstList (java.lang.String in_rpt_no, 
                                              java.lang.String in_ply_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getClmDgstList", true);
          _output.write_string((java.lang.String)in_rpt_no);
          _output.write_string((java.lang.String)in_ply_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getClmDgstList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getClmDgstList(in_rpt_no, in_ply_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getQuotation (in com.mcip.nia.orb.QuotaCndtn quotacndtnobj,
                                      in wstring rdr_type)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getQuotation (com.mcip.nia.orb.QuotaCndtn quotacndtnobj, 
                                            java.lang.String rdr_type) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getQuotation", true);
          com.mcip.nia.orb.QuotaCndtnHelper.write(_output, quotacndtnobj);
          _output.write_wstring((java.lang.String)rdr_type);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getQuotation", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getQuotation(quotacndtnobj, rdr_type);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPlyAppNetAddress (in string cust_typ,
                                             in string in_clnt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPlyAppNetAddress (java.lang.String cust_typ, 
                                                   java.lang.String in_clnt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPlyAppNetAddress", true);
          _output.write_string((java.lang.String)cust_typ);
          _output.write_string((java.lang.String)in_clnt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPlyAppNetAddress", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPlyAppNetAddress(cust_typ, in_clnt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClauseList (in wstring in_insrnc_cde,
                                       in wstring in_clause_cde,
                                       in wstring in_clnt_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClauseList (java.lang.String in_insrnc_cde, 
                                             java.lang.String in_clause_cde, 
                                             java.lang.String in_clnt_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getClauseList", true);
          _output.write_wstring((java.lang.String)in_insrnc_cde);
          _output.write_wstring((java.lang.String)in_clause_cde);
          _output.write_wstring((java.lang.String)in_clnt_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getClauseList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getClauseList(in_insrnc_cde, in_clause_cde, in_clnt_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProposalList (in wstring user_id,
                                         in string plyapp_cde,
                                         in string app_from_tm,
                                         in string app_to_tm,
                                         in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProposalList (java.lang.String user_id, 
                                               java.lang.String plyapp_cde, 
                                               java.lang.String app_from_tm, 
                                               java.lang.String app_to_tm, 
                                               java.lang.String cust_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getProposalList", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)plyapp_cde);
          _output.write_string((java.lang.String)app_from_tm);
          _output.write_string((java.lang.String)app_to_tm);
          _output.write_string((java.lang.String)cust_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getProposalList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getProposalList(user_id, plyapp_cde, app_from_tm, app_to_tm, 
                                       cust_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEdrAppList (in wstring user_id,
                                       in string edrapp_cde, in string ply_no,
                                       in string app_from_tm,
                                       in string app_to_tm, in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEdrAppList (java.lang.String user_id, 
                                             java.lang.String edrapp_cde, 
                                             java.lang.String ply_no, 
                                             java.lang.String app_from_tm, 
                                             java.lang.String app_to_tm, 
                                             java.lang.String cust_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEdrAppList", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)edrapp_cde);
          _output.write_string((java.lang.String)ply_no);
          _output.write_string((java.lang.String)app_from_tm);
          _output.write_string((java.lang.String)app_to_tm);
          _output.write_string((java.lang.String)cust_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEdrAppList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getEdrAppList(user_id, edrapp_cde, ply_no, app_from_tm, 
                                     app_to_tm, cust_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEdrsmtList (in wstring user_id, in string edr_no,
                                       in string ply_no,
                                       in string app_from_tm,
                                       in string app_to_tm, in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEdrsmtList (java.lang.String user_id, 
                                             java.lang.String edr_no, 
                                             java.lang.String ply_no, 
                                             java.lang.String app_from_tm, 
                                             java.lang.String app_to_tm, 
                                             java.lang.String cust_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEdrsmtList", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)edr_no);
          _output.write_string((java.lang.String)ply_no);
          _output.write_string((java.lang.String)app_from_tm);
          _output.write_string((java.lang.String)app_to_tm);
          _output.write_string((java.lang.String)cust_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEdrsmtList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getEdrsmtList(user_id, edr_no, ply_no, app_from_tm, app_to_tm, 
                                     cust_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEdrsmtInfo (in string edr_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEdrsmtInfo (java.lang.String edr_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEdrsmtInfo", true);
          _output.write_string((java.lang.String)edr_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEdrsmtInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getEdrsmtInfo(edr_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPreEdrInfo (in string edr_app_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPreEdrInfo (java.lang.String edr_app_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPreEdrInfo", true);
          _output.write_string((java.lang.String)edr_app_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPreEdrInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.getPreEdrInfo(edr_app_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean checkEdrApp (in string ply_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean checkEdrApp (java.lang.String ply_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("checkEdrApp", true);
          _output.write_string((java.lang.String)ply_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("checkEdrApp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyInfoManagerOperations _self = (com.mcip.nia.orb.PolicyInfoManagerOperations)_so.servant;
        try {
          return _self.checkEdrApp(ply_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
