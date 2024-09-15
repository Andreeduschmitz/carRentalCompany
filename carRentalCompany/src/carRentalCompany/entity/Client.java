package carRentalCompany.entity;

public class Client {
	int clientId;
	String clientName;
	int clientCpf;
	int clientPhone;
	String clientEmail;

	public Client(int clientId, String clientName, int clientCpf, int clientPhone, String clientEmail) {
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

	public int getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(int clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
}