package org.intuit.payments.intuitpaymentprocessor.resources;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.ConnectionCallback;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.intuit.payments.intuitpaymentprocessor.model.SuccessChargeMock;
import org.intuit.payments.intuitpaymentprocessor.model.Message;
import org.intuit.payments.intuitpaymentprocessor.model.TempCharge;

@Path("/v1/TimedOut_Payment_Succeeded")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TimedOut_Payment_Succeeded {
	
	
	@POST
	public Message postPayment(@Suspended final AsyncResponse asyncResponse)
	{
		final SuccessChargeMock c = new SuccessChargeMock();
		c.createCharge("12345");
		System.out.println("Charge created " + c.getCharge("12345").getChargeId() + " " + c.getCharge("12345").isStatus());
		

		
		asyncResponse.setTimeoutHandler(new TimeoutHandler() {
			 
	        @Override
	        public void handleTimeout(AsyncResponse asyncResponse) {
	        	TempCharge myCharge = c.getCharge("12345");
	        	System.out.println("Connection Timed Out  " + myCharge.getChargeId() + " " + myCharge.isStatus() + " resuming..." );
				if(myCharge.isStatus()==true)
				{
					System.out.println("success");
					asyncResponse.resume(Response.status(Response.Status.OK)
							.entity("Payment Processed Successfully").build());
				}
				else
				{
					
					asyncResponse.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)
	                    .entity("Payment was not successful").build());
				}
	        }
	    });
		
		
		asyncResponse.setTimeout(5, TimeUnit.SECONDS);
		
		
		new Thread(new Runnable() {
			 
	        @Override
	        public void run() {
	        	System.out.println("Initiating process charge request ");
	            TempCharge charge = c.processCharge("12345");
	            System.out.println("Charge process output is " + charge.getChargeId() + " " + charge.isStatus() + " resuming..." );
	            asyncResponse.resume(charge);
	        }
	 
	        
	    }).start();
		
		Message m = new Message();
		//System.out.println("Send payment success message." + asyncResponse.toString());
		 m.setMessage("Payment Successful");
		 return m;
		
	}

}
