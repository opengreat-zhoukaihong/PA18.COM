package com.mcip.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.orb.CoException
<li> <b>Source File</b> com/mcip/orb/CoException.java
<li> <b>IDL Source File</b> exceptions.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::orb::CoException
<li> <b>Repository Identifier</b> IDL:com/mcip/orb/CoException:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/orb"
    exception CoException {
      string errCode;
      wstring errDescription;
      string errFieldName;
      string severity;
    };
</pre>
</p>
*/
final public class CoException extends org.omg.CORBA.UserException {
  public java.lang.String errCode;
  public java.lang.String errDescription;
  public java.lang.String errFieldName;
  public java.lang.String severity;
  public CoException() {
  }
  public CoException(
    java.lang.String errCode,
    java.lang.String errDescription,
    java.lang.String errFieldName,
    java.lang.String severity
  ) {
    this.errCode = errCode;
    this.errDescription = errDescription;
    this.errFieldName = errFieldName;
    this.severity = severity;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.orb.CoExceptionHelper.insert(any, this);
    return any.toString();
  }
}
