package questao03.Aviao;

import questao02.Calendario.Data;

/**
 * A classe TesteMetodos da biblioteca Aviao nos permite testar
 * os atributos e os métodos das classes Voo e Passageiro, utilizadas
 * para controlar um avião comercial, representado pela biblioteca
 * Aviao.
 * 
 * A classe Passageiro irá manter os dados de cada tripulante da
 * aeronave, e a classe Voo, as informações de cada viagem.
 * 
 * Para as operações, já explicadas anteriormente, foram dadas
 * mais explicações abaixo. 
 * 
 * @author  Pedro M. Botelho
 * @version 1.0
 * @since   29/10/2021
 */

public class AgenciaVoos {

    public static void main(String[] args){
        /**
         * Um voo de Petrolina a Paris foi instânciado, para o dia 31/10/2021, às 13:50.
         */
        Data horariopetrolinaParis = new Data((byte) 31, (byte) 10, (short) 2021, (byte) 13, (byte) 50);
        Voo petrolinaParis = new Voo(471047, horariopetrolinaParis);
        System.out.println("----------------------------------------------------\nVoo Petrolina-Paris");
        System.out.println(petrolinaParis + "\n");
        System.out.println("\n----------------------------------------------------\n");
        
        /**
         * Um passageiro, João Kaio, tenta embarcar no voo de Petrolina, na poltrona 12.
         */
        Passageiro joao = new Passageiro("João Kaio", petrolinaParis, 30581330550L, (byte) 12);
        petrolinaParis.ocupaPoltrona(joao); 
        System.out.println(joao + "\n");
        
        /**
         * Um passageiro, Pedro Jr., tenta embarcar no voo de Petrolina, na poltrona 101. Essa poltrona
         * não existe, já que temos apenas 100 poltronas. Ele será alocado para a cadeira 1.
         */
        Passageiro pedro = new Passageiro("Pedro Jr.", petrolinaParis, 73298712100L, (byte) 101); 
        petrolinaParis.ocupaPoltrona(pedro);
        System.out.println(pedro + "\n");
        
        /**
         * Um passageiro, Ian Guimarães, tenta embarcar no voo de Petrolina, na poltrona 12. Essa poltrona
         * já foi escolhida. Ele será alocado para a cadeira 2.
         */
        Passageiro ian = new Passageiro("Ian Guimarães", petrolinaParis, 89511236510L, (byte) 12); 
        petrolinaParis.ocupaPoltrona(ian);
        System.out.println(ian + "\n");
        
        /**
         * Um passageiro, David Vitor, tenta embarcar no voo de Petrolina, na poltrona 12. Essa poltrona
         * já foi escolhida. Ele será alocado para a cadeira 3.
         */
        Passageiro david = new Passageiro("David Vitor", petrolinaParis, 24101198702L, (byte) 12); 
        petrolinaParis.ocupaPoltrona(david);
        System.out.println(david + "\n");

        System.out.println("----------------------------------------------------\nVoo Petrolina-Paris");
        System.out.println(petrolinaParis + "\n");
        System.out.println("\n----------------------------------------------------\n");

        /**
         * O voo de Petrolina a Paris teve que ser clonado, para que possa ser salvo no backup!
         */
        Voo petrolinaParis2 = petrolinaParis.clone();
        System.out.println(petrolinaParis2);

        /**
         * Um novo voo foi instânciado, dessa vez de Fortaleza a Manaus, para o dia 12/01/2022, às 21:15.
         */
        Data horarioFortalezaManaus = new Data((byte) 12, (byte) 01, (short) 2022, (byte) 21, (byte) 15);
        Voo fortalezaManaus = new Voo(490, horarioFortalezaManaus);
        
        /**
         * Um exame de rotina foi executado, para saber se os voos não estão clonados.
         */
        System.out.println(fortalezaManaus.equals(petrolinaParis));

        /**
         * O voo de Fortaleza a Manaus teve que ser clonado, para que possa ser salvo no backup!
         * É verificado, depois, se a clonagem foi bem sucedida, verificando a igualdade.
         */
        Voo fortalezaManaus2 = fortalezaManaus.clone();
        System.out.println(fortalezaManaus.equals(fortalezaManaus2));

        /**
         * Alguns passageiros fizeram uma reserva pelo site, para um voo de São Paulo para
         * Juazeiro do Norte, que será às 7:58 de 30/11/2021.
         * O voo é, então, instanciado já passando as reservas dos passageiros.
         */
        Passageiro[] reservaSite = {joao, pedro, ian, david};
        Data horarioSPJN = new Data((byte) 30, (byte) 11, (short) 2021, (byte) 7, (byte) 58);
        Voo saoPauloJuazeiroNorte = new Voo(90641452, horarioSPJN, reservaSite);
        System.out.println(saoPauloJuazeiroNorte);

        /**
         * Pedro quer mudar de voo... E ainda quer ocupar a mesma cadeira que ocupava antes.
         * Que exigente! Vamos ver como as instâncias do passageiro e dos dois voos, o anterior
         * e o atual, se comportam!
         */
        System.out.println("\n-------------------ANTES DA MUDANÇA DE VOO-----------------------\n");
        System.out.println(pedro + "\n");
        System.out.println(petrolinaParis + "\n");
        System.out.println(fortalezaManaus + "\n");
        System.out.println("\n-------------------DEPOIS DA MUDANÇA DE VOO-----------------------n");
        pedro.mudarVoo(fortalezaManaus, pedro.getPoltrona());
        System.out.println(pedro + "\n");
        System.out.println(petrolinaParis + "\n");
        System.out.println(fortalezaManaus + "\n");
        System.out.println("\n-------------------FIM DA MUDANÇA DE VOO-----------------------n");

        /**
         * O passageiro Pedro foi clonado, por nós! Seria isso um crime?
         */
        Passageiro teste = pedro.clone();
        System.out.println("pedro é igual a pedro?" + teste.equals(pedro));

        /**
         * Bem, o passageiro achou o processo de clonagem interessante, e agora quer criemos uma
         * identidade falsa pra ele! Acho que nos metemos numa fria.
         * 
         * Criamos uma nova identidade pra ele, mas com os mesmos dados, e o colocamos no voo de Petrolina
         * para Paris. Acho que não somos muito bons nisso...
         */
        Passageiro pedro2 = new Passageiro(pedro.getNome(), petrolinaParis, pedro.getnumericCPF(), (byte) 12);
        System.out.println("Pedro é igual a Pedro?" + pedro.comparaPessoa(pedro2));

        /**
         * Autoexplicativo, né?
         */
        System.out.println("Quantidade de Vagas no voo Petrolina-Paris: " + petrolinaParis.getVagas());
        System.out.println("Quantidade de Vagas no voo Fortaleza-Manaus: " + fortalezaManaus.getVagas());

        /**
         * Isso é meio louco né? Vamos lá...
         * pedro.getVoo() vai retornar uma referência ao voo a qual Pedro pertence.
         * A partir dessa referencia podemos chamar getPassageiro, que irá retornar o
         * passageiro que está na poltrona pedro.getPoltrona(), ou seja, o proprio Pedro!
         */
        Passageiro clonagemDoida = pedro.getVoo().getPassageiro(pedro.getPoltrona());
        System.out.println(clonagemDoida + "\n");
        System.out.println(pedro + "\n");
        System.out.println("Igualdade da Clonagem Doida: " + clonagemDoida.equals(pedro));

        
        /*
        Isso aqui vai imprimir todos os passageiros de Petrolina a Paris. Para ver, só tirar os comentários.
        getPassageiros vai retornar uma copia do vetor de passageiros, sem nulos.
        */
        /*
        System.out.println("\n----------------------------------------------------\n" + petrolinaParis + "\n----------------------------------------------------\n");
        Passageiro[] t2 = petrolinaParis.getPassageiros();
        for(Passageiro t : t2){
            System.out.println(t + "\n----------------------------------------------------\n");
        }
        */

        /*
        Isso aqui vai imprimir todos as poltronas de Petrolina a Paris. Para ver, só tirar os comentários.
        getPoltronas vai retornar uma copia do vetor de poltronas, com nulos.
        */
        /*
        Passageiro[] t3 = petrolinaParis.getPoltronas();
        for(Passageiro t : t3){
            System.out.println(t);
        }
        */
        
    }
}