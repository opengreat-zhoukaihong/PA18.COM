
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
public class BusinessManagerPOATie extends BusinessManagerPOA {
  private com.mcip.bus.orb.BusinessManagerOperations _delegate;
  private org.omg.PortableServer.POA _poa;

  public BusinessManagerPOATie (final com.mcip.bus.orb.BusinessManagerOperations _delegate) {
    this._delegate = _delegate;
  }

  public BusinessManagerPOATie (final com.mcip.bus.orb.BusinessManagerOperations _delegate, 
                              final org.omg.PortableServer.POA _poa) {
    this._delegate = _delegate;
    this._poa = _poa;
  }

  public com.mcip.bus.orb.BusinessManagerOperations _delegate () {
    return this._delegate;
  }

  public void _delegate (final com.mcip.bus.orb.BusinessManagerOperations delegate) {
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
   *   boolean isAlive ();
   * </pre>
   */
  public boolean isAlive () {
    return this._delegate.isAlive();
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
    return this._delegate.queryPlyNetList(in_opr_cde, in_prnt_flg, in_ply_no, frm_plyapp_tm, 
                                          to_plyapp_tm, frm_insrnc_cde, to_insrnc_cde, 
                                          dpt_array);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryPlyNetInfo (in com.mcip.orb.Strings ply_no_array)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryPlyNetInfo (java.lang.String[] ply_no_array) throws  com.mcip.orb.CoException {
    return this._delegate.queryPlyNetInfo(ply_no_array);
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
    return this._delegate.updatePrintInfo(ply_no_array, in_opr_cde);
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
    return this._delegate.acceptPlyAssign(in_ply_no, in_assign_emp, in_assign_tm, 
                                          in_sended_tm, in_feedbk_tm);
  }

  /**
   * <pre>
   *   boolean acceptPlySended (in string in_ply_no, in string in_sended_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPlySended (java.lang.String in_ply_no, 
                                  java.lang.String in_sended_tm) throws  com.mcip.orb.CoException {
    return this._delegate.acceptPlySended(in_ply_no, in_sended_tm);
  }

  /**
   * <pre>
   *   boolean acceptPlyFreebk (in string in_ply_no, in string in_freebk_tm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean acceptPlyFreebk (java.lang.String in_ply_no, 
                                  java.lang.String in_freebk_tm) throws  com.mcip.orb.CoException {
    return this._delegate.acceptPlyFreebk(in_ply_no, in_freebk_tm);
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
    return this._delegate.queryPlyNetAbleEmp(in_dpt_cde, in_opr_cde);
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
    return this._delegate.queryPlyDealList(in_deal_type, in_deal_flg, in_ply_no, 
                                           frm_plyapp_tm, to_plyapp_tm, frm_insrnc_cde, 
                                           to_insrnc_cde, dpt_array, in_opr_cde);
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
    return this._delegate.queryRptFlwUpList(in_deal_type, in_deal_flg, in_ply_no, 
                                            in_rpt_no, frm_rpt_tm, to_rpt_tm, frm_insrnc_cde, 
                                            to_insrnc_cde, dpt_array, in_opr_cde);
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
    return this._delegate.acceptRptFlwUpEmp(in_rpt_no, in_emp_cde, auth_opr_cde);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss queryEventTypeList (in wstring in_event_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] queryEventTypeList (java.lang.String in_event_cde) throws  com.mcip.orb.CoException {
    return this._delegate.queryEventTypeList(in_event_cde);
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
    return this._delegate.queryEventCountList(frm_log_tm, to_log_tm, in_event_typ, 
                                              in_event_cde, in_opr_cde);
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
    return this._delegate.acceptGuideInfo(guideinfoobj, in_opr_cnm);
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
    return this._delegate.updateGuideInfo(guideinfoobj, in_opr_cnm);
  }

  /**
   * <pre>
   *   boolean deleteGuideInfo (in wstring in_info_no, in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteGuideInfo (java.lang.String in_info_no, 
                                  java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {
    return this._delegate.deleteGuideInfo(in_info_no, in_opr_cnm);
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
    return this._delegate.queryGuideList(in_info_no, in_opr_cnm);
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
    return this._delegate.queryGuideInfo(in_info_no, in_opr_cnm);
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
    return this._delegate.acceptConsultInfo(insrncfaqinfoobj, in_opr_cnm);
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
    return this._delegate.updateConsultInfo(insrncfaqinfoobj, in_opr_cnm);
  }

  /**
   * <pre>
   *   boolean deleteConsultInfo (in wstring in_faq_no, in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteConsultInfo (java.lang.String in_faq_no, 
                                    java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {
    return this._delegate.deleteConsultInfo(in_faq_no, in_opr_cnm);
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
    return this._delegate.queryConsultList(in_topic_no, in_opr_cnm);
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
    return this._delegate.queryConsultInfo(in_faq_no, in_opr_cnm);
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
    return this._delegate.acceptFaqInfo(custfaqinfoobj, in_opr_cnm);
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
    return this._delegate.updateFaqInfo(custfaqinfoobj, in_opr_cnm);
  }

  /**
   * <pre>
   *   boolean deleteFaqInfo (in wstring in_faq_no, in wstring in_opr_cnm)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public boolean deleteFaqInfo (java.lang.String in_faq_no, 
                                java.lang.String in_opr_cnm) throws  com.mcip.orb.CoException {
    return this._delegate.deleteFaqInfo(in_faq_no, in_opr_cnm);
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
    return this._delegate.queryFaqList(in_faq_no, in_opr_cnm);
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
    return this._delegate.queryFaqInfo(in_faq_no, in_opr_cnm);
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
    return this._delegate.getPlyAppStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                              frm_dpt, to_dpt, frm_insrnc_cde, 
                                              to_insrnc_cde, in_cur_cde, in_site_cde, 
                                              in_stat_type, in_opr_cde);
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
    return this._delegate.getPolicyStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                              frm_dpt, to_dpt, frm_insrnc_cde, 
                                              to_insrnc_cde, in_cur_cde, in_site_cde, 
                                              in_opr_cde);
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
    return this._delegate.getEdrPlcyStatictics(frm_edrapp_tm, to_edrapp_tm, owned_dpt, 
                                               frm_dpt, to_dpt, frm_insrnc_cde, 
                                               to_insrnc_cde, in_cur_cde, in_site_cde, 
                                               in_opr_cde);
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
    return this._delegate.getProposalStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                                frm_dpt, to_dpt, frm_insrnc_cde, 
                                                to_insrnc_cde, in_cur_cde, in_site_cde, 
                                                in_opr_cde);
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
    return this._delegate.getCaseRptStatictics(frm_plyapp_tm, to_plyapp_tm, owned_dpt, 
                                               frm_dpt, to_dpt, frm_insrnc_cde, 
                                               to_insrnc_cde, in_cur_cde, in_site_cde, 
                                               in_opr_cde);
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
    return this._delegate.getCustStatictics(frm_crt_tm, to_crt_tm, owned_dpt, frm_dpt, 
                                            to_dpt, in_opr_cde);
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
    return this._delegate.acceptClmDgst(clmdgstinfoobj, in_opr_cde);
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
    return this._delegate.updateClmDgst(clmdgstinfoobj, in_opr_cde);
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
    return this._delegate.deleteClmDgst(in_rpt_no, in_ply_no, in_info_no, in_opr_cde);
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
    return this._delegate.queryClmDgstInfo(in_rpt_no, in_ply_no, in_opr_cde);
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
    return this._delegate.acceptChatCntnt(in_bgn_tm, in_end_tm, in_chat_ttl, chat_cntnt, 
                                          in_chat_nme, in_chat_mrk);
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
    return this._delegate.queryChatCntnt(in_chat_ttl, in_chat_mrk);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getCustPlyAppList (in wstring in_user_id)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getCustPlyAppList (java.lang.String in_user_id) throws  com.mcip.orb.CoException {
    return this._delegate.getCustPlyAppList(in_user_id);
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
    return this._delegate.getCustPlySum(in_user_id, in_insrnc_cde, in_sum_tm);
  }

  /**
   * <pre>
   *   com.mcip.orb.Stringss getChatRight (in wstring in_emp_cde)
    raises (com.mcip.orb.CoException);
   * </pre>
   */
  public java.lang.String[][] getChatRight (java.lang.String in_emp_cde) throws  com.mcip.orb.CoException {
    return this._delegate.getChatRight(in_emp_cde);
  }

}
