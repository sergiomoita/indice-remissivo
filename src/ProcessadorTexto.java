import java.io.*;
import java.text.Normalizer;

public class ProcessadorTexto {

    private TabelaHashPalavras tabela;       // guarda TODAS as palavras do texto
    private ArvoreBinariaChaves arvoreChaves; // guarda SOMENTE palavras-chave

    public ProcessadorTexto() {
        this.tabela = new TabelaHashPalavras();
        this.arvoreChaves = new ArvoreBinariaChaves();
    }

    public TabelaHashPalavras getTabela() {
        return this.tabela;
    }

    public ArvoreBinariaChaves getArvoreChaves() {
        return this.arvoreChaves;
    }

    // ===============================================================
    // 1) LER TEXTO PRINCIPAL
    // ===============================================================
    public void lerArquivoTexto(String caminhoArquivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            String linha;
            int numeroLinha = 1;

            while ((linha = br.readLine()) != null) {

                String linhaLimpa = limparLinha(linha);
                String[] palavras = linhaLimpa.split("\\s+");

                for (String p : palavras) {
                    if (p.isEmpty()) continue;

                    String normalizado = normalizarPalavra(p);

                    tabela.inserirOuAtualizar(p, normalizado, numeroLinha);
                }

                numeroLinha++;
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler texto: " + e.getMessage());
        }
    }


    // ===============================================================
    // 2) LER PALAVRAS-CHAVE (separadas por vírgula)
    // ===============================================================
    public void lerPalavrasChave(String caminho) {

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String linha = br.readLine();
            if (linha == null) return;

            // NÃO REMOVER ACENTOS!
            String[] chaves = linha.split(",");

            for (String chaveOriginal : chaves) {

                chaveOriginal = chaveOriginal.trim();
                if (chaveOriginal.isEmpty()) continue;

                // normalizado SEM acento
                String normalizado = normalizarPalavra(chaveOriginal);

                // inserir na ABB de chaves com original preservado
                arvoreChaves.inserirChave(chaveOriginal, normalizado);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler palavras-chave: " + e.getMessage());
        }
    }

    // ===============================================================
    // 3) GERAR ÍNDICE — AGORA USANDO APENAS A ABB DE PALAVRAS-CHAVE
    // ===============================================================
    public void gerarIndiceRemissivo(String caminhoSaida) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoSaida))) {

            arvoreChaves.imprimirIndice(tabela, bw);

            System.out.println("✔ Índice remissivo gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo de saída: " + e.getMessage());
        }
    }

    // ===============================================================
    // FUNÇÃO: REMOVER PONTUAÇÃO E ACENTOS
    // ===============================================================
    private String limparLinha(String linha) {

        linha = Normalizer.normalize(linha, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        linha = linha.replace("-", "_HIFEN_");
        linha = linha.replaceAll("[^a-zA-Z _HIFEN_]", " ");
        linha = linha.replace("_HIFEN_", "-");

        return linha;
    }

    // ===============================================================
    // FUNÇÃO: NORMALIZAR PLURAIS (versão melhorada)
    // ===============================================================
    private String normalizarPalavra(String p) {

        p = p.trim().toLowerCase();

        // remover acentos para comparação
        p = Normalizer.normalize(p, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]+", "");

        // -- exceções invariáveis
        String[] invariaveis = {
                "lapis", "onibus", "cais", "pais", "gratis", "virus", "atlas", "pires", "lilis"
        };
        for (String inv : invariaveis) {
            if (p.equals(inv)) return p;
        }

        // -- plurais irregulares (não reduzir)
        String[] irreg = { "oes", "aes", "aos", "ãos", "ães" };
        for (String irr : irreg)
            if (p.endsWith(irr)) return p;

        // -- plural regular (carros → carro)
        if (p.length() > 3 && p.endsWith("s") && !p.endsWith("ss"))
            return p.substring(0, p.length() - 1);

        return p;
    }

}
