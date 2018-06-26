package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb._example_BusinessManager
<li> <b>Source File</b> com/mcip/bus/orb/_example_BusinessManager.java
<li> <b>IDL Source File</b> businessManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::BusinessManager
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/BusinessManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    interface BusinessManager {
      boolean isAlive();
      ::com::mcip::orb::Stringss queryPlyNetList(
        in wstring in_opr_cde,
        in string in_prnt_flg,
        in string in_ply_no,
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in ::com::mcip::orb::Strings dpt_array
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPlyNetInfo(
        in ::com::mcip::orb::Strings ply_no_array
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePrintInfo(
        in ::com::mcip::orb::Strings ply_no_array,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPlyAssign(
        in string in_ply_no,
        in wstring in_assign_emp,
        in string in_assign_tm,
        in string in_sended_tm,
        in string in_feedbk_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPlySended(
        in string in_ply_no,
        in string in_sended_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPlyFreebk(
        in string in_ply_no,
        in string in_freebk_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPlyNetAbleEmp(
        in wstring in_dpt_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPlyDealList(
        in string in_deal_type,
        in string in_deal_flg,
        in string in_ply_no,
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in ::com::mcip::orb::Strings dpt_array,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryRptFlwUpList(
        in string in_deal_type,
        in string in_deal_flg,
        in string in_ply_no,
        in string in_rpt_no,
        in string frm_rpt_tm,
        in string to_rpt_tm,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in ::com::mcip::orb::Strings dpt_array,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptRptFlwUpEmp(
        in string in_rpt_no,
        in wstring in_emp_cde,
        in wstring auth_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryEventTypeList(
        in wstring in_event_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryEventCountList(
        in string frm_log_tm,
        in string to_log_tm,
        in wstring in_event_typ,
        in wstring in_event_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptGuideInfo(
        in ::com::mcip::bus::orb::InsrncGuideInfo guideinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateGuideInfo(
        in ::com::mcip::bus::orb::InsrncGuideInfo guideinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteGuideInfo(
        in wstring in_info_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryGuideList(
        in wstring in_info_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryGuideInfo(
        in wstring in_info_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptConsultInfo(
        in ::com::mcip::bus::orb::InsrncFaqInfo insrncfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateConsultInfo(
        in ::com::mcip::bus::orb::InsrncFaqInfo insrncfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteConsultInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryConsultList(
        in wstring in_topic_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryConsultInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptFaqInfo(
        in ::com::mcip::bus::orb::CustFaqInfo custfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateFaqInfo(
        in ::com::mcip::bus::orb::CustFaqInfo custfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteFaqInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryFaqList(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryFaqInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_stat_type,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrPlcyStatictics(
        in string frm_edrapp_tm,
        in string to_edrapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustStatictics(
        in string frm_crt_tm,
        in string to_crt_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptClmDgst(
        in ::com::mcip::bus::orb::ClmDgstInfo clmdgstinfoobj,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateClmDgst(
        in ::com::mcip::bus::orb::ClmDgstInfo clmdgstinfoobj,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteClmDgst(
        in wstring in_rpt_no,
        in wstring in_ply_no,
        in wstring in_info_no,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryClmDgstInfo(
        in wstring in_rpt_no,
        in wstring in_ply_no,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptChatCntnt(
        in wstring in_bgn_tm,
        in wstring in_end_tm,
        in wstring in_chat_ttl,
        in ::com::mcip::orb::Strings chat_cntnt,
        in wstring in_chat_nme,
        in wstring in_chat_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryChatCntnt(
        in wstring in_chat_ttl,
        in wstring in_chat_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustPlyAppList(
        in wstring in_user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustPlySum(
        in wstring in_user_id,
        in ::com::mcip::orb::Strings in_insrnc_cde,
        in wstring in_sum_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getChatRight(
        in wstring in_emp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _example_BusinessManager extends com.mcip.bus.orb._BusinessManagerImplBase {
  /** Construct a persistently named object. */
  public _example_BusinessManager(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_BusinessManager() {
    super();
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::isAlive</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean isAlive();
  </pre>
  </p>
  */
  public boolean isAlive() {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryPlyNetList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryPlyNetList(
      in wstring in_opr_cde,
      in string in_prnt_flg,
      in string in_ply_no,
      in string frm_plyapp_tm,
      in string to_plyapp_tm,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in ::com::mcip::orb::Strings dpt_array
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryPlyNetList(
    java.lang.String in_opr_cde,
    java.lang.String in_prnt_flg,
    java.lang.String in_ply_no,
    java.lang.String frm_plyapp_tm,
    java.lang.String to_plyapp_tm,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String[] dpt_array
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryPlyNetInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryPlyNetInfo(
      in ::com::mcip::orb::Strings ply_no_array
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryPlyNetInfo(
    java.lang.String[] ply_no_array
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::updatePrintInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean updatePrintInfo(
      in ::com::mcip::orb::Strings ply_no_array,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updatePrintInfo(
    java.lang.String[] ply_no_array,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptPlyAssign</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptPlyAssign(
      in string in_ply_no,
      in wstring in_assign_emp,
      in string in_assign_tm,
      in string in_sended_tm,
      in string in_feedbk_tm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptPlyAssign(
    java.lang.String in_ply_no,
    java.lang.String in_assign_emp,
    java.lang.String in_assign_tm,
    java.lang.String in_sended_tm,
    java.lang.String in_feedbk_tm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptPlySended</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptPlySended(
      in string in_ply_no,
      in string in_sended_tm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptPlySended(
    java.lang.String in_ply_no,
    java.lang.String in_sended_tm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptPlyFreebk</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptPlyFreebk(
      in string in_ply_no,
      in string in_freebk_tm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptPlyFreebk(
    java.lang.String in_ply_no,
    java.lang.String in_freebk_tm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryPlyNetAbleEmp</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryPlyNetAbleEmp(
      in wstring in_dpt_cde,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryPlyNetAbleEmp(
    java.lang.String in_dpt_cde,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryPlyDealList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryPlyDealList(
      in string in_deal_type,
      in string in_deal_flg,
      in string in_ply_no,
      in string frm_plyapp_tm,
      in string to_plyapp_tm,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in ::com::mcip::orb::Strings dpt_array,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryPlyDealList(
    java.lang.String in_deal_type,
    java.lang.String in_deal_flg,
    java.lang.String in_ply_no,
    java.lang.String frm_plyapp_tm,
    java.lang.String to_plyapp_tm,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String[] dpt_array,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryRptFlwUpList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryRptFlwUpList(
      in string in_deal_type,
      in string in_deal_flg,
      in string in_ply_no,
      in string in_rpt_no,
      in string frm_rpt_tm,
      in string to_rpt_tm,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in ::com::mcip::orb::Strings dpt_array,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryRptFlwUpList(
    java.lang.String in_deal_type,
    java.lang.String in_deal_flg,
    java.lang.String in_ply_no,
    java.lang.String in_rpt_no,
    java.lang.String frm_rpt_tm,
    java.lang.String to_rpt_tm,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String[] dpt_array,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptRptFlwUpEmp</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptRptFlwUpEmp(
      in string in_rpt_no,
      in wstring in_emp_cde,
      in wstring auth_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptRptFlwUpEmp(
    java.lang.String in_rpt_no,
    java.lang.String in_emp_cde,
    java.lang.String auth_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryEventTypeList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryEventTypeList(
      in wstring in_event_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryEventTypeList(
    java.lang.String in_event_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryEventCountList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryEventCountList(
      in string frm_log_tm,
      in string to_log_tm,
      in wstring in_event_typ,
      in wstring in_event_cde,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryEventCountList(
    java.lang.String frm_log_tm,
    java.lang.String to_log_tm,
    java.lang.String in_event_typ,
    java.lang.String in_event_cde,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptGuideInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptGuideInfo(
      in ::com::mcip::bus::orb::InsrncGuideInfo guideinfoobj,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptGuideInfo(
    com.mcip.bus.orb.InsrncGuideInfo guideinfoobj,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::updateGuideInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean updateGuideInfo(
      in ::com::mcip::bus::orb::InsrncGuideInfo guideinfoobj,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateGuideInfo(
    com.mcip.bus.orb.InsrncGuideInfo guideinfoobj,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::deleteGuideInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean deleteGuideInfo(
      in wstring in_info_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteGuideInfo(
    java.lang.String in_info_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryGuideList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryGuideList(
      in wstring in_info_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryGuideList(
    java.lang.String in_info_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryGuideInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryGuideInfo(
      in wstring in_info_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryGuideInfo(
    java.lang.String in_info_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptConsultInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptConsultInfo(
      in ::com::mcip::bus::orb::InsrncFaqInfo insrncfaqinfoobj,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptConsultInfo(
    com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::updateConsultInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean updateConsultInfo(
      in ::com::mcip::bus::orb::InsrncFaqInfo insrncfaqinfoobj,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateConsultInfo(
    com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::deleteConsultInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean deleteConsultInfo(
      in wstring in_faq_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteConsultInfo(
    java.lang.String in_faq_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryConsultList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryConsultList(
      in wstring in_topic_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryConsultList(
    java.lang.String in_topic_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryConsultInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryConsultInfo(
      in wstring in_faq_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryConsultInfo(
    java.lang.String in_faq_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptFaqInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptFaqInfo(
      in ::com::mcip::bus::orb::CustFaqInfo custfaqinfoobj,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptFaqInfo(
    com.mcip.bus.orb.CustFaqInfo custfaqinfoobj,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::updateFaqInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean updateFaqInfo(
      in ::com::mcip::bus::orb::CustFaqInfo custfaqinfoobj,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateFaqInfo(
    com.mcip.bus.orb.CustFaqInfo custfaqinfoobj,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::deleteFaqInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean deleteFaqInfo(
      in wstring in_faq_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteFaqInfo(
    java.lang.String in_faq_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryFaqList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryFaqList(
      in wstring in_faq_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryFaqList(
    java.lang.String in_faq_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryFaqInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryFaqInfo(
      in wstring in_faq_no,
      in wstring in_opr_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryFaqInfo(
    java.lang.String in_faq_no,
    java.lang.String in_opr_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getPlyAppStatictics</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getPlyAppStatictics(
      in string frm_plyapp_tm,
      in string to_plyapp_tm,
      in ::com::mcip::orb::Strings owned_dpt,
      in wstring frm_dpt,
      in wstring to_dpt,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in wstring in_cur_cde,
      in wstring in_site_cde,
      in wstring in_stat_type,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPlyAppStatictics(
    java.lang.String frm_plyapp_tm,
    java.lang.String to_plyapp_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_dpt,
    java.lang.String to_dpt,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String in_cur_cde,
    java.lang.String in_site_cde,
    java.lang.String in_stat_type,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getPolicyStatictics</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getPolicyStatictics(
      in string frm_plyapp_tm,
      in string to_plyapp_tm,
      in ::com::mcip::orb::Strings owned_dpt,
      in wstring frm_dpt,
      in wstring to_dpt,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in wstring in_cur_cde,
      in wstring in_site_cde,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyStatictics(
    java.lang.String frm_plyapp_tm,
    java.lang.String to_plyapp_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_dpt,
    java.lang.String to_dpt,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String in_cur_cde,
    java.lang.String in_site_cde,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getEdrPlcyStatictics</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getEdrPlcyStatictics(
      in string frm_edrapp_tm,
      in string to_edrapp_tm,
      in ::com::mcip::orb::Strings owned_dpt,
      in wstring frm_dpt,
      in wstring to_dpt,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in wstring in_cur_cde,
      in wstring in_site_cde,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEdrPlcyStatictics(
    java.lang.String frm_edrapp_tm,
    java.lang.String to_edrapp_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_dpt,
    java.lang.String to_dpt,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String in_cur_cde,
    java.lang.String in_site_cde,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getProposalStatictics</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getProposalStatictics(
      in string frm_plyapp_tm,
      in string to_plyapp_tm,
      in ::com::mcip::orb::Strings owned_dpt,
      in wstring frm_dpt,
      in wstring to_dpt,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in wstring in_cur_cde,
      in wstring in_site_cde,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getProposalStatictics(
    java.lang.String frm_plyapp_tm,
    java.lang.String to_plyapp_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_dpt,
    java.lang.String to_dpt,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String in_cur_cde,
    java.lang.String in_site_cde,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getCaseRptStatictics</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getCaseRptStatictics(
      in string frm_plyapp_tm,
      in string to_plyapp_tm,
      in ::com::mcip::orb::Strings owned_dpt,
      in wstring frm_dpt,
      in wstring to_dpt,
      in wstring frm_insrnc_cde,
      in wstring to_insrnc_cde,
      in wstring in_cur_cde,
      in wstring in_site_cde,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCaseRptStatictics(
    java.lang.String frm_plyapp_tm,
    java.lang.String to_plyapp_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_dpt,
    java.lang.String to_dpt,
    java.lang.String frm_insrnc_cde,
    java.lang.String to_insrnc_cde,
    java.lang.String in_cur_cde,
    java.lang.String in_site_cde,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getCustStatictics</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getCustStatictics(
      in string frm_crt_tm,
      in string to_crt_tm,
      in ::com::mcip::orb::Strings owned_dpt,
      in wstring frm_dpt,
      in wstring to_dpt,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCustStatictics(
    java.lang.String frm_crt_tm,
    java.lang.String to_crt_tm,
    java.lang.String[] owned_dpt,
    java.lang.String frm_dpt,
    java.lang.String to_dpt,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptClmDgst</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptClmDgst(
      in ::com::mcip::bus::orb::ClmDgstInfo clmdgstinfoobj,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptClmDgst(
    com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::updateClmDgst</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean updateClmDgst(
      in ::com::mcip::bus::orb::ClmDgstInfo clmdgstinfoobj,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateClmDgst(
    com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::deleteClmDgst</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean deleteClmDgst(
      in wstring in_rpt_no,
      in wstring in_ply_no,
      in wstring in_info_no,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteClmDgst(
    java.lang.String in_rpt_no,
    java.lang.String in_ply_no,
    java.lang.String in_info_no,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryClmDgstInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryClmDgstInfo(
      in wstring in_rpt_no,
      in wstring in_ply_no,
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryClmDgstInfo(
    java.lang.String in_rpt_no,
    java.lang.String in_ply_no,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::acceptChatCntnt</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    boolean acceptChatCntnt(
      in wstring in_bgn_tm,
      in wstring in_end_tm,
      in wstring in_chat_ttl,
      in ::com::mcip::orb::Strings chat_cntnt,
      in wstring in_chat_nme,
      in wstring in_chat_mrk
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptChatCntnt(
    java.lang.String in_bgn_tm,
    java.lang.String in_end_tm,
    java.lang.String in_chat_ttl,
    java.lang.String[] chat_cntnt,
    java.lang.String in_chat_nme,
    java.lang.String in_chat_mrk
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::queryChatCntnt</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss queryChatCntnt(
      in wstring in_chat_ttl,
      in wstring in_chat_mrk
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryChatCntnt(
    java.lang.String in_chat_ttl,
    java.lang.String in_chat_mrk
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getCustPlyAppList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getCustPlyAppList(
      in wstring in_user_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCustPlyAppList(
    java.lang.String in_user_id
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getCustPlySum</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getCustPlySum(
      in wstring in_user_id,
      in ::com::mcip::orb::Strings in_insrnc_cde,
      in wstring in_sum_tm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCustPlySum(
    java.lang.String in_user_id,
    java.lang.String[] in_insrnc_cde,
    java.lang.String in_sum_tm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::BusinessManager::getChatRight</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/BusinessManager"
    ::com::mcip::orb::Stringss getChatRight(
      in wstring in_emp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getChatRight(
    java.lang.String in_emp_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
}
