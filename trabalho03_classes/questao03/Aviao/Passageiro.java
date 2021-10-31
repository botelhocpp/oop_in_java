package questao03.Aviao;

/**
 * A classe Passageiro, da biblioteca Aviao, permite a representação de
 * um tripulante de um voo, bem como suas caracerísticas, como nome e
 * CPF. Alguns atributos da classe possuem características interessantes,
 * como a formatação da String CPF e um outro campo com o seu valor numerico.
 * Vamos entrar em detalhes brevemente.
 * 
 * Os atributos estão protegidos, para evitar sua incorreta manipulação,
 * devendo ser utilizados métodos para modificar ou obtê-los. A manipulação 
 * de passageiros em um voo é feita pela classe Voo, exceto em um caso:
 * mudar de voo ou de poltrona, utilizando a classe mudarVoo. A decisão de 
 * colocar um método de manipulação de voos na classe Passageiro, ao invés
 * da classe Voo, foi devido ao fato de que é mais fácil mudar os atributos
 * do passageiro estando dentro da classe, pois, além de mudar os dados da
 * instância da classe Voo é necessário, também, mudar os atributos da instância
 * da classe Passageiro, mantendo a linearidade do código.
 * 
 * Sendo assim, para ocupar e desocupar vagas em um voo é necessário a utilização 
 * de métodos específicos da classe Voo, com exceção de mudar de um voo para outro,
 * ou de uma poltrona para outra. 
 * 
 * Existem dois métodos para comparação: um onde se é comparado a igualdade do
 * estado da classe, equals, e um onde se é comparado se as pessoas de dois passageiros
 * são iguais, comparaPessoa, ou seja, se tem o mesmo CPF. Obviamente sabemos que muitas
 * pessoas tem nomes parecidos, mas com CPFs diferentes. Originalmente, o método também
 * comparava o nome, porém, para manter a realidade do programa, isso foi retirado.
 * 
 * A classe possui dois construtores: um público, único acessível pelo usuário, e um
 * privado, acessível somente dentro da classe. A decisão em ter um segundo construtor
 * foi unicamente pelo método clone, que precisa associar cada elemento de uma instância à
 * outra, porém, o construtor não deve permitir que uma nova instãncia escolha uma cadeira 
 * que já pertença a outro passageiro. Logo, foi criado um construtor privado que faz tudo,
 * menos associar a poltrona ao passageiro. O construtor público utiliza o construtor privado
 * para as inicializações, faz a verificação de poltronas e estabelece seu valor. O método,
 * clone, então, também chama o construtor privado e faz a associação da poltrona fora a parte,
 * dessa vez sem verificações. Isso foi feito para preencher um índice do vetor de poltronas,
 * na classe Voo, e resguardar uma cópia da instância atual, no método mudarVoo.
 * 
 * Essa classe também se utiliza da classe Voo, recebendo parãmetros nos métodos, e guardando
 * uma referência à instância da classe Voo a qual essa instância da classe Passageiro pertence.
 * Essa instância é guardada para facilitar a utilização do método mudarVoo, que precisa ter 
 * acesso aos dois voos: o atual e o desejado. 
 * 
 * Finalmente, essa classe dispõe de dois atributos para resguardar o CPF do passageiro: um
 * numerico e uma String. O valor numérico foi guardado simplesmente para facilitar as comparações
 * e o método clone, já que o construtor recebe um long para converter em uma String formatada.
 * 
 * @author  Pedro M. Botelho
 * @version 1.0
 * @since   29/10/2021
 */

public class Passageiro {
    /**
     * Representa o nome do tripulante do voo.
     */
    private final String nome;

    /**
     * Representa o CPF do tripulante do voo. Essa String é salva no formato padrão brasileiro,
     * com 11 dígitos: xxx.xxx.xxx-xx. Uma função privada foi feita especialmente para formatar
     * o CPF corretamente.
     */
    private final String CPF;
    
    /**
     * Representa o número do CPF do tripulante do voo.
     */
    private final long numericCPF;
    
    /**
     * Referência à instância da classe Voo a qual o passageiro deseja entrar. Não guarda uma
     * cópia do objeto da classe Voo, mas sim uma referência ao objeto que representa o voo,
     * podendo acessar então os métodos da classe referente à instância dentro da classe Passageiro.
     * 
     */
    private Voo vooAtual;
    
    /**
     * Guarda a poltrona que o tripulante ocupa no voo, de 1 a 100. Caso esse número seja negativo,
     * então o voo está cheio. 
     */
    private byte poltrona;

    /**
     * Formata o número do CPF do tripulante em uma String que segue os padrões brasileiros, ou seja,
     * uma string 11 dígitos separados por pontos e hífen: "xxx.xxx.xxx-xx".
     * 
     * Caso um CPF inválido seja passado, será atribuído 1 a ele, e sua forma será: "000.000.000-01".
     * 
     * Esse método privado adicional foi criado para suprir a necessidade de um CPF imutável na classe.
     * 
     * Primeiramente é criado uma String auxiliar que irá receber o número do CPF já no formato de uma
     * string. Para isso, é usado o método format para criar uma string com 11 espaços, preenchidos com
     * zeros, e, alinhado à direita, preenchido com os números do CPF informado. Então, em posse da String
     * do CPF, é criado uma String formatada, com os campos separados por pontos e hífens, e a esses campos
     * é atribuído uma parte respectiva da String do CPF, e, para isso, é usado o método substring.
     * 
     * @param CPF O número de CPF do tripulante. Caso seja inválido, ou seja, zero ou menor, será
     * substiuído por "1".
     * @return Uma String contendo o CPF formatado no padrão brasileiro da documentação.
     */
    private String formatCPF(long CPF){
        CPF = (CPF > 0) ? CPF : 1;
        String strCPF = String.format("%011d", CPF);
        return String.format("%s.%s.%s-%s", strCPF.substring(0, 3), strCPF.substring(3, 6), strCPF.substring(6, 9), strCPF.substring(9, 11));
    }

    /**
     * Cria um passageiro e atribui a ele um voo e uma poltrona. A poltrona, passada como parâmetro, será
     * verificada por disponibilidade, e caso esta disponível, será atribuída ao passageiro. Caso não,
     * a primeira poltrona livre, a partir da primeira, será atribuída. Caso nenhuma poltrona esteja livre
     * o seu valor será negativo.
     * 
     * @param nome Nome do tripulanete.
     * @param voo Referência ao voo que o tripulante deseja embarcar.
     * @param CPF Número do CPF do tripulante. Caso seja inválido será atribuído 1.
     * @param poltrona Poltrona desejada pelo tripulante. Caso não esteja disponível outra será atribuída.
     * Caso nenhuma esteja, será atribuído o valor -128.
     */
    public Passageiro(String nome, Voo voo, long CPF, byte poltrona){
        this(nome, voo, CPF);
        this.poltrona = (voo.verificaPoltrona(poltrona)) ? poltrona : voo.proximoLivre();
    }

    /**
     * Cria um passageiro e atribui a ele um voo. Esse construtor privado não inclui a inicialização da
     * poltrona, por motivos de reúso de código e integridade do programa.
     * 
     * Esse construtor é usado na criação do método clone e no cosntrutor público.
     * 
     * @param nome Nome do tripulanete.
     * @param voo Referência ao voo que o tripulante deseja embarcar.
     * @param CPF Número do CPF do tripulante. Caso seja inválido será atribuído 1.
     */
    private Passageiro(String nome, Voo voo, long CPF){
        this.nome = (nome != null) ? nome : "";
        this.numericCPF = (CPF > 0) ? CPF : 1;
        this.CPF = this.formatCPF(CPF);
        this.vooAtual = voo;
    }

    /**
     * Devolve o nome do passageiro.
     * @return O nome do passageiro.
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Devolve a poltrona que o passageiro ocupa.
     * @return A poltrona do passageiro.
     */
    public byte getPoltrona(){
        return this.poltrona;
    }
    
    /**
     * Devolve a String formatada com o número de CPF do passageiro no padrão brasileiro.
     * @return O CPF do passageiro formatado.
     */
    public String getCPF(){
        return this.CPF;
    }

    /**
     * Devolve o número de CPF do passageiro.
     * @return O CPF do passageiro.
     */
    public long getnumericCPF(){
        return this.numericCPF;
    }

    /**
     * Devolve o número do voo que o passageiro está.
     * @return O número do voo do passageiro.
     */
    public int getNumVoo(){
        return this.vooAtual.getVoo();
    }

    /**
     * Devolve uma referência ao objeto da classe Voo a qual essa instãncia Passageiro pertence.
     * @return Uma referência ao voo do passageiro.
     */
    public Voo getVoo(){
        return this.vooAtual;
    }

    /**
     * Realiza a mudança de voo do passageiro. Caso a mudança de voo não seja possível os dados
     * não são alterados. A variável "checarPoltrona" guarda a poltrona que o passageiro ira
     * ocupar, após realizar uma verificação. Caso nenhuma poltrona esteja disponível então o
     * método irá retornar falso.
     * 
     * O método pode retornar falso em muitos casos, como caso não seja possível ocupar uma
     * poltrona, ou não tenham poltronas livres, ou não seja possível desocupar uma poltrona.
     * 
     * @param vooDesejado Referência ao voo que o passageiro deseja embarcar.
     * @param poltrona Poltrona que o passageiro deseja ocupar no voo.
     * @return "true" se foi possível mudar de voo, e "false" caso contrário.
     */
    public boolean mudarVoo(Voo vooDesejado, byte poltrona){
        Passageiro copia = this.clone();
        this.poltrona = (vooDesejado.verificaPoltrona(poltrona)) ? poltrona : vooDesejado.proximoLivre();
        this.vooAtual = vooDesejado;
        if(vooDesejado.ocupaPoltrona(this.poltrona, this)){
            if(copia.vooAtual.desocupaPoltrona(copia)){
                return true;
            }
        }
        this.vooAtual.ocupaPoltrona(copia.getPoltrona(), copia);
        this.poltrona = copia.poltrona;
        this.vooAtual = copia.vooAtual;
        return false;
    }

    /**
     * Realiza a mudança de poltrona do passageiro no voo atual. Caso a mudança de poltrona
     * não seja possível os dados não são alterados. A variável "checarPoltrona" guarda a
     * poltrona que o passageiro ira ocupar, após realizar uma verificação. Caso nenhuma
     *  poltrona esteja disponível então o método irá retornar falso.
     * 
     * O método pode retornar falso em muitos casos, como caso não seja possível ocupar uma
     * poltrona, ou não tenham poltronas livres, ou não seja possível desocupar uma poltrona.
     * 
     * @param poltrona Outra poltrona que o passageiro deseja ocupar no voo.
     * @return "true" se foi possível mudar de poltrona, e "false" caso contrário.
     */
    public boolean mudarPoltrona(byte poltrona){
        return this.mudarVoo(this.getVoo(), poltrona);
    }

    /**
     * Compara os números a igualdade de dois tripulantes. Caso sejam iguais, então os dois tripulantes
     * são a mesma pessoa. A comparação é feita, em condições normais, usando apenas o CPF.
     * 
     * No caso de, na inicialização do objeto, um CPF inválido ser passado, o CPF será configurado
     * para 1. Então, é possível que vários tripulantes tenham o CPF igual. Logo, se o CPF dos dois 
     * tripulantes for igual a "1", e caso sejam iguais, então a comapração será entre seus nomes. Caso
     * não, será apenas entre seus CPF.
     * 
     * @param individuo Um tripulante para testar sua igualdade.
     * @return "true" caso sejam iguais, e "false" caso sejam diferentes.
     */
    public boolean comparaPessoa(Passageiro individuo){
        if(this.numericCPF == individuo.numericCPF && this.numericCPF == 1){
            return (this.nome.equals(individuo.nome));
        }
        return (this.numericCPF == individuo.numericCPF);
    }

    /**
     * Compara os dois objetos, e diz se são iguais ou não.
     * 
     * @param individuo Um tripulante para testar sua igualdade.
     * @return "true" caso sejam iguais, e "false" caso sejam diferentes.
     */
    public boolean equals(Passageiro individuo){
        return (this.numericCPF == individuo.numericCPF) && (this.nome.equals(individuo.nome)) && (this.vooAtual.getVoo() == individuo.vooAtual.getVoo()) && (this.poltrona == individuo.poltrona);
    }

    /**
     * Cria uma cópia do objeto atual da classe. Essa cópia ocupará, inclusive, a mesma poltrona
     * que a original.
     * 
     * @return Uma referência a uma instância da classe com a mesmo estado da instância que invocou
     * o método. 
     */
    public Passageiro clone(){
        Passageiro copia = new Passageiro(this.nome, this.vooAtual, this.numericCPF);
        copia.poltrona = this.poltrona;
        return copia;
    }

    /**
     * Devolve ao usuário da classe as principais informações da instância.
     * 
     * @return As informações principais do passageiro, formatadas em uma String.
     */
    public String toString(){
        return String.format("Passageiro: %s%nCPF: %s%nNúmero do Voo: %08d%nPoltrona: %03d", this.nome, this.CPF, this.vooAtual.getVoo(), this.poltrona);
    }
}