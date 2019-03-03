package compare_utils;

import java.util.Date;
import java.util.Random;

public class CompareUtils {
    public static void main(String[] args) {
        abstractRightSort(generateArrayData());
    }
    /*
    使用随机数生成一个大小随机的数组
     */
    /**
     *
     * @return 随机生成一个int[]待比较数组
     */
    public static int[] generateArrayData(){
        Random random = new Random();
        long time = new Date().getTime();
        random.setSeed(time);
        int n = random.nextInt((20));
        int[] params = new int[n];
        for (int i = 0; i < n; i++) {
            params[i] = random.nextInt(10000);
        }
        return params;
    }
    /*
    绝对正确的排序算法
     */

    /**
     *
     * @param params 要排序的集合
     * @return 排好序的集合
     */
    public static int[] abstractRightSort(int[] params){
        int len = params.length;
        for (int i = 1; i < len; i++) {
            for (int j = len-1; j > i-1; j--) {
                if(params[j]<params[j-1]){
                    int temp = params[j];
                    params[j] = params[j-1];
                    params[j-1] = temp;
                }
            }
        }
        return params;
    }
    /*
    比较器，用来比较两个算法得出的结果集合是否相同，从而判断出算法对错
     */

    /**
     *
     * @param result1 绝对正确算法得出的结果集合
     * @param result2 自定义算法得出的结果集合
     * @return boolean 返回一个boolean值，用来判断算法正确与否
     */
    public static boolean  compareAlgorithm(int[] result1,int[] result2){
        int len = result1.length;
        for(int i = 0;i<len;i++){
            if(result1[i]==result2[i]){
                continue;
            }else {
//                System.out.println("排序算法出现问题，请检查算法!!");
                return false;
            }
        }
        return true;
    }
}
