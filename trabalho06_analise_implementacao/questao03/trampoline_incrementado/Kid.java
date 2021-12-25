package questao03.trampoline_incrementado;

/**
 * Representa uma criança, com nome e idade,
 * que pode brincar em um trampolim.
 *  
 * @see questao03.trampoline_incrementado.Kid  
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 25/11/2021
 */
public class Kid{
    /**
     * Encapsula a idade da criança.
     */
    private int age;

    /**
     * Encapsula o nome da criança.
     */
    private String name;

    /**
     * Saldo da criança no trampolim.
     */
    private float balance;

    /**
     * Inicializa a criança com os dados passados
     * como parâmetros, caso eles sejam válidos.
     * 
     * @param name O nome da criança.
     * @param age A idade da criança.
     * @throws IllegalArgumentException caso os valores 
     * passados de inicialização não sejam válidos.
     */
    public Kid(String name, int age){
        if(name == null || age < 0){
            throw new IllegalArgumentException("fail: valores inválidos.");
        }
        else{
            this.age = age;
            this.name = name;
        }
    }

    /**
     * Devolve a idade da criança.
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Devolve o nome da criança.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Devolve o saldo da criança.
     */
    public float getBalance(){
        return this.balance;
    }

    /**
     * Aumenta a dívida da criança no trampolim
     * em um valor "value", caso seja válido.
     * 
     * @param value Valor a ser acrescentado à
     * divida.
     */
    public void increaseBalance(float value){
        if(value < 0){
            throw new IllegalArgumentException("fail: valor a pagar inválido.");
        }
        else{
            this.balance += value;
        }
    }

    /**
     * Quita a dívida com o trapolim, zerando
     * "balance" e retornando seu valor.
     * 
     * @return A dívida no trampolim.
     */
    public float payDebt(){
        float aux = this.balance;
        this.balance = 0;
        return aux;
    }

    /**
     * Devolve as principais informações da
     * criança.
     */
    public String toString(){
        return String.format("%s:%d", this.name, this.age);
    }
}