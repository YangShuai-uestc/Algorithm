/**
 * @author ys
 * @date 2021/2/21 11:57
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0, 2, 3, 4, 5, 2, 4, 3, 6, 9, 2, 3, 5, 3, 2, 1, 4, 6, 4};
        heapSort(nums);
        System.out.println("排序后:");
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    static void heapSort(int[] arr) {
        int len = arr.length;
        //构建大根堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
        //从大顶堆中取出最大值并从剩下的数中继续调整
        for (int i = len - 1; i >= 0; i--) {
            //最大值放最后
            swap(arr, 0, i);
            //剩下的继续构建堆
            adjustHeap(arr, 0, i);
        }
    }

    static void adjustHeap(int[] arr, int parent, int length) {
        for (int child = parent * 2 + 1; child < length; child++) {
            //child指向更大的孩子
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                //找左右孩子更大的
                child++;
            }
            //如果孩子比父亲大
            if (arr[child] > arr[parent]) {
                swap(arr, parent, child);
                //当前孩子作为下一轮的父亲
                parent = child;
            }else {
                //父亲已经比孩子大，所以以父亲为节点的完全二叉树是大根堆
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
