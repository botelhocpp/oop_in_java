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

public class ContaEspecies {

    public static boolean searchArray(int keyWord, int[] array, int n){
        for(int a = 0; a < n; a++){
            if(array[a] == keyWord)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        final int n = input.nextInt();
        int[] animais = new int[n];
        int[] especies = new int[n];
        int i;
        for(i = 0; i < n; i++){
            animais[i] = input.nextInt();
        }
        int numeroEspecies = 0;
        for(i = 0; i < n; i++){
            if(!searchArray(animais[i], especies, n))
                especies[numeroEspecies++] = animais[i];
        }
        System.out.println(numeroEspecies);
        input.close();
    }
}
