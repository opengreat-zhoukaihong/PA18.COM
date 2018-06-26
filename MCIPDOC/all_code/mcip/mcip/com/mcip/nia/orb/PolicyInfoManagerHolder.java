package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PolicyInfoManagerHolder
<li> <b>Source File</b> com/mcip/nia/orb/PolicyInfoManagerHolder.java
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
final public class PolicyInfoManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PolicyInfoManager value;
  public PolicyInfoManagerHolder() {
  }
  public PolicyInfoManagerHolder(com.mcip.nia.orb.PolicyInfoManager value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PolicyInfoManagerHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PolicyInfoManagerHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PolicyInfoManagerHelper.type();
  }
}
