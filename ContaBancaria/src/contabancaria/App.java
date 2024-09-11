package contabancaria;

import java.util.Scanner;
import newpackage.Conta;
import newpackage1.ContaEspecial;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int codigo;
        Conta conta = null;
        ContaEspecial contaEspecial = null;

        do {
            System.out.println("------------------------");
            System.out.println("      TELA INICIAL      ");
            System.out.println("------------------------");
            System.out.println("1 - Criar conta corrente");
            System.out.println("2 - Criar conta especial");
            System.out.println("3 - Encerrar programa");
            System.out.println("");
            System.out.println("Digite a opção desejada: ");
            codigo = sc.nextInt();
            System.out.println("");

            switch (codigo) {

                case 1:
                    
                    conta = new Conta();
                    conta = conta.criarConta();

                    conta.menu();
                    
                    break;

                case 2:
                    
                    contaEspecial = new ContaEspecial();
                    contaEspecial = contaEspecial.criarConta();
                    
                    contaEspecial.menu();

                    break;
                    
                case 3:


                    break;

                default:

                    System.out.println("Opção inválida!");

                    break;
            }

        } while (codigo != 3);
    }

}
