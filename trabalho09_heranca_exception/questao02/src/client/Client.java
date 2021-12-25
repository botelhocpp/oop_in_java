package client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import account.Account;

/**
 * <p>
 * Modela um cliente de uma agência
 * de banco. O cliente pode ter várias
 * contas.
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @see account.Account
 * @since 23/12/2021
 */
public class Client {
    /**
     * Encapsula a identificação por extenso 
     * do cliente, como um nome.
     */
    private String clientId;

    /**
     * Encapsula as contas do cliente.
     */
    private List<Account> accounts;

    /**
     * Inicializa o cliente, configurando
     * a identificação e inicializa uma
     * lista de contas.
     * 
     * @param clientId identificação por extenso 
     * do cliente
     * @throws IllegalArgumentException Caso a
     * identificação seja nula ou de tamanho 0.
     */
    public Client(String clientId) throws IllegalArgumentException{
        this.setClientId(clientId);
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Adiciona uma conta na lista de contas
     * da instância.
     * 
     * @param account Conta a ser adicionada.
     * @throws NullPointerException Caso a conta
     * informada seja nula.
     */
    public void addAccount(Account account) throws NullPointerException {
        if(account == null){
            throw new NullPointerException("fail: parâmetro aponta para nulo.");
        }
        else{
            this.accounts.add(account); 
        }
    }

    /**
     * <p>
     * Mostra as principais informações do
     * cliente, no molde - Nome [id1, ..., idn]
     * </p>
     * 
     * <p>
     * Foi utilizado uma stream de dados para
     * mapear apenas os IDs guardados na lista
     * de contas.
     * </p>
     */
    public String toString(){
        return "- " + this.clientId + " "
        + this.accounts.stream().map(account -> account.getId())
        .collect(Collectors.toList()).toString();
    }

    /**
     * Retorna a identificação por extenso 
     * do cliente
     */
    public String getClientId(){
        return this.clientId;
    }

    /**
     * Configura a identificação do cliente.
     * 
     * @param clientId Identificação por extenso
     * do cliente.
     * @throws IllegalArgumentException Caso a
     * identificação seja nula ou de tamanho 0.
     */
    private void setClientId(String clientId) throws IllegalArgumentException {
        if(clientId == null || clientId.length() == 0){
            throw new IllegalArgumentException("fail: parâmetro para identificação inválido.");
        }
        else{
            this.clientId = clientId;
        }
    }

    /**
     * Retorna uma lista com as contas
     * do cliente
     */
    public List<Account> getAccounts(){
        return this.getAccounts();
    }

    /**
     * Atribui a lista de contas informadas na
     * instância, substituindo as contas originais.
     * 
     * @param accounts Lista de contas a serem
     * atribuídas na instância.
     * @throws NullPointerException Caso a lista de
     * contas informada seja nula.
     */
    public void setAccounts(List<Account> accounts) throws NullPointerException {
        if(accounts == null){
            throw new NullPointerException("fail: parâmetro aponta para nulo.");
        }
        else{
            this.accounts = accounts;
        }
    }
}
