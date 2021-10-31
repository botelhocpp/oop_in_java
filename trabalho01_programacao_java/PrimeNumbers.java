/*
Descrição

Faça uma função chamada primo que recebe um inteiro positivo n e retorna true (verdadeiro) se n é primo, ou
false (falso) caso contrário. Um número inteiro é primo quando é divisível apenas por 1 e por ele mesmo.

Uma estratégia simples para testar se um número n é primo consiste em procurar um divisor de n do número 2
até o número n−1. Se algum valor nesta faixa é divisor do n, então n não é primo. Caso contrário, n é primo.

Note que a função pode retornar true assim que encontrar um divisor de n entre 2 e n−1.
Ou seja, não é necessário retornar apenas no final da função.

Na função main, leia dois inteiros positivos A e B, com A≤B, e imprima todos os primos de A até B.
Portanto, use a função primo dentro da função main.

Entrada:

* 1a linha: valor do inteiro positivo A.
* 2a linha: valor do inteiro positivo B (com A≤B).

Saída:

* Todos os primos de A até B (um por linha).
*/
import java.util.Scanner;

public class PrimeNumbers {
    
    public static boolean isPrime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int A = userInput.nextInt();
        int B = userInput.nextInt();
        for(int i = A; i <= B; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
        userInput.close();
    }
}
