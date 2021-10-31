package questao01.Conjuntos;

/**
 * A classe NumeroComplexo, da biblioteca Conjuntos, permite a
 * representação do conjunto dos números complexos por meio de
 * dois atributos, no formato: z = a + bi.
 * 
 * Os atributos estão protegidos, para evitar sua incorreta 
 * manipulação, devendo ser utilizados métodos para os acessar e 
 * modificar.
 * 
 *  * Os atributos só podem ser modificados no ato na inicialização,
 * por meio de um dos construtores, e obtidos por meio de métodos
 * getters, pelo método clone (indiretamente) e pelo método toString,
 * em forma de uma String formatada.
 * 
 * @author  Pedro M. Botelho
 * @version 1.0
 * @since   27/10/2021
 */

public class NumeroComplexo{
    /**
     * Representa a parte real do número complexo, a.
     */
    private double parteReal;

    /**
     * Representa a parte imaginária do número complexo, b.
     */
    private double parteImaginaria;

    /**
     * Inicializa o número complexo z no forma:
     * 
     * z = a + bi
     * 
     * Onde os elementos do número são encapsulados em duas variáveis
     * privadas, dentro da classe.
     * 
     * Caso a seja zero, z será um número imaginário puro.
     * 
     * Caso b seja zero, z será um número real.
     * 
     * @param parteReal A parte real do número complexo, a.
     * @param parteImaginaria A parte imaginária do número complexo, b.
     */
    public NumeroComplexo(double parteReal, double parteImaginaria){
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    /**
     * Imprime o número complexo na forma padrão, verificando se o
     * número se trata de um real, um imaginário puro ou um complexo
     * cheio.
     */
    public void imprimeNumero(){
        System.out.println(this); 
    }

    /**
     * Verifica se a instância atual é igual à outra instância da 
     * classe.
     * 
     * @param referencia Uma referência a um outro objeto da classe 
     * NumeroComplexo, o qual se deseja testar a igualdade.
     * @return "true" se a instância que invocou o método é igual
     * à instância passada como parâmetro, e "false" caso contrário.
     */
    public boolean ehIgual(NumeroComplexo referencia){
        return (this.parteReal == referencia.parteReal) && (this.parteImaginaria == referencia.parteImaginaria);
    }

    /**
     * Soma um outro objeto da classe a está instância atual.
     * 
     * Como o método não tem retorno, deve ser chamado a partir
     * de um dos operandos, passando o outro como parâmetro.
     * O resultado será salvo na instância que o invocou.
     * 
     * @param operando Uma referência a um outro objeto da classe 
     * NumeroComplexo, o qual se deseja somar à instância atual.
     */
    public void soma(NumeroComplexo operando){
        this.parteReal += operando.parteReal;
        this.parteImaginaria += operando.parteImaginaria;
    }

    /**
     * Subtrai um outro objeto da classe desta instância atual.
     * 
     * Como o método não tem retorno, deve ser chamado a partir
     * de um dos operandos, passando o outro como parâmetro.
     * O resultado será salvo na instância que o invocou.
     * 
     * @param operando Uma referência a um outro objeto da classe 
     * NumeroComplexo, o qual se deseja subtrair à instância atual.
     */
    public void subtrai(NumeroComplexo operando){
        this.parteReal -= operando.parteReal;
        this.parteImaginaria -= operando.parteImaginaria;
    }

    /**
     * Multiplica um outro objeto da classe a está instância atual.
     * 
     * Uma constante PARTE_REAL_TEMP foi usada para resguardar o valor
     * original de "parteReal", já que deve ser usado após sua modificação.
     * 
     * Como o método não tem retorno, deve ser chamado a partir
     * de um dos operandos, passando o outro como parâmetro.
     * O resultado será salvo na instância que o invocou.
     * 
     * @param operando Uma referência a um outro objeto da classe 
     * NumeroComplexo, o qual se deseja multiplicar à instância atual.
     */
    public void multiplica(NumeroComplexo operando){
        final double PARTE_REAL_TEMP = this.parteReal;
        this.parteReal = (this.parteReal)*(operando.parteReal) - (this.parteImaginaria)*(operando.parteImaginaria);
        this.parteImaginaria = (PARTE_REAL_TEMP)*(operando.parteImaginaria) + (this.parteImaginaria)*(operando.parteReal);
    }

    /**
     * Divide a instância atual por um outro objeto da classe.
     * 
     * São usadas duas constantes: um DENOMINADOR, que irá se repetir duas vezes,
     * que chama o método estático "pow" duas vezes, dessa forma, diminuindo
     * a quantidade de chamadas externas, e PARTE_REAL_TEMP, que guarda o valor
     * original de "parteReal", já que será modificado.
     * 
     * Como o método não tem retorno, deve ser chamado a partir
     * de um dos operandos, passando o outro como parâmetro.
     * O resultado será salvo na instância que o invocou.
     * 
     * @param operando Uma referência a um outro objeto da classe 
     * NumeroComplexo, o qual se deseja dividir a instância atual por.
     */
    public void divide(NumeroComplexo operando){
        final double DENOMINADOR = (Math.pow(operando.parteReal, 2) + Math.pow(operando.parteImaginaria, 2));
        final double PARTE_REAL_TEMP = this.parteReal;
        this.parteReal = ((this.parteReal)*(operando.parteReal) + (this.parteImaginaria)*(operando.parteImaginaria))/(DENOMINADOR);
        this.parteImaginaria = ((this.parteImaginaria)*(operando.parteReal) - (PARTE_REAL_TEMP)*(operando.parteImaginaria))/(DENOMINADOR);
    }

    /**
     * Método "getter", que encapsula a parte real do número complexo
     * e a retorna.
     * 
     * @return A parte real do número complexo, a.
     */
    public double getReal(){
        return this.parteReal;
    }

    /**
     * Método "getter", que encapsula a parte imaginária do número
     * complexo e a retorna.
     * 
     * @return A parte imaginária do número complexo, b.
     */
    public double getImaginaria(){
        return this.parteImaginaria;
    }

    /**
     * Retorna o número complexo na forma padrão, verificando se o
     * número se trata de um real, um imaginário puro ou um complexo
     * cheio, na forma de uma String.
     * 
     * Primeiro verifica-se se a parte imaginária é igual a zero, pois
     * se a parte real também for igual a zero, o modelo da impressão
     * será o mesmo que o de um número real: z = 0, logo, descartando
     * a necessidade de uma quarta condição.
     * 
     * Foram implementadas estruturas de seleção para que a impressão
     * condiza com os padrões matemáticos, como omitir o fator caso 
     * seja 1 e utilizar parênteses para não misturar sinais diferentes.
     * 
     * @return O número complexo na forma padrão.
     */
    public String toString(){
        if(this.parteImaginaria == 0){
            return Double.toString(this.parteReal); 
        }
        else if(this.parteReal == 0){
            if(this.parteImaginaria == 1){
                return "i";
            }      
            else{
                return this.parteImaginaria + "i";
            }
        }
        else{
            if(this.parteImaginaria == 1){
                return this.parteReal + " + " + "i";   
            }
            else if(this.parteImaginaria == -1){
                return this.parteReal + " - " + "i";   
            }
            else if(this.parteImaginaria < 0){
                return this.parteReal + " + (" + this.parteImaginaria + ")i";   
            }
            else{
                return this.parteReal + " + " + this.parteImaginaria + "i";   
            }
            
        }
    }

    /**
     * Cria uma cópia do objeto atual da classe. Irá basicamente realizar
     * a tarefa do operador new e do construtor, porém com os mesmos atributos
     * passados para a instância original.
     * 
     * @return Uma referência a uma instância da classe com a mesmo
     * estado da instância que invocou o método.
     */
    public NumeroComplexo clone(){
        NumeroComplexo copia = new NumeroComplexo(this.parteReal, this.parteImaginaria);
        return copia;
    }
}