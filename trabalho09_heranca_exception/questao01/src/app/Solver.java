package app;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import agenda.agendastar.AgendaStar;
import contact.Fone;
import contact.contactstar.ContactStar;

/**
 * Controlador para a classe AgendaStar,
 * baseado em comandos passados no terminal.
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 20/12/2021
 * @see contact.contactstar.ContatoStar
 * @see agenda.agendastar.AgendaStar
 * @see contact.Fone
 */
public class Solver {

    /**
     * Cria um ContactStar a partir do vetor de entrada tal como
     * add joao oi:123 tim:432 claro:09123.
     * 
     * @param ui Um Array de Strings, com os parâmetros para a 
     * inicialização do contato.
     * @return Um ContactStar correspondente.
     */
    static ContactStar parseContact(String[] ui) {
        return new ContactStar(ui[1], Arrays.asList(ui).stream()
            .skip(2).map(token -> new Fone(token.split(":")[0], token.split(":")[1]))
            .collect(Collectors.toList()), false);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaStar agenda = new AgendaStar();
        String line;
        String ui[];
        while(true) {
            line = scanner.nextLine();
            System.out.println("$" + line);
            ui = line.split(" ");
            
            if(ui[0].equals("end")) {
                break;
            }
            else if(ui[0].equals("init")) {
                agenda = new AgendaStar();
            }
            
            else if(ui[0].equals("add")) { //name label:fone label:fone label:fone
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    agenda.addContact(Solver.parseContact(ui));
                }
            }
            else if(ui[0].equals("rmContact")) { //name
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    agenda.rmContact(ui[1]);
                }
            }
            else if(ui[0].equals("rmFone")) { //name index
                if(ui.length != 3){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    try{
                        agenda.findContact(ui[1]).rmFone(Integer.parseInt(ui[2]));
                    }
                    catch(NullPointerException e){ }
                }
            }
            else if(ui[0].equals("search")) {
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    System.out.println(agenda.search(ui[1]).stream().map(c -> "" + c).collect(Collectors.joining("\n")));     
                }
                
            }
            else if(ui[0].equals("star")) {
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    agenda.star(ui[1], true);
                }
            }
            else if(ui[0].equals("unstar")) {
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    agenda.star(ui[1], false);
                }
            }
            else if(ui[0].equals("starred")) {
                System.out.println(agenda.getStarred().stream().map(c -> "" + c).collect(Collectors.joining("\n")));
            }
            else if(ui[0].equals("show")) {
                System.out.println(agenda);
            }
            else {
                System.out.println("fail: comando inválido.");
            }
        }
        scanner.close();
    }
}