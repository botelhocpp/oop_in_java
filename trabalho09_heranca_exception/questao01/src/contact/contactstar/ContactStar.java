package contact.contactstar;

import java.util.List;

import contact.Contact;
import contact.Fone;

/**
 * <p>
 * Modela um contato que pode receber uma estrela, ou
 * seja, ser favoritado.
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 20/12/2021
 * @see agenda.agendastar.AgendaStar
 * @see contact.Contato
 */
public class ContactStar extends Contact {
    
    /**
     * <p>
     * Indicador da estrela do contato. Caso
     * seja "true" é porque o contato foi
     * marcado como favorito. 
     * </p>
     */
    private boolean star;

    /**
     * <p>
     * Inicializa o contato, configurando a
     * estrela de favorito.
     * </p> 
     * 
     * @param name Nome do contato.
     * @param fones Lista de telefones do
     * contato.
     * @param star Indicador da estrela do
     * contato. Caso seja "true" é porque o
     * contato foi marcado como favorito. 
     */
    public ContactStar(String name, List<Fone> fones, boolean star){
        super(name, fones);
        this.setStar(star);
    }
   
    /**
     * <p>
     * Configura o valor do indicador da
     * estrela, assim como o prefixo.
     * Caso o contato tenha sido favoritado
     * o prefixo é trocado de '-' para '@'.
     * </p>
     * 
     * @param value Indicador da estrela do
     * contato. Caso seja "true" é porque o
     * contato foi marcado como favorito.  
     */
    public void setStar(boolean value){
        this.star = value;
        this.prefix = (value) ? "@" : "-";
    }
    
    /**
     * <p>
     * Retorna o indicador da estrela do
     * contato. Caso seja "true" é porque o
     * contato foi marcado como favorito.  
     * </p>
     */
    public boolean getStar(){
        return this.star;
    }
}
