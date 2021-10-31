package questao03;

/**
 * 
 * A classe Poligono contém campos e metodos que representar um polígono
 * de até 10 lados.
 * 
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 *  int[] tamanhoLados
 *  byte quantidadeLados
 * Métodos:
 *  void configuraPoligono(int[], byte)
 *  int[] getLados()
 *  byte getQuantidade()
 *  void mostraPoligono()
 *  boolean ehIgual(Poligono)
 *  Poligono clone()
 *  String nomePoligono()
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

public class Poligono {
    private int[] tamanhoLados;
    private byte quantidadeLados;

    /**
     * Primeiro ajusta o tamanho e depois preenche o vetor de lados.
     */
    public void configuraPoligono(int[] lados, byte tamanho){
        quantidadeLados = tamanho;
        tamanhoLados = new int[quantidadeLados];
        for(int i = 0; i < quantidadeLados; i++){
            tamanhoLados[i] = lados[i];
        }
    }

    /**
     * Para retornar os lados deve-se retornar um array novo, com a cópia dos lados.
     */

    public int[] getLados(){
        int[] copiaLados = new int[quantidadeLados];
        for(int i = 0; i < quantidadeLados; i++){
            copiaLados[i] = tamanhoLados[i];
        }
        return copiaLados;
    }

    public byte getQuantidade(){
        return quantidadeLados;
    }

    public void mostraPoligono(){
        for(int i = 0; i < quantidadeLados; i++){
            System.out.println("Lado Nº: " + (i + 1) + " - Tamanho: " + tamanhoLados[i]);
        }
    }

    /**
     * Primeiro verifica se a quantidade de lados é igual, depois verifica, um a um,
     * os tamanhos dos lados do polígono.
     * @param referencial
     * @return
     */
    public boolean ehIgual(Poligono referencial){
        if(quantidadeLados != referencial.quantidadeLados){
            return false;
        }
        for(int i = 0; i < quantidadeLados; i++){
            if(tamanhoLados[i] != referencial.tamanhoLados[i]){
                return false;
            }
        }
        return true;
    }

    public Poligono clone(){
        Poligono copia = new Poligono();
        copia.configuraPoligono(tamanhoLados, quantidadeLados);
        return copia;
    }

    public String nomePoligono(){
        switch(quantidadeLados){
            case 3:
                return "Trilátero";
            case 4:
                return "Quadrilátero";
            case 5:
                return "Pentágono";
            case 6:
                return "Hexágono";
            case 7:
                return "Heptágono";
            case 8:
                return "Octógono";
            case 9:
                return "Eneágono";
            case 10:
                return "Decágono";
            default:
                return "Inexistente";
        }
    }
}
