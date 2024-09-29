package carRentalCompany.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	
	private Connection connection;
	
	public DBConnection() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String password = "119123";
		String url = "jdbc:postgresql://localhost:5432/carRentalCompany";
		
        try {
            Class.forName(driver);
            this.connection = (Connection) DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }  
	}
	
    public Connection getConnection() {
        return this.connection;
    }
    
    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
