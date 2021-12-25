package cinema;

/**
 * Conjunto finito de testes para o pacote "cinema".
 * 
 * @author Atílio G. Luiz
 * @since 02/12/2021
 * @see cinema.Cliente
 * @see cinema.Sala
 */
public class Manual {
    public static void main(String[] args) {
        Sala cinema = new Sala(0);
        System.out.println(cinema);
        // [ ]
        cinema = new Sala(5);
        System.out.println(cinema.toString());
        // [ - - - - - ]
        cinema = new Sala(4);
        System.out.println(cinema);
        // [ - - - - ]
        cinema.reservar("davi", "3232", 0);
        cinema.reservar("joao", "3131", 3);
        System.out.println(cinema);
        // [ davi:3232 - - joao:3131 ]
        cinema.reservar("rute", "3030", 0);
        // fail: cadeira ja esta ocupada
        cinema.reservar("davi", "3234", 2);
        // fail: cliente ja esta no cinema
        cinema.cancelar("davi");
        System.out.println(cinema);
        // [ - - - joao:3131 ]
        cinema.cancelar("rita");
        // fail: cliente nao esta no cinema
        System.out.println(cinema);
        // [ - - - joao:3131 ]
    }
}