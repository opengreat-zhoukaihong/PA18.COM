package utility;
import java.util.*;
public class formMoney
{
	private final static String CHN[] = {"Áã","Ò¼","·¡","Èþ","ËÁ","Îé","Â½","Æâ","°Æ","¾Á"};
	private final static String CUNIT[] = {"ÒÚ","Íò","Çª","°Û","Ê°",""};
	private final static String CDECIMAL[] = {"½Ç","·Ö"};
	private final static String E2DIGIT[] = {"","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN",
	"ELEVEN","TWELVE","THIRTEEN","FOURTEEN","FIFTEEN","SIXTEEN","SEVENTEEN","EIGHTEEN","NINETEEN"};
	private final static String E20DIGIT[] = {"","","TWENTY","THIRTY","FORTY","FIFTY","SIXTY","SEVENTY","EIGHTY","NINETY"};
	private final static String EBIGDIGIT[] = {"","HUNDRED","THOUSAND","MILLION","BILLION"};                                                   

	private static String eTrans2(String num2){
		int index;
		String result = "";
		if(num2 == null || num2.length()< 1 || num2.length()>2)
			return result;
		try{
			index = Integer.parseInt(num2);
			result = E2DIGIT[index];
			return result;
		}
		catch(NumberFormatException e){
			return "";
		}
		catch(ArrayIndexOutOfBoundsException e){
			result = "";
		}
		result = result+E20DIGIT[Integer.parseInt(new String(num2.toCharArray(),0,1))];
		if (num2.toCharArray()[1] != '0')
			result = result + "-" + E2DIGIT[Integer.parseInt(new String(num2.toCharArray(),1,1))];
		return result;
	}
	
	private static String eTrans3(String num3){
		int index;
		String result = "",temp = "";
		if(num3 == null || num3.length()< 1 || num3.length()>3)
			return result;
		if (num3.length() < 3)
			return eTrans2(num3);
		if (num3.toCharArray()[0] != '0')
			result += eTrans2(new String(num3.toCharArray(),0,1))+" "+EBIGDIGIT[1];
		temp = eTrans2(new String(num3.toCharArray(),1,2));
		if (temp.length() != 0 )
			if (result.length()>0)
				result +=" AND ";
			result += temp;
		return result;
	}

	public static String getEng(String num){
		int index = 0,offset  = 0,count = 3;
		String result = "";
		String point = getDecimal(num);
		boolean isAnd = false;
		num = getInteger(num);
        
		if( num == null || num.length() <1 || num.length()>15)
			return "";

		if(num.substring(num.length() - 2).equals("00"))
		{
			isAnd = true;
			System.out.println("isAnd = true;");
        }

		num = new StringBuffer(num).reverse().toString();
		char c[] = num.toCharArray();
		if (num.length()<4){
			result = eTrans3(new StringBuffer(num).reverse().toString());
			if (!point.equals("00") && !point.equals("0") && point.length()>0){
				result = result + " AND "+eTrans3(point)+" CENTS";
			}
			return result;
		}
		for (int i=0;;i++){
				if (eTrans3(new StringBuffer(new String(c,offset,count)).reverse().toString()).length()==0)
					result = eTrans3(new StringBuffer(new String(c,offset,count)).reverse().toString())+result;
				else{
					if (i != 0)
						if(result.length()>0)
					{
						if((result.indexOf(EBIGDIGIT[1]) < 0) || (i>0 &&  offset<=3 && (isAnd && (!(!point.equals("00") && !point.equals("0") && point.length()>0)))))//is to not add AND
						{
							result = eTrans3(new StringBuffer(new String(c,offset,count)).reverse().toString())+" "+EBIGDIGIT[i+1]+" AND "+result;
					}else
						{
								result = eTrans3(new StringBuffer(new String(c,offset,count)).reverse().toString())+" "+EBIGDIGIT[i+1]+" "+result;
					}

					}
						else
							result = eTrans3(new StringBuffer(new String(c,offset,count)).reverse().toString())+" "+EBIGDIGIT[i+1]+result;
					else
						result = eTrans3(new StringBuffer(new String(c,offset,count)).reverse().toString())+" "+EBIGDIGIT[i]+result;
				}
			offset += 3;
			if (offset + count >c.length)
				count = c.length - offset;
			if (offset > c.length-1)
				break;
		}

		if (!point.equals("00") && !point.equals("0") && point.length()>0){
						result = result + " AND "+eTrans3(point)+" CENTS";
		}
		return result+" ONLY";
	}
	public static String trans1(String num1){
		int index;
		if(num1 == null || num1.length() != 1)
			return "";
		try{
			index = Integer.parseInt(num1);
		}
		catch(NumberFormatException e){
			return "";
		}
		return CHN[index];
	}

	private static String trans4(String num4){
		String result = "";//return string
		boolean tailZero = true;//true = tail zero and not be display;false = tail not zero or displayed
		boolean middleZero = false;//true = middle zero and not be display;false = middle not zero or displayed

		if(num4 == null || num4.length() < 1 || num4.length()>4)
			return result;
		for (int i=num4.length()-1, j=CUNIT.length-1; i>=0;i--,j--){
			if (tailZero && num4.charAt(i) != '0' ) tailZero = false;
			if (!tailZero){
				if (num4.charAt(i) != '0'){
					if (middleZero){
						result = trans1("0")+result;
						middleZero = false;
					}//f (middleZero)
					result = trans1(String.valueOf(num4.charAt(i)))+CUNIT[j]+result;
				}//if (num4.charAt(i) != '0')
				else{
					middleZero = true;
					//result = trans1(String.valueOf(num4.charAt(i)))+result;
				}//else
			}//if (!tailZero)
		}//for (int i=num4.length()-1, j=3; i>=0;i--,j--)
		if ( middleZero)
			result = trans1("0")+result;
		return result;
	}
	public static String trans8(String num8){
		String result = "";
		if(num8 == null || num8.length() < 1 || num8.length()>8)
			return result;
		num8 = new StringBuffer(num8).reverse().toString();
		char c[] =num8.toCharArray();
		int offset = 0;
		int count = 4;
		if (count >c.length) count = c.length;

		for (int i=0;;i++){
			if (i ==1 && trans4(new StringBuffer(new String(c,offset,count)).reverse().toString()).length()>0) result = CUNIT[1]+result;
			result = trans4(new StringBuffer(new String(c,offset,count)).reverse().toString())+result;
			offset += 4;
			if (offset + count >c.length)
				count = c.length - offset;
			if (offset > c.length-1)
				break;
		}
		return result;
	}
	
	public static String getInteger(String num){
		StringTokenizer st = new StringTokenizer(num,".");
		return st.nextToken();
	}

	public static String getDecimal(String num){
		StringTokenizer st = new StringTokenizer(num,".");
		try{
			st.nextToken();
			return st.nextToken();
		}
		catch(NoSuchElementException e){
			return "";
		}
	}

	public static String getChn(String num){
		String result = "";
		String num16 = getInteger(num);
		String point16 = getDecimal(num);
		if(num16 == null || num16.length() < 1 || num16.length()>16)
			return result;
		num16 = new StringBuffer(num16).reverse().toString();
		char c[] =num16.toCharArray();
		int offset = 0;
		int count = 8;
		if (count >c.length) count = c.length;

		for (int i=0;;i++){
			if (i ==1 && trans8(new StringBuffer(new String(c,offset,count)).reverse().toString()).length()>0) result = CUNIT[0]+result;
			result = trans8(new StringBuffer(new String(c,offset,count)).reverse().toString())+result;
			offset += 8;
			if (offset + count >c.length)
				count = c.length - offset;
			if (offset > c.length-1)
				break;
		}
		result += "Ô²";
		if (!point16.equals("00") && !point16.equals("0") && point16.length()>0){
			for (int i=0;i<2 && i<point16.toCharArray().length;i++){
				result = result + trans1(new String(point16.toCharArray(),i,1))+CDECIMAL[i];
			}
		}
		else{
			result +="Õû";
		}
		return result;
	}

	public static void main(String[] args){
		System.out.println(getEng(args[0]));
	}
}
