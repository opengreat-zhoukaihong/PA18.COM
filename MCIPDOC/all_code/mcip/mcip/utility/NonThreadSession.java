package utility;
import java.util.*;
import java.lang.*;
import java.io.*;

public class  NonThreadSession
{
	private String data;
	private int timeOut=5000;
	private long accessTime=0;

	public String getData()
	{
		Date d = new Date();
		if ((d.getTime()-accessTime)<timeOut) 
		{
			accessTime = d.getTime();
			return data;
		}
		else
			return null;
	}

	public void setData(String value)
	{
		Date d = new Date();
		accessTime = d.getTime();
		data = value;
	}
	public int getTimeOut()
	{
		return timeOut;
	}
	public void setTimeOut(int newTimeOut)
	{
		timeOut = newTimeOut;
	}
}
