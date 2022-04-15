package com;

import java.util.ArrayList;
import java.util.Arrays;

public class run {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(new Graph());
        dijkstra.dijkstra(6);
    }
}

@SuppressWarnings({"all"})

class Dijkstra
{
    Graph graph;
    visitedVertexs visitedVertexs;

    public Dijkstra(Graph graph) {
        this.graph = graph;

    }

    public void dijkstra(int index)//index代表出发点的索引
    {
        visitedVertexs = new visitedVertexs(graph.edges.length,index);
        updateDisandPre(index);
        for (int i = 0; i < graph.edges.length -1; i++) {
            index = visitedVertexs.updateVertex();
            updateDisandPre(index);
        }
        System.out.println(Arrays.toString(visitedVertexs.dis));
    }

    public void updateDisandPre(int index)//该方法用来更新出发点到index顶点周围顶点的距离和被更新结点的前驱结点
    {
        int len = 0;
        int[][] edges = graph.edges;
        boolean[] isVisited = visitedVertexs.isVisited;
        for (int i = 0; i < edges[index].length; i++) {
            len = visitedVertexs.getDis(index) + edges[index][i];
            if(!isVisited[i] && len < visitedVertexs.getDis(i))
            {
                visitedVertexs.updatePre(i,index);
                visitedVertexs.updateDis(i,len);
            }
        }
    }
}

@SuppressWarnings({"all"})

class visitedVertexs//已访问过的顶点的集合
{
    boolean[] isVisited;//该数组记录某顶点是否被访问
    int[] preVisited;//该数组索引代表顶点 值代表顶点的前驱结点
    int[] dis;//该数组记录出发点到其他所有点的距离

    public visitedVertexs(int length, int index)//length是顶点个数 index是出发点的索引
    {
        isVisited = new boolean[length];
        isVisited[index] = true;//设置出发顶点被访问过
        preVisited = new int[length];
        dis = new int[length];
        //初始化dis数组
        Arrays.fill(dis,65535);//和其他点的初始距离为整型最大值
        dis[index] = 0;//和自己的距离为0
    }

    public void updateDis(int index,int len)//该方法用来更新出发点到index顶点的距离
    {
        dis[index] = len;
    }

    public void updatePre(int pre,int index)//该方法用来更新pre结点的前驱结点
    {
        preVisited[pre] = index;
    }

    public int getDis(int index)//该方法用来返回出发点到index顶点的距离
    {
        return dis[index];
    }

    public int updateVertex()//该方法用来更新访问顶点
    {
        int min = 65535;
        int index = 0;
        for (int i = 0; i < dis.length; i++) {
            if(!isVisited[i] && dis[i] < min)
            {
                min = dis[i];
                index = i;
            }
        }
        isVisited[index] = true;
        return index;
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
        int N = 65535;
        edges = new int[][]{
                {N,5,7,N,N,N,2},
                {5,N,N,9,N,N,3},
                {7,N,N,N,8,N,N},
                {N,9,N,N,N,4,N},
                {N,N,8,N,N,5,4},
                {N,N,N,4,5,N,6},
                {2,3,N,N,4,6,N},
        };
    }
}
