package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::InsrncGuideInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/InsrncGuideInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct InsrncGuideInfo {
  ...
};
 * </pre>
 */
public final class InsrncGuideInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_info_no;
  
  public java.lang.String c_title_no;
  
  public java.lang.String c_title_cnm;
  
  public java.lang.String c_title_enm;
  
  public java.lang.String c_content_cnm;
  
  public java.lang.String c_content_enm;
  
  public java.lang.String t_crt_tm;

  public InsrncGuideInfo () {
  }

  public InsrncGuideInfo (final java.lang.String c_info_no, 
                          final java.lang.String c_title_no, 
                          final java.lang.String c_title_cnm, 
                          final java.lang.String c_title_enm, 
                          final java.lang.String c_content_cnm, 
                          final java.lang.String c_content_enm, 
                          final java.lang.String t_crt_tm) {
    this.c_info_no = c_info_no;
    this.c_title_no = c_title_no;
    this.c_title_cnm = c_title_cnm;
    this.c_title_enm = c_title_enm;
    this.c_content_cnm = c_content_cnm;
    this.c_content_enm = c_content_enm;
    this.t_crt_tm = t_crt_tm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.InsrncGuideInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_info_no=");
    _ret.append(c_info_no != null?'\"' + c_info_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_title_no=");
    _ret.append(c_title_no != null?'\"' + c_title_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_title_cnm=");
    _ret.append(c_title_cnm != null?'\"' + c_title_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_title_enm=");
    _ret.append(c_title_enm != null?'\"' + c_title_enm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_content_cnm=");
    _ret.append(c_content_cnm != null?'\"' + c_content_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_content_enm=");
    _ret.append(c_content_enm != null?'\"' + c_content_enm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_crt_tm=");
    _ret.append(t_crt_tm != null?'\"' + t_crt_tm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.InsrncGuideInfo) {
      final com.mcip.bus.orb.InsrncGuideInfo obj = (com.mcip.bus.orb.InsrncGuideInfo)o;
      boolean res = true;
      do {
        res = this.c_info_no == obj.c_info_no ||
         (this.c_info_no != null && obj.c_info_no != null && this.c_info_no.equals(obj.c_info_no));
        if (!res) break;
        res = this.c_title_no == obj.c_title_no ||
         (this.c_title_no != null && obj.c_title_no != null && this.c_title_no.equals(obj.c_title_no));
        if (!res) break;
        res = this.c_title_cnm == obj.c_title_cnm ||
         (this.c_title_cnm != null && obj.c_title_cnm != null && this.c_title_cnm.equals(obj.c_title_cnm));
        if (!res) break;
        res = this.c_title_enm == obj.c_title_enm ||
         (this.c_title_enm != null && obj.c_title_enm != null && this.c_title_enm.equals(obj.c_title_enm));
        if (!res) break;
        res = this.c_content_cnm == obj.c_content_cnm ||
         (this.c_content_cnm != null && obj.c_content_cnm != null && this.c_content_cnm.equals(obj.c_content_cnm));
        if (!res) break;
        res = this.c_content_enm == obj.c_content_enm ||
         (this.c_content_enm != null && obj.c_content_enm != null && this.c_content_enm.equals(obj.c_content_enm));
        if (!res) break;
        res = this.t_crt_tm == obj.t_crt_tm ||
         (this.t_crt_tm != null && obj.t_crt_tm != null && this.t_crt_tm.equals(obj.t_crt_tm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
