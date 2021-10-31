package questao01.item_c;

/**
 * 
 * A classe DataHora contém campos e metodos que permitem a 
 * manipulacao de datas e horários no formato aproximado: 
 * DIA/MES/ANO HORAS:MINUTOS
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Essa classe foi implementada usando os métodos e atributos das classes
 * 'HoraAproximada' e 'Data'.
 * 
 * Atributos:
 *  HoraAproximada horaInstancia
 *  Data dataInstancia
 * Métodos:
 *  void inicializaDataHora(byte, byte, byte, byte, short)
 *  byte getHoras()
 *  byte getMinutos()
 *  byte getDia()
 *  byte getMes()
 *  short getAno()
 *  boolean horaValida(byte, byte)
 *  boolean dataValida(byte, byte, short)
 *  boolean dataHoraValida(byte, byte, byte, byte, short)
 *  boolean dataIgual(dataReferencial)
 *  void mostraDataHoras()
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

import questao01.item_a.HoraAproximada;

public class DataHora {

    /**
     * Representa o horário no formato aproximado HORAS:MINUTOS.
     */
    HoraAproximada horaInstancia;

    /**
     * Representa a data no formato DIA/MES/ANO.
     */
    Data dataInstancia;

    /**
     * Inicializa os atributos da classe DataHora, referente ao
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
    public void inicializaDataHora(byte h, byte min, byte d, byte m, short a) {
        horaInstancia = new HoraAproximada();
        dataInstancia = new Data();

        if(dataHoraValida(h, min, d, m ,a)){
            horaInstancia.inicializaHora(h, min);
            dataInstancia.inicializaData(d, m, a);
        }
        else{
            horaInstancia.inicializaHora((byte) 0, (byte) 0);
            dataInstancia.inicializaData((byte) 1, (byte) 1, (short) 2010);
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
        return horaInstancia.getHoras();
    }

    /**
     * Devolve o atributo 'minutos' encapsulado.
     * @return Os minutos referentes à instancia da classe.
     */
    public byte getMinutos() {
        return horaInstancia.getMinutos();
    }

    /**
     * Devolve o atributo 'dia' encapsulado.
     * @return O dia referente à instancia da classe.
     */
    public byte getDia() {
        return dataInstancia.getDia();
    }

    /**
     * Devolve o atributo 'mes' encapsulado.
     * @return O mes referente à instancia da classe.
     */
    public byte getMes() {
        return dataInstancia.getMes();
    }

    /**
     * Devolve o atributo 'ano' encapsulado.
     * @return O ano referente à instancia da classe.
     */
    public short getAno() {
        return dataInstancia.getAno();
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
        return horaInstancia.horaValida(h, min);
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
        return dataInstancia.dataEhValida(d, m, a);
    }

    /**
     * Verifica se os dados que representam a data e hroa estão dentro
     * dos limites. Isso é feito por meio de uma estrutura de if-else
     * muito simples, verificando os limites.
     * @param h Representa as horas, referente ao atributo da classe.
     * @param min Representa os minutos, referente ao atributo da 
     * classe.
     * @param d Representa o dia, referente ao atributo da classe.
     * @param m Representa o mês, referente ao atributo da classe.
     * @param a Representa o ano, referente ao atributo da classe.
     * @return 'true' se os dados que representam a data estiverem
     * dentro dos limites, e 'false' caso contrário.
     */
    public boolean dataHoraValida(byte h, byte min, byte d, byte m, short a) {
        return horaValida(h, min) && dataValida(d, m, a);
    }

    /**
     * Verifica a igualdade entre dois objetos da classe DataHora
     * por meio de uma estrutura if-else simples, verificando os
     * atributos desta instância com a instância de parâmetro.
     * @param dataReferencial Representa um objeto da classe DataHora,
     * a qual será verificada a igualdade em relação à primeira 
     * instância da classe.
     * @return 'true' se os objetos representam a mesma data e horário
     * padronizado, e 'false' caso contrário.
     */
    public boolean dataIgual(DataHora dataReferencial) {
        return horaInstancia.horaIgual(dataReferencial.horaInstancia) && dataInstancia.ehIgual(dataReferencial.dataInstancia);
    }

    /**
     * Imprime a data e o horário padronizado, representado pelos atributos
     * da classe, da seguinte maneira formatada: 
     * 00/00/0000 00:00, onde cada
     * campo é uma "caixa" de tamanho dois, preenchida com zeros, com
     * excessão da caixa do 'ano', que tem tamanho quatro.
     */
    public void mostraDataHoras() {
        dataInstancia.mostraData();
        horaInstancia.mostraHoras();
    }
}
