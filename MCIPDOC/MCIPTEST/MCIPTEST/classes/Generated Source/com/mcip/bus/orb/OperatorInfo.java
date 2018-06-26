package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::OperatorInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/OperatorInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct OperatorInfo {
  ...
};
 * </pre>
 */
public final class OperatorInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_opr_cde;
  
  public java.lang.String c_opr_pw;
  
  public java.lang.String c_emp_cde;
  
  public java.lang.String c_dpt_cde;
  
  public java.lang.String c_acredt_cde;
  
  public java.lang.String c_sys_admin;

  public OperatorInfo () {
  }

  public OperatorInfo (final java.lang.String c_opr_cde, 
                       final java.lang.String c_opr_pw, 
                       final java.lang.String c_emp_cde, 
                       final java.lang.String c_dpt_cde, 
                       final java.lang.String c_acredt_cde, 
                       final java.lang.String c_sys_admin) {
    this.c_opr_cde = c_opr_cde;
    this.c_opr_pw = c_opr_pw;
    this.c_emp_cde = c_emp_cde;
    this.c_dpt_cde = c_dpt_cde;
    this.c_acredt_cde = c_acredt_cde;
    this.c_sys_admin = c_sys_admin;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.OperatorInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_opr_cde=");
    _ret.append(c_opr_cde != null?'\"' + c_opr_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_opr_pw=");
    _ret.append(c_opr_pw != null?'\"' + c_opr_pw + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_emp_cde=");
    _ret.append(c_emp_cde != null?'\"' + c_emp_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_dpt_cde=");
    _ret.append(c_dpt_cde != null?'\"' + c_dpt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_acredt_cde=");
    _ret.append(c_acredt_cde != null?'\"' + c_acredt_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_sys_admin=");
    _ret.append(c_sys_admin != null?'\"' + c_sys_admin + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.OperatorInfo) {
      final com.mcip.bus.orb.OperatorInfo obj = (com.mcip.bus.orb.OperatorInfo)o;
      boolean res = true;
      do {
        res = this.c_opr_cde == obj.c_opr_cde ||
         (this.c_opr_cde != null && obj.c_opr_cde != null && this.c_opr_cde.equals(obj.c_opr_cde));
        if (!res) break;
        res = this.c_opr_pw == obj.c_opr_pw ||
         (this.c_opr_pw != null && obj.c_opr_pw != null && this.c_opr_pw.equals(obj.c_opr_pw));
        if (!res) break;
        res = this.c_emp_cde == obj.c_emp_cde ||
         (this.c_emp_cde != null && obj.c_emp_cde != null && this.c_emp_cde.equals(obj.c_emp_cde));
        if (!res) break;
        res = this.c_dpt_cde == obj.c_dpt_cde ||
         (this.c_dpt_cde != null && obj.c_dpt_cde != null && this.c_dpt_cde.equals(obj.c_dpt_cde));
        if (!res) break;
        res = this.c_acredt_cde == obj.c_acredt_cde ||
         (this.c_acredt_cde != null && obj.c_acredt_cde != null && this.c_acredt_cde.equals(obj.c_acredt_cde));
        if (!res) break;
        res = this.c_sys_admin == obj.c_sys_admin ||
         (this.c_sys_admin != null && obj.c_sys_admin != null && this.c_sys_admin.equals(obj.c_sys_admin));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
