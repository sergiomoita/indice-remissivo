public class ListaOcorrencias {

    // Nodo interno
    private static class Nodo {
        int linha;
        Nodo proximo;

        public Nodo(int linha) {
            this.linha = linha;
            this.proximo = null;
        }
    }

    private Nodo primeiro;
    private Nodo ultimo;
    private int n_elementos;

    public ListaOcorrencias() {
        this.primeiro = null;
        this.ultimo = null;
        this.n_elementos = 0;
    }

    // Adiciona linha apenas se ela ainda não estiver na lista
    public void adicionarOcorrencia(int linha) {

        // lista vazia
        if (primeiro == null) {
            Nodo novo = new Nodo(linha);
            primeiro = novo;
            ultimo = novo;
            n_elementos++;
            return;
        }

        // se a última ocorrência já é igual à atual, não precisa percorrer
        if (ultimo.linha == linha) {
            return;
        }

        // percorre lista evitando duplicados
        Nodo atual = primeiro;
        while (atual != null) {
            if (atual.linha == linha) {
                return; // já existe
            }
            atual = atual.proximo;
        }

        // adiciona no final
        Nodo novo = new Nodo(linha);
        ultimo.proximo = novo;
        ultimo = novo;
        n_elementos++;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo atual = primeiro;
        while (atual != null) {
            sb.append(atual.linha);
            if (atual.proximo != null) {
                sb.append(", ");
            }
            atual = atual.proximo;
        }
        return sb.toString();
    }
}
