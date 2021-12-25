package account;

/**
 * <p>
 * Excessão lançada em situações de erros
 * relacionados à contas na classe BankAgency.
 * </p>
 * 
 * <p>
 * Essa exceção é uma subclasse de RuntimeException,
 * ou seja, seu tratamento ou sinalização não é
 * fundamental para a execução do programa.
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 223/12/2021
 * @see agency.BankAgency
 */
public class AccountException extends RuntimeException {

    /**
     * <p>
     * Dispara a exceção, enviando a mensagem
     * "message".
     * </p>
     * 
     * @param message Mensagem de erro.
     */
    public AccountException(String message) {
        super(message);
    }

}