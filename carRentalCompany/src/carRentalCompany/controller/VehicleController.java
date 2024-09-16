package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import carRentalCompany.bean.VehicleBean;
import carRentalCompany.enums.VehicleCategory;
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
	

    public void updateVehicle(Connection con, VehicleBean vehicle) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n1 - Placa\n2 - Valor da diária\n3 - Cancelar");

        int option = 0;

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
            
            default:
            	System.out.println("Opção inválida!");
            	return;
        }
        
        VehicleModel.update(vehicle, con);
        System.out.println("Informações atualizadas com sucesso!");
    }
}
