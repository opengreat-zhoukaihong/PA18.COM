package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::SysFuncInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/SysFuncInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct SysFuncInfo {
  ...
};
 * </pre>
 */
public final class SysFuncInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_func_cde;
  
  public java.lang.String c_func_cnm;
  
  public java.lang.String c_func_enm;

  public SysFuncInfo () {
  }

  public SysFuncInfo (final java.lang.String c_func_cde, 
                      final java.lang.String c_func_cnm, 
                      final java.lang.String c_func_enm) {
    this.c_func_cde = c_func_cde;
    this.c_func_cnm = c_func_cnm;
    this.c_func_enm = c_func_enm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.SysFuncInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_func_cde=");
    _ret.append(c_func_cde != null?'\"' + c_func_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_func_cnm=");
    _ret.append(c_func_cnm != null?'\"' + c_func_cnm + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_func_enm=");
    _ret.append(c_func_enm != null?'\"' + c_func_enm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.SysFuncInfo) {
      final com.mcip.bus.orb.SysFuncInfo obj = (com.mcip.bus.orb.SysFuncInfo)o;
      boolean res = true;
      do {
        res = this.c_func_cde == obj.c_func_cde ||
         (this.c_func_cde != null && obj.c_func_cde != null && this.c_func_cde.equals(obj.c_func_cde));
        if (!res) break;
        res = this.c_func_cnm == obj.c_func_cnm ||
         (this.c_func_cnm != null && obj.c_func_cnm != null && this.c_func_cnm.equals(obj.c_func_cnm));
        if (!res) break;
        res = this.c_func_enm == obj.c_func_enm ||
         (this.c_func_enm != null && obj.c_func_enm != null && this.c_func_enm.equals(obj.c_func_enm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
