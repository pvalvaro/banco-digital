package bootcamp.quebec.entidade;

public class ContaPoupanca extends ContaBancaria {

   public void imprimirExtratoPoupaca(){
       System.out.println("=== Extrato Conta Poupanca ===");
       super.imprimirSaldo();
   }
}
