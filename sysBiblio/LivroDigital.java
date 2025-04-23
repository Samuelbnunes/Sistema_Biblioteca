public final class LivroDigital extends Livro {

    private double tamanhoArquivo;
    private String formatoArquivo;

    public LivroDigital(String titulo, String autor, int anoPublicacao, int numeroPaginas, double tamanhoArquivo, String formatoArquivo) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formatoArquivo = formatoArquivo;
    }

    public LivroDigital() {
        super(null, null, 0, 0);
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    @Override
    public String getFormato() {
        return "Digital";
    }

    @Override
    public String toString() {
        String descricao = super.toString();
        descricao += " - Formato Arquivo:" + getFormatoArquivo() +
                     " - Tamanho (MB): " + getTamanhoArquivo();
        return descricao;
    }
}