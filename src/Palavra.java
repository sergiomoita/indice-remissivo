public class Palavra implements Comparable<Palavra> {

    private String original;        // preservado para impressão
    private String normalizado;     // usado para hash/busca
    private ListaOcorrencias ocorrencias;

    public Palavra(String original, String normalizado) {
        this.original = original;           // preserva hífen, acento, maiúscula
        this.normalizado = normalizado;     // versão limpa e singularizada
        this.ocorrencias = new ListaOcorrencias();
    }

    public String getOriginal() {
        return original;
    }

    public String getNormalizado() {
        return normalizado;
    }

    public void adicionarOcorrencia(int linha) {
        ocorrencias.adicionarOcorrencia(linha);
    }

    public ListaOcorrencias getOcorrencias() {
        return ocorrencias;
    }

    @Override
    public int compareTo(Palavra outra) {
        return this.normalizado.compareTo(outra.normalizado);
    }

    @Override
    public String toString() {
        return original + ": " + ocorrencias.toString();
    }
}
