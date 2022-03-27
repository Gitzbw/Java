package com;

public class run {
    public static void main(String[] args) {
//        Maze maze = new Maze();
//        int[][] map = maze.map;
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j] + "  ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------------------------");
//        Maze.setWay(map,1,1);
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j] + "  ");
//            }
//            System.out.println();
//        }
        EightQueens eightQueens = new EightQueens();
        eightQueens.check(0);
        System.out.println(EightQueens.count);


    }
}


class EightQueens
{
    int max = 8;//表示皇后的数目
    int[] arr = new int[max];//该数组用来记录皇后的位置
    static int count = 0;//用来统计解法数

    public void print()//该方法用来打印皇后的摆放位置 即八皇后问题的一种解
    {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean judge(int n)//该方法用来判断目前摆放的皇后会不会与前面已经摆放好的皇后冲突
    {
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n] 用来判断在不在同一列
            //Math.abs(arr[n] - arr[i]) 用来判断在不在同一斜线 因为下标代表行 数组里存的val是代表列 行列相等就在同一斜线上
            //不用判断是不是在同一行
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i]))
            {
                return false;
            }
        }
        return true;
    }

    public void check(int n)//核心方法
    {
        if(n== max)//此时相当于所有皇后都已经摆放完 打印后直接return
        {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if(judge(n))
            {
                check(n+1);
            }
        }
    }
}



class Maze
{
    int[][] map;

    {
        map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
    }//在代码块中完成地图的初始化 我们设1表示墙


    public static boolean setWay(int[][] map,int i,int j)//该方法用来找路 i j 表示走的位置的坐标 没走过为0 墙为1 通路为2 走不通为3
    {
        //我们找路的策略定为 下 右 上 左
        if(map[6][5] == 2)
        {
            return true;
        }
        if(map[i][j] == 0)
        {
            map[i][j] = 2;//我们先假定可以走通
            if(setWay(map,i+1,j))
            {
                return true;
            }
            else if(setWay(map,i,j+1))
            {
                return true;
            }
            else if(setWay(map,i-1,j))
            {
                return true;
            }
            else if(setWay(map,i,j-1))
            {
                return true;
            }
            else
            {
                map[i][j] = 3;
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}


