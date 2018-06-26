public class  Monitor extends Thread
{
	public void run() {
		do{
			testAllDBs();
			testAllCorbas();
			testBackendC();
			System.out.println("#############################################");
			try{
				sleep(15000);
			}catch(Exception e){
			}
		}while (true);
	}


	private void testAllDBs()
	{
		java.util.Date StartTime = new java.util.Date();
		java.util.Date EndTime = null;
		//test local db
		if (mon.OracleClient.isAlive(mon.OracleClient.LOCAL))
		{
			EndTime = new java.util.Date();
			System.out.println("Connection to LOCAL ORACLE DB successfully.Using time:"+(EndTime.getTime()-StartTime.getTime())+"ms");
		}
		else
		{
			EndTime = new java.util.Date();
			System.out.println("Connection to LOCAL ORACLE DB failed.Using time:"+(EndTime.getTime()-StartTime.getTime())+"ms");
		}
		//test backend  db
		if (mon.OracleClient.isAlive(mon.OracleClient.REMOTE))
		{
			EndTime = new java.util.Date();
			System.out.println("Connection to REMOTE ORACLE DB successfully.Using time:"+(EndTime.getTime()-StartTime.getTime())+"ms");
		}
		else
		{
			EndTime = new java.util.Date();
			System.out.println("Connection to REMOTE ORACLE DB failed.Using time:"+(EndTime.getTime()-StartTime.getTime())+"ms");
		}

	}
	/**
	*This method try to connect to the backend c service
	*/
	private void testBackendC(){
		java.util.Date today = new java.util.Date();
		System.out.println("Connecting to Backend C services...");
		//PsB2B service
		if ( mon.PsB2BClient.isAlive().length() == 0)
		{
			System.out.println("\tBackend C Socket Service is alive@"+today);
		}
		else
		{
			System.out.println("\tBackend C Socket Service is down@"+ today);
		}		
	}
	private void testAllCorbas()
	{
		java.util.Date today = new java.util.Date();
		System.out.println("Connecting to corba services...");
		//PsB2B service
		if ( mon.PsB2BClient.isAlive().length() == 0)
		{
			System.out.println("\tPsB2B Service is alive@"+today);
		}
		else
		{
			System.out.println("\tPsB2B Service is down@"+ today);
		}		
		//BsInfoQuery service
		if ( mon.BsInfoQueryClient.isAlive().length() == 0)
		{
			System.out.println("\tBsInfo Service is alive@"+today);
		}
		else
		{
			System.out.println("\tBsInfo Service is down@"+ today);
		}
		//business service
		if ( mon.BusinessClient.isAlive().length() == 0)
		{
			System.out.println("\tBusiness Service is alive@"+today);
		}
		else
		{
			System.out.println("\tBusiness Service is down@"+ today);
		}
		//policy application service
		if (mon.PolicyAppClient.isAlive().length() == 0 )
		{
			System.out.println("\tPolicy App Service is alive@"+today);
		}
		else
		{
			System.out.println("\tPolicy App Service is down@"+today);
		}
		//Customer service
		if (mon.CustClient.isAlive().length() == 0 )
		{
			System.out.println("\tCustomer Service is alive@"+today);
		}
		else
		{
			System.out.println("\tCustomer Service is down@"+today);
		}
		//Policy Service
		if (mon.PolicyClient.isAlive().length() == 0 )
		{
			System.out.println("\tPolicy Service is alive@"+today);
		}else
		{
			System.out.println("\tPolicy Service is down@"+today);
		}
		//Email Service
		if (mon.EmailClient.isAlive().length() == 0 )
		{
			System.out.println("\tEmail Service is alive@"+today);
		}
		else
		{
			System.out.println("\tEmail Service is down@"+today);
		}
		//Policy Information Service
		if (mon.PolicyInfoClient.isAlive().length() == 0 )
		{
			System.out.println("\tPolicy Information Service is alive@"+today);
		}
		else
		{
			System.out.println("\tPolicy Information Service is down@"+today);
		}
		//Payment Service
		if (mon.PaymentClient.isAlive().length() == 0 )
		{
			System.out.println("\tPayment Service is alive@"+today);
		}
		else
		{
			System.out.println("\tPayment Service is down@"+today);
		}
		//Static Infmation Servie
		if (mon.StaticInfoClient.isAlive().length() == 0 )
		{
			System.out.println("\tStatic Information Service is alive@"+today);
		}
		else
		{
			System.out.println("\tStatic Information Service is down@"+today);
		}

	}

	public static void main(String[] args) 
	{
		new Monitor().start();
	}
}
