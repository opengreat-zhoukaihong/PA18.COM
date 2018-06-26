package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::CustFaqInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/CustFaqInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct CustFaqInfo {
  ...
};
 * </pre>
 */
public final class CustFaqInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_faq_no;
  
  public java.lang.String c_faq_psn;
  
  public java.lang.String c_faq_email;
  
  public java.lang.String c_faq_title;
  
  public java.lang.String c_faq_content;
  
  public java.lang.String t_faq_tm;
  
  public java.lang.String c_reply_cont;
  
  public java.lang.String c_reply_emp;
  
  public java.lang.String t_reply_tm;

  public CustFaqInfo () {
  }

  public CustFaqInfo (final java.lang.String c_faq_no, 
                      final java.lang.String c_faq_psn, 
                      final java.lang.String c_faq_email, 
                      final java.lang.String c_faq_title, 
                      final java.lang.String c_faq_content, 
                      final java.lang.String t_faq_tm, 
                      final java.lang.String c_reply_cont, 
                      final java.lang.String c_reply_emp, 
                      final java.lang.String t_reply_tm) {
    this.c_faq_no = c_faq_no;
    this.c_faq_psn = c_faq_psn;
    this.c_faq_email = c_faq_email;
    this.c_faq_title = c_faq_title;
    this.c_faq_content = c_faq_content;
    this.t_faq_tm = t_faq_tm;
    this.c_reply_cont = c_reply_cont;
    this.c_reply_emp = c_reply_emp;
    this.t_reply_tm = t_reply_tm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.CustFaqInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_faq_no=");
    _ret.append(c_faq_no != null?'\"' + c_faq_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_faq_psn=");
    _ret.append(c_faq_psn != null?'\"' + c_faq_psn + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_faq_email=");
    _ret.append(c_faq_email != null?'\"' + c_faq_email + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_faq_title=");
    _ret.append(c_faq_title != null?'\"' + c_faq_title + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_faq_content=");
    _ret.append(c_faq_content != null?'\"' + c_faq_content + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_faq_tm=");
    _ret.append(t_faq_tm != null?'\"' + t_faq_tm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_reply_cont=");
    _ret.append(c_reply_cont != null?'\"' + c_reply_cont + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_reply_emp=");
    _ret.append(c_reply_emp != null?'\"' + c_reply_emp + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_reply_tm=");
    _ret.append(t_reply_tm != null?'\"' + t_reply_tm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.CustFaqInfo) {
      final com.mcip.bus.orb.CustFaqInfo obj = (com.mcip.bus.orb.CustFaqInfo)o;
      boolean res = true;
      do {
        res = this.c_faq_no == obj.c_faq_no ||
         (this.c_faq_no != null && obj.c_faq_no != null && this.c_faq_no.equals(obj.c_faq_no));
        if (!res) break;
        res = this.c_faq_psn == obj.c_faq_psn ||
         (this.c_faq_psn != null && obj.c_faq_psn != null && this.c_faq_psn.equals(obj.c_faq_psn));
        if (!res) break;
        res = this.c_faq_email == obj.c_faq_email ||
         (this.c_faq_email != null && obj.c_faq_email != null && this.c_faq_email.equals(obj.c_faq_email));
        if (!res) break;
        res = this.c_faq_title == obj.c_faq_title ||
         (this.c_faq_title != null && obj.c_faq_title != null && this.c_faq_title.equals(obj.c_faq_title));
        if (!res) break;
        res = this.c_faq_content == obj.c_faq_content ||
         (this.c_faq_content != null && obj.c_faq_content != null && this.c_faq_content.equals(obj.c_faq_content));
        if (!res) break;
        res = this.t_faq_tm == obj.t_faq_tm ||
         (this.t_faq_tm != null && obj.t_faq_tm != null && this.t_faq_tm.equals(obj.t_faq_tm));
        if (!res) break;
        res = this.c_reply_cont == obj.c_reply_cont ||
         (this.c_reply_cont != null && obj.c_reply_cont != null && this.c_reply_cont.equals(obj.c_reply_cont));
        if (!res) break;
        res = this.c_reply_emp == obj.c_reply_emp ||
         (this.c_reply_emp != null && obj.c_reply_emp != null && this.c_reply_emp.equals(obj.c_reply_emp));
        if (!res) break;
        res = this.t_reply_tm == obj.t_reply_tm ||
         (this.t_reply_tm != null && obj.t_reply_tm != null && this.t_reply_tm.equals(obj.t_reply_tm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
