

public class Code07_EvenTimesOddTimes {

    /**
     * 一个数组，只有一种数出现了奇数次，其他的所有数都是偶数次，如何找到这个奇数次的数
     * 时间 O(N)
     * 空间 O(1)
     * int eor = 0;
     * eor = eor ^... = 出现奇数次的数
     */
    public static void printOddTimeNum1(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }


    /**
     * 一个数组，有两种数出现了奇数次，其他的所有数都是偶数次，如何找到这两个奇数次的数
     * 时间 O(N)
     * 空间 O(1)
     * <p>
     * a,b,other
     * int eor ^..=a^b;  a不等于b  至少有一位数是不等于0
     * int eor* = 获取其中一位不是0的数  得出的值为a或者b
     */
    public static void printOddTimeNum2(int[] arr) {
        int eor = 0;
        for (int curNum : arr) {
            eor ^= curNum;
        }
        // eor = a^b
        //eor !=0
        //eor必有一个位置上是1
        /**
         * eor :    1010111100
         * ~eor:    0101000011
         * ~eor+1： 0101000100       补码：找出原码最右边的1  分两边 左边取反 右边不变
         * &：      0000000100
         */
        int rightOne = eor & (~eor + 1); //提取出最右边的1

        int onlyOne = 0;//eor*
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
