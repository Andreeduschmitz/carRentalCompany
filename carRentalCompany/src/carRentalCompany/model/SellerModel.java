package carRentalCompany.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import carRentalCompany.bean.SellerBean;

public class SellerModel {

	public static void create(SellerBean seller, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("INSERT INTO public.seller("
				+ "	sellername, sellerphone, selleremail)"
				+ "	VALUES ( ?, ?, ?);");
		ps.setString(0, seller.getSellerName());
		ps.setString(1, seller.getSellerPhone());
		ps.setString(2, seller.getSellerEmail());
		
		ps.execute();
		ps.close();
	}
	
	public static void update(SellerBean seller, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("UPDATE public.seller"
				+ "	SET sellername=?, sellerphone=?, selleremail=?"
				+ "	WHERE public.seller.sellerid=?;");
		ps.setString(0, seller.getSellerName());
		ps.setString(1, seller.getSellerPhone());
		ps.setString(2, seller.getSellerEmail());
		
		ps.execute();
		ps.close();
	}
	
	public static void delete(SellerBean seller, Connection connection) throws SQLException {
		PreparedStatement ps;
		ps = connection.prepareStatement("DELETE FROM public.seller"
				+ "	WHERE public.seller.id=?;");
		ps.setInt(0, seller.getSellerId());
		
		ps.execute();
		ps.close();
	}
	
	public static ArrayList<SellerBean> listAll(Connection con) throws SQLException {
		Statement st;
		ArrayList<SellerBean> list = new ArrayList<SellerBean>();
		
		st = (Statement) con.createStatement();
		String query = "SELECT sellerid, sellername, sellerphone, selleremail FROM public.seller;";
		ResultSet result = st.executeQuery(query);
		
	    while(result.next()) {
	        list.add(new SellerBean(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
	    }

	    return list;
	}

	public static ArrayList<SellerBean> searchByName(Connection con, String name) throws SQLException {
		PreparedStatement ps;
		ArrayList<SellerBean> list = new ArrayList<SellerBean>();
		
		ps = con.prepareStatement("SELECT sellerid, sellername, sellerphone, selleremail FROM public.seller WHERE public.seller.sellername LIKE '%?%';");
		ps.setString(0, name);
		ResultSet result = ps.executeQuery();
		
	    while(result.next()) {
	        list.add(new SellerBean(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
	    }

	    return list;
	}
}
