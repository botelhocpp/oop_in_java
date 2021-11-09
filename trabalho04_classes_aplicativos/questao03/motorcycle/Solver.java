package motorcycle;

import java.util.Scanner;

/**
 * Comandos para a utilização dos métodos da classe Car.
 * 
 * 31/10/2021 - Commit Inicial. Estrutura proposta pelo professor.
 * 
 * @author Atílio G. Luiz
 * @since 31/10/2021
 */
public class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Motorcycle motoca  = new Motorcycle(1);
        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" "); //ui user input eh um vetor de strings
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            }
            else if(ui[0].equals("init")) { //power
                motoca = new Motorcycle(Integer.parseInt(ui[1]));
            }
            else if(ui[0].equals("in")) { //in name age
                int age = Integer.parseInt(ui[2]);
                Person person = new Person(ui[1], age);
                motoca.in(person);
            }
            else if(ui[0].equals("out")) {
                motoca.out();
            }
            else if(ui[0].equals("show")) {
                System.out.println(motoca);
            }
            else if(ui[0].equals("drive")) {
                motoca.drive(Integer.parseInt(ui[1]));
            }
            else if(ui[0].equals("buy")) {
                motoca.buy(Integer.parseInt(ui[1]));
            }
            else if(ui[0].equals("honk")) {
                motoca.honk();
            }
            else {
                System.err.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}

