/**
 * @author ys
 * @date 2021/3/25 16:44
 */
public class BubbleSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 0, 2, 1, 1, 0, 2, 3, 4, 5, 2, 4, 3, 6, 9, 2, 3, 5, 3, 2, 1, 4, 6, 4};
        bubbleSort(arr);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 冒泡排序
     */
    static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    //交换两元素位置
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    /**
     * 冒泡排序
     */
    static void bubbleSort2(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {

            //本次循环是否做了交换，没做交换就是有序的，可以退出循环
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    //交换两元素位置
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }
}
