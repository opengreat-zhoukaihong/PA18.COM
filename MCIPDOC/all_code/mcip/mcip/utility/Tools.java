////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Common utilities
// Update Date:2000/7/20
////////////////////////////////////////////////////////

package utility;

import java.util.*;
public class Tools {
   public Tools() {
      	super();
   }
   public static String ComposeValue(String[] SValue) {
      	int l = 0;
      	int i = 0;
      	String STemp = SValue[0].trim();
      	if (SValue[0] == null || SValue[0].compareTo("") == 0) {
         		return "";
      	}
	      StringTokenizer ptoken = new StringTokenizer(STemp);
      	int plen = ptoken.countTokens();
      	String[] p = new String[plen];
      	while (ptoken.hasMoreTokens()) {
         		p[i++] = ptoken.nextToken();
      	}
      	l = p.length;
      	String sVal = new String(p[0]);
      	for (i = 1; i < p.length; i++) {
         		sVal = sVal + "&" + p[i];
      	}
      	return sVal;
   }

   public static String ConvertCN(String is) {
      	if (is == null || is.compareTo("") == 0)
         		return "";
      	String os;
      	int l = is.length();
      	byte[] tmp = new byte[l];
      	for (int q = 0; q < l; q++) {
      	int t = (int) is.charAt(q);
      	if (t > 128)
         		t += 0xff00;
      		tmp[q] = (byte) t;
      	}
      	os = new String(tmp);
      	return os;
   }

   public static String[] DevideString(String SourceString, String StrDevidor) {
      	String[] retStr1;
      	int i = 0;
      	if (SourceString == null)
         		return null;
      	if (SourceString.equals(""))
         		return null;

      	StringTokenizer stFirst = new StringTokenizer(SourceString, StrDevidor);

      	retStr1 = new String[stFirst.countTokens()];

      	while (stFirst.hasMoreTokens()){
       			try	{
         		 		retStr1[i] = stFirst.nextToken().replace('\"',' ');
         		 		retStr1[i] = retStr1[i].trim();

         		 		retStr1[i] = retStr1[i].replace('\'',' ');
         		 		retStr1[i] = retStr1[i].trim();
       			}
       			catch(NoSuchElementException e){}
            		i++;
       }

       return retStr1;
   }
   
   public static String[] difference(String[] sc1, String[] sc2) {
      	String[] result;
      	Vector tmpv = new Vector();
      	int i, j;
      	if (sc1 == null)	return null;
      	if (sc1.length == 0) return null;
      	if (sc2 == null)	return sc1;
      	if (sc2.length == 0)	return sc1;
      	for (i = 0; i < sc1.length; i++) {
         		sc1[i] = sc1[i].trim();
         		for (j = 0; j < sc2.length; j++) {
            			sc2[j] = sc2[j].trim();
            			if (sc1[i].equals(sc2[j])) {
               				break;
            			}
         		}
         		if (j == sc2.length)
         		tmpv.addElement(sc1[i]);
      	}
      	int vsize;
      	vsize = tmpv.size();
      	if (vsize == 0)	return null;
      	result = new String[vsize];
      	for (i = 0; i < vsize; i++)
         		result[i] = (String) tmpv.elementAt(i);
      	return result;
   }

   public static String[] difference(String[] sc1, String[] sc2, String df) {
      	String[] result;
      	Vector tmpv = new Vector();
      	Vector tmpv1 = new Vector();
      	String[] tmps1;
      	String[] tmps2;
      	String[] tmps;
      	int i, j;
      	if (sc1 == null)	return null;
      	if (sc1.length == 0) 		return null;
      	if (sc2 == null) 		return sc1;
      	if (sc2.length == 0)	return sc1;

      	tmps1 = new String[sc1.length];
      	tmps2 = new String[sc2.length];
      	for (i = 0; i < sc1.length; i++) {
         		tmps = Tools.DevideString(sc1[i], df);
          	if (tmps.length == 2) {
            			sc1[i] = tmps[0];
               tmps1[i] = tmps[1];
          	}
      	}

      	for (i = 0; i < sc2.length; i++) {
        		tmps = Tools.DevideString(sc2[i], df);
     	   	sc2[i] = tmps[0];
      	}
      	for (i = 0; i < sc1.length; i++) {
         	sc1[i] = sc1[i].trim();
         	for (j = 0; j < sc2.length; j++) {
            			sc2[j] = sc2[j].trim();
            			if (sc1[i].equals(sc2[j])) {
               				break;
            			}
         	}
      	   if (j == sc2.length) {
          			tmpv.addElement(sc1[i]);
       		   	tmpv1.addElement(tmps1[i]);
         	}
      	}
      	int vsize;
      	vsize = tmpv.size();
      	if (vsize == 0)
         		return null;
       result = new String[vsize];
      	for (i = 0; i < vsize; i++) {
         		result[i] = (String) tmpv.elementAt(i);
          	result[i] = result[i] + "|" + (String) tmpv1.elementAt(i);
       }
      	return result;
   }

   public static String[] intersection(String[] sc1, String[] sc2) {
      	String[] result;
      	Vector tmpv = new Vector();
      	int i, j;
      	if (sc1 == null || sc2 == null)
         		return null;
      	for (i = 0; i < sc1.length; i++) {
         		sc1[i] = sc1[i].trim();
           for (j = 0; j < sc2.length; j++) {
            			sc2[j] = sc2[j].trim();
            			if (sc1[i].equals(sc2[j])) {
               				tmpv.addElement(sc1[i]);
               				break;
            			}
         		}
      	}
      	int vsize;
      	vsize = tmpv.size();
      	if (vsize == 0)		return null;
      	result = new String[vsize];
      	for (i = 0; i < vsize; i++)
         		result[i] = (String) tmpv.elementAt(i);
      	return result;
   }

   public static String[] intersection(String[] sc1, String[] sc2, String df) {
      	String[] result;
      	Vector tmpv = new Vector();
      	Vector tmpv1 = new Vector();
      	String[] tmps1;
      	String[] tmps2;
      	String[] tmps;
      	int i, j;
      	if (sc1 == null || sc2 == null)
         		return null;
      	tmps1 = new String[sc1.length];
      	tmps2 = new String[sc2.length];
      	for (i = 0; i < sc1.length; i++) {
         		tmps = Tools.DevideString(sc1[i], df);
         		if (tmps.length == 2) {
            			sc1[i] = tmps[0];
            			tmps1[i] = tmps[1];
         		}
      	}
      	for (i = 0; i < sc2.length; i++) {
         		tmps = Tools.DevideString(sc2[i], df);
         		if (tmps.length == 2) {
            			sc2[i] = tmps[0];
            			tmps2[i] = tmps[1];
         		}
      	}
      	for (i = 0; i < sc1.length; i++) {
         		sc1[i] = sc1[i].trim();
         		for (j = 0; j < sc2.length; j++) {
            			sc2[j] = sc2[j].trim();
            			if (sc1[i].equals(sc2[j])) {
               				tmpv.addElement(sc1[i]);
               				tmpv1.addElement(tmps1[i]);
               				break;
            			}
         		}
      	}
      	int vsize;
      	vsize = tmpv.size();
      	if (vsize == 0)
      		return null;
      	result = new String[vsize];
      	for (i = 0; i < vsize; i++) {
         		result[i] = (String) tmpv.elementAt(i);
         		result[i] = result[i] + "|" + (String) tmpv1.elementAt(i);
      	}
      	return result;
   }
}
