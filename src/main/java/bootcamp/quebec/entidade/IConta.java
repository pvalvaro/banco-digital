package bootcamp.quebec.entidade;

import java.util.Map;

public interface IConta {
    void sacar(double valor);
    void depositar(double valor);
    void transferir(Long contaDestino, double valor);
    void imprimirSaldo();

}
