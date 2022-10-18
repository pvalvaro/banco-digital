package bootcamp.quebec.entidade;

import lombok.Data;

@Data
public class ContaCorrente extends ContaBancaria {

    public void imprimirExtratoCorrente(){
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirSaldo();
    }
}
