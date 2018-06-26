package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb._BusinessManagerImplBase
<li> <b>Source File</b> com/mcip/bus/orb/_BusinessManagerImplBase.java
<li> <b>IDL Source File</b> businessManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::BusinessManager
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/BusinessManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    interface BusinessManager {
      boolean isAlive();
      ::com::mcip::orb::Stringss queryPlyNetList(
        in wstring in_opr_cde,
        in string in_prnt_flg,
        in string in_ply_no,
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in ::com::mcip::orb::Strings dpt_array
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPlyNetInfo(
        in ::com::mcip::orb::Strings ply_no_array
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePrintInfo(
        in ::com::mcip::orb::Strings ply_no_array,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPlyAssign(
        in string in_ply_no,
        in wstring in_assign_emp,
        in string in_assign_tm,
        in string in_sended_tm,
        in string in_feedbk_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPlySended(
        in string in_ply_no,
        in string in_sended_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPlyFreebk(
        in string in_ply_no,
        in string in_freebk_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPlyNetAbleEmp(
        in wstring in_dpt_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPlyDealList(
        in string in_deal_type,
        in string in_deal_flg,
        in string in_ply_no,
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in ::com::mcip::orb::Strings dpt_array,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryRptFlwUpList(
        in string in_deal_type,
        in string in_deal_flg,
        in string in_ply_no,
        in string in_rpt_no,
        in string frm_rpt_tm,
        in string to_rpt_tm,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in ::com::mcip::orb::Strings dpt_array,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptRptFlwUpEmp(
        in string in_rpt_no,
        in wstring in_emp_cde,
        in wstring auth_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryEventTypeList(
        in wstring in_event_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryEventCountList(
        in string frm_log_tm,
        in string to_log_tm,
        in wstring in_event_typ,
        in wstring in_event_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptGuideInfo(
        in ::com::mcip::bus::orb::InsrncGuideInfo guideinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateGuideInfo(
        in ::com::mcip::bus::orb::InsrncGuideInfo guideinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteGuideInfo(
        in wstring in_info_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryGuideList(
        in wstring in_info_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryGuideInfo(
        in wstring in_info_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptConsultInfo(
        in ::com::mcip::bus::orb::InsrncFaqInfo insrncfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateConsultInfo(
        in ::com::mcip::bus::orb::InsrncFaqInfo insrncfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteConsultInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryConsultList(
        in wstring in_topic_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryConsultInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptFaqInfo(
        in ::com::mcip::bus::orb::CustFaqInfo custfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateFaqInfo(
        in ::com::mcip::bus::orb::CustFaqInfo custfaqinfoobj,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteFaqInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryFaqList(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryFaqInfo(
        in wstring in_faq_no,
        in wstring in_opr_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPlyAppStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_stat_type,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getPolicyStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getEdrPlcyStatictics(
        in string frm_edrapp_tm,
        in string to_edrapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getProposalStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCaseRptStatictics(
        in string frm_plyapp_tm,
        in string to_plyapp_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring frm_insrnc_cde,
        in wstring to_insrnc_cde,
        in wstring in_cur_cde,
        in wstring in_site_cde,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustStatictics(
        in string frm_crt_tm,
        in string to_crt_tm,
        in ::com::mcip::orb::Strings owned_dpt,
        in wstring frm_dpt,
        in wstring to_dpt,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptClmDgst(
        in ::com::mcip::bus::orb::ClmDgstInfo clmdgstinfoobj,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateClmDgst(
        in ::com::mcip::bus::orb::ClmDgstInfo clmdgstinfoobj,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteClmDgst(
        in wstring in_rpt_no,
        in wstring in_ply_no,
        in wstring in_info_no,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryClmDgstInfo(
        in wstring in_rpt_no,
        in wstring in_ply_no,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptChatCntnt(
        in wstring in_bgn_tm,
        in wstring in_end_tm,
        in wstring in_chat_ttl,
        in ::com::mcip::orb::Strings chat_cntnt,
        in wstring in_chat_nme,
        in wstring in_chat_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryChatCntnt(
        in wstring in_chat_ttl,
        in wstring in_chat_mrk
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustPlyAppList(
        in wstring in_user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getCustPlySum(
        in wstring in_user_id,
        in ::com::mcip::orb::Strings in_insrnc_cde,
        in wstring in_sum_tm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getChatRight(
        in wstring in_emp_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
abstract public class _BusinessManagerImplBase extends com.inprise.vbroker.CORBA.portable.Skeleton implements com.mcip.bus.orb.BusinessManager {
  protected com.mcip.bus.orb.BusinessManager _wrapper = null;
  public com.mcip.bus.orb.BusinessManager _this() {
    return this;
  }
  protected _BusinessManagerImplBase(java.lang.String name) {
    super(name);
  }
  public _BusinessManagerImplBase() {
  }
  public java.lang.String toString() {
    try {
      return super.toString();
    } catch (org.omg.CORBA.SystemException ex) { // delegate may not be set yet
      return "Unbound instance of com.mcip.bus.orb.BusinessManager";
    }
  }
  public java.lang.String[] _ids() {
    return __ids;
  }
  private static java.lang.String[] __ids = {
    "IDL:com/mcip/bus/orb/BusinessManager:1.0"
  };
  public org.omg.CORBA.portable.MethodPointer[] _methods() {
    org.omg.CORBA.portable.MethodPointer[] methods = {
      new org.omg.CORBA.portable.MethodPointer("isAlive", 0, 0),
      new org.omg.CORBA.portable.MethodPointer("queryPlyNetList", 0, 1),
      new org.omg.CORBA.portable.MethodPointer("queryPlyNetInfo", 0, 2),
      new org.omg.CORBA.portable.MethodPointer("updatePrintInfo", 0, 3),
      new org.omg.CORBA.portable.MethodPointer("acceptPlyAssign", 0, 4),
      new org.omg.CORBA.portable.MethodPointer("acceptPlySended", 0, 5),
      new org.omg.CORBA.portable.MethodPointer("acceptPlyFreebk", 0, 6),
      new org.omg.CORBA.portable.MethodPointer("queryPlyNetAbleEmp", 0, 7),
      new org.omg.CORBA.portable.MethodPointer("queryPlyDealList", 0, 8),
      new org.omg.CORBA.portable.MethodPointer("queryRptFlwUpList", 0, 9),
      new org.omg.CORBA.portable.MethodPointer("acceptRptFlwUpEmp", 0, 10),
      new org.omg.CORBA.portable.MethodPointer("queryEventTypeList", 0, 11),
      new org.omg.CORBA.portable.MethodPointer("queryEventCountList", 0, 12),
      new org.omg.CORBA.portable.MethodPointer("acceptGuideInfo", 0, 13),
      new org.omg.CORBA.portable.MethodPointer("updateGuideInfo", 0, 14),
      new org.omg.CORBA.portable.MethodPointer("deleteGuideInfo", 0, 15),
      new org.omg.CORBA.portable.MethodPointer("queryGuideList", 0, 16),
      new org.omg.CORBA.portable.MethodPointer("queryGuideInfo", 0, 17),
      new org.omg.CORBA.portable.MethodPointer("acceptConsultInfo", 0, 18),
      new org.omg.CORBA.portable.MethodPointer("updateConsultInfo", 0, 19),
      new org.omg.CORBA.portable.MethodPointer("deleteConsultInfo", 0, 20),
      new org.omg.CORBA.portable.MethodPointer("queryConsultList", 0, 21),
      new org.omg.CORBA.portable.MethodPointer("queryConsultInfo", 0, 22),
      new org.omg.CORBA.portable.MethodPointer("acceptFaqInfo", 0, 23),
      new org.omg.CORBA.portable.MethodPointer("updateFaqInfo", 0, 24),
      new org.omg.CORBA.portable.MethodPointer("deleteFaqInfo", 0, 25),
      new org.omg.CORBA.portable.MethodPointer("queryFaqList", 0, 26),
      new org.omg.CORBA.portable.MethodPointer("queryFaqInfo", 0, 27),
      new org.omg.CORBA.portable.MethodPointer("getPlyAppStatictics", 0, 28),
      new org.omg.CORBA.portable.MethodPointer("getPolicyStatictics", 0, 29),
      new org.omg.CORBA.portable.MethodPointer("getEdrPlcyStatictics", 0, 30),
      new org.omg.CORBA.portable.MethodPointer("getProposalStatictics", 0, 31),
      new org.omg.CORBA.portable.MethodPointer("getCaseRptStatictics", 0, 32),
      new org.omg.CORBA.portable.MethodPointer("getCustStatictics", 0, 33),
      new org.omg.CORBA.portable.MethodPointer("acceptClmDgst", 0, 34),
      new org.omg.CORBA.portable.MethodPointer("updateClmDgst", 0, 35),
      new org.omg.CORBA.portable.MethodPointer("deleteClmDgst", 0, 36),
      new org.omg.CORBA.portable.MethodPointer("queryClmDgstInfo", 0, 37),
      new org.omg.CORBA.portable.MethodPointer("acceptChatCntnt", 0, 38),
      new org.omg.CORBA.portable.MethodPointer("queryChatCntnt", 0, 39),
      new org.omg.CORBA.portable.MethodPointer("getCustPlyAppList", 0, 40),
      new org.omg.CORBA.portable.MethodPointer("getCustPlySum", 0, 41),
      new org.omg.CORBA.portable.MethodPointer("getChatRight", 0, 42),
    };
    return methods;
  }
  public boolean _execute(org.omg.CORBA.portable.MethodPointer method, org.omg.CORBA.portable.InputStream input, org.omg.CORBA.portable.OutputStream output) {
    switch(method.interface_id) {
    case 0: {
      return com.mcip.bus.orb._BusinessManagerImplBase._execute(_this(), method.method_id, input, output); 
    }
    }
    throw new org.omg.CORBA.MARSHAL();
  }
  public static boolean _execute(com.mcip.bus.orb.BusinessManager _self, int _method_id, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.OutputStream _output) {
    switch(_method_id) {
    case 0: {
      boolean _result = _self.isAlive();
      _output.write_boolean(_result);
      return false;
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
        java.lang.String[][] _result = _self.queryPlyNetList(in_opr_cde,in_prnt_flg,in_ply_no,frm_plyapp_tm,to_plyapp_tm,frm_insrnc_cde,to_insrnc_cde,dpt_array);
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
        java.lang.String[] ply_no_array;
        ply_no_array = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String[][] _result = _self.queryPlyNetInfo(ply_no_array);
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
        java.lang.String[] ply_no_array;
        ply_no_array = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.updatePrintInfo(ply_no_array,in_opr_cde);
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
        boolean _result = _self.acceptPlyAssign(in_ply_no,in_assign_emp,in_assign_tm,in_sended_tm,in_feedbk_tm);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 5: {
      try {
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String in_sended_tm;
        in_sended_tm = _input.read_string();
        boolean _result = _self.acceptPlySended(in_ply_no,in_sended_tm);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 6: {
      try {
        java.lang.String in_ply_no;
        in_ply_no = _input.read_string();
        java.lang.String in_freebk_tm;
        in_freebk_tm = _input.read_string();
        boolean _result = _self.acceptPlyFreebk(in_ply_no,in_freebk_tm);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 7: {
      try {
        java.lang.String in_dpt_cde;
        in_dpt_cde = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryPlyNetAbleEmp(in_dpt_cde,in_opr_cde);
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
        java.lang.String[][] _result = _self.queryPlyDealList(in_deal_type,in_deal_flg,in_ply_no,frm_plyapp_tm,to_plyapp_tm,frm_insrnc_cde,to_insrnc_cde,dpt_array,in_opr_cde);
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
        java.lang.String[][] _result = _self.queryRptFlwUpList(in_deal_type,in_deal_flg,in_ply_no,in_rpt_no,frm_rpt_tm,to_rpt_tm,frm_insrnc_cde,to_insrnc_cde,dpt_array,in_opr_cde);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_string();
        java.lang.String in_emp_cde;
        in_emp_cde = _input.read_wstring();
        java.lang.String auth_opr_cde;
        auth_opr_cde = _input.read_wstring();
        boolean _result = _self.acceptRptFlwUpEmp(in_rpt_no,in_emp_cde,auth_opr_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 11: {
      try {
        java.lang.String in_event_cde;
        in_event_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryEventTypeList(in_event_cde);
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
        java.lang.String[][] _result = _self.queryEventCountList(frm_log_tm,to_log_tm,in_event_typ,in_event_cde,in_opr_cde);
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
        com.mcip.bus.orb.InsrncGuideInfo guideinfoobj;
        guideinfoobj = com.mcip.bus.orb.InsrncGuideInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.acceptGuideInfo(guideinfoobj,in_opr_cnm);
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
        com.mcip.bus.orb.InsrncGuideInfo guideinfoobj;
        guideinfoobj = com.mcip.bus.orb.InsrncGuideInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.updateGuideInfo(guideinfoobj,in_opr_cnm);
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
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.deleteGuideInfo(in_info_no,in_opr_cnm);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 16: {
      try {
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryGuideList(in_info_no,in_opr_cnm);
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
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryGuideInfo(in_info_no,in_opr_cnm);
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
        com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj;
        insrncfaqinfoobj = com.mcip.bus.orb.InsrncFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.acceptConsultInfo(insrncfaqinfoobj,in_opr_cnm);
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
        com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj;
        insrncfaqinfoobj = com.mcip.bus.orb.InsrncFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.updateConsultInfo(insrncfaqinfoobj,in_opr_cnm);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 20: {
      try {
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.deleteConsultInfo(in_faq_no,in_opr_cnm);
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
        java.lang.String in_topic_no;
        in_topic_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryConsultList(in_topic_no,in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryConsultInfo(in_faq_no,in_opr_cnm);
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
        com.mcip.bus.orb.CustFaqInfo custfaqinfoobj;
        custfaqinfoobj = com.mcip.bus.orb.CustFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.acceptFaqInfo(custfaqinfoobj,in_opr_cnm);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 24: {
      try {
        com.mcip.bus.orb.CustFaqInfo custfaqinfoobj;
        custfaqinfoobj = com.mcip.bus.orb.CustFaqInfoHelper.read(_input);
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.updateFaqInfo(custfaqinfoobj,in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        boolean _result = _self.deleteFaqInfo(in_faq_no,in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryFaqList(in_faq_no,in_opr_cnm);
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
        java.lang.String in_faq_no;
        in_faq_no = _input.read_wstring();
        java.lang.String in_opr_cnm;
        in_opr_cnm = _input.read_wstring();
        java.lang.String[][] _result = _self.queryFaqInfo(in_faq_no,in_opr_cnm);
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
        java.lang.String[][] _result = _self.getPlyAppStatictics(frm_plyapp_tm,to_plyapp_tm,owned_dpt,frm_dpt,to_dpt,frm_insrnc_cde,to_insrnc_cde,in_cur_cde,in_site_cde,in_stat_type,in_opr_cde);
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
        java.lang.String[][] _result = _self.getPolicyStatictics(frm_plyapp_tm,to_plyapp_tm,owned_dpt,frm_dpt,to_dpt,frm_insrnc_cde,to_insrnc_cde,in_cur_cde,in_site_cde,in_opr_cde);
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
        java.lang.String[][] _result = _self.getEdrPlcyStatictics(frm_edrapp_tm,to_edrapp_tm,owned_dpt,frm_dpt,to_dpt,frm_insrnc_cde,to_insrnc_cde,in_cur_cde,in_site_cde,in_opr_cde);
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
        java.lang.String[][] _result = _self.getProposalStatictics(frm_plyapp_tm,to_plyapp_tm,owned_dpt,frm_dpt,to_dpt,frm_insrnc_cde,to_insrnc_cde,in_cur_cde,in_site_cde,in_opr_cde);
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
        java.lang.String[][] _result = _self.getCaseRptStatictics(frm_plyapp_tm,to_plyapp_tm,owned_dpt,frm_dpt,to_dpt,frm_insrnc_cde,to_insrnc_cde,in_cur_cde,in_site_cde,in_opr_cde);
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
        java.lang.String[][] _result = _self.getCustStatictics(frm_crt_tm,to_crt_tm,owned_dpt,frm_dpt,to_dpt,in_opr_cde);
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
        com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj;
        clmdgstinfoobj = com.mcip.bus.orb.ClmDgstInfoHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.acceptClmDgst(clmdgstinfoobj,in_opr_cde);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 35: {
      try {
        com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj;
        clmdgstinfoobj = com.mcip.bus.orb.ClmDgstInfoHelper.read(_input);
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.updateClmDgst(clmdgstinfoobj,in_opr_cde);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_wstring();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_wstring();
        java.lang.String in_info_no;
        in_info_no = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        boolean _result = _self.deleteClmDgst(in_rpt_no,in_ply_no,in_info_no,in_opr_cde);
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
        java.lang.String in_rpt_no;
        in_rpt_no = _input.read_wstring();
        java.lang.String in_ply_no;
        in_ply_no = _input.read_wstring();
        java.lang.String in_opr_cde;
        in_opr_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.queryClmDgstInfo(in_rpt_no,in_ply_no,in_opr_cde);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
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
        boolean _result = _self.acceptChatCntnt(in_bgn_tm,in_end_tm,in_chat_ttl,chat_cntnt,in_chat_nme,in_chat_mrk);
        _output.write_boolean(_result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 39: {
      try {
        java.lang.String in_chat_ttl;
        in_chat_ttl = _input.read_wstring();
        java.lang.String in_chat_mrk;
        in_chat_mrk = _input.read_wstring();
        java.lang.String[][] _result = _self.queryChatCntnt(in_chat_ttl,in_chat_mrk);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 40: {
      try {
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String[][] _result = _self.getCustPlyAppList(in_user_id);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 41: {
      try {
        java.lang.String in_user_id;
        in_user_id = _input.read_wstring();
        java.lang.String[] in_insrnc_cde;
        in_insrnc_cde = com.mcip.orb.StringsHelper.read(_input);
        java.lang.String in_sum_tm;
        in_sum_tm = _input.read_wstring();
        java.lang.String[][] _result = _self.getCustPlySum(in_user_id,in_insrnc_cde,in_sum_tm);
        com.mcip.orb.StringssHelper.write(_output, _result);
      }
      catch(com.mcip.orb.CoException _exception) {
        com.mcip.orb.CoExceptionHelper.write(_output, _exception);
        return true;
      }
      return false;
    }
    case 42: {
      try {
        java.lang.String in_emp_cde;
        in_emp_cde = _input.read_wstring();
        java.lang.String[][] _result = _self.getChatRight(in_emp_cde);
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
