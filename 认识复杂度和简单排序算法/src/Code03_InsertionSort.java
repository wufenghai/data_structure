import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * [2,3,5,4,2,3,3]
 * 0 1 2 3 4 5 6
 * 从后面往前看
 * 0~0
 * 0~1
 * 0~2
 * 0~3
 * 0~4
 * ...
 * 数据状况不同，流程不一样
 * 最坏：O(N^2)  按最差情况估计
 * 最好：O(N)
 * 空间：O(1)
 */
public class Code03_InsertionSort {

    public static void insertionSort(int[] arr) {
        //过滤数据
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~0有序的
        //0~i想有序
        for (int i = 1; i < arr.length; i++) {//0~i 做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    //i和j是一个位置的话，会出错
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //forTest
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }


    //对数器
    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);
    }


    private static int[] generateRandomArray(int maxSize, int maxValue) {
        //Math.random() -> [0,1) 所有的小数，等概率返回一个
        //Math.random() *N ->[0,N) 所有小数，等概率返回一个
        //(int) (Math.random() *N )->所有的整数，等概率返回一个
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];//长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

}
