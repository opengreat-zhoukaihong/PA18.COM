package com.mcip.bus.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.bus.orb._example_UserManager
<li> <b>Source File</b> com/mcip/bus/orb/_example_UserManager.java
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
public class _example_UserManager extends com.mcip.bus.orb._UserManagerImplBase {
  /** Construct a persistently named object. */
  public _example_UserManager(java.lang.String name) {
    super(name);
  }
  /** Construct a transient object. */
  public _example_UserManager() {
    super();
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::operatorLogin</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss operatorLogin(
      in wstring usrname,
      in wstring passwd
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] operatorLogin(
    java.lang.String usrname,
    java.lang.String passwd
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::acceptOperator</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean acceptOperator(
      in ::com::mcip::bus::orb::OperatorInfo operatorinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptOperator(
    com.mcip.bus.orb.OperatorInfo operatorinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::updateOperator</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean updateOperator(
      in ::com::mcip::bus::orb::OperatorInfo operatorinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateOperator(
    com.mcip.bus.orb.OperatorInfo operatorinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::deleteOperator</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean deleteOperator(
      in string auth_dpt_cde,
      in wstring auth_opr_cde,
      in wstring del_opr_cde,
      in string rcsv_del_flg
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteOperator(
    java.lang.String auth_dpt_cde,
    java.lang.String auth_opr_cde,
    java.lang.String del_opr_cde,
    java.lang.String rcsv_del_flg
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryOptrInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryOptrInfo(
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryOptrInfo(
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryOptrList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryOptrList(
      in wstring in_opr_cde,
      in string in_emp_cde,
      in wstring adm_opr_cde,
      in string adm_dpt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryOptrList(
    java.lang.String in_opr_cde,
    java.lang.String in_emp_cde,
    java.lang.String adm_opr_cde,
    java.lang.String adm_dpt_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryAuthList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryAuthList(
      in wstring in_opr_cde,
      in string in_emp_cde,
      in wstring adm_opr_cde,
      in string adm_dpt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryAuthList(
    java.lang.String in_opr_cde,
    java.lang.String in_emp_cde,
    java.lang.String adm_opr_cde,
    java.lang.String adm_dpt_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::acceptOptrAuth</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean acceptOptrAuth(
      in ::com::mcip::orb::Stringss oprauthInfoobj,
      in ::com::mcip::orb::Stringss oprdptinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptOptrAuth(
    java.lang.String[][] oprauthInfoobj,
    java.lang.String[][] oprdptinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::updateOptrAuth</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean updateOptrAuth(
      in ::com::mcip::orb::Stringss oprauthInfoobj,
      in ::com::mcip::orb::Stringss oprdptinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateOptrAuth(
    java.lang.String[][] oprauthInfoobj,
    java.lang.String[][] oprdptinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::deleteOptrAuth</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean deleteOptrAuth(
      in wstring in_opr_cde,
      in wstring in_func_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteOptrAuth(
    java.lang.String in_opr_cde,
    java.lang.String in_func_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryOptrDptList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryOptrDptList(
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryOptrDptList(
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryAbleDptList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryAbleDptList(
      in wstring in_opr_cde,
      in wstring auth_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryAbleDptList(
    java.lang.String in_opr_cde,
    java.lang.String auth_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::acceptSysFunc</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean acceptSysFunc(
      in ::com::mcip::bus::orb::SysFuncInfo sysfuncinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptSysFunc(
    com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::updateSysFunc</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean updateSysFunc(
      in ::com::mcip::bus::orb::SysFuncInfo sysfuncinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updateSysFunc(
    com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::deleteSysFunc</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean deleteSysFunc(
      in wstring in_func_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteSysFunc(
    java.lang.String in_func_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::querySysFuncList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss querySysFuncList(
      in string in_func_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] querySysFuncList(
    java.lang.String in_func_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::acceptPagesInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean acceptPagesInfo(
      in ::com::mcip::bus::orb::PagesInfo pagesinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean acceptPagesInfo(
    com.mcip.bus.orb.PagesInfo pagesinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::updatePagesInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean updatePagesInfo(
      in ::com::mcip::bus::orb::PagesInfo pagesinfoobj
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean updatePagesInfo(
    com.mcip.bus.orb.PagesInfo pagesinfoobj
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::deletePagesInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean deletePagesInfo(
      in string in_page_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deletePagesInfo(
    java.lang.String in_page_no
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryPagesList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryPagesList(
      in string in_func_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryPagesList(
    java.lang.String in_func_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::executeOptrAuth</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
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
  </pre>
  </p>
  */
  public boolean executeOptrAuth(
    java.lang.String act_typ,
    java.lang.String auth_opr_cde,
    java.lang.String in_opr_cde,
    java.lang.String[][] oprauthInfo,
    java.lang.String[][] oprdptinfo
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::checkOptrAuth</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean checkOptrAuth(
      in wstring in_optr_cde,
      in string in_func_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean checkOptrAuth(
    java.lang.String in_optr_cde,
    java.lang.String in_func_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryCustEnttList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
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
  </pre>
  </p>
  */
  public java.lang.String[][] queryCustEnttList(
    java.lang.String in_opr_cde,
    java.lang.String in_verify_flg,
    java.lang.String[] in_dpt_cde,
    java.lang.String frm_crt_tm,
    java.lang.String to_crt_tm,
    java.lang.String frm_verify_tm,
    java.lang.String to_verify_tm,
    int frm_ltimes,
    int to_ltimes,
    java.lang.String in_user_id
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::querySameCustList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss querySameCustList(
      in wstring in_clnt_cnm
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] querySameCustList(
    java.lang.String in_clnt_cnm
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::acceptUserVerify</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
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
  </pre>
  </p>
  */
  public boolean acceptUserVerify(
    java.lang.String in_user_id,
    java.lang.String in_clnt_cde,
    java.lang.String in_cmpny_agt_cde,
    java.lang.String in_verify_flg,
    java.lang.String in_vrfy_desc,
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::replaceAuthOptr</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean replaceAuthOptr(
      in wstring org_optr_cde,
      in wstring trgt_optr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean replaceAuthOptr(
    java.lang.String org_optr_cde,
    java.lang.String trgt_optr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::compareAuthDptOptr</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean compareAuthDptOptr(
      in wstring org_optr_cde,
      in wstring trgt_optr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean compareAuthDptOptr(
    java.lang.String org_optr_cde,
    java.lang.String trgt_optr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryOptrAuthList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryOptrAuthList(
      in wstring in_opr_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryOptrAuthList(
    java.lang.String in_opr_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::querySubDptList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss querySubDptList(
      in wstring in_dpt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] querySubDptList(
    java.lang.String in_dpt_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::acceptClntMapInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
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
  </pre>
  </p>
  */
  public boolean acceptClntMapInfo(
    java.lang.String opr_cde,
    java.lang.String clnt_agt_flg,
    java.lang.String user_id,
    java.lang.String clnt_cde,
    java.lang.String main_flg
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::updateClntMapInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
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
  </pre>
  </p>
  */
  public boolean updateClntMapInfo(
    java.lang.String opr_cde,
    java.lang.String clnt_agt_flg,
    java.lang.String new_user_id,
    java.lang.String new_clnt_cde,
    java.lang.String main_flg,
    java.lang.String old_user_id,
    java.lang.String old_clnt_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::deleteClntMapInfo</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean deleteClntMapInfo(
      in wstring opr_cde,
      in wstring user_id,
      in string clnt_cde,
      in string clnt_agt_flg
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteClntMapInfo(
    java.lang.String opr_cde,
    java.lang.String user_id,
    java.lang.String clnt_cde,
    java.lang.String clnt_agt_flg
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::queryClntMapList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss queryClntMapList(
      in wstring opr_cde,
      in wstring user_id
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] queryClntMapList(
    java.lang.String opr_cde,
    java.lang.String user_id
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::executeSysadmAuth</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean executeSysadmAuth(
      in string act_typ,
      in wstring auth_opr_cde,
      in wstring in_opr_cde,
      in wstring in_dpt_cde
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean executeSysadmAuth(
    java.lang.String act_typ,
    java.lang.String auth_opr_cde,
    java.lang.String in_opr_cde,
    java.lang.String in_dpt_cde
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::getDptCEnm</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss getDptCEnm(
      in wstring dpt_cde,
      in wstring cenm_typ
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] getDptCEnm(
    java.lang.String dpt_cde,
    java.lang.String cenm_typ
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::acceptSuppEmail</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
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
  </pre>
  </p>
  */
  public boolean acceptSuppEmail(
    java.lang.String emp_cde,
    java.lang.String emp_nme,
    java.lang.String dpt_cde,
    java.lang.String emp_type,
    java.lang.String emp_email
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::updateSuppEmail</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
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
  </pre>
  </p>
  */
  public boolean updateSuppEmail(
    java.lang.String emp_cde,
    java.lang.String emp_nme,
    java.lang.String dpt_cde,
    java.lang.String emp_type,
    java.lang.String emp_email,
    java.lang.String supp_no
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::deleteSuppEmail</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    boolean deleteSuppEmail(
      in wstring supp_no
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public boolean deleteSuppEmail(
    java.lang.String supp_no
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return false;
  }
  /**
  <p>
  Operation: <b>::com::mcip::bus::orb::UserManager::querySuppEmailList</b>.
  <pre>
    #pragma prefix "com/mcip/bus/orb/UserManager"
    ::com::mcip::orb::Stringss querySuppEmailList(
      in wstring emp_nme,
      in ::com::mcip::orb::Strings dpt_cde,
      in wstring emp_type
    )
    raises(
      ::com::mcip::orb::CoException
    );
  </pre>
  </p>
  */
  public java.lang.String[][] querySuppEmailList(
    java.lang.String emp_nme,
    java.lang.String[] dpt_cde,
    java.lang.String emp_type
  ) throws
    com.mcip.orb.CoException {
    // IMPLEMENT: Operation
    return null;
  }
}
