package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyAppManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyAppManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyAppManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyAppManager {
  ...
};
 * </pre>
 */
public abstract class PolicyAppManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.nia.orb.PolicyAppManagerOperations {

  public com.mcip.nia.orb.PolicyAppManager _this () {
   return com.mcip.nia.orb.PolicyAppManagerHelper.narrow(super._this_object());
  }

  public com.mcip.nia.orb.PolicyAppManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.nia.orb.PolicyAppManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyAppManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("acceptPolicyApp", new int[] { 0, 0 });
    _methods.put("withdrawalPolicyApp", new int[] { 0, 1 });
    _methods.put("updatePolicyApp", new int[] { 0, 2 });
    _methods.put("confirmPolicyAppProposal", new int[] { 0, 3 });
    _methods.put("acceptUserRemark", new int[] { 0, 4 });
    _methods.put("deletePolicyApp", new int[] { 0, 5 });
    _methods.put("updatePayFlag", new int[] { 0, 6 });
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
        return com.mcip.nia.orb.PolicyAppManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.nia.orb.PolicyAppManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
      try {
        com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj;
        plcyappinfoobj = com.mcip.nia.orb.PlcyAppInfoHelper.read(_input);
        java.lang.String[][] rdrinfo;
        rdrinfo = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] _result = _self.acceptPolicyApp(plcyappinfoobj, rdrinfo);
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
        java.lang.String plcyapp_no;
        plcyapp_no = _input.read_string();
        boolean _result = _self.withdrawalPolicyApp(plcyapp_no);
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
        com.mcip.nia.orb.PlcyAppInfo plcyappinfoobj;
        plcyappinfoobj = com.mcip.nia.orb.PlcyAppInfoHelper.read(_input);
        java.lang.String[][] rdrinfo;
        rdrinfo = com.mcip.orb.StringssHelper.read(_input);
        java.lang.String[][] _result = _self.updatePolicyApp(plcyappinfoobj, rdrinfo);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        java.lang.String[][] _result = _self.confirmPolicyAppProposal(plcyapp_no, 
                                                                      dpt_cde, 
                                                                      insrnc_cde, 
                                                                      undr_prsn);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        boolean _result = _self.acceptUserRemark(plcyapp_no, app_cde, user_remark, 
                                                 app_typ);
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
        java.lang.String plcyapp_no;
        plcyapp_no = _input.read_string();
        boolean _result = _self.deletePolicyApp(plcyapp_no);
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
        java.lang.String plcy_no;
        plcy_no = _input.read_string();
        java.lang.String pay_flag;
        pay_flag = _input.read_string();
        java.lang.String app_typ;
        app_typ = _input.read_string();
        boolean _result = _self.updatePayFlag(plcy_no, pay_flag, app_typ);
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
