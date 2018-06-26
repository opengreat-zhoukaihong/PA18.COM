package beans;
class Pages 
{
	static String pageList[][] =null;
	static int totalRows = 0;
	static int pageRows = 0;
	static int pageNo = 0;
	public int[] getPageAttribute()
	{
		int retArray[] = {totalRows,pageRows,pageNo};
		return retArray;
	}
	public void setPageAttribute(int tRows, int pRows, int pNo)
	{
		totalRows = tRows;
		pageRows = pRows;
		pageNo = pNo;
		return;
	}
	public boolean fillPage(String[][] page)
	{
		if (page == null || page.length<1 || page[0].length<1)
			return false;
		pageList = new String[page.length][page[0].length];
		for (int i=0; i<page.length ; i++ )
		{
			System.arraycopy(page[i],0,pageList[i],0,page[i].length);
		}
			return true;
	}
	public void emptyPage()
	{
		pageList = null;
		return;
	}
	public static void main(String[] args)
	{
	}
}