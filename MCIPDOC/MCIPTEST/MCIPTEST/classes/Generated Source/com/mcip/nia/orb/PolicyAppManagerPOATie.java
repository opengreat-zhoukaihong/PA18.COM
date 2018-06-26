
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
public class PolicyAppManagerPOATie extends PolicyAppManagerPOA {
  private com.mcip.nia.orb.PolicyAppManagerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public PolicyAppManagerPOATie (final com.mcip.nia.orb.PolicyAppManagerOperations _delegate) {
    this._delegate = _delegate;
  }

  public PolicyAppManagerPOATie (final com.mcip.nia.orb.PolicyAppManagerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public com.mcip.nia.orb.PolicyAppManagerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final com.mcip.nia.orb.PolicyAppManagerOperations delegate) {
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
   *   com.mcip.orb.Stringss acceptPolicyApp (in com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj,
                                         in com.mcip.orb.Stringss rdrinfo)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] acceptPolicyApp (com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj, 
                                               java.lang.String[][] rdrinfo) throws  com.mcip.orb.CoException {
    return this._delegate.acceptPolicyApp(plcyappinfoobj, rdrinfo);
  }

  /**
   * <pre>
   *   boolean withdrawalPolicyApp (in string plcyapp_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean withdrawalPolicyApp (java.lang.String plcyapp_no) throws  com.mcip.orb.CoException {
    return this._delegate.withdrawalPolicyApp(plcyapp_no);
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
    return this._delegate.updatePolicyApp(plcyappinfoobj, rdrinfo);
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
    return this._delegate.confirmPolicyAppProposal(plcyapp_no, dpt_cde, insrnc_cde, 
                                                   undr_prsn);
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
    return this._delegate.acceptUserRemark(plcyapp_no, app_cde, user_remark, app_typ);
  }

  /**
   * <pre>
   *   boolean deletePolicyApp (in string plcyapp_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deletePolicyApp (java.lang.String plcyapp_no) throws  com.mcip.orb.CoException {
    return this._delegate.deletePolicyApp(plcyapp_no);
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
    return this._delegate.updatePayFlag(plcy_no, pay_flag, app_typ);
  }

}
