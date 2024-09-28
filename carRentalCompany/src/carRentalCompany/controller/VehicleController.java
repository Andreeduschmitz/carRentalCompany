package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import carRentalCompany.bean.RentalBean;
import carRentalCompany.bean.VehicleBean;
import carRentalCompany.enums.VehicleCategory;
import carRentalCompany.model.RentalModel;
import carRentalCompany.model.VehicleModel;
import carRentalCompany.utils.Utils;

public class VehicleController {
    
	public void createVehicle(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados abaixo para cadastrar um novo veículo:");
        
        System.out.print("Placa do veículo: ");
        String vehiclePlate = input.next();

        System.out.print("Modelo do veículo: ");
        String vehicleModel = input.next();

        System.out.print("Ano de lançamento: ");
        int vehicleLaunchYear = input.nextInt();

        System.out.print("Categoria do veículo: ");
        VehicleCategory vehicleCategory = Utils.vehicleCategorySelector();

        System.out.print("Marca do veículo: ");
        String vehicleBrand = input.next();

        System.out.print("Valor da diária: ");
        double dailyValue = input.nextDouble();

        VehicleBean vehicle = new VehicleBean(vehiclePlate, vehicleModel, vehicleLaunchYear, vehicleBrand,vehicleCategory, dailyValue);
        VehicleModel.create(vehicle, con);
        System.out.println("Veículo cadastrado com sucesso!");
    }
	

    public void updateVehicle(Connection con) throws SQLException {
    	VehicleBean vehicle = Utils.selectVehicle(con);
        Scanner input = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n1 - Placa\n2 - Valor da diária\n3 - Cancelar");

        int option;
        
        do {
        	option = input.nextInt();
        	
            switch (option) {
            case 1:
                System.out.print("Digite a nova placa: ");
                String plate = input.next();
                vehicle.setVehiclePlate(plate);
                break;

            case 2:
                System.out.print("Digite o novo valor da diária: ");
                double value = input.nextDouble();
                vehicle.setDailyValue(value);
                break;
                
            case 3:
            	break;
            
            default:
            	System.out.println("Opção inválida!");
            	return;
        }
        	
        } while (option < 1 || option > 3);
        
        VehicleModel.update(vehicle, con);
        System.out.println("Informações atualizadas com sucesso!");
    }
    
    public static void deleteVehicle(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Selecione o veículo que deseja excluir:");
    	VehicleBean vehicle = Utils.selectVehicle(con);
    	
    	if(Utils.isVehicleInUse(con, vehicle)) {
    		System.out.println("Este veículo está atualmente em uso e não pode ser excluído");
    		return;
    	}
    	
    	System.out.println("Tem certeza que deseja excluir esse veículo? S/N");
    	
    	String option = input.next();
    	
    	if(option == "S" || option == "s") {
    		VehicleModel.detele(vehicle, con);
    		System.out.println("Veículo excluído com sucesso");
    	}
    }
    
    public static void listAll(Connection con) throws SQLException {
    	ArrayList<VehicleBean> vehicles = VehicleModel.listAll(con);
    	
    	if(vehicles == null || vehicles.isEmpty()) {
    		System.out.println("Não há nenhum veículo cadastrado");
    		return;
    	}
    	
    	for(VehicleBean vehicle : vehicles) {
    		System.out.println(vehicles.toString());
    	}
    }
    
    public static void listVehiclesBySearch(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	VehicleBean vehicleSearch = new VehicleBean();
    	
    	System.out.println("Digite o índice da característica do veículo a qual deseja utilizar na pesquisa:");
    	System.out.println("1 - placa, 2 - modelo, 3 - categoria, 4 - valor, 5 - marca");
    	
        int index = -1;

        while (true) {
            try {
                index = input.nextInt();
                if (index >= 0 && index < 5) {
                    break;
                } else {
                    System.out.println("Índice fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next();
            }
        }
        
        switch(index) {
	        case 1:
	            System.out.println("Digite a placa do veículo:");
	            vehicleSearch.setVehiclePlate(input.next());
	            break;
	        case 2:
	            System.out.println("Digite o modelo do veículo:");
	            vehicleSearch.setVehicleModel(input.next());
	            break;
	        case 3:
	            System.out.println("Digite a categoria do veículo:");
	            vehicleSearch.setVehicleCategory(VehicleCategory.fromOrdinal(input.nextInt()));
	            break;
	        case 4:
	            System.out.println("Digite o valor do veículo:");
	            vehicleSearch.setDailyValue(input.nextDouble());
	            break;
	        case 5:
	            System.out.println("Digite a marca do veículo:");
	            vehicleSearch.setVehicleBrand(input.next());
	            break;
        }
    	
    	ArrayList<VehicleBean> vehicles = VehicleModel.listBySearch(vehicleSearch, con);
    	
    	if(vehicles == null ||  vehicles.isEmpty()) {
    		System.out.println("Não há nenhum veículo com essa característica cadastrado");
    		return;
    	}
    	
    	for(VehicleBean vehicle : vehicles) {
    		System.out.println(vehicles.toString());
    	}
    }
    
    public static void vehicleTotalBillingInPeriod(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	VehicleBean vehicle = Utils.selectVehicle(con);
    	
		System.out.println("Digite a data inicial da busca (formato aaaa-mm-dd):");
        String startDateString = input.nextLine();
        Date startDate = Date.valueOf(startDateString);
        
        System.out.print("Digite a data final da busca (formato aaaa-mm-dd):");
        String endDateString = input.nextLine();
        Date endDate = Date.valueOf(endDateString);
        
        List<RentalBean> rentals = RentalModel.searchRentalByVehicleAndPeriod(vehicle, startDate, endDate, con);
        
        if(rentals == null | rentals.isEmpty()) {
        	System.out.println("Não há nenhuma alocação para este veículo nesse período");
        	return;
        }
        
        Long daysAmount = 0l;
        
        for(RentalBean rental : rentals) {
        	daysAmount += ChronoUnit.DAYS.between(rental.getStartDate().toInstant(), rental.getEndDate().toInstant());
        }
        
        Double billing = daysAmount * vehicle.getDailyValue();
        
        System.out.println("O valor total de faturamento do veículo no período foi de R$" + billing);
    }
}