package questao02.item_c;

/**
 * 
 * A classe Linha contém campos e metodos que representar uma linha,
 * unida por dois pontos no espaço cartesiano de duas dimensões, usando
 * a classe Ponto2D para representar pontos na esquerda e na direita, 
 * sendo essa "localização" apenas como referência.
 * 
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 *  Ponto2D pontoEsq
 *  Ponto2D pontoDir
 * Métodos:
 *  void desenharLinha(int, int, int, int)
 *  Ponto2D getPontoEsq()
 *  Ponto2D getPontoDir()
 *  boolean ehIgual(Linha)
 *  void mostraLinha()
 *  Linha clone()
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

import questao02.item_a.Ponto2D;

public class Linha {
    private Ponto2D pontoEsq;
    private Ponto2D pontoDir;

    public void desenharLinha(int pontoEsqX, int pontoEsqY, int pontoDirX, int pontoDirY){
        pontoEsq = new Ponto2D();
        pontoEsq.inserirPonto(pontoEsqX, pontoEsqY);
        pontoDir = new Ponto2D();
        pontoDir.inserirPonto(pontoDirX, pontoDirY);
    }

    public Ponto2D getPontoEsq(){
        return pontoEsq;
    }

    public Ponto2D getPontoDir(){
        return pontoDir;
    }

    public boolean ehIgual(Linha referencial){
        return (pontoEsq.getX() == referencial.pontoEsq.getX())
        && (pontoEsq.getY() == referencial.pontoEsq.getY())
        && (pontoDir.getX() == referencial.pontoDir.getX())
        && (pontoDir.getY() == referencial.pontoDir.getY());
    }

    public void mostraLinha(){
        System.out.printf("Ponto Direito: (%d, %d)%n", getPontoDir().getX(), getPontoDir().getY());
        System.out.printf("Ponto Esquerdo: (%d, %d)%n", getPontoEsq().getX(), getPontoEsq().getY());
    }

    public Linha clone(){
        Linha copia = new Linha();
        copia.desenharLinha(getPontoEsq().getX(), getPontoEsq().getY(), getPontoDir().getX(), getPontoDir().getY());
        return copia;
    }
}
