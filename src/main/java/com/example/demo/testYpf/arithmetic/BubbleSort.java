package com.example.demo.testYpf.arithmetic;

/**
 * 冒泡
 * 时间复杂度 o(n2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer arr[] = {2, 4, 7, 6, 8, 5, 9};
        bubbleSort(arr,arr.length);
        show(arr);
    }

    private static void bubbleSort(Integer[] nums,int n){
        if (n<=1)
            return;
        for (int i=0;i<n;i++){
            boolean flag = false;
            for (int j = 0;j<n-1-i;j++){
                if (nums[j]<nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

    public static void show(Integer[] nums){
        for (Integer num: nums){
            System.out.printf(num+ "    ");
        }
    }
}
