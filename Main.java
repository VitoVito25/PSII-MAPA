import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Main para rodar o programa
 * 
 * 
 * @author Victor Renaud
 * @version 1.0
 */
public class Main {
   
    /**
     * Função para limpar o console
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Comando para limpar o console no Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comando para limpar o console no Unix/Linux/MacOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console.");
            e.printStackTrace();
        }
    }

        /**
     * Função main para rodar programa CRUD dos clientes
     * 
     * 
     * @author Victor Renaud
     * @version 1.0
     */
    public static void main(String[] args) {

        List<Cliente> listaClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);  // Inicia o Scanner para leitura do teclado
        int option = 0;

        do {

            do{
                clearConsole();
                // Menu inicial
                System.out.println("#---- Bem vindo ao sistema de armazenamento de clientes ----#");
                System.out.println("Digite uma das opções abaixo para acessar os menus:");
                System.out.println("1 - Cadastrar um novo cliente");
                System.out.println("2 - Listar clientes cadastrados");
                System.out.println("3 - Atualizar um cliente cadastrado");
                System.out.println("4 - Excluir um cliente cadastrado");
                System.out.println("5 - Busca de cliente por ID");
                System.out.println("9 - Sair");
                
                // Capturando entradas e tratando erros
                try {
                    System.out.println("Pressione a opção desejada");
                    option = scanner.nextInt();
                    scanner.nextLine();

                    if(option >= 5 && option >= 1 && option != 9) {
                        System.out.println("Você inseriu uma opção invalida, por favor verifique a opção.");
                        scanner.nextLine();
                        clearConsole();
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Você inseriu um caracter invalido, pressione um numero");
                    scanner.nextLine();
                    clearConsole();
                }

                switch (option) {
                    case 1:
                        clearConsole();
                        // Solicita os dados
                        System.out.println("#---- Cadastro de clientes ----#");
                        System.out.println("Insira o nome do Cliente: ");
                        String nome = scanner.nextLine();
                        System.out.println("Insira o email do Cliente: ");
                        String email = scanner.nextLine();
                        System.out.println("Insira o telefone do Cliente: ");
                        String telefone = scanner.nextLine();

                        // Puxa o Id mais alto cadastrado
                        int lastId = 0;
                        for (Cliente cliente : listaClientes) {
                            if (cliente.getId() > lastId) {
                                lastId = cliente.getId(); 
                            }
                        }
                        // Atribui um novo ID
                        int id = lastId + 1;

                        // Gera o novo cliente e coloca na lista
                        Cliente newCliente = new Cliente(id, nome, email, telefone);
                        listaClientes.add(newCliente);

                        System.out.printf("Cliente com o id %d inserido com sucesso!\n", id);
                        scanner.nextLine();
                        break;
                    
                    case 2:
                        clearConsole();
                        
                        // Verifica se a lista esta vazia
                        if (listaClientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            for (Cliente cliente : listaClientes) {
                                cliente.imprimirCliente();
                            }
                        }

                        System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
                        scanner.nextLine();
                        break;

                    case 3:
                        clearConsole();
                        boolean idEncontrado = false;
                        Cliente clienteEncontrado = null;
                        int idEditar = 0;
                        System.out.println("#---- Atualização de clientes ----#");
                        
                        // Verifica se a lista esta vazia
                        if (listaClientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                            System.out.println("#---- Pressione ENTER para voltar ao Menu ----#");
                            scanner.nextLine();
                        } else {
                            do{
                                try {
                                    // Solicita os dados
                                    System.out.println("Informe o ID do cliente que você deseja editar: ");
                                    idEditar =  scanner.nextInt();
                                    scanner.nextLine();
    
                                    // Verifica se o Id esta cadastrado
                                    for(Cliente cliente : listaClientes) {
                                        if(cliente.getId() == idEditar) {
                                            idEncontrado = true;
                                            clienteEncontrado = cliente;
                                        }
                                    }
    
                                    if(idEncontrado == false) {
                                        System.out.printf("Cliente com o Id %d nao encontrado. Insira um novo Id \n", idEditar);
                                    }
    
                                } catch (InputMismatchException e) {
                                    System.out.println("Caracter invalido, por favor clique ENTER e insira um numero");
                                    scanner.nextLine();
                                }
    
    
                            }while(idEncontrado == false);
    
                            clearConsole();
                            System.out.println("#---- Atualização de clientes ----#");
                            System.out.println("Cliente encontrado: ");
                            clienteEncontrado.imprimirCliente();
                            System.out.printf("Insira os novos dados para o cliente com Id %d ", idEditar);
                            
                            System.out.print("Digite o novo nome (ou deixe em branco para manter o atual): ");
                            String novoNome = scanner.nextLine();
                            if (!novoNome.isEmpty()) {
                                clienteEncontrado.setNome(novoNome);
                            }
    
                            System.out.print("Digite o novo email (ou deixe em branco para manter o atual): ");
                            String novoEmail = scanner.nextLine();
                            if (!novoEmail.isEmpty()) {
                                clienteEncontrado.setEmail(novoEmail);
                            }
    
                            System.out.print("Digite o novo telefone (ou deixe em branco para manter o atual): ");
                            String novoTelefone = scanner.nextLine();
                            if (!novoTelefone.isEmpty()) {
                                clienteEncontrado.setTelefone(novoTelefone);
                            }
    
    
                            System.out.println("Dados do cliente atualizados com sucesso!");
                            clienteEncontrado.imprimirCliente();
                            System.out.println("Pressione ENTER para continuar...");
                            scanner.nextLine();
    
                            break;
                        }


                    
                
                    default:
                        break;
                }

            }while(option >= 5 && option >= 1 && option != 9);
            
        }while(option != 9);
        
        scanner.close(); // Fecha o Scanner

    }


}
