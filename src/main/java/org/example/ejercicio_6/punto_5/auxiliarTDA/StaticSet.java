package org.example.ejercicio_6.punto_5.auxiliarTDA;

import java.util.Random;

public class StaticSet implements ISet{

    private static final int MAX = 10000;
    private int[] array;
    private int count;

    public StaticSet(){
        this.array = new int[MAX];
        this.count = 0;
    }
    @Override
    public void add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++){
            if (array[i] == a){return;}
        }
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove(int a) {
        if (isEmpty()){
            throw new RuntimeException("No se pueden remover elementos de un set vacio");
        }
        for (int i = 0; i < count; i++){
            if (array[i] == a){
                array[i] = array[count-1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() { return count == 0; }

    @Override
    public int choose() {
        if (isEmpty()){
            throw new RuntimeException("No se pueden elegir elementos de un set vacio");
        }
        return this.array[new Random().nextInt(this.count)];
    }
}
