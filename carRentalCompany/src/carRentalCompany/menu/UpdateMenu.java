package carRentalCompany.menu;

import java.sql.Connection;

import carRentalCompany.utils.Utils;

public class UpdateMenu {

    public static void alterMenu(Connection con) {
        System.out.println("Qual tipo de alteração você deseja realizar?");
        System.out.println("1 - Cliente");
        System.out.println("2 - Vendedor");
        System.out.println("3 - Endereço");
        System.out.println("4 - Veículo");

        int opcao = Utils.indexSelector(1, 4);
    }
}
