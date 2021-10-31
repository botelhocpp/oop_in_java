package questao02.Calendario;

/**
 * A classe EventosComemorativos da biblioteca Calendario nos permite
 * testar e verificar os métodos e atributos da classe Data. Todas as
 * informações aqui são fictícias.
 * 
 * Para as operações, já explicadas anteriormente, foram dadas
 * mais explicações abaixo. 
 * 
 * @author  Pedro M. Botelho
 * @version 1.0
 * @since   28/10/2021
 */

public class EventosComemorativos {
    public static void main(String[] args){
        /**
         * Cria uma instância da classe Data que representa apenas horas.
         */
        Data horaCorrente = new Data((byte) 15, (byte) 29);
        
        /**
         * Usa printf para formatar uma String usando os metodos getters da classe para vizualizar o horário.
         */
        System.out.printf("Agora são %02d horas e %02d minutos... Vou me atrasar pra aula de POO...%n", horaCorrente.getHoras(), horaCorrente.getMinutos());

        /**
         * Dessa vez, cria uma instância que representa apenas uma data do calendário gregoriano.
         */
        Data dataAniversario = new Data((byte) 2, (byte) 1, (short) 1997);

        /**
         * Usa printf para formatar uma String usando os metodos getters da classe para vizualizar a data.
         */
        System.out.printf("Lembrete: Aniversário da morena é dia %02d de %s de %04d, não posso esquecer!%n", dataAniversario.getDia(), dataAniversario.getMesExtenso(), dataAniversario.getAno());

        /**
         * Agora, é criado uma instância que representa uma data e uma hora.
         */
        Data festaFaculdade = new Data((byte) 12, (byte) 3, (short) 2022, (byte) 19, (byte) 30);

        /**
         * É usado o método toString para imprimir a data no formato padrão.
         */
        System.out.println("Preciso lembrar disso! 'Festa da faculdade: " + festaFaculdade + ".'");

        /**
         * É criado uma nova instância utilizando-se de dados de uma outra instância, adicionando outros dados fora a parte.
         */
        Data festaAniversario = new Data(dataAniversario.getDia(), dataAniversario.getMes(), (short) 2022, (byte) 20, (byte) 30);
        System.out.println("Preciso lembrar disso? 'Festa de aniversário da morena: " + festaAniversario + ".'");

        Data cursoBombeiros = new Data((byte) 2, (byte) 1, (short) 2022, (byte) 13, (byte) 30);
        System.out.println("Será que consigo ir para o curso dos bombeiros e também para a festa da morena?");
        
        /**
         * Os métodos, singulares, para comparação de datas e horas são utilizados para imprimir Strings distintas.
         * Caso a comparação seja diferente de zero é porque a comparação resultou em "diferente".
         * 
         * Lembrete: comparaData apenas compara os campos de DATA das instâncias, ou seja, se elas não podem representar
         * datas então a comparação não pode acontecer. O mesmo ocorre para comparaHora. Aqui não faço a verificação, já
         * que estou inicializando manualmente, mas é imprescidível. A forma certa seria utiliza o tratador de exceção do  
         * java, try{...} catch(Exception e){...}, sendo a abordagem escolhida mais simplista.
         * 
         */
        if(cursoBombeiros.comparaData(festaAniversario) != 0){
            System.out.println("Bem... Não são no mesmo dia, então tá safe!");
        }
        else{
            System.out.println("Nooooossa... São no mesmo dia... Não sendo na mesma hora acho que dá certo... Qualquer coisa dou um migué pra morena.");
            if(cursoBombeiros.comparaHora(festaAniversario) != 0){
                System.out.println("Pronto. Dá certo, não são na mesma hora.");
            }
            else{
                System.out.println("Migué it is.");
            }
        }

        /**
         * É utilizado um operador ternário, em conjunto com um método de comparação de horas, para escolher uma
         * String baseado na igualdade entre duas instâncias;
         */
        String verificaIgualdade = (festaAniversario.comparaData(dataAniversario) == 0) ? "Sim" : "Não";
        System.out.println("A festa de aniversário acontecerá na data de aniversário? Resposta: " + verificaIgualdade);

        /**
         * Bem, o aluno chato vai dar uma festa no mesmo dia e no mesmo horário da festa da faculdade, porquê ele é o
         * chato afinal. Então é usado o método clone para atribuir à instância "festaAlunoChato" o mesmo estado de
         * "festaFaculdade".
         */
        Data festaAlunoChato = festaFaculdade.clone();

        /**
         * É usado o método geral "compara" para verificar igualdade entre as instâncias recentemente clonadas, e, com o
         * auxílio do operador ternário, atribuído uma String, baseado na comparação.
         * 
         * Lembrete: O método "compara" pode se utilizar dos outros dois métodos de comparação, caso algum dos métodos
         * seja limitado a apenas representar datas e horários. Caso não, a comparação leva em conta as datas e as horas.
         */
        verificaIgualdade = (festaAlunoChato.compara(festaFaculdade) == 0) ? "Sim" : "Não";
        System.out.println("A festa do aluno chato acontecerá, novamente, na data da festa da faculdade? Resposta: " + verificaIgualdade);

        /**
         * Três Strings são impressas para que os formatos possíveis sejam visíveis. A função toString, invocada
         * quando a referência da classe é utilizada em um contexto de String, verifica as capacidades de representação
         * da instância, e, baseado nisso, retorna uma String formatada de uma das três formas:
         * 
         * Apenas hora: hh:mi
         * Apenas data: dd/mm/aaaa
         * Data e hora: dd/mm/aaaa hh:mi
         * 
         */
        System.out.println("Vamos só verificar os três formatos possíveis do método toString!");
        System.out.println("Apenas Hora: " + horaCorrente);
        System.out.println("Apenas Data: " + dataAniversario);
        System.out.println("Data e Hora: " + festaAlunoChato);
    }
}
