package org.example.ejercicio_6.punto_5;

import org.example.ejercicio_6.punto_5.auxiliarTDA.ISet;
import org.example.ejercicio_6.punto_5.auxiliarTDA.ISimpleDictionary;
import org.example.ejercicio_6.punto_5.auxiliarTDA.StaticDictionary;

public class Graph implements IGraph{
    private static final int MAX_Nodes = 10;

    private float[][] adjacencyMatrix;
    private ISimpleDictionary dictionary;
    private int totalNodes;
    @Override
    public void inicializarGrafo() {
        this.adjacencyMatrix = new float[MAX_Nodes][MAX_Nodes];
        this.dictionary = new StaticDictionary();
        this.totalNodes = 0;
    }

    @Override
    public void agregarVertice(int v) {
        if(this.totalNodes == 0){
            this.dictionary.add(v, this.totalNodes);
            this.totalNodes++;
            return;
        }
        ISet nodes = this.dictionary.getKeys();
        while(!nodes.isEmpty()){
            int current = nodes.choose();
            if (current == v){
                throw new RuntimeException("El nodo ya existe");
            }
            nodes.remove(current);
        }
        this.dictionary.add(v, this.totalNodes);
        this.totalNodes++;
    }

    @Override
    public void removerVertice(int v) {
        if (dictionary.get(v) != totalNodes-1){
            for (int i=0; i < totalNodes; i++){
                this.adjacencyMatrix[dictionary.get(v)][i] = this.adjacencyMatrix[totalNodes-1][i];
                this.adjacencyMatrix[i][dictionary.get(v)] = this.adjacencyMatrix[i][totalNodes-1];
            }
            this.dictionary.remove(v);
            this.totalNodes--;
            return;
        }

        this.dictionary.remove(v);
        this.totalNodes--;
    }

    @Override
    public ISet vertices() {
        return dictionary.getKeys();
    }

    @Override
    public void agregarArista(int v1, int v2, float probabilidad) {
        float total = probabilidad;
        for (int i=0; i<totalNodes; i++){
            total += this.adjacencyMatrix[this.dictionary.get(v2)][i];
        }
        if (total > 1){ //Reviso que la probabilidad que llega a un nodo sea menor a 1.
            throw new RuntimeException("La probabilidad total no puede ser superior a 1");
        }

        this.adjacencyMatrix[this.dictionary.get(v1)][this.dictionary.get(v2)] = probabilidad;
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        this.adjacencyMatrix[this.dictionary.get(v1)][this.dictionary.get(v2)] = 0;
    }

    @Override
    public boolean existeArista(int v1, int v2) {
        return this.probabilidadArista(v1, v2) != 0;
    }

    @Override
    public float probabilidadArista(int v1, int v2) {
        return this.adjacencyMatrix[this.dictionary.get(v1)][this.dictionary.get(v2)];
    }
}
