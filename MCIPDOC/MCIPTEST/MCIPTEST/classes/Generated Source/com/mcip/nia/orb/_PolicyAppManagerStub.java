package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyAppManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyAppManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyAppManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyAppManager {
  ...
};
 * </pre>
 */
public class _PolicyAppManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.nia.orb.PolicyAppManager {
  final public static java.lang.Class _opsClass = com.mcip.nia.orb.PolicyAppManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyAppManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss acceptPolicyApp (in com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj,
                                         in com.mcip.orb.Stringss rdrinfo)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] acceptPolicyApp (com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj, 
                                               java.lang.String[][] rdrinfo) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("acceptPolicyApp", true);
          com.mcip.nia.orb.PlcyAppInfoHelper.write(_output, plcyappinfoobj);
          com.mcip.orb.StringssHelper.write(_output, rdrinfo);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPolicyApp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyAppManagerOperations _self = (com.mcip.nia.orb.PolicyAppManagerOperations)_so.servant;
        try {
          return _self.acceptPolicyApp(plcyappinfoobj, rdrinfo);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean withdrawalPolicyApp (in string plcyapp_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean withdrawalPolicyApp (java.lang.String plcyapp_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("withdrawalPolicyApp", true);
          _output.write_string((java.lang.String)plcyapp_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("withdrawalPolicyApp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyAppManagerOperations _self = (com.mcip.nia.orb.PolicyAppManagerOperations)_so.servant;
        try {
          return _self.withdrawalPolicyApp(plcyapp_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss updatePolicyApp (in com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj,
                                         in com.mcip.orb.Stringss rdrinfo)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] updatePolicyApp (com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj, 
                                               java.lang.String[][] rdrinfo) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("updatePolicyApp", true);
          com.mcip.nia.orb.PlcyAppInfoHelper.write(_output, plcyappinfoobj);
          com.mcip.orb.StringssHelper.write(_output, rdrinfo);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updatePolicyApp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyAppManagerOperations _self = (com.mcip.nia.orb.PolicyAppManagerOperations)_so.servant;
        try {
          return _self.updatePolicyApp(plcyappinfoobj, rdrinfo);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss confirmPolicyAppProposal (in string plcyapp_no,
                                                  in string dpt_cde,
                                                  in string insrnc_cde,
                                                  in string undr_prsn)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] confirmPolicyAppProposal (java.lang.String plcyapp_no, 
                                                        java.lang.String dpt_cde, 
                                                        java.lang.String insrnc_cde, 
                                                        java.lang.String undr_prsn) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("confirmPolicyAppProposal", true);
          _output.write_string((java.lang.String)plcyapp_no);
          _output.write_string((java.lang.String)dpt_cde);
          _output.write_string((java.lang.String)insrnc_cde);
          _output.write_string((java.lang.String)undr_prsn);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("confirmPolicyAppProposal", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyAppManagerOperations _self = (com.mcip.nia.orb.PolicyAppManagerOperations)_so.servant;
        try {
          return _self.confirmPolicyAppProposal(plcyapp_no, dpt_cde, insrnc_cde, 
                                                undr_prsn);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptUserRemark (in string plcyapp_no, in string app_cde,
                            in wstring user_remark, in string app_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptUserRemark (java.lang.String plcyapp_no, 
                                   java.lang.String app_cde, 
                                   java.lang.String user_remark, 
                                   java.lang.String app_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptUserRemark", true);
          _output.write_string((java.lang.String)plcyapp_no);
          _output.write_string((java.lang.String)app_cde);
          _output.write_wstring((java.lang.String)user_remark);
          _output.write_string((java.lang.String)app_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptUserRemark", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyAppManagerOperations _self = (com.mcip.nia.orb.PolicyAppManagerOperations)_so.servant;
        try {
          return _self.acceptUserRemark(plcyapp_no, app_cde, user_remark, app_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deletePolicyApp (in string plcyapp_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deletePolicyApp (java.lang.String plcyapp_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deletePolicyApp", true);
          _output.write_string((java.lang.String)plcyapp_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deletePolicyApp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyAppManagerOperations _self = (com.mcip.nia.orb.PolicyAppManagerOperations)_so.servant;
        try {
          return _self.deletePolicyApp(plcyapp_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updatePayFlag (in string plcy_no, in string pay_flag,
                         in string app_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updatePayFlag (java.lang.String plcy_no, 
                                java.lang.String pay_flag, 
                                java.lang.String app_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updatePayFlag", true);
          _output.write_string((java.lang.String)plcy_no);
          _output.write_string((java.lang.String)pay_flag);
          _output.write_string((java.lang.String)app_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updatePayFlag", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyAppManagerOperations _self = (com.mcip.nia.orb.PolicyAppManagerOperations)_so.servant;
        try {
          return _self.updatePayFlag(plcy_no, pay_flag, app_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
