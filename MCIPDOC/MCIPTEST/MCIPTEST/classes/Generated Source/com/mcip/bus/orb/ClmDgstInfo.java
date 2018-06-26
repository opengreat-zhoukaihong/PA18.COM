package com.mcip.bus.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/businessInfoStruct.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::bus::orb::ClmDgstInfo
 * <li> <b>Repository Id</b> IDL:com/mcip/bus/orb/ClmDgstInfo:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * struct ClmDgstInfo {
  ...
};
 * </pre>
 */
public final class ClmDgstInfo implements org.omg.CORBA.portable.IDLEntity {
  
  public java.lang.String c_ply_no;
  
  public java.lang.String c_rpt_no;
  
  public java.lang.String c_info_no;
  
  public java.lang.String c_digest;
  
  public java.lang.String c_content;
  
  public java.lang.String t_input_tm;

  public ClmDgstInfo () {
  }

  public ClmDgstInfo (final java.lang.String c_ply_no, 
                      final java.lang.String c_rpt_no, 
                      final java.lang.String c_info_no, 
                      final java.lang.String c_digest, 
                      final java.lang.String c_content, 
                      final java.lang.String t_input_tm) {
    this.c_ply_no = c_ply_no;
    this.c_rpt_no = c_rpt_no;
    this.c_info_no = c_info_no;
    this.c_digest = c_digest;
    this.c_content = c_content;
    this.t_input_tm = t_input_tm;
  }

  public java.lang.String toString() {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("struct com.mcip.bus.orb.ClmDgstInfo {");
    _ret.append("\n");
    _ret.append("java.lang.String c_ply_no=");
    _ret.append(c_ply_no != null?'\"' + c_ply_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_rpt_no=");
    _ret.append(c_rpt_no != null?'\"' + c_rpt_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_info_no=");
    _ret.append(c_info_no != null?'\"' + c_info_no + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_digest=");
    _ret.append(c_digest != null?'\"' + c_digest + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String c_content=");
    _ret.append(c_content != null?'\"' + c_content + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String t_input_tm=");
    _ret.append(t_input_tm != null?'\"' + t_input_tm + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;

    if (o instanceof com.mcip.bus.orb.ClmDgstInfo) {
      final com.mcip.bus.orb.ClmDgstInfo obj = (com.mcip.bus.orb.ClmDgstInfo)o;
      boolean res = true;
      do {
        res = this.c_ply_no == obj.c_ply_no ||
         (this.c_ply_no != null && obj.c_ply_no != null && this.c_ply_no.equals(obj.c_ply_no));
        if (!res) break;
        res = this.c_rpt_no == obj.c_rpt_no ||
         (this.c_rpt_no != null && obj.c_rpt_no != null && this.c_rpt_no.equals(obj.c_rpt_no));
        if (!res) break;
        res = this.c_info_no == obj.c_info_no ||
         (this.c_info_no != null && obj.c_info_no != null && this.c_info_no.equals(obj.c_info_no));
        if (!res) break;
        res = this.c_digest == obj.c_digest ||
         (this.c_digest != null && obj.c_digest != null && this.c_digest.equals(obj.c_digest));
        if (!res) break;
        res = this.c_content == obj.c_content ||
         (this.c_content != null && obj.c_content != null && this.c_content.equals(obj.c_content));
        if (!res) break;
        res = this.t_input_tm == obj.t_input_tm ||
         (this.t_input_tm != null && obj.t_input_tm != null && this.t_input_tm.equals(obj.t_input_tm));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
