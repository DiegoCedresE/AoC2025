package com.AoC.Diego.day8;

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

    public int find(int node) {

        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }

        return parent[node];
    }

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

    public int getSize(int node) {
        return size[find(node)];
    }

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