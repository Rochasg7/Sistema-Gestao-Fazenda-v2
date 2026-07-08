package Relatorios;
import java.util.Scanner;

public class MenuRelatorios {
    private static Scanner sc = new Scanner(System.in);

    public static void abrirMenuRelatorios() {

        int opcao;

        do {

            System.out.println("\n===== RELATÓRIOS =====");

            System.out.println("1 - Relatório de Funcionários");
            System.out.println("2 - Relatório da Frota");
            System.out.println("3 - Relatório de Talhões");
            System.out.println("4 - Relatório de Colheita");
            System.out.println("5 - Relatório Geral da Fazenda");
            System.out.println("6 - Acerto da Quinzena");
            System.out.println("7 - Relatório de Secagem");
            System.out.println("0 - Voltar");

            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    RelatorioService.relatorioFuncionarios();
                    break;

                case 2:
                    RelatorioService.relatorioFrota();
                    break;

                case 3:
                    RelatorioService.relatorioTalhoes();
                    break;

                case 4:
                    RelatorioService.relatorioColheita();
                    break;

                case 5:
                    RelatorioService.relatorioGeral();
                    break;
                case 6:
                    RelatorioService.relatorioQuinzena();
                    break;


                case 7:
                    RelatorioService.relatorioSecagem();
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