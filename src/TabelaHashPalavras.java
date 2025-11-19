public class TabelaHashPalavras {

    private ArvoreBinariaPalavras[] tabela;

    public TabelaHashPalavras() {
        tabela = new ArvoreBinariaPalavras[26];
        for (int i = 0; i < 26; i++) {
            tabela[i] = new ArvoreBinariaPalavras();
        }
    }

    private int hash(String palavraNormalizada) {

        if (palavraNormalizada == null || palavraNormalizada.isEmpty()) return 0;

        char c = palavraNormalizada.charAt(0);

        if (c < 'a' || c > 'z') return 0;

        return c - 'a';
    }

    public void inserirOuAtualizar(String original, String normalizado, int linha) {

        int indice = hash(normalizado);

        tabela[indice].inserirOuAtualizar(original, normalizado, linha);
    }

    public Palavra buscar(String normalizado) {

        int indice = hash(normalizado);

        return tabela[indice].buscar(normalizado);
    }

    public ArvoreBinariaPalavras getArvore(int i) {
        if (i < 0 || i >= 26) return null;
        return tabela[i];
    }
}
