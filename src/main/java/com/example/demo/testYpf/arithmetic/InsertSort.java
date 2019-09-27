package com.example.demo.testYpf.arithmetic;

import java.util.Arrays;

/**
 * 直接插入排序
 * 时间复杂度 o(n2)
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr= {30,20,50,10,80,9,7,12,100,40,8,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arrays){
       for (int i=1;i<arrays.length;i++){
           int temp = arrays[i];
           int index = i-1;
           while (index>=0 && temp<arrays[index]){
               arrays[index+1] = arrays[index];
               index --;
           }
           arrays[index+1] = temp;
       }
    }
}
