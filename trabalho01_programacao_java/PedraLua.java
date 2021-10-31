/*
Descrição
Vários competidores disputaram uma competição interessante. Eles tinham duas pedras para lançar. Chamemos de pedra A e pedra B. Eles tinham que arremessar ambas as pedras
a pelo menos 10 metros de distância. Ganhava a competição, o competidor que arremessou as duas além da linha de 10 m o mais próximo possível uma da outra. Se alguma das
pedras tiver distância menor que 10 metros, o competidor estará desclassificado.

Ação
Faça um programa que retorne o número do vencedor do jogo. O primeiro jogador recebe o número 0.

Ganha a competição, o competidor que arremessar as duas além da linha de 10 m o mais próximo possível uma da outra; e que tiver o arremesso (A ou B) mais próximo de 10m.
Arremessos com distância menor que 10 metros do jogador são ignorados e o jogador já está desclassificado.

Entrada:
O número N de competidores.
Distância das pedras A e B de cada competidor.

Saida:
O número do competidor vitorioso. O primeiro competidor tem número 0. Caso haja empate, mostre o de menor número. Se ninguém ganhar o jogo, porque não conseguiram lançar
as bolas além dos 10 metros, imprima "sem ganhador".
*/

import java.util.Scanner;

public class PedraLua {

    public static int jogadorVitorioso(int[][] distanciaPedras, int N){
        int numeroJogador = -1;
        int menorDistanciaGeral = Integer.MAX_VALUE;
        int menorDistanciaAtual;
        for(int i = 0; i < N; i++){
            if((distanciaPedras[i][0] >= 10) && (distanciaPedras[i][1] >= 10)){
                menorDistanciaAtual = Math.abs(distanciaPedras[i][0] - distanciaPedras[i][1]);
                if(menorDistanciaAtual <= menorDistanciaGeral){
                    menorDistanciaGeral = menorDistanciaAtual;
                    numeroJogador = i;
                }
            }
        }
        return numeroJogador;
    }

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int N = userInput.nextInt();
        int[][] distanciaPedras = new int[N][2];
        for(int i = 0; i < N; i++){
            distanciaPedras[i][0] = userInput.nextInt();
            distanciaPedras[i][1] = userInput.nextInt();
        }
        if(jogadorVitorioso(distanciaPedras, N) > -1){
            System.out.println(jogadorVitorioso(distanciaPedras, N));
        }
        else{
            System.out.println("sem ganhador");
        }
        userInput.close();
    }
}
