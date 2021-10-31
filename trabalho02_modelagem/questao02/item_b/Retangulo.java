package questao02.item_b;

/**
 * 
 * A classe Retangulo contém campos e metodos que permitem representar
 * retangulo por meio de quatro pontos no espaço cartesiano de duas 
 * dimensões, usando a classe Ponto2D. 
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 *  Ponto2D cantoInfEsq
 *  Ponto2D cantoSupDir
 * Métodos:
 *  void desenharRetangulo(int, int, int, int)
 *  Ponto2D getPontoinfEsq()
 *  Ponto2D getPontosupDir()
 *  boolean ehIgual(Retangulo)
 *  void mostraRetangulo()
 *  Retangulo clone()
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

import questao02.item_a.Ponto2D;

public class Retangulo {
    /**
     * Representa o canto inferior esquerdo do retângulo.
     */
    private Ponto2D cantoInfEsq;

    /**
     * Representa o canto superior direito do retângulo.
     */
    private Ponto2D cantoSupDir;

    /**
     * É construído um retangulo, onde:
     * Canto inferior esquerdo: (infEsqX, infEsqY)
     * Canto superior direito: (supDirX, supDirY)
     * @param infEsqX
     * @param infEsqY
     * @param supDirX
     * @param supDirY
     */
    public void desenharRetangulo(int infEsqX, int infEsqY, int supDirX, int supDirY){
        cantoInfEsq = new Ponto2D();
        cantoInfEsq.inserirPonto(infEsqX, infEsqY);
        cantoSupDir = new Ponto2D();
        cantoSupDir.inserirPonto(supDirX, supDirY);
    }

    public Ponto2D getPontoInfEsq(){
        return cantoInfEsq;
    }

    public Ponto2D getPontoSupDir(){
        return cantoSupDir;
    }

    /**
     * Os objetos só são iguais caso TODOS os atributos também sejam.
     * @param referencial
     * @return
     */
    public boolean ehIgual(Retangulo referencial){
        return (cantoInfEsq.getX() == referencial.cantoInfEsq.getX())
        && (cantoInfEsq.getY() == referencial.cantoInfEsq.getY())
        && (cantoSupDir.getX() == referencial.cantoSupDir.getX())
        && (cantoSupDir.getY() == referencial.cantoSupDir.getY());
    }

    public void mostraRetangulo(){
        System.out.printf("Ponto Superior Direito: (%d, %d)%n", getPontoSupDir().getX(), getPontoSupDir().getY());
        System.out.printf("Ponto Inferior Esquerdo: (%d, %d)%n", getPontoInfEsq().getX(), getPontoInfEsq().getY());
    }

    /**
     * Cria uma nova instância, preenche os atributos com os dados de "this", e retorna.
     */
    public Retangulo clone(){
        Retangulo copia = new Retangulo();
        copia.desenharRetangulo(getPontoInfEsq().getX(), getPontoInfEsq().getY(), getPontoSupDir().getX(), getPontoSupDir().getY());
        return copia;
    }
}
