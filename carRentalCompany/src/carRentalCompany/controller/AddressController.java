package carRentalCompany.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import carRentalCompany.bean.AddressBean;
import carRentalCompany.bean.ClientBean;
import carRentalCompany.model.AdressModel;

public class AddressController {
	
    public void createAddress(Connection con, ClientBean client) throws SQLException {
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
        if (option == "S" || option == "s") {
            System.out.print("Informe o complemento: ");
            addressComplement = input.next();
        }

        AddressBean address = new AddressBean(addressCep, addressStreet, addressNeighborhood, addressNumber, addressComplement, client.getClientId());
        AdressModel.create(address, con);
        System.out.println("Endereço criado com sucesso!");
    }

    public void updateAddress(Connection con, AddressBean address) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n1 - CEP\n2 - Rua\n3 - Bairro\n4 - Número\n5 - Complemento\n6 - Cancelar");

        int option = 0;

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
            
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        AdressModel.update(address, con);
        System.out.println("Informações atualizadas com sucesso!");
    }
}
