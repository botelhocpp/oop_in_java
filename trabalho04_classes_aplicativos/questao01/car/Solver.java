package car;

import java.util.Scanner;

/**
 * Comandos para a utilização dos métodos da classe Car.
 * 
 * 31/10/2021 - Commit Inicial. Estrutura proposta pelo professor.
 * 
 * @author Atílio G. Luiz
 * @since 31/10/2021
 */
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")){
                break;
            }
            else if(ui[0].equals("in")){
                car.in();
            }
            else if(ui[0].equals("out")){
                car.out();
            }
            else if(ui[0].equals("show")){
                System.out.println(car.toString());
            }
            else if (ui[0].equals("drive")){
                car.drive(Integer.parseInt(ui[1]));
            }
            else if (ui[0].equals("fuel")){
                car.fuel(Integer.parseInt(ui[1]));
            }
            else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}