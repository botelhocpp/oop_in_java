package car;

/**
 * Sequência de testes finitos para a classe Car.
 * 
 * 31/10/2021 - Commit Inicial. Estrutura proposta pelo professor.
 * 
 * @author Atílio G. Luiz
 * @since 31/10/2021
 */
public class Manual {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);
        //pass: 0, gas: 0, km: 0
        car.in();
        car.in();
        System.out.println(car);
        //pass: 2, gas: 0, km: 0
        car.in();
        //fail: limite de pessoas atingido
        System.out.println(car);
        //pass: 2, gas: 0, km: 0
        car.out();
        car.out();
        car.out();
        //fail: nao ha ninguem no carro
        System.out.println(car);
        //pass: 0, gas: 0, km: 0

        car = new Car();
        car.fuel(60);
        System.out.println(car);
        //pass: 0, gas: 60, km: 0

        car.drive(10);
        //fail: nao ha ninguem no carro

        car.in();
        car.drive(10);
        System.out.println(car);
        //pass: 1, gas: 50, km: 10

        car.drive(70);
        //fail: tanque vazio apos andar 50 km
        car.drive(10);
        //fail: tanque vazio
        System.out.println(car);
        //pass: 1, gas: 0, km: 60

        car.fuel(200);
        System.out.println(car);
        //pass: 1, gas: 100, km: 60
    }
}