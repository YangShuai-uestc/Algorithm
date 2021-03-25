/**
 * @author ys
 * @date 2021/3/25 17:17
 */
public class HeapSort {

    public static void main(String[] args) throws Exception {
        int[] nums = {2, 0, 2, 1, 1, 0, 2, 3, 4, 5, 2, 4, 3, 6, 9, 2, 3, 5, 3, 2, 1, 4, 6, 4};
        heapSort(nums);
        System.out.println("排序后:");
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }


    /**
     * 大顶堆排序
     */
    static void heapSort(int[] arr) {
        //1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustMaxHeap(arr, i, arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
            adjustMaxHeap(arr, 0, j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param parent 当前父节点
     * @param length 大顶堆的最大范围
     */
    static void adjustMaxHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];//先取出当前元素i
        for (int child = parent * 2 + 1; child < length; child = child * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
            if (child + 1 < length && arr[child] < arr[child + 1]) {//如果左子结点小于右子结点，k指向右子结点
                child++;
            }
            if (arr[child] > temp) {//如果子节点大于父节点，将子节点值和父节点交换
                swap(arr, parent, child);
                parent = child;
            } else {
                break;
            }
        }
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
