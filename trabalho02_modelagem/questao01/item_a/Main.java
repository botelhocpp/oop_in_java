package questao01.item_a;

public class Main {
    public static void main(String[] args){
        HoraAproximada horaCorrente = new HoraAproximada();
        
        final byte HORAS = 20;
        final byte MINUTOS = 40;

        horaCorrente.inicializaHora(HORAS, MINUTOS);
        System.out.println(horaCorrente.getHoras());
        System.out.println(horaCorrente.getMinutos());
        horaCorrente.mostraHoras();

        HoraAproximada horaReferencia = new HoraAproximada();
        horaReferencia.inicializaHora((byte) 60, (byte) 70);
        System.out.println(horaReferencia.getHoras());
        System.out.println(horaReferencia.getMinutos());
        horaReferencia.mostraHoras();

        System.out.println(horaCorrente.horaIgual(horaReferencia));
    }
}
