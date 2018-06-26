package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._PolicyManagerImplBase
<li> <b>Source File</b> com/mcip/nia/orb/_PolicyManagerImplBase.java
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
abstract public class _PolicyManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.nia.orb.PolicyManager {
  protected com.mcip.nia.orb.PolicyManager _wrapper = null;
  public com.mcip.nia.orb.PolicyManager _this() {
    return this;
  }
  protected _PolicyManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _PolicyManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.nia.orb.PolicyManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("acceptCaseRpt", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("acceptPolicyEdr", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("getPolicyEdr", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("withdrawalEdrApp", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("getEdrAppInfo", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("confirmEdrAppProposal", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("deleteEdrApp", 0, 6),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.nia.orb._PolicyManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.nia.orb.PolicyManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        com.mcip.nia.orb.CaseRptInfo caserptinfoobj;
        caserptinfoobj = com.mcip.nia.orb.CaseRptInfoHelper.read(_input);
        java.lang.String[][] _result = _self.acceptCaseRpt(caserptinfoobj);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 1: {
      try {
        com.mcip.nia.orb.PlyEdrAppInfo plyedrappinfoobj;
        plyedrappinfoobj = com.mcip.nia.orb.PlyEdrAppInfoHelper.read(_input);
        com.mcip.nia.orb.PlyEdrAppCrgoInfo plyedrappcrgoinfoobj;
        plyedrappcrgoinfoobj = com.mcip.nia.orb.PlyEdrAppCrgoInfoHelper.read(_input);
        java.lang.String[][] rdrinfo;
        rdrinfo = com.mcip.orb.StringssHelper.read(_input);
        com.mcip.nia.orb.PlyEdrAppPayInfo plyedrapppayinfoobj;
        plyedrapppayinfoobj = com.mcip.nia.orb.PlyEdrAppPayInfoHelper.read(_input);
        com.mcip.nia.orb.PlyPlyAppNetInfo plyplyappnetinfoobj;
        plyplyappnetinfoobj = com.mcip.nia.orb.PlyPlyAppNetInfoHelper.read(_input);
        java.lang.String[][] _result = _self.acceptPolicyEdr(plyedrappinfoobj,plyedrappcrgoinfoobj,rdrinfo,plyedrapppayinfoobj,plyplyappnetinfoobj);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 2: {
      try {
        com.mcip.nia.orb.PlyGetDocInfo plygetdocinfoobj;
        plygetdocinfoobj = com.mcip.nia.orb.PlyGetDocInfoHelper.read(_input);
        org.omg.CORBA.AnyHolder plyedrapp = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrappcrgo = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrapprdr = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrapppay = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyplyappnet = new org.omg.CORBA.AnyHolder();
        _self.getPolicyEdr(plygetdocinfoobj,plyedrapp,plyedrappcrgo,plyedrapprdr,plyedrapppay,plyplyappnet);
        _output.write_any(plyedrapp.value);
        _output.write_any(plyedrappcrgo.value);
        _output.write_any(plyedrapprdr.value);
        _output.write_any(plyedrapppay.value);
        _output.write_any(plyplyappnet.value);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 3: {
      try {
        java.lang.String edr_app_no;
        edr_app_no = _input.read_string();
        boolean _result = _self.withdrawalEdrApp(edr_app_no);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 4: {
      try {
        com.mcip.nia.orb.PlyEdrGridInfo plyedrgridinfoobj;
        plyedrgridinfoobj = com.mcip.nia.orb.PlyEdrGridInfoHelper.read(_input);
        org.omg.CORBA.AnyHolder plyedrapp = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrappcrgo = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrapprdr = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrapppay = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyplyappnet = new org.omg.CORBA.AnyHolder();
        _self.getEdrAppInfo(plyedrgridinfoobj,plyedrapp,plyedrappcrgo,plyedrapprdr,plyedrapppay,plyplyappnet);
        _output.write_any(plyedrapp.value);
        _output.write_any(plyedrappcrgo.value);
        _output.write_any(plyedrapprdr.value);
        _output.write_any(plyedrapppay.value);
        _output.write_any(plyplyappnet.value);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 5: {
      try {
        java.lang.String edrapp_no;
        edrapp_no = _input.read_string();
        java.lang.String dpt_cde;
        dpt_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.confirmEdrAppProposal(edrapp_no,dpt_cde,insrnc_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 6: {
      try {
        java.lang.String edr_app_no;
        edr_app_no = _input.read_string();
        boolean _result = _self.deleteEdrApp(edr_app_no);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
}
