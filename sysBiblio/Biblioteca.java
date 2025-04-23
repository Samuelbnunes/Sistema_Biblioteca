import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // BD em memória
    private List<Livro> acervo = new ArrayList<>();
    public static final int ANO_PUBLICACAO_MINIMO = 1400;

    public Livro adicionar(Livro novoLivro) throws Exception {
        if (novoLivro.getTitulo() == null || novoLivro.getTitulo().trim().isEmpty() ||
            novoLivro.getAutor() == null || novoLivro.getAutor().trim().isEmpty()) {
            throw new Exception("Título e Autor não podem estar em branco!");
        }

        if (novoLivro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO) {
            throw new Exception("Ano de publicação não pode ser menor que " + ANO_PUBLICACAO_MINIMO);
        }

        if (novoLivro.getNumeroPaginas() <= 0) {
            throw new Exception("Número de páginas não pode ser zero ou negativo.");
        }

        for (Livro livro : acervo) {
            if (livro.getTitulo().equalsIgnoreCase(novoLivro.getTitulo())) {
                throw new Exception("Já existe um livro com este título.");
            }
        }

        acervo.add(novoLivro);

        return novoLivro;
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarTodos() {
        return acervo;
    }

    public int removerPorTitulo(String titulo) {
        int removidos = 0;
        List<Livro> livrosParaRemover = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosParaRemover.add(livro);
                removidos++;
            }
        }
        acervo.removeAll(livrosParaRemover);
        return removidos;
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisarPorAno(int ano) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getAnoPublicacao() == ano) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
}
