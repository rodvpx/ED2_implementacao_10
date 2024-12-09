package ed2;

public class AlgoritmoHungaro {

    public static int[] aplicarAlgoritmo(int[][] custo, int maxPeso) {
        int n = custo.length;

        // Passo 1: Subtrair o menor valor de cada linha
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, custo[i][j]);
            }
            for (int j = 0; j < n; j++) {
                custo[i][j] -= min;
            }
        }

        // Passo 2: Subtrair o menor valor de cada coluna
        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, custo[i][j]);
            }
            for (int i = 0; i < n; i++) {
                custo[i][j] -= min;
            }
        }

        // Passo 3: Encontrar a alocação ótima (baseado nos zeros na matriz)
        int[] resultado = new int[n];
        boolean[] linhaCoberta = new boolean[n];
        boolean[] colunaCoberta = new boolean[n];
        boolean[] zeroMarcado = new boolean[n * n];

        // Inicializa com -1, indicando que a disciplina não foi atribuída
        for (int i = 0; i < n; i++) {
            resultado[i] = -1;
        }

        // Tentar fazer a alocação com base nos zeros encontrados
        boolean terminou = false;
        while (!terminou) {
            terminou = true;
            for (int i = 0; i < n; i++) {
                if (!linhaCoberta[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!colunaCoberta[j] && custo[i][j] == 0 && !zeroMarcado[i * n + j]) {
                            zeroMarcado[i * n + j] = true;
                            if (resultado[j] == -1) {
                                resultado[j] = i;
                                terminou = false; // Se encontrou uma correspondência, continuar tentando
                                break;
                            } else {
                                linhaCoberta[resultado[j]] = true;
                                colunaCoberta[j] = false;
                            }
                        }
                    }
                }
            }
        }

        // Se algum índice for -1, significa que a correspondência não foi encontrada
        for (int i = 0; i < n; i++) {
            if (resultado[i] == -1) {
                System.out.println("Não foi possível atribuir a disciplina " + i);
            }
        }

        return resultado;
    }
}