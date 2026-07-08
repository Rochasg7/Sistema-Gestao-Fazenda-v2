package Frota;

import java.util.Scanner;

public class CadastroFrota {

    // Scanner usado para leitura dos dados digitados pelo usuário
    static Scanner sc = new Scanner(System.in);

    // Vetor responsável por armazenar todos os tratores cadastrados
    public static Frota[] tratores = new Frota[100];

    // Controla quantos tratores já foram cadastrados
    public static int totalTratores = 0;

    // CADASTRAR TRATOR
    public static void cadastrarTrator() {

        // Verifica se o limite máximo do vetor foi atingido
        if (totalTratores >= 100) {

            System.out.println("Limite máximo de tratores atingido!");
            return;
        }

        // Cria um novo objeto do tipo Frota
        Frota novoTrator = new Frota();

        System.out.println("\n===== CADASTRO DE TRATORES =====");

        // Recebe a placa do trator
        System.out.print("Placa: ");

        novoTrator.placa = sc.nextLine();

        // Verifica se a placa já existe no sistema
        if (placaExiste(novoTrator.placa)) {

            System.out.println("Placa já cadastrada!");
            return;
        }

        // Recebe a capacidade máxima do trator
        System.out.print("Capacidade: ");

        novoTrator.capacidade = Double.parseDouble(sc.nextLine());

        // Armazena o trator no vetor
        tratores[totalTratores] = novoTrator;

        // Incrementa o contador de tratores cadastrados
        totalTratores++;

        // Salva os dados no CSV
        PersistenciaFrota.salvarFrotaCSV();

        System.out.println("Trator cadastrado com sucesso!");
    }

    // LISTAR TRATORES
    public static void listarTratores() {

        System.out.println("\n===== LISTA DE TRATORES =====");

        // Verifica se existem tratores cadastrados
        if (totalTratores == 0) {

            System.out.println("Nenhum trator cadastrado.");
            return;
        }

        // Percorre o vetor mostrando os tratores
        for (int i = 0; i < totalTratores; i++) {

            System.out.println("----------------------");
            System.out.println("Placa: " + tratores[i].placa);
            System.out.println("Capacidade: " + tratores[i].capacidade);
        }
    }

    // BUSCAR TRATOR
    public static void buscarTrator() {

        // Verifica se existem tratores cadastrados
        if (totalTratores == 0) {

            System.out.println("Nenhum trator cadastrado.");
            return;
        }

        // Mostra uma lista rápida dos tratores disponíveis
        // para ajudar o usuário a visualizar as placas
        System.out.println("\n===== TRATORES DISPONÍVEIS =====");

        for (int i = 0; i < totalTratores; i++) {

            Frota trator = tratores[i];

            System.out.println(
                    "Placa: " + trator.placa +
                            " | Capacidade: " + trator.capacidade);
        }

        System.out.println("\n===== BUSCA DE TRATOR =====");
        System.out.print("Informe a placa: ");

        String placaDigitada = sc.nextLine();

        // Percorre todos os tratores cadastrados
        for (int i = 0; i < totalTratores; i++) {

            // Verifica se a placa existe
            if (tratores[i].placa.equalsIgnoreCase(placaDigitada)) {

                System.out.println("\n===== TRATOR ENCONTRADO =====");
                System.out.println("Placa: " + tratores[i].placa);
                System.out.println("Capacidade: " + tratores[i].capacidade);
                return;
            }
        }

        System.out.println("Trator não encontrado.");
    }

    // VERIFICAR SE A PLACA JÁ EXISTE
    public static boolean placaExiste(String placaDigitada) {

        // Percorre todos os tratores cadastrados
        for (int i = 0; i < totalTratores; i++) {

            // equalsIgnoreCase ignora letras maiúsculas/minúsculas
            if (tratores[i].placa.equalsIgnoreCase(placaDigitada)) {
                return true;
            }
        }

        return false;
    }

    // VALIDAR CAPACIDADE DO TRATOR
    public static boolean validarCapacidade(String placaDigitada, double litros) {

        // Procura o trator pela placa
        for (int i = 0; i < totalTratores; i++) {

            if (tratores[i].placa.equalsIgnoreCase(placaDigitada)) {

                // Verifica se os litros estão dentro da capacidade
                return litros <= tratores[i].capacidade;
            }
        }

        // Caso a placa não seja encontrada
        return false;
    }
}