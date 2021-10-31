package questao01.item_c;

/**
 * 
 * A classe DataHoraFull contém campos e metodos que permitem a 
 * manipulacao de datas e horários no formato aproximado: 
 * DIA/MES/ANO HORAS:MINUTOS
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 *  byte horas
 *  byte minutos
 *  byte dia
 *  byte mes
 *  short ano
 * Métodos:
 *  void inicializaData(byte, byte, byte, byte, short)
 *  byte getHoras()
 *  byte getMinutos()
 *  byte getDia()
 *  byte getMes()
 *  short getAno()
 *  boolean horaValida(byte, byte)
 *  boolean dataValida(byte, byte, short)
 *  boolean horaIgual(dataReferencial)
 *  void mostraDataHoraFulls()
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

public class DataHoraFull {

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
     * Representam o dia do formato DIA/mes/ano.
     * Seu valor deve estar entre 0 e 31, incluindo os limites, sempre.
     */
    private byte dia;

    /**
     * Representam o mês do formato dia/MES/ano.
     * Seu valor deve estar entre 1 e 12, incluindo os limites, sempre.
     */
    private byte mes;

    /**
     * Representam o ano do formato dia/mes/ANO.
     * Seu valor deve estar entre 0 e 2099, incluindo os limites, 
     * sempre.
     */
    private short ano;

    /**
     * Inicializa os atributos da classe HoraAproximada, referente ao
     * objeto instanciado, usando os parâmetros passados.
     * Antes disso, é realizado uma verificação, checando se os
     * valores passados como parâmetros estão dentro os limites
     * estabelecidos, por meio de uma estrutura if-else. Caso não 
     * estejam dentro dos limites, a data e hora é configurada. para
     * 01/01/2010 00:00.
     * @param h Representa as horas, referente ao atributo da classe.
     * @param min Representa os minutos, referente ao atributo da
     * clase.
     * @param d Representa o dia, referente ao atributo da classe.
     * @param m Representa o mês, referente ao atributo da classe.
     * @param a Representa o ano, referente ao atributo da classe.
     */
    public void inicializaData(byte h, byte min, byte d, byte m, short a) {
        if(horaValida(h, min) && dataValida(d, m ,a)){
            horas = h;
            minutos = min;
            dia = d;
            mes = m;
            ano = a;
        }
        else{
            horas = 0;
            minutos = 0;
            dia = 1;
            mes = 1;
            ano = 2010;
        }

        /*
        As seguintes operações poderiam ser feitas alternativamente.
        Dessa forma apenas ao campo fora dos limites seria
        atribuído os valores padrões.

        horas = (h >= 0 && h < 24) ? h : 0;
        minutos = (min >= 0 && min < 60) ? min : 0;
        dia = (dia >= 1 && dia <= 31) ? min : 1;
        mes = (mes >= 1 && mes < 12) ? min : 1;
        ano = (ano >= 0 && ano < 2099) ? min : 2010;
         &&  && 
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
     * Devolve o atributo 'dia' encapsulado.
     * @return O dia referente à instancia da classe.
     */
    public byte getDia() {
        return dia;
    }

    /**
     * Devolve o atributo 'mes' encapsulado.
     * @return O mes referente à instancia da classe.
     */
    public byte getMes() {
        return mes;
    }

    /**
     * Devolve o atributo 'ano' encapsulado.
     * @return O ano referente à instancia da classe.
     */
    public short getAno() {
        return ano;
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
     * Verifica se os dados que representam a data estão dentro
     * dos limites. Isso é feito por meio de uma estrutura de if-else
     * muito simples, verificando os limites.
     * @param d Representa o dia, referente ao atributo da classe.
     * @param m Representa o mês, referente ao atributo da classe.
     * @param a Representa o ano, referente ao atributo da classe.
     * @return 'true' se os dados que representam a data estiverem
     * dentro dos limites, e 'false' caso contrário.
     */
    public boolean dataValida(byte d, byte m, short a) {
        if(d >= 1 && d <= 31 && m >= 1 && m <= 12 && a >= 0 && a <= 2099){
            return true;
        }
        return false;
    }

    /**
     * Verifica a igualdade entre dois objetos da classe DataHoraFull
     * por meio de uma estrutura if-else simples, verificando os
     * atributos desta instância com a instância de parâmetro.
     * @param dataReferencial Representa um objeto da classe DataHoraFull,
     * a qual será verificada a igualdade em relação à primeira 
     * instância da classe.
     * @return 'true' se os objetos representam a mesma data e horário
     * padronizado, e 'false' caso contrário.
     */
    public boolean dataIgual(DataHoraFull dataReferencial) {
        if(horas == dataReferencial.horas
        && minutos == dataReferencial.minutos
        && dia == dataReferencial.dia && mes == dataReferencial.mes
        && ano == dataReferencial.ano){
            return true;
        }
        return false;
    }

    /**
     * Imprime a data e o horário padronizado, representado pelos atributos
     * da classe, da seguinte maneira formatada: 
     * 00/00/0000 00:00, onde cada
     * campo é uma "caixa" de tamanho dois, preenchida com zeros, com
     * excessão da caixa do 'ano', que tem tamanho quatro.
     */
    public void mostraDataHoraFulls() {
        System.out.printf("%02d/%02d/%04d %02d:%02d\n", dia, mes, ano, horas, minutos);
    }
}
