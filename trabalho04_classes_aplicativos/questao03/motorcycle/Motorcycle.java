package motorcycle;

/**
 * Modela uma moto, que pode comportar uma
 * pessoa da classe Person, desde que tenha 10 anos
 * ou menos.
 * 
 * 31/10/2021 - Commit Inicial. Estrutura proposta pelo
 * professor.
 * 09/11/2021 - Métodos implementados. Adição de métodos
 * getters para faculitar a obtenção de informações por
 * sistemas de controle e gerenciamento, como por exemplo
 * para gerenciar melhor o tempo e criar melodias da buzina
 * alterando a potência. 
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 09/11/2021
 */
public class Motorcycle {
    /**
     * Representa a pessoa que está pilotando a moto.
     */
    private Person person;

    /**
     * Representa a potência da moto.
     */
    private int power;

    /**
     * Representa o tempo disponível para pilotar a moto.
     */
    private int time;
    
    /**
     * Inicializa o atributo power como 1, o default. Os outros
     * atributos, time e person, são inicializados pela JVM já
     * com os valores requeridos, então não são inicializados
     * no construtor.
     */
    public Motorcycle(){
        this(1); 
    }
    
    /**
     * Inicializa o atributo power com o parâmetro passado,
     * caso seja válido. Caso seja inválido a potência default
     * é atribuída, ou seja, 1. Os outros atributos, time e person,
     * são inicializados pela JVM já com os valores requeridos,
     * então não são inicializados no construtor.
     * 
     * @param power Valor de potência que será atribuída a moto
     * caso seja maior que zero. Caso não, será atribuído 1.
     */
    public Motorcycle(int power){
        this.power = (power > 0) ? power : 1; 
    }
    
    /**
     * Comprar mais tempo para pilotar a moto. Caso o tempo seja
     * inválido, menor que zero, é mostrado uma mensagem ao usuário.
     * 
     * @param time Tempo, maior que zero, que  será adicionado
     * ao tempo disponível para pilotar a moto.
     */
    public void buy(int time){
        if(time > 0){
            this.time += time;
        }
        else{
            System.out.println("fail: tempo inválido");
        }
    }
    
    /**
     * Se a moto estiver vazia, coloca a pessoa requerida
     * na moto e retorna "true". Caso a moto estiver ocupada
     * uma mensagem será mostrada ao usuário e será retornado
     * "false".
     * 
     * Nesse caso o método clone é dispensável, sendo utilizado
     * apenas para manter a integridade do código. Não haveria
     * problema algum em guardar apenas a referência externa
     * NESSE CASO, já que não tem uma restrição de modificação,
     * e nem modificados "person" dentro desta classe ou fora dela.
     * 
     * @param person Pessoa a ser alocada para a moto. Não deve
     * ser "null".
     * @return "true" caso seja possível alocar a pessoa "person"
     * a moto, e "false" caso contrário.
     */
    public boolean in(Person person){
        if(this.person == null){
            this.person = person.clone();
            return true;
        }
        else if(this.person != null){
            System.out.println("fail: moto ocupada");
            return false;
        }
        else{
            System.out.println("fail: pessoa inexistente");
            return false;
        }
    }

    /**
     * Se houver uma pessoa na moto i.e. o atributo da classe
     * Person não estiver vazio, essa pessoa é retirada da
     * moto e é retornada para o usuário.
     * 
     * Existem duas formas de fazer o "retorno" do objeto:
     * 
     * Ao fazer "Person temporary = this.person.clone()"
     * "temporary" irá referenciar um objeto com o mesmo estado
     * do objeto que "person" referencia. Depois, ao fazer "person"
     * referenciar para "null" seu antigo objeto irá se perder 
     * no heap e deverá ser liberado pel Garbage Collector da JVM.
     * Então, "temporary" deverá ser retornado. Dessa forma o objeto
     *  original se perde.
     * 
     * Podemos aproveitar a instância original realizando
     * simplesmente "Person temporary = this.person" e depois
     * atribuindo "null" à "person". Dessa forma "temporary"
     * irá referenciar o objeto original, e a referência atributo
     * irá apontar para nulo. Dessa forma reaproveitamos a instância
     * original de Person!
     * 
     * @return O objeto da classe Person que está na moto
     * ou null, caso ela esteja vazia.
     */
    public Person out(){
        if(this.person != null){
            Person temporary = this.person;
            this.person = null;
            return temporary;
        }
        else{
            System.out.println("fail: moto vazia");
            return null;
        }
    }
    
    /**
     * Pilota a moto por um tempo "time", maior que zero.
     * 
     * A moto deve estar ocupada por uma pessoa com idade
     * menor ou igual a 10, e deve ter ao menos um minuto
     * disponível. Se o tempo acabar no meio do passeio,
     * a quantidade de tempo que a pessoa pilotou será
     * informado.
     * 
     * @param time Tempo a ser pilotado pela pessoa. Será
     * decrementado do tempo disponível.
     */
    public void drive(int time){
        if((this.person.getAge() < 11) && (this.time > 0)){
            if(this.time >= time){
                this.time -= time;
            }
            else if(time < 1){
                System.out.println("fail: tempo inválido");
            }
            else{
                System.out.printf("fail: andou %d min e acabou o tempo%n", this.time);
                this.time = 0;
            }
        }
        else if(this.person.getAge() > 10){
            System.out.println("fail: muito grande para andar de moto");
        }
        else{
            System.out.println("fail: tempo zerado");
        }
    }
   
    /**
    * Qualquer pessoa pode buzinar na moto. A moto não
    deve estar vazia!
    *
    * O barulho da buzina é "Pem", porém o número de
    * letras "e" na palavra é igual ao valor da potência.
    * 
    */
    public void honk(){
        if(person != null){
            System.out.print("P");
            for(int i = 0; i < this.power; i++){
                System.out.print("e");
            }
            System.out.println("m");
        }
        else{
            System.out.println("fail: moto vazia");
        }
    }

    /**
     * Devolve para o usuário a potência da moto.
     */
    public int getPower(){
        return this.power;
    }

    /**
     * Devolve para o usuário o tempo disponível para
     * a pessoa pilotar a moto.
     */
    public int getTime(){
        return this.time;
    }

    /**
     * Devolve para o usuário a pessoa que está a
     * pilotar a moto.
     */
    public Person getPerson(){
        return this.person.clone();
    }

    /**
     * Devolve para o usuário os principais dados da
     * instância em forma de uma String.
     */
    public String toString(){
        return String.format("potencia: %d, minutos: %d, pessoa: %s", this.power, this.time, this.person);
    }
}
