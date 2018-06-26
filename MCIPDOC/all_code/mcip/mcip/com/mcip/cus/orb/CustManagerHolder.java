package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustManagerHolder
<li> <b>Source File</b> com/mcip/cus/orb/CustManagerHolder.java
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
final public class CustManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.cus.orb.CustManager value;
  public CustManagerHolder() {
  }
  public CustManagerHolder(com.mcip.cus.orb.CustManager value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.cus.orb.CustManagerHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.cus.orb.CustManagerHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.cus.orb.CustManagerHelper.type();
  }
}
