package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import agenda.Agenda;
import contact.Contact;
import contact.Fone;

public class Solver {
    //cria um contato a partir do vetor de entrada tal como
    //add joao oi:123 tim:432 claro:09123
    public static Contact parseContact(String[] ui) {
        return new Contact(ui[1], (ArrayList<Fone>) Arrays.asList(ui).stream()
            .skip(2).map(token -> new Fone(token.split(":")[0], token.split(":")[1]))
            .collect(Collectors.toList()));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            }
            else if(ui[0].equals("init")) {
                agenda = new Agenda();
            }
            else if(ui[0].equals("add")) { //name label:fone label:fone label:fone
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    agenda.addContact(Solver.parseContact(ui));
                }
            }
            else if(ui[0].equals("rm")) { //name
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    agenda.rmContact(ui[1]);
                }
            }
            else if(ui[0].equals("rmFone")) { //name index
                if(ui.length < 3){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    Contact contact = agenda.findContact(ui[1]);
                    if(contact != null){
                        contact.rmFone(Integer.parseInt(ui[2]));
                    }
                }
            }
            else if(ui[0].equals("show")) {
                System.out.println(agenda);
            }
            else if(ui[0].equals("search")) {
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    System.out.println(agenda.search(ui[1]).stream().map(c -> "" + c).collect(Collectors.joining("\n")));     
                }
                
            }
            else {
                System.out.println("fail: comando inválido.");
            }
        }
        scanner.close();
    }
}