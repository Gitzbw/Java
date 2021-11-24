package com;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author
 */
public class run {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                return book1.getPrice()-book2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
