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
public interface staticInfoManagerOperations {
  /**
   * <pre>
   *   com.mcip.orb.Stringss getNationalList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getNationalList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAreaList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAreaList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProvinceList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProvinceList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCityList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCityList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEduList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEduList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getTitleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getTitleList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDutyList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDutyList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getTradeTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getTradeTypeList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOrgTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOrgTypeList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOwnershipList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOwnershipList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getScaleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getScaleList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPremiumScaleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPremiumScaleList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCurrencyList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCurrencyList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCargoClsList (in string cde, in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCargoClsList (java.lang.String cde, 
                                               java.lang.String insrnc_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCargoTypeList (in string Cargocls)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCargoTypeList (java.lang.String Cargocls) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPackList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPackList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getExchangeRateList (in string cur1, in string cur2)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getExchangeRateList (java.lang.String cur1, 
                                                   java.lang.String cur2) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPayModeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPayModeList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceClassList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceClassList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceDefineList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceDefineList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceTypeList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getClauseList (in string insrnc_cde,
                                       in string claus_cde, in string add_mrk)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getClauseList (java.lang.String insrnc_cde, 
                                             java.lang.String claus_cde, 
                                             java.lang.String add_mrk) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEndorseReasonList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEndorseReasonList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDepartmentList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDepartmentList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgentCharacterList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgentCharacterList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getSurveyAgentList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getSurveyAgentList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCarriageList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCarriageList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getVslLevelList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getVslLevelList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCertificateList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCertificateList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getMajorList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getMajorList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getMarriageList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getMarriageList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getSexList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getSexList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEmployeeCodeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEmployeeCodeList (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPACrgoClsTypList (in wstring in_crgo_cde,
                                             in wstring in_site_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPACrgoClsTypList (java.lang.String in_crgo_cde, 
                                                   java.lang.String in_site_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getNetCodeList (in wstring in_net_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getNetCodeList (java.lang.String in_net_cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCurrencyInfo (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCurrencyInfo (java.lang.String cde) throws com.mcip.orb.CoException;

  /**
   * <pre>
   *   com.mcip.orb.Stringss getRptTelNum (in string in_dpt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getRptTelNum (java.lang.String in_dpt_cde) throws com.mcip.orb.CoException;

}
