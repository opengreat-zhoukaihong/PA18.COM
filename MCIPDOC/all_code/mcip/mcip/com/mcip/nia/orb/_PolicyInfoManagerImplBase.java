package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb._PolicyInfoManagerImplBase
<li> <b>Source File</b> com/mcip/nia/orb/_PolicyInfoManagerImplBase.java
<li> <b>IDL Source File</b> policyInfoManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PolicyInfoManager
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PolicyInfoManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    interface PolicyInfoManager {
      ::com::mcip::orb::Stringss getOCList(
        in wstring user_id,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getOCInfo(
        in string OC_cde,
        in string insrnc_cde,
        in string crgo_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      wstring getPrintFormat(
        in wstring incondStr
      )
      raises(
        ::com::mcip::orb::CoException
      );
      wstring getPrintPolicy(
        in wstring incondStr
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyList(
        in wstring clnt_cde,
        in string insrnc_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyInfo(
        in string agt_agr_cde,
        in string insrnc_cde,
        in string crgo_cde,
        in string crgo_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getAgencyPlcyList(
        in string agt_agr_cde,
        in string insrnc_cde,
        in string credit_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustPlcyList(
        in wstring user_id,
        in string insrnc_cde,
        in string credit_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyAppList(
        in wstring user_id,
        in string plyapp_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyAppInfo(
        in string plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyList(
        in wstring user_id,
        in string policy_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyInfo(
        in string policy_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyInfoLatest(
        in string policy_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalInfo(
        in string plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEndorseProposalInfo(
        in string edrapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppRdrInfo(
        in string in_plyapp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyRdrInfo(
        in string in_ply_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptList(
        in wstring in_user_id,
        in string in_rpt_no,
        in string in_from_tm,
        in string in_to_tm,
        in string in_cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptInfo(
        in string in_rpt_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseClmList(
        in string in_rpt_no,
        in string in_status_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClaimList(
        in string in_clnt_cde,
        in string in_rpt_no,
        in string in_clm_no,
        in string in_from_tm,
        in string in_to_tm,
        in string in_status_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClmDgstList(
        in string in_rpt_no,
        in string in_ply_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getQuotation(
        in ::com::mcip::nia::orb::QuotaCndtn quotacndtnobj,
        in wstring rdr_type
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppNetAddress(
        in string cust_typ,
        in string in_clnt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getClauseList(
        in wstring in_insrnc_cde,
        in wstring in_clause_cde,
        in wstring in_clnt_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalList(
        in wstring user_id,
        in string plyapp_cde,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrAppList(
        in wstring user_id,
        in string edrapp_cde,
        in string ply_no,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrsmtList(
        in wstring user_id,
        in string edr_no,
        in string ply_no,
        in string app_from_tm,
        in string app_to_tm,
        in string cust_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrsmtInfo(
        in string edr_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPreEdrInfo(
        in string edr_app_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean checkEdrApp(
        in string ply_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
abstract public class _PolicyInfoManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.nia.orb.PolicyInfoManager {
  protected com.mcip.nia.orb.PolicyInfoManager _wrapper = null;
  public com.mcip.nia.orb.PolicyInfoManager _this() {
    return this;
  }
  protected _PolicyInfoManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _PolicyInfoManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.nia.orb.PolicyInfoManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/nia/orb/PolicyInfoManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("getOCList", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("getOCInfo", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("getPrintFormat", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("getPrintPolicy", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("getAgencyList", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("getAgencyInfo", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("getAgencyPlcyList", 0, 6),
      new org.omg.CORBA.portable.MethodPointer("getCustPlcyList", 0, 7),
      new org.omg.CORBA.portable.MethodPointer("getPolicyAppList", 0, 8),
      new org.omg.CORBA.portable.MethodPointer("getPolicyAppInfo", 0, 9),
      new org.omg.CORBA.portable.MethodPointer("getPolicyList", 0, 10),
      new org.omg.CORBA.portable.MethodPointer("getPolicyInfo", 0, 11),
      new org.omg.CORBA.portable.MethodPointer("getPolicyInfoLatest", 0, 12),
      new org.omg.CORBA.portable.MethodPointer("getProposalInfo", 0, 13),
      new org.omg.CORBA.portable.MethodPointer("getEndorseProposalInfo", 0, 14),
      new org.omg.CORBA.portable.MethodPointer("getPlyAppRdrInfo", 0, 15),
      new org.omg.CORBA.portable.MethodPointer("getPlyRdrInfo", 0, 16),
      new org.omg.CORBA.portable.MethodPointer("getCaseRptList", 0, 17),
      new org.omg.CORBA.portable.MethodPointer("getCaseRptInfo", 0, 18),
      new org.omg.CORBA.portable.MethodPointer("getCaseClmList", 0, 19),
      new org.omg.CORBA.portable.MethodPointer("getClaimList", 0, 20),
      new org.omg.CORBA.portable.MethodPointer("getClmDgstList", 0, 21),
      new org.omg.CORBA.portable.MethodPointer("getQuotation", 0, 22),
      new org.omg.CORBA.portable.MethodPointer("getPlyAppNetAddress", 0, 23),
      new org.omg.CORBA.portable.MethodPointer("getClauseList", 0, 24),
      new org.omg.CORBA.portable.MethodPointer("getProposalList", 0, 25),
      new org.omg.CORBA.portable.MethodPointer("getEdrAppList", 0, 26),
      new org.omg.CORBA.portable.MethodPointer("getEdrsmtList", 0, 27),
      new org.omg.CORBA.portable.MethodPointer("getEdrsmtInfo", 0, 28),
      new org.omg.CORBA.portable.MethodPointer("getPreEdrInfo", 0, 29),
      new org.omg.CORBA.portable.MethodPointer("checkEdrApp", 0, 30),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.nia.orb._PolicyInfoManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.nia.orb.PolicyInfoManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      try {
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.getOCList(user_id,insrnc_cde);
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
        java.lang.String OC_cde;
        OC_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String crgo_cde;
        crgo_cde = _input.read_string();
        java.lang.String[][] _result = _self.getOCInfo(OC_cde,insrnc_cde,crgo_cde);
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
        java.lang.String incondStr;
        incondStr = _input.read_wstring();
        java.lang.String _result = _self.getPrintFormat(incondStr);
        _output.write_wstring(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 3: {
      try {
        java.lang.String incondStr;
        incondStr = _input.read_wstring();
        java.lang.String _result = _self.getPrintPolicy(incondStr);
        _output.write_wstring(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 4: {
      try {
        java.lang.String clnt_cde;
        clnt_cde = _input.read_wstring();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String[][] _result = _self.getAgencyList(clnt_cde,insrnc_cde);
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
        java.lang.String agt_agr_cde;
        agt_agr_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String crgo_cde;
        crgo_cde = _input.read_string();
        java.lang.String crgo_typ;
        crgo_typ = _input.read_string();
        java.lang.String[][] _result = _self.getAgencyInfo(agt_agr_cde,insrnc_cde,crgo_cde,crgo_typ);
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
        java.lang.String agt_agr_cde;
        agt_agr_cde = _input.read_string();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String credit_id;
        credit_id = _input.read_string();
        java.lang.String[][] _result = _self.getAgencyPlcyList(agt_agr_cde,insrnc_cde,credit_id);
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
        java.lang.String user_id;
        user_id = _input.read_wstring();
        java.lang.String insrnc_cde;
        insrnc_cde = _input.read_string();
        java.lang.String credit_cde;
        credit_cde = _input.read_string();
        java.lang.String[][] _result = _self.getCustPlcyList(user_id,insrnc_cde,credit_cde);
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
        java.lang.String[][] _result = _self.getPolicyAppList(user_id,plyapp_cde,app_from_tm,app_to_tm,cust_typ);
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
        java.lang.String plyapp_cde;
        plyapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyAppInfo(plyapp_cde);
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
        java.lang.String[][] _result = _self.getPolicyList(user_id,policy_cde,app_from_tm,app_to_tm,cust_typ);
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
        java.lang.String policy_cde;
        policy_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyInfo(policy_cde);
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
        java.lang.String policy_cde;
        policy_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPolicyInfoLatest(policy_cde);
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
        java.lang.String plyapp_cde;
        plyapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getProposalInfo(plyapp_cde);
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
        java.lang.String edrapp_cde;
        edrapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getEndorseProposalInfo(edrapp_cde);
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
        java.lang.String in_plyapp_cde;
        in_plyapp_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPlyAppRdrInfo(in_plyapp_cde);
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
        java.lang.String in_ply_cde;
        in_ply_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPlyRdrInfo(in_ply_cde);
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
        java.lang.String[][] _result = _self.getCaseRptList(in_user_id,in_rpt_no,in_from_tm,in_to_tm,in_cust_typ);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String[][] _result = _self.getCaseRptInfo(in_rpt_no);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_status_mrk;
        in_status_mrk = _input.read_string();
        java.lang.String[][] _result = _self.getCaseClmList(in_rpt_no,in_status_mrk);
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
        java.lang.String[][] _result = _self.getClaimList(in_clnt_cde,in_rpt_no,in_clm_no,in_from_tm,in_to_tm,in_status_mrk);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String[][] _result = _self.getClmDgstList(in_rpt_no,in_ply_no);
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
        com.mcip.nia.orb.QuotaCndtn quotacndtnobj;
        quotacndtnobj = com.mcip.nia.orb.QuotaCndtnHelper.read(_input);
        java.lang.String rdr_type;
        rdr_type = _input.read_wstring();
        java.lang.String[][] _result = _self.getQuotation(quotacndtnobj,rdr_type);
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
        java.lang.String cust_typ;
        cust_typ = _input.read_string();
        java.lang.String in_clnt_cde;
        in_clnt_cde = _input.read_string();
        java.lang.String[][] _result = _self.getPlyAppNetAddress(cust_typ,in_clnt_cde);
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
        java.lang.String in_insrnc_cde;
        in_insrnc_cde = _input.read_wstring();
        java.lang.String in_clause_cde;
        in_clause_cde = _input.read_wstring();
        java.lang.String in_clnt_cnm;
        in_clnt_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.getClauseList(in_insrnc_cde,in_clause_cde,in_clnt_cnm);
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
        java.lang.String[][] _result = _self.getProposalList(user_id,plyapp_cde,app_from_tm,app_to_tm,cust_typ);
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
        java.lang.String[][] _result = _self.getEdrAppList(user_id,edrapp_cde,ply_no,app_from_tm,app_to_tm,cust_typ);
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
        java.lang.String[][] _result = _self.getEdrsmtList(user_id,edr_no,ply_no,app_from_tm,app_to_tm,cust_typ);
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
        java.lang.String edr_no;
        edr_no = _input.read_string();
        java.lang.String[][] _result = _self.getEdrsmtInfo(edr_no);
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
        java.lang.String edr_app_no;
        edr_app_no = _input.read_string();
        java.lang.String[][] _result = _self.getPreEdrInfo(edr_app_no);
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
        java.lang.String ply_no;
        ply_no = _input.read_string();
        boolean _result = _self.checkEdrApp(ply_no);
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
