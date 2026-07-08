package Talhoes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenciaTalhao {

    // SALVAR TALHÕES NO CSV
    public static void salvarTalhoesCSV() {

        try {

            // Cria/abre o arquivo CSV onde os dados serão salvos
            FileWriter writer = new FileWriter("banco/talhoes.csv");

            // Percorre todos os talhões cadastrados
            for (int i = 0; i < CadastroTalhao.totalTalhoes; i++) {

                Talhao talhao = CadastroTalhao.talhoes[i];

                // Escreve os dados separados por ";"
                writer.write(
                        talhao.codigo + ";" +
                                talhao.nome + ";" +
                                talhao.variedadeCafe + ";" +
                                talhao.estimativaLitros + ";" +
                                talhao.producaoAtual);

                // Quebra de linha para separar os talhões
                writer.write("\n");
            }

            // Fecha o arquivo após finalizar a escrita
            writer.close();

            System.out.println("Talhões salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar talhões.");
        }
    }

    // CARREGAR TALHÕES DO CSV
    public static void carregarTalhoes() {

        try {

            // Abre o arquivo CSV para leitura
            File arquivo = new File("banco/talhoes.csv");

            Scanner leitor = new Scanner(arquivo);

            // Lê linha por linha do arquivo
            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                // Divide os dados utilizando ";" como separador
                String[] partes = linha.split(";");

                Talhao talhao = new Talhao();

                // Recupera os dados do arquivo
                talhao.codigo = partes[0];
                talhao.nome = partes[1];
                talhao.variedadeCafe = partes[2];
                talhao.estimativaLitros = Double.parseDouble(partes[3]);
                talhao.producaoAtual = Double.parseDouble(partes[4]);

                // Armazena o talhão no vetor
                CadastroTalhao.talhoes[CadastroTalhao.totalTalhoes] = talhao;

                // Incrementa o contador de talhões
                CadastroTalhao.totalTalhoes++;
            }

            // Fecha o leitor após finalizar
            leitor.close();

            System.out.println("Talhões carregados com sucesso!");

        } catch (IOException e) {

            // Caso o arquivo ainda não exista
            System.out.println("Arquivo de talhões não encontrado.");
        }
    }
}