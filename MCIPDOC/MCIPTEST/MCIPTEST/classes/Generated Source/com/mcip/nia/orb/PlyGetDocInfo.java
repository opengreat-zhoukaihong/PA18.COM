package com.mcip.nia.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/policyInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::nia::orb::PlyGetDocInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/nia/orb/PlyGetDocInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct PlyGetDocInfo {
  ...
};
 * </pre>
 */
public final class PlyGetDocInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_doc_no;
  
  public java.lang.String c_insrnc_cde;
  
  public java.lang.String c_prn_typ;
  
  public java.lang.String t_undr_tm;

  public PlyGetDocInfo () {
  }

  public PlyGetDocInfo (final java.lang.String c_doc_no, 
                        final java.lang.String c_insrnc_cde, 
                        final java.lang.String c_prn_typ, 
                        final java.lang.String t_undr_tm) {
    this.c_doc_no = c_doc_no;
    this.c_insrnc_cde = c_insrnc_cde;
    this.c_prn_typ = c_prn_typ;
    this.t_undr_tm = t_undr_tm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.nia.orb.PlyGetDocInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_doc_no=");
    _ret.append(c_doc_no != null?'\"' + c_doc_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_insrnc_cde=");
    _ret.append(c_insrnc_cde != null?'\"' + c_insrnc_cde + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_prn_typ=");
    _ret.append(c_prn_typ != null?'\"' + c_prn_typ + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_undr_tm=");
    _ret.append(t_undr_tm != null?'\"' + t_undr_tm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.nia.orb.PlyGetDocInfo) {
      final com.mcip.nia.orb.PlyGetDocInfo obj = (com.mcip.nia.orb.PlyGetDocInfo)o;
      boolean res = true;
      do {
        res = this.c_doc_no == obj.c_doc_no ||
         (this.c_doc_no != null && obj.c_doc_no != null && this.c_doc_no.equals(obj.c_doc_no));
        if (!res) break;
        res = this.c_insrnc_cde == obj.c_insrnc_cde ||
         (this.c_insrnc_cde != null && obj.c_insrnc_cde != null && this.c_insrnc_cde.equals(obj.c_insrnc_cde));
        if (!res) break;
        res = this.c_prn_typ == obj.c_prn_typ ||
         (this.c_prn_typ != null && obj.c_prn_typ != null && this.c_prn_typ.equals(obj.c_prn_typ));
        if (!res) break;
        res = this.t_undr_tm == obj.t_undr_tm ||
         (this.t_undr_tm != null && obj.t_undr_tm != null && this.t_undr_tm.equals(obj.t_undr_tm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
