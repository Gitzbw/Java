package com;

import java.util.function.Consumer;

public class run {
    public static void main(String[] args) {
        test(10, (Integer x) -> System.out.println(x));
    }

    public static void test(int x, Consumer<Integer> consumer)
    {
        consumer.accept(x);
    }
}
