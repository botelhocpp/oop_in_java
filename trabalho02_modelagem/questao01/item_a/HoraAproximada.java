package questao01.item_a;

/**
 * 
 * A classe HoraAproximada contém campos e metodos que permitem a 
 * manipulacao de horários no formato aproximado: HORAS:MINUTOS. 
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 *  byte horas
 *  byte minutos
 * Métodos:
 *  void inicializaHora(byte, byte)
 *  byte getHoras()
 *  byte getMinutos()
 *  boolean horaValida(byte, byte)
 *  boolean horaIgual(HoraAproximada)
 *  void mostraHoras()
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

public class HoraAproximada {

    /**
     * Representam as horas do formato aproximado HORAS:minutos.
     * Seu valor deve estar entre 0 e 23, incluindo os limites, sempre.
     */
    private byte horas;
    
    /**
     * Representam os minutos do formato aproximado horas:MINUTOS.
     * Seu valor deve estar entre 0 e 59, incluindo os limites, sempre.
     */
    private byte minutos;

    /**
     * Inicializa os atributos da classe HoraAproximada, referente ao
     * objeto instanciado, usando os parâmetros passados.
     * Antes disso, é realizado uma verificação, checando se os
     * valores passados como parâmetros estão dentro os limites
     * estabelecidos, por meio de uma estrutura if-else. Caso não 
     * estejam dentro dos limites, é atribuído valor 0 a ambos.
     * @param h Representa as horas, referente ao atributo da classe.
     * @param min Representa os minutos, referente ao atributo da 
     * classe.
     */
    public void inicializaHora(byte h, byte min) {
        if(horaValida(h, min)){
            horas = h;
            minutos = min;
        }
        else{
            horas = 0;
            minutos = 0;
        }

        /*
        As seguintes operações poderiam ser feitas alternativamente.
        Dessa forma apenas ao campo fora dos limites seria
        atribuído zero.

        horas = (h >= 0 && h < 24) ? h : 0;
        minutos = (min >= 0 && min < 60) ? min : 0;
        */
    }

    /**
     * Devolve o atributo 'horas' encapsulado.
     * @return As horas referentes à instancia da classe.
     */
    public byte getHoras() {
        return horas;
    }

    /**
     * Devolve o atributo 'minutos' encapsulado.
     * @return Os minutos referentes à instancia da classe.
     */
    public byte getMinutos() {
        return minutos;
    }

    /**
     * Verifica se os dados que representam o horário estão dentro
     * dos limites. Isso é feito por meio de uma estrutura de if-else
     * muito simples, verificando os limites.
     * @param h Representa as horas, referente ao atributo da classe.
     * @param min Representa os minutos, referente ao atributo da 
     * classe.
     * @return 'true' se os dados que representam o horário estiverem
     * dentro dos limites, e 'false' caso contrário.
     */
    public boolean horaValida(byte h, byte min) {
        if(h >= 0 && h < 24 && min >= 0 && min < 60){
            return true;
        }
        return false;
    }

    /**
     * Verifica a igualdade entre dois objetos da classe HoraAproximada
     * por meio de uma estrutura if-else simples, verificando os
     * atributos desta instância com a instância de parâmetro.
     * @param horario Representa um objeto da classe HoraAproximada,
     * a qual será verificada a igualdade em relação à primeira 
     * instância da classe.
     * @return 'true' se os objetos representam o mesmo horário
     * padronizado, e 'false' caso contrário.
     */
    public boolean horaIgual(HoraAproximada horario) {
        if(horas == horario.horas && minutos == horario.minutos){
            return true;
        }
        return false;
    }

    /**
     * Imprime o horário padronizado, representado pelos atributos
     * da classe, da seguinte maneira formatada: 00:00, onde cada
     * campo é uma "caixa" de tamanho dois, preenchida com zeros.
     */
    public void mostraHoras() {
        System.out.printf("%02d:%02d\n", horas, minutos);
    }
}
