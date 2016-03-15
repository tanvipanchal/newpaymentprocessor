package org.intuit.payments.intuitpaymentprocessor.model;

import java.util.ArrayList;
import java.util.Date;

public class SuccessChargeMock {
	
	private static final ArrayList<TempCharge> charges= new ArrayList<TempCharge>();

	
	
	public void createCharge(String chargeId)
	{
		TempCharge charge = new TempCharge();
		charge.setChargeId(chargeId);
		charge.setStatus(false);
		charges.add(charge);
		
		
	}

	public TempCharge getCharge(String chargeId)
	{
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("In getCharge method " + new Date());
				
			}
			
		});
		
		t.start();
		try {
			Thread.sleep(1000);
			
			
		for(TempCharge charge:charges)
		{
			if(charge.getChargeId().equals(chargeId))
			{
				return charge;
				
			}
			
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public TempCharge processCharge(String chargeId)
	{
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("In processCharge method : " + new Date());
				
			}
			
		});
		
		t.start();
		try {
			
			Thread.sleep(5000);
			
			for(TempCharge charge:charges)
			{
				if(charge.getChargeId().equals(chargeId))
				{
					charge.setStatus(true);
					System.out.println("Charge processed " + new Date());
					return charge;
					
				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	}
	
	
	
}
