package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::BusinessManager
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/BusinessManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface BusinessManager {
  ...
};
 * </pre>
 */
public class _BusinessManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.bus.orb.BusinessManager {
  final public static java.lang.Class _opsClass = com.mcip.bus.orb.BusinessManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/bus/orb/BusinessManager:1.0"
  };

  /**
   * <pre>
   *   boolean isAlive ();
   * </pre>
   */
  public boolean isAlive () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("isAlive", true);
          _input = this._invoke(_output);
          _result = _input.read_boolean();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
          java.lang.String _exception_id = _exception.getId();
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.portable.RemarshalException _exception) {
          continue;
        }
        finally {
          this._releaseReply(_input);
        }
      } else {
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("isAlive", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.isAlive();
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPlyNetList (in wstring in_opr_cde,
                                         in string in_prnt_flg,
                                         in string in_ply_no,
                                         in string frm_plyapp_tm,
                                         in string to_plyapp_tm,
                                         in wstring frm_insrnc_cde,
                                         in wstring to_insrnc_cde,
                                         in com.mcip.orb.Strings dpt_array)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPlyNetList (java.lang.String in_opr_cde, 
                                               java.lang.String in_prnt_flg, 
                                               java.lang.String in_ply_no, 
                                               java.lang.String frm_plyapp_tm, 
                                               java.lang.String to_plyapp_tm, 
                                               java.lang.String frm_insrnc_cde, 
                                               java.lang.String to_insrnc_cde, 
                                               java.lang.String[] dpt_array) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryPlyNetList", true);
          _output.write_wstring((java.lang.String)in_opr_cde);
          _output.write_string((java.lang.String)in_prnt_flg);
          _output.write_string((java.lang.String)in_ply_no);
          _output.write_string((java.lang.String)frm_plyapp_tm);
          _output.write_string((java.lang.String)to_plyapp_tm);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          com.mcip.orb.StringsHelper.write(_output, dpt_array);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryPlyNetList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryPlyNetList(in_opr_cde, in_prnt_flg, in_ply_no, frm_plyapp_tm, 
                                       to_plyapp_tm, frm_insrnc_cde, to_insrnc_cde, 
                                       dpt_array);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPlyNetInfo (in com.mcip.orb.Strings ply_no_array)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPlyNetInfo (java.lang.String[] ply_no_array) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryPlyNetInfo", true);
          com.mcip.orb.StringsHelper.write(_output, ply_no_array);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryPlyNetInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryPlyNetInfo(ply_no_array);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updatePrintInfo (in com.mcip.orb.Strings ply_no_array,
                           in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updatePrintInfo (java.lang.String[] ply_no_array, 
                                  java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updatePrintInfo", true);
          com.mcip.orb.StringsHelper.write(_output, ply_no_array);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updatePrintInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.updatePrintInfo(ply_no_array, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptPlyAssign (in string in_ply_no, in wstring in_assign_emp,
                           in string in_assign_tm, in string in_sended_tm,
                           in string in_feedbk_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPlyAssign (java.lang.String in_ply_no, 
                                  java.lang.String in_assign_emp, 
                                  java.lang.String in_assign_tm, 
                                  java.lang.String in_sended_tm, 
                                  java.lang.String in_feedbk_tm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptPlyAssign", true);
          _output.write_string((java.lang.String)in_ply_no);
          _output.write_wstring((java.lang.String)in_assign_emp);
          _output.write_string((java.lang.String)in_assign_tm);
          _output.write_string((java.lang.String)in_sended_tm);
          _output.write_string((java.lang.String)in_feedbk_tm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPlyAssign", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptPlyAssign(in_ply_no, in_assign_emp, in_assign_tm, 
                                       in_sended_tm, in_feedbk_tm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptPlySended (in string in_ply_no, in string in_sended_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPlySended (java.lang.String in_ply_no, 
                                  java.lang.String in_sended_tm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptPlySended", true);
          _output.write_string((java.lang.String)in_ply_no);
          _output.write_string((java.lang.String)in_sended_tm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPlySended", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptPlySended(in_ply_no, in_sended_tm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptPlyFreebk (in string in_ply_no, in string in_freebk_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPlyFreebk (java.lang.String in_ply_no, 
                                  java.lang.String in_freebk_tm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptPlyFreebk", true);
          _output.write_string((java.lang.String)in_ply_no);
          _output.write_string((java.lang.String)in_freebk_tm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPlyFreebk", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptPlyFreebk(in_ply_no, in_freebk_tm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPlyNetAbleEmp (in wstring in_dpt_cde,
                                            in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPlyNetAbleEmp (java.lang.String in_dpt_cde, 
                                                  java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryPlyNetAbleEmp", true);
          _output.write_wstring((java.lang.String)in_dpt_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryPlyNetAbleEmp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryPlyNetAbleEmp(in_dpt_cde, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPlyDealList (in string in_deal_type,
                                          in string in_deal_flg,
                                          in string in_ply_no,
                                          in string frm_plyapp_tm,
                                          in string to_plyapp_tm,
                                          in wstring frm_insrnc_cde,
                                          in wstring to_insrnc_cde,
                                          in com.mcip.orb.Strings dpt_array,
                                          in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPlyDealList (java.lang.String in_deal_type, 
                                                java.lang.String in_deal_flg, 
                                                java.lang.String in_ply_no, 
                                                java.lang.String frm_plyapp_tm, 
                                                java.lang.String to_plyapp_tm, 
                                                java.lang.String frm_insrnc_cde, 
                                                java.lang.String to_insrnc_cde, 
                                                java.lang.String[] dpt_array, 
                                                java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryPlyDealList", true);
          _output.write_string((java.lang.String)in_deal_type);
          _output.write_string((java.lang.String)in_deal_flg);
          _output.write_string((java.lang.String)in_ply_no);
          _output.write_string((java.lang.String)frm_plyapp_tm);
          _output.write_string((java.lang.String)to_plyapp_tm);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          com.mcip.orb.StringsHelper.write(_output, dpt_array);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryPlyDealList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryPlyDealList(in_deal_type, in_deal_flg, in_ply_no, frm_plyapp_tm, 
                                        to_plyapp_tm, frm_insrnc_cde, to_insrnc_cde, 
                                        dpt_array, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryRptFlwUpList (in string in_deal_type,
                                           in string in_deal_flg,
                                           in string in_ply_no,
                                           in string in_rpt_no,
                                           in string frm_rpt_tm,
                                           in string to_rpt_tm,
                                           in wstring frm_insrnc_cde,
                                           in wstring to_insrnc_cde,
                                           in com.mcip.orb.Strings dpt_array,
                                           in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryRptFlwUpList (java.lang.String in_deal_type, 
                                                 java.lang.String in_deal_flg, 
                                                 java.lang.String in_ply_no, 
                                                 java.lang.String in_rpt_no, 
                                                 java.lang.String frm_rpt_tm, 
                                                 java.lang.String to_rpt_tm, 
                                                 java.lang.String frm_insrnc_cde, 
                                                 java.lang.String to_insrnc_cde, 
                                                 java.lang.String[] dpt_array, 
                                                 java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryRptFlwUpList", true);
          _output.write_string((java.lang.String)in_deal_type);
          _output.write_string((java.lang.String)in_deal_flg);
          _output.write_string((java.lang.String)in_ply_no);
          _output.write_string((java.lang.String)in_rpt_no);
          _output.write_string((java.lang.String)frm_rpt_tm);
          _output.write_string((java.lang.String)to_rpt_tm);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          com.mcip.orb.StringsHelper.write(_output, dpt_array);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryRptFlwUpList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryRptFlwUpList(in_deal_type, in_deal_flg, in_ply_no, 
                                         in_rpt_no, frm_rpt_tm, to_rpt_tm, frm_insrnc_cde, 
                                         to_insrnc_cde, dpt_array, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptRptFlwUpEmp (in string in_rpt_no, in wstring in_emp_cde,
                             in wstring auth_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptRptFlwUpEmp (java.lang.String in_rpt_no, 
                                    java.lang.String in_emp_cde, 
                                    java.lang.String auth_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptRptFlwUpEmp", true);
          _output.write_string((java.lang.String)in_rpt_no);
          _output.write_wstring((java.lang.String)in_emp_cde);
          _output.write_wstring((java.lang.String)auth_opr_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptRptFlwUpEmp", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptRptFlwUpEmp(in_rpt_no, in_emp_cde, auth_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryEventTypeList (in wstring in_event_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryEventTypeList (java.lang.String in_event_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryEventTypeList", true);
          _output.write_wstring((java.lang.String)in_event_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryEventTypeList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryEventTypeList(in_event_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryEventCountList (in string frm_log_tm,
                                             in string to_log_tm,
                                             in wstring in_event_typ,
                                             in wstring in_event_cde,
                                             in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryEventCountList (java.lang.String frm_log_tm, 
                                                   java.lang.String to_log_tm, 
                                                   java.lang.String in_event_typ, 
                                                   java.lang.String in_event_cde, 
                                                   java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryEventCountList", true);
          _output.write_string((java.lang.String)frm_log_tm);
          _output.write_string((java.lang.String)to_log_tm);
          _output.write_wstring((java.lang.String)in_event_typ);
          _output.write_wstring((java.lang.String)in_event_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryEventCountList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryEventCountList(frm_log_tm, to_log_tm, in_event_typ, 
                                           in_event_cde, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptGuideInfo (in com.mcip.bus.orb.InsrncGuideInfo guideinfoobj,
                           in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptGuideInfo (com.mcip.bus.orb.InsrncGuideInfo guideinfoobj, 
                                  java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptGuideInfo", true);
          com.mcip.bus.orb.InsrncGuideInfoHelper.write(_output, guideinfoobj);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptGuideInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptGuideInfo(guideinfoobj, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateGuideInfo (in com.mcip.bus.orb.InsrncGuideInfo guideinfoobj,
                           in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateGuideInfo (com.mcip.bus.orb.InsrncGuideInfo guideinfoobj, 
                                  java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateGuideInfo", true);
          com.mcip.bus.orb.InsrncGuideInfoHelper.write(_output, guideinfoobj);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateGuideInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.updateGuideInfo(guideinfoobj, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteGuideInfo (in wstring in_info_no, in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteGuideInfo (java.lang.String in_info_no, 
                                  java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteGuideInfo", true);
          _output.write_wstring((java.lang.String)in_info_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteGuideInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.deleteGuideInfo(in_info_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryGuideList (in wstring in_info_no,
                                        in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryGuideList (java.lang.String in_info_no, 
                                              java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryGuideList", true);
          _output.write_wstring((java.lang.String)in_info_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryGuideList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryGuideList(in_info_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryGuideInfo (in wstring in_info_no,
                                        in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryGuideInfo (java.lang.String in_info_no, 
                                              java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryGuideInfo", true);
          _output.write_wstring((java.lang.String)in_info_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryGuideInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryGuideInfo(in_info_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptConsultInfo (in com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj,
                             in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptConsultInfo (com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj, 
                                    java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptConsultInfo", true);
          com.mcip.bus.orb.InsrncFaqInfoHelper.write(_output, insrncfaqinfoobj);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptConsultInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptConsultInfo(insrncfaqinfoobj, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateConsultInfo (in com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj,
                             in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateConsultInfo (com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj, 
                                    java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateConsultInfo", true);
          com.mcip.bus.orb.InsrncFaqInfoHelper.write(_output, insrncfaqinfoobj);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateConsultInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.updateConsultInfo(insrncfaqinfoobj, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteConsultInfo (in wstring in_faq_no, in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteConsultInfo (java.lang.String in_faq_no, 
                                    java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteConsultInfo", true);
          _output.write_wstring((java.lang.String)in_faq_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteConsultInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.deleteConsultInfo(in_faq_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryConsultList (in wstring in_topic_no,
                                          in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryConsultList (java.lang.String in_topic_no, 
                                                java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryConsultList", true);
          _output.write_wstring((java.lang.String)in_topic_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryConsultList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryConsultList(in_topic_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryConsultInfo (in wstring in_faq_no,
                                          in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryConsultInfo (java.lang.String in_faq_no, 
                                                java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryConsultInfo", true);
          _output.write_wstring((java.lang.String)in_faq_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryConsultInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryConsultInfo(in_faq_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptFaqInfo (in com.mcip.bus.orb.CustFaqInfo custfaqinfoobj,
                         in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptFaqInfo (com.mcip.bus.orb.CustFaqInfo custfaqinfoobj, 
                                java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptFaqInfo", true);
          com.mcip.bus.orb.CustFaqInfoHelper.write(_output, custfaqinfoobj);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptFaqInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptFaqInfo(custfaqinfoobj, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateFaqInfo (in com.mcip.bus.orb.CustFaqInfo custfaqinfoobj,
                         in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateFaqInfo (com.mcip.bus.orb.CustFaqInfo custfaqinfoobj, 
                                java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateFaqInfo", true);
          com.mcip.bus.orb.CustFaqInfoHelper.write(_output, custfaqinfoobj);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateFaqInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.updateFaqInfo(custfaqinfoobj, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteFaqInfo (in wstring in_faq_no, in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteFaqInfo (java.lang.String in_faq_no, 
                                java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteFaqInfo", true);
          _output.write_wstring((java.lang.String)in_faq_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteFaqInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.deleteFaqInfo(in_faq_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryFaqList (in wstring in_faq_no,
                                      in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryFaqList (java.lang.String in_faq_no, 
                                            java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryFaqList", true);
          _output.write_wstring((java.lang.String)in_faq_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryFaqList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryFaqList(in_faq_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryFaqInfo (in wstring in_faq_no,
                                      in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryFaqInfo (java.lang.String in_faq_no, 
                                            java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryFaqInfo", true);
          _output.write_wstring((java.lang.String)in_faq_no);
          _output.write_wstring((java.lang.String)in_opr_cnm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryFaqInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryFaqInfo(in_faq_no, in_opr_cnm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPlyAppStatictics (in string frm_plyapp_tm,
                                             in string to_plyapp_tm,
                                             in com.mcip.orb.Strings owned_dpt,
                                             in wstring frm_dpt,
                                             in wstring to_dpt,
                                             in wstring frm_insrnc_cde,
                                             in wstring to_insrnc_cde,
                                             in wstring in_cur_cde,
                                             in wstring in_site_cde,
                                             in wstring in_stat_type,
                                             in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPlyAppStatictics (java.lang.String frm_plyapp_tm, 
                                                   java.lang.String to_plyapp_tm, 
                                                   java.lang.String[] owned_dpt, 
                                                   java.lang.String frm_dpt, 
                                                   java.lang.String to_dpt, 
                                                   java.lang.String frm_insrnc_cde, 
                                                   java.lang.String to_insrnc_cde, 
                                                   java.lang.String in_cur_cde, 
                                                   java.lang.String in_site_cde, 
                                                   java.lang.String in_stat_type, 
                                                   java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPlyAppStatictics", true);
          _output.write_string((java.lang.String)frm_plyapp_tm);
          _output.write_string((java.lang.String)to_plyapp_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_wstring((java.lang.String)frm_dpt);
          _output.write_wstring((java.lang.String)to_dpt);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          _output.write_wstring((java.lang.String)in_cur_cde);
          _output.write_wstring((java.lang.String)in_site_cde);
          _output.write_wstring((java.lang.String)in_stat_type);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPlyAppStatictics", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getPlyAppStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                           frm_dpt, to_dpt, frm_insrnc_cde, to_insrnc_cde, 
                                           in_cur_cde, in_site_cde, in_stat_type, 
                                           in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyStatictics (in string frm_plyapp_tm,
                                             in string to_plyapp_tm,
                                             in com.mcip.orb.Strings owned_dpt,
                                             in wstring frm_dpt,
                                             in wstring to_dpt,
                                             in wstring frm_insrnc_cde,
                                             in wstring to_insrnc_cde,
                                             in wstring in_cur_cde,
                                             in wstring in_site_cde,
                                             in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyStatictics (java.lang.String frm_plyapp_tm, 
                                                   java.lang.String to_plyapp_tm, 
                                                   java.lang.String[] owned_dpt, 
                                                   java.lang.String frm_dpt, 
                                                   java.lang.String to_dpt, 
                                                   java.lang.String frm_insrnc_cde, 
                                                   java.lang.String to_insrnc_cde, 
                                                   java.lang.String in_cur_cde, 
                                                   java.lang.String in_site_cde, 
                                                   java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPolicyStatictics", true);
          _output.write_string((java.lang.String)frm_plyapp_tm);
          _output.write_string((java.lang.String)to_plyapp_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_wstring((java.lang.String)frm_dpt);
          _output.write_wstring((java.lang.String)to_dpt);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          _output.write_wstring((java.lang.String)in_cur_cde);
          _output.write_wstring((java.lang.String)in_site_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPolicyStatictics", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getPolicyStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                           frm_dpt, to_dpt, frm_insrnc_cde, to_insrnc_cde, 
                                           in_cur_cde, in_site_cde, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEdrPlcyStatictics (in string frm_edrapp_tm,
                                              in string to_edrapp_tm,
                                              in com.mcip.orb.Strings owned_dpt,
                                              in wstring frm_dpt,
                                              in wstring to_dpt,
                                              in wstring frm_insrnc_cde,
                                              in wstring to_insrnc_cde,
                                              in wstring in_cur_cde,
                                              in wstring in_site_cde,
                                              in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEdrPlcyStatictics (java.lang.String frm_edrapp_tm, 
                                                    java.lang.String to_edrapp_tm, 
                                                    java.lang.String[] owned_dpt, 
                                                    java.lang.String frm_dpt, 
                                                    java.lang.String to_dpt, 
                                                    java.lang.String frm_insrnc_cde, 
                                                    java.lang.String to_insrnc_cde, 
                                                    java.lang.String in_cur_cde, 
                                                    java.lang.String in_site_cde, 
                                                    java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getEdrPlcyStatictics", true);
          _output.write_string((java.lang.String)frm_edrapp_tm);
          _output.write_string((java.lang.String)to_edrapp_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_wstring((java.lang.String)frm_dpt);
          _output.write_wstring((java.lang.String)to_dpt);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          _output.write_wstring((java.lang.String)in_cur_cde);
          _output.write_wstring((java.lang.String)in_site_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEdrPlcyStatictics", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getEdrPlcyStatictics(frm_edrapp_tm, to_edrapp_tm, owned_dpt, 
                                            frm_dpt, to_dpt, frm_insrnc_cde, to_insrnc_cde, 
                                            in_cur_cde, in_site_cde, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProposalStatictics (in string frm_plyapp_tm,
                                               in string to_plyapp_tm,
                                               in com.mcip.orb.Strings owned_dpt,
                                               in wstring frm_dpt,
                                               in wstring to_dpt,
                                               in wstring frm_insrnc_cde,
                                               in wstring to_insrnc_cde,
                                               in wstring in_cur_cde,
                                               in wstring in_site_cde,
                                               in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProposalStatictics (java.lang.String frm_plyapp_tm, 
                                                     java.lang.String to_plyapp_tm, 
                                                     java.lang.String[] owned_dpt, 
                                                     java.lang.String frm_dpt, 
                                                     java.lang.String to_dpt, 
                                                     java.lang.String frm_insrnc_cde, 
                                                     java.lang.String to_insrnc_cde, 
                                                     java.lang.String in_cur_cde, 
                                                     java.lang.String in_site_cde, 
                                                     java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getProposalStatictics", true);
          _output.write_string((java.lang.String)frm_plyapp_tm);
          _output.write_string((java.lang.String)to_plyapp_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_wstring((java.lang.String)frm_dpt);
          _output.write_wstring((java.lang.String)to_dpt);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          _output.write_wstring((java.lang.String)in_cur_cde);
          _output.write_wstring((java.lang.String)in_site_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getProposalStatictics", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getProposalStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                             frm_dpt, to_dpt, frm_insrnc_cde, to_insrnc_cde, 
                                             in_cur_cde, in_site_cde, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCaseRptStatictics (in string frm_plyapp_tm,
                                              in string to_plyapp_tm,
                                              in com.mcip.orb.Strings owned_dpt,
                                              in wstring frm_dpt,
                                              in wstring to_dpt,
                                              in wstring frm_insrnc_cde,
                                              in wstring to_insrnc_cde,
                                              in wstring in_cur_cde,
                                              in wstring in_site_cde,
                                              in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCaseRptStatictics (java.lang.String frm_plyapp_tm, 
                                                    java.lang.String to_plyapp_tm, 
                                                    java.lang.String[] owned_dpt, 
                                                    java.lang.String frm_dpt, 
                                                    java.lang.String to_dpt, 
                                                    java.lang.String frm_insrnc_cde, 
                                                    java.lang.String to_insrnc_cde, 
                                                    java.lang.String in_cur_cde, 
                                                    java.lang.String in_site_cde, 
                                                    java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCaseRptStatictics", true);
          _output.write_string((java.lang.String)frm_plyapp_tm);
          _output.write_string((java.lang.String)to_plyapp_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_wstring((java.lang.String)frm_dpt);
          _output.write_wstring((java.lang.String)to_dpt);
          _output.write_wstring((java.lang.String)frm_insrnc_cde);
          _output.write_wstring((java.lang.String)to_insrnc_cde);
          _output.write_wstring((java.lang.String)in_cur_cde);
          _output.write_wstring((java.lang.String)in_site_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCaseRptStatictics", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getCaseRptStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                            frm_dpt, to_dpt, frm_insrnc_cde, to_insrnc_cde, 
                                            in_cur_cde, in_site_cde, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCustStatictics (in string frm_crt_tm,
                                           in string to_crt_tm,
                                           in com.mcip.orb.Strings owned_dpt,
                                           in wstring frm_dpt,
                                           in wstring to_dpt,
                                           in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCustStatictics (java.lang.String frm_crt_tm, 
                                                 java.lang.String to_crt_tm, 
                                                 java.lang.String[] owned_dpt, 
                                                 java.lang.String frm_dpt, 
                                                 java.lang.String to_dpt, 
                                                 java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCustStatictics", true);
          _output.write_string((java.lang.String)frm_crt_tm);
          _output.write_string((java.lang.String)to_crt_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_wstring((java.lang.String)frm_dpt);
          _output.write_wstring((java.lang.String)to_dpt);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCustStatictics", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getCustStatictics(frm_crt_tm, to_crt_tm, owned_dpt, frm_dpt, 
                                         to_dpt, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptClmDgst (in com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj,
                         in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptClmDgst (com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj, 
                                java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptClmDgst", true);
          com.mcip.bus.orb.ClmDgstInfoHelper.write(_output, clmdgstinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptClmDgst", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptClmDgst(clmdgstinfoobj, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updateClmDgst (in com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj,
                         in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateClmDgst (com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj, 
                                java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updateClmDgst", true);
          com.mcip.bus.orb.ClmDgstInfoHelper.write(_output, clmdgstinfoobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updateClmDgst", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.updateClmDgst(clmdgstinfoobj, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean deleteClmDgst (in wstring in_rpt_no, in wstring in_ply_no,
                         in wstring in_info_no, in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteClmDgst (java.lang.String in_rpt_no, 
                                java.lang.String in_ply_no, 
                                java.lang.String in_info_no, 
                                java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("deleteClmDgst", true);
          _output.write_wstring((java.lang.String)in_rpt_no);
          _output.write_wstring((java.lang.String)in_ply_no);
          _output.write_wstring((java.lang.String)in_info_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("deleteClmDgst", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.deleteClmDgst(in_rpt_no, in_ply_no, in_info_no, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryClmDgstInfo (in wstring in_rpt_no,
                                          in wstring in_ply_no,
                                          in wstring in_opr_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryClmDgstInfo (java.lang.String in_rpt_no, 
                                                java.lang.String in_ply_no, 
                                                java.lang.String in_opr_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryClmDgstInfo", true);
          _output.write_wstring((java.lang.String)in_rpt_no);
          _output.write_wstring((java.lang.String)in_ply_no);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryClmDgstInfo", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryClmDgstInfo(in_rpt_no, in_ply_no, in_opr_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptChatCntnt (in wstring in_bgn_tm, in wstring in_end_tm,
                           in wstring in_chat_ttl,
                           in com.mcip.orb.Strings chat_cntnt,
                           in wstring in_chat_nme, in wstring in_chat_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptChatCntnt (java.lang.String in_bgn_tm, 
                                  java.lang.String in_end_tm, 
                                  java.lang.String in_chat_ttl, 
                                  java.lang.String[] chat_cntnt, 
                                  java.lang.String in_chat_nme, 
                                  java.lang.String in_chat_mrk) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptChatCntnt", true);
          _output.write_wstring((java.lang.String)in_bgn_tm);
          _output.write_wstring((java.lang.String)in_end_tm);
          _output.write_wstring((java.lang.String)in_chat_ttl);
          com.mcip.orb.StringsHelper.write(_output, chat_cntnt);
          _output.write_wstring((java.lang.String)in_chat_nme);
          _output.write_wstring((java.lang.String)in_chat_mrk);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptChatCntnt", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.acceptChatCntnt(in_bgn_tm, in_end_tm, in_chat_ttl, chat_cntnt, 
                                       in_chat_nme, in_chat_mrk);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryChatCntnt (in wstring in_chat_ttl,
                                        in wstring in_chat_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryChatCntnt (java.lang.String in_chat_ttl, 
                                              java.lang.String in_chat_mrk) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryChatCntnt", true);
          _output.write_wstring((java.lang.String)in_chat_ttl);
          _output.write_wstring((java.lang.String)in_chat_mrk);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryChatCntnt", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.queryChatCntnt(in_chat_ttl, in_chat_mrk);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCustPlyAppList (in wstring in_user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCustPlyAppList (java.lang.String in_user_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCustPlyAppList", true);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCustPlyAppList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getCustPlyAppList(in_user_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCustPlySum (in wstring in_user_id,
                                       in com.mcip.orb.Strings in_insrnc_cde,
                                       in wstring in_sum_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCustPlySum (java.lang.String in_user_id, 
                                             java.lang.String[] in_insrnc_cde, 
                                             java.lang.String in_sum_tm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getCustPlySum", true);
          _output.write_wstring((java.lang.String)in_user_id);
          com.mcip.orb.StringsHelper.write(_output, in_insrnc_cde);
          _output.write_wstring((java.lang.String)in_sum_tm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCustPlySum", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getCustPlySum(in_user_id, in_insrnc_cde, in_sum_tm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getChatRight (in wstring in_emp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getChatRight (java.lang.String in_emp_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getChatRight", true);
          _output.write_wstring((java.lang.String)in_emp_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getChatRight", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.bus.orb.BusinessManagerOperations _self = (com.mcip.bus.orb.BusinessManagerOperations)_so.servant;
        try {
          return _self.getChatRight(in_emp_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
