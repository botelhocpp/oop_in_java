package cinema;

import java.util.Scanner;

/**
 * Sistema de controle, do pacote "cinema", para alocação
 * de uma sala de cinema, a partir de comandos, que pode
 * receber reservas de clientes.
 * 
 * Cadeiras livres podem ser alocadas pelo comando $reservar,
 * passando os dados do cliente e o número da cadeira, começando
 * de zero. A reserva pode ser desfeita pelo comando $cancelar,
 * passando o nome do cliente. O sistema mostra quem está sentado
 * em cada cadeira com o comando $show.
 * 
 * O programa irá mostrar uma mensagem de erro caso os comandos
 * que necessitam de argumentos recebam menos argumentos que o
 * necessário.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 02/12/2021
 * @see cinema.Cliente
 * @see cinema.Sala
 */
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sala sala = new Sala(0);
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            }
            else if(ui[0].equals("init")) {
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    sala = new Sala(Integer.parseInt(ui[1]));
                }
            }
            else if(ui[0].equals("show")) {
                System.out.println(sala);
            }
            else if(ui[0].equals("reservar")) {
                if(ui.length != 4){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    sala.reservar(ui[1], ui[2], Integer.parseInt(ui[3]));
                }
            }
            else if(ui[0].equals("cancelar")) {
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválida de operandos.");
                }
                else{
                    sala.cancelar(ui[1]);
                }
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}