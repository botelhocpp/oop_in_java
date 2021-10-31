package questao01.item_e;

/**
 * A classe Data contém campos e metodos que
 * permitem a manipulacao de datas. 
 * Esta versão da classe tem os campos protegidos
 * para evitar a sua manipulação incorreta --
 * valores dos campos só podem ser acessados através de métodos.
 */
class Data { // declaracão da classe

    /**
     * Declaração dos atributos da classe
     */
    private byte dia, mes; 
    private short ano;

    /**
     * O método inicializaData recebe argumentos para inicializar 
     * os atributos da classe Data. Este método chama o método 
     * dataEhValida para verificar se os argumentos correspondem
     * a uma data válida: se forem, inicializa os atributos, caso contrário
     * inicializa todos os três atributos com o valor zero.
     * @param d o argumento correspondente ao atributo dia
     * @param m o argumento correspondente ao atributo mes
     * @param a o argumento correspondente ao atributo ano
     */
    public void inicializaData(byte d, byte m, short a) {
        ano = a;
        if(dataEhValida(d, m, a)) {
            dia = d;
            mes = m;
        }
        else {
            dia = mes = 0;
            ano = 0;
        }
    }

    /**
     * O método dataEhValida recebe três valores como argumentos
     * e verifica de maneira simples se os dados correspondem a uma data válida.
     * Se a data for válida, retorna a constante booleana true, 
     * caso contrário, retorna false.
     * O algorítmo leva em conta a quantidade de dias prevista para
     * cada mês, também levando em conta o ano.
     * @param d o argumento correspondente ao atributo dia.
     * @param m o argumento correspondente ao atributo mes.
     * @param a o argumento correspondente ao atributo ano.
     * @return true se a data for válida, false caso contrário.
     */
    public boolean dataEhValida(byte d, byte m, short a) {
        if((m <= 0 || m > 12)){
            return false;
        }
        if(d > 0 && d <= 31){
            if(m == 2){
                if(ehBissexto()){
                    if(d <= 29){
                        return true;
                    }
                }
                else{
                    if(d <= 28){
                        return true;
                    } 
                }
                return false;
            }
            else if((m < 8) && (m % 2 == 0)){
                if(d <= 30){
                    return true;
                }
            }
            else{
                if(d <= 31){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     Diz se o ano é bissexto ou não. Um ano é considerado 'bissexto' se ele for divisível 
     * por 400, ou se ele for divisível por 4 e não por 100.
     * @return Valores booleanos 'true' se for bissexto ou 'false', se não for.
     */
    public boolean ehBissexto(){
        if(dia != 0 && mes != 0 && ano != 0){
            return (ano % 400 == 0) || ((ano % 4 == 0) && !(ano % 100 == 0));
        }
        return false;
    }    

    /**
     * O método getDia devolve o dia da data encapsulada.
     * @return o dia encapsulado pela classe
     */
    public byte getDia() {
        return dia;
    }

    /**
     * O método getMes devolve o mês da data encapsulada.
     * @return o mês encapsulado pela classe
     */
    public byte getMes() {
        return mes;
    }

    /**
     * O método getAno devolve o ano da data encapsulada.
     * @return o ano encapsulado pela classe
     */
    public short getAno() {
        return ano;
    }

    /**
     * O método ehIgual recebe uma instância da própria classe
     * Data como argumento e verifica se a data representada 
     * pela classe e pela instância que foi passada é a mesma.
     * A comparação é feita comparando os campos da data um a um.
     * @param data uma instância da própria classe Data
     * @return true se a data encapsulada for igual à passada, false caso contrário
     */
    boolean ehIgual(Data data) {
        if( (dia == data.dia) && (mes == data.mes) && (ano == data.ano) )
            return true;
        else
            return false;
    }

    /**
     * O método mostraData não recebe argumentos nem retorna valores.
     * Este método somente imprime os valores dos atributos no
     * formato dd/mm/aaaa. Uma quebra de linha é impressa ao final.
     */
    void mostraData() {
        if(dia == 0 || mes == 0 || ano == 0){
            System.out.println("Data Inválida.");
        }
        else{
            System.out.println(dia + "/" + mes + "/" + ano);
        }
    }
}