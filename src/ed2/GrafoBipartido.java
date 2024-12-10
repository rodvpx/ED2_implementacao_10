/*
 * Estrutura de Dados II - Junio Cesar - 4º Período Sistemas de Informação
 * Implementação 10
 * Alunos: Isabella, Luan, Rodrigo  */

package ed2;

import java.util.ArrayList;
import java.util.List;

public class GrafoBipartido {
    private List<List<Aresta>> verticesProfessores;
    private List<List<Aresta>> verticesDisciplinas;
    public String[] nomesProfessores;
    private String[] nomesDisciplinas;

    public GrafoBipartido(String[] nomesProfessores, String[] nomesDisciplinas) {
        // Duplicando os professores para igualar o número de disciplinas
        int numProfessores = nomesProfessores.length;
        int numDisciplinas = nomesDisciplinas.length;

        // Se houver mais disciplinas que professores, duplicamos os professores
        if (numDisciplinas > numProfessores) {
            List<String> listaProfessores = new ArrayList<>();
            for (int i = 0; i < numDisciplinas; i++) {
                listaProfessores.add(nomesProfessores[i % numProfessores]);
            }
            this.nomesProfessores = listaProfessores.toArray(new String[0]);
        } else {
            this.nomesProfessores = nomesProfessores;
        }

        this.nomesDisciplinas = nomesDisciplinas;
        this.verticesProfessores = new ArrayList<>();
        this.verticesDisciplinas = new ArrayList<>();

        for (int i = 0; i < this.nomesProfessores.length; i++) {
            verticesProfessores.add(new ArrayList<>());
        }

        for (int i = 0; i < this.nomesDisciplinas.length; i++) {
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
