package controller;

import java.util.HashMap;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Payment;
import service.PaymentService;;


/*
 *default Port : 8081 
 *http://localhost:8081/PaymentService/api/v2/payment/*
*/
@Path("/payment") 
public class PaymentController {
	
	private Payment payment;
	private PaymentService paymentService = new PaymentService();
	
	@POST
	@Path("/addpayment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPayment(HashMap<String, ?> paymentData) {
		Integer buyerId, fundingbody_id;

		Long recipienIdTemp = new Long((long) paymentData.get("recipient_id"));
		int recipienId = recipienIdTemp.intValue();	
		Long l = new Long((long) paymentData.get("total"));
		double total = l.doubleValue();
		String paymentMethod = (String) paymentData.get("paymentMethod");
		
		Long researcherIdTemp = new Long((long) paymentData.get("researcher_id"));
		int researcherId = researcherIdTemp.intValue();	
		
		if(paymentData.get("buyerId") != null) {
			Long buyerIdTemp = new Long((long) paymentData.get("buyerId"));
			buyerId = buyerIdTemp.intValue();
		}else {
			buyerId = null;
		}
			
		if(paymentData.get("fundingbody_id") != null) {
			Long fundingbody_idTemp = new Long((long) paymentData.get("fundingbody_id"));
			fundingbody_id = fundingbody_idTemp.intValue();
		}else {
			fundingbody_id = null;
		}

		payment = new Payment(recipienId, total, paymentMethod, researcherId, buyerId, fundingbody_id);
		return paymentService.addPayment(payment);
	}
	
	@GET
	@Path("/getpayments")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPayments() {
		return paymentService.getAllPayments();
	}
	
	@GET
	@Path("/getpaymentbyid/{paymentid}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBuyerById(@PathParam("paymentid") Integer paymentid) {
		return paymentService.getPaymentById(paymentid);
	}
    
	@DELETE
	@Path("/deletebyid/{paymentId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("paymentId") Integer paymentId) {
		return paymentService.deletePayment(paymentId);
	}
	
	@GET
	@Path("/getpaymentwithdata/{paymentid}")
	public Response getPaymentWithUser(@PathParam("paymentid") Integer paymentid) {
		return paymentService.getPaymentWithUser(paymentid);
	}
	
	
	@GET
	@Path("/getpaymenalldetails")
	public Response getPaymenAllDetails() {
		return paymentService.getPaymenAllDetails();
	}
		
}
	

