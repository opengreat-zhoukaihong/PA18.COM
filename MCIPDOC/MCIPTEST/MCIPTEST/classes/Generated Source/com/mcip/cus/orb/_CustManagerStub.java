package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustManager
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface CustManager {
  ...
};
 * </pre>
 */
public class _CustManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.cus.orb.CustManager {
  final public static java.lang.Class _opsClass = com.mcip.cus.orb.CustManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/cus/orb/CustManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss customerLogin (in wstring usrname, in wstring passwd)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] customerLogin (java.lang.String usrname, 
                                             java.lang.String passwd) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("customerLogin", true);
          _output.write_wstring((java.lang.String)usrname);
          _output.write_wstring((java.lang.String)passwd);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("customerLogin", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.customerLogin(usrname, passwd);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptOrgaCust (in string in_register_mrk,
                          in com.mcip.cus.orb.CustOrgn custorgnobj,
                          in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptOrgaCust (java.lang.String in_register_mrk, 
                                 com.mcip.cus.orb.CustOrgn custorgnobj, 
                                 com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptOrgaCust", true);
          _output.write_string((java.lang.String)in_register_mrk);
          com.mcip.cus.orb.CustOrgnHelper.write(_output, custorgnobj);
          com.mcip.cus.orb.CustEntityHelper.write(_output, custentityobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptOrgaCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.acceptOrgaCust(in_register_mrk, custorgnobj, custentityobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptPrsnCust (in string in_register_mrk,
                          in com.mcip.cus.orb.CustPrsn custprsnobj,
                          in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPrsnCust (java.lang.String in_register_mrk, 
                                 com.mcip.cus.orb.CustPrsn custprsnobj, 
                                 com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptPrsnCust", true);
          _output.write_string((java.lang.String)in_register_mrk);
          com.mcip.cus.orb.CustPrsnHelper.write(_output, custprsnobj);
          com.mcip.cus.orb.CustEntityHelper.write(_output, custentityobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPrsnCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.acceptPrsnCust(in_register_mrk, custprsnobj, custentityobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteIllegalUser (in string user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteIllegalUser (java.lang.String user_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteIllegalUser", true);
          _output.write_string((java.lang.String)user_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteIllegalUser", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.deleteIllegalUser(user_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptAgntCust (in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptAgntCust (com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptAgntCust", true);
          com.mcip.cus.orb.CustEntityHelper.write(_output, custentityobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptAgntCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.acceptAgntCust(custentityobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateOrgaCust (in com.mcip.cus.orb.CustOrgn custorgnobj,
                          in wstring cust_user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateOrgaCust (com.mcip.cus.orb.CustOrgn custorgnobj, 
                                 java.lang.String cust_user_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateOrgaCust", true);
          com.mcip.cus.orb.CustOrgnHelper.write(_output, custorgnobj);
          _output.write_wstring((java.lang.String)cust_user_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateOrgaCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.updateOrgaCust(custorgnobj, cust_user_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updatePrsnCust (in com.mcip.cus.orb.CustPrsn custprsnobj,
                          in wstring cust_user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updatePrsnCust (com.mcip.cus.orb.CustPrsn custprsnobj, 
                                 java.lang.String cust_user_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updatePrsnCust", true);
          com.mcip.cus.orb.CustPrsnHelper.write(_output, custprsnobj);
          _output.write_wstring((java.lang.String)cust_user_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updatePrsnCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.updatePrsnCust(custprsnobj, cust_user_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateEnttCust (in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateEnttCust (com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateEnttCust", true);
          com.mcip.cus.orb.CustEntityHelper.write(_output, custentityobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateEnttCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.updateEnttCust(custentityobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustEntt (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustEntt (java.lang.String in_account_info) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryCustEntt", true);
          _output.write_wstring((java.lang.String)in_account_info);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryCustEntt", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.queryCustEntt(in_account_info);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustOrgn (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustOrgn (java.lang.String in_account_info) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryCustOrgn", true);
          _output.write_wstring((java.lang.String)in_account_info);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryCustOrgn", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.queryCustOrgn(in_account_info);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustPrsn (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustPrsn (java.lang.String in_account_info) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryCustPrsn", true);
          _output.write_wstring((java.lang.String)in_account_info);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryCustPrsn", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.queryCustPrsn(in_account_info);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustAgnt (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustAgnt (java.lang.String in_account_info) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryCustAgnt", true);
          _output.write_wstring((java.lang.String)in_account_info);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryCustAgnt", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.queryCustAgnt(in_account_info);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss requireCust (in string in_user_mrk,
                                     in wstring in_user_id,
                                     in wstring in_register_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] requireCust (java.lang.String in_user_mrk, 
                                           java.lang.String in_user_id, 
                                           java.lang.String in_register_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("requireCust", true);
          _output.write_string((java.lang.String)in_user_mrk);
          _output.write_wstring((java.lang.String)in_user_id);
          _output.write_wstring((java.lang.String)in_register_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("requireCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.requireCust(in_user_mrk, in_user_id, in_register_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean checkProposal (in wstring user_id, in string cust_type)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean checkProposal (java.lang.String user_id, 
                                java.lang.String cust_type) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("checkProposal", true);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)cust_type);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("checkProposal", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.checkProposal(user_id, cust_type);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryAgencyInfo (in wstring in_agent_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryAgencyInfo (java.lang.String in_agent_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryAgencyInfo", true);
          _output.write_wstring((java.lang.String)in_agent_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryAgencyInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.queryAgencyInfo(in_agent_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryOCcustInfo (in wstring in_clnt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryOCcustInfo (java.lang.String in_clnt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryOCcustInfo", true);
          _output.write_wstring((java.lang.String)in_clnt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryOCcustInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.queryOCcustInfo(in_clnt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptOCCust (in string in_register_mrk,
                        in com.mcip.cus.orb.CustOrgn custorgnobj,
                        in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptOCCust (java.lang.String in_register_mrk, 
                               com.mcip.cus.orb.CustOrgn custorgnobj, 
                               com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptOCCust", true);
          _output.write_string((java.lang.String)in_register_mrk);
          com.mcip.cus.orb.CustOrgnHelper.write(_output, custorgnobj);
          com.mcip.cus.orb.CustEntityHelper.write(_output, custentityobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptOCCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.acceptOCCust(in_register_mrk, custorgnobj, custentityobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptAGCust (in string in_register_mrk,
                        in com.mcip.cus.orb.CustOrgn custorgnobj,
                        in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptAGCust (java.lang.String in_register_mrk, 
                               com.mcip.cus.orb.CustOrgn custorgnobj, 
                               com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptAGCust", true);
          _output.write_string((java.lang.String)in_register_mrk);
          com.mcip.cus.orb.CustOrgnHelper.write(_output, custorgnobj);
          com.mcip.cus.orb.CustEntityHelper.write(_output, custentityobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptAGCust", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cus.orb.CustManagerOperations _self = (com.mcip.cus.orb.CustManagerOperations)_so.servant;
        try {
          return _self.acceptAGCust(in_register_mrk, custorgnobj, custentityobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
