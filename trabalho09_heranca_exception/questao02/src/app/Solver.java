package app;

import java.util.Locale;
import java.util.Scanner;

import account.AccountException;
import agency.BankAgency;

/**
 * <p>
 * Controla os métodos da classe BankAgency
 * por meio de comandos entrados no console.
 * </p>
 * 
 * @author Pedro M. Botelho (Aluno)
 * @author Atílio G. Luiz (Orientador)
 * @since 23/12/2021
 * @see agency.BankAgency
 * @see account.AccountException
 */
public class Solver {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        String line, ui[];
        BankAgency agency = new BankAgency();
        while (true) {
            try {
                line = scanner.nextLine();
                System.out.println("$" + line);
                ui = line.split(" ");
                if (line.equals("end")) {
                    if (ui.length != 1) {
                        System.err.println("fail: quantidade inválida de operandos.");
                    }
                    else {
                        break;
                    }
                }
                else if (ui[0].equals("show")) {
                    if (ui.length != 1) {
                        System.err.println("fail: quantidade inválida de operandos.");
                    }
                    else {
                        System.out.println(agency);
                    }
                } 
                else if (ui[0].equals("addCli")) {
                    if (ui.length != 2) {
                        System.err.println("fail: quantidade inválida de operandos.");
                    }
                    else {
                        agency.addClient(ui[1]);
                    }
                }

                // accountId value
                else if (ui[0].equals("saque")) { 
                    if (ui.length != 3) {
                        System.err.println("fail: quantidade inválida de operandos.");
                    }
                    else {
                        agency.withdraw(Integer.parseInt(ui[1]), Float.parseFloat(ui[2]));
                    }
                }

                // accountId value
                else if (ui[0].equals("deposito")) {
                    if (ui.length != 3) {
                        System.err.println("fail: quantidade inválida de operandos.");
                    }
                    else {
                        agency.deposit(Integer.parseInt(ui[1]), Float.parseFloat(ui[2]));
                    }
                }

                // from to value
                else if (ui[0].equals("transf")) {
                    if (ui.length != 4) {
                        System.err.println("fail: quantidade inválida de operandos.");
                    }
                    else {
                        agency.transfer(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]), Float.parseFloat(ui[3]));
                    }
                }
                else if (ui[0].equals("update")) {
                    if (ui.length != 1) {
                        System.err.println("fail: quantidade inválida de operandos.");
                    }
                    else {
                        agency.monthlyUpdate();
                    }
                }
                else {
                    System.out.println("fail: comando invalido");
                }
            }
            catch (AccountException ae) {
                System.out.println(ae.getMessage());
            }
        }
        scanner.close();
    }
}
