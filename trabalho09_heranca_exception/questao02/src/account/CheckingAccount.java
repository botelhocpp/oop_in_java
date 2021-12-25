package account;

/**
 * <p>
 * Modela uma conta corrente, que pode
 * ser utilizada em uma agência de banco. 
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @see account.Account
 * @since 23/12/2021
 */
public class CheckingAccount extends Account {

    /**
     * <p>
     * Inicializa uma conta com tipagem
     * "conta corrente".
     * </p>
     * 
     * @param id Número de identificação
     * do cliente.
     * @param idClient Nome do cliente.
     * @throws IllegalArgumentException
     * Caso o nome seja nulo ou de tamanho 0,
     * e o id seja negativo.
     */
    public CheckingAccount(int id, String idClient) throws IllegalArgumentException {
        super(id, idClient);
        this.type = "CC";
    }

    /**
     * <p>
     * Atualiza a conta, aplicando uma tarifa
     * de 20 reais podendo o saldo ficar
     * negativo.
     * </p>
     */
    public void monthlyUpdate(){
        this.balance -= 20;
    }
}