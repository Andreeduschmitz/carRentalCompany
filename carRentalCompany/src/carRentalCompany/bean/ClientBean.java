package carRentalCompany.bean;

public class ClientBean {
	int clientId;
	String clientName;
	int clientCpf;
	String clientPhone;
	String clientEmail;

	public ClientBean(String clientName, int clientCpf, String clientPhone, String clientEmail) {
		super();
		this.clientName = clientName;
		this.clientCpf = clientCpf;
		this.clientPhone = clientPhone;
		this.clientEmail = clientEmail;
	}

	public ClientBean(int clientId, String clientName, int clientCpf, String clientPhone, String clientEmail) {
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientCpf = clientCpf;
		this.clientPhone = clientPhone;
		this.clientEmail = clientEmail;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getClientCpf() {
		return clientCpf;
	}

	public void setClientCpf(int clientCpf) {
		this.clientCpf = clientCpf;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
}