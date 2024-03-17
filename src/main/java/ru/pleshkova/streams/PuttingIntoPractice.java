package ru.pleshkova.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> list2011 = transactions.stream()
                .filter(x -> x.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).toList();

        //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> town = transactions.stream()
                .map(x-> x.getTrader().getCity()).distinct().toList();

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> kembrTraders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName)).toList();

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String names = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct().sorted()
                .collect(Collectors.joining(", "));

        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean hasMilanTraider = transactions.stream()
                .anyMatch(x->x.getTrader().getCity().equals("Milan"));

        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        int sumCambridge = transactions.stream()
                        .filter(x->x.getTrader().getCity().equals("Cambridge"))
                                .mapToInt(Transaction::getValue).sum();

        // 7. Какова максимальная сумма среди всех транзакций?
        int maxValue = transactions.stream()
                .mapToInt(Transaction::getValue).max().getAsInt();

        // 8. Найти транзакцию с минимальной суммой.
        int minValue = transactions.stream()
                .mapToInt(Transaction::getValue).min().getAsInt();

    }

}
