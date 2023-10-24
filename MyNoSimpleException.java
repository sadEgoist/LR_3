package org.example.Errors;
public class MyNoSimpleException extends RuntimeException{
    private int i;
    private int j;
    private  String s;
    public MyNoSimpleException(int i, int j, String s){
        super("Найден элемент, соответствующий условию задания: '" + s + "' Номер ячейки: " + (i+1) + " x " + (j+1));
        this.i = i;
        this.j = j;
        this.s = s;
    }
}