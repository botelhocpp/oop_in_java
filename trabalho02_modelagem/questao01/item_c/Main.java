package questao01.item_c;

public class Main {
    public static void main(String[] args){
        DataHora horaCorrente = new DataHora();
        
        final byte HORAS = 17;
        final byte MINUTOS = 32;
        final byte DIA = 24;
        final byte MES = 10;
        final short ANO = 2021;

        horaCorrente.inicializaDataHora(HORAS, MINUTOS, DIA, MES, ANO);
        System.out.println(horaCorrente.getHoras());
        System.out.println(horaCorrente.getMinutos());
        System.out.println(horaCorrente.getDia());
        System.out.println(horaCorrente.getMes());
        System.out.println(horaCorrente.getAno());
        horaCorrente.mostraDataHoras();

        DataHora horaReferencia = new DataHora();
        horaReferencia.inicializaDataHora((byte) 23, (byte) 59, (byte) 31, (byte) 12, (short) 2099);
        System.out.println(horaReferencia.getHoras());
        System.out.println(horaReferencia.getMinutos());
        System.out.println(horaReferencia.getDia());
        System.out.println(horaReferencia.getMes());
        System.out.println(horaReferencia.getAno());
        horaReferencia.mostraDataHoras();

        System.out.println(horaCorrente.dataIgual(horaReferencia));
    }
}
