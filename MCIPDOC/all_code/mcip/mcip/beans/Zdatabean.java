/*
==================================================================
=== 	 Author£º 			zlx												===
===	 Function£º			For session Data exchange				   ===
===	 Create date£º		2000/09/20										===
==================================================================
*/

package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;

public class Zdatabean
{

    private static String info1=null;
    private static String info2=null;
    private static String[] data=null;
    private static String[][] dataArra=null;

	public Zdatabean()  
   {
		super();
	}
    public void setinfo1(String para)
    {
        this.info1= para;
    }
    public String getinfo1()
    {
        return this.info1;
	 }

	 public void setinfo2(String para)
    {
        this.info2= para;
    }
    public String getinfo2()
    {
        return this.info2;
    }

    public void setdata(String[] para)
    {
        this.data= para;
    }
    public String[] getdata()
    {
        return this.data;
    }

    public void setdataArra(String[][] para)
    {
        this.dataArra = para;
    }

	 public String[][] getdataArra()
    {
        return this.dataArra;
    }

  
}
