package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb.UserManagerHolder
<li> <b>Source File</b> com/mcip/bus/orb/UserManagerHolder.java
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
final public class UserManagerHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.bus.orb.UserManager value;
  public UserManagerHolder() {
  }
  public UserManagerHolder(com.mcip.bus.orb.UserManager value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.bus.orb.UserManagerHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.bus.orb.UserManagerHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.bus.orb.UserManagerHelper.type();
  }
}
