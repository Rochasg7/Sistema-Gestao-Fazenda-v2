package Registros;

import java.util.Scanner;

import Equipe.CadastroFuncionario;
import Equipe.Funcionario;
import Frota.CadastroFrota;
import Frota.Frota;
import Talhoes.CadastroTalhao;
import Talhoes.Talhao;

public class RegistrosServico {

    // Scanner utilizado para leitura dos dados
    static Scanner sc = new Scanner(System.in);

    // Vetor responsável por armazenar os registros de colheita
    public static RegistroColheita[] registros = new RegistroColheita[100];

    // Controla quantos registros já foram cadastrados
    public static int totalRegistros = 0;

    // REGISTRAR COLHEITA
    public static void registrarColheita() {

        // Verifica se o limite máximo foi atingido
        if (totalRegistros >= 100) {

            System.out.println("Limite máximo de registros atingido!");
            return;
        }

        RegistroColheita registro = new RegistroColheita();

        System.out.println("\n===== REGISTRO DE COLHEITA =====");

        // Recebe a data da colheita
        System.out.print("Digite a data: ");
        registro.data = sc.nextLine();

        // Recebe a matrícula do funcionário responsável
        while (true) {

            System.out.print(
                    "Digite a matrícula do funcionário "
                            + "(ou LISTAR): ");

            String matricula = sc.nextLine();

            // LISTAR FUNCIONÁRIOS
            if (matricula.equalsIgnoreCase("LISTAR")) {

                System.out.println("\n===== FUNCIONÁRIOS =====");

                for (int i = 0; i < CadastroFuncionario.totalFuncionarios; i++) {

                    Funcionario funcionario = CadastroFuncionario.funcionarios[i];

                    System.out.println(
                            funcionario.matricula
                                    + " - "
                                    + funcionario.nome);
                }

                continue;
            }

            // VALIDAR EXISTÊNCIA
            boolean encontrado = false;

            for (int i = 0; i < CadastroFuncionario.totalFuncionarios; i++) {

                if (CadastroFuncionario.funcionarios[i].matricula
                        .equalsIgnoreCase(matricula)) {

                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {

                registro.matriculaFuncionario = matricula;
                break;

            } else {

                System.out.println(
                        "Funcionário não encontrado.");
            }
        }

        // Recebe o código do talhão
        while (true) {

            System.out.print(
                    "Digite o código do talhão "
                            + "(ou LISTAR): ");

            String codigo = sc.nextLine();

            if (codigo.equalsIgnoreCase("LISTAR")) {

                System.out.println("\n===== TALHÕES =====");

                for (int i = 0; i < CadastroTalhao.totalTalhoes; i++) {

                    Talhao talhao = CadastroTalhao.talhoes[i];

                    System.out.println(
                            talhao.codigo
                                    + " - "
                                    + talhao.nome);
                }

                continue;
            }

            boolean encontrado = false;

            for (int i = 0; i < CadastroTalhao.totalTalhoes; i++) {

                if (CadastroTalhao.talhoes[i].codigo
                        .equalsIgnoreCase(codigo)) {

                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {

                registro.codigoTalhao = codigo;
                break;

            } else {

                System.out.println("Talhão não encontrado.");
            }
        }

        // Recebe e valida a placa do trator/caminhão
        // Também captura a capacidade máxima suportada
        double capacidadeTrator = 0;

        while (true) {

            System.out.print(
                    "Digite a placa do trator "
                            + "(ou LISTAR): ");

            String placa = sc.nextLine();

            // Caso o usuário queira listar os tratores
            if (placa.equalsIgnoreCase("LISTAR")) {

                System.out.println("\n===== TRATORES =====");

                for (int i = 0; i < CadastroFrota.totalTratores; i++) {

                    Frota trator = CadastroFrota.tratores[i];

                    System.out.println(
                            "Placa: "
                                    + trator.placa
                                    + " | Capacidade: "
                                    + trator.capacidade
                                    + " litros");
                }

                continue;
            }

            boolean encontrado = false;

            // Verifica se o trator existe
            for (int i = 0; i < CadastroFrota.totalTratores; i++) {

                if (CadastroFrota.tratores[i].placa
                        .equalsIgnoreCase(placa)) {

                    encontrado = true;

                    // Salva a placa no registro
                    registro.placaTrator = placa;

                    // Captura a capacidade do trator
                    capacidadeTrator = CadastroFrota.tratores[i].capacidade;

                    break;
                }
            }

            if (encontrado) {

                break;

            } else {

                System.out.println(
                        "Trator não encontrado.");
            }
        }

        // Recebe e valida a quantidade de litros
        // Não permite ultrapassar a capacidade do trator
        while (true) {

            System.out.print(
                    "Digite a quantidade de litros: ");

            double litros = Double.parseDouble(sc.nextLine());

            // Verifica se excede a capacidade
            if (litros > capacidadeTrator) {

                System.out.println(
                        "Quantidade excede a capacidade "
                                + "do trator.");

                System.out.println(
                        "Capacidade máxima: "
                                + capacidadeTrator
                                + " litros");

            } else {

                registro.litros = litros;
                break;
            }
        }

        // Recebe o destino da carga
        System.out.print("Digite o destino: ");
        registro.destino = sc.nextLine();

        // Armazena o registro no vetor
        registros[totalRegistros] = registro;

        // Incrementa o contador de registros
        totalRegistros++;

        // Salva os registros no arquivo CSV
        PersistenciaRegistros.salvarRegistrosCSV();

        System.out.println("Registro realizado com sucesso!");
    }

    // LISTAR REGISTROS
    public static void listarRegistros() {

        // Verifica se existe pelo menos um registro cadastrado
        if (totalRegistros == 0) {

            System.out.println("Nenhum registro encontrado.");
            return;
        }

        System.out.println("\n===== LISTA DE REGISTROS =====");

        // Percorre todos os registros cadastrados
        for (int i = 0; i < totalRegistros; i++) {

            RegistroColheita registro = registros[i];

            System.out.println("---------------------------");

            System.out.println("Data: " + registro.data);
            System.out.println("Matrícula: " + registro.matriculaFuncionario);
            System.out.println("Talhão: " + registro.codigoTalhao);
            System.out.println("Placa: " + registro.placaTrator);
            System.out.println("Litros: " + registro.litros);
            System.out.println("Destino: " + registro.destino);
        }
    }

    // BUSCAR REGISTRO POR DATA
    public static void buscarRegistro() {

        System.out.println("\n===== BUSCAR REGISTRO =====");

        System.out.print("Digite a data do registro: ");

        String dataDigitada = sc.nextLine();

        // Percorre todos os registros cadastrados
        for (int i = 0; i < totalRegistros; i++) {

            RegistroColheita registro = registros[i];

            // Verifica se a data corresponde
            if (registro.data.equalsIgnoreCase(dataDigitada)) {

                System.out.println("\n===== REGISTRO ENCONTRADO =====");

                System.out.println("Data: " + registro.data);
                System.out.println("Matrícula: " + registro.matriculaFuncionario);
                System.out.println("Talhão: " + registro.codigoTalhao);
                System.out.println("Placa: " + registro.placaTrator);
                System.out.println("Litros: " + registro.litros);
                System.out.println("Destino: " + registro.destino);
                return;
            }
        }

        System.out.println("Registro não encontrado.");
    }
}