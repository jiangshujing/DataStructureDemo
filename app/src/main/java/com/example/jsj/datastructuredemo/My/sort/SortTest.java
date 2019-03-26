package com.example.jsj.datastructuredemo.My.sort;

import android.util.Log;

/**
 * Created by jiangshujing on 2018/3/1.
 */

public class SortTest {

    /**
     * 选择排序
     */
    private void selectSort() {
        //选择排序，每次选择固定未知的数据分别跟其他的数进行比较
        int[] arr = {2, 5, 11, 9, 3, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     */
    private void bubbling() {
        //冒泡排序，相邻的两个数进行比较
        int[] arr = {3, 0, 5, 11, 7, 43, 4};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmep = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = arr[j];
                }
            }
        }
    }

    /**
     * 插入排序
     * arr 表示数组，n 表示数组大小
     */
    public static void insertSort(int[] arr, int n) {
        if (n <= 1) return;
        //将第一个元素设为有序组
        //遍历无序数组，从下标1开始，因为0已经放到有序数组中
        //从无序表开始遍历，每次取第一个元素，将其插入到有序表中
        for (int i = 1; i < n; i++) {
            int temp = arr[i];//temp为本次循环待插入有序列表中的数
            int j = i - 1;//有序表的长度
            //遍历有序表，寻找temp插入有序列表的正确位置
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j]; // 将元素后移，为插入temp做准备，将temp插到j 与j+1中间
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;//插入元素
        }
    }


    /**
     * 快速排序 -- 获取分区点
     * 1.取基准值为第一个键值
     * 2.由右向左找到个比基准值小的数，坐标为i
     * 3.由左向右找到个比基准值大的数,坐标为j
     * 4.如果i<j ,两个数交换,并继续执行2
     * 5.直到i>=j,交换基准值跟下标为j的数值，则更改基准值的值，基准值=坐标为j的
     * 6.并以下标为j的值为基准点，分为左右两部分，并以递归方式分别为左右两部分进行排序
     *
     * @param arr
     * @param low
     * @param high 设定一个基准值，然后左边找到个比基准值大的数，右面找到个比基准值小的数，然后两个数进行交换
     */
    public static int checkDividValue1(int[] arr, int low, int high) {
        int left, right, value, temp;
        if (low > high) {
            return -1;
        }
        //left 比基准值大的数的坐标
        left = low;
        //right 比基准值小的数的坐标
        right = high;
        //value就是基准位，这里用第一个数作为基准值
        value = arr[low];

        while (left < right) {
            //先看右边，依次往左递减
            while (value <= arr[right] && left < right) {
                right--;//不需要交换，继续跟max-1比较,直到找到比基准值小的
            }
            //再看左边，依次往右递增
            while (value >= arr[left] && left < right) {
                left++;//不需要交换，继续跟min+1比较,直到找到比基准值大的
            }
            //交换两个数
            if (left < right) {
                temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        //基准值 与 下标为right的数值交换，right 为基准值
        //调整key的位置
        int temp1 = arr[right];
        arr[right] = arr[low];
        arr[low] = temp1;

        return right;
    }


    /**
     * 快速排序 固定基准值
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort1(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int mid = checkDividValue1(arr, left, right);//获取分区点
        // 分治法
        //对基准值左边的数据进行递归排序
        quickSort1(arr, left, mid);
        //对基准值右边的数据进行递归排序
        quickSort1(arr, mid + 1, right);
    }

    /**
     * 快速排序 三数取中
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort2(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1)
            return;
        int mid = checkDividValue(arr, left, right);//获取分区点
        // 分治法
        quickSort2(arr, left, mid);
        quickSort2(arr, mid + 1, right);
    }


    /**
     * 快速排序 三数取中
     * 找基准值的下标
     * 1.三数：中间数，最左边，最右边
     * 2.三个数进行排序
     * 3.以中间的为基准值
     * 4.将基准值放到末尾-1
     *
     * @param arr
     * @param left
     * @param right
     */
    public static int checkDividValue(int[] arr, int left, int right) {
        // 左指针
        if (left < right) {
            // 获取基准值，并将其放在当前待处理序列末尾
            dealPivot(arr, left, right);
            // 获取基准值，最后位置-1为基准值的初始位置
            int pivot = arr[right - 1];
            int i = left;
            // 右指针
            int j = right - 1;

            while (true) {
                //先从右边遍历比较，依次往左递减，直到left >= j结束
                while (pivot <= arr[j] && left < j) {
                    j--;//不需要交换
                }
                //再从左边遍历比较，依次往右递增，直到i >= right结束
                while (pivot >= arr[i] && i < right) {
                    i++;//不需要交换
                }
                //交换
                if (i < j) {
                    swap(arr, i, j);
                } else {
                    break;
                }
            }

            //交换基准值
            if (i < right) {
                swap(arr, i, right - 1);
            }

        }
        return right - 1;
    }

    /**
     * 处理基准值
     * 1.三数：中间数，最左边，最右边
     * 2.三个数进行排序
     * 3.以中间的为基准值
     * 4.将基准值放到末尾-1
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        // 枢纽值被放在序列末尾
        swap(arr, right - 1, mid);
    }

    /**
     * 数据交换
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    /**
     * 归并排序
     *
     * @param arr   要排序的数组
     * @param left  数据第一个元素的下标
     * @param right 数据最后一个元素的下标
     * @param temp  盛放排序后的数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //取中间值
            //分两路分别排序
            mergeSort(arr, left, mid, temp);//左边归并排序
            mergeSort(arr, mid + 1, right, temp);//右边归并排序

            //合并左右有序数据
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并两路
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        Log.e("SortTest ", "merge arr size ==" + arr.length);
        Log.e("SortTest ", "left ==" + left);
        Log.e("SortTest ", "mid ==" + mid);
        Log.e("SortTest ", "right ==" + right);
        Log.e("SortTest ", "merge temp size ==" + temp.length);
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }


    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        mergeSort(arr, 0, arr.length - 1, temp);
    }


}
