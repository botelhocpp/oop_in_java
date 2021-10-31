/*
Motivação
A brincadeira preferida de Maurício é pegar os copos da sua mãe e fazer uma torre
no formato de um triangulo isósceles.

Um dia, sua mãe entrou na cozinha e viu aquela torre de base 5 utilizando 15 copos.

Imediatamente uma chinela voou pela casa acertando em cheio a cabeça de Maurício,
é claro, pra aprender a não fazer torres com copos de vidro.

Ação
Faça um programa que dado um numero N inteiro (0<N<50) mostre na tela um triangulo
isósceles formado por apenas N e com altura igual a N.

Entrada:
Inteiro N(0<N<50)

Saída:
Um triângulo isósceles formado por apenas pelo numero N e com altura igual a N.
*/

import java.util.Scanner;

public class TorreCopos {

    public static void main(String[] args){
        Scanner recebeUsuario = new Scanner(System.in);
        final int N = recebeUsuario.nextInt();
        recebeUsuario.close();

        int i, j;
        final char CHAR_N = (char) (N + '0');
        final int TAMANHO_BASE = N + (N - 1);

        char[][] torreCopos = new char[N][TAMANHO_BASE];

        for(i = 0; i < TAMANHO_BASE; ++i){
            torreCopos[N - 1][i] = (i % 2 == 0) ? CHAR_N : '.';
        }

        for(i = N - 2; i >= 0; --i){      
            for(j = 0; j < TAMANHO_BASE; ++j){
                if((j == 0) || (j == TAMANHO_BASE - 1)){
                    torreCopos[i][j] = '.';
                    continue;
                }
                if(torreCopos[i + 1][j - 1] == CHAR_N && torreCopos[i + 1][j + 1] == CHAR_N){
                    torreCopos[i][j] = CHAR_N;
                }
                else{
                    torreCopos[i][j] = '.';
                }
            }
        }

        for(i = 0; i < N; ++i){
            System.out.println(torreCopos[i]);
        }
    }
}