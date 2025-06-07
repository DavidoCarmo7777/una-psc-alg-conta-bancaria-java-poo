import java.util.Scanner;

public class ContaBancaria {
    private String nome;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String nome, String numeroConta, double saldoInicial) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Saque inválido ou saldo insuficiente.");
        }
    }

    public double obterSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
        return saldo;
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome da Pessoa: ");
        String nome = sc.nextLine();

        System.out.print("Número da Conta: ");
        String numeroConta = sc.nextLine();

        System.out.print("Saldo Inicial: ");
        double saldoInicial = sc.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);

        System.out.println("Conta bancária criada com sucesso.");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha a operação:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Obter saldo");
            System.out.println("4 - Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor para depósito: ");
                    double valorDeposito = sc.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Informe o valor para saque: ");
                    double valorSaque = sc.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.obterSaldo();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
        System.out.println("Programa encerrado.");
    }
}
