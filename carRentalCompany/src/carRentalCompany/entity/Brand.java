package carRentalCompany.entity;

public class Brand {

	int brandId;
	String brandName;
	String brandNationality;

	public Brand(int brandId, String brandName, String brandNationality) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandNationality = brandNationality;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandNationality() {
		return brandNationality;
	}

	public void setBrandNationality(String brandNationality) {
		this.brandNationality = brandNationality;
	}
}