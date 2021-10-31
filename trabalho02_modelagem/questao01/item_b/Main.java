package questao01.item_b;

public class Main {
    public static void main(String[] args){
        HoraPrecisa horaCorrente = new HoraPrecisa();
        
        final byte HORAS = 20;
        final byte MINUTOS = 40;
        final byte SEGUNDOS = 56;
        final byte CENTESIMOS = 80;

        horaCorrente.inicializaHora(HORAS, MINUTOS, SEGUNDOS, CENTESIMOS);
        System.out.println(horaCorrente.getHoras());
        System.out.println(horaCorrente.getMinutos());
        System.out.println(horaCorrente.getSegundos());
        System.out.println(horaCorrente.getCentesimos());
        horaCorrente.mostraHoras();

        HoraPrecisa horaReferencia = new HoraPrecisa();
        horaReferencia.inicializaHora((byte) 23, (byte) 59, (byte) 59, (byte) 99);
        System.out.println(horaReferencia.getHoras());
        System.out.println(horaReferencia.getMinutos());
        System.out.println(horaReferencia.getSegundos());
        System.out.println(horaReferencia.getCentesimos());
        horaReferencia.mostraHoras();

        System.out.println(horaCorrente.horaIgual(horaReferencia));
    }
}
