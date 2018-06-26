package com.mcip.cdt.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.cdt.orb._staticInfoManagerImplBase
<li> <b>Source File</b> com/mcip/cdt/orb/_staticInfoManagerImplBase.java
<li> <b>IDL Source File</b> getStaticInfo.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::cdt::orb::staticInfoManager
<li> <b>Repository Identifier</b> IDL:com/mcip/cdt/orb/staticInfoManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/cdt/orb"
    interface staticInfoManager {
      ::com::mcip::orb::Stringss getNationalList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAreaList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProvinceList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCityList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEduList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getTitleList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getDutyList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getTradeTypeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getOrgTypeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getOwnershipList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getScaleList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPremiumScaleList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCurrencyList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCargoClsList(
        in string cde,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCargoTypeList(
        in string Cargocls
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPackList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getExchangeRateList(
        in string cur1,
        in string cur2
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPayModeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getInsuranceClassList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getInsuranceDefineList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getInsuranceTypeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClauseList(
        in string insrnc_cde,
        in string claus_cde,
        in string add_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEndorseReasonList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getDepartmentList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgentCharacterList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getSurveyAgentList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCarriageList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getVslLevelList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCertificateList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getMajorList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getMarriageList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getSexList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEmployeeCodeList(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPACrgoClsTypList(
        in wstring in_crgo_cde,
        in wstring in_site_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getNetCodeList(
        in wstring in_net_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCurrencyInfo(
        in string cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getRptTelNum(
        in string in_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
abstract public class _staticInfoManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.cdt.orb.staticInfoManager {
  protected com.mcip.cdt.orb.staticInfoManager _wrapper = null;
  public com.mcip.cdt.orb.staticInfoManager _this() {
    return this;
  }
  protected _staticInfoManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _staticInfoManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.cdt.orb.staticInfoManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/cdt/orb/staticInfoManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("getNationalList", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("getAreaList", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("getProvinceList", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("getCityList", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("getEduList", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("getTitleList", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("getDutyList", 0, 6),
      new org.omg.CORBA.portable.MethodPointer("getTradeTypeList", 0, 7),
      new org.omg.CORBA.portable.MethodPointer("getOrgTypeList", 0, 8),
      new org.omg.CORBA.portable.MethodPointer("getOwnershipList", 0, 9),
      new org.omg.CORBA.portable.MethodPointer("getScaleList", 0, 10),
      new org.omg.CORBA.portable.MethodPointer("getPremiumScaleList", 0, 11),
      new org.omg.CORBA.portable.MethodPointer("getCurrencyList", 0, 12),
      new org.omg.CORBA.portable.MethodPointer("getCargoClsList", 0, 13),
      new org.omg.CORBA.portable.MethodPointer("getCargoTypeList", 0, 14),
      new org.omg.CORBA.portable.MethodPointer("getPackList", 0, 15),
      new org.omg.CORBA.portable.MethodPointer("getExchangeRateList", 0, 16),
      new org.omg.CORBA.portable.MethodPointer("getPayModeList", 0, 17),
      new org.omg.CORBA.portable.MethodPointer("getInsuranceClassList", 0, 18),
      new org.omg.CORBA.portable.MethodPointer("getInsuranceDefineList", 0, 19),
      new org.omg.CORBA.portable.MethodPointer("getInsuranceTypeList", 0, 20),
      new org.omg.CORBA.portable.MethodPointer("getClauseList", 0, 21),
      new org.omg.CORBA.portable.MethodPointer("getEndorseReasonList", 0, 22),
      new org.omg.CORBA.portable.MethodPointer("getDepartmentList", 0, 23),
      new org.omg.CORBA.portable.MethodPointer("getAgentCharacterList", 0, 24),
      new org.omg.CORBA.portable.MethodPointer("getSurveyAgentList", 0, 25),
      new org.omg.CORBA.portable.MethodPointer("getCarriageList", 0, 26),
      new org.omg.CORBA.portable.MethodPointer("getVslLevelList", 0, 27),
      new org.omg.CORBA.portable.MethodPointer("getCertificateList", 0, 28),
      new org.omg.CORBA.portable.MethodPointer("getMajorList", 0, 29),
      new org.omg.CORBA.portable.MethodPointer("getMarriageList", 0, 30),
      new org.omg.CORBA.portable.MethodPointer("getSexList", 0, 31),
      new org.omg.CORBA.portable.MethodPointer("getEmployeeCodeList", 0, 32),
      new org.omg.CORBA.portable.MethodPointer("getPACrgoClsTypList", 0, 33),
      new org.omg.CORBA.portable.MethodPointer("getNetCodeList", 0, 34),
      new org.omg.CORBA.portable.MethodPointer("getCurrencyInfo", 0, 35),
      new org.omg.CORBA.portable.MethodPointer("getRptTelNum", 0, 36),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.cdt.orb._staticInfoManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.cdt.orb.staticInfoManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getNationalList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getAreaList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 2: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getProvinceList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCityList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getEduList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getTitleList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getDutyList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getTradeTypeList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 8: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getOrgTypeList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getOwnershipList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getScaleList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getPremiumScaleList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCurrencyList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.getCargoClsList(cde,insrnc_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 14: {
      try {
        java.lang.String Cargocls;
        Cargocls = _input.read_string();
        java.lang.String[][] _result = _self.getCargoTypeList(Cargocls);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getPackList(cde);
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
        java.lang.String cur1;
        cur1 = _input.read_string();
        java.lang.String cur2;
        cur2 = _input.read_string();
        java.lang.String[][] _result = _self.getExchangeRateList(cur1,cur2);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 17: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getPayModeList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 18: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getInsuranceClassList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 19: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getInsuranceDefineList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getInsuranceTypeList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 21: {
      try {
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String claus_cde;
        claus_cde = _input.read_string();
        java.lang.String add_mrk;
        add_mrk = _input.read_string();
        java.lang.String[][] _result = _self.getClauseList(insrnc_cde,claus_cde,add_mrk);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 22: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getEndorseReasonList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getDepartmentList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getAgentCharacterList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 25: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getSurveyAgentList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 26: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCarriageList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 27: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getVslLevelList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCertificateList(cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getMajorList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 30: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getMarriageList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 31: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getSexList(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 32: {
      try {
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getEmployeeCodeList(cde);
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
        java.lang.String in_crgo_cde;
        in_crgo_cde = _input.read_wstring();
        java.lang.String in_site_cde;
        in_site_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getPACrgoClsTypList(in_crgo_cde,in_site_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 34: {
      try {
        java.lang.String in_net_cde;
        in_net_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getNetCodeList(in_net_cde);
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
        java.lang.String cde;
        cde = _input.read_string();
        java.lang.String[][] _result = _self.getCurrencyInfo(cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 36: {
      try {
        java.lang.String in_dpt_cde;
        in_dpt_cde = _input.read_string();
        java.lang.String[][] _result = _self.getRptTelNum(in_dpt_cde);
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
