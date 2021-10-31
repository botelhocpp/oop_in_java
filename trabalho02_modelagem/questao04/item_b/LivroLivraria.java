package questao04.item_b;

import questao04.item_a.Livro;

/**
 * 
 * A classe LivroLivraria contém campos e metodos que representam os atributos
 * básicos de um livro a venda em uma livraria.
 * 
 * Esta versão da classe tem os atributos protegidos para evitar a sua
 * manipulação incorreta. Deverão ser utilizados métodos para acessar,
 * e modificar, os valores dos atributos.
 * 
 * Atributos:
 * Métodos:
 * 
 * @author Pedro M. Botelho
 * @version 1.0
 * 
 */

public class LivroLivraria {
    
    private Livro livroBland = new Livro(); 
    private short valorLivro;
    private int codigoDeBarra;
    private int codigoIdentificacao;
    private int quantidadeExemplares;


    //SET

    public void setExemplares(int quantidade){
        quantidadeExemplares = quantidade;
    }

    public void setValor(short valor){
        valorLivro = valor;
    }

    public void setCodigoBarra(int codigo){
        codigoDeBarra = codigo;
    }

    public void setId(int id){
        codigoIdentificacao = id;
    }

    public void setQuantidadePaginas(short numeroPaginas){
        livroBland.setQuantidadePaginas(numeroPaginas);
    }

    public void setClasEtaria(byte clasEtaria){
        livroBland.setClasEtaria(clasEtaria);
    }

    public void setAno(short anoPublicacao){
        livroBland.setAno(anoPublicacao);
    }

    public void setClasObra(String clasObra){
        livroBland.setClasObra(clasObra);
    }

    public void setNome(String nomeLivro){
        livroBland.setNome(nomeLivro);
    }

    public void setAutor(String nomeAutor){
        livroBland.setAutor(nomeAutor);
    }

    public void setEditora(String editoraLivros){
        livroBland.setEditora(editoraLivros);
    }

    public void setGenero(String generoLivro){
        livroBland.setGenero(generoLivro);
    }

    //GET

    public short getValor(){
        return valorLivro;
    }

    public int getCodigoBarra(){
        return codigoDeBarra;
    }

    public int getId(){
        return codigoIdentificacao;
    }

    public short getQuantidadePaginas(){
        return livroBland.getQuantidadePaginas();
    }

    public byte getClasEtaria(){
        return livroBland.getClasEtaria();
    }

    public short getAno(){
        return livroBland.getAno();
    }

    public String getClasObra(){
        return livroBland.getClasObra();
    }

    public String getNome(){
        return livroBland.getNome();
    }

    public String getAutor(){
        return livroBland.setAutor();
    }

    public String getEditora(){
        return livroBland.setEditora();
    }

    public String getGenero(){
        return livroBland.setGenero();
    }

    public boolean estaDisponivel(){
        if(quantidadeExemplares == 0){
            return false;
        }
        return true;
    }

    public void comprar(){
        if(estaDisponivel()){
            quantidadeExemplares--;
        }
        else{
            System.out.println("Não há exemplares disponíveis.");
        }
    }

    public void reembolso(){
        quantidadeExemplares++;
    }

}
