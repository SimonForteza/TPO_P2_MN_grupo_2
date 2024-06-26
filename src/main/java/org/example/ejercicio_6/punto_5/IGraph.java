package org.example.ejercicio_6.punto_5;

import org.example.ejercicio_6.punto_5.auxiliarTDA.ISet;

public interface IGraph {
    void inicializarGrafo();
    void agregarVertice(int v);
    void removerVertice(int v);
    ISet vertices();
    void agregarArista(int v1, int v2, float probabilidad);
    void eliminarArista(int v1, int v2);
    boolean existeArista(int v1, int v2);
    float probabilidadArista(int v1, int v2);

}
