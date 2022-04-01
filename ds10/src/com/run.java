package com;

import java.util.ArrayList;


@SuppressWarnings({"all"})
public class run {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1000,1234};
        System.out.println("下标为 : " + binarySearch2(arr,0,arr.length-1,1000));
    }


    public static ArrayList binarySearch3(int[] arr,int left,int right,int findVal)
    {
        if(findVal < arr[0] || findVal > arr[arr.length - 1])//越界直接返回空数组列表
        {
            return new ArrayList();
        }
        while(left <= right)
        {
            int mid = (left+right)/2;
            if(findVal < arr[mid])
            {
                right = mid-1;
            }
            else if(findVal > arr[mid])
            {
                left = mid+1;
            }
            else
            {
                ArrayList arrayList = new ArrayList();
                int temp = mid-1;
                while(true)//向左扫描
                {
                    if(temp>=0 && arr[temp] == findVal)
                    {
                        temp--;
                    }
                    else
                    {
                        break;
                    }
                }
                for (int i = temp+1; i <= mid; i++) {
                    arrayList.add(i);
                }
                temp = mid+1;
                while(true)//向右扫描
                {
                    if(temp <= arr.length-1 && arr[temp] == findVal)
                    {
                        arrayList.add(temp++);
                    }
                    else
                    {
                        break;
                    }
                }

                return arrayList;//找不到返回空数组列表
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal)
    {
        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1])//找不到返回空数组列表
        {
            return new ArrayList();
        }
        int mid = (left+right)/2;
        if(findVal < arr[mid])
        {
            return binarySearch2(arr,left,mid-1,findVal);
        }
        else if(findVal > arr[mid])
        {
            return binarySearch2(arr,mid+1,right,findVal);
        }
        else//如果找到 我们还需要向左和向右扫描 把所有索引都放到数组列表中
        {
            ArrayList arrayList = new ArrayList();
            int temp = mid-1;
            while(true)//向左扫描
            {
                if(temp>=0 && arr[temp] == findVal)
                {
                    temp--;
                }
                else
                {
                    break;
                }
            }
            for (int i = temp+1; i <= mid; i++) {
                arrayList.add(i);
            }
            temp = mid+1;
            while(true)//向右扫描
            {
                if(temp <= arr.length-1 && arr[temp] == findVal)
                {
                    arrayList.add(temp++);
                }
                else
                {
                    break;
                }
            }

            return arrayList;
        }
    }


    public static int binarySearch1(int[] arr,int left,int right,int findVal)
    {
            if(left > right|| findVal < arr[0] || findVal > arr[arr.length - 1])//找不到返回-1
            {
                return -1;
            }
            int mid = (left+right)/2;
            if(findVal < arr[mid])
            {
                return binarySearch1(arr,left,mid,findVal);
            }
            else if(findVal > arr[mid])
            {
                return binarySearch1(arr,mid+1,right,findVal);
            }
            else
            {
                return mid;
            }
    }

}
