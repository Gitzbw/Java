package com;

import java.util.Arrays;


@SuppressWarnings({"all"})
public class run {
    public static void main(String[] args) {
        int arr[] = {3,2,1,0};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr,int left,int right,int[] temp)
    {
        if(left < right)
        {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid, temp);//向左递归
            mergeSort(arr, mid+1, right, temp);//向右递归
            merge(arr,left,mid,right,temp);//合并
        }
    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp)//归并排序中 合并的算法
    {
        int i = left;//i用来记录左边有序序列的索引位置
        int j = mid+1;//j用来记录右边有序序列的索引位置
        int t = 0;//t用来记录temp数组的索引位置
        while(i <= mid && j <= right)
        {
            if(arr[i] < arr[j])
            {
                temp[t] = arr[i];
                i++;
                t++;
            }
            else
            {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }//至此左右两个有序序列中的一个(至少一个 也有可能两个都完成了)已经全部拷贝完成
        while( i <= mid) { //左边的有序序列还有剩余的元素，就全部填充到 temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while( j <= right) { //右边的有序序列还有剩余的元素，就全部填充到 temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //接下来需要将temp数组里的元素拷贝到arr数组中 注意只有最后一次才会把所有元素全部复制到arr数组中 其余情况只复制一部分到对应位置
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right)
        {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }




    public static void quickSort(int[] arr,int left,int right)
    {
        if(left < right)//判断是否要递归下去的判断条件
        {
            int standard = arr[left];//以数组第一个元素为基准
            int low = left;//保存左边界
            int high = right;//保存右边界
            while(low < high)
            {
                while(low < high && arr[high] >= standard)
                {
                    high--;
                }
                arr[low] = arr[high];
                while(low < high && arr[low] < standard)
                {
                    low++;
                }
                arr[high] = arr[left];
            }//到此为止 low = high
            arr[low] = standard;//把基准值赋给low/high索引
            quickSort(arr,left,high-1);
            quickSort(arr,low+1,right);
            //high-1 和 low+1 就把数组分成了2个部分 左边全是比基准元素小的 右边全是比基准元素大的 基准元素不需要再比较
        }
    }


}
