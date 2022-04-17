package com;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class run {
    public static void main(String[] args) {
        Knight_tour knight_tour = new Knight_tour(8, 8);
        long start = System.currentTimeMillis();
        int[][] arr = new int[8][8];
        knight_tour.traversalChessBoard(arr,0,0,1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        knight_tour.showChessBoard(arr);
    }
}

@SuppressWarnings({"all"})

class Knight_tour
{
    int X;//棋盘的列数
    int Y;//棋盘的行数
    boolean[] isVisited;//该数组来标记棋盘的各个位置是否被访问
    boolean isFinished;//该变量用来标记马踏棋盘是否完成

    public Knight_tour(int x, int y) {
        X = x;
        Y = y;
        isVisited = new boolean[x * y];
    }

    public ArrayList<Point> next(Point curPoint)//该方法根据传入的坐标 返回所有能走的坐标(放在一个数组列表中)
    {
        ArrayList<Point> ps = new ArrayList<Point>();
        Point p1 = new Point();
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public void traversalChessBoard(int[][] chessBoard,int row,int col,int step)
    {
        chessBoard[row][col] = step;
        isVisited[row * X + col] = true; //标记该位置已经访问
        ArrayList<Point> ps = next(new Point(col,row));//获取当前位置能走的下一个位置的集合
        sort(ps);
        while(!ps.isEmpty())
        {
            Point p = ps.remove(0);
            if(!isVisited[p.y * X + p.x])//还没有访问过的情况
            {
                traversalChessBoard(chessBoard, p.y, p.x, step + 1);
            }
        }
        //走到这有两种情况 (1)棋盘到目前位置 已经不能再走了 但没有完成马踏棋盘 需要回溯 (2)已经完成马踏棋盘
        if(step < X * Y && !isFinished)
        {
            chessBoard[row][col] = 0;
            isVisited[row * X + col] = false;
        }
        else
        {
            isFinished = true;
        }
    }

    public void sort(ArrayList<Point> ps)
    {
        Collections.sort(ps,(p1,p2) -> next(p1).size() - next(p2).size());
    }

    public void showChessBoard(int[][] chessBoard)
    {
        for(int[] rows : chessBoard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }


}
