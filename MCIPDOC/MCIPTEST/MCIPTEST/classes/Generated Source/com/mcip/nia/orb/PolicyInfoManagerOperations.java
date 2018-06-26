package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyInfoManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyInfoManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyInfoManager {
  ...
};
 * </pre>
 */
public interface PolicyInfoManagerOperations {
  /**
   * <pre>
   *   com.mcip.orb.Stringss getOCList (in wstring user_id, in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOCList (java.lang.String user_id, 
                                         java.lang.String insrnc_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOCInfo (in string OC_cde, in string insrnc_cde,
                                   in string crgo_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOCInfo (java.lang.String OC_cde, 
                                         java.lang.String insrnc_cde, 
                                         java.lang.String crgo_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   wstring getPrintFormat (in wstring incondStr)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String getPrintFormat (java.lang.String incondStr) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   wstring getPrintPolicy (in wstring incondStr)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String getPrintPolicy (java.lang.String incondStr) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgencyList (in wstring clnt_cde,
                                       in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgencyList (java.lang.String clnt_cde, 
                                             java.lang.String insrnc_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgencyInfo (in string agt_agr_cde,
                                       in string insrnc_cde,
                                       in string crgo_cde, in string crgo_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgencyInfo (java.lang.String agt_agr_cde, 
                                             java.lang.String insrnc_cde, 
                                             java.lang.String crgo_cde, 
                                             java.lang.String crgo_typ) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgencyPlcyList (in string agt_agr_cde,
                                           in string insrnc_cde,
                                           in string credit_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgencyPlcyList (java.lang.String agt_agr_cde, 
                                                 java.lang.String insrnc_cde, 
                                                 java.lang.String credit_id) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCustPlcyList (in wstring user_id,
                                         in string insrnc_cde,
                                         in string credit_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCustPlcyList (java.lang.String user_id, 
                                               java.lang.String insrnc_cde, 
                                               java.lang.String credit_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyAppList (in wstring user_id,
                                          in string plyapp_cde,
                                          in string app_from_tm,
                                          in string app_to_tm,
                                          in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyAppList (java.lang.String user_id, 
                                                java.lang.String plyapp_cde, 
                                                java.lang.String app_from_tm, 
                                                java.lang.String app_to_tm, 
                                                java.lang.String cust_typ) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyAppInfo (in string plyapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyAppInfo (java.lang.String plyapp_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyList (in wstring user_id,
                                       in string policy_cde,
                                       in string app_from_tm,
                                       in string app_to_tm, in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyList (java.lang.String user_id, 
                                             java.lang.String policy_cde, 
                                             java.lang.String app_from_tm, 
                                             java.lang.String app_to_tm, 
                                             java.lang.String cust_typ) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyInfo (in string policy_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyInfo (java.lang.String policy_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPolicyInfoLatest (in string policy_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPolicyInfoLatest (java.lang.String policy_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProposalInfo (in string plyapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProposalInfo (java.lang.String plyapp_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEndorseProposalInfo (in string edrapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEndorseProposalInfo (java.lang.String edrapp_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPlyAppRdrInfo (in string in_plyapp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPlyAppRdrInfo (java.lang.String in_plyapp_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPlyRdrInfo (in string in_ply_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPlyRdrInfo (java.lang.String in_ply_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCaseRptList (in wstring in_user_id,
                                        in string in_rpt_no,
                                        in string in_from_tm,
                                        in string in_to_tm,
                                        in string in_cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCaseRptList (java.lang.String in_user_id, 
                                              java.lang.String in_rpt_no, 
                                              java.lang.String in_from_tm, 
                                              java.lang.String in_to_tm, 
                                              java.lang.String in_cust_typ) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCaseRptInfo (in string in_rpt_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCaseRptInfo (java.lang.String in_rpt_no) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCaseClmList (in string in_rpt_no,
                                        in string in_status_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCaseClmList (java.lang.String in_rpt_no, 
                                              java.lang.String in_status_mrk) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClaimList (in string in_clnt_cde,
                                      in string in_rpt_no,
                                      in string in_clm_no,
                                      in string in_from_tm,
                                      in string in_to_tm,
                                      in string in_status_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClaimList (java.lang.String in_clnt_cde, 
                                            java.lang.String in_rpt_no, 
                                            java.lang.String in_clm_no, 
                                            java.lang.String in_from_tm, 
                                            java.lang.String in_to_tm, 
                                            java.lang.String in_status_mrk) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClmDgstList (in string in_rpt_no,
                                        in string in_ply_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClmDgstList (java.lang.String in_rpt_no, 
                                              java.lang.String in_ply_no) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getQuotation (in com.mcip.nia.orb.QuotaCndtn quotacndtnobj,
                                      in wstring rdr_type)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getQuotation (com.mcip.nia.orb.QuotaCndtn quotacndtnobj, 
                                            java.lang.String rdr_type) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPlyAppNetAddress (in string cust_typ,
                                             in string in_clnt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPlyAppNetAddress (java.lang.String cust_typ, 
                                                   java.lang.String in_clnt_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClauseList (in wstring in_insrnc_cde,
                                       in wstring in_clause_cde,
                                       in wstring in_clnt_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClauseList (java.lang.String in_insrnc_cde, 
                                             java.lang.String in_clause_cde, 
                                             java.lang.String in_clnt_cnm) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProposalList (in wstring user_id,
                                         in string plyapp_cde,
                                         in string app_from_tm,
                                         in string app_to_tm,
                                         in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProposalList (java.lang.String user_id, 
                                               java.lang.String plyapp_cde, 
                                               java.lang.String app_from_tm, 
                                               java.lang.String app_to_tm, 
                                               java.lang.String cust_typ) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEdrAppList (in wstring user_id,
                                       in string edrapp_cde, in string ply_no,
                                       in string app_from_tm,
                                       in string app_to_tm, in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEdrAppList (java.lang.String user_id, 
                                             java.lang.String edrapp_cde, 
                                             java.lang.String ply_no, 
                                             java.lang.String app_from_tm, 
                                             java.lang.String app_to_tm, 
                                             java.lang.String cust_typ) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEdrsmtList (in wstring user_id, in string edr_no,
                                       in string ply_no,
                                       in string app_from_tm,
                                       in string app_to_tm, in string cust_typ)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEdrsmtList (java.lang.String user_id, 
                                             java.lang.String edr_no, 
                                             java.lang.String ply_no, 
                                             java.lang.String app_from_tm, 
                                             java.lang.String app_to_tm, 
                                             java.lang.String cust_typ) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEdrsmtInfo (in string edr_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEdrsmtInfo (java.lang.String edr_no) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPreEdrInfo (in string edr_app_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPreEdrInfo (java.lang.String edr_app_no) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   boolean checkEdrApp (in string ply_no)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean checkEdrApp (java.lang.String ply_no) throws com.mcip.orb.CoException;

}
