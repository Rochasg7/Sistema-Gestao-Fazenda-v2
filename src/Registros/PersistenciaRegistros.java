package Registros;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PersistenciaRegistros {

    // SALVAR REGISTROS NO CSV
    public static void salvarRegistrosCSV() {

        try {

            // Cria/abre o arquivo CSV onde os registros serão salvos
            FileWriter writer =
                    new FileWriter("banco/registros.csv");

            // Percorre todos os registros cadastrados
            for (int i = 0; i < RegistrosService.totalRegistros; i++) {

                RegistroColheita registro =
                        RegistrosService.registros[i];

                // Escreve os dados separados por ";"
                writer.write(
                        registro.data + ";" +
                        registro.matriculaFuncionario + ";" +
                        registro.codigoTalhao + ";" +
                        registro.placaTrator + ";" +
                        registro.litros + ";" +
                        registro.destino
                );

                // Quebra de linha para separar os registros
                writer.write("\n");
            }

            // Fecha o arquivo após finalizar a escrita
            writer.close();

            System.out.println("Registros salvos com sucesso!");

        } catch (IOException e) {

            System.out.println("Erro ao salvar registros.");
        }
    }

    // CARREGAR REGISTROS DO CSV
    public static void carregarRegistrosCSV() {

        try {

            // Abre o arquivo CSV para leitura
            File arquivo =
                    new File("banco/registros.csv");

            Scanner leitor =
                    new Scanner(arquivo);

            // Lê linha por linha do arquivo
            while (leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                // Divide os dados utilizando ";" como separador
                String[] partes = linha.split(";");

                RegistroColheita registro =
                        new RegistroColheita();

                // Recupera os dados do arquivo
                registro.data = partes[0];
                registro.matriculaFuncionario = partes[1];
                registro.codigoTalhao = partes[2];
                registro.placaTrator = partes[3];
                registro.litros =
                        Double.parseDouble(partes[4]);
                registro.destino = partes[5];

                // Armazena o registro no vetor
                RegistrosService.registros[
                        RegistrosService.totalRegistros
                ] = registro;

                // Incrementa o contador de registros
                RegistrosService.totalRegistros++;
            }

            // Fecha o leitor após finalizar
            leitor.close();

            System.out.println("Registros carregados com sucesso!");

        } catch (IOException e) {

            // Caso o arquivo ainda não exista
            System.out.println("Arquivo de registros não encontrado.");
        }
    }
}