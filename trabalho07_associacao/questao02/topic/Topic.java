package topic;

import java.util.ArrayList;

/**
 * Modela uma "topique" que pode abrigar vários 
 * passageiros, conforme sua capacidade.
 * 
 * Opera com uma relação de composição com a 
 * classe Passageiro.
 * 
 * Foi utilizado algumas vezes dos operadores
 * lógicos para incrementar a legibilidade e
 * a densidade de código:
 * 
 * A || B -> Se A for verdadeiro, o B nem é
 * verificado. B só é verificado caso A seja
 * falso.
 * 
 * A && B -> Se A for verdadeiro, o B é verificado.
 * Caso A seja falso, B não é verificado.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 02/12/2021
 * @see topic.Passageiro
 */
public class Topic {
    /**
     * Encapsula um conjunto de espaços, que podem 
     * amparar objetos da classe Passageiros. Essas
     * cadeiras estão destinadas a quem não tem
     * prioridade, mas podem ser usadas no geral.  
     */
    private ArrayList<Passageiro> prioritySeats;

    /**
     * Encapsula um conjunto de espaços, que podem 
     * amparar objetos da classe Passageiros. Essas
     * cadeiras estão destinadas a quem tem prioridade,
     * mas podem ser usadas no geral.  
     */
    private ArrayList<Passageiro> normalSeats;

    /**
     * Inicializa a topique, configurando a lotação máxima
     * e a quantidade de cadeiras preferenciais.
     * 
     * A quantidade de cadeiras normais é dada pela relação
     * capacity - qtdPriority. As cadeiras dos passageiros
     * são preenchidas com nulos, de forma a termos um "array
     * vazio não-vazio".
     * 
     * @param capacity Capacidade total da topique.
     * @param qtdPriority Quantidade de cadeiras preferenciais.
     * @throws IllegalArgumentException Caso algum dos parâmetros
     * seja inválido i.e. menor que zero.
     */
    public Topic(int capacity, int qtdPriority){
        if(capacity < 0 || qtdPriority < 0){
            throw new IllegalArgumentException("fail: Parâmetros informados inválidos.");
        }
        else{
            this.normalSeats = new ArrayList<Passageiro>(capacity - qtdPriority);
            this.prioritySeats = new ArrayList<Passageiro>(qtdPriority);
            for(int i = 0; i < capacity - qtdPriority; i++){
                this.normalSeats.add(null);
            }
            for(int i = 0; i < qtdPriority; i++){
                this.prioritySeats.add(null);
            }
        }
    }

    /**
     * Procura pela primeira posição livre em um ArrayList
     * informado.
     * 
     * @param list A lista onde a busca será efetuada.
     * @return O índice da primeira posição livre, ou -1, caso
     * a lista esteja cheia.
     */
    private int findFirstFreePos(ArrayList<Passageiro> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == null){
                return i;
            }
        }
        return -1;
    }

    /**
     * Procura por um passageiro de nome "name" no ArrayList
     * informado.
     * 
     * @param name Nome do passageiro.
     * @param list Lista onde a busca será efetuada.
     * @return A posição do passageiro, ou -1, caso não esteja
     * na lista.
     */
    private int findByName(String name, ArrayList<Passageiro> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) != null && list.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Insere o passageiro na lista informada, se houver uma
     * posição livre. O método findFirstFreePos() é usado
     * para encontrar a primeira posição livre da lista.
     * 
     * Se a posição for igual ou maior que zero, ou seja, há
     * uma posição livre, o passageiro é colocado no índice
     * livre.
     *  
     * @param passageiro Passageiro a ser inserido na lista.
     * @param list Lista onde a operação será realizada.
     * @return "true" se a operação pôde se realidaza, e
     * "false" caso contrário.
     */
    private boolean insertOnList(Passageiro passageiro, ArrayList<Passageiro> list){
        int index = this.findFirstFreePos(list);
        if(index < 0){
            return false;
        }
        else{
            list.set(index, passageiro);
            return true;
        }
    }

    /**
     * Remove um passageiro de nome "name" da lista informada.
     * O método findByName() é usado para localizar a posição,
     * da lista que, se maior ou igual a zero, é preenchida com
     * nulo, removendo o passageiro da topique. Se o passageiro
     * não for localizado i.e. índice encontrado menor que zero,
     * a operação foi mal sucedida.
     * 
     * @param name Nome do passageiro.
     * @param list Lista onde a procura será efetuada.
     * @return "true" se a operação foi realizada, ou "false"
     * caso contrário.
     */
    private boolean removeFromList(String name, ArrayList<Passageiro> list){
        int index = this.findByName(name, list);
        if(index < 0){
            return false;
        }
        else{
            list.set(index, null);
            return true;
        }
    }
    
    /**
     * Insere um passageiro informado nas listas, baseados
     * em uma ordem de prioridade. O método findByName()
     * verifica se o passageiro já está em uma lista. O método
     * insertOnList() é então usado para inserir na lista. A
     * lista de parâmetro deve ser baseada na prioridade i.e
     * método isPriority().
     * 
     * Algumas melhorias forma feitas para incrementar a 
     * densidade de código e melhorar a leitura. A linha
     *
     * if(passageiro.isPriority() && this.insertOnList(passageiro, this.prioritySeats))
     * 
     * primeiro verifica se o passageiro tem prioridade.
     * Se sim, verifica se a inserção na lista de prioridades
     * é bem sucedida, por se tratar de um "E" todas os átomos
     * devem ser verdadeiros. Se não, irá para pŕoxima escolha.
     * Se sim, retorna true. A próxima escolha,
     * 
     * else if(this.insertOnList(passageiro, this.normalSeats) || this.insertOnList(passageiro, this.prioritySeats)),
     * 
     * verifica se uma inserção na lista de assentos normais
     * é bem sucedida. Se não, tenta inserir na lista de prioridade.
     * Caso algum dos dois átomos seja verdadeiro é retornado
     * true. Caso nada dê certo, é retornado false.
     * 
     * @param passageiro O passageiro a embarcar na topique.
     * @return "true" caso a operação sejam bem sucedida, e 
     * "false" caso contrário.
     */
    public boolean insert(Passageiro passageiro){
        if(this.findByName(passageiro.getName(), this.normalSeats) != -1 || this.findByName(passageiro.getName(), this.prioritySeats) != -1){
            System.out.println("fail: passageiro já esta na topic.");
            return false;
        }
        else{
            if(passageiro.isPriority() && this.insertOnList(passageiro, this.prioritySeats)){
                return true;
            }
            else if(this.insertOnList(passageiro, this.normalSeats) || this.insertOnList(passageiro, this.prioritySeats)){
                return true;
            }
            else{
                System.out.println("fail: topic lotada.");
                return false;
            }
        }
    }

    /**
     * Remove um passageiro de nome "name" da topique.
     * Usa o método removeFromList() para tentar remover
     * de ambas as listas
     * 
     * @param name Nome do passageiro a ser removido.
     * @return "true" caso a operação sejam bem sucedida, e 
     * "false" caso contrário.
     */
    public boolean remove(String name){
        if(this.removeFromList(name, this.normalSeats)){
            return true;
        }
        else if(this.removeFromList(name, this.prioritySeats)){
            return true;
        }
        else{
            System.out.println("fail: passageiro não está na topic.");
            return false;
        }
    } 

    /**
     * Devolve as principais informações da topique em
     * uma String bem formatado. A classe "StringBuilder"
     * foi utilizada para facilitar a manipulação da String.
     * 
     * São utilizados dois laços for each: um para os assentos
     * prioritários e um para os assentos normais. A linha
     * 
     * (passageiro == null) ? " " : passageiro + " "
     * 
     * diz que, caso aquele "passageiro" seja nulo, ou seja,
     * se naquele assento não tem ninguém, então apenas um
     * espaço será inserido, e, se não, os dados do passageiro,
     * acescidos de um espaço, ao final. Como a String do modelo
     * do professor não tem espaços no começo e no fim, deve-se
     * tira-los, com a ajuda de:
     * 
     * int index = informacoes.lastIndexOf(" ");
     * if(index != -1){
     *      informacoes.replace(index, index + 1, "");
     * }
     * 
     * Que irá retirar o último espaço, caso exista. A variável
     * "index" foi utilizada para reduzir a chamada do método
     * lastIndexOf(" ") de 3 vezes para apenas 1, reduzindo o
     * overhead.
     *  
     */
    public String toString(){
        StringBuilder informacoes = new StringBuilder("[");
        for(Passageiro passageiro : this.prioritySeats){
            informacoes.append("@" + ((passageiro == null) ? " " : passageiro + " "));
        }
        for(Passageiro passageiro : this.normalSeats){
            informacoes.append("=" + ((passageiro == null) ? " " : passageiro + " "));
        }
        int index = informacoes.lastIndexOf(" ");
        if(index != -1){
            informacoes.replace(index, index + 1, "");
        }
        return informacoes.append("]").toString();
    }
}