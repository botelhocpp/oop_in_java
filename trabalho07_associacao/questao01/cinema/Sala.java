package cinema;

import java.util.ArrayList;

/**
 * Modela uma sala de cinema que pode guardar reservas
 * de clientes. Essa classe guarda objetos da classe
 * Clientes, instânciados dentro da própria classe Sala,
 * caracterizando uma relação de composição.
 * 
 * Para impedir que haja chamada de método a partir de
 * uma instância nula primeiro verificamos se a reserva
 * não é nula e só depois verificamos o ID, já que o
 * operador lógico AND ignora o segundo membro
 * caso o primeiro seja inválido. Logo, dessa forma 
 * evitamos a exceção. Exemplo:
 * 
 * if(this.cadeiras.get(i) != null && this.cadeiras.get(i).getId().equals(id))
 * 
 * Só devemos chamar o método getId se tivernos certeza
 * que o assento correspondente não é nulo. Fazemos isso
 * pelo primeiro termo, que, caso seja verdadeiro, não 
 * realiza o segundo termo.
 * 
 * @author Pedro M. Botelho & Atílio G. Luiz
 * @since 02/12/2021
 * @see cinema.Cliente
 */
public class Sala {
    /**
     * Guarda os clientes que realizaram as reservas.
     */
    private ArrayList<Cliente> cadeiras;

    /**
     * Capacidade total da sala.
     */
    private final int capacidade;

    /**
     * Quantidade de reservas efetuadas. Deve ser menor
     * que a capacidade.
     */
    private int reservas;

    /**
     * Inicializa a sala do cinema com uma capacidade inicial.
     * A sala inicia com zero clientes em seu interior. O array
     * de clientes é preenchido com nulos, e duas variáveis externas
     * são usadas para controlar as quantidades de clientes na
     * lista.
     * 
     * @param capacidade Capacidade de clientes que a sala
     * pode comportar.
     * @throws IllegalArgumentException Caso o parâmetro seja
     * menor que zero.
     */
    public Sala(int capacidade){
        if(capacidade < 0){
            throw new IllegalArgumentException("fail: valor inválido para capacidade.");
        }
        else{
            this.capacidade = capacidade;
            this.cadeiras = new ArrayList<Cliente>(this.capacidade);
            for(int i = 0; i < this.capacidade; i++){
                this.cadeiras.add(null);
            }
        }
    }

    /**
     * Reserva uma cadeira no cinenam para um cliente, passando
     * sua identificaçãio, telefone e o número da cadeira.
     * 
     * Se o cliente já não estiver no cinema, se a sala não
     * estiver lotada e se a cadeira já não estiver ocupada
     * o cliente será alocado para ela. O contador de reservas
     * será incrementado.
     * 
     * @param id Identificação do cliente.
     * @param fone Telefone do cliente.
     * @param ind Número da cadeira.
     * @return "true" se foi possível realizar a reserva, e
     * "false" caso contrário.
     */
    public boolean reservar(String id, String fone, int ind){      
        if(this.clienteReservado(id)){
            System.err.println("fail: cliente já está no cinema.");
            return false;
        }
        else if(this.reservas == this.capacidade){
            System.err.println("fail: sala lotada.");
            return false;
        }
        else if(cadeiras.get(ind) != null){
            System.err.println("fail: cadeira já está ocupada.");
            return false;
        }
        else{
            cadeiras.set(ind, new Cliente(id, fone));
            reservas++;
            return true;
        }
    }
    
    /**
     * Cancela a reserva de um cliente com uma identificação
     * "id", caso ele tenha uma reserva na sala.
     * 
     * @param id Identificação do cliente.
     */
    public void cancelar(String id){
        for(int i = 0; i < this.capacidade; i++){
            if(this.cadeiras.get(i) != null && this.cadeiras.get(i).getId().equals(id)){
                this.cadeiras.set(i, null);
                this.reservas--;
                return;
            }
        }
        System.err.println("fail: cliente não está no cinema.");
    }

    /**
     * Verifica se um cliente tem reserva na sala.
     * 
     * @param id Identificação do cliente.
     * @return "true" se foi possível localizar a reserva, e
     * "false" caso contrário.
     */
    public boolean clienteReservado(String id){
        for(Cliente reserva : this.cadeiras){
            if(reserva != null && reserva.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna o array de clientes com reserva na sala.
     */
    public ArrayList<Cliente> getCadeiras(){
        return this.cadeiras;
    }

    /**
     * Retorna a capacidade da sala.
     */
    public int getCapacidade(){
        return this.capacidade;
    }

    /**
     * Retorna as reservas da sala.
     */
    public int getReservas(){
        return this.reservas;
    }
    
    /**
     * Devolve as principais informações da sala,
     */
    public String toString(){
        String cadeirasCinema = "[ ";
        for(Cliente reserva : this.cadeiras){
            if(reserva == null){
                cadeirasCinema = cadeirasCinema.concat("- ");
            }
            else{
                cadeirasCinema = cadeirasCinema.concat(reserva + " ");
            }
        }
        return cadeirasCinema.concat("]");
    }
}