package app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import agencia.Conta;
import agencia.Label;

/**
 * Aplicação para controle dos métodos das classes do
 * pacote agencia, a partir de comandos inseridos no
 * terminal.
 * 
 * O aplicativo emite uma mensagem de erro ao inserir
 * quantidade de parâmetros inválida.
 * 
 * Novos comandos de finalização adicionados.
 * 
 * Tratamento de exceção básico para o programa
 * não finalizar.
 * 
 * @author Pedro M. Botelho
 * @author Atílio G. Luiz
 * @see agencia.Conta
 * @see agencia.Financas
 * @see agencia.Label
 * @see agencia.Operacao
 * @since 10/12/2021
 */
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta(0);
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            List<String> ui = Arrays.asList(line.split(" "));
            if(line.equals("end") || line.equals("exit") || line.equals("sair")) {
                break;
            }
            else if(ui.get(0).equals("show")) {
                System.out.println(conta);
            }
            else if(ui.get(0).equals("init")) {
                if(ui.size() != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    conta = new Conta(Integer.parseInt(ui.get(1)));
                }
            }
            else if(ui.get(0).equals("saque")) {
                if(ui.size() != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    conta.sacar(Integer.parseInt(ui.get(1)));
                }
            }
            else if(ui.get(0).equals("tarifa")) {
                if(ui.size() != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    conta.tarifar(Integer.parseInt(ui.get(1)));
                }
            }
            else if(ui.get(0).equals("deposito")) {
                if(ui.size() != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    conta.creditar(Label.DEPOSITO, Integer.parseInt(ui.get(1)));
                }
            }
            else if(ui.get(0).equals("extornar")) {
                if(ui.size() < 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    final Conta aux = conta;
                    ui.stream().skip(1).forEach(index -> aux.extornar(Integer.parseInt(index)));
                }
            }
            else if(ui.get(0).equals("extrato")) {
                try {
                    conta.getFinancas().getExtrato().forEach(System.out::println);
                }
                catch(Exception e){
                    //Apenas para não aparecer a exceção e finalizar a aplicação.
                }
            }
            else if(ui.get(0).equals("extratoN")) {
                if(ui.size() != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    try {
                        conta.getFinancas().getExtrato(Integer.parseInt(ui.get(1))).forEach(System.out::println);
                    }
                    catch(Exception e){
                        //Apenas para não aparecer a exceção e finalizar a aplicação.
                    }
                }
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
