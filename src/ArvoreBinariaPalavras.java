import java.io.BufferedWriter;
import java.io.IOException;

public class ArvoreBinariaPalavras {

    class Nodo {
        public Palavra elemento;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(Palavra elemento) {
            this.elemento = elemento;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    // ===== ATRIBUTOS DA ÁRVORE =====
    private Nodo raiz;
    private int nElementos;

    public ArvoreBinariaPalavras() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public void inserirOuAtualizar(String original, String normalizado, int linha) {

        Palavra nova = new Palavra(original, normalizado);

        this.raiz = inserirOuAtualizar(this.raiz, nova, linha);
    }

    private Nodo inserirOuAtualizar(Nodo nodo, Palavra nova, int linha) {

        if (nodo == null) {
            nova.adicionarOcorrencia(linha);
            this.nElementos++;
            return new Nodo(nova);
        }

        int cmp = nova.getNormalizado().compareTo(nodo.elemento.getNormalizado());

        if (cmp < 0) {
            nodo.esquerdo = inserirOuAtualizar(nodo.esquerdo, nova, linha);

        } else if (cmp > 0) {
            nodo.direito = inserirOuAtualizar(nodo.direito, nova, linha);

        } else {
            // já existe → só adicionar ocorrência
            nodo.elemento.adicionarOcorrencia(linha);
        }

        return nodo;
    }

    public Palavra buscar(String normalizado) {
        return buscar(this.raiz, normalizado);
    }

    private Palavra buscar(Nodo nodo, String normalizado) {
        if (nodo == null) return null;

        int cmp = normalizado.compareTo(nodo.elemento.getNormalizado());

        if (cmp < 0)
            return buscar(nodo.esquerdo, normalizado);

        else if (cmp > 0)
            return buscar(nodo.direito, normalizado);

        else
            return nodo.elemento;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(this.raiz);
    }

    private void imprimirEmOrdem(Nodo nodo) {
        if (nodo == null) return;

        imprimirEmOrdem(nodo.esquerdo);
        System.out.println(nodo.elemento.toString());
        imprimirEmOrdem(nodo.direito);
    }


    public void imprimirEmOrdem(BufferedWriter bw) throws IOException {
        imprimirEmOrdem(this.raiz, bw);
    }

    private void imprimirEmOrdem(Nodo nodo, BufferedWriter bw) throws IOException {
        if (nodo == null) return;

        imprimirEmOrdem(nodo.esquerdo, bw);

        bw.write(nodo.elemento.toString());
        bw.newLine();

        imprimirEmOrdem(nodo.direito, bw);
    }
}
