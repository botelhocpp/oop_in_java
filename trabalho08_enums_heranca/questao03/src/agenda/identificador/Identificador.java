package agenda.identificador;

/**
 * Modela os tipos de identificadores para
 * os telefones, introduzidos na classe Fone,
 * do pacote contact. Temos então 5 operadoras
 * e 4 identificadores genéricos.
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 11/12/2021
 * @see contact.Fone
 */
public enum Identificador {
    /**
     * Tipos de identificadores usados
     * pela classe Fone.
     */
    OI("oi"),
    TIM("tim"),
    CLARO("claro"),
    VIVO("vivo"),
    FIXO("fixo"),
    NEXTEL("nextel"),
    EMERGENCIAL("emergencial"),
    CASA("casa"),
    TRABALHO("trabalho");
    
    /**
     * "Nome" do identificador.
     */
    private String identificador;

    /**
     * Inicializa o identificador com o "nome" 
     * pre-estabelecido.
     * 
     * @param identificador "Nome" pre-estabelecido
     * nos identificadores do enum.
     */
    private Identificador(String identificador){
        this.identificador = identificador;
    }

    /**
     * Retorna o identificador em formato
     * de String.
     */
    @Override
    public String toString(){
        return identificador;
    }
}
