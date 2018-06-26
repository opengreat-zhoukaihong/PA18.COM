package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._example_PolicyManager
<li> <b>Source File</b> com/mcip/nia/orb/_example_PolicyManager.java
<li> <b>IDL Source File</b> policyManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PolicyManager
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PolicyManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    interface PolicyManager {
      ::com::mcip::orb::Stringss acceptCaseRpt(
        in ::com::mcip::nia::orb::CaseRptInfo caserptinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss acceptPolicyEdr(
        in ::com::mcip::nia::orb::PlyEdrAppInfo plyedrappinfoobj,
        in ::com::mcip::nia::orb::PlyEdrAppCrgoInfo plyedrappcrgoinfoobj,
        in ::com::mcip::orb::Stringss rdrinfo,
        in ::com::mcip::nia::orb::PlyEdrAppPayInfo plyedrapppayinfoobj,
        in ::com::mcip::nia::orb::PlyPlyAppNetInfo plyplyappnetinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      void getPolicyEdr(
        in ::com::mcip::nia::orb::PlyGetDocInfo plygetdocinfoobj,
        out any plyedrapp,
        out any plyedrappcrgo,
        out any plyedrapprdr,
        out any plyedrapppay,
        out any plyplyappnet
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean withdrawalEdrApp(
        in string edr_app_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      void getEdrAppInfo(
        in ::com::mcip::nia::orb::PlyEdrGridInfo plyedrgridinfoobj,
        out any plyedrapp,
        out any plyedrappcrgo,
        out any plyedrapprdr,
        out any plyedrapppay,
        out any plyplyappnet
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss confirmEdrAppProposal(
        in string edrapp_no,
        in string dpt_cde,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteEdrApp(
        in string edr_app_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
public class _example_PolicyManager extends com.mcip.nia.orb._PolicyManagerImplBase {
  /** Construct a persistently named object. */
  public _example_PolicyManager(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_PolicyManager() {
    super();
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::acceptCaseRpt</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    ::com::mcip::orb::Stringss acceptCaseRpt(
      in ::com::mcip::nia::orb::CaseRptInfo caserptinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] acceptCaseRpt(
    com.mcip.nia.orb.CaseRptInfo caserptinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::acceptPolicyEdr</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    ::com::mcip::orb::Stringss acceptPolicyEdr(
      in ::com::mcip::nia::orb::PlyEdrAppInfo plyedrappinfoobj,
      in ::com::mcip::nia::orb::PlyEdrAppCrgoInfo plyedrappcrgoinfoobj,
      in ::com::mcip::orb::Stringss rdrinfo,
      in ::com::mcip::nia::orb::PlyEdrAppPayInfo plyedrapppayinfoobj,
      in ::com::mcip::nia::orb::PlyPlyAppNetInfo plyplyappnetinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] acceptPolicyEdr(
    com.mcip.nia.orb.PlyEdrAppInfo plyedrappinfoobj,
    com.mcip.nia.orb.PlyEdrAppCrgoInfo plyedrappcrgoinfoobj,
    java.lang.String[][] rdrinfo,
    com.mcip.nia.orb.PlyEdrAppPayInfo plyedrapppayinfoobj,
    com.mcip.nia.orb.PlyPlyAppNetInfo plyplyappnetinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::getPolicyEdr</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    void getPolicyEdr(
      in ::com::mcip::nia::orb::PlyGetDocInfo plygetdocinfoobj,
      out any plyedrapp,
      out any plyedrappcrgo,
      out any plyedrapprdr,
      out any plyedrapppay,
      out any plyplyappnet
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public void getPolicyEdr(
    com.mcip.nia.orb.PlyGetDocInfo plygetdocinfoobj,
    org.omg.CORBA.AnyHolder plyedrapp,
    org.omg.CORBA.AnyHolder plyedrappcrgo,
    org.omg.CORBA.AnyHolder plyedrapprdr,
    org.omg.CORBA.AnyHolder plyedrapppay,
    org.omg.CORBA.AnyHolder plyplyappnet
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::withdrawalEdrApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    boolean withdrawalEdrApp(
      in string edr_app_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean withdrawalEdrApp(
    java.lang.String edr_app_no
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::getEdrAppInfo</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    void getEdrAppInfo(
      in ::com::mcip::nia::orb::PlyEdrGridInfo plyedrgridinfoobj,
      out any plyedrapp,
      out any plyedrappcrgo,
      out any plyedrapprdr,
      out any plyedrapppay,
      out any plyplyappnet
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public void getEdrAppInfo(
    com.mcip.nia.orb.PlyEdrGridInfo plyedrgridinfoobj,
    org.omg.CORBA.AnyHolder plyedrapp,
    org.omg.CORBA.AnyHolder plyedrappcrgo,
    org.omg.CORBA.AnyHolder plyedrapprdr,
    org.omg.CORBA.AnyHolder plyedrapppay,
    org.omg.CORBA.AnyHolder plyplyappnet
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::confirmEdrAppProposal</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    ::com::mcip::orb::Stringss confirmEdrAppProposal(
      in string edrapp_no,
      in string dpt_cde,
      in string insrnc_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] confirmEdrAppProposal(
    java.lang.String edrapp_no,
    java.lang.String dpt_cde,
    java.lang.String insrnc_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::nia::orb::PolicyManager::deleteEdrApp</b>.
  <pre>
    #pragma prefix "com/mcip/nia/orb/PolicyManager"
    boolean deleteEdrApp(
      in string edr_app_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteEdrApp(
    java.lang.String edr_app_no
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
}
