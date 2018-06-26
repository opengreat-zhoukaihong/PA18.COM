package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PolicyManagerHelper
<li> <b>Source File</b> com/mcip/nia/orb/PolicyManagerHelper.java
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
abstract public class PolicyManagerHelper {
  public static com.mcip.nia.orb.PolicyManager narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static com.mcip.nia.orb.PolicyManager narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof com.mcip.nia.orb.PolicyManager) {
      return (com.mcip.nia.orb.PolicyManager) object;
    }
    if(is_a || object._is_a(id())) {
      com.mcip.nia.orb._st_PolicyManager result = (com.mcip.nia.orb._st_PolicyManager)new com.mcip.nia.orb._st_PolicyManager();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (com.mcip.nia.orb.PolicyManager) result._this();
    }
    return null;
  }
  public static com.mcip.nia.orb.PolicyManager bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static com.mcip.nia.orb.PolicyManager bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static com.mcip.nia.orb.PolicyManager bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
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
  public static com.mcip.nia.orb.PolicyManager read(org.omg.CORBA.portable.InputStream _input) {
    return com.mcip.nia.orb.PolicyManagerHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.nia.orb.PolicyManager value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.nia.orb.PolicyManager value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.nia.orb.PolicyManager extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "PolicyManager");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/nia/orb/PolicyManager:1.0";
  }
}
