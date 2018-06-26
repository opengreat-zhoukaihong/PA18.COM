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
public interface PolicyManagerOperations {
  /**
   * <pre>
   *   com.mcip.orb.Stringss acceptCaseRpt (in com.mcip.nia.orb.CaseRptInfo caserptinfoobj)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] acceptCaseRpt (com.mcip.nia.orb.CaseRptInfo caserptinfoobj) throws com.mcip.orb.CoException;

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
                                               com.mcip.nia.orb.PlyPlyAppNetInfo plyplyappnetinfoobj) throws com.mcip.orb.CoException;

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
                            org.omg.CORBA.AnyHolder plyplyappnet) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   boolean withdrawalEdrApp (in string edr_app_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean withdrawalEdrApp (java.lang.String edr_app_no) throws com.mcip.orb.CoException;

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
                             org.omg.CORBA.AnyHolder plyplyappnet) throws com.mcip.orb.CoException;

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
                                                     java.lang.String insrnc_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   boolean deleteEdrApp (in string edr_app_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteEdrApp (java.lang.String edr_app_no) throws com.mcip.orb.CoException;

}
