📘 Índice Remissivo em Java

Projeto que lê um conjunto de palavras-chave e um texto, identifica em quais linhas cada termo aparece e gera um índice remissivo ordenado alfabeticamente.
Implementado usando Tabela Hash, Árvores Binárias de Busca (ABB) e Listas Encadeadas, sem uso de coleções prontas.

🚀 Funcionalidades

Leitura de palavras-chave separadas por vírgula

Leitura completa do texto linha a linha

Normalização de acentos, hífen e plural

Hash por inicial da palavra

ABB para ordenação automática

Lista encadeada de ocorrências

Geração do arquivo indice-remissivo.txt

📂 Estruturas Utilizadas

ListaOcorrencias → armazena as linhas

Palavra → guarda original + normalizada

ArvoreBinariaPalavras → ordenação

TabelaHashPalavras → distribuição por letra

ProcessadorTexto → lógica principal

▶️ Como Executar

Coloque texto.txt e palavras-chave.txt na pasta do projeto

Compile:

javac src/*.java


Execute:

java src/Main


O resultado estará em:

indice-remissivo.txt

📄 Exemplo de Saída
informação: 4
human-engineered: 5
papéis: 6
