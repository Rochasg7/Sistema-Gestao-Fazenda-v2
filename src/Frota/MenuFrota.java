package Frota;

import java.util.Scanner;

public class MenuFrota {

    // Scanner utilizado para leitura das opções do menu
    static Scanner sc = new Scanner(System.in);

    // MENU DA FROTA
    public static void abrirMenuFrota() {

        int opcao;

        do {

            System.out.println("\n===== MENU FROTA =====");

            System.out.println("1 - Cadastrar Trator");
            System.out.println("2 - Listar Tratores");
            System.out.println("3 - Buscar Trator");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();

            // Limpa o buffer do Scanner
            sc.nextLine();

            switch (opcao) {

                case 1:

                    // Abre o cadastro de tratores
                    CadastroFrota.cadastrarTrator();
                    break;

                case 2:

                    // Lista todos os tratores cadastrados
                    CadastroFrota.listarTratores();
                    break;

                case 3:

                    // Busca um trator pela placa
                    CadastroFrota.buscarTrator();
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