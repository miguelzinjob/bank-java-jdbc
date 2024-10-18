package domain.cliente;

public class DadosCadastroCliente {
    String nome;
    String cpf;
    String email;

    public DadosCadastroCliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}