package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PolicyAppManagerHelper
<li> <b>Source File</b> com/mcip/nia/orb/PolicyAppManagerHelper.java
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
abstract public class PolicyAppManagerHelper {
  public static com.mcip.nia.orb.PolicyAppManager narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static com.mcip.nia.orb.PolicyAppManager narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof com.mcip.nia.orb.PolicyAppManager) {
      return (com.mcip.nia.orb.PolicyAppManager) object;
    }
    if(is_a || object._is_a(id())) {
      com.mcip.nia.orb._st_PolicyAppManager result = (com.mcip.nia.orb._st_PolicyAppManager)new com.mcip.nia.orb._st_PolicyAppManager();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (com.mcip.nia.orb.PolicyAppManager) result._this();
    }
    return null;
  }
  public static com.mcip.nia.orb.PolicyAppManager bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static com.mcip.nia.orb.PolicyAppManager bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static com.mcip.nia.orb.PolicyAppManager bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
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
  public static com.mcip.nia.orb.PolicyAppManager read(org.omg.CORBA.portable.InputStream _input) {
    return com.mcip.nia.orb.PolicyAppManagerHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PolicyAppManager value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PolicyAppManager value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PolicyAppManager extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "PolicyAppManager");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PolicyAppManager:1.0";
  }
}
