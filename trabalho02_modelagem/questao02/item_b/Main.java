package questao02.item_b;

public class Main {
    public static void main(String[] args){
        Retangulo retangulo = new Retangulo();
        retangulo.desenharRetangulo(-2, -3, 1, 1);
        retangulo.mostraRetangulo();
        Retangulo quadrado = new Retangulo();
        quadrado.desenharRetangulo(0, 0, 1, 1);
        System.out.println(retangulo.ehIgual(quadrado));
        Retangulo quadrilatero = quadrado.clone();
        System.out.println(quadrilatero.ehIgual(quadrado));
    }
}
