package questao01.lapiseira;

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
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 16/11/2021
 */
public class Lapiseira {
    /**
     * A espessura de grafite que a lapiseira
     * comporta.
     */
    private float calibre;

    /**
     * O grafite engatilhado na lapiseira.
     */
    private Grafite grafite;

    /**
     * Inicializa a lapiseira com um calibre informado
     * caso ele seja válido, ou seja, caso pertença a
     * lista de valores da classe Grafite.
     * 
     * @param calibre Espessura do grafite.
     */
    public Lapiseira(float calibre){
        if(Grafite.calibreValores.indexOf(calibre) != -1){
            this.calibre = calibre;
        }
        else{
            System.err.println("fail: valor inválido para calibre da lapiseira.");
        }
    }

    /**
     * Engatilha a lapiseira com um grafite, caso esteja
     * vazia. Caso não, emite uma mensagem de erro. Só irá
     * engatilhar se o calibre for compatível e se o grafite
     * passado foi válido. Note que é verificado se o calibre
     * do grafite passado é zero, o que indica que o grafite
     * foi inicializado com valores errados. 
     * 
     * @param grafite Grafite a ser engatilhado na lapiseira.
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
        if(this.grafite != null){
            System.err.println("fail: já existe grafite.");
            return false;
        }
        else if(grafite.getCalibre() == this.calibre){
            //No caso de instâncias externas, como a caixa de grafites.
            //this.grafite = grafite.clone();
            
            //No caso de a instância ser criada na chamada do método.
            this.grafite = grafite;
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
        if(this.grafite != null){
            Grafite temporary = this.grafite;
            this.grafite = null;
            return temporary;
        }
        else{
            System.err.println("fail: não existe grafite.");
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
        if(this.grafite == null){
            System.err.println("fail: não existe grafite.");
        }
        else if(this.grafite.getTamanho() < 11){
            System.out.println("warning: grafite acabou.");
        }
        else{
            while(folhas-- > 0){
                if((this.grafite.getTamanho() - 10) < this.grafite.desgastePorFolha()){
                    System.err.println("fail: "+ (folhas + 1) + " folha(s) incompleta(s) ou vazia(s)");
                }
                if(this.grafite.getTamanho() < 11){
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
     * Retorna as principais informações da lapiseira, e do
     * grafite correspondente, em formato de String.
     */
    public String toString(){
        return String.format("calibre: %.1f, grafite: %s", this.calibre, this.grafite);
    }
}