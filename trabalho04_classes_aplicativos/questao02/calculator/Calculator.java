package calculator;

/**
 * Classe que modela uma calculadora que realiza operações
 * e tem uma bateria interna, utilizada nas operações.
 * 
 * Cada operação gasta 1 mA da bateria, que pode ser
 * recarregada pelo usuário.
 *
 * Todas as operações aritméticas envolvem números de ponto flutuante
 * com precisão de duas casas decimais. Ou seja, caso o valor absoluto
 * de algum resultado seja menor que 0.01 o valor é arrendondando para
 * zero.
 * 
 * Por exemplo, para uma operação de soma:
 * 
 * this.display = (Math.abs(a + b) < 0.01f) ? 0 : a + b;
 *
 * Como essa classe está muito maior que a proposta pelo professor
 * um diagrama UML foi criado para facilitar a vizualização. Ele
 * se encontra na pasta "trabalho04_classes_aplicativos/questao02/uml".
 * 
 * 31/10/2021 - Commit inicial. Estrutura proposta pelo professor.
 * 08/11/2021 - Funções requisitadas pelo professor.
 * 09/11/2021 - Funções adicionais: getters, funções matemáticas,
 * capacidade de operar com os valores em display e uma função
 * básica de gerenciamento de bateria. Operações englobam números de 
 * ponto flutuante. Dois setters foram adicionados, setPi e setEuler,
 * para realizar operações com os seus respectivos números. Esses valores
 * são atribuídos ao display.
 * 
 * Getters foram incluídos caso o usuário queira obter o
 * valor do display de forma numérica, ou caso o usuário
 * queria obter o valor numérico do nível de bateria e 
 * bateria máxima. Por exemplo pra criar um software de
 * manejo de bateria.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 09/11/2021
 */


public class Calculator {
    /**
     * Quantidade atual de bateria, em mA.
     */
    private int battery;

    /**
     * Representa a quantidade máxima de bateria, em mA.
     */
    private int batteryMax;

    /**
     * Indica qual o resultado da operação mais recente.
     */
    private float display;

    /**
     * Inicia os atributos, battery e display começam com
     * o zero.
     * 
     * A JVM já inicializa todos com zero automaticamente,
     * então não é necessário repetir a inicialização.
     * 
     * @param batteryMax Indica a quantidade máxima de bateria,
     * em miliampères.
     */
    public Calculator(int batteryMax){
        this.batteryMax = batteryMax;
    }

    /**
     * Aumenta a bateria, porém não além do máximo.
     * 
     * @param value O valor o qual será adicionado à bateria,
     * em miliampères.
     */
    public void chargeBattery(int value){
        this.battery += (this.battery + value > batteryMax) ? this.batteryMax - this.battery : value;
    }
    
    /**
     * Tenta gastar uma unidade da bateria e emite um erro
     * se não conseguir.
     * 
     * @return "true" caso seja possível gastar bateria,
     * e "false", caso não seja. É emitido, ainda, uma mensagem
     * de erro em caso de falha.
     */
    public boolean useBattery(){
        if(this.battery > 0){
            this.battery--;
            return true;
        }
        else{
            System.err.println("fail: bateria insuficiente");
            return false;
        }
    }
    
    /**
     * Se conseguir gastar bateria, armazene a soma no
     * atributo display.
     * 
     * Colocando um dos parâmetros negativos é possível
     * realizar uma subtração.
     * 
     * @param a Primeiro operando da soma.
     * @param b Segundo operando da soma.
     */
    public void sum(float a, float b){
        if(useBattery()){
            this.display = (Math.abs(a + b) < 0.01f) ? 0 : a + b;
        }
    }
    
    /**
     * Se conseguir gastar bateria, some o operando com o
     * valor de display e volte a armazenar a soma no
     * atributo display.
     * 
     * Colocando o parâmetro negativo é possível realizar
     * uma subtração.
     * 
     * @param a O operando a ser somado com display.
     */
    public void sum(float a){
        sum(this.display, a);
    }
    
    /**
     * Se conseguir gastar bateria, armazene a multiplicação
     * no atributo display.
     * 
     * @param a Primeiro operando da multiplicação.
     * @param b Segundo operando da multiplicação.
     */
    public void mul(float a, float b){
        if(useBattery()){
            this.display = (Math.abs(a * b) < 0.01f) ? 0 : a * b;
        }
    }
    
    /**
     * Se conseguir gastar bateria, multiplique o operando
     * com o valor de display e volte a armazenar no
     * atributo display.
     * 
     * @param a O operando a ser multiplicado por display.
     */
    public void mul(float a){
        mul(this.display, a);
    }

    /**
     * Se conseguir gastar bateria, e o denominador não for zero,
     * realize a divisão num/den e armazene em display.
     * 
     * @param num Numerador da divisão.
     * @param den Denominador da divisão.
     */
    public void division(float num, float den){
        if(useBattery() && den != 0){
            this.display = (Math.abs(num / den) < 0.01f) ? 0 : num / den;
        }
        else if(den == 0){
            System.err.println("fail: divisao por zero");
        }
    }

    /**
     * Se conseguir gastar bateria, e o denominador não for zero,
     * realize a divisão do valor em display pelo denominador.
     * 
     * @param den Denominador da divisão.
     */
    public void division(float den){
        division(this.display, den);
    }
    
    /**
     * Se conseguir gastar bateria realize a operação
     * de potência base^exp.
     * 
     * @param base Base da potência.
     * @param exp Expoente da potência.
     */
    public void pow(float base, float exp){
        if(useBattery()){
            this.display = (float) Math.pow(base, exp);
        }
    }
    
    /**
     * Se conseguir gastar bateria realize a operação
     * de potência do valor em display elevado a exp.
     * 
     * @param base Base da potência.
     * @param exp Expoente da potência.
     */
    public void pow(float exp){
        pow(this.display, exp);
    }

    /**
     * Obtém o valor resultante da função seno a partir de um
     * parâmetro a, e o salva em display.
     * 
     * @param a Operando da função seno, no domínio de x.
     */
    public void sen(float a){
        if(useBattery()){
            this.display = (Math.abs(Math.sin(a)) < 0.01f) ? 0 : (float) Math.sin(a);
        }
    }

    /**
     * Obtém o valor resultante da função seno a partir do valor
     * em display, e o salva em display.
     */
    public void sen(){
        sen(this.display);
    }

    /**
     * Obtém o valor resultante da função cosseno a partir de um
     * parâmetro a, e o salva em display.
     * 
     * @param a Operando da função cosseno, no domínio de x.
     */
    public void cos(float a){
        if(useBattery()){
            this.display = (Math.abs(Math.cos(a)) < 0.01f) ? 0 : (float) Math.cos(a);
        }
    }

    /**
     * Obtém o valor resultante da função cosseno a partir do valor
     * em display, e o salva em display.
     */
    public void cos(){
        cos(this.display);
    }

    /**
     * Obtém o valor resultante da função tangente a partir de um
     * parâmetro a, e o salva em display.
     * 
     * @param a Operando da função tangente, no domínio de x.
     */
    public void tg(float a){
        if(useBattery()){
            this.display = (Math.abs(Math.tan(a)) < 0.01f) ? 0 : (float) Math.tan(a);
        }
    }

    /**
     * Obtém o valor resultante da função tangente a partir do valor
     * em display, e o salva em display.
     */
    public void tg(){
        tg(this.display);
    }

    /**
     * Obtém o valor resultante da raiz quadrada a partir de um
     * parâmetro a, e o salva em display.
     * 
     * @param a Operando da raiz quadrada.
     */
    public void sqrt(float a){
        if(useBattery()){
            if(a >= 0){
                this.display = (float) Math.sqrt(a);
            }
            else{
                System.err.println("fail: raiz complexa");
            }
        }
    }

    /**
     * Obtém o valor resultante da raiz quadrada a partir do
     * valor em display, e o salva em display.
     */
    public void sqrt(){
        sqrt(this.display);
    }

    /**
     * Obtém o valor resultante do logarítmo na base 10 de um
     * parâmetro a, e o salva em display.
     * 
     * @param a Operando do logarítmo de base 10.
     */
    public void log(float a){
        if(useBattery()){
            if(a > 0){
                this.display = (float) Math.log10(a);
            }
            else{
                System.err.println("fail: logaritmando não deve ser zero ou negativo");
            }
        }
    }

    /**
     * Obtém o valor resultante do logarítmo na base 10 do
     * valor em display, e o salva em display.
     */
    public void log(){
        log(this.display);
    }

    /**
     * Obtém o valor resultante do logarítmo natural de um
     * parâmetro a, e o salva em display.
     * 
     * @param a Operando do logarítmo natural.
     */
    public void ln(float a){
        if(useBattery()){
            if(a > 0){
                this.display = (float) Math.log(a);
            }
            else{
                System.err.println("fail: logaritmando não deve ser zero ou negativo");
            }
        }
    }

     /**
     * Obtém o valor resultante do logarítmo natural do
     * valor em display, e o salva em display.
     */
    public void ln(){
        ln(this.display);
    }

    /**
     * Atribui o valor do número de euler ao display.
     */
    public void setEuler(){
        if(useBattery()){
            this.display = (float) Math.E;
        }
    }

    /**
     * Atribui o valor do número pi ao display.
     */
    public void setPi(){
        if(useBattery()){
            this.display = (float) Math.PI;
        }
    }

    /**
     * Devolve para o usuário o resultado da última operação.
     */
    public float getDisplay(){
        return this.display;
    }

    /**
     * Devolve para o usuário o nível de bateria da calculadora.
     */
    public int getBattery(){
        return this.battery;
    }

    /**
     * Devolve para o usuário a capacidade máxima da bateria da
     * calculadora.
     */
    public int getBatteryMax(){
        return this.batteryMax;
    }

    /**
     * Devolve ao usuário o estado da bateria, mostrando a relação
     * entre o nível atual e a capacidade máxima, bem como a
     * porcentagem de baterial atual.
     * 
     * @return Uma string contendo o estado da bateria.
     */
    public String batteryManager(){
        return String.format("%d/%d %d%%", this.battery, this.batteryMax, ((this.battery*100)/(this.batteryMax)));
    }

    /**
     * Devolve o conteúdo do display, com duas casas decimais,
     * assim como o estado da bateria
     */
    public String toString(){
        return String.format("display = %.2f, battery = %d mA", this.display, this.battery);
    }
}
