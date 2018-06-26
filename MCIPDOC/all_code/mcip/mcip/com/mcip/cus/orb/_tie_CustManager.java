package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb._tie_CustManager
<li> <b>Source File</b> com/mcip/cus/orb/_tie_CustManager.java
<li> <b>IDL Source File</b> custManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cus::orb::CustManager
<li> <b>Repository Identifier</b> IDL:com/mcip/cus/orb/CustManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cus/orb"
    interface CustManager {
      ::com::mcip::orb::Stringss customerLogin(
        in wstring usrname,
        in wstring passwd
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptOrgaCust(
        in string in_register_mrk,
        in ::com::mcip::cus::orb::CustOrgn custorgnobj,
        in ::com::mcip::cus::orb::CustEntity custentityobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPrsnCust(
        in string in_register_mrk,
        in ::com::mcip::cus::orb::CustPrsn custprsnobj,
        in ::com::mcip::cus::orb::CustEntity custentityobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteIllegalUser(
        in string user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptAgntCust(
        in ::com::mcip::cus::orb::CustEntity custentityobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateOrgaCust(
        in ::com::mcip::cus::orb::CustOrgn custorgnobj,
        in wstring cust_user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePrsnCust(
        in ::com::mcip::cus::orb::CustPrsn custprsnobj,
        in wstring cust_user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateEnttCust(
        in ::com::mcip::cus::orb::CustEntity custentityobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryCustEntt(
        in wstring in_account_info
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryCustOrgn(
        in wstring in_account_info
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryCustPrsn(
        in wstring in_account_info
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryCustAgnt(
        in wstring in_account_info
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss requireCust(
        in string in_user_mrk,
        in wstring in_user_id,
        in wstring in_register_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean checkProposal(
        in wstring user_id,
        in string cust_type
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryAgencyInfo(
        in wstring in_agent_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOCcustInfo(
        in wstring in_clnt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptOCCust(
        in string in_register_mrk,
        in ::com::mcip::cus::orb::CustOrgn custorgnobj,
        in ::com::mcip::cus::orb::CustEntity custentityobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptAGCust(
        in string in_register_mrk,
        in ::com::mcip::cus::orb::CustOrgn custorgnobj,
        in ::com::mcip::cus::orb::CustEntity custentityobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _tie_CustManager extends com.mcip.cus.orb._CustManagerImplBase {
  private com.mcip.cus.orb.CustManagerOperations _delegate;
  public _tie_CustManager(com.mcip.cus.orb.CustManagerOperations delegate, java.lang.String name) {
    super(name);
    this._delegate = delegate;
  }
  public _tie_CustManager(com.mcip.cus.orb.CustManagerOperations delegate) {
    this._delegate = delegate;
  }
  public com.mcip.cus.orb.CustManagerOperations _delegate() {
    return this._delegate;
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::customerLogin</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss customerLogin(
      in wstring usrname,
      in wstring passwd
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] customerLogin(
    java.lang.String usrname,
    java.lang.String passwd
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.customerLogin(
      usrname,
      passwd
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::acceptOrgaCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean acceptOrgaCust(
      in string in_register_mrk,
      in ::com::mcip::cus::orb::CustOrgn custorgnobj,
      in ::com::mcip::cus::orb::CustEntity custentityobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptOrgaCust(
    java.lang.String in_register_mrk,
    com.mcip.cus.orb.CustOrgn custorgnobj,
    com.mcip.cus.orb.CustEntity custentityobj
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.acceptOrgaCust(
      in_register_mrk,
      custorgnobj,
      custentityobj
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::acceptPrsnCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean acceptPrsnCust(
      in string in_register_mrk,
      in ::com::mcip::cus::orb::CustPrsn custprsnobj,
      in ::com::mcip::cus::orb::CustEntity custentityobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptPrsnCust(
    java.lang.String in_register_mrk,
    com.mcip.cus.orb.CustPrsn custprsnobj,
    com.mcip.cus.orb.CustEntity custentityobj
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.acceptPrsnCust(
      in_register_mrk,
      custprsnobj,
      custentityobj
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::deleteIllegalUser</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean deleteIllegalUser(
      in string user_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteIllegalUser(
    java.lang.String user_id
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.deleteIllegalUser(
      user_id
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::acceptAgntCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean acceptAgntCust(
      in ::com::mcip::cus::orb::CustEntity custentityobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptAgntCust(
    com.mcip.cus.orb.CustEntity custentityobj
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.acceptAgntCust(
      custentityobj
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::updateOrgaCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean updateOrgaCust(
      in ::com::mcip::cus::orb::CustOrgn custorgnobj,
      in wstring cust_user_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateOrgaCust(
    com.mcip.cus.orb.CustOrgn custorgnobj,
    java.lang.String cust_user_id
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.updateOrgaCust(
      custorgnobj,
      cust_user_id
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::updatePrsnCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean updatePrsnCust(
      in ::com::mcip::cus::orb::CustPrsn custprsnobj,
      in wstring cust_user_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updatePrsnCust(
    com.mcip.cus.orb.CustPrsn custprsnobj,
    java.lang.String cust_user_id
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.updatePrsnCust(
      custprsnobj,
      cust_user_id
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::updateEnttCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean updateEnttCust(
      in ::com::mcip::cus::orb::CustEntity custentityobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateEnttCust(
    com.mcip.cus.orb.CustEntity custentityobj
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.updateEnttCust(
      custentityobj
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::queryCustEntt</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss queryCustEntt(
      in wstring in_account_info
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryCustEntt(
    java.lang.String in_account_info
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.queryCustEntt(
      in_account_info
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::queryCustOrgn</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss queryCustOrgn(
      in wstring in_account_info
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryCustOrgn(
    java.lang.String in_account_info
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.queryCustOrgn(
      in_account_info
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::queryCustPrsn</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss queryCustPrsn(
      in wstring in_account_info
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryCustPrsn(
    java.lang.String in_account_info
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.queryCustPrsn(
      in_account_info
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::queryCustAgnt</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss queryCustAgnt(
      in wstring in_account_info
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryCustAgnt(
    java.lang.String in_account_info
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.queryCustAgnt(
      in_account_info
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::requireCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss requireCust(
      in string in_user_mrk,
      in wstring in_user_id,
      in wstring in_register_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] requireCust(
    java.lang.String in_user_mrk,
    java.lang.String in_user_id,
    java.lang.String in_register_id
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.requireCust(
      in_user_mrk,
      in_user_id,
      in_register_id
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::checkProposal</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean checkProposal(
      in wstring user_id,
      in string cust_type
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean checkProposal(
    java.lang.String user_id,
    java.lang.String cust_type
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.checkProposal(
      user_id,
      cust_type
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::queryAgencyInfo</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss queryAgencyInfo(
      in wstring in_agent_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryAgencyInfo(
    java.lang.String in_agent_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.queryAgencyInfo(
      in_agent_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::queryOCcustInfo</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    ::com::mcip::orb::Stringss queryOCcustInfo(
      in wstring in_clnt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryOCcustInfo(
    java.lang.String in_clnt_cde
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.queryOCcustInfo(
      in_clnt_cde
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::acceptOCCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean acceptOCCust(
      in string in_register_mrk,
      in ::com::mcip::cus::orb::CustOrgn custorgnobj,
      in ::com::mcip::cus::orb::CustEntity custentityobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptOCCust(
    java.lang.String in_register_mrk,
    com.mcip.cus.orb.CustOrgn custorgnobj,
    com.mcip.cus.orb.CustEntity custentityobj
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.acceptOCCust(
      in_register_mrk,
      custorgnobj,
      custentityobj
    );
  }
  /**
  <p>
  Operation: <b>::com::mcip::cus::orb::CustManager::acceptAGCust</b>.
  <pre>
    #pragma prefix "com/mcip/cus/orb/CustManager"
    boolean acceptAGCust(
      in string in_register_mrk,
      in ::com::mcip::cus::orb::CustOrgn custorgnobj,
      in ::com::mcip::cus::orb::CustEntity custentityobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptAGCust(
    java.lang.String in_register_mrk,
    com.mcip.cus.orb.CustOrgn custorgnobj,
    com.mcip.cus.orb.CustEntity custentityobj
  ) throws
    com.mcip.orb.CoException {
    return this._delegate.acceptAGCust(
      in_register_mrk,
      custorgnobj,
      custentityobj
    );
  }
}
