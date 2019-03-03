package bubble_sort;

import compare_utils.CompareUtils;

/**
 * 冒泡排序，按从小到大的顺序俩排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] testArray = CompareUtils.generateArrayData();
            int[] ints1 = CompareUtils.abstractRightSort(testArray);
            int[] ints2 = sortByBubble(testArray);
            boolean result = CompareUtils.compareAlgorithm(ints1, ints2);
            if(!result){
                System.out.println("警告！！！！ 算法出现问题,请检测.....");
                return;
            }
        }
        System.out.println("自定义算法通过......,你真棒！！！");

    }

    public static int[] sortByBubble(int[] params) {
        int len = params.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len - 1; j++) {
                if (params[j] > params[j + 1]) {
                    int temp = params[j];
                    params[j] = params[j + 1];
                    params[j + 1] = temp;
                }
            }
        }
        return params;
    }
}
