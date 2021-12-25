package agenda.agendaeletronica;

import java.util.Date;

import agenda.Agenda;
import contact.Contact;
import contact.Fone;

/**
 * Modela uma agenda telefônica eletrônica, que pode
 * ter vários contatos, assim como a agenda normal.
 * 
 * A agenda eletrônica é um tipo de agenda, logo
 * faz sentido ter uma relação de herança entre
 * estas classes, Alguns métodos adicionais foram
 * implementados aqui, para adicionar redundância
 * à agenda.
 * 
 * A vantagem da agenda eletrônica é a verificação
 * automática dos identificadores e dos números de
 * telefone adicionados. Os métodos para validação
 * dos números, por meio de expressão regular, foram
 * feitos nesta  classe, e os métodos para verificação 
 * dos identificadores foram feitos na classe Fone, do 
 * pacote contact, para fins de organização, e pela forma
 * como a classe Controller foi construída, porém, poderiam
 * ter sido implementados aqui sem nenhum problema.
 * 
 * Outra vantagem é a interface, mostrando o dono da
 * agenda e a data atual.
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 11/12/2021
 * @see contact.Contact
 * @see contact.Fone
 * @see agenda.Agenda
 */
public class AgendaEletronica extends Agenda {

    /**
     * Encapsula o nome do dono da agenda eletrônica.
     */
    final String nomeDono;

    /**
     * Inicializa a agenda eletrônica com um nome e um
     * tamanho. O tamanho é a quantidade de contatos
     * que a agenda pode guardar, limitando a agenda
     * verticalmente, mas não horizontalmente, já que
     * um contato poderá ter quantos números de telefone
     * quiser.
     * 
     * @param nomeDono O nome do dono da agenda eletrônica.
     * @param size A quantidade de contatos que a agenda
     * eletrônica pode guardar i.e. sua memória.
     * @throws IllegalArgumentException Caso o valor
     * passado para o tamanho seja inválido.
     */
    public AgendaEletronica(String nomeDono, int size){
        super(size);
        if(nomeDono == null | nomeDono.length() == 0){
            throw new IllegalArgumentException("fail: nome do dono da agenda é inválido.");
        }
        else{
            this.nomeDono = nomeDono;
        }
    }
    
    /**
     * Adiciona um contato à agenda caso seja válido.
     * Usa o método validaFone(Contact) para verificar
     * se o(s) número(s) do contato é(são) válido(s). 
     * 
     * Caso o contato a ser adicionado não exista e a
     * lista esteja cheia, emite uma mensagem de erro.
     * A única circunstância para permitir inserir um
     * contato na agenda estando ela cheia é quando o
     * contato já existe e irá apenas adicionar números
     * a ele.
     * 
     * Para o telefone ser validado corretamente ele deve
     * ser no formato "(XX)X.XXXX.XXXX", "XXXX.XXXX", "XXX", 
     * "(XX)XXXX.XXXX" ou "X.XXXX.XXXX".
     * 
     * @param contact O contato a ser adicionado.
     */
    @Override
    public void addContact(Contact contact) {
        if(!validaFone(contact)){
            System.err.println("fail: número(s) inválidos(s).");
        }
        else{
            if(this.findPosByName(contact.getName()) < 0 && this.getSize() == this.getContacts().size()){
                System.err.println("fail: memória cheia.");
            }
            else{
                super.addContact(contact);
            }
        }
    }

    /**
     * Valida os telefones do contato, um a um,
     * utilizando um for-each.
     * 
     * @param contact O contato a ser verificado.
     * @return "true" caso todos estejam nos conformes,
     * ou "false", caso algum esteja forma dos padrões.
     */
    private boolean validaFone(Contact contact){
        for(Fone fone : contact.getFones()){
            if(!this.validaFone(fone.getNumber())){
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se o telefone informado é válido,
     * utilizando uma expressão regular para isso:
     * 
     * ['('[0-9][0-9]')']?[0-9]?['.']?[0-9][0-9][0-9][0-9]['.'][0-9][0-9][0-9][0-9]
     * 
     * @param number O número de telefone a ser 
     * verificado.
     * @return "true" caso o número esteja nos conformes,
     * ou "false", caso contrário.
     * @see https://regexr.com/
     */
    private boolean validaFone(String number){
        return number.matches("((\\([0-9]{2}\\))?([0-9]\\.)?[0-9]{4}\\.[0-9]{4})|([0-9]{3})");
    }

    /**
     * Retorna as principais informações da agenda,
     * com um cabeçalho composto do dono da agenda
     * e data e hora, e, caso a lista de contatos
     * não esteja vazia, as informações de cada
     * contato.
     */
    @Override
    public String toString(){
        StringBuilder info = new StringBuilder();
        info.append("-> Agenda Eletrônica de " + this.nomeDono + ".\n-> Horário: " + (new Date()).toString() + '\n');
        return info.append(super.toString()).toString();
    }

}