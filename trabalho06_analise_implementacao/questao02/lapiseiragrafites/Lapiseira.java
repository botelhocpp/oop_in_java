package questao02.lapiseiragrafites;

import java.util.ArrayList;

/**
 * Essa classe modela uma lapiseira, que quando
 * munida de um grafite, poderá escrever folhas.
 * 
 * A lapiseira precisa de um grafite para
 * poder escrever. Caso não tenha, irá
 * emitir uma mensagem de erro.
 * 
 * Essa classe é um objeto container, ou seja,
 * tem dentro de sim uma outra classe, por
 * composição.
 * 
 * O diagrama UML nos diz muito sobre a relação
 * enter a classe "Lapiseira" e a classe "Grafite":
 * Um objeto da classe Lapiseira contém vários objetos
 * da classe Grafite, atuando como um conteiner: a 
 * existência deles é exclusiva à instância da classe
 * Lapiseira(relação todo-parte). Temos que uma lapiseira
 * (instância) pode ter, ou não, um grafite no bico,
 * assim como pode ter, ou não, grafites no tambor.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 25/11/2021
 */
public class Lapiseira {
    /**
     * A espessura de grafite que a lapiseira
     * comporta.
     */
    private float calibre;

    /**
     * O grafite engatilhado na lapiseira, ou seja,
     * o grafite que está em uso.
     */
    private Grafite bico;

    /**
     * Os grafites reserva.
     */
    private ArrayList<Grafite> tambor;

    /**
     * Inicializa a lapiseira com um calibre informado
     * caso ele seja válido, ou seja, caso pertença a
     * lista de valores da classe Grafite. A lapiseira
     * estará com o tambor e bico vazios.
     * 
     * @param calibre Espessura do grafite.
     */
    public Lapiseira(float calibre){
        if(Grafite.calibreValores.indexOf(calibre) != -1){
            this.calibre = calibre;
            this.tambor = new ArrayList<Grafite>();
        }
        else{
            System.err.println("fail: valor inválido para calibre da lapiseira.");
        }
    }

    /**
     * Carrega a lapiseira com um grafite. Só irá engatilhar se
     * o calibre for compatível e se o grafite passado foi válido.
     * Note que é verificado se o calibre do grafite passado é zero,
     * o que indica que o grafite foi inicializado com valores errados.
     * 
     * @param grafite Grafite a ser carregado na lapiseira.
     * @return "true" caso o processo de inserção seja bem
     * sucedido e "false" caso contrário.
     */
    public boolean inserir(Grafite grafite){
        if(grafite == null){
            System.err.println("fail: grafite inexistente.");
            return false;
        }
        if(grafite.getCalibre() == 0){
            return false;
        }
        else if(grafite.getCalibre() == this.calibre){
            this.tambor.add(grafite);
            return true;
        }
        else{
            System.err.println("fail: calibre incompatível.");
            return false;
        }
    }

    /**
     * Remove o grafite da lapiseira, caso tenha algum.
     * 
     * @return O grafite removido.
     */
    public Grafite remover(){
        if(this.bico != null){
            Grafite temporary = this.bico;
            this.bico = null;
            return temporary;
        }
        else{
            System.err.println("fail: não existe grafite no bico.");
            return null;
        }
    }

    /**
     * Escreve um número determinado de folhas caso a lapiseira
     * tenha grafite e caso ele tenha mais que 10mm de comprimento. 
     * O grafite sofre desgate por folha, baseado no seu nível 
     * de maciez.
     * 
     * Caso não seja possível escrever todas as folhas é emitido
     * uma mensagem de erro para o usuário. Caso o grafite tenha
     * acabado, ou seja, alcançado 10mm, o usuário é notificado e
     * deverá trocar o grafite.
     * 
     * O laço irá assegurar que todas as folhas sejam escritas,
     * caso tenha grafite suficiente. Caso não tenha um break irá
     * fazer o programa sair do laço. A linha:
     * 
     * this.grafite.getTamanho() - 10 < this.grafite.desgastePorFolha()
     * 
     * Realiza o desgaste e pergunta se aquele desgaste realizado é maior
     * que o tamanho do grafite, após o desgaste, menos dez(10 é o valor
     * para qual o grafite deve ser inoperante). Caso seja então a folha
     * não poderá ser escrita por completa e é mostrado quants folhas
     * faltam.
     * 
     * @param folhas Quantidade de folhas a serem escritas.
     */
    public void escrever(int folhas){
        if(this.bico == null){
            System.err.println("fail: não existe grafite no bico.");
        }
        else if(this.bico.getTamanho() < 11){
            System.out.println("fail: grafite acabou.");
        }
        else{
            while(folhas-- > 0){
                if((this.bico.getTamanho() - 10) < this.bico.desgastePorFolha()){
                    System.err.println("fail: "+ (folhas + 1) + " folha(s) incompleta(s) ou vazia(s)");
                }
                if(this.bico.getTamanho() < 11){
                    System.out.println("warning: grafite acabou.");
                    break;
                }
            }
        }
    }

    /**
     * A lapiseira escreverá uma folha.
     */
    public void escrever(){
        this.escrever(1);
    }

    /**
     * Engatilha o bico com um grafite do tambor, caso não
     * haja grafite no bico e caso o tambor não esteja vazio.
     * 
     * @return "true" se foi possível realizar a operação
     * e "false" caso contrário.
     */
    public boolean puxar(){
        if(this.bico != null){
            System.out.println("fail: ja existe grafite no bico");
            return false;
        }
        else if(this.tambor.isEmpty()){
            System.err.println("fail: não existe grafite no tambor.");
            return false;
        }
        else{
            this.bico = this.tambor.remove(0);
            return true;
        }
    }

    /**
     * Retorna as principais informações da lapiseira, e do
     * grafite correspondente, em formato de String.
     */
    public String toString(){
        //Desta forma a formatação não fica nos moldes esperados.
        //Mas funciona e é mais legível.
        //return String.format("calibre: %.1f, bico: %s, tambor: %s", this.calibre, (this.bico == null) ? "[]" : this.bico, this.tambor);

        //Desta forma atende os moldes esperados de formatação.
        String lapiseiraInformacoes = String.format("calibre: %.1f, bico: %s, tambor: {", this.calibre, (this.bico == null) ? "[]" : this.bico);
        for(int i = 0; i < this.tambor.size(); i++){
            lapiseiraInformacoes = lapiseiraInformacoes.concat(this.tambor.get(i).toString());
        }
        return lapiseiraInformacoes.concat("}");
    }
}