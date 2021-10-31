/*
Motivação
Você ganhou uma bolsa de auxílio pra organizar a fila do RU.
Então teve uma brilhante ideia para organizar as filas.
Ao invés de uma única fila você vai fazer uma para os professores e STAs e uma para alunos.

Ação
Imprima todos os números ímpares na ordem em que foram inseridos na primeira linha, e imprima todos os pares na segunda linha de forma análoga.

Entrada e Saída
Entrada:

Quantidade N de pessoas na fila.
N valores inteiros onde um número ímpar representa um aluno e um par representa um servidor.
Saída:

Os números ímpares na ordem que aparecem na entrada.
Os números pares na ordem que aparecem na entrada.
*/

import java.util.Scanner;

class FilaRU {
    public static void main(String[] args){
        Scanner getInput = new Scanner(System.in);
        int N = getInput.nextInt();
        int[] pessoas = new int[N];
        int i;
        for(i = 0; i < N; i++){
            pessoas[i] = getInput.nextInt();
        }
        getInput.close();
        System.out.printf("[ ");
        for(i = 0; i < N; i++){
            if(pessoas[i] % 2 == 1) System.out.printf("%d ", pessoas[i]);
        }
        System.out.printf("]\n[ ");
        for(i = 0; i < N; i++){
            if(pessoas[i] % 2 == 0) System.out.printf("%d ", pessoas[i]);
        }
        System.out.printf("]\n");
    }
}