package carRentalCompany.menu;

import java.sql.Connection;
import java.sql.SQLException;

import carRentalCompany.utils.Utils;

public class MainMenu {

	public static void mainMenu(Connection con) throws SQLException {
		int opcao;
		System.out.println("Bem vindo à D&N Car - Locações!!!");

		do {
			System.out.println("Digite o serviço que deseja utilizar:");
	        System.out.println("1 - Menu de cadastros");
	        System.out.println("2 - Menu de alterações");
	        System.out.println("3 - Menu de exclusão");
	        System.out.println("4 - Menu de listagens");
	        System.out.println("5 - Menu de relatórios");
	        System.out.println("6 - Sair");
			
			opcao = Utils.indexSelector(1, 6);
			
			switch (opcao) {
				case 1:
					RegisterMenu.registerMenu(con);
					break;
				case 2:
					UpdateMenu.updateMenu(con);
					break;
				case 3:
					DeleteMenu.deleteMenu(con);
					break;
				case 4:
					ListMenu.listMenu(con);
					break;
				case 5:
					ReportMenu.reportMenu(con);
					break;
				case 6:
					return;
				default:
					System.out.println("Opção inválida");
					break;
			}
		
		} while(opcao != 6);
	}
}
