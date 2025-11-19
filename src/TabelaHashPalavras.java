public class TabelaHashPalavras {

    private ArvoreBinariaPalavras[] tabela;

    public TabelaHashPalavras() {
        tabela = new ArvoreBinariaPalavras[26];
        for (int i = 0; i < 26; i++) {
            tabela[i] = new ArvoreBinariaPalavras();
        }
    }

    // ======================================================
    // FUNÇÃO HASH — retorna índice de 0 a 25 (a → z)
    // ======================================================
    private int hash(String palavraNormalizada) {

        if (palavraNormalizada == null || palavraNormalizada.isEmpty()) return 0;

        char c = palavraNormalizada.charAt(0);

        if (c < 'a' || c > 'z') return 0;

        return c - 'a';
    }

    // ======================================================
    // INSERIR OU ATUALIZAR PALAVRA DO TEXTO
    // ======================================================
    public void inserirOuAtualizar(String original, String normalizado, int linha) {

        int indice = hash(normalizado);

        tabela[indice].inserirOuAtualizar(original, normalizado, linha);
    }

    // ======================================================
    // BUSCAR UMA PALAVRA NORMALIZADA NA TABELA
    // ======================================================
    public Palavra buscar(String normalizado) {

        int indice = hash(normalizado);

        return tabela[indice].buscar(normalizado);
    }

    // ======================================================
    // ACESSAR UMA DAS 26 ÁRVORES
    // ======================================================
    public ArvoreBinariaPalavras getArvore(int i) {
        if (i < 0 || i >= 26) return null;
        return tabela[i];
    }
}
