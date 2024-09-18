package carRentalCompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carRentalCompany.bean.ClientBean;
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
	
	public static ArrayList<RentalBean> searchRentalByClient(ClientBean client, Connection con) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT rentalid, startdate, enddate, renovationid, vehicleid, sellerid, clientid"
				+ "	FROM public.rental"
				+ " WHERE public.rental.clientid=?");
		ps.setInt(0, client.getClientId());
		
		ResultSet result = ps.executeQuery();
		ArrayList<RentalBean> rentals = new ArrayList<RentalBean>();
		
		while(result.next()) {
			rentals.add(new RentalBean(result.getInt(0), result.getDate(1), result.getDate(2), result.getInt(3), result.getInt(4), result.getInt(5), result.getInt(6)));
		}
		
		return rentals;
	}
}