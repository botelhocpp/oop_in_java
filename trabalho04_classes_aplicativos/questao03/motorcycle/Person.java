package motorcycle;

/**
 * Modela uma pessoa, com nome e idade, que pode
 * pilotar uma moto, modelada pela classe Motorcycle.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 09/11/2021
 */
public class Person {

    /**
     * Representa o nome da pessoa modelada pela classe.
     */
    private String name;
    
    /**
     * Representa a idade da pessoa modelada pela classe.
     */
    private int age;
    
    /**
     * Inicializa a instância, representando uma pessoa pela
     * classe Person, por meio dos seguintes atributos.
     * 
     * Antes de modificar os atributos devem ser feitas
     * verificações, como idade negativa e nome nulo.
     * 
     * Isso poderia ser feito usando o operador ternário,
     * porém, para seguir a linha de raciocínio do professor,
     * com mensagens de erro, foi utilizada a estrutura if-else.
     * 
     * Os parâmetros só são repassados para os atributos
     * caso ambos sejam válidos, por segurança.
     * 
     * @param name
     * @param age
     */
    public Person(String name, int age){
        if((name != null) && (age >= 0)){
            this.name = (name != null) ? name : ""; 
            this.age = (age >= 0) ? age : 0;
        }
        else if(age < 0){
            System.err.println("fail: idade inválida");
        }
        else if(name != null){
            System.err.println("fail: nome inválido");
        }
        else{
            System.err.println("fail: nome e idade inválidos");
        }
    }

    /**
     * Devolve para o usuário o nome da pessoa modelada
     * pela classe Person.
     * 
     * @return O "nome" da instância.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Devolve para o usuário a idade da pessoa modelada
     * pela classe Person.
     * 
     * @return A "idade" da instância.
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Devolve para o usuário os principais dados da
     * instância em forma de uma String.
     */
    public String toString(){
        return String.format("[%s:%d]", this.name, this.age);
    }

    /**
     * Devolve um objeto idêntico ao atual.
     */
    public Person clone(){
        return new Person(this.name, this.age);
    }
}

