package carRentalCompany.bean;

import carRentalCompany.enums.VehicleCategory;

public class VehicleBean {
	int vehicleId;
	String vehiclePlate;
	String vehicleModel;
	int vehicleLaunchYear;
	String vehicleBrand;
	VehicleCategory vehicleCategory;
	Double dailyValue;

	public VehicleBean(int vehicleId, String vehiclePlate, String vehicleModel, int vehicleLaunchYear, String vehicleBrand, VehicleCategory vehicleCategory, Double dailyValue) {
		this.vehicleId = vehicleId;
		this.vehiclePlate = vehiclePlate;
		this.vehicleModel = vehicleModel;
		this.vehicleLaunchYear = vehicleLaunchYear;
		this.vehicleBrand = vehicleBrand;
		this.vehicleCategory = vehicleCategory;
		this.dailyValue = dailyValue;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public int getVehicleLaunchYear() {
		return vehicleLaunchYear;
	}

	public void setVehicleLaunchYear(int vehicleLaunchYear) {
		this.vehicleLaunchYear = vehicleLaunchYear;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public VehicleCategory getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(VehicleCategory vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public Double getDailyValue() {
		return dailyValue;
	}

	public void setDailyValue(Double dailyValue) {
		this.dailyValue = dailyValue;
	}
}