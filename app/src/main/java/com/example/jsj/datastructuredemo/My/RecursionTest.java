package com.example.jsj.datastructuredemo.My;

/**
 * 递归算法
 */
public class RecursionTest {


    /**
     * n的阶乘：就是从1到指定数之间的所有自然数相乘的结果
     *
     * @param n
     * @return
     */
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }


    /**
     * 兔子产仔
     * 如果一对两个月大的兔子以后每个月都可以生一对小兔子，而一对小兔子出生两个月后才能生小兔子，一年后共有多少对兔子
     * 1个月：2
     * 2个月：2
     * 3个月：4
     * 4个月：6
     * 5个月：10
     * ....................
     * 兔子总和等于上两个月兔子个数的综合
     * fn= f(n-1)+f(n-2)
     *
     * @param n 月数
     * @return
     */
    public static int fibonacci(int n) {
        //如果是第一月和第二月不会生小兔子，总对数还是1
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * @param coin 寻找假币 -- 假币比真币轻
     * @param low  开始的index
     * @param high 结束的index
     * @return
     */
    public static int falseCoin(int coin[], int low, int high) {
        int sum1 = 0, sum2 = 0;//记录总重量
        int target = 0;//要查找的假币的index


        //只有两个硬币
        if (low + 1 == high) {
            if (coin[low] < coin[high]) {
                target = low;
                return target;
            } else {
                target = high;
                return target;
            }
        }

        //如果是偶数个，分成两份，比较总重量
        if ((high - low + 1) % 2 == 0) {//n为偶数

            int mid = low + (high - low) / 2;//中间值的index
            //计算左半部分的总重量
            for (int i = low; i <= mid; i++) {
                sum1 = sum1 + coin[i];
            }
            //计算右半部分的总重量
            //从中间 + 1 开始
            for (int i = mid + 1; i <= high; i++) {
                sum2 = sum2 + coin[i];
            }

            //比较两部分的重量
            if (sum1 < sum2) {
                target = falseCoin(coin, low, mid);//假币再左半部分
                return target;
            } else if (sum1 > sum2) {//假币在右半部分
                target = falseCoin(coin, mid + 1, high);//假币再左半部分
                return target;
            }
        } else {//如果是奇数
            int sum3 = 0;
            int mid = low + (high - low) / 2;//如果是奇数计算出来的是，比如 low:5 high:9  (5+9-1)/2=7

            //计算左半部分的总重量,先不计算中间的值，为了左右相同个数的硬币
            for (int i = low; i < mid - 1; i++) {
                sum1 = sum1 + coin[i];
            }

            //计算右半部分的总重量
            //从中间 + 1 开始
            for (int i = mid + 1; i < high; i++) {
                sum2 = sum2 + coin[i];
            }

            //计算了左半部分的和右半部分的，还剩下中间的一个硬币
            sum3 = coin[mid];//剩下中间硬币的重量

            //比较两部分重量
            if (sum1 < sum2) {//假币在左边
                target = falseCoin(coin, low, mid);
                return target;
            } else if (sum1 > sum2) {//假币在右边
                target = falseCoin(coin, mid + 1, high);
                return target;
            }

            if (sum1 + sum3 == sum2 + sum3) {
                target = mid + 1;
                return target;
            }

        }

        return target;
    }

}
