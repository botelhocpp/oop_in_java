package questao01.item_e;

public class Main {
    public static void main(String[] args){
        Data dataAtual = new Data();
        dataAtual.inicializaData((byte) 29, (byte) 2, (short) 1900);
        System.out.println(dataAtual.ehBissexto());
        dataAtual.mostraData();
    }
}
