import java.util.Scanner;

import Equipe.MenuEquipe;
import Equipe.PersistenciaFuncionario;

import Frota.MenuFrota;
import Frota.PersistenciaFrota;

import Registros.MenuRegistro;
import Registros.PersistenciaRegistros;

import Relatorios.MenuRelatorios;

import Talhoes.MenuTalhao;
import Talhoes.PersistenciaTalhao;

public class SistemaPrincipal {

    // Scanner utilizado para leitura das opções do sistema
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // CARREGAMENTO DOS DADOS

        // Carrega os registros de colheita salvos no CSV
        PersistenciaRegistros.carregarRegistrosCSV();

        // Carrega os talhões salvos no CSV
        PersistenciaTalhao.carregarTalhoes();

        // Carrega os funcionários salvos no CSV
        PersistenciaFuncionario.carregarFuncionariosCSV();

        // Carrega a frota salva no CSV
        PersistenciaFrota.carregarFrotaCSV();

        int opcao;

        do {

            System.out.println("\n===== SISTEMA FAZENDA =====");

            System.out.println("1 - Talhões");
            System.out.println("2 - Funcionários");
            System.out.println("3 - Frota");
            System.out.println("4 - Colheita");
            System.out.println("5 - Mercado do Café");
            System.out.println("6 - Relatórios");
            System.out.println("0 - Sair");

            System.out.print("Opção: ");

            opcao = sc.nextInt();

            // Limpa o buffer do Scanner
            sc.nextLine();

            switch (opcao) {

                case 1:

                    // Abre o menu de talhões
                    MenuTalhao.abrirMenuTalhao();
                    break;

                case 2:

                    // Abre o menu de funcionários
                    MenuEquipe.abrirMenuEquipe();
                    break;

                case 3:

                    // Abre o menu da frota
                    MenuFrota.abrirMenuFrota();
                    break;

                case 4:

                    // Abre o menu de registros de colheita
                    MenuRegistro.abrirMenuRegistro();
                    break;

                case 5:

                    // Abre o menu do mercado do café
                    MercadoCafe.abrirMenuMercado();
                    break;
                case 6:
                    
                    MenuRelatorios.abrirMenuRelatorios();
                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}