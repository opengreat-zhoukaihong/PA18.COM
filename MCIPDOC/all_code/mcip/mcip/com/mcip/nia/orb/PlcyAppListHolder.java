package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.PlcyAppListHolder
<li> <b>Source File</b> com/mcip/nia/orb/PlcyAppListHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::PlcyAppList
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/PlcyAppList:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct PlcyAppList {
      string c_ply_app_no;
      string c_ply_no;
      string c_insrnc_cde;
      wstring c_insrnc_cnm;
      double n_amt;
      string c_amt_cur;
      string c_crgo_cde;
      wstring c_cdgo_desc;
      string c_frm_prt_ara;
      wstring c_frm_prt_ara_cnm;
      wstring c_from_prt;
      string c_to_prt_ara;
      wstring c_to_prt_ara_cnm;
      wstring c_to_prt;
      string c_carriage_cde;
      wstring c_carriage_cnm;
    };
</pre>
</p>
*/
final public class PlcyAppListHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.PlcyAppList value;
  public PlcyAppListHolder() {
  }
  public PlcyAppListHolder(com.mcip.nia.orb.PlcyAppList value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.PlcyAppListHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.PlcyAppListHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.PlcyAppListHelper.type();
  }
}
