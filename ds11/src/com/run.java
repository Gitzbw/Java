package com;

import java.util.HashSet;

public class run {
    public static void main(String[] args) {
//        HashSet hashSet = new HashSet();
//        hashSet.add("1");
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.showList();
//        singleLinkedList.add(new Node(1));
//        singleLinkedList.add(new Node(2));
//        singleLinkedList.showList();
        HashTable hashTable = new HashTable(16);
        hashTable.add(new Node(0));
        hashTable.add(new Node(1));
        hashTable.add(new Node(2));
        hashTable.add(new Node(3));
        hashTable.add(new Node(16));
        hashTable.add(new Node(8));
        hashTable.showTable();
    }
}

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
    }
}

class SingleLinkedList
{
    Node head;

    public void add(Node node)//尾插
    {
        if(head == null)//如果头结点为null 直接把node赋给头结点
        {
            head = node;
            return;
        }
        Node tmp = head;
        while(tmp.next != null)
        {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public void showList(int num)
    {
        if(head == null)
        {
            System.out.println("第"+num+"条链表为空");
            return;
        }
        Node tmp = head;
        System.out.print("第" + num + "条链表 : ");
        while(tmp != null)
        {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

}

class HashTable
{
    int size;
    Node[] table;
    SingleLinkedList[] singleLinkedList;

    public HashTable(int size) {
        this.size = size;
        table = new Node[size];
        singleLinkedList = new SingleLinkedList[size];
        for (int i = 0; i < size; i++) {//初始化链表数组中的每条链表 不然会报空指针异常
            singleLinkedList[i] = new SingleLinkedList();
        }
    }

    public int hashFun(int data)//散列函数
    {
        return data%size;
    }

    public void add(Node node)
    {
        int index = hashFun(node.data);
        singleLinkedList[index].add(node);
        table[index] = singleLinkedList[index].head;//把头结点放入table中

    }

    public void showTable()
    {
        for (int i = 0; i < size; i++) {
            singleLinkedList[i].showList(hashFun(i));
        }
    }

}


