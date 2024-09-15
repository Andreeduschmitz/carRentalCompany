package carRentalCompany.entity;

public class Seller {
	int sellerId;
	String sellerName;
	String sellerPhone;
	String sellerEmail;

	public Seller(int sellerId, String sellerName, String sellerPhone, String sellerEmail) {
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerPhone = sellerPhone;
		this.sellerEmail = sellerEmail;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerPhone() {
		return sellerPhone;
	}

	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
}