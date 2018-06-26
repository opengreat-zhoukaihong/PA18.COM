package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb._UserManagerImplBase
<li> <b>Source File</b> com/mcip/bus/orb/_UserManagerImplBase.java
<li> <b>IDL Source File</b> userManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::UserManager
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/UserManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    interface UserManager {
      ::com::mcip::orb::Stringss operatorLogin(
        in wstring usrname,
        in wstring passwd
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptOperator(
        in ::com::mcip::bus::orb::OperatorInfo operatorinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateOperator(
        in ::com::mcip::bus::orb::OperatorInfo operatorinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteOperator(
        in string auth_dpt_cde,
        in wstring auth_opr_cde,
        in wstring del_opr_cde,
        in string rcsv_del_flg
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrInfo(
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrList(
        in wstring in_opr_cde,
        in string in_emp_cde,
        in wstring adm_opr_cde,
        in string adm_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryAuthList(
        in wstring in_opr_cde,
        in string in_emp_cde,
        in wstring adm_opr_cde,
        in string adm_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptOptrAuth(
        in ::com::mcip::orb::Stringss oprauthInfoobj,
        in ::com::mcip::orb::Stringss oprdptinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateOptrAuth(
        in ::com::mcip::orb::Stringss oprauthInfoobj,
        in ::com::mcip::orb::Stringss oprdptinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteOptrAuth(
        in wstring in_opr_cde,
        in wstring in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrDptList(
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryAbleDptList(
        in wstring in_opr_cde,
        in wstring auth_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptSysFunc(
        in ::com::mcip::bus::orb::SysFuncInfo sysfuncinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateSysFunc(
        in ::com::mcip::bus::orb::SysFuncInfo sysfuncinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteSysFunc(
        in wstring in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySysFuncList(
        in string in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPagesInfo(
        in ::com::mcip::bus::orb::PagesInfo pagesinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePagesInfo(
        in ::com::mcip::bus::orb::PagesInfo pagesinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deletePagesInfo(
        in string in_page_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPagesList(
        in string in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean executeOptrAuth(
        in string act_typ,
        in wstring auth_opr_cde,
        in wstring in_opr_cde,
        in ::com::mcip::orb::Stringss oprauthInfo,
        in ::com::mcip::orb::Stringss oprdptinfo
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean checkOptrAuth(
        in wstring in_optr_cde,
        in string in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryCustEnttList(
        in wstring in_opr_cde,
        in string in_verify_flg,
        in ::com::mcip::orb::Strings in_dpt_cde,
        in string frm_crt_tm,
        in string to_crt_tm,
        in string frm_verify_tm,
        in string to_verify_tm,
        in long frm_ltimes,
        in long to_ltimes,
        in wstring in_user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySameCustList(
        in wstring in_clnt_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptUserVerify(
        in wstring in_user_id,
        in string in_clnt_cde,
        in string in_cmpny_agt_cde,
        in string in_verify_flg,
        in wstring in_vrfy_desc,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean replaceAuthOptr(
        in wstring org_optr_cde,
        in wstring trgt_optr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean compareAuthDptOptr(
        in wstring org_optr_cde,
        in wstring trgt_optr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrAuthList(
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySubDptList(
        in wstring in_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptClntMapInfo(
        in wstring opr_cde,
        in string clnt_agt_flg,
        in wstring user_id,
        in string clnt_cde,
        in wstring main_flg
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateClntMapInfo(
        in wstring opr_cde,
        in string clnt_agt_flg,
        in wstring new_user_id,
        in string new_clnt_cde,
        in wstring main_flg,
        in wstring old_user_id,
        in string old_clnt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteClntMapInfo(
        in wstring opr_cde,
        in wstring user_id,
        in string clnt_cde,
        in string clnt_agt_flg
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryClntMapList(
        in wstring opr_cde,
        in wstring user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean executeSysadmAuth(
        in string act_typ,
        in wstring auth_opr_cde,
        in wstring in_opr_cde,
        in wstring in_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getDptCEnm(
        in wstring dpt_cde,
        in wstring cenm_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptSuppEmail(
        in wstring emp_cde,
        in wstring emp_nme,
        in wstring dpt_cde,
        in wstring emp_type,
        in wstring emp_email
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateSuppEmail(
        in wstring emp_cde,
        in wstring emp_nme,
        in wstring dpt_cde,
        in wstring emp_type,
        in wstring emp_email,
        in wstring supp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteSuppEmail(
        in wstring supp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySuppEmailList(
        in wstring emp_nme,
        in ::com::mcip::orb::Strings dpt_cde,
        in wstring emp_type
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
abstract public class _UserManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.bus.orb.UserManager {
  protected com.mcip.bus.orb.UserManager _wrapper = null;
  public com.mcip.bus.orb.UserManager _this() {
    return this;
  }
  protected _UserManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _UserManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.bus.orb.UserManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/bus/orb/UserManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("operatorLogin", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("acceptOperator", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("updateOperator", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("deleteOperator", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("queryOptrInfo", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("queryOptrList", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("queryAuthList", 0, 6),
      new org.omg.CORBA.portable.MethodPointer("acceptOptrAuth", 0, 7),
      new org.omg.CORBA.portable.MethodPointer("updateOptrAuth", 0, 8),
      new org.omg.CORBA.portable.MethodPointer("deleteOptrAuth", 0, 9),
      new org.omg.CORBA.portable.MethodPointer("queryOptrDptList", 0, 10),
      new org.omg.CORBA.portable.MethodPointer("queryAbleDptList", 0, 11),
      new org.omg.CORBA.portable.MethodPointer("acceptSysFunc", 0, 12),
      new org.omg.CORBA.portable.MethodPointer("updateSysFunc", 0, 13),
      new org.omg.CORBA.portable.MethodPointer("deleteSysFunc", 0, 14),
      new org.omg.CORBA.portable.MethodPointer("querySysFuncList", 0, 15),
      new org.omg.CORBA.portable.MethodPointer("acceptPagesInfo", 0, 16),
      new org.omg.CORBA.portable.MethodPointer("updatePagesInfo", 0, 17),
      new org.omg.CORBA.portable.MethodPointer("deletePagesInfo", 0, 18),
      new org.omg.CORBA.portable.MethodPointer("queryPagesList", 0, 19),
      new org.omg.CORBA.portable.MethodPointer("executeOptrAuth", 0, 20),
      new org.omg.CORBA.portable.MethodPointer("checkOptrAuth", 0, 21),
      new org.omg.CORBA.portable.MethodPointer("queryCustEnttList", 0, 22),
      new org.omg.CORBA.portable.MethodPointer("querySameCustList", 0, 23),
      new org.omg.CORBA.portable.MethodPointer("acceptUserVerify", 0, 24),
      new org.omg.CORBA.portable.MethodPointer("replaceAuthOptr", 0, 25),
      new org.omg.CORBA.portable.MethodPointer("compareAuthDptOptr", 0, 26),
      new org.omg.CORBA.portable.MethodPointer("queryOptrAuthList", 0, 27),
      new org.omg.CORBA.portable.MethodPointer("querySubDptList", 0, 28),
      new org.omg.CORBA.portable.MethodPointer("acceptClntMapInfo", 0, 29),
      new org.omg.CORBA.portable.MethodPointer("updateClntMapInfo", 0, 30),
      new org.omg.CORBA.portable.MethodPointer("deleteClntMapInfo", 0, 31),
      new org.omg.CORBA.portable.MethodPointer("queryClntMapList", 0, 32),
      new org.omg.CORBA.portable.MethodPointer("executeSysadmAuth", 0, 33),
      new org.omg.CORBA.portable.MethodPointer("getDptCEnm", 0, 34),
      new org.omg.CORBA.portable.MethodPointer("acceptSuppEmail", 0, 35),
      new org.omg.CORBA.portable.MethodPointer("updateSuppEmail", 0, 36),
      new org.omg.CORBA.portable.MethodPointer("deleteSuppEmail", 0, 37),
      new org.omg.CORBA.portable.MethodPointer("querySuppEmailList", 0, 38),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.bus.orb._UserManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.bus.orb.UserManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        java.lang.String usrname;
        usrname = _input.read_wstring();
        java.lang.String passwd;
        passwd = _input.read_wstring();
        java.lang.String[][] _result = _self.operatorLogin(usrname,passwd);
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
        com.mcip.bus.orb.OperatorInfo operatorinfoobj;
        operatorinfoobj = com.mcip.bus.orb.OperatorInfoHelper.read(_input);
        boolean _result = _self.acceptOperator(operatorinfoobj);
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
        com.mcip.bus.orb.OperatorInfo operatorinfoobj;
        operatorinfoobj = com.mcip.bus.orb.OperatorInfoHelper.read(_input);
        boolean _result = _self.updateOperator(operatorinfoobj);
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
        java.lang.String auth_dpt_cde;
        auth_dpt_cde = _input.read_string();
        java.lang.String auth_opr_cde;
        auth_opr_cde = _input.read_wstring();
        java.lang.String del_opr_cde;
        del_opr_cde = _input.read_wstring();
        java.lang.String rcsv_del_flg;
        rcsv_del_flg = _input.read_string();
        boolean _result = _self.deleteOperator(auth_dpt_cde,auth_opr_cde,del_opr_cde,rcsv_del_flg);
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
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOptrInfo(in_opr_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 5: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String in_emp_cde;
        in_emp_cde = _input.read_string();
        java.lang.String adm_opr_cde;
        adm_opr_cde = _input.read_wstring();
        java.lang.String adm_dpt_cde;
        adm_dpt_cde = _input.read_string();
        java.lang.String[][] _result = _self.queryOptrList(in_opr_cde,in_emp_cde,adm_opr_cde,adm_dpt_cde);
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
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String in_emp_cde;
        in_emp_cde = _input.read_string();
        java.lang.String adm_opr_cde;
        adm_opr_cde = _input.read_wstring();
        java.lang.String adm_dpt_cde;
        adm_dpt_cde = _input.read_string();
        java.lang.String[][] _result = _self.queryAuthList(in_opr_cde,in_emp_cde,adm_opr_cde,adm_dpt_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 7: {
      try {
        java.lang.String[][] oprauthInfoobj;
        oprauthInfoobj = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] oprdptinfoobj;
        oprdptinfoobj = com.mcip.orb.StringssHelper.read(_input);
        boolean _result = _self.acceptOptrAuth(oprauthInfoobj,oprdptinfoobj);
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
        java.lang.String[][] oprauthInfoobj;
        oprauthInfoobj = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] oprdptinfoobj;
        oprdptinfoobj = com.mcip.orb.StringssHelper.read(_input);
        boolean _result = _self.updateOptrAuth(oprauthInfoobj,oprdptinfoobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 9: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String in_func_cde;
        in_func_cde = _input.read_wstring();
        boolean _result = _self.deleteOptrAuth(in_opr_cde,in_func_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 10: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOptrDptList(in_opr_cde);
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
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String auth_opr_cde;
        auth_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryAbleDptList(in_opr_cde,auth_opr_cde);
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
        com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj;
        sysfuncinfoobj = com.mcip.bus.orb.SysFuncInfoHelper.read(_input);
        boolean _result = _self.acceptSysFunc(sysfuncinfoobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 13: {
      try {
        com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj;
        sysfuncinfoobj = com.mcip.bus.orb.SysFuncInfoHelper.read(_input);
        boolean _result = _self.updateSysFunc(sysfuncinfoobj);
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
        java.lang.String in_func_cde;
        in_func_cde = _input.read_wstring();
        boolean _result = _self.deleteSysFunc(in_func_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 15: {
      try {
        java.lang.String in_func_cde;
        in_func_cde = _input.read_string();
        java.lang.String[][] _result = _self.querySysFuncList(in_func_cde);
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
        com.mcip.bus.orb.PagesInfo pagesinfoobj;
        pagesinfoobj = com.mcip.bus.orb.PagesInfoHelper.read(_input);
        boolean _result = _self.acceptPagesInfo(pagesinfoobj);
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
        com.mcip.bus.orb.PagesInfo pagesinfoobj;
        pagesinfoobj = com.mcip.bus.orb.PagesInfoHelper.read(_input);
        boolean _result = _self.updatePagesInfo(pagesinfoobj);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 18: {
      try {
        java.lang.String in_page_no;
        in_page_no = _input.read_string();
        boolean _result = _self.deletePagesInfo(in_page_no);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 19: {
      try {
        java.lang.String in_func_cde;
        in_func_cde = _input.read_string();
        java.lang.String[][] _result = _self.queryPagesList(in_func_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 20: {
      try {
        java.lang.String act_typ;
        act_typ = _input.read_string();
        java.lang.String auth_opr_cde;
        auth_opr_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] oprauthInfo;
        oprauthInfo = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] oprdptinfo;
        oprdptinfo = com.mcip.orb.StringssHelper.read(_input);
        boolean _result = _self.executeOptrAuth(act_typ,auth_opr_cde,in_opr_cde,oprauthInfo,oprdptinfo);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 21: {
      try {
        java.lang.String in_optr_cde;
        in_optr_cde = _input.read_wstring();
        java.lang.String in_func_cde;
        in_func_cde = _input.read_string();
        boolean _result = _self.checkOptrAuth(in_optr_cde,in_func_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 22: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String in_verify_flg;
        in_verify_flg = _input.read_string();
        java.lang.String[] in_dpt_cde;
        in_dpt_cde = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_crt_tm;
        frm_crt_tm = _input.read_string();
        java.lang.String to_crt_tm;
        to_crt_tm = _input.read_string();
        java.lang.String frm_verify_tm;
        frm_verify_tm = _input.read_string();
        java.lang.String to_verify_tm;
        to_verify_tm = _input.read_string();
        int frm_ltimes;
        frm_ltimes = _input.read_long();
        int to_ltimes;
        to_ltimes = _input.read_long();
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustEnttList(in_opr_cde,in_verify_flg,in_dpt_cde,frm_crt_tm,to_crt_tm,frm_verify_tm,to_verify_tm,frm_ltimes,to_ltimes,in_user_id);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 23: {
      try {
        java.lang.String in_clnt_cnm;
        in_clnt_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.querySameCustList(in_clnt_cnm);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 24: {
      try {
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String in_clnt_cde;
        in_clnt_cde = _input.read_string();
        java.lang.String in_cmpny_agt_cde;
        in_cmpny_agt_cde = _input.read_string();
        java.lang.String in_verify_flg;
        in_verify_flg = _input.read_string();
        java.lang.String in_vrfy_desc;
        in_vrfy_desc = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.acceptUserVerify(in_user_id,in_clnt_cde,in_cmpny_agt_cde,in_verify_flg,in_vrfy_desc,in_opr_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 25: {
      try {
        java.lang.String org_optr_cde;
        org_optr_cde = _input.read_wstring();
        java.lang.String trgt_optr_cde;
        trgt_optr_cde = _input.read_wstring();
        boolean _result = _self.replaceAuthOptr(org_optr_cde,trgt_optr_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 26: {
      try {
        java.lang.String org_optr_cde;
        org_optr_cde = _input.read_wstring();
        java.lang.String trgt_optr_cde;
        trgt_optr_cde = _input.read_wstring();
        boolean _result = _self.compareAuthDptOptr(org_optr_cde,trgt_optr_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 27: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOptrAuthList(in_opr_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 28: {
      try {
        java.lang.String in_dpt_cde;
        in_dpt_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.querySubDptList(in_dpt_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 29: {
      try {
        java.lang.String opr_cde;
        opr_cde = _input.read_wstring();
        java.lang.String clnt_agt_flg;
        clnt_agt_flg = _input.read_string();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String clnt_cde;
        clnt_cde = _input.read_string();
        java.lang.String main_flg;
        main_flg = _input.read_wstring();
        boolean _result = _self.acceptClntMapInfo(opr_cde,clnt_agt_flg,user_id,clnt_cde,main_flg);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 30: {
      try {
        java.lang.String opr_cde;
        opr_cde = _input.read_wstring();
        java.lang.String clnt_agt_flg;
        clnt_agt_flg = _input.read_string();
        java.lang.String new_user_id;
        new_user_id = _input.read_wstring();
        java.lang.String new_clnt_cde;
        new_clnt_cde = _input.read_string();
        java.lang.String main_flg;
        main_flg = _input.read_wstring();
        java.lang.String old_user_id;
        old_user_id = _input.read_wstring();
        java.lang.String old_clnt_cde;
        old_clnt_cde = _input.read_string();
        boolean _result = _self.updateClntMapInfo(opr_cde,clnt_agt_flg,new_user_id,new_clnt_cde,main_flg,old_user_id,old_clnt_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 31: {
      try {
        java.lang.String opr_cde;
        opr_cde = _input.read_wstring();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String clnt_cde;
        clnt_cde = _input.read_string();
        java.lang.String clnt_agt_flg;
        clnt_agt_flg = _input.read_string();
        boolean _result = _self.deleteClntMapInfo(opr_cde,user_id,clnt_cde,clnt_agt_flg);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 32: {
      try {
        java.lang.String opr_cde;
        opr_cde = _input.read_wstring();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String[][] _result = _self.queryClntMapList(opr_cde,user_id);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 33: {
      try {
        java.lang.String act_typ;
        act_typ = _input.read_string();
        java.lang.String auth_opr_cde;
        auth_opr_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String in_dpt_cde;
        in_dpt_cde = _input.read_wstring();
        boolean _result = _self.executeSysadmAuth(act_typ,auth_opr_cde,in_opr_cde,in_dpt_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 34: {
      try {
        java.lang.String dpt_cde;
        dpt_cde = _input.read_wstring();
        java.lang.String cenm_typ;
        cenm_typ = _input.read_wstring();
        java.lang.String[][] _result = _self.getDptCEnm(dpt_cde,cenm_typ);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 35: {
      try {
        java.lang.String emp_cde;
        emp_cde = _input.read_wstring();
        java.lang.String emp_nme;
        emp_nme = _input.read_wstring();
        java.lang.String dpt_cde;
        dpt_cde = _input.read_wstring();
        java.lang.String emp_type;
        emp_type = _input.read_wstring();
        java.lang.String emp_email;
        emp_email = _input.read_wstring();
        boolean _result = _self.acceptSuppEmail(emp_cde,emp_nme,dpt_cde,emp_type,emp_email);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 36: {
      try {
        java.lang.String emp_cde;
        emp_cde = _input.read_wstring();
        java.lang.String emp_nme;
        emp_nme = _input.read_wstring();
        java.lang.String dpt_cde;
        dpt_cde = _input.read_wstring();
        java.lang.String emp_type;
        emp_type = _input.read_wstring();
        java.lang.String emp_email;
        emp_email = _input.read_wstring();
        java.lang.String supp_no;
        supp_no = _input.read_wstring();
        boolean _result = _self.updateSuppEmail(emp_cde,emp_nme,dpt_cde,emp_type,emp_email,supp_no);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 37: {
      try {
        java.lang.String supp_no;
        supp_no = _input.read_wstring();
        boolean _result = _self.deleteSuppEmail(supp_no);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 38: {
      try {
        java.lang.String emp_nme;
        emp_nme = _input.read_wstring();
        java.lang.String[] dpt_cde;
        dpt_cde = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String emp_type;
        emp_type = _input.read_wstring();
        java.lang.String[][] _result = _self.querySuppEmailList(emp_nme,dpt_cde,emp_type);
        com.mcip.orb.StringssHelper.write(_output, _result);
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
