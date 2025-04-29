package aplicativo;

import java.time.LocalDate;
import Controller.PetShop;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PetShop petShop = new PetShop();

        while (true) {
        	System.out.println("\n--- Menu Pet Shop ---");
        	System.out.println("1. Cadastrar cliente");
        	System.out.println("2. Listar clientes");
        	System.out.println("3. Buscar cliente");
        	System.out.println("4. Remover cliente");
        	System.out.println("5. Adicionar pet a cliente");
        	System.out.println("6. Listar pets de um cliente");
        	System.out.println("7. Remover pet de um cliente");
        	System.out.println("8. Agendar serviço para pet");
        	System.out.println("9. Listar serviços agendados de um pet");
        	System.out.println("10. Editar serviço agendado de um pet");
        	System.out.println("0. Sair");
        	System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();
                    Cliente cliente = new Cliente(nome, telefone, email);
                    petShop.adicionarCliente(cliente);
                    System.out.println("Cliente cadastrado.");
                }
                case 2 -> petShop.listarClientes();
                case 3 -> {
                    System.out.print("Nome do cliente: ");
                    String busca = sc.nextLine();
                    Cliente encontrado = petShop.buscarClientePorNome(busca);
                    if (encontrado != null) {
                        encontrado.exibirInformacoes();
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 4 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    if (petShop.removerCliente(nome)) {
                        System.out.println("Cliente removido.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 5 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = petShop.buscarClientePorNome(nome);
                    if (cliente != null) {
                        System.out.print("Nome do pet: ");
                        String nomePet = sc.nextLine();
                        System.out.print("Espécie: ");
                        String especie = sc.nextLine();
                        System.out.print("Raça: ");
                        String raca = sc.nextLine();
                        System.out.print("Idade: ");
                        int idade = sc.nextInt();
                        System.out.print("Peso: ");
                        double peso = sc.nextDouble();
                        sc.nextLine();
                        Pet pet = new Pet(nomePet, especie, raca, idade, peso);
                        cliente.adicionarPet(pet);
                        System.out.println("Pet cadastrado.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 6 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = petShop.buscarClientePorNome(nome);
                    if (cliente != null) {
                        for (Pet p : cliente.getPets()) {
                            p.exibirInformacoes();
                            System.out.println();
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 7 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = petShop.buscarClientePorNome(nome);
                    if (cliente != null) {
                        System.out.print("Nome do pet a remover: ");
                        String nomePet = sc.nextLine();
                        Pet pet = cliente.buscarPetPorNome(nomePet);
                        if (pet != null && cliente.removerPet(pet)) {
                            System.out.println("Pet removido.");
                        } else {
                            System.out.println("Pet não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                case 8 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = petShop.buscarClientePorNome(nome);
                    if (cliente != null) {
                        System.out.print("Nome do pet: ");
                        String nomePet = sc.nextLine();
                        Pet pet = cliente.buscarPetPorNome(nomePet);
                        if (pet != null) {
                            System.out.println("Tipo de serviço:");
                            System.out.println("1 - Banho e Tosa");
                            System.out.println("2 - Consulta Veterinária");
                            System.out.println("3 - Hospedagem");
                            System.out.println("4 - Adestramento");
                            System.out.print("Escolha: ");
                            int tipo = sc.nextInt();
                            System.out.print("Preço: ");
                            double preco = sc.nextDouble();
                            sc.nextLine(); // limpar buffer
                            System.out.print("Data do serviço (AAAA-MM-DD): ");
                            String dataStr = sc.nextLine();
                            Servico servico = switch (tipo) {
                                case 1 -> new BanhoETosa(preco);
                                case 2 -> new ConsultaVeterinaria(preco);
                                case 3 -> new Hospedagem(preco);
                                case 4 -> new Adestramento(preco);
                                default -> null;
                            };
                            if (servico != null) {
                                LocalDate data = LocalDate.parse(dataStr);
                                ServicoAgendado agendado = new ServicoAgendado(servico, data);
                                pet.adicionarServicoAgendado(agendado);
                                System.out.println("Serviço agendado com sucesso.");
                            } else {
                                System.out.println("Serviço inválido.");
                            }
                        } else {
                            System.out.println("Pet não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                
                case 9 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = petShop.buscarClientePorNome(nome);
                    if (cliente != null) {
                        System.out.print("Nome do pet: ");
                        String nomePet = sc.nextLine();
                        Pet pet = cliente.buscarPetPorNome(nomePet);
                        if (pet != null) {
                            pet.listarServicosAgendados();
                        } else {
                            System.out.println("Pet não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
                
                case 10 -> {
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = petShop.buscarClientePorNome(nome);
                    if (cliente != null) {
                        System.out.print("Nome do pet: ");
                        String nomePet = sc.nextLine();
                        Pet pet = cliente.buscarPetPorNome(nomePet);
                        if (pet != null) {
                            System.out.print("Tipo do serviço a editar: ");
                            String tipo = sc.nextLine();
                            ServicoAgendado sa = pet.buscarServicoAgendadoPorTipo(tipo);
                            if (sa != null) {
                                System.out.print("Novo preço: ");
                                double novoPreco = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Nova data (AAAA-MM-DD): ");
                                String novaData = sc.nextLine();
                                sa.getServico().setPreco(novoPreco);
                                sa.setDataAgendada(LocalDate.parse(novaData));
                                System.out.println("Serviço atualizado.");
                            } else {
                                System.out.println("Serviço não encontrado.");
                            }
                        } else {
                            System.out.println("Pet não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }



                case 0 -> {
                    System.out.println("Sistema encerrado.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
