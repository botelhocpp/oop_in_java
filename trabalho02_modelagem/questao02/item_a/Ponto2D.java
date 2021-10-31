package questao02.item_a;

/**
 * 
 * A classe Ponto2D contém campos e metodos que permitem representar
 * um ponto no espaço cartesiano de duas dimensões. 
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 *  int x
 *  int y
 * Métodos:
 *  void inserirPonto(int, int)
 *  int getX()
 *  int getY()
 *  boolean ehIgual(Ponto2D)
 *  void mostraPonto()
 *  Ponto2D clone()
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

public class Ponto2D {
    
    /**
     * Representa um elemento do eixo do x.
     */
    private int x;

    /**
     * Representa um elemento do eixo do y.
     */
    private int y;

    /**
     * Insere um ponto no plano cartesiano, por meio de:
     * @param eixoX Posição no eixo X
     * @param eixoY Posição no eixo Y
     */
    public void inserirPonto(int eixoX, int eixoY){
        x = eixoX;
        y = eixoY;
    }

    /**
     * Devolve o valor do elemento no eixo do x.
     * @return O valor do atributo 'x'.
     */
    public int getX(){
        return x;
    }


    /**
     * Devolve o valor do elemento no eixo do y.
     * @return O valor do atributo 'y'.
     */
    public int getY(){
        return y;
    }

    /**
     * Diz se dois objetos da classe Ponto2D são iguais.
     * @param ponto Um objeto para se verificar a igualdade.
     * @return Se são iguais, retorna 'true', e 'false', caso
     * contrário.
     */
    public boolean ehIgual(Ponto2D ponto){
        return (x == ponto.x) && (y == ponto.y);
        
    }

    /**
     * Imprime o ponto no formato: (x, y).
     */
    public void mostraPonto(){
        System.out.printf("(%d, %d)%n", x, y);
    }

    /**
     * Clona o objeto, retornando outro objeto com o mesmo estado.
     */
    public Ponto2D clone(){
        Ponto2D copia = new Ponto2D();
        copia.x = x;
        copia.y = y;
        return copia;
    }

}