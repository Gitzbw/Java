package com;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class run {
    public static void main(String[] args) {
//        System.out.println(BF.find("aabaabaaf","aabaaf"));
//        System.out.println(KMP.find1("aabaabaaf","aabaaf"));
//        System.out.println(KMP.find2("aabaabaaf","aabaaf"));
        int[] arr = {3,1,2,4,5};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }



    public static void shellSort(int[] arr)
    {
        for (int gap = arr.length/2;gap >=1 ;gap /= 2)//gap为组数也是步长
        {
            for(int i = gap;i < arr.length;i++)
            {
                int insertVal = arr[i];
                int j = i;
                while(j-gap >= 0 && insertVal < arr[j-gap])
                {
                    arr[j] = arr[j-gap];
                    j-=gap;
                }
                arr[j] = insertVal;
            }
        }
    }



//    public static void shellSort(int[] arr)
//    {
//        for (int gap = arr.length/2;gap >=1 ;gap /= 2)//gap为步长
//        {
//            for (int i = gap; i < arr.length; i++) {
//                for (int j = i-gap; j >=0 ; j -= gap) {
//                    if(arr[j] > arr[j+gap])
//                    {
//                        int tmp = arr[j];
//                        arr[j] = arr[j+gap];
//                        arr[j+gap] = tmp;
//                    }
//                }
//            }
//        }
//    }


    public static void insertSort(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++) {
            int insertVal = arr[i+1];
            int j = i;
            while(j>=0 && insertVal < arr[j])
            {
                arr[j+1] = arr[j];//数据后移
                j--;
            }
            if(j != i)
            {
                arr[j + 1] = insertVal;
            }
        }
    }

    public static void selectSort(int[] arr)
    {
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min])
                {
                    min = j;
                }
            }
            if(min != i)
            {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }

    }


}




class BF
{
    public static int find(String s1,String s2)
    {
        int length1 = s1.length();
        int length2 = s2.length();
        int i = 0;
        int j = 0;
        while(i<length1 && j<length2)
        {
            if(s1.charAt(i) == s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i = i-j+1;
                j=0;
            }
            if(i == length2)
            {
                return i-j;
            }
        }
        return -1;
    }

}

class KMP
{
    public static int[] getNext(String s)
    {
        int length = s.length();
        char[] chars = s.toCharArray();
        char[] ch = new char[length+1];
        for (int i = 0; i < length; i++) {
            ch[i+1] = chars[i];
        }
        int[] next = new int[ch.length];
        next[1] = 0;
        int i = 1;
        int j = 0;
        while(i<length)
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

    public static int[] getNextVal(String s)
    {
        int[] next = getNext(s);
        String s1 = " " + s;
        int[] nextVal = new int[next.length];
        int i = 1;
        for (; i < nextVal.length; i++) {
            if(s1.charAt(i) != s1.charAt(next[i]))
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

    public static int find1(String s1,String s2)
    {
        int[] next = getNext(s2);
        String s3 = " " + s2;
        int i = 0;
        int j = 1;
        while(i<s1.length() && j<s3.length())
        {
            if(j==0 || s1.charAt(i) == s3.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j = next[j];
            }
        }
        if(j>s2.length())
        {
            return i-s2.length();
        }
        else
        {
            return -1;
        }
    }

    public static int find2(String s1,String s2)
    {
        int[] nextVal = getNextVal(s2);
        String s3 = " " + s2;
        int i = 0;
        int j = 1;
        while(i<s1.length() && j<s3.length())
        {
            if(j==0 || s1.charAt(i) == s3.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j = nextVal[j];
            }
        }
        if(j>s2.length())
        {
            return i-s2.length();
        }
        else
        {
            return -1;
        }
    }
}
