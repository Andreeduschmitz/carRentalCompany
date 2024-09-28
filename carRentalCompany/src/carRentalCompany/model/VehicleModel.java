package carRentalCompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import carRentalCompany.bean.VehicleBean;
import carRentalCompany.enums.VehicleCategory;

public class VehicleModel {

	public static void create(VehicleBean vehicle, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("INSERT INTO public.vehicle(\n"
				+ "	vehicleplate, vehiclemodel, vehiclelaunchyear, vehiclecategory, dailyvalue, brandid)\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?);");
		ps.setString(1, vehicle.getVehiclePlate());
		ps.setString(2, vehicle.getVehicleModel());
		ps.setInt(3, vehicle.getVehicleLaunchYear());
		ps.setDouble(4, vehicle.getDailyValue());
		ps.setInt(5, vehicle.getVehicleCategory().ordinal());
		
		ps.execute();
		ps.close();
	}
	
	public static void update(VehicleBean vehicle, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("UPDATE public.vehicle"
				+ "	SET vehicleplate=?, vehiclemodel=?, vehiclelaunchyear=?, vehiclecategory=?, dailyvalue=?, brandid=?"
				+ "	WHERE public.vehicle.vehicleid=?");
		ps.setString(1, vehicle.getVehiclePlate());
		ps.setString(2, vehicle.getVehicleModel());
		ps.setInt(3,  vehicle.getVehicleLaunchYear());
		ps.setInt(4, vehicle.getVehicleCategory().ordinal());
		ps.setDouble(5, vehicle.getDailyValue());
		ps.setString(6, vehicle.getVehicleBrand());
		
		ps.execute();
		ps.close();
	}
	
	public static void detele(VehicleBean vehicle, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("DELETE FROM public.vehicle"
				+ "	WHERE public.vehicle.vehicleid=?");
		ps.setInt(1, vehicle.getVehicleId());
		
		ps.execute();
		ps.close();
	}
	
	public static ArrayList<VehicleBean> listAll(Connection con) throws SQLException {
		Statement st;
		ArrayList<VehicleBean> list = new ArrayList<VehicleBean>();
		
		st = (Statement) con.createStatement();
		String query = "SELECT vehicleid, vehicleplate, vehiclemodel, vehiclelaunchyear, vehiclecategory, dailyvalue, vehiclebrand FROM public.vehicle;";
		ResultSet result = st.executeQuery(query);
		
	    while(result.next()) {
	        list.add(new VehicleBean(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(7),
	        		VehicleCategory.fromOrdinal(result.getInt(5)), result.getDouble(6)));
	    }
	    
	    return list;
	}

	public static ArrayList<VehicleBean> listBySearch(VehicleBean vehicle, Connection con) throws SQLException {
		PreparedStatement ps;
		ArrayList<VehicleBean> list = new ArrayList<VehicleBean>();
		String selectClause = "SELECT vehicleid, vehicleplate, vehiclemodel, vehiclelaunchyear, vehiclecategory, dailyvalue, vehiclebrand FROM public.vehicle";
		String whereClause;
		
		if(vehicle.getVehiclePlate() != null) {
			whereClause = " WHERE public.vehicle.vehicleplate LIKE '%?%';";
			ps = con.prepareStatement(selectClause + whereClause);
			ps.setString(1, vehicle.getVehiclePlate());
		} else if(vehicle.getVehicleModel() != null) {
			whereClause = " WHERE public.vehicle.vehiclemodel LIKE '%?%';";
			ps = con.prepareStatement(selectClause + whereClause);
			ps.setString(1, vehicle.getVehicleModel());
		} else if(vehicle.getVehicleCategory() != null) {
			whereClause = " WHERE public.vehicle.vehiclecategory = ?;";
			ps = con.prepareStatement(selectClause + whereClause);
			ps.setInt(1, vehicle.getVehicleCategory().ordinal());
		} else if(vehicle.getDailyValue() != null) {
			whereClause = " WHERE public.vehicle.dailyvalue <= ?;";
			ps = con.prepareStatement(selectClause + whereClause);
			ps.setDouble(1, vehicle.getDailyValue());
		} else {
			whereClause = " WHERE public.vehicle.vehiclebrand LIKE '%?%';";
			ps = con.prepareStatement(selectClause + whereClause);
			ps.setString(1, vehicle.getVehicleBrand());
		}
		
		ResultSet result = ps.executeQuery();
		
	    while(result.next()) {
	        list.add(new VehicleBean(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(7),
	        		VehicleCategory.fromOrdinal(result.getInt(5)), result.getDouble(6)));
	    }
	    
	    return list;
	}
}
