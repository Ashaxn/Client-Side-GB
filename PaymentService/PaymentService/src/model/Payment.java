package model;

public class Payment {
	private int id;
	private int recipientId;
	private double total;
	private String paymentMethod;
	private String paidAt;
	private int researcheId;
	private Integer buyerId;
	private Integer fundingbodyId;
	
	public Payment() {
		super();
	}

	public Payment(int recipientId, double total, String paymentMethod,
			int researcheId, Integer buyerId, Integer fundingbodyId) {
		super();
		this.recipientId = recipientId;
		this.total = total;
		this.paymentMethod = paymentMethod;
		this.researcheId = researcheId;
		this.buyerId = buyerId;
		this.fundingbodyId = fundingbodyId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(String paidAt) {
		this.paidAt = paidAt;
	}


	public int getResearcheId() {
		return researcheId;
	}

	public void setResearcheId(int researcheId) {
		this.researcheId = researcheId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getFundingbodyId() {
		return fundingbodyId;
	}

	public void setFundingbodyId(Integer fundingbodyId) {
		this.fundingbodyId = fundingbodyId;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", recipientId=" + recipientId + ", total=" + total + ", paymentMethod="
				+ paymentMethod + ", paidAt=" + paidAt + ", researcheId=" + researcheId + ", buyerId=" + buyerId
				+ ", fundingbodyId=" + fundingbodyId + "]";
	}

	

}
