package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyManager {
  ...
};
 * </pre>
 */
public class _PolicyManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.nia.orb.PolicyManager {
  final public static java.lang.Class _opsClass = com.mcip.nia.orb.PolicyManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss acceptCaseRpt (in com.mcip.nia.orb.CaseRptInfo caserptinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] acceptCaseRpt (com.mcip.nia.orb.CaseRptInfo caserptinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("acceptCaseRpt", true);
          com.mcip.nia.orb.CaseRptInfoHelper.write(_output, caserptinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptCaseRpt", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyManagerOperations _self = (com.mcip.nia.orb.PolicyManagerOperations)_so.servant;
        try {
          return _self.acceptCaseRpt(caserptinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss acceptPolicyEdr (in com.mcip.nia.orb.PlyEdrAppInfo plyedrappinfoobj,
                                         in com.mcip.nia.orb.PlyEdrAppCrgoInfo plyedrappcrgoinfoobj,
                                         in com.mcip.orb.Stringss rdrinfo,
                                         in com.mcip.nia.orb.PlyEdrAppPayInfo plyedrapppayinfoobj,
                                         in com.mcip.nia.orb.PlyPlyAppNetInfo plyplyappnetinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] acceptPolicyEdr (com.mcip.nia.orb.PlyEdrAppInfo plyedrappinfoobj, 
                                               com.mcip.nia.orb.PlyEdrAppCrgoInfo plyedrappcrgoinfoobj, 
                                               java.lang.String[][] rdrinfo, 
                                               com.mcip.nia.orb.PlyEdrAppPayInfo plyedrapppayinfoobj, 
                                               com.mcip.nia.orb.PlyPlyAppNetInfo plyplyappnetinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("acceptPolicyEdr", true);
          com.mcip.nia.orb.PlyEdrAppInfoHelper.write(_output, plyedrappinfoobj);
          com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper.write(_output, plyedrappcrgoinfoobj);
          com.mcip.orb.StringssHelper.write(_output, rdrinfo);
          com.mcip.nia.orb.PlyEdrAppPayInfoHelper.write(_output, plyedrapppayinfoobj);
          com.mcip.nia.orb.PlyPlyAppNetInfoHelper.write(_output, plyplyappnetinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPolicyEdr", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyManagerOperations _self = (com.mcip.nia.orb.PolicyManagerOperations)_so.servant;
        try {
          return _self.acceptPolicyEdr(plyedrappinfoobj, plyedrappcrgoinfoobj, 
                                       rdrinfo, plyedrapppayinfoobj, plyplyappnetinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   void getPolicyEdr (in com.mcip.nia.orb.PlyGetDocInfo plygetdocinfoobj,
                     out any plyedrapp, out any plyedrappcrgo,
                     out any plyedrapprdr, out any plyedrapppay,
                     out any plyplyappnet)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public void getPolicyEdr (com.mcip.nia.orb.PlyGetDocInfo plygetdocinfoobj, 
                            org.omg.CORBA.AnyHolder plyedrapp, 
                            org.omg.CORBA.AnyHolder plyedrappcrgo, 
                            org.omg.CORBA.AnyHolder plyedrapprdr, 
                            org.omg.CORBA.AnyHolder plyedrapppay, 
                            org.omg.CORBA.AnyHolder plyplyappnet) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("getPolicyEdr", true);
          com.mcip.nia.orb.PlyGetDocInfoHelper.write(_output, plygetdocinfoobj);
          _input = this._invoke(_output);
          plyedrapp.value = _input.read_any();
          plyedrappcrgo.value = _input.read_any();
          plyedrapprdr.value = _input.read_any();
          plyedrapppay.value = _input.read_any();
          plyplyappnet.value = _input.read_any();
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPolicyEdr", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyManagerOperations _self = (com.mcip.nia.orb.PolicyManagerOperations)_so.servant;
        try {
          _self.getPolicyEdr(plygetdocinfoobj, plyedrapp, plyedrappcrgo, plyedrapprdr, 
                             plyedrapppay, plyplyappnet);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
      break;
    }
  }

  /**
   * <pre>
   *   boolean withdrawalEdrApp (in string edr_app_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean withdrawalEdrApp (java.lang.String edr_app_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("withdrawalEdrApp", true);
          _output.write_string((java.lang.String)edr_app_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("withdrawalEdrApp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyManagerOperations _self = (com.mcip.nia.orb.PolicyManagerOperations)_so.servant;
        try {
          return _self.withdrawalEdrApp(edr_app_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   void getEdrAppInfo (in com.mcip.nia.orb.PlyEdrGridInfo plyedrgridinfoobj,
                      out any plyedrapp, out any plyedrappcrgo,
                      out any plyedrapprdr, out any plyedrapppay,
                      out any plyplyappnet)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public void getEdrAppInfo (com.mcip.nia.orb.PlyEdrGridInfo plyedrgridinfoobj, 
                             org.omg.CORBA.AnyHolder plyedrapp, 
                             org.omg.CORBA.AnyHolder plyedrappcrgo, 
                             org.omg.CORBA.AnyHolder plyedrapprdr, 
                             org.omg.CORBA.AnyHolder plyedrapppay, 
                             org.omg.CORBA.AnyHolder plyplyappnet) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        try {
          _output = this._request("getEdrAppInfo", true);
          com.mcip.nia.orb.PlyEdrGridInfoHelper.write(_output, plyedrgridinfoobj);
          _input = this._invoke(_output);
          plyedrapp.value = _input.read_any();
          plyedrappcrgo.value = _input.read_any();
          plyedrapprdr.value = _input.read_any();
          plyedrapppay.value = _input.read_any();
          plyplyappnet.value = _input.read_any();
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEdrAppInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyManagerOperations _self = (com.mcip.nia.orb.PolicyManagerOperations)_so.servant;
        try {
          _self.getEdrAppInfo(plyedrgridinfoobj, plyedrapp, plyedrappcrgo, plyedrapprdr, 
                              plyedrapppay, plyplyappnet);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
      break;
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss confirmEdrAppProposal (in string edrapp_no,
                                               in string dpt_cde,
                                               in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] confirmEdrAppProposal (java.lang.String edrapp_no, 
                                                     java.lang.String dpt_cde, 
                                                     java.lang.String insrnc_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("confirmEdrAppProposal", true);
          _output.write_string((java.lang.String)edrapp_no);
          _output.write_string((java.lang.String)dpt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("confirmEdrAppProposal", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyManagerOperations _self = (com.mcip.nia.orb.PolicyManagerOperations)_so.servant;
        try {
          return _self.confirmEdrAppProposal(edrapp_no, dpt_cde, insrnc_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteEdrApp (in string edr_app_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteEdrApp (java.lang.String edr_app_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteEdrApp", true);
          _output.write_string((java.lang.String)edr_app_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteEdrApp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.nia.orb.PolicyManagerOperations _self = (com.mcip.nia.orb.PolicyManagerOperations)_so.servant;
        try {
          return _self.deleteEdrApp(edr_app_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
