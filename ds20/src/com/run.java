package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

@SuppressWarnings({"all"})

public class run {
    public static void main(String[] args) {
//        String[] vertexValue = {"A","B","C","D","E"};
//        graph graph = new graph(5);
//        for(String vertex : vertexValue)
//        {
//            graph.insertVertex(vertex);
//        }
//        graph.insertEdge(0,1,1);
//        graph.insertEdge(0,2,1);
//        graph.insertEdge(1,2,1);
//        graph.insertEdge(1,3,1);
//        graph.insertEdge(1,4,1);
//        graph.showGraph();
//        graph.DFS();
//        graph.BFS();
        hanoiTower(3,'a','b','c');
    }

    public static void hanoiTower(int num,char a,char b,char c)//第一个参数是盘子的数目 后面3个参数就是三根柱子
    {
        if(num == 1)
        {
            System.out.println("第1个盘子: " + a + " -> " + c);
        }
        else//看成两个盘 一个最下面的盘 一个上面的盘(把上面全部盘看成一个整体)
        {
            //分3步完成
            //1.把上面的盘移动到b柱
            hanoiTower(num-1,a,c,b);
            //2.把下面的盘移动到c柱
            System.out.println("第" + num + "个盘子: " + a + " -> " + c);
            //3.把b柱上的盘移动到c柱
            hanoiTower(num-1,b,a,c);
        }
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

    public void BFS()//这里重载的目的是为了能遍历所有结点 连通图不重载也可以完成遍历 但是不连通图就不能完成遍历 就必须要重载来遍历所有结点
    {
        isVisited = new boolean[vertexList.size()];//重置isVisited数组
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i])
            {
                BFS(isVisited,i);
            }
        }
    }

    private void BFS(boolean[] isVisited,int index)
    {
        LinkedList<Integer> queue = new LinkedList<>();//创建一个队列记录访问结点的顺序 辅助我们BFS
        queue.addLast(index);//首先把头结点加入
        isVisited[index] = true;//把头结点标记为已访问
        while(queue.size() > 0)
        {
            int first = queue.getFirst();
            for (int i = 0; i < edges.length; i++) {
                if(edges[first][i] == 1 && !isVisited[i])
                {
                    queue.addLast(i);
                    isVisited[i] = true;
                }
            }
            System.out.println(getValueByIndex(first));//打印当前结点
            queue.removeFirst();//删除第一个结点
        }
    }

    public void DFS()//这里重载的目的是为了能遍历所有结点 连通图不重载也可以完成遍历 但是不连通图就不能完成遍历 就必须要重载来遍历所有结点
    {
        isVisited = new boolean[vertexList.size()];//重置isVisited数组
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
        for (int i = 0; i < edges.length; i++) {
            if(edges[index][i] == 1 && !isVisited[i])
            {
                DFS(isVisited,i);
            }
        }
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
