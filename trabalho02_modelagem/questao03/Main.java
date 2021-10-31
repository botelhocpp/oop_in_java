package questao03;

public class Main {
    public static void main(String[] args){
        Poligono troco = new Poligono();
        int[] tamanhoLados = {1, 2, 1, 2};
        troco.configuraPoligono(tamanhoLados, (byte) 4);
        System.out.println(troco.nomePoligono());

        Poligono bloco = troco.clone();
        System.out.println(troco.ehIgual(bloco));
    }
}
