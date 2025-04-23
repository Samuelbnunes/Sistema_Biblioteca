public abstract class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numeroPaginas;
    public static final int ANO_PUBLICACAO_MINIMO = 1400;

    public Livro(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public abstract String getFormato();

    public final int calcularTempoPublicacao() {
        return java.time.Year.now().getValue() - this.anoPublicacao;
    }

    @Override
    public String toString() {
        String descricao =
            "Título: " + getTitulo() +
            " - Autor: " + getAutor() +
            " - Ano: " + getAnoPublicacao() +
            " - Páginas: " + getNumeroPaginas() +
            " - Formato: " + getFormato() +
            " - Tempo Publicação: " + calcularTempoPublicacao() + " anos";
        return descricao;
    }
}