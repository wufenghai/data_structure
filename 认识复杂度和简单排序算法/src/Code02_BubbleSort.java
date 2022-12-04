/**
 * 冒泡排序
 * <p>
 * 前后比大小，然后交换
 * <p>
 * O(n^2)
 */
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        //过滤数据
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length; e > 0; e--) {//0 ~ e
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    //交换arr的i和j位置上的值
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     *                      ^-->无进位相加
     *  a   ^   b   =
     *  0       1       1
     *  1       0       1
     *  0       0       0
     *  1       1       0
     *
     *  例子:
     *      a:10110
     *      ^
     *      b:00111
     *   =    10001
     *
     * 性质：
     *  1)0^N =N,N^N=0
     *  2)满足交换律和结合律
     *      a^b=b^a,a^b^c=a^(b^c)
     *  3)一堆数^  和谁先谁后^（异或）无关
     *
     *
     *  两个数的交换，不需要额外变量(a和b的在内存里是独立的区域)
     *  a=a^b;
     *  b=a^b;
     *  a=a^b;
     */

    /**
     * 一个数组，只有一种数出现了奇数次，其他的所有数都是偶数次，如何找到这个奇数次的数
     * 时间 O(N)
     * 空间 O(1)
     *  int eor = 0;
     *  eor = eor ^... = 出现奇数次的数
     */


    /**
     *  一个数组，有两种数出现了奇数次，其他的所有数都是偶数次，如何找到这两个奇数次的数
     * 时间 O(N)
     * 空间 O(1)
     *
     */
}
