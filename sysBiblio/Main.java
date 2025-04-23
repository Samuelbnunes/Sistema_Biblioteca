import java.util.List;
import java.util.Scanner;

public class Main {
    private static Biblioteca biblio = new Biblioteca();

    public static void main(String[] args) {
        String menu = """
                ====== Biblioteca Online ======

                Escolha uma das opções abaixo:
                1 - Adicionar novo livro
                2 - Pesquisar livro por título
                3 - Listar todos os livros
                4 - Remover livro por título
                5 - Pesquisar livro por autor
                6 - Listar livros por ano
                0 - Sair
                """;
        int opcao;
        Scanner lerTeclado = new Scanner(System.in);
        do {
            limparTela();
            opcao = inputNumerico(lerTeclado, menu);
            switch (opcao) {
                case 1:
                    adicionar(lerTeclado);
                    break;
                case 2:
                    pesquisarPorTitulo(lerTeclado);
                    break;
                case 3:
                    pesquisarTodos();
                    break;
                case 4:
                    removerPorTitulo(lerTeclado);
                    break;
                case 5:
                    pesquisarPorAutor(lerTeclado);
                    break;
                case 6:
                    pesquisarPorAno(lerTeclado);
                    break;
                case 0:
                    limparTela();
                    System.out.println("Encerrando programa ...");
                    break;
                default:
                    limparTela();
                    System.out.println("Opção inválida!");
                    break;
            }
            pausar(lerTeclado);
        } while (opcao != 0);
    }

    private static void adicionar(Scanner lerTeclado) {
        limparTela();
        System.out.print("Digite o título do livro: ");
        String titulo = lerTeclado.nextLine();
        limparTela();
        System.out.print("Digite o autor do livro: ");
        String autor = lerTeclado.nextLine();
        limparTela();
        int anoPublicacao = inputNumerico(lerTeclado, "Digite o ano da publicação: ");
        limparTela();
        int numeroPaginas = inputNumerico(lerTeclado, "Digite o número de páginas: ");

        Livro novoLivro;

        limparTela();
        int tipoLivro = inputNumerico(lerTeclado, "Qual o tipo do livro: 1-Físico, 2-Digital");
        if (tipoLivro == 1) {
            novoLivro = new LivroFisico();
            limparTela();
            System.out.print("Digite as dimensões do livro: ");
            String dimensoes = lerTeclado.nextLine();
            limparTela();
            int numeroExemplares = inputNumerico(lerTeclado, "Digite o número de exemplares: ");

            LivroFisico novoLivroFisico = (LivroFisico) novoLivro;
            novoLivroFisico.setDimensoes(dimensoes);
            novoLivroFisico.setNumeroExemplares(numeroExemplares);
        } else {
            novoLivro = new LivroDigital();
            limparTela();
            System.out.print("Digite o formato do arquivo: ");
            String formatoArquivo = lerTeclado.nextLine();

            LivroDigital novoLivroDigital = (LivroDigital) novoLivro;
            novoLivroDigital.setFormatoArquivo(formatoArquivo);
        }

        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);
        novoLivro.setAnoPublicacao(anoPublicacao);
        novoLivro.setNumeroPaginas(numeroPaginas);

        try {
            biblio.adicionar(novoLivro);
            limparTela();
            System.out.println("Livro adicionado com Sucesso!\n");
        } catch (Exception e) {
            limparTela();
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public static void pesquisarTodos() {
        List<Livro> livros = biblio.pesquisarTodos();
        if (livros.isEmpty()) {
            limparTela();
            System.out.println("NENHUM LIVRO CADASTRADO!");
        } else {
            limparTela();
            System.out.println("Livros Cadastrados:");
            for (Livro livro : livros) {
                System.out.println(livro.toString());
            }
        }
    }

    private static void pesquisarPorTitulo(Scanner lerTeclado) {
        limparTela();
        System.out.print("Digite o título a pesquisar: ");
        String titulo = lerTeclado.nextLine();
        List<Livro> resultados = biblio.pesquisarPorTitulo(titulo);
        if (resultados.isEmpty()) {
            limparTela();
            System.out.println("Nenhum livro encontrado com o título: " + titulo);
        } else {
            limparTela();
            System.out.println("Livros encontrados:");
            for (Livro livro : resultados) {
                System.out.println(livro.toString());
            }
        }
    }

    private static void removerPorTitulo(Scanner lerTeclado) {
        limparTela();
        System.out.print("Digite o título do livro a remover: ");
        String titulo = lerTeclado.nextLine();
        int removidos = biblio.removerPorTitulo(titulo);
        limparTela();
        System.out.println(removidos + " livro(s) removido(s).");
    }

    private static void pesquisarPorAutor(Scanner lerTeclado) {
        limparTela();
        System.out.print("Digite o autor a pesquisar: ");
        String autor = lerTeclado.nextLine();
        List<Livro> resultados = biblio.pesquisarPorAutor(autor);
        if (resultados.isEmpty()) {
            limparTela();
            System.out.println("Nenhum livro encontrado com o autor: " + autor);
        } else {
            limparTela();
            System.out.println("Livros encontrados:");
            for (Livro livro : resultados) {
                System.out.println(livro.toString());
            }
        }
    }

    private static void pesquisarPorAno(Scanner lerTeclado) {
        limparTela();
        System.out.print("Digite o ano a pesquisar: ");
        int ano = lerTeclado.nextInt();
        lerTeclado.nextLine();
        List<Livro> resultados = biblio.pesquisarPorAno(ano);
        if (resultados.isEmpty()) {
            limparTela();
            System.out.println("Nenhum livro encontrado no ano: " + ano);
        } else {
            limparTela();
            System.out.println("Livros encontrados:");
            for (Livro livro : resultados) {
                System.out.println(livro.toString());
            }
        }
    }

    private static int inputNumerico(Scanner lerTeclado, String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = lerTeclado.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                limparTela();
                System.out.println("Erro. Por favor informe um número Inteiro");
            }
        } while (!entradaValida);
        return valor;
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausar(Scanner lerTeclado) {
        System.out.println("\nPressione Enter para continuar...");
        lerTeclado.nextLine();
    }
}