package agencia;

import java.util.ArrayList;
import java.util.List;

/**
 * Trata das operações financeiras entre as classes
 * Conta e Operacao, agindo como um mediador.
 * 
 * Adiciona as operações requisitadas a uma
 * lista de extrato, assim como guarda o saldo
 * da conta, ou seja, é a parte financeira da
 * aplicação, como diz o nome.
 * 
 * @author Pedro M. Botelho
 * @author Atílio G. Luiz
 * @see agencia.Conta
 * @see agencia.Operacao
 * @see agencia.Label
 * @since 10/12/2021
 */
public class Financas {
    /**
     * Encapsula o ID da próxima operação dessa conta.
     */
    private int nextId;
    
    /**
     * Encapsula a lista de operações realizadas pela conta.
     */
    private List<Operacao> extrato;

    /**
     * Encapsula a quantidade de dinheiro atual na conta.
     */
    private int saldo;

    /**
     * Inicializa a lista de operações i.e. extrato, para
     * controle de movimentações na conta.
     */
    public Financas(){
        this.extrato = new ArrayList<Operacao>();
    }
    
    /**
     * Adiciona uma operação requerida ao extrato, assim como
     * adiciona "value" ao saldo. Atributo nextId é incrementado.
     * 
     * @param label Tipo da operação realizada.
     * @param value Valor da operação.
     */
    public void addOperacao(Label label, int value){
        this.saldo += value; 
        this.extrato.add(new Operacao(nextId++, label, value, this.saldo));
    }

    /**
     * Retorna o saldo atual da conta.
     */
    public int getSaldo(){
        return this.saldo;
    }

    /**
     * Retorna a lista de operações da conta i.e. extrato.
     */
    public List<Operacao> getExtrato(){
        return this.extrato;
    }

    /**
     * Retorna os "qtdOp" últimos ítens da lista de operações
     * i.e. extrato, caso o valor passado seja válido.
     * 
     * @param qtdOp Quantidade de ítens a serem retornados, do
     * final para o começo da lista.
     * @return Uma lista com os ítens selecionados.
     */
    public List<Operacao> getExtrato(int qtdOp){
        if(qtdOp >= this.extrato.size() || qtdOp <= 0){
            System.err.println("fail: quantidade inválida.");
            return null;
        }
        List<Operacao> extratoSeletivo = new ArrayList<Operacao>();
        for(int i = this.extrato.size() - qtdOp; i < this.extrato.size(); i++){
            extratoSeletivo.add(this.extrato.get(i));
        }
        return extratoSeletivo;
    }
}