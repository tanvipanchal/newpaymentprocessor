package org.intuit.payments.intuitpaymentprocessor.resources;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.ConnectionCallback;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.MediaType;

import org.intuit.payments.intuitpaymentprocessor.model.SuccessChargeMock;
import org.intuit.payments.intuitpaymentprocessor.model.IntuitCard;
import org.intuit.payments.intuitpaymentprocessor.model.Message;
import org.intuit.payments.intuitpaymentprocessor.model.TempCharge;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.Card;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.CardTokenResponse;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.Charge;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.ChargeResponse;
import org.intuit.payments.intuitpaymentprocessor.stripe.restwebservice.StripePaymentProcessorServiceImpl;
import org.intuit.payments.intuitpaymentprocessor.stripe.restwebservice.StripePaymentProcessorServiceInterface;

@Path("/v1/payments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentResource {
	StripePaymentProcessorServiceInterface stripeEndpoint;
	
	@GET
	@Path("/{chargeId}")
	public ChargeResponse getChargeDetails(@PathParam("chargeId") String chargeId) 
	{
		stripeEndpoint  = new StripePaymentProcessorServiceImpl();
		return stripeEndpoint.retriveCharge(chargeId);
		
	}
	
	@POST
	public ChargeResponse postPayment(IntuitCard intuitCard)
	{
		stripeEndpoint = new StripePaymentProcessorServiceImpl();
		
		Card stripeCard = stripeEndpoint.buildStripeCardObject(intuitCard);
		
		CardTokenResponse cardToken = stripeEndpoint.createCardToken(stripeCard);
		
		Charge stripeCharge = stripeEndpoint.buildStripeChargeObject(cardToken, intuitCard);
		
		ChargeResponse charge = stripeEndpoint.createCharge(stripeCharge);
		
		return charge;
	}
	
	@PUT	
	@Path("/{chargeId}")
	public ChargeResponse updateCharge(@PathParam("chargeId") String chargeId, IntuitCard intuitCard)
	{
		stripeEndpoint = new StripePaymentProcessorServiceImpl();
		ChargeResponse chargeResp = stripeEndpoint.updateCharge(intuitCard.getCharge().getDecription(), chargeId);
		return chargeResp;
	}
	
	@DELETE
	@Path("/{chargeId}")
	public Message refundCharge(@PathParam("chargeId") String chargeId)
	{
		Message msg = new Message();
		msg.setMessage("Refunded to required debit/credit card for " + chargeId + " charge transaction");
		
		return msg;
	}

	
}
