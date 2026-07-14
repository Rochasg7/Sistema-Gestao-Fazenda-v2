import java.util.Scanner;

public class MercadoCafe {

    static Scanner sc = new Scanner(System.in);

    // Preço atual da saca
    static double precoAtual = 2145.00;

    // Histórico simples sem array
    static double segunda = 2020;
    static double terca = 2080;
    static double quarta = 2120;
    static double quinta = 2145;

    public static void abrirMenuMercado() {

        int opcao;

        do {

            System.out.println("\n===== BOLSA DO CAFÉ =====");
            System.out.println("1 - Ver preço atual");
            System.out.println("2 - Simular venda");
            System.out.println("3 - Histórico de preços");
            System.out.println("4 - Situação do mercado");
            System.out.println("0 - Voltar");

            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    verPrecoAtual();
                    break;

                case 2:
                    simularVenda();
                    break;

                case 3:
                    historico();
                    break;

                case 4:
                    situacaoMercado();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // Mostrar preço atual
    public static void verPrecoAtual() {

        System.out.println("\n===== PREÇO ATUAL =====");
        System.out.println("Preço da saca: R$ " + precoAtual);
    }

    // Simulação de venda
    // Simulação de venda
    public static void simularVenda() {

        // Exemplo de quantidade produzida
        double totalSacas = 350;

        System.out.println("\n===== SIMULAÇÃO DE VENDA =====");
        System.out.println("Total disponível: " + totalSacas + " sacas");

        System.out.print("Quantas sacas deseja vender? ");
        double sacasVenda = sc.nextDouble();

        // Validação
        if (sacasVenda > totalSacas) {

            System.out.println("Quantidade indisponível.");
            return;
        }

        double faturamento = sacasVenda * precoAtual;

        double restante = totalSacas - sacasVenda;

        System.out.println("\n===== RESULTADO =====");
        System.out.println("Sacas vendidas: " + sacasVenda);
        System.out.println("Preço atual: R$ " + precoAtual);
        System.out.println("Faturamento: R$ " + faturamento);
        System.out.println("Sacas restantes: " + restante);
    }

    // Histórico simples
    public static void historico() {

        System.out.println("\n===== HISTÓRICO =====");

        System.out.println("Segunda: R$ " + segunda);
        System.out.println("Terça: R$ " + terca);
        System.out.println("Quarta: R$ " + quarta);
        System.out.println("Quinta: R$ " + quinta);
    }

    // Mercado em alta ou baixa
    public static void situacaoMercado() {

        System.out.println("\n===== SITUAÇÃO =====");

        if (precoAtual > quarta) {

            System.out.println("MERCADO EM ALTA 📈");
            System.out.println("Boa oportunidade de venda.");

        } else {

            System.out.println("MERCADO EM BAIXA 📉");
            System.out.println("Aguardar valorização.");
        }
    }
}