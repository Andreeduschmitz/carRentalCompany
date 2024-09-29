package carRentalCompany.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import carRentalCompany.bean.ClientBean;
import carRentalCompany.bean.RentalBean;
import carRentalCompany.bean.SellerBean;
import carRentalCompany.bean.VehicleBean;
import carRentalCompany.enums.VehicleCategory;
import carRentalCompany.model.ClientModel;
import carRentalCompany.model.RentalModel;
import carRentalCompany.model.SellerModel;
import carRentalCompany.model.VehicleModel;

public class Utils {

    public static Date addOneDayToDate(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return new Date(calendar.getTimeInMillis());
    }
    
    public static VehicleCategory vehicleCategorySelector() {
    	VehicleCategory[] categorys = VehicleCategory.values();
    	
    	for(int i = 0; i < categorys.length; i++) {
    		System.out.println(i + 1 + " - " + categorys[i].toString());
    	}
    	
    	Scanner input = new Scanner(System.in);
    	int option = input.nextInt();
    	
    	return VehicleCategory.fromOrdinal(option - 1);
    }
    
    public static SellerBean selectSeller(Connection con) throws SQLException {
    	ArrayList<SellerBean> sellers = SellerModel.listAll(con);
    	
    	if(sellers == null || sellers.isEmpty()) {
    		System.out.println("Não há nenhum vendedor cadastrado");
    		return null;
    	}
    	
    	System.out.println("Selecione o número do vendedor");

    	for(SellerBean seller : sellers) {
    		System.out.println(seller.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = Utils.indexSelector(0, sellers.size());

        return sellers.get(index);
    }
    
    public static VehicleBean selectVehicle(Connection con) throws SQLException {
    	ArrayList<VehicleBean> vehicles = VehicleModel.listAll(con);
    	
    	if(vehicles == null || vehicles.isEmpty()) {
    		System.out.println("Não há nenhum veículo cadastrado");
    		return null;
    	}
    	
    	System.out.println("Selecione o número do veículo");

    	for(VehicleBean vehicle : vehicles) {
    		System.out.println(vehicle.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = Utils.indexSelector(0, vehicles.size());

        return vehicles.get(index);
    }
    
    public static ClientBean selectClient(Connection con) throws SQLException {
    	ArrayList<ClientBean> clients = ClientModel.listAll(con);
    	
    	if(clients == null || clients.isEmpty()) {
    		System.out.println("Não há nenhum cliente cadastrado");
    		return null;
    	}
    	
    	System.out.println("Selecione o número do cliente");
    	
    	for(ClientBean client : clients) {
    		System.out.println(client.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = Utils.indexSelector(0, clients.size());
        
        return clients.get(index);
    }
    
    public static ClientBean selectClientBySearch(Connection con, long cpf, String name) throws SQLException {
    	ArrayList<ClientBean> clients = ClientModel.search(cpf, name, con);
    	
    	if(clients == null || clients.isEmpty()) {
    		System.out.println("Nenhum cliente encontrado");
    		return null;
    	}
    	
    	System.out.println("Selecione o número do cliente");
    	
    	for(ClientBean client : clients) {
    		System.out.println(client.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = Utils.indexSelector(0, clients.size());
        
        return clients.get(index);
    }

	public static RentalBean selectRentalByClient(Connection con, ClientBean client) throws SQLException {
		ArrayList<RentalBean> rentals = RentalModel.searchRentalByClient(client, con);
		
		if(rentals == null || rentals.isEmpty()) {
			System.out.println("Esse cliente não possui nenhuma locação");
			return null;
		}
		
		System.out.println("Selecione o número da locação");
		
		for(RentalBean rental : rentals) {
			System.out.println(rental.toString());
		}
		
        Scanner input = new Scanner(System.in);
        int index = Utils.indexSelector(0, rentals.size());

        return rentals.get(index);
	}
	
	public static Boolean isVehicleInUse(Connection con, VehicleBean vehicle) throws SQLException {
		List<RentalBean> vehicleActiveRental = RentalModel.searchRentalByVehicle(vehicle, con);
		
		if(vehicleActiveRental == null || !vehicleActiveRental.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public static int indexSelector(int startIndex, int endIndex) {
		Scanner input = new Scanner(System.in);
		int index = -1;

		while (true) {
			try {
				index = input.nextInt();
				if (index >= startIndex && index <= endIndex) {
					break;
				} else {
					System.out.println("Índice fora do intervalo. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Digite um número inteiro.");
				input.next();
			}
		}
		
		return index;
	}
	
	public static long calculateDaysBetweenDates(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		
		start.setTime(startDate);
		end.setTime(endDate);
		
		long diffInMillis = end.getTimeInMillis() - start.getTimeInMillis();
		long diffInDays = diffInMillis / (24 * 60 * 60 * 1000);
		
		return diffInDays;
	}
	
    public static Date safeDateInput() {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        Date date = null;
        boolean valid = false;

        while (!valid) {
            String dateString = input.next();

            try {
                java.util.Date utilDate = dateFormat.parse(dateString);
                date = new Date(utilDate.getTime());
                valid = true;
            } catch (ParseException e) {
                System.out.println("Data inválida, tente novamente.");
            }
        }

        return date;
    }
}
