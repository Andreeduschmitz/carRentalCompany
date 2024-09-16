package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import carRentalCompany.bean.RentalBean;
import carRentalCompany.bean.SellerBean;
import carRentalCompany.bean.VehicleBean;
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

        RentalBean rental = new RentalBean(startDate, endDate, null, vehicle.getVehicleId(), seller.getSellerId());
        RentalModel.createRental(rental, con);
        System.out.println("Locação criada com sucesso!");
    }
}
