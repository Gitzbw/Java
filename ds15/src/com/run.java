package com;

import java.nio.charset.StandardCharsets;
import java.util.*;

@SuppressWarnings({"all"})

public class run {
    public static void main(String[] args) {
//        int[] arr = {13,7,8,3,29,6,1};
//        Node huffmanTree = createHuffmanTree(arr);
        String content = "i like like like java do you like a java";
        byte[] bytes = content.getBytes();
        Node huffmanTree = createHuffmanTree(bytes);
        huffmanTree.preOrder();
    }


    public static Node createHuffmanTree(byte[] bytes)//返回HuffmanTree的根结点
    {
        List<Node> nodes = getList(bytes);
        Collections.sort(nodes);//排序
        while(nodes.size() > 1)//处理到最后 数组列表中应该只剩下一个结点
        {
            Node leftNode = nodes.get(0);//获取左结点
            Node rightNode = nodes.get(1);//获取右结点
            Node parentNode = new Node(null,leftNode.weight + rightNode.weight);//构造父结点
            parentNode.left = leftNode;//构造二叉树
            parentNode.right = rightNode;//构造二叉树
            nodes.remove(leftNode);//从数组列表中删除左结点
            nodes.remove(rightNode);//从数组列表中删除右结点
            nodes.add(parentNode);//向数组列表中添加父结点
            Collections.sort(nodes);//排序
        }
        return nodes.get(0);
    }

//    public static Node createHuffmanTree(int[] arr)//返回HuffmanTree的根结点
//    {
//        ArrayList<Node> nodes = new ArrayList<>();//创建数组列表 把arr数组中的值转换为结点存储
//        for (int i = 0; i < arr.length; i++) {
//            nodes.add(new Node(arr[i]));
//        }
//        Collections.sort(nodes);//排序
//        while(nodes.size() > 1)//处理到最后 数组列表中应该只剩下一个结点
//        {
//            Node leftNode = nodes.get(0);//获取左结点
//            Node rightNode = nodes.get(1);//获取右结点
//            Node parentNode = new Node(leftNode.val + rightNode.val);//构造父结点
//            parentNode.left = leftNode;//构造二叉树
//            parentNode.right = rightNode;//构造二叉树
//            nodes.remove(leftNode);//从数组列表中删除左结点
//            nodes.remove(rightNode);//从数组列表中删除右结点
//            nodes.add(parentNode);//向数组列表中添加父结点
//            Collections.sort(nodes);//排序
//        }
//        return nodes.get(0);
//    }

    public static List<Node> getList(byte[] bytes)//该方法用来构造一个数组列表 存放字符串对应字节数组的结点
    {
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<Byte,Integer> counts = new HashMap<>();//利用HashMap统计各个字符出现的次数
        for (Byte b : bytes) {
            Integer count = counts.get(b);//获取字符出现的次数
            if(count == null)//这里处理的是第一次的情况
            {
                counts.put(b,1);
            }
            else
            {
                counts.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry :counts.entrySet()) {//遍历HashMap 将元素放入数组列表中
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

}


class Node implements Comparable<Node>//为了能方便的排序 需要实现Comparable接口
{
    Byte data;//数据域 存放字符的ASCII码值
    int weight;//结点权值 表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public void preOrder()
    {
        System.out.println(this.data);
        if(this.left != null)
        {
            this.left.preOrder();
        }
        if(this.right != null)
        {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node node) {
        return this.weight - node.weight;//表示从小到大排
    }
}


//class Node implements Comparable<Node>//为了能方便的排序 需要实现Comparable接口
//{
//    int val;//结点权值
//    Node left;
//    Node right;
//
//    public Node(int val) {
//        this.val = val;
//    }
//
//    public void preOrder()
//    {
//        System.out.println(this.val);
//        if(this.left != null)
//        {
//            this.left.preOrder();
//        }
//        if(this.right != null)
//        {
//            this.right.preOrder();
//        }
//    }
//
//    @Override
//    public int compareTo(Node node) {
//        return this.val - node.val;//表示从小到大排
//    }
//}


