public class Problema1 {

    public static void main(String[] args) {
        String[] S = {"buy Amazon", "buy Google", "buy Apple", "buy Google", "buy Google", "buy NVIDIA"};
        String[] S_line = {"buy Google", "buy Apple", "buy Google", "buy NVIDIA"};

        System.out.println(hasTrend(S, S_line));
    }

    public static boolean hasTrend(String[] S, String[] S_line) {
        int m =  S_line.length;
        int n =  S.length;
        int j = 0, i = 0;

        /*
         * i -> S <- n
         * j -> S_line <- m
         * O loop vai percorrer os arrays e incrementar o j toda vez que ele encontra
         * um item no array S-line igual no array S, e a cada roda ele incrementa o i
         * se o valor de j for igual o valor do tamanho do array S_line, ele encontrou
         * tooos os elementos de S em S_line
         */
        while(j < m && i < n) { 
            if(S[i] == S_line[j]) {
                j++;
            }
            i++;
        }

        // retorna o comparitivo de se o número de itens achado é igual ao tamanhao de S_line
        return m == j;
    }
}