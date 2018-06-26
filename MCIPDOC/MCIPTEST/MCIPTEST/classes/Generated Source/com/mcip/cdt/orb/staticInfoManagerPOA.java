package com.mcip.cdt.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/getStaticInfo.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cdt::orb::staticInfoManager
 * <li> <b>Repository Id</b> IDL:com/mcip/cdt/orb/staticInfoManager:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface staticInfoManager {
  ...
};
 * </pre>
 */
public abstract class staticInfoManagerPOA extends org.omg.PortableServer.Servant implements 
  org.omg.CORBA.portable.InvokeHandler, com.mcip.cdt.orb.staticInfoManagerOperations {

  public com.mcip.cdt.orb.staticInfoManager _this () {
   return com.mcip.cdt.orb.staticInfoManagerHelper.narrow(super._this_object());
  }

  public com.mcip.cdt.orb.staticInfoManager _this (org.omg.CORBA.ORB orb) {
    return com.mcip.cdt.orb.staticInfoManagerHelper.narrow(super._this_object(orb));
  }

  public java.lang.String[] _all_interfaces (final org.omg.PortableServer.POA poa, final byte[] objectId) {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:com/mcip/cdt/orb/staticInfoManager:1.0"
  };

  private static java.util.Dictionary _methods = new java.util.Hashtable();

  static {
    _methods.put("getNationalList", new int[] { 0, 0 });
    _methods.put("getAreaList", new int[] { 0, 1 });
    _methods.put("getProvinceList", new int[] { 0, 2 });
    _methods.put("getCityList", new int[] { 0, 3 });
    _methods.put("getEduList", new int[] { 0, 4 });
    _methods.put("getTitleList", new int[] { 0, 5 });
    _methods.put("getDutyList", new int[] { 0, 6 });
    _methods.put("getTradeTypeList", new int[] { 0, 7 });
    _methods.put("getOrgTypeList", new int[] { 0, 8 });
    _methods.put("getOwnershipList", new int[] { 0, 9 });
    _methods.put("getScaleList", new int[] { 0, 10 });
    _methods.put("getPremiumScaleList", new int[] { 0, 11 });
    _methods.put("getCurrencyList", new int[] { 0, 12 });
    _methods.put("getCargoClsList", new int[] { 0, 13 });
    _methods.put("getCargoTypeList", new int[] { 0, 14 });
    _methods.put("getPackList", new int[] { 0, 15 });
    _methods.put("getExchangeRateList", new int[] { 0, 16 });
    _methods.put("getPayModeList", new int[] { 0, 17 });
    _methods.put("getInsuranceClassList", new int[] { 0, 18 });
    _methods.put("getInsuranceDefineList", new int[] { 0, 19 });
    _methods.put("getInsuranceTypeList", new int[] { 0, 20 });
    _methods.put("getClauseList", new int[] { 0, 21 });
    _methods.put("getEndorseReasonList", new int[] { 0, 22 });
    _methods.put("getDepartmentList", new int[] { 0, 23 });
    _methods.put("getAgentCharacterList", new int[] { 0, 24 });
    _methods.put("getSurveyAgentList", new int[] { 0, 25 });
    _methods.put("getCarriageList", new int[] { 0, 26 });
    _methods.put("getVslLevelList", new int[] { 0, 27 });
    _methods.put("getCertificateList", new int[] { 0, 28 });
    _methods.put("getMajorList", new int[] { 0, 29 });
    _methods.put("getMarriageList", new int[] { 0, 30 });
    _methods.put("getSexList", new int[] { 0, 31 });
    _methods.put("getEmployeeCodeList", new int[] { 0, 32 });
    _methods.put("getPACrgoClsTypList", new int[] { 0, 33 });
    _methods.put("getNetCodeList", new int[] { 0, 34 });
    _methods.put("getCurrencyInfo", new int[] { 0, 35 });
    _methods.put("getRptTelNum", new int[] { 0, 36 });
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
        return com.mcip.cdt.orb.staticInfoManagerPOA._invoke(this, method[1], _input, handler);
      }
    }
    throw new org.omg.CORBA.BAD_OPERATION();
  }

  public static org.omg.CORBA.portable.OutputStream _invoke (com.mcip.cdt.orb.staticInfoManagerOperations _self,
                                                             int _method_id,
                                                             org.omg.CORBA.portable.InputStream _input,
                                                             org.omg.CORBA.portable.ResponseHandler _handler) {
    org.omg.CORBA.portable.OutputStream _output = null;
    {
      switch (_method_id) {
      case 0: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getNationalList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getAreaList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getProvinceList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCityList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getEduList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getTitleList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getDutyList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getTradeTypeList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getOrgTypeList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getOwnershipList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getScaleList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getPremiumScaleList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCurrencyList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.getCargoClsList(cde, insrnc_cde);
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
        java.lang.String Cargocls;
        Cargocls = _input.read_string();
        java.lang.String[][] _result = _self.getCargoTypeList(Cargocls);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getPackList(cde);
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
        java.lang.String cur1;
        cur1 = _input.read_string();
        java.lang.String cur2;
        cur2 = _input.read_string();
        java.lang.String[][] _result = _self.getExchangeRateList(cur1, cur2);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getPayModeList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getInsuranceClassList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getInsuranceDefineList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getInsuranceTypeList(cde);
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
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String claus_cde;
        claus_cde = _input.read_string();
        java.lang.String add_mrk;
        add_mrk = _input.read_string();
        java.lang.String[][] _result = _self.getClauseList(insrnc_cde, claus_cde, 
                                                           add_mrk);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getEndorseReasonList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getDepartmentList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getAgentCharacterList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getSurveyAgentList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCarriageList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getVslLevelList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCertificateList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getMajorList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getMarriageList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getSexList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getEmployeeCodeList(cde);
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
        java.lang.String in_crgo_cde;
        in_crgo_cde = _input.read_wstring();
        java.lang.String in_site_cde;
        in_site_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getPACrgoClsTypList(in_crgo_cde, in_site_cde);
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
        java.lang.String in_net_cde;
        in_net_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getNetCodeList(in_net_cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCurrencyInfo(cde);
        _output = _handler.createReply();
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch (com.mcip.orb.CoException _exception) {
        _output = _handler.createExceptionReply();
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
      }
        return _output;
      }
      case 36: {
      try {
        java.lang.String in_dpt_cde;
        in_dpt_cde = _input.read_string();
        java.lang.String[][] _result = _self.getRptTelNum(in_dpt_cde);
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
