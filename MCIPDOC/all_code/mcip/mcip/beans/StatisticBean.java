package beans;
import java.util.*;
/**
 * Title:
 * Description:  beans for statistic purpose
 * Copyright:    Copyright (c) 2000
 * Company:      C&T
 * @author Lawrence Kang
 * @version 1.0
 */

public class StatisticBean {
	private static final String[][] CURR_INFO={
											    {"01","RMB","人民币"},
												{"02","HKD","港币"},
												{"03","USD","美元"}
											  };
	private static final int CURRENCY_CODE = 0;
	private static final int CURRENCY_SYMBOL = 1;
	private static final int CURRENCY_CHNNAME = 2;
		/**本方法用于将从数据库中选出的数据进行筛选<br>
	 * 使用者给出待筛选的数据和筛选的依据，方法返回筛选结果和统计
	 */
	public static String[][] filter(String in_data[][],String key){
		Vector tempStore = new Vector();
		float summaryPrm = 0,summaryAmt = 0;
		String[][] result = null;
		if (in_data == null)
			return null;
		for (int i=0;i<in_data.length;i++){
			if (key.equals(in_data[i][Objects.getColNum("C_PRM_CUR",in_data)])){
			    tempStore.add(in_data[i]);
				summaryPrm += Float.parseFloat(in_data[i][Objects.getColNum("N_TGT_PRM",in_data)]);
				summaryAmt += Float.parseFloat(in_data[i][Objects.getColNum("N_TGT_AMT",in_data)]);
			}
		}
		//初始化返回数组
		//第一行：字段名
		//最后一行：小计结果
		if (tempStore.size()>0){
			result = new String[tempStore.size()+2][in_data[0].length];
			//初始化最后行
			for (int i=0;i<result[result.length-1].length;i++)
				result[result.length-1][i] = "";
			//填入小计结果
			result[result.length-1][Objects.getColNum("C_PLY_NO",in_data)] = getCurrInfo(key,CURRENCY_CHNNAME) + "小计:";//小计标题
		    result[result.length-1][Objects.getColNum("N_TGT_PRM",in_data)] = new Float(summaryPrm).toString();//小计保费
			result[result.length-1][Objects.getColNum("C_PRM_CUR",in_data)] = key;//保费币种

			if (!key.equals(CURR_INFO[2][0])){
				result[result.length-1][Objects.getColNum("N_TGT_AMT",in_data)] = new Float(summaryAmt).toString();//小计保额
				result[result.length-1][Objects.getColNum("C_CUR_SBL",in_data)] = getCurrInfo(key,CURRENCY_SYMBOL);//保额币种
			}


		}
		else{
			result = new String[1][in_data[0].length];
		}
		//填入字段名
		result[0] = in_data[0];

		for (int i=0;i<tempStore.size();i++){
			result[i+1] = (String[])tempStore.elementAt(i);
		}
		return result;
	}

	/** This private method accept the input index and return the whole detail information of the currency<br>
	 *  NOTE:The indexString can be one of the following: currency code,currency symbol or currency name in Chinese<br>
	 *  Example, to get the information of HKD(Hong Kong doller):
	 *  String HKDSymbol = getCurrInfo("02",CURRENCY_SYMBOL);<br>
	 *  String HKDCHNName = getCurrInfo("HKD",CURRENCY_CHNNAME);<br>
	 *  String HKDCode = getCurrInfo("港币",CURRENCY_CODE);<br>
	 *  If no specifate information be found,a null will be returned
	 */
	private static String[] getCurrInfo(String indexString){
		if (indexString == null)
			return null;
		for (int i=0;i<CURR_INFO.length;i++){
			for (int j=0;j<CURR_INFO.length;j++)
				if (CURR_INFO[i][j].equals(indexString)){
					return CURR_INFO[i];
				}
		}
		return null;
	}

	/**
	 * This private mehtod accept the input index and specific information index then return the specific information of the currency<br>
	 * NOTE:The indexString can be one of the following string: currency code,currency symbol or currency name in Chinese<br>
	 * NOTE:The infoIndex can be one of the following int :CURRENCY_CODE,CURRENCY_SYMBOL,CURRENCY_CHNNAME
	 * Example, to get the detail information of HKD(Hong Kong doller):
	 *  String HKDInfo = getCurrInfo("02",);<br>
	 *  String HKDInfo = getCurrInfo("HKD");<br>
	 *  String HKDInfo = getCurrInfo("港币");<br>
	 *  any of the above statement will get the properiate information about HKD
	 *  If no specifate information be found,a null will be returned
	 */
	 private static String getCurrInfo(String indexString,int infoIndex){
		String[] tempArray = getCurrInfo(indexString);
		if (tempArray == null)
			return null;
		if (infoIndex<0 || infoIndex >2)
			return null;
		return tempArray[infoIndex];
	 }

}