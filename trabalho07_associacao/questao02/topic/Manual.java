package topic;

/**
 * Conjunto finito de testes para o pacote "topic".
 * Estes são os mesmos testes indicados pelo professor.
 * 
 * @author Pedro M. Botelho
 * @since 02/12/2021
 * @see topic.Passageiro
 * @see topic.Topic
 */
public class Manual {
    public static void main(String[] args){
        /**
         * __case Inicializar
         */
        Topic topic = new Topic(0, 0);
        System.out.println(topic);
        //[]
        topic = new Topic(5, 2);
        System.out.println(topic + "\n");
        //[@ @ = = =]

        /**
         * __case Embarque
         */
        topic.insert(new topic.Passageiro("davi", 17));
        System.out.println(topic);
        //[@ @ =davi:17 = =]
        topic.insert(new topic.Passageiro("joao", 103));
        System.out.println(topic);
        //[@joao:103 @ =davi:17 = =]
        topic.insert(new topic.Passageiro("ana", 35));
        System.out.println(topic);
        //[@joao:103 @ =davi:17 =ana:35 =]
        topic.insert(new topic.Passageiro("rex", 20));
        topic.insert(new topic.Passageiro("bia", 16));
        System.out.println(topic + "\n");
        //[@joao:103 @bia:16 =davi:17 =ana:35 =rex:20]
        
        /**
         * __case Desembarque
         */
        topic.remove("davi");
        System.out.println(topic);
        //[@joao:103 @bia:16 = =ana:35 =rex:20]
        topic.insert(new topic.Passageiro("aragao", 96));
        System.out.println(topic + "\n");
        //[@joao:103 @bia:16 =aragao:96 =ana:35 =rex:20]

        /**
         * __case Erros
         */
        topic.insert(new topic.Passageiro("lucas", 23));
        //fail: topic lotada
        topic.remove("marcelo");
        //fail: paassageiro não está na topic
        topic.remove("ana");
        topic.insert(new topic.Passageiro("bia", 13));
        //fail: pass já está na topic
        System.out.println(topic + "\n");
        //[@joao:103 @bia:16 =aragao:96 = =rex:20]

        /**
         * __case Limites Capacidade
         */
        topic = new Topic(4, 2);
        //[@ @ = =]
        System.out.println(topic);
        topic.remove("haroldo");
        //fail: passageiro não está na topic.
        topic.insert(new topic.Passageiro("lucas", 23));
        topic.insert(new topic.Passageiro("bia", 13));
        topic.insert(new topic.Passageiro("seu agripino", 99));
        topic.insert(new topic.Passageiro("jeredy", 11));
        System.out.println(topic);
        //[@seu agripino:99 @jeredy:11 =lucas:23 =bia:13]
    }
}
