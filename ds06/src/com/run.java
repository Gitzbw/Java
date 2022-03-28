package com;

import java.util.Arrays;

public class run {
    public static void main(String[] args) {
        
    }

    public static void bubbleSort(int[] arr)
    {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;//每次都需要把flag置为false 所以直接在内层定义
            for (int j = 0; j < length - 1 - i; j++) {
                if(arr[j] > arr[j+1])
                {
                    flag = true;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if(!flag)
            {
                break;
            }
        }
    }

}
