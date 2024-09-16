package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import carRentalCompany.bean.SellerBean;
import carRentalCompany.model.SellerModel;

public class SellerController {
    
	public void createSeller(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados abaixo para cadastrar um novo vendedor:");
        
        System.out.print("Nome completo: ");
        String sellerName = input.next();

        System.out.print("Telefone para contato: ");
        String sellerPhone = input.next();

        System.out.print("E-mail: ");
        String sellerEmail = input.next();

        SellerBean seller = new SellerBean(sellerName, sellerPhone, sellerEmail);
        SellerModel.create(seller, con);
        System.out.println("Vendedor criado com sucesso!");
    }
	
    public void updateSeller(Connection con, SellerBean seller) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n1 - Nome\n2 - Telefone\n3 - E-mail\n4 - Cancelar");

        int option = input.nextInt();

        switch (option) {
            case 1:
                System.out.print("Digite o nome completo atualizado: ");
                String name = input.next();
                seller.setSellerName(name);
                break;

            case 2:
                System.out.print("Digite o telefone atualizado: ");
                String phoneNumber = input.next();
                seller.setSellerPhone(phoneNumber);;
                break;

            case 3:
                System.out.print("Digite o e-mail atualizado: ");
                String email = input.next();
                seller.setSellerEmail(email);
                break;
            
            default:
            	System.out.println("Opção inválida!");
            	return;
        }
        
        SellerModel.update(seller, con);
        System.out.println("Informações atualizadas com sucesso!");
    }
}
