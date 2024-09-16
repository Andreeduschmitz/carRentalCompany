package carRentalCompany.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import carRentalCompany.bean.SellerBean;
import carRentalCompany.bean.VehicleBean;
import carRentalCompany.enums.VehicleCategory;
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

        // Solicitar um índice válido ao usuário
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

        // Solicitar um índice válido ao usuário
        while (true) {
            try {
                System.out.print("Digite o índice do vendedor que deseja selecionar: ");
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
}
