package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class run {
    public static void main(String[] args) {
        minTree minTree = new minTree(new Graph());
        //EData[] edgesArray = minTree.getEdgesArray();
        //Arrays.sort(edgesArray);
        //System.out.println(Arrays.toString(edgesArray));
        minTree.Kruskal();
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

    public void Kruskal()
    {
        EData[] edgesArray = getEdgesArray();
        int index = 0;//该变量用来记录edgesArray的索引
        Arrays.sort(edgesArray);
        Disjoint_Sets disjoint_sets = new Disjoint_Sets(graph.edges.length);//构造并查集 用于解决问题二
        int start = edgesArray[index].startIndex;//记录边的起点索引
        int end = edgesArray[index].endIndex;//记录边的终点索引
        for (int i = 0; i < graph.edges.length - 1; i++) {//构造顶点减一条边
            while(disjoint_sets.find(start) == disjoint_sets.find(end))//边的两个顶点的祖先是同一个 构成回路 不能造
            {
                index++;
                start = edgesArray[index].startIndex;//给起点赋新值
                end = edgesArray[index].endIndex;//给终点赋新值
            }
            //退出while循环 说明边的两个顶点的祖先不是同一个 不会构成回路 可以造路
            disjoint_sets.union(start,end);
            System.out.println(edgesArray[index]);
        }
    }

//    public void sortEdges(EData[] edges)
//    {
//        Arrays.sort(edges);
//    }

    public EData[] getEdgesArray()//该方法用来获取边的数组
    {
        EData[] EData = new EData[graph.edgeNum];
        ArrayList<String> vertexList = graph.vertexList;
        int[][] edges = graph.edges;
        int length = edges.length;
        int index = 0;//该变量用来记录数组索引
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if(edges[i][j] != Integer.MAX_VALUE)
                {
                    EData[index++] = new EData(vertexList.get(i),i,vertexList.get(j),j,edges[i][j]);
                }
            }
        }
        return EData;
    }
}



@SuppressWarnings({"all"})

class EData implements Comparable<EData>//创建一个边类 为了方便排序 要实现Comparable接口
{
    String start;//记录边的起点
    int startIndex;//记录边的起点的索引
    String end;//记录边的终点
    int endIndex;//记录边的终点的索引
    int weight;//记录边的权值

    public EData(String start, int startIndex, String end, int endIndex, int weight) {
        this.start = start;
        this.startIndex = startIndex;
        this.end = end;
        this.endIndex = endIndex;
        this.weight = weight;
    }

    @Override
    public int compareTo(EData EData) {
        return this.weight - EData.weight;
    }

    @Override
    public String toString() {
        return start + "-" + end + "(权值: " + weight + ")";
    }
}



@SuppressWarnings({"all"})

class Graph
{
    ArrayList<String> vertexList;//该集合用来存放顶点
    int[][] edges;//该数组就是图对应的邻接矩阵
    int edgeNum;

    public Graph() {
        vertexList = new ArrayList(7);
        vertexList.add("A");
        vertexList.add("B");
        vertexList.add("C");
        vertexList.add("D");
        vertexList.add("E");
        vertexList.add("F");
        vertexList.add("G");
        int MAX = Integer.MAX_VALUE;
        edges = new int[][]{
//                {0,12,1000,1000,1000,16,14},
//                {12,0,10,1000, 1000,7,1000},
//                {1000,10,0,3,5,6,1000},
//                {1000,1000,3,0,4,1000,1000},
//                {1000,1000,5,4,0,2,8},
//                {16,7,6,1000,2,0,9},
//                {14,1000,1000,1000,8,9,0}
                {MAX,12,MAX,MAX,MAX,16,14},
                {12,MAX,10,MAX,MAX,7,MAX},
                {MAX,10,MAX,3,5,6,MAX},
                {MAX,MAX,3,MAX,4,MAX,MAX},
                {MAX,MAX,5,4,MAX,2,8},
                {16,7,6,MAX,2,MAX,9},
                {14,MAX,MAX,MAX,8,9,MAX}
        };
        edgeNum = 12;
    }


}

@SuppressWarnings({"all"})

class Disjoint_Sets {
    int[] parent;//父亲数组的含义: 例如parent[1] = 2 代表1的父结点是2

    public Disjoint_Sets(int n) {//在构造器中完成父亲数组的初始化
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;//一开始每个元素都是孤立的 即自己的父结点就是自己
        }
    }


    public int find(int i)//该方法用来查找i的祖先
    {
        if (parent[i] == i)//利用祖先结点的特点 即祖先的父结点就是本身
        {
            return i;
        }
        else
        {
            parent[i] = find(parent[i]);//该步进行了进行路径压缩
            return find(parent[i]);
        }
    }

    public void union(int i,int j)//合并i和j 使i的祖先指向j的祖先
    {
        int m = find(i);//找到i的祖先 赋给m
        int n = find(j);//找到j的祖先 赋给n
        parent[m] = n;//将i的祖先指向j的祖先
    }
}
