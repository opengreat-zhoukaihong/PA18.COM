package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.NiaGridPackHolder
<li> <b>Source File</b> com/mcip/nia/orb/NiaGridPackHolder.java
<li> <b>IDL Source File</b> policyInfoStruct.idl
<li> <b>IDL Absolute Name</b> ::com::mcip::nia::orb::NiaGridPack
<li> <b>Repository Identifier</b> IDL:com/mcip/nia/orb/NiaGridPack:1.0
</ul>
<b>IDL definition:</b>
<pre>
    #pragma prefix "com/mcip/nia/orb"
    struct NiaGridPack {
      string c_docno;
      string t_sendtm;
      string c_blgdptcde;
      string c_source;
      string c_senddptcde;
      string c_sendcde;
      string c_desdptcde;
      string c_emergency;
      string c_authprncde;
      string c_udrmrk;
      string c_sendmrk;
      string c_udropnmrk;
      long n_vrfymrk;
      string t_mdfytm;
      string c_Insrnccde;
      wstring c_undrprsn;
      wstring c_undrdpt;
      string c_prntyp;
      string c_rinsrncmrk;
      string c_coinsrncmrk;
      string c_plyno;
      string c_edrno;
      string c_read;
      string c_flag;
      wstring c_insrntnme;
      wstring c_insrnccnm;
      wstring c_blgdptcnm;
      wstring c_senddptcnm;
      wstring c_desdptcnm;
      wstring c_undrdptcnm;
      string t_signtm;
      wstring c_rptdesc;
      string c_edrtyp;
      string c_risklvlcde;
      string c_lcnno;
      string c_engno;
      string c_insrnccls;
      string c_useatr;
      string c_apptyp;
      string t_apptm;
      string t_inputtm;
      wstring c_appnme;
      wstring c_undropn;
      string c_edrapptm;
      string c_internet_typ;
    };
</pre>
</p>
*/
final public class NiaGridPackHolder implements org.omg.CORBA.portable.Streamable {
  public com.mcip.nia.orb.NiaGridPack value;
  public NiaGridPackHolder() {
  }
  public NiaGridPackHolder(com.mcip.nia.orb.NiaGridPack value) {
    this.value = value;
  }
  public void _read(org.omg.CORBA.portable.InputStream input) {
    value = com.mcip.nia.orb.NiaGridPackHelper.read(input);
  }
  public void _write(org.omg.CORBA.portable.OutputStream output) {
    com.mcip.nia.orb.NiaGridPackHelper.write(output, value);
  }
  public org.omg.CORBA.TypeCode _type() {
    return com.mcip.nia.orb.NiaGridPackHelper.type();
  }
}
