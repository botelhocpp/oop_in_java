package topic;

import java.util.Scanner;

/**
 * Sistema de controle, do pacote "topic", para alocação
 * de assentos para passageiros, a partir de comandos, que
 * pode ser alocado para passageiros.
 * 
 * Houve adição de controle para comandos com quantidade
 * inválida de operandos.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 02/12/2021
 * @see topic.Passageiro
 * @see topic.Topic
 */
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Topic topic = new Topic(0, 0);
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(line.equals("end")) {
                break;
            }
            else if(ui[0].equals("init")) {
                if(ui.length != 3){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                }
            }
            else if(ui[0].equals("show")) {
                System.out.println(topic);
            }
            else if(ui[0].equals("in")) {
                if(ui.length != 3){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    topic.insert(new Passageiro(ui[1], Integer.parseInt(ui[2])));
                }
            }
            else if(ui[0].equals("out")) {//value value
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    topic.remove(ui[1]);
                }
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
