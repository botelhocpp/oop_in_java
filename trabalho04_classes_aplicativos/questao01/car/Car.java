package car; 

/**
 * A classe Car modela uma carro "ecológico", que tem autonomia de 1km por
 * litro. Ele tem capacidade para transportar duas pessoas, e tem um tanque
 * que comporta no máximo 100L. Só não recomendo, com a gasolina a 7 reais. 
 * 
 * 31/10/2021 - Commit Inicial. Estrutura proposta pelo professor.
 * 07/11/2021 - Primeiras Modificações. Funções implementadas totalmente.
 * 09/11/2021 - Métodos getters implementados, para facilitar o trabalho
 * de possíveis softwares de gerenciamento do nosso carro, como sistemas
 * para monitorar o tanque e aumentar a sua autonomia.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 09/11/2021  
 */
public class Car {
    /**
     * Quantidade de quilometragem do carro.
     */
    private int quilometragem;

    /**
     * Quantidade de passageiros do carro.
     */
    private byte passageiros;

    /**
     * Marcador de combustível do tanque.
     */
    private int gas;

    /**
     * Limite de passageiros do carro.
     */
    private final byte passageirosMAX;

    /**
     * Limite de combustível do tanque.
     */
    private final int gasMAX;
    
    /**
     * Inicializa o carro de tanque vazio, sem ninguém dentro e com 0 de
     * quilometragem. O carro esportivo suporta até duas pessoas e seu tanque
     * suporta até 100 litros de gás como combustível.
     * 
     * Os outros atributos não foram inicializados justamente porque a JVM
     * já os inicializa com zero, que é o valor que queremos.
     */
    public Car(){
        this.passageirosMAX = 2;
        this.gasMAX = 100;
    }
    
    /**
     * Embarca uma pessoa no carro caso haja vaga. Caso não é emitido uma
     * mensagem de falha.
     */
    public void in(){
        if(this.passageiros < this.passageirosMAX){
            this.passageiros++;
        }
        else{
            System.out.println("fail: limite de pessoas atingido");
        }
    }

    /**
     * Desembarca uma pessoa do carro caso não esteja vazio. Caso esteja é
     * emitido uma mensagem de falha.
     */
    public void out(){
        if(this.passageiros > 0){
            this.passageiros--;
        }
        else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }

    /**
     * Abastece o tanque com uma quantidade de litros especificada por "gas".
     * Caso a quantidade exceda o máximo do tanque o restante será descartado,
     * infelizmente.
     * 
     * @param gas Quantidade de gasolina a ser adicionada ao tanque.
     */
    public void fuel(int gas){
        this.gas += (gas > (this.gasMAX - this.gas)) ? this.gasMAX - this.gas : gas;
    }

    /**
     * Caso haja ao menos uma pessoa no veículo, e caso o tanque não esteja vazio.
     * o veículo pode ser utilizado para seu propósito, com sua "incrível" autônomia
     * de 1km/L. Devido a isso talvez não seja possível chegar ao destino. Na verdade
     * o veículo só consegue cobrir 100km, mesmo com o tanque cheio, antes de precisar
     * ser abastecido novamente. Ande sempre com reserva. E um cartão com limite alto.
     * 
     * Caso a quantidade de combustível não seja o bastante para completar o caminho
     * o veículo irá "andar" até que se esgote, e então mostrar ao usuário quantos
     * quilometros foram cobertos.
     * 
     * Caso não tenha combustível ou não tenham pessoas é emitido uma mensagem de erro
     * ao usuário.
     * 
     * @param quilometros Quantidade de quilômetros que o usuário quer percorrer.
     */
    public void drive(int quilometros){
        if(this.gas > 0 && this.passageiros > 0){
            if(quilometros <= this.gas){
                this.quilometragem += quilometros;
                this.gas -= quilometros;
            }
            else{
                System.out.printf("fail: tanque vazio apos andar %d km%n", this.gas);
                this.quilometragem += this.gas;
                this.gas = 0;
            }
        }
        else if(this.gas == 0){
            System.out.println("fail: tanque vazio");
        }
        else if(this.passageiros == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }
        else{
            System.out.println("fail: tanque vazio e nao ha ninguem no carro");
        }
    }

    /**
     * Devolve para o usuário o nível de gás no tanque.
     */
    public int getGas(){
        return this.gas;
    }

    /**
     * Devolve para o usuário a capacidade máxima que o tanque suporta
     */
    public int getGasMax(){
        return this.gasMAX;
    }

    /**
     * Devolve para o usuário a quantidade de passageiros no carro.
     */
    public int getPassageiros(){
        return this.passageiros;
    }

    /**
     * Devolve para o usuário a quantidade máxima de passageiros que o 
     * carro suporta.
     */
    public int getPassageirosMax(){
        return this.passageirosMAX;
    }

    /**
     * Devolve para o usuário a quantidade de quilometros rodados.
     */
    public int getQuilometragem(){
        return this.quilometragem;
    }

    /**
     * Devolve as principais informações do veículo, indicando como está seu
     * estado.
     */
    public String toString(){
        return String.format("pass: %d, gas: %d, km: %d%n", this.passageiros, this.gas, this.quilometragem);
    }
}