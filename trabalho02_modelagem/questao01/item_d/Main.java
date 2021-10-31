package questao01.item_d;

public class Main {
    public static void main(String[] args){
        Data dataAtual = new Data();
        dataAtual.inicializaData((byte) 31, (byte) 13, (short) 2099);
        dataAtual.mostraData();
    }
}
