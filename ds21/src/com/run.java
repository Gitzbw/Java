package com;

import java.util.Arrays;

@SuppressWarnings({"all"})

public class run {
    public static void main(String[] args) {
//        int[] w = {1,4,3};
//        int[] val = {1500,3000,2000};
//        int m = 4;
//        new run().knapsackProblem(w,val,m);
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        new run().KMP(str1,str2);
    }

    public void KMP(String str1,String str2)
    {
        //为了便于操作 使两个字符串都转换成字符数组 并空出第一位弃用
        char[] ch1 = (" " + str1).toCharArray();
        char[] ch2 = (" " + str2 ).toCharArray();
        int[] next = getNext(" " + str2);
        int[] nextVal = getNextVal(next, " " + str2);
        int i = 1;
        int j = 1;
        while(i < ch1.length && j < ch2.length)
        {
            if(j == 0 || ch1[i] == ch2[j])
            {
                i++;
                j++;
            }
            else
            {
                j = nextVal[j];
            }
        }
        if(j == ch2.length)
        {
            System.out.println("匹配成功 下标为" + (i-j) );
        }
        else
        {
            System.out.println("匹配失败");
        }
    }

    public int[] getNext(String str)//为了更加直观 这里传入的字符串长度比原字符串长1(索引0处为" ") 数组下标从1开始(即弃用下标0)
    {
        char[] ch = str.toCharArray();
        int[] next = new int[ch.length];
        int i = 1;//下标1处元素恒为0 初始化是默认是0 不用再显式赋值了
        int j = 0;
        while(i < next.length-1)
        {
            if(j==0 || ch[i] == ch[j])
            {
                next[++i] = ++j;
            }
            else
            {
                j = next[j];
            }
        }
        return next;
    }

    public int[] getNextVal(int[] next,String str)
    {
        char[] ch = str.toCharArray();
        int[] nextVal = new int[next.length];
        //下标1处元素恒为0 初始化是默认是0 不用再显式赋值了
        for (int i = 2; i < nextVal.length; i++) {
            if(ch[i] != ch[next[i]])
            {
                nextVal[i] = next[i];
            }
            else
            {
                nextVal[i] = nextVal[next[i]];
            }
        }
        return nextVal;
    }

    public void BF(String str1,String str2)
    {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int i = 0;
        int j = 0;
        while(i < s1.length && j < s2.length)
        {
            if(s1[i] == s2[j])
            {
                i++;
                j++;
            }
            else
            {
                i = i-j+1;
                j = 0;
            }
        }
        if(j == s2.length)
        {
            System.out.println("匹配成功 下标为" + (i-j) );
        }
        else
        {
            System.out.println("匹配失败");
        }
    }

    public void knapsackProblem(int[] w,int[] val,int capacity)//第一个参数是物品的重量 第二个参数是物品的价值 第三个参数背包的容量
    {
        int[][] v = new int[w.length+1][capacity+1];//创建一个二维数组 第零行第零列默认值就是0 不用再显式赋值
        int[][] path = new int[w.length+1][capacity+1];//该数组用来记录装入背包的物品
        for (int i = 1; i < w.length + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if(w[i-1] > j)
                {
                    v[i][j] = v[i-1][j];
                }
                else
                {
                    if(v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]])
                    {
                        v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
                        path[i][j] = 1;//记录最优解
                    }
                    else
                    {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }
        System.out.println("最多可以装总价值为" + v[w.length][capacity] + "的物品");
        System.out.println("装入顺序为: ");
        int i = path.length-1;
        int j = path[0].length-1;
        while(i > 0 && j > 0)
        {
            if(path[i][j] == 1)
            {
                System.out.println("装入第" + i + "个物品");
                j-= w[i-1];
            }
            i--;
        }
    }


}
