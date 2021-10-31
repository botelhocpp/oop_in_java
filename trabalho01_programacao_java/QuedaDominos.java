/*
Motivação
Deoclécio tem o passatempo de montar filas de dominós para derrubá-las depois.

Para fazer um efeito mais interessante, ele usa peças de dominó com tamanhos variados, sempre colocando
as menores peças no começo da fila.
Para ajudar nessa importante tarefa, Deo pediu sua ajuda para verificar se uma fila de dominós está
dentro do padrão, ou seja, se os tamanhos dos dominós estão ordenados de forma crescente.

Ação
Leia um vetor(array) de tamanho n (quantidade de dominós) , e diga se ele está ordenado de forma crescente.

Entrada e Saída
Entrada:

O número n ( 0 < n <= 50) de dominós.
A altura (inteira) de cada dominó.
Saída

"ok" caso  caso vetor esteja ordenado.
"precisa de ajuste" caso vetor esteja desordenado.
*/

import java.util.Scanner;

class QuedaDominos {

    public static boolean iterativeDominoSort(int[] dominos, int n) {
        for (int i = 1; i < n; i++) {
            if (dominos[i] < dominos[i - 1]) return false;
        }
        return true;
    }

    public static boolean recursiveDominoSort(int[] dominos, int n) {
        if(n == 1){
            return true;
        }
        if(dominos[n - 1] < dominos[n - 2]){
            return false;
        }
        return recursiveDominoSort(dominos, n - 1);
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        final int n = userInput.nextInt();
        int[] dominos = new int[n];
        for(int j = 0; j < n; j++){
            dominos[j] = userInput.nextInt();
        }
        userInput.close();
        if(recursiveDominoSort(dominos, n))
            System.out.println("ok");
        else    
            System.out.println("precisa de ajuste");
    }
}