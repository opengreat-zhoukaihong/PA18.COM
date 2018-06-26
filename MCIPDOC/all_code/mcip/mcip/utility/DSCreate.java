package utility;

import java.security.*;
import java.io.*;

public class DSCreate {

  private String message;
  private byte[] signedDoc;
  private String identity;
  private StringBuffer errCode = new StringBuffer();

  public DSCreate(String message, String identity) {
    this.message = message;
    signedDoc = null;
    this.identity = identity;
  }

  public byte[] GetSignedDoc() {
    return signedDoc;
  }

  public String GetErrMsg() {
    return errCode.toString();
  }

  public boolean sign() {
    try {
      Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
      KeyManage keyManage = new KeyManage(identity);
      //PrivateKey privateKey = keyManage.getPrivateKey();
	PrivateKey privateKey = keyManage.getPrivateKey("SendPrivate");      

      if (privateKey == null) {
        errCode.append(" Invalid identity ! ");
        return false;
      }
      else {
        sig.initSign(privateKey);

        //FileInputStream fis = new FileInputStream(message);
        InputStream fis = new StringBufferInputStream(message);
        BufferedInputStream bufin = new BufferedInputStream(fis);
        byte[] buffer = new byte[1024];
        int len;
        while (bufin.available() !=0) {
          len = bufin.read(buffer);
          sig.update(buffer, 0, len);
        }
        bufin.close();

        //byte[] signature = sig.sign();
        //signedDoc = signature;
        signedDoc = sig.sign();
        return true;
      }
    }
    catch (Exception e) {
      errCode.append(" Error in generating digital signature! "  );
      return false;
    }
  }

  public static void main(String[] args) {
    String parMessage = "<?xml version = '1.0'?><main><RFQ_HEADER><ROW num=\"1\"><REF_NO>324</REF_NO>" ;
    parMessage = parMessage + "<TARGET_REPLY_DATE>2000-09-07 18:34:07.0</TARGET_REPLY_DATE>" ;
    parMessage = parMessage + "<NAME_OF_ASSURED>Company A</NAME_OF_ASSURED><INSURED_VALUE>10000</INSURED_VALUE>" ;
    parMessage = parMessage + "<INSURED_CURRENCY>HKD</INSURED_CURRENCY><CONVEYANCE>Conveyance A</CONVEYANCE>" ;
    parMessage = parMessage + "<VOYAGE>Voyage A</VOYAGE><LOADING_PORT>Loading Port A</LOADING_PORT>" ;
    parMessage = parMessage + "<DISCHARGING_PORT>Discharging Port A</DISCHARGING_PORT>" ;
    parMessage = parMessage + "<DEPARTURE_DATE>2000-09-07 18:34:07.0</DEPARTURE_DATE>" ;
    parMessage = parMessage + "<PREFERRED_RATE>Rate A</PREFERRED_RATE>" ;
    parMessage = parMessage + "<REMARKS>Remarks A</REMARKS></ROW></RFQ_HEADER><RFQ_ITEMS>" ;
    parMessage = parMessage + "<ROW num=\"1\"><INTEREST_INSURED>Item A1</INTEREST_INSURED>" ;
    parMessage = parMessage + "<PACKING>Bulk Pack A1</PACKING></ROW><ROW num=\"2\">" ;
    parMessage = parMessage + "<INTEREST_INSURED>Item A2</INTEREST_INSURED><PACKING>Bulk Pack A2</PACKING>" ;
    parMessage = parMessage + "</ROW></RFQ_ITEMS><RFQ_CONDITIONS><ROW num=\"1\"><CONDITION>Cargo A</CONDITION>" ;
    parMessage = parMessage + "</ROW><ROW num=\"2\"><CONDITION>Cargo B</CONDITION></ROW>" ;
    parMessage = parMessage + "</RFQ_CONDITIONS></main>";

    //DSCreate dsCreate = new DSCreate(parMessage, "koeman");
	DSCreate dsCreate = new DSCreate(parMessage, "PA");
	
	
    if (dsCreate.sign() == true) {
      try {
        FileOutputStream sigfos = new FileOutputStream("FirstSignedDoc");
        sigfos.write(dsCreate.GetSignedDoc());
        sigfos.close();
        System.out.println("Successful!");
      }
      catch (Exception e) {
      }
    }
    else {
      System.out.println(dsCreate.GetErrMsg());
    }      

  }
}

 