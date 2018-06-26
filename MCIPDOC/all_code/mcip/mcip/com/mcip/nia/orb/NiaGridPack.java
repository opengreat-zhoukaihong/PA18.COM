package com.mcip.nia.orb;
/**
<p>
<ul>
<li> <b>Java Class</b> com.mcip.nia.orb.NiaGridPack
<li> <b>Source File</b> com/mcip/nia/orb/NiaGridPack.java
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
final public class NiaGridPack {
  public java.lang.String c_docno;
  public java.lang.String t_sendtm;
  public java.lang.String c_blgdptcde;
  public java.lang.String c_source;
  public java.lang.String c_senddptcde;
  public java.lang.String c_sendcde;
  public java.lang.String c_desdptcde;
  public java.lang.String c_emergency;
  public java.lang.String c_authprncde;
  public java.lang.String c_udrmrk;
  public java.lang.String c_sendmrk;
  public java.lang.String c_udropnmrk;
  public int n_vrfymrk;
  public java.lang.String t_mdfytm;
  public java.lang.String c_Insrnccde;
  public java.lang.String c_undrprsn;
  public java.lang.String c_undrdpt;
  public java.lang.String c_prntyp;
  public java.lang.String c_rinsrncmrk;
  public java.lang.String c_coinsrncmrk;
  public java.lang.String c_plyno;
  public java.lang.String c_edrno;
  public java.lang.String c_read;
  public java.lang.String c_flag;
  public java.lang.String c_insrntnme;
  public java.lang.String c_insrnccnm;
  public java.lang.String c_blgdptcnm;
  public java.lang.String c_senddptcnm;
  public java.lang.String c_desdptcnm;
  public java.lang.String c_undrdptcnm;
  public java.lang.String t_signtm;
  public java.lang.String c_rptdesc;
  public java.lang.String c_edrtyp;
  public java.lang.String c_risklvlcde;
  public java.lang.String c_lcnno;
  public java.lang.String c_engno;
  public java.lang.String c_insrnccls;
  public java.lang.String c_useatr;
  public java.lang.String c_apptyp;
  public java.lang.String t_apptm;
  public java.lang.String t_inputtm;
  public java.lang.String c_appnme;
  public java.lang.String c_undropn;
  public java.lang.String c_edrapptm;
  public java.lang.String c_internet_typ;
  public NiaGridPack() {
  }
  public NiaGridPack(
    java.lang.String c_docno,
    java.lang.String t_sendtm,
    java.lang.String c_blgdptcde,
    java.lang.String c_source,
    java.lang.String c_senddptcde,
    java.lang.String c_sendcde,
    java.lang.String c_desdptcde,
    java.lang.String c_emergency,
    java.lang.String c_authprncde,
    java.lang.String c_udrmrk,
    java.lang.String c_sendmrk,
    java.lang.String c_udropnmrk,
    int n_vrfymrk,
    java.lang.String t_mdfytm,
    java.lang.String c_Insrnccde,
    java.lang.String c_undrprsn,
    java.lang.String c_undrdpt,
    java.lang.String c_prntyp,
    java.lang.String c_rinsrncmrk,
    java.lang.String c_coinsrncmrk,
    java.lang.String c_plyno,
    java.lang.String c_edrno,
    java.lang.String c_read,
    java.lang.String c_flag,
    java.lang.String c_insrntnme,
    java.lang.String c_insrnccnm,
    java.lang.String c_blgdptcnm,
    java.lang.String c_senddptcnm,
    java.lang.String c_desdptcnm,
    java.lang.String c_undrdptcnm,
    java.lang.String t_signtm,
    java.lang.String c_rptdesc,
    java.lang.String c_edrtyp,
    java.lang.String c_risklvlcde,
    java.lang.String c_lcnno,
    java.lang.String c_engno,
    java.lang.String c_insrnccls,
    java.lang.String c_useatr,
    java.lang.String c_apptyp,
    java.lang.String t_apptm,
    java.lang.String t_inputtm,
    java.lang.String c_appnme,
    java.lang.String c_undropn,
    java.lang.String c_edrapptm,
    java.lang.String c_internet_typ
  ) {
    this.c_docno = c_docno;
    this.t_sendtm = t_sendtm;
    this.c_blgdptcde = c_blgdptcde;
    this.c_source = c_source;
    this.c_senddptcde = c_senddptcde;
    this.c_sendcde = c_sendcde;
    this.c_desdptcde = c_desdptcde;
    this.c_emergency = c_emergency;
    this.c_authprncde = c_authprncde;
    this.c_udrmrk = c_udrmrk;
    this.c_sendmrk = c_sendmrk;
    this.c_udropnmrk = c_udropnmrk;
    this.n_vrfymrk = n_vrfymrk;
    this.t_mdfytm = t_mdfytm;
    this.c_Insrnccde = c_Insrnccde;
    this.c_undrprsn = c_undrprsn;
    this.c_undrdpt = c_undrdpt;
    this.c_prntyp = c_prntyp;
    this.c_rinsrncmrk = c_rinsrncmrk;
    this.c_coinsrncmrk = c_coinsrncmrk;
    this.c_plyno = c_plyno;
    this.c_edrno = c_edrno;
    this.c_read = c_read;
    this.c_flag = c_flag;
    this.c_insrntnme = c_insrntnme;
    this.c_insrnccnm = c_insrnccnm;
    this.c_blgdptcnm = c_blgdptcnm;
    this.c_senddptcnm = c_senddptcnm;
    this.c_desdptcnm = c_desdptcnm;
    this.c_undrdptcnm = c_undrdptcnm;
    this.t_signtm = t_signtm;
    this.c_rptdesc = c_rptdesc;
    this.c_edrtyp = c_edrtyp;
    this.c_risklvlcde = c_risklvlcde;
    this.c_lcnno = c_lcnno;
    this.c_engno = c_engno;
    this.c_insrnccls = c_insrnccls;
    this.c_useatr = c_useatr;
    this.c_apptyp = c_apptyp;
    this.t_apptm = t_apptm;
    this.t_inputtm = t_inputtm;
    this.c_appnme = c_appnme;
    this.c_undropn = c_undropn;
    this.c_edrapptm = c_edrapptm;
    this.c_internet_typ = c_internet_typ;
  }
  public java.lang.String toString() {
    org.omg.CORBA.Any any = org.omg.CORBA.ORB.init().create_any();
    com.mcip.nia.orb.NiaGridPackHelper.insert(any, this);
    return any.toString();
  }
}
