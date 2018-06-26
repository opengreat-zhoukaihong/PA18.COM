package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessManage.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::BusinessManager
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/BusinessManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface BusinessManager {
  ...
};
 * </pre>
 */
public abstract class BusinessManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.bus.orb.BusinessManagerOperations {

  public com.mcip.bus.orb.BusinessManager _this () {
   return com.mcip.bus.orb.BusinessManagerHelper.narrow(super._this_object());
  }

  public com.mcip.bus.orb.BusinessManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.bus.orb.BusinessManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/bus/orb/BusinessManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("isAlive", new int[] { 0, 0 });
    _methods.put("queryPlyNetList", new int[] { 0, 1 });
    _methods.put("queryPlyNetInfo", new int[] { 0, 2 });
    _methods.put("updatePrintInfo", new int[] { 0, 3 });
    _methods.put("acceptPlyAssign", new int[] { 0, 4 });
    _methods.put("acceptPlySended", new int[] { 0, 5 });
    _methods.put("acceptPlyFreebk", new int[] { 0, 6 });
    _methods.put("queryPlyNetAbleEmp", new int[] { 0, 7 });
    _methods.put("queryPlyDealList", new int[] { 0, 8 });
    _methods.put("queryRptFlwUpList", new int[] { 0, 9 });
    _methods.put("acceptRptFlwUpEmp", new int[] { 0, 10 });
    _methods.put("queryEventTypeList", new int[] { 0, 11 });
    _methods.put("queryEventCountList", new int[] { 0, 12 });
    _methods.put("acceptGuideInfo", new int[] { 0, 13 });
    _methods.put("updateGuideInfo", new int[] { 0, 14 });
    _methods.put("deleteGuideInfo", new int[] { 0, 15 });
    _methods.put("queryGuideList", new int[] { 0, 16 });
    _methods.put("queryGuideInfo", new int[] { 0, 17 });
    _methods.put("acceptConsultInfo", new int[] { 0, 18 });
    _methods.put("updateConsultInfo", new int[] { 0, 19 });
    _methods.put("deleteConsultInfo", new int[] { 0, 20 });
    _methods.put("queryConsultList", new int[] { 0, 21 });
    _methods.put("queryConsultInfo", new int[] { 0, 22 });
    _methods.put("acceptFaqInfo", new int[] { 0, 23 });
    _methods.put("updateFaqInfo", new int[] { 0, 24 });
    _methods.put("deleteFaqInfo", new int[] { 0, 25 });
    _methods.put("queryFaqList", new int[] { 0, 26 });
    _methods.put("queryFaqInfo", new int[] { 0, 27 });
    _methods.put("getPlyAppStatictics", new int[] { 0, 28 });
    _methods.put("getPolicyStatictics", new int[] { 0, 29 });
    _methods.put("getEdrPlcyStatictics", new int[] { 0, 30 });
    _methods.put("getProposalStatictics", new int[] { 0, 31 });
    _methods.put("getCaseRptStatictics", new int[] { 0, 32 });
    _methods.put("getCustStatictics", new int[] { 0, 33 });
    _methods.put("acceptClmDgst", new int[] { 0, 34 });
    _methods.put("updateClmDgst", new int[] { 0, 35 });
    _methods.put("deleteClmDgst", new int[] { 0, 36 });
    _methods.put("queryClmDgstInfo", new int[] { 0, 37 });
    _methods.put("acceptChatCntnt", new int[] { 0, 38 });
    _methods.put("queryChatCntnt", new int[] { 0, 39 });
    _methods.put("getCustPlyAppList", new int[] { 0, 40 });
    _methods.put("getCustPlySum", new int[] { 0, 41 });
    _methods.put("getChatRight", new int[] { 0, 42 });
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
        return com.mcip.bus.orb.BusinessManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.bus.orb.BusinessManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
        boolean _result = _self.isAlive();
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
        return _output;
      }
      case 1: {
      try {
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String in_prnt_flg;
        in_prnt_flg = _input.read_string();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String frm_plyapp_tm;
        frm_plyapp_tm = _input.read_string();
        java.lang.String to_plyapp_tm;
        to_plyapp_tm = _input.read_string();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String[] dpt_array;
        dpt_array = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String[][] _result = _self.queryPlyNetList(in_opr_cde, in_prnt_flg, 
                                                             in_ply_no, frm_plyapp_tm, 
                                                             to_plyapp_tm, frm_insrnc_cde, 
                                                             to_insrnc_cde, dpt_array);
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
        java.lang.String[] ply_no_array;
        ply_no_array = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String[][] _result = _self.queryPlyNetInfo(ply_no_array);
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
        java.lang.String[] ply_no_array;
        ply_no_array = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.updatePrintInfo(ply_no_array, in_opr_cde);
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
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String in_assign_emp;
        in_assign_emp = _input.read_wstring();
        java.lang.String in_assign_tm;
        in_assign_tm = _input.read_string();
        java.lang.String in_sended_tm;
        in_sended_tm = _input.read_string();
        java.lang.String in_feedbk_tm;
        in_feedbk_tm = _input.read_string();
        boolean _result = _self.acceptPlyAssign(in_ply_no, in_assign_emp, in_assign_tm, 
                                                in_sended_tm, in_feedbk_tm);
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
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String in_sended_tm;
        in_sended_tm = _input.read_string();
        boolean _result = _self.acceptPlySended(in_ply_no, in_sended_tm);
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
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String in_freebk_tm;
        in_freebk_tm = _input.read_string();
        boolean _result = _self.acceptPlyFreebk(in_ply_no, in_freebk_tm);
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
        java.lang.String in_dpt_cde;
        in_dpt_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryPlyNetAbleEmp(in_dpt_cde, in_opr_cde);
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
        java.lang.String in_deal_type;
        in_deal_type = _input.read_string();
        java.lang.String in_deal_flg;
        in_deal_flg = _input.read_string();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String frm_plyapp_tm;
        frm_plyapp_tm = _input.read_string();
        java.lang.String to_plyapp_tm;
        to_plyapp_tm = _input.read_string();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String[] dpt_array;
        dpt_array = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryPlyDealList(in_deal_type, in_deal_flg, 
                                                              in_ply_no, frm_plyapp_tm, 
                                                              to_plyapp_tm, frm_insrnc_cde, 
                                                              to_insrnc_cde, dpt_array, 
                                                              in_opr_cde);
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
        java.lang.String in_deal_type;
        in_deal_type = _input.read_string();
        java.lang.String in_deal_flg;
        in_deal_flg = _input.read_string();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String frm_rpt_tm;
        frm_rpt_tm = _input.read_string();
        java.lang.String to_rpt_tm;
        to_rpt_tm = _input.read_string();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String[] dpt_array;
        dpt_array = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryRptFlwUpList(in_deal_type, in_deal_flg, 
                                                               in_ply_no, in_rpt_no, 
                                                               frm_rpt_tm, to_rpt_tm, 
                                                               frm_insrnc_cde, 
                                                               to_insrnc_cde, dpt_array, 
                                                               in_opr_cde);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_emp_cde;
        in_emp_cde = _input.read_wstring();
        java.lang.String auth_opr_cde;
        auth_opr_cde = _input.read_wstring();
        boolean _result = _self.acceptRptFlwUpEmp(in_rpt_no, in_emp_cde, auth_opr_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 11: {
      try {
        java.lang.String in_event_cde;
        in_event_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryEventTypeList(in_event_cde);
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
        java.lang.String frm_log_tm;
        frm_log_tm = _input.read_string();
        java.lang.String to_log_tm;
        to_log_tm = _input.read_string();
        java.lang.String in_event_typ;
        in_event_typ = _input.read_wstring();
        java.lang.String in_event_cde;
        in_event_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryEventCountList(frm_log_tm, to_log_tm, 
                                                                 in_event_typ, 
                                                                 in_event_cde, 
                                                                 in_opr_cde);
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
        com.mcip.bus.orb.InsrncGuideInfo guideinfoobj;
        guideinfoobj = com.mcip.bus.orb.InsrncGuideInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.acceptGuideInfo(guideinfoobj, in_opr_cnm);
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
        com.mcip.bus.orb.InsrncGuideInfo guideinfoobj;
        guideinfoobj = com.mcip.bus.orb.InsrncGuideInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.updateGuideInfo(guideinfoobj, in_opr_cnm);
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
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.deleteGuideInfo(in_info_no, in_opr_cnm);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 16: {
      try {
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryGuideList(in_info_no, in_opr_cnm);
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
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryGuideInfo(in_info_no, in_opr_cnm);
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
        com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj;
        insrncfaqinfoobj = com.mcip.bus.orb.InsrncFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.acceptConsultInfo(insrncfaqinfoobj, in_opr_cnm);
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
        com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj;
        insrncfaqinfoobj = com.mcip.bus.orb.InsrncFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.updateConsultInfo(insrncfaqinfoobj, in_opr_cnm);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 20: {
      try {
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.deleteConsultInfo(in_faq_no, in_opr_cnm);
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
        java.lang.String in_topic_no;
        in_topic_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryConsultList(in_topic_no, in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryConsultInfo(in_faq_no, in_opr_cnm);
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
        com.mcip.bus.orb.CustFaqInfo custfaqinfoobj;
        custfaqinfoobj = com.mcip.bus.orb.CustFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.acceptFaqInfo(custfaqinfoobj, in_opr_cnm);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 24: {
      try {
        com.mcip.bus.orb.CustFaqInfo custfaqinfoobj;
        custfaqinfoobj = com.mcip.bus.orb.CustFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.updateFaqInfo(custfaqinfoobj, in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.deleteFaqInfo(in_faq_no, in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryFaqList(in_faq_no, in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryFaqInfo(in_faq_no, in_opr_cnm);
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
        java.lang.String frm_plyapp_tm;
        frm_plyapp_tm = _input.read_string();
        java.lang.String to_plyapp_tm;
        to_plyapp_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_dpt;
        frm_dpt = _input.read_wstring();
        java.lang.String to_dpt;
        to_dpt = _input.read_wstring();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String in_cur_cde;
        in_cur_cde = _input.read_wstring();
        java.lang.String in_site_cde;
        in_site_cde = _input.read_wstring();
        java.lang.String in_stat_type;
        in_stat_type = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getPlyAppStatictics(frm_plyapp_tm, 
                                                                 to_plyapp_tm, 
                                                                 owned_dpt, frm_dpt, 
                                                                 to_dpt, frm_insrnc_cde, 
                                                                 to_insrnc_cde, 
                                                                 in_cur_cde, in_site_cde, 
                                                                 in_stat_type, 
                                                                 in_opr_cde);
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
        java.lang.String frm_plyapp_tm;
        frm_plyapp_tm = _input.read_string();
        java.lang.String to_plyapp_tm;
        to_plyapp_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_dpt;
        frm_dpt = _input.read_wstring();
        java.lang.String to_dpt;
        to_dpt = _input.read_wstring();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String in_cur_cde;
        in_cur_cde = _input.read_wstring();
        java.lang.String in_site_cde;
        in_site_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getPolicyStatictics(frm_plyapp_tm, 
                                                                 to_plyapp_tm, 
                                                                 owned_dpt, frm_dpt, 
                                                                 to_dpt, frm_insrnc_cde, 
                                                                 to_insrnc_cde, 
                                                                 in_cur_cde, in_site_cde, 
                                                                 in_opr_cde);
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
        java.lang.String frm_edrapp_tm;
        frm_edrapp_tm = _input.read_string();
        java.lang.String to_edrapp_tm;
        to_edrapp_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_dpt;
        frm_dpt = _input.read_wstring();
        java.lang.String to_dpt;
        to_dpt = _input.read_wstring();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String in_cur_cde;
        in_cur_cde = _input.read_wstring();
        java.lang.String in_site_cde;
        in_site_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getEdrPlcyStatictics(frm_edrapp_tm, 
                                                                  to_edrapp_tm, 
                                                                  owned_dpt, frm_dpt, 
                                                                  to_dpt, frm_insrnc_cde, 
                                                                  to_insrnc_cde, 
                                                                  in_cur_cde, in_site_cde, 
                                                                  in_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 31: {
      try {
        java.lang.String frm_plyapp_tm;
        frm_plyapp_tm = _input.read_string();
        java.lang.String to_plyapp_tm;
        to_plyapp_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_dpt;
        frm_dpt = _input.read_wstring();
        java.lang.String to_dpt;
        to_dpt = _input.read_wstring();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String in_cur_cde;
        in_cur_cde = _input.read_wstring();
        java.lang.String in_site_cde;
        in_site_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getProposalStatictics(frm_plyapp_tm, 
                                                                   to_plyapp_tm, 
                                                                   owned_dpt, frm_dpt, 
                                                                   to_dpt, frm_insrnc_cde, 
                                                                   to_insrnc_cde, 
                                                                   in_cur_cde, 
                                                                   in_site_cde, 
                                                                   in_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 32: {
      try {
        java.lang.String frm_plyapp_tm;
        frm_plyapp_tm = _input.read_string();
        java.lang.String to_plyapp_tm;
        to_plyapp_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_dpt;
        frm_dpt = _input.read_wstring();
        java.lang.String to_dpt;
        to_dpt = _input.read_wstring();
        java.lang.String frm_insrnc_cde;
        frm_insrnc_cde = _input.read_wstring();
        java.lang.String to_insrnc_cde;
        to_insrnc_cde = _input.read_wstring();
        java.lang.String in_cur_cde;
        in_cur_cde = _input.read_wstring();
        java.lang.String in_site_cde;
        in_site_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getCaseRptStatictics(frm_plyapp_tm, 
                                                                  to_plyapp_tm, 
                                                                  owned_dpt, frm_dpt, 
                                                                  to_dpt, frm_insrnc_cde, 
                                                                  to_insrnc_cde, 
                                                                  in_cur_cde, in_site_cde, 
                                                                  in_opr_cde);
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
        java.lang.String frm_crt_tm;
        frm_crt_tm = _input.read_string();
        java.lang.String to_crt_tm;
        to_crt_tm = _input.read_string();
        java.lang.String[] owned_dpt;
        owned_dpt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String frm_dpt;
        frm_dpt = _input.read_wstring();
        java.lang.String to_dpt;
        to_dpt = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getCustStatictics(frm_crt_tm, to_crt_tm, 
                                                               owned_dpt, frm_dpt, 
                                                               to_dpt, in_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 34: {
      try {
        com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj;
        clmdgstinfoobj = com.mcip.bus.orb.ClmDgstInfoHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.acceptClmDgst(clmdgstinfoobj, in_opr_cde);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 35: {
      try {
        com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj;
        clmdgstinfoobj = com.mcip.bus.orb.ClmDgstInfoHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.updateClmDgst(clmdgstinfoobj, in_opr_cde);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_wstring();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_wstring();
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.deleteClmDgst(in_rpt_no, in_ply_no, in_info_no, 
                                              in_opr_cde);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_wstring();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryClmDgstInfo(in_rpt_no, in_ply_no, 
                                                              in_opr_cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 38: {
      try {
        java.lang.String in_bgn_tm;
        in_bgn_tm = _input.read_wstring();
        java.lang.String in_end_tm;
        in_end_tm = _input.read_wstring();
        java.lang.String in_chat_ttl;
        in_chat_ttl = _input.read_wstring();
        java.lang.String[] chat_cntnt;
        chat_cntnt = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_chat_nme;
        in_chat_nme = _input.read_wstring();
        java.lang.String in_chat_mrk;
        in_chat_mrk = _input.read_wstring();
        boolean _result = _self.acceptChatCntnt(in_bgn_tm, in_end_tm, in_chat_ttl, 
                                                chat_cntnt, in_chat_nme, in_chat_mrk);
        _output = _handler.createReply();
        _output.write_boolean((boolean)_result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 39: {
      try {
        java.lang.String in_chat_ttl;
        in_chat_ttl = _input.read_wstring();
        java.lang.String in_chat_mrk;
        in_chat_mrk = _input.read_wstring();
        java.lang.String[][] _result = _self.queryChatCntnt(in_chat_ttl, in_chat_mrk);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 40: {
      try {
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String[][] _result = _self.getCustPlyAppList(in_user_id);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 41: {
      try {
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String[] in_insrnc_cde;
        in_insrnc_cde = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_sum_tm;
        in_sum_tm = _input.read_wstring();
        java.lang.String[][] _result = _self.getCustPlySum(in_user_id, in_insrnc_cde, 
                                                           in_sum_tm);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 42: {
      try {
        java.lang.String in_emp_cde;
        in_emp_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getChatRight(in_emp_cde);
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
