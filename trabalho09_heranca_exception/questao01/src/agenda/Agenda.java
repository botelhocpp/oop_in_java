package agenda;

import java.util.ArrayList;
import java.util.List;

import contact.Contact;
import contact.Fone;

/**
 * Modela uma agenda telefônica que pode ter vários
 * contatos, que por sua vez possuem vários telefones.
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 10/12/2021
 * @see contact.Contato
 * @see contact.Fone
 */
public class Agenda {
    /**
     * Encapsula uma lista de contatos disponíveis na
     * agenda.
     */
    private List<Contact> contacts;

    /**
     * Inicializa a instância da agenda, inicializando 
     * a lista de contatos.
     */
    public Agenda(){
        this.contacts = new ArrayList<Contact>(); 
    }

    /**
     * Procura por um contato com nome "name" e o retorna.
     * Caso não exista é retornado null. O método findPosName()
     * é usado para procurar o índice do contato.
     * 
     * É verificado primeiro se o parâmetro passado é
     * válido. Após isso é verificado se o índice
     * encontrado para "name" é válido. Se for então
     * os resultados foram conclusivos.
     * 
     * @param name Nome do contato a ser encontrado.
     * @return O objeto Contact, caso exista na lista, ou
     * null, caso contrário.
     */
    public Contact findContact(String name){
        if(name == null || name.length() == 0){
            System.err.println("fail: nome inválido.");
            return null;
        }
        int index = this.findPosByName(name);
        if(index < 0){
            System.err.println("fail: contato " + name + " não existe");
            return null;
        }
        else{
            return this.contacts.get(index);
        }
    }

    /**
     * Adiciona um contato especificado à lista de contatos.
     * Se nenhum contato existir com esse nome, será adicionado
     * como um novo contato, porém, se já existir, os números
     * novos serão adicionados ao contato pre-existente.
     * 
     * A lista é ordenada ao final, em ordem alfabetica.
     * 
     * @param contact Contato a ser adicionado à lista.
     */
    public void addContact(Contact contact) {
        int index = this.findPosByName(contact.getName());
        if(index < 0){
            this.contacts.add(contact);
        }
        else{
            for(Fone fone : contact.getFones()){
                this.contacts.get(index).addFone(fone);
            }
        }
        this.contacts.sort((Contact c1, Contact c2) -> (c1.getName().compareTo(c2.getName())));
    }

    /**
     * Remove um contato de nome "name" da lista, caso
     * exista. Caso não, retorna uma mensagem de erro.
     * 
     * O método findPosName() retorna o índice do contato
     * requerido.
     * 
     * @param name Nome do contato a ser removido.
     */
    public void rmContact(String name){
        int index = this.findPosByName(name);
        if(index < 0){
            System.err.println("fail: contato " + name + " não existe");
        }
        else{
            this.contacts.remove(index);
        }
    }

    /**
     * Procura na lista de contatos a substring informada
     * e retorna os contatos que tenham ela em seu interior,
     * ou seja, no nome do contato, identificação ou números
     * de telefone;
     * 
     * A busca é feita a partir do retorno do método toString(),
     * com a ajuda do método indexOf() da classe String, que
     * retorna o índice da primeira ocorrência da substring.
     * 
     * Caso nada seja encontrado é emitida uma mensagem de
     * aviso e é retornada uma lista vazia.
     * 
     * @param pattern Substring a ser procurada na lista de 
     * contatos.
     * @return Uma lista de contatos que tem a substring em
     * suas informações principais.
     */
    public List<Contact> search(String pattern){
        ArrayList<Contact> auxList = new ArrayList<Contact>();
        if(pattern != null && pattern.length() != 0){
            for(Contact contact : this.contacts){
                if(contact.toString().indexOf(pattern) >= 0){
                    auxList.add(contact);
                }
            }
        }
        if(auxList.size() == 0){
            System.err.println("warning: nenhum resultado encontrado.");
        }
        return auxList;
    }
    
    /**
     * Retorna a lista de contatos da agenda.
     * 
     * @return Uma lista List de objetos da classe Contacts,
     * contendo os contatos da agenda.
     */
    public List<Contact> getContacts(){
        return this.contacts;
    }
    
    /**
     * Retorna as principais informações da agenda, no
     * formato de uma String formatada.
     * 
     * A classe StringBuilder e os métodos append() e 
     * toString() são usados para facilitar a construção,
     * bem como um laço for-each.
     */
    @Override
    public String toString(){
        StringBuilder info = new StringBuilder();
        for(Contact contact : this.contacts){
            info.append(contact + "\n");
        }
        return info.toString();
    }
    
    /**
     * Procura um contato de nome "name" na lista e retorna
     * a posição do contato com esse nome no vetor, ou -1,
     * se não existir.
     * 
     * @param name O nome do contato a ser procurado na
     * lista.
     * @return A posição do contato de nome "name", ou -1,
     * caso não exista na lista.
     */
    private int findPosByName(String name){
        for(int i = 0; i < this.contacts.size(); i++){
            if(this.contacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}