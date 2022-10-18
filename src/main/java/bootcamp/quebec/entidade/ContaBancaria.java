package bootcamp.quebec.entidade;

import lombok.Data;

import java.util.*;

@Data
public class ContaBancaria implements IConta {

    protected static final int AGENCIA_PADRAO = 3001;
    private static Random RANDOM = new Random();
    protected int agencia;
    protected long numero;
    protected double saldo;

    Scanner entrada = new Scanner(System.in);

    public ContaBancaria() {
        this.agencia = ContaBancaria.AGENCIA_PADRAO;
        this.numero = RANDOM.nextInt(100000);
    }


    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Long contaDestino, double valor) {
        this.sacar(valor);
        imprimirSaldo();
    }
    public void imprimirSaldo() {
        System.out.println("             SALDO                            ");
        System.out.println("------------------------------------------------");
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("------------------------------------------------");
    }

    public void infoConta(long numeroConta,  Map<Long, Double> saldoConta) {
        saldoConta.forEach((conta, saldo) ->{
            if(conta.equals(numeroConta)){
               this.numero = conta;
               this.saldo = saldo;
            }

            if(conta.equals(numeroConta)){
                this.numero = conta;
                this.saldo = saldo;
            }
        });
    }


    public int tipoConta(){
        System.out.println("             TIPOS DE CONTA                     ");
        System.out.println("------------------------------------------------");
        System.out.println("1 - CORRENTE");
        System.out.println("2 - POUPANCA");

        System.out.println("Escolha tipo da conta: ");
        return entrada.nextInt();
    }

    public Cliente novoCliente(){
        Cliente cli = new Cliente();
        ContaCorrente contaCorrente = new ContaCorrente();
        ContaPoupanca contaPoupanca = new ContaPoupanca();

        System.out.println("Nome do Cliente: ");
        cli.setNomeCliente(entrada.next() + " " + entrada.next());
        cli.setContaCorrente(contaCorrente.getNumero());
        cli.setContaPoupanca(contaPoupanca.getNumero());
        return cli;
    }

    public String nomeClientePesquisa(){
        System.out.println("Nome do Cliente: ");
        return entrada.next() + " " + entrada.next();
    }

    public void primeiroDeposito(long numeroConta, double valorInicial){
        this.numero = numeroConta;
        this.saldo = valorInicial;
    }

    public void saldoBancario(Cliente cliente,  Map<Long, Double> saldoConta){
        int tipoConta = tipoConta();
        if(tipoConta == 1) {
            infoConta(cliente.getContaCorrente(), saldoConta);
        }else if (tipoConta == 2) {
            infoConta(cliente.getContaPoupanca(), saldoConta);
        }else
            System.out.println("Tipo de conta invalida");

        imprimirSaldo();
    }

    public void saqueBancario(Cliente cliente,  Map<Long, Double> saldoConta){
        System.out.println("Informe o valor do saque: ");
        Double valorSaque = entrada.nextDouble();

        int tipoConta = tipoConta();
        if(tipoConta == 1) {
            infoConta(cliente.getContaCorrente(), saldoConta);
        }else if (tipoConta == 2) {
            infoConta(cliente.getContaPoupanca(), saldoConta);
        }else
            System.out.println("Tipo de conta invalida");

        if(valorSaque < this.saldo) {
            sacar(valorSaque);
        }else{
            System.out.println("Conta bancaria nao possui saldo suficiente!!");
        }
        imprimirSaldo();
    }

    public void depositoBancario(Cliente cliente,  Map<Long, Double> saldoConta){
        System.out.println("Informe o valor do deposito: ");
        Double valorDeposito = entrada.nextDouble();

        int tipoConta = tipoConta();
        if(tipoConta == 1) {
            infoConta(cliente.getContaCorrente(), saldoConta);
        }else if (tipoConta == 2) {
            infoConta(cliente.getContaPoupanca(), saldoConta);
        }else
            System.out.println("Tipo de conta invalida");

        depositar(valorDeposito);
        imprimirSaldo();
    }

    public void transferenciaBancario(Cliente cliente,  Map<Long, Double> saldoConta){
        System.out.println("Informe o valor da transferencia: ");
        Double valorTransferencia = entrada.nextDouble();

        int tipoConta = tipoConta();
        if(tipoConta == 1) {
            infoConta(cliente.getContaCorrente(), saldoConta);
        }else if (tipoConta == 2) {
            infoConta(cliente.getContaPoupanca(), saldoConta);
        }else
            System.out.println("Tipo de conta invalida");

        Long contaDestino = null;
        if(valorTransferencia < this.saldo) {
            System.out.println("Informe o numero da conta de destino: ");
            contaDestino = entrada.nextLong();
        }else{
            System.out.println("Conta bancaria nao possui saldo suficiente!!");
        }

        transferir(contaDestino, valorTransferencia);
    }
}
