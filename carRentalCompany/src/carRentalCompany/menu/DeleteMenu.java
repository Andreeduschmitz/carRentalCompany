package carRentalCompany.menu;

import java.sql.Connection;
import java.sql.SQLException;

import carRentalCompany.controller.AddressController;
import carRentalCompany.controller.ClientController;
import carRentalCompany.controller.SellerController;
import carRentalCompany.controller.VehicleController;
import carRentalCompany.utils.Utils;

public class DeleteMenu {

    public static void deleteMenu(Connection con) throws SQLException {
    	int opcao;

    	do {
	        System.out.println("Qual tipo de exclusão você deseja realizar?");
	        System.out.println("1 - Cliente");
	        System.out.println("2 - Vendedor");
	        System.out.println("3 - Veículo");
	        System.out.println("4 - Endereço");
	        System.out.println("5 - Retornar ao menu principal");
	
	        opcao = Utils.indexSelector(1, 5);
	        
			switch (opcao) {
				case 1:
					ClientController.deleteClient(con);
					return;
				case 2:
					SellerController.deleteSeller(con);
					return;
				case 3:
					VehicleController.deleteVehicle(con);
					return;
				case 4:
					AddressController.deleteAddress(con);
					return;
				case 5:
					return;
				default:
					System.out.println("Opção inválida");
					break;
			}

    	} while (opcao != 5);
    }
}
