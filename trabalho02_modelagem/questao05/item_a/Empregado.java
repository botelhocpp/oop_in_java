package questao05.item_a;

public class Empregado {
    private String nome;
    private String departamento;
    private int horasTrabalhadas;
    private float salarioPorHora;

    /**
     * Valores escolhidos para os máximos e mínimos foram por senso comum.
     */
    public void cadastrar(String nomeFunc, String dep, int horasTrab, float salPorHora){
        nome = nomeFunc;
        departamento = dep;
        horasTrabalhadas = (horasTrab >= 0 && horasTrab <= 372) ? horasTrab : 0;
        salarioPorHora = (salPorHora >= 0.01f && salPorHora <= 61.14) ? salPorHora : 0;
    }

    public float calculaSalarioMensal(){
        return horasTrabalhadas*salarioPorHora;
    }

    public void mostraDados(){
        System.out.printf("Nome: %s%nDepartamento: %s%nHoras Trabalhadas: %d horas%nSalario por Hora: R$ %02.2f%n", nome, departamento, horasTrabalhadas, salarioPorHora);
    }
}
