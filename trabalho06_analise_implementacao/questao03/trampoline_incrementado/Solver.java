package questao03.trampoline_incrementado;

import java.util.Scanner;

/**
 * Aplicativo de controle da classe Trampoline,
 * por meio de comandos no terminal.
 * 
 * Antes de inicializar o sistema deve-se
 * configurar o trampolim. Só então poderá
 * usar os comandos. O comando "$remover _nome"
 * foi modificado de forma que, ao remover
 * alguma criança, seu débito seja quitado.
 * Esse comando substitui $papaichegou _nome,
 * porque eu acho mais legal assim, mas faz
 * a mesma coisa.
 * 
 * Comandos adicionais:
 * 
 * $saldo _nome - Mostra o valor que uma criança
 * deve acumulado.
 * 
 * $caixa - Mostra quanto dinheiro o pula pula já
 * arrecadou, e quanto deve cada criança.
 * 
 * $fechar - Retira todas as criancas das listas e
 * quita suas dívidas.
 * 
 * $remover _nome - Remove uma criança das listas
 * e quita suas dívidas.
 *  
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 25/11/2021
 */
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Trampoline tramp;
        String line, ui[];

        //Inicializar o trampolim.
        while(true){
            System.out.println("Inicialize o Trampolim: Passe a capacidade máxima, idade máxima e preço.");
            line = scanner.nextLine();
            ui = line.split(" ");
            if(ui.length != 3){
                System.err.println("fail: quantidade errada de parâmetros.");
            }
            else if(Integer.parseInt(ui[0]) < 1 || Integer.parseInt(ui[1])  < 1 || Float.parseFloat(ui[2].replace(",", "."))  < 0){
                System.err.println("fail: parâmetros inválidos.");
            }
            else{
                tramp = new Trampoline(Integer.parseInt(ui[0]), Integer.parseInt(ui[1]), Float.parseFloat(ui[2].replace(",", ".")));
                break;
            }
        }
        System.out.println("Trampolim configurado. Insira os comandos abaixo.\n");

        //Gerenciar o trampolim. 
        while(true) {
            line = scanner.nextLine();
            System.out.println("$"+ line);
            ui = line.split(" ");
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
            else if(ui[0].equals("caixa")) {
                System.out.println(tramp.getBalance());
            }
            else if(ui[0].equals("saldo")) {
                if(ui.length != 2){
                    System.err.println("fail: quantidade errada de parâmetros.");
                }
                else{
                    System.out.println("R$ " + tramp.findKid(ui[1]).getBalance());
                }
            }
            else if(ui[0].equals("remove")) {//name
                if(ui.length != 2){
                    System.err.println("fail: quantidade errada de parâmetros.");
                }
                else{
                    tramp.remove(ui[1]);
                }
            }
            else if(ui[0].equals("fechar")) {
                tramp.removeAll();
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
