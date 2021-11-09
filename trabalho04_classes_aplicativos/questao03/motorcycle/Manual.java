package motorcycle;

/**
 * Sequência de testes finitos para as classes Motorcycle e Person.
 * 
 * 31/10/2021 - Commit Inicial. Estrutura proposta pelo professor.
 * 
 * @author Atílio G. Luiz
 * @since 31/10/2021
 */
public class Manual {
    public static void main(String[] args) {

        //case subindo e buzinando
        Motorcycle moto = new Motorcycle();
        System.out.println(moto);
        //power: 1, minutos: 0, person: null
        moto.honk();
        //fail: moto vazia
        moto.in(new Person("marcos", 4));
        System.out.println(moto);
        //power: 1, minutos: 0, person: [marcos:4]
        moto.honk();
        //Pem
        moto.in(new Person("marisa", 2));
        //fail: moto ocupada
        System.out.println(moto);
        //power: 1, minutos: 0, person: [marcos:4]

        //case subindo e buzinando
        moto = new Motorcycle(5);
        System.out.println(moto);
        //power: 5, minutos: 0, person: null
        moto.in(new Person("marcos", 4));
        System.out.println(moto);
        //power: 5, minutos: 0, person: [marcos:4]
        moto.honk();
        //Peeeeem

        //case subindo e trocando
        moto = new Motorcycle(7);
        moto.in(new Person("heitor", 6));
        System.out.println(moto);
        //power: 7, minutos: 0, person: [heitor:6]
        Person heitor = moto.out();
        System.out.println(heitor);
        //[heitor:6]
        moto.out();
        //fail: moto vazia
        moto.in(new Person("suzana", 8));
        System.out.println(moto);
        //power: 7, minutos: 0, person: [suzana:8]

        //case passeando
        moto = new Motorcycle(7);
        moto.in(new Person("suzana", 8));
        moto.drive(10);
        //fail: time zerado
        moto.buy(40);
        System.out.println(moto);
        //power: 7, minutos: 40, person: [suzana:8]
        moto.drive(20);
        System.out.println(moto);
        //power: 7, minutos: 20, person: [suzana:8]

        //case nem grande nem pequeno
        moto = new Motorcycle(7);
        moto.buy(20);
        moto.in(new Person("andreina", 23));
        moto.drive(15);
        //fail: muito grande para andar de moto
        System.out.println(moto);
        //power: 7, minutos: 20, person: [andreina:23]

        //case acabou o time
        moto = new Motorcycle(7);
        moto.buy(20);
        moto.in(new Person("andreina", 6));
        moto.drive(15);
        System.out.println(moto);
        //power: 7, minutos: 5, person: [andreina:6]
        moto.drive(10);
        //fail: andou 5 min e acabou o time
    }
}
