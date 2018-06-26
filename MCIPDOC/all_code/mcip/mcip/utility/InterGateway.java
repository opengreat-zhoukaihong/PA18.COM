//InterGateway.java
package utility;

public class InterGateway
{
    private static String ins=null;
    public String rstr=null;

    static {
	System.loadLibrary("intergatecom");
    }
    
    public native byte[] packetchanege(int serviceid,byte[] instr,int strlen);

    public InterGateway(){
    }

    public InterGateway(byte[] inbytes) throws Exception
    {

    }

    public byte[] doGatewayJob(int serviceid,byte[] inbytes){
         //ins=instr;
      try{
	    //byte[] inbytes=ins.getBytes("gb2312");
	    //int instrlen=ins.length();
      int instrlen=inbytes.length;
	    byte[] outbytes=(byte [])this.packetchanege(serviceid,inbytes,instrlen);
	    return outbytes;
    	}
     	catch (Exception e)
	    {
		    System.err.println("UnsupportedEncodingException"+ e);
        return null;
	    }
    }
}

















