package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import carRentalCompany.bean.AddressBean;
import carRentalCompany.bean.ClientBean;
import carRentalCompany.model.AddressModel;
import carRentalCompany.utils.Utils;

public class AddressController {
	
	public static void createAddress(Connection con) throws SQLException {
		ClientBean client = Utils.selectClient(con);
		AddressController.createAddress(con, client);
	}
	
    public static void createAddress(Connection con, ClientBean client) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os dados abaixo para cadastrar um novo endereço:");
        
        System.out.print("CEP: ");
        int addressCep = input.nextInt();

        System.out.print("Rua: ");
        String addressStreet = input.next();

        System.out.print("Bairro: ");
        String addressNeighborhood = input.next();

        System.out.print("Número: ");
        int addressNumber = input.nextInt();

        System.out.println("Deseja informar complemento? S/N");
        String option = input.next();

        String addressComplement = null;
        if (option.equals("S") || option.equals("s")) {
            System.out.print("Informe o complemento: ");
            addressComplement = input.next();
        }

        AddressBean address = new AddressBean(addressCep, addressStreet, addressNeighborhood, addressNumber, addressComplement, client.getClientId());
        AddressModel.create(address, con);
        System.out.println("Endereço criado com sucesso!");
    }

    public static void updateAddress(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
    	ClientBean client = Utils.selectClient(con);
    	List<AddressBean> addresses = AddressModel.findAddressByClient(client, con);
    	
    	if(addresses == null || addresses.isEmpty()) {
    		System.out.println("Esse cliente não possui nenhum endereço registrado");
    		return;
    	}
    	
    	System.out.println("Selecione do endereço que deseja atualizar");
    	
    	for(AddressBean address : addresses) {
    		System.out.println(address.toString());
    	}
    	
		int index = -1;

		while (true) {
			try {
				index = input.nextInt();
				if (index >= 0 && index < addresses.size()) {
					break;
				} else {
					System.out.println("Índice fora do intervalo. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida. Digite um número inteiro.");
				input.next();
			}
		}
		
		AddressBean address = addresses.get(index);
    	
        System.out.println("O que você deseja atualizar?\n1 - CEP\n2 - Rua\n3 - Bairro\n4 - Número\n5 - Complemento\n6 - Cancelar");

        int option;
        
        do {
        	option = input.nextInt();
        	
            switch (option) {
	            case 1:
	                System.out.print("Digite o novo CEP: ");
	                int cep = input.nextInt();
	                address.setAddressCep(cep);
	                break;
	
	            case 2:
	                System.out.print("Digite o nome da rua atualizado: ");
	                String streetName = input.next();
	                address.setAddressStreet(streetName);
	                break;
	
	            case 3:
	                System.out.print("Digite o nome do bairro atualizado: ");
	                String neighborhoodName = input.next();
	                address.setAddressNeighborhood(neighborhoodName);
	                break;
	
	            case 4:
	                System.out.print("Digite o número da residência atualizado: ");
	                int number = input.nextInt();
	                address.setAddressNumber(number);
	                break;
	
	            case 5:
	                System.out.print("Digite o complemento atualizado: ");
	                String complement = input.next();
	                address.setAddressComplement(complement);
	                break;
	                
	            case 6:
	            	break;
	            
	            default:
	                System.out.println("Opção inválida!");
	                return;
            }
        	
		} while (option < 1 || option > 6);
        
        AddressModel.update(address, con);
        System.out.println("Informações atualizadas com sucesso!");
    }
    
    public static void deleteAddress(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Digite o cpf do cliente que deseja listar os endereços");
    	int cpf = input.nextInt();
    	
    	ClientBean client = Utils.selectClientBySearch(con, cpf, null);
    	ArrayList<AddressBean> addresses = AddressModel.findAddressByClient(client, con);

    	for(AddressBean address : addresses) {
    		address.toString();
    	}
    	
        int index = -1;

        while (true) {
            try {
                System.out.print("Digite o índice do endereço que deseja excluir: ");
                index = input.nextInt();
                if (index >= 0 && index < addresses.size()) {
                    break;
                } else {
                    System.out.println("Índice fora do intervalo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
                input.next();
            }
        }
    	
        AddressModel.delete(addresses.get(index), con);
        System.out.println("Endereço excluído com sucesso!");
    }
    
    public static void listAddressesByClient(Connection con) throws SQLException {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Digite o cpf do cliente que deseja listar os endereços");
    	int cpf = input.nextInt();
    	
    	ClientBean client = Utils.selectClientBySearch(con, cpf, null);
    	ArrayList<AddressBean> addresses = AddressModel.findAddressByClient(client, con);
    	
    	if(addresses == null || addresses.isEmpty()) {
    		System.out.println("Este cliente não possui nenhum endereço cadastrado");
    		return;
    	}

    	for(AddressBean address : addresses) {
    		address.toString();
    	}
    }
}