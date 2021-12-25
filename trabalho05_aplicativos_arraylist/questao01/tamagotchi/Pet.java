package questao01.tamagotchi;

/**
 * Essa classe modela um bichinho virtual. Ele poderá comer, 
 * brincar, dormir e tomar banho. E eventualmente morrerá, 
 * se você não cuidar bem dele.
 * 
 * Se algum atributo chegar a 0, o pet morre e nenhuma ação
 * pode ser feita a não ser mostrar os dados.
 * 
 * A ordem de precedência para a morte do pet, ou seja,
 * qual atributo irá mata-lo se chegar a zero é:  Energia,
 * Saciedade e Limpeza.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 15/11/2021
 */
class Pet{
    private int energyMAX;
    private int hungryMAX;
    private int cleanMAX;
    
    private int energy;
    private int hungry;
    private int clean;

    private int diamonds;
    private int age;

    private boolean alive;
    
    /**
     * Inicializa o bichinho, passando sua energia, saciedade e limpeza máximas.
     * 
     * Caso os valores de inicialização sejam inferiores a
     * um os valores padrões são passados aos atributos.
     * 
     * @param energyMAX Energia máxima do pet.
     * @param hungryMAX Saciedade máxima do pet.
     * @param cleanMAX Limpeza máxima do pet.
     */
    public Pet(int energyMAX, int hungryMAX, int cleanMAX){
        if(energyMAX > 0 && hungryMAX > 0 && cleanMAX > 0){
            this.alive = true;
            this.energyMAX = this.energy = energyMAX;
            this.hungryMAX = this.hungry = hungryMAX;
            this.cleanMAX = this.clean = cleanMAX;
        }
        else{
            this.alive = true;
            this.energyMAX = this.energy = 15;
            this.hungryMAX = this.hungry = 12;
            this.cleanMAX = this.clean = 10;
        }
    }

    /**
     * Atribui o valor de energia do pet. Se o valor ficar abaixo de 0,
     * o pet morre de fraqueza. Garanta que os valores ficarão no intervalo
     * 0 - máximo.
     * 
     * @param energy Valor de energia a ser atribuído ao pet.
     */
    private void setEnergy(int energy){
        if(energy < 1){
            this.energy = 0;
            this.alive = false;
            System.out.println("fail: pet morreu de fraqueza");
        }
        else if(energy > this.energyMAX){
            this.energy = this.energyMAX;
        }
        else{
            this.energy = energy;
        }
    }

    /**
     * Atribui o valor de saciedade do pet. Se o valor ficar abaixo de 0,
     * o pet morre de fome. Garanta que os valores ficarão no intervalo
     * 0 - máximo.
     * 
     * @param hungry Valor de saciedade a ser atribuído ao pet.
     */
    private void setHungry(int hungry){
        if(hungry < 1){
            this.hungry = 0;
            this.alive = false;
            System.out.println("fail: pet morreu de fome");
        }
        else if(hungry > this.hungryMAX){
            this.hungry = this.hungryMAX;
        }
        else{
            this.hungry = hungry;
        }
    }

    /**
     * Atribui o valor de limpeza do pet. Se o valor ficar abaixo de 0,
     * o pet morre de sujeira. Garanta que os valores ficarão no intervalo
     * 0 - máximo.
     * 
     * @param clean Valor de limpeza a ser atribuído ao pet.
     */
    private void setClean(int clean){
        if(clean < 1){
            this.clean = 0;
            this.alive = false;
            System.out.println("fail: pet morreu de sujeira");
        }
        else if(clean > this.cleanMAX){
            this.clean = this.cleanMAX;
        }
        else{
            this.clean = clean;
        }
    }

    /**
     * Retorna o nível de limpeza do pet.
     */
    public int getClean(){
        return this.clean;
    }

    /**
     * Retorna o nível de saciedade do pet.
     */
    public int getHungry(){
        return this.hungry;
    }

    /**
     * Retorna o nível de energia do pet.
     */
    public int getEnergy(){
        return this.energy;
    }

    /**
     * Retorna a capacidade máxima de energia do pet.
     */
    public int getEnergyMAX(){
        return this.energyMAX;
    }

    /**
     * Retorna a capacidade máxima de limpeza do pet.
     */
    public int getCleanMAX(){
        return this.cleanMAX;
    }

    /**
     * Retorna a capacidade máxima de saciedade do pet.
     */
    public int getHungryMAX(){
        return this.hungryMAX;
    }
    

    /**
     * Retorna as principais informações do pet formatadas em uma String.
     */
    public String toString(){
        return String.format("E: %d/%d, S: %d/%d, L: %d/%d, D: %d, I: %d%n", this.energy, this.energyMAX, this.hungry, this.hungryMAX, this.clean, this.cleanMAX, this.diamonds, this.age);
    }

    /**
     * Verifica se o pet está vivo. Se não estiver emite uma
     * mensagem avisando de seu falecimento.
     * 
     * @return "true" se o pet estiver vivo e "false" caso
     * contrário.
     */
    public boolean testAlive(){
        if((alive) && (this.energy > 0) && (this.hungry > 0) && (this.clean > 0)){
            return true;
        }
        else{
            System.out.println("fail: pet esta morto");
            return false;
        }
    }

    /**
     * Brinque com seu pet! Isso diminuirá sua energia
     * em 2, sua saciedade em 1, sua limpeza em 3 e
     * aumentará seus diamentes e sua idade em 1.
     */
    public void play(){
        if(this.testAlive()){
            this.age += 1;
            this.diamonds += 1;
            this.setEnergy(this.energy - 2);
            if(alive){
                this.setHungry(this.hungry - 1);
                if(alive){
                    this.setClean(this.clean - 3);
                }
            }
        }
    }

    /**
     * Banhe seu pet! Isso diminuirá sua energia
     * em 3, sua saciedade em 1 e irá maximizar sua
     * limpeza, e também aumentará sua idade em 2.
     */
    public void shower(){
        if(this.testAlive()){
            this.age += 2;
            this.setClean(this.cleanMAX);
            this.setEnergy(this.energy - 3);
            if(alive){
                this.setHungry(this.hungry - 1);
            }
        }
    }

    /**
     * Dê comida ao seu pet! Isso diminuirá sua energia
     * em 1 e sua limpeza em 2 e aumentará a saciedade
     * em 4 e sua idade em 1
     */
    public void eat(){
        if(this.testAlive()){
            this.age += 1;
            this.setHungry(this.hungry + 4);
            this.setEnergy(this.energy - 1);
            if(alive){
                this.setClean(this.clean - 2);
            }
        }
    }

    /**
     * Coloque seu pet para dormir! Isso diminuirá sua
     * saciedade em 1 e irá maximizar sua energia
     * e também aumentará sua idade em 1.
     * 
     * Se o pet tiver perdido menos de 5 unidade de energia
     * o pet não irá querer dormir.
     */
    public void sleep(){
        if(this.energy + 4 >= this.energyMAX){
            System.out.println("fail: nao esta com sono");
        }
        else if(this.testAlive()){
            this.age += 1;
            this.setEnergy(this.energyMAX);
            this.setHungry(this.hungry - 1);
        }
    }
}