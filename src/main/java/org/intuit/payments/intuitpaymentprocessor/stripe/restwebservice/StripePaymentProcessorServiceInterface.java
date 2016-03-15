package org.intuit.payments.intuitpaymentprocessor.stripe.restwebservice;

import org.intuit.payments.intuitpaymentprocessor.stripe.model.Card;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.Charge;
import org.intuit.payments.intuitpaymentprocessor.model.IntuitCard;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.CardTokenResponse;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.ChargeResponse;

public interface StripePaymentProcessorServiceInterface {
	
	public Card buildStripeCardObject(IntuitCard card);
	public CardTokenResponse createCardToken(Card stripeCard);
	public Charge buildStripeChargeObject(CardTokenResponse cardToken, IntuitCard intuitCard);
	public ChargeResponse createCharge(Charge charge);
	public ChargeResponse retriveCharge(String chargeId);
	public ChargeResponse updateCharge(String description,String chargeId);
	
	
}
