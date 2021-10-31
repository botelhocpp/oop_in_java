package questao05.item_a;

public class Main {
    public static void main(String[] args){
        Empregado t = new Empregado();
        t.cadastrar("Botelho", "Caça", 280, 0.85f);
        t.mostraDados();
        System.out.println(t.calculaSalarioMensal());
    }
}
