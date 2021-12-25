package cinema;

/**
 * Modela um cliente que pode fazer reservas em
 * uma sala de cinema.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 02/12/2021
 * @see cinema.Sala
 */
public class Cliente {
    /**
     * Encapsula a identificação do cliente.
     */
    private String id;

    /**
     * Encapsula o telefone do cliente.
     */
    private String fone;

    /**
     * Inicializa um cliente com nome e número de telefone.
     * 
     * Se utiliza dos métodos setters, privados, como
     * indicado no diagrama de classes.
     * 
     * @param id Identificação do cliente.
     * @param fone Telefone do cliente.
     * @throws IllegalArgumentException Caso os paramêtros
     * sejam nulos ou tenham comprimento zero.
     */
    public Cliente(String id, String fone){
        this.setId(id);
        this.setFone(fone);
    }

    /**
     * Retorna a identificação encapsulada.
     */
    public String getId(){
        return this.id;
    }

    /**
     * Retorna o "número" de telefone encapsulado, como
     * uma String.
     */
    public String getFone(){
        return this.fone;
    }

    /**
     * Configura o campo de identificação do cliente. 
     * 
     * @param id Identificação do cliente.
     * @throws IllegalArgumentException Caso o paramêtro
     * seja nulo ou tenha comprimento zero.
     */
    private void setId(String id){
        if(id == null || id.length() == 0){
            throw new IllegalArgumentException("fail: identificação informada inválida.");
        }
        else{
            this.id = id;
        }
    }

    /**
     * Configura o campo de telefone do cliente. 
     * 
     * @param fone Telefone do cliente.
     * @throws IllegalArgumentException Caso o paramêtro
     * seja nulo ou tenha comprimento zero.
     */
    private void setFone(String fone){
        if(fone == null || fone.length() == 0){
            throw new IllegalArgumentException("fail: número de telefone informado inválido.");
        }
        else{
            this.fone = fone;
        }
    }

    /**
     * Devolve as principais informações da instância
     * no formado "id:fone".
     */
    public String toString(){
        return String.format("%s:%s", this.id, this.fone);
    }
}