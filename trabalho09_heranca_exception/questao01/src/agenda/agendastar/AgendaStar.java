package agenda.agendastar;

import java.util.List;
import java.util.stream.Collectors;

import agenda.Agenda;
import contact.Contact;
import contact.contactstar.ContactStar;

/**
 * <p>
 * Modela uma agenda telefônica que pode ter vários
 * contatos, que por sua vez possuem vários telefones.
 * </p>
 * 
 * <p>
 * Essa agenda pode ter contatos que aceitam "estrelas",
 * ou seja, é possível favoritar contatos!
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 20/12/2021
 * @see agenda.Agenda
 * @see contact.contactstar.ContatoStar
 */
public class AgendaStar extends Agenda {
    
    /**
     * <p>
     * Constroi uma agenda que aceita contatos favoritos.
     * </p>
     * 
     * <p>
     * Esse método foi apenas incluido aqui para manter
     * a estrutura visual, já que o construtor da super-
     * classe seria chamado de maneira implícita.
     * </p>
     */
    public AgendaStar(){
        super();
    }

    /**
     * <p>
     * Altera o atributo "star" de um contato, caso
     * ele exista e seja do tipo ContatoStar.
     * </p>
     * 
     * @param name Nome do contato a ser favoritado.
     * @param value Caso seja "true" o contato será
     * favoritado i.e. receberá uma estrela. Caso
     * seja "false" o contato será desfavoritado,
     * perdendo sua estrela caso tenha.
     */
    public void star(String name, boolean value){
        Contact verify = this.findContact(name);
        if(verify instanceof ContactStar){
            ((ContactStar) verify).setStar(value);
        }
    }
    
    /**
     * <p>
     * Filtra em uma nova lista apenas os contatos
     * que forem do tipo ContatoStar e que estão
     * favoritados.
     * </p>
     * 
     * @return Uma lista mutável de contatos
     * favoritados.
     */
    public List<Contact> getStarred(){
        return this.getContacts().stream()
        .filter(contact -> (contact instanceof ContactStar) && ((ContactStar) contact).getStar())
        .collect(Collectors.toList());
    }
}
