package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.QuotaCndtnHolder
<li> <b>Source File</b> com/mcip/nia/orb/QuotaCndtnHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::QuotaCndtn
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/QuotaCndtn:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct QuotaCndtn {
      string c_dpt_cde;
      string c_insrnc_cde;
      string c_rdr_cde;
      string c_crgo_cls;
      string c_crgo_cde;
      string c_pack_cde;
      string c_carriage_cde;
      string c_frm_prt_ara;
      string c_to_prt_ara;
      string n_rate;
      wstring c_nclm_desc;
    };
</pre>
</p>
*/
final public class QuotaCndtnHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.QuotaCndtn value;
  public QuotaCndtnHolder() {
  }
  public QuotaCndtnHolder(com.mcip.nia.orb.QuotaCndtn value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.QuotaCndtnHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.QuotaCndtnHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.QuotaCndtnHelper.type();
  }
}
