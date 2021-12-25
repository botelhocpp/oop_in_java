package account;

/**
 * <p>
 * Modela uma conta poupança, que pode
 * ser utilizada em uma agência de banco. 
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @see account.Account
 * @since 23/12/2021
 */
public class SavingsAccount extends Account {
 
    /**
     * <p>
     * Inicializa uma conta com tipagem
     * "conta poupança".
     * </p>
     * 
     * @param id Número de identificação
     * do cliente.
     * @param idClient Nome do cliente.
     * @throws IllegalArgumentException
     * Caso o nome seja nulo ou de tamanho 0,
     * e o id seja negativo.
     */
    public SavingsAccount(int id, String idClient) throws IllegalArgumentException {
        super(id, idClient);
        this.type = "CP";
    }

    
    /**
     * <p>
     * Atualiza a conta, aumentando o saldo
     * em 1%.
     * </p>
     */
    public void monthlyUpdate(){
        this.balance *= 1.01;
    }
}
