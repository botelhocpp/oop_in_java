package agency;

import java.util.Map;
import java.util.TreeMap;

import account.Account;
import account.AccountException;
import account.CheckingAccount;
import account.SavingsAccount;
import client.Client;

/**
 * <p>
 * Modela uma agência de banco que mantém
 * vários clientes e suas respectivas contas.
 * Cada cliente tem uma conta corrente
 * (CC) e uma conta poupança (CP).
 * </p>
 * 
 * <p>
 * Os clientes e as contas são guardados
 * em Maps, de forma que possamos ter
 * estruturas chave/valor. São utilizados
 * TreeMaps para termos uma ordenação
 * baseada na ordem inserção.
 * </p>
 * 
 * <p>
 * O métodos lançam a exceção AccountException
 * quando ocorre alguma situação excepcional.
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 23/12/2021
 * @see client.Client
 * @see account.Account
 * @see account.CheckingAccount
 * @see account.SavingsAccount
 * @see account.AccountException
 */
public class BankAgency {
    /**
     * <p>
     * Encapsula os clientes em uma estrutura
     * chave-valor, onde os elementos são
     * salvos em tuplas <Nome, DadosCliente>.
     * </p>
     */
    private Map<String, Client> clients;

    /**
     * <p>
     * Encapsula as contas em uma estrutura
     * chave-valor, onde os elementos são
     * salvos em tuplas <ID, DadosConta>.
     * </p>
     */
    private Map<Integer, Account> accounts;

    /**
     * <p>
     * Encapsula o ID da próxima conta [a ser
     * criada], incrementado a cada conta criada.
     * </p>
     */
    private int nextAccountId;

    /**
     * <p>
     * Inicializa a agência de banco. Para isso
     * inicializa as duas estruturas chave-valor
     * como TreeMaps. Dessa forma teremos uma
     * estrutura de ordenação baseada em uma
     * árvore, que é mais confiável que tabela
     * hash.
     * </p>
     * 
     * <p>
     * Essa estrutura preserva a ordem natural das
     * chaves. Sendo as chaves do campo "clients"
     * Strings então a ordem será baseda na ordem
     * alfabética. Já o campo "accounts" tem chaves 
     * de números inteiros que representam o ID das
     * contas, logo a ordenação será do menor para o 
     * maior, dispondo as contas da mais velha pra
     * mais nova. 
     * </p>
     */
    public BankAgency() {
        this.clients = new TreeMap<String, Client>();
        this.accounts = new TreeMap<Integer, Account>();
    }

    /**
     * <p>
     * Obtém uma conta com identificador "id"
     * ou lança uma exceção.
     * </p>
     * 
     * @param id Identificador da conta.
     * @return A conta de identificador "id",
     * caso exista.
     * @throws AccountException Caso não exista
     * uma conta com o identificador informado.
     */
    private Account getAccount(int id) throws AccountException {
        Account account = this.accounts.get(id);
        if (account == null) {
            throw new AccountException("fail: conta não encontrada.");
        }
        else {
            return account;
        }
    }

    /**
     * <p>
     * Adiciona um cliente às estruturas da agência.
     * Se o cliente não existir o cliente é criado,
     * e para ele é atribuído duas contas, uma CC e
     * uma CP, respectivamente. Essas contas são
     * adicionadas nos vetores do cliente e da
     * agência e o cliente, ao final, é adicionado
     * ao mapa de clientes..
     * </p>
     * 
     * @param clientId Identificação (Nome) do
     * cliente.
     */
    public void addClient(String clientId) {
        if (!this.clients.containsKey(clientId)) {
            try{
                // Cria o cliente.
                Client client = new Client(clientId);

                // Cria uma CC.
                this.accounts.put(this.nextAccountId, new CheckingAccount(this.nextAccountId, clientId));
                client.addAccount(this.accounts.get(this.nextAccountId++));
    
                // Cria uma CP.
                this.accounts.put(this.nextAccountId, new SavingsAccount(this.nextAccountId, clientId));
                client.addAccount(this.accounts.get(this.nextAccountId++));

                // Adiciona o cliente ao sistema.
                this.clients.put(clientId, client);
            }
            catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * <p>
     * Obtém o cliente com o identificador informado
     * e realiza o saque do valor caso o cliente
     * tenha saldo suficiente.
     * </p>
     * 
     * @param idConta Identificação do cliente.
     * @param value Valor a ser sacado.
     */
    public void withdraw(int idConta, float value) {
        try {
            this.getAccount(idConta).withdraw(value);
        }
        catch (AccountException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * <p>
     * Obtém o cliente com o identificador informado
     * e realiza o deposito do valor.
     * </p>
     * 
     * @param idConta Identificação do cliente.
     * @param value Valor a ser sacado.
     */
    public void deposit(int idConta, float value) {
        try {
            this.getAccount(idConta).deposit(value);
        }
        catch (AccountException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * <p>
     * Obtém o cliente remetente, e destinatario,
     * com os identificadores informados e realiza
     * a transferência do valor pedido.
     * </p>
     * 
     * @param contaDe Identificação do cliente
     * remetente.
     * @param contaPara Identificação do cliente
     * destinatario.
     * @param value Valor a ser transferido.
     */
    public void transfer(int contaDe, int contaPara, float value) {
        try {
            this.getAccount(contaDe).transfer(this.getAccount(contaPara), value);
        }
        catch (AccountException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * <p>
     * Atualiza todas as contas do mapa de
     * acordo com sua regra, descrita no
     * método monthlyUpdate().
     * </p>
     */
    public void monthlyUpdate() {
        this.accounts.values().forEach(account -> account.monthlyUpdate());
    }

    /**
     * <p>
     * Retorna as principais informações da
     * agência de banco em uma String, ou
     * seja, os clientes e as contas, baseado
     * na ordem natural de suas chaves.
     * </p>
     * 
     * <p>
     * O método foi escrito usando StringBuilder,
     * pois é a forma mais compacta e fácil de
     * entender que conheço. Utilizei uma simples
     * expressão lambda dentro de um forEach para
     * realizar a construção da string, usando o
     * método append(). Isso substitui o for-each
     * regular de três linhas.
     * </p>
     * 
     * <p>
     * Uma versão desse método foi escrito
     * utilizando expressões Lambda, juntamente
     * com a API de Streams. Essa versão pode
     * ser encontrada no apêndice, na linha 260.
     * </p>
     */
    public String toString() {
        StringBuilder aux = new StringBuilder("Clients:\n");
        this.clients.values().forEach(client -> aux.append(client + "\n"));
        aux.append("Accounts:");
        this.accounts.values().forEach(account -> aux.append("\n" + account));
        return aux.toString();
    }
}


/*
APÊNDICE:

Forma funcional do método toString(), usando Streams:

return "Clients:\n" + this.clients.values().stream()                            //Primeira lista: Clientes.
.map(client -> client.toString())                                               //Obtém a string de cada cliente.
.reduce("", (clientStr, client) -> clientStr + client.toString() + "\n")        //Constroi uma única string com todos os clientes.
+ "Accounts:" + this.accounts.values().stream()                                 //Segunda lista: Contas.
.map(account -> account.toString())                                             //Obtém a string de cada conta.
.reduce("", (accountStr, account) -> accountStr + "\n" + account.toString());   //Constroi uma única string com todas as contas.
*/
