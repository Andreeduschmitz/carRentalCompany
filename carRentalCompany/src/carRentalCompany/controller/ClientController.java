package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import carRentalCompany.bean.ClientBean;
import carRentalCompany.model.ClientModel;
import carRentalCompany.utils.Utils;

public class ClientController {
	
    public static void createClient(Connection con) throws SQLException {
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
        
        client = ClientModel.search(clientCpf, null, con).get(0);
        
        System.out.println("Deseja inserir um endereço para esse cliente? S/N");
        String option = input.next();
        
        if(option == "S" || option == "s") {
        	AddressController.createAddress(con, client);
        }
    }

    public static void updateClient(Connection con) throws SQLException {
    	ClientBean client = Utils.selectClient(con);
        Scanner input = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n1 - Nome\n2 - Telefone\n3 - E-mail\n4 - Cancelar");

        int option;
        
		do {
			option = input.nextInt();

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
				case 4:
					break;
	
				default:
					System.out.println("Opção inválida!");
					return;
			}

		} while (option < 1 || option > 4);
        
        ClientModel.update(client, con);
        System.out.println("Informações atualizadas com sucesso!");
    }
    
    public static void deleteClient(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Digite o cpf do cliente que deseja excluir");
    	int cpf = input.nextInt();
    	
    	ClientBean client = Utils.selectClientBySearch(con, cpf, null);
    	
    	System.out.println("Tem certeza que deseja excluir o cliente " + client.getClientName() + "? S/N");
    	String option = input.next();
    	
    	if(option == "S" || option == "s") {
    		ClientModel.delete(client, con);
    		
    		System.out.println("Cliente excluído com sucesso!");
    	}
    	
    }
    
    public static void listAllClients(Connection con) throws SQLException {
    	ArrayList<ClientBean> clients = ClientModel.listAll(con);
    	
    	if(clients == null || clients.isEmpty()) {
    		System.out.println("Não há nenhum cliente cadastrado");
    		return;
    	}

    	for(ClientBean client : clients) {
    		System.out.println(client.toString());
    	}
    }
    
    public static void listClientsBySeach(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Qual a característica do cliente você deseja utilizar na busca?\n 0 - cpf\n 1 - nome");
		int index = -1;

		while (true) {
			try {
				index = input.nextInt();
				if (index >= 0 && index < 1) {
					break;
				} else {
					System.out.println("Índice fora do intervalo. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Digite um número inteiro.");
				input.next();
			}
		}
		
		int cpf = 0;
		String name = null;
		
		if(index == 0) {
			System.out.println("Digite o cpf que deseja pesquisar:");
			cpf = input.nextInt();
		} else {
			System.out.println("Digite o nome que deseja pesquisar");
			name = input.next();
		}
		
		ClientController.listClientsBySeach(con, cpf, name);
    }
    
    public static void listClientsBySeach(Connection con, int cpf, String name) throws SQLException {
    	ArrayList<ClientBean> clients = ClientModel.search(cpf, name, con);

    	if(clients == null || clients.isEmpty()) {
    		System.out.println("Não há nenhum cliente cadastrado");
    		return;
    	}

    	for(ClientBean client : clients) {
    		System.out.println(client.toString());
    	}
    }
}