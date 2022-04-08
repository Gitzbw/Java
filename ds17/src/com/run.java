package com;

import java.util.*;

@SuppressWarnings({"all"})

public class run {
    public static void main(String[] args) {
        //String content = "i like like like java do you like a java";
//        String content = "hello world!!!";
//        huffmanTree huffmanTree = new huffmanTree(content);
        //System.out.println(huffmanTree.getCodes());
        //System.out.println(Arrays.toString(huffmanTree.zip()));
        //System.out.println(huffmanTree.byteToBitString(false,(byte)01));
//        byte[] zip = huffmanTree.zip();
//        System.out.println(new String(huffmanTree.decode(huffmanTree.huffmanCodes,zip,huffmanTree.binaryStringLength)));
        int[] arr = {7,3,10,12,5,1,9,2};
        binarySortTree binarySortTree = new binarySortTree();
        for(int i =0;i<arr.length;i++)
        {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
//        System.out.println("------------------------");
//        binarySortTree.remove(12);
//        binarySortTree.infixOrder();

    }


}


@SuppressWarnings({"all"})

class binarySortTree
{
    Node root;

    public void remove(int value)
    {
        if(root == null)
        {
            return;
        }
        Node targetNode = search(value);
        if(targetNode == null)
        {
            return;
        }
        if(root.left == null && root.right == null)//只有根节点的情况
        {
            root = null;
            return;
        }
        Node ParentNode = searchParent(value);
        if(targetNode.left == null && targetNode.right == null)//叶子结点的情况
        {
            if(ParentNode.value > targetNode.value)
            {
                ParentNode.left = null;
            }
            else
            {
                ParentNode.right = null;
            }
        }
    }

    public Node search(int value)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return root.search(value);
        }
    }

    public Node searchParent(int value)
    {
        if(root == null)
        {
            return null;
        }
        else
        {
            return root.searchParent(value);
        }
    }

    public void add(Node node)
    {
        if(root == null)
        {
            root = node;
        }
        else
        {
            root.add(node);
        }
    }

    public void infixOrder()
    {
        if(root == null)
        {
            System.out.println("二叉排序树为空");
        }
        else
        {
            root.infixOrder();
        }
    }
}


@SuppressWarnings({"all"})

class Node
{
    int value;
    Node left;
    Node right;

    public Node search(int value)//该方法用于查找目标结点
    {
        if(this.value == value)
        {
            return this;
        }
        else if(this.value > value)
        {
            if(this.left == null)
            {
                return null;
            }
            return this.left.search(value);
        }
        else
        {
            if(this.right == null)
            {
                return null;
            }
            return this.right.search(value);
        }
    }

    public Node searchParent(int value)//该方法用于查找目标结点的父结点
    {
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value))
            {
                return this;
            }
        else
        {
            if(this.value > value && this.left != null)
            {
                return this.left.searchParent(value);
            }
            else if(this.value <= value && this.right != null)
            {
                return this.right.searchParent(value);
            }
            else
            {
                return null;
            }
        }

    }

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node)
    {
        if(node == null)
        {
            return;
        }
        if(this.value > node.value)
        {
            if(this.left == null)
            {
                this.left = node;
            }
            else
            {
                this.left.add(node);
            }
        }
        else
        {
            if(this.right == null)
            {
                this.right = node;
            }
            else
            {
                this.right.add(node);
            }
        }
    }

    public void infixOrder()
    {
        if(this.left != null)
        {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if(this.right != null)
        {
            this.right.infixOrder();
        }
    }
}


//@SuppressWarnings({"all"})
//
//class huffmanTree
//{
//    byte[] bytes;//该字节数组用来存放传入字符串的每个字符的ASCII码
//    static HashMap<Byte,String> huffmanCodes = new HashMap();//该集合用来存放赫夫曼编码表
//    static StringBuilder stringBuilder = new StringBuilder();//定义一个StringBuilder拼接路径 便于生成叶子叶子结点的赫夫曼编码
//    static int binaryStringLength;
//
//    public huffmanTree(String content) {
//        this.bytes = content.getBytes();
//    }
//
//    public byte[] decode(HashMap<Byte,String> huffmanCodes,byte[] zipBytes,int realLength)//返回原字符串对应的字节数组
//    {
//        //将压缩字节数组转换为二进制字符串
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < zipBytes.length; i++) {
//            //根据是不是字节数组的最后一个元素来设置flag
//            //如果传入的字节是zip得到的数组的最后一个数据 则flag为假 反之为真
//            boolean flag = !(i == zipBytes.length -1);
//            stringBuilder.append(byteToBitString(flag,zipBytes[i]));
//        }
//        //下面代码处理最后一个字节需要补0的情况
//        int length = stringBuilder.length();
//        if(length != realLength)//不相等说明需要补0
//        {
//            int num = realLength - length;//得到需要补0的个数
//            //将stringBuilder重置 重新赋值
//            stringBuilder = new StringBuilder();
//            for (int i = 0; i < zipBytes.length; i++) {
//                //根据是不是字节数组的最后一个元素来设置flag
//                //如果传入的字节是zip得到的数组的最后一个数据 则flag为假 反之为真
//                boolean flag = !(i == zipBytes.length -1);
//                if(!flag)//最后一位的情况 需要先补0 再追加
//                {
//                    for(int j = 0;j<num;j++)
//                    {
//                        stringBuilder.append("0");
//                    }
//                }
//                stringBuilder.append(byteToBitString(flag,zipBytes[i]));
//            }
//        }
//        //把得到的二进制字符串根据赫夫曼编码表还原成原来的字符串对应的字符数组
//        //因为要反向查询 所以要反转赫夫曼编码表(即反转key和value)
//        HashMap<String, Byte> reverse = new HashMap<>();
//        for(Map.Entry<Byte,String> entry : huffmanCodes.entrySet())
//        {
//            reverse.put(entry.getValue(),entry.getKey());
//        }
//        ArrayList<Byte> list = new ArrayList<>();//先定义一个集合 来存放得到的字节 直接定义字节数组 不能确定大小
//        for (int i = 0; i < stringBuilder.length(); ) {//对stringBuilder里的字符一个个扫描 用到滑动窗口的思想
//            int count = 1;//定义一个计数器
//            boolean flag = true;
//            Byte b = null;
//            while(flag)
//            {
//                String key = stringBuilder.substring(i,i+count);
//                b = reverse.get(key);
//                if(b == null)
//                {
//                    count++;
//                }
//                else
//                {
//                    flag = false;
//                }
//            }
//            list.add(b);//从while循环退出就代表找到了
//            i += count;
//        }
//        byte[] bytes = new byte[list.size()];
//        for (int i = 0; i < bytes.length; i++) {
//            bytes[i] = list.get(i);
//        }
//        return bytes;
//    }
//
//    public String byteToBitString(boolean flag,byte b)
//    {
//        int temp = b;//为了使用api(Integer.toBinaryString(int i))将b转换为二进制 我们先把b赋给一个int类型的临时变量
//        //存在几个问题
//        //1.api返回的二进制是按int类型的数据返回的 即返回的二进制最多可能有32位(负数) 而我们只需要8位 解决方法: 截取最后8位返回
//        //2.如果是较小的正数(比如1) 会舍去前面的0(如果是1就只会返回1 而不是0000 0001) 解决方法: 可以 |= 256(1 0000 0000)
//        //3.返回的字节字符串不一定是8位的 可能不满8位 解决方法: 设置flag变量进行控制(可以传入flag参数) flag为真表示需要补高位 为假表示不需要
//        //如果传入的字节是zip得到的数组的最后一个数据 则flag为假 反之为真
//        //4.这个问题下面代码也处理不了 zip得到的数组的最后一个数据如果不满8位(flag为假 不需要补0) 但它需要补0(比如00 01) 就会导致解压失败
//        //分析问题4 传入的参数(false,1(实际上是01 或者是001 但是会被编译器认为是1)) 得到的结果就是1 而不是01(001)
//        if(flag)//如果不是zip得到的数组的最后一个数据 正负数都可以进行|= 但最后一个数据不能补0
//        {
//            temp |= 256;
//        }
//        String s = Integer.toBinaryString(temp);
//        if(flag || temp < 0)//如果不是zip得到的数组的最后一个数据 返回截取的 当然负数肯定需要截取 哪怕是最后一个数据
//        {
//            return s.substring(s.length()-8);
//        }
//        else//如果是zip得到的数组的最后一个数据 直接返回(前提: 不是负数 负数需要截取 在上面的return语句返回)
//        {
//            return s;
//        }
//    }
//
//    public byte[] zip()//该方法返回压缩后的字符串对应的字节数组
//    {
//        HashMap<Byte, String> codes = getCodes();//获取每个字符的二进制字符串
//        //将待压缩的字符串中的每个字符都转换成二进制字符串
//        StringBuilder stringBuilder = new StringBuilder();
//        for (byte b : bytes) {
//            stringBuilder.append(huffmanCodes.get(b));
//        }
//        binaryStringLength = stringBuilder.length();
//        //计算字节数组的长度
//        int len;
//        if(stringBuilder.length() % 8 == 0)
//        {
//            len = stringBuilder.length() / 8;
//        }
//        else
//        {
//            len = stringBuilder.length() / 8 + 1;
//        }
//        //创建字节数组
//        byte[] bytes = new byte[len];
//        //8位一组转换成字节存储(要从补码转换成原码 原来的二进制字符串默认是补码) 我们可以直接调用api帮助我们转换
//        int index = 0;//记录字节数组的索引
//        for (int i = 0; i < stringBuilder.length(); i+=8)
//        {
//            if(i+8 > stringBuilder.length())//最后若不满8位 则全部截取
//            {
//                bytes[index++] = (byte)Integer.parseInt(stringBuilder.substring(i),2);
//            }
//            else
//            {
//                bytes[index++] = (byte)Integer.parseInt(stringBuilder.substring(i,i+8),2);
//            }
//        }
//        return bytes;
//    }
//
//    public HashMap<Byte,String> getCodes()
//    {
//        Node huffmanTreeRoot = createHuffmanTree();
//        huffmanTreeRoot.getCodes("",stringBuilder);
//        return huffmanCodes;
//    }
//
//    public Node createHuffmanTree()//返回HuffmanTree的根结点
//    {
//        List<Node> nodes = getList();
//        Collections.sort(nodes);//排序
//        while(nodes.size() > 1)//处理到最后 数组列表中应该只剩下一个结点
//        {
//            Node leftNode = nodes.get(0);//获取左结点
//            Node rightNode = nodes.get(1);//获取右结点
//            Node parentNode = new Node(null,leftNode.weight + rightNode.weight);//构造父结点
//            parentNode.left = leftNode;//构造二叉树
//            parentNode.right = rightNode;//构造二叉树
//            nodes.remove(leftNode);//从数组列表中删除左结点
//            nodes.remove(rightNode);//从数组列表中删除右结点
//            nodes.add(parentNode);//向数组列表中添加父结点
//            Collections.sort(nodes);//排序
//        }
//        return nodes.get(0);
//    }
//
//    public List<Node> getList()//该方法用来构造一个数组列表 存放字符串对应字节数组的结点
//    {
//        ArrayList<Node> nodes = new ArrayList<>();
//        HashMap<Byte,Integer> counts = new HashMap<>();//利用HashMap统计各个字符出现的次数
//        for (Byte b : bytes) {
//            Integer count = counts.get(b);//获取字符出现的次数
//            if(count == null)//这里处理的是第一次的情况
//            {
//                counts.put(b,1);
//            }
//            else
//            {
//                counts.put(b,count+1);
//            }
//        }
//        for (Map.Entry<Byte,Integer> entry :counts.entrySet()) {//遍历HashMap 将元素放入数组列表中
//            nodes.add(new Node(entry.getKey(),entry.getValue()));
//        }
//        return nodes;
//    }
//
//}
//
//
//@SuppressWarnings({"all"})
//
//class Node implements Comparable<Node>//为了能方便的排序 需要实现Comparable接口
//{
//    Byte data;//数据域 存放字符的ASCII码值
//    int weight;//结点权值 表示字符出现的次数
//    Node left;
//    Node right;
//
//    public void getCodes(String code,StringBuilder stringBuilder)
//    //该方法用来获取各个叶子结点的赫夫曼编码 并存放至HashMap中 我们规定往左子结点走的路径为0 往右子结点走的路径为1
//    //一开始传入的参数列表是("",stringbuilder) 隐参是root
//    {
//        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);//构造一个新的StringBuilder
//        //以下注释是上方代码StringBuilder走的构造器
//        //        public StringBuilder(CharSequence seq) {
//        //        this(seq.length() + 16);
//        //        append(seq);
//        //    }
//        stringBuilder2.append(code);//追加字符
//        if(this != null)//非空结点才处理
//        {
//            if(this.data == null)//非叶子结点继续递归
//            {
//                this.left.getCodes("0",stringBuilder2);//向左递归
//                this.right.getCodes("1",stringBuilder2);//向右递归
//            }
//            else//找到叶子结点 此时stringBuilder2中存储的就是该叶子结点的赫夫曼编码 放入HashMap中即可
//            {
//                huffmanTree.huffmanCodes.put(this.data,stringBuilder2.toString());
//            }
//        }
//    }
//
//    public Node(Byte data, int weight) {
//        this.data = data;
//        this.weight = weight;
//    }
//
//    public void preOrder()
//    {
//        System.out.println(this.data);
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
//        return this.weight - node.weight;//表示从小到大排
//    }
//}