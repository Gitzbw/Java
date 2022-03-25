package com;

public class run {
    public static void main(String[] args) {
//        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(new Node(1));
//        doubleLinkedList.add(new Node(2));
//        doubleLinkedList.add(new Node(3));
//        doubleLinkedList.add(new Node(4));
//        doubleLinkedList.add(new Node(5));
//        doubleLinkedList.addByOrder(new Node(1));
//        doubleLinkedList.addByOrder(new Node(2));
//        doubleLinkedList.addByOrder(new Node(3));
//        doubleLinkedList.addByOrder(new Node(5));
//        doubleLinkedList.addByOrder(new Node(4));
//        doubleLinkedList.showList();
//        System.out.println("--------------------");
        //doubleLinkedList.remove(6);
        //doubleLinkedList.remove(4);
//        doubleLinkedList.remove(5);
//        doubleLinkedList.remove(2);
//        doubleLinkedList.remove(1);
//        doubleLinkedList.showList();
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.showList();
        System.out.println("------------------------");
        CircleSingleLinkedList.josephuQusetion(circleSingleLinkedList.getFirst(),circleSingleLinkedList.getCur(),
                5,1,2);


    }
}

class Node
{
    public int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

@SuppressWarnings({"all"})
class CircleSingleLinkedList
{
    private Node first;
    private Node cur;//定义一个辅助结点 来指向 指向first的结点

    public Node getFirst() {
        return first;
    }

    public Node getCur() {
        return cur;
    }

    public void add(int num)
    {
        if(num < 1)
        {
            System.out.println("num值不正确");
            return;
        }
        for(int i=1;i<=num;i++)
        {
            Node node = new Node(i);
            if(i==1)
            {
                first = node;
                first.next = first;
                cur = first;
            }
            cur.next = node;
            node.next = first;
            cur = node;
        }
    }

    public void showList()
    {
        if(first == null)
        {
            System.out.println("环形链表为空");
            return;
        }
        Node tmp = first;
        while(tmp != cur)
        {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println(tmp.data);//打印cur指针的data域
    }

    public static void josephuQusetion(Node first,Node cur,int num,int start,int countNum)
    {
        if(first == null || start<1 || start>num)
        {
            System.out.println("传入的参数有误");//这里不再去验证传入的人数是否等于传入链表结点的个数
            return;
        }

        while(first.data != start)//该while循环的目的是使first指向开始报数的人
        {
            first = first.next;
        }
        while(true)
        {
            for(int i=0;i<countNum-1;i++)//该for循环用来找到出圈的人 并且调整cur的位置方便删除结点 -1是因为自己也要报数
            {
                first = first.next;
                cur = cur.next;
            }
            System.out.println(first.data);//出圈人报数
            first = first.next;
            cur.next = first;//完成出圈
            if(first == cur)//循环终止条件 只剩一个人时直接报数 终止循环
            {
                System.out.println("winner : "+first.data);//最后一个人报数
                break;
            }
        }
    }

}





































//class Node
//{
//    public int data;
//    Node pre;
//    Node next;
//
//    public Node(int data) {
//        this.data = data;
//    }
//}
//
//class DoubleLinkedList
//{
//    private Node head = new Node(0);
//
//    public Node getHead() {
//        return head;
//    }
//
//    public void add(Node node)//尾插 只需要添加两条线
//    {
//        Node tmp = head;
//        while(tmp.next != null)
//        {
//            tmp = tmp.next;
//        }
//        tmp.next = node;
//        node.pre = tmp;
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
//        if(tmp.next == null)
//        {
//            tmp.next = node;
//            node.pre = tmp;
//            return;
//        }
//        //下面删掉两条线 添加四条线
//        node.next = tmp.next;
//        tmp.next.pre = node;
//        node.pre = tmp;
//        tmp.next = node;
//    }
//
//    public void remove(int data)
//    {
//        Node tmp = head.next;
//        if(head == null)
//        {
//            System.out.println("双向链表为空");
//            return;
//        }
//        while(tmp != null && tmp.data != data)
//        {
//            tmp = tmp.next;
//        }
//        if(tmp == null)
//        {
//            System.out.println("想要删除的结点不存在");
//            return;
//        }
//        tmp.pre.next = tmp.next;
//        if(tmp.next != null)
//        {
//            tmp.next.pre = tmp.pre;//这句话是有风险的 如果这是最后一个结点 tmp.next会null 会发生空指针异常 所以需要判断一下
//        }
//    }
//
//    public void showList()
//    {
//        Node tmp = head.next;
//        if(tmp == null)
//        {
//            System.out.println("双向链表为空");
//            return;
//        }
//        while(tmp != null)
//        {
//            System.out.println(tmp.data);
//            tmp = tmp.next;
//        }
//    }
//}
