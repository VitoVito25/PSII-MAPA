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

        List<Integer> listaIdClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);  // Inicia o Scanner para leitura do teclado
        int option = 0;

        do {

            do{
                System.out.println("#---- Bem vindo ao sistema de armazenamento de clientes ----#");
                System.out.println("Digite uma das opções abaixo para acessar os menus:");
                System.out.println("1 - Cadastrar um novo cliente");
                System.out.println("2 - Listar clientes cadastrados");
                System.out.println("3 - Atualizar um cliente cadastrado");
                System.out.println("4 - Excluir um cliente cadastrado");
                System.out.println("5 - Busca de cliente por ID");
                System.out.println("9 - Sair");

                try {
                    System.out.println("Pressione a opção desejada");
                    option = scanner.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("Você inseriu um caracter invalido, pressione um numero");
                    scanner.nextLine();
                    clearConsole();
                }

                if(option >= 5 && option >= 1 && option != 9) {
                    System.out.println("Você inseriu uma opção invalida, por favor verifique a opção.");
                    scanner.nextLine();
                    clearConsole();
                }
            }while(option >= 5 && option >= 1 && option != 9);
            


        }while(option != 9);
        


    }


}
