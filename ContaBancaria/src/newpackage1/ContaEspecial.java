package newpackage1;

import java.util.Scanner;
import newpackage.Conta;

public class ContaEspecial extends Conta {

    private double limiteEmprestimo;

    public ContaEspecial() {
        super();
        this.limiteEmprestimo = 0.0;
    }

    public ContaEspecial(int numero, String titular, double limiteEmprestimo) {
        super(numero, titular);
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public ContaEspecial(int numero, String titular, double depInicial, double limiteEmprestimo) {
        super(numero, titular, depInicial);
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public void emprestimo(double quantia) {

        if (quantia <= limiteEmprestimo) {

            limiteEmprestimo -= quantia;
            setSaldo(getSaldo() + quantia);
            System.out.println("Empréstimo realizado com sucesso!");
            System.out.println(this);

        } else {

            System.out.println("Valor do empréstimo excede o limite disponível.");

        }

    }

    @Override
    public void saque(double quantia) {
        if (quantia <= getSaldo() + limiteEmprestimo) {
            double saldoAntesDoSaque = getSaldo();
            if (quantia > getSaldo()) {
                double emprestimoNecessario = quantia - getSaldo();
                if (emprestimoNecessario <= limiteEmprestimo) {
                    limiteEmprestimo -= emprestimoNecessario;
                    setSaldo(0);
                } else {
                    System.out.println("Valor do saque excede o limite de empréstimo.");
                    return;
                }
            } else {
                setSaldo(getSaldo() - quantia + 5.0f);
            }
            System.out.println("Saque realizado com sucesso!");
            System.out.println(this); // Exibe os dados da conta após o saque
        } else {
            System.out.println("Saldo e limite de empréstimo insuficientes para realizar o saque.");
        }
    }

    @Override
    public void deposito(double quantia) {
        setSaldo(getSaldo() + quantia);
        System.out.println("Depósito realizado com sucesso!");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString()
                + "LIMITE EMPRÉSTIMO: R$" + limiteEmprestimo + "\n";
    }

    @Override
    public ContaEspecial criarConta() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número da conta especial: ");
        int numero = sc.nextInt();

        System.out.println("Digite o nome do titular ");
        String titular = sc.next();

        System.out.println("Digite o limite de empréstimo: R$");
        double limiteEmprestimo = sc.nextDouble();

        System.out.println("Deseja realizar um depósito inicial: (y/n)");
        char resposta = sc.next().charAt(0);
        
        ContaEspecial contaEspecial;

        if (resposta == 'y') {

            System.out.println("Digite o valor a depositar: R$");
            double depInicial = sc.nextDouble();

            contaEspecial = new ContaEspecial(numero, titular, depInicial, limiteEmprestimo);

        } else if (resposta == 'n') {

            contaEspecial = new ContaEspecial(numero, titular, limiteEmprestimo);

        } else {
            System.out.println("Opção inválida! ");
            return null;
        }

        System.out.println("Conta especial criada com sucesso!");
        System.out.println(contaEspecial);
        return contaEspecial;
    }

    @Override
    public void menu() {

        Scanner sc = new Scanner(System.in);

        double quantia;
        int codigo;

        do {

            System.out.println("------------------------");
            System.out.println("          MENU          ");
            System.out.println("------------------------");
            System.out.println("1 - Realizar saque");
            System.out.println("2 - Realizar depósito");
            System.out.println("3 - Solicitar empréstimo");
            System.out.println("4 - Exibir dados da conta");
            System.out.println("5 - Sair da conta");
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

                    System.out.println("Digite o valor do empréstimo: R$");
                    quantia = sc.nextDouble();
                    emprestimo(quantia);

                    break;

                case 4:

                    System.out.println(this);
                    break;

                case 5:
                    break;

                default:

                    System.out.println("Opção inválida!");

                    break;
            }

        } while (codigo != 5);

    }

}
