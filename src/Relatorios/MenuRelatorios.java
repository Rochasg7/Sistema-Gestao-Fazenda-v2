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
                    RelatorioServico.relatorioFuncionarios();
                    break;

                case 2:
                    RelatorioServico.relatorioFrota();
                    break;

                case 3:
                    RelatorioServico.relatorioTalhoes();
                    break;

                case 4:
                    RelatorioServico.relatorioColheita();
                    break;

                case 5:
                    RelatorioServico.relatorioGeral();
                    break;
                case 6:
                    RelatorioServico.relatorioQuinzena();
                    break;


                case 7:
                    RelatorioServico.relatorioSecagem();
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