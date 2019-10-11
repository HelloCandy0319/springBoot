package com.example.demo.testYpf.arithmetic;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度
 * 平均：O( nlogn )
 * 最坏情况：O( n^2 )
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr= {30,20,50,10,80,9,7,12,100,40,8,1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int [] arrays,int low,int high){
        int begin = low;
        int end = high;
        int key = arrays[low];
        // 从 后给前 排序
        while (end>begin){
            //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while (end>begin && key<=arrays[end])
                end --;
            if (key>=arrays[end]){
                int temp = arrays[end];
                arrays[end] = arrays[begin];
                arrays[begin] = temp;
            }
           //从前给后
            while (end>begin && key>=arrays[begin])
                begin++;
            if (key<=arrays[begin]){
                int temp = arrays[begin];
                arrays[begin] = arrays[end];
                arrays[end] = temp;
            }
        }
        if (begin>low){
            quickSort(arrays,low,begin-1);
        }
        if (end<high){
            quickSort(arrays,end+1,high);
        }


    }
}
