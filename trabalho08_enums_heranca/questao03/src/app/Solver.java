package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import agenda.agendaeletronica.AgendaEletronica;
import contact.Contact;
import contact.Fone;

/**
 * Oferece uma interface para controle dos métodos
 * da agenda eletrônica. Algumas modificações foram
 * feitas para melhor se adequar à classe AgendaEletronica.
 * 
 * Para visualizar os comandos insira o comando
 * $help. 
 * 
 * Um tratamento simples de exceção foi adicionado
 * para permitir o programa continuar mesmo após
 * um erro (tratável).
 * 
 * Os comandos que necessitam de comandos, caso
 * recebam menos que o necessário, ou mais,
 * dependendo do caso, iram emitir uma
 * mensagem de erro. Nesse caso o usuário
 * pode tentar de novo. 
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 11/12/2021
 * @see contact.Contact
 * @see contact.Fone
 * @see agenda.agendaeletronica.AgendaEletronica
 */
public class Solver {

    /**
     * "", "", "", 
     * "" ou ""
     */

    public static String manual = "Agenda Eletrônica OOPersonal v1.0\n\n" + 
    "A agenda deve ser iniciada com um tamanho superior a 0. Caso não esteja inicializada  não poderá ser utilizada.\n" +
    "Ao adicionar um telefone certifique-se que ele esteja no formato correto:\n" +  
    "     (1) Não pode ter espaços.\n" +
    "     (2) Use pontos para separar os grupos de números.\n" +
    "     (3) Pode ter ou não DDD entre parênteses.\n" +
    "     (4) Pode ter ou não o dígito adicional antes do número.\n" +
    "     (5) Deve ter no mínimo 3 dígitos ou 8 dígitos. No caso de 8 dígitos aplique as regras (2), (3) e (4).\n" +
    "     (6) Formatos válidos:\n" +
    "          (I) XXX\n" +
    "          (II) XXXX.XXXX\n" +
    "          (III) X.XXXX.XXXX\n" +
    "          (IV) (XX)XXXX.XXXX\n" +
    "          (V) (XX)X.XXXX.XXXX\n" +
    "$init _dono _size - Inicia a agenda eletrônica com capacidade _size e nome _dono.\n" + 
    "$add _nome id:num ... id:num - Adiciona um contato _nome com os contatos inseridos no formato id:num. Caso o contato já exista ele será apenas atualizado com os números inseridos.\n" + 
    "$rm _nome - Apaga o contato _nome.\n" + 
    "$rmFone _nome _ind - Apaga o telefone de índice _ind do contato _nome.\n" + 
    "$show - Mostra as principais informações da agenda.\n" + 
    "$search _keyWord - Procura contatos que tenham _keyWord em seu interior.\n";

    public static Contact parseContact(String[] ui) {
        return new Contact(ui[1], (ArrayList<Fone>) Arrays.asList(ui).stream()
            .skip(2).map(token -> new Fone(token.split(":")[0], token.split(":")[1]))
            .collect(Collectors.toList()));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line, ui[];
        AgendaEletronica agendaEletronica = new AgendaEletronica("placeholder", 0);
        while(true){
            line = scanner.nextLine();
            System.out.println("$" + line);
            ui = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            }
            if(ui[0].equals("help")) {
                System.out.print(manual);
            }
            else if(ui[0].equals("init")) {
                if(ui.length != 3){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    try{
                        agendaEletronica = new AgendaEletronica(ui[1], Integer.parseInt(ui[2]));
                    }
                    catch(Exception e){
                        System.err.println("fail: operandos inválidos.");
                    }
                }
            }
            else if(agendaEletronica.getSize() == 0 && ui.length > 0){
                System.err.println("fail: agenda eletrônica não inicializada. Use o comando $init.");
            }
            else if(ui[0].equals("add")) { 
                /**
                 * Caso seja "ui.length < 3" então não é possível
                 * salvar contatos sem número.
                 */
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    try{
                        agendaEletronica.addContact(Solver.parseContact(ui));
                    }
                    catch(Exception e){
                        System.err.println("fail: formato inválido.");
                    }
                }
            }
            else if(ui[0].equals("rm")) { //name
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    agendaEletronica.rmContact(ui[1]);
                }
            }
            else if(ui[0].equals("rmFone")) { //name index
                if(ui.length < 3){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    Contact contact = agendaEletronica.findContact(ui[1]);
                    if(contact != null){
                        contact.rmFone(Integer.parseInt(ui[2]));
                    }
                }
            }
            else if(ui[0].equals("show")) {
                System.out.print(agendaEletronica);
            }
            else if(ui[0].equals("search")) {
                if(ui.length < 2){
                    System.err.println("fail: quantidade inválido de operandos para o comando.");
                }
                else{
                    System.out.println(agendaEletronica.search(ui[1]).stream().map(c -> "" + c).collect(Collectors.joining("\n")));     
                }
                
            }
            else {
                System.out.println("fail: comando inválido. Entre $help para obter ajuda.");
            }
        }
        scanner.close();
    }
}