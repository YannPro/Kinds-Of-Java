package com.yannyao.demo.algorithm;

import java.util.Arrays;

/**
 * @Auther: YJY
 * @Date: 2018/10/30 13:38
 * @Description:
 */
public class Sort {
    /**
     * 冒泡排序
     * 时间复杂度O(N²)
     * https://www.cnblogs.com/shen-hua/p/5422676.html
     * @param numbers
     */
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                // 交换两数位置
                if (numbers[j] > numbers[j + 1])
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }

    /**
     * 选择排序
     * 时间复杂度O(N²)
     * 将要排序的数据元素选出最小（大），将他和数据元素的首位交换位置。
     * 再次从剩下的数据元素中 找到最小（大）的元素，
     * 然后与数据元素的第二位子交换。。。直到将整个数据元素排序。
     */
    /**
     * 插入排序
     * 时间复杂度最好O(N)   最坏还是O(N²)
     * 从未排序的数组选取第一个插入到已经排序好的数组中
     * @param args
     */


    /**
     * 快速排序
     * 时间复杂度O(NlogN)
     * https://blog.csdn.net/as02446418/article/details/47395867
     * @param arr,low,high
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        bubbleSort(new int[]{8,5,4,7,1,9});
        quickSort(new int[]{8,5,4,7,1,9}, 0, 5);
    }
}
