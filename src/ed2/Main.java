package ed2;

public class Main {
    public static void main(String[] args) {
        // Definindo os professores e disciplinas
        String[] professores = { "Cristiane", "Paulo", "Amaury", "Nattane", "Julio",
                "Jean", "Junio", "Lucas", "Gabriel" };

        String[] disciplinas = { "Programação II", "Engenharia de Software", "Lógica", "Sistemas Operacionais",
                "Metodologia Científica", "Estrutura de Dados II", "Redes de Computadores",
                "Banco de Dados II", "Programação Web I", "Álgebra Linear", "Intro. Mineração de Dados",
                "Programação Mobile", "Elaboração de Projetos", "Arquitetura de Software",
                "Marketing e Inovação" };

        // Criando o grafo bipartido com 9 professores e 15 disciplinas
        GrafoBipartido grafo = new GrafoBipartido(professores, disciplinas); // Professores e Disciplinas

        // Adicionando as preferências dos professores (pesos) de forma correta
        grafo.adicionarAresta(0, 0, 2); // Cristiane - Programação II
        grafo.adicionarAresta(0, 1, 4); // Cristiane - Engenharia de Software
        grafo.adicionarAresta(0, 2, 6); // Cristiane - Lógica

        grafo.adicionarAresta(1, 0, 1); // Paulo - Programação II
        grafo.adicionarAresta(1, 3, 3); // Paulo - Sistemas Operacionais
        grafo.adicionarAresta(1, 4, 5); // Paulo - Metodologia Científica

        grafo.adicionarAresta(2, 1, 2); // Amaury - Engenharia de Software
        grafo.adicionarAresta(2, 5, 1); // Amaury - Estrutura de Dados II
        grafo.adicionarAresta(2, 6, 4); // Amaury - Redes de Computadores

        grafo.adicionarAresta(3, 7, 3); // Nattane - Banco de Dados II
        grafo.adicionarAresta(3, 8, 2); // Nattane - Programação Web I

        grafo.adicionarAresta(4, 9, 4); // Julio - Álgebra Linear
        grafo.adicionarAresta(4, 10, 5); // Julio - Intro. Mineração de Dados

        grafo.adicionarAresta(5, 11, 2); // Jean - Programação Mobile
        grafo.adicionarAresta(5, 12, 3); // Jean - Elaboração de Projetos

        grafo.adicionarAresta(6, 13, 4); // Junio - Arquitetura de Software
        grafo.adicionarAresta(6, 14, 1); // Junio - Marketing e Inovação

        grafo.adicionarAresta(7, 0, 6); // Lucas - Programação II
        grafo.adicionarAresta(7, 9, 7); // Lucas - Álgebra Linear

        grafo.adicionarAresta(8, 11, 4); // Gabriel - Programação Mobile
        grafo.adicionarAresta(8, 8, 6); // Gabriel - Programação Web I

        // Obtendo a matriz de custos para o algoritmo Húngaro
        int[][] custo = grafo.obterMatrizDeCusto();

        // Aplicando o algoritmo Húngaro para encontrar a melhor alocação
        int maxPeso = 10;
        int[] atribuicoes = AlgoritmoHungaro.aplicarAlgoritmo(custo, maxPeso);

        // Exibindo o resultado
        System.out.println("Melhor correspondência (Professor -> Disciplina):");
        for (int i = 0; i < atribuicoes.length; i++) {
            if (atribuicoes[i] != -1) { // Verificando se houve atribuição válida
                System.out.println("Professor: " + grafo.obterNomeProfessor(atribuicoes[i]) + " -> Disciplina: "
                        + grafo.obterNomeDisciplina(i));
            } else {
                System.out.println("Não foi possível atribuir a disciplina " + grafo.obterNomeDisciplina(i));
            }
        }
    }
}
