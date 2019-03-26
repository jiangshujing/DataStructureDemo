package com.example.jsj.datastructuredemo.My.find;

/**
 * 查找算法
 */
public class Find {





    /**
     * 二分查找
     *
     * @return
     */
    private int toChecked() {
        //二分查找，先进行排序
        int[] arr = {3, 6, 9, 11, 13, 20};
        int min = 0;
        int max = arr.length - 1;
        int target = 20;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (target == mid) {
                return mid;
            } else if (target > arr[mid]) {
                max = mid + 1;
            } else if (target < arr[mid]) {
                min = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，递归法
     * @param min
     * @param max
     * @return
     */
    private int toChecked2(int min, int max) {
        int[] arr = {3, 6, 9, 11, 13, 20};
        int tager = 20;

        if (min > max) {
            return -1;
        }
        int mid = (min + max) / 2;
        if (tager > arr[mid]) {
            toChecked2(mid + 1, max);
        } else if (tager < arr[mid]) {
            toChecked2(min, mid - 1);
        } else if (tager == arr[mid]) {
            return mid;
        }
        return -1;
    }
}
