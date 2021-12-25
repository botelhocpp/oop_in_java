package contato;

/**
 * Sequência de testes finitos fornecidos
 * pelo professor, no tópico "Shell", para
 * a verificação das classes do pacote
 * "contato".
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 05/12/2021
 * @see contato.Fone
 * @see contato.Contato
 */
public class Manual {
    public static void main(String[] args) {
        /**
         * __case definindo nome
         */
        Contato david = new Contato("david", null);
        System.out.println(david);
        //- david

        /**
         * __case definindo nome
         */
        david.addFone(new Fone("oi", String.valueOf(88)));
        david.addFone(new Fone("tim", String.valueOf(99)));
        david.addFone(new Fone("tim", String.valueOf(98)));
        david.addFone(new Fone("vivo", String.valueOf(83)));
        System.out.println(david);
        //- david [0:oi:88] [1:tim:99] [2:tim:98] [3:vivo:83]

        /**
         * __case removendo telefone por indice
         */
        david.rmFone(2);
        System.out.println(david);
        //- david [0:oi:88] [1:tim:99] [2:vivo:83]
        david.rmFone(0);
        System.out.println(david);
        //- david [0:tim:99] [1:vivo:83]

        /**
         * __case validando numero de fone
         */
        david.addFone(new Fone("tim", "9a9"));
        //fail: invalid number 'tim:9a9'.
        david.addFone(new Fone("tim", "(85)99.99"));
        System.out.println(david);
        //- david [0:tim:99] [1:vivo:83] [2:tim:(85)99.99]
        
    }
}
