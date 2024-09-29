package carRentalCompany.bean;

public class ClientBean {
	private int clientId;
	private String clientName;
	private long clientCpf;
	private String clientPhone;
	private String clientEmail;

	public ClientBean(String clientName, long clientCpf, String clientPhone, String clientEmail) {
		super();
		this.clientName = clientName;
		this.clientCpf = clientCpf;
		this.clientPhone = clientPhone;
		this.clientEmail = clientEmail;
	}

	public ClientBean(int clientId, String clientName, long clientCpf, String clientPhone, String clientEmail) {
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

	public long getClientCpf() {
		return clientCpf;
	}

	public void setClientCpf(long clientCpf) {
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

	@Override
	public String toString() {
		return "ClientBean [clientId=" + clientId + ", clientName=" + clientName + ", clientCpf=" + clientCpf
				+ ", clientPhone=" + clientPhone + ", clientEmail=" + clientEmail + "]";
	}
}