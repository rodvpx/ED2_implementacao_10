/*
 * Estrutura de Dados II - Junio Cesar - 4º Período Sistemas de Informação
 * Implementação 10
 * Alunos: Isabella, Luan, Rodrigo  */

package ed2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Definindo os professores e disciplinas
        String[] professores = {"Amaury", "Cristiane", "Gabriel", "Jean", "Julio", "Junio", "Lucas", "Nattane", "Paulo"};
        String[] disciplinas = {
                "Álgebra Linear", "Arquitetura de Software", "Banco de Dados II", "Elaboração de Projetos",
                "Engenharia de Software", "Estrutura de Dados II", "Intro. Mineração de Dados",
                "Lógica", "Marketing e Inovação", "Metodologia Científica", "Programação II",
                "Programação Mobile", "Programação Web I", "Redes de Computadores", "Sistemas Operacionais"
        };

        // Criando o grafo bipartido com 9 professores e 15 disciplinas
        GrafoBipartido grafo = new GrafoBipartido(professores, disciplinas);

        // Adicionando as preferências dos professores (pesos)
        grafo.adicionarAresta(0, 1, 2);  // Amaury - Arquitetura de Software
        grafo.adicionarAresta(0, 14, 1); // Amaury - Sistemas Operacionais

        grafo.adicionarAresta(1, 10, 1); // Cristiane - Programação II
        grafo.adicionarAresta(1, 2, 2);  // Cristiane - Banco de Dados II
        grafo.adicionarAresta(1, 6, 6);  // Cristiane - Intro. Mineração de Dados
        grafo.adicionarAresta(1, 11, 3); // Cristiane - Programação Mobile

        grafo.adicionarAresta(2, 3, 5);  // Gabriel - Elaboração de Projetos
        grafo.adicionarAresta(2, 4, 1);  // Gabriel - Engenharia de Software
        grafo.adicionarAresta(2, 13, 2); // Gabriel - Redes de Computadores

        grafo.adicionarAresta(3, 13, 0); // Jean - Redes de Computadores (menor peso)
        grafo.adicionarAresta(3, 9, 1);  // Jean - Metodologia Científica (menor peso)

        grafo.adicionarAresta(4, 7, 2);  // Julio - Lógica
        grafo.adicionarAresta(4, 8, 3);  // Julio - Marketing e Inovação

        grafo.adicionarAresta(5, 5, 1);  // Junio - Estrutura de Dados II
        grafo.adicionarAresta(5, 11, 3); // Junio - Programação Mobile
        grafo.adicionarAresta(5, 6, 6);  // Junio - Intro. Mineração de Dados

        grafo.adicionarAresta(6, 7, 6);  // Lucas - Lógica
        grafo.adicionarAresta(6, 0, 1);  // Lucas - Álgebra Linear

        grafo.adicionarAresta(7, 11, 6); // Nattane - Programação Mobile
        grafo.adicionarAresta(7, 12, 1); // Nattane - Programação Web I
        grafo.adicionarAresta(7, 9, 6);  // Nattane - Metodologia Científica

        grafo.adicionarAresta(8, 1, 5);  // Paulo - Arquitetura de Software
        grafo.adicionarAresta(8, 6, 2);  // Paulo - Intro. Mineração de Dados

        // Obtendo a matriz de custos para o algoritmo Húngaro
        int[][] custo = grafo.obterMatrizDeCusto();

        // Aplicando o algoritmo Húngaro para encontrar a melhor alocação
        int maxPeso = 10; // definindo o peso maximo (1 à 10)
        int[] atribuicoes = AlgoritmoHungaro.aplicarAlgoritmo(custo, maxPeso);

        // Criando uma lista para armazenar as correspondências (Professor -> Disciplina)
        List<String> correspondencias = new ArrayList<>();
        for (int i = 0; i < atribuicoes.length; i++) {
            if (atribuicoes[i] != -1) { // Verificando se houve atribuição válida
                correspondencias.add("Professor: " + grafo.obterNomeProfessor(atribuicoes[i]) + " -> Disciplina: "
                        + grafo.obterNomeDisciplina(i));
            } else {
                correspondencias.add("Não foi possível atribuir a disciplina " + grafo.obterNomeDisciplina(i));
            }
        }

        // Ordenando as correspondências por nome do professor em ordem alfabética
        Collections.sort(correspondencias);

        // Exibindo o resultado
        System.out.println("Melhor correspondência (Professor -> Disciplina):");
        for (String correspondencia : correspondencias) {
            System.out.println(correspondencia);
        }
    }
}
