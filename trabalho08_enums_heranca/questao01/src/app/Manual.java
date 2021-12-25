package app;

import agencia.Conta;
import agencia.Label;

/**
 * Sequência finita de casos de teste, para os métodos das
 * classes do pacote agencia, fornecida pelo professor.
 * 
 * @author Pedro M. Botelho
 * @author Atílio G. Luiz
 * @see agencia.Conta
 * @see agencia.Financas
 * @see agencia.Label
 * @see agencia.Operacao
 * @since 10/12/2021
 */
public class Manual {
    public static void main(String[] args){
        System.out.println("\n------------ Inicio __case iniciar ------------\n");
        Conta contaAgencia = new Conta(100);
        System.out.println(contaAgencia);
        //conta:100 saldo:0

        System.out.println("\n------------ Inicio __case depositar ------------\n");
        contaAgencia.creditar(Label.DEPOSITO, 100);
        contaAgencia.creditar(Label.DEPOSITO, -10);
        //fail: valor invalido
        System.out.println(contaAgencia);
        //conta:100 saldo:100

        System.out.println("\n------------ Inicio __case debito ------------\n");
        contaAgencia.sacar(20);
        contaAgencia.tarifar(10);
        System.out.println(contaAgencia);
        //conta:100 saldo:70
        contaAgencia.sacar(150);
        //fail: saldo insuficiente
        contaAgencia.sacar(30);
        contaAgencia.tarifar(5);
        contaAgencia.creditar(Label.DEPOSITO, 5);
        contaAgencia.tarifar(1);
        System.out.println(contaAgencia);
        //conta:100 saldo:39

        System.out.println("\n------------ Inicio __case extrato ------------\n");
        contaAgencia.getFinancas().getExtrato().forEach(System.out::println);
        /*
            0: abertura:    0:    0
            1: deposito:  100:  100
            2:    saque:  -20:   80
            3:   tarifa:  -10:   70
            4:    saque:  -30:   40
            5:   tarifa:   -5:   35
            6: deposito:    5:   40
            7:   tarifa:   -1:   39
         */

        //__case extratoN
        System.out.println("\n------------ Inicio __case extratoN ------------\n");
        contaAgencia.getFinancas().getExtrato(2).forEach(System.out::println);
        /*
            6: deposito:    5:   40
            7:   tarifa:   -1:   39
         */

        System.out.println("\n------------ Inicio __case extornar ------------\n");
        contaAgencia.extornar(1);
        //fail: indice 1 nao e tarifa
        contaAgencia.extornar(5);
        contaAgencia.extornar(7);
        contaAgencia.extornar(50);
        //fail: indice 50 invalido

        System.out.println("\n------------ Inicio __case novo extrato ------------\n");
        contaAgencia.getFinancas().getExtrato().forEach(System.out::println);
        /*
            0: abertura:    0:    0
            1: deposito:  100:  100
            2:    saque:  -20:   80
            3:   tarifa:  -10:   70
            4:    saque:  -30:   40
            5:   tarifa:   -5:   35
            6: deposito:    5:   40
            7:   tarifa:   -1:   39
            8:  extorno:    5:   44
            9:  extorno:    1:   45
         */

        System.out.println("\n------------ Inicio __case extrato tarifa ------------\n");
        contaAgencia.tarifar(50);
        contaAgencia.getFinancas().getExtrato(2).forEach(System.out::println);
        /*
            9:  extorno:    1:   45
           10:   tarifa:  -50:   -5
         */
    }
}