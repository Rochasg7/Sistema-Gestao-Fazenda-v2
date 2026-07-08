package Equipe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenciaFuncionario {

    // SALVAR FUNCIONÁRIOS NO CSV
    public static void salvarFuncionariosCSV() {

        try {

            // Cria/abre o arquivo CSV onde os funcionários serão salvos
            FileWriter writer = new FileWriter("banco/funcionarios.csv");

            // Percorre todos os funcionários cadastrados
            for (int i = 0; i < CadastroFuncionario.totalFuncionarios; i++) {

                Funcionario funcionario = CadastroFuncionario.funcionarios[i];

                // Escreve os dados separados por ";"
                writer.write(
                        funcionario.nome + ";" +
                                funcionario.matricula + ";" +
                                funcionario.tipoContrato);

                // Quebra de linha para separar cada funcionário
                writer.write("\n");
            }

            // Fecha o arquivo após finalizar a escrita
            writer.close();

            System.out.println("Funcionários salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar funcionários.");
        }
    }

    // CARREGAR FUNCIONÁRIOS DO CSV
    public static void carregarFuncionariosCSV() {

        try {

            // Abre o arquivo CSV para leitura
            File arquivo = new File("banco/funcionarios.csv");

            Scanner leitor = new Scanner(arquivo);

            // Lê linha por linha do arquivo
            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                // Divide os dados usando ";" como separador
                String[] partes = linha.split(";");

                Funcionario funcionario = new Funcionario();

                // Recupera os dados do arquivo
                funcionario.nome = partes[0];
                funcionario.matricula = partes[1];
                funcionario.tipoContrato = partes[2];

                // Armazena o funcionário no vetor
                CadastroFuncionario.funcionarios[CadastroFuncionario.totalFuncionarios] = funcionario;

                // Incrementa o contador de funcionários
                CadastroFuncionario.totalFuncionarios++;
            }

            // Fecha o leitor após finalizar
            leitor.close();

            System.out.println("Funcionários carregados com sucesso!");

        } catch (IOException e) {

            // Caso o arquivo ainda não exista
            System.out.println("Arquivo de funcionários não encontrado.");
        }
    }
}