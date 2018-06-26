package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PolicyInfoManager
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PolicyInfoManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface PolicyInfoManager {
  ...
};
 * </pre>
 */
public abstract class PolicyInfoManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.nia.orb.PolicyInfoManagerOperations {

  public com.mcip.nia.orb.PolicyInfoManager _this () {
   return com.mcip.nia.orb.PolicyInfoManagerHelper.narrow(super._this_object());
  }

  public com.mcip.nia.orb.PolicyInfoManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.nia.orb.PolicyInfoManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyInfoManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("getOCList", new int[] { 0, 0 });
    _methods.put("getOCInfo", new int[] { 0, 1 });
    _methods.put("getPrintFormat", new int[] { 0, 2 });
    _methods.put("getPrintPolicy", new int[] { 0, 3 });
    _methods.put("getAgencyList", new int[] { 0, 4 });
    _methods.put("getAgencyInfo", new int[] { 0, 5 });
    _methods.put("getAgencyPlcyList", new int[] { 0, 6 });
    _methods.put("getCustPlcyList", new int[] { 0, 7 });
    _methods.put("getPolicyAppList", new int[] { 0, 8 });
    _methods.put("getPolicyAppInfo", new int[] { 0, 9 });
    _methods.put("getPolicyList", new int[] { 0, 10 });
    _methods.put("getPolicyInfo", new int[] { 0, 11 });
    _methods.put("getPolicyInfoLatest", new int[] { 0, 12 });
    _methods.put("getProposalInfo", new int[] { 0, 13 });
    _methods.put("getEndorseProposalInfo", new int[] { 0, 14 });
    _methods.put("getPlyAppRdrInfo", new int[] { 0, 15 });
    _methods.put("getPlyRdrInfo", new int[] { 0, 16 });
    _methods.put("getCaseRptList", new int[] { 0, 17 });
    _methods.put("getCaseRptInfo", new int[] { 0, 18 });
    _methods.put("getCaseClmList", new int[] { 0, 19 });
    _methods.put("getClaimList", new int[] { 0, 20 });
    _methods.put("getClmDgstList", new int[] { 0, 21 });
    _methods.put("getQuotation", new int[] { 0, 22 });
    _methods.put("getPlyAppNetAddress", new int[] { 0, 23 });
    _methods.put("getClauseList", new int[] { 0, 24 });
    _methods.put("getProposalList", new int[] { 0, 25 });
    _methods.put("getEdrAppList", new int[] { 0, 26 });
    _methods.put("getEdrsmtList", new int[] { 0, 27 });
    _methods.put("getEdrsmtInfo", new int[] { 0, 28 });
    _methods.put("getPreEdrInfo", new int[] { 0, 29 });
    _methods.put("checkEdrApp", new int[] { 0, 30 });
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
        return com.mcip.nia.orb.PolicyInfoManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.nia.orb.PolicyInfoManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.getOCList(user_id, insrnc_cde);
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
        java.lang.String OC_cde;
        OC_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String crgo_cde;
        crgo_cde = _input.read_string();
        java.lang.String[][] _result = _self.getOCInfo(OC_cde, insrnc_cde, crgo_cde);
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
        java.lang.String incondStr;
        incondStr = _input.read_wstring();
        java.lang.String _result = _self.getPrintFormat(incondStr);
        _output = _handler.createReply();
        _output.write_wstring((java.lang.String)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 3: {
      try {
        java.lang.String incondStr;
        incondStr = _input.read_wstring();
        java.lang.String _result = _self.getPrintPolicy(incondStr);
        _output = _handler.createReply();
        _output.write_wstring((java.lang.String)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 4: {
      try {
        java.lang.String clnt_cde;
        clnt_cde = _input.read_wstring();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.getAgencyList(clnt_cde, insrnc_cde);
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
        java.lang.String agt_agr_cde;
        agt_agr_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String crgo_cde;
        crgo_cde = _input.read_string();
        java.lang.String crgo_typ;
        crgo_typ = _input.read_string();
        java.lang.String[][] _result = _self.getAgencyInfo(agt_agr_cde, insrnc_cde, 
                                                           crgo_cde, crgo_typ);
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
        java.lang.String agt_agr_cde;
        agt_agr_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String credit_id;
        credit_id = _input.read_string();
        java.lang.String[][] _result = _self.getAgencyPlcyList(agt_agr_cde, insrnc_cde, 
                                                               credit_id);
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
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String credit_cde;
        credit_cde = _input.read_string();
        java.lang.String[][] _result = _self.getCustPlcyList(user_id, insrnc_cde, 
                                                             credit_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 8: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String plyapp_cde;
        plyapp_cde = _input.read_string();
        java.lang.String app_from_tm;
        app_from_tm = _input.read_string();
        java.lang.String app_to_tm;
        app_to_tm = _input.read_string();
        java.lang.String cust_typ;
        cust_typ = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyAppList(user_id, plyapp_cde, 
                                                              app_from_tm, app_to_tm, 
                                                              cust_typ);
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
        java.lang.String plyapp_cde;
        plyapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyAppInfo(plyapp_cde);
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
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String policy_cde;
        policy_cde = _input.read_string();
        java.lang.String app_from_tm;
        app_from_tm = _input.read_string();
        java.lang.String app_to_tm;
        app_to_tm = _input.read_string();
        java.lang.String cust_typ;
        cust_typ = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyList(user_id, policy_cde, 
                                                           app_from_tm, app_to_tm, 
                                                           cust_typ);
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
        java.lang.String policy_cde;
        policy_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyInfo(policy_cde);
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
        java.lang.String policy_cde;
        policy_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyInfoLatest(policy_cde);
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
        java.lang.String plyapp_cde;
        plyapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getProposalInfo(plyapp_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 14: {
      try {
        java.lang.String edrapp_cde;
        edrapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getEndorseProposalInfo(edrapp_cde);
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
        java.lang.String in_plyapp_cde;
        in_plyapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPlyAppRdrInfo(in_plyapp_cde);
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
        java.lang.String in_ply_cde;
        in_ply_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPlyRdrInfo(in_ply_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 17: {
      try {
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_from_tm;
        in_from_tm = _input.read_string();
        java.lang.String in_to_tm;
        in_to_tm = _input.read_string();
        java.lang.String in_cust_typ;
        in_cust_typ = _input.read_string();
        java.lang.String[][] _result = _self.getCaseRptList(in_user_id, in_rpt_no, 
                                                            in_from_tm, in_to_tm, 
                                                            in_cust_typ);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 18: {
      try {
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String[][] _result = _self.getCaseRptInfo(in_rpt_no);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 19: {
      try {
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_status_mrk;
        in_status_mrk = _input.read_string();
        java.lang.String[][] _result = _self.getCaseClmList(in_rpt_no, in_status_mrk);
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
        java.lang.String in_clnt_cde;
        in_clnt_cde = _input.read_string();
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_clm_no;
        in_clm_no = _input.read_string();
        java.lang.String in_from_tm;
        in_from_tm = _input.read_string();
        java.lang.String in_to_tm;
        in_to_tm = _input.read_string();
        java.lang.String in_status_mrk;
        in_status_mrk = _input.read_string();
        java.lang.String[][] _result = _self.getClaimList(in_clnt_cde, in_rpt_no, 
                                                          in_clm_no, in_from_tm, 
                                                          in_to_tm, in_status_mrk);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 21: {
      try {
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String[][] _result = _self.getClmDgstList(in_rpt_no, in_ply_no);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 22: {
      try {
        com.mcip.nia.orb.QuotaCndtn quotacndtnobj;
        quotacndtnobj = com.mcip.nia.orb.QuotaCndtnHelper.read(_input);
        java.lang.String rdr_type;
        rdr_type = _input.read_wstring();
        java.lang.String[][] _result = _self.getQuotation(quotacndtnobj, rdr_type);
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
        java.lang.String cust_typ;
        cust_typ = _input.read_string();
        java.lang.String in_clnt_cde;
        in_clnt_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPlyAppNetAddress(cust_typ, in_clnt_cde);
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
        java.lang.String in_insrnc_cde;
        in_insrnc_cde = _input.read_wstring();
        java.lang.String in_clause_cde;
        in_clause_cde = _input.read_wstring();
        java.lang.String in_clnt_cnm;
        in_clnt_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.getClauseList(in_insrnc_cde, in_clause_cde, 
                                                           in_clnt_cnm);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 25: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String plyapp_cde;
        plyapp_cde = _input.read_string();
        java.lang.String app_from_tm;
        app_from_tm = _input.read_string();
        java.lang.String app_to_tm;
        app_to_tm = _input.read_string();
        java.lang.String cust_typ;
        cust_typ = _input.read_string();
        java.lang.String[][] _result = _self.getProposalList(user_id, plyapp_cde, 
                                                             app_from_tm, app_to_tm, 
                                                             cust_typ);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 26: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String edrapp_cde;
        edrapp_cde = _input.read_string();
        java.lang.String ply_no;
        ply_no = _input.read_string();
        java.lang.String app_from_tm;
        app_from_tm = _input.read_string();
        java.lang.String app_to_tm;
        app_to_tm = _input.read_string();
        java.lang.String cust_typ;
        cust_typ = _input.read_string();
        java.lang.String[][] _result = _self.getEdrAppList(user_id, edrapp_cde, 
                                                           ply_no, app_from_tm, 
                                                           app_to_tm, cust_typ);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 27: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String edr_no;
        edr_no = _input.read_string();
        java.lang.String ply_no;
        ply_no = _input.read_string();
        java.lang.String app_from_tm;
        app_from_tm = _input.read_string();
        java.lang.String app_to_tm;
        app_to_tm = _input.read_string();
        java.lang.String cust_typ;
        cust_typ = _input.read_string();
        java.lang.String[][] _result = _self.getEdrsmtList(user_id, edr_no, ply_no, 
                                                           app_from_tm, app_to_tm, 
                                                           cust_typ);
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
        java.lang.String edr_no;
        edr_no = _input.read_string();
        java.lang.String[][] _result = _self.getEdrsmtInfo(edr_no);
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
        java.lang.String edr_app_no;
        edr_app_no = _input.read_string();
        java.lang.String[][] _result = _self.getPreEdrInfo(edr_app_no);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 30: {
      try {
        java.lang.String ply_no;
        ply_no = _input.read_string();
        boolean _result = _self.checkEdrApp(ply_no);
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
