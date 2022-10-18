package bootcamp.quebec;

import bootcamp.quebec.entidade.*;
import lombok.Data;

import java.util.*;

public class loadBank{
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        ContaBancaria contaBancaria = new ContaBancaria();
        Banco banco = new Banco();

        Map<Long, Double> saldoConta = new HashMap<>();
        Map<Long, Cliente> listCliente = new HashMap<>();

        int tipoConta;

        String nomeBanco = banco.nomeBanco();
        Scanner entrada = new Scanner(System.in);
        int controle = 1;

        banco.benvindo();

        System.out.println("Escolha uma opcao: ");
        int opcao = entrada.nextInt();
        controle = opcao;
        while (controle != 0){
            switch (opcao){
                case 1:
                    String nomeCliente = contaBancaria.nomeClientePesquisa();

                    if(!listCliente.isEmpty() && banco.isCliente(listCliente, nomeCliente)){
                        cliente = banco.getClienteReturn();
                        int operacao = banco.operacao();

                        if(operacao == 1){
                            contaBancaria.saldoBancario(cliente, saldoConta);
                        }
                        if(operacao == 2){
                            contaBancaria.saqueBancario(cliente, saldoConta);
                        }
                        if(operacao == 3){
                           contaBancaria.depositoBancario(cliente, saldoConta);
                        }
                        if(operacao == 4){
                           contaBancaria.transferenciaBancario(cliente, saldoConta);
                        }
                    }
                    break;

                case 2:
                    Double valorInicial = 0d;
                    cliente = contaBancaria.novoCliente();
                    listCliente.put(cliente.getContaCorrente(), cliente);

                    System.out.println("Valor inicial: ");
                    valorInicial = entrada.nextDouble();

                    tipoConta = contaBancaria.tipoConta();

                    banco.imprimirDadosBancario(cliente);

                    if(tipoConta == 1) {
                        contaCorrente.primeiroDeposito(cliente.getContaCorrente(), valorInicial);
                        contaCorrente.imprimirSaldo();
                        saldoConta.put(cliente.getContaCorrente(), valorInicial);
                    }else if (tipoConta == 2) {
                        contaPoupanca.primeiroDeposito(cliente.getContaCorrente(), valorInicial);
                        contaPoupanca.imprimirSaldo();
                        saldoConta.put(cliente.getContaPoupanca(), valorInicial);
                    }else
                        System.out.println("Tipo de conta invalida");

                    cliente = new Cliente();
                    contaCorrente = new ContaCorrente();
                    contaPoupanca = new ContaPoupanca();

                    break;

                case 3:
                    if (!listCliente.isEmpty())
                        banco.listaClientes(listCliente);
                    else
                        System.out.println("Banco nao possui nenhum clinte\n\n\n");
                    break;
                default:
                    System.out.println("Opcao invalida!\n" + "Digite um numero de 1 a 3");
            }

            System.out.println("Digite 0 para sair do sistema e 1 para continuar...");
            if(entrada.nextInt() == 0)
                controle = 0;
            else {
                banco.benvindo();
                System.out.println("Escolha uma opcao: ");
                opcao = entrada.nextInt();
                controle = opcao;
            }
        }
    }
}
