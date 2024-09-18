package carRentalCompany.bean;

public class SellerBean {
	private int sellerId;
	private String sellerName;
	private String sellerPhone;
	private String sellerEmail;

	public SellerBean(String sellerName, String sellerPhone, String sellerEmail) {
		this.sellerName = sellerName;
		this.sellerPhone = sellerPhone;
		this.sellerEmail = sellerEmail;
	}

	public SellerBean(int sellerId, String sellerName, String sellerPhone, String sellerEmail) {
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

	@Override
	public String toString() {
		return "SellerBean [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerPhone=" + sellerPhone
				+ ", sellerEmail=" + sellerEmail + "]";
	}
}