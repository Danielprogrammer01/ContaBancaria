package newpackage;

import java.util.Scanner;

public class Conta {

    Scanner sc = new Scanner(System.in);

    private int numero;
    private String titular;
    private double saldo;

    public Conta(int numero, String titular, double depInicial) {

        this.numero = numero;
        this.titular = titular;
        this.saldo = depInicial;
    }

    public Conta(int numero, String titular) {

        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;

    }

    public Conta() {
        this.numero = 0;
        this.titular = "Sem titular";
        this.saldo = 0.0;
    }

    public void saque(double quantia) {

        saldo -= quantia + 5.0;
        System.out.println("Saque realizado com sucesso!");
        System.out.println(this);

    }

    public void deposito(double quantia) {

        saldo += quantia;
        System.out.println("depósito realizado com sucesso!");
        System.out.println(this);

    }

    @Override
    public String toString() {
        return "NÚMERO DA CONTA: " + numero + "\n"
                + "TITULAR: " + titular + "\n"
                + "SALDO: R$" + saldo + "\n";
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public Conta criarConta() {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número da conta: ");
        int numero = sc.nextInt();

        System.out.println("Digite o nome do titular: ");
        String titular = sc.next();

        System.out.println("Deseja realizar um depósito inicial: (y/n)");
        char resposta = sc.next().charAt(0);

        if (resposta == 'y') {

            System.out.println("Digite o valor a depositar: R$");
            double depInicial = sc.nextDouble();

            this.numero = numero;
            this.titular = titular;
            this.saldo = depInicial;

        } else if (resposta == 'n') {

            this.numero = numero;
            this.titular = titular;
            this.saldo = 0.0;

        } else {
            System.out.println("Opção inválida! ");
            return null;
        }

        System.out.println("Conta criada com sucesso!");
        System.out.println(this);
        sc.close();
        return this;
    }

    public void menu() {

        double quantia;
        int codigo;

        do {

            System.out.println("------------------------");
            System.out.println("          MENU          ");
            System.out.println("------------------------");
            System.out.println("1 - Realizar saque");
            System.out.println("2 - Realizar depósito");
            System.out.println("3 - Exibir dados da conta");
            System.out.println("4 - Sair da conta");
            System.out.println("");
            System.out.println("Digite a opção desejada: ");
            codigo = sc.nextInt();
            System.out.println("");

            switch (codigo) {

                case 1:

                    System.out.println("Digite o valor do saque: R$");
                    quantia = sc.nextDouble();

                    saque(quantia);

                    break;

                case 2:

                    System.out.println("Digite o valor do depósito: R$");
                    quantia = sc.nextDouble();

                    deposito(quantia);

                    break;

                case 3:

                    System.out.println(this);

                    break;

                case 4:

                    break;

                default:

                    System.out.println("Opção inválida!");

                    break;
            }

        } while (codigo != 4);
        
        sc.close();

    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

}
