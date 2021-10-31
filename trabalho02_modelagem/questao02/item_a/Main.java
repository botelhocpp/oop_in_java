package questao02.item_a;

public class Main {
    public static void main(String[] args){
        Ponto2D ponto01 = new Ponto2D();
        ponto01.inserirPonto(3, 3);
        ponto01.mostraPonto();
        Ponto2D ponto02 = new Ponto2D();
        ponto02.inserirPonto(-3, -3);
        ponto02.mostraPonto();
        System.out.println(ponto01.ehIgual(ponto02));
    }
}
