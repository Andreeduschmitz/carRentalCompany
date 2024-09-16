package carRentalCompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import carRentalCompany.bean.AdressBean;

public class AdressModel {
	
	public static void create(AdressBean address, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("INSERT INTO public.address("
				+ "	addresscep, addressstreet, addressneighborhood, addressnumber, addresscomplement, clientid)"
				+ "	VALUES (?, ?, ?, ?, ?, ?);");
		ps.setInt(1, address.getAdressCep());
		ps.setString(2, address.getAdressStreet());
		ps.setString(3, address.getAdressNeighborhood());
		ps.setInt(4, address.getAdressNumber());
		ps.setString(5, address.getAdressComplement());
		ps.setInt(6, address.getClientId());
		
		ps.execute();
		ps.close();
	}
	
	public static void update(AdressBean address, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("UPDATE public.address"
				+ "	SET addressid=?, addresscep=?, addressstreet=?, addressneighborhood=?, addressnumber=?, addresscomplement=?, clientid=?"
				+ "	WHERE public.address.addressid=?;");
		ps.setInt(1, address.getAdressCep());
		ps.setString(2, address.getAdressStreet());
		ps.setString(3, address.getAdressNeighborhood());
		ps.setInt(4, address.getAdressNumber());
		ps.setString(5, address.getAdressComplement());
		ps.setInt(6, address.getClientId());
		ps.setInt(7, address.getAdressId());
		
		ps.execute();
		ps.close();
	}
	
	public static void delete(AdressBean address, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("DELETE FROM public.address"
				+ " WHERE public.address.addressid=?");
		ps.setInt(1, address.getAdressId());
		
		ps.execute();
		ps.close();
	}
}
