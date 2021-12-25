package agencia;

/**
 * Encapsula um tipo de operação, representada por uma
 * constante com um nome, da operação, encapsulado em
 * seu interior.
 * 
 * @author Pedro M. Botelho
 * @author Atílio G. Luiz
 * @see agencia.Conta
 * @see agencia.Financas
 * @see agencia.Operacao
 * @since 10/12/2021
 */
public enum Label {
    /**
     * Operações disponíveis, representadas por uma
     * "constante" e um valor a ser encapsulado.
     */
    SAQUE("saque"), 
    DEPOSITO("deposito"), 
    TARIFA("tarifa"), 
    EXTORNO("extorno"), 
    ABERTURA("abertura");
    
    /**
     * Nome da operação a ser realizada, encapsulada pelo
     * Enum.
     */
    private String name;

    /**
     * Inicializa a instância do Enum, utilizando o valor
     * constante referente a cada operação.
     * 
     * @param name Nome do operação a ser encpasulada.
     */
    private Label(String name) {
        this.name = name;
    }

    /**
     * Retorna o nome da operação encapsulada,
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retorna uma string contendo o nome da operação
     * encapsulada, sua principal, e única, informação.
     */
    @Override
    public String toString() {
        return this.name;
    }
}