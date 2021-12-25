package agencia;

/**
 * Modela uma conta de um banco que pode
 * realizar transações financeiras em uma
 * agência.
 * 
 * @author Pedro M. Botelho
 * @author Atílio G. Luiz
 * @see agencia.Conta
 * @see agencia.Operacao
 * @see agencia.Label
 * @since 10/12/2021
 */
public class Conta {
    /**
     * Encapsula o número da conta.
     */
    private int id;

    /**
     * Encapsula um tratador de finanças da conta.
     */
    private Financas financas;

    /**
     * Inicializa a conta com um número passado, atribuindo
     * a ela um tratador das finanças e adicionando a lista a
     * primeira operação, a de abertura.
     * 
     * @param id Número da conta.
     */
    public Conta(int id){
        if(id < 0){
            throw new IllegalArgumentException("fail: id inválido.");
        }
        else{
            this.id = id;
            this.financas = new Financas();
            this.financas.addOperacao(Label.ABERTURA, 0);
        }
    }
    
    /**
     * Realiza um saque de valor "value", da conta, caso
     * value seja válido e haja dinheiro suficiente
     * na conta.
     * 
     * @param value Valor a ser sacado.
     * @return "true" se a operação for verdadeira e
     * "false" caso contrário.
     */
    public boolean sacar(int value){
        if(value <= 0){
            System.err.println("fail: valor inválido.");
            return false;
        }
        else{
            if(this.financas.getSaldo() >= value){
                this.financas.addOperacao(Label.SAQUE, -value);
                return true;
            }
            else{
                System.err.println("fail: saldo insuficiente.");
                return false;
            }
        }
    }

    /**
     * Retira dinheiro da conta, mesmo que o saldo fique
     * negativo, verificando antes a validade do valor
     * passado.
     * 
     * @param value Valor a ser movimentado.
     * @return "true" caso a operação seja bem sucedida,
     * e "false" caso contrário.
     */
    public boolean tarifar(int value){
        if(value <= 0){
            System.err.println("fail: valor inválido.");
            return false;
        }
        else{
            this.financas.addOperacao(Label.TARIFA, -value);
            return true;
        }
    }  

    /**
     * Se o índice for válido e representar uma operação
     * de tarifa, adicione o mesmo valor tarifado, mas com
     * label de extorno.
     * 
     * O "-" é pra converter o número negativo em positivo.
     * 
     * @param indice Índice da operação a ser extornada.
     * @return "true" caso a operação seja bem sucedida,
     * e "false" caso contrário.
     */
    public boolean extornar(int indice){
        if(indice < 0 || this.financas.getExtrato().size() <= indice){
            System.err.println("fail: indice " + indice + " inválido.");
            return false;
        }
        else if(this.financas.getExtrato().get(indice).getLabel().equals(Label.TARIFA)){
            this.financas.addOperacao(Label.EXTORNO, -this.financas.getExtrato().get(indice).getValue());
            return true;
        }
        else{
            System.err.println("fail: indice " + indice + " não é tarifa.");
            return false;
        }
    }

    /**
     * Adiciona valor a conta, caso seja válido.
     * 
     * @param label Tipo de operação a ser realizada.
     * @param value Valor a ser movimentado.
     * @return "true" caso a operação seja bem sucedida,
     * e "false" caso contrário.
     */
    public boolean creditar(Label label, int value){
        if(value <= 0){
            System.err.println("fail: valor inválido.");
            return false;
        }
        else{
            this.financas.addOperacao(label, value);
            return true;
        }
    }
    
    /**
     * Retorna o ID da conta.
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Retorna o tratador das finanças desta instância.
     */
    public Financas getFinancas(){
        return this.financas;
    }

    /**
     * Retorna as informações do objeto em forma de uma
     * String formatada como segue:
     * 
     * conta:XX saldo:XX
     */
    @Override
    public String toString(){
        return String.format("conta:%d saldo:%d", this.id, this.financas.getSaldo());
    }
}