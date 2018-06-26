package com.mcip.orb;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "D:/Kevin/MCIPDOC/MCIPTEST/MCIPTEST/src/IDL/exceptions.idl"
 * <li> <b>IDL Name</b>      ::com::mcip::orb::CoException
 * <li> <b>Repository Id</b> IDL:com/mcip/orb/CoException:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * exception CoException {
  ...
};
 * </pre>
 */
public final class CoException extends org.omg.CORBA.UserException {
  
  public java.lang.String errCode;
  
  public java.lang.String errDescription;
  
  public java.lang.String errFieldName;
  
  public java.lang.String severity;

  public CoException () {
    super(com.mcip.orb.CoExceptionHelper.id());
  }

  public CoException (java.lang.String errCode,
                      java.lang.String errDescription,
                      java.lang.String errFieldName,
                      java.lang.String severity) {
    this();
    this.errCode = errCode;
    this.errDescription = errDescription;
    this.errFieldName = errFieldName;
    this.severity = severity;
  }

  public CoException (java.lang.String _reason, java.lang.String errCode, 
                                                java.lang.String errDescription, 
                                                java.lang.String errFieldName, 
                                                java.lang.String severity) {
    super(com.mcip.orb.CoExceptionHelper.id() + ' ' + _reason);
    this.errCode = errCode;
    this.errDescription = errDescription;
    this.errFieldName = errFieldName;
    this.severity = severity;
  }

  public java.lang.String toString () {
    final java.lang.StringBuffer _ret = new java.lang.StringBuffer("exception com.mcip.orb.CoException {");
    _ret.append("\n");
    _ret.append("java.lang.String errCode=");
    _ret.append(errCode != null?'\"' + errCode + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String errDescription=");
    _ret.append(errDescription != null?'\"' + errDescription + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String errFieldName=");
    _ret.append(errFieldName != null?'\"' + errFieldName + '\"':null);
    _ret.append(",\n");
    _ret.append("java.lang.String severity=");
    _ret.append(severity != null?'\"' + severity + '\"':null);
    _ret.append("\n");
    _ret.append("}");
    return _ret.toString();
  }

  public boolean equals (java.lang.Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (o instanceof com.mcip.orb.CoException) {
      final com.mcip.orb.CoException obj = (com.mcip.orb.CoException)o;
      boolean res = true;
      do {
        res = this.errCode == obj.errCode ||
         (this.errCode != null && obj.errCode != null && this.errCode.equals(obj.errCode));
        if (!res) break;
        res = this.errDescription == obj.errDescription ||
         (this.errDescription != null && obj.errDescription != null && this.errDescription.equals(obj.errDescription));
        if (!res) break;
        res = this.errFieldName == obj.errFieldName ||
         (this.errFieldName != null && obj.errFieldName != null && this.errFieldName.equals(obj.errFieldName));
        if (!res) break;
        res = this.severity == obj.severity ||
         (this.severity != null && obj.severity != null && this.severity.equals(obj.severity));
      } while (false);
      return res;
    }
    else {
      return false;
    }
  }
}
