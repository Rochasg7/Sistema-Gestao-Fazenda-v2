package Equipe;

import java.util.Scanner;

public class MenuEquipe {

    // Scanner utilizado para leitura das opções do menu
    static Scanner sc = new Scanner(System.in);

    // MENU DE FUNCIONÁRIOS
    public static void abrirMenuEquipe() {

        int opcao;

        do {

            System.out.println("\n===== MENU FUNCIONÁRIOS =====");

            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Buscar Funcionário");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();

            // Limpa o buffer do Scanner
            sc.nextLine();

            switch (opcao) {

                case 1:
                    // Abre o cadastro de funcionários
                    CadastroFuncionario.cadastrarFuncionario();
                    break;

                case 2:
                    // Lista todos os funcionários cadastrados
                    CadastroFuncionario.listarFuncionarios();
                    break;

                case 3:
                    // Busca um funcionário pela matrícula
                    CadastroFuncionario.buscarFuncionario();
                    break;

                case 0:

                    System.out.println("Voltando...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}