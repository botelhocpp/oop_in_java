package questao04.item_a;

/**
 * 
 * A classe Livro contém campos e metodos que representam os atributos
 * básicos de um livro, sem se preocupar com a sua finalidade.
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

public class Livro {
    private short quantidadePaginas;
    private byte classificacaoEtaria;
    private short ano;

    private String classificacaoObra;
    private String nome;
    private String autor;
    private String editora;
    private String genero;
    
    //SET

    public void setQuantidadePaginas(short numeroPaginas){
        quantidadePaginas = (numeroPaginas > 0 && numeroPaginas < 10000) ? numeroPaginas : 0;
    }

    public void setClasEtaria(byte clasEtaria){
        classificacaoEtaria = (clasEtaria > 0 && clasEtaria <= 18) ? clasEtaria : 0;
    }

    public void setAno(short anoPublicacao){
        ano = (anoPublicacao < 2099) ? anoPublicacao : 0;
    }

    public void setClasObra(String clasObra){
        classificacaoObra = clasObra;
    }

    public void setNome(String nomeLivro){
        nome = nomeLivro;
    }

    public void setAutor(String nomeAutor){
        autor = nomeAutor;
    }

    public void setEditora(String editoraLivros){
        editora = editoraLivros;
    }

    public void setGenero(String generoLivro){
        genero = generoLivro;
    }

    //GET

    public short getQuantidadePaginas(){
        return quantidadePaginas;
    }

    public byte getClasEtaria(){
        return classificacaoEtaria;
    }

    public short getAno(){
        return ano;
    }

    public String getClasObra(){
        return classificacaoObra;
    }

    public String getNome(){
        return nome;
    }

    public String setAutor(){
        return autor;
    }

    public String setEditora(){
        return editora;
    }

    public String setGenero(){
        return genero;
    }

}
