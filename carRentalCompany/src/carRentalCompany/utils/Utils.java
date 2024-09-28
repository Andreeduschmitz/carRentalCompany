package carRentalCompany.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
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
    		System.out.println(i + " - " + categorys[i].toString());
    	}
    	
    	Scanner input = new Scanner(System.in);
    	int option = input.nextInt();
    	
    	return VehicleCategory.fromOrdinal(option);
    }
    
    public static SellerBean selectSeller(Connection con) throws SQLException {
    	ArrayList<SellerBean> sellers = SellerModel.listAll(con);

    	for(SellerBean seller : sellers) {
    		System.out.println(seller.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = -1;

        while (true) {
            try {
                System.out.print("Digite o índice do vendedor que deseja selecionar: ");
                index = input.nextInt();
                if (index >= 0 && index < sellers.size()) {
                    break;
                } else {
                    System.out.println("Índice fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next();
            }
        }

        return sellers.get(index);
    }
    
    public static VehicleBean selectVehicle(Connection con) throws SQLException {
    	ArrayList<VehicleBean> vehicles = VehicleModel.listAll(con);

    	for(VehicleBean vehicle : vehicles) {
    		System.out.println(vehicle.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = -1;

        while (true) {
            try {
                System.out.print("Digite o índice do veículo que deseja selecionar: ");
                index = input.nextInt();
                if (index >= 0 && index < vehicles.size()) {
                    break;
                } else {
                    System.out.println("Índice fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next();
            }
        }

        return vehicles.get(index);
    }
    
    public static ClientBean selectClient(Connection con) throws SQLException {
    	ArrayList<ClientBean> clients = ClientModel.listAll(con);
    	
    	for(ClientBean client : clients) {
    		System.out.println(client.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = -1;

        while (true) {
            try {
                System.out.print("Digite o índice do cliente que deseja selecionar: ");
                index = input.nextInt();
                if (index >= 0 && index < clients.size()) {
                    break;
                } else {
                    System.out.println("Índice fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next();
            }
        }
        
        return clients.get(index);
    }
    
    public static ClientBean selectClientBySearch(Connection con, int cpf, String name) throws SQLException {
    	ArrayList<ClientBean> clients = ClientModel.search(cpf, name, con);
    	
    	for(ClientBean client : clients) {
    		System.out.println(client.toString());
    	}
    	
        Scanner input = new Scanner(System.in);
        int index = -1;

        while (true) {
            try {
                System.out.print("Digite o índice do cliente que deseja selecionar: ");
                index = input.nextInt();
                if (index >= 0 && index < clients.size()) {
                    break;
                } else {
                    System.out.println("Índice fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next();
            }
        }
        
        return clients.get(index);
    }

	public static RentalBean selectRentalByClient(Connection con, ClientBean client) throws SQLException {
		ArrayList<RentalBean> rentals = RentalModel.searchRentalByClient(client, con);
		
		for(RentalBean rental : rentals) {
			System.out.println(rental.toString());
		}
		
        Scanner input = new Scanner(System.in);
        int index = -1;

        while (true) {
            try {
                System.out.print("Digite o índice da locação que deseja selecionar: ");
                index = input.nextInt();
                if (index >= 0 && index < rentals.size()) {
                    break;
                } else {
                    System.out.println("Índice fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next();
            }
        }

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
				if (index >= startIndex && index < endIndex) {
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
}
