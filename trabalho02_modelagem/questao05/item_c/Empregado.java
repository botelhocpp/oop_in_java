package questao05.item_c;

public class Empregado {
    private String nome;
    private String departamento;
    private int horasNormaisTrabalhadas;
    private int horasExtrasTrabalhadas;
    private float salarioPorHoraNormal;
    private float salarioPorHoraExtra;

    public void cadastrar(String nomeFunc, String dep, int horasTrab, float salPorHora){
        nome = nomeFunc;
        departamento = dep;
        horasNormaisTrabalhadas = (horasTrab >= 0 && horasTrab <= 372) ? horasTrab : 0;
        salarioPorHoraNormal = (salPorHora >= 0.01f && salPorHora <= 61.14) ? salPorHora : 0;
    }

    public void cadastrarHoraExtra(int horasExtras, float salarioHoraExtra){
        horasExtrasTrabalhadas = (horasExtras >= 0 && horasExtras <= 120) ? horasExtras : 0;
        salarioPorHoraExtra = (salarioHoraExtra >= 0 && salarioHoraExtra <= 57.54) ? salarioHoraExtra : 0;
    }

    /**
     * Ao multiplicar por 1.1, estará fazendo 110%!
     * @return
     */
    public float calculaSalarioMensal(){
        if(departamento == "Diretoria"){
            return (horasNormaisTrabalhadas*salarioPorHoraNormal + horasExtrasTrabalhadas*salarioPorHoraExtra)*1.1f;
        }
        return horasNormaisTrabalhadas*salarioPorHoraNormal + horasExtrasTrabalhadas*salarioPorHoraExtra;
    }

    public void mostraDados(){
        System.out.printf("Nome: %s%nDepartamento: %s%nHoras Normais Trabalhadas: %d horas%nSalario por Hora Normal: R$ %02.2f%nHoras Extras Trabalhadas: %d horas%nSalario por Hora Extra: R$ %02.2f%n", nome, departamento, horasNormaisTrabalhadas, salarioPorHoraNormal, horasExtrasTrabalhadas, salarioPorHoraExtra);
    }
}
