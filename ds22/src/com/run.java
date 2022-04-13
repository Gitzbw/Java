package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings({"all"})

public class run {
    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("abc");
//        trie.insert("acd");
//        System.out.println(trie.search("abc"));
//        System.out.println(trie.search("ab"));
//        greedyAlgorithm();
//        minTree minTree = new minTree(new Graph());
//        minTree.Prim(0);
    }

    public static void greedyAlgorithm()
    {
        HashMap<String, HashSet<String>> broadCasts = new HashMap<>();//创建广播电台集合
        //创建电台并加入到电台集合中
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadCasts.put("K1", hashSet1);
        broadCasts.put("K2", hashSet2);
        broadCasts.put("K3", hashSet3);
        broadCasts.put("K4", hashSet4);
        broadCasts.put("K5", hashSet5);
        HashSet<String> allAreas = new HashSet<String>();//存放所有要覆盖区域的集合
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        ArrayList<String> selects = new ArrayList<String>();//用来存放选择的电台集合
        HashSet<String> tempSet = new HashSet<String>();//该集合用来存放遍历广播电台能覆盖的区域和当前未被覆盖区域的交集
        String maxKey = null;//定义maxKey 保存在一次遍历过程中 能够覆盖最大未覆盖的地区对应的电台的key 如果maxKey不为空 则会加入到selects
        int maxTemp = 0;//该变量用来保存临时集合的大小
        while(allAreas.size() > 0)
        {
            maxKey = null;
            maxTemp = 0;
            for(String key : broadCasts.keySet())
            {
                tempSet.clear();//清除临时集合 避免影响下面的操作
                HashSet<String> areas = broadCasts.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);//调用retainAll方法能使tempSet被赋值为tempSet和allAreas的交集
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > maxTemp)){
                    maxKey = key;
                    maxTemp = tempSet.size();
                }
            }
            if(maxKey != null)
            {
                selects.add(maxKey);
                allAreas.removeAll(broadCasts.get(maxKey));
                broadCasts.remove(maxKey);
            }
        }
        System.out.println("得到的选择结果是" + selects);
    }

}


@SuppressWarnings({"all"})

class minTree
{
    private Graph graph;

    public minTree(Graph graph) {
        this.graph = graph;
    }

    public void Prim(int index)//传入的参数代表从第几个顶点(从0开始)开始构造最小生成树
    {
        int[][] edges = graph.edges;
        ArrayList<String> vertexList = graph.vertexList;
        boolean[] isVisited = new boolean[edges.length];
        isVisited[index] = true;//把传入结点标记为已访问
        int v1 = -1;//该变量用于记录目前已访问过的顶点的索引
        int v2 = -1;//该变量用于记录目前将要访问的顶点的索引
        int minWeight = Integer.MAX_VALUE;//记录最小路径长
        for (int k = 0; k < edges.length-1; k++) {//最小生成树的边是顶点数减一
            //第一层遍历已经访问过的顶点 第二层访问未访问过的顶点 结合内层if语句理解 借助这两层for循环找到最短路径
            for (int i = 0; i < edges.length; i++) {
                for (int j = 0; j < edges.length; j++) {
                    if(isVisited[i] && !isVisited[j] && edges[i][j] < minWeight)
                    {
                        minWeight = edges[i][j];
                        v1 = i;
                        v2 = j;
                    }
                }
            }
            //退出双层for循环就代表已经找到最小路径了
            System.out.println("在" + vertexList.get(v1) + "和" + vertexList.get(v2) + "间造路" + " 路径长: " + minWeight);
            isVisited[v2] = true;//把v2标记为已访问
            minWeight = Integer.MAX_VALUE;//重置minWeight
        }
    }
}


@SuppressWarnings({"all"})

class Graph
{
    ArrayList<String> vertexList;//该集合用来存放顶点
    int[][] edges;//该数组就是图对应的邻接矩阵

    public Graph() {
        vertexList = new ArrayList(7);
        vertexList.add("A");
        vertexList.add("B");
        vertexList.add("C");
        vertexList.add("D");
        vertexList.add("E");
        vertexList.add("F");
        vertexList.add("G");
        edges = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000, 10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
    }
}



@SuppressWarnings({"all"})

class Disjoint_Sets
{
    int[] parent;//父亲数组的含义: 例如parent[1] = 2 代表1的父结点是2

    public Disjoint_Sets(int n) {//在构造器中完成父亲数组的初始化
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public void find()//查找
    {

    }

    public void union()//合并
    {

    }
}



@SuppressWarnings({"all"})

class Trie
{
    Node root = new Node();//根节点不储存data

    public void insert(String str)
    {
        char[] ch = str.toCharArray();
        Node tmp = root;
        for (int i = 0; i < ch.length; i++) {
            int index = ch[i] - 'a';//得到索引值
            if(tmp.children[index] == null)
            {
                tmp.children[index] = new Node(ch[i]);
            }
            tmp = tmp.children[index];
        }
        tmp.isEnd = true;
    }

    public boolean search(String str)
    {
        char[] ch = str.toCharArray();
        Node tmp = root;
        for (int i = 0; i < ch.length; i++) {
            int index = ch[i] - 'a';//得到索引值
            if(tmp.children[index] == null)
            {
               return false;
            }
            tmp = tmp.children[index];
        }
        if(tmp.isEnd == false)
        {
            return false;
        }
        return true;
    }
}



@SuppressWarnings({"all"})

class Node
{
    char data;//用于存储字符
    Node[] children = new Node[26];//定义数组存储孩子结点
    boolean isEnd;//结束标志

    public Node() {//便于创建不存储字符的根节点
    }

    public Node(char data) {
        this.data = data;
    }
}
