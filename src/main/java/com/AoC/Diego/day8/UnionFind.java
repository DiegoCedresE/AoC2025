package com.AoC.Diego.day8;
/**
 * Implementa la estructura de datos Union-Find para gestionar
 * conjuntos disjuntos.
 */
public class UnionFind {
    private final int[] parent;
    private final int[] size;
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    /**
     * Obtiene el representante del conjunto al que pertenece un nodo.
     *
     * @param node nodo a consultar.
     * @return representante del conjunto.
     */
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
    /**
     * Une los conjuntos a los que pertenecen dos nodos.
     *
     * @param a primer nodo.
     * @param b segundo nodo.
     * @return {@code true} si los conjuntos se unieron; {@code false} si ya pertenecían al mismo conjunto.
     */
    public boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return false;
        }
        if (size[rootA] < size[rootB]) {
            int aux = rootA;
            rootA = rootB;
            rootB = aux;
        }
        parent[rootB] = rootA;
        size[rootA] += size[rootB];
        return true;
    }
    /**
     * Devuelve el tamaño del conjunto al que pertenece un nodo.
     *
     * @param node nodo del conjunto.
     * @return número de elementos del conjunto.
     */
    public int getSize(int node) {
        return size[find(node)];
    }
    /**
     * Calcula el número de conjuntos disjuntos existentes.
     *
     * @return número de conjuntos.
     */
    public int getNumberOfSets() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }
}