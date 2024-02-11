package ru.pleshkova;

public class MyCollection {

    static void bubbleSort(MyList<Integer> listToSort) {
        for (int i = listToSort.getLength(); i > 0; i--) {
            if (isSorted(listToSort, listToSort.getLength())) {
                return;
            }
            int maxIndex = 0;
            Integer maxValue = listToSort.get(0);
            for (int j = 0; j < i; j++) {
                if (maxValue < listToSort.get(j)) {
                    maxValue = listToSort.get(j);
                    maxIndex = j;
                }
            }
            swap(listToSort, maxIndex, i - 1);
        }
    }

    private static void swap(MyList<Integer> listToSort, int j, int i) {
        if (i != j) {
            int temp = listToSort.get(j);
            listToSort.set(listToSort.get(i), j);
            listToSort.set(temp, i);
        }
    }

    private static boolean isSorted(MyList<Integer> listToSort, int length) {
        if (length == 1 || length == 0) {
            return true;
        }
        if (length == 2) {
            return listToSort.get(0) < listToSort.get(1);
        }
        return (listToSort.get(length - 1) > listToSort.get(length - 2)) && isSorted(listToSort, length - 1);
    }

}
