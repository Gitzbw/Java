package com;

import java.util.ArrayList;
import java.util.Arrays;

public class run {
    public static void main(String[] args) {
        String[] vertexValue = {"A","B","C","D","E"};
        graph graph = new graph(5);
        for(String vertex : vertexValue)
        {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();
        graph.DFS();
    }
}


@SuppressWarnings({"all"})

class graph
{
    ArrayList<String> vertexList;//该集合用于存储顶点
    int[][] edges;//该数组用于存储图对应的邻接矩阵
    int numOfEdges;//表示边的数目
    boolean[] isVisited;//该数组用于记录对应结点是否被访问

    public graph(int n)//传入的参数代表图的顶点数
    {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
    }

    public void DFS()//这里重载的目的是为了能遍历所有结点 连通图不重载也可以完成遍历 但是不连通图就不能完成遍历 就必须要重载来遍历所有结点
    {
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i])
            {
                DFS(isVisited,i);
            }
        }
    }

    private void DFS(boolean[] isVisited,int index)
    {
        System.out.println(getValueByIndex(index));
        isVisited[index] = true;//将该结点设置为已访问
        int firstAdjacency = getFirstAdjacency(index);//查找第一个领接结点
        while(firstAdjacency != -1)
        {
            if(!isVisited[firstAdjacency])
            {
                DFS(isVisited,firstAdjacency);
            }
            firstAdjacency = getNextAdjacency(index,firstAdjacency);//index可以理解为行 firstAdjacency可以理解为列
        }
    }

    public int getFirstAdjacency(int index)//该方法用于获取得到传入结点的第一个领接结点的下标 不存在返回-1
    {
        for (int i = 0; i < vertexList.size(); i++) {
            if(edges[index][i] > 0)
            {
                return i;
            }
        }
        return -1;
    }

    public int getNextAdjacency(int preRowIndex,int preColIndex)//该方法根据传入的前一个领接结点获取下一个领接结点 不存在返回-1
    {
        for (int i = preColIndex+1; i < vertexList.size(); i++) {
            if(edges[preRowIndex][i] > 0)
            {
                return i;
            }
        }
        return -1;
    }

    public void insertVertex(String vertex)//该方法用于添加结点
    {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1,int v2,int weight)//该方法用于添加边 v1 v2 都是点的下标
    {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertexs()//该方法用于返回结点的数目
    {
        return vertexList.size();
    }

    public int getNumOfEdges()//该方法用于返回边的数目
    {
        return numOfEdges;
    }

    public String getValueByIndex(int index)//该方法根据传入的索引返回顶点
    {
        return vertexList.get(index);
    }

    public int getWeight(int v1,int v2)//该方法用于返回v1和v2间的权值
    {
        return edges[v1][v2];
    }

    public void showGraph()//该方法用于显示图对应的邻接矩阵
    {
        for(int[] link : edges)
        {
            System.out.println(Arrays.toString(link));
        }
    }
}
