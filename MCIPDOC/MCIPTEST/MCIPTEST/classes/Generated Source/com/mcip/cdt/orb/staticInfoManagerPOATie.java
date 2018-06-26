
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
public class staticInfoManagerPOATie extends staticInfoManagerPOA {
  private com.mcip.cdt.orb.staticInfoManagerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public staticInfoManagerPOATie (final com.mcip.cdt.orb.staticInfoManagerOperations _delegate) {
    this._delegate = _delegate;
  }

  public staticInfoManagerPOATie (final com.mcip.cdt.orb.staticInfoManagerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public com.mcip.cdt.orb.staticInfoManagerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final com.mcip.cdt.orb.staticInfoManagerOperations delegate) {
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
   *   com.mcip.orb.Stringss getNationalList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getNationalList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getNationalList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAreaList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAreaList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getAreaList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getProvinceList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getProvinceList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getProvinceList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCityList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCityList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getCityList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEduList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEduList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getEduList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getTitleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getTitleList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getTitleList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDutyList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDutyList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getDutyList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getTradeTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getTradeTypeList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getTradeTypeList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOrgTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOrgTypeList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getOrgTypeList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getOwnershipList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getOwnershipList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getOwnershipList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getScaleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getScaleList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getScaleList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPremiumScaleList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPremiumScaleList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getPremiumScaleList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCurrencyList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCurrencyList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getCurrencyList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCargoClsList (in string cde, in string insrnc_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCargoClsList (java.lang.String cde, 
                                               java.lang.String insrnc_cde) throws  com.mcip.orb.CoException {
    return this._delegate.getCargoClsList(cde, insrnc_cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCargoTypeList (in string Cargocls)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCargoTypeList (java.lang.String Cargocls) throws  com.mcip.orb.CoException {
    return this._delegate.getCargoTypeList(Cargocls);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPackList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPackList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getPackList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getExchangeRateList (in string cur1, in string cur2)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getExchangeRateList (java.lang.String cur1, 
                                                   java.lang.String cur2) throws  com.mcip.orb.CoException {
    return this._delegate.getExchangeRateList(cur1, cur2);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getPayModeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getPayModeList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getPayModeList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceClassList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceClassList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getInsuranceClassList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceDefineList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceDefineList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getInsuranceDefineList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getInsuranceTypeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getInsuranceTypeList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getInsuranceTypeList(cde);
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
    return this._delegate.getClauseList(insrnc_cde, claus_cde, add_mrk);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEndorseReasonList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEndorseReasonList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getEndorseReasonList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getDepartmentList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getDepartmentList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getDepartmentList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getAgentCharacterList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getAgentCharacterList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getAgentCharacterList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getSurveyAgentList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getSurveyAgentList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getSurveyAgentList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCarriageList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCarriageList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getCarriageList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getVslLevelList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getVslLevelList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getVslLevelList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCertificateList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCertificateList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getCertificateList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getMajorList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getMajorList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getMajorList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getMarriageList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getMarriageList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getMarriageList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getSexList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getSexList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getSexList(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getEmployeeCodeList (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getEmployeeCodeList (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getEmployeeCodeList(cde);
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
    return this._delegate.getPACrgoClsTypList(in_crgo_cde, in_site_cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getNetCodeList (in wstring in_net_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getNetCodeList (java.lang.String in_net_cde) throws  com.mcip.orb.CoException {
    return this._delegate.getNetCodeList(in_net_cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCurrencyInfo (in string cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCurrencyInfo (java.lang.String cde) throws  com.mcip.orb.CoException {
    return this._delegate.getCurrencyInfo(cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getRptTelNum (in string in_dpt_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getRptTelNum (java.lang.String in_dpt_cde) throws  com.mcip.orb.CoException {
    return this._delegate.getRptTelNum(in_dpt_cde);
  }

}
