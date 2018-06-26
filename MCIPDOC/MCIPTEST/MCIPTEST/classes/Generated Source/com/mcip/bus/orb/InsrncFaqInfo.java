package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::InsrncFaqInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/InsrncFaqInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct InsrncFaqInfo {
  ...
};
 * </pre>
 */
public final class InsrncFaqInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_faq_no;
  
  public java.lang.String c_faq_emp;
  
  public java.lang.String c_faq_title;
  
  public java.lang.String c_faq_content;
  
  public java.lang.String t_faq_tm;
  
  public java.lang.String c_topic_no;

  public InsrncFaqInfo () {
  }

  public InsrncFaqInfo (final java.lang.String c_faq_no, 
                        final java.lang.String c_faq_emp, 
                        final java.lang.String c_faq_title, 
                        final java.lang.String c_faq_content, 
                        final java.lang.String t_faq_tm, 
                        final java.lang.String c_topic_no) {
    this.c_faq_no = c_faq_no;
    this.c_faq_emp = c_faq_emp;
    this.c_faq_title = c_faq_title;
    this.c_faq_content = c_faq_content;
    this.t_faq_tm = t_faq_tm;
    this.c_topic_no = c_topic_no;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.InsrncFaqInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_faq_no=");
    _ret.append(c_faq_no != null?'\"' + c_faq_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_faq_emp=");
    _ret.append(c_faq_emp != null?'\"' + c_faq_emp + '\"':null);
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
    _ret.append("java.lang.String c_topic_no=");
    _ret.append(c_topic_no != null?'\"' + c_topic_no + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.InsrncFaqInfo) {
      final com.mcip.bus.orb.InsrncFaqInfo obj = (com.mcip.bus.orb.InsrncFaqInfo)o;
      boolean res = true;
      do {
        res = this.c_faq_no == obj.c_faq_no ||
         (this.c_faq_no != null && obj.c_faq_no != null && this.c_faq_no.equals(obj.c_faq_no));
        if (!res) break;
        res = this.c_faq_emp == obj.c_faq_emp ||
         (this.c_faq_emp != null && obj.c_faq_emp != null && this.c_faq_emp.equals(obj.c_faq_emp));
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
        res = this.c_topic_no == obj.c_topic_no ||
         (this.c_topic_no != null && obj.c_topic_no != null && this.c_topic_no.equals(obj.c_topic_no));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
