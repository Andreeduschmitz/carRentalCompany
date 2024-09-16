package carRentalCompany.bean;

public class AdressBean {
	int adressId;
	int adressCep;
	String adressStreet;
	String adressNeighborhood;
	int adressNumber;
	String adressComplement;
	int clientId;
	
	public AdressBean(int adressCep, String adressStreet, String adressNeighborhood, int adressNumber,
			String adressComplement, int clientId) {
		this.adressCep = adressCep;
		this.adressStreet = adressStreet;
		this.adressNeighborhood = adressNeighborhood;
		this.adressNumber = adressNumber;
		this.adressComplement = adressComplement;
		this.clientId = clientId;
	}

	public AdressBean(int adressId, int adressCep, String adressStreet, String adressNeighborhood, int adressNumber,
			String adressComplement, int clientId) {
		this.adressId = adressId;
		this.adressCep = adressCep;
		this.adressStreet = adressStreet;
		this.adressNeighborhood = adressNeighborhood;
		this.adressNumber = adressNumber;
		this.adressComplement = adressComplement;
		this.clientId = clientId;
	}

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}

	public int getAdressCep() {
		return adressCep;
	}

	public void setAdressCep(int adressCep) {
		this.adressCep = adressCep;
	}

	public String getAdressStreet() {
		return adressStreet;
	}

	public void setAdressStreet(String adressStreet) {
		this.adressStreet = adressStreet;
	}

	public String getAdressNeighborhood() {
		return adressNeighborhood;
	}

	public void setAdressNeighborhood(String adressNeighborhood) {
		this.adressNeighborhood = adressNeighborhood;
	}

	public int getAdressNumber() {
		return adressNumber;
	}

	public void setAdressNumber(int adressNumber) {
		this.adressNumber = adressNumber;
	}

	public String getAdressComplement() {
		return adressComplement;
	}

	public void setAdressComplement(String adressComplement) {
		this.adressComplement = adressComplement;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
}