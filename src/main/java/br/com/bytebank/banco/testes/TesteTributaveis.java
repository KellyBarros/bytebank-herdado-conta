package br.com.bytebank.banco.testes;

import br.com.bytebank.banco.modelo.CalculadorImposto;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.SeguroDeVida;

public class TesteTributaveis {

    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(2121, 2121);
        SeguroDeVida seguroDeVida = new SeguroDeVida();
        contaCorrente.deposita(1000);
        CalculadorImposto calculadorImposto = new CalculadorImposto();
        calculadorImposto.registra(contaCorrente);
        calculadorImposto.registra(seguroDeVida);

        System.out.print(calculadorImposto.getTotalImposto());


    }
}
