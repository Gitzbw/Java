package com;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class run {
    public static void main(String[] args) {
//        int[] arr = {53,3,542,748,14,214};
//        System.out.println(Arrays.toString(arr));
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = {2,3,4,5,1,2,3,8,7};
        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void countSort(int[] arr)
    {
        if(arr.length < 2)
        {
            return;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        int[] count = new int[max+1];//定义一个计数数组 数组长度为arr数组最大值加一 数组索引就是原数组中的数据
        for (int i = 0; i < arr.length; i++) {//该循环用于完成计数
            count[arr[i]]++;
        }
        int index = 0;//用来保存arr的索引
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[index] = i;
                index++;
            }
        }
    }


    public static void radixSort(int[] arr)
    {
        int[][] buckets = new int[10][arr.length];//定义排序需要的桶
        int[] count = new int[10];//该数组用来记录每个桶中放的元素个数
        //为了确定要排多少轮 我们要找到数组中最大的数 其位数就是我们要排序的轮数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();//这是一种巧妙求数据位数的方法
        //接下来开始正式排序
        for (int k = 0,m = 1; k < maxLength; k++,m *= 10) {//m是用来辅助计算每次需要除10的几次方
            //把数据放入桶中
            for (int i = 0; i < arr.length; i++) {
                int digitNum = (arr[i]/m)%10;
                buckets[digitNum][count[digitNum]] = arr[i];//放入对应的桶中
                count[digitNum]++;
            }
            //接下来把桶中的元素依次复制到数组中
            int index = 0;//该数据用来记录
            for (int i = 0; i < 10; i++) {
                if(count[i] != 0)
                {
                    for (int j = 0; j < count[i]; j++) {
                        arr[index] = buckets[i][j];
                        index++;
                    }
                }
                count[i] = 0;//把元素个数置为0 避免影响下次操作
            }
        }
    }
}
