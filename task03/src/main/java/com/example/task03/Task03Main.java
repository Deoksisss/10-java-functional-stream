package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    record MinMax<T>(T min, T max) {}

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        var result = stream.collect(
                Collectors.teeing(
                        Collectors.minBy(order),
                        Collectors.maxBy(order),
                        (minOpt, maxOpt) -> new MinMax<>(minOpt.orElse(null), maxOpt.orElse(null))
                )
        );

        minMaxConsumer.accept(result.min(), result.max());
    }
}
