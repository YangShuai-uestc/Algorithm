/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) throws Exception {
        int[] arr = {2, 0, 2, 1, 1, 0, 2, 3, 4, 5, 2, 4, 3, 6, 9, 2, 3, 5, 3, 2, 1, 4, 6, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 快排（填坑法）
     */
    private static void quickSort(int[] array, int left, int right) {
        //如果left==right表示只有一个数，则就是有序的
        if (left < right) {
            //最开始的左右边界，接下来的递归要用
            int l = left;
            int r = right;
            //数组最左边的值作为基准保存，此时数组此位置为坑
            int pivot = array[left];
            while (left < right) {
                //从右边开始找小于基准的数
                while (left < right && array[right] >= pivot) {
                    right--;
                }
                //找到了就填坑
                array[left] = array[right];
                //从左边开始找大于基准的值
                while (left < right && array[left] <= pivot) {
                    left++;
                }
                //找到了就填坑
                array[right] = array[left];
            }
            //此时left==right就是基准最终排序的位置
            array[left] = pivot;
            //递归排序基准左右两个数组
            quickSort(array, l, left - 1);
            quickSort(array, right + 1, r);
        }
    }
}
