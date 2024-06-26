package org.example.ejercicio_6.punto_5.auxiliarTDA;

public class StaticDictionary implements ISimpleDictionary {

    private static final int MAX = 10000;

    private int[][] array;
    private int count;

    public StaticDictionary() {
        this.array = new int[MAX][2];
        this.count = 0;
    }

    @Override
    public void add(int k, int v) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for(int i = 0; i < count; i++) {
            if(this.array[i][0] == k) {
                return;
            }
        }
        this.array[count] = new int[2];
        this.array[count][0] = k;
        this.array[count][1] = v;
        this.count++;
    }

    @Override
    public void remove(int k) {
        for(int i = 0; i < count; i++) {
            if(this.array[i][0] == k) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
        throw new RuntimeException("No existe la clave");
    }

    @Override
    public StaticSet getKeys() {
        StaticSet set = new StaticSet();
        for(int i = 0; i < count; i++) {
            set.add(this.array[i][0]);
        }
        return set;
    }

    @Override
    public int get(int k) {
        for(int i = 0; i < count; i++) {
            if(this.array[i][0] == k) {
                return array[i][1];
            }
        }
        throw new RuntimeException("No existe un valor asociado a la clave");
    }

    public boolean isEmpty(){return this.count == 0;}
}
