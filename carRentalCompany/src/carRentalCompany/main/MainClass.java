package carRentalCompany.main;

import java.sql.Connection;
import java.sql.SQLException;

import carRentalCompany.connection.DBConnection;
import carRentalCompany.menu.MainMenu;

public class MainClass {
	public static void main(String[] args) throws SQLException {
        DBConnection connection = new DBConnection();
        Connection con = connection.getConnection();

        MainMenu.mainMenu(con);
        con.close();
	}
}
