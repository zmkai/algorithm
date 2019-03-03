# 冒泡排序思想（从小到大）

#### 思想

*从第一位开始，与第二位进行比较，如果第二位小于第一位，那么就进行两位的交换，然后第二位再与第三位比较,直到比较到最后一个，这时候最后一位就是最大的值，然后再从第一位开始比较，将第二大的值交换到倒数第二位*

#### 比较示例

![](.IMGS/冒泡排序思想图.jpeg)

#### 算法复杂度:O(n^2)

#### 实现代码

```java
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
```



