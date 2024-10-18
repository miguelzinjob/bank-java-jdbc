package domain.cliente;

import java.util.Objects;

public class Cliente {
    String nome, cpf, email;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome;
        this.cpf = dados.cpf;
        this.email = dados.email;
    }

    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\''+
                ", cpf='" + cpf +  "\'" +
                ", email='" + email + '\'' +
                '}';
    }

}