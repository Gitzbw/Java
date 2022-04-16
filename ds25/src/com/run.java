package com;

import java.util.ArrayList;
import java.util.Arrays;

public class run {
    public static void main(String[] args) {
        Floyd floyd = new Floyd(new Graph());
        floyd.floyd();
    }
}


@SuppressWarnings({"all"})

class Floyd
{
    Graph graph;
    int[][] pre;//前驱结点表

    public Floyd(Graph graph) {
        this.graph = graph;
        //初始化前驱结点表
        pre = new int[graph.edges.length][graph.edges.length];
        for (int i = 0; i < graph.edges.length; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void floyd()
    {
        int len = 0;//该变量用来保存距离
        int[][] edges = graph.edges;
        int length = edges.length;
        for (int k = 0; k < length; k++)//中间顶点
        {
            for (int i = 0; i < length; i++)//出发顶点
            {
                for (int j = 0; j < length; j++)//终点
                {
                    len = edges[i][k] + edges[k][j];//从出发顶点i到中间顶点k的距离 加上 从中间顶点k到终点j的距离
                    if(len < edges[i][j])//算出来的len小于原来距离的情况
                    {
                        edges[i][j] = len;
                        pre[i][j] = pre[k][j];
                        pre[j][i] = pre[k][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(edges));
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
                {0,5,7,N,N,N,2},
                {5,0,N,9,N,N,3},
                {7,N,0,N,8,N,N},
                {N,9,N,0,N,4,N},
                {N,N,8,N,0,5,4},
                {N,N,N,4,5,0,6},
                {2,3,N,N,4,6,0},
        };
    }
}
