package contact;

import agenda.identificador.Identificador;

/**
 * Modela um número de telefone, com um indentificador,
 * para ser adicionado a uma agenda telefônica.
 * 
 * 05/12/2021 - Implementação dos métodos.
 * 11/12/2021 - Atributo "id" passa a ser do tipo
 * "Identificador", do pacote agenda.identificador.
 * Método setId() foi modificado para atender à necessidade
 * e método validaId() foi adicionado para validar
 * o ID fornecido.
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 11/12/2021
 * @see contact.Contact
 * @see agenda.identificador.Identificador
 */
public class Fone {
    /**
     * Identificação do número de telefone.
     */
    private Identificador id;

    /**
     * Número de telefone propriamente dito.
     */
    private String number;

    /**
     * Inicializa o número de telefone, usando
     * os métodos setters especificados no
     * diagrama fornecido.
     * 
     * @param id Identificação do número de telefone.
     * @param number Número de telefone propriamente
     * dito.
     * @throws IllegalArgumentException caso o parâmetros
     * sejam inválidos, na ordem da passagem.
     */
    public Fone(String id, String number){
        this.setId(id);
        this.setNumber(number);
    }

    /**
     * Verifica se o número indicado é válido,
     * ou seja, se contém apenas os caractéres
     * de '0' a '9', '(', ')' e '.'.
     * 
     * @param number Número de telefone propriamente
     * dito.
     * @return "true" se o número for válido, ou
     * "false" caso contrário.
     */
    public static boolean validate(String number){
        for(int i = 0; i < number.length(); i++){
            if((number.charAt(i) != '.' && number.charAt(i) != ')' && number.charAt(i) != '(') && (number.charAt(i) > '9' || number.charAt(i) < '0')){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Devolve a identificação do número de
     * telefone.
     */
    public String getId(){
        return this.id.toString();
    }
    
    /**
     * Configura a identificação do número de telefone
     * com a String indicada, caso seja válida.
     * 
     * @param id Identificação do Número de telefone.
     * @throws IllegalArgumentException caso o identificador
     * seja inválido, do ponto de vista semântico e sintático.
     */
    private void setId(String id){
        if(id.length() == 0 || id == null){
            throw new IllegalArgumentException("fail: id inválido (inexistente ou vazio).");
        }
        else{
            if(!validaId(id.toLowerCase())){
                throw new IllegalArgumentException("fail: id inválido, não pertence às categorias aceitas.");
            }
            else{
                this.id = Identificador.valueOf(id.toUpperCase());
            }
        }
    }
    
    /**
     * Devolve o número de telefone.
     */
    public String getNumber(){
        return this.number;
    }
    
    /**
     * Configura o número de telefone com a String
     * indicada, caso seja válida.
     * 
     * A verificação usando validate() poderia ser usada
     * aqui, mas para manter a estrutura proposta foi
     * removida.
     * 
     * @param number Número de telefone propriamente
     * dito.
     * @throws IllegalArgumentException caso o número
     * seja inválido, do ponto de vista semantico.
     */
    private void setNumber(String number){
        if(number.length() == 0 || number == null){
            throw new IllegalArgumentException("fail: invalid number.");
        }
        else{
            this.number = number;
        }
    }

    /**
     * Valida o ID do telefone, baseando-se nos
     * identificadores do enum. Caso o ID informado
     * esteja entre os identificadores pre-estebelecidos
     * então ele é válido. Caso contrário é inválido.
     * 
     * @param id Identificador do número de telefone.
     * @return "true" caso o identificador seja válido,
     * ou "false" caso contrário.
     */
    private boolean validaId(String id){
        for(Identificador identificador : Identificador.values()){
            if(identificador.toString().equals(id)){
                return true;
            }
        }
        return false;
    }

    /**
     * Configura uma String com as informações
     * do número de telefone.
     */
    @Override
    public String toString(){
        return String.format("%s:%s", this.id, this.number);
    }
}
