package questao05.item_b;

public class Main {
    public static void main(String[] args){
        Empregado t = new Empregado();
        t.cadastrar("Botelho", "Caça", 176, 15.85f);
        t.cadastrarHoraExtra(90, 19.14f);
        t.mostraDados();
        System.out.println(t.calculaSalarioMensal());
    }
}
