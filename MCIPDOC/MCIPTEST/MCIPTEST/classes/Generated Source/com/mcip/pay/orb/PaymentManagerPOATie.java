
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
public class PaymentManagerPOATie extends PaymentManagerPOA {
  private com.mcip.pay.orb.PaymentManagerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public PaymentManagerPOATie (final com.mcip.pay.orb.PaymentManagerOperations _delegate) {
    this._delegate = _delegate;
  }

  public PaymentManagerPOATie (final com.mcip.pay.orb.PaymentManagerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public com.mcip.pay.orb.PaymentManagerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final com.mcip.pay.orb.PaymentManagerOperations delegate) {
    this._delegate = delegate;
  }

  public org.omg.PortableServer.POA _default_POA () {
    if (_poa != null) {
      return _poa;
    } 
    else {
      return super._default_POA();
    }
  }

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
    return this._delegate.queryLastPayment(order_no, tran_type, user_id, pay_amt, 
                                           order_tm);
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
    return this._delegate.queryPaymentList(order_no, tran_type, user_id, pay_amt, 
                                           order_tm);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPaymentLog (in string in_p_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPaymentLog (java.lang.String in_p_id) throws  com.mcip.orb.CoException {
    return this._delegate.queryPaymentLog(in_p_id);
  }

  /**
   * <pre>
   *   boolean acceptPaymentLog (in com.mcip.pay.orb.PaymentLog paymentlogobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPaymentLog (com.mcip.pay.orb.PaymentLog paymentlogobj) throws  com.mcip.orb.CoException {
    return this._delegate.acceptPaymentLog(paymentlogobj);
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
    return this._delegate.updatePayFlag(plcy_no, pay_flag, in_session_id, bank_cde, 
                                        bank_nme, bank_accnt, in_got_prm, in_cur_typ, 
                                        pay_tm, pay_type, pay_cde, app_typ);
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
    return this._delegate.getPaymentLogList(frm_pay_tm, to_pay_tm, owned_dpt, in_trans_id, 
                                            in_order_no, in_payment_id, in_cur_typ, 
                                            in_user_id);
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
    return this._delegate.getBankPayList(frm_pay_tm, to_pay_tm, owned_dpt, frm_insrnc_cde, 
                                         to_insrnc_cde, in_bank_cde);
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
    return this._delegate.getDptPayList(frm_undr_tm, to_undr_tm, owned_dpt, frm_insrnc_cde, 
                                        to_insrnc_cde, in_bank_cde);
  }

  /**
   * <pre>
   *   boolean updatePaymentLog (in com.mcip.pay.orb.PaymentLog paymentlogobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updatePaymentLog (com.mcip.pay.orb.PaymentLog paymentlogobj) throws  com.mcip.orb.CoException {
    return this._delegate.updatePaymentLog(paymentlogobj);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPayStatusList ()
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPayStatusList () throws  com.mcip.orb.CoException {
    return this._delegate.getPayStatusList();
  }

  /**
   * <pre>
   *   boolean setPayFlag (in com.mcip.orb.Stringss payinfo)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean setPayFlag (java.lang.String[][] payinfo) throws  com.mcip.orb.CoException {
    return this._delegate.setPayFlag(payinfo);
  }

}
