package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._example_PolicyAppManager
<li> <b>Source File</b> com/mcip/nia/orb/_example_PolicyAppManager.java
<li> <b>IDL Source File</b> policyAppManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PolicyAppManager
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PolicyAppManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    interface PolicyAppManager {
      ::com::mcip::orb::Stringss acceptPolicyApp(
        in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
        in ::com::mcip::orb::Stringss rdrinfo
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean withdrawalPolicyApp(
        in string plcyapp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss updatePolicyApp(
        in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
        in ::com::mcip::orb::Stringss rdrinfo
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss confirmPolicyAppProposal(
        in string plcyapp_no,
        in string dpt_cde,
        in string insrnc_cde,
        in string undr_prsn
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptUserRemark(
        in string plcyapp_no,
        in string app_cde,
        in wstring user_remark,
        in string app_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deletePolicyApp(
        in string plcyapp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePayFlag(
        in string plcy_no,
        in string pay_flag,
        in string app_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _example_PolicyAppManager extends com.mcip.nia.orb._PolicyAppManagerImplBase {
  /** Construct a persistently named object. */
  public _example_PolicyAppManager(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_PolicyAppManager() {
    super();
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::acceptPolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    ::com::mcip::orb::Stringss acceptPolicyApp(
      in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
      in ::com::mcip::orb::Stringss rdrinfo
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] acceptPolicyApp(
    com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj,
    java.lang.String[][] rdrinfo
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::withdrawalPolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean withdrawalPolicyApp(
      in string plcyapp_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean withdrawalPolicyApp(
    java.lang.String plcyapp_no
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::updatePolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    ::com::mcip::orb::Stringss updatePolicyApp(
      in ::com::mcip::nia::orb::PlcyAppInfo plcyappinfoobj,
      in ::com::mcip::orb::Stringss rdrinfo
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] updatePolicyApp(
    com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj,
    java.lang.String[][] rdrinfo
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::confirmPolicyAppProposal</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    ::com::mcip::orb::Stringss confirmPolicyAppProposal(
      in string plcyapp_no,
      in string dpt_cde,
      in string insrnc_cde,
      in string undr_prsn
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] confirmPolicyAppProposal(
    java.lang.String plcyapp_no,
    java.lang.String dpt_cde,
    java.lang.String insrnc_cde,
    java.lang.String undr_prsn
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::acceptUserRemark</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean acceptUserRemark(
      in string plcyapp_no,
      in string app_cde,
      in wstring user_remark,
      in string app_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptUserRemark(
    java.lang.String plcyapp_no,
    java.lang.String app_cde,
    java.lang.String user_remark,
    java.lang.String app_typ
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::deletePolicyApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean deletePolicyApp(
      in string plcyapp_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deletePolicyApp(
    java.lang.String plcyapp_no
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyAppManager::updatePayFlag</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyAppManager"
    boolean updatePayFlag(
      in string plcy_no,
      in string pay_flag,
      in string app_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updatePayFlag(
    java.lang.String plcy_no,
    java.lang.String pay_flag,
    java.lang.String app_typ
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
}
