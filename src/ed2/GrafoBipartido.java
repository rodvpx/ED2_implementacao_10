package Implements10;

import java.util.List;
import java.util.ArrayList;

public class GrafoBipartido {
    private List<List<Aresta>> verticesProfessores;
    private List<List<Aresta>> verticesDisciplinas;
    private String[] nomesProfessores;
    private String[] nomesDisciplinas;

    public GrafoBipartido(int numProfessores, int numDisciplinas, String[] nomesProfessores,
            String[] nomesDisciplinas) {
        this.nomesProfessores = nomesProfessores;
        this.nomesDisciplinas = nomesDisciplinas;
        this.verticesProfessores = new ArrayList<>();
        this.verticesDisciplinas = new ArrayList<>();

        for (int i = 0; i < numProfessores; i++) {
            verticesProfessores.add(new ArrayList<>());
        }

        for (int i = 0; i < numDisciplinas; i++) {
            verticesDisciplinas.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int professor, int disciplina, int peso) {
        Aresta aresta = new Aresta(disciplina, peso);
        verticesProfessores.get(professor).add(aresta);

        aresta = new Aresta(professor, peso);
        verticesDisciplinas.get(disciplina).add(aresta);
    }

    public int[][] obterMatrizDeCusto() {
        int numProfessores = nomesProfessores.length;
        int numDisciplinas = nomesDisciplinas.length;
        int[][] custo = new int[numProfessores][numDisciplinas];

        // Preenche a matriz de custo com as preferências (pesos) dos professores pelas
        // disciplinas
        for (int i = 0; i < numProfessores; i++) {
            for (int j = 0; j < numDisciplinas; j++) {
                custo[i][j] = Integer.MAX_VALUE; // Inicializa com um valor alto (infinito)
                for (Aresta aresta : verticesProfessores.get(i)) {
                    if (aresta.getDestino() == j) {
                        custo[i][j] = aresta.getPeso(); // Preenche o peso de preferência
                    }
                }
            }
        }

        return custo;
    }

    public String obterNomeProfessor(int professor) {
        return nomesProfessores[professor];
    }

    public String obterNomeDisciplina(int disciplina) {
        return nomesDisciplinas[disciplina];
    }
}
