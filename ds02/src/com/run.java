package com;

import java.util.Arrays;
import java.util.Stack;

public class run {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(new Node(1));
//        singleLinkedList.add(new Node(2));
//        singleLinkedList.add(new Node(3));
//        singleLinkedList.add(new Node(4));
//        singleLinkedList.showList();
//        singleLinkedList.addByOrder(new Node(1));
//        singleLinkedList.addByOrder(new Node(3));
//        singleLinkedList.addByOrder(new Node(2));
//        singleLinkedList.addByOrder(new Node(4));
//        singleLinkedList.addByOrder(new Node(5));
//        singleLinkedList.addByOrder(new Node(2));
//        singleLinkedList.addByOrder(new Node(3));
//        singleLinkedList.showList();
//        System.out.println("-----------------");
//        singleLinkedList.remove(5);
//        singleLinkedList.showList();
//        singleLinkedList.remove(4);
//        System.out.println("-----------------");
//        singleLinkedList.showList();
//        System.out.println("-----------------");
//        singleLinkedList.remove(1);
//        singleLinkedList.showList();
//        System.out.println("-----------------");
//        System.out.println(SingleLinkedList.getLength(singleLinkedList.getHead()));
//        System.out.println(SingleLinkedList.getLength(new Node(0)));
//        System.out.println("-----------------");
//        System.out.println(SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),1).data);
//        System.out.println(SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),2).data);
//        System.out.println(SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),3).data);
//        System.out.println(SingleLinkedList.findLastIndexNode(new Node(0),1));
        singleLinkedList.addByOrder(new Node(1));
        singleLinkedList.addByOrder(new Node(2));
        singleLinkedList.addByOrder(new Node(3));
        singleLinkedList.addByOrder(new Node(4));
        singleLinkedList.addByOrder(new Node(5));
        singleLinkedList.showList();
        System.out.println("-------------------------");
        //SingleLinkedList.reverseList(singleLinkedList.getHead());
        //singleLinkedList.showList();
        SingleLinkedList.reversePrint(singleLinkedList.getHead());


    }
}

class Node
{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

//class SingleLinkedList
//{
//    Node head = new Node(0);
//
//    public void add(Node node)//尾插
//    {
//        Node tmp = head;
//        while (tmp.next != null)
//        {
//            tmp = tmp.next;
//        }
//        tmp.next = node;
//    }
//
//    public void addByOrder(Node node)
//    {
//        int data = node.data;
//        Node tmp = head;
//        while(tmp.next != null && data > tmp.next.data)
//        {
//            tmp = tmp.next;
//        }
//        node.next = tmp.next;
//        tmp.next = node;
//    }
//
//    public void remove(int data)
//    {
//        Node tmp = head;
//        while (tmp.next != null && tmp.next.data != data)
//        {
//            tmp = tmp.next;
//        }
//        if(tmp.next == null)
//        {
//            System.out.println("要删除的结点不存在");
//            return;
//        }
//        tmp.next = tmp.next.next;
//    }
//
//    public void showList()
//    {
//        if(head.next == null)
//        {
//            System.out.println("链表为空");
//            return;
//        }
//        Node tmp = head;
//        while(tmp.next != null)
//        {
//            tmp = tmp.next;
//            System.out.println(tmp.data);
//        }
//    }
//
//
//}


class SingleLinkedList
{
    private Node head = new Node(0);

    public Node getHead() {
        return head;
    }

    public void add(Node node)//尾插
    {
        Node tmp = head;
        while (true)
        {
            if(tmp.next == null)
            {
                tmp.next = node;
                return;
            }
            tmp = tmp.next;
        }

    }

    public void addByOrder(Node node)
    {
        int data = node.data;
        Node tmp = head;
        while(true)
        {
            if(tmp.next == null)
            {
                tmp.next = node;
                return;
            }
            if(data > tmp.next.data)
            {
                tmp = tmp.next;
            }
            else
            {
                node.next = tmp.next;
                tmp.next = node;
                return;
            }
        }

    }

    public void remove(int data)
    {
        Node tmp = head;
        while (true)
        {
            if(tmp.next == null)
            {
                System.out.println("要删除的结点不存在");
                return;
            }
            if(tmp.next.data == data)
            {
                tmp.next = tmp.next.next;
                return;
            }
            else
            {
                tmp = tmp.next;
            }
        }
    }

    public void showList()
    {
        Node tmp = head;
        if(tmp.next == null)
        {
            System.out.println("链表为空");
        }
        while(true)
        {
            if(tmp.next == null)
            {
                return;
            }
            System.out.println(tmp.next.data);
            tmp = tmp.next;
        }
    }

    public static int getLength(Node head)
    {
        Node tmp = head;
        int count = 0;
        while(tmp.next != null)
        {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public static Node findLastIndexNode(Node head,int index)
    {
        int length = getLength(head);
        if(index<=0 || index > length)
        {
            System.out.println("index超出范围");
            return null;
        }
        if(length == 0)
        {
            System.out.println("链表为空");
            return null;
        }
        Node tmp = head;
        for(int i=0;i<length-index+1;i++)
        {
            tmp = tmp.next;
        }
        return tmp;
    }

    public static void reverseList(Node head)
    {
        //空链表和只有一个元素的链表不需要翻转
        if(head.next == null || head.next.next == null)
        {
            return;
        }
        Node reverseHead = new Node(0);//定义一个反转头结点 将参数结点以头插的方式接在反转头结点后 实现反转
        Node tmp = head.next;
        Node next = null;//定义一个辅助结点 用来保存tmp结点后面的一个结点
        while(tmp != null)
        {
            next = tmp.next;//保存tmp的下一个结点
            tmp.next = reverseHead.next;
            reverseHead.next = tmp;
            tmp = next;
        }
        head.next = reverseHead.next;//最后把反转头结点的next域赋给参数头结点
    }

    public static void reversePrint(Node head)
    {
        if(head.next == null)
        {
            System.out.println("栈为空");
            return;
        }
        Node tmp = head.next;
        Stack<Node> nodes = new Stack<>();
        while(tmp != null)
        {
            nodes.push(tmp);
            tmp = tmp.next;
        }
        while(nodes.size() > 0)
        {
            System.out.println(nodes.pop().data);
        }
    }


}
