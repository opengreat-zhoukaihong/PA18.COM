import java.util.*;
//Multithread class to test ServerLeap
class TestServerLeap extends Thread{
	public void run(){
		for (int i=0; i<2000; i++){
			try{
				sleep(1);
			}catch(InterruptedException e){
				System.out.println("sleep interrupted");
			}
			statistic();
		}
	}

	synchronized private void statistic(){
		ServerLeap.statistic(new Date());
	}

	public static void main(String args[]){
		new TestServerLeap().start();
		new TestServerLeap().start();
		new TestServerLeap().start();
		new TestServerLeap().start();
		try{
			sleep(10000);
		}catch(InterruptedException e){
			System.out.println("sleep interrupted");
		}
		System.out.println(ServerLeap.getMaxCount());
	}
}
public class ServerLeap
{
	private static double currentSecond;
	private static long maxCount;
	private static long count;

	synchronized public static void statistic(Date d){
		long ms = d.getTime();
		if ((ms/1000) == currentSecond){
			count ++;
		}
		else{
			if (count > maxCount)
				maxCount = count;
			count = 1;
			currentSecond = ms/1000;
			}
	}

	synchronized public static long getMaxCount(){
		if (count>maxCount)
			return count;
		else
			return maxCount;
	}

	public static void main(String[] args) 
	{
		for (int i=0;i<2000000;i++){
			Date d  = new Date();
			ServerLeap.statistic(d);
		}
		System.out.println(ServerLeap.getMaxCount());
	}
}
