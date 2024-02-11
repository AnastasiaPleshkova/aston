package ru.pleshkova;

public interface MyList<T> {

    void add(T elenemt);

    T get(int index);

    T remove(int index);

    void addAll(MyList<? extends T> listToAdd);

    int getLength();

    void set(T elenemt, int index);
}
