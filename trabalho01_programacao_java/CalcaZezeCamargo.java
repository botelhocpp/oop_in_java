/*
Motivação
Tem mulheres que gostam de roupa apertada. E homens sertanejos também. Mariana olhou em seu armário
e se vestiu para lacrar na festa do Luan Santana. Então pegou 5 de suas melhores calças jeans e decidiu
escolher a mais justa.

Ação 
Faça um programa que receba cinco valores inteiros e encontre o menor deles

Entrada:
5 valores inteiros (entre 1 e 30), um por linha.

Saída:
O menor valor inteiro.
*/

import java.util.Scanner;

public class CalcaZezeCamargo {
    
    public static int menorInteiro(int[] valores, int tamanho){
        int i, menor = valores[0];
        for(i = 1; i < tamanho; i++)
            menor = (menor > valores[i]) ? valores[i] : menor;      
        return menor;
    }
    
    public static void main(String[] args){
        Scanner recebeInteiro = new Scanner(System.in);
        int[] valores = new int[5];
        for(int i = 0; i < 5; i++){
            valores[i] = recebeInteiro.nextInt();
        }
        recebeInteiro.close();
        System.out.println(menorInteiro(valores, 5));
    }
}
