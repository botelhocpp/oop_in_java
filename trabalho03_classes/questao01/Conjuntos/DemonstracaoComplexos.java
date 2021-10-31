package questao01.Conjuntos;

/**
 * A classe DemonstracaoComplexos da biblioteca Conjuntos nos permite
 * testar e verificar os métodos e atributos da classe NumeroComplexo.
 * 
 * Para as operações, já explicadas anteriormente, foram dadas
 * mais explicações abaixo. 
 * 
 * @author  Pedro M. Botelho
 * @version 1.0
 * @since   27/10/2021
 */

public class DemonstracaoComplexos {
    public static void main(String[] args){
        /**
         * Ao criar um novo objeto usando o operador "new", é retornado uma referência ao dito cujo.
         * É invocado automaticamente o construtor, que irá realizar as ações mais imediatas, como
         * inicializar atributos. Essas ações devem ser feitas antes de qualquer coisa.
         * 
         * O construtor, então, foi criado como uma forma de substituir uma função de inicialização
         * que pode ser esquecida de ser chamada, mantendo a integridade da classe.
         * 
         * O construtor em questão recebe dois parâmetros double para inicializar os dois atributos
         * privados, parteReal e parteImaginária, respectivamente. 
         * 
         * No caso, "naoTaoComplexo" será inicializado com "parteReal = 2" e "parteImaginaria = 3".
         */
        NumeroComplexo naoTaoComplexo = new NumeroComplexo(2, 3);
        System.out.println("Primeiro número complexo!");

        /**
         * Aqui imprimimos o conteúdo de "naoTaoComplexo". É implementado de maneira semelhante à:
         * System.out.println(naoTaoComplexo) ou System.out.println(naoTaoComplexo.toString()), onde
         * o método "toString" tem subsídios para imprimir o número no formato padrão, colocando
         * parênteses quando a parte imaginária é negativa, ou omitindo-a quando for 1.
         * 
         * O método toString foi criado para incrementar o reúso de código e para padronizar a classe.
         */
        naoTaoComplexo.imprimeNumero();

        /**
         * Aqui são usados os métodos "getters" e "setters" para imprimir partes individuais do número.
         * 
         * Foram criados para que partes individuais possam ser vizualizadas individualmente, facilitando
         * o uso do número complexo.
         */
        System.out.println("Parte real: " + naoTaoComplexo.getReal() + "\nParte imaginária: " + naoTaoComplexo.getImaginaria() + "\n");

        NumeroComplexo moduloUnitario = new NumeroComplexo(0, 1);
        System.out.println("Segundo número complexo!");
        moduloUnitario.imprimeNumero();
        System.out.println("Parte real: " + moduloUnitario.getReal() + "\nParte imaginária: " + moduloUnitario.getImaginaria() + "\n");

        /**
         * É usado o operador ternário para escolher uma string baseado na igualdade entre os dois números
         * complexos: "moduloUnitario" e "naoTaoComplexo", verificada pelo método ehIgual. Caso sejam iguais,
         * ou seja, seus dois atributos sejam iguais, a string "Sim" será selecionada.
         */
        String igualdade = (moduloUnitario.ehIgual(naoTaoComplexo)) ? "Sim!" : "Não";
        System.out.println("Os dois numeros complexos: '" +  naoTaoComplexo  + "' e '" + moduloUnitario + "' são iguais?\nResposta: " + igualdade + "\n");

        /**
         * O método clone irá retornar um objeto com o mesmo estado do que o chamou.
         * Basicamente irá criar um novo objeto da classe, atribuir aos seus atributos 
         * os mesmos valores atribuídos ao objeto original e retornar sua referência.  
         */
        NumeroComplexo normaUnitaria = moduloUnitario.clone();
        System.out.println("Terceiro número complexo!");
        normaUnitaria.imprimeNumero();

        igualdade = (normaUnitaria.ehIgual(moduloUnitario)) ? "Sim!" : "Não";
        System.out.println("É uma cópia do segundo número complexo?\nResposta: " + igualdade + "\n");

        /**
         * Abaixo serão usadas as quatro operações básicas com números complexos.
         * Foram implementas de forma que os retornos sejam void, devendo um operando
         * chamar o método, passando o outro operando como parâmetro.
         */

        System.out.println("As quatro operações!\n");

        System.out.print("(" + normaUnitaria + ") + (" + moduloUnitario + ") = (");
        normaUnitaria.soma(moduloUnitario);
        System.out.println(normaUnitaria + ")");

        System.out.print("(" + normaUnitaria + ") - (" + moduloUnitario + ") = (");
        normaUnitaria.subtrai(moduloUnitario);
        System.out.println(normaUnitaria + ")");

        System.out.print("(" + naoTaoComplexo + ") x (" + normaUnitaria + ") = (");
        naoTaoComplexo.multiplica(normaUnitaria);
        System.out.println(naoTaoComplexo + ")");

        System.out.print("(" + naoTaoComplexo + ") / (" + normaUnitaria + ") = (");
        naoTaoComplexo.divide(normaUnitaria);
        System.out.println(naoTaoComplexo + ")");
    }
}