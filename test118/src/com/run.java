package com;

import java.util.Optional;

public class run {
    public static void main(String[] args) {
        Optional<String> s = Optional.of("123");
        System.out.println(s.get());
    }
}
