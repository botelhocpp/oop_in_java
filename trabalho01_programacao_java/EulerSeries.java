/**
 * Descrição

O número de Euler (2,71828182846...) pode ser aproximado pela série abaixo:

E=1 + 11! + 12! + 13! + ⋯ + 1N!

Faça uma função que retorna o fatorial de um número inteiro positivo n passado como parâmetro,
ou seja, retorna 1 * 2 * 3 * ... * (n-1) * n.
Chame esta função de `fatorial`.
O valor retornado, e a variável que armazena o fatorial, devem ser do tipo double, pois esta função
cresce muito rápido. Uma variável do tipo int só é capaz de armazenar até 12!.

Em seguida, crie uma função chamada `euler` que recebe um inteiro N e retorna o valor da série

E=1 + 11! + 12! + 13! + ⋯ + 1N!

A função euler deve chamar a função fatorial.

A função main lê o inteiro N e imprime o valor de euler(N).

Entrada:

* 1a linha: valor do inteiro positivo N

Saída:

* Aproximação do número de Euler somando até 1/N!

 */

import java.util.Locale;
import java.util.Scanner;

public class EulerSeries {

    public static int iterativeFatorial(int n){
        int fatorialValue = n;
        if(n < 2)
            return 1;
        for(int i = 2; i < n; i++)
            fatorialValue *= i;
        return fatorialValue;
    }

    public static int recursiveFatorial(int n){
        if(n < 2)
            return 1;
        return n*recursiveFatorial(n - 1);
    }

    public static float euler(int N){
        float eulerNumber = 1;
        for(int j = N; j > 0; j--)
            eulerNumber += 1.0f/iterativeFatorial(j);
        return eulerNumber;
    }

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner userInput = new Scanner(System.in);
        System.out.printf("%.6f", euler(userInput.nextInt()));
        userInput.close();
    }
}
