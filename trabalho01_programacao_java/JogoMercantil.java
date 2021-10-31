/*
Motivação
Pedro e João foram no Silvio Santos. O programa era aquele que o Silvio mostrava um produto do mercantil
e a pessoa que chegasse mais próximo do preço real ganhava.

João e Pedro são concorrentes. O objetivo do seu programa é informar quem ganhou a disputa.

O primeiro jogador informa o preço e o segundo jogador informa maior ou menor.
Quem vencer mais disputas ganha o jogo. Se o valor do produto for igual ao chute, ganha o primeiro concorrente.

Se ambos vencerem a mesma quantidade então acontece o empate. 

Se ambos tiverem igualmente próximos do preço então nenhum dos dois ganha a disputa.

Entrada:

linha 1: a quantidade de produtos (1 a 50)
linha 2: o valor dos produtos (0.01 até 1000.0)
linha 3: os chutes do Primeiro (float)
linha 4: as escolhas do segundo (m para menor, M para maior)


Saída:

"primeiro" ou "segundo" ou "empate"
*/

import java.util.Locale;
import java.util.Scanner;

public class JogoMercantil {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        final int quantidadeProdutos = input.nextInt();
        int i;

        float[] valorProdutos = new float[quantidadeProdutos];
        for(i = 0; i < quantidadeProdutos; i++){
            valorProdutos[i] = input.nextFloat();
        }

        float[] chutesPrimeiro = new float[quantidadeProdutos];
        for(i = 0; i < quantidadeProdutos; i++){
            chutesPrimeiro[i] = input.nextFloat();
        }

        char[] escolhasSegundo = new char[quantidadeProdutos];
        for(i = 0; i < quantidadeProdutos; i++){
            escolhasSegundo[i] = input.next().charAt(0);
        }

        //Game!
        int pontosPrimeiro = 0;
        int pontosSegundo = 0;
        for(i = 0; i < quantidadeProdutos; i++){
            if(chutesPrimeiro[i] == valorProdutos[i]){
                pontosPrimeiro++;
                continue;
            }
            else if((escolhasSegundo[i] == 'm') && (chutesPrimeiro[i] > valorProdutos[i])){
                pontosSegundo++;
                continue;
            }
            else if((escolhasSegundo[i] == 'M') && (chutesPrimeiro[i] < valorProdutos[i])){
                pontosSegundo++;
                continue;
            }
        }

        //Resultado!
        if(pontosPrimeiro > pontosSegundo){
            System.out.print("primeiro");
        }
        else if(pontosPrimeiro < pontosSegundo){
            System.out.print("segundo");
        }
        else{
            System.out.print("empate");
        }
        input.close();
    }
}
