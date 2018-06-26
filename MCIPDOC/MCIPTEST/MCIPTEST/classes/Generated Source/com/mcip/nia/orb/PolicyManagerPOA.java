package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyManager {
  ...
};
 * </pre>
 */
public abstract class PolicyManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.nia.orb.PolicyManagerOperations {

  public com.mcip.nia.orb.PolicyManager _this () {
   return com.mcip.nia.orb.PolicyManagerHelper.narrow(super._this_object());
  }

  public com.mcip.nia.orb.PolicyManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.nia.orb.PolicyManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("acceptCaseRpt", new int[] { 0, 0 });
    _methods.put("acceptPolicyEdr", new int[] { 0, 1 });
    _methods.put("getPolicyEdr", new int[] { 0, 2 });
    _methods.put("withdrawalEdrApp", new int[] { 0, 3 });
    _methods.put("getEdrAppInfo", new int[] { 0, 4 });
    _methods.put("confirmEdrAppProposal", new int[] { 0, 5 });
    _methods.put("deleteEdrApp", new int[] { 0, 6 });
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
        return com.mcip.nia.orb.PolicyManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.nia.orb.PolicyManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
      try {
        com.mcip.nia.orb.CaseRptInfo caserptinfoobj;
        caserptinfoobj = com.mcip.nia.orb.CaseRptInfoHelper.read(_input);
        java.lang.String[][] _result = _self.acceptCaseRpt(caserptinfoobj);
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
        java.lang.String[][] _result = _self.acceptPolicyEdr(plyedrappinfoobj, 
                                                             plyedrappcrgoinfoobj, 
                                                             rdrinfo, plyedrapppayinfoobj, 
                                                             plyplyappnetinfoobj);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
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
        _self.getPolicyEdr(plygetdocinfoobj, plyedrapp, plyedrappcrgo, plyedrapprdr, 
                           plyedrapppay, plyplyappnet);
        _output = _handler.createReply();
        _output.write_any((org.omg.CORBA.Any)plyedrapp.value);
        _output.write_any((org.omg.CORBA.Any)plyedrappcrgo.value);
        _output.write_any((org.omg.CORBA.Any)plyedrapprdr.value);
        _output.write_any((org.omg.CORBA.Any)plyedrapppay.value);
        _output.write_any((org.omg.CORBA.Any)plyplyappnet.value);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 3: {
      try {
        java.lang.String edr_app_no;
        edr_app_no = _input.read_string();
        boolean _result = _self.withdrawalEdrApp(edr_app_no);
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
        com.mcip.nia.orb.PlyEdrGridInfo plyedrgridinfoobj;
        plyedrgridinfoobj = com.mcip.nia.orb.PlyEdrGridInfoHelper.read(_input);
        org.omg.CORBA.AnyHolder plyedrapp = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrappcrgo = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrapprdr = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyedrapppay = new org.omg.CORBA.AnyHolder();
        org.omg.CORBA.AnyHolder plyplyappnet = new org.omg.CORBA.AnyHolder();
        _self.getEdrAppInfo(plyedrgridinfoobj, plyedrapp, plyedrappcrgo, plyedrapprdr, 
                            plyedrapppay, plyplyappnet);
        _output = _handler.createReply();
        _output.write_any((org.omg.CORBA.Any)plyedrapp.value);
        _output.write_any((org.omg.CORBA.Any)plyedrappcrgo.value);
        _output.write_any((org.omg.CORBA.Any)plyedrapprdr.value);
        _output.write_any((org.omg.CORBA.Any)plyedrapppay.value);
        _output.write_any((org.omg.CORBA.Any)plyplyappnet.value);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 5: {
      try {
        java.lang.String edrapp_no;
        edrapp_no = _input.read_string();
        java.lang.String dpt_cde;
        dpt_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.confirmEdrAppProposal(edrapp_no, dpt_cde, 
                                                                   insrnc_cde);
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
        java.lang.String edr_app_no;
        edr_app_no = _input.read_string();
        boolean _result = _self.deleteEdrApp(edr_app_no);
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
