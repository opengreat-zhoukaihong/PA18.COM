package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.UserManagerHelper
<li> <b>Source File</b> com/mcip/bus/orb/UserManagerHelper.java
<li> <b>IDL Source File</b> userManage.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::bus::orb::UserManager
<li> <b>Repository Identifier</b> IDL:com/mcip/bus/orb/UserManager:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/bus/orb"
    interface UserManager {
      ::com::mcip::orb::Stringss operatorLogin(
        in wstring usrname,
        in wstring passwd
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptOperator(
        in ::com::mcip::bus::orb::OperatorInfo operatorinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateOperator(
        in ::com::mcip::bus::orb::OperatorInfo operatorinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteOperator(
        in string auth_dpt_cde,
        in wstring auth_opr_cde,
        in wstring del_opr_cde,
        in string rcsv_del_flg
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrInfo(
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrList(
        in wstring in_opr_cde,
        in string in_emp_cde,
        in wstring adm_opr_cde,
        in string adm_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryAuthList(
        in wstring in_opr_cde,
        in string in_emp_cde,
        in wstring adm_opr_cde,
        in string adm_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptOptrAuth(
        in ::com::mcip::orb::Stringss oprauthInfoobj,
        in ::com::mcip::orb::Stringss oprdptinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateOptrAuth(
        in ::com::mcip::orb::Stringss oprauthInfoobj,
        in ::com::mcip::orb::Stringss oprdptinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteOptrAuth(
        in wstring in_opr_cde,
        in wstring in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrDptList(
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryAbleDptList(
        in wstring in_opr_cde,
        in wstring auth_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptSysFunc(
        in ::com::mcip::bus::orb::SysFuncInfo sysfuncinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateSysFunc(
        in ::com::mcip::bus::orb::SysFuncInfo sysfuncinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteSysFunc(
        in wstring in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySysFuncList(
        in string in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptPagesInfo(
        in ::com::mcip::bus::orb::PagesInfo pagesinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updatePagesInfo(
        in ::com::mcip::bus::orb::PagesInfo pagesinfoobj
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deletePagesInfo(
        in string in_page_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryPagesList(
        in string in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean executeOptrAuth(
        in string act_typ,
        in wstring auth_opr_cde,
        in wstring in_opr_cde,
        in ::com::mcip::orb::Stringss oprauthInfo,
        in ::com::mcip::orb::Stringss oprdptinfo
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean checkOptrAuth(
        in wstring in_optr_cde,
        in string in_func_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryCustEnttList(
        in wstring in_opr_cde,
        in string in_verify_flg,
        in ::com::mcip::orb::Strings in_dpt_cde,
        in string frm_crt_tm,
        in string to_crt_tm,
        in string frm_verify_tm,
        in string to_verify_tm,
        in long frm_ltimes,
        in long to_ltimes,
        in wstring in_user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySameCustList(
        in wstring in_clnt_cnm
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptUserVerify(
        in wstring in_user_id,
        in string in_clnt_cde,
        in string in_cmpny_agt_cde,
        in string in_verify_flg,
        in wstring in_vrfy_desc,
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean replaceAuthOptr(
        in wstring org_optr_cde,
        in wstring trgt_optr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean compareAuthDptOptr(
        in wstring org_optr_cde,
        in wstring trgt_optr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryOptrAuthList(
        in wstring in_opr_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySubDptList(
        in wstring in_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptClntMapInfo(
        in wstring opr_cde,
        in string clnt_agt_flg,
        in wstring user_id,
        in string clnt_cde,
        in wstring main_flg
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateClntMapInfo(
        in wstring opr_cde,
        in string clnt_agt_flg,
        in wstring new_user_id,
        in string new_clnt_cde,
        in wstring main_flg,
        in wstring old_user_id,
        in string old_clnt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteClntMapInfo(
        in wstring opr_cde,
        in wstring user_id,
        in string clnt_cde,
        in string clnt_agt_flg
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss queryClntMapList(
        in wstring opr_cde,
        in wstring user_id
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean executeSysadmAuth(
        in string act_typ,
        in wstring auth_opr_cde,
        in wstring in_opr_cde,
        in wstring in_dpt_cde
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss getDptCEnm(
        in wstring dpt_cde,
        in wstring cenm_typ
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean acceptSuppEmail(
        in wstring emp_cde,
        in wstring emp_nme,
        in wstring dpt_cde,
        in wstring emp_type,
        in wstring emp_email
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean updateSuppEmail(
        in wstring emp_cde,
        in wstring emp_nme,
        in wstring dpt_cde,
        in wstring emp_type,
        in wstring emp_email,
        in wstring supp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      boolean deleteSuppEmail(
        in wstring supp_no
      )
      raises(
        ::com::mcip::orb::CoException
      );
      ::com::mcip::orb::Stringss querySuppEmailList(
        in wstring emp_nme,
        in ::com::mcip::orb::Strings dpt_cde,
        in wstring emp_type
      )
      raises(
        ::com::mcip::orb::CoException
      );
    };
</pre>
</p>
*/
abstract public class UserManagerHelper {
  public static com.mcip.bus.orb.UserManager narrow(org.omg.CORBA.Object object) {
    return narrow(object, false);
  }
  private static com.mcip.bus.orb.UserManager narrow(org.omg.CORBA.Object object, boolean is_a) {
    if(object == null) {
      return null;
    }
    if(object instanceof com.mcip.bus.orb.UserManager) {
      return (com.mcip.bus.orb.UserManager) object;
    }
    if(is_a || object._is_a(id())) {
      com.mcip.bus.orb._st_UserManager result = (com.mcip.bus.orb._st_UserManager)new com.mcip.bus.orb._st_UserManager();
      ((org.omg.CORBA.portable.ObjectImpl) result)._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      ((org.omg.CORBA.portable.ObjectImpl) result._this())._set_delegate
        (((org.omg.CORBA.portable.ObjectImpl) object)._get_delegate());
      return (com.mcip.bus.orb.UserManager) result._this();
    }
    return null;
  }
  public static com.mcip.bus.orb.UserManager bind(org.omg.CORBA.ORB orb) {
    return bind(orb, null, null, null);
  }
  public static com.mcip.bus.orb.UserManager bind(org.omg.CORBA.ORB orb, java.lang.String name) {
    return bind(orb, name, null, null);
  }
  public static com.mcip.bus.orb.UserManager bind(org.omg.CORBA.ORB orb, java.lang.String name, java.lang.String host, org.omg.CORBA.BindOptions options) {
    if (orb instanceof com.visigenic.vbroker.orb.ORB) {
      return narrow(((com.visigenic.vbroker.orb.ORB)orb).bind(id(), name, host, options), true);
    }
    else {
      throw new org.omg.CORBA.BAD_PARAM();
    }
  }
  private static org.omg.CORBA.ORB _orb() {
    return org.omg.CORBA.ORB.init();
  }
  public static com.mcip.bus.orb.UserManager read(org.omg.CORBA.portable.InputStream _input) {
    return com.mcip.bus.orb.UserManagerHelper.narrow(_input.read_Object(), true);
  }
  public static void write(org.omg.CORBA.portable.OutputStream _output, com.mcip.bus.orb.UserManager value) {
    _output.write_Object(value);
  }
  public static void insert(org.omg.CORBA.Any any, com.mcip.bus.orb.UserManager value) {
    org.omg.CORBA.portable.OutputStream output = any.create_output_stream();
    write(output, value);
    any.read_value(output.create_input_stream(), type());
  }
  public static com.mcip.bus.orb.UserManager extract(org.omg.CORBA.Any any) {
    if(!any.type().equal(type())) {
      throw new org.omg.CORBA.BAD_TYPECODE();
    }
    return read(any.create_input_stream());
  }
  private static org.omg.CORBA.TypeCode _type;
  public static org.omg.CORBA.TypeCode type() {
    if(_type == null) {
      _type = _orb().create_interface_tc(id(), "UserManager");
    }
    return _type;
  }
  public static java.lang.String id() {
    return "IDL:com/mcip/bus/orb/UserManager:1.0";
  }
}
