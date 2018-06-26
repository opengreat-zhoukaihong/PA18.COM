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
public abstract class PaymentManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.pay.orb.PaymentManagerOperations {

  public com.mcip.pay.orb.PaymentManager _this () {
   return com.mcip.pay.orb.PaymentManagerHelper.narrow(super._this_object());
  }

  public com.mcip.pay.orb.PaymentManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.pay.orb.PaymentManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/pay/orb/PaymentManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("queryLastPayment", new int[] { 0, 0 });
    _methods.put("queryPaymentList", new int[] { 0, 1 });
    _methods.put("queryPaymentLog", new int[] { 0, 2 });
    _methods.put("acceptPaymentLog", new int[] { 0, 3 });
    _methods.put("updatePayFlag", new int[] { 0, 4 });
    _methods.put("getPaymentLogList", new int[] { 0, 5 });
    _methods.put("getBankPayList", new int[] { 0, 6 });
    _methods.put("getDptPayList", new int[] { 0, 7 });
    _methods.put("updatePaymentLog", new int[] { 0, 8 });
    _methods.put("getPayStatusList", new int[] { 0, 9 });
    _methods.put("setPayFlag", new int[] { 0, 10 });
  }

  public org.omg.CORBA.portable.OutputStream _invoke (java.lang.String opName,
                                                      org.omg.CORBA.portable.InputStream _input,
                                                      org.omg.CORBA.portable.ResponseHandler handler) {
    int[] method = (int[]) _methods.get(opName);
    if (method == null) {
      throw new org.omg.CORBA.BAD_OPERATION();
    }
    switch (method[0]) {
      case 0: {
        return com.mcip.pay.orb.PaymentManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.pay.orb.PaymentManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
      try {
        java.lang.String order_no;
        order_no = _input.read_string();
        java.lang.String tran_type;
        tran_type = _input.read_string();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String pay_amt;
        pay_amt = _input.read_string();
        java.lang.String order_tm;
        order_tm = _input.read_string();
        java.lang.String[][] _result = _self.queryLastPayment(order_no, tran_type, 
                                                              user_id, pay_amt, 
                                                              order_tm);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 1: {
      try {
        java.lang.String order_no;
        order_no = _input.read_string();
        java.lang.String tran_type;
        tran_type = _input.read_string();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String pay_amt;
        pay_amt = _input.read_string();
        java.lang.String order_tm;
        order_tm = _input.read_string();
        java.lang.String[][] _result = _self.queryPaymentList(order_no, tran_type, 
                                                              user_id, pay_amt, 
                                                              order_tm);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 2: {
      try {
        java.lang.String in_p_id;
        in_p_id = _input.read_string();
        java.lang.String[][] _result = _self.queryPaymentLog(in_p_id);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 3: {
      try {
        com.mcip.pay.orb.PaymentLog paymentlogobj;
        paymentlogobj = com.mcip.pay.orb.PaymentLogHelper.read(_input);
        boolean _result = _self.acceptPaymentLog(paymentlogobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 4: {
      try {
        java.lang.String plcy_no;
        plcy_no = _input.read_string();
        java.lang.String pay_flag;
        pay_flag = _input.read_string();
        java.lang.String in_session_id;
        in_session_id = _input.read_string();
        java.lang.String bank_cde;
        bank_cde = _input.read_wstring();
        java.lang.String bank_nme;
        bank_nme = _input.read_wstring();
        java.lang.String bank_accnt;
        bank_accnt = _input.read_wstring();
        java.lang.String in_got_prm;
        in_got_prm = _input.read_string();
        java.lang.String in_cur_typ;
        in_cur_typ = _input.read_string();
        java.lang.String pay_tm;
        pay_tm = _input.read_string();
        java.lang.String pay_type;
        pay_type = _input.read_string();
        java.lang.String pay_cde;
        pay_cde = _input.read_string();
        java.lang.String app_typ;
        app_typ = _input.read_string();
        boolean _result = _self.updatePayFlag(plcy_no, pay_flag, in_session_id, 
                                              bank_cde, bank_nme, bank_accnt, in_got_prm, 
                                              in_cur_typ, pay_tm, pay_type, pay_cde, 
                                              app_typ);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 5: {
      try {
        java.lang.String frm_pay_tm;
        frm_pay_tm = _input.read_string();
        java.lang.String to_pay_tm;
        to_pay_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_trans_id;
        in_trans_id = _input.read_wstring();
        java.lang.String in_order_no;
        in_order_no = _input.read_wstring();
        java.lang.String in_payment_id;
        in_payment_id = _input.read_wstring();
        java.lang.String in_cur_typ;
        in_cur_typ = _input.read_wstring();
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String[][] _result = _self.getPaymentLogList(frm_pay_tm, to_pay_tm, 
                                                               owned_dpt, in_trans_id, 
                                                               in_order_no, in_payment_id, 
                                                               in_cur_typ, in_user_id);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 6: {
      try {
        java.lang.String frm_pay_tm;
        frm_pay_tm = _input.read_string();
        java.lang.String to_pay_tm;
        to_pay_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_string();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_string();
        java.lang.String in_bank_cde;
        in_bank_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getBankPayList(frm_pay_tm, to_pay_tm, 
                                                            owned_dpt, frm_insrnc_cde, 
                                                            to_insrnc_cde, in_bank_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 7: {
      try {
        java.lang.String frm_undr_tm;
        frm_undr_tm = _input.read_string();
        java.lang.String to_undr_tm;
        to_undr_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_string();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_string();
        java.lang.String in_bank_cde;
        in_bank_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getDptPayList(frm_undr_tm, to_undr_tm, 
                                                           owned_dpt, frm_insrnc_cde, 
                                                           to_insrnc_cde, in_bank_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 8: {
      try {
        com.mcip.pay.orb.PaymentLog paymentlogobj;
        paymentlogobj = com.mcip.pay.orb.PaymentLogHelper.read(_input);
        boolean _result = _self.updatePaymentLog(paymentlogobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 9: {
      try {
        java.lang.String[][] _result = _self.getPayStatusList();
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 10: {
      try {
        java.lang.String[][] payinfo;
        payinfo = com.mcip.orb.StringssHelper.read(_input);
        boolean _result = _self.setPayFlag(payinfo);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      }
      throw new org.omg.CORBA.BAD_OPERATION();
    }
  }
}
