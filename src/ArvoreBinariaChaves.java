import java.io.BufferedWriter;
import java.io.IOException;

public class ArvoreBinariaChaves {

    class Nodo {
        Palavra chave;
        Nodo esquerdo, direito;

        Nodo(Palavra p) {
            this.chave = p;
        }
    }

    private Nodo raiz;

    public void inserirChave(String original, String normalizado) {
        Palavra nova = new Palavra(original, normalizado);
        raiz = inserir(raiz, nova);
    }

    private Nodo inserir(Nodo nodo, Palavra nova) {
        if (nodo == null)
            return new Nodo(nova);

        int cmp = nova.getNormalizado().compareTo(nodo.chave.getNormalizado());

        if (cmp < 0) nodo.esquerdo = inserir(nodo.esquerdo, nova);
        else if (cmp > 0) nodo.direito = inserir(nodo.direito, nova);

        return nodo;
    }

    public void imprimirIndice(TabelaHashPalavras tabela, BufferedWriter bw) throws IOException {
        imprimir(raiz, tabela, bw);
    }

    private void imprimir(Nodo nodo, TabelaHashPalavras tabela, BufferedWriter bw) throws IOException {
        if (nodo == null) return;

        imprimir(nodo.esquerdo, tabela, bw);

        Palavra encontrada = tabela.buscar(nodo.chave.getNormalizado());

        if (encontrada == null || encontrada.getOcorrencias().estaVazia()) {
            bw.write(nodo.chave.getOriginal() + ": (não encontrada no texto)");
        } else {
            bw.write(nodo.chave.getOriginal() + ": " + encontrada.getOcorrencias().toString());
        }

        bw.newLine();

        imprimir(nodo.direito, tabela, bw);
    }
}
