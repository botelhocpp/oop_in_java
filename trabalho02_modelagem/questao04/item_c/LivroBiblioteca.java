package questao04.item_c;

import questao04.item_a.Livro;

/**
 * 
 * A classe LivroBiblioteca contém campos e metodos que representam os atributos
 * básicos de um livro disponível em uma bilbioteca, que pode ser emprestado para
 * leitores.
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

public class LivroBiblioteca {
    
    private Livro livroBland = new Livro(); 
    private int codigoIdentificacao;
    private int quantidadeExemplares;
    private int identificacaoLeitor;


    //SET

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

    public int getIdLeitor(){
        return identificacaoLeitor;
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

    public void alugar(int idLeitor){
        if(estaDisponivel()){
            quantidadeExemplares--;
            identificacaoLeitor = idLeitor;
        }
        else{
            System.out.println("Não há exemplares disponíveis.");
        }
    }

    public void devolver(){
        quantidadeExemplares++;
    }

}
