package questao03.trampoline;

import java.util.Scanner;

/**
 * Aplciativo de controle da classe Trampoline,
 * por meio de comandos no terminal.
 *  
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 25/11/2021
 */
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trampoline tramp = new Trampoline();
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$"+ line);
            String[] ui = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            }
            else if(ui[0].equals("arrive")) { // name age
                if(ui.length != 3){
                    System.err.println("fail: quantidade errada de parâmetros.");
                }
                else{
                    tramp.arrive(new Kid(ui[1], Integer.parseInt(ui[2])));
                }
            }
            else if(ui[0].equals("in")) {
                tramp.in();
            }
            else if(ui[0].equals("out")) {
                tramp.out();
            }
            else if(ui[0].equals("remove")) {//name
                if(ui.length != 2){
                    System.err.println("fail: quantidade errada de parâmetros.");
                }
                else{
                    tramp.remove(ui[1]);
                }
            }
            else if(ui[0].equals("show")) {
                System.out.println(tramp);
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
