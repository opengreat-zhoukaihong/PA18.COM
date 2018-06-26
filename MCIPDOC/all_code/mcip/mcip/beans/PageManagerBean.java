package beans;
import constant.*;
/**
*PageManagerBean is used to divide the multi-line page into serveral pages.
*Because all the data will stored in the bean ,so the scope of bean must be set as "session". You can use the 
*bean simply follow the setps:
*1.invoke method dumpIn() to save the data from database.
*2.invoke method setPageLength() to set the page lines as you need(this step is optional).
*3.invoke method getPage() to retrieve the specified page content from bean.
*<font color="red">The data from PageManagerBean is the same as you store in ,except less rows.</font>
*@author ¿µ½ø author C&T SoftWare(SZ) Co., Ltd.
*@version 1.0
*/
public class PageManagerBean
{
	private String pageArray[][] = null;
	private String titleArray[] = null;
	private String thisPage[][] = null;
	private int pageLength = BConst.PAGE_LENGTH;
	/**
	*		set the row numbers per page.
	*		There is a default value.This method may not invoke at most time. "leng" should be greater than 0,
	*otherwise the pageLength will not change. You can invoke the method getPageLength() to check  the length value.
	*@param leng  int valule of page rows 
	*@return void
	*@exception no exception thrown
	*/
	public void setPageLength(int leng)
	{
		if (leng>0)
			pageLength = leng;
	}
	/**
	*get total rows number per page.
	*@param none
	*@return int number of total rows
	*@exception noException no exception thrown
	*
	*/
	public int getPageLength() 
	{
		return pageLength;
	}

	/**
	*	save the table into the bean.
	*	@param list two dimension string array(first row is save the field name)
	*  @return boolean if the operator is done
	*  @exception noException no exception thrown
	*/

	public boolean dumpIn(String[][] list) //dump all the data into the bean storage
	{
		pageArray = null;
		titleArray = null;
		if (list!=null && list.length> 1 && list[0].length>0)
		{
			titleArray = new String[list[0].length];
			System.arraycopy(list[0],0,titleArray,0,list[0].length);
			pageArray = new String[list.length-1][list[0].length];
			for (int i=1,j=0;i<list.length ;i++,j++ )
			{
				System.arraycopy(list[i],0,pageArray[j],0,list[i].length);	
			}
			return true;
		}
		else
			return false;
	}

	/**
	*	output all the table saved in the bean.
	*	@param none
	*  @return String[][] the table saved,if failed a null will be returned
	*  @exception noException no exception thrown
	*/
public String[][] dumpOut(){
	thisPage = null;

	if (pageArray == null || titleArray == null)
		return thisPage;

	thisPage = new String[pageArray.length+1][pageArray[0].length];

	System.arraycopy(titleArray,0,thisPage[0],0,titleArray.length);
	for (int i=0,j = 1;i<pageArray.length ; i++,j++ )
		System.arraycopy(pageArray[i],0,thisPage[j],0,pageArray[i].length);	

	return thisPage;
	}

	/**
	*	get how many pages there are.
	*	Notice that the return value is the total pages, and page number is begin 	with 0 ,so the max page 
	*	number should be retrieve as following codes:
	*	eg.
	*		int totalPage = p.getTotalPage();//get the total pages ;
	*		int maxPageNum = totalPage - 1; // get the max page number;
	*	@param none
	*	@return int total number of pages
	*	@exception noException no exception thrown
	*/
	public int getTotalPage()
	{
		int totalPage = 0;
		if (pageArray == null)
			return totalPage;
		totalPage = pageArray.length/pageLength;
		if (pageArray.length%pageLength > 0)
			totalPage++;
		return totalPage;
	}
	/**
	*	get the specified page's content.
	*	pageNo is the page number which begins with 0.
	*	when this method is invoked , it will try to 
	*	find the data meet the condition. If failed a null
	*	will be returned.
	*	@param pageNo int value of page no(start from 0)
	*	@return String[][] a table of this page(first line is the column name)
	*	@exception noException no exception thrown
	*/
	public String[][] getPage(int pageNo)
	{
		thisPage = null;
		int thisLength = 0;

		if (pageArray == null || titleArray == null || pageNo < 0)
		{
			return thisPage;
		}

		if (pageNo * pageLength < pageArray.length) 
		{
			if ((pageNo + 1) * pageLength > pageArray.length) 
				thisLength = pageArray.length%pageLength;
			else
				thisLength = pageLength;
			System.out.println("thisLength:"+thisLength);
			thisPage = new String[thisLength+1][pageArray[0].length];

			System.arraycopy(titleArray,0,thisPage[0],0,titleArray.length);
			for (int i=pageNo * pageLength,j = 1;i<(pageNo+1) * pageLength && i< pageArray.length; i++,j++ )
			{
				System.arraycopy(pageArray[i],0,thisPage[j],0,pageArray[i].length);	
			}
			return thisPage;
		}
		else
			return thisPage;
	}
}
