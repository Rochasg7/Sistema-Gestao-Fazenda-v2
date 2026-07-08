package Relatorios;

import Equipe.CadastroFuncionario;
import Equipe.Funcionario;

import Frota.CadastroFrota;
import Frota.Frota;

import Talhoes.CadastroTalhao;
import Talhoes.Talhao;

import Registros.RegistrosService;
import Registros.RegistroColheita;

public class RelatorioService {

    // RELATÓRIO DE FUNCIONÁRIOS
    public static void relatorioFuncionarios() {

        System.out.println("\n===== RELATÓRIO DE FUNCIONÁRIOS =====");

        if (CadastroFuncionario.totalFuncionarios == 0) {

            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (int i = 0;
             i < CadastroFuncionario.totalFuncionarios;
             i++) {

            Funcionario funcionario =
                    CadastroFuncionario.funcionarios[i];

            System.out.println("----------------------------------");

            System.out.println("Nome: "
                    + funcionario.nome);

            System.out.println("Matrícula: "
                    + funcionario.matricula);

            System.out.println("Tipo de Contrato: "
                    + funcionario.tipoContrato);
        }

        System.out.println("----------------------------------");

        System.out.println("Total de funcionários: "
                + CadastroFuncionario.totalFuncionarios);
    }

    // RELATÓRIO DA FROTA
    public static void relatorioFrota() {

        System.out.println("\n===== RELATÓRIO DA FROTA =====");

        if (CadastroFrota.totalTratores == 0) {

            System.out.println("Nenhum trator cadastrado.");
            return;
        }

        for (int i = 0;
             i < CadastroFrota.totalTratores;
             i++) {

            Frota trator =
                    CadastroFrota.tratores[i];

            System.out.println("----------------------------------");

            System.out.println("Placa: "
                    + trator.placa);

            System.out.println("Capacidade: "
                    + trator.capacidade + " litros");
        }

        System.out.println("----------------------------------");

        System.out.println("Total de tratores: "
                + CadastroFrota.totalTratores);
    }

    // RELATÓRIO DE TALHÕES
    public static void relatorioTalhoes(){

        System.out.println("\n===== RELATÓRIO DE TALHÕES =====");

        if (CadastroTalhao.totalTalhoes == 0) {

            System.out.println("Nenhum talhão cadastrado.");
            return;
        }

        for (int i = 0;
             i < CadastroTalhao.totalTalhoes;
             i++) {

            Talhao talhao =
                    CadastroTalhao.talhoes[i];

            System.out.println("----------------------------------");

            System.out.println("Código: "
                    + talhao.codigo);

            System.out.println("Nome: "
                    + talhao.nome);

            System.out.println("Variedade do Café: "
                    + talhao.variedadeCafe);

            System.out.println("Estimativa: "
                    + talhao.estimativaLitros + " litros");

            System.out.println("Produção Atual: "
                    + talhao.producaoAtual + " litros");
        }

        System.out.println("----------------------------------");

        System.out.println("Total de talhões: "
                + CadastroTalhao.totalTalhoes);
    }

    // RELATÓRIO DE COLHEITA
    public static void relatorioColheita() {

        System.out.println("\n===== RELATÓRIO DE COLHEITA =====");

        if (RegistrosService.totalRegistros == 0) {

            System.out.println("Nenhum registro encontrado.");
            return;
        }

        double totalLitros = 0;

        for (int i = 0;
             i < RegistrosService.totalRegistros;
             i++) {

            RegistroColheita registro =
                    RegistrosService.registros[i];

            System.out.println("----------------------------------");

            System.out.println("Data: "
                    + registro.data);

            System.out.println("Funcionário: "
                    + registro.matriculaFuncionario);

            System.out.println("Talhão: "
                    + registro.codigoTalhao);

            System.out.println("Trator: "
                    + registro.placaTrator);

            System.out.println("Litros Colhidos: "
                    + registro.litros);

            System.out.println("Destino: "
                    + registro.destino);

            totalLitros += registro.litros;
        }

        System.out.println("----------------------------------");

        System.out.println("Total colhido: "
                + totalLitros + " litros");
    }

    // RELATÓRIO GERAL
    public static void relatorioGeral() {

        System.out.println("\n===== RELATÓRIO GERAL DA FAZENDA =====");

        System.out.println("Funcionários cadastrados: "
                + CadastroFuncionario.totalFuncionarios);

        System.out.println("Tratores cadastrados: "
                + CadastroFrota.totalTratores);

        System.out.println("Talhões cadastrados: "
                + CadastroTalhao.totalTalhoes);

        System.out.println("Registros de colheita: "
                + RegistrosService.totalRegistros);
    }
    public static void relatorioQuinzena() {

    System.out.println(
        "\n===== ACERTO DA QUINZENA ====="
    );

    if (RegistrosService.totalRegistros == 0) {

        System.out.println(
            "Nenhum registro encontrado."
        );

        return;
    }

    for (int i = 0;
         i < CadastroFuncionario.totalFuncionarios;
         i++) {

        Funcionario funcionario =
                CadastroFuncionario.funcionarios[i];

        double totalLitros = 0;

        for (int j = 0;
             j < RegistrosService.totalRegistros;
             j++) {

            RegistroColheita registro =
                    RegistrosService.registros[j];

            if (registro.matriculaFuncionario
                    .equalsIgnoreCase(
                        funcionario.matricula)) {

                totalLitros += registro.litros;
            }
        }

        System.out.println(
            funcionario.nome
            + " -> "
            + totalLitros
            + " litros"
        );
        }
    }
    public static void relatorioTalhao() {

    System.out.println(
        "\n===== FECHAMENTO DOS TALHÕES ====="
    );

    for (int i = 0;
         i < CadastroTalhao.totalTalhoes;
         i++) {

        Talhao talhao =
                CadastroTalhao.talhoes[i];

        double totalProduzido = 0;

        for (int j = 0;
             j < RegistrosService.totalRegistros;
             j++) {

            RegistroColheita registro =
                    RegistrosService.registros[j];

            if (registro.codigoTalhao
                    .equalsIgnoreCase(
                        talhao.codigo)) {

                totalProduzido += registro.litros;
            }
        }

        System.out.println("\nTalhão: "
                + talhao.nome);

        System.out.println(
            "Produção Atual: "
            + totalProduzido
            + " litros"
        );

        System.out.println(
            "Estimativa: "
            + talhao.estimativaLitros
            + " litros"
        );

        if (totalProduzido
                >= talhao.estimativaLitros) {

            System.out.println(
                "Meta atingida ✅"
            );

        } else {

            System.out.println(
                "Meta não atingida ❌"
            );
        }
    }
    }
    public static void relatorioSecagem() {

        System.out.println(
            "\n===== RELATÓRIO DE SECAGEM ====="
        );

    double secador = 0;
    double terreiro = 0;

    for (int i = 0;
         i < RegistrosService.totalRegistros;
         i++) {

        RegistroColheita registro =
                RegistrosService.registros[i];

        // TRANSFORMA EM MINÚSCULO
        String destino =
                registro.destino.toLowerCase();

        // VERIFICA SECADOR
        if (destino.contains("secador")) {

            secador += registro.litros;
        }

        // VERIFICA TERREIRO
        else if (destino.contains("terreiro")) {

            terreiro += registro.litros;
        }
    }

    System.out.println(
        "Secador: "
        + secador
        + " litros"
    );

    System.out.println(
        "Terreiro: "
        + terreiro
        + " litros"
    );
}
}