package com.mcip.cus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/custInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::cus::orb::CustEntity
 * <li> <b>Repository Id</b> IDL:com/mcip/cus/orb/CustEntity:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustEntity {
  ...
};
 * </pre>
 */
public final class CustEntity implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_user_id;
  
  public java.lang.String c_user_name;
  
  public java.lang.String c_user_pw;
  
  public java.lang.String c_pw_question;
  
  public java.lang.String c_pw_result;
  
  public java.lang.String c_clnt_cde;
  
  public int n_user_seq_no;
  
  public char c_verify;
  
  public java.lang.String c_cmpny_agt_cde;
  
  public java.lang.String c_net_id;

  public CustEntity () {
  }

  public CustEntity (final java.lang.String c_user_id, 
                     final java.lang.String c_user_name, 
                     final java.lang.String c_user_pw, 
                     final java.lang.String c_pw_question, 
                     final java.lang.String c_pw_result, 
                     final java.lang.String c_clnt_cde, 
                     final int n_user_seq_no, 
                     final char c_verify, 
                     final java.lang.String c_cmpny_agt_cde, 
                     final java.lang.String c_net_id) {
    this.c_user_id = c_user_id;
    this.c_user_name = c_user_name;
    this.c_user_pw = c_user_pw;
    this.c_pw_question = c_pw_question;
    this.c_pw_result = c_pw_result;
    this.c_clnt_cde = c_clnt_cde;
    this.n_user_seq_no = n_user_seq_no;
    this.c_verify = c_verify;
    this.c_cmpny_agt_cde = c_cmpny_agt_cde;
    this.c_net_id = c_net_id;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.cus.orb.CustEntity {");
    _ret.append("\n");
    _ret.append("java.lang.String c_user_id=");
    _ret.append(c_user_id != null?'\"' + c_user_id + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_user_name=");
    _ret.append(c_user_name != null?'\"' + c_user_name + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_user_pw=");
    _ret.append(c_user_pw != null?'\"' + c_user_pw + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pw_question=");
    _ret.append(c_pw_question != null?'\"' + c_pw_question + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_pw_result=");
    _ret.append(c_pw_result != null?'\"' + c_pw_result + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_clnt_cde=");
    _ret.append(c_clnt_cde != null?'\"' + c_clnt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("int n_user_seq_no=");
    _ret.append(n_user_seq_no);
    _ret.append(",\n");
    _ret.append("char c_verify=");
    _ret.append('\'' + c_verify + '\'');
    _ret.append(",\n");
    _ret.append("java.lang.String c_cmpny_agt_cde=");
    _ret.append(c_cmpny_agt_cde != null?'\"' + c_cmpny_agt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_net_id=");
    _ret.append(c_net_id != null?'\"' + c_net_id + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.cus.orb.CustEntity) {
      final com.mcip.cus.orb.CustEntity obj = (com.mcip.cus.orb.CustEntity)o;
      boolean res = true;
      do {
        res = this.c_user_id == obj.c_user_id ||
         (this.c_user_id != null && obj.c_user_id != null && this.c_user_id.equals(obj.c_user_id));
        if (!res) break;
        res = this.c_user_name == obj.c_user_name ||
         (this.c_user_name != null && obj.c_user_name != null && this.c_user_name.equals(obj.c_user_name));
        if (!res) break;
        res = this.c_user_pw == obj.c_user_pw ||
         (this.c_user_pw != null && obj.c_user_pw != null && this.c_user_pw.equals(obj.c_user_pw));
        if (!res) break;
        res = this.c_pw_question == obj.c_pw_question ||
         (this.c_pw_question != null && obj.c_pw_question != null && this.c_pw_question.equals(obj.c_pw_question));
        if (!res) break;
        res = this.c_pw_result == obj.c_pw_result ||
         (this.c_pw_result != null && obj.c_pw_result != null && this.c_pw_result.equals(obj.c_pw_result));
        if (!res) break;
        res = this.c_clnt_cde == obj.c_clnt_cde ||
         (this.c_clnt_cde != null && obj.c_clnt_cde != null && this.c_clnt_cde.equals(obj.c_clnt_cde));
        if (!res) break;
        res = this.n_user_seq_no == obj.n_user_seq_no;
        if (!res) break;
        res = this.c_verify == obj.c_verify;
        if (!res) break;
        res = this.c_cmpny_agt_cde == obj.c_cmpny_agt_cde ||
         (this.c_cmpny_agt_cde != null && obj.c_cmpny_agt_cde != null && this.c_cmpny_agt_cde.equals(obj.c_cmpny_agt_cde));
        if (!res) break;
        res = this.c_net_id == obj.c_net_id ||
         (this.c_net_id != null && obj.c_net_id != null && this.c_net_id.equals(obj.c_net_id));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
