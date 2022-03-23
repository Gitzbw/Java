package com;

import java.util.Arrays;

public class run {
    public static void main(String[] args) {
//        //原数组的创建
//        int[][] arr = new int[11][11];
//        arr[1][2] = 1;
//        arr[2][4] = 2;
//        //遍历原数组 找到非零个数
//        int count = 0;
//        for (int[] row :arr) {
//            for (int data :row) {
//                if(data != 0)
//                {
//                    count++;
//                }
//            }
//        }
//        //创建稀疏数组
//        int[][] sparseArr = new int[count+1][3];
//        sparseArr[0][0] = 11;
//        sparseArr[0][1] = 11;
//        sparseArr[0][2] = count;
//        //填充数据
//        int current = 0;//用于记录当前稀疏数组的行数
//        for (int i = 0; i < 11; i++) {
//            for (int j = 0; j < 11; j++) {
//                if(arr[i][j]!= 0)
//                {
//                    sparseArr[++current][0] = i;
//                    sparseArr[current][1] = j;
//                    sparseArr[current][2] = arr[i][j];
//                }
//            }
//        }
//        //恢复
//        int[][] oldArr = new int[sparseArr[0][0]][sparseArr[0][1]];
//        for (int i = 1; i < sparseArr.length; i++) {
//            oldArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
//        }
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.addData(1);
        arrayQueue.addData(2);
        arrayQueue.showQueue();
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(10);
        circleArrayQueue.addData(1);
        circleArrayQueue.addData(2);
        circleArrayQueue.showQueue();
    }
}

class ArrayQueue
{
    private int maxSize;
    private int front;//指向队列的第一个元素的前一个位置
    private int rear;//指向队列的最后一个元素
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull()
    {
        return rear == maxSize-1;
    }

    public boolean isEmpty()
    {
        return front == rear;
    }

    public void addData(int n)
    {
        if(isFull())
        {
            System.out.println("队列已满 添加失败");
            return;
        }
        arr[++rear] = n;
    }

    public int getData()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列空 无法取出数据");
        }
        return arr[++front];
    }

    public void showQueue()
    {
        if(isEmpty())
        {
            System.out.println("队列空 无数据");
            return;
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.println(arr[i]);
        }
    }

    public int getHeadData()//该方法只是显示头数据 并不会把头数据从队列中取出
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列空 无法取出数据");
        }
        return arr[front+1];
    }
}

class CircleArrayQueue
{
    private int maxSize;
    private int front;//指向队列的第一个元素的前一个位置
    private int rear;//指向队列的最后一个元素
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull()
    {
        return (rear+1) % maxSize == front;
    }

    public boolean isEmpty()
    {
        return front == rear;
    }

    public void addData(int n)
    {
        if(isFull())
        {
            System.out.println("队列已满 添加失败");
            return;
        }
        arr[rear] = n;
        rear = (rear+1) % maxSize;
    }

    public int getData()
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列空 无法取出数据");
        }
        int value = arr[front];
        front = (front+1) % maxSize;
        return value;
    }

    public void showQueue()
    {
        if(isEmpty())
        {
            System.out.println("队列空 无数据");
            return;
        }
        for (int i = front; i < front + trueSize(); i++) {
            System.out.println(arr[i%maxSize]);
        }
    }

    public int trueSize()
    {
        return (rear-front+maxSize) % maxSize;
    }

    public int getHeadData()//该方法只是显示头数据 并不会把头数据从队列中取出
    {
        if(isEmpty())
        {
            throw new RuntimeException("队列空 无法取出数据");
        }
        return arr[front];
    }
}
