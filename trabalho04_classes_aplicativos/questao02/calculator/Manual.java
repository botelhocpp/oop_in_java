package calculator;

import java.util.Locale;

/**
 * Sequência de testes finitos para a classe Calculator.
 * 
 * 09/11/2021 - Commit Inicial. Sequência de testes para
 * testar rapidamente os métodos da classe.
 * 
 * @author Pedro M. Botelho
 * @since 09/11/2021
 */
public class Manual {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        //Iniciando a Calculador
        Calculator calc = new Calculator(4200);
        System.out.println("Nível de bateria inicial: " + calc.batteryManager());
        calc.chargeBattery(3700);
        System.out.println("Nível de bateria após uma carga de 3700mA: " + calc.batteryManager() + "\n");

        //Case Operações Aritméticas Básicas
        calc.sum(60, 20);
        System.out.println("Operação: 60 + 20, " + calc);
        calc.sum(80, -20);
        System.out.println("Operação: 80 + (-20), " + calc);
        calc.mul(16, 5);
        System.out.println("Operação: 16*5, " + calc);
        calc.division(80, 16);
        System.out.println("Operação: 80/16, " + calc);
        calc.sum(1);
        System.out.println("Operação: 5 + 1, " + calc);
        calc.sum(-1);
        System.out.println("Operação: 6 + (-1), " + calc);
        calc.mul(10);
        System.out.println("Operação: 5*10, " + calc);
        calc.division(10);
        System.out.println("Operação: 50/10, " + calc + "\n");
        
        //Case Funções Trigonometricas
        calc.setPi();
        System.out.println("Inserir: 3.14, " + calc);
        calc.division(2);
        calc.sen();
        System.out.println("Operação: sen(3.14/2), " + calc);
        calc.setPi();
        calc.cos();
        System.out.println("Operação: cos(3.14), " + calc);
        calc.setPi();
        calc.mul(3);
        calc.division(4);
        calc.tg();
        System.out.println("Operação: tg(3.14*3/4), " + calc + "\n");

        //Case Funções Adicionais
        calc.setEuler();
        System.out.println("Inserir: 2.72, " + calc);
        calc.ln();
        System.out.println("Operação: ln(2.72), " + calc);
        calc.log(100);
        System.out.println("Operação: log(100), " + calc);
        calc.sqrt(9);
        System.out.println("Operação: sqrt(9), " + calc);
        calc.pow(3);
        System.out.println("Operação: 3^3, " + calc);
        calc.pow(59, 2);
        System.out.println("Operação: 59^2, " + calc);
    }
}