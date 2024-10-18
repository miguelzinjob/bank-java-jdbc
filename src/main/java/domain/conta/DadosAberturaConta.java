package domain.conta;

import domain.cliente.DadosCadastroCliente;

public class DadosAberturaConta {
    public Integer numero;
    public DadosCadastroCliente dadosCliente;

    public DadosAberturaConta(Integer numero, DadosCadastroCliente dadosCliente){
        this.numero = numero;
        this.dadosCliente = dadosCliente;
    }

}