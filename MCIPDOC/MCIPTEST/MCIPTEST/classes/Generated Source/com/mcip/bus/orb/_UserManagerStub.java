package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/userManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::UserManager
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/UserManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface UserManager {
  ...
};
 * </pre>
 */
public class _UserManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.bus.orb.UserManager {
  final public static java.lang.Class _opsClass = com.mcip.bus.orb.UserManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/bus/orb/UserManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss operatorLogin (in wstring usrname, in wstring passwd)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] operatorLogin (java.lang.String usrname, 
                                             java.lang.String passwd) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("operatorLogin", true);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("operatorLogin", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.operatorLogin(usrname, passwd);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptOperator (in com.mcip.bus.orb.OperatorInfo operatorinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptOperator (com.mcip.bus.orb.OperatorInfo operatorinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptOperator", true);
          com.mcip.bus.orb.OperatorInfoHelper.write(_output, operatorinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptOperator", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.acceptOperator(operatorinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateOperator (in com.mcip.bus.orb.OperatorInfo operatorinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateOperator (com.mcip.bus.orb.OperatorInfo operatorinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateOperator", true);
          com.mcip.bus.orb.OperatorInfoHelper.write(_output, operatorinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateOperator", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.updateOperator(operatorinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteOperator (in string auth_dpt_cde, in wstring auth_opr_cde,
                          in wstring del_opr_cde, in string rcsv_del_flg)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteOperator (java.lang.String auth_dpt_cde, 
                                 java.lang.String auth_opr_cde, 
                                 java.lang.String del_opr_cde, 
                                 java.lang.String rcsv_del_flg) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteOperator", true);
          _output.write_string((java.lang.String)auth_dpt_cde);
          _output.write_wstring((java.lang.String)auth_opr_cde);
          _output.write_wstring((java.lang.String)del_opr_cde);
          _output.write_string((java.lang.String)rcsv_del_flg);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteOperator", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.deleteOperator(auth_dpt_cde, auth_opr_cde, del_opr_cde, 
                                      rcsv_del_flg);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryOptrInfo (in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryOptrInfo (java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryOptrInfo", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryOptrInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryOptrInfo(in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryOptrList (in wstring in_opr_cde,
                                       in string in_emp_cde,
                                       in wstring adm_opr_cde,
                                       in string adm_dpt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryOptrList (java.lang.String in_opr_cde, 
                                             java.lang.String in_emp_cde, 
                                             java.lang.String adm_opr_cde, 
                                             java.lang.String adm_dpt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryOptrList", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
          _output.write_string((java.lang.String)in_emp_cde);
          _output.write_wstring((java.lang.String)adm_opr_cde);
          _output.write_string((java.lang.String)adm_dpt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryOptrList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryOptrList(in_opr_cde, in_emp_cde, adm_opr_cde, adm_dpt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryAuthList (in wstring in_opr_cde,
                                       in string in_emp_cde,
                                       in wstring adm_opr_cde,
                                       in string adm_dpt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryAuthList (java.lang.String in_opr_cde, 
                                             java.lang.String in_emp_cde, 
                                             java.lang.String adm_opr_cde, 
                                             java.lang.String adm_dpt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryAuthList", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
          _output.write_string((java.lang.String)in_emp_cde);
          _output.write_wstring((java.lang.String)adm_opr_cde);
          _output.write_string((java.lang.String)adm_dpt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryAuthList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryAuthList(in_opr_cde, in_emp_cde, adm_opr_cde, adm_dpt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptOptrAuth (in com.mcip.orb.Stringss oprauthInfoobj,
                          in com.mcip.orb.Stringss oprdptinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptOptrAuth (java.lang.String[][] oprauthInfoobj, 
                                 java.lang.String[][] oprdptinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptOptrAuth", true);
          com.mcip.orb.StringssHelper.write(_output, oprauthInfoobj);
          com.mcip.orb.StringssHelper.write(_output, oprdptinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptOptrAuth", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.acceptOptrAuth(oprauthInfoobj, oprdptinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateOptrAuth (in com.mcip.orb.Stringss oprauthInfoobj,
                          in com.mcip.orb.Stringss oprdptinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateOptrAuth (java.lang.String[][] oprauthInfoobj, 
                                 java.lang.String[][] oprdptinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateOptrAuth", true);
          com.mcip.orb.StringssHelper.write(_output, oprauthInfoobj);
          com.mcip.orb.StringssHelper.write(_output, oprdptinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateOptrAuth", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.updateOptrAuth(oprauthInfoobj, oprdptinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteOptrAuth (in wstring in_opr_cde, in wstring in_func_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteOptrAuth (java.lang.String in_opr_cde, 
                                 java.lang.String in_func_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteOptrAuth", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
          _output.write_wstring((java.lang.String)in_func_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteOptrAuth", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.deleteOptrAuth(in_opr_cde, in_func_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryOptrDptList (in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryOptrDptList (java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryOptrDptList", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryOptrDptList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryOptrDptList(in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryAbleDptList (in wstring in_opr_cde,
                                          in wstring auth_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryAbleDptList (java.lang.String in_opr_cde, 
                                                java.lang.String auth_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryAbleDptList", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
          _output.write_wstring((java.lang.String)auth_opr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryAbleDptList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryAbleDptList(in_opr_cde, auth_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptSysFunc (in com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptSysFunc (com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptSysFunc", true);
          com.mcip.bus.orb.SysFuncInfoHelper.write(_output, sysfuncinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptSysFunc", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.acceptSysFunc(sysfuncinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateSysFunc (in com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateSysFunc (com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateSysFunc", true);
          com.mcip.bus.orb.SysFuncInfoHelper.write(_output, sysfuncinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateSysFunc", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.updateSysFunc(sysfuncinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteSysFunc (in wstring in_func_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteSysFunc (java.lang.String in_func_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteSysFunc", true);
          _output.write_wstring((java.lang.String)in_func_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteSysFunc", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.deleteSysFunc(in_func_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss querySysFuncList (in string in_func_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] querySysFuncList (java.lang.String in_func_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("querySysFuncList", true);
          _output.write_string((java.lang.String)in_func_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("querySysFuncList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.querySysFuncList(in_func_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptPagesInfo (in com.mcip.bus.orb.PagesInfo pagesinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPagesInfo (com.mcip.bus.orb.PagesInfo pagesinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptPagesInfo", true);
          com.mcip.bus.orb.PagesInfoHelper.write(_output, pagesinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPagesInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.acceptPagesInfo(pagesinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updatePagesInfo (in com.mcip.bus.orb.PagesInfo pagesinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updatePagesInfo (com.mcip.bus.orb.PagesInfo pagesinfoobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updatePagesInfo", true);
          com.mcip.bus.orb.PagesInfoHelper.write(_output, pagesinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updatePagesInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.updatePagesInfo(pagesinfoobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deletePagesInfo (in string in_page_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deletePagesInfo (java.lang.String in_page_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deletePagesInfo", true);
          _output.write_string((java.lang.String)in_page_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deletePagesInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.deletePagesInfo(in_page_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPagesList (in string in_func_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPagesList (java.lang.String in_func_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryPagesList", true);
          _output.write_string((java.lang.String)in_func_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryPagesList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryPagesList(in_func_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean executeOptrAuth (in string act_typ, in wstring auth_opr_cde,
                           in wstring in_opr_cde,
                           in com.mcip.orb.Stringss oprauthInfo,
                           in com.mcip.orb.Stringss oprdptinfo)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean executeOptrAuth (java.lang.String act_typ, 
                                  java.lang.String auth_opr_cde, 
                                  java.lang.String in_opr_cde, 
                                  java.lang.String[][] oprauthInfo, 
                                  java.lang.String[][] oprdptinfo) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("executeOptrAuth", true);
          _output.write_string((java.lang.String)act_typ);
          _output.write_wstring((java.lang.String)auth_opr_cde);
          _output.write_wstring((java.lang.String)in_opr_cde);
          com.mcip.orb.StringssHelper.write(_output, oprauthInfo);
          com.mcip.orb.StringssHelper.write(_output, oprdptinfo);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("executeOptrAuth", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.executeOptrAuth(act_typ, auth_opr_cde, in_opr_cde, oprauthInfo, 
                                       oprdptinfo);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean checkOptrAuth (in wstring in_optr_cde, in string in_func_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean checkOptrAuth (java.lang.String in_optr_cde, 
                                java.lang.String in_func_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("checkOptrAuth", true);
          _output.write_wstring((java.lang.String)in_optr_cde);
          _output.write_string((java.lang.String)in_func_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("checkOptrAuth", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.checkOptrAuth(in_optr_cde, in_func_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustEnttList (in wstring in_opr_cde,
                                           in string in_verify_flg,
                                           in com.mcip.orb.Strings in_dpt_cde,
                                           in string frm_crt_tm,
                                           in string to_crt_tm,
                                           in string frm_verify_tm,
                                           in string to_verify_tm,
                                           in long frm_ltimes,
                                           in long to_ltimes,
                                           in wstring in_user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustEnttList (java.lang.String in_opr_cde, 
                                                 java.lang.String in_verify_flg, 
                                                 java.lang.String[] in_dpt_cde, 
                                                 java.lang.String frm_crt_tm, 
                                                 java.lang.String to_crt_tm, 
                                                 java.lang.String frm_verify_tm, 
                                                 java.lang.String to_verify_tm, 
                                                 int frm_ltimes, 
                                                 int to_ltimes, 
                                                 java.lang.String in_user_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryCustEnttList", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
          _output.write_string((java.lang.String)in_verify_flg);
          com.mcip.orb.StringsHelper.write(_output, in_dpt_cde);
          _output.write_string((java.lang.String)frm_crt_tm);
          _output.write_string((java.lang.String)to_crt_tm);
          _output.write_string((java.lang.String)frm_verify_tm);
          _output.write_string((java.lang.String)to_verify_tm);
          _output.write_long((int)frm_ltimes);
          _output.write_long((int)to_ltimes);
          _output.write_wstring((java.lang.String)in_user_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryCustEnttList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryCustEnttList(in_opr_cde, in_verify_flg, in_dpt_cde, 
                                         frm_crt_tm, to_crt_tm, frm_verify_tm, 
                                         to_verify_tm, frm_ltimes, to_ltimes, in_user_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss querySameCustList (in wstring in_clnt_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] querySameCustList (java.lang.String in_clnt_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("querySameCustList", true);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("querySameCustList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.querySameCustList(in_clnt_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptUserVerify (in wstring in_user_id, in string in_clnt_cde,
                            in string in_cmpny_agt_cde,
                            in string in_verify_flg, in wstring in_vrfy_desc,
                            in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptUserVerify (java.lang.String in_user_id, 
                                   java.lang.String in_clnt_cde, 
                                   java.lang.String in_cmpny_agt_cde, 
                                   java.lang.String in_verify_flg, 
                                   java.lang.String in_vrfy_desc, 
                                   java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptUserVerify", true);
          _output.write_wstring((java.lang.String)in_user_id);
          _output.write_string((java.lang.String)in_clnt_cde);
          _output.write_string((java.lang.String)in_cmpny_agt_cde);
          _output.write_string((java.lang.String)in_verify_flg);
          _output.write_wstring((java.lang.String)in_vrfy_desc);
          _output.write_wstring((java.lang.String)in_opr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptUserVerify", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.acceptUserVerify(in_user_id, in_clnt_cde, in_cmpny_agt_cde, 
                                        in_verify_flg, in_vrfy_desc, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean replaceAuthOptr (in wstring org_optr_cde, in wstring trgt_optr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean replaceAuthOptr (java.lang.String org_optr_cde, 
                                  java.lang.String trgt_optr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("replaceAuthOptr", true);
          _output.write_wstring((java.lang.String)org_optr_cde);
          _output.write_wstring((java.lang.String)trgt_optr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("replaceAuthOptr", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.replaceAuthOptr(org_optr_cde, trgt_optr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean compareAuthDptOptr (in wstring org_optr_cde,
                              in wstring trgt_optr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean compareAuthDptOptr (java.lang.String org_optr_cde, 
                                     java.lang.String trgt_optr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("compareAuthDptOptr", true);
          _output.write_wstring((java.lang.String)org_optr_cde);
          _output.write_wstring((java.lang.String)trgt_optr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("compareAuthDptOptr", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.compareAuthDptOptr(org_optr_cde, trgt_optr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryOptrAuthList (in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryOptrAuthList (java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryOptrAuthList", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryOptrAuthList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryOptrAuthList(in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss querySubDptList (in wstring in_dpt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] querySubDptList (java.lang.String in_dpt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("querySubDptList", true);
          _output.write_wstring((java.lang.String)in_dpt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("querySubDptList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.querySubDptList(in_dpt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptClntMapInfo (in wstring opr_cde, in string clnt_agt_flg,
                             in wstring user_id, in string clnt_cde,
                             in wstring main_flg)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptClntMapInfo (java.lang.String opr_cde, 
                                    java.lang.String clnt_agt_flg, 
                                    java.lang.String user_id, 
                                    java.lang.String clnt_cde, 
                                    java.lang.String main_flg) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptClntMapInfo", true);
          _output.write_wstring((java.lang.String)opr_cde);
          _output.write_string((java.lang.String)clnt_agt_flg);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)clnt_cde);
          _output.write_wstring((java.lang.String)main_flg);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptClntMapInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.acceptClntMapInfo(opr_cde, clnt_agt_flg, user_id, clnt_cde, 
                                         main_flg);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateClntMapInfo (in wstring opr_cde, in string clnt_agt_flg,
                             in wstring new_user_id, in string new_clnt_cde,
                             in wstring main_flg, in wstring old_user_id,
                             in string old_clnt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateClntMapInfo (java.lang.String opr_cde, 
                                    java.lang.String clnt_agt_flg, 
                                    java.lang.String new_user_id, 
                                    java.lang.String new_clnt_cde, 
                                    java.lang.String main_flg, 
                                    java.lang.String old_user_id, 
                                    java.lang.String old_clnt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateClntMapInfo", true);
          _output.write_wstring((java.lang.String)opr_cde);
          _output.write_string((java.lang.String)clnt_agt_flg);
          _output.write_wstring((java.lang.String)new_user_id);
          _output.write_string((java.lang.String)new_clnt_cde);
          _output.write_wstring((java.lang.String)main_flg);
          _output.write_wstring((java.lang.String)old_user_id);
          _output.write_string((java.lang.String)old_clnt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateClntMapInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.updateClntMapInfo(opr_cde, clnt_agt_flg, new_user_id, new_clnt_cde, 
                                         main_flg, old_user_id, old_clnt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteClntMapInfo (in wstring opr_cde, in wstring user_id,
                             in string clnt_cde, in string clnt_agt_flg)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteClntMapInfo (java.lang.String opr_cde, 
                                    java.lang.String user_id, 
                                    java.lang.String clnt_cde, 
                                    java.lang.String clnt_agt_flg) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteClntMapInfo", true);
          _output.write_wstring((java.lang.String)opr_cde);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)clnt_cde);
          _output.write_string((java.lang.String)clnt_agt_flg);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteClntMapInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.deleteClntMapInfo(opr_cde, user_id, clnt_cde, clnt_agt_flg);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryClntMapList (in wstring opr_cde,
                                          in wstring user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryClntMapList (java.lang.String opr_cde, 
                                                java.lang.String user_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryClntMapList", true);
          _output.write_wstring((java.lang.String)opr_cde);
          _output.write_wstring((java.lang.String)user_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryClntMapList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.queryClntMapList(opr_cde, user_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean executeSysadmAuth (in string act_typ, in wstring auth_opr_cde,
                             in wstring in_opr_cde, in wstring in_dpt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean executeSysadmAuth (java.lang.String act_typ, 
                                    java.lang.String auth_opr_cde, 
                                    java.lang.String in_opr_cde, 
                                    java.lang.String in_dpt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("executeSysadmAuth", true);
          _output.write_string((java.lang.String)act_typ);
          _output.write_wstring((java.lang.String)auth_opr_cde);
          _output.write_wstring((java.lang.String)in_opr_cde);
          _output.write_wstring((java.lang.String)in_dpt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("executeSysadmAuth", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.executeSysadmAuth(act_typ, auth_opr_cde, in_opr_cde, in_dpt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDptCEnm (in wstring dpt_cde, in wstring cenm_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDptCEnm (java.lang.String dpt_cde, 
                                          java.lang.String cenm_typ) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getDptCEnm", true);
          _output.write_wstring((java.lang.String)dpt_cde);
          _output.write_wstring((java.lang.String)cenm_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getDptCEnm", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.getDptCEnm(dpt_cde, cenm_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptSuppEmail (in wstring emp_cde, in wstring emp_nme,
                           in wstring dpt_cde, in wstring emp_type,
                           in wstring emp_email)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptSuppEmail (java.lang.String emp_cde, 
                                  java.lang.String emp_nme, 
                                  java.lang.String dpt_cde, 
                                  java.lang.String emp_type, 
                                  java.lang.String emp_email) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptSuppEmail", true);
          _output.write_wstring((java.lang.String)emp_cde);
          _output.write_wstring((java.lang.String)emp_nme);
          _output.write_wstring((java.lang.String)dpt_cde);
          _output.write_wstring((java.lang.String)emp_type);
          _output.write_wstring((java.lang.String)emp_email);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptSuppEmail", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.acceptSuppEmail(emp_cde, emp_nme, dpt_cde, emp_type, emp_email);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateSuppEmail (in wstring emp_cde, in wstring emp_nme,
                           in wstring dpt_cde, in wstring emp_type,
                           in wstring emp_email, in wstring supp_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateSuppEmail (java.lang.String emp_cde, 
                                  java.lang.String emp_nme, 
                                  java.lang.String dpt_cde, 
                                  java.lang.String emp_type, 
                                  java.lang.String emp_email, 
                                  java.lang.String supp_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateSuppEmail", true);
          _output.write_wstring((java.lang.String)emp_cde);
          _output.write_wstring((java.lang.String)emp_nme);
          _output.write_wstring((java.lang.String)dpt_cde);
          _output.write_wstring((java.lang.String)emp_type);
          _output.write_wstring((java.lang.String)emp_email);
          _output.write_wstring((java.lang.String)supp_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateSuppEmail", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.updateSuppEmail(emp_cde, emp_nme, dpt_cde, emp_type, emp_email, 
                                       supp_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteSuppEmail (in wstring supp_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteSuppEmail (java.lang.String supp_no) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteSuppEmail", true);
          _output.write_wstring((java.lang.String)supp_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteSuppEmail", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.deleteSuppEmail(supp_no);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss querySuppEmailList (in wstring emp_nme,
                                            in com.mcip.orb.Strings dpt_cde,
                                            in wstring emp_type)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] querySuppEmailList (java.lang.String emp_nme, 
                                                  java.lang.String[] dpt_cde, 
                                                  java.lang.String emp_type) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("querySuppEmailList", true);
          _output.write_wstring((java.lang.String)emp_nme);
          com.mcip.orb.StringsHelper.write(_output, dpt_cde);
          _output.write_wstring((java.lang.String)emp_type);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("querySuppEmailList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.UserManagerOperations _self = (com.mcip.bus.orb.UserManagerOperations)_so.servant;
        try {
          return _self.querySuppEmailList(emp_nme, dpt_cde, emp_type);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
