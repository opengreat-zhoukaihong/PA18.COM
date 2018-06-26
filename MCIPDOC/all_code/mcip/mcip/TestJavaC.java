import beans.*;
import java.util.*;
import jtoc.*;
public class TestJavaC 
{/**
	public static void main(String[] args) throws Exception
	{
		String policyCond = "PE0201admin         19    1    9    0    1    010186000201010000281zs2009_en1";

		String [] ss = {"T_ITEM_DCRB PC0213",
			"T_ITEM_DCRB PE0201",
			"T_ITEM_DCRB RC0001",
			"T_ITEM_DCRB RE0001",
			"T_DOC_DATABLK",
			"205 PC0213",
			"205 PE0201",
			"205 RC0001",
			"205 RE0001"};
		PolicyPrintBean ppb  = new PolicyPrintBean();
		long startTime = new Date().getTime();
		String policyStr = ppb.getPrintPolicy(policyCond);
		System.out.println("##"+policyStr+"##"+"\nlength:"+policyStr.length());
		String[] single = ppb.getPrintFormats(ss);
		long endTime = new Date().getTime();
		for (int i=0;i<single.length ;i++ )
		{
			if (single[i] != null)
			{
				System.out.println("**S**"+single[i].length()+"**E**");
			}else{
			System.out.println("**S**"+single[i]+"**E**");
			}
		}

		System.out.println("Total "+(endTime - startTime)+"sec.");
		
	}*/
	public static void main(String [] args){
			try{
			String _inCondStr = "PE0201admin         19    1    9    0    1    010186000201010000281zs2009_en1";
			PrintObj pb = new PrintObj(_inCondStr);//construct the input query conditon string
			jtoc.PacketHead ph= new jtoc.PacketHead(jtoc.JCConstant.GETPRINTINFO_PACKET_ID);//construct packet header
			//call c function
			jtoc.JavaC jc=new jtoc.JavaC(ph,pb);
			jc.init();
			jc.JavaCMain();
			String retStr = ((PrintObj)jc.GetReturnObj()).condStr;
			System.out.println("[retStr length:]"+retStr.length());
			System.out.println("[retStr]["+retStr+"]");
			//get return object and return
		}catch (Exception e){
			System.out.println(new java.util.Date()+"Error occus when calling c to get print format:"+e);
		}

	}
}
