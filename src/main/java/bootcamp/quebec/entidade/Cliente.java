package bootcamp.quebec.entidade;

import lombok.Data;

import java.util.List;
import java.util.Scanner;

@Data
public class Cliente {
    private String nomeCliente;
    private long contaCorrente;
    private long contaPoupanca;
}
