package account;

import java.util.Objects;

/**
 * <p>
 * Modela uma conta de banco, que
 * pode ser utilizada por um cliente
 * em uma agência de banco.
 * </p>
 * 
 * <p>
 * Guarda um número de identificação,
 * um saldo e uma identificação por
 * extenso, como seu nome.
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 23/12/2021
 */
public abstract class Account {
    /**
     * Encapsula o número de identificação
     * da conta.
     */
    protected int id;

    /**
     * Encapsula o saldo da conta, que pode
     * inclusive ser negativo.
     */
    protected float balance;

    /**
     * Encapsula o nome do cliente.
     */
    protected String clientId;

    /**
     * Encpapsula o tipo da conta, que pode
     * ser conta corrente(CC) ou uma conta
     * poupança(CP).
     */
    protected String type;

    /**
     * <p>
     * Inicializa a conta com um ID e um
     * nome, caso sejam válidos.
     * </p>
     * 
     * @param id Número de identificação
     * do cliente.
     * @param clientId Nome do cliente.
     * @throws IllegalArgumentException
     * Caso o nome seja nulo ou de tamanho 0,
     * e o id seja negativo.
     */
    public Account(int id, String clientId) throws IllegalArgumentException {
        if(clientId == null || clientId.length() == 0){
            throw new IllegalArgumentException("fail: parâmetro para identificação inválido.");
        }
        else if(id < 0){
            throw new IllegalArgumentException("fail: número de ID inválido(negativo).");
        }
        else{
            this.clientId = clientId;
            this.id = id;
        }
    }

    /**
     * <p>
     * Atualiza a conta baseado no seu tipo.
     * </p>
     * 
     * <p>
     * Contas corrente vão receber uma tarifa
     * de 20 reais podendo inclusive ficar
     * negativas.
     * </p>
     * 
     * <p>
     * Contas poupança vão aumentar de 1
     * porcento.
     * </p>
     */
    public abstract void monthlyUpdate();

    /**
     * <p>
     * Saca o valor informado da conta,
     * caso tenha saldo suficiente. Caso
     * não é emitido uma mensagem de erro.
     * </p>
     * 
     * @param value Valor a ser sacado.
     * @throws AccountException Caso o valor
     * informado seja inválido, ou caso o
     * saldo seja insuficiente.
     */
    public void withdraw(float value) throws AccountException {
        if(value <= 0){
            throw new AccountException("fail: valor informado inválido.");
        }
        else{
            if(this.balance >= value){
                this.balance -= value;
            }
            else{
                throw new AccountException("fail: saldo insuficiente.");
            }
        }
    }

    /**
     * <p>
     * Deposita o valor informado na conta.
     * </p>
     * 
     * @param value Valor a ser sacado.
     * @throws AccountException Caso o valor
     * informado seja inválido.
     */
    public void deposit(float value) throws AccountException {
        if(value <= 0){
            throw new AccountException("fail: valor informado inválido.");
        }
        else{
            this.balance += value;
        }
    }

    /**
     * <p>
     * Transfere o valor informado da conta,
     * para a conta "other", caso tenha saldo
     * suficiente. Caso não é emitido uma
     * mensagem de erro.
     * </p>
     * 
     * @param other Conta a receber o valor.
     * @param value Valor a ser sacado.
     * @throws AccountException Caso o valor
     * informado seja inválido, ou caso o
     * saldo seja insuficiente.
     */
    public void transfer(Account other, float value) throws AccountException {
        if(value <= 0){
            throw new AccountException("fail: valor informado inválido.");
        }
        else{
            if(this.balance >= value){
                this.balance -= value;
                other.balance += value;
            }
            else{
                throw new AccountException("fail: saldo insuficiente.");
            }
        }
    }
    
    /**
     * Retorna o ID da conta.
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Retorna o saldo da conta.
     */
    public float getBalance(){
        return this.balance;
    }

    /**
     * Retorna o nome da conta.
     */
    public String getClientId(){
        return this.clientId;
    }

    /**
     * Retorna o tipo da conta.
     */
    public String getType(){
        return this.type;
    }

    /**
     * <p>
     * Devolve as principais informações 
     * da conta em formato de String, na
     * forma:
     * </p>
     * 
     * <p>
     * id:nome:saldo:tipo
     * </p>
     * 
     * <p>
     * Exemplo: 100:Pedro:400.00:CC
     * </p>
     * 
     */
    @Override
    public String toString(){
        return String.format("%d:%s:%.2f:%s", this.id, this.clientId, this.balance, this.type);
    }

    /**
     * Verifica se os dois objetos são
     * iguais.
     */
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(getClass() != other.getClass()){
            return false;
        }
        Account compareOther = (Account) other;

        return Objects.equals(this.clientId, compareOther.clientId)
        && Objects.equals(this.type, compareOther.type)
        && this.id == compareOther.id
        && this.balance == compareOther.balance;
    }

    /**
     * Deolve o hashCode associado à
     * conta.
     */
    @Override
    public int hashCode(){
        return Integer.valueOf(this.id).hashCode()
        + Double.valueOf(this.balance).hashCode()
        + this.clientId.hashCode();
    }
}
