package com.demo.sort;

/**
 * @author HeQingbao
 *
 * 排序大的分类可以分为两种：内排序和外排序。在排序过程中，全部记录存放在内存，则称为内排序，如果排序过程中需要使用外存，则称为外排序。下面讲的排序都是属于内排序。
 *
 * 内排序有可以分为以下几类：
 *
 * (1)、插入排序：直接插入排序、二分法插入排序、希尔排序。
 *
 * (2)、选择排序：简单选择排序、堆排序。
 *
 * (3)、交换排序：冒泡排序、快速排序。
 *
 * (4)、归并排序
 *
 * (5)、基数排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        print("排序之前", a);

        insertSort1(a);

        print("排序之后", a);
    }

    // 直接插入排序
    // 思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排好序的合适位置，直到全部插入排序完为止。
    // 关键问题：在前面已经排好序的序列中找到合适的插入位置。
    public static void insertSort1(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i]; // 待排序元素
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }

    // 二分法插入排序
    public static void insertSort2(int a[]) {

    }

    public static void print(String str, int a[]) {
        System.out.print(str + "：");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
