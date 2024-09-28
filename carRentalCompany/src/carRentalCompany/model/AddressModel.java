package carRentalCompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import carRentalCompany.bean.AddressBean;
import carRentalCompany.bean.ClientBean;

public class AddressModel {
	
	public static void create(AddressBean address, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("INSERT INTO public.address("
				+ "	addresscep, addressstreet, addressneighborhood, addressnumber, addresscomplement, clientid)"
				+ "	VALUES (?, ?, ?, ?, ?, ?);");
		ps.setInt(1, address.getAddressCep());
		ps.setString(2, address.getAddressStreet());
		ps.setString(3, address.getAddressNeighborhood());
		ps.setInt(4, address.getAddressNumber());
		ps.setString(5, address.getAddressComplement());
		ps.setInt(6, address.getClientId());
		
		ps.execute();
		ps.close();
	}
	
	public static void update(AddressBean address, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("UPDATE public.address"
				+ "	SET addressid=?, addresscep=?, addressstreet=?, addressneighborhood=?, addressnumber=?, addresscomplement=?, clientid=?"
				+ "	WHERE public.address.addressid=?;");
		ps.setInt(1, address.getAddressCep());
		ps.setString(2, address.getAddressStreet());
		ps.setString(3, address.getAddressNeighborhood());
		ps.setInt(4, address.getAddressNumber());
		ps.setString(5, address.getAddressComplement());
		ps.setInt(6, address.getClientId());
		ps.setInt(7, address.getAddressId());
		
		ps.execute();
		ps.close();
	}
	
	public static void delete(AddressBean address, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("DELETE FROM public.address"
				+ " WHERE public.address.addressid=?");
		ps.setInt(1, address.getAddressId());
		
		ps.execute();
		ps.close();
	}
	
	public static ArrayList<AddressBean> findAddressByClient(ClientBean client, Connection con) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT addressid, addresscep, addressstreet, addressneighborhood, addressnumber, addresscomplement, clientid\n"
				+ "	FROM public.address"
				+ " WHERE public.address.clientid=?;");
		ps.setInt(1, client.getClientId());
		
		ResultSet result = ps.executeQuery();
		ArrayList<AddressBean> addresses = new ArrayList<AddressBean>();
		
		while(result.next()) {
			addresses.add(new AddressBean(result.getInt(0), result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getInt(6)));
		}
		
		return addresses;
	}
}
