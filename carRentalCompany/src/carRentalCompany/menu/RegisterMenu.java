package carRentalCompany.menu;

import java.sql.Connection;

import carRentalCompany.utils.Utils;

public class RegisterMenu {

	public static void registerMenu(Connection con) {
        System.out.println("Qual tipo de cadastro você deseja realizar?");
        System.out.println("1 - Cliente");
        System.out.println("2 - Vendedor");
        System.out.println("3 - Veículo");
        System.out.println("4 - Locação");
        System.out.println("5 - Endereço");
		
		int opcao = Utils.indexSelector(1, 5);
	}
}
