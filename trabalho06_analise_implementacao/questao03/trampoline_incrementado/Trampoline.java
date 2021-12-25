package questao03.trampoline_incrementado;

import java.util.LinkedList;

/**
 * Gestor de pula-pulas em um parquinho.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 25/11/2021
 */
public class Trampoline {
    /**
     * Lista encadeada com as crianças esperando
     * para brincarem.
     */
    private LinkedList<Kid> kidsWaiting;

    /**
     * Lista encadeada com as crianças brincando.
     */
    private LinkedList<Kid> kidsPlaying;

    /**
     * Capacidade máxima de crianças do trampolim.
     */
    private final int MAX_CAPACITY;

    /**
     * Idade máxima das crianças para brincarem no
     * trampolim.
     */
    private final int MAX_AGE;

    /**
     * Valor do ingresso para brincar no trampolim uma vez.
     */
    private final float TICKET_VALUE;

    /**
     * Caixa do trampolim.
     */
    private float paybox;

    /**
     * Inicializa o trampolim com uma limite de idade
     * máxima para uma criança brincar, uma capacidade
     * máxima para o trampolim e um valor de entrada.
     * 
     * Entradas inválidas levantarão uma exceção.
     * 
     * @param maxCapacity Capacidade máxima do trampolim.
     * Deve ser maior que zero.
     * @param maxAge Idade máxima para uma criança poder
     * brincar. Deve ser maior que zero, pois recém nascidos
     * não podem brincar no trampolim.
     * @param ticketValue Valor da entrada para brincar no
     * trampolim. Não pode ser menor que zero. Entrada pode
     * ser gratuita.
     */
    public Trampoline(int maxCapacity, int maxAge, float ticketValue){
        this.kidsWaiting = new LinkedList<Kid>();
        this.kidsPlaying = new LinkedList<Kid>();
        if(maxCapacity < 1){
            throw new IllegalArgumentException("fail: valor informado para capacidade máxima inválido.");
        }
        else if(maxAge < 1){
            throw new IllegalArgumentException("fail: valor informado para idade máxima inválido.");
        }
        else if(ticketValue < 0){
            throw new IllegalArgumentException("fail: valor informado para o preço da entrada inválido.");
        }
        else{
            this.MAX_AGE = maxAge;
            this.MAX_CAPACITY = maxCapacity;
            this.TICKET_VALUE = ticketValue;
        }
    }
    
    /**
     * Insere a criança na lista de espera do trampolim,
     * caso ela exista e caso tenha idade apropriada.
     * 
     * Primeiro é verificado se a instância passada existe;
     * Depois, a idade da criança. Deve ser menor que o 
     * máximo;
     * Por fim, verifica se a criança já não está em uma
     * das listas, por meio do método findKind();
     * 
     * Se tudo estiver OK, a criança é adicionada na lista
     * de espera.
     * 
     * @param kid Criança que quer brincar no trampolim.
     */
    public void arrive(Kid kid){
        if(kid == null || kid.getAge() < 1 || kid.getName().equals(null)){
            System.err.println("fail: criança inexistente.");
        }
        else if(kid.getAge() > this.MAX_AGE){
            System.err.println("fail: criança muito velha.");
        }
        else if((this.findKid(kid.getName(), this.kidsWaiting) != null) || (this.findKid(kid.getName(), this.kidsPlaying) != null)){
            System.err.println("fail: criança já nas listas.");
        }
        else{
            this.kidsWaiting.add(kid);
        }
    }
    
    /**
     * Caso o trampolim não esteja cheio e caso a lista de espera
     * não esteja vazia retire da lista de espera e insira na lista
     * de crianças que estão brincando no trampolim.
     * 
     * Primeiro é verificado se a lista de espera estpa vazia;
     * Depois, se a capacidade máxima foi atingida;
     * Depois é verificado se a lista de crianças brincando
     * está vazia. Se tiver, a inserção ocorre de maneira direta.
     * Se não, deve-se ter uma relação enter a criança mais velha
     * e a criança mais nova que está brincando com a criança
     * que está prestes a entrar. Se essa criança for:
     * 
     * (oldest - 2) <= criança <= (oldest + 2)
     * 
     * e
     * 
     * (youngest - 2) <= criança <= (youngest + 2)
     * 
     * Então ela pode entrar. Se não, a próxima criança da lista
     * de espera será testada, e assim por diante.
     * 
     * A cada vez que uma criança entra seu saldo é incrementado pelo
     * valor da entrada.
     */
    public void in(){
        if(this.kidsWaiting.isEmpty()){
            System.err.println("fail: lista de espera vazia.");
        }
        else if(this.kidsPlaying.size() == this.MAX_CAPACITY){
            System.err.println("fail: trampolim cheio.");
        }
        else{
            if(this.kidsPlaying.isEmpty()){
                this.kidsWaiting.getFirst().increaseBalance(this.TICKET_VALUE);
                this.kidsPlaying.add(this.kidsWaiting.removeFirst());
            }
            else{
                for(int i = 0; i < kidsWaiting.size(); i++){
                    Kid youngestKid = findYoungest(this.kidsPlaying);
                    Kid oldestKid = findOldest(this.kidsPlaying);
                    if((youngestKid.getAge() + 2 >= kidsWaiting.get(i).getAge()) && (youngestKid.getAge() - 2 <= kidsWaiting.get(i).getAge())){
                        if((oldestKid.getAge() + 2 >= kidsWaiting.get(i).getAge()) && (oldestKid.getAge() - 2 <= kidsWaiting.get(i).getAge())){
                            this.kidsWaiting.get(i).increaseBalance(this.TICKET_VALUE);
                            this.kidsPlaying.add(this.kidsWaiting.remove(i));
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Procura pela criança mais nova na lista.
     * 
     * @param list Lista onde a procura deve ser realizada.
     * @return A criança mais nova, caso exista.
     */
    private Kid findYoungest(LinkedList<Kid> list){
        Kid youngestKid = list.getFirst();
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).getAge() < youngestKid.getAge()){
                youngestKid = list.get(i);
            }
        }
        return youngestKid;
    }

    /**
     * Procura pela criança mais velha na lista.
     * 
     * @param list Lista onde a procura deve ser realizada.
     * @return A criança mais velha, caso exista.
     */
    private Kid findOldest(LinkedList<Kid> list){
        Kid oldestKid = list.getFirst();
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).getAge() > oldestKid.getAge()){
                oldestKid = list.get(i);
            }
        }
        return oldestKid;
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
     * Procura uma criança de nome "name" em uma lista
     * "list".
     * 
     * @param name Nome da criança a ser procurada.
     * @param list Lista onde a procura deve ser realizada.
     * @return A criança de nome "name", caso exista,
     * ou nulo, caso contrário.
     */
    private Kid findKid(String name, LinkedList<Kid> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(name)){
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * Procura uma criança de nome "name" nas duas
     * listas e a retorna, caso encontre.
     * 
     * Se as listas não estiverem vazias a procura
     * ocorrerá nelas. 
     * 
     * @param name Nome da criança a ser procurada.
     * @return A criança de nome "name", caso exista,
     * ou nulo, caso contrário.
     */
    public Kid findKid(String name){
        //Listas vazias?
        if(this.kidsWaiting.isEmpty() && this.kidsPlaying.isEmpty()){
            System.err.println("fail: listas vazias.");
        }

        //Procure na lista de espera.
        Kid auxiliaryKid = findKid(name, this.kidsWaiting);
        if(auxiliaryKid != null){
            return auxiliaryKid;
        }

        //Procure na lista de quem está brincando.
        auxiliaryKid = findKid(name, this.kidsPlaying);
        if(auxiliaryKid != null){
            return auxiliaryKid;
        }

        //Não foi dessa vez.
        System.err.println("fail: criança não existente nas listas.");
        return null;
    }

    /**
     * Remove uma criança de nome "name" do parquinho,
     * esteja ela na lista de espera ou de crianças
     * brincando. Ao ser removida sua dívida deve
     * ser quitada.
     * 
     * @param name Nome da criança a ser removida.
     * @return Uma criança de nome "name", ou null, caso
     * não exista.
     */
    public Kid remove(String name){
        //Tentar remover da lista de espera.
        Kid auxiliaryKid = findKid(name, this.kidsWaiting);
        if(auxiliaryKid != null){
            this.paybox += auxiliaryKid.payDebt();
            this.kidsWaiting.remove(this.kidsWaiting.indexOf(auxiliaryKid));
            return auxiliaryKid;
        }

        //Tentar remover da lista de quem está brincando.
        auxiliaryKid = findKid(name, this.kidsPlaying);
        if(auxiliaryKid != null){
            this.paybox += auxiliaryKid.payDebt();
            this.kidsPlaying.remove(this.kidsPlaying.indexOf(auxiliaryKid));
            return auxiliaryKid;
        }

        //Não foi dessa vez.
        System.err.println("fail: não existe uma criança com esse nome nas listas.");
        return null;
    }
    
    /**
     * Remove todas as crianças, quitando suas dívidas.
     */
    public void removeAll(){
        //Remover da lista de espera.
        for(int i = this.kidsWaiting.size() - 1; i >= 0; i--){
            this.paybox += this.kidsWaiting.get(i).payDebt();
            this.kidsWaiting.remove(i);
        }

        //Remover da lista de quem está brincando.
        for(int i = this.kidsPlaying.size() - 1; i >= 0; i--){
            this.paybox += this.kidsPlaying.get(i).payDebt();
            this.kidsPlaying.remove(i);
        }
    }

    /**
     * Retorna as informações sobre o fluxo de
     * caixa do trampolim.
     * 
     * @return String com as informações formatadas.
     */
    public String getBalance(){
        String trampolineData = String.format("=> caixa: R$ %.2f\n", this.paybox);
        for(int i = this.kidsWaiting.size() - 1; i >= 0 ; i--){
            trampolineData = trampolineData.concat("=> nome: " + this.kidsWaiting.get(i).getName() + ", saldo: R$ " + this.kidsWaiting.get(i).getBalance() + "\n");
        }
        for(int i = this.kidsPlaying.size() - 1; i >= 0 ; i--){
            trampolineData = trampolineData.concat("=> nome: " + this.kidsPlaying.get(i).getName() + ", saldo: R$ " + this.kidsPlaying.get(i).getBalance() + "\n");
        }
        return trampolineData;
    }

    /**
     * Devolve as principais informações do
     * controle do trampolim.
     */
    public String toString(){
        String trampolineData = String.format("=> caixa: R$ %.2f => ", this.paybox);
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
