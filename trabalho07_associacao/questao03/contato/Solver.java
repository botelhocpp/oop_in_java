package contato;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Comandos para manipulação da classe
 * Contato. Os comandos que necessitam
 * de parâmetros retornam erros tratáveis
 * caso passados mais parâmetros, ou menos,
 * que o necessário.
 * 
 * O comando "init" pode receber mais de um
 * parâmetro. Caso receba apenas o nome
 * nenhum número de telefone será atribuído.
 * Mais parâmetros podem ser passados,
 * caracterizando os telefones do contato.
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 05/12/2021
 * @see contato.Fone
 * @see contato.Contato
 */
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contato contact = new Contato("", null);
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            }
            else if(ui[0].equals("init")) { //name
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválida de parâmetros.");
                }
                if(ui.length == 2){
                    contact = new Contato(ui[1], null);
                }
                else{
                    ArrayList<Fone> fones = new ArrayList<Fone>();
                    for(int i = 2; i < ui.length; i += 2){
                        fones.add(new Fone(ui[i], ui[i + 1]));
                    }
                    contact = new Contato(ui[1], fones);
                }
            }
            else if(ui[0].equals("add")) {  //id fone
                if(ui.length != 3){
                    System.err.println("fail: quantidade inválida de parâmetros.");
                }
                else{
                    contact.addFone(new Fone(ui[1], ui[2]));
                }
            }
            else if(ui[0].equals("rm")) {   //index
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválida de parâmetros.");
                }
                else{
                    contact.rmFone(Integer.parseInt(ui[1]));
                }
            }
            else if(ui[0].equals("show")) {
                System.out.println(contact);
            }
            else {
                System.out.println("fail: invalid command");
            }
        }
        scanner.close();
    }
}