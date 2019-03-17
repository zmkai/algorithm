package sort;
public class Sort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,2,5,2};
//        int[] nums = new int[]{2,3,5,5};
//        int[] result = maoPaoSort(nums);
//        quickSort(nums,0,nums.length-1);
//        insertSort(nums);
//        shellSort(nums);
//        chooseSort(nums);
//        heapSort(nums);
        mergeSort(nums,0,nums.length-1);
        printArray(nums);

    }

    /**
     * 打印数组
     * @param nums
     */
    public static void printArray(int[] nums){
        for(int i : nums){
            System.out.print(i+"\t");
        }
    }

    /**
     * 交换排序-----冒泡排序
     * 思想：前面的数和后面的数比较，如果前面的数大于后面的数，那么就进行交换，将最大的数放在数组最后面
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static int[] maoPaoSort(int[] nums){
        int len = nums.length;
        for(int i = len;i> 2 ;i--){
            for(int j = 0 ;j<i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 交换排序--------快速排序
     * 思想：选取数组最后一个元素当做基准元素，然后遍历数组与基准元素做比较，将比基准元素小的放在一边，比他大的就放在另一边，然后再将基准元素交换到自己正确的位置
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(nlogn)-O(n)
     * 稳定性：不稳定
     * @param nums 待比较数组
     * @param left 待比较数组的开始索引
     * @param right 待比较数组的尾索引
     *
     */

    public static void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return ;
        }
        int mid = splitArray(nums,left,right);
        quickSort(nums,left,mid-1);
        quickSort(nums,mid+1,right);
    }

    /**
     * 分治思想将数组分成两份
     * 思想：找到基准元素在数组中的位置
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int splitArray(int[] nums,int left,int right){
        int base = nums[right];
        for(int i = left;i< right;i++){
            if(nums[i]<base){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
                i++;
            }
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        return left;
    }

    /**
     * 插入排序
     */
    /**
     * 插入排序--------直接插入排序
     * 思想：将数组看成有序表和无序表两个部分，从无序表中将依次取出数据，插入到有序表，保证仍然有顺序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性；稳定
     * @param array
     */
    public static void insertSort(int[] array){
        int len = array.length;
        int tmp = 0;
        for(int i = 1;i<len;i++){
            tmp = array[i];
            int j = i - 1;
            while(j>= 0 && tmp < array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = tmp;
        }
    }

    /**
     * 插入排序-----希尔排序
     * 思想：将dk定义为增量，刚开始定义为n/2,然后再进行插入排序，然后再让dk=dk/2,直到dk为1时完成最后一次插入排序
     * 时间复杂度：O(nlogn)-O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     *
     * @param dk 增量
     *
     * @param n  数组长度
     *
     */
    public static void xiErSort(int[] array,int dk,int n){
        for(int i = dk;i<n;i++){
            if(array[i]<array[i-dk]){
                int tmp = array[i];
                int j = i - dk;
                array[i] = array[j];
                while(j-dk > 0 && tmp <array[j]){
                    array[j] = array[j-dk];
                    j=j-dk;
                }
                array[j] = tmp;
            }
        }
    }

    /**
     * 希尔排序完成
     *
     * @param array
     */
    public static void shellSort(int[] array){
        int len = array.length;
        int dk = len/2;
        while (dk>=1){
            xiErSort(array,dk,len);
            dk = dk/2;
        }
    }


    /**
     * 选择排序--------直接选择排序
     * 思想：遍历一边数组，将数组中最小的元素放在数组第一个位置，依次进行下去，直到数组完成排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arrray
     */
    public static void chooseSort(int[] arrray){
        int len = arrray.length;
        int index = -1;
        for(int i = 1; i< len;i++){
            index = i-1;
            for(int j = i;j<len;j++){
                if(arrray[index]>arrray[j]){
                    index = j;
                }
            }
            int temp = arrray[i-1];
            arrray[i-1] = arrray[index];
            arrray[index] = temp;
        }
    }

    /**
     * 选择排序-----堆排序
     * 思想：通过构建二叉树数据结构，再通过交换操作将最大值放在根节点上，即数组的第一个元素上，然后再将最大值与最后位进行交换，依次完成
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     */
    public static void createHeap(int[] array,int len){
        int i = len/2-1;
        for(;i>=0;i--){
            int left = i*2+1;
            int right = i*2 +2;
            int j = 0;
            if(right<len){
                if(array[right]>array[left]){
                    j = right;
                }else {
                    j = left;
                }
            }
            if(array[j]>array[i]){
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }
    }

    /**
     * 调用堆排序
     * @param array
     */
    public static void heapSort(int[] array){
        createHeap(array,array.length);
        for(int i = array.length-1;i>=0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            createHeap(array,i);
        }
    }


    /**
     * 合并排好序的数组
     * 归并排序
     * 思想：将大问题分解成子问题，采用分治策略，将子问题解决，再将子问题合成，对于排序中，先将数组分解成n个有序序列，然后再归并合成数组，即可完成排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     *
     */
    public static void mergeArray(int[] array,int left,int mid,int right){
        int len = right-left+1;
        int[] tmp = new int[len];
        int k = 0;
        int i = left;
        int j = mid+1;
        while(i<=mid&&j<=right){
            if(array[i]>array[j]){
                tmp[k++] = array[j++];
            }else {
                tmp[k++] = array[i++];
            }
        }
        while(i<=mid){
            tmp[k++] = array[i++];
        }
        while (j<=right){
            tmp[k++] = array[j++];
        }
        for(int n = 0;n<len;n++){
            array[left++] = tmp[n];
        }
    }

    /**
     * 递归归并排序
     * @param array 待排序数组
     * @param left 待排序的数组左边索引
     * @param right 待排序的数组右边索引
     */
    public static void mergeSort(int[] array,int left,int right){
        if(left == right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        mergeArray(array,left,mid,right);
    }
}

