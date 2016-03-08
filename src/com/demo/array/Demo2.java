package com.demo.array;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月7日 下午2:19:39
 * @version V1.0
 */
// 给定一个数组如{9, 1, 6, 3, 3, 1, 2, 1, 8}，请找出该数组中出现次数最多且最大的那个数及出现的次数
public class Demo2 {

    public static void main(String[] args) {
        int arr[] = { 9, 1, 6, 3, 3, 1, 2, 1, 8 };
        sort(arr);
        print(arr);
    }

    private static void print(int[] arrt) {
        for (int i : arrt) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
