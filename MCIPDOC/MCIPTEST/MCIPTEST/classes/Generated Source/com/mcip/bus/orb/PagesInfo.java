package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::PagesInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/PagesInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PagesInfo {
  ...
};
 * </pre>
 */
public final class PagesInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_page_no;
  
  public java.lang.String c_page_title;
  
  public java.lang.String c_file_enm;
  
  public java.lang.String c_func_cde;
  
  public java.lang.String t_edit_tm;

  public PagesInfo () {
  }

  public PagesInfo (final java.lang.String c_page_no, 
                    final java.lang.String c_page_title, 
                    final java.lang.String c_file_enm, 
                    final java.lang.String c_func_cde, 
                    final java.lang.String t_edit_tm) {
    this.c_page_no = c_page_no;
    this.c_page_title = c_page_title;
    this.c_file_enm = c_file_enm;
    this.c_func_cde = c_func_cde;
    this.t_edit_tm = t_edit_tm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.PagesInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_page_no=");
    _ret.append(c_page_no != null?'\"' + c_page_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_page_title=");
    _ret.append(c_page_title != null?'\"' + c_page_title + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_file_enm=");
    _ret.append(c_file_enm != null?'\"' + c_file_enm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_func_cde=");
    _ret.append(c_func_cde != null?'\"' + c_func_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_edit_tm=");
    _ret.append(t_edit_tm != null?'\"' + t_edit_tm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.PagesInfo) {
      final com.mcip.bus.orb.PagesInfo obj = (com.mcip.bus.orb.PagesInfo)o;
      boolean res = true;
      do {
        res = this.c_page_no == obj.c_page_no ||
         (this.c_page_no != null && obj.c_page_no != null && this.c_page_no.equals(obj.c_page_no));
        if (!res) break;
        res = this.c_page_title == obj.c_page_title ||
         (this.c_page_title != null && obj.c_page_title != null && this.c_page_title.equals(obj.c_page_title));
        if (!res) break;
        res = this.c_file_enm == obj.c_file_enm ||
         (this.c_file_enm != null && obj.c_file_enm != null && this.c_file_enm.equals(obj.c_file_enm));
        if (!res) break;
        res = this.c_func_cde == obj.c_func_cde ||
         (this.c_func_cde != null && obj.c_func_cde != null && this.c_func_cde.equals(obj.c_func_cde));
        if (!res) break;
        res = this.t_edit_tm == obj.t_edit_tm ||
         (this.t_edit_tm != null && obj.t_edit_tm != null && this.t_edit_tm.equals(obj.t_edit_tm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
