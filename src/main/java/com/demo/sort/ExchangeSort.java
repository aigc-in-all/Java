package com.demo.sort;

public class ExchangeSort {

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        print("排序之前", a);

        quickSort(a);

        print("排序之后", a);
    }

    // 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
    private static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                // 这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            print(i + "", a);
        }
    }

    // 基本思想：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
    // 实现思路：
    // 1.以第一个关键字 K1为控制字，将 [K1 ,K2 ,...,Kn ] 分成两个子区，使左区所有关键字小于等于 K1，右区所有关键字大于等于
    // K1，最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。
    // 2.把左区作为一个整体，用[1]的步骤进行处理，右区进行相同的处理。（即递归）
    // 3.重复第[1]、[2]步，直到左区处理完毕。
    private static void quickSort(int a[]) {
        if (a.length == 0) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int a[], int left, int right) {
        if (left < right) {
            int dp = partition(a, left, right);
            quickSort(a, 0, dp - 1);
            quickSort(a, dp + 1, right);
        }
    }

    private static int partition(int a[], int left, int right) {
        int temp = a[left]; // 基准元素
        while (left < right) {
            // 找到比基准元素小的元素位置
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        return left;
    }

    private static void print(String str, int a[]) {
        System.out.print(str + "：");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
