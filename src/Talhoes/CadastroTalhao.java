package Talhoes;

import java.util.Scanner;

public class CadastroTalhao {

    // Scanner utilizado para leitura dos dados digitados
    static Scanner sc = new Scanner(System.in);

    // Vetor responsável por armazenar os talhões cadastrados
   public static Talhao[] talhoes = new Talhao[100];

    // Contador de talhões cadastrados
    public static int totalTalhoes = 0;

    // CADASTRAR TALHÃO
    public static void cadastrarTalhao() {

        if (totalTalhoes >= 100) {

            System.out.println("Limite máximo de talhões atingido.");
            return;
        }

        Talhao talhao = new Talhao();

        System.out.println("\n===== CADASTRO DE TALHÃO =====");

        System.out.print("Código: ");

        talhao.codigo = sc.nextLine();

        // Verifica se já existe um talhão com esse código
        if (codigoExiste(talhao.codigo)) {

            System.out.println("Código já cadastrado.");

            return;
        }

        System.out.print("Nome: ");
        talhao.nome = sc.nextLine();

        System.out.print("Variedade do café: ");
        talhao.variedadeCafe = sc.nextLine();

        System.out.print("Estimativa de litros: ");
        talhao.estimativaLitros = Double.parseDouble(sc.nextLine());

        System.out.print("Produção atual: ");
        talhao.producaoAtual = Double.parseDouble(sc.nextLine());

        // Guarda o talhão dentro do vetor
        talhoes[totalTalhoes] = talhao;

        // Aumenta o contador de talhões cadastrados
        totalTalhoes++;

        // Salva os dados no arquivo CSV
        PersistenciaTalhao.salvarTalhoesCSV();

        System.out.println("Talhão cadastrado com sucesso.");
    }

    // LISTAR TALHÕES
    public static void listarTalhoes() {

        // Verifica se existe pelo menos um talhão cadastrado
        if (totalTalhoes == 0) {

            System.out.println("Nenhum talhão cadastrado.");

            return;
        }

        System.out.println("\n===== LISTA DE TALHÕES =====");

        // Percorre todos os talhões cadastrados
        for (int i = 0; i < totalTalhoes; i++) {

            Talhao talhao = talhoes[i];

            System.out.println("----------------------");
            System.out.println("Código: " + talhao.codigo);
            System.out.println("Nome: " + talhao.nome);
            System.out.println("Variedade: " + talhao.variedadeCafe);
            System.out.println("Estimativa: " + talhao.estimativaLitros);
            System.out.println("Produção Atual: " + talhao.producaoAtual);
        }
    }

    // BUSCAR TALHÃO
    public static void buscarTalhao() {

        // Verifica se existem talhões cadastrados
        if (totalTalhoes == 0) {

            System.out.println("Nenhum talhão cadastrado.");
            return;
        }

        // Mini lista
        System.out.println("\n===== BUSCA DE TALHÃO =====");

        for (int i = 0; i < totalTalhoes; i++) {

            Talhao talhao = talhoes[i];

            System.out.println(
                "Código: " + talhao.codigo +
                    " | Nome: " + talhao.nome);
        }

        // Solicita o código
        System.out.print("\nInforme o código do talhão: ");

        String codigo = sc.nextLine();

        // Busca o talhão
        for (int i = 0; i < totalTalhoes; i++) {

            Talhao talhao = talhoes[i];

            if (talhao.codigo.equalsIgnoreCase(codigo)) {

                System.out.println("\n===== TALHÃO ENCONTRADO =====");
                System.out.println("Código: " + talhao.codigo);
                System.out.println("Nome: " + talhao.nome);
                System.out.println("Variedade: " + talhao.variedadeCafe);
                System.out.println("Estimativa: " + talhao.estimativaLitros);
                System.out.println("Produção Atual: " + talhao.producaoAtual);

                return;
            }
        }

        System.out.println("Talhão não encontrado.");
    }

    // VALIDAR CÓDIGO
    public static boolean codigoExiste(String codigo) {

        // Percorre todos os talhões cadastrados
        for (int i = 0; i < totalTalhoes; i++) {

            // Verifica se já existe um talhão com o código informado
            if (talhoes[i].codigo.equalsIgnoreCase(codigo)) {

                return true;
            }
        }

        return false;
    }
}