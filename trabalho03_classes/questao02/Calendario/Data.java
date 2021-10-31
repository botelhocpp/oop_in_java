package questao02.Calendario;

/**
 * A classe Data, da biblioteca Calendario, permite a representação de
 * data e hora de maneira simplificada, podendo o usuário escolher
 * entre uma representação em conjunto, ou apenas representar data
 * ou hora. Isso é feito escolhendo o construtor adequado. O controle
 * da representação escolhida é feito por meio de duas variáveis
 * booleanas, que são ativadas conforme a necessidade, na criação,
 * e depois verificadas na classe, mantendo a integridade.
 * 
 * Os atributos estão protegidos, para evitar sua incorreta 
 * manipulação, devendo ser utilizados métodos para os acessar e 
 * modificar.
 * 
 * Os atributos só podem ser modificados no ato na inicialização,
 * por meio de um dos construtores, e obtidos por meio de métodos
 * getters, pelo método clone (indiretamente) e pelo método toString,
 * em forma de uma String formatada.
 * 
 * @author  Pedro M. Botelho
 * @version 1.0
 * @since   28/10/2021
 */

public class Data {
    /**
     * Representa o dia, da data, devendo estar sempre entre 1 e 31,
     * incluíndo os limites. Dependendo do mês e do ano o limite pode
     * ser menor.
     */
    private byte dia;

    /**
     * Representa o mês, da data, devendo estar sempre entre 1 e 12,
     * incluindo os limites.
     */
    private byte mes;

    /**
     * Representa o ano, da data, devendo estar sempre entre 1 e 2099,
     * incluindo os limites.
     */
    private short ano;

    /**
     * Representa as horas, da data, devendo estar sempre entre 0 e 24,
     * incluindo os limites.
     */
    private byte horas;

    /**
     * Representa os minutos, da data, devendo estar sempre entre 0 e
     * 60, incluindo os limites.
     */
    private byte minutos;

    /**
     * Controla se o objeto da classe Data representa apenas um data,
     * ou seja, um dia, de um mês, de um ano.
     */
    private boolean apenasData; 

    /**
     * Controla se o objeto da classe Data representa apenas um horário,
     * ou seja, uma valor para hora e um para minuto.
     */
    private boolean apenasHora; 
    
    /**
     * Inicializa o objeto como apenas uma representação de uma data,
     * indicado pela variável de controle 'apenasData' e discernido
     * pelos parâmetros. A string retornada pelo método toString para
     * um objeto obtido por meio desse construtor será: dd/mm/aaaa.
     * 
     * Os parametros serão repassados para os atributos se eles
     * estiverem dentro dos limites desejados.
     *  
     * @param dia O dia da data, será repassado para o atributo 'dia'.
     * Seu valor máximo depende do mês e do ano, e seu valor mínimo
     * será sempre 1.Caso o mês seja 2 e o ano seja bissexto o valor
     * máximo é 29. Caso o mês seja 2 e o ano não seja bissexto, o valor
     * máximo será 28. Se mês for par e menor que 8, o valor máximo 
     * deverá ser 30, caso contrário, será 31. 
     * @param mes O mes da data, será repassado para o atributo 'mes'.
     * Seu valor máximo sempre será 12, e o mínimo 1.
     * @param ano O ano da data, será repassado para o atributo 'ano'.
     * Seu valor mínimo sempre será 1, e seu valor máximo sempre será
     * 2099.
     */
    public Data(byte dia, byte mes, short ano){
        this(dia, mes, ano, (byte) 0, (byte) 0);
        apenasData = true;
    }
    
    /**
     * Inicializa o objeto como apenas uma representação de um horário,
     * indicado pela variável de controle 'apenasHora' e discernido
     * pelos parâmetros. A string retornada pelo método toString para
     * um objeto obtido por meio desse construtor será: hh:mi.
     * 
     * Os parametros serão repassados para os atributos se eles
     * estiverem dentro dos limites desejados.
     *  
     * @param horas As horas da data, será repassado para o atributo
     * 'horas'. Seu valor máximo sempre será 23, e o mínimo 0.
     * @param minutos Os minutos da data, será repassado para o atributo
     * 'minutos'. Seu valor máximo sempre será 59, e o mínimo 0.
     */
    public Data(byte horas, byte minutos){
        this((byte) 1, (byte) 1, (short) 1, horas, minutos);
        apenasHora = true;
    }

    /**
     * Inicializa o objeto como uma representação de uma data e de um
     * horário, discernido pelos parâmetros. As variáveis de controle,
     * portanto, permanecem com seus valores default, 'false', já que
     * esse objeto não será uma representação singular.
     * A string retornada pelo método toString para um objeto obtido
     * por meio desse construtor será: dd/mm/aaaa hh:mi.
     * 
     * Os parametros serão repassados para os atributos se eles
     * estiverem dentro dos limites desejados.
     *  
     * @param dia O dia da data, será repassado para o atributo 'dia'.
     * Seu valor máximo depende do mês e do ano, e seu valor mínimo
     * será sempre 1.Caso o mês seja 2 e o ano seja bissexto o valor
     * máximo é 29. Caso o mês seja 2 e o ano não seja bissexto, o valor
     * máximo será 28. Se mês for par e menor que 8, o valor máximo 
     * deverá ser 30, caso contrário, será 31. 
     * @param mes O mes da data, será repassado para o atributo 'mes'.
     * Seu valor máximo sempre será 12, e o mínimo 1.
     * @param ano O ano da data, será repassado para o atributo 'ano'.
     * Seu valor mínimo sempre será 1, e seu valor máximo sempre será
     * 2099.
     * @param horario Uma data que consiga representar horas e minutos.
     * Os três primeiros atributos seram repassados para os seus respectivos
     * atributos, porém, os atributos "horas" e "minutos" seram retirados
     * do parametro "horario".
     */
    public Data(byte dia, byte mes, short ano, Data horario){
        this(dia, mes, ano, horario.horas, horario.minutos);
    }

    /**
     * Inicializa o objeto como uma representação de uma data e de um
     * horário, discernido pelos parâmetros. As variáveis de controle,
     * portanto, permanecem com seus valores default, 'false', já que
     * esse objeto não será uma representação singular.
     * A string retornada pelo método toString para um objeto obtido
     * por meio desse construtor será: dd/mm/aaaa hh:mi.
     * 
     * Os parametros serão repassados para os atributos se eles
     * estiverem dentro dos limites desejados.
     *  
     * @param horario Uma data que consiga representar dias, meses e anos.
     * Os dois ultimos atributos seram repassados para os seus respectivos
     * atributos, porém, os atributos "dia", "mes" e "ano" seram retirados
     * do parametro "data".
     * @param horas As horas da data, será repassado para o atributo
     * 'horas'. Seu valor máximo sempre será 23, e o mínimo 0.
     * @param minutos Os minutos da data, será repassado para o atributo
     * 'minutos'. Seu valor máximo sempre será 59, e o mínimo 0.
     */
    public Data(Data data, byte horas, byte minutos){
        this(data.dia, data.mes, data.ano, horas, minutos);
    }

    /**
     * Inicializa o objeto como uma representação de uma data e de um
     * horário, discernido pelos parâmetros. As variáveis de controle,
     * portanto, permanecem com seus valores default, 'false', já que
     * esse objeto não será uma representação singular.
     * A string retornada pelo método toString para um objeto obtido
     * por meio desse construtor será: dd/mm/aaaa hh:mi.
     * 
     * Os parametros serão repassados para os atributos se eles
     * estiverem dentro dos limites desejados.
     *  
     * @param dia O dia da data, será repassado para o atributo 'dia'.
     * Seu valor máximo depende do mês e do ano, e seu valor mínimo
     * será sempre 1.Caso o mês seja 2 e o ano seja bissexto o valor
     * máximo é 29. Caso o mês seja 2 e o ano não seja bissexto, o valor
     * máximo será 28. Se mês for par e menor que 8, o valor máximo 
     * deverá ser 30, caso contrário, será 31. 
     * @param mes O mes da data, será repassado para o atributo 'mes'.
     * Seu valor máximo sempre será 12, e o mínimo 1.
     * @param ano O ano da data, será repassado para o atributo 'ano'.
     * Seu valor mínimo sempre será 1, e seu valor máximo sempre será
     * 2099.
     * @param horas As horas da data, será repassado para o atributo
     * 'horas'. Seu valor máximo sempre será 23, e o mínimo 0.
     * @param minutos Os minutos da data, será repassado para o atributo
     * 'minutos'. Seu valor máximo sempre será 59, e o mínimo 0.
     */
    public Data(byte dia, byte mes, short ano, byte horas, byte minutos){  
        this.horas = (horas >= 0 && horas <= 24) ? horas : 0;
        this.minutos = (minutos >= 0 && minutos <= 60) ? minutos : 0;
        
        this.mes = (mes > 0 && mes <= 12) ? mes : 1;
        this.ano = (ano > 0 && ano <= 2099) ? ano : 1;
        if(dia > 0 && dia <= 31){
            if(this.mes == 2){
                if(isBissexto()){
                    this.dia = (dia > 0 && dia <= 29) ? dia : 1;
                }
                else{
                    this.dia = (dia > 0 && dia <= 28) ? dia : 1; 
                }
            }
            else if((this.mes < 8) && (this.mes % 2 == 0)){
                this.dia = (dia > 0 && dia <= 30) ? dia : 1;
            }
            else{
                this.dia = (dia > 0 && dia <= 31) ? dia : 1;
            }
        }
    }
    
    /**
     * Verifica se a igualdade da instância atual quanto à outra
     * instância da classe, em relação à suas datas apenas. e
     * somente no caso de ambas as instâncias representarem datas.
     * 
     * @param referencia Uma referência a um outro objeto da classe 
     * Data, o qual se deseja testar a igualdade.
     * @return 0 se a instância que invocou o método é igual
     * à instância passada como parâmetro, 1 se for maior e -1
     * se for menor.
     */
    public byte comparaData(Data referencial){
        if(this.apenasHora || referencial.apenasHora){
            return Byte.MIN_VALUE;
        }
        if(this.ano > referencial.ano){
            return 1;
        }
        else if(this.ano == referencial.ano){
            if(this.mes > referencial.mes){
                return 1;
            }
            else if(this.mes == referencial.mes){
                if(this.dia > referencial.dia){
                    return 1;
                }
                else if(this.dia == referencial.dia){
                    return 0;
                }
                else{
                    return -1;
                }
            }
            else{
                return -1;
            }
        }
        return -1;
    }
    
    /**
     * Verifica se a igualdade da instância atual quanto à outra
     * instância da classe, em relação à seus horários apenas, e
     * somente no caso de ambas as instâncias representarem horas.
     * 
     * @param referencia Uma referência a um outro objeto da classe 
     * Data, o qual se deseja testar a igualdade.
     * @return 0 se a instância que invocou o método é igual
     * à instância passada como parâmetro, 1 se for maior e -1
     * se for menor.
     */
    public byte comparaHora(Data referencial){
        if(this.apenasData || referencial.apenasData){
            return Byte.MIN_VALUE;
        }
        if(this.horas > referencial.horas){
            return 1;
        }
        else if(this.horas == referencial.horas){
            if(this.minutos > referencial.minutos){
                return 1;
            }
            else if(this.minutos == referencial.minutos){
                return 0;
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }   
    
    /**
     * Verifica se a igualdade da instância atual quanto à outra
     * instância da classe. Esse método verifica se ao menos uma das
     * instâncias representam apenas data ou hora, e, se sim, realiza
     * a comparação baseada apenas em sua representação. Caso as
     * instâncias representem data e hora, primeiro é verificado a
     * data, e se caso sejam iguais, então é verificado o horário. 
     * 
     * @param referencia Uma referência a um outro objeto da classe 
     * Data, o qual se deseja testar a igualdade.
     * @return 0 se a instância que invocou o método é igual
     * à instância passada como parâmetro, 1 se for maior e -1
     * se for menor.
     */
    public byte compara(Data referencial){
        if(this.apenasData || referencial.apenasData){
            return this.comparaData(referencial);
        }
        else if(this.apenasHora || referencial.apenasHora){
            return this.comparaHora(referencial);
        }
        byte dataComparada = this.comparaData(referencial);
        if(dataComparada == 1){
            return 1;
        }
        else if(dataComparada == 0){
            byte horaComparada = this.comparaData(referencial);
            if(horaComparada == 1){
                return 1;
            }
            else if(horaComparada == 0){
                return 0;
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }

    /**
     * Caso a instância possa representar uma data, devolve o dia
     * para o usuário, se e somente se. Caso não possa, um número
     * muito pequeno é retornado, para simbolizar um erro ao retornar
     * o dia de uma instância que não pode representar dias.
     * 
     * @return O dia da data, ou um valor muito pequeno quando a
     * instância não puder simbolizar uma data.
     */
    public byte getDia(){
        if(apenasHora){
            return Byte.MIN_VALUE;
        }
        return this.dia;
    }

    /**
     * Caso a instância possa representar uma data, devolve o mes
     * para o usuário, se e somente se. Caso não possa, um número
     * muito pequeno é retornado, para simbolizar um erro ao retornar
     * o mes de uma instância que não pode representar meses.
     * 
     * @return O mes da data, ou um valor muito pequeno quando a
     * instância não puder simbolizar uma data.
     */
    public byte getMes(){
        if(apenasHora){
            return Byte.MIN_VALUE;
        }
        return this.mes;
    }

    /**
     * Caso a instância possa representar uma data, devolve o mes em
     * extenso para o usuário, se e somente se. Caso não possa, uma
     * String nula é retornada, para simbolizar um erro ao retornar
     * o mes de uma instância que não pode representar meses.
     * 
     * @return O mes da data, ou uma String nula quando a instância não
     * puder simbolizar uma data.
     */
    public String getMesExtenso(){
        if(apenasHora){
            return null;
        }
        switch(this.mes){
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
        }
        return "Dezembro";
    }
    
    /**
     * Caso a instância possa representar uma data, devolve o ano
     * para o usuário, se e somente se. Caso não possa, um número
     * muito pequeno é retornado, para simbolizar um erro ao retornar
     * o ano de uma instância que não pode representar anos.
     * 
     * @return O mes da data, ou um valor muito pequeno quando a
     * instância não puder simbolizar uma data.
     */
    public short getAno(){
        if(apenasHora){
            return Short.MIN_VALUE;
        }
        return this.ano;
    }
    
    /**
     * Caso a instância possa representar um horário, devolve as horas
     * para o usuário, se e somente se. Caso não possa, um número
     * muito pequeno é retornado, para simbolizar um erro ao retornar
     * as horas de uma instância que não pode representar horas.
     * 
     * @return As horas da data, ou um valor muito pequeno quando a
     * instância não puder simbolizar um horário.
     */
    public byte getHoras(){
        if(apenasData){
            return Byte.MIN_VALUE;
        }
        return this.horas;
    }
    
    /**
     * Caso a instância possa representar um horário, devolve os minutos
     * para o usuário, se e somente se. Caso não possa, um número
     * muito pequeno é retornado, para simbolizar um erro ao retornar
     * os minutos de uma instância que não pode representar minutos.
     * 
     * @return Os minutos da data, ou um valor muito pequeno quando a
     * instância não puder simbolizar um horário.
     */
    public byte getMinutos(){
        if(apenasData){
            return Byte.MIN_VALUE;
        }
        return this.minutos;
    }
    
    /**
     * Diz se o ano é bissexto ou não, caso a instância não consiga
     * representar datas. Um ano é considerado 'bissexto' se ele for
     * divisível por 400, ou se ele for divisível por 4 e não por 100.
     * 
     * @return 'true' se o ano for bissexto, ou 'false' se não for, ou
     * no caso da instância não consiguir representar datas.
     */
    public boolean isBissexto(){
        if(apenasHora){
            return false;
        }
        return (this.ano % 400 == 0) || ((this.ano % 4 == 0) && !(this.ano % 100 == 0));
    }

    /**
     * Cria uma cópia do objeto atual da classe. Irá basicamente realizar
     * a tarefa do operador new e do construtor, porém com os mesmos
     * atributos da instância original.
     * 
     * @return Uma referência a uma instância da classe com a mesmo
     * estado da instância que invocou o método.
     */
    public Data clone(){
        Data copia = new Data(this.dia, this.mes, this.ano, this.horas, this.minutos);
        copia.apenasData = this.apenasData;
        copia.apenasHora = this.apenasHora;
        return copia;
    }

    /**
     * Devolve a data na forma padrão, por meio de uma String bem
     * formatada, baseado nas variáveis de controle configuradas na
     * criação da instância. Dessa forma a String retornada irá variar
     * de instância para instância, dependendo se ela consegue ou não
     * representar horas(hh:mi), datas(dd/mm/aaaa), ou datas e horas
     * (dd/mm/aaaa hh:mi).
     * 
     * @return A data formata no formato padrão, dependendo do tipo
     * de data criada, ou seja, se representa apenas datas ou horas, ou
     * ambas.
     */
    public String toString(){
        if(apenasData){
            return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
        }
        else if(apenasHora){
            return String.format("%02d:%02d", this.horas, this.minutos);
        }
        else{
            return String.format("%02d/%02d/%04d %02d:%02d", this.dia, this.mes, this.ano, this.horas, this.minutos);
        }
    }
}