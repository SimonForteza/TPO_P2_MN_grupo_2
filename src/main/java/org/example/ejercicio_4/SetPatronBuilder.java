package org.example.ejercicio_4;

import java.util.Random;

public class SetPatronBuilder implements ISetPB{
    private static final int MAX = 10000;
    private int[] array;
    private int count;

    public SetPatronBuilder(){
        this.array = new int[MAX];
        this.count = 0;
    }
    @Override
    public SetPatronBuilder add(int a) {
        if(count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++){
            if (array[i] == a){return this;}
        }
        this.array[count] = a;
        this.count++;
        return this;
    }

    public SetPatronBuilder addAll(ISetPB set){
        ISetPB aux = new SetPatronBuilder();
        while (!set.isEmpty()){
            int value = set.choose();
            this.array[count] = value;
            this.count++;
            aux.add(value);
            set.remove(value);
        }

        while (!aux.isEmpty()){
            int value = aux.choose();
            set.add(value);
            aux.remove(value);
        }
        return this;
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
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int choose() {
        if (isEmpty()){
            throw new RuntimeException("No se pueden elegir elementos de un set vacio");
        }
        return this.array[new Random().nextInt(this.count)];
    }
}
