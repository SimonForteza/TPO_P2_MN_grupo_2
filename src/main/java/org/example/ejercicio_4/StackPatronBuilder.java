package org.example.ejercicio_4;

public class StackPatronBuilder implements IStackPB{
    private static final int MAX = 1000;

    private int[] array;
    private int count;

    public StackPatronBuilder(){
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public StackPatronBuilder add(int x) {
        if (this.count >= MAX){
            throw new RuntimeException("Limite Excedido");
        }
        this.array[this.count++] = x;
        return this;
    }

    @Override
    public void remove() {
        if (this.isEmpty()){
            throw new RuntimeException("Stack Vacio");
        }
        this.count --;
    }

    @Override
    public boolean isEmpty() {
        if (this.count == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()){
            throw new RuntimeException("Stack Vacio");
        }
        return this.array[this.count - 1];
    }

    public int acumulador(){
        int acumulador = 0;
        for (int i =0; i<count; i++){
            acumulador += this.array[i];
        }
        return acumulador;
    }
}
