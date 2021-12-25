package questao03.trampoline;

import java.util.LinkedList;

/**
 * Essa classe representa uma estrutura
 * de gerência de um trampolim de um
 * parquinho.
 * 
 * @see questao03.trampoline_incrementado.Trampoline
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 25/11/2021
 */
public class Trampoline {
    private LinkedList<Kid> kidsWaiting;
    private LinkedList<Kid> kidsPlaying;

    /**
     * Inicializa o trampolim com uma limite de idade
     * máxima para uma criança brincar, e uma capacidade
     * máxima para o trampolim.
     * 
     * @param maxCapacity Capacidade máxima do trampolim.
     * @param maxAge Idade máxima para uma criança poder
     * brincar.
     */
    public Trampoline(){
        this.kidsWaiting = new LinkedList<Kid>();
        this.kidsPlaying = new LinkedList<Kid>();
    }
    
    /**
     * Insere a criança na lista de espera do trampolim,
     * caso ela exista e caso tenha idade apropriada.
     * 
     * @param kid Criança que quer brincar no trampolim.
     */
    public void arrive(Kid kid){
        if(kid == null){
            System.err.println("fail: criança inexistente.");
        }
        else{
            this.kidsWaiting.add(kid);
        }
    }
    
    /**
     * Caso o trampolim não esteja cheio e caso a lista de espera
     * não esteja vazia retire da lista de espera e insira na lista
     * de crianças que estão brincando no trampolim.
     */
    public void in(){
        if(this.kidsWaiting.isEmpty()){
            System.err.println("fail: lista de espera vazia.");
        }
        else{
            this.kidsPlaying.add(this.kidsWaiting.removeFirst());
        }
    }
    
    /**
     * Remove uma criança do começo da lista de crianças que
     * estão a brincar no trampolim e a insere no final da
     * lista de espera. Caso não hajam crianças brincando
     * uma mensagem irá ser mostrada ao usuário.
     */
    public void out(){
        if(this.kidsPlaying.size() > 0){
            this.kidsWaiting.add(this.kidsPlaying.removeFirst());
        }
        else{
            System.err.println("fail: trampolim vazio.");
        }
    }

    /**
     * Procura uma criança de nome "name" em uma lista encadeada
     * "list", a remove da lista e a retorna.
     * 
     * @param name O nome da criança a ser removida.
     * @param list A lista onde a procura irá ocorrer.
     * @return Uma instância da classe Criança de nome "name", ou
     * null, caso não exista na lista.
     */
    private Kid removeKid(String name, LinkedList<Kid> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(name)){
                Kid auxiliaryKid = list.get(i);
                list.remove(i);
                return auxiliaryKid;
            }
        }
        return null;
    }
    
    /**
     * Remove uma criança de nome "name" do parquinho,
     * esteja ela na lista de espera ou de crianças
     * brincando.
     * 
     * @param name Nome da criança a ser removida.
     * @return uma criança de nome "name", ou null, caso
     * não exista.
     */
    public Kid remove(String name){
        if(this.kidsWaiting.isEmpty() && this.kidsPlaying.isEmpty()){
            System.err.println("fail: listas vazias.");
        }
        Kid auxiliaryKid = removeKid(name, this.kidsWaiting);
        if(auxiliaryKid != null){
            return auxiliaryKid;
        }
        auxiliaryKid = removeKid(name, this.kidsPlaying);
        if(auxiliaryKid != null){
            return auxiliaryKid;
        }
        System.err.println("fail: criança não existente nas listas.");
        return null;
    }
    
    /**
     * Devolve as principais informações do
     * controle do trampolim.
     */
    public String toString(){
        String trampolineData = "=> ";
        for(int i = this.kidsWaiting.size() - 1; i >= 0 ; i--){
            trampolineData = trampolineData.concat(this.kidsWaiting.get(i).toString() + " ");
        }
        trampolineData = trampolineData.concat("=> [");
        for(int i = this.kidsPlaying.size() - 1; i >= 0 ; i--){
            trampolineData = trampolineData.concat(" " + this.kidsPlaying.get(i).toString());
        }
        return trampolineData.concat(" ]");
    }
}
