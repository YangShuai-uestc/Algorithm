/**
 * @author ys
 * @date 2021/3/25 16:55
 */
public class SelectionSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 0, 2, 1, 1, 0, 2, 3, 4, 5, 2, 4, 3, 6, 9, 2, 3, 5, 3, 2, 1, 4, 6, 4};
        selectionSort(arr);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 选择排序
     */
    static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i; j < len; j++) {
                //找最小的数的索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //把最小数放到开头
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
