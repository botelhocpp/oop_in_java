package questao02.item_c;

public class Main {
    public static void main(String[] args){
        Linha traco = new Linha();
        traco.desenharLinha(-2, -3, 1, 1);
        traco.mostraLinha();

        Linha risco = new Linha();
        risco.desenharLinha(0, 0, 1, 1);
        risco.mostraLinha();
        System.out.println(risco.ehIgual(traco));

        Linha tracinho = traco.clone();
        System.out.println(tracinho.ehIgual(traco));
    }
}
