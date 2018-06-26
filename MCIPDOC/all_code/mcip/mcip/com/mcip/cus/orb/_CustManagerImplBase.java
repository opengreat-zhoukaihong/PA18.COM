package com.mcip.cus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cus.orb._CustManagerImplBase
<li> <b>Source File</b> com/mcip/cus/orb/_CustManagerImplBase.java
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
abstract public class _CustManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.cus.orb.CustManager {
  protected com.mcip.cus.orb.CustManager _wrapper = null;
  public com.mcip.cus.orb.CustManager _this() {
    return this;
  }
  protected _CustManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _CustManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.cus.orb.CustManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/cus/orb/CustManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("customerLogin", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("acceptOrgaCust", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("acceptPrsnCust", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("deleteIllegalUser", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("acceptAgntCust", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("updateOrgaCust", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("updatePrsnCust", 0, 6),
      new org.omg.CORBA.portable.MethodPointer("updateEnttCust", 0, 7),
      new org.omg.CORBA.portable.MethodPointer("queryCustEntt", 0, 8),
      new org.omg.CORBA.portable.MethodPointer("queryCustOrgn", 0, 9),
      new org.omg.CORBA.portable.MethodPointer("queryCustPrsn", 0, 10),
      new org.omg.CORBA.portable.MethodPointer("queryCustAgnt", 0, 11),
      new org.omg.CORBA.portable.MethodPointer("requireCust", 0, 12),
      new org.omg.CORBA.portable.MethodPointer("checkProposal", 0, 13),
      new org.omg.CORBA.portable.MethodPointer("queryAgencyInfo", 0, 14),
      new org.omg.CORBA.portable.MethodPointer("queryOCcustInfo", 0, 15),
      new org.omg.CORBA.portable.MethodPointer("acceptOCCust", 0, 16),
      new org.omg.CORBA.portable.MethodPointer("acceptAGCust", 0, 17),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.cus.orb._CustManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.cus.orb.CustManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        java.lang.String usrname;
        usrname = _input.read_wstring();
        java.lang.String passwd;
        passwd = _input.read_wstring();
        java.lang.String[][] _result = _self.customerLogin(usrname,passwd);
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
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptOrgaCust(in_register_mrk,custorgnobj,custentityobj);
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
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustPrsn custprsnobj;
        custprsnobj = com.mcip.cus.orb.CustPrsnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptPrsnCust(in_register_mrk,custprsnobj,custentityobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 3: {
      try {
        java.lang.String user_id;
        user_id = _input.read_string();
        boolean _result = _self.deleteIllegalUser(user_id);
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
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptAgntCust(custentityobj);
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
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        java.lang.String cust_user_id;
        cust_user_id = _input.read_wstring();
        boolean _result = _self.updateOrgaCust(custorgnobj,cust_user_id);
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
        com.mcip.cus.orb.CustPrsn custprsnobj;
        custprsnobj = com.mcip.cus.orb.CustPrsnHelper.read(_input);
        java.lang.String cust_user_id;
        cust_user_id = _input.read_wstring();
        boolean _result = _self.updatePrsnCust(custprsnobj,cust_user_id);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 7: {
      try {
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.updateEnttCust(custentityobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 8: {
      try {
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustEntt(in_account_info);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 9: {
      try {
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustOrgn(in_account_info);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 10: {
      try {
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustPrsn(in_account_info);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 11: {
      try {
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustAgnt(in_account_info);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 12: {
      try {
        java.lang.String in_user_mrk;
        in_user_mrk = _input.read_string();
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String in_register_id;
        in_register_id = _input.read_wstring();
        java.lang.String[][] _result = _self.requireCust(in_user_mrk,in_user_id,in_register_id);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 13: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String cust_type;
        cust_type = _input.read_string();
        boolean _result = _self.checkProposal(user_id,cust_type);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 14: {
      try {
        java.lang.String in_agent_cde;
        in_agent_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryAgencyInfo(in_agent_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 15: {
      try {
        java.lang.String in_clnt_cde;
        in_clnt_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOCcustInfo(in_clnt_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 16: {
      try {
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptOCCust(in_register_mrk,custorgnobj,custentityobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 17: {
      try {
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptAGCust(in_register_mrk,custorgnobj,custentityobj);
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
