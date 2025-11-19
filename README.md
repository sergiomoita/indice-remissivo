📘 Índice Remissivo em Java

Projeto que implementa um gerador de índice remissivo ordenado alfabeticamente, utilizando estruturas manuais de dados: Tabela Hash, Árvore Binária de Busca (ABB) e Lista Encadeada.
O programa lê palavras-chave e um texto, identifica em quais linhas cada termo aparece e gera um arquivo final indice-remissivo.txt.

📂 Estrutura Geral
src/
 
 ├── Main.java
 
 ├── ProcessadorTexto.java
 
 ├── Palavra.java
 
 ├── ListaOcorrencias.java
 
 ├── ArvoreBinariaPalavras.java
 
 └── TabelaHashPalavras.java

arquivos/
 
 ├── texto.txt
 
 └── palavras-chave.txt

indice-remissivo.txt
README.md

🚀 Funcionalidades

Leitura de palavras-chave separadas por vírgula

Processamento completo do texto linha por linha

Tratamento de acentos, hífen e plural (regular e irregular)

Hash por letra inicial (a–z)

ABB para ordenação automática

Lista encadeada para armazenar ocorrências sem duplicatas

Geração de índice remissivo ordenado alfabeticamente

🧠 Estruturas Utilizadas
🔹 Palavra

Guarda:

a forma original

a forma normalizada

a lista encadeada de ocorrências

🔹 ListaOcorrencias

Lista simplesmente encadeada que armazena números de linha.

🔹 ArvoreBinariaPalavras

Responsável pela inserção, busca e ordenação das palavras.

🔹 TabelaHashPalavras

Tabela com 26 árvores (a…z), cada uma contendo as palavras de uma letra inicial.

🔹 ProcessadorTexto

Executa:

normalização

leitura da chave

leitura do texto

busca

registro de ocorrência

geração do índice

🔹 Main

Controla o fluxo principal do programa.

📥 Arquivos de Entrada
palavras-chave.txt

Palavras separadas por vírgula:

programming, information, human-engineered, lápis, mãos

texto.txt

Arquivo de texto comum, analisado linha por linha.

📄 Exemplo de Saída
cão: 8
carros: 1
e-mails: 7
human-engineered: 5
informação: 4
lápis: 6
mãos: 2
ônibus: 3
papéis: 6

▶️ Como Executar
1. Compile o projeto:
javac src/*.java

2. Execute:
java src/Main

3. Resultado:

Gerado automaticamente no arquivo:

indice-remissivo.txt

🧾 Licença

Uso livre para fins acadêmicos.
