package 递归排序;

/**
 * 递归方式：多叉树--->后序遍历--->空间其实是看树的高度
 *      [3,2,5,6,7,4]
 *       0 1 2 3 4 5
 *                                      p(0,5)
 *                          p(0,2)                  p(3,5)
 *                  p(0,1)      p(2,2)          p(3,4)      p(5,5)
 *             p(0,0)   p(1,1)              p(3,3)  p(4,4)
 *             只有计算完子点后，才能向上汇总，
 *             递归过程其实就是用系统栈，把整个过程一条线给压栈了。
 * eg:
 *      arr[L..R]范围上求最大值    N
 *
 * 递归算法求时间复杂度：
 *      master公式：
 *          T(N) = a*T(N/b) +O(N^d)
 *          T(N): 母问题的规模是N  , N/b: 子问题的规模都是N/b(调用规模都是等量的) ，a：子问题被调用多少次，+O(N^d)：除去子问题调用之外，剩下的过程
 *      1）log(b,a)<d  O(N^d)
 *      2）log(b,a)>d  O(N^log(b,a))
 *      3）log(b,a)=d  O(N^d*logN)
 *
 */
public class Code08_GetMax {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    //arr[L..R]范围上求最大值  N
    public static int process(int[] arr, int L, int R) {
        if (L == R) {//arr[L..R]范围上只有一个数，直接返回，base，case
            return arr[L];
        }
        /**
         * L+R/2  可能会导致溢出，这样出来的值可能是负数
         * L+(L+R)/2 可以防止出现这个情况（右移一位比/2的运算速度要快）
         */
        int mid = L + ((R - L) >> 1);//中点

        int leftMax = process(arr, L, mid);//子问题 N/2

        int rightMax = process(arr, mid + 1, R);//子问题 N/2

        return Math.max(leftMax, rightMax);
        /**
         *  master公式
         *      T(N) = a*T(N/b) +O(N^d)
         *      T(N) = 2*T(N/2)+O(1)
         *      1）log(b,a)<d  O(N^d)
         *      2）log(b,a)>d  O(N^log(b,a))
         *      3）log(b,a)=d  O(N^d*logN)
         *      时间复杂度：O(N)
         */
    }
}
