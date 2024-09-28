package carRentalCompany.menu;

import java.sql.Connection;

import carRentalCompany.utils.Utils;

public class DeleteMenu {

    public static void deleteMenu(Connection con) {
        System.out.println("Qual tipo de exclusão você deseja realizar?");
        System.out.println("1 - Cliente");
        System.out.println("2 - Vendedor");
        System.out.println("3 - Veículo");
        System.out.println("4 - Endereço");

        int opcao = Utils.indexSelector(1, 4);
    }
}
