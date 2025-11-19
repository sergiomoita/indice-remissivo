public class Main {

    public static void main(String[] args) {

        ProcessadorTexto proc = new ProcessadorTexto();

        // ===============================
        // 1) Ler o texto e registrar TODAS as palavras
        // ===============================
        proc.lerArquivoTexto("texto.txt");

        // ===============================
        // 2) Ler as palavras-chave (ordenadas na ABB de chaves)
        // ===============================
        proc.lerPalavrasChave("palavras-chave.txt");

        // ===============================
        // 3) Gerar índice remissivo
        // ===============================
        proc.gerarIndiceRemissivo("indice-remissivo.txt");

        // Mensagem final simples:
        System.out.println("\nPrograma finalizado.");
    }
}
