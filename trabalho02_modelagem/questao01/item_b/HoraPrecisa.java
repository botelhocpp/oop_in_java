package questao01.item_b;

/**
 * 
 * A classe HoraPrecisa contém campos e metodos que permitem a 
 * manipulacao de horários no formato preciso: 
 * HORAS:MINUTOS:SEGUNDOS:CENTESIMOS 
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 *  byte horas                                    (reaproveitado)
 *  byte minutos                                  (reaproveitado)
 *  byte segundos                                 (original)
 *  byte centesimos                               (original)
 * Métodos:
 *  void inicializaHora(byte, byte, byte, byte)   (melhorado)
 *  byte getHoras()                               (reaproveitado)
 *  byte getMinutos()                             (reaproveitado)
 *  byte getSegundos()                            (original)
 *  byte getCentesimos()                          (original)
 *  boolean horaValida(byte, byte, byte, byte)    (melhorado)
 *  boolean horaIgual(HoraAproximada)             (melhorado)
 *  void mostraHoras()                            (melhorado)
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

public class HoraPrecisa {

    /**
     * Representam as horas do formato preciso:
     * HORAS:minutos:segundos:centesimos
     * Seu valor deve estar entre 0 e 23, incluindo os limites, sempre.
     */
    private byte horas;
    
    /**
     * Representam os minutos do formato preciso:
     * horas:MINUTOS:segundos:centesimos
     * Seu valor deve estar entre 0 e 59, incluindo os limites, sempre.
     */
    private byte minutos;

    /**
     * Representam os segundos do formato preciso:
     * horas:minutos:SEGUNDOS:centesimos
     * Seu valor deve estar entre 0 e 59, incluindo os limites, sempre.
     */
    private byte segundos;

    /**
     * Representam os centésimos de segundos do formato preciso:
     * horas:minutos:segundos:CENTESIMOS
     * Seu valor deve estar entre 0 e 99, incluindo os limites, sempre.
     */
    private byte centesimos;

    /**
     * Inicializa os atributos da classe HoraPrecisa, referente ao
     * objeto instanciado, usando os parâmetros passados.
     * Antes disso, é realizado uma verificação, checando se os
     * valores passados como parâmetros estão dentro os limites
     * estabelecidos, por meio de uma estrutura if-else. Caso não 
     * estejam dentro dos limites, é atribuído valor 0 a todos.
     * @param h Representa as horas, referente ao atributo da classe.
     * @param min Representa os minutos, referente ao atributo da 
     * classe.
     * @param seg Representa os segundos, referente ao atributo da 
     * classe.
     * @param cent Representa os centésimos de segundo, referente ao 
     * atributo da classe.
     */
    public void inicializaHora(byte h, byte min, byte seg, byte cent){
        if(horaValida(h, min, seg, cent)){
            horas = h;
            minutos = min;
            segundos = seg;
            centesimos = cent;
        }
        else{
            horas = 0;
            minutos = 0;
            segundos = 0;
            centesimos = 0;
        }

        /*
        As seguintes operações poderiam ser feitas alternativamente.
        Dessa forma apenas ao campo fora dos limites seria
        atribuído zero.

        horas = (h >= 0 && h < 24) ? h : 0;
        minutos = (min >= 0 && min < 60) ? min : 0;
        segundos = (seg >= 0 && seg < 60) ? seg : 0;
        centesimos = (cent >= 0 && cent < 100) ? cent : 0;
        */
    }

    /**
     * Devolve o atributo 'horas' encapsulado.
     * @return As horas referentes à instancia da classe.
     */
    public byte getHoras(){
        return horas;
    }

    /**
     * Devolve o atributo 'minutos' encapsulado.
     * @return Os minutos referentes à instancia da classe.
     */
    public byte getMinutos(){
        return minutos;
    }

    /**
     * Devolve o atributo 'segundos' encapsulado.
     * @return Os segundos referentes à instancia da classe.
     */
    public byte getSegundos(){
        return segundos;
    }

    /**
     * Devolve o atributo 'centesimos' encapsulado.
     * @return Os centesimos de segundos referentes à instancia da 
     * classe.
     */
    public byte getCentesimos(){
        return centesimos;
    }

    /**
     * Verifica se os dados que representam o horário estão dentro
     * dos limites. Isso é feito por meio de uma estrutura de if-else
     * muito simples, verificando os limites.
     * @param h Representa as horas, referente ao atributo da classe.
     * @param min Representa os minutos, referente ao atributo da 
     * classe.
     * @param seg Representa os segundos, referente ao atributo da 
     * classe.
     * @param cent Representa os centésimos de segundo, referente ao 
     * atributo da classe.
     * @return 'true' se os dados que representam o horário estiverem
     * dentro dos limites, e 'false' caso contrário.
     */
    public boolean horaValida(byte h, byte min, byte seg, byte cent){
        if((h >= 0 && h < 24) && (min >= 0 && min < 60)
        && (seg >= 0 && seg < 60) && (cent >= 0 && cent < 100)){
            return true;
        }
        return false;
    }

    /**
     * Verifica a igualdade entre dois objetos da classe HoraPrecisa
     * por meio de uma estrutura if-else simples, verificando os
     * atributos desta instância com a instância de parâmetro.
     * @param horario Representa um objeto da classe HoraPrecisa,
     * a qual será verificada a igualdade em relação à primeira 
     * instância da classe.
     * @return 'true' se os objetos representam o mesmo horário
     * padronizado, e 'false' caso contrário.
     */
    public boolean horaIgual(HoraPrecisa horario){
        if(horas == horario.horas && minutos == horario.minutos
        && segundos == horario.segundos
        && centesimos == horario.centesimos){
            return true;
        }
        return false;
    }

    /**
     * Imprime o horário padronizado, representado pelos atributos
     * da classe, da seguinte maneira formatada: 00:00:00:00, onde cada
     * campo é uma "caixa" de tamanho dois, preenchida com zeros.
     */
    public void mostraHoras() {
        System.out.printf("%02d:%02d:%02d:%02d\n",
        horas, minutos, segundos, centesimos);
    }
}
