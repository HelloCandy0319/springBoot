package com.example.demo.testYpf.arithmetic;

import java.util.Arrays;

/**
 * 二分法查找 数组有序
 * 时间复杂度：k=log2n,（是以2为底，n的对数）
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr= {30,20,50,10,80,9,7,12,100,40,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr,40));
    }

    public static int binarySearch(int [] arr,int value){
        int low = 0;
        int high = arr.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (arr[mid] == value){
                return mid;
            }else  if (arr[mid]<value){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }
}
