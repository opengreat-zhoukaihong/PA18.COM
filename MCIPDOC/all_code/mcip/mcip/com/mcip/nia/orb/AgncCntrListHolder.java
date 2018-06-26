package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.AgncCntrListHolder
<li> <b>Source File</b> com/mcip/nia/orb/AgncCntrListHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::AgncCntrList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/AgncCntrList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct AgncCntrList {
      string c_agt_agr_no;
      long n_sub_co_no;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      string c_crgo_cde;
      wstring c_crgo_cnm;
    };
</pre>
</p>
*/
final public class AgncCntrListHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.AgncCntrList value;
  public AgncCntrListHolder() {
  }
  public AgncCntrListHolder(com.mcip.nia.orb.AgncCntrList value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.AgncCntrListHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.AgncCntrListHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.AgncCntrListHelper.type();
  }
}
