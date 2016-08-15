package com.demo.array;

import java.util.Arrays;

/**
 * @author qingbao.ho@gmail.com
 * @date 2016年3月7日 下午2:19:39
 * @version V1.0
 */
/**
 * 给你一个补丁长度的数组和需要把最后几位依次放到首位，求最后的数组，例：
 * [1,2,3,4,5,6]    
 * 移动3此依次为：
 * step = 1  : [6, 1, 2, 3, 4, 5]
 * step = 2  : [5, 6, 1, 2, 3, 4]
 * step = 3  : [4, 5, 6, 1, 2, 3]
 *
 */
public class Demo {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        for (int i = 1; i <= 3; i++) {
            moveByStep(arr, i);
        }
    }

    public static void moveByStep(int[] arr, int step) {
        int length = arr.length;
        if (step > length) {
            step = step % length;
        }

        int[] before = Arrays.copyOf(arr, length - step);
        int after[] = Arrays.copyOfRange(arr, length - step, length);
        int result[] = new int[length];
        System.arraycopy(after, 0, result, 0, after.length);
        System.arraycopy(before, 0, result, after.length, before.length);
        System.out.println("step = " + step + "  : " + Arrays.toString(result));

    }

}
