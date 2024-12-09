package Implements10;

public class Aresta {
    private int destino; // Vértice de destino (disciplina ou professor)
    private int peso; // Peso da aresta (preferência)

    // Construtor da aresta
    public Aresta(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    // Getters e Setters
    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}