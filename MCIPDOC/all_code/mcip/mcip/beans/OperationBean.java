////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function：For Operation select item data
// Create date：2000/08/11
// Update date：2000/08/15
////////////////////////////////////////////////////////

package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import beans.*;




public class OperationBean
{
    private String tranType = "";
    private String credit = "";
    private String[] homeTransit = null;
    private String[] portTransit = null;
    private String[] homeTransitName = null;
    private String[] portTransitName = null;
	private String [][] savedResult = null;
    private String InsrInfo[][] = null;
	private String PlyInfo[] = null;
    //for remote user
    private String remoteOperType = "";
    private String[][] remoteData = null;
    //for form data store
    private Hashtable hashData = new Hashtable();
    private String[][] formData = null;
    private int step = 0;

    private String[] tempOne = null;
    private String[][] tempTwo = null;

    public OperationBean()
    {
    }

    public void setRemoteOperType(String newValue)
    {
        this.remoteOperType = newValue;
    }
    public void setTranType(String newValue)
    {
        this.tranType = newValue;
    }

    public void setCredit(String newValue)
    {
        this.credit = newValue;
    }

    public void setPortTransit(String[] newValue)
    {
        this.portTransit = newValue;
    }

    public void setHomeTransit(String[] newValue)
    {
        this.homeTransit = newValue;
    }

    public void setPortTransitName(String[] newValue)
    {
        this.portTransitName = newValue;
    }

    public void setHomeTransitName(String[] newValue)
    {
        this.homeTransitName = newValue;
    }

    public void setTempOne(String[] newValue)
    {
        this.tempOne = newValue;
    }
    public void setTempTwo(String[][] newValue)
    {
        this.tempTwo = newValue;
    }
    public void setRemoteData(String[][] newValue)
    {
        this.remoteData = newValue;
    }

    public void setStep(int newValue)
    {
        this.step = newValue;
    }

    public String getRemoteOperType()
    {
        return this.remoteOperType;
    }

    public String getTranType()
    {
        return this.tranType;
    }

    public int getStep()
    {
        return this.step;
    }

    public String getCredit()
    {
        return this.credit;
    }

    public String[] getPortTransit()
    {
        return this.portTransit;
    }

    public String[] getHomeTransit()
    {
        return this.homeTransit;
    }

    public String[] getPortTransitName()
    {
        return this.portTransitName;
    }

    public String[] getHomeTransitName()
    {
        return this.homeTransitName;
    }
    public String[] getTempOne()
    {
        return this.tempOne;
    }
    public String[][] getTempTwo()
    {
        return this.tempTwo;
    }
    public String[][] getRemoteData()
    {
        return this.remoteData;
    }

//for datastore and get to refresh form
    public Hashtable getHashData()
    {
        return this.hashData;
    }
    public void setFormDataAdd(String[][] NewValue) throws NormalException
    {
        this.formData = NewValue;
        TranData();
    }
    /** @Author kangjin
     *  将另外一个散列表中的数据加入到现有的散列表中来
     */
     public static void setFormDataAdd(Hashtable hash,Hashtable newHash) throws NormalException{
      hash.putAll(newHash);
     }
    public void setFormData(String[][] NewValue) throws NormalException
    {
        this.formData = NewValue;
        hashData.clear();
        TranData();
    }

	public void setFormData(Hashtable ht) throws NormalException
	{
		this.hashData = ht;
	}


    private void TranData() throws NormalException
    {
    	int i = 0;
    	int Row = Servlets.getLen(formData);//formData.length;
    	String Temp = "";

    	if(formData == null || Row<2)
    	    return;
    	//     throw new NormalException("System internal datapara error");

        for(i = 0; i < formData[0].length; i++)
        {
    	    Temp = formData[0][i].toUpperCase();
    	    hashData.put(Temp,formData[1][i]);
        }
        return;
    }

//get remote field's disable property
    public String getFieldProp(String FieldName) throws NormalException
    {
    	String RetProp = "";
    	if(remoteData == null)
    	     return RetProp;

    	String ParaData[][] = remoteData;
    	if(ParaData == null || ParaData.length < 2)
    	     return RetProp;
    	for(int i = 0 ; i < ParaData[0].length; i++)
    	{
    		if(FieldName.equalsIgnoreCase(ParaData[0][i]) & !(ParaData[1][i] == null || ParaData[1][i].equals("")))
    		{
    			RetProp = " disabled ";
    			break;
    		}
    	}

       return RetProp;
    }
	public void setHashData(Hashtable newHashData){
	   hashData = newHashData;
	}

	public void setPlyInfo(String PlyInfo[]){
	   this.PlyInfo = PlyInfo;
	}
	public String[] getPlyInfo(){
	  return PlyInfo;
	}
	public void setInsrInfo(String[][] InsrInfo){
	 this.InsrInfo = InsrInfo;
	}
	public String[][] getInsrInfo(){
	  return InsrInfo;
	}

	public String[][] getSavedResult(){
		return savedResult;
	}

	public void setSavedResult(String[][] result){
		this.savedResult = result;
	}
}
