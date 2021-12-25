package questao02.arraymaster;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esse aplicativo irá controlar um ArrayList por meio
 * de comandos no terminal. Alguns comandos aceitam
 * argumentos, outros não. Caso seja passado argumento 
 * para os comandos que não necessitam eles serão ignorados.
 * 
 * Alguns comandos tem restrições no número de argumentos
 * para que o programa funcione corretamente. Por exemplo:
 * o comando $get deve receber somente um parâmetro. Caso
 * receba mais que isso, ou menos, o programa retornará
 * uma mensagem de erro. 
 * 
 * O comando $clear foi adicionado ao repertório para
 * limpar a lista e facilitar os testes.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @sincw 16/11/2021
 */
public class ArrayMaster{	

    /**
     * O Scanner do método principal. Foi colocado aqui para
     * que possa ser criada um método exit(), que o feche.
     */
    private static Scanner scan = new Scanner(System.in);

    /**
     * Fecha o fluxo do Scanner e finaliza o programa. Foi
     * criado para que o programa possa finalizar a partir
     * do case "end" do switch.
     */
    private static void exit(){
        scan.close();
        System.exit(0);
    } 
    
    public static void main(String[] args) {
        ArrayList<Integer> vet = new ArrayList<Integer>();
        String line, ui[], cmd;
        int index, value, i;

        while(true) {
            line = scan.nextLine();
            System.out.println("$" + line);
            ui = line.split(" ");
            cmd = ui[0];

            switch(cmd){
                /**
                 * $end -> Finaliza o programa.
                 */
                case "end":
                    exit();
                    break;

                /**
                 * $show -> Mostra os valores do vetor.
                 */
                case "show":
                    System.out.print("[ ");
                    for(Integer val : vet){
                        System.out.print(val + " ");
                    }
                    System.out.println("]");
                    break;

                /**
                 * $rshow -> Mostra os valores da estrutura do último
                 * para o primeiro.
                 */
                case "rshow":
                    System.out.print("[ ");
                    for(i = vet.size() - 1; i >= 0; i--){
                        System.out.print(vet.get(i) + " ");
                    }
                    System.out.println("]");
                    break;

                /**
                 * $add v_1 v_2 ... v_n -> Adiciona os valores informados
                 * no final da estrutura.
                 * 
                 * Deve ter no mínimo um argumento além do comando.
                 * Não há limite de argumentos.
                 */
                case "add":
                    if(ui.length == 1){
                        System.err.println("fail: quantidade inválida de parâmetros.");
                    }
                    else{
                        for(i = 1; i < ui.length; i++){
                            vet.add(Integer.parseInt(ui[i]));
                        }
                    }
                    break;

                /**
                 * $find v_1 v_2 ... v_n -> Indica o índice da primeira
                 * ocorrência dos valores procurados ou -1 se ele não
                 * existir. 
                 * 
                 * Deve ter no mínimo um argumento além do comando.
                 * Não há limite de argumentos.
                 */
                case "find":
                    if(ui.length == 1){
                        System.err.println("fail: quantidade inválida de parâmetros.");
                    }
                    else{
                        System.out.print("[ ");
                        for(i = 1; i < ui.length; i++){
                            System.out.print(vet.indexOf(Integer.parseInt(ui[i])) + " ");
                        }
                        System.out.println("]");
                    }
                    break;

                /**
                 * $get ind -> Mostra o valor do vetor na posicao "ind".
                 * 
                 * Deve ter exatamente um argumento além do comando.
                 * O índice deve ser maior ou igual a zero e menor que
                 * o tamanho do array.
                 */
                case "get":
                    if(ui.length != 2){
                        System.err.println("fail: quantidade inválida de parâmetros.");
                        break;
                    }
                    index = Integer.parseInt(ui[1]);
                    if(index >= vet.size() || index < 0){
                        System.err.println("fail: índice inválido.");
                    }
                    else{
                        System.out.println("[ " + vet.get(index) + " ]");
                    }
                    break;   

                /**
                 * $set ind value -> Muda o valor da posicao "ind" para
                 * o valor "value".
                 * 
                 * Deve ter exatamente dois argumentos além do comando.
                 * O índice deve ser maior ou igual a zero e menor que
                 * o tamanho do array.
                 */
                case "set":
                    if(ui.length != 3){
                        System.err.println("fail: quantidade inválida de parâmetros.");
                        break;
                    }
                    index = Integer.parseInt(ui[1]);
                    value = Integer.parseInt(ui[2]);
                    if((index >= vet.size()) || (index < 0)){
                       System.err.println("fail: índice inválido.");
                    }
                    else{
                        vet.set(index, value);
                    }
                    break;

                /**
                 * $ins ind value -> Insere "value" na posição "ind"
                 * da estrutura.
                 * 
                 * Deve ter exatamente dois argumentos além do comando.
                 * 
                 * Se "ind" for menor que 0, não faça a inserção.
                 * Se "ind" for maior que último índice válido,
                 * insira na última posição.
                 * Se "ind" for um índice válido, desloque todos
                 * os elementos a partir dessa posição, uma posição
                 * à frente.
                 */
                case "ins":
                    if(ui.length != 3){
                        System.err.println("fail: quantidade inválida de parâmetros.");
                        break;
                    }
                    index = Integer.parseInt(ui[1]);
                    value = Integer.parseInt(ui[2]);
                    if(index < 0){
                       System.err.println("fail: índice inválido.");
                    }
                    else if(index >= vet.size()){
                        vet.add(value);
                    }
                    else{
                        vet.add(index, value);
                    }
                    break;
                
                /**
                 * $rmi ind -> Remove o elemento no índice informado, caso
                 * exista.
                 * 
                 * Deve ter exatamente um argumento além do comando.
                 * O índice deve ser maior ou igual a zero e menor que
                 * o tamanho do array.
                 */
                case "rmi":
                    if(ui.length != 2){
                        System.err.println("fail: quantidade inválida de parâmetros.");
                        break;
                    }
                    index = Integer.parseInt(ui[1]);
                    if(index >= vet.size() || index < 0){
                        System.err.println("fail: índice inválido.");
                    }
                    else{
                        vet.remove(index);
                    }
                    break;

                /**
                 * $rma value -> Remove todos os elementos que contém esse valor.
                 * 
                 * Deve ter exatamente um argumento além do comando.
                 */
                case "rma":
                    if(ui.length != 2){
                        System.err.println("fail: quantidade inválida de parâmetros.");
                        break;
                    }
                    value = Integer.parseInt(ui[1]);
                    int verify = vet.indexOf(value);

                    while(verify != -1){
                        vet.remove(verify);
                        verify = vet.indexOf(value);
                    }

                    break;

                /**
                 * Limpa todos os elementos da lista.
                 */
                case "clear":
                    vet.clear();
                    break;

                /**
                 * Caso algum comando estranho seja inserido o
                 * aplicativo irá avisar ao usuário.
                 */
                default:
                    System.err.print("fail: command not found\n");
            }
        }
    }
}