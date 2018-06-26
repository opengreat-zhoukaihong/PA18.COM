package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/userManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::UserManager
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/UserManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface UserManager {
  ...
};
 * </pre>
 */
public abstract class UserManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.bus.orb.UserManagerOperations {

  public com.mcip.bus.orb.UserManager _this () {
   return com.mcip.bus.orb.UserManagerHelper.narrow(super._this_object());
  }

  public com.mcip.bus.orb.UserManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.bus.orb.UserManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/bus/orb/UserManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("operatorLogin", new int[] { 0, 0 });
    _methods.put("acceptOperator", new int[] { 0, 1 });
    _methods.put("updateOperator", new int[] { 0, 2 });
    _methods.put("deleteOperator", new int[] { 0, 3 });
    _methods.put("queryOptrInfo", new int[] { 0, 4 });
    _methods.put("queryOptrList", new int[] { 0, 5 });
    _methods.put("queryAuthList", new int[] { 0, 6 });
    _methods.put("acceptOptrAuth", new int[] { 0, 7 });
    _methods.put("updateOptrAuth", new int[] { 0, 8 });
    _methods.put("deleteOptrAuth", new int[] { 0, 9 });
    _methods.put("queryOptrDptList", new int[] { 0, 10 });
    _methods.put("queryAbleDptList", new int[] { 0, 11 });
    _methods.put("acceptSysFunc", new int[] { 0, 12 });
    _methods.put("updateSysFunc", new int[] { 0, 13 });
    _methods.put("deleteSysFunc", new int[] { 0, 14 });
    _methods.put("querySysFuncList", new int[] { 0, 15 });
    _methods.put("acceptPagesInfo", new int[] { 0, 16 });
    _methods.put("updatePagesInfo", new int[] { 0, 17 });
    _methods.put("deletePagesInfo", new int[] { 0, 18 });
    _methods.put("queryPagesList", new int[] { 0, 19 });
    _methods.put("executeOptrAuth", new int[] { 0, 20 });
    _methods.put("checkOptrAuth", new int[] { 0, 21 });
    _methods.put("queryCustEnttList", new int[] { 0, 22 });
    _methods.put("querySameCustList", new int[] { 0, 23 });
    _methods.put("acceptUserVerify", new int[] { 0, 24 });
    _methods.put("replaceAuthOptr", new int[] { 0, 25 });
    _methods.put("compareAuthDptOptr", new int[] { 0, 26 });
    _methods.put("queryOptrAuthList", new int[] { 0, 27 });
    _methods.put("querySubDptList", new int[] { 0, 28 });
    _methods.put("acceptClntMapInfo", new int[] { 0, 29 });
    _methods.put("updateClntMapInfo", new int[] { 0, 30 });
    _methods.put("deleteClntMapInfo", new int[] { 0, 31 });
    _methods.put("queryClntMapList", new int[] { 0, 32 });
    _methods.put("executeSysadmAuth", new int[] { 0, 33 });
    _methods.put("getDptCEnm", new int[] { 0, 34 });
    _methods.put("acceptSuppEmail", new int[] { 0, 35 });
    _methods.put("updateSuppEmail", new int[] { 0, 36 });
    _methods.put("deleteSuppEmail", new int[] { 0, 37 });
    _methods.put("querySuppEmailList", new int[] { 0, 38 });
  }

  public org.omg.CORBA.portable.OutputStream _invoke (java.lang.String opName,
                                                      org.omg.CORBA.portable.InputStream _input,
                                                      org.omg.CORBA.portable.ResponseHandler handler) {
    int[] method = (int[]) _methods.get(opName);
    if (method == null) {
      throw new org.omg.CORBA.BAD_OPERATION();
    }
    switch (method[0]) {
      case 0: {
        return com.mcip.bus.orb.UserManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.bus.orb.UserManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
      try {
        java.lang.String usrname;
        usrname = _input.read_wstring();
        java.lang.String passwd;
        passwd = _input.read_wstring();
        java.lang.String[][] _result = _self.operatorLogin(usrname, passwd);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 1: {
      try {
        com.mcip.bus.orb.OperatorInfo operatorinfoobj;
        operatorinfoobj = com.mcip.bus.orb.OperatorInfoHelper.read(_input);
        boolean _result = _self.acceptOperator(operatorinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 2: {
      try {
        com.mcip.bus.orb.OperatorInfo operatorinfoobj;
        operatorinfoobj = com.mcip.bus.orb.OperatorInfoHelper.read(_input);
        boolean _result = _self.updateOperator(operatorinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.deleteOperator(auth_dpt_cde, auth_opr_cde, del_opr_cde, 
                                               rcsv_del_flg);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 4: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOptrInfo(in_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        java.lang.String[][] _result = _self.queryOptrList(in_opr_cde, in_emp_cde, 
                                                           adm_opr_cde, adm_dpt_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        java.lang.String[][] _result = _self.queryAuthList(in_opr_cde, in_emp_cde, 
                                                           adm_opr_cde, adm_dpt_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 7: {
      try {
        java.lang.String[][] oprauthInfoobj;
        oprauthInfoobj = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] oprdptinfoobj;
        oprdptinfoobj = com.mcip.orb.StringssHelper.read(_input);
        boolean _result = _self.acceptOptrAuth(oprauthInfoobj, oprdptinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 8: {
      try {
        java.lang.String[][] oprauthInfoobj;
        oprauthInfoobj = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] oprdptinfoobj;
        oprdptinfoobj = com.mcip.orb.StringssHelper.read(_input);
        boolean _result = _self.updateOptrAuth(oprauthInfoobj, oprdptinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 9: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String in_func_cde;
        in_func_cde = _input.read_wstring();
        boolean _result = _self.deleteOptrAuth(in_opr_cde, in_func_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 10: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOptrDptList(in_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 11: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String auth_opr_cde;
        auth_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryAbleDptList(in_opr_cde, auth_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 12: {
      try {
        com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj;
        sysfuncinfoobj = com.mcip.bus.orb.SysFuncInfoHelper.read(_input);
        boolean _result = _self.acceptSysFunc(sysfuncinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 13: {
      try {
        com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj;
        sysfuncinfoobj = com.mcip.bus.orb.SysFuncInfoHelper.read(_input);
        boolean _result = _self.updateSysFunc(sysfuncinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 14: {
      try {
        java.lang.String in_func_cde;
        in_func_cde = _input.read_wstring();
        boolean _result = _self.deleteSysFunc(in_func_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 15: {
      try {
        java.lang.String in_func_cde;
        in_func_cde = _input.read_string();
        java.lang.String[][] _result = _self.querySysFuncList(in_func_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 16: {
      try {
        com.mcip.bus.orb.PagesInfo pagesinfoobj;
        pagesinfoobj = com.mcip.bus.orb.PagesInfoHelper.read(_input);
        boolean _result = _self.acceptPagesInfo(pagesinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 17: {
      try {
        com.mcip.bus.orb.PagesInfo pagesinfoobj;
        pagesinfoobj = com.mcip.bus.orb.PagesInfoHelper.read(_input);
        boolean _result = _self.updatePagesInfo(pagesinfoobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 18: {
      try {
        java.lang.String in_page_no;
        in_page_no = _input.read_string();
        boolean _result = _self.deletePagesInfo(in_page_no);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 19: {
      try {
        java.lang.String in_func_cde;
        in_func_cde = _input.read_string();
        java.lang.String[][] _result = _self.queryPagesList(in_func_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.executeOptrAuth(act_typ, auth_opr_cde, in_opr_cde, 
                                                oprauthInfo, oprdptinfo);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 21: {
      try {
        java.lang.String in_optr_cde;
        in_optr_cde = _input.read_wstring();
        java.lang.String in_func_cde;
        in_func_cde = _input.read_string();
        boolean _result = _self.checkOptrAuth(in_optr_cde, in_func_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        java.lang.String[][] _result = _self.queryCustEnttList(in_opr_cde, in_verify_flg, 
                                                               in_dpt_cde, frm_crt_tm, 
                                                               to_crt_tm, frm_verify_tm, 
                                                               to_verify_tm, frm_ltimes, 
                                                               to_ltimes, in_user_id);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 23: {
      try {
        java.lang.String in_clnt_cnm;
        in_clnt_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.querySameCustList(in_clnt_cnm);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.acceptUserVerify(in_user_id, in_clnt_cde, in_cmpny_agt_cde, 
                                                 in_verify_flg, in_vrfy_desc, in_opr_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 25: {
      try {
        java.lang.String org_optr_cde;
        org_optr_cde = _input.read_wstring();
        java.lang.String trgt_optr_cde;
        trgt_optr_cde = _input.read_wstring();
        boolean _result = _self.replaceAuthOptr(org_optr_cde, trgt_optr_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 26: {
      try {
        java.lang.String org_optr_cde;
        org_optr_cde = _input.read_wstring();
        java.lang.String trgt_optr_cde;
        trgt_optr_cde = _input.read_wstring();
        boolean _result = _self.compareAuthDptOptr(org_optr_cde, trgt_optr_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 27: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOptrAuthList(in_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 28: {
      try {
        java.lang.String in_dpt_cde;
        in_dpt_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.querySubDptList(in_dpt_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.acceptClntMapInfo(opr_cde, clnt_agt_flg, user_id, 
                                                  clnt_cde, main_flg);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.updateClntMapInfo(opr_cde, clnt_agt_flg, new_user_id, 
                                                  new_clnt_cde, main_flg, old_user_id, 
                                                  old_clnt_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.deleteClntMapInfo(opr_cde, user_id, clnt_cde, clnt_agt_flg);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 32: {
      try {
        java.lang.String opr_cde;
        opr_cde = _input.read_wstring();
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String[][] _result = _self.queryClntMapList(opr_cde, user_id);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.executeSysadmAuth(act_typ, auth_opr_cde, in_opr_cde, 
                                                  in_dpt_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 34: {
      try {
        java.lang.String dpt_cde;
        dpt_cde = _input.read_wstring();
        java.lang.String cenm_typ;
        cenm_typ = _input.read_wstring();
        java.lang.String[][] _result = _self.getDptCEnm(dpt_cde, cenm_typ);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.acceptSuppEmail(emp_cde, emp_nme, dpt_cde, emp_type, 
                                                emp_email);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.updateSuppEmail(emp_cde, emp_nme, dpt_cde, emp_type, 
                                                emp_email, supp_no);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 37: {
      try {
        java.lang.String supp_no;
        supp_no = _input.read_wstring();
        boolean _result = _self.deleteSuppEmail(supp_no);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 38: {
      try {
        java.lang.String emp_nme;
        emp_nme = _input.read_wstring();
        java.lang.String[] dpt_cde;
        dpt_cde = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String emp_type;
        emp_type = _input.read_wstring();
        java.lang.String[][] _result = _self.querySuppEmailList(emp_nme, dpt_cde, 
                                                                emp_type);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      }
      throw new org.omg.CORBA.BAD_OPERATION();
    }
  }
}
