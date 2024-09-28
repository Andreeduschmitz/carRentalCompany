package carRentalCompany.controller;

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
import carRentalCompany.utils.Utils;

public class RentalController {

    public void createRental(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados abaixo para cadastrar uma nova locação:");
        
        System.out.print("Data de início (formato aaaa-mm-dd):");
        String startDateString = input.nextLine();
        Date startDate = Date.valueOf(startDateString);

        System.out.print("Data de término (formato aaaa-mm-dd): ");
        String endDateString = input.nextLine();
        Date endDate = Date.valueOf(endDateString);
        
        System.out.println("Selecione o vendedor responsável:");
        SellerBean seller = Utils.selectSeller(con);
        
        System.out.println("Selecione o veículo que será alugado");
        VehicleBean vehicle = Utils.selectVehicle(con);
        
        System.out.println("Selecione o cliente que irá alugar o veículo");
        ClientBean client = Utils.selectClient(con);

        RentalBean rental = new RentalBean(startDate, endDate, null, vehicle.getVehicleId(), seller.getSellerId(), client.getClientId());
        RentalModel.createRental(rental, con);
        System.out.println("Locação criada com sucesso!");
    }
    
    public void createRenovation(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Insira os dados abaixo para renovar sua locação");
    	
    	System.out.println("Digite o cpf do titular da locação a ser renovada:");
    	int cpf = input.nextInt();
    	ClientBean client = Utils.selectClientBySearch(con, cpf, null);
    	
    	System.out.println("Selecione a locação a ser renovada");
    	RentalBean rental = Utils.selectRentalByClient(con, client);
    	
    	if(rental.getEndDate().after(new Date(System.currentTimeMillis()))) {
    		System.out.println("A locação já venceu e não é possível renovar");
    		return;
    	}
    	
    	System.out.println("Selecione o vendedor responsável pela renovação");
    	SellerBean seller = Utils.selectSeller(con);
    	
        System.out.print("Data de início (formato aaaa-mm-dd):");
        String startDateString = input.nextLine();
        Date startDate = Date.valueOf(startDateString);

        System.out.print("Data de término (formato aaaa-mm-dd): ");
        String endDateString = input.nextLine();
        Date endDate = Date.valueOf(endDateString);
        
        RentalBean renovatedRental = new RentalBean(startDate, endDate, rental.getRentalId(), rental.getVehicleId(), seller.getSellerId(), client.getClientId());
        RentalModel.createRental(renovatedRental, con);
        System.out.println("Locação renovada com sucesso!");
    }
    
	public static void listRentalsBySearch(Connection con) throws SQLException {
		Scanner input = new Scanner(System.in);
		List<RentalBean> rentals = null;

		System.out.println("Digite o índice da característica do veículo a qual deseja utilizar na pesquisa:");
		System.out.println("1 - veículo, 2 - cliente, 3 - data");

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

		switch (index) {
			case 1:
				System.out.println("Selecione o veículo que deseja buscar o aluguel:");
				VehicleBean vehicle = Utils.selectVehicle(con);
				
				rentals = RentalModel.searchRentalByVehicle(vehicle, con);
				break;
			case 2:
		        System.out.println("Selecione o cliente que deseja buscar o aluguel");
		        ClientBean client = Utils.selectClient(con);
		        
		        rentals = RentalModel.searchRentalByClient(client, con);
				break;
			case 3:
				System.out.println("Digite a data inicial da busca (formato aaaa-mm-dd):");
		        String startDateString = input.nextLine();
		        Date startDate = Date.valueOf(startDateString);
		        
		        System.out.print("Digite a data final da busca (formato aaaa-mm-dd):");
		        String endDateString = input.nextLine();
		        Date endDate = Date.valueOf(endDateString);
		        
		        rentals = RentalModel.searchRentalByDatePeriod(startDate, endDate, con);
				break;
		}
		
		
		if(rentals == null || rentals.isEmpty()) {
			System.out.println("Nenhum aluguel encontrado");
			return;
		}
		
		for(RentalBean rental : rentals) {
			System.out.println(rental.toString());
		}
	}
	
	public static void countAssociatedRentals(Connection con) throws SQLException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Para realizar essa operação, é necessário buscar uma alocação");
		System.out.println("Você deseja realizar a busca dessa alocação de qual forma?");
		System.out.println("1 - por cliente /n2 - por período/n3 - por veículo");
		
		int index = -1;

		while (true) {
			try {
				index = input.nextInt();
				if (index >= 1 && index < 4) {
					break;
				} else {
					System.out.println("Índice fora do intervalo. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Digite um número inteiro.");
				input.next();
			}
		}
		
		List<RentalBean> rentals = null;
		
		switch(index) {
			case 1:
				ClientBean client = Utils.selectClient(con);
				rentals = RentalModel.searchRentalByClient(client, con);

				break;
			case 2:
		        System.out.print("Data de início (formato aaaa-mm-dd):");
		        String startDateString = input.nextLine();
		        Date startDate = Date.valueOf(startDateString);

		        System.out.print("Data de término (formato aaaa-mm-dd): ");
		        String endDateString = input.nextLine();
		        Date endDate = Date.valueOf(endDateString);

		        rentals = RentalModel.searchRentalByDatePeriod(startDate, endDate, con);
		        
		        break;
			case 3:
				VehicleBean vehicle = Utils.selectVehicle(con);
				
				rentals = RentalModel.searchRentalByVehicle(vehicle, con);
				
				break;
		}
		
		if(rentals == null || rentals.isEmpty()) {
			System.out.println("Não foi encontrado nenhuma alocação");
			return;
		}
		
		System.out.println("Selecione a alocação desejada");
		for(RentalBean rental : rentals) {
			System.out.println(rental.toString());
		}
		
		int rentalIndex = -1;

		while (true) {
			try {
				rentalIndex = input.nextInt();
				if (rentalIndex >= 1 && rentalIndex < rentals.size() + 1) {
					break;
				} else {
					System.out.println("Índice fora do intervalo. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Digite um número inteiro.");
				input.next();
			}
		}
		
		RentalBean rental = rentals.get(rentalIndex);
		int associatedRentalsAmount = RentalModel.countAssociatedRentals(rental, con);
		
		System.out.println("A quantidade de alocações/renovações associadas a essa alocação é de: " + associatedRentalsAmount);
	}
}
