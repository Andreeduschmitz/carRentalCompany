package carRentalCompany.bean;

import java.sql.Date;

public class RentalBean {
	int rentalId;
	Date startDate;
	Date endDate;
	Integer renovationId;
	int vehicleId;
	int sellerId;

	public RentalBean(Date startDate, Date endDate, Integer renovationId, int vehicleId, int sellerId) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.renovationId = renovationId;
		this.vehicleId = vehicleId;
		this.sellerId = sellerId;
	}

	public RentalBean(int rentalId, Date startDate, Date endDate, Integer renovationId, int vehicleId, int sellerId) {
		this.rentalId = rentalId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.renovationId = renovationId;
		this.vehicleId = vehicleId;
		this.sellerId = sellerId;
	}

	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getRenovationId() {
		return renovationId;
	}

	public void setRenovationId(Integer renovationId) {
		this.renovationId = renovationId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
}