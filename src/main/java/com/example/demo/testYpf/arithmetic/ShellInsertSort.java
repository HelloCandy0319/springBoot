package com.example.demo.testYpf.arithmetic;

import java.util.Arrays;

public class ShellInsertSort {
    public static void main(String[] args) {
        int[] arr= {30,20,50,10,80,9,7,12,100,40,8,1};
        int td = arr.length/2;
        while (td>=1){
            shellInsertSort(arr,td);
            td = td/2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void shellInsertSort(int [] arrays,int td){
        for (int i = td;i<arrays.length;i++){
            if (arrays[i]<arrays[i-td]){
                int j;
                int temp = arrays[i];
                arrays[i] = arrays[i-td];
                for (j=i-td;j>=0 && temp<arrays[j];j=j-td){
                    arrays[j+td] = arrays[j];
                }
                arrays[j+td] = temp;
            }
        }
    }
}
