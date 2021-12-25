package questao01.lapiseira;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Essa classe modela uma peça de grafite que
 * pode ser usada em uma lapiseira de mesmo
 * calibre.
 * 
 * Essa classe tem dois atributos estáticos,
 * que podem ser acessados externamente à
 * classe para verificar os padrões de
 * dureza e calibre. Outro motivo para
 * torna-los estáticos é que são duas
 * estruturas de dados que, caso não
 * estáticas, iriam ocupar muito espaço na
 * memória, já que cada instância de Grafite
 * iria ter uma.
 * 
 * O método "clone" foi criado para atender
 * a relação de composição entre as classes
 * Lapiseira e Grafite, onde um grafite colocado
 * na lapiseira deve ser destruído caso a lapiseira
 * seja destruída. Por exemplo, se temos, no método
 * principal "Grafite caixaGrafites" e adicionamos
 * isso a um objeto Lapiseira devemos adicionar não 
 * uma referẽncia à instância, mas uma cópia desta 
 * instância, ou seja, adicionar os grafites da caixa.
 * Essa metodologia é destinada, obviamente, a instâncias
 * múltiplas na função principal, como fábrica de instâncias.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 16/11/2021
 */
public class Grafite {

    /**
     * Representa o comprimento do grafite.
     */
    private int tamanho;

    /**
     * Representa a espessura do grafite.
     */
    private float calibre;

    /**
     * Representa a escala do grafite, do mais rígido
     * para o mais macio.
     */
    private String dureza;

    /**
     * Todos os valores de dureza, do mais rígido para o
     * mais macio, aceitáveis para a classe Grafite.
     */
    public static final ArrayList<String> durezaValores = new ArrayList<String>(Arrays.asList("HB", "2B", "4B", "6B"));  

    /**
     * Todos os valores de calibre aceitáveis para a
     * classe Grafite, do menos para o mais expesso. 
     */
    public static final ArrayList<Float> calibreValores = new ArrayList<Float>(Arrays.asList(0.2f, 0.3f, 0.5f, 0.7f, 0.9f, 2.0f, 2.5f, 3.0f, 3.15f, 3.2f, 3.8f, 5.6f)); 

    /**
     * Inicializa os atributos da classe Grafite caso os
     * valores de calibre e dureza passados como argumentos
     * sejam válidos, estando de acordo com os valores
     * preestabelecidos pela classe. 
     * 
     * Caso não, é emitido um sinal de erro para o usuário.
     * 
     * @param calibre Espessura do grafite.
     * @param dureza Escala de maciez do grafite.
     * @param tamanho Comprimento do grafite.
     */
    public Grafite(float calibre, String dureza, int tamanho){
        int durezaCheck = durezaValores.indexOf(dureza);
        int calibreCheck = calibreValores.indexOf(calibre);
        if(durezaCheck != -1 && calibreCheck != -1){
            this.calibre = calibre;
            this.dureza = dureza;
            this.tamanho = tamanho;
        }
        if(durezaCheck == -1){
            System.err.println("fail: valor inválido para dureza do grafite.");
        }
        if(calibreCheck == -1){
            System.err.println("fail: valor inválido para calibre do grafite.");
        }
    }

    /**
     * Realiza um desgaste no grafite, referente a escrever
     * uma folha inteira e baseado no seu nível de dureza, 
     * e retorna a o valor do desgaste. O grafite é desgastado
     * na mesma quantidade retornada.
     * 
     * Já que na instanciação o objeto não pode receber um
     * valor inválido para dureza, não há um código de erro
     * para a função.
     * 
     * @return Valor do desgaste para uma folha.
     */
    public int desgastePorFolha(){
        if(this.dureza.equals("HB")){
            this.tamanho = ((this.tamanho - 1) > 10) ? this.tamanho - 1 : 10;
            return 1;
        }
        else if(this.dureza.equals("2B")){
            this.tamanho = ((this.tamanho - 2) > 10) ? this.tamanho - 2 : 10;
            return 2;
        }
        else if(this.dureza.equals("4B")){
            this.tamanho = ((this.tamanho - 4) > 10) ? this.tamanho - 4 : 10;
            return 4;
        }
        else{
            this.tamanho = ((this.tamanho - 6) > 10) ? this.tamanho - 6 : 10;
            return 6;
        }
    }

    /**
     * Retorna o valor do comprimento do grafite.
     */
    public int getTamanho(){
        return this.tamanho;
    }

    /**
     * Retorna o valor da espessura do grafite.
     */
    public float getCalibre(){
        return this.calibre;
    }

    /**
     * Retorna a escala de maciez do grafite.
     */
    public String getDureza(){
        return this.dureza;
    }

    /**
     * Retorna uma string com todas as informações
     * relevantes desta instãncia.
     */
    public String toString(){
        return String.format("[%.1f:%s:%d]", this.calibre, this.dureza, this.tamanho);
    }

    /**
     * Clona a instância, gerando um novo objeto com o
     * mesmo estado desta.
     */
    public Grafite clone(){
        return new Grafite(this.calibre, this.dureza, this.tamanho);
    }
}
