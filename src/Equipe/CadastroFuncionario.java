package Equipe;

import java.util.Scanner;

public class CadastroFuncionario {

    // Scanner utilizado para leitura dos dados
    static Scanner sc = new Scanner(System.in);

    // Vetor responsável por armazenar os funcionários
    public static Funcionario[] funcionarios = new Funcionario[100];

    // Contador de funcionários cadastrados
    public static int totalFuncionarios = 0;

    // CADASTRAR FUNCIONÁRIO
    public static void cadastrarFuncionario() {

        // Verifica se o limite do vetor foi atingido
        if (totalFuncionarios >= 100) {

            System.out.println("Limite máximo de funcionários atingido.");
            return;
        }

        Funcionario funcionario = new Funcionario();

        System.out.println("\n===== CADASTRO DE FUNCIONÁRIO =====");

        System.out.print("Nome: ");
        funcionario.nome = sc.nextLine();

        System.out.print("Matrícula: ");
        funcionario.matricula = sc.nextLine();

        // Verifica se a matrícula já foi cadastrada
        if (matriculaExiste(funcionario.matricula)) {

            System.out.println("Matrícula já cadastrada.");
            return;
        }

        System.out.print("Tipo de contrato: ");
        funcionario.tipoContrato = sc.nextLine();

        // Armazena o funcionário no vetor
        funcionarios[totalFuncionarios] = funcionario;

        // Incrementa o contador de funcionários
        totalFuncionarios++;

        // Salva os funcionários no CSV
        PersistenciaFuncionario.salvarFuncionariosCSV();

        System.out.println("Funcionário cadastrado com sucesso.");
    }

    // LISTAR FUNCIONÁRIOS
    public static void listarFuncionarios() {

        // Verifica se existe pelo menos um funcionário cadastrado
        if (totalFuncionarios == 0) {

            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\n===== LISTA DE FUNCIONÁRIOS =====");

        // Percorre todos os funcionários cadastrados
        for (int i = 0; i < totalFuncionarios; i++) {

            Funcionario funcionario = funcionarios[i];

            System.out.println("----------------------");

            System.out.println("Nome: " + funcionario.nome);
            System.out.println("Matrícula: " + funcionario.matricula);
            System.out.println("Contrato: " + funcionario.tipoContrato);
        }
    }

    // BUSCAR FUNCIONÁRIO
    public static void buscarFuncionario() {

        // Verifica se existem funcionários cadastrados
        if (totalFuncionarios == 0) {

            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        // Mostra uma lista rápida para ajudar o usuário
        // a visualizar as matrículas disponíveis
        System.out.println("\n===== FUNCIONÁRIOS DISPONÍVEIS =====");

        for (int i = 0; i < totalFuncionarios; i++) {

            Funcionario funcionario = funcionarios[i];

            System.out.println(
                    "Matrícula: " + funcionario.matricula +
                            " | Nome: " + funcionario.nome);
        }

        System.out.println("\n===== BUSCA DE FUNCIONÁRIO =====");

        System.out.print("Informe a matrícula: ");
        String matricula = sc.nextLine();

        // Percorre todos os funcionários cadastrados
        for (int i = 0; i < totalFuncionarios; i++) {

            Funcionario funcionario = funcionarios[i];

            // Verifica se a matrícula existe
            if (funcionario.matricula.equalsIgnoreCase(matricula)) {

                System.out.println("\n===== FUNCIONÁRIO ENCONTRADO =====");

                System.out.println("Nome: " + funcionario.nome);
                System.out.println("Matrícula: " + funcionario.matricula);
                System.out.println("Contrato: " + funcionario.tipoContrato);
                return;
            }
        }

        System.out.println("Funcionário não encontrado.");
    }

    // VALIDAR MATRÍCULA
    public static boolean matriculaExiste(String matricula) {

        // Percorre o vetor procurando matrícula repetida
        for (int i = 0; i < totalFuncionarios; i++) {

            if (funcionarios[i].matricula.equalsIgnoreCase(matricula)) {

                return true;
            }
        }

        return false;
    }
}