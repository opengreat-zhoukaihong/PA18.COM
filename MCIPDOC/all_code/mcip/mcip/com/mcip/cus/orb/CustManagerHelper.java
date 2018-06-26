package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb.CustManagerHelper
<li> <b>Source File</b> com/mcip/cus/orb/CustManagerHelper.java
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
abstract public class CustManagerHelper {
  public static com.mcip.cus.orb.CustManager narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static com.mcip.cus.orb.CustManager narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof com.mcip.cus.orb.CustManager) {
      return (com.mcip.cus.orb.CustManager) object;
    }
    if(is_a || object._is_a(id())) {
      com.mcip.cus.orb._st_CustManager result = (com.mcip.cus.orb._st_CustManager)new com.mcip.cus.orb._st_CustManager();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (com.mcip.cus.orb.CustManager) result._this();
    }
    return null;
  }
  public static com.mcip.cus.orb.CustManager bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static com.mcip.cus.orb.CustManager bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static com.mcip.cus.orb.CustManager bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
    if (orb instanceof com.visigenic.vbroker.orb.ORB) {
      return narrow(((com.visigenic.vbroker.orb.ORB)orb).bind(id(), name, host, options), true);
    }
    else {
      throw new org.omg.CORBA.BAD_PARAM();
    }
  }
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.cus.orb.CustManager read(org.omg.CORBA.portable.InputStream _input) {
    return com.mcip.cus.orb.CustManagerHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.cus.orb.CustManager value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.cus.orb.CustManager value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.cus.orb.CustManager extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "CustManager");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/cus/orb/CustManager:1.0";
  }
}
