/*
 * Classe referente ao algoritmo de Strassem para multiplicaçaõ de matrizes
 * Para a multiplicação é requerido alguns métodos a mais, separar, subtrair,
 * somar e juntar matrizes
 */
public class Problema2 {

    // Método 1
    // Multiplicar matrizes
    public int[][] multiply(int[][] A, int[][] B)
    {
        // Captura a ordem(tamanho) da matriz
        int n = A.length;

        // Cria uma matriz quadrada de tamanho n
        int[][] R = new int[n][n];

        // Caso base, se há apenas 1 elemento
        if (n == 1)

            // Retorna a simples multiplicação dos 2 valores
            R[0][0] = A[0][0] * B[0][0];

        // Matriz
        else {
            // Passo 1: Divide-se a matriz em partes,
            // armazenando as subpartes em variáveis
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            // Passo 2: Divide-se as matrizes A em 4 partes
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);

            // Passo 2: Divide-se as matrizes B em 4 partes
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            // Usando fórmulas conforme o algoritmo

            // M1=(A1+A3)×(B1+B2)
            int[][] M1 = multiply(add(A11, A22), add(B11, B22));

            // M2=(A2+A4)×(B3+B4)
            int[][] M2 = multiply(add(A21, A22), B11);

            // M3=(A1−A4)×(B1+A4)
            int[][] M3 = multiply(A11, sub(B12, B22));

            // M4=A1×(B2−B4)
            int[][] M4 = multiply(A22, sub(B21, B11));

            // M5=(A3+A4)×(B1)
            int[][] M5 = multiply(add(A11, A12), B22);

            // M6=(A1+A2)×(B4)
            int[][] M6 = multiply(sub(A21, A11), add(B11, B12));

            // M7=A4×(B3−B1)
            int[][] M7 = multiply(sub(A12, A22), add(B21, B22));

            // P=M2+M3−M6−M7
            int[][] C11 = add(sub(add(M1, M4), M5), M7);
           
            // Q=M4+M6
            int[][] C12 = add(M3, M5);
           
            // R=M5+M7
            int[][] C21 = add(M2, M4);
           
            // S=M1−M3−M4−M5
            int[][] C22 = add(sub(add(M1, M3), M2), M6);

            // Passo 3: Junta as 4 partes em uma matriz resultado
            join(C11, R, 0, 0);
            join(C12, R, 0, n / 2);
            join(C21, R, n / 2, 0);
            join(C22, R, n / 2, n / 2);
        }

        // Passo 4: Retorna a matriz resultado
        return R;
    }

    // Método 2
    // Subtração entre 2 matrizes
    public int[][] sub(int[][] A, int[][] B)
    {
        // Captura a ordem(tamanho) da matriz
        int n = A.length;

        // Cria uma matriz quadrada de tamanho n, sendo n dado pelo usuário
        int[][] C = new int[n][n];

        // Interação dos elementos das matrizes

        // loop das linhas
        for (int i = 0; i < n; i++)

            // loop das colunas
            for (int j = 0; j < n; j++)

                // Subtração dos elementos correspondentes das matrizes
                C[i][j] = A[i][j] - B[i][j];

        // Retorna a matriz resultado
        return C;
    }

    // Método 3
    // Adição entre matrizes
    public int[][] add(int[][] A, int[][] B)
    {

        // Captura a ordem(tamanho) da matriz
        int n = A.length;

        // Cria uma matriz quadrada de tamanho n, sendo n dado pelo usuário
        int[][] C = new int[n][n];

        // Interação dos elementos das matrizes

        // loop das linhas
        for (int i = 0; i < n; i++)

            // loop das colunas
            for (int j = 0; j < n; j++)

                // Adição dos elementos correspondentes das matrizes
                C[i][j] = A[i][j] + B[i][j];

        // Retorna a matriz resultado
        return C;
    }

    // Método 4
    // Divide a matriz pai em matrizes filhas
    public void split(int[][] P, int[][] C, int iB, int jB)
    {
        // Interação dos elementos das matrizes

        // loop das linhas
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)

            // loop das colunas
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                C[i1][j1] = P[i2][j2];
    }
 
    // Método 5
    // Junta as matrizes filhas e recria a matriz pai
    public void join(int[][] C, int[][] P, int iB, int jB)

    {
        // Interação dos elementos das matrizes

        // loop das linhas
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
 
            // loop das colunas
            for (int j1 = 0, j2 = jB; j1 < C.length;
                 j1++, j2++)
 
                P[i2][j2] = C[i1][j1];
    }

    public static void main(String[] args)
    {
        System.out.println(
            "Multiplicação de matrizes utilizando o Método de Strassen:\n");

        Problema2 s = new Problema2();

        // Matriz A
        int[][] A = { { 1, 2, 3, 4 },
                      { 4, 3, 0, 1 },
                      { 5, 6, 1, 1 },
                      { 0, 2, 5, 6 } };

        // Matriz B
        int[][] B = { { 1, 0, 5, 1 },
                      { 1, 2, 0, 2 },
                      { 0, 3, 2, 3 },
                      { 1, 2, 1, 2 } };
 
        // Matrix C computations
 
        // Matrix C calling method to get Result
        int[][] C = s.multiply(A, B);
        
        // Captura a ordem(tamanho) da matriz
        int N = C.length;

        System.out.println(
            "O resultado das multiplicação das matrizes A e B é:");

        // loop das linhas da matriz
        for (int i = 0; i < N; i++) {
            // loop das colunas da matriz
            for (int j = 0; j < N; j++)

                // Escreve no terminal a matriz resultante da multiplicação
                if (C[i][j] < 10) {
                    if (j == 0) {
                        System.out.print("{ ");
                    }
                    System.out.print(" " + C[i][j] + " ");

                    if (j == N - 1) {
                        if (i == N -1 ) {
                            System.out.print("}");
                        } else {
                        System.out.print("},");
                        }
                    }
                } else {
                    if (j == 0) {
                        System.out.print("{ ");
                    }
                    System.out.print(C[i][j] + " ");

                    if (j == N - 1) {
                        if (i == N -1 ) {
                            System.out.print("}");
                        } else {
                        System.out.print("},");
                        }
                    }
                }

            // nova linha para imprimir a próxima linha da matriz
            System.out.println();
        }
    }
}