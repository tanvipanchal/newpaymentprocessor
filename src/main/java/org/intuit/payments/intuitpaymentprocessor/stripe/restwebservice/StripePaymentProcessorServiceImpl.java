package org.intuit.payments.intuitpaymentprocessor.stripe.restwebservice;



import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;


import org.intuit.payments.intuitpaymentprocessor.model.IntuitCard;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.Card;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.Charge;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.CardTokenResponse;
import org.intuit.payments.intuitpaymentprocessor.stripe.model.ChargeResponse;
import org.intuit.payments.intuitpaymentprocessor.stripe.restwebservice.StripePaymentProcessorServiceInterface;

public class StripePaymentProcessorServiceImpl implements StripePaymentProcessorServiceInterface{
	
	public WebTarget getStripeVersion1WebTarget()
	{
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("https://api.stripe.com/");
		WebTarget versionV1Target = baseTarget.path("v1");
		
		return versionV1Target;
	}
	
	@Override
	public CardTokenResponse createCardToken(Card stripeCard) {
		WebTarget  versionV1Target = getStripeVersion1WebTarget();	
		WebTarget tokensTarget = versionV1Target.path("tokens");
		
		
		Form form = new Form();
		form.param("card[number]",stripeCard.getId());
		form.param("card[exp_month]", Integer.toString(stripeCard.getExp_month()));
		form.param("card[exp_year]", Integer.toString(stripeCard.getExp_year()));
		form.param("card[cvc]", stripeCard.getCvc());
		
		CardTokenResponse token = tokensTarget.request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer sk_test_BQokikJOvBiI2HlWgH4olfQ2")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),CardTokenResponse.class);
		
		return token;
	}

	@Override
	public ChargeResponse createCharge(Charge charge) {
		WebTarget  versionV1Target = getStripeVersion1WebTarget();	
		WebTarget chargesTarget = versionV1Target.path("charges");
		
		Form form = new Form();
		form.param("amount", Integer.toString(charge.getAmount()));
		form.param("currency", charge.getCurrency());
		form.param("source", charge.getSource());
		form.param("description", charge.getDescription());
		
		ChargeResponse chargeRes = chargesTarget.request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer sk_test_BQokikJOvBiI2HlWgH4olfQ2")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), ChargeResponse.class);
		return chargeRes;
	}





	@Override
	public Charge buildStripeChargeObject(CardTokenResponse cardToken, IntuitCard intuitCard) {
		Charge charge = new Charge();
		charge.setAmount(intuitCard.getCharge().getAmount());
		charge.setSource(cardToken.getId());
		charge.setCurrency(intuitCard.getCurrency());
		charge.setDescription(intuitCard.getCharge().getDecription());
		
		return charge;
	}

	@Override
	public Card buildStripeCardObject(org.intuit.payments.intuitpaymentprocessor.model.IntuitCard intuitCard) {
		Card stripeCard = new Card();
		stripeCard.setId(intuitCard.getCardNumber());
		stripeCard.setObject(intuitCard.getObject());
		//Address address;
		stripeCard.setAddress_city(intuitCard.getAddress_city());
		stripeCard.setAddress_country(intuitCard.getAddress_country());
		stripeCard.setAddress_line1(intuitCard.getAddress_line1());
		stripeCard.setAddress_line1_check(intuitCard.getAddress_line1_check());
		stripeCard.setAddress_line2(intuitCard.getAddress_line2());
		stripeCard.setAddress_state(intuitCard.getAddress_state());
		stripeCard.setAddress_zip(intuitCard.getAddress_zip());
		stripeCard.setAddress_zip_check(intuitCard.getAddress_zip_check());
		stripeCard.setBrand(intuitCard.getBrand());
		stripeCard.setCountry(intuitCard.getCountry());
		stripeCard.setCurrency(intuitCard.getCurrency());
		stripeCard.setCustomer(intuitCard.getCustomer());
		stripeCard.setCvc_check(intuitCard.getCvc_check());
		stripeCard.setDefault_for_currency(intuitCard.getDefault_for_currency());
		stripeCard.setDynamic_last4(intuitCard.getDynamic_last4());
		stripeCard.setExp_month(intuitCard.getExp_month());
		stripeCard.setExp_year(intuitCard.getExp_year());
		stripeCard.setFingerprint(intuitCard.getFingerprint());
		stripeCard.setFunding(intuitCard.getFunding());
		stripeCard.setLast4(intuitCard.getLast4());
		stripeCard.setMetadata(intuitCard.getMetadata());
		stripeCard.setName(intuitCard.getName());
		stripeCard.setCvc(intuitCard.getCvc());
		stripeCard.setTokenization_method(intuitCard.getTokenization_method());
		
		return stripeCard;
	}

	@Override
	public ChargeResponse retriveCharge(String chargeId) {
		
		WebTarget  versionV1Target = getStripeVersion1WebTarget();	
		WebTarget chargesTarget = versionV1Target.path("charges");
		WebTarget singleChargeTarget = chargesTarget.path("{chargeId}");
		
		ChargeResponse chargeRes = singleChargeTarget.resolveTemplate("chargeId", chargeId).request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer sk_test_BQokikJOvBiI2HlWgH4olfQ2")
				.get(ChargeResponse.class);
		return chargeRes;
		
	}

	@Override
	public ChargeResponse updateCharge(String description,String chargeId) {		
		WebTarget  versionV1Target = getStripeVersion1WebTarget();	
		WebTarget chargesTarget = versionV1Target.path("charges");
		WebTarget singleChargeTarget = chargesTarget.path("{chargeId}");
		
		Form form = new Form();
		form.param("description", description);
		
		ChargeResponse chargeRes = singleChargeTarget.resolveTemplate("chargeId", chargeId).request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer sk_test_BQokikJOvBiI2HlWgH4olfQ2")
				.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE), ChargeResponse.class);
		return chargeRes;
		
		
	}

}

