package carRentalCompany.menu;

import java.sql.Connection;

import carRentalCompany.utils.Utils;

public class ReportMenu {

    private static void reportMenu(Connection con) {
        System.out.println("Qual relatório você deseja gerar?");
        System.out.println("1 - Listar o valor total gerado por um veículo em um período de tempo");
        System.out.println("2 - Listar todas as locações de um vendedor em um período");
        System.out.println("3 - Listar todas as renovações de uma alocação");

        int opcao = Utils.indexSelector(1, 3);
    }
}
