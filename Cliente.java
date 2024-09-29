/**
 *  Classe para armazenar clientes
 * 
 * @author Victor Renaud
 * @version 1.00
 */


public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;

    // Construtor
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getter e Setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter e Setter para telefone
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void excluirCliente() {
        int idClienteExcluido = this.id;
        this.id = 0;
        this.nome = null;
        this.email = null;
        this.telefone = null;
        System.out.println("Cliente com id " + idClienteExcluido + " excluídos com sucesso.");
    }
}