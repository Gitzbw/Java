package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author
 */
public class run {
    public static void main(String[] args) {
       Collection col = new ArrayList();
       col.add(new Book("红楼梦",30));
       col.add(new Book("水浒传",30));
        Iterator iterator = col.iterator();
        System.out.println("第一次遍历");
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        iterator = col.iterator();
        System.out.println("第二次遍历");
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}

class Book
{
    public String name;
    public int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
