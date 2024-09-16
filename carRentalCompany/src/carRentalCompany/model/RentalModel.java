package carRentalCompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import carRentalCompany.bean.RentalBean;

public class RentalModel {

	public static void createRental(RentalBean rental, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("INSERT INTO public.rental("
				+ "	startdate, enddate, vehicleid, sellerid)"
				+ "	VALUES (?, ?, ?, ?);");
		ps.setDate(0, rental.getStartDate());
		ps.setDate(1, rental.getEndDate());
		ps.setInt(2, rental.getVehicleId());
		ps.setInt(3, rental.getSellerId());
		
		ps.execute();
		ps.close();
	}
	
	public static void createRenovation(RentalBean renovatedRental, RentalBean renovation, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("INSERT INTO public.rental("
				+ "	startdate, enddate, renovationid, vehicleid, sellerid)"
				+ "	VALUES (?, ?, ?, ?, ?);");
		ps.setDate(0, renovation.getStartDate());
		ps.setDate(1, renovation.getEndDate());
		ps.setInt(2, renovatedRental.getRentalId());
		ps.setInt(3, renovation.getVehicleId());
		ps.setInt(4, renovation.getSellerId());
		
		ps.execute();
		ps.close();
	}
}