/**
 * 选择排序
 * 从0到n-1
 * 依次找出最小数
 * <p>
 * 时间复杂度：
 * 第一次
 * 看n眼     比较n次    1次交换
 * 第二次
 * 看n-1眼     比较n-1次    1次交换
 * ....
 * 一共操作
 * 看：n+n-1+n-2+....
 * 比较：n+n-1+n-2+....
 * 交换：n
 * = an^2+bn+c
 * 所以：   O(n^2)
 */
public class Code01_SelectionSort {

    public static void selectionSort(int[] arr) {
        //过滤数据
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {//i~n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {//i~n-1上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
