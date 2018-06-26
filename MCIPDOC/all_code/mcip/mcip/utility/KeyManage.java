package utility;

import java.security.*;
import java.io.*;
import java.security.spec.*;

public class KeyManage {

  private String identity;

  public KeyManage(String i_id) {
    identity = i_id;
  }

  PublicKey getPublicKey() {
    IdentityScope is = IdentityScope.getSystemScope();
    System.out.println(is);
    Identity origIdentity = (Identity)is.getIdentity(identity);
    try {
      return origIdentity.getPublicKey();
    }
    catch (NullPointerException npe) {
      return null;
    }            
  }

  PrivateKey getPrivateKey() {
    IdentityScope is = IdentityScope.getSystemScope();
    System.out.println(is);
    Signer origSigner = (Signer)is.getIdentity(identity);
    try {
      return origSigner.getPrivateKey();
    }
    catch (NullPointerException npe) {
      return null;
    }            
  }
  
  PrivateKey getPrivateKey(String privateKeyPath) {
	try 
	{
		byte[] privateByte = FileAccessHelper.readFile(privateKeyPath);
		PKCS8EncodedKeySpec pvkKeySpec = new PKCS8EncodedKeySpec(privateByte);
		KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
		return keyFactory.generatePrivate(pvkKeySpec);
	}
	catch (Exception e)
	{
		System.out.println("Error:" + e.getMessage());
		return null;
	}
	
		
	
		
		
  }
  

  public static void main(String args[]) {
    KeyManage keyManage = new KeyManage("");
    PublicKey tempPublic = keyManage.getPublicKey();
    //PrivateKey tempPrivate = keyManage.getPrivateKey();
	PrivateKey tempPrivate = keyManage.getPrivateKey("SendPrivate");
    
  }
}

 