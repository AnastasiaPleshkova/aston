package ru.pleshkova;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private int size = 10;
    private int length;
    private T[] array;

    public MyArrayList() {
        array = (T[]) new Object[size];
    }

    public MyArrayList(MyList<? extends T> list) {
        array = (T[]) new Object[size];
        addAll(list);
    }

    @Override
    public void add(T elenemt) {
        if (length == size) {
            expand();
        }
        array[length] = elenemt;
        length++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    public void setAndMove(T elenemt, int index) {
        if (length >= size) {
            expand();
        }
        T prev;
        T cur = elenemt;
        for (int i = index; i < length; i++) {
            prev = array[i];
            array[i] = cur;
            cur = prev;
        }
        length++;
    }

    public void set(T elenemt, int index) {
        array[index] = elenemt;
    }

    @Override
    public T remove(int index) {
        T element = array[index];
        for (int i = index; i < length - 1; ) {
            array[i] = array[++i];
        }
        length--;
        return element;
    }

    @Override
    public void addAll(MyList<? extends T> listToAdd) {
        while (size < listToAdd.getLength()) {
            expand();
        }
        int counter = length;
        for (int i = 0; i < listToAdd.getLength(); i++) {
            array[counter + i] = listToAdd.get(i);
        }
        length += listToAdd.getLength();
    }

    private void expand() {
        size = size * 3 / 2;
        T[] copyArray = (T[]) new Object[size];
        for (int i = 0; i < length; i++) {
            copyArray[i] = array[i];
        }
        array = copyArray;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "size=" + size +
                ", length=" + length +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
