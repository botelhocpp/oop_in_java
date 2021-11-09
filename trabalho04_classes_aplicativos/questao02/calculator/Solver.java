package calculator;

import java.util.Locale;
import java.util.Scanner;

/**
 * Aplicativo para controlar a calculadora.
 * 
 * Adicionei suporte à números de ponto flutuante
 * nas operações.
 * 
 * 31/10/2021 - Commit inicial. Estrutura proposta pelo professor.
 * 09/11/2021 - Controle para as funções adicionais.
 * 
 * Adicionei alguns comandos para operar o restante das funções.
 * Caso seja inserido algum comando, além de init e end, antes do
 * primeiro init será emitido uma mensagem de erro.
 * 
 * Comandos de Controle: Controlam primariamente a bateria da calculadora.
 * 
 * init m  - Inicia a calculadora com "m" miliampères.
 * end     - Desliga a calculadora.
 * show    - Mostra o display e quantidade de bateria, em miliampères.
 * charge  - Carrega a bateria em uma certa quantidade, em miliampères.
 * battery - Mostra o gerenciamento de bateria, ou seja, o seu estado atual.
 * 
 * Comandos Aritméticos: Controlam o dado que aparecerá no display.
 * 
 * sum m n - Soma m com n.
 * sum m   - Soma o valor do display com m.
 * mul m n - Multiplica m por n.
 * mul m   - Multiplica o valor do display por m.
 * div m n - Divide o m por n.
 * div m   - Divide o valor do display por m.
 * pow m n - Eleva m a potência de n.
 * pow m   - Eleva o valor do display a potência de m.
 * sen m   - Computa o seno de m.
 * sen     - Computa o seno do valor do display.
 * cos m   - Computa o cosseno de m.
 * cos     - Computa o cosseno do valor do display.
 * tg m    - Computa a tangente de m.
 * tg      - Computa o tangente do valor do display.
 * sqrt m  - Computa a raiz quadrada de m.
 * sqrt    - Computa a raiz quadrada do valor do display.
 * log m   - Computa o logarítmo de base 10 de m.
 * log     - Computa o logarítmo de base 10 do valor do display.
 * ln m    - Computa o logarítmo natural de m.
 * ln      - Computa o logarítmo natural do valor do display..
 * e       - Configura o valor de display para o número de euler.
 * pi      - Configura o valor de display para o número pi.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 09/11/2021
 */
public class Solver{

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator(0);
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(line.equals("end")){
                break;
            }
            else if(ui[0].equals("init")){
                calc = new Calculator(Integer.parseInt(ui[1]));
            }
            else if(line.length() != 0 && calc.getBatteryMax() == 0){
                System.err.println("fail: calculadora não inicializada");
                continue;
            }
            else if(ui[0].equals("show")){
                System.out.println(calc);
            }
            else if(ui[0].equals("charge")){
                calc.chargeBattery(Integer.parseInt(ui[1]));
            }
            else if(ui[0].equals("sum")){
                if(ui.length == 3){
                    calc.sum(Float.parseFloat(ui[1]), Float.parseFloat(ui[2]));
                }
                else if(ui.length == 2){
                    calc.sum(Float.parseFloat(ui[1]));
                }
            }
            else if(ui[0].equals("mul")){
                if(ui.length == 3){
                    calc.mul(Float.parseFloat(ui[1]), Float.parseFloat(ui[2]));
                }
                else if(ui.length == 2){
                    calc.mul(Float.parseFloat(ui[1]));
                }
            }
            else if(ui[0].equals("div")){
                if(ui.length == 3){
                    calc.division(Float.parseFloat(ui[1]), Float.parseFloat(ui[2]));
                }
                else if(ui.length == 2){
                    calc.division(Float.parseFloat(ui[1]));
                }
            }
            else if(ui[0].equals("pow")){
                if(ui.length == 3){
                    calc.pow(Float.parseFloat(ui[1]), Float.parseFloat(ui[2]));
                }
                else if(ui.length == 2){
                    calc.pow(Float.parseFloat(ui[1]));
                }
            }
            else if(ui[0].equals("sen")){
                if(ui.length == 2){
                    calc.sen(Float.parseFloat(ui[1]));
                }
                else if(ui.length == 1){
                    calc.sen();
                }
            }
            else if(ui[0].equals("cos")){
                if(ui.length == 2){
                    calc.cos(Float.parseFloat(ui[1]));
                }
                else if(ui.length == 1){
                    calc.cos();
                }
            }
            else if(ui[0].equals("tg")){
                if(ui.length == 2){
                    calc.tg(Float.parseFloat(ui[1]));
                }
                else if(ui.length == 1){
                    calc.tg();
                }
            }
            else if(ui[0].equals("sqrt")){
                if(ui.length == 2){
                    calc.sqrt(Float.parseFloat(ui[1]));
                }
                else if(ui.length == 1){
                    calc.sqrt();
                }
            }
            else if(ui[0].equals("log")){
                if(ui.length == 2){
                    calc.log(Float.parseFloat(ui[1]));
                }
                else if(ui.length == 1){
                    calc.log();
                }
            }
            else if(ui[0].equals("ln")){
                if(ui.length == 2){
                    calc.ln(Float.parseFloat(ui[1]));
                }
                else if(ui.length == 1){
                    calc.ln();
                }
            }
            else if(ui[0].equals("battery")){
                System.out.println(calc.batteryManager());
            }
            else if(ui[0].equals("e")){
                calc.setEuler();
            }
            else if(ui[0].equals("pi")){
                calc.setPi();
            }
            else{
                System.err.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}