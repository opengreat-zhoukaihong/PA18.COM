package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PolicyManagerHolder
<li> <b>Source File</b> com/mcip/nia/orb/PolicyManagerHolder.java
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
final public class PolicyManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PolicyManager value;
  public PolicyManagerHolder() {
  }
  public PolicyManagerHolder(com.mcip.nia.orb.PolicyManager value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PolicyManagerHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PolicyManagerHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PolicyManagerHelper.type();
  }
}
