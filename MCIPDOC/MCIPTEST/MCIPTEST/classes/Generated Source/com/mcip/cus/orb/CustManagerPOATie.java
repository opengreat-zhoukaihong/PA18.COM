
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
public class CustManagerPOATie extends CustManagerPOA {
  private com.mcip.cus.orb.CustManagerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public CustManagerPOATie (final com.mcip.cus.orb.CustManagerOperations _delegate) {
    this._delegate = _delegate;
  }

  public CustManagerPOATie (final com.mcip.cus.orb.CustManagerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public com.mcip.cus.orb.CustManagerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final com.mcip.cus.orb.CustManagerOperations delegate) {
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
   *   com.mcip.orb.Stringss customerLogin (in wstring usrname, in wstring passwd)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] customerLogin (java.lang.String usrname, 
                                             java.lang.String passwd) throws  com.mcip.orb.CoException {
    return this._delegate.customerLogin(usrname, passwd);
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
    return this._delegate.acceptOrgaCust(in_register_mrk, custorgnobj, custentityobj);
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
    return this._delegate.acceptPrsnCust(in_register_mrk, custprsnobj, custentityobj);
  }

  /**
   * <pre>
   *   boolean deleteIllegalUser (in string user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteIllegalUser (java.lang.String user_id) throws  com.mcip.orb.CoException {
    return this._delegate.deleteIllegalUser(user_id);
  }

  /**
   * <pre>
   *   boolean acceptAgntCust (in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptAgntCust (com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {
    return this._delegate.acceptAgntCust(custentityobj);
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
    return this._delegate.updateOrgaCust(custorgnobj, cust_user_id);
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
    return this._delegate.updatePrsnCust(custprsnobj, cust_user_id);
  }

  /**
   * <pre>
   *   boolean updateEnttCust (in com.mcip.cus.orb.CustEntity custentityobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean updateEnttCust (com.mcip.cus.orb.CustEntity custentityobj) throws  com.mcip.orb.CoException {
    return this._delegate.updateEnttCust(custentityobj);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustEntt (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustEntt (java.lang.String in_account_info) throws  com.mcip.orb.CoException {
    return this._delegate.queryCustEntt(in_account_info);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustOrgn (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustOrgn (java.lang.String in_account_info) throws  com.mcip.orb.CoException {
    return this._delegate.queryCustOrgn(in_account_info);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustPrsn (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustPrsn (java.lang.String in_account_info) throws  com.mcip.orb.CoException {
    return this._delegate.queryCustPrsn(in_account_info);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryCustAgnt (in wstring in_account_info)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryCustAgnt (java.lang.String in_account_info) throws  com.mcip.orb.CoException {
    return this._delegate.queryCustAgnt(in_account_info);
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
    return this._delegate.requireCust(in_user_mrk, in_user_id, in_register_id);
  }

  /**
   * <pre>
   *   boolean checkProposal (in wstring user_id, in string cust_type)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean checkProposal (java.lang.String user_id, 
                                java.lang.String cust_type) throws  com.mcip.orb.CoException {
    return this._delegate.checkProposal(user_id, cust_type);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryAgencyInfo (in wstring in_agent_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryAgencyInfo (java.lang.String in_agent_cde) throws  com.mcip.orb.CoException {
    return this._delegate.queryAgencyInfo(in_agent_cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryOCcustInfo (in wstring in_clnt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryOCcustInfo (java.lang.String in_clnt_cde) throws  com.mcip.orb.CoException {
    return this._delegate.queryOCcustInfo(in_clnt_cde);
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
    return this._delegate.acceptOCCust(in_register_mrk, custorgnobj, custentityobj);
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
    return this._delegate.acceptAGCust(in_register_mrk, custorgnobj, custentityobj);
  }

}
