package com;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class run {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);
        System.out.println(now.getMonth());
        System.out.println(now.getMonthValue());
        System.out.println(Instant.now());
        for (int i = 10; i > 0 ; i-- )
            System . out . println ("Counting down . . . " + i ) ;
        System . out . println (" B1 astoff!") ;
        int[] arr = {1,2,3,4,5,};

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
    }
}
