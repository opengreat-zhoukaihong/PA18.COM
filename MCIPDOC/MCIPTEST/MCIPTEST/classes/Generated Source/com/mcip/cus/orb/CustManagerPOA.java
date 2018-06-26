package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustManager
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface CustManager {
  ...
};
 * </pre>
 */
public abstract class CustManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.cus.orb.CustManagerOperations {

  public com.mcip.cus.orb.CustManager _this () {
   return com.mcip.cus.orb.CustManagerHelper.narrow(super._this_object());
  }

  public com.mcip.cus.orb.CustManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.cus.orb.CustManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/cus/orb/CustManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("customerLogin", new int[] { 0, 0 });
    _methods.put("acceptOrgaCust", new int[] { 0, 1 });
    _methods.put("acceptPrsnCust", new int[] { 0, 2 });
    _methods.put("deleteIllegalUser", new int[] { 0, 3 });
    _methods.put("acceptAgntCust", new int[] { 0, 4 });
    _methods.put("updateOrgaCust", new int[] { 0, 5 });
    _methods.put("updatePrsnCust", new int[] { 0, 6 });
    _methods.put("updateEnttCust", new int[] { 0, 7 });
    _methods.put("queryCustEntt", new int[] { 0, 8 });
    _methods.put("queryCustOrgn", new int[] { 0, 9 });
    _methods.put("queryCustPrsn", new int[] { 0, 10 });
    _methods.put("queryCustAgnt", new int[] { 0, 11 });
    _methods.put("requireCust", new int[] { 0, 12 });
    _methods.put("checkProposal", new int[] { 0, 13 });
    _methods.put("queryAgencyInfo", new int[] { 0, 14 });
    _methods.put("queryOCcustInfo", new int[] { 0, 15 });
    _methods.put("acceptOCCust", new int[] { 0, 16 });
    _methods.put("acceptAGCust", new int[] { 0, 17 });
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
        return com.mcip.cus.orb.CustManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.cus.orb.CustManagerOperations _self,
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
        java.lang.String[][] _result = _self.customerLogin(usrname, passwd);
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
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptOrgaCust(in_register_mrk, custorgnobj, custentityobj);
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
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustPrsn custprsnobj;
        custprsnobj = com.mcip.cus.orb.CustPrsnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptPrsnCust(in_register_mrk, custprsnobj, custentityobj);
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
        java.lang.String user_id;
        user_id = _input.read_string();
        boolean _result = _self.deleteIllegalUser(user_id);
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
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptAgntCust(custentityobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 5: {
      try {
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        java.lang.String cust_user_id;
        cust_user_id = _input.read_wstring();
        boolean _result = _self.updateOrgaCust(custorgnobj, cust_user_id);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 6: {
      try {
        com.mcip.cus.orb.CustPrsn custprsnobj;
        custprsnobj = com.mcip.cus.orb.CustPrsnHelper.read(_input);
        java.lang.String cust_user_id;
        cust_user_id = _input.read_wstring();
        boolean _result = _self.updatePrsnCust(custprsnobj, cust_user_id);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 7: {
      try {
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.updateEnttCust(custentityobj);
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
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustEntt(in_account_info);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 9: {
      try {
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustOrgn(in_account_info);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 10: {
      try {
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustPrsn(in_account_info);
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
        java.lang.String in_account_info;
        in_account_info = _input.read_wstring();
        java.lang.String[][] _result = _self.queryCustAgnt(in_account_info);
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
        java.lang.String in_user_mrk;
        in_user_mrk = _input.read_string();
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String in_register_id;
        in_register_id = _input.read_wstring();
        java.lang.String[][] _result = _self.requireCust(in_user_mrk, in_user_id, 
                                                         in_register_id);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 13: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String cust_type;
        cust_type = _input.read_string();
        boolean _result = _self.checkProposal(user_id, cust_type);
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
        java.lang.String in_agent_cde;
        in_agent_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryAgencyInfo(in_agent_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 15: {
      try {
        java.lang.String in_clnt_cde;
        in_clnt_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryOCcustInfo(in_clnt_cde);
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
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptOCCust(in_register_mrk, custorgnobj, custentityobj);
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
        java.lang.String in_register_mrk;
        in_register_mrk = _input.read_string();
        com.mcip.cus.orb.CustOrgn custorgnobj;
        custorgnobj = com.mcip.cus.orb.CustOrgnHelper.read(_input);
        com.mcip.cus.orb.CustEntity custentityobj;
        custentityobj = com.mcip.cus.orb.CustEntityHelper.read(_input);
        boolean _result = _self.acceptAGCust(in_register_mrk, custorgnobj, custentityobj);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
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
