package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::OprAuthInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/OprAuthInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct OprAuthInfo {
  ...
};
 * </pre>
 */
public final class OprAuthInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_opr_cde;
  
  public java.lang.String c_func_cde;

  public OprAuthInfo () {
  }

  public OprAuthInfo (final java.lang.String c_opr_cde, 
                      final java.lang.String c_func_cde) {
    this.c_opr_cde = c_opr_cde;
    this.c_func_cde = c_func_cde;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.OprAuthInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_opr_cde=");
    _ret.append(c_opr_cde != null?'\"' + c_opr_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_func_cde=");
    _ret.append(c_func_cde != null?'\"' + c_func_cde + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.OprAuthInfo) {
      final com.mcip.bus.orb.OprAuthInfo obj = (com.mcip.bus.orb.OprAuthInfo)o;
      boolean res = true;
      do {
        res = this.c_opr_cde == obj.c_opr_cde ||
         (this.c_opr_cde != null && obj.c_opr_cde != null && this.c_opr_cde.equals(obj.c_opr_cde));
        if (!res) break;
        res = this.c_func_cde == obj.c_func_cde ||
         (this.c_func_cde != null && obj.c_func_cde != null && this.c_func_cde.equals(obj.c_func_cde));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
