package bootcamp.quebec.entidade;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

@Data
public class Banco {
    protected final String NOME_BANCO = "DIGITAL-X";
    private Cliente clienteReturn;

    public String nomeBanco(){
        return NOME_BANCO.toString();
    }
    public void benvindo(){
        System.out.println("\nBENVINDO AO BANCO "+ NOME_BANCO);
        System.out.println("1 - ACESSAR CONTA");
        System.out.println("2 - ABRIR CONTA");
        System.out.println("3 - LISTA DE CLIENTES");

    }

    public void listaClientes(Map<Long, Cliente> listClient){
        System.out.println("             CLIENTES DO BANCO                  ");
        System.out.println("------------------------------------------------");
        for (Map.Entry<Long, Cliente> entry: listClient.entrySet()) {
            System.out.println("Nome: " + entry.getValue().getNomeCliente().toUpperCase());
            System.out.println("C/C: " + entry.getValue().getContaCorrente());
            System.out.println("Poupanca: " + entry.getValue().getContaPoupanca());
            System.out.println("\n");
        }
    }

    public boolean isCliente(Map<Long, Cliente> listClient, String nomeClient){
        for (Map.Entry<Long, Cliente> entry: listClient.entrySet()) {
           if(entry.getValue().getNomeCliente().equalsIgnoreCase(nomeClient))
              clienteReturn = entry.getValue();
               return true;
        }
        return false;
    }

    public void imprimirDadosBancario(Cliente cliente){
        System.out.println("\n             DADOS BANCARIOS                  ");
        System.out.println("------------------------------------------------");
        System.out.println("cliente: " + cliente.getNomeCliente());
        System.out.println("Banco: "+ NOME_BANCO);
        System.out.println("Agencia: "+ ContaBancaria.AGENCIA_PADRAO);
        System.out.println("Conta Corrente: "+ cliente.getContaCorrente());
        System.out.println("Conta Poupanca: "+ cliente.getContaPoupanca());
        System.out.println("------------------------------------------------");

    }

    public int operacao(){
        System.out.println("             OPERACAO                           ");
        System.out.println("------------------------------------------------");
        System.out.println("1 - SALDO");
        System.out.println("2 - SAQUE");
        System.out.println("3 - DEPOSITO");
        System.out.println("4 - TRANSFERENCIA");

        System.out.println("Escolha tipo de operacao: ");
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
}
