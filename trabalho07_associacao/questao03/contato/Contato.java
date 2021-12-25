package contato;

import java.util.ArrayList;

/**
 * Modela uma agenda telefônica que só pode
 * guardar um único contato. Cada contato
 * pode ter múltiplos telefones, com
 * identificadores e números de telefone.
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 05/12/2021
 * @see contato.Fone
 */
public class Contato {
    /**
     * Nome do contato a ser salvo na agenda.
     */
    private String name;

    /**
     * Telefones a serem salvos na agenda,
     * referentes ao contato.
     */
    private ArrayList<Fone> fones;

    /**
     * Prefixo do contato. Está como final
     * para impedir que seja alterado em
     * classes do mesmo pacote.
     * 
     * Será utilizado no método toString().
     * 
     * Está como protected para seguir a
     * estrutura do professor.
     */
    protected final String prefix = "-";
    
    /**
     * Inicializa a agenda com um contato 
     * "name" e atribui a ele uma lista de
     * telefones, se "fones" não for nulo.
     * 
     * Se utiliza do metodo setter "setName()"
     * para inicializar o atributo "name".
     * 
     * @param name Nome do contato a ser
     * salvo na agenda. 
     * @param fones Lista de telefones a
     * serem adicionados ao contato.
     */
    public Contato(String name, ArrayList<Fone> fones){
        this.setName(name);
        this.fones = new ArrayList<Fone>();
        if(fones != null && fones.size() > 0){
            for(int i = 0; i < fones.size(); i++){
                this.addFone(fones.get(i));
            }
        }
    }
    
    /**
     * Insere o telefone indicado na
     * agenda caso ele seja válido.
     * 
     * A verificação é feita por meio
     * do método validate() da classe
     * Fone, que é estático.
     * 
     * Caso seja inválido uma mensagem
     * de erro será mostrada e o telefone
     * não será atribuído.
     * 
     * @param fone Telefone a ser inserido
     * na agenda.
     * @see contato.Fone#validate(String)
     */
    public void addFone(Fone fone){
        if(Fone.validate(fone.getNumber())){
            this.fones.add(fone);
        }
        else{
            System.err.println("fail: invalid number '" + fone + "'.");
        }
    }
    
    /**
     * Remove o telefone no índice
     * informado, caso exista.
     * 
     * @param index Índice de onde
     * o telefone será removido.
     */
    public void rmFone(int index){
        if(this.fones.size() > index){
            this.fones.remove(index);
        }
        else{
            System.err.println("fail: invalid index.");
        }
    }
    
    /**
     * Devolve o nome do contato,
     * salvo na agenda.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Configura o nome, verificando
     * se o argumento passado é válido
     * i.e. tem comprimento maior que 0
     * e se é diferente de nulo. Se sim,
     * então atribui ao atributo "name"
     * o parâmetro.
     *  
     * @param name Nome do contato salvo
     * na agenda.
     */
    public void setName(String name){
        this.name = (name.length() == 0 || name == null) ? "" : name;
    }
    
    /**
     * Retorna a lista de telefones do
     * contato.
     */
    public ArrayList<Fone> getFones(){
        return this.fones;
    }
    
    /**
     * Configura uma String com as principais
     * informações da agenda i.e. nome do contato
     * e telefones, com seus índices, identificadores
     * e números.
     * 
     * A classe StringBuilder fornece facilidade para
     * manipulação da String i.e. método append().
     * 
     * O formato da String será:
     * 
     * - <name> [<index_1>:<id_1>:<num_1>] [<index_2>:<id_2>:<num_2>] ...
     */
    public String toString(){
        StringBuilder info = new StringBuilder(this.prefix + " " + name);
        for(int i = 0; i < this.fones.size(); i++){
            info.append(String.format(" [%d:%s:%s]", i, this.fones.get(i).getId(), this.fones.get(i).getNumber()));
        }
        return info.toString();
    }
}