package questao03.Aviao;

import questao02.Calendario.Data;

/**
 * A classe Voo, da biblioteca Aviao, permite a representação de
 * um voo, que acontece em determinada data e em determinado horário,
 * e que transpota no máximo 100 passageiros.
 * 
 * Os atributos estão protegidos, para evitar sua incorreta 
 * manipulação, devendo ser utilizados métodos para modificar
 * ou obtê-los. Logo, para, por exemplo, ocupar e desocupar 
 * vagas é necessário a utilização de métodos específicos 
 * para isso, que vão verificar a integridade das informações
 * antes de passarem para os atributos da classe.
 * 
 * Essa classe se utiliza da classe Data, da biblioteca Calendario,
 * para armazenar a data e o horário de cada voo. Logo, é utilizado
 * a representação apropriada para isso: dd/mm/aaaa hh/mi.
 * 
 * Essa classe também se utiliza da classe Passageiro, cujos objetos
 * representam os tripulantes de cada voo. Ocorre referência circular
 * entre esta classe e a classe Passageiro, mas isso não é um problema.
 * 
 * Essa classe dispõe de dois construtores, um utilizado quando os
 * passageiros serão colocados no decorrer do programa, e outro para
 * quando já se tem todos os passageiros agrupados em um array, provindos,
 * por exemplo, de um banco de dados e/ou de um arquivo.
 * 
 * Ainda, esta classe possui dois métodos específicos para que um passageiro
 * ocupe uma cadeira: ocupaPoltrona. É recomendável que se use o método
 * que recebe apenas um parâmetro, da classe Passageiro, pois ele realizará
 * atividades de verificação, aumentando a segurança do sistema.
 * 
 * @author  Pedro M. Botelho
 * @version 1.0
 * @since   29/10/2021
 */

public class Voo {
    /**
     * Representa o número do voo, que por sua vez identifica este voo
     * em meio aos demais, no sistema de controle de voos. Foi escolhido
     * que este atributo não seja atribuído por outra variável estática, 
     * como por exemplo por uma variável que conte os outros voos, por 
     * motivos de simplicidade.
     */
    private final int numeroVoo;

    /**
     * Representa a data e a hora do voo. Esta instância da classe Data 
     * tem, então, a forma padrão dd/mm/aaaa hh/mi.
     */
    private final Data dataHorario;

    /**
     * Representa a quantidade máxima de passageiros que podem embarcar
     * a aeronave por voo.
     */
    private final byte MAXIMO_PASSAGEIROS;
    
    /**
     * As 100 poltronas do avião, que comportam objetos da classe Passageiro.
     * O usuário desta classe acessará as poltronas de 1 a 100, porém os
     * métodos irão sempre subtrair 1 ao índice. Logo, a poltrona 0 não existe.
     * Essa poltronas serão controladas pelos métodos, podendo ser ocupadas
     * e desocupadas. Índices nulos remetem a poltronas vazias.
     */
    private Passageiro[] poltronas;

    /**
     * Representa a quantidade de passageiros a bordo da aeronave. Esse número
     * é incrementado ou decrementado conforme as poltronas são ocupadas ou
     * desocupadas.
     */
    private byte quantidadePassageiros; 

    /**
     * Conta quantidade de passageiros, ou seja, a quantidade de elementos não-nulos,
     * em um vetor de instâncias da classe Passageiro.
     * 
     * @param passageiros Vetor de tripulantes de voo. Apenas elementos não-nulos serão
     * contado.
     * @return Quantidade de elementos não nulos do vetor.
     */
    private int contarPassageiros(Passageiro[] passageiros) {
        int contador = 0;
        for (Object obj : passageiros) {
            if(obj != null){
                contador++;
            }
        }
        return contador;
    }

    /**
     * Inicializa o voo da maneira mais simples, com todas as poltronas vazias,
     * e apenas com o número identificador de voo e com sua data e horário. Se
     * o identificador de voo for zero, ou menor, é automaticamente configurado
     * para 1.
     * 
     * @param numeroVoo O identificador do voo no sistema de controle.
     * @param dataHorario A data, e horário, em que acontecerá o voo.
     */
    public Voo(int numeroVoo, Data dataHorario){
        this.numeroVoo = (numeroVoo > 0) ? numeroVoo : 1;
        this.dataHorario = dataHorario.clone();
        this.MAXIMO_PASSAGEIROS = 100;
        this.poltronas = new Passageiro[this.MAXIMO_PASSAGEIROS];
    }

    /**
     * Inicializa o voo já com tripulantes devidamente configurados. Primeiramente
     * é inicializado os atributos da maneira convencional. Então cada elemento do
     * vetor de passageiros, passado como argumento, é clonado para o vetor das
     * poltronas da instância. Antes de copiar é verificado se o elemento a ser
     * copiado não é nulo. Se não for nulo, então o método clone da classe
     * Passageiro é chamado. Aqui é usado um foreach para facilitar a vizualização.
     * 
     * @param numeroVoo O identificador do voo no sistema de controle.
     * @param dataHorario A data, e horário, em que acontecerá o voo.
     * @param tripulante Um array de objetos da classe Passageiro a serem repassados
     * para as poltronas desta instância da classe Voo.
     */
    public Voo(int numeroVoo, Data dataHorario, Passageiro[] tripulante){
        this(numeroVoo, dataHorario);
        for(Passageiro copia : tripulante){
            if(copia != null){
                this.ocupaPoltrona(copia.clone());
            }
        }
        this.quantidadePassageiros = (byte) this.contarPassageiros(tripulante);
    }

    /**
     * Verifica se uma poltrona, no voo representado por esta instância, está vaga.
     * Além disso, verifica também se o parâmetro respeita os limites estabelecidos.
     * 
     * @param poltrona Representa um índice no vetor de passageiros. Deve estar
     * entre 1 e 100, incluíndo os limites.
     * @return "true" se o valor de "poltrona" está dentro dos limites, e, se sim,
     * se o índice que ela representa está livre, e "false" caso contrário.
     */
    public boolean verificaPoltrona(byte poltrona){
        return (poltrona < this.MAXIMO_PASSAGEIROS && poltrona > 0 && this.poltronas[poltrona - 1] == null) ? true : false;
    }

    /**
     * Verifica qual a próxima poltrona livre, a partir do início do vetor, e,
     * caso tenha alguma poltrona livre, retorna o índice correspondente somado
     * a 1.
     * 
     * @return A próxima poltrona livre, ou, caso não tenham poltronas livres,
     * o menor valor representável por um byte.
     */
    public byte proximoLivre(){
        for(byte i = 1; i <= this.MAXIMO_PASSAGEIROS; i++){
            if(this.verificaPoltrona(i)){
                return i;
            }
        }
        return Byte.MIN_VALUE;
    }

    /**
     * Preenche uma poltrona do avião com um tripulante, ambos especificados. Poucas 
     * verificações são feitas, como verificar se a instância passada como parâmetro 
     * não é nula ou se o avião já atingiu sua capacidade máxima. Caso não, a 
     * disponibilidade da poltrona é verificada, e, caso esteja vazia, o tripulante
     * é alocado para ela. A quantidade de passageiros é incrementada, então.  
     * 
     * Esse método é recomendado quando se precisa seguir estritamente o alocamento de
     * poltronas, descrito nas instâncias da classe Passageiro, já que não oferece  
     * mecanismos de verificação suficiente. Esse método é usado por outro método 
     * de mesmo nome, que oferece mais flexibilidade ao usuário.
     * 
     * @param poltrona Representa a poltrona que o tripulante irá sentar. Deve respeitar
     * os limites, devendo estar entre 1 e 100, incluíndo os limites. 
     * @param tripulante O passageiro a ser alocado para a poltrona especificada.
     * @return "true" caso a operação seja bem sucedida, e "false" caso contrário.
     */
    public boolean ocupaPoltrona(byte poltrona, Passageiro tripulante){
        if(tripulante == null || this.quantidadePassageiros == this.MAXIMO_PASSAGEIROS ){
            return false;
        }
        if(this.verificaPoltrona(poltrona)){
            this.poltronas[poltrona - 1] = tripulante.clone();
            this.quantidadePassageiros++;
            return true;
        }
        return false;
    }

    /**
     * Preenche uma poltrona do avião com um tripulante especificado. A poltrona
     * preenchida será a cadastrada na instância de parâmetro, logo, será obtida
     * por meio do método getPoltrona.
     * 
     * Mais verificações são efetuadas. Caso não seja possível ocupar a poltrona
     * especificada pelo objeto é, então, verificada a próxima próxima poltrona
     * livre, e então, é ocupada. Caso não seja possível a ocupar, o voo está 
     * cheio. O retorno condiz com o status da alocação. Esse método se utiliza
     * do outro de mesmo nome, oferecendo mais uma camada de flexibilidade ao
     * usuário.
     * 
     * Esse método é ideal para cenários em que não é necessário atender a um quadro 
     * muito estrito de alocações das poltronas.
     * 
     * @param tripulante O passageiro a ser alocado para a poltrona, especificada em
     * sua própria instância.
     * @return "true" caso a operação seja bem sucedida e "false" caso contrário, ou 
     * seja, nenhuma cadeira esteja disponível.
     */
    public boolean ocupaPoltrona(Passageiro tripulante){
        if(this.ocupaPoltrona(tripulante.getPoltrona(), tripulante)){
            return true;
        }
        else{
            return this.ocupaPoltrona(this.proximoLivre(), tripulante);
        }
    }

    /**
     * Desocupa uma poltrona especificada na instância de parâmetro, caso ela pertença,
     * verdadeiramente, ao tripulante em específico. É realizada uma verificação com base
     * no CPF do tripulante, para ter certeza que o passageiro na poltrona é realmente ele.
     * A quantidade de passageiros é decrementada em sucesso.
     * 
     * @param tripulante O passageiro a ser desalocado da poltrona, especificada em
     * sua própria instância.
     * @return "true" caso seja possível desocupar a poltrona, e "false" caso contrário.
     */
    public boolean desocupaPoltrona(Passageiro tripulante){
        if(this.poltronas[tripulante.getPoltrona() - 1].getnumericCPF() == tripulante.getnumericCPF()){
            this.poltronas[tripulante.getPoltrona() - 1] = null;
            quantidadePassageiros--;
            return true;
        }
        return false;
    }

    /**
     * Devolve para o usuário o número do voo.
     * @return Número do voo da instância.
     */
    public int getVoo(){
        return this.numeroVoo;
    }

    /**
     * Devolve para o usuário a data do voo.
     * @return Uma cópia do objeto da classe Data, da instância.
     */
    public Data getData(){
        return this.dataHorario.clone();
    }

    /**
     * Devolve para o usuário a quantidade de vagas disponíveis para
     * tripulantes, na aeronave.
     * @return A quantidade atual de passageiros subtraída do número
     * máximo de passageiros.
     */
    public byte getVagas(){
        return (byte) (this.MAXIMO_PASSAGEIROS - this.quantidadePassageiros);
    }

    /**
     * Devolve para o usuário a quantidade de passageiros na aeronave.
     * @return Quantidade de passageiros a bordo da aeronave.
     */
    public byte getQuantPassageiros(){
        return this.quantidadePassageiros;
    }

    /**
     * Devolve para o usuário uma String preenchida com todos os passageiros
     * do voo, em ordem de poltronas. Essa String não contém elementos nulos.
     * 
     * @return A referência para uma copia do vetor com os passageiros do voo.
     */
    public Passageiro[] getPassageiros(){
        Passageiro[] copia = new Passageiro[this.quantidadePassageiros];
        for(int i = 0, j = 0; i < this.MAXIMO_PASSAGEIROS; i++){
            if(this.poltronas[i] != null){
                copia[j++] = this.poltronas[i].clone();
            }
        }
        return copia;
    }

    /**
     * Devolve para o usuário uma copia da alocação das poltronas do voo,
     * ou seja, é retornado uma referência para um vetor de passageiros,
     * onde cada passageiro é uma exata cópia dos passageiros deste voo,
     * em seus devidos lugares.
     * 
     * @return A referência para um vetor de passageiros com a alocação de
     * poltronas atuais.
     */
    public Passageiro[] getPoltronas(){
        Passageiro[] copia = new Passageiro[this.MAXIMO_PASSAGEIROS];
        for(int i = 0; i < this.MAXIMO_PASSAGEIROS; i++){
            if(this.poltronas[i] != null){
                copia[i] = this.poltronas[i].clone();
            }
        }
        return copia;
    }

    /**
     * Obtém um passageiro de uma poltrona específica, uma referência à uma
     * cópia do registro respectivo da instância. 
     * 
     * @param poltrona Representa a poltrona que o tripulante está sentado. 
     * Deve respeitar os limites, devendo estar entre 1 e 100, incluíndo os limites. 
     * @return A referência ao passageiro na poltrona requisitada, caso
     * seja possível localizado, ou uma referência nula.
     */
    public Passageiro getPassageiro(byte poltrona){
        return (poltrona > 0 && this.poltronas[poltrona - 1] != null) ? this.poltronas[poltrona - 1].clone() : null;
    }

    /**
     * Indica se esta instância e uma instância de parâmetro são iguais, ou seja,
     * se ao menos um de seus atributos seja diferente de uma instância para outra.
     * 
     * @param referencial Uma referência à outro objeto da classe Voo, que deve ter
     * sua igualdade testada juntamente à esta instância.
     * @return "true" caso sejam absolutamente iguais, ou seja, tenham o mesmo estado,
     * e "false" caso contrário.
     */
    public boolean equals(Voo referencial){
        if(!(this.numeroVoo == referencial.numeroVoo) || !(this.dataHorario.compara(referencial.dataHorario) == 0) || !(this.quantidadePassageiros == referencial.quantidadePassageiros)){
            return false;
        }
        for(int i = 0; i < MAXIMO_PASSAGEIROS; i++){
            if((this.poltronas[i] != null) && !(this.poltronas[i].equals(referencial.poltronas[i]))){
                return false;
            }
        }
        return true;
    }

    /**
     * Cria uma cópia do objeto atual da classe. Essa cópia receberá,
     * inclusive, a mesma alocação de poltronas.
     * 
     * @return Uma referência a uma instância da classe com a mesmo
     * estado da instância que invocou o método.
     */
    public Voo clone(){
        Passageiro[] copias = new Passageiro[this.MAXIMO_PASSAGEIROS];
        for(int i = 0; i < this.MAXIMO_PASSAGEIROS; i++){
            copias[i] = (this.poltronas[i] != null) ? this.poltronas[i].clone() : null;
        }
        Voo copia = new Voo(this.numeroVoo, this.dataHorario, copias);
        copia.quantidadePassageiros = this.quantidadePassageiros;
        return copia;
    }

    /**
     * Devolve ao usuário da classe as principais informações da instância.
     * 
     * @return As informações principais do voo, formatadas em uma String.
     */
    public String toString(){
        return String.format("Número do Voo: %08d%nData do Voo: %s%nQuantidade de Passageiros: %03d", this.numeroVoo, this.dataHorario, this.quantidadePassageiros);
    }
}