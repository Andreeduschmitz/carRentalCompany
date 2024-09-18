package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;

import carRentalCompany.bean.ClientBean;
import carRentalCompany.bean.RentalBean;
import carRentalCompany.bean.SellerBean;
import carRentalCompany.bean.VehicleBean;
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
    	
        System.out.print("Data de início (formato aaaa-mm-dd):");
        String startDateString = input.nextLine();
        Date startDate = Date.valueOf(startDateString);

        System.out.print("Data de término (formato aaaa-mm-dd): ");
        String endDateString = input.nextLine();
        Date endDate = Date.valueOf(endDateString);
        
        RentalBean renovatedRental = new RentalBean(startDate, endDate, null, rental.getVehicleId(), rental.getSellerId(), client.getClientId());
        RentalModel.createRental(renovatedRental, con);
        System.out.println("Locação renovada com sucesso!");
    }
}
