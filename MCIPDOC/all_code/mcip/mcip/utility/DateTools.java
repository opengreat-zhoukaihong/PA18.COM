package utility;
import java.util.*;
import java.text.*;
/**
 You can use the static method of this class like this
 <li>//increase the day of today
 <li> ...
 <li> Date today = new Date();
 <li> Date tomorrow = DateTools.shiftDay(today,1,DateTools.INCREASE);
 <li> Date yesterday = DateTools.shiftDay(today,1,DateTools.DECREASE);
 <li> ...
 */

public class DateTools {
	//Constants Define
	public static final long INCREASE = 1;//operation indicator
	public static final long DECREASE = -1;//operation indicator
	private static final long SECONDS_PER_MINUTE = 60;//number of second per minute
	private static final long MINUTES_PER_HOUR = 60;//number of minute per hour
	private static final long HOURS_PER_DAY = 24;//number of hour per day

	public static Date shiftDay(Date shiftDate,long days,long flag){
		Date sd = new Date(shiftDate.getTime());
		sd.setTime(
					shiftDate.getTime()+
					days*flag*1000*SECONDS_PER_MINUTE*MINUTES_PER_HOUR*HOURS_PER_DAY);
		return sd;

	}

	public static void main(String args[]){
		try{
		Date today = new SimpleDateFormat("yyyy-MM-dd").parse(args[0]);
		Date tomorrow = DateTools.shiftDay(today,1,DateTools.INCREASE);
		System.out.println("today is:"+today+"\n"+"tomorrow is:"+tomorrow);
		}catch (Exception e){
			System.out.println(e);
		}
	}
}