package com.mcip.cdt.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/getStaticInfo.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cdt::orb::staticInfoManager
 * <li> <b>Repository Id</b> IDL:com/mcip/cdt/orb/staticInfoManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface staticInfoManager {
  ...
};
 * </pre>
 */
public class _staticInfoManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.cdt.orb.staticInfoManager {
  final public static java.lang.Class _opsClass = com.mcip.cdt.orb.staticInfoManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/cdt/orb/staticInfoManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss getNationalList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getNationalList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getNationalList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getNationalList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getNationalList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAreaList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAreaList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getAreaList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAreaList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getAreaList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProvinceList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProvinceList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getProvinceList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getProvinceList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getProvinceList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCityList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCityList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCityList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCityList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getCityList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEduList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEduList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEduList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEduList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getEduList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getTitleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getTitleList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getTitleList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getTitleList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getTitleList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDutyList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDutyList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getDutyList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getDutyList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getDutyList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getTradeTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getTradeTypeList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getTradeTypeList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getTradeTypeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getTradeTypeList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOrgTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOrgTypeList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getOrgTypeList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getOrgTypeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getOrgTypeList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOwnershipList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOwnershipList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getOwnershipList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getOwnershipList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getOwnershipList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getScaleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getScaleList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getScaleList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getScaleList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getScaleList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPremiumScaleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPremiumScaleList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPremiumScaleList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPremiumScaleList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getPremiumScaleList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCurrencyList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCurrencyList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCurrencyList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCurrencyList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getCurrencyList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCargoClsList (in string cde, in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCargoClsList (java.lang.String cde, 
                                               java.lang.String insrnc_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCargoClsList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCargoClsList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getCargoClsList(cde, insrnc_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCargoTypeList (in string Cargocls)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCargoTypeList (java.lang.String Cargocls) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCargoTypeList", true);
          _output.write_string((java.lang.String)Cargocls);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCargoTypeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getCargoTypeList(Cargocls);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPackList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPackList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPackList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPackList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getPackList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getExchangeRateList (in string cur1, in string cur2)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getExchangeRateList (java.lang.String cur1, 
                                                   java.lang.String cur2) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getExchangeRateList", true);
          _output.write_string((java.lang.String)cur1);
          _output.write_string((java.lang.String)cur2);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getExchangeRateList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getExchangeRateList(cur1, cur2);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPayModeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPayModeList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPayModeList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPayModeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getPayModeList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceClassList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceClassList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getInsuranceClassList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getInsuranceClassList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getInsuranceClassList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceDefineList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceDefineList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getInsuranceDefineList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getInsuranceDefineList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getInsuranceDefineList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceTypeList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getInsuranceTypeList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getInsuranceTypeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getInsuranceTypeList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClauseList (in string insrnc_cde,
                                       in string claus_cde, in string add_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClauseList (java.lang.String insrnc_cde, 
                                             java.lang.String claus_cde, 
                                             java.lang.String add_mrk) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getClauseList", true);
          _output.write_string((java.lang.String)insrnc_cde);
          _output.write_string((java.lang.String)claus_cde);
          _output.write_string((java.lang.String)add_mrk);
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
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getClauseList(insrnc_cde, claus_cde, add_mrk);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEndorseReasonList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEndorseReasonList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEndorseReasonList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEndorseReasonList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getEndorseReasonList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDepartmentList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDepartmentList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getDepartmentList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getDepartmentList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getDepartmentList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgentCharacterList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgentCharacterList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getAgentCharacterList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAgentCharacterList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getAgentCharacterList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getSurveyAgentList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getSurveyAgentList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getSurveyAgentList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getSurveyAgentList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getSurveyAgentList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCarriageList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCarriageList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCarriageList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCarriageList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getCarriageList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getVslLevelList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getVslLevelList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getVslLevelList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getVslLevelList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getVslLevelList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCertificateList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCertificateList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCertificateList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCertificateList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getCertificateList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getMajorList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getMajorList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getMajorList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getMajorList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getMajorList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getMarriageList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getMarriageList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getMarriageList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getMarriageList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getMarriageList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getSexList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getSexList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getSexList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getSexList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getSexList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEmployeeCodeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEmployeeCodeList (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEmployeeCodeList", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEmployeeCodeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getEmployeeCodeList(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPACrgoClsTypList (in wstring in_crgo_cde,
                                             in wstring in_site_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPACrgoClsTypList (java.lang.String in_crgo_cde, 
                                                   java.lang.String in_site_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPACrgoClsTypList", true);
          _output.write_wstring((java.lang.String)in_crgo_cde);
          _output.write_wstring((java.lang.String)in_site_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPACrgoClsTypList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getPACrgoClsTypList(in_crgo_cde, in_site_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getNetCodeList (in wstring in_net_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getNetCodeList (java.lang.String in_net_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getNetCodeList", true);
          _output.write_wstring((java.lang.String)in_net_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getNetCodeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getNetCodeList(in_net_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCurrencyInfo (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCurrencyInfo (java.lang.String cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCurrencyInfo", true);
          _output.write_string((java.lang.String)cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCurrencyInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getCurrencyInfo(cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getRptTelNum (in string in_dpt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getRptTelNum (java.lang.String in_dpt_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getRptTelNum", true);
          _output.write_string((java.lang.String)in_dpt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getRptTelNum", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.cdt.orb.staticInfoManagerOperations _self = (com.mcip.cdt.orb.staticInfoManagerOperations)_so.servant;
        try {
          return _self.getRptTelNum(in_dpt_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
