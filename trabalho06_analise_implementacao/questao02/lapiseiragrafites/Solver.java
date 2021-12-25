package questao02.lapiseiragrafites;

import java.util.Locale;
import java.util.Scanner;

/**
 * Manipula a classe Lapiseira por meio de comandos
 * no terminal. O comando $write foi modificado
 * para escrever várias folhas, e o comando
 * $help foi incrementado. Os comandos com limite
 * de argumentos foram protegidos com estruturas
 * de decisão.
 * 
 * @author M. Botelho & Atílio G. Luiz
 * @since 25/11/2021
 */
public class Solver {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Lapiseira lapiseira = new Lapiseira(0.5f);
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            }
            else if(ui[0].equals("help")) {
                System.out.println("\n------------------------------------------HELP----------------------------------------------\n" + 
                                    "$init _calibre: Inicializa uma lapiseira que comporta grafites de espessura '_calibre' mm.\n\n" + 
                                    "$add _calibre _dureza _tamanho: Insere um grafite com espessura '_calibre', nível de maciez\n'_dureza' e comprimento '_tamanho' no tambor.\n\n" + 
                                    "$remove: Remove o grafite engatilhado na lapiseira.\n\n" +
                                    "$pull: Engatilha o bico da lapiseira com um grafite do tambor, se não estiver vazio.\n\n" +
                                    "$write _folhas: Escreve uma quantidade '_folhas' de folhas. Valor default de '_folhas' é 1.\n\n" +
                                    "$show: Mostra as principais informações da lapiseira.\n\n" +
                                    "$end: Finaliza o programa.\n" +
                                    "-------------------------------------------------------------------------------------------\n");
            }


            else if(ui[0].equals("init")) { //calibre
                if(ui.length != 2){
                    System.err.println("fail: quantidade inválida de parâmetros.");
                }
                else{
                    lapiseira = new Lapiseira(Float.parseFloat(ui[1].replace(',', '.')));
                }
            }
            else if(ui[0].equals("add")) { //calibre dureza tamanho
                if(ui.length != 4){
                    System.err.println("fail: quantidade inválida de parâmetros.");
                }
                else{
                    float calibre = Float.parseFloat(ui[1].replace(',', '.'));
                    String dureza  = ui[2].toUpperCase();
                    int tamanho = Integer.parseInt(ui[3]);
                    lapiseira.inserir(new Grafite(calibre, dureza, tamanho));
                }
            }

            else if(ui[0].equals("remove")) {
                lapiseira.remover();
            }
            else if(ui[0].equals("show")) {
                System.out.println(lapiseira);
            }
            else if (ui[0].equals("write")) {
                if(ui.length == 1){
                    lapiseira.escrever();
                }
                else if(ui.length == 2){
                    lapiseira.escrever(Integer.parseInt(ui[1]));
                }
                else{
                    System.err.println("fail: quantidade inválida de parâmetros.");
                }
            }
            else if (ui[0].equals("pull")) {
                lapiseira.puxar();
            }
            else {
                System.out.println("fail: comando invalido, digite 'help' para obter ajuda.");
            }
        }
        scanner.close();
    }
}