package controller;

import domain.cliente.DadosCadastroCliente;
import domain.conta.DadosAberturaConta;
import exeptions.RegraDeNegocioException;
import service.ContaService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class BankJavaController {
    ContaService service;
    Scanner teclado;
    public BankJavaController(){
        this.service = new ContaService();
        this.teclado = new Scanner(System.in) .useDelimiter("\n");
    }

    public static void main(String[] args) throws SQLException {
        BankJavaController controller = new BankJavaController();
        controller.start();
    }
    public void start() throws SQLException {
        Scanner teclado = new Scanner(System.in) .useDelimiter("\n");

        int opcao = exibirMenu();
        while (opcao != 8) {
            try {
                switch (opcao) {
                    case 1:
                        listarContas();
                        break;
                    case 2:
                        abrirConta();
                        break;
                    case 3:
                        encerrarConta();
                        break;
                    case 4:
                        consultarSaldo();
                        break;
                    case 5:
                        realizarSaque();
                        break;
                    case 6:
                        realizarDeposito();
                        break;
                    case 7:
                        realizarTransferencia();
                        break;

                }
            } catch (RegraDeNegocioException e) {
                System.out.println("Erro" + e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                teclado.next();
            }
            opcao = exibirMenu();
        }
        System.out.println("Finalizando a aplicação");
    }
    private int exibirMenu(){
        System.out.println("""
                BYTEBANK - ESCOLHA UMA OPÇÃO:
                1-Listar contas abertas
                2-Abertura de conta
                3-Encerramento de conta
                4-Consultar saldo de uma conta
                5-Realizar saque em uma conta
                6-Realizar depósito em uma conta
                7-Realizar uma tranferência
                8-Sair
                """);
        return teclado.nextInt();
    }
    private void listarContas(){
        System.out.println("Contas Cadastradas: ");
        var contas = service.listarContasAbertas();
        contas.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private void abrirConta () throws SQLException {
        System.out.println("Digite o número da conta: ");
        var numeroDaConta = teclado.nextInt();

        System.out.println("Digite o nome do cliente: ");
        var nome = teclado.next();

        System.out.println("Digite o cpf do cliente: ");
        var cpf = teclado.next();

        System.out.println("Digite o email do cliente: ");
        var email = teclado.next();

        service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));

        System.out.println("Conta aberta com sucesso!");
        System.out.println("Pressione gualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    private void encerrarConta () {
        System.out.println("Digite o númeco da conta: ");
        var numeroDaconta = teclado.nextInt();

        service.encerrar(numeroDaconta);

        System.out.println("Conta encerrada com sucesso!");
        System.out.println("Pressione gualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();

    }

    public void consultarSaldo(){
        System.out.println("Digite o número da conta: ");
        var numeroDaConta = teclado.nextInt();
        var saldo = service.consultarSaldo(numeroDaConta);
        System.out.println("Saldo da conta: " +saldo);

        System.out.println("Pressione gualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    public void realizarSaque(){
        System.out.println("Digite o número da conta: ");
        var numeroDaConta = teclado.nextInt();

        System.out.println("Digite o valor do saque: ");
        var valor = teclado.nextBigDecimal();

        service.realizarSaque(numeroDaConta, valor);
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Pressione gualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    public void realizarDeposito(){
        System.out.println("Digite o número da conta: ");
        var numeroDaConta = teclado.nextInt();

        System.out.println("Digite o valor do deposito: ");
        var valor = teclado.nextBigDecimal();

        service.realizarDeposito(numeroDaConta, valor);

        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Pressione gualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }

    public void realizarTransferencia(){
        System.out.println();

        System.out.println();

        System.out.println();
        BigDecimal valor = teclado.nextBigDecimal();

        //this.service.realizaTransferencia(numeroContaOrigem, numeroContaDestino, valor);
        System.out.println("Tranferência realizado com sucesso!");
        System.out.println("Pressione gualquer tecla e de ENTER para voltar ao menu principal");
        teclado.next();
    }
}