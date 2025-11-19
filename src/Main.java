public class Main {

    public static void main(String[] args) {

        ProcessadorTexto proc = new ProcessadorTexto();

        proc.lerArquivoTexto("texto.txt");


        proc.lerPalavrasChave("palavras-chave.txt");

        proc.gerarIndiceRemissivo("indice-remissivo.txt");

        System.out.println("\nPrograma finalizado.");
    }
}
