import java.util.Scanner;

public class Fibonacci {
    
    public static int Fibo(int a){
        int atual = 1, anterior = 0, temp;
        for(int i = 0; i < a; i++){
            temp = atual;
            atual = atual + anterior;
            anterior = temp;
        }
        return atual;
    }
    
    public static void main(String[] args){
        Scanner recebe = new Scanner(System.in);
        int n = recebe.nextInt();
        for(int j = 0; j < n; j++){   
            System.out.println("Enésimo valor da sequencia de Fibonacci:" + Fibo(j));
        }
        recebe.close();
    }
}
