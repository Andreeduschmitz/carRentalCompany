package carRentalCompany.menu;

import java.sql.Connection;

import carRentalCompany.utils.Utils;

public class ListMenu {

    private static void listMenu(Connection con) {
        System.out.println("Qual tipo de listagem você deseja realizar?");
        System.out.println("1 - Clientes");
        System.out.println("2 - Vendedor");
        System.out.println("3 - Veículo");
        System.out.println("4 - Endereço");
        System.out.println("5 - Locação");

        int opcao = Utils.indexSelector(1, 5);
    }
}
