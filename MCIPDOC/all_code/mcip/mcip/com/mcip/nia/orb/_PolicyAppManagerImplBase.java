package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._PolicyAppManagerImplBase
<li> <b>Source File</b> com/mcip/nia/orb/_PolicyAppManagerImplBase.java
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
abstract public class _PolicyAppManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.nia.orb.PolicyAppManager {
  protected com.mcip.nia.orb.PolicyAppManager _wrapper = null;
  public com.mcip.nia.orb.PolicyAppManager _this() {
    return this;
  }
  protected _PolicyAppManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _PolicyAppManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.nia.orb.PolicyAppManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyAppManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("acceptPolicyApp", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("withdrawalPolicyApp", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("updatePolicyApp", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("confirmPolicyAppProposal", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("acceptUserRemark", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("deletePolicyApp", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("updatePayFlag", 0, 6),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.nia.orb._PolicyAppManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.nia.orb.PolicyAppManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj;
        plcyappinfoobj = com.mcip.nia.orb.PlcyAppInfoHelper.read(_input);
        java.lang.String[][] rdrinfo;
        rdrinfo = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] _result = _self.acceptPolicyApp(plcyappinfoobj,rdrinfo);
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
        java.lang.String plcyapp_no;
        plcyapp_no = _input.read_string();
        boolean _result = _self.withdrawalPolicyApp(plcyapp_no);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 2: {
      try {
        com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj;
        plcyappinfoobj = com.mcip.nia.orb.PlcyAppInfoHelper.read(_input);
        java.lang.String[][] rdrinfo;
        rdrinfo = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] _result = _self.updatePolicyApp(plcyappinfoobj,rdrinfo);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 3: {
      try {
        java.lang.String plcyapp_no;
        plcyapp_no = _input.read_string();
        java.lang.String dpt_cde;
        dpt_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String undr_prsn;
        undr_prsn = _input.read_string();
        java.lang.String[][] _result = _self.confirmPolicyAppProposal(plcyapp_no,dpt_cde,insrnc_cde,undr_prsn);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 4: {
      try {
        java.lang.String plcyapp_no;
        plcyapp_no = _input.read_string();
        java.lang.String app_cde;
        app_cde = _input.read_string();
        java.lang.String user_remark;
        user_remark = _input.read_wstring();
        java.lang.String app_typ;
        app_typ = _input.read_string();
        boolean _result = _self.acceptUserRemark(plcyapp_no,app_cde,user_remark,app_typ);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 5: {
      try {
        java.lang.String plcyapp_no;
        plcyapp_no = _input.read_string();
        boolean _result = _self.deletePolicyApp(plcyapp_no);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 6: {
      try {
        java.lang.String plcy_no;
        plcy_no = _input.read_string();
        java.lang.String pay_flag;
        pay_flag = _input.read_string();
        java.lang.String app_typ;
        app_typ = _input.read_string();
        boolean _result = _self.updatePayFlag(plcy_no,pay_flag,app_typ);
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
