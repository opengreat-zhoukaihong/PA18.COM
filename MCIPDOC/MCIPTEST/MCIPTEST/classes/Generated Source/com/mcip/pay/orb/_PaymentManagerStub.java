package com.mcip.pay.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/paymentManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::pay::orb::PaymentManager
 * <li> <b>Repository Id</b> IDL:com/mcip/pay/orb/PaymentManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PaymentManager {
  ...
};
 * </pre>
 */
public class _PaymentManagerStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements com.mcip.pay.orb.PaymentManager {
  final public static java.lang.Class _opsClass = com.mcip.pay.orb.PaymentManagerOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/pay/orb/PaymentManager:1.0"
  };

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryLastPayment (in string order_no,
                                          in string tran_type,
                                          in wstring user_id,
                                          in string pay_amt,
                                          in string order_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryLastPayment (java.lang.String order_no, 
                                                java.lang.String tran_type, 
                                                java.lang.String user_id, 
                                                java.lang.String pay_amt, 
                                                java.lang.String order_tm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryLastPayment", true);
          _output.write_string((java.lang.String)order_no);
          _output.write_string((java.lang.String)tran_type);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)pay_amt);
          _output.write_string((java.lang.String)order_tm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryLastPayment", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.queryLastPayment(order_no, tran_type, user_id, pay_amt, 
                                        order_tm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPaymentList (in string order_no,
                                          in string tran_type,
                                          in wstring user_id,
                                          in string pay_amt,
                                          in string order_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPaymentList (java.lang.String order_no, 
                                                java.lang.String tran_type, 
                                                java.lang.String user_id, 
                                                java.lang.String pay_amt, 
                                                java.lang.String order_tm) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryPaymentList", true);
          _output.write_string((java.lang.String)order_no);
          _output.write_string((java.lang.String)tran_type);
          _output.write_wstring((java.lang.String)user_id);
          _output.write_string((java.lang.String)pay_amt);
          _output.write_string((java.lang.String)order_tm);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryPaymentList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.queryPaymentList(order_no, tran_type, user_id, pay_amt, 
                                        order_tm);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPaymentLog (in string in_p_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPaymentLog (java.lang.String in_p_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("queryPaymentLog", true);
          _output.write_string((java.lang.String)in_p_id);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("queryPaymentLog", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.queryPaymentLog(in_p_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean acceptPaymentLog (in com.mcip.pay.orb.PaymentLog paymentlogobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPaymentLog (com.mcip.pay.orb.PaymentLog paymentlogobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("acceptPaymentLog", true);
          com.mcip.pay.orb.PaymentLogHelper.write(_output, paymentlogobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("acceptPaymentLog", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.acceptPaymentLog(paymentlogobj);
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
                         in string in_session_id, in wstring bank_cde,
                         in wstring bank_nme, in wstring bank_accnt,
                         in string in_got_prm, in string in_cur_typ,
                         in string pay_tm, in string pay_type,
                         in string pay_cde, in string app_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updatePayFlag (java.lang.String plcy_no, 
                                java.lang.String pay_flag, 
                                java.lang.String in_session_id, 
                                java.lang.String bank_cde, 
                                java.lang.String bank_nme, 
                                java.lang.String bank_accnt, 
                                java.lang.String in_got_prm, 
                                java.lang.String in_cur_typ, 
                                java.lang.String pay_tm, 
                                java.lang.String pay_type, 
                                java.lang.String pay_cde, 
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
          _output.write_string((java.lang.String)in_session_id);
          _output.write_wstring((java.lang.String)bank_cde);
          _output.write_wstring((java.lang.String)bank_nme);
          _output.write_wstring((java.lang.String)bank_accnt);
          _output.write_string((java.lang.String)in_got_prm);
          _output.write_string((java.lang.String)in_cur_typ);
          _output.write_string((java.lang.String)pay_tm);
          _output.write_string((java.lang.String)pay_type);
          _output.write_string((java.lang.String)pay_cde);
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
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.updatePayFlag(plcy_no, pay_flag, in_session_id, bank_cde, 
                                     bank_nme, bank_accnt, in_got_prm, in_cur_typ, 
                                     pay_tm, pay_type, pay_cde, app_typ);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPaymentLogList (in string frm_pay_tm,
                                           in string to_pay_tm,
                                           in com.mcip.orb.Strings owned_dpt,
                                           in wstring in_trans_id,
                                           in wstring in_order_no,
                                           in wstring in_payment_id,
                                           in wstring in_cur_typ,
                                           in wstring in_user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPaymentLogList (java.lang.String frm_pay_tm, 
                                                 java.lang.String to_pay_tm, 
                                                 java.lang.String[] owned_dpt, 
                                                 java.lang.String in_trans_id, 
                                                 java.lang.String in_order_no, 
                                                 java.lang.String in_payment_id, 
                                                 java.lang.String in_cur_typ, 
                                                 java.lang.String in_user_id) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPaymentLogList", true);
          _output.write_string((java.lang.String)frm_pay_tm);
          _output.write_string((java.lang.String)to_pay_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_wstring((java.lang.String)in_trans_id);
          _output.write_wstring((java.lang.String)in_order_no);
          _output.write_wstring((java.lang.String)in_payment_id);
          _output.write_wstring((java.lang.String)in_cur_typ);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPaymentLogList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.getPaymentLogList(frm_pay_tm, to_pay_tm, owned_dpt, in_trans_id, 
                                         in_order_no, in_payment_id, in_cur_typ, 
                                         in_user_id);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getBankPayList (in string frm_pay_tm,
                                        in string to_pay_tm,
                                        in com.mcip.orb.Strings owned_dpt,
                                        in string frm_insrnc_cde,
                                        in string to_insrnc_cde,
                                        in wstring in_bank_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getBankPayList (java.lang.String frm_pay_tm, 
                                              java.lang.String to_pay_tm, 
                                              java.lang.String[] owned_dpt, 
                                              java.lang.String frm_insrnc_cde, 
                                              java.lang.String to_insrnc_cde, 
                                              java.lang.String in_bank_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getBankPayList", true);
          _output.write_string((java.lang.String)frm_pay_tm);
          _output.write_string((java.lang.String)to_pay_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_string((java.lang.String)frm_insrnc_cde);
          _output.write_string((java.lang.String)to_insrnc_cde);
          _output.write_wstring((java.lang.String)in_bank_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getBankPayList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.getBankPayList(frm_pay_tm, to_pay_tm, owned_dpt, frm_insrnc_cde, 
                                      to_insrnc_cde, in_bank_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDptPayList (in string frm_undr_tm,
                                       in string to_undr_tm,
                                       in com.mcip.orb.Strings owned_dpt,
                                       in string frm_insrnc_cde,
                                       in string to_insrnc_cde,
                                       in wstring in_bank_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDptPayList (java.lang.String frm_undr_tm, 
                                             java.lang.String to_undr_tm, 
                                             java.lang.String[] owned_dpt, 
                                             java.lang.String frm_insrnc_cde, 
                                             java.lang.String to_insrnc_cde, 
                                             java.lang.String in_bank_cde) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getDptPayList", true);
          _output.write_string((java.lang.String)frm_undr_tm);
          _output.write_string((java.lang.String)to_undr_tm);
          com.mcip.orb.StringsHelper.write(_output, owned_dpt);
          _output.write_string((java.lang.String)frm_insrnc_cde);
          _output.write_string((java.lang.String)to_insrnc_cde);
          _output.write_wstring((java.lang.String)in_bank_cde);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getDptPayList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.getDptPayList(frm_undr_tm, to_undr_tm, owned_dpt, frm_insrnc_cde, 
                                     to_insrnc_cde, in_bank_cde);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean updatePaymentLog (in com.mcip.pay.orb.PaymentLog paymentlogobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updatePaymentLog (com.mcip.pay.orb.PaymentLog paymentlogobj) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("updatePaymentLog", true);
          com.mcip.pay.orb.PaymentLogHelper.write(_output, paymentlogobj);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("updatePaymentLog", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.updatePaymentLog(paymentlogobj);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPayStatusList ()
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPayStatusList () throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        java.lang.String[][] _result;
        try {
          _output = this._request("getPayStatusList", true);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getPayStatusList", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.getPayStatusList();
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

  /**
   * <pre>
   *   boolean setPayFlag (in com.mcip.orb.Stringss payinfo)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean setPayFlag (java.lang.String[][] payinfo) throws  com.mcip.orb.CoException {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        boolean _result;
        try {
          _output = this._request("setPayFlag", true);
          com.mcip.orb.StringssHelper.write(_output, payinfo);
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
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("setPayFlag", _opsClass);
        if (_so == null) {
          continue;
        }
        final com.mcip.pay.orb.PaymentManagerOperations _self = (com.mcip.pay.orb.PaymentManagerOperations)_so.servant;
        try {
          return _self.setPayFlag(payinfo);
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
