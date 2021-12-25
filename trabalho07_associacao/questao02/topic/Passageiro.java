package topic;

/**
 * Modela um passageiro que pode embarcar em uma
 * topic. A classe Passageiro, então, terá uma relação
 * de composição com a classe Topic.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 02/12/2021
 * @see topic.Topic
 */
public class Passageiro {
    /**
     * Encapsula o nome do passageiro.
     */
    private String name;

    /**
     * Encapsula a idade do passageiro.
     */
    private int age;

    /**
     * Inicializa um passageiro, com nome e idade,
     * que irá ser utilizado dentro de uma classe
     * Topic, por composição.
     * 
     * São utilizadas os dois métodos setters
     * presentes na estrutura proposta pelo professor
     * para configurar os dois parâmetros da classe.
     *  
     * @param name Nome do passageiro.
     * @param age Idade do passageiro.
     * @throws IllegalArgumentException Caso um dos
     * parâmetros seja inválido i.e "name" nulo ou de
     * tamanho 0 e "age" abaixo de zero.
     */
    public Passageiro(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    /**
     * Retorna o nome do passageiro encapsulado.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Retorna a idade do passageiro encapsulada.
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Configura o nome do passageiro, verificando 
     * se a cadeia informada atende aos padrões aceitáveis.
     * 
     * @param name Nome do passageiro.
     * @throws IllegalArgumentException Caso o parâmetro
     * seja inválido, ou seja, nulo ou de tamanho 0.
     */
    private void setName(String name){
        if(name == null || name.length() == 0){
            throw new IllegalArgumentException("fail: nome informado inválido.");
        }
        else{
            this.name = name;
        }
    }

    /**
     * Configura a idade do passageiro, verificando 
     * se o valor informado atende aos padrões aceitáveis.
     * 
     * @param age Idade do passageiro.
     * @throws IllegalArgumentException Caso o parâmetro
     * seja inválido, ou seja, menor que zero.
     */
    private void setAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("fail: idade informada inválida.");
        }
        else{
            this.age = age;
        }
    }

    /**
     * Verifica se o passageiro pertence à categoria
     * de prioridade i.e. maior ou igual a 65 anos.
     * 
     * O operador ternário foi utilizado pela simplicidade
     * da representação.
     * 
     * @return "true" se tiver prioridade, ou "false",
     * caso contrário.
     */
    public boolean isPriority(){
        return (this.age >= 65) ? true : false;
    }

    /**
     * Devolve as informações do passageiro em forma
     * de String, utilizando o método String.Format().
     */
    public String toString(){
        return String.format("%s:%d", this.name, this.age);
    }
}
