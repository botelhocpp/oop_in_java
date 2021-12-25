package agencia;

/**
 * Encapsula uma operação realizada em uma agência. Se
 * utiliza de um tipo, proveniente do enum Label, de
 * um índice, no extrato, de um valor requisitado para
 * a operação e de um saldo restante. 
 * 
 * @author Pedro M. Botelho
 * @author Atílio G. Luiz
 * @see agencia.Conta
 * @see agencia.Financas
 * @see agencia.Label
 * @since 10/12/2021
 */
public class Operacao {
    /**
     * Encapsula o índice da operação, baseado na ordem de
     * realização.
     * Usado aqui para facilitar o método toString()
     */
    private int indice;

    /**
     * Encapsula o tipo de operação realizada.
     */    
    private Label label;
    
    /**
     * Encapsula o valor requisitado para a operação.
     * Caso haja debito o valor será negativo.
     */    
    private int value;
    
    /**
     * O saldo residual após ser realizada a operação.
     */    
    private int saldo;
    
    /**
     * Inicializa a operação com os valores requisitados.
     * 
     * @param indice Índice da operação, baseado na ordem
     * de realização da operação.
     * @param label Tipo da operação realizada.
     * @param value Valor requisitado para a operação.
     * @param saldo Valor residual apos a realização.
     */  
    public Operacao(int indice, Label label, int value, int saldo) {
        this.indice = indice;
        this.label = label;
        this.value = value; 
        this.saldo = saldo;
    }

    /**
     * Faz o preenchimento da string com espaços em branco
     * até completar o length, de forma semelhante às
     * "caixas" do método printf() do pacote System.out.
     * 
     * @param string A string a ser formatada.
     * @param length o tamanho da "caixa".
     * @return A string formatada.
     */   
    public static String pad(String string, int length) {
        return String.format("%1$" + length+ "s", string);
    }
    
    /**
     * Retorna o índice da operação.
     */    
    public int getIndice() {
        return this.indice;
    }
    
    /**
     * Retorna o tipo da operação.
     */    
    public Label getLabel() {
        return this.label;
    }
    
    /**
     * Retorna o valor requisitado para a operação.
     */    
    public int getValue() {
        return this.value;
    }
    
    /**
     * Retorna o saldo residual após a operação.
     */    
    public int getSaldo() {
        return this.saldo;
    }
    
    /**
     * Retorna as informações da operação em um formato onde
     * cada linha tem um número máximo de caracteres, de forma
     * que os espaços vazios são preenchidos com espaços.
     */  
    @Override  
    public String toString() {
        return pad("" + this.indice, 2) + ":" + pad("" + this.label, 9) + ":" + pad("" + this.value, 5) + ":" + pad("" + this.saldo, 5); 
    }
}