package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._tie_PolicyInfoManager
<li> <b>Source File</b> com/mcip/nia/orb/_tie_PolicyInfoManager.java
<li> <b>IDL Source File</b> policyInfoManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PolicyInfoManager
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PolicyInfoManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    interface PolicyInfoManager {
      ::com::mcip::orb::Stringss getOCList(
        in wstring user_id,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getOCInfo(
        in string OC_cde,
        in string insrnc_cde,
        in string crgo_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      wstring getPrintFormat(
        in wstring incondStr
      )
      raises(
        ::com::mcip::orb::CoException
      );
      wstring getPrintPolicy(
        in wstring incondStr
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyList(
        in wstring clnt_cde,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyInfo(
        in string agt_agr_cde,
        in string insrnc_cde,
        in string crgo_cde,
        in string crgo_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyPlcyList(
        in string agt_agr_cde,
        in string insrnc_cde,
        in string credit_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustPlcyList(
        in wstring user_id,
        in string insrnc_cde,
        in string credit_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyAppList(
        in wstring user_id,
        in string plyapp_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyAppInfo(
        in string plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyList(
        in wstring user_id,
        in string policy_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyInfo(
        in string policy_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyInfoLatest(
        in string policy_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalInfo(
        in string plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEndorseProposalInfo(
        in string edrapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppRdrInfo(
        in string in_plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyRdrInfo(
        in string in_ply_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptList(
        in wstring in_user_id,
        in string in_rpt_no,
        in string in_from_tm,
        in string in_to_tm,
        in string in_cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptInfo(
        in string in_rpt_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseClmList(
        in string in_rpt_no,
        in string in_status_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClaimList(
        in string in_clnt_cde,
        in string in_rpt_no,
        in string in_clm_no,
        in string in_from_tm,
        in string in_to_tm,
        in string in_status_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClmDgstList(
        in string in_rpt_no,
        in string in_ply_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getQuotation(
        in ::com::mcip::nia::orb::QuotaCndtn quotacndtnobj,
        in wstring rdr_type
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppNetAddress(
        in string cust_typ,
        in string in_clnt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClauseList(
        in wstring in_insrnc_cde,
        in wstring in_clause_cde,
        in wstring in_clnt_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalList(
        in wstring user_id,
        in string plyapp_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrAppList(
        in wstring user_id,
        in string edrapp_cde,
        in string ply_no,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrsmtList(
        in wstring user_id,
        in string edr_no,
        in string ply_no,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrsmtInfo(
        in string edr_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPreEdrInfo(
        in string edr_app_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean checkEdrApp(
        in string ply_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _tie_PolicyInfoManager extends com.mcip.nia.orb._PolicyInfoManagerImplBase {
  private com.mcip.nia.orb.PolicyInfoManagerOperations _delegate;
  public _tie_PolicyInfoManager(com.mcip.nia.orb.PolicyInfoManagerOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_PolicyInfoManager(com.mcip.nia.orb.PolicyInfoManagerOperations delegate) {
    this._delegate = delegate;
  }
  public com.mcip.nia.orb.PolicyInfoManagerOperations _delegate() {
    return this._delegate;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getOCList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getOCList(
      in wstring user_id,
      in string insrnc_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getOCList(
    java.lang.String user_id,
    java.lang.String insrnc_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getOCList(
      user_id,
      insrnc_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getOCInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getOCInfo(
      in string OC_cde,
      in string insrnc_cde,
      in string crgo_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getOCInfo(
    java.lang.String OC_cde,
    java.lang.String insrnc_cde,
    java.lang.String crgo_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getOCInfo(
      OC_cde,
      insrnc_cde,
      crgo_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPrintFormat</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    wstring getPrintFormat(
      in wstring incondStr
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String getPrintFormat(
    java.lang.String incondStr
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPrintFormat(
      incondStr
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPrintPolicy</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    wstring getPrintPolicy(
      in wstring incondStr
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String getPrintPolicy(
    java.lang.String incondStr
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPrintPolicy(
      incondStr
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getAgencyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getAgencyList(
      in wstring clnt_cde,
      in string insrnc_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAgencyList(
    java.lang.String clnt_cde,
    java.lang.String insrnc_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getAgencyList(
      clnt_cde,
      insrnc_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getAgencyInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getAgencyInfo(
      in string agt_agr_cde,
      in string insrnc_cde,
      in string crgo_cde,
      in string crgo_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAgencyInfo(
    java.lang.String agt_agr_cde,
    java.lang.String insrnc_cde,
    java.lang.String crgo_cde,
    java.lang.String crgo_typ
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getAgencyInfo(
      agt_agr_cde,
      insrnc_cde,
      crgo_cde,
      crgo_typ
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getAgencyPlcyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getAgencyPlcyList(
      in string agt_agr_cde,
      in string insrnc_cde,
      in string credit_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getAgencyPlcyList(
    java.lang.String agt_agr_cde,
    java.lang.String insrnc_cde,
    java.lang.String credit_id
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getAgencyPlcyList(
      agt_agr_cde,
      insrnc_cde,
      credit_id
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCustPlcyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCustPlcyList(
      in wstring user_id,
      in string insrnc_cde,
      in string credit_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCustPlcyList(
    java.lang.String user_id,
    java.lang.String insrnc_cde,
    java.lang.String credit_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getCustPlcyList(
      user_id,
      insrnc_cde,
      credit_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyAppList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyAppList(
      in wstring user_id,
      in string plyapp_cde,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyAppList(
    java.lang.String user_id,
    java.lang.String plyapp_cde,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPolicyAppList(
      user_id,
      plyapp_cde,
      app_from_tm,
      app_to_tm,
      cust_typ
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyAppInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyAppInfo(
      in string plyapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyAppInfo(
    java.lang.String plyapp_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPolicyAppInfo(
      plyapp_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyList(
      in wstring user_id,
      in string policy_cde,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyList(
    java.lang.String user_id,
    java.lang.String policy_cde,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPolicyList(
      user_id,
      policy_cde,
      app_from_tm,
      app_to_tm,
      cust_typ
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyInfo(
      in string policy_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyInfo(
    java.lang.String policy_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPolicyInfo(
      policy_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPolicyInfoLatest</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPolicyInfoLatest(
      in string policy_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPolicyInfoLatest(
    java.lang.String policy_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPolicyInfoLatest(
      policy_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getProposalInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getProposalInfo(
      in string plyapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getProposalInfo(
    java.lang.String plyapp_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getProposalInfo(
      plyapp_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEndorseProposalInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEndorseProposalInfo(
      in string edrapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEndorseProposalInfo(
    java.lang.String edrapp_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getEndorseProposalInfo(
      edrapp_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPlyAppRdrInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPlyAppRdrInfo(
      in string in_plyapp_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPlyAppRdrInfo(
    java.lang.String in_plyapp_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPlyAppRdrInfo(
      in_plyapp_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPlyRdrInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPlyRdrInfo(
      in string in_ply_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPlyRdrInfo(
    java.lang.String in_ply_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPlyRdrInfo(
      in_ply_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCaseRptList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCaseRptList(
      in wstring in_user_id,
      in string in_rpt_no,
      in string in_from_tm,
      in string in_to_tm,
      in string in_cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCaseRptList(
    java.lang.String in_user_id,
    java.lang.String in_rpt_no,
    java.lang.String in_from_tm,
    java.lang.String in_to_tm,
    java.lang.String in_cust_typ
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getCaseRptList(
      in_user_id,
      in_rpt_no,
      in_from_tm,
      in_to_tm,
      in_cust_typ
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCaseRptInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCaseRptInfo(
      in string in_rpt_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCaseRptInfo(
    java.lang.String in_rpt_no
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getCaseRptInfo(
      in_rpt_no
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getCaseClmList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getCaseClmList(
      in string in_rpt_no,
      in string in_status_mrk
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getCaseClmList(
    java.lang.String in_rpt_no,
    java.lang.String in_status_mrk
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getCaseClmList(
      in_rpt_no,
      in_status_mrk
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getClaimList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getClaimList(
      in string in_clnt_cde,
      in string in_rpt_no,
      in string in_clm_no,
      in string in_from_tm,
      in string in_to_tm,
      in string in_status_mrk
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getClaimList(
    java.lang.String in_clnt_cde,
    java.lang.String in_rpt_no,
    java.lang.String in_clm_no,
    java.lang.String in_from_tm,
    java.lang.String in_to_tm,
    java.lang.String in_status_mrk
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getClaimList(
      in_clnt_cde,
      in_rpt_no,
      in_clm_no,
      in_from_tm,
      in_to_tm,
      in_status_mrk
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getClmDgstList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getClmDgstList(
      in string in_rpt_no,
      in string in_ply_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getClmDgstList(
    java.lang.String in_rpt_no,
    java.lang.String in_ply_no
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getClmDgstList(
      in_rpt_no,
      in_ply_no
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getQuotation</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getQuotation(
      in ::com::mcip::nia::orb::QuotaCndtn quotacndtnobj,
      in wstring rdr_type
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getQuotation(
    com.mcip.nia.orb.QuotaCndtn quotacndtnobj,
    java.lang.String rdr_type
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getQuotation(
      quotacndtnobj,
      rdr_type
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPlyAppNetAddress</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPlyAppNetAddress(
      in string cust_typ,
      in string in_clnt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPlyAppNetAddress(
    java.lang.String cust_typ,
    java.lang.String in_clnt_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPlyAppNetAddress(
      cust_typ,
      in_clnt_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getClauseList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getClauseList(
      in wstring in_insrnc_cde,
      in wstring in_clause_cde,
      in wstring in_clnt_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getClauseList(
    java.lang.String in_insrnc_cde,
    java.lang.String in_clause_cde,
    java.lang.String in_clnt_cnm
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getClauseList(
      in_insrnc_cde,
      in_clause_cde,
      in_clnt_cnm
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getProposalList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getProposalList(
      in wstring user_id,
      in string plyapp_cde,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getProposalList(
    java.lang.String user_id,
    java.lang.String plyapp_cde,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getProposalList(
      user_id,
      plyapp_cde,
      app_from_tm,
      app_to_tm,
      cust_typ
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEdrAppList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEdrAppList(
      in wstring user_id,
      in string edrapp_cde,
      in string ply_no,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEdrAppList(
    java.lang.String user_id,
    java.lang.String edrapp_cde,
    java.lang.String ply_no,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getEdrAppList(
      user_id,
      edrapp_cde,
      ply_no,
      app_from_tm,
      app_to_tm,
      cust_typ
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEdrsmtList</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEdrsmtList(
      in wstring user_id,
      in string edr_no,
      in string ply_no,
      in string app_from_tm,
      in string app_to_tm,
      in string cust_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEdrsmtList(
    java.lang.String user_id,
    java.lang.String edr_no,
    java.lang.String ply_no,
    java.lang.String app_from_tm,
    java.lang.String app_to_tm,
    java.lang.String cust_typ
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getEdrsmtList(
      user_id,
      edr_no,
      ply_no,
      app_from_tm,
      app_to_tm,
      cust_typ
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getEdrsmtInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getEdrsmtInfo(
      in string edr_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getEdrsmtInfo(
    java.lang.String edr_no
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getEdrsmtInfo(
      edr_no
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::getPreEdrInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    ::com::mcip::orb::Stringss getPreEdrInfo(
      in string edr_app_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getPreEdrInfo(
    java.lang.String edr_app_no
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.getPreEdrInfo(
      edr_app_no
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyInfoManager::checkEdrApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyInfoManager"
    boolean checkEdrApp(
      in string ply_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean checkEdrApp(
    java.lang.String ply_no
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.checkEdrApp(
      ply_no
    );
  }
}
