package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PolicyAppManagerHolder
<li> <b>Source File</b> com/mcip/nia/orb/PolicyAppManagerHolder.java
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
final public class PolicyAppManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PolicyAppManager value;
  public PolicyAppManagerHolder() {
  }
  public PolicyAppManagerHolder(com.mcip.nia.orb.PolicyAppManager value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PolicyAppManagerHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PolicyAppManagerHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PolicyAppManagerHelper.type();
  }
}
