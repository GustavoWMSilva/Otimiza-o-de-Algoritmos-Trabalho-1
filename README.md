# README.md

## Trabalho T1 - Projeto e Otimização de Algoritmos

Este repositório contém a implementação e análise de algoritmos de busca de subsequência em uma série temporal e de multiplicação de matrizes utilizando o método de Strassen. Estes algoritmos foram desenvolvidos como parte da disciplina de Projeto e Otimização de Algoritmos.

### Objetivos do Trabalho

- Implementar e analisar algoritmos greedy e de divisão e conquista.
- Resolver problemas específicos utilizando esses algoritmos.
- Comparar a eficiência e a corretude das soluções implementadas.

### Problema 1: Busca de Subsequência em Séries Temporais

#### Descrição

Dada uma longa sequência \( S \) de eventos, como ordens de compra em bolsas de valores, deseja-se detectar se uma subsequência \( S' \) ocorre em \( S \) na mesma ordem, mas não necessariamente consecutivamente. Por exemplo, queremos saber se os eventos "buy Google", "buy Apple", "buy Google", "buy NVIDIA" ocorrem na sequência \( S = \{"buy Amazon", "buy Google", "buy Apple", "buy Google", "buy Google", "buy NVIDIA"\} \).

#### Exemplo

- **Sequência S**: \{"buy Amazon", "buy Google", "buy Apple", "buy Google", "buy Google", "buy NVIDIA"\}
- **Subsequência S'**: \{"buy Google", "buy Apple", "buy Google", "buy NVIDIA"\}

O algoritmo verifica se \( S' \) é uma subsequência de \( S \) percorrendo ambas as sequências e garantindo que todos os elementos de \( S' \) sejam encontrados em \( S \) na ordem correta.

### Problema 2: Multiplicação de Matrizes com o Método de Strassen

#### Descrição

A multiplicação de matrizes é uma operação fundamental em várias áreas, como ciência da computação e matemática. O método tradicional de multiplicação de matrizes possui complexidade \( O(n^3) \). No entanto, o algoritmo de Strassen reduz essa complexidade para aproximadamente \( O(n^{2.81}) \) usando uma abordagem de divisão e conquista.

#### Exemplo

Dadas duas matrizes \( A \) e \( B \), o objetivo é calcular a matriz resultante \( C = A \times B \) utilizando o algoritmo de Strassen. Este método divide as matrizes em submatrizes menores e realiza operações matriciais com um número reduzido de multiplicações e adições.

### Estrutura do Relatório

O relatório do trabalho é estruturado nas seguintes seções:

#### Problema 1

1. **O Problema**:
   - Descrição detalhada do problema de busca de subsequência em séries temporais.
   - Exemplo ilustrativo.

2. **O Algoritmo**:
   - Descrição do algoritmo greedy utilizado para verificar se uma sequência é subsequência de outra.

3. **Análise do Algoritmo**:
   - Prova de que a decisão greedy resulta em uma solução global ótima.
   - Discussão sobre a eficiência do algoritmo.

4. **Implementação e Tempo de Execução**:
   - Análise de complexidade e desempenho do algoritmo implementado.

#### Problema 2

1. **O Problema**:
   - Descrição detalhada do problema de multiplicação de matrizes.

2. **O Algoritmo**:
   - Descrição do algoritmo de Strassen para multiplicação de matrizes.

3. **Análise do Algoritmo**:
   - Discussão sobre a eficiência do algoritmo e como ele melhora a complexidade assintótica em comparação com o método tradicional.

4. **Implementação e Tempo de Execução**:
   - Análise de complexidade e desempenho do algoritmo implementado.

### Como Executar

Para compilar e executar os códigos:

1. Certifique-se de ter o JDK instalado.
2. Compile os arquivos Java com o comando `javac`.
3. Execute os programas usando o comando `java`.

### Contato

Para mais informações, entre em contato com os desenvolvedores.

---

Este trabalho foi realizado como parte da disciplina de Projeto e Otimização de Algoritmos, sob a orientação do professor Rafael Scopel.
