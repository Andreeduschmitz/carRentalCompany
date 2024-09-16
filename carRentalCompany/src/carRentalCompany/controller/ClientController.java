package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import carRentalCompany.bean.ClientBean;
import carRentalCompany.model.ClientModel;

public class ClientController {
	
    public void createClient(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados abaixo para cadastrar um novo cliente:");
        
        System.out.print("Nome completo: ");
        String clientName = input.next();

        System.out.print("CPF: ");
        int clientCpf = input.nextInt();

        System.out.print("Telefone para contato: ");
        String clientPhone = input.next();

        System.out.print("E-mail: ");
        String clientEmail = input.next();

        ClientBean client = new ClientBean(clientName, clientCpf, clientPhone, clientEmail);
        ClientModel.create(client, con);
        System.out.println("Cliente criado com sucesso!");
    }

    public void updateClient(Connection con, ClientBean client) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n1 - Nome\n2 - Telefone\n3 - E-mail\n4 - Cancelar");

        int option = 0;

        switch (option) {
            case 1:
                System.out.print("Digite o nome completo atualizado: ");
                String name = input.next();
                client.setClientName(name);
                break;

            case 2:
                System.out.print("Digite o telefone atualizado: ");
                String phoneNumber = input.next();
                client.setClientPhone(phoneNumber);
                break;

            case 3:
                System.out.print("Digite o e-mail atualizado: ");
                String email = input.next();
                client.setClientEmail(email);
                break;
            
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        ClientModel.update(client, con);
        System.out.println("Informações atualizadas com sucesso!");
    }
}
